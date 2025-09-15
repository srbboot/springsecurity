package com.thc.spradv2025fall.controller;

import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.dto.PostDto;
import com.thc.spradv2025fall.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/post")
@RestController
public class PostRestController {

    final PostService postService;

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody PostDto.CreateReqDto param, HttpServletRequest request){
        Object reqUserId = request.getAttribute("reqUserId");
        if (reqUserId != null) {
            param.setUserId(Long.parseLong(reqUserId.toString()));
        } else {
            throw new RuntimeException("no auth");
        }

        return ResponseEntity.ok(postService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody PostDto.UpdateReqDto param){
        postService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody PostDto.UpdateReqDto param){
        postService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<PostDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(postService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<PostDto.DetailResDto>> list(PostDto.ListReqDto param){
        return ResponseEntity.ok(postService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(PostDto.PagedListReqDto param){
        return ResponseEntity.ok(postService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<PostDto.DetailResDto>> scrollList(PostDto.ScrollListReqDto param, HttpServletRequest request){
        return ResponseEntity.ok(postService.scrollList(param));
    }

}
