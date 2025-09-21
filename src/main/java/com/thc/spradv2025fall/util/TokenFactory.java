package com.thc.spradv2025fall.util;

import com.thc.spradv2025fall.domain.RefreshToken;
import com.thc.spradv2025fall.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@RequiredArgsConstructor
@Component
public class TokenFactory {

    private final RefreshTokenRepository refreshTokenRepository;
    public int refreshTokenTerm = 60 * 6;
    public int accessTokenTerm = 30;

    public void revokeRefreshToken(Long userId) {
        List<RefreshToken> list = refreshTokenRepository.findByUserId(userId);
        if(list != null && !list.isEmpty()) {
            refreshTokenRepository.deleteAll(list);
        }
    }

    public String createRefreshToken(Long userId) {
        revokeRefreshToken(userId);
        return generateToken(userId, refreshTokenTerm);
    }

    public String createAccessToken(Long userId) {
        return generateToken(userId, accessTokenTerm);
    }

    public Long validateRefreshToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElse(null);
        if(refreshToken == null) {
            return null;
        }

        Long tempUserId = refreshToken.getUserId();
        Long tokenUserId = validateToken(token);

        if(!tempUserId.equals(tokenUserId)) {
            return null;
        }

        return tokenUserId;
    }

    public Long validateAccessToken(String token) {
        return validateToken(token);
    }

    public String generateToken(Long userId, int term) {
        //Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, term);
        String due = formatter.format(cal.getTime());

        String data = userId + "_" + due;
        String token = null;
        try{
            token = AES256Cipher.AES_Encode(null, data);
        }catch(Exception e) {
        }

        return token;
    }

    public Long validateToken(String token) {
        String data = null;
        try{
            data = AES256Cipher.AES_Decode(null, token);
        } catch (Exception e){}

        if(data == null) {
            return null;
        }

        String[] dataArr = data.split("_");
        if(dataArr.length != 2) {
            return null;
        }
        Long userId = Long.parseLong(dataArr[0]);
        String due = dataArr[1];

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String now = formatter.format(cal.getTime());

        String[] nowArr = {now, due};
        Arrays.sort(nowArr);

        if(!now.equals(nowArr[0])) {
            return null;
        }

        return userId;

    }

}
