create user student identified by student;
grant connect, resource to student;
revoke resource from student;


create user dev identified by dev; --��� �����ڷ� �����Ͽ� ��������, ���Ѻο�
grant connect, resource to dev;

grant create view to kh; --kh���� view�� ���� �� �ִ� ���� �ο�

select * from user_tab_privs;
select * from user_privs;

create user challenger identified by ch;
grant connect,resource to challenger;
grant create view to challenger;