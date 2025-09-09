package com.thc.spradv2025fall.service;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.ChatDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChatService {
    /**/
    DefaultDto.CreateResDto create(ChatDto.CreateReqDto param);
    void update(ChatDto.UpdateReqDto param);
    void delete(ChatDto.UpdateReqDto param);
    ChatDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChatDto.DetailResDto> list(ChatDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(ChatDto.PagedListReqDto param);
    List<ChatDto.DetailResDto> scrollList(ChatDto.ScrollListReqDto param);
}