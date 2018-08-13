drop table message;

create table message(
msg_no number,
sender varchar2(30),
receiver varchar2(30),
msg_title varchar2(100),
msg_txt varchar2(1000),
msg_date date);

create sequence msg_seq;

select * from message;

create table bd_list(
me_id varchar2(30),
bd_id varchar2(30));

insert into bd_list values('ocean', 'mino');
insert into bd_list values('ocean', 'mino2');
insert into bd_list values('ocean', 'mino3');
insert into bd_list values('ocean', 'Joo');

insert into bd_list values('single', 'mino');
insert into bd_list values('ocean', 'Joo');

insert into bd_list values('mino', 'ocean');
insert into bd_list values('mino', 'mino2');

select * from bd_list;
select * from member;


update bd_list set bd_id='Joo' where me_id='ocean';
