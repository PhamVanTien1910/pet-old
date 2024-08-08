package com.tienpv.petcare.application.service.impl;

import com.tienpv.petcare.application.dto.request.RoleRequest;
import com.tienpv.petcare.application.dto.response.RoleResponse;
import com.tienpv.petcare.domain.entity.PermissionEntity;
import com.tienpv.petcare.domain.entity.RoleEntity;
import com.tienpv.petcare.domain.repository.IPermissionRepository;
import com.tienpv.petcare.domain.repository.RoleRepository;
import com.tienpv.petcare.domain.service.IRoleService;
import com.tienpv.petcare.infrastructure.converter.IRoleConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private IPermissionRepository permissionRepository;

    @Autowired
    private IRoleConverter converter;

    @Override
    public RoleResponse create(RoleRequest request) {
        RoleEntity entity = converter.toEntity(request);
        List<PermissionEntity> permissions = permissionRepository.findAllById(request.getPermissions());
        entity.setPermissions(new HashSet<>(permissions));
        entity = roleRepository.save(entity);
        return converter.toDTO(entity);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public List<RoleResponse> getAll() {
        List<RoleEntity> roles = roleRepository.findAll();
        return roles.stream().map(converter::toDTO).toList();
    }

    @Override
    public void delete(String role) {
        roleRepository.deleteById(role);
    }
}
