--[Basic Select]
--1.
select department_name "학과 명", category "계열" from tb_department;
--2.
select department_name||'의 정원은 ' ||capacity||'명 입니다.' "학과별 정원" from tb_department;
--3. 
select student_name from tb_student where department_no=(select department_no from tb_department where department_name='국어국문학과')
and absence_yn='Y' and substr(student_ssn,8,1)=2;
--4.
select student_name from tb_student where student_no in ('A513079','A513090','A513091','A513110','A513119');
--5.
select department_name, category from tb_department where capacity between 20 and 30;
--6.
select professor_name from tb_professor where department_no is null;
--7.
select student_no from tb_student where department_no is null;
select student_no from tb_student where department_no not in (select department_no from tb_department);
--8.
select class_no from tb_class where preattending_class_no is not null;
--9.
select distinct category from tb_department;
--10.
select student_no, student_name, student_ssn from tb_student where substr(student_no,1,2)='A2' and student_address like '전주시%' and absence_yn='N';

--[Additional Select - 함수]
--1.
select student_no 학번, student_name 이름, to_char(entrance_date,'YYYY-MM-DD') 입학년도 from tb_student where department_no='002' order by 3;
--2.
select professor_name, professor_ssn from tb_professor where length(professor_name) !=3;
--3.
select professor_name 교수이름, floor((sysdate-to_date(19000000+(substr(professor_ssn,1,6)),'YYYYMMDD'))/365) 나이 from tb_professor where substr(professor_ssn,8,1)=1 order by 2;
--4.
select substr(professor_name,2,2) 이름 from tb_professor;
--5.
select student_no, student_name from tb_student where ((entrance_date-to_date(19000000+substr(student_ssn,1,6),'YYYYMMDD'))/365)>19;

select student_name, floor((entrance_date-to_date(19000000+substr(student_ssn,1,6),'YYYYMMDD'))/365) 입학나이 from tb_student;

--6.
select to_char(to_date('20201225','YYYYMMDD'),'DY')||'요일' "2020년 크리스마스" from dual;
--7.
select to_char(to_date('99/10/11','YY/MM/DD'),'YYYY"년"MM"월"DD"일"') "1", to_char(to_date('49/10/11','YY/MM/DD'),'YYYY"년"MM"월"DD"일"') "2", 
to_char(to_date('99/10/11','RR/MM/DD'),'YYYY"년"MM"월"DD"일"') "3", to_char(to_date('49/10/11','RR/MM/DD'),'YYYY"년"MM"월"DD"일"') "4" from dual;
--8.
select student_no,student_name from tb_student where student_no not like 'A%';
--9.
select round(avg(point),1) 평점 from tb_grade group by student_no having student_no='A517178';
--10.
select department_no 학과번호, count(*) "학생수(명)" from tb_student group by department_no order by 1; 
--11.
select count(*) from tb_student where coach_professor_no is null;
--12.
select 년도, round(avg(평점),1) "년도 별 평점" from (select substr(term_no,1,4) 년도, point 평점 from tb_grade where student_no='A112113') group by 년도 order by 1;

--13.
select department_no 학과코드명, count(case when absence_yn='Y' then 1 end) "휴학생 수" from tb_student group by department_no order by 1; 

--14.
select student_name 동일이름, count(*) from tb_student group by student_name having count(*)>1;
--15.
select substr(term_no,1,4) 년도, substr(term_no,5,2) 학기, point 평점 from tb_grade where student_no='A112113';
select substr(term_no,1,4) 년도, null 학기, round(avg(point),1) 평점 from (select * from tb_grade where student_no='A112113') group by substr(term_no,1,4);

select substr(term_no,1,4) 년도, substr(term_no,5,2) 학기, point 평점 from tb_grade where student_no='A112113'
union select substr(term_no,1,4) 년도, ' ' 학기, round(avg(point),1) 평점 from (select * from tb_grade where student_no='A112113') group by substr(term_no,1,4) ;

--[Additional Select - Option]
--1.
select student_name "학생 이름", student_address 주소지 from tb_student order by 1;
--2.
select student_name, student_ssn from tb_student where absence_yn='Y' order by substr(student_ssn,1,6) desc;
--3.
select student_name 학생이름, student_no 학번, student_address "거주지 주소" from tb_student
where (student_address like '경기도%' or student_address like '강원도%') and student_no not like 'A%' order by 1;
--4.
select professor_name, professor_ssn from tb_professor where department_no=(select department_no from tb_department where department_name='법학과') order by 2;
--5.
select student_no, point from tb_grade where term_no='200402' and class_no='C3118100' order by 2 desc, 1 ;
--6.
select student_no, student_name, department_name from tb_student join tb_department 
on tb_student.department_no=tb_department.department_no order by 2;
--7.
select class_name, department_name from tb_class c join tb_department d on c.department_no=d.department_no;
--8.
select class_name, professor_name from tb_class c join tb_class_professor cp on c.class_no=cp.class_no 
join tb_professor p on cp.professor_no=p.professor_no;
--9.
select class_name, professor_name from tb_class c join tb_class_professor cp on c.class_no=cp.class_no 
join tb_professor p on cp.professor_no=p.professor_no 
where c.department_no in (select department_no from tb_department where category='인문사회');
--10. **
select tb_grade.student_no 학번, student_name "학생 이름", round(avg(point),1) "전체 평점" from tb_student join tb_grade on tb_student.student_no=tb_grade.student_no 
where department_no=(select department_no from tb_department where department_name='음악학과') group by tb_grade.student_no;
select tb_grade.student_no 학번, student_name "학생 이름", round(avg(point),1) "전체 평점" from tb_student join tb_grade on tb_student.student_no=tb_grade.student_no 
group by tb_grade.student_no;

select student_no 학번, (select student_name from tb_student where student_no=tb_grade.student_no) "학생 이름",round(avg(point),1) "전체 평점" from tb_grade group by student_no
having STUDENT_NO in (select student_no from tb_student where department_no=(select department_no from tb_department where department_name='음악학과'));
--11.
select department_name 학과이름, student_name 학생이름, professor_name 지도교수이름 from tb_department d join tb_student s
on d.department_no=s.department_no join tb_professor on coach_professor_no=professor_no where student_no='A313047';
--12.
select student_name, term_no from tb_student s join tb_grade g on s.student_no=g.student_no 
where term_no like '2007%' and class_no=(select class_no from tb_class where class_name='인간관계론');
--13.
select class_name, department_name from tb_class c join tb_department d on c.department_no=d.department_no
where category='예체능' and class_no not in (select class_no from tb_class_professor);
--14.
select student_name 학생이름, nvl(professor_name,'지도교수 미지정') 지도교수 from tb_student left join tb_professor 
on tb_student.coach_professor_no=tb_professor.professor_no where tb_student.department_no=(select department_no from tb_department where department_name='서반아어학과');
--15. ***
select student_no 학번, student_name 이름, (select department_name from tb_department where tb_student.department_no=department_no) "학과 이름", 
(select avg(point) from tb_grad
e where tb_student.student_no=student_no group by student_no) 평점 from tb_student where absence_yn='N' and (select avg(point) from tb_grade where tb_student.student_no=student_no group by student_no)>=4.0;
--1) 4.0 이상인 사람 중 휴학 아닌
select student_no 학번, student_name 이름, department_name "학과 이름", avg(point) 평점 from ;
--2) 휴학 아닌사람 중 4.0 이상인
select student_no 학번, student_name 이름, department_name "학과 이름" from tb_student;

--16. *
select c.class_no, class_name, avg(point) from tb_class c join tb_grade g on c.class_no=g.class_no 
where department_no = (select department_no from tb_department where department_name='환경조경학과') and class_type like '전공%' group by c.class_no,class_name;
--17.
select student_name, student_address from tb_student where department_no=(select department_no from tb_student where student_name='최경희');
--18. ***
select student_no, student_name from tb_student join tb_grade using(student_no) join tb_department using(department_no)
where department_name='국어국문학과' group by student_no,student_name;

SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT JOIN TB_GRADE USING(STUDENT_NO) JOIN TB_DEPARTMENT USING(DEPARTMENT_NO) 
WHERE DEPARTMENT_NAME = '국어국문학과' GROUP BY STUDENT_NO, STUDENT_NAME 
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT)) FROM TB_GRADE 
JOIN TB_STUDENT USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '국어국문학과'
GROUP BY STUDENT_NO);

--19. 
select d.department_name "계열 학과명", round(avg(point),1) 전공평점 from tb_class c join tb_department d on c.department_no=d.department_no
join tb_grade g on c.class_no=g.class_no where category = (select category from tb_department where department_name='환경조경학과') 
and class_type like '전공%' group by department_name;

--[DDL]
--1.
create table tb_category(
    name varchar2(10),
    use_yn char(1) default 'Y'
);
--2.
create table tb_class_type(
    no varchar2(5) primary key,
    name varchar2(10)
);
--3.
alter table tb_category add constraint category_pk primary key(name);
--4.
alter table tb_class_type modify name not null;
--5.
alter table tb_category modify name varchar(20);
alter table tb_class_type modify no varchar(10);
alter table tb_class_type modify name varchar(20);
--6.
alter table tb_category rename column name to category_name;
alter table tb_class_type rename column no to class_type_no;
alter table tb_class_type rename column name to class_type_name;
--7.
alter table tb_category rename constraint category_pk to pk_category_name;
alter table tb_class_type rename constraint SYS_C007099 to pk_class_type_no;
--8.
insert into tb_category values('공학','Y');
insert into tb_category values('자연과학','Y');
insert into tb_category values('의학','Y');
insert into tb_category values('예체능','Y');
insert into tb_category values('인문사회','Y');
commit;
--9.
alter table tb_department add constraint fk_department_category foreign key(category) references tb_category(category_name);
select * from user_constraints where table_name='TB_DEPARTMENT';
--10.
create view VW_학생일반정보 as select student_no 학번, student_name 학생이름, student_address 주소 from tb_student;
--11.
create view VW_지도면담 as select s.student_name 학생이름, d.department_name 학과이름, p.professor_name 지도교수이름
from tb_student s left join tb_department d on s.department_no=d.department_no left join tb_professor p on s.coach_professor_no=p.professor_no order by 2;
--12.
create view VW_학과별학생수 as select department_name, count(student_no) student_count 
from tb_student right join tb_department on tb_student.department_no=tb_department.department_no group by department_name order by 1;
--13.
update VW_학생일반정보 set 학생이름='김신희' where 학번='A213046';
select * from VW_학생일반정보;
--14.
--view를 이용하는 사용자에게 resource가 아닌 select 권한만 부여한다?
--grant select on VW_학생일반정보 to user;
--혹은
drop view VW_학생일반정보;

create view VW_학생일반정보 as select student_no 학번, student_name 학생이름, student_address 주소 from tb_student
with read only; --라고 제한하여 생성하기

grant select on VW_학생일반정보 to student;

--15. ?


select * from user_views;
--[DML]
--1.
insert into tb_class_type values(01,'전공필수');
insert into tb_class_type values(02,'전공선택');
insert into tb_class_type values(03,'교양필수');
insert into tb_class_type values(04,'교양선택');
insert into tb_class_type values(05,'논문지도');
select * from tb_class_type;
--2.
create table tb_학생일반정보 as select student_no 학번, student_name 학생이름, student_address 주소 from tb_student;
--3.
create table tb_국어국문학과 as select student_no 학번, student_name 학생이름, 1900+substr(student_ssn,1,2) 출생년도, nvl((select professor_name from tb_professor where professor_no=coach_professor_no),'없음') 교수이름 from tb_student;
commit;
--4.
update tb_department set capacity = round(capacity*1.1);
--5.
update tb_student set student_address='서울시 종로구 숭인동 181-21' where student_no='A413042';
--6.
update tb_student set student_ssn=substr(student_ssn,1,6);
--7.
update tb_grade set point='3.5' where term_no='200501' 
and student_no=(select student_no from tb_student where student_name='김명훈' 
and department_no=(select department_no from tb_department where department_name='의학과'))
and class_no=(select class_no from tb_class where class_name='피부생리학');
--8.
delete from tb_grade where student_no in (select student_no from tb_student where absence_yn='Y');
select * from tb_grade where student_no in (select student_no from tb_student where absence_yn='Y');

select student_name from tb_student where department_no=(select department_no from tb_department where department_name='동서의료공학과');

desc tb_class_type;
desc tb_category;
select * from user_tables;
select * from user_constraints;
select * from user_constraints where table_name='TB_CATEGORY';
select * from user_constraints where table_name='TB_CLASS_TYPE';


select * from tb_class;
select * from tb_class_professor;
select * from tb_department;
select * from tb_grade;
select * from tb_professor;
select * from tb_student;