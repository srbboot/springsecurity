package com.thc.spradv2025fall.repository;

import com.thc.spradv2025fall.domain.Postlike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostlikeRepository extends JpaRepository<Postlike, Long> {
    Postlike findByPostIdAndUserId(Long postId, Long userId);
}