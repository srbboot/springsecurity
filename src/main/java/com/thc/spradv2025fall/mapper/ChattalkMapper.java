package com.thc.spradv2025fall.mapper;

import com.thc.spradv2025fall.dto.ChattalkDto;
import com.thc.spradv2025fall.dto.DefaultDto;

import java.util.List;

public interface ChattalkMapper {
    /**/
    ChattalkDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<ChattalkDto.DetailResDto> list(ChattalkDto.ListReqDto param);
    List<ChattalkDto.DetailResDto> pagedList(ChattalkDto.PagedListReqDto param);
    int pagedListCount(ChattalkDto.PagedListReqDto param);
    List<ChattalkDto.DetailResDto> scrollList(ChattalkDto.ScrollListReqDto param);
}
