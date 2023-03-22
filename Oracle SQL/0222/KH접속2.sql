select * from cafe; -- kh에서 commit하지 않으면 보관된 query가 반영 안됨

insert into cafe values(cafe_seq.nextval,'Cafe Latte',2500,'N');
delete from cafe;
delete from cafe where id=1003;
delete from cafe where id=1005;
