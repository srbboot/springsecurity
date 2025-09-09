package com.thc.spradv2025fall.repository;

import com.thc.spradv2025fall.domain.Chatuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatuserRepository extends JpaRepository<Chatuser, Long> {
    Chatuser findByChatIdAndUserId(Long chatId, Long userId);
}