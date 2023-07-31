-- 5월 3일 회원 정보 테이블
drop table userinfo; 

create table userinfo
( 
	userid varchar2(20) primary key,
 	username varchar2(20) not null,
 	gender varchar2(5) check(gender in ('남','여')),
 	phone varchar2(20),
 	birthday date 
 );