create table brands(
    brand_id number primary key,
    brand_name varchar2(100) not null
);

create table products(
    product_no number primary key,
    product_name varchar2(50) not null,
    product_price number not null,
    brand_code number references brands, --> //�����÷��� �����ϴ���? brands(brand_id) �ƴѵ�.
    sold_out char(1) default 'N' check(sold_out in ('Y','N'))
);


create sequence seq_brand_id start with 100 increment by 100 maxvalue 500 nocycle;--> 5������ �Է°���

create sequence seq_product_no start with 1 increment by 1 maxvalue 10000 nocycle;

insert into brands values(seq_brand_id.nextval, '�Ｚ');
insert into brands values(seq_brand_id.nextval, '����');

 -->S8, S9,.. 
insert into products values(seq_product_no.nextval, '������S8',800000,100,'S8','Y'); 
insert into products values(seq_product_no.nextval, '������S9',900000,100,'S9','N');
insert into products values(seq_product_no.nextval, '������S10',1000000,100,'S10','N');
insert into products values(seq_product_no.nextval, '������9S',900000,200,'9S','N');
insert into products values(seq_product_no.nextval, '������10S',1000000,200,'10S','N');

-- �����ȸ
select product_name, product_price, brand_name,sold_out from products join brands on brand_id=brand_code;

-------------------
--> serial_no��� �÷��� ���� �����ߴ�.
--alter table products add(serial_no varchar2(100) unique);

alter table products add(serial_no varchar2(100) unique);
--�÷� ���������� sold_out �����ٰ� �ٽû�������
alter table products drop column sold_out;
alter table products add(sold_out char(1) default 'N' check(sold_out in ('Y','N')));
desc brands;
desc products;

--�ܷ�Ű ������ ����� �Ƴ�..? unique�� primary�� ���� �ϳ��� �׷�����
--alter table products add constraint fk_brand_code foreign key(brand_code) references brands(brand_id);

--ĳ���������ε� ����Ŭ������ �̶�� ������
drop sequence seq_brand_id;
create sequence seq_brand_id start with 100 increment by 100 maxvalue 500 nocache;
drop sequence seq_product_no;
create sequence seq_product_no start with 1 increment by 1 maxvalue 10000 nocache;

select * from brands;
select * from user_constraints where table_name='PRODUCTS';
select * from user_constraints where table_name='BRANDS';
update products set brand_code=200 where product_name like '������%';
