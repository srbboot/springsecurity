package com.thc.spradv2025fall.repository;

import com.thc.spradv2025fall.domain.Postimg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostimgRepository extends JpaRepository<Postimg, Long> {
}