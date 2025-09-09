package com.thc.spradv2025fall.repository;

import com.thc.spradv2025fall.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findByTitle(String title);
}