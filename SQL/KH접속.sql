desc employee;
--describe: employee table�� ���� �����϶�.

-- << select query�� ���ʹ��� ���� >>

select emp_name,phone,emp_no from employee; 
-- employee table���� �ش� column�� data ���
select * from employee; 
--��� colume data ���

--����: select �÷��� from ���̺�� where ���ǹ�;

select emp_id,emp_name from employee where emp_id = 207;
--where : for�� ������ if�� �������� �Ͱ� ����

--quiz01. 
--1. Employee ���̺� �����ϴ� ��� ������ ���, �̸�, �޿��� ����غ���
select emp_id,emp_name,salary from employee;
--2. ���� �� D9 �μ��� �����ִ� �������� ���, �̸�, �μ��ڵ带 ����غ���
select emp_id,emp_name,dept_code from employee where dept_code='D9';


select * from employee where salary>5000000;
select * from job;
select * from department;

--quiz02.
--���� �� �޿��� 200���� ���Ϸ� �޴� ������ �̸�, �μ��ڵ�, �����ڵ带 ����غ���
select emp_name,dept_code,job_code,salary from employee where salary<=2000000;

--and, or ���
select * from location;
select * from employee where salary<=3000000 and dept_code='D6';

--quiz03.
--�޿��� 200~300�� ������ ������ ���, �̸�, �޿�, �����ڵ带 ����غ���
select emp_id,emp_name,salary,job_code from employee where 2000000<=salary and salary<=3000000;
-- ** ���� ���� ���� ������ �Ʒ��� ���� ǥ���� �� �ִ�. 
select emp_id,emp_name,salary,job_code from employee where salary between 2000000 and 3000000;

--quiz04.
--employee ���̺��� ���� �� �����ڵ尡 J3�̸鼭 �޿��� 350���� �̻��� ������ �̸��� ��ȭ��ȣ�� ����غ���
select emp_name,phone from employee where job_code='J3' and salary>=3500000;

--quiz05.
--employee ���̺��� ���� �� �μ��ڵ尡 D5�̰ų� D6�̰ų� D9�� ������ �̸��� �μ��ڵ带 ����غ���
select emp_name,dept_code from employee where dept_code='D5' or dept_code='D6' or dept_code='D9';
-- ** ���� ���� or �ݺ� ������ �Ʒ��� ���� ǥ���� �� �ִ�. 
select emp_name,dept_code from employee where dept_code in ('D5','D6','D9');

--�μ��ڵ忡 null���� ����ִ� ���� ����� ����ϰ� �ʹٸ� (null�� �ƴѻ���� ����ϰ������ is not null)
select emp_id,emp_name from employee where dept_code is null;

-- ** alias (as) : ��Ī ����
select emp_name �����,salary*12 as "����",'��' as "����" from employee;
--�����Ϳ��� �ȿ� ���� �� Ȭ����ǥ, �ۿ� �ִ°� �ֵ���ǥ

-- ** sysdate : ���� ��¥ �� �ð��� ��ȯ(date��)
select sysdate from dual; 
-- �ѹ��� ���� ������ �⺻���� ����Ǿ��ִ� dual table �̿��ϱ�

select sysdate+50 from dual; --��¥Ÿ���� +,-���굵 �����ϴ�.
-- ��¥Ÿ�԰� ��¥Ÿ���� �����ϸ� �� ��¥ ������ ������ ��ȯ��

select emp_name �����,hire_date �Ի���,floor(sysdate-hire_date) || '��' �ٹ��ϼ� from employee;
--floor()�Լ�, || �̾���̱�

--quiz06.
--employee ���̺��� �ټӳ���� 20�� �̻� �� ������ �̸�, ����, ���ʽ����� ����غ���
select 
    emp_name �����,
    salary||'��' ����,
    bonus ���ʽ���,
    floor((sysdate-hire_date)/365)||'��' as "�ټӳ��" 
from 
    employee 
where 
    (sysdate-hire_date)/365>=20;
--��� ������ �̸�, ����, �Ǽ��ɾ�(����-����*3%)�� ����غ���
select emp_name �����,salary*12||'��' ����,salary*12-salary*12*0.03||'��' �Ǽ��ɾ� from employee;

--��¥���� between ��� ����
select * from employee 
    where hire_date between '00/01/01' and '05/12/31';

-- ** like (contains�� ���) ~%~ (%: ������ �ְų� ���� ���� ����) 
select * from employee where emp_name like '��%';
select * from employee where emp_name like '%��%';
select * from employee where emp_name like '%��_';
-- �����(_)�� ��밡��: ����� �ڸ��� �ݵ�� �� ���ڰ� �����ؾ� �Ѵٴ� �ǹ�. �ΰ� ���� �α���
-- not like��� ���� �ݴ�� �ش� ���ڸ� �������� �ʴ� ����� ����Ѵٴ� �ǹ�.
select * from employee where emp_name not like '%��%';

--quiz07.
--1.��� �����߿� ��ȭ��ȣ ó�� ���ڸ��� 010�� �ƴ� ������ �̸��� ��ȭ��ȣ ����غ���
select emp_name �����,phone ��ȭ��ȣ from employee where phone not like '010%';
--2.��� �����߿��� �̸��� '��'�� ���� ����� ��� ã�� �̸��� ����غ���
select emp_name as "�����" from employee where emp_name like '%��%';
--3.��� �����߿��� �μ��ڵ尡 D9 �Ǵ� D6�̰�, ������ 270���� �̻��̸�, email�� s�� ���ԵǾ��ְ�,
--������� 2001�� 1��1��~2005�� 12��31�� ������ ������ �̸�,�μ��ڵ�,�޿�,email,������� ����غ���
select emp_name �����,dept_code �μ��ڵ�,salary||'��' �޿�,email �̸���,hire_date ����� 
    from employee 
    where 
        dept_code in ('D6','D9') 
        and salary>=2700000 
        and email like '%s%'
        and hire_date between '01/01/01' and '05/12/31';
        
--quiz08.
--1.���ӻ��(manager_id)�� ���� �μ���ġ�� ���� ���� ������ ����� �̸� ����غ���
select emp_id ���,emp_name ����� from employee where manager_id is null and dept_code is null;
--2.�μ���ġ�� ���� �ʾ����� ���ʽ��� ���޵Ǵ� ������ �μ��ڵ�,�̸�,���ʽ��� ����غ���
select dept_code �μ��ڵ�,emp_name �����,bonus ���ʽ� from employee where dept_code is null and bonus is not null;

--order by : query ���� ������� Ư�������� �̿��� �����͸� �����ϴ� ����
select emp_id,emp_name,dept_code,salary from employee order by dept_code nulls last, salary desc; 
select emp_id,emp_name,salary from employee order by 3 desc; 
----default�� ��������(asc), ���������� desc, nulls first/last, column ��ȣ�� order ����
--���ļ����� �߿���

--quiz09.
--1.�ټӳ�� 5�� �̻�, 10�� ������ ������ �̸�,�ֹι�ȣ,�޿�,�Ի����� �˻��ϼ���.
select emp_name �����, emp_no �ֹι�ȣ,salary �޿�,hire_date �Ի��� from employee 
    where 5<=(sysdate-hire_date)/365 and (sysdate-hire_date)/365<=10;
    
--2.�������� �ƴ� ������ �̸�,�μ��ڵ带 �˻��ϼ���. (��� ���� : ENT_YN)
select emp_name �����,dept_code �μ��ڵ� from employee 
    where ent_yn='Y';
    
--3.�ټӳ���� 10�� �̻��� �������� �˻��Ͽ� ��� ����� �̸�,�޿�,�ټӳ��(�Ҽ���X)�� �ټӳ�� ������������ �����Ͽ� ����ϼ���.
--��, �޿��� 50% �λ�� �޿��� ��µǵ��� �ϼ���.
select emp_name �����,salary*1.5||'��' �޿�,floor((sysdate-hire_date)/365)||'��' �ټӳ�� from employee 
    where (sysdate-hire_date)/365>=10 order by 3;
    
--4.�Ի����� 99/01/01 ~ 10/01/01 �� ��� �߿��� �޿��� 2000000 �� ������ ����� �̸�,�ֹι�ȣ,�̸���,����ȣ,�޿��� ����ϼ���.
select emp_name �����,emp_no �ֹι�ȣ,email �̸���,phone ��ȭ��ȣ,salary||'��' �޿� from employee 
    where hire_date between '99/01/01' and '10/01/01' and salary<=2000000;
    
--5.�޿��� 2000000�� ~ 3000000�� �� ������ �߿��� 4�� �����ڸ� �˻��Ͽ� �̸�,�ֹι�ȣ,�޿�,�μ��ڵ带 �ֹι�ȣ ������������ ����ϼ���.
--(��, �μ��ڵ尡 null�� ����� �μ��ڵ尡 '����' ���� ��� �ϼ���.)
select emp_name �����,emp_no �ֹι�ȣ,salary||'��' �޿�,NVL(dept_code, '����') �μ��ڵ� from employee 
    where 2000000<=salary and salary<=3000000 and emp_no like '%04%-%' order by emp_no desc;
    
--6.���� ��� �� ���ʽ��� ���� ����� ���ñ��� �ٹ����� �����Ͽ� 1000�� ����(�Ҽ��� ����) 
--�޿��� 10% ���ʽ��� ����Ͽ� �̸�,Ư�� ���ʽ� (��� �ݾ�) ����� ����ϼ���. ��, �̸� ������ ���� ���� �����Ͽ� ����ϼ���.? 
select emp_name �����,salary*0.1*floor((sysdate-hire_date)/1000)||'��' "Ư�� ���ʽ�" from employee
    where emp_no like '%-1%' and bonus is null order by emp_name;
    
--0215---------------------------------------------------------------------------
-- ** function() == method()

--���� ���� �Լ�
-- nvl(), length(), lengthb(), instr(), substr()
select length('�ȳ��ϼ���') from dual;
select lengthb('�ȳ��ϼ���') from dual; -- �ѱ��� �� ���ڴ� 3byte
select instr('Hello World Hello Human','H',2,2) from dual;
select substr('����������ٶ�ϰ�',6,4) from dual;

select * from employee;
--quiz01.
--1. ������ܿ��� �̸��� ���� �����Ͽ� ����غ���
--+) ����� ���� �տ� distinct ���̸� : ��ø�Ǵ� �� ����� �ϳ��� ���� ���
select distinct substr(emp_name,1,1) from employee; 
--2. ������ܿ��� �����ȣ, �����, �ֹι�ȣ, ������ ����غ���
--��, like�� ������� �ʰ� ���������� ������ �ֹι�ȣ �� 6�ڸ��� *��ȣ�� ����غ���
select emp_id �����ȣ, emp_name �����, substr(emp_no,1,8)||'******' �ֹι�ȣ, salary*12||'��' ���� 
    from employee where substr(emp_no,8,1)='1';
 
 --���� ���� �Լ�   
-- abs(), mod(), round(), floor(), trunc(), ceil()
select abs(-9) from dual;
select mod(10,4) from dual;
select round(3.141592, 3) from dual;
select round(33.141592, -1) from dual;
select trunc(3.141592, 2) from dual;
select ceil(3.141592) from dual;
select ceil(3.141592*10)/10 from dual; -- �Ҽ��� ù°�ڸ����� �ø�
select ceil(3.141592*100)/100 from dual; --�Ҽ��� ��°�ڸ����� �ø�

--��¥ ���� �Լ�
--sysdate,months_between, add_months(), next_day(), last_day(), extract()
select sysdate from dual;
select emp_name, floor(months_between(sysdate,hire_date)) �ټӰ����� from employee;
select add_months(sysdate, 3) from dual;
select sysdate+30 from dual; --���������ϸ� �޸��� �ϼ��� �޶� ��Ȯ�� ��� �����
select next_day('23/03/01', '��') from dual;
select last_day(sysdate) from dual;
select extract(year from sysdate) from dual;

--quiz.
--1.���� �� ������ ��¥�� ��ĥ�ϱ��?
select last_day('23/03/01') from dual;
select last_day(add_months(sysdate,1)) from dual;
--2.���, �����, �Ի�⵵(~~��) �������� ����غ���
select emp_id ���,emp_name �����,extract(year from hire_date)||'��' �Ի�⵵ from employee;
--3.������ܿ��� ����� �̸�, �Ի���, ������ �Ի��� ������������ ����غ���(����-> �Ҽ����� ��� �ø����� ���)
select emp_name �����, hire_date �Ի���, ceil((sysdate - hire_date)/365) ���� from employee order by hire_date;

-- ���� �Լ�
--to char()
select to_char(sysdate, 'YYYY"��"MM"��"DD"��" (DY) "����ð� : "HH:MI:SS WW RR') ���� from dual;
select to_char(100000000, '9,9999,9999L') ���� from dual; -- ������ ���ϴ� ��ġ�� ���� �� ����
--quiz.
--�����, �����(1990/02/06(ȭ)) ���·� ����غ���
select emp_name �����, to_char(hire_date,'YYYY/MM/DD(DY)') ����� from employee;

-- ** to_date()
select to_date('20180208','YYYYMMDD')-5 ���� from dual;

--quiz.
--1945�� 8�� 15���� ������?
select to_char(sysdate, 'DY') from dual;
select to_char(to_date('19450815'), 'DY')||'����' "������ ����" from dual;

select sysdate - to_date('08272018','MMDDYYYY') from dual; --������ �޶� ��갡���ϳ�

--decode()
select decode('Orange','Apple','���','Orange','������','Banana','�ٳ���') from dual;

--quiz
--�����ȣ, �����, ����(��,��) ���·� ����غ���
select emp_id ���,emp_name �����,decode(substr(emp_no,8,1),1,'��',2,'��') ���� from employee;

-- case(), �� ��� case�Լ��� �Ἥ �Ʒ��� ���� ����� �� ����
select 
    emp_id,     
    emp_name, 
    case 
        when substr(emp_no,8,1)='1' then '��' 
        when substr(emp_no,8,1)='2' then '��' 
        else '??'    
    end ���� 
from employee;

--quiz
--60���� ������ �߿��� 60~64��� �������� 60��� �ʹ�, 65~69��� �������� 60��� �Ĺ��̶�� ����غ���
select emp_id ���,emp_name ���,
    case 
        when substr(emp_no,1,2) < 65 then '60��� �ʹ�' 
        when 65<=substr(emp_no,1,2) then '60��� �Ĺ�'
    end "���̴�"
from employee where substr(emp_no,1,1)=6 ; --substr(emp_no,1,2) between 60 and 69 �ε� �ۼ�����

-- ��������� ��� ������ �Լ�
-------------------------
--�׷��Լ�(sum, avg, count, max, min ..)
select to_char(sum(salary),'999,999,999')||'��' �޿��հ� from employee;
select to_char(avg(salary),'999,999,999')||'��' ��ձ޿� from employee;
select count(salary)||'��' ������ from employee;
select to_char(max(salary),'999,999,999')||'��' �ִ�޿� from employee;
select to_char(min(salary),'999,999,999')||'��' �ּұ޿� from employee;

--quiz
--1.
select to_char(avg(salary),'999,999,999')||'��' �޿���� from employee where dept_code='D5';
--2.
select to_char(sum(salary),'999,999,999')||'��' �޿��հ� from employee where substr(emp_no,8,1)=1;

select to_char(123456.7890,'999,999.99') from dual;

--������ quiz.
--1.������� �̸��� , �̸��� ���̸� ����ϼ���
select emp_name �̸�, email �̸���, length(email) �̸��ϱ��� from employee;
--2.������ �̸��� �̸��� �ּ��� ���̵� �κи� ����ϼ���
select emp_name �̸�, substr(email,1,instr(email,'@')-1) "ID" from employee;
--3. 60����� ������� ���, ���ʽ� ���� ����ϼ���
--   �׶� ���ʽ� ���� null�� ��쿡�� 0% �̶�� ��� �ǰ� ���弼��
select emp_name ������, substr(emp_no,1,2) ���, nvl(bonus*100,0)||'%' ���ʽ� from employee where substr(emp_no,1,1)=6;
--4. '010' �ڵ��� ��ȣ�� ���� �ʴ� ����� ���� ����ϼ��� (�ڿ� ������ ���� ���̼���)
select count(nvl(phone,'����'))||'��' �ο� from employee where phone is null or substr(phone,1,3) not like '010%'; 
--count()�� null ���� ����
--5.������� �Ի����� ����ϼ���  ex) ������      2012��12��
select emp_name ������,to_char(hire_date,'YYYY"��"MM"��"') �Ի��� from employee;
--6.������� �ֹι�ȣ�� ��ȸ�ϼ���. ��, �ֹι�ȣ 9��° �ڸ����� �������� '*' ���ڷ� ä���� ��� �ϼ���
select emp_name ������,substr(emp_no,1,8)||'******' �ֹι�ȣ from employee;
--7. ������, �����ڵ�, ����(��)�� ��ȸ�ϼ���. (������ ���ʽ�����Ʈ�� ����� 1��ġ �޿���)
--��, ������ ��57,000,000 �� ���� ǥ�õǰ� �� (���� ��ȭ �ܰ� ���� �Ǿ�� ��) 
select emp_name ������,job_code �����ڵ�,to_char(salary*12+nvl(salary*bonus*12,0),'L999,999,999') "����(��)" from employee;
--8. �μ��ڵ尡 D5, D9�� ������ �߿��� 2004�⵵�� �Ի��� ������[ ��� ����� �μ��ڵ� �Ի��� ]�� ��ȸ�ϼ���
select emp_id ���,emp_name �����, dept_code �μ��ڵ�, hire_date �Ի��� from employee where dept_code in ('D5','D9') and substr(to_char(hire_date,'YYYY'),1,4)='2004';
select emp_id ���,emp_name �����, dept_code �μ��ڵ�, hire_date �Ի��� from employee where dept_code in ('D5','D9') and extract(year from hire_date)='2004';
--9.������, �Ի���, ���ñ����� �ٹ��ϼ� ��ȸ�ϼ���. * �ָ��� ���� , �Ҽ��� �Ʒ��� ����
select emp_name ������, hire_date �Ի���, floor(sysdate-hire_date)||'��' �ٹ��ϼ� from employee;
--10.��� ������ ���� �� ���� ���� ���̿� ���� ���� ���̸� ��� �ϼ���. (���̸� ���)
--��� ������ 1900��� ���̶�� �����Ͽ� ����ô�
select max(extract(year from sysdate)-1900-substr(emp_no,1,2)+1)||'��' �ְ��,min(extract(year from sysdate)-1900-substr(emp_no,1,2)+1)||'��' �ֿ��� from employee;
select to_char(100000000, '777,777,777') from dual;
select emp_no from employee;
--11. ȸ�翡�� �߱��� �ؾ� �Ǵ� �μ��� ��ǥ�Ͽ��� �մϴ�. 
--�μ��ڵ尡 D5,D6,D9�̸� �߱�, �׿ܴ� �߱پ��� ���� ��µǵ��� �ϼ���
-- ��� ���� �̸�,�μ��ڵ�,�߱����� (�μ��ڵ� ���� �������� ������.) (�μ��ڵ尡 null�� ����� �߱پ��� ��)? 
select emp_name �̸�, dept_code �μ��ڵ�, decode(dept_code, 'D5', '�߱�', 'D6', '�߱�','D9', '�߱�','�߱پ���') �߱����� from employee order by dept_code;


--** group by : �׷�ȭ �� ������ �ٷ��
select nvl(dept_code,'����') �μ��ڵ�, to_char(sum(salary),'L999,999,999,999') "�μ��� �޿��հ�" from employee group by dept_code order by dept_code;

--quiz
--1.���޺� �޿� ����� ���޺� ������������ �����Ͽ� ����غ���
select nvl(job_code,'intern') ����, to_char(avg(salary),'L999,999,999') "�޿� ���" from employee group by nvl(job_code,'intern') order by ����;
--2.������ ���� �ο��� ����غ���
select decode(substr(emp_no,8,1),1,'��',2,'��') ����, count(*)||'��' �ο��� from employee group by substr(emp_no,8,1);
--3.������ ���� �޿� ��� ����غ���, �ӿ����� ������ ��
select decode(substr(emp_no,8,1),1,'��',2,'��') ����, to_char(avg(salary),'L999,999,999') �޿���� from employee where job_code not in ('J1','J2') group by substr(emp_no,8,1);
--select decode(substr(emp_no,8,1),1,'��',2,'��') ����, to_char(avg(salary),'L999,999,999') �޿���� from employee group by substr(emp_no,8,1);
--4.���̴뺰 �޿� ��� ����غ���, 10���� �������� �ݿø�
select decode(substr(emp_no,1,1),6,'60����',7,'70����',8,'80����') ���̴�,to_char(round(avg(salary),-5),'L999,999,999') �޿���� from employee group by substr(emp_no,1,1) order by 1;

select * from employee;

--group by�� ������ ��ø�� �� ���������� �׷�ȭ�غ���
--quiz
--1.�μ��� ���޺� �ο��� �ľ�
select dept_code, job_code, count(*)||'��' from employee group by dept_code, job_code order by 1,2;
select dept_code, count(*) from employee group by dept_code;
--2.�μ��� ������ �ο��� �ľ�
select nvl(dept_code,'����') �μ�, decode(substr(emp_no,8,1),1,'��',2,'��') ����,count(*)||'��' �ο� from employee group by dept_code, decode(substr(emp_no,8,1),1,'��',2,'��') order by dept_code;

--** having
--where�������� �׷��Լ��� ����� �� ���� ������(��������) �ٸ� ����� ����Ѵ�.
--group by�� ���� �׷�ȭ �� �����Ϳ� ���� ������ ���� ���� having ���� ����Ѵ�~!

----quiz. 
--1. �μ��� �޿���� 300���� �̻��� �μ��� �μ��ڵ� �� �޿������ ����غ���
select dept_code �μ�, to_char(avg(salary),'L999,999,999') �޿� from employee group by dept_code having avg(salary)>=3000000;
--2. �ο��� 3�� �̸��� �����ڵ��� �ο��� ����Ϸ��� �Ѵ�. �ش� ���޿� ���Ͽ� �����ڵ�� �ο��� ����غ���
select job_code �����ڵ�, count(*)||'��' �ο� from employee group by job_code having count(*)<3;

--** join ����
--1. ANSI ǥ�ع���
-- cross join
select * from department cross join job;
-- inner join
select emp_id, emp_name, dept_title from employee inner join department on dept_code = dept_id;
-- +) column ���� ������ ��� ���̺���� �տ� �ٿ��� ��������� �Ѵ�.
-- +) from���� �ҷ��� �� table �� ��Ī�� �ٿ��� �ڵ带 �����ϰ� �� �� �ִ�. ( ��Ī�� �ٿ����� ���� ��� ��Ī���� �����)
select emp_id, emp_name, e.job_code, job_name from employee e
inner join job j on e.job_code = j.job_code;
-- �ٸ� �̷��� join���� �� ������ ���̺� �� �÷����� ������ ��쿡, using�� ����� �� �ִ�!
-- (using�� ����ϸ� ��Ī�� ����� �� ����)
select emp_id, emp_name, job_code, job_name from employee 
inner join job using(job_code) ;
-- outer join : null�� ���� �׸���� ��� ���
select emp_name, nvl(dept_code,'����'), nvl(dept_title,'����') from employee left outer join department on dept_code = dept_id order by 2;
select emp_name, dept_code, dept_title from employee full outer join department on dept_code = dept_id order by 2;
-- ** self join : ���� ���̺��� join�� �� �ִ�.
select * from job cross join job; 
--����) �������� ���� manager_id �Ӹ� �ƴ϶� manager(���) �̸��� ����غ���.
select e1.emp_id ���ID, e1.emp_name �̸�, nvl(e1.manager_id,'����') ���ӻ��ID, nvl(e2.emp_name,'����') ���ӻ���̸� 
from employee e1 left join employee e2 on e1.manager_id = e2.emp_id order by 1; 
select e1.emp_id ���ID, e1.emp_name �̸�, nvl(e1.manager_id,'����') ���ӻ��ID, nvl(e2.emp_name,'����') ���ӻ���̸� 
from employee e1 cross join employee e2 order by 1; 

--2. Oracle ���빮��
-- cross join (cartesian product�� ������.)
select * from department, job; 
-- inner join (cartesian product �߿��� Ư�� ������ �����ϴ� ���ڵ常 ����)
-- null���� ���� �׸��� ������ �� ����. (--> outer join���� null���� ������ �� ����)
select emp_id, emp_name, dept_title from employee, department where dept_code = dept_id;
select emp_id, emp_name, dept_title from employee, department;


--quiz.
--1. ��������� ������� �̸�, �μ��ڵ�, �޿� ����غ���
select emp_name, dept_code, salary from employee, department where dept_code=dept_id and dept_title = '���������';
select emp_name, dept_code,dept_title, salary from employee inner join department on dept_code=dept_id and dept_title = '���������';
--2. �ؿܿ���n�� �������� ���, �����, �μ���, ���� ����غ���
select emp_id ���, emp_name �����, dept_title �μ���, to_char(salary*12,'L999,999,999') ���� 
from employee inner join department on dept_code=dept_id and dept_code in ('D5','D6','D7');
--�Ǵ�
select emp_id ���, emp_name �����, dept_title �μ���, to_char(salary*12,'L999,999,999') ���� 
from employee inner join department on dept_code=dept_id where dept_title like '�ؿܿ���%';
--3. self join ���빮��. 
--���������� ���� �μ����� ���ϴ� �������� �̸�, �μ��ڵ�, �����ڵ带 ����غ���(���� �� �̸��� �ٲٸ� �ٸ�������� ��°���)
select e2.emp_name, e2.dept_code, e2.job_code from employee e1 join employee e2 on e1.dept_code=e2.dept_code where e1.emp_name='������';

-- ���� join : 3�� �̻��� ���̺� join
-- �����, �μ���, ���޸��� �Բ� ����غ���
select e.emp_name, d.dept_title, j.job_name 
from employee e full join department d on e.dept_code=d.dept_id 
join job j on e.job_code = j.job_code order by e.job_code;

--quiz
--�����, �μ���, �ٹ�����(national code)�� ����غ���
select e.emp_name,d.dept_title,l.national_code,n.national_name 
from employee e left join department d on e.dept_code=d.dept_id
left join location l on d.location_id=l.local_code
left join national n on l.national_code=n.national_code ;

--- �� ���� quiz
-- 1. 2020�� 12�� 25���� ���� �������� ��ȸ�ϼ���.
select to_char(to_date('20/12/25'),'DY')||'����' "20.12.25 ����" from dual;
-- 2. �ֹι�ȣ�� 1970��� ���̸鼭 ������ �����̰�, ���� ������ �������� �����, �ֹι�ȣ, �μ���, ���޸��� ��ȸ�ϼ���.
 select e.emp_name �����,e.emp_no �ֹι�ȣ,d.dept_title �μ���,j.job_name ���޸� from employee e join department d on e.dept_code=d.dept_id
 join job j on e.job_code=j.job_code where substr(emp_no,1,1)=7 and substr(emp_no,8,1)=2 and substr(emp_name,1,1)='��';
-- 3. �̸��� "��"�ڰ� ���� �������� ���, �����, �μ����� ��ȸ�ϼ���.
select emp_id ���,emp_name �����, dept_title �μ��� from employee join department on dept_code=dept_id where emp_name like '%��%';
-- 4. �μ��� �޿� ����� 300���� ������ �μ��� �μ���� �޿� ����� ����ϼ���
-- > �޿� ����� 10000�� �ڸ� �Ʒ��� ������ ������ּ���. 
-- > ���� �ѱ� ���� ��ȭ ǥ������� ������ּ���. (��3,520,000)
select nvl(dept_title,'����') �μ���, to_char(trunc(avg(salary),-4),'L999,999,999') �޿���� from employee left join department
on nvl(dept_code,'0')=nvl(dept_id,'0') group by dept_title having avg(salary)<=3000000;
-- 5. �ؿܿ����ο� �ٹ��ϴ� �����, ���޸�, �μ��ڵ�, �μ����� ��ȸ�ϼ���.
select emp_name �����,job_name ���޸�, dept_code �μ��ڵ�, dept_title �μ��� 
from employee e join job j on e.job_code=j.job_code
join department d on e.dept_code=d.dept_id where dept_title like '�ؿܿ���%';
-- 6. ���ʽ�����Ʈ�� �޴� �������� �����, ���ʽ�����Ʈ, �μ���, �ٹ��������� ��ȸ�ϼ���.
select emp_name �����,bonus ���ʽ�����Ʈ,nvl(dept_title,'����') �μ���, nvl(local_name,'����') �ٹ������� 
from employee left join department on dept_code=dept_id
left join location on location_id=local_code 
where bonus is not null;
-- 7. �μ��ڵ尡 D2�� �������� �����, ���޸�, �μ���, �ٹ��������� ��ȸ�ϼ���.
select emp_name �����,job_name ���޸�, dept_title �μ���, local_name �ٹ������� 
from employee join job on employee.job_code=job.job_code
join department on dept_code=dept_id
join location on location_id=local_code
where dept_code='D2';
-- 8. �ѱ�(KO)�� �Ϻ�(JP)�� �ٹ��ϴ� �������� �����, �μ���, �ٹ�������, �������� ��ȸ�ϼ���.
select nvl(emp_name,'����') �����, dept_title �μ���, local_name �ٹ�������, national_name ������
from employee full join department on dept_code=dept_id
join location on location_id=local_code
join national on location.national_code=national.national_code
where national.national_code in ('KO','JP');
-- 9. ��� ��� �� �������� �Ŵ����� �ΰ� �ִ� ������ �̸�, ������ �μ���, �Ŵ����� �̸��� ����ϼ���.
select e1.emp_name �̸�, dept_title �μ���, e2.emp_name "�Ŵ��� �̸�"
from employee e1 join employee e2 on e1.manager_id=e2.emp_id
join department on e1.dept_code=dept_id
where e2.emp_name='������';
-- 10. ���ʽ�����Ʈ�� ���� ������ �߿��� ������ ����� ����� �������� �����, ���޸�, �޿��� ��ȸ�ϼ��� (join�� in ���)
select emp_name �����, job_name ���޸�, to_char(salary,'L9,999,999') �޿�
from employee join job on employee.job_code=job.job_code
where bonus is null and job_name in ('����','���');
-- 11. �������� ������ ����� ������ ���� ��ȸ�ϼ���.
select decode(ent_yn,'Y','���','N','������') ��������,count(*)||'��' �ο� from employee group by ent_yn;

----0220------------------------------------------
--union : �⺻������ �� ���̺� ���� ������
select dept_id from department union 
select bonus from employee; --Į�� ��, ������Ÿ���� ���ƾ��Ѵ�.

create table A(data number); -- ��ü(���̺�) ����
insert into A values(1); -- ���̺� �� �߰�
insert into A values(2);
insert into A values(3);
select * from A;
--drop table A; -- ���̺� ����

create table B(data number);
insert into B values(2);
insert into B values(3);
insert into B values(4);
select * from B;

select * from A union select * from B; -- �׳� union�� �� ���̺� �� �ߺ��� ���� �ִٸ� �� ���� 1ȸ�� ����Ѵ�. 
select * from A union all select * from B; -- �� ���̺��� �ߺ��� ����Ͽ� ��� ����Ѵ�.
select * from A intersect select * from B; -- �� ���̺��� �������� ����Ѵ�.
select * from A minus select * from B; -- �� ���̺��� �� ���̺��� �������� ������ �κ�(������)�� ����Ѵ�.

----- **** subquery : ���� ���� ����

--����) �������� ��� �̸��� ã���� �� ��, �Ʒ��� �� ������ ã����
select manager_id from employee where emp_name='������';
select emp_name from employee where emp_id=214;
--Ȥ�� self join���� ������ ���� ã�Ƴ� �� �־�����
select e1.emp_name,e2.emp_name from employee e1 join employee e2 on e1.manager_id=e2.emp_id where e1.emp_name='������';

--������ ���� select manager_id from employee where emp_name='������' ��ü�� 214��� return���̶�� ����
--select emp_name from employee where emp_id=214;�� 214 �κп� ��ü�Ͽ� ���� �� �ִ�.
select emp_name from employee where emp_id=(select manager_id from employee where emp_name='������');

--����� ���� �з�.
--������,���Ͽ�/������/���߿�/������,���߿�/inline view/���

--������, ���Ͽ� subquery ����
--quiz
--1. ������ ������ �޿��� ������ �޿��� �޴� ������ �̸� �� �޿� ����غ���
select emp_name �̸�, to_char(salary,'L999,999,999') �޿� from employee where salary = (select salary from employee where emp_name='������') and emp_name != '������'; 
--2. �� ���� �޿� ��պ��� �޿��� ���� �޴� ������ �̸�, �����ڵ�, �޿��� ����غ���
select emp_name �̸�, job_code �����ڵ�, to_char(salary,'L999,999,999') �޿� from employee where salary > (select avg(salary) from employee);
--3. D1, D2�μ��� ���� �� �޿��� D5�μ��� �޿� ��պ��� ���� �������� �μ���ȣ, ���, �����, �޿��� ����غ���
select dept_code �μ���ȣ,emp_id ���, emp_name �����, to_char(salary,'L999,999,999') �޿� from employee 
where salary > (select avg(salary) from employee where dept_code='D5') and dept_code in ('D1','D2'); 
--4. �޿��� ���� ���� ����� ���� ���� ����� ���, �����, �޿��� ����غ���
select emp_id ���, emp_name �����, to_char(salary,'L999,999,999') �޿� from employee where salary in ((select max(salary) from employee),(select min(salary) from employee)); 


select emp_id ���, emp_name �����, to_char(salary,'L999,999,999') �޿� from employee where salary = (select max(salary),min(salary) from employee); 
-->������ ���߿� subquery�̱⵵ ��
select max(salary),min(salary) from employee;


-- ������ ���Ͽ� subquery ����
--�ڳ���, �������� �μ��ڵ�� ������ �μ��� ���� �������� ����
select * from employee where dept_code in (select dept_code from employee where emp_name in ('�ڳ���','������'));
--> ������ ������ �������� �� �������� ����� ������. �̶��� = �񱳸� ������ �� ����. in�� ����ؾ� ��.

--quiz.
--1. ���¿� �Ǵ� ������ ������ �޿���ް� ���� �޿������ ������ ���޸�� ������� ����غ���
select job_name ���޸�, emp_name �����, sal_level �޿���� from employee join job using(job_code)
where sal_level in (select sal_level from employee where emp_name in ('���¿�','������'));
--2. ������ ��ǥ, �λ����� �ƴ� ��� ������ �����, �����ڵ带 ����غ���
select emp_name �����, job_code �����ڵ� from employee 
where job_code not in (select job_code from job where job_name in ('��ǥ','�λ���'));

--������ subquery������ <,>�񱳸� ǥ���Ϸ���?
--����) D5 �μ� �������� �޿����� ���̹޴� ������ ������ ���
select emp_name �����,to_char(salary,'L9,999,999') �޿� from employee 
where salary>any(select salary from employee where dept_code='D5'); -- min(salary)���� ū �� ���
select emp_name �����,to_char(salary,'L9,999,999') �޿� from employee 
where salary>all(select salary from employee where dept_code='D5'); -- max(salary)���� ū �� ���

-- ������ ���߿� subquery ����
--����� ����� ���� �μ�, ���� ���޿� ���� ����� ���� ���
select emp_name, dept_code, job_code from employee 
where (dept_code, job_code) = (select dept_code, job_code from employee where ent_yn='Y');
-- ���߿� subquery = ������ ���߿� subquery ������ ����.

--quiz.
--1. ������ 8��8���� ������ ���� �μ��̸鼭 ���� �����ڵ��� �������� �����,������ ����غ��� (8��8���� ����� ����)
select emp_name �����, to_char(to_date(substr(emp_no,3,4),'MMDD'),'MM"��"DD"��"') ���� from employee 
where (dept_code, job_code) in (select dept_code, job_code from employee where substr(emp_no,3,4)='0808') and  substr(emp_no,3,4) !='0808';
--2. �μ��� �޿��� ���� ���� �޴� ������ �μ��ڵ� �� �޿� ����غ���
select nvl(dept_code,'����') �μ��ڵ�,emp_name �̸�, to_char(salary,'L99,999,999') �޿� from employee 
where (nvl(dept_code,'����'),salary) in (select nvl(dept_code,'����'),max(salary) from employee group by dept_code) order by dept_code;
--�μ��ڵ���� �� ����� ��! salary�θ� �˻��ϸ� �߸��� ������� ��µ�

-- subquery�� ����ϴ� �Ǵٸ� ����
--select������ subquery ���
--������, �μ����� �ٿ����� ���� ��
select emp_name, (select dept_title from department where dept_code = dept_id) from employee;
--> subquery�� main query�� column�� ���ΰ�ó�� ����� �� �ִ�. 
--> subquery�� mainquery�� ������ ���� ��, �̸� ��� subquery��� ��.

--quiz. ������, ���޸��� ����غ��� (join�� �ƴ� subquery��)
select emp_name, (select job_name from job j where j.job_code=e.job_code)  from employee e;

--inline view ��
--from������ subquery ��� (���Ƿ� ������� ���� table�̶�� �����ص� ����)
select * from  (select emp_id, emp_name, emp_no from employee);

-- rank ���� �Լ� !
select emp_name, salary, rank() over(order by salary desc) ���� from employee;
select emp_name, salary, dense_rank() over(order by salary desc) ���� from employee;
select emp_name, salary, row_number() over(order by salary desc) ���� from employee;

--quiz.
--1. �޿� ������������ �ึ�� ��ȣ�� �ٿ��� ��, 10~15�� ������ �����͸� ����غ���
select * from (select emp_name, salary, rank() over(order by salary desc) as "��ŷ" from employee) where "��ŷ" between 10 and 15;

--������ quiz.
--1. ��������ο� ���� ������� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�
select emp_name �̸�, dept_code �μ��ڵ�, to_char(salary,'L999,999,999') �޿� from employee 
where dept_code = (select dept_id from department where dept_title='���������');
--�Ǵ�
select emp_name �̸�, dept_code �μ��ڵ�, to_char(salary,'L999,999,999') �޿� from employee
join department on dept_code=dept_id where dept_title = '���������';
--2. *** ��������ο� ���� ����� �� ���� ������ ���� ����� �̸�,�μ��ڵ�,�޿��� ����Ͻÿ�
select emp_name �̸�, dept_code �μ��ڵ�, to_char(salary,'L999,999,999') �޿� from employee
where (dept_code, salary) in (select dept_code, max(salary) from employee group by dept_code) and dept_code = (select dept_id from department where dept_title='���������');
--�Ǵ�
select emp_name �̸�, dept_code �μ��ڵ�, to_char(salary,'L999,999,999') �޿� from employee join department on dept_code=dept_id
where (dept_code,salary) in (select dept_code, max(salary) from employee group by dept_code) and dept_title='���������';
--3. �Ŵ����� �ִ� ����߿� ������ ��ü��� ����� �Ѱ� ���,�̸�,�Ŵ��� �̸�,����(������������)�� ���Ͻÿ�.
--��, JOIN�� �̿��Ͻÿ�
select e1.emp_id ���, e1.emp_name �̸�, e2.emp_name "�Ŵ��� �̸�", e1.salary/10000||'����' ���� from employee e1
join employee e2 on e1.manager_id=e2.emp_id where e1.manager_id is not null and e1.salary > (select avg(salary) from employee);
--===>>  e1.manager_id=e2.emp_id���� null�� �ɷ����ϱ� not null�� ���°� �´°ǰ�?

--4. �� ���޸��� �޿� ����� ���� ���� ������ �̸�, �����ڵ�, �޿�, �޿���� ��ȸ
--�޿�����̶�� �ϸ� �ߺ��Ǵµ�..
select emp_name �̸�, job_code �����ڵ�, to_char(salary,'L9,999,999') �޿�, sal_level �޿���� from employee
where (job_code,sal_level) in (select job_code,min(sal_level) from employee group by job_code);
--�޿��� ���� ���� �̶�� �����ϸ�
select emp_name �̸�, job_code �����ڵ�, to_char(salary,'L999,999,999') �޿�, sal_level �޿���� from employee
where (job_code, salary) in (select job_code, max(salary) from employee group by job_code);
--5. ���� ���ʽ��� ���� �޴� ������ ������� �̾����� 4~8���� ����, �����, �޿�, ���ʽ����� ���
select * from (select rank() over(order by bonus desc) as "����",emp_name �����,to_char(salary,'L9,999,999') �޿�,bonus ���ʽ��� from employee 
where bonus is not null) where "����" between 4 and 8;
--6. �μ��� ��� �޿��� 2,200,000 �̻��� �μ���, ��� �޿� ��ȸ ��, ��� �޿��� �Ҽ��� ����
select (select dept_title from department where dept_id=dept_code) �μ���, floor(avg(salary)) ��ձ޿� 
from employee where dept_code in (select dept_code from employee group by dept_code having avg(salary)>2200000) group by dept_code;
---===>> �̰� �ʹ� �������� �ڵ��ΰ�?
--�Ǵ�
select * from (select dept_title �μ���, floor(avg(salary)) ��ձ޿� from employee join department on dept_id=dept_code group by dept_title) where ��ձ޿�>=2200000;
--7. ������ ���� ��պ��� ���� �޴� ���ڻ���� �����,�����ڵ�,�μ��ڵ�,������ �̸� ������������ ��ȸ�Ͻÿ� 
--���� ��� => (�޿�+(�޿�*���ʽ�))*12
select emp_name �����, job_code �����ڵ�, dept_code �μ��ڵ�, to_char((salary+salary*nvl(bonus,0))*12,'L999,999,999') "����" from employee e1
where (salary+salary*nvl(bonus,0))*12 < (select avg((salary+salary*nvl(bonus,0))*12) from employee e2 group by job_code 
having e1.job_code = e2.job_code) and substr(emp_no,8,1)='2' order by 1; -- ���� join ������;;

--���
select e1.emp_name �����, e1.job_code �����ڵ�, e1.dept_code �μ��ڵ�, ���� from employee e1 
join (select job_code, avg(salary*(1+nvl(bonus, 0))*12) ������տ��� from employee group by job_code) e2 on e1.job_code = e2.job_code
join (select salary*(1+nvl(bonus, 0))*12 ����, emp_id from employee) e3 on e3.emp_id = e1.emp_id -- ���� join �ź����ε�
where (substr(emp_no, 8, 1) = 2) and (���� < ������տ���) order by 1;

select * from department;
select * from employee;
select * from job;
select * from location;
select * from national;
select * from sal_grade;

----------------------------------------------------------------------------------------------------------
------0221
-- DDL

-- create table <���̺��̸�> (
--  �÷��� �ڷ��� ��������,
--  �÷��� �ڷ��� ��������,
-- .....
--);

create table cafe_menu(
    id number,
    name varchar(21), -- ������ �ڷ����� �ִ������(byte)�� ��������� ��(varchar/char �Ѵ� ����)
    --varchar: �������� �ڷ���. ������� �����Ͱ� �ִ밪���� ������ ���� ������ ȸ���Ѵ�. char�� ������ ũ��.
    price number
);

describe cafe_menu;

-- DML
--insert : table ��ü�� �����͸� �Է��ϴ� SQL
--insert into ���̺�� �÷��� values(������);
insert into cafe_menu (id,name) values(1001,'Americano');
insert into cafe_menu (id,price) values(1002,3000);
insert into cafe_menu (id,name,price) values(1003,'Cafe Mocha',4000);
insert into cafe_menu values(1004,'Orange Juice',4500);
-- ��� �÷��� �� �ۼ��ϰڴٴ� ���� �Ͽ� �÷��� �����ϰ� �ۼ� ����

--update : table ��ü�� ����� �����͸� �����ϴ� SQL
--update ���̺�� set �÷��� = ������ ������ where ������ �� ����;
update cafe_menu set price = 2000 where id=1001;
update cafe_menu set name = 'Cafe Latte' where id=1002;

insert into cafe_menu (id) values(1005);
update cafe_menu set name = 'Vanila Latte', price = 3500 where id = 1005;
--�޸��� �̾ ���� �÷��� ���ÿ� update ����

--delete : table ��ü�� ����� �����͸� �����ϴ� SQL
--delete from ���̺�� where ������ �� ����;
delete from cafe_menu where id=1004;

delete from cafe_menu;

select * from cafe_menu;

--drop : Oracle ���� �����ϴ� ��ü�� �����ϴ� SQL
--drop ��ü���� ��ü�̸�;
drop table cafe_menu;

-- DDL - Create 2 -
create table cafe_menu(
    id number not null, -- null ���� �� �� ���ٴ� �������� �ۼ�
    name varchar(21) not null,
    price number not null
);

describe cafe_menu;

insert into cafe_menu (id) values(1001); -- null���� ���� �� ����
insert into cafe_menu values(1001,'Americano',2000);
update cafe_menu set price=null where id=1001; --null������ �����Ҽ��� ����

insert into cafe_menu values(1001,'Americano',2000);
--�̷��� �Ȱ��� ���� �� ����� �� ���� ������ ����� ������.
--�ߺ��� ���� �Է��� ������� �ʴ� �������� �ʿ�! --> ���̺� �ٽ� �����غ���.
drop table cafe_menu;


-------
create table cafe_menu(
    id number primary key, --> not null�̸鼭 �ߺ��� ������� �ʴ� ����� �Ѵ�. 
                                        --(�� �ϳ��� �÷����� ���� ����. ���� ��¥ �ĺ��ڷμ� ����ϱ� ����!)
    name varchar(21) not null,
    price number not null
);

insert into cafe_menu values(1001,'Americano',2000); -- ���� 1001�� id�� �ϳ��� ������������
insert into cafe_menu values(1002,'Cafe Latte',3000);

drop table cafe_menu;

--�Ǵٸ� ���������� �߰��غ���.
--(unique)
create table cafe_menu(
    id number primary key,
    name varchar(21) unique not null, --> unique : �÷��� �ߺ��� �����Ѵ�. (null�� ���)
    price number not null                   -- ���Ͱ��� ���� ���������� �Բ� �ۼ�����. 
);

insert into cafe_menu values(1001,'Americano',2000);
insert into cafe_menu values(1002,'Americano',3000); --���� �̸��� �ߺ��� �� ���� �Ұ�!
insert into cafe_menu values(1002,'Cafe Latte',3000);

drop table cafe_menu;

--�Ǵٸ� ���������� �߰��غ���.
--(check)
create table cafe_menu(
    id number primary key,
    name varchar(21) unique not null, 
    price number not null,
    isIce char(1) check(isIce in ('Y','N')) not null -- check : Ư�� ���� �ƴϸ� �Է��� ������� ����
);

insert into cafe_menu values(1001,'Americano',2000,'ice'); -- isIce ũ�⿡ ���� �ʾ� �����߻�
insert into cafe_menu values(1001,'Americano',2000,'i'); -- check�� ������ ���� �ش����� �ʾ� �����߻�
insert into cafe_menu values(1001,'Americano',2000,'N');
insert into cafe_menu values(1002,'Cafe Latte',2500,'Y');

select * from cafe_menu;

--�Ǵٸ� ���������� �߰��غ���. 
--(foreign key)
--��ǰ����� ����� ���̺�
create table product(
    id number primary key,
    pname varchar(30) not null,
    price number not null
);

insert into product values(1001,'Airpot',200000);
insert into product values(1002,'Galaxys23',2000000);
insert into product values(1003,'LG_Gram17',1500000);

update product set pname='GalaxyS23' where id=1002;

--�Ǹų����� ����ϴ� ���̺�
create table sales_history(
    sid number primary key, --�Ǹű�� id
    pid references product(id) not null, --�Ǹŵ� �׸��� id --> ��ǰ��Ͽ� ���� id�� ���� �� ����. (�ܷ� Ű)
    sdate timestamp not null --�Ǹŵ� ��¥
);

insert into sales_history values(100001,1005,sysdate); --�����ִ�(�����ϴ� �ܷ�Ű�� �ش����� �ʴ�) ������ ����
--���� ������ ���� �˼��ֵ���, references �� �÷����� parent - child ���谡 �����ȴ�.

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);


--�̶� �θ�Ű�� 1001���� ������� �Ѵٸ�?
delete from product where id=1001; -- ���Ἲ �������� ����. child record�� �־ ������ �� ����.
delete from product where id=1002; -- child�� ������ ���� �׸��� ���� �����ϴ�.

drop table product; -- �׸��� �����ִ� parent ���̺��� ������ �� ����.
drop table sales_history; -- child ���̺��� ���� ����

--���ο� ���� �߰��� ����
create table sales_history(
    sid number primary key, 
    pid references product(id) on delete cascade, -- parent table�� �׸��� ������ �� child tale�� ����� �׸� �����ȴ�. 
    sdate timestamp not null 
);

insert into product values(1002,'Galaxys23',2000000);

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);
insert into sales_history values(100003,1002,sysdate);
insert into sales_history values(100004,1002,sysdate);

delete from product where id = 1002; --�������� ���п� product�� 1002���� ��������,
--child record���� 1002���� ���� �׸�鵵 ������ ���� Ȯ���� �� �ִ�.
--�Խ��ǿ� ���� �� ����� �ܷ�Ű�� id�� �ް�, �� ����� ȸ��Ż�������� �Խñ۱��� ��� ���������� �� �� ����

drop table sales_history;

create table sales_history(
    sid number primary key, 
    pid references product(id) on delete set null, -- parent table�� �׸��� ������ �� child tale�� ����� �׸� null���� �Էµȴ�. 
    sdate timestamp not null 
);

insert into sales_history values(100001,1001,sysdate);
insert into sales_history values(100002,1003,sysdate);

delete from product where id=1003; -- child record�� null������ �ٲ� �� Ȯ���� �� �ִ�.
--���� ����� �� null��--> 'Ż���� ȸ��' ���� ������ ǥ���� �� �ְڴ�.

select * from product;
select * from sales_history;

--------------------------------------
--sequence ��ü : �ַ� �ĺ��� id ������ ���

create sequence product_seq --product ���̺��� ����� �̸�����
start with 1002 -- 1002���� ����(���� 1001������ ��������ϱ�)
increment by 1 --1�� ����
nomaxvalue nocache; --�̰� �׳� default��� ����

insert into product values(product_seq.nextval,'IPad6',1500000);
--�̷��� sequence ��ü���� ���� ���� �����޶�� ��û�Ͽ� ���

--------------------------------------
--alter(DDL) : ��ü ���� ���� (���ӻ��� ��� �ر� ���� ������)


select * from cafe_menu;

--���̺� �̸� ����
--cafe_menu --> cafe�� ����
alter table cafe_menu rename to cafe;

select * from cafe;

--���̺� �÷� �߰�
alter table cafe add (menu_size varchar(10) check (menu_size in ('S','R','L')) not null);
-->null ���� ���� �� ���ٰ� ���������Ƿ� ���� ���� �ʰ�� �÷� ���� �Ұ�
alter table cafe add (menu_size varchar(10) default 'S' check (menu_size in ('S','R','L')) not null);
-->���� �⺻�� ������ ���ָ� ��������

--���̺� �÷� ����
alter table cafe drop column menu_size;

--���̺� �÷� �ڷ��� ����
alter table cafe modify name varchar(30) not null; --or null
desc cafe;

--�÷� �̸� ����
alter table cafe rename column menu_size to scale;
desc cafe;

-------�������� ����(null/not null�� modify�� ���� �����ϴ�.)
-- ���� �˾ƾ��ϴ� ��. Oracle�� dictionary(����Ŭ ���� ���̺�) ���
-- ������� ��ɿ� ���� �߻��ϴ� �����͸� �����ϱ� ���� ����Ŭ ���� ���̺�.
--���⼭ ����̶� create, view .. ��

select * from user_tables; -- kh������ ���� ���̺���� ��� table
select * from user_constraints; -- kh������ ���� �������ǵ��� ��� table

--���� � ���������� �ִ��� dictionary�� ���� ��ȸ�� �� ���������� �����غ���.
select * from user_constraints where table_name='CAFE'; --(constraint_type���� P�� primary, U�� unique)
desc cafe;

--�������� ����
alter table cafe drop constraint SYS_C007031; --isIce�� üũ �ɼ��� ����
alter table cafe drop constraint SYS_C007032;

--�������� �߰�
alter table cafe add primary key(id);
--�߰��� �� ������ �̸����� �������� �̸��� ������ �� �ִ�.
alter table cafe add constraint cafe_id_pk primary key(id); 
--unique�� �߰�
alter table cafe add constraint cafe_name_uk unique(name);
--check�� �ٽ� �߰�
alter table cafe add constraint cafe_isIce_chk check (isIce in ('Y','N'));

drop table cafe;

--create�� �÷��� ������ ��ÿ� �������ǿ� �̸��� ������ ���� �ִ�.
create table cafe(
    id number constraint cafe_id_pk primary key,
    name varchar(30) constraint cafe_name_uk unique constraint cafe_name_nn not null,
    price number constraint cafe_price_nn not null,
    isIce char(1) constraint cafe_isIce_chk check(isIce in ('Y','N'))
);

select * from user_constraints where table_name='CAFE'; 

--sequence���� alter�� �� �� �ִ�.
create sequence cafe_seq start with 1001 increment by 1 maxvalue 2000 nocycle; 
--+) cycle : maxvalue(2000)���� ������ ���� �ٽ� ��������(1001)���� ���ư��°�

alter sequence cafe_seq nomaxvalue;
alter sequence cafe_seq increment by -10; --�����ϵ��� �Ϸ��� ������ ����.

-- +)���� �н����嵵 ���� ���� (������ �������� ���� ��)
--alter user kh identified by test; �̷������� �ۼ��ϸ� ��
-----------------------------------------
-- DCL : grant, revoke (view ��ü���̿��� �˾ƺ���)
-- ������ ���̺� ������ �� ���ִ�. ���̺��� ���� �ְų�/���ų�. �÷������δ� �� �� ����.
-- �̶� �ʿ���� �÷��� ���� �ְ���� ��. �ְ���� ���븸 �κ����̺�� ���� ����� �ִ� ����� ����� �� �ִ�.
select * from employee;

create table employee_dev as select emp_id, emp_name, email, phone from employee;
select * from employee_dev;

--��� �����ڷ� �����Ͽ� dev ��������, ���Ѻο�

--�ٽ� kh�� ���ƿ� dev ������ �κ����̺��� ��ȸ�� �� �ִ� ���� �ο�
grant select on employee_dev to dev;

--�׷��� dev�� kh�� ������ ���̺��� ��ȸ�� �� �ְ� ������,
--employee ���̺� ��������� ���� �� employee_dev���� �ڵ����� ������Ʈ ������ �ʴ´�. ������ ������Ʈ����� ��.
--���� ������ױ��� �ڵ����� �ݿ��ϱ� ���ؼ��� �� �۾��� view�� ��ȯ�Ͽ� �����ϵ��� �Ѵ�.
--view : ������ ����ü��. view��� ��ũ�� ���� �������̺��� ���� ���. ���� �������̺��� ��������� �ݿ��ȴ�.

-- resource ���ѿ��� view�� ����� ������ ����. �����ڿ��Լ� �ο��޾� �����Ѵ�.
create view employee_view as select emp_id, emp_name, email, phone from employee;

-- ������� view�� ��ȸ�� �� �ִ� ������ dev���� �ش�.
grant select on employee_view to dev;

update employee set emp_name='������' where emp_id=200;
commit; --Ŀ������� �����
select * from employee;

--���̺� ���� �ο��� ���� ��� ���
select * from user_tab_privs;

--���� ���ѱ�
revoke select on employee_dev from dev;
revoke select on employee_view from dev;

---------------------------------------
-- TCL (Transanction Control Language)
-- rollback : ���query�� ����ϰ� Ư���������� �����ϴ� ����

select * from user_sequences;
select * from cafe;
insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y');

rollback; -- cafe�� �޴� �Է��ϱ� ������ ���ư���.

select * from employee;
delete from employee; -- Ȥ�ó� delete �÷��� �Է����� �ʾ� �����͸� �� �����Ծ�� rollback���� ��������

-- commit : �ۼ��� query���� ���� DB�� �ݿ��ϴ� ���. ���̻� ������ �� ���� .. 

--�ǽ�
delete from cafe;
commit;
insert into cafe values(cafe_seq.nextval, 'Americano', 2000, 'Y');
insert into cafe values(cafe_seq.nextval, 'Cafe Mocha', 4000, 'Y');
select * from cafe;
delete from cafe where id=1005;
