package com.tienpv.petcare.infrastructure.controller;

import com.tienpv.petcare.application.dto.request.PermissionRequest;
import com.tienpv.petcare.application.dto.request.PetRequest;
import com.tienpv.petcare.application.dto.response.ApiResponse;
import com.tienpv.petcare.application.dto.response.PermissionResponse;
import com.tienpv.petcare.application.dto.response.PetResponse;
import com.tienpv.petcare.domain.service.IPermissionService;
import com.tienpv.petcare.domain.service.IPetSerivce;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pets")
@RequiredArgsConstructor
public class Pets {

    @Autowired
    private IPetSerivce petSerivce;

    @SecurityRequirement(name = "Bearer Authentication")
    @PostMapping
    ApiResponse<PetResponse> create(@RequestBody PetRequest request) {
        ApiResponse<PetResponse> apiResponse = new ApiResponse<>();
        PetResponse data = petSerivce.createPet(request);
        apiResponse.setResult(data);
        return apiResponse;
    }
}
