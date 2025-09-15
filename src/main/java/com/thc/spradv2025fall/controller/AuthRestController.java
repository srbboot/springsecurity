package com.thc.spradv2025fall.controller;

import com.thc.spradv2025fall.util.TokenFactory;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/auth") //전체 메서드에 해당하는 주소값 앞에 더하는 효과!!
@RestController
public class AuthRestController {

    String token_prefix = "Bearer ";

    final TokenFactory tokenFactory;

    @PostMapping("")
    public ResponseEntity<Void> access(HttpServletRequest request) {
        String refreshToken = request.getHeader("RefreshToken");

        if(refreshToken != null && !refreshToken.isEmpty() && refreshToken.startsWith(token_prefix)) {
            // 정상 토큰 입니다
            refreshToken = refreshToken.substring(token_prefix.length());

        } else {
            throw new RuntimeException("Invalid token");
        }

        System.out.println("@@@@@@@@2Refresh token: " + refreshToken);
        Long userId = tokenFactory.validateRefreshToken(refreshToken);

        if(userId == null){
            throw new RuntimeException("Invalid token");
        }

        String token = tokenFactory.createAccessToken(userId);
        return ResponseEntity.ok().header("Authorization", token_prefix + token).build();
    }
}