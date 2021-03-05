drop table if exists `test`;
create  table `test`(
    `id` bigint not null comment 'id',
    `name` varchar(50) comment 'name',
    `password` varchar(50),
    primary key (`id`)

)engine=innodb default  charset =utf8mb4;
SELECT * From `test`;

insert into `test` (id, name, password) VALUES (0,'test','pass');

#demo table for mybatis generator
create  table `demo`(
                        `id` bigint not null comment 'id',
                        `name` varchar(50) comment 'name',
                        primary key (`id`)

)engine=innodb default  charset =utf8mb4;

insert into `demo` (id, name) VALUES (0,'test');