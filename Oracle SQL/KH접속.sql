desc employee;
--describe: employee table에 대해 묘사하라.

-- << select query의 기초문법 연습 >>

select emp_name,phone,emp_no from employee; -- employee table에서 해당 column의 data 출력
select * from employee; --모든 colume data 출력
--select 컬럼명 from 테이블명 where 조건문;

select emp_id,emp_name from employee where emp_id = 207;
--where : for문 돌릴때 if문 끼워넣은 것과 동일

--quiz01. 
--1. Employee 테이블에 존재하는 모든 직원의 사번, 이름, 급여를 출력해보기
select emp_id,emp_name,salary from employee;
--2. 직원 중 D9 부서에 속해있는 직원들의 사번, 이름, 부서코드를 출력해보기
select emp_id,emp_name,dept_code from employee where dept_code='D9';

select * from employee where salary>5000000;
select * from job;
select * from department;

--quiz02.
--직원 중 급여를 200만원 이하로 받는 직원의 이름, 부서코드, 직급코드를 출력해보기
select emp_name,dept_code,job_code,salary from employee where salary<=2000000;

--and, or 사용
select * from location;
select * from employee where salary<=3000000 and dept_code='D6';

--quiz03.
--급여가 200~300만 사이인 직원의 사번, 이름, 급여, 직급코드를 출력해보기
select emp_id,emp_name,salary,job_code from employee where 2000000<=salary and salary<=3000000;
-- ** 위와 같은 범위 조건은 아래와 같이 표현할 수 있다. 
select emp_id,emp_name,salary,job_code from employee where salary between 2000000 and 3000000;

--quiz04.
--employee 테이블의 직원 중 직급코드가 J3이면서 급여가 350만원 이상인 직원의 이름과 전화번호를 출력해보기
select emp_name,phone from employee where job_code='J3' and salary>=3500000;

--quiz05.
--employee 테이블의 직원 중 부서코드가 D5이거나 D6이거나 D9인 직원의 이름과 부서코드를 출력해보기
select emp_name,dept_code from employee where dept_code='D5' or dept_code='D6' or dept_code='D9';
-- ** 위와 같은 or 반복 조건은 아래와 같이 표현할 수 있다. 
select emp_name,dept_code from employee where dept_code in ('D5','D6','D9');

--부서코드에 null값이 들어있는 직원 목록을 출력하고 싶다면 (null이 아닌사람을 출력하고싶으면 is not null)
select emp_id,emp_name from employee where dept_code is null;

-- ** alias (as) : 별칭 수여
select emp_name 사원명,salary*12 as "연봉",'원' as "단위" from employee;
--데이터영역 안에 들어가는 건 홑따옴표, 밖에 있는건 쌍따옴표

-- ** sysdate : 현재 날짜 및 시간을 반환(date형)
select sysdate from dual; 
-- 한번만 쓰고 싶을때 기본으로 내장되어있는 dual table 이용하기

select sysdate+50 from dual; --날짜타입은 +,-연산도 가능하다.
-- 날짜타입과 날짜타입을 연산하면 두 날짜 사이의 일차가 반환됨

select emp_name 사원명,hire_date 입사일,floor(sysdate-hire_date) || '일' 근무일수 from employee;
--floor()함수, || 이어붙이기

--quiz06.
--employee 테이블에서 근속년수가 20년 이상 된 직원의 이름, 월급, 보너스율을 출력해보기
select 
    emp_name 사원명,
    salary||'원' 월급,
    bonus 보너스율,
    floor((sysdate-hire_date)/365)||'년' as "근속년수" 
from 
    employee 
where 
    (sysdate-hire_date)/365>=20;
--모든 직원의 이름, 연봉, 실수령액(연봉-연봉*3%)을 출력해보기
select emp_name 사원명,salary*12||'원' 연봉,salary*12-salary*12*0.03||'원' 실수령액 from employee;

--날짜값도 between 사용 가능
select * from employee 
    where hire_date between '00/01/01' and '05/12/31';

-- ** like (contains와 비슷) ~%~ (%: 뭔가가 있거나 없을 수도 있음) 
select * from employee where emp_name like '전%';
select * from employee where emp_name like '%유%';
select * from employee where emp_name like '%하_';
-- 언더바(_)도 사용가능: 언더바 자리에 반드시 한 글자가 존재해야 한다는 의미. 두개 쓰면 두글자
-- not like라고 쓰면 반대로 해당 글자를 포함하지 않는 사람만 출력한다는 의미.
select * from employee where emp_name not like '%하%';

--quiz07
--1.모든 직원중에 전화번호 처음 세자리가 010이 아닌 직원의 이름과 전화번호 출력해보기
select emp_name 사원명,phone 전화번호 from employee where phone not like '010%';
--2.모든 직원중에서 이름에 '이'가 들어가는 사람을 모두 찾아 이름을 출력해보기
select emp_name as "사원명" from employee where emp_name like '%이%';
--3.모든 직원중에서 부서코드가 D9 또는 D6이고, 월급이 270만원 이상이며, email에 s가 포함되어있고,
--고용일이 2001년 1월1일~2005년 12월31일 사이인 직원의 이름,부서코드,급여,email,고용일을 출력해보기
select emp_name 사원명,dept_code 부서코드,salary||'원' 급여,email 이메일,hire_date 고용일 from employee 
where 
    dept_code in ('D6','D9') 
    and salary>=2700000 
    and email like '%s%'
    and hire_date between '01/01/01' and '05/12/31';
    