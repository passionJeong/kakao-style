CREATE TABLE USER_ACCOUNT (
	USER_NUM BIGINT AUTO_INCREMENT,
   	USER_ID VARCHAR(20) NOT NULL,
   	USER_PW VARCHAR(20) NOT NULL,
   	APPROVE_AUTHORITY BOOLEAN,
   	PRIMARY KEY(USER_ID)
);

CREATE TABLE DOCUMENT_INFO (
	DOCUMENT_NUM BIGINT AUTO_INCREMENT,
	DOCUMENT_TITLE VARCHAR(30) NOT NULL,
	DOCUMENT_TYPE VARCHAR(30),
	DOCUMENT_CONTENTS VARCHAR(70),
	OWNER_USER_NUM BIGINT NOT NULL,
	APPROVE_STATUS CHAR(1) NOT NULL,
	APPROVE_USER_NUM BIGINT,
	APPROVE_LINE VARCHAR(50) NOT NULL,
	PRIMARY KEY(DOCUMENT_NUM)
);

CREATE TABLE DOCUMENT_APPROVE_LOG (
	DOCUMENT_NUM BIGINT,
	APPROVE_STATUS CHAR(1) NOT NULL,
    APPROVE_USER_NUM BIGINT NOT NULL,
	APPROVE_MESSAGE VARCHAR(100)
);