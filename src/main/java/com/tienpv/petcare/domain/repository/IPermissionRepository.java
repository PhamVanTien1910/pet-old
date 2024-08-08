package com.tienpv.petcare.domain.repository;

import com.tienpv.petcare.domain.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPermissionRepository extends JpaRepository<PermissionEntity, String> {
}
