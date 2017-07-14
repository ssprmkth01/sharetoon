
/* Drop Tables */

DROP TABLE SHT_USER CASCADE CONSTRAINTS;




/* Create Tables */

-- SHT���� : sharetoon ȸ�� ����
CREATE TABLE SHT_USER
(
	-- ���̵� : ���� ID
	ID varchar2(30) NOT NULL,
	-- ��ȣ : ���� ��ȣ
	PASSWORD varchar2(30) NOT NULL,
	-- ���ڸ��� : ���� ���� �ּ�
	EMAIL varchar2(200) NOT NULL,
	-- ���� : ���� ���� ����
	POINT number(19,0) NOT NULL,
	PRIMARY KEY (ID)
);



/* Comments */

COMMENT ON TABLE SHT_USER IS 'SHT���� : sharetoon ȸ�� ����';
COMMENT ON COLUMN SHT_USER.ID IS '���̵� : ���� ID';
COMMENT ON COLUMN SHT_USER.PASSWORD IS '��ȣ : ���� ��ȣ';
COMMENT ON COLUMN SHT_USER.EMAIL IS '���ڸ��� : ���� ���� �ּ�';
COMMENT ON COLUMN SHT_USER.POINT IS '���� : ���� ���� ����';



