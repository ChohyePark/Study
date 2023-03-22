--[Basic Select]
--1.
select department_name "�а� ��", category "�迭" from tb_department;
--2.
select department_name||'�� ������ ' ||capacity||'�� �Դϴ�.' "�а��� ����" from tb_department;
--3. 
select student_name from tb_student where department_no=(select department_no from tb_department where department_name='������а�')
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
select student_no, student_name, student_ssn from tb_student where substr(student_no,1,2)='A2' and student_address like '���ֽ�%' and absence_yn='N';

--[Additional Select - �Լ�]
--1.
select student_no �й�, student_name �̸�, to_char(entrance_date,'YYYY-MM-DD') ���г⵵ from tb_student where department_no='002' order by 3;
--2.
select professor_name, professor_ssn from tb_professor where length(professor_name) !=3;
--3.
select professor_name �����̸�, floor((sysdate-to_date(19000000+(substr(professor_ssn,1,6)),'YYYYMMDD'))/365) ���� from tb_professor where substr(professor_ssn,8,1)=1 order by 2;
--4.
select substr(professor_name,2,2) �̸� from tb_professor;
--5.
select student_no, student_name from tb_student where ((entrance_date-to_date(19000000+substr(student_ssn,1,6),'YYYYMMDD'))/365)>19;

select student_name, floor((entrance_date-to_date(19000000+substr(student_ssn,1,6),'YYYYMMDD'))/365) ���г��� from tb_student;

--6.
select to_char(to_date('20201225','YYYYMMDD'),'DY')||'����' "2020�� ũ��������" from dual;
--7.
select to_char(to_date('99/10/11','YY/MM/DD'),'YYYY"��"MM"��"DD"��"') "1", to_char(to_date('49/10/11','YY/MM/DD'),'YYYY"��"MM"��"DD"��"') "2", 
to_char(to_date('99/10/11','RR/MM/DD'),'YYYY"��"MM"��"DD"��"') "3", to_char(to_date('49/10/11','RR/MM/DD'),'YYYY"��"MM"��"DD"��"') "4" from dual;
--8.
select student_no,student_name from tb_student where student_no not like 'A%';
--9.
select round(avg(point),1) ���� from tb_grade group by student_no having student_no='A517178';
--10.
select department_no �а���ȣ, count(*) "�л���(��)" from tb_student group by department_no order by 1; 
--11.
select count(*) from tb_student where coach_professor_no is null;
--12.
select �⵵, round(avg(����),1) "�⵵ �� ����" from (select substr(term_no,1,4) �⵵, point ���� from tb_grade where student_no='A112113') group by �⵵ order by 1;

--13.
select department_no �а��ڵ��, count(case when absence_yn='Y' then 1 end) "���л� ��" from tb_student group by department_no order by 1; 

--14.
select student_name �����̸�, count(*) from tb_student group by student_name having count(*)>1;
--15.
select substr(term_no,1,4) �⵵, substr(term_no,5,2) �б�, point ���� from tb_grade where student_no='A112113';
select substr(term_no,1,4) �⵵, null �б�, round(avg(point),1) ���� from (select * from tb_grade where student_no='A112113') group by substr(term_no,1,4);

select substr(term_no,1,4) �⵵, substr(term_no,5,2) �б�, point ���� from tb_grade where student_no='A112113'
union select substr(term_no,1,4) �⵵, ' ' �б�, round(avg(point),1) ���� from (select * from tb_grade where student_no='A112113') group by substr(term_no,1,4) ;

--[Additional Select - Option]
--1.
select student_name "�л� �̸�", student_address �ּ��� from tb_student order by 1;
--2.
select student_name, student_ssn from tb_student where absence_yn='Y' order by substr(student_ssn,1,6) desc;
--3.
select student_name �л��̸�, student_no �й�, student_address "������ �ּ�" from tb_student
where (student_address like '��⵵%' or student_address like '������%') and student_no not like 'A%' order by 1;
--4.
select professor_name, professor_ssn from tb_professor where department_no=(select department_no from tb_department where department_name='���а�') order by 2;
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
where c.department_no in (select department_no from tb_department where category='�ι���ȸ');
--10. **
select tb_grade.student_no �й�, student_name "�л� �̸�", round(avg(point),1) "��ü ����" from tb_student join tb_grade on tb_student.student_no=tb_grade.student_no 
where department_no=(select department_no from tb_department where department_name='�����а�') group by tb_grade.student_no;
select tb_grade.student_no �й�, student_name "�л� �̸�", round(avg(point),1) "��ü ����" from tb_student join tb_grade on tb_student.student_no=tb_grade.student_no 
group by tb_grade.student_no;

select student_no �й�, (select student_name from tb_student where student_no=tb_grade.student_no) "�л� �̸�",round(avg(point),1) "��ü ����" from tb_grade group by student_no
having STUDENT_NO in (select student_no from tb_student where department_no=(select department_no from tb_department where department_name='�����а�'));
--11.
select department_name �а��̸�, student_name �л��̸�, professor_name ���������̸� from tb_department d join tb_student s
on d.department_no=s.department_no join tb_professor on coach_professor_no=professor_no where student_no='A313047';
--12.
select student_name, term_no from tb_student s join tb_grade g on s.student_no=g.student_no 
where term_no like '2007%' and class_no=(select class_no from tb_class where class_name='�ΰ������');
--13.
select class_name, department_name from tb_class c join tb_department d on c.department_no=d.department_no
where category='��ü��' and class_no not in (select class_no from tb_class_professor);
--14.
select student_name �л��̸�, nvl(professor_name,'�������� ������') �������� from tb_student left join tb_professor 
on tb_student.coach_professor_no=tb_professor.professor_no where tb_student.department_no=(select department_no from tb_department where department_name='���ݾƾ��а�');
--15. ***
select student_no �й�, student_name �̸�, (select department_name from tb_department where tb_student.department_no=department_no) "�а� �̸�", 
(select avg(point) from tb_grad
e where tb_student.student_no=student_no group by student_no) ���� from tb_student where absence_yn='N' and (select avg(point) from tb_grade where tb_student.student_no=student_no group by student_no)>=4.0;
--1) 4.0 �̻��� ��� �� ���� �ƴ�
select student_no �й�, student_name �̸�, department_name "�а� �̸�", avg(point) ���� from ;
--2) ���� �ƴѻ�� �� 4.0 �̻���
select student_no �й�, student_name �̸�, department_name "�а� �̸�" from tb_student;

--16. *
select c.class_no, class_name, avg(point) from tb_class c join tb_grade g on c.class_no=g.class_no 
where department_no = (select department_no from tb_department where department_name='ȯ�������а�') and class_type like '����%' group by c.class_no,class_name;
--17.
select student_name, student_address from tb_student where department_no=(select department_no from tb_student where student_name='�ְ���');
--18. ***
select student_no, student_name from tb_student join tb_grade using(student_no) join tb_department using(department_no)
where department_name='������а�' group by student_no,student_name;

SELECT STUDENT_NO, STUDENT_NAME FROM TB_STUDENT JOIN TB_GRADE USING(STUDENT_NO) JOIN TB_DEPARTMENT USING(DEPARTMENT_NO) 
WHERE DEPARTMENT_NAME = '������а�' GROUP BY STUDENT_NO, STUDENT_NAME 
HAVING AVG(POINT) = (SELECT MAX(AVG(POINT)) FROM TB_GRADE 
JOIN TB_STUDENT USING(STUDENT_NO)
JOIN TB_DEPARTMENT USING(DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '������а�'
GROUP BY STUDENT_NO);

--19. 
select d.department_name "�迭 �а���", round(avg(point),1) �������� from tb_class c join tb_department d on c.department_no=d.department_no
join tb_grade g on c.class_no=g.class_no where category = (select category from tb_department where department_name='ȯ�������а�') 
and class_type like '����%' group by department_name;

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
insert into tb_category values('����','Y');
insert into tb_category values('�ڿ�����','Y');
insert into tb_category values('����','Y');
insert into tb_category values('��ü��','Y');
insert into tb_category values('�ι���ȸ','Y');
commit;
--9.
alter table tb_department add constraint fk_department_category foreign key(category) references tb_category(category_name);
select * from user_constraints where table_name='TB_DEPARTMENT';
--10.
create view VW_�л��Ϲ����� as select student_no �й�, student_name �л��̸�, student_address �ּ� from tb_student;
--11.
create view VW_������� as select s.student_name �л��̸�, d.department_name �а��̸�, p.professor_name ���������̸�
from tb_student s left join tb_department d on s.department_no=d.department_no left join tb_professor p on s.coach_professor_no=p.professor_no order by 2;
--12.
create view VW_�а����л��� as select department_name, count(student_no) student_count 
from tb_student right join tb_department on tb_student.department_no=tb_department.department_no group by department_name order by 1;
--13.
update VW_�л��Ϲ����� set �л��̸�='�����' where �й�='A213046';
select * from VW_�л��Ϲ�����;
--14.
--view�� �̿��ϴ� ����ڿ��� resource�� �ƴ� select ���Ѹ� �ο��Ѵ�?
--grant select on VW_�л��Ϲ����� to user;
--Ȥ��
drop view VW_�л��Ϲ�����;

create view VW_�л��Ϲ����� as select student_no �й�, student_name �л��̸�, student_address �ּ� from tb_student
with read only; --��� �����Ͽ� �����ϱ�

grant select on VW_�л��Ϲ����� to student;

--15. ?


select * from user_views;
--[DML]
--1.
insert into tb_class_type values(01,'�����ʼ�');
insert into tb_class_type values(02,'��������');
insert into tb_class_type values(03,'�����ʼ�');
insert into tb_class_type values(04,'���缱��');
insert into tb_class_type values(05,'������');
select * from tb_class_type;
--2.
create table tb_�л��Ϲ����� as select student_no �й�, student_name �л��̸�, student_address �ּ� from tb_student;
--3.
create table tb_������а� as select student_no �й�, student_name �л��̸�, 1900+substr(student_ssn,1,2) ����⵵, nvl((select professor_name from tb_professor where professor_no=coach_professor_no),'����') �����̸� from tb_student;
commit;
--4.
update tb_department set capacity = round(capacity*1.1);
--5.
update tb_student set student_address='����� ���α� ���ε� 181-21' where student_no='A413042';
--6.
update tb_student set student_ssn=substr(student_ssn,1,6);
--7.
update tb_grade set point='3.5' where term_no='200501' 
and student_no=(select student_no from tb_student where student_name='�����' 
and department_no=(select department_no from tb_department where department_name='���а�'))
and class_no=(select class_no from tb_class where class_name='�Ǻλ�����');
--8.
delete from tb_grade where student_no in (select student_no from tb_student where absence_yn='Y');
select * from tb_grade where student_no in (select student_no from tb_student where absence_yn='Y');

select student_name from tb_student where department_no=(select department_no from tb_department where department_name='�����Ƿ���а�');

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