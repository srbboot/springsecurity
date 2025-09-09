package com.thc.spradv2025fall.service;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    /**/
    DefaultDto.CreateResDto create(PostDto.CreateReqDto param);
    void update(PostDto.UpdateReqDto param);
    void delete(PostDto.UpdateReqDto param);
    PostDto.DetailResDto detail(DefaultDto.DetailReqDto param);
    List<PostDto.DetailResDto> list(PostDto.ListReqDto param);
    DefaultDto.PagedListResDto pagedList(PostDto.PagedListReqDto param);
    List<PostDto.DetailResDto> scrollList(PostDto.ScrollListReqDto param);
}