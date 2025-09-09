package com.thc.spradv2025fall.service;

import com.thc.spradv2025fall.dto.UserDto;
import com.thc.spradv2025fall.dto.DefaultDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    UserDto.LoginResDto login(UserDto.LoginReqDto param);
    /**/
    DefaultDto.CreateResDto create(UserDto.CreateReqDto param);
    void update(UserDto.UpdateReqDto param);
    void delete(UserDto.UpdateReqDto param);
    UserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<UserDto.DetailResDto> list(UserDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(UserDto.PagedListReqDto param);
    List<UserDto.DetailResDto> scrollList(UserDto.ScrollListReqDto param);
}