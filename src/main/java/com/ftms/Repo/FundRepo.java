package com.ftms.Repo;

import com.ftms.Entity.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FundRepo extends JpaRepository<Fund,Long> {
    List<Fund> findByUser_Id(Long userId);

    @Query("SELECT f FROM Fund f " +
            "WHERE f.user.id = :userId " +
            "AND f.createdAt BETWEEN :start AND :end")
    List<Fund> findFundsByUserAndMonth(@Param("userId") Long userId,
                                       @Param("start") LocalDate start,
                                       @Param("end") LocalDate end);
}
