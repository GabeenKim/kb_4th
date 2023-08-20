--조인 함수
-- 여러 테이블로부터 데이터를 가져올때 사용되는 기법 

-- 직원에 대한 정보를 가져온다. 
SELECT * FROM emp;

-- 부서에 대한 정보를 가져온다. 
SELECT * FROM dept;

-- 직원, 부서에 대한 정보를 가져온다. 
SELECT * FROM emp,dept;  --> 연관관계가 없이 출력

/*
    위에 처럼 나온 결과를 Cartesian Product(곱집합)라고 한다.
    emp 테이블과 dept 테이블의 단순한 수평적인 결합 결과를 의미. 
    14행 * 4행 = 56행을 의미. 
    
    Cartesian Product 가 도출되는 경우 => 연결이 X RDBMS와는 맞지 않는 결과 도출
    1) join 조건이 없을 시
    2) join 조건을 잘못 줄 시
*/

--step1 
--조인 조건 : 양 쪽 테이블의 공통적인 컬림이 조인 조건이다. 
-- 조인 조건은 WHERE절에 지정하고 =를 사용해서 명시하면 된다. 

-- *은 자제하고 Projection을 제한해야함.  
SELECT * FROM emp, dept
WHERE emp.deptno = dept.deptno;

--step2
-- Oracle 서버가 두 테이블을 모두 찾는데, 두 테이블이 공통으로 갖고 있는 컬럼의 경우 모호함을 없애기 위해
-- 어느 테이블에서 가져온 컬럼인지를 명시해줘야 함. 
SELECT empno, ename,sal, deptno ,dname FROM emp , dept
WHERE emp.deptno = dept.deptno;

--step3
--어느 테이블의 컬럼을 가져와야 하는지
--모든 테이블을 다 뒤적기리기 떄문에 성능에 치명적인 영향을 준다. -> 따라서 어디서 온 것인지 ㅁㅕㅇ시
SELECT emp.empno,emp.ename,emp.sal, emp.deptno ,dept.dname FROM emp , dept
WHERE emp.deptno = dept.deptno;


--step4
SELECT e.empno,e.ename,e.sal, e.deptno ,d.dname FROM emp e , dept d
WHERE e.deptno = d.deptno;

--사원 이름, 급여, 부서 번호, 부서이름, 부서 위치를 검색 
--단 급여가 2000 이상이고 30번 부서에 한 해서만 검색
SELECT e.ename, e.sal, d.deptno, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno 
AND e.sal >=2000 
AND d.deptno =30;

--뉴욕에서 근무하는 사원의 이름과 급여를 검색 
SELECT e.ename, e.sal 
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND d.loc = 'NEW YORK';


--SELF JOIN : 하나의 테이블을 자체적으로 조인할 때 사용하는 유형.
-- 특정 사원의 상사의 이름을 검색해야 할 때 
SELECT empno, ename, mgr FROM emp;

--step1
/*
    1&2 = emp e / 3&4 = emp m
    1. 특정 사원의 ename을 조사해서 emp 테이블에서 찾는다. => smith 
    2. smith의 상사 번호 mgr을 조회 -> 관리자 번호를 찾는다. 7902
    ------------------------------------------------------------
    3. 다시 7902 번호의 empno를 찾고 
    4. empno가 7902번인 사원의 ename을 찾는다. => FORD
*/

SELECT empno, ename , mgr FROM emp; -- e : 사원의 상사 번호
SELECT empno, ename FROM emp; -- m : 사원의 이름

--조건을 안 준 경우 
SELECT * FROM 
(SELECT empno, ename , mgr FROM emp )e,
(SELECT empno, ename FROM emp)m ; 

--step2
SELECT * FROM 
(SELECT empno, ename , mgr FROM emp )e,
(SELECT empno, ename FROM emp)m 
WHERE e.mgr = m.empno;

--step3 : Alias를 지정. 사원 번호, 사원 이름, 상사 이름 
SELECT e.empno "사원 번호", e.ename "사원 이름", m.ename "상사 이름"
FROM  emp e, emp m
WHERE e.mgr = m.empno
ORDER BY 1;

--step4 : 특정 사원을 smith의 상사 검색
SELECT e.empno, e.ename, m.ename
FROM emp e, emp m
WHERE e.mgr = m.empno AND e.ename = 'SMITH';


-- OUTER JOIN 
SELECT DISTINCT(deptno) FROM emp;
SELECT deptno FROM dept;


SELECT e.empno, e.ename, e.job, e.deptno, d.deptno, d.dname 
FROM emp e, dept d
WHERE d.deptno = e.deptno(+);


SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND e.sal >2000;  --> 40은 안 나옴.


SELECT e.ename, e.sal, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno AND e.sal(+) >2000;  -- (+)를 붙여야 하는 테이블의 모든 조건에 다 붙여줘야 함. 



































