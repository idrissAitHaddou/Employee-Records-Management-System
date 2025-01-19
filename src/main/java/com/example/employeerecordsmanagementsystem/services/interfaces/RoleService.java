package com.example.employeerecordsmanagementsystem.services.interfaces;

import com.example.employeerecordsmanagementsystem.dto.RoleDTO;
import java.util.Optional;

public interface RoleService {
    RoleDTO saveRole(RoleDTO role);
    Optional<RoleDTO> findRoleById(Long id);
    Boolean deleteRole(Long id);
}
