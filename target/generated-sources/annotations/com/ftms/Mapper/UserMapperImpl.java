package com.ftms.Mapper;

import com.ftms.DTO.UserRequestDTO;
import com.ftms.DTO.UserResponseDTO;
import com.ftms.Entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T19:11:55+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserRequestDTO userRequestDTO) {
        if ( userRequestDTO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.name( userRequestDTO.name() );

        return user.build();
    }

    @Override
    public UserResponseDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        String name = null;

        name = user.getName();

        UserResponseDTO userResponseDTO = new UserResponseDTO( name );

        return userResponseDTO;
    }
}
