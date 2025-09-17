package com.ftms.Service;

import com.ftms.DTO.FundRequestDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Entity.Fund;
import com.ftms.Entity.User;
import com.ftms.Mapper.FundMapper;
import com.ftms.Repo.FundRepo;
import com.ftms.Repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FundService {
    private final FundRepo fundRepo;
    private final UserRepo userRepo;
    private final FundMapper fundMapper;

    @Autowired
    public FundService(FundRepo fundRepo, UserRepo userRepo, FundMapper fundMapper) {
        this.fundRepo = fundRepo;
        this.userRepo = userRepo;
        this.fundMapper = fundMapper;
    }

    public void saveFund(FundRequestDTO requestDTO) {
        User user = userRepo.findByName(requestDTO.username()).orElseThrow();

        Fund fund = fundMapper.toEntity(requestDTO, user);

        fundRepo.save(fund);
    }

    public List<FundResponseDTO> getFundByName(String username) {
        List<FundResponseDTO> fundResponseList = new ArrayList<>();
        User user = userRepo.findByName(username).orElseThrow();

        Long id = user.getId();
        List<Fund> fundList = fundRepo.findByUser_Id(id);

        double monthlyPending = 500;
        int currentMonth = -1;

        for (Fund fund : fundList) {
            int fundMonth = fund.getCreatedAt().getMonthValue();
            // Refresh monthly pending amount when find dif currentMonth val of next entry
            if (currentMonth != fundMonth) {
                monthlyPending = 500;
                currentMonth = fundMonth;
            }

            monthlyPending -= fund.getPaidAmount();
            fundResponseList.add(fundMapper.toDTO(user.getId(), username, fund,monthlyPending));
        }

        return fundResponseList;
    }

    public Double getTotalFund() {
        return fundRepo.findAll().stream().mapToDouble(Fund::getPaidAmount).sum();
    }
}
