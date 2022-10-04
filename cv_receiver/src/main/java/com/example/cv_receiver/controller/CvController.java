package com.example.cv_receiver.controller;

import com.example.cv_receiver.dto.ApplicantInfo;
import com.example.cv_receiver.kafka.ApplicantCvProducer;
import com.example.cv_receiver.repository.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cv")
@AllArgsConstructor
public class CvController {
    private ApplicantCvProducer producer;
    private ApplicantRepository applicantRepository;

    @PostMapping
    public void postApplicantInfo(@RequestBody ApplicantInfo applicantInfo) {

        System.out.println("got info " + applicantInfo);

        applicantRepository.save(applicantInfo);

        producer.sendMessage(applicantInfo);

    }

}
