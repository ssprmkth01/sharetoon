
/* Drop Tables */

DROP TABLE SHT_USER CASCADE CONSTRAINTS;




/* Create Tables */

-- SHT유저 : sharetoon 회원 정보
CREATE TABLE SHT_USER
(
	-- 아이디 : 유저 ID
	ID varchar2(30) NOT NULL,
	-- 암호 : 유저 암호
	PASSWORD varchar2(30) NOT NULL,
	-- 전자메일 : 유저 메일 주소
	EMAIL varchar2(200) NOT NULL,
	-- 점수 : 유저 참여 점수
	POINT number(19,0) NOT NULL,
	PRIMARY KEY (ID)
);



/* Comments */

COMMENT ON TABLE SHT_USER IS 'SHT유저 : sharetoon 회원 정보';
COMMENT ON COLUMN SHT_USER.ID IS '아이디 : 유저 ID';
COMMENT ON COLUMN SHT_USER.PASSWORD IS '암호 : 유저 암호';
COMMENT ON COLUMN SHT_USER.EMAIL IS '전자메일 : 유저 메일 주소';
COMMENT ON COLUMN SHT_USER.POINT IS '점수 : 유저 참여 점수';



