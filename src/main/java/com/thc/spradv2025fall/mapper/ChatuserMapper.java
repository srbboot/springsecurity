package com.thc.spradv2025fall.mapper;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.ChatuserDto;

import java.util.List;

public interface ChatuserMapper {
    /**/
    ChatuserDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatuserDto.DetailResDto> list(ChatuserDto.ListReqDto param);
    List<ChatuserDto.DetailResDto> pagedList(ChatuserDto.PagedListReqDto param);
    int pagedListCount(ChatuserDto.PagedListReqDto param);
    List<ChatuserDto.DetailResDto> scrollList(ChatuserDto.ScrollListReqDto param);
}
