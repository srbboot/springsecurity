package com.thc.spradv2025fall.dto;

import com.thc.spradv2025fall.domain.User;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class UserDto {


    @Setter @Getter @Builder
    public static class LoginReqDto {
        String username;
        String password;
    }
    @Setter @Getter @Builder
    public static class LoginResDto {
        Long id;
    }
    @Setter @Getter @Builder
    public static class TokenResDto {
        String token;
    }

    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        String username;
        String password;
        String name;
        String phone;

        public User toEntity(){
            return User.of(getUsername(), getPassword(), getName(), getPhone());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String password;
        String name;
        String phone;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        String username;
        String name;
        String phone;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        String username;
        String name;
        String phone;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        String username;
        String name;
        String phone;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        String username;
        String name;
        String phone;
    }
}
