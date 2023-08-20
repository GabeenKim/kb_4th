-- 
CREATE TABLE employee
AS
(SELECT * FROM emp);

CREATE TABLE department
AS
(SELECT * FROM dept);

DESC employee;
DESC department;

--CTAS로는 제약조건이 적용이 안 되어 있기에 제약조건을 추가해야 기본키가 같이 복사됨.
--PK 제약조건을 테이블에 추가 
--employee 테이블과 department 테이블에 pk 제약 조건을 추가해준다. 
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);
desc employee;
ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);
desc department; 


DELETE employee WHERE empno = 7369;
SELECT * FROM employee;

DELETE department WHERE deptno = 20;
SELECT * FROM department;

--20번 부서를 삭제하더라도 20번 부서에서 근무하는 직원은 그대로이다. 
--이것은 employee 테이블과 department 테이블이 연관Reational되어져 있지 않기 때문이다.
--따라서 FK 제약조건을 추가해줘야 한다. 

--drop은 메모리에서 객체를 아예 없애줌. 
DROP TABLE employee;
DROP TABLE department;


CREATE TABLE employee
AS
(SELECT * FROM emp);

CREATE TABLE department
AS
(SELECT * FROM dept);

--PK 제약 조건
ALTER TABLE employee ADD CONSTRAINT employee_empno_pk PRIMARY KEY(empno);

ALTER TABLE department ADD CONSTRAINT department_deptno_pk PRIMARY KEY(deptno);

--FK 제약 조건
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno); 

--foreign  key가 있는 쪽이 자식 테이블이다. 
DELETE employee WHERE empno = 7369;
SELECT * FROM employee;

DELETE department WHERE deptno = 20;
SELECT * FROM department;


-- FK재약 조건을 추가하면 자식을 가지고 있는 부모 테이블 삭제가 안 된다. 
-- 해결방법은 자식 레코드를 먼저 삭제한 후 부모 레코드 삭제를 진행 
-- 이와 같은 작업을 그대로 해주는 옵션이 ON DELETE CASCADE 
-- FK 제약조건을 지정할 때 마지막에 ON DELETE CASCADE를 붙여서 지정하면 된다.
ALTER TABLE employee ADD CONSTRAINT employee_deptno_fk foreign key(deptno) 
REFERENCES department(deptno) ON DELETE CASCADE;





commit;

