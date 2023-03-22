desc employee;
--describe: employee table에 대해 묘사하라.

-- << select query의 기초문법 연습 >>

select emp_name,phone,emp_no from employee; 
-- employee table에서 해당 column의 data 출력
select * from employee; 
--모든 colume data 출력

--문법: select 컬럼명 from 테이블명 where 조건문;

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

--quiz07.
--1.모든 직원중에 전화번호 처음 세자리가 010이 아닌 직원의 이름과 전화번호 출력해보기
select emp_name 사원명,phone 전화번호 from employee where phone not like '010%';
--2.모든 직원중에서 이름에 '이'가 들어가는 사람을 모두 찾아 이름을 출력해보기
select emp_name as "사원명" from employee where emp_name like '%이%';
--3.모든 직원중에서 부서코드가 D9 또는 D6이고, 월급이 270만원 이상이며, email에 s가 포함되어있고,
--고용일이 2001년 1월1일~2005년 12월31일 사이인 직원의 이름,부서코드,급여,email,고용일을 출력해보기
select emp_name 사원명,dept_code 부서코드,salary||'원' 급여,email 이메일,hire_date 고용일 
    from employee 
    where 
        dept_code in ('D6','D9') 
        and salary>=2700000 
        and email like '%s%'
        and hire_date between '01/01/01' and '05/12/31';
        
--quiz08.
--1.직속상사(manager_id)가 없고 부서배치도 받지 않은 직원의 사번과 이름 출력해보기
select emp_id 사번,emp_name 사원명 from employee where manager_id is null and dept_code is null;
--2.부서배치를 받지 않았지만 보너스는 지급되는 직원의 부서코드,이름,보너스를 출력해보기
select dept_code 부서코드,emp_name 사원명,bonus 보너스 from employee where dept_code is null and bonus is not null;

--order by : query 실행 결과에서 특정조건을 이용해 데이터를 정렬하는 문법
select emp_id,emp_name,dept_code,salary from employee order by dept_code nulls last, salary desc; 
select emp_id,emp_name,salary from employee order by 3 desc; 
----default는 오름차순(asc), 내림차순은 desc, nulls first/last, column 번호로 order 가능
--정렬순서가 중요함

--quiz09.
--1.근속년수 5년 이상, 10년 이하인 직원의 이름,주민번호,급여,입사일을 검색하세요.
select emp_name 사원명, emp_no 주민번호,salary 급여,hire_date 입사일 from employee 
    where 5<=(sysdate-hire_date)/365 and (sysdate-hire_date)/365<=10;
    
--2.재직중이 아닌 직원의 이름,부서코드를 검색하세요. (퇴사 여부 : ENT_YN)
select emp_name 사원명,dept_code 부서코드 from employee 
    where ent_yn='Y';
    
--3.근속년수가 10년 이상인 직원들을 검색하여 출력 결과는 이름,급여,근속년수(소수점X)를 근속년수 오름차순으로 정렬하여 출력하세요.
--단, 급여는 50% 인상된 급여로 출력되도록 하세요.
select emp_name 사원명,salary*1.5||'원' 급여,floor((sysdate-hire_date)/365)||'년' 근속년수 from employee 
    where (sysdate-hire_date)/365>=10 order by 3;
    
--4.입사일이 99/01/01 ~ 10/01/01 인 사람 중에서 급여가 2000000 원 이하인 사람의 이름,주민번호,이메일,폰번호,급여를 출력하세요.
select emp_name 사원명,emp_no 주민번호,email 이메일,phone 전화번호,salary||'원' 급여 from employee 
    where hire_date between '99/01/01' and '10/01/01' and salary<=2000000;
    
--5.급여가 2000000원 ~ 3000000원 인 여직원 중에서 4월 생일자를 검색하여 이름,주민번호,급여,부서코드를 주민번호 내림차순으로 출력하세요.
--(단, 부서코드가 null인 사람은 부서코드가 '없음' 으로 출력 하세요.)
select emp_name 사원명,emp_no 주민번호,salary||'원' 급여,NVL(dept_code, '없음') 부서코드 from employee 
    where 2000000<=salary and salary<=3000000 and emp_no like '%04%-%' order by emp_no desc;
    
--6.남자 사원 중 보너스가 없는 사원의 오늘까지 근무일을 측정하여 1000일 마다(소수점 제외) 
--급여의 10% 보너스를 계산하여 이름,특별 보너스 (계산 금액) 결과를 출력하세요. 단, 이름 순으로 오름 차순 정렬하여 출력하세요.? 
select emp_name 사원명,salary*0.1*floor((sysdate-hire_date)/1000)||'원' "특별 보너스" from employee
    where emp_no like '%-1%' and bonus is null order by emp_name;
    
--0215---------------------------------------------------------------------------
-- ** function() == method()

--글자 관련 함수
-- nvl(), length(), lengthb(), instr(), substr()
select length('안녕하세요') from dual;
select lengthb('안녕하세요') from dual; -- 한글은 한 글자당 3byte
select instr('Hello World Hello Human','H',2,2) from dual;
select substr('구구절절대다라니경',6,4) from dual;

select * from employee;
--quiz01.
--1. 직원명단에서 이름의 성만 추출하여 출력해보기
--+) 출력할 내용 앞에 distinct 붙이면 : 중첩되는 건 지우고 하나만 남겨 출력
select distinct substr(emp_name,1,1) from employee; 
--2. 직원명단에서 사원번호, 사원명, 주민번호, 연봉을 출력해보기
--단, like를 사용하지 않고 남자직원의 정보만 주민번호 뒷 6자리는 *기호로 출력해보기
select emp_id 사원번호, emp_name 사원명, substr(emp_no,1,8)||'******' 주민번호, salary*12||'원' 연봉 
    from employee where substr(emp_no,8,1)='1';
 
 --숫자 관련 함수   
-- abs(), mod(), round(), floor(), trunc(), ceil()
select abs(-9) from dual;
select mod(10,4) from dual;
select round(3.141592, 3) from dual;
select round(33.141592, -1) from dual;
select trunc(3.141592, 2) from dual;
select ceil(3.141592) from dual;
select ceil(3.141592*10)/10 from dual; -- 소수점 첫째자리까지 올림
select ceil(3.141592*100)/100 from dual; --소수점 둘째자리까지 올림

--날짜 관련 함수
--sysdate,months_between, add_months(), next_day(), last_day(), extract()
select sysdate from dual;
select emp_name, floor(months_between(sysdate,hire_date)) 근속개월수 from employee;
select add_months(sysdate, 3) from dual;
select sysdate+30 from dual; --덧셈으로하면 달마다 일수가 달라서 정확한 계산 어려움
select next_day('23/03/01', '수') from dual;
select last_day(sysdate) from dual;
select extract(year from sysdate) from dual;

--quiz.
--1.다음 달 마지막 날짜는 며칠일까요?
select last_day('23/03/01') from dual;
select last_day(add_months(sysdate,1)) from dual;
--2.사번, 사원명, 입사년도(~~년) 형식으로 출력해보기
select emp_id 사번,emp_name 사원명,extract(year from hire_date)||'년' 입사년도 from employee;
--3.직원명단에서 사원의 이름, 입사일, 년차를 입사일 오름차순으로 출력해보기(년차-> 소수점일 경우 올림으로 출력)
select emp_name 사원명, hire_date 입사일, ceil((sysdate - hire_date)/365) 년차 from employee order by hire_date;

-- 복합 함수
--to char()
select to_char(sysdate, 'YYYY"년"MM"월"DD"일" (DY) "현재시각 : "HH:MI:SS WW RR') 예시 from dual;
select to_char(100000000, '9,9999,9999L') 예시 from dual; -- 반점을 원하는 위치에 찍을 수 있음
--quiz.
--사원명, 고용일(1990/02/06(화)) 형태로 출력해보기
select emp_name 사원명, to_char(hire_date,'YYYY/MM/DD(DY)') 고용일 from employee;

-- ** to_date()
select to_date('20180208','YYYYMMDD')-5 예시 from dual;

--quiz.
--1945년 8월 15일의 요일은?
select to_char(sysdate, 'DY') from dual;
select to_char(to_date('19450815'), 'DY')||'요일' "광복절 요일" from dual;

select sysdate - to_date('08272018','MMDDYYYY') from dual; --형식이 달라도 계산가능하네

--decode()
select decode('Orange','Apple','사과','Orange','오렌지','Banana','바나나') from dual;

--quiz
--사원번호, 사원명, 성별(남,여) 형태로 출력해보기
select emp_id 사번,emp_name 사원명,decode(substr(emp_no,8,1),1,'남',2,'여') 성별 from employee;

-- case(), 위 퀴즈를 case함수를 써서 아래와 같이 출력할 수 있음
select 
    emp_id,     
    emp_name, 
    case 
        when substr(emp_no,8,1)='1' then '남' 
        when substr(emp_no,8,1)='2' then '여' 
        else '??'    
    end 성별 
from employee;

--quiz
--60년대생 직원들 중에서 60~64년생 직원들은 60년생 초반, 65~69년생 직원들은 60년생 후반이라고 출력해보기
select emp_id 사번,emp_name 사원,
    case 
        when substr(emp_no,1,2) < 65 then '60년생 초반' 
        when 65<=substr(emp_no,1,2) then '60년생 후반'
    end "나이대"
from employee where substr(emp_no,1,1)=6 ; --substr(emp_no,1,2) between 60 and 69 로도 작성가능

-- 여기까지는 모두 단일행 함수
-------------------------
--그룹함수(sum, avg, count, max, min ..)
select to_char(sum(salary),'999,999,999')||'원' 급여합계 from employee;
select to_char(avg(salary),'999,999,999')||'원' 평균급여 from employee;
select count(salary)||'명' 직원수 from employee;
select to_char(max(salary),'999,999,999')||'원' 최대급여 from employee;
select to_char(min(salary),'999,999,999')||'원' 최소급여 from employee;

--quiz
--1.
select to_char(avg(salary),'999,999,999')||'원' 급여평균 from employee where dept_code='D5';
--2.
select to_char(sum(salary),'999,999,999')||'원' 급여합계 from employee where substr(emp_no,8,1)=1;

select to_char(123456.7890,'999,999.99') from dual;

--마무리 quiz.
--1.직원명과 이메일 , 이메일 길이를 출력하세요
select emp_name 이름, email 이메일, length(email) 이메일길이 from employee;
--2.직원의 이름과 이메일 주소중 아이디 부분만 출력하세요
select emp_name 이름, substr(email,1,instr(email,'@')-1) "ID" from employee;
--3. 60년생의 직원명과 년생, 보너스 율을 출력하세요
--   그때 보너스 값이 null인 경우에는 0% 이라고 출력 되게 만드세요
select emp_name 직원명, substr(emp_no,1,2) 년생, nvl(bonus*100,0)||'%' 보너스 from employee where substr(emp_no,1,1)=6;
--4. '010' 핸드폰 번호를 쓰지 않는 사람의 수를 출력하세요 (뒤에 단위는 명을 붙이세요)
select count(nvl(phone,'없음'))||'명' 인원 from employee where phone is null or substr(phone,1,3) not like '010%'; 
--count()는 null 값을 못셈
--5.직원명과 입사년월을 출력하세요  ex) 전형돈      2012년12월
select emp_name 직원명,to_char(hire_date,'YYYY"년"MM"월"') 입사년월 from employee;
--6.직원명과 주민번호를 조회하세요. 단, 주민번호 9번째 자리부터 끝까지는 '*' 문자로 채워서 출력 하세요
select emp_name 직원명,substr(emp_no,1,8)||'******' 주민번호 from employee;
--7. 직원명, 직급코드, 연봉(원)을 조회하세요. (연봉은 보너스포인트가 적용된 1년치 급여임)
--단, 연봉은 ￦57,000,000 와 같이 표시되게 함 (현지 통화 ￦가 적용 되어야 함) 
select emp_name 직원명,job_code 직급코드,to_char(salary*12+nvl(salary*bonus*12,0),'L999,999,999') "연봉(원)" from employee;
--8. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의[ 사번 사원명 부서코드 입사일 ]을 조회하세요
select emp_id 사번,emp_name 사원명, dept_code 부서코드, hire_date 입사일 from employee where dept_code in ('D5','D9') and substr(to_char(hire_date,'YYYY'),1,4)='2004';
select emp_id 사번,emp_name 사원명, dept_code 부서코드, hire_date 입사일 from employee where dept_code in ('D5','D9') and extract(year from hire_date)='2004';
--9.직원명, 입사일, 오늘까지의 근무일수 조회하세요. * 주말도 포함 , 소수점 아래는 버림
select emp_name 직원명, hire_date 입사일, floor(sysdate-hire_date)||'일' 근무일수 from employee;
--10.모든 직원의 나이 중 가장 많은 나이와 가장 적은 나이를 출력 하세요. (나이만 출력)
--모든 직원이 1900년대 생이라는 전제하에 만듭시다
select max(extract(year from sysdate)-1900-substr(emp_no,1,2)+1)||'세' 최고령,min(extract(year from sysdate)-1900-substr(emp_no,1,2)+1)||'세' 최연소 from employee;
select to_char(100000000, '777,777,777') from dual;
select emp_no from employee;
--11. 회사에서 야근을 해야 되는 부서를 발표하여야 합니다. 
--부서코드가 D5,D6,D9이면 야근, 그외는 야근없음 으로 출력되도록 하세요
-- 출력 값은 이름,부서코드,야근유무 (부서코드 기준 오름차순 정렬함.) (부서코드가 null인 사람도 야근없음 임)? 
select emp_name 이름, dept_code 부서코드, decode(dept_code, 'D5', '야근', 'D6', '야근','D9', '야근','야근없음') 야근유무 from employee order by dept_code;


--** group by : 그룹화 된 데이터 다루기
select nvl(dept_code,'없음') 부서코드, to_char(sum(salary),'L999,999,999,999') "부서별 급여합계" from employee group by dept_code order by dept_code;

--quiz
--1.직급별 급여 평균을 직급별 오름차순으로 정렬하여 출력해보기
select nvl(job_code,'intern') 직급, to_char(avg(salary),'L999,999,999') "급여 평균" from employee group by nvl(job_code,'intern') order by 직급;
--2.성별에 따른 인원수 출력해보기
select decode(substr(emp_no,8,1),1,'남',2,'여') 성별, count(*)||'명' 인원수 from employee group by substr(emp_no,8,1);
--3.성별에 따른 급여 평균 출력해보기, 임원진은 제외할 것
select decode(substr(emp_no,8,1),1,'남',2,'여') 성별, to_char(avg(salary),'L999,999,999') 급여평균 from employee where job_code not in ('J1','J2') group by substr(emp_no,8,1);
--select decode(substr(emp_no,8,1),1,'남',2,'여') 성별, to_char(avg(salary),'L999,999,999') 급여평균 from employee group by substr(emp_no,8,1);
--4.나이대별 급여 평균 출력해보기, 10만원 단위까지 반올림
select decode(substr(emp_no,1,1),6,'60년대생',7,'70년대생',8,'80년대생') 나이대,to_char(round(avg(salary),-5),'L999,999,999') 급여평균 from employee group by substr(emp_no,1,1) order by 1;

select * from employee;

--group by를 여러번 중첩해 더 세부적으로 그룹화해보기
--quiz
--1.부서내 직급별 인원수 파악
select dept_code, job_code, count(*)||'명' from employee group by dept_code, job_code order by 1,2;
select dept_code, count(*) from employee group by dept_code;
--2.부서내 성별별 인원수 파악
select nvl(dept_code,'없음') 부서, decode(substr(emp_no,8,1),1,'남',2,'여') 성별,count(*)||'명' 인원 from employee group by dept_code, decode(substr(emp_no,8,1),1,'남',2,'여') order by dept_code;

--** having
--where절에서는 그룹함수를 사용할 수 없기 때문에(막혀있음) 다른 방법을 사용한다.
--group by로 인해 그룹화 된 데이터에 대해 조건을 비교할 때는 having 절을 사용한다~!

----quiz. 
--1. 부서별 급여평균 300만원 이상인 부서의 부서코드 및 급여평균을 출력해보기
select dept_code 부서, to_char(avg(salary),'L999,999,999') 급여 from employee group by dept_code having avg(salary)>=3000000;
--2. 인원이 3명 미만인 직급코드의 인원을 충원하려고 한다. 해당 직급에 대하여 직급코드와 인원수 출력해보기
select job_code 직급코드, count(*)||'명' 인원 from employee group by job_code having count(*)<3;

--** join 문법
--1. ANSI 표준문법
-- cross join
select * from department cross join job;
-- inner join
select emp_id, emp_name, dept_title from employee inner join department on dept_code = dept_id;
-- +) column 명이 동일한 경우 테이블명을 앞에 붙여서 구분해줘야 한다.
-- +) from으로 불러올 때 table 명에 별칭을 붙여서 코드를 간단하게 쓸 수 있다. ( 별칭을 붙였으면 이후 계속 별칭으로 써야함)
select emp_id, emp_name, e.job_code, job_name from employee e
inner join job j on e.job_code = j.job_code;
-- 다만 이렇게 join에서 쓸 조건의 테이블 내 컬럼명이 동일한 경우에, using을 사용할 수 있다!
-- (using을 사용하면 별칭은 사용할 수 없음)
select emp_id, emp_name, job_code, job_name from employee 
inner join job using(job_code) ;
-- outer join : null과 같은 항목까지 모두 출력
select emp_name, nvl(dept_code,'없음'), nvl(dept_title,'없음') from employee left outer join department on dept_code = dept_id order by 2;
select emp_name, dept_code, dept_title from employee full outer join department on dept_code = dept_id order by 2;
-- ** self join : 같은 테이블을 join할 수 있다.
select * from job cross join job; 
--예문) 직원정보 옆에 manager_id 뿐만 아니라 manager(상사) 이름을 출력해보자.
select e1.emp_id 사원ID, e1.emp_name 이름, nvl(e1.manager_id,'없음') 직속상사ID, nvl(e2.emp_name,'없음') 직속상사이름 
from employee e1 left join employee e2 on e1.manager_id = e2.emp_id order by 1; 
select e1.emp_id 사원ID, e1.emp_name 이름, nvl(e1.manager_id,'없음') 직속상사ID, nvl(e2.emp_name,'없음') 직속상사이름 
from employee e1 cross join employee e2 order by 1; 

--2. Oracle 전용문법
-- cross join (cartesian product를 만들어낸다.)
select * from department, job; 
-- inner join (cartesian product 중에서 특정 조건을 만족하는 레코드만 선별)
-- null값을 가진 항목은 가져올 수 없다. (--> outer join으로 null까지 가져올 수 있음)
select emp_id, emp_name, dept_title from employee, department where dept_code = dept_id;
select emp_id, emp_name, dept_title from employee, department;


--quiz.
--1. 기술지원부 사람들의 이름, 부서코드, 급여 출력해보기
select emp_name, dept_code, salary from employee, department where dept_code=dept_id and dept_title = '기술지원부';
select emp_name, dept_code,dept_title, salary from employee inner join department on dept_code=dept_id and dept_title = '기술지원부';
--2. 해외영업n부 직원들의 사번, 사원명, 부서명, 연봉 출력해보기
select emp_id 사번, emp_name 사원명, dept_title 부서명, to_char(salary*12,'L999,999,999') 연봉 
from employee inner join department on dept_code=dept_id and dept_code in ('D5','D6','D7');
--또는
select emp_id 사번, emp_name 사원명, dept_title 부서명, to_char(salary*12,'L999,999,999') 연봉 
from employee inner join department on dept_code=dept_id where dept_title like '해외영업%';
--3. self join 응용문제. 
--하이유씨와 같은 부서에서 일하는 직원들의 이름, 부서코드, 직급코드를 출력해보기(조건 내 이름만 바꾸면 다른사람으로 출력가능)
select e2.emp_name, e2.dept_code, e2.job_code from employee e1 join employee e2 on e1.dept_code=e2.dept_code where e1.emp_name='하이유';

-- 다중 join : 3개 이상의 테이블 join
-- 사원명, 부서명, 직급명을 함께 출력해보기
select e.emp_name, d.dept_title, j.job_name 
from employee e full join department d on e.dept_code=d.dept_id 
join job j on e.job_code = j.job_code order by e.job_code;

--quiz
--사원명, 부서명, 근무지역(national code)을 출력해보기
select e.emp_name,d.dept_title,l.national_code,n.national_name 
from employee e left join department d on e.dept_code=d.dept_id
left join location l on d.location_id=l.local_code
left join national n on l.national_code=n.national_code ;

--- 총 정리 quiz
-- 1. 2020년 12월 25일이 무슨 요일인지 조회하세요.
select to_char(to_date('20/12/25'),'DY')||'요일' "20.12.25 요일" from dual;
-- 2. 주민번호가 1970년대 생이면서 성별이 여자이고, 성이 전씨인 직원들의 사원명, 주민번호, 부서명, 직급명을 조회하세요.
 select e.emp_name 사원명,e.emp_no 주민번호,d.dept_title 부서명,j.job_name 직급명 from employee e join department d on e.dept_code=d.dept_id
 join job j on e.job_code=j.job_code where substr(emp_no,1,1)=7 and substr(emp_no,8,1)=2 and substr(emp_name,1,1)='전';
-- 3. 이름에 "형"자가 들어가는 직원들의 사번, 사원명, 부서명을 조회하세요.
select emp_id 사번,emp_name 사원명, dept_title 부서명 from employee join department on dept_code=dept_id where emp_name like '%형%';
-- 4. 부서별 급여 평균이 300만원 이하인 부서의 부서명과 급여 평균을 출력하세요
-- > 급여 평균은 10000의 자리 아래로 버리고 출력해주세요. 
-- > 또한 한국 로컬 통화 표기법으로 출력해주세요. (￦3,520,000)
select nvl(dept_title,'없음') 부서명, to_char(trunc(avg(salary),-4),'L999,999,999') 급여평균 from employee left join department
on nvl(dept_code,'0')=nvl(dept_id,'0') group by dept_title having avg(salary)<=3000000;
-- 5. 해외영업부에 근무하는 사원명, 직급명, 부서코드, 부서명을 조회하세요.
select emp_name 사원명,job_name 직급명, dept_code 부서코드, dept_title 부서명 
from employee e join job j on e.job_code=j.job_code
join department d on e.dept_code=d.dept_id where dept_title like '해외영업%';
-- 6. 보너스포인트를 받는 직원들의 사원명, 보너스포인트, 부서명, 근무지역명을 조회하세요.
select emp_name 사원명,bonus 보너스포인트,nvl(dept_title,'없음') 부서명, nvl(local_name,'없음') 근무지역명 
from employee left join department on dept_code=dept_id
left join location on location_id=local_code 
where bonus is not null;
-- 7. 부서코드가 D2인 직원들의 사원명, 직급명, 부서명, 근무지역명을 조회하세요.
select emp_name 사원명,job_name 직급명, dept_title 부서명, local_name 근무지역명 
from employee join job on employee.job_code=job.job_code
join department on dept_code=dept_id
join location on location_id=local_code
where dept_code='D2';
-- 8. 한국(KO)과 일본(JP)에 근무하는 직원들의 사원명, 부서명, 근무지역명, 국가명을 조회하세요.
select nvl(emp_name,'없음') 사원명, dept_title 부서명, local_name 근무지역명, national_name 국가명
from employee full join department on dept_code=dept_id
join location on location_id=local_code
join national on location.national_code=national.national_code
where national.national_code in ('KO','JP');
-- 9. 모든 사원 중 선동일을 매니저로 두고 있는 직원의 이름, 직원의 부서명, 매니저의 이름을 출력하세요.
select e1.emp_name 이름, dept_title 부서명, e2.emp_name "매니저 이름"
from employee e1 join employee e2 on e1.manager_id=e2.emp_id
join department on e1.dept_code=dept_id
where e2.emp_name='선동일';
-- 10. 보너스포인트가 없는 직원들 중에서 직급이 차장과 사원인 직원들의 사원명, 직급명, 급여를 조회하세요 (join과 in 사용)
select emp_name 사원명, job_name 직급명, to_char(salary,'L9,999,999') 급여
from employee join job on employee.job_code=job.job_code
where bonus is null and job_name in ('차장','사원');
-- 11. 재직중인 직원과 퇴사한 직원의 수를 조회하세요.
select decode(ent_yn,'Y','퇴사','N','재직중') 재직여부,count(*)||'명' 인원 from employee group by ent_yn;

----0220------------------------------------------
--union : 기본적으로 두 테이블 간의 합집합
select dept_id from department union 
select bonus from employee; --칼럼 수, 데이터타입이 같아야한다.

create table A(data number); -- 객체(테이블) 생성
insert into A values(1); -- 테이블에 행 추가
insert into A values(2);
insert into A values(3);
select * from A;
--drop table A; -- 테이블 삭제

create table B(data number);
insert into B values(2);
insert into B values(3);
insert into B values(4);
select * from B;

select * from A union select * from B; -- 그냥 union은 두 테이블 내 중복된 행이 있다면 그 행은 1회만 출력한다. 
select * from A union all select * from B; -- 두 테이블간에 중복을 허용하여 모두 출력한다.
select * from A intersect select * from B; -- 두 테이블간의 교집합을 출력한다.
select * from A minus select * from B; -- 앞 테이블에서 두 테이블간의 교집합을 제외한 부분(차집합)을 출력한다.

----- **** subquery : 쿼리 안의 쿼리

--예시) 전지연의 상사 이름을 찾으려 할 때, 아래의 두 순서로 찾든지
select manager_id from employee where emp_name='전지연';
select emp_name from employee where emp_id=214;
--혹은 self join으로 다음과 같이 찾아낼 수 있었지만
select e1.emp_name,e2.emp_name from employee e1 join employee e2 on e1.manager_id=e2.emp_id where e1.emp_name='전지연';

--다음과 같이 select manager_id from employee where emp_name='전지연' 자체를 214라는 return값이라고 보고
--select emp_name from employee where emp_id=214;의 214 부분에 대체하여 넣을 수 있다.
select emp_name from employee where emp_id=(select manager_id from employee where emp_name='전지연');

--결과에 따라 분류.
--단일행,단일열/다중행/다중열/다중행,다중열/inline view/상관

--단일행, 단일열 subquery 예시
--quiz
--1. 윤은해 직원의 급여와 동일한 급여를 받는 직원의 이름 및 급여 출력해보기
select emp_name 이름, to_char(salary,'L999,999,999') 급여 from employee where salary = (select salary from employee where emp_name='윤은해') and emp_name != '윤은해'; 
--2. 전 직원 급여 평균보다 급여를 많이 받는 직원의 이름, 직급코드, 급여를 출력해보기
select emp_name 이름, job_code 직급코드, to_char(salary,'L999,999,999') 급여 from employee where salary > (select avg(salary) from employee);
--3. D1, D2부서의 직원 중 급여가 D5부서의 급여 평균보다 많은 직원들의 부서번호, 사번, 사원명, 급여를 출력해보기
select dept_code 부서번호,emp_id 사번, emp_name 사원명, to_char(salary,'L999,999,999') 급여 from employee 
where salary > (select avg(salary) from employee where dept_code='D5') and dept_code in ('D1','D2'); 
--4. 급여가 제일 많은 사람과 제일 적은 사람의 사번, 사원명, 급여를 출력해보기
select emp_id 사번, emp_name 사원명, to_char(salary,'L999,999,999') 급여 from employee where salary in ((select max(salary) from employee),(select min(salary) from employee)); 


select emp_id 사번, emp_name 사원명, to_char(salary,'L999,999,999') 급여 from employee where salary = (select max(salary),min(salary) from employee); 
-->단일행 다중열 subquery이기도 함
select max(salary),min(salary) from employee;


-- 다중행 단일열 subquery 예시
--박나라, 송종기의 부서코드와 동일한 부서에 속한 직원들의 정보
select * from employee where dept_code in (select dept_code from employee where emp_name in ('박나라','송종기'));
--> 안쪽의 쿼리를 실행했을 때 다중행의 결과를 만들어낸다. 이때는 = 비교를 수행할 수 없다. in을 사용해야 함.

--quiz.
--1. 차태연 또는 전지연 직원의 급여등급과 같은 급여등급인 직원의 직급명과 사원명을 출력해보기
select job_name 직급명, emp_name 사원명, sal_level 급여등급 from employee join job using(job_code)
where sal_level in (select sal_level from employee where emp_name in ('차태연','전지연'));
--2. 직급이 대표, 부사장이 아닌 모든 직원의 사원명, 직급코드를 출력해보기
select emp_name 사원명, job_code 직급코드 from employee 
where job_code not in (select job_code from job where job_name in ('대표','부사장'));

--다중행 subquery문에서 <,>비교를 표현하려면?
--예시) D5 부서 직원들의 급여보다 많이받는 직원의 정보를 출력
select emp_name 사원명,to_char(salary,'L9,999,999') 급여 from employee 
where salary>any(select salary from employee where dept_code='D5'); -- min(salary)보다 큰 값 출력
select emp_name 사원명,to_char(salary,'L9,999,999') 급여 from employee 
where salary>all(select salary from employee where dept_code='D5'); -- max(salary)보다 큰 값 출력

-- 단일행 다중열 subquery 예시
--퇴사한 사람과 같은 부서, 같은 직급에 속한 사람의 정보 출력
select emp_name, dept_code, job_code from employee 
where (dept_code, job_code) = (select dept_code, job_code from employee where ent_yn='Y');
-- 다중열 subquery = 다중행 다중열 subquery 문법과 동일.

--quiz.
--1. 생일이 8월8일인 사원들과 같은 부서이면서 같은 직급코드인 직원들의 사원명,생일을 출력해보기 (8월8일인 사람은 제외)
select emp_name 사원명, to_char(to_date(substr(emp_no,3,4),'MMDD'),'MM"월"DD"일"') 생일 from employee 
where (dept_code, job_code) in (select dept_code, job_code from employee where substr(emp_no,3,4)='0808') and  substr(emp_no,3,4) !='0808';
--2. 부서별 급여를 가장 많이 받는 직원의 부서코드 및 급여 출력해보기
select nvl(dept_code,'없음') 부서코드,emp_name 이름, to_char(salary,'L99,999,999') 급여 from employee 
where (nvl(dept_code,'없음'),salary) in (select nvl(dept_code,'없음'),max(salary) from employee group by dept_code) order by dept_code;
--부서코드까지 꼭 써줘야 함! salary로만 검색하면 잘못된 결과까지 출력됨

-- subquery를 사용하는 또다른 유형
--select절에서 subquery 사용
--직원명, 부서명을 붙여쓰고 싶을 때
select emp_name, (select dept_title from department where dept_code = dept_id) from employee;
--> subquery는 main query의 column을 본인것처럼 사용할 수 있다. 
--> subquery가 mainquery의 영향을 받을 때, 이를 상관 subquery라고 함.

--quiz. 직원명, 직급명을 출력해보기 (join이 아닌 subquery로)
select emp_name, (select job_name from job j where j.job_code=e.job_code)  from employee e;

--inline view 편
--from절에서 subquery 사용 (임의로 만들어진 가상 table이라고 생각해도 무방)
select * from  (select emp_id, emp_name, emp_no from employee);

-- rank 관련 함수 !
select emp_name, salary, rank() over(order by salary desc) 순위 from employee;
select emp_name, salary, dense_rank() over(order by salary desc) 순위 from employee;
select emp_name, salary, row_number() over(order by salary desc) 순위 from employee;

--quiz.
--1. 급여 내림차순으로 행마다 번호를 붙였을 때, 10~15위 까지의 데이터만 출력해보기
select * from (select emp_name, salary, rank() over(order by salary desc) as "랭킹" from employee) where "랭킹" between 10 and 15;

--마무리 quiz.
--1. 기술지원부에 속한 사람들의 사람의 이름,부서코드,급여를 출력하시오
select emp_name 이름, dept_code 부서코드, to_char(salary,'L999,999,999') 급여 from employee 
where dept_code = (select dept_id from department where dept_title='기술지원부');
--또는
select emp_name 이름, dept_code 부서코드, to_char(salary,'L999,999,999') 급여 from employee
join department on dept_code=dept_id where dept_title = '기술지원부';
--2. *** 기술지원부에 속한 사람들 중 가장 연봉이 높은 사람의 이름,부서코드,급여를 출력하시오
select emp_name 이름, dept_code 부서코드, to_char(salary,'L999,999,999') 급여 from employee
where (dept_code, salary) in (select dept_code, max(salary) from employee group by dept_code) and dept_code = (select dept_id from department where dept_title='기술지원부');
--또는
select emp_name 이름, dept_code 부서코드, to_char(salary,'L999,999,999') 급여 from employee join department on dept_code=dept_id
where (dept_code,salary) in (select dept_code, max(salary) from employee group by dept_code) and dept_title='기술지원부';
--3. 매니저가 있는 사원중에 월급이 전체사원 평균을 넘고 사번,이름,매니저 이름,월급(만원단위부터)을 구하시오.
--단, JOIN을 이용하시오
select e1.emp_id 사번, e1.emp_name 이름, e2.emp_name "매니저 이름", e1.salary/10000||'만원' 월급 from employee e1
join employee e2 on e1.manager_id=e2.emp_id where e1.manager_id is not null and e1.salary > (select avg(salary) from employee);
--===>>  e1.manager_id=e2.emp_id에서 null은 걸러지니까 not null은 빼는게 맞는건가?

--4. 각 직급마다 급여 등급이 가장 높은 직원의 이름, 직급코드, 급여, 급여등급 조회
--급여등급이라고 하면 중복되는데..
select emp_name 이름, job_code 직급코드, to_char(salary,'L9,999,999') 급여, sal_level 급여등급 from employee
where (job_code,sal_level) in (select job_code,min(sal_level) from employee group by job_code);
--급여가 가장 높은 이라고 생각하면
select emp_name 이름, job_code 직급코드, to_char(salary,'L999,999,999') 급여, sal_level 급여등급 from employee
where (job_code, salary) in (select job_code, max(salary) from employee group by job_code);
--5. 가장 보너스를 많이 받는 순으로 사원들을 뽑았을때 4~8위의 순위, 사원명, 급여, 보너스율을 출력
select * from (select rank() over(order by bonus desc) as "순위",emp_name 사원명,to_char(salary,'L9,999,999') 급여,bonus 보너스율 from employee 
where bonus is not null) where "순위" between 4 and 8;
--6. 부서별 평균 급여가 2,200,000 이상인 부서명, 평균 급여 조회 단, 평균 급여는 소수점 버림
select (select dept_title from department where dept_id=dept_code) 부서명, floor(avg(salary)) 평균급여 
from employee where dept_code in (select dept_code from employee group by dept_code having avg(salary)>2200000) group by dept_code;
---===>> 이건 너무 지저분한 코드인가?
--또는
select * from (select dept_title 부서명, floor(avg(salary)) 평균급여 from employee join department on dept_id=dept_code group by dept_title) where 평균급여>=2200000;
--7. 직급의 연봉 평균보다 적게 받는 여자사원의 사원명,직급코드,부서코드,연봉을 이름 오름차순으로 조회하시오 
--연봉 계산 => (급여+(급여*보너스))*12
select emp_name 사원명, job_code 직급코드, dept_code 부서코드, to_char((salary+salary*nvl(bonus,0))*12,'L999,999,999') "연봉" from employee e1
where (salary+salary*nvl(bonus,0))*12 < (select avg((salary+salary*nvl(bonus,0))*12) from employee e2 group by job_code 
having e1.job_code = e2.job_code) and substr(emp_no,8,1)='2' order by 1; -- 거의 join 혐오자;;

--답안
select e1.emp_name 사원명, e1.job_code 직급코드, e1.dept_code 부서코드, 연봉 from employee e1 
join (select job_code, avg(salary*(1+nvl(bonus, 0))*12) 직급평균연봉 from employee group by job_code) e2 on e1.job_code = e2.job_code
join (select salary*(1+nvl(bonus, 0))*12 연봉, emp_id from employee) e3 on e3.emp_id = e1.emp_id -- 여긴 join 신봉자인듯
where (substr(emp_no, 8, 1) = 2) and (연봉 < 직급평균연봉) order by 1;

select * from department;
select * from employee;
select * from job;
select * from location;
select * from national;
select * from sal_grade;

----------------------------------------------------------------------------------------------------------
------0221
-- DDL

-- create table <테이블이름> (
--  컬럼명 자료형 제약조건,
--  컬럼명 자료형 제약조건,
-- .....
--);

create table cafe_menu(
    id number,
    name varchar(21), -- 글자형 자료형은 최대사이즈(byte)를 지정해줘야 함(varchar/char 둘다 가능)
    --varchar: 가변적인 자료형. 집어넣은 데이터가 최대값보다 작으면 남은 공간을 회수한다. char는 고정적 크기.
    price number
);

describe cafe_menu;

-- DML
--insert : table 객체에 데이터를 입력하는 SQL
--insert into 테이블명 컬럼명 values(데이터);
insert into cafe_menu (id,name) values(1001,'Americano');
insert into cafe_menu (id,price) values(1002,3000);
insert into cafe_menu (id,name,price) values(1003,'Cafe Mocha',4000);
insert into cafe_menu values(1004,'Orange Juice',4500);
-- 모든 컬럼을 다 작성하겠다는 전제 하에 컬럼명 생략하고 작성 가능

--update : table 객체에 저장된 데이터를 수정하는 SQL
--update 테이블명 set 컬럼명 = 수정할 데이터 where 수정할 행 지정;
update cafe_menu set price = 2000 where id=1001;
update cafe_menu set name = 'Cafe Latte' where id=1002;

insert into cafe_menu (id) values(1005);
update cafe_menu set name = 'Vanila Latte', price = 3500 where id = 1005;
--콤마로 이어서 여러 컬럼을 동시에 update 가능

--delete : table 객체에 저장된 데이터를 삭제하는 SQL
--delete from 테이블명 where 삭제할 행 지정;
delete from cafe_menu where id=1004;

delete from cafe_menu;

select * from cafe_menu;

--drop : Oracle 내에 존재하는 객체를 삭제하는 SQL
--drop 객체종류 객체이름;
drop table cafe_menu;

-- DDL - Create 2 -
create table cafe_menu(
    id number not null, -- null 값이 들어갈 수 없다는 제약조건 작성
    name varchar(21) not null,
    price number not null
);

describe cafe_menu;

insert into cafe_menu (id) values(1001); -- null값을 넣을 수 없음
insert into cafe_menu values(1001,'Americano',2000);
update cafe_menu set price=null where id=1001; --null값으로 수정할수도 없음

insert into cafe_menu values(1001,'Americano',2000);
--이렇게 똑같은 행을 또 만들면 두 행을 구분할 방법이 없어짐.
--중복된 행의 입력을 허락하지 않는 제약조건 필요! --> 테이블 다시 생성해보자.
drop table cafe_menu;


-------
create table cafe_menu(
    id number primary key, --> not null이면서 중복을 허락하지 않는 기능을 한다. 
                                        --(딱 하나의 컬럼에만 설정 가능. 따라서 진짜 식별자로서 사용하기 위함!)
    name varchar(21) not null,
    price number not null
);

insert into cafe_menu values(1001,'Americano',2000); -- 이제 1001번 id는 하나만 생성가능해짐
insert into cafe_menu values(1002,'Cafe Latte',3000);

drop table cafe_menu;

--또다른 제약조건을 추가해보자.
--(unique)
create table cafe_menu(
    id number primary key,
    name varchar(21) unique not null, --> unique : 컬럼에 중복을 방지한다. (null은 허용)
    price number not null                   -- 위와같이 여러 제약조건을 함께 작성가능. 
);

insert into cafe_menu values(1001,'Americano',2000);
insert into cafe_menu values(1002,'Americano',3000); --이제 이름도 중복된 값 삽입 불가!
insert into cafe_menu values(1002,'Cafe Latte',3000);

drop table cafe_menu;

--또다른 제약조건을 추가해보자.
--(check)
create table cafe_menu(
    id number primary key,
    name varchar(21) unique not null, 
    price number not null,
    isIce char(1) check(isIce in ('Y','N')) not null -- check : 특정 값이 아니면 입력을 허락하지 않음
);

insert into cafe_menu values(1001,'Americano',2000,'ice'); -- isIce 크기에 맞지 않아 에러발생
insert into cafe_menu values(1001,'Americano',2000,'i'); -- check로 설정한 값에 해당하지 않아 에러발생
insert into cafe_menu values(1001,'Americano',2000,'N');
insert into cafe_menu values(1002,'Cafe Latte',2500,'Y');

select * from cafe_menu;

--또다른 제약조건을 추가해보자. 
--(foreign key)
--상품목록이 저장된 테이블
create table product(
    id number primary key,
    pname varchar(30) not null,
    price number not null
);

insert into product values(1001,'Airpot',200000);
insert into product values(1002,'Galaxys23',2000000);
insert into product values(1003,'LG_Gram17',1500000);

update product set pname='GalaxyS23' where id=1002;

--판매내역을 기록하는 테이블
create table sales_history(
    sid number primary key, --판매기록 id
    pid references product(id) not null, --판매된 항목의 id --> 상품목록에 없는 id는 들어올 수 없다. (외래 키)
    sdate timestamp not null --판매된 날짜
);

insert into sales_history values(100001,1005,sysdate); --결점있는(참조하는 외래키에 해당하지 않는) 데이터 오류
--오류 구문을 보면 알수있듯이, references 한 컬럼간에 parent - child 관계가 형성된다.

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);


--이때 부모키의 1001번을 지우려고 한다면?
delete from product where id=1001; -- 무결성 제약조건 위반. child record가 있어서 삭제할 수 없다.
delete from product where id=1002; -- child와 엮이지 않은 항목은 삭제 가능하다.

drop table product; -- 항목이 엮여있는 parent 테이블은 삭제할 수 없다.
drop table sales_history; -- child 테이블은 삭제 가능

--새로운 설정 추가해 생성
create table sales_history(
    sid number primary key, 
    pid references product(id) on delete cascade, -- parent table의 항목을 지웠을 때 child tale의 연결된 항목도 삭제된다. 
    sdate timestamp not null 
);

insert into product values(1002,'Galaxys23',2000000);

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);
insert into sales_history values(100003,1002,sysdate);
insert into sales_history values(100004,1002,sysdate);

delete from product where id = 1002; --제약조건 덕분에 product의 1002번이 지워지고,
--child record에서 1002번과 엮인 항목들도 삭제된 것을 확인할 수 있다.
--게시판에 글을 쓴 사람이 외래키로 id를 받고, 이 사람이 회원탈퇴했을때 게시글까지 모두 지워지도록 할 수 있음

drop table sales_history;

create table sales_history(
    sid number primary key, 
    pid references product(id) on delete set null, -- parent table의 항목을 지웠을 때 child tale의 연결된 항목엔 null값이 입력된다. 
    sdate timestamp not null 
);

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);

delete from product where id=1003; -- child record가 null값으로 바뀐 걸 확인할 수 있다.
--이후 출력할 때 null값--> '탈퇴한 회원' 같은 식으로 표현할 수 있겠다.

select * from product;
select * from sales_history;

--------------------------------------
--sequence 객체 : 주로 식별자 id 관리에 사용

create sequence product_seq --product 테이블에서 사용할 이름설정
start with 1002 -- 1002부터 시작(현재 1001번까지 들어있으니까)
increment by 1 --1씩 증가
nomaxvalue nocache; --이건 그냥 default라고 생각

insert into product values(product_seq.nextval,'IPad6',1500000);
--이렇게 sequence 객체에게 다음 값을 꺼내달라고 요청하여 사용

--------------------------------------
--alter(DDL) : 객체 설정 수정 (쓰임새가 적어서 잊기 쉬운 문법들)


select * from cafe_menu;

--테이블 이름 변경
--cafe_menu --> cafe로 수정
alter table cafe_menu rename to cafe;

select * from cafe;

--테이블 컬럼 추가
alter table cafe add (menu_size varchar(10) check (menu_size in ('S','R','L')) not null);
-->null 값을 넣을 수 없다고 제약했으므로 값을 넣지 않고는 컬럼 생성 불가
alter table cafe add (menu_size varchar(10) default 'S' check (menu_size in ('S','R','L')) not null);
-->따라서 기본값 설정을 해주면 생성가능

--테이블 컬럼 삭제
alter table cafe drop column menu_size;

--테이블 컬럼 자료형 변경
alter table cafe modify name varchar(30) not null; --or null
desc cafe;

--컬럼 이름 변경
alter table cafe rename column menu_size to scale;
desc cafe;

-------제약조건 변경(null/not null만 modify로 수정 가능하다.)
-- 먼저 알아야하는 것. Oracle의 dictionary(오라클 내장 테이블) 기능
-- 사용자의 명령에 의해 발생하는 데이터를 보관하기 위한 오라클 내장 테이블.
--여기서 명령이란 create, view .. 등

select * from user_tables; -- kh계정이 만든 테이블들이 담긴 table
select * from user_constraints; -- kh계정이 만든 제약조건들이 담긴 table

--먼저 어떤 제약조건이 있는지 dictionary를 통해 조회한 후 제약조건을 변경해보자.
select * from user_constraints where table_name='CAFE'; --(constraint_type에서 P는 primary, U는 unique)
desc cafe;

--제약조건 삭제
alter table cafe drop constraint SYS_C007031; --isIce의 체크 옵션을 삭제
alter table cafe drop constraint SYS_C007032;

--제약조건 추가
alter table cafe add primary key(id);
--추가할 때 지정한 이름으로 제약조건 이름을 설정할 수 있다.
alter table cafe add constraint cafe_id_pk primary key(id); 
--unique도 추가
alter table cafe add constraint cafe_name_uk unique(name);
--check도 다시 추가
alter table cafe add constraint cafe_isIce_chk check (isIce in ('Y','N'));

drop table cafe;

--create로 컬럼을 생성할 당시에 제약조건에 이름을 설정할 수도 있다.
create table cafe(
    id number constraint cafe_id_pk primary key,
    name varchar(30) constraint cafe_name_uk unique constraint cafe_name_nn not null,
    price number constraint cafe_price_nn not null,
    isIce char(1) constraint cafe_isIce_chk check(isIce in ('Y','N'))
);

select * from user_constraints where table_name='CAFE'; 

--sequence에도 alter를 쓸 수 있다.
create sequence cafe_seq start with 1001 increment by 1 maxvalue 2000 nocycle; 
--+) cycle : maxvalue(2000)까지 도달한 다음 다시 시작지점(1001)으로 돌아가는것

alter sequence cafe_seq nomaxvalue;
alter sequence cafe_seq increment by -10; --감소하도록 하려면 음수로 설정.

-- +)계정 패스워드도 변경 가능 (관리자 계정으로 접속 후)
--alter user kh identified by test; 이런식으로 작성하면 됨
-----------------------------------------
-- DCL : grant, revoke (view 객체를이용해 알아보기)
-- 권한은 테이블 단위로 줄 수있다. 테이블을 볼수 있거나/없거나. 컬럼단위로는 줄 수 없음.
-- 이때 필요없는 컬럼은 빼고 주고싶을 때. 주고싶은 내용만 부분테이블로 따로 만들어 주는 방법을 사용할 수 있다.
select * from employee;

create table employee_dev as select emp_id, emp_name, email, phone from employee;
select * from employee_dev;

--잠시 관리자로 접속하여 dev 계정생성, 권한부여

--다시 kh로 돌아와 dev 계정에 부분테이블을 조회할 수 있는 권한 부여
grant select on employee_dev to dev;

--그러면 dev는 kh가 떼어준 테이블을 조회할 수 있게 되지만,
--employee 테이블에 변경사항이 있을 때 employee_dev까지 자동으로 업데이트 되지는 않는다. 일일히 업데이트해줘야 함.
--따라서 변경사항까지 자동으로 반영하기 위해서는 위 작업을 view로 전환하여 수행하도록 한다.
--view : 가상의 접근체제. view라는 링크를 통해 원본테이블을 보는 방식. 따라서 원본테이블의 변경사항이 반영된다.

-- resource 권한에는 view를 만드는 권한이 없음. 관리자에게서 부여받아 생성한다.
create view employee_view as select emp_id, emp_name, email, phone from employee;

-- 만들어진 view를 조회할 수 있는 권한을 dev에게 준다.
grant select on employee_view to dev;

update employee set emp_name='선동일' where emp_id=200;
commit; --커밋해줘야 저장됨
select * from employee;

--테이블에 대해 부여된 권한 모두 출력
select * from user_tab_privs;

--권한 빼앗기
revoke select on employee_dev from dev;
revoke select on employee_view from dev;

---------------------------------------
-- TCL (Transanction Control Language)
-- rollback : 모든query를 취소하고 특정시점으로 복원하는 명형

select * from user_sequences;
select * from cafe;
insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y');

rollback; -- cafe에 메뉴 입력하기 전으로 돌아갔음.

select * from employee;
delete from employee; -- 혹시나 delete 컬럼을 입력하지 않아 데이터를 다 날려먹었어도 rollback으로 복구가능

-- commit : 작성된 query들을 실제 DB에 반영하는 명령. 더이상 복원할 수 없다 .. 

--실습
delete from cafe;
commit;
insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y');
insert into cafe values(cafe_seq.nextval, 'Cafe Mocha', 4000, 'Y');
select * from cafe;
delete from cafe where id=1005;
