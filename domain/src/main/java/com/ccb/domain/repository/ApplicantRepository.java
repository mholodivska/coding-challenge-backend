package com.ccb.domain.repository;

import com.ccb.domain.dto.ApplicantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//@EnableJpaRepositories
@Repository
public interface ApplicantRepository extends JpaRepository<ApplicantInfo, Long> {
    ApplicantInfo findByName(String name);
}
