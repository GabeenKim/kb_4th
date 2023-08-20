```-- 삭제
DROP TABLE student;
DROP TABLE lecture;
DROP TABLE learning;

-- 생성
CREATE TABLE student (
student_id number(5),
name VARCHAR2(20),
address VARCHAR2(255),
phone VARCHAR2(30),
email VARCHAR2(40)
);

CREATE TABLE lecture(
lecture_id number(5),
name VARCHAR2(20),
subject VARCHAR2(20),
likes number(5),
price number(9)
);

CREATE TABLE learning(
student_id number(5),
lecture_id number(5),
flag NUMBER(1)
);

CREATE TABLE teacher(
teacher_id number(5),
name varchar2(20),
email VARCHAR2(40),
subject varchar2(20)
);

CREATE TABLE education(
lecture_id number(5),
teacher_id number(5)
);

-- select
SELECT * from tab;

-- 기본키 제약조건
ALTER TABLE student ADD CONSTRAINT student_student_id_pk PRIMARY KEY(student_id);
DESC student;
ALTER TABLE lecture ADD CONSTRAINT lecture_lecture_id_pk PRIMARY KEY(lecture_id);
DESC lecture;
ALTER TABLE teacher ADD CONSTRAINT teacher_teacher_id_pk PRIMARY KEY(teacher_id);
DESC teacher;

-- 외래키 제약조건
ALTER TABLE learning ADD CONSTRAINT learning_student_id_fk foreign key(student_id)
REFERENCES student(student_id);
DESC learning;

ALTER TABLE learning ADD CONSTRAINT learning_lecture_id_fk foreign key(lecture_id)
REFERENCES lecture(lecture_id);
DESC learning;

ALTER TABLE education ADD CONSTRAINT education_lecture_id_fk foreign key(lecture_id)
REFERENCES lecture(lecture_id);
DESC education;

ALTER TABLE education ADD CONSTRAINT education_teacher_id_fk foreign key(teacher_id)
REFERENCES teacher(teacher_id);

-- 값 
CREATE SEQUENCE seq_student
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE seq_lecture
START WITH 1
INCREMENT BY 1;

CREATE SEQUENCE seq_teacher
START WITH 1
INCREMENT BY 1;

INSERT INTO student(student_id,name,address,phone,email)
VALUES(seq_student.nextVal,'최송희','수원','010-1111-1111','111@naver.com');

INSERT INTO student(student_id,name,address,phone,email)
VALUES(seq_student.nextVal,'김가빈','인천','010-2222-2222','222@naver.com');

INSERT INTO student(student_id,name,address,phone,email)
VALUES(seq_student.nextVal,'맹영욱','서울','010-3333-3333','333@naver.com');

select * from student;

INSERT INTO lecture(lecture_id,name,subject,likes,price)
VALUES(seq_lecture.nextVal,'미분','수학',0,1000000);

INSERT INTO lecture(lecture_id,name,subject,likes,price)
VALUES(seq_lecture.nextVal,'확통','수학',0,50000);

INSERT INTO lecture(lecture_id,name,subject,likes,price)
VALUES(seq_lecture.nextVal,'말하기','국어',0,10000);
select * from lecture;

insert into teacher(teacher_id,name,email,subject)
values(seq_teacher.nextVal,'하승현','ha@naver.com','수학');

insert into teacher(teacher_id,name,email,subject)
values(seq_teacher.nextVal,'최승현','choi@naver.com','국어');

insert into teacher(teacher_id,name,email,subject)
values(seq_teacher.nextVal,'김승현','kim@naver.com','수학');

select * from teacher;

insert into learning(student_id, lecture_id, flag)
values(1,2,0);

insert into learning(student_id, lecture_id, flag)
values(2,1,0);

insert into learning(student_id, lecture_id, flag)
values(3,3,0);

-- insert into learning(student_id, lecture_id, flag) values(5,5,0);

insert into education(teacher_id, lecture_id)
values(1,1);

insert into education(teacher_id, lecture_id)
values(3,2);

insert into education(teacher_id, lecture_id)
values(2,3);

/*
INSERT INTO student(student_id,name,address,phone,email)
VALUES( ,'','','','');

INSERT INTO lecture(lecture_id,lecture_name,subject,likes,price)
VALUES(,'','',,);

insert into teacher(teacher_id,teacher_name,teacher_email,subject)
values(,'','','');

insert into learning(student_id, lecture_id,check_flag)
values(1,1,0);

insert into education(teacher_id, lecture_id)
values(7,1);
*/```

--////////////////////////////////////////////////////////
select * from lecture ORDER By 1;
select * from student ORDER By 1;
select * from teacher ORDER By 1;

select * from learning ORDER BY 1;
select teacher_id, lecture_id from education ORDER By 1;


insert into education(teacher_id, lecture_id)
values(1,1);
insert into education(teacher_id, lecture_id)
values(1,2);
insert into education(teacher_id, lecture_id)
values(3,3);
insert into education(teacher_id, lecture_id)
values(2,4);
insert into education(teacher_id, lecture_id)
values(2,5);

commit;

