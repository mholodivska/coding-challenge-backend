package com.ccb.cv_reviewer.pdfcreator;

import com.ccb.domain.dto.ApplicantInfo;
import com.ccb.domain.dto.ProjectInfo;
import com.ccb.domain.repository.ApplicantRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.Arrays;


@Service
public class PdfService {

    public void createPdf(long id, ApplicantRepository applicantRepository) throws DocumentException, IOException {
        if (applicantRepository.findById(id).isPresent()) {
            ApplicantInfo applicantInfo = applicantRepository.findById(id).get();
            Document document = new Document(PageSize.A4, 25, 25, 25, 25);

            ByteArrayOutputStream os = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, os);
            document.open();

            Paragraph title = new Paragraph("Applicant " + applicantInfo.getName(),
                    FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD, new BaseColor(0, 255, 255)));

            document.add(title);

            PdfPTable table = new PdfPTable(2);
            table.setSpacingBefore(25);
            table.setSpacingAfter(25);

            PdfPCell c1 = new PdfPCell(new Phrase("Name"));
            table.addCell(c1);
            table.addCell(applicantInfo.getName());

            PdfPCell c2 = new PdfPCell(new Phrase("Email"));
            table.addCell(c2);
            table.addCell(applicantInfo.getEmail());

            PdfPCell c3 = new PdfPCell(new Phrase("Github"));
            table.addCell(c3);
            table.addCell(applicantInfo.getGitHubUserLink());

            PdfPCell c4 = new PdfPCell(new Phrase("Projects"));
            table.addCell(c4);

            for (ProjectInfo projectInfo : applicantInfo.getProjects()) {
                table.addCell(String.valueOf(projectInfo));
                table.addCell("");
            }

            document.add(table);
            document.close();

            FileOutputStream fos = new FileOutputStream(applicantInfo.getName().replaceAll(" ", "_") + ".pdf");
            fos.write(os.toByteArray());
        }
    }
}
