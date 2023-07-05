create table user
(
    user_id       int                                not null
        primary key,
    user_name     varchar(100)                       not null,
    user_password varchar(20)                        not null,
    deleted       int                                not null,
    logtime       datetime default CURRENT_TIMESTAMP not null,
    constraint user_pk
        unique (user_name)
)
    comment '用户表';

create table family
(
    family_id          int                                not null comment '家族ID'
        primary key,
    user_id            int                                not null comment '用户ID',
    family_name        varchar(233)                       not null comment '家族名字',
    family_date        varchar(50)                        null comment '创建时间',
    family_description varchar(666)                       null comment '家族宣言',
    logtime            datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted            int                                not null comment '逻辑删除字段',
    constraint family_pk2
        unique (family_name),
    constraint family_user_user_id_fk
        foreign key (user_id) references user (user_id)
)
    comment '家族表';

create definer = root@`%` trigger deletedP
    after update
    on family
    for each row
BEGIN
IF new.deleted=1 THEN
UPDATE personnel SET deleted=1
WHERE family_id=old.family_id;
END IF;
END;

create table personnel
(
    personnel_id        int                                not null comment '人员ID'
        primary key,
    family_id           int                                not null comment '家族ID',
    personnel_name      varchar(100)                       not null comment '姓名',
    personnel_sex       varchar(20)                        not null comment '性别',
    personnel_brithdate varchar(50)                        null comment '出生日期',
    personnel_deathdate varchar(50)                        null comment '死亡日期',
    logtime             datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted             int                                not null comment '逻辑删除字段',
    constraint personnel_pk
        unique (personnel_name),
    constraint personnel_family_family_id_fk
        foreign key (family_id) references family (family_id)
)
    comment '人员表';

create table inccident
(
    personnel_id          int                                not null comment '人员ID',
    inccident_date        varchar(50)                        not null comment '事件时间',
    inccident_description varchar(100)                       null comment '事件描述',
    inccident_type        varchar(50)                        not null comment '事件类型',
    inccident_attachments varchar(200)                       null comment '事件附件',
    logtime               datetime default CURRENT_TIMESTAMP not null comment '更新时间',
    deleted               int                                not null comment '逻辑删除字段',
    constraint inccident_personnel_personnel_id_fk
        foreign key (personnel_id) references personnel (personnel_id)
)
    comment '人员事件表';

create definer = root@`%` trigger deletedI
    after update
    on personnel
    for each row
BEGIN
IF new.deleted=1 THEN
UPDATE inccident SET deleted=1
WHERE personnel_id=old.personnel_id;
END IF;
END;

create definer = root@`%` trigger deletedR
    after update
    on personnel
    for each row
BEGIN
IF new.deleted=1 THEN
UPDATE relation SET deleted=1
WHERE personnel_id1=old.personnel_id 
OR personnel_id2=old.personnel_id;
END IF;
END;

create table relation
(
    personnel_id1 int                                not null,
    personnel_id2 int                                not null,
    relation_type varchar(50)                        null,
    logtime       datetime default CURRENT_TIMESTAMP not null,
    deleted       int                                not null,
    constraint relation_personnel_personnel_id_fk
        foreign key (personnel_id1) references personnel (personnel_id),
    constraint relation_personnel_personnel_id_fk2
        foreign key (personnel_id2) references personnel (personnel_id)
)
    comment '关系表';

create definer = root@`%` trigger deletedF
    after update
    on user
    for each row
BEGIN
IF new.deleted=1 THEN
UPDATE family set deleted=1
WHERE user_id=old.user_id;
END IF;
END;


