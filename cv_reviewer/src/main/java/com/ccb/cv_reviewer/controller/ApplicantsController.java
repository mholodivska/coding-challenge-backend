package com.ccb.cv_reviewer.controller;

import com.ccb.domain.dto.ApplicantInfo;
import com.ccb.domain.repository.ApplicantRepository;
import com.ccb.cv_reviewer.pdfcreator.PdfCreationService;
import com.ccb.cv_reviewer.pdfcreator.PdfService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/applicants")
@AllArgsConstructor
public class ApplicantsController {
    private final ApplicantRepository applicantRepository;
    private final PdfService pdfService;


    @GetMapping
    public List<ApplicantInfo> getAllApplicants() {
        return applicantRepository.findAll();
    }

    @GetMapping("{id}")
    public ApplicantInfo getApplicantById(@PathVariable long id) {
        ApplicantInfo one = null;
        if (applicantRepository.findById(id).isPresent()) {
            one = applicantRepository.findById(id).get();
        }
        return one;
    }

    @GetMapping("{id}/download")
    public void downloadPdfCv(@PathVariable long id) {
        Runnable process = new PdfCreationService(pdfService, id, applicantRepository);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(process);
    }
}
