--javalink/javalink

create table mms_member(
    id number constraint member_id_seq NOT NULL primary key,
    name varchar2(12) unique NOT NULL,
    addr varchar2(50) NOT NULL,
    nation varchar2(12) NOT NULL,
    email varchar2(30) NOT NULL,
    age number
);

create sequence id_seq
start with 1
increment by 1
;