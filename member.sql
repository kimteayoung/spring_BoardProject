use spring_kty3;


drop table board_table;

drop table board_table;
create table board_table(
   b_number bigint auto_increment,
    b_writer varchar(10),
    b_password varchar(20),
    b_title varchar(30),
    b_hits int default 0,
    b_contentsl varchar(2000),
    -- 시간 날짜!!
    b_date timestamp not null default current_timestamp,
    constraint primary key(b_number));
    
            select * from board_table;
-- limit a,b에서 a는 시작글의 순서(0부터 시작), b는 한페이지에 보여줄 글 갯수 
select * from board_table order by b_number desc limit 10,5;

-- 1. 최근글부터 보여야 함.
select * from board_table order by b_number desc;
-- 2. b_number 기준으로 내림차순 정렬한 상태에서 3개씩 글을 조회alter
-- limit a, b : a(순서, 가장첫번째가 0), b(한번에조회할 갯수)
-- 현재 게시판 테이블에서 3개씩 본다면 1페이지를 보는 쿼리 (0,1,2)
select * from board_table order by b_number desc limit 0, 3;
-- 2페이지를 보는 쿼리 (3,4,5)
select * from board_table order by b_number desc limit 3, 3;
-- 3페이지를 보는 쿼리 (6,7,8)
select * from board_table order by b_number desc limit 6, 3;
-- 4페이지를 보는 쿼리 (9,10,11)
select * from board_table order by b_number desc limit 9, 3;

-- 한페이지에 5개씩 글을 조회할 수 있다면 1,2,3,4페이지를 어떻게 조회할지 쿼리문을 작성해봅시다.

select * from board_table order by b_number desc limit 0, 3;
select * from board_table order by b_number desc limit 5, 3;
select * from board_table order by b_number desc limit 10, 3;
select * from board_table order by b_number desc limit 15, 3;

-- 제목에 안녕이라는 단어가 포함된 결과를 출력하는 쿼리는?
select * from board_table where b_title like '%bbb&';
-- 내용에 안녕 이라는 단어가 포함된 결과를 출력하는 쿼리는?
select * from board_table where b_contents like '%111&';







    
    
    
    
    
    