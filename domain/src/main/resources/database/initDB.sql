create table if not exists applicant_info
(
    id                bigserial
    constraint applicant_info_pk
    primary key,
    name              varchar(200) not null,
    email             varchar(200),
    git_hub_user_link varchar(200)
    );

alter table applicant_info
    owner to root;

create unique index if not exists applicant_info_id_uindex
    on applicant_info (id);

create table if not exists project_info
(
    id                bigserial
    constraint project_info_pk
    primary key,
    title             varchar(200),
    applicant_info_id integer
    constraint project_info_applicant_info_id_fk
    references applicant_info
    on update cascade on delete cascade,
    employment_mode   varchar(50),
    capacity          varchar(50),
    duration_months   integer,
    role              varchar(200),
    team_size         integer,
    link_to_repo      varchar(200),
    link_to_live      varchar(200),
    year              bytea
    );

alter table project_info
    owner to root;

create unique index if not exists project_info_id_uindex
    on project_info (id);

