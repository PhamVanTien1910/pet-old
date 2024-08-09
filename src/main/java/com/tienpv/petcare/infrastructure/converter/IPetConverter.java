package com.tienpv.petcare.infrastructure.converter;

import com.tienpv.petcare.application.dto.request.PetRequest;
import com.tienpv.petcare.application.dto.response.PetResponse;
import com.tienpv.petcare.domain.entity.PetEntity;

public interface IPetConverter {
    PetResponse toDTO(PetEntity entity);
    PetEntity toEntity(PetRequest request);
}
