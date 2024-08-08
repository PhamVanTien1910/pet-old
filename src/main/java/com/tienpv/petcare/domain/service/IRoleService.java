package com.tienpv.petcare.domain.service;


import com.tienpv.petcare.application.dto.request.RoleRequest;
import com.tienpv.petcare.application.dto.response.RoleResponse;

import java.util.List;


public interface IRoleService {
    RoleResponse create(RoleRequest request);

    List<RoleResponse> getAll();

    void delete(String role);
}
