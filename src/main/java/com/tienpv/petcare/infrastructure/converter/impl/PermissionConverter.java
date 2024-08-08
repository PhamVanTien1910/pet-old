package com.tienpv.petcare.infrastructure.converter.impl;

import com.tienpv.petcare.application.dto.request.PermissionRequest;
import com.tienpv.petcare.application.dto.response.PermissionResponse;
import com.tienpv.petcare.domain.entity.PermissionEntity;
import com.tienpv.petcare.infrastructure.converter.IPermissionConverter;
import org.springframework.stereotype.Component;

@Component
public class PermissionConverter implements IPermissionConverter {
    public PermissionEntity toEntity(PermissionRequest dto) {
        PermissionEntity entity = new PermissionEntity();
        entity.setName(dto.getName());
        entity.setDesciption(dto.getDescription());
        return entity;
    }

    public PermissionResponse toDTO(PermissionEntity entity) {
        PermissionResponse dto = new PermissionResponse();
        dto.setName(entity.getName());
        dto.setDescription(entity.getDesciption());
        return dto;
    }
}
