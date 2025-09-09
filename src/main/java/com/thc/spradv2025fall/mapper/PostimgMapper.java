package com.thc.spradv2025fall.mapper;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.PostimgDto;

import java.util.List;

public interface PostimgMapper {
    /**/
    PostimgDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostimgDto.DetailResDto> list(PostimgDto.ListReqDto param);
    List<PostimgDto.DetailResDto> pagedList(PostimgDto.PagedListReqDto param);
    int pagedListCount(PostimgDto.PagedListReqDto param);
    List<PostimgDto.DetailResDto> scrollList(PostimgDto.ScrollListReqDto param);
}
