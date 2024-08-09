package com.tienpv.petcare.application.service.impl;

import com.tienpv.petcare.application.dto.request.PetRequest;
import com.tienpv.petcare.application.dto.response.PetResponse;
import com.tienpv.petcare.application.exception.AppException;
import com.tienpv.petcare.application.exception.ErrorCode;
import com.tienpv.petcare.application.service.validation.PetValidationService;
import com.tienpv.petcare.domain.entity.PetEntity;
import com.tienpv.petcare.domain.repository.IPetRepository;
import com.tienpv.petcare.domain.service.IPetSerivce;
import com.tienpv.petcare.infrastructure.converter.IPetConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService implements IPetSerivce {

    @Autowired
    private IPetConverter petConverter;

    @Autowired
    private IPetRepository petRepository;

    @Autowired
    private PetValidationService validationService;

    @Override
    public PetResponse createPet(PetRequest request) {
        validationService.validatePetRequest(request);
        PetEntity entity = petConverter.toEntity(request);
        try {
            entity = petRepository.save(entity);
            return petConverter.toDTO(entity);
        } catch (Exception e) {
            throw new AppException(ErrorCode.SERVER_ERROR);
        }
    }

}
