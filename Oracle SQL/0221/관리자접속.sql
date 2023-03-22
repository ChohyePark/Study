create user student identified by student;
grant connect, resource to student;
revoke resource from student;


create user dev identified by dev; --잠시 관리자로 접속하여 계정생성, 권한부여
grant connect, resource to dev;

grant create view to kh; --kh에게 view를 만들 수 있는 권한 부여

select * from user_tab_privs;
select * from user_privs;

create user challenger identified by ch;
grant connect,resource to challenger;
grant create view to challenger;