select * from cafe;
select * from user_sequences;

select * from employee;

select cafe_seq.currval from dual;

select last_number from user_sequences where SEQUENCE_NAME='CAFE_SEQ';

create table movies(
    id number primary key,
    title varchar(60) not null,
    genre varchar(20) not null
); 

create sequence movies_seq start with 1001 increment by 1 nocache nomaxvalue;
update cafe set name = 'Mocha Latte', price = 3500 where id=1008;

select * from movies;

create table students(
    id number primary key,
    name varchar(20) not null,
    kor number not null,
    eng number not null,
    math number not null
);

create sequence students_seq start with 1001 increment by 1 nomaxvalue;

select * from students;
    
---------------------------------------자습
create table games(
    id number primary key,
    title varchar(100) not null,
    genre varchar(100) not null,
    dev varchar(50) not null,
    pub varchar(50) not null,
    release date,
    supKor char(1) default 'N' check(isSingle in ('Y','N'))
);

create sequence games_seq start with 1001 increment by 1 nomaxvalue nocycle;

insert into games values(games_seq.nextval,'Portal2','Puzzle','Valve','Valve',to_date('2011/04/19'),'Y');
insert into games values(games_seq.nextval,'Dota2','stretagy','');
insert into games values(games_seq.nextval,'The Past Witin','Puzzle','')
insert into games values(games_seq.nextval,
insert into games values(games_seq.nextval,

--평점으로 order 할 수 있는 것도 만들자
create table movies2(
    id number primary key,
    title varchar(50) not null,
    genre varchar(20) not null,
    director varchar(50) not null,
    score number,
    release timestamp,
    nation varchar(50)
);



--======================== 0228 수업
create table members(
    id varchar(20) primary key,
    pw varchar(128) not null,
    name varchar(20) not null,
    contact varchar(20),
    reg_date timestamp default sysdate not null
);

--drop table members;
select * from members;

desc members;


select * from user_tables;

select * from user_sequences;



select count(emp_name),dept_code from employee group by dept_code;

create user study identified by kh;
grant resource, connect to study;


