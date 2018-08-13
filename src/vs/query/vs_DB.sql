drop table VS_BOARD;
create table vs_board(
vs_no number,
vs_title varchar2(100),
vs_optionA varchar2(100),
vs_optionB varchar2(100),
vs_txt varchar2(1000),
me_id varchar2(30),
vs_hitsA number,
vs_hitsB number,
vs_date date);
create sequence vs_seq;

drop table VS_CMT;
create table vs_cmt(
vs_cmt_no number,
vs_cmt_txt varchar2(500),
vs_cmt_date date,
vs_no number,
me_id varchar2(30));
create sequence vs_cmt_seq;

drop table vs_voting;
create table vs_voting(
	vs_no number,
	me_id varchar2(30),
	opt varchar2(10)
);

insert into vs_board values(vs_seq.nextval, '날마다 새벽 5시에 출근해서 저녁 10시에 퇴근하는데 계속 다녀야 되나요?', '퇴사하기', '계속 다니기', '집이랑 회사 도보 10분 연봉 3억', 'ocean', 0, 0, sysdate);
insert into vs_board values(vs_seq.nextval, '다이어트 중인데 뭘 먹으면 좋을까요?', '족발', '곱창', '', 'ocean', 0, 0, sysdate);
insert into vs_board values(vs_seq.nextval, '결혼을 앞두고 로또 1등 당첨되면 반을 주기로 약속했을때', '조용히 결혼', '계속 다니기', '', 'ocean', 0, 0, sysdate);
insert into vs_board values(vs_seq.nextval, '날마다 새벽 5시에 출근해서 저녁 10시에 퇴근하는데 계속 다녀야 되나요?', '퇴사하기', '계속 다니기', '집이랑 회사 도보 10분 연봉 3억', 'ocean', 0, 0, sysdate);

update vs_board set vs_title='', vs_optionA='', vs_optionB='', vs_txt='' where vs_no='61';

insert into vs_voting values('50', 'ocean', 'A');
select * from VS_BOARD;
select * from VS_CMT;
select * from vs_voting;