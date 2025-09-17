package com.ftms.Service;

import com.ftms.DTO.FundReportResponseDTO;
import com.ftms.DTO.FundResponseDTO;
import com.ftms.Entity.Fund;
import com.ftms.Entity.FundReport;
import com.ftms.Entity.User;
import com.ftms.Mapper.FundMapper;
import com.ftms.Repo.FundRepo;
import com.ftms.Repo.FundReportRepo;
import com.ftms.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FundReportService {
    private final FundRepo fundRepo;
    private final FundReportRepo fundReportRepo;
    private final FundMapper fundMapper;
    private final UserRepo userRepo;

    @Autowired
    public FundReportService(FundRepo fundRepo, FundReportRepo fundReportRepo, FundMapper fundMapper, UserRepo userRepo) {
        this.fundRepo = fundRepo;
        this.fundReportRepo = fundReportRepo;
        this.fundMapper = fundMapper;
        this.userRepo = userRepo;
    }

    public List<FundResponseDTO> generateAndGetReport(Long userId, int month, int year) {
        User user = userRepo.findById(userId).orElseThrow();

        // start from 01/mm/yyyy
        LocalDate start = LocalDate.of(year, month, 1);
        // to end of month dd/mm/yyyy, where 'dd' decide by 'lengthOfMonth()'
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());

        List<Fund> fundList = fundRepo.findFundsByUserAndMonth(userId, start, end);
        List<Double> monthlyPaidList = fundList
                .stream()
                .map(Fund::getPaidAmount)
                .toList();

        List<FundResponseDTO> fundResponseList = new ArrayList<>();
        double monthlyPending = 500;

        for (Fund fund : fundList) {
            double paid = fund.getPaidAmount();
            monthlyPending = monthlyPending - paid;

            FundReport report = FundReport.builder()
                    .userId(userId)
                    .targetAmount(500)
                    .paidAmount(paid)
                    .dueAmount(monthlyPending)
                    .month(month)
                    .year(year)
                    .build();

            fundReportRepo.save(report);
            fundResponseList.add(fundMapper.toDTO(userId, user.getName(), fund, monthlyPending));
        }

        return fundResponseList;
    }
}
