package com.ftms.Mapper;

import com.ftms.DTO.FundRequestDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Entity.Fund;
import com.ftms.Entity.User;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-15T20:00:14+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.8 (Ubuntu)"
)
@Component
public class FundMapperImpl implements FundMapper {

    @Override
    public Fund toEntity(FundRequestDTO requestDTO, User user) {
        if ( requestDTO == null && user == null ) {
            return null;
        }

        Fund.FundBuilder fund = Fund.builder();

        if ( requestDTO != null ) {
            fund.createdAt( requestDTO.createdAt() );
            fund.paidAmount( requestDTO.paidAmount() );
        }
        fund.user( user );

        return fund.build();
    }

    @Override
    public FundResponseDTO toDTO(Long userId, String username, Fund fund, double due) {
        if ( userId == null && username == null && fund == null ) {
            return null;
        }

        LocalDate createdAt = null;
        double paidAmount = 0.0d;
        if ( fund != null ) {
            createdAt = fund.getCreatedAt();
            paidAmount = fund.getPaidAmount();
        }
        Long userId1 = null;
        userId1 = userId;
        String username1 = null;
        username1 = username;
        double due1 = 0.0d;
        due1 = due;

        FundResponseDTO fundResponseDTO = new FundResponseDTO( userId1, username1, createdAt, paidAmount, due1 );

        return fundResponseDTO;
    }
}
