package com.tienpv.petcare.domain.repository;

import com.tienpv.petcare.domain.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvalidatedTokenRepository extends JpaRepository<TokenEntity, String> {
}
