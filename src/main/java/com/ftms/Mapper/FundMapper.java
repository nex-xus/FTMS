package com.ftms.Mapper;

import com.ftms.DTO.FundReportResponseDTO;
import com.ftms.DTO.FundRequestDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Entity.Fund;
import com.ftms.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FundMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "user")
    @Mapping(target = "createdAt", source = "requestDTO.createdAt")
    @Mapping(target = "paidAmount", source = "requestDTO.paidAmount")
    Fund toEntity(FundRequestDTO requestDTO, User user);

    FundResponseDTO toDTO(Long userId, String username, Fund fund, double due);
}
