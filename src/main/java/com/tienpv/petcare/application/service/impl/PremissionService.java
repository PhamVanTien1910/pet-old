package com.tienpv.petcare.application.service.impl;

import com.tienpv.petcare.application.dto.request.PermissionRequest;
import com.tienpv.petcare.application.dto.response.PermissionResponse;
import com.tienpv.petcare.domain.entity.auth.PermissionEntity;
import com.tienpv.petcare.domain.repository.IPermissionRepository;
import com.tienpv.petcare.domain.service.IPermissionService;
import com.tienpv.petcare.infrastructure.converter.IPermissionConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PremissionService implements IPermissionService {

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IPermissionConverter converter;

    @Override
    public PermissionResponse create(PermissionRequest request) {
        PermissionEntity permissionEntity = converter.toEntity(request);
        permissionEntity = permissionRepository.save(permissionEntity);
        return converter.toDTO(permissionEntity);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<PermissionResponse> getAll() {
        List<PermissionEntity> permissions = permissionRepository.findAll();
        return permissions.stream().map(converter::toDTO).toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
