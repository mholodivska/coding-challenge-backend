package com.ccb.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.time.Year;
import java.util.Arrays;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "project_info")
public class ProjectInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Enumerated(EnumType.STRING)
    private EmploymentMode employmentMode;

    @Enumerated(EnumType.STRING)
    private Capacity capacity;

    @Column
    private int durationMonths;

    @Column
    private Year year;

    @Column
    private String role;

    @Column
    private int teamSize;

    @Column
    private String linkToRepo; //optional

    @Column
    private String linkToLive; //optional

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ApplicantInfo applicantInfo;

    @Override
    public String toString() {
        return "ProjectInfo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", employmentMode=" + employmentMode +
                ", capacity=" + capacity +
                ", durationMonths=" + durationMonths +
                ", year=" + year +
                ", role='" + role + '\'' +
                ", teamSize=" + teamSize +
                ", linkToRepo='" + linkToRepo + '\'' +
                ", linkToLive='" + linkToLive + '\'' +
                '}';
    }

    @AllArgsConstructor
    @Getter
    public enum EmploymentMode {
        FREELANCE("freelance"),
        EMPLOYED("employed"),
        DEFAULT("default");

        private final String name;
    }

    @AllArgsConstructor
    @Getter
    public enum Capacity {
        PART_TIME("part-time"),
        FULL_TIME("full-time"),
        DEFAULT("default");

        private final String name;
    }
}
