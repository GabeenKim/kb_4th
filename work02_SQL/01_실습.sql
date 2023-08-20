-- 1) emp 테이블 정보를 확인하세요.
desc emp;

-- 2) 부서번호가 20번인 부서의 사람 중 사원번호, 이름, 월급을 출력하라
SELECT empno, ename, sal 
FROM emp 
WHERE deptno = 20;


-- 3) 이름이 JONES인 사람의 모든 정보를 출력하라.
SELECT * FROM emp
WHERE ename = 'JONES';

-- 4)직업이 MANAGER가 아닌 사람의 모든 정보를 출력하라.
SELECT * FROM emp 
WHERE job != 'MANAGER';

-- 5) 급여가 $1,600보다 크고 $3,000보다 작은 사람의 이름, 직업, 급여를 출력하라.
SELECT ename, job, sal 
FROM emp 
--WHERE 1600<sal AND sal<3000;
WHERE sal between 1600 and 3000;

-- 6) 입사일이 80년도인 사람의 모든 정보를 출력하라
SELECT * 
FROM emp 
WHERE hiredate LIKE '80%';


-- 7) 입사일이 81/12/09 보다 먼저 입사한 사람들의 모든 정보를 출력하라.
SELECT * 
FROM emp 
WHERE hiredate < '81/12/09';


-- 8) 이름 중 S자가 들어가 있는 사람만 모든 정보를 출력하라.
SELECT * 
FROM emp 
WHERE ename LIKE '%S%';

-- 9) comm이 null이 아닌 사원들의 이름, 급여, comm, 부서번호를 조회
-- comm의 별칭을 보너스로 하고 보너스가 높은 사원순으로(desc) 정렬
SELECT ename, sal, comm 보너스, deptno
FROM emp
WHERE comm is not null
ORDER BY 보너스 DESC;


-- 10) 사원중에서 담당업무가 SALESMAN이거나 사장(PRESIDENT)이면서 동시에 급여가 1500 이상이 되는 사원을 검색
SELECT ename, job,sal 
FROM emp
WHERE (job ='SALESMAN' OR job ='PRESIDENT') AND sal>=1500;  

-->정렬은 순서대로 이루어짐. 앞에 있는 컬럼으로 정렬 진행된 후 같을 경우에 그 다음에 나오는 정렬을 진행함. 
-- 11) 부서번호로 기본 정렬한후, 부서번호가 같을경우 급여가 많은 순으로 정렬하여 사번, 이름, 업무, 부서번호,급여를 조회
SELECT empno, ename, job, deptno, sal
FROM emp
ORDER BY deptno, sal DESC;

--> 부서가 같아도 업무는 다를 수 있음! 따라서 부서는 중복 제거 한다해도 job개수대로 출력됨. 
-- 12) 부서별로 담당하는 업무를 한번씩 조회하시오
-- 단, 업무 기준으로 정렬합니다.
SELECT DISTINCT deptno, job
FROM emp
ORDER BY 2;

-- 13) 입사일이 가장 오래된 사원 5명만 조회하시오
SELECT ename, hiredate, rownum 랭킹 
FROM (SELECT * FROM emp ORDER BY hiredate)
WHERE rownum <=5;


-- 14) emp Table에서 이름, 급여, 커미션 금액, 총액(sal + comm)을  구하여 총액이 많은 순서로 출력하라. 
-- 단, 커미션이 NULL인 사람은 제외한다.(커미션금액: sal*comm/100)
SELECT ename , sal,  sal*comm/100 "커미션 금액" , sal+comm 총액 
FROM emp
WHERE comm is not null
ORDER BY 총액 DESC;

-- 15)  10번 부서의 모든 사람들에게 급여의 13%를 보너스로 지불하기로 하였다. 이름, 급여, 보너스 금액, 부서번호를 출력하라.
SELECT ename, sal, sal*1.3 "보너스 금액", deptno
FROM emp 
WHERE deptno = 10;


