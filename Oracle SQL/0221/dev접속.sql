select * from kh.employee; -- 접근권한이 없어서 에러발생
select * from kh.employee_dev; --kh에게 권한을 부여받아 select할 수 있게 됨

select emp_name from kh.employee_dev where emp_id=207;

select * from kh.employee_view; --kh에게 권한을 부여받아 view도 select할 수 있게 됨
--kh계정에서 employee 테이블의 항목을 수정하자 view에서만 반영되는 것이 확인된다.
