package com.example.cv_receiver.dto;

import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;

@Data
@Entity
@Table(name = "project_info")
public class ProjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ApplicantInfo applicantInfo;

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }


}
