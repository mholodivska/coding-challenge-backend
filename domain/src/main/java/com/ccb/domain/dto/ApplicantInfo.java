package com.ccb.domain.dto;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;


@Data
@Entity
@Table(name = "applicant_info")
public class ApplicantInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String gitHubUserLink;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "applicant_info_id")
    private Set<ProjectInfo> projects;


}
