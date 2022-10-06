package com.ccb.cv_reviewer.pdfcreator;

import com.ccb.domain.repository.ApplicantRepository;
import com.itextpdf.text.DocumentException;

import java.io.IOException;
import java.util.Arrays;

public class PdfCreationService implements Runnable {

    private PdfService pdfService;
    private long id;
    private ApplicantRepository applicantRepository;

    public PdfCreationService(PdfService pdfService, long id, ApplicantRepository applicantRepository) {
        this.pdfService = pdfService;
        this.id = id;
        this.applicantRepository = applicantRepository;
    }

    @Override
    public void run() {
        try {
            pdfService.createPdf(id, applicantRepository);
        } catch (DocumentException | IOException e) {
            System.out.println(e.getMessage() + " :: " + Arrays.toString(e.getStackTrace()));
        }
    }
}
