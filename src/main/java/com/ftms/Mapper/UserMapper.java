package com.ftms.Mapper;

import com.ftms.DTO.UserRequestDTO;
import com.ftms.DTO.UserResponseDTO;
import com.ftms.Entity.User;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "id", ignore = true)
    User toEntity(@Valid UserRequestDTO userRequestDTO);

    UserResponseDTO toDTO(User user);
}
