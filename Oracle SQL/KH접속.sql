desc employee;
--describe: employee table�� ���� �����϶�.

-- << select query�� ���ʹ��� ���� >>

select emp_name,phone,emp_no from employee; -- employee table���� �ش� column�� data ���
select * from employee; --��� colume data ���
--select �÷��� from ���̺�� where ���ǹ�;

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

--quiz07
--1.��� �����߿� ��ȭ��ȣ ó�� ���ڸ��� 010�� �ƴ� ������ �̸��� ��ȭ��ȣ ����غ���
select emp_name �����,phone ��ȭ��ȣ from employee where phone not like '010%';
--2.��� �����߿��� �̸��� '��'�� ���� ����� ��� ã�� �̸��� ����غ���
select emp_name as "�����" from employee where emp_name like '%��%';
--3.��� �����߿��� �μ��ڵ尡 D9 �Ǵ� D6�̰�, ������ 270���� �̻��̸�, email�� s�� ���ԵǾ��ְ�,
--������� 2001�� 1��1��~2005�� 12��31�� ������ ������ �̸�,�μ��ڵ�,�޿�,email,������� ����غ���
select emp_name �����,dept_code �μ��ڵ�,salary||'��' �޿�,email �̸���,hire_date ����� from employee 
where 
    dept_code in ('D6','D9') 
    and salary>=2700000 
    and email like '%s%'
    and hire_date between '01/01/01' and '05/12/31';
    