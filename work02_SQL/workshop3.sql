--테이블 생성하기 
CREATE TABLE member(
id number primary key,
name varchar2(20),
email varchar2(50),
phone varchar2(50));

CREATE SEQUENCE seq_member
START WITH 1
INCREMENT BY 1;

