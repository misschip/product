#### Simple JSP & Ajax Exercise Project

## Table Creation
```sql
CREATE TABLE PRODUCT (
    id number primary key,
    name varchar2(30) not null,
    type varchar2(30) not null,
    price number not null,
    count number not null
);
```
## Sample Data Insertion
```sql
insert into product values(1,'바나나','과일',1000,200);
insert into product values(2,'딸기','과일',2000,10);
insert into product values(3,'연필','문구',500,2000);
insert into product values(4,'지우개','문구',700,600);
insert into product values(5,'사과','과일',1500,100);
insert into product values(6,'청바지','옷',15000,1700);
insert into product values(7,'포도','과일',1200,300);
insert into product values(8,'자몽','과일',2000,50);
insert into product values(9,'볼펜','문구',1000,1500);
insert into product values(10,'딱풀','문구',1500,350);
insert into product values(11,'참외','과일',900,1000);
insert into product values(12,'면티','옷',7000,3500);
insert into product values(13,'점퍼','옷',35000,300);
insert into product values(14,'벨트','옷',1000,1200);
commit;
```