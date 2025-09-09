package com.thc.spradv2025fall.mapper;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.ChatDto;

import java.util.List;

public interface ChatMapper {
    /**/
    ChatDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatDto.DetailResDto> list(ChatDto.ListReqDto param);
    List<ChatDto.DetailResDto> pagedList(ChatDto.PagedListReqDto param);
    int pagedListCount(ChatDto.PagedListReqDto param);
    List<ChatDto.DetailResDto> scrollList(ChatDto.ScrollListReqDto param);
}
