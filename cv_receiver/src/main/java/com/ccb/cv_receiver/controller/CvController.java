package com.ccb.cv_receiver.controller;

import com.ccb.cv_receiver.kafka.ApplicantCvProducer;

import com.ccb.domain.dto.ApplicantInfo;
import com.ccb.domain.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv")
@AllArgsConstructor
public class CvController {
    private final ApplicantCvProducer producer;
    private final ApplicantRepository applicantRepository;

    @PostMapping
    public void postApplicantInfo(@RequestBody ApplicantInfo applicantInfo) {
        ApplicantInfo existedApplicant = applicantRepository.findByName(applicantInfo.getName());
        if (existedApplicant != null) {
            applicantRepository.deleteById(existedApplicant.getId());
        }
        applicantRepository.save(applicantInfo);

        producer.sendMessage(applicantInfo);

    }

}
