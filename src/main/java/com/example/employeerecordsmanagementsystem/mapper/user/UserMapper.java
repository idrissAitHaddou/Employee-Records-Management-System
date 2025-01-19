package com.example.employeerecordsmanagementsystem.mapper.user;

import com.example.employeerecordsmanagementsystem.dto.user.UserDTO;
import com.example.employeerecordsmanagementsystem.entities.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
}
