package com.thc.spradv2025fall.domain;

import com.thc.spradv2025fall.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Chat extends AuditingField{
    @Column(nullable = false, unique = true) String title;
    Integer countuser;

    protected Chat() {}
    private Chat(String title) {
        this.title = title;
        this.countuser = 0;
    }

    public static Chat of(String title) {
        return new Chat(title);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
