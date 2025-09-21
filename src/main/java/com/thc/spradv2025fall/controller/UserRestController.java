package com.thc.spradv2025fall.controller;

import com.thc.spradv2025fall.dto.UserDto;
import com.thc.spradv2025fall.dto.DefaultDto;
import com.thc.spradv2025fall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/user")
@RestController
public class UserRestController {

    final UserService userService;

    /*
    String token_prefix = "Bearer ";

    @PostMapping("/login")
    public ResponseEntity<UserDto.LoginResDto> login(@RequestBody UserDto.LoginReqDto param){
        return ResponseEntity.ok(userService.login(param));
    }*/
    /*
    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody UserDto.LoginReqDto param){
        String data = userService.login(param).getToken();
        return ResponseEntity.ok().header("RefreshToken", token_prefix + data).build();
    }
     */

    /**/

    @PostMapping("")
    public ResponseEntity<DefaultDto.CreateResDto> create(@RequestBody UserDto.CreateReqDto param){
        return ResponseEntity.ok(userService.create(param));
    }
    @PutMapping("")
    public ResponseEntity<Void> update(@RequestBody UserDto.UpdateReqDto param){
        userService.update(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @DeleteMapping("")
    public ResponseEntity<Void> delete(@RequestBody UserDto.UpdateReqDto param){
        userService.delete(param);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("")
    public ResponseEntity<UserDto.DetailResDto> detail(DefaultDto.DetailReqDto param){
        return ResponseEntity.ok(userService.detail(param));
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserDto.DetailResDto>> list(UserDto.ListReqDto param){
        return ResponseEntity.ok(userService.list(param));
    }
    @GetMapping("/pagedList")
    public ResponseEntity<DefaultDto.PagedListResDto> pagedList(UserDto.PagedListReqDto param){
        return ResponseEntity.ok(userService.pagedList(param));
    }
    @GetMapping("/scrollList")
    public ResponseEntity<List<UserDto.DetailResDto>> scrollList(UserDto.ScrollListReqDto param){
        return ResponseEntity.ok(userService.scrollList(param));
    }

}
