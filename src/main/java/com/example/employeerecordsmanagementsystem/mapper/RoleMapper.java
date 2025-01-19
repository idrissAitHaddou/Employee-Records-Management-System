package com.example.employeerecordsmanagementsystem.mapper;

import com.example.employeerecordsmanagementsystem.dto.RoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.example.employeerecordsmanagementsystem.entities.Role;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

    RoleDTO roleToRoleDTO(Role role);
    Role roleDTOToRole(RoleDTO roleDTO);
}
