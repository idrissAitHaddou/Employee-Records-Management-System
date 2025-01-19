package com.example.employeerecordsmanagementsystem.services;

import com.example.employeerecordsmanagementsystem.dto.RoleDTO;
import com.example.employeerecordsmanagementsystem.entities.Role;
import com.example.employeerecordsmanagementsystem.mapper.RoleMapper;
import com.example.employeerecordsmanagementsystem.repositories.RoleRepository;
import com.example.employeerecordsmanagementsystem.services.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public RoleDTO saveRole(RoleDTO roleDTO) {
        Role role = RoleMapper.INSTANCE.roleDTOToRole(roleDTO);
        Role savedRole = roleRepository.save(role);
        return RoleMapper.INSTANCE.roleToRoleDTO(savedRole);
    }

    @Override
    public Optional<RoleDTO> findRoleById(Long id) {
        Optional<Role> role = roleRepository.findById(id);
        return role.map(RoleMapper.INSTANCE::roleToRoleDTO);
    }

    @Override
    public Boolean deleteRole(Long id) {
        if (roleRepository.existsById(id)) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}