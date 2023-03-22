create table brands(
    brand_id number primary key,
    brand_name varchar2(100) not null
);

create table products(
    product_no number primary key,
    product_name varchar2(50) not null,
    product_price number not null,
    brand_code number references brands, --> //무슨컬럼을 참고하는지? brands(brand_id) 아닌듯.
    sold_out char(1) default 'N' check(sold_out in ('Y','N'))
);


create sequence seq_brand_id start with 100 increment by 100 maxvalue 500 nocycle;--> 5개까지 입력가능

create sequence seq_product_no start with 1 increment by 1 maxvalue 10000 nocycle;

insert into brands values(seq_brand_id.nextval, '삼성');
insert into brands values(seq_brand_id.nextval, '애플');

 -->S8, S9,.. 
insert into products values(seq_product_no.nextval, '갤럭시S8',800000,100,'S8','Y'); 
insert into products values(seq_product_no.nextval, '갤럭시S9',900000,100,'S9','N');
insert into products values(seq_product_no.nextval, '갤럭시S10',1000000,100,'S10','N');
insert into products values(seq_product_no.nextval, '아이폰9S',900000,200,'9S','N');
insert into products values(seq_product_no.nextval, '아이폰10S',1000000,200,'10S','N');

-- 결과조회
select product_name, product_price, brand_name,sold_out from products join brands on brand_id=brand_code;

-------------------
--> serial_no라는 컬럼을 빼고 생성했다.
--alter table products add(serial_no varchar2(100) unique);

alter table products add(serial_no varchar2(100) unique);
--컬럼 순서때문에 sold_out 지웠다가 다시생성해줌
alter table products drop column sold_out;
alter table products add(sold_out char(1) default 'N' check(sold_out in ('Y','N')));
desc brands;
desc products;

--외래키 설정이 제대로 됐네..? unique나 primary가 저거 하나라서 그런가봄
--alter table products add constraint fk_brand_code foreign key(brand_code) references brands(brand_id);

--캐쉬사용안함인데 사이클사용안함 이라고 적었음
drop sequence seq_brand_id;
create sequence seq_brand_id start with 100 increment by 100 maxvalue 500 nocache;
drop sequence seq_product_no;
create sequence seq_product_no start with 1 increment by 1 maxvalue 10000 nocache;

select * from brands;
select * from user_constraints where table_name='PRODUCTS';
select * from user_constraints where table_name='BRANDS';
update products set brand_code=200 where product_name like '아이폰%';
