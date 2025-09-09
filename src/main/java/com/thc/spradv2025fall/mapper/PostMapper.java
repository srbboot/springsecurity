package com.thc.spradv2025fall.mapper;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.PostDto;

import java.util.List;

public interface PostMapper {
    /**/
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
    List<PostDto.DetailResDto> pagedList(PostDto.PagedListReqDto param);
    int pagedListCount(PostDto.PagedListReqDto param);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param);
}
