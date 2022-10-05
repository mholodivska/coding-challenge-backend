package com.example.cv_receiver.dto;

import lombok.*;
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

    public ProjectInfo(Long id, String title, String employmentMode, String capacity, int durationMonths,
                       int year, String role, int teamSize, String linkToRepo, String linkToLive) {
        this.id = id;
        this.title = title;
        this.employmentMode = Arrays.stream(EmploymentMode.values()).filter(a -> a.getName().equals(employmentMode)).findFirst().orElse(EmploymentMode.DEFAULT);
        this.capacity = Arrays.stream(Capacity.values()).filter(a -> a.getName().equals(capacity)).findFirst().orElse(Capacity.DEFAULT);
        this.durationMonths = durationMonths;
        this.year = Year.of(year);
        this.role = role;
        this.teamSize = teamSize;
        this.linkToRepo = linkToRepo;
        this.linkToLive = linkToLive;
    }

    public ProjectInfo(Long id, String title, String employmentMode, String capacity, int durationMonths,
                       int year, String role, int teamSize) {
        this.id = id;
        this.title = title;
        this.employmentMode = Arrays.stream(EmploymentMode.values()).filter(a -> a.getName().equals(employmentMode)).findFirst().orElse(EmploymentMode.DEFAULT);
        this.capacity = Arrays.stream(Capacity.values()).filter(a -> a.getName().equals(capacity)).findFirst().orElse(Capacity.DEFAULT);
        this.durationMonths = durationMonths;
        this.year = Year.of(year);
        this.role = role;
        this.teamSize = teamSize;
    }

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
