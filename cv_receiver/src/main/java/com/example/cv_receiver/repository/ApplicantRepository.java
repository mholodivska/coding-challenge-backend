package com.example.cv_receiver.repository;

import com.example.cv_receiver.dto.ApplicantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ApplicantRepository extends JpaRepository<ApplicantInfo, Long> {
    ApplicantInfo findByName(String name);
    void deleteByName(String name);
}
