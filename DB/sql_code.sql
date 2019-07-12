CREATE TABLE PROJECT2USERS
   	("USERID" NUMBER NOT NULL ENABLE, 
    "USER_EMAIL" VARCHAR2(255) NOT NULL UNIQUE,
	"USERPASSWORD" VARCHAR2(20) NOT NULL, 
	"FIRSTNAME" VARCHAR2(20), 
	"LASTNAME" VARCHAR2(20),
	"PHONE_NUMBER" VARCHAR2(10),
	"ADDRESS" VARCHAR2(255),
	"CITY" VARCHAR2(30),
	"STATE" VARCHAR2(20),
	CONSTRAINT "PROJECT2_USER_ID_PK" PRIMARY KEY ("USERID"))
	
	CREATE TABLE PROJECT2AGENDA
   (	"AGENDA_ID" NUMBER NOT NULL ENABLE, 
    "DATE" DATE,
	"TASK" VARCHAR2(255), 
	"DURATION" NUMBER(20), 
	"IMAGES" BLOB,
	"LOCATION" VARCHAR2(255),
	"USERID" NUMBER,
	CONSTRAINT "PROJECT2_AGENDA_ID_PK" PRIMARY KEY ("AGENDA_ID"))
	
	DROP TABLE PROJECT2AGENDA;
	
	CREATE TABLE PROJECT2CONTACTLIST
   (	"CONTACTLIST_ID" NUMBER NOT NULL ENABLE, 
    "CONTACT_EMAIL" VARCHAR2(255) NOT NULL UNIQUE,
	"FIRSTNAME" VARCHAR2(20), 
	"LASTNAME" VARCHAR2(20),
	"PHONE_NUMBER" VARCHAR2(10),
	"ADDRESS" VARCHAR2(255),
	"CITY" VARCHAR2(30),
	"STATE" VARCHAR2(20),
	"USERID" NUMBER,
	CONSTRAINT "PROJECT2_CONTACT_ID_PK" PRIMARY KEY ("CONTACTLIST_ID"))

CREATE TABLE PROJECT2CONTACTLIST
   (	"REIMBURSEMENTID" NUMBER NOT NULL ENABLE, 
    "DATE" DATE NOT NULL UNIQUE,
	"STATUS" VARCHAR2(20) NOT NULL, 
	"AMOUNT" NUMBER(20) NOT NULL,
	"EMPLOYEEID" NUMBER,
	"MANAGERID" NUMBER,
	CONSTRAINT "REIMBURSEMENT_ID_PK" PRIMARY KEY ("REIMBURSEMENTID"))
	
	ALTER TABLE  PROJECT2CONTACTLIST
	ADD CONSTRAINT "P2_USER_FK" FOREIGN KEY ("USERID")
	  REFERENCES PROJECT2USERS ("USERID") ON DELETE CASCADE
	
	  	ALTER TABLE  PROJECT2AGENDA
	ADD CONSTRAINT "P2AGENDA_USER_FK" FOREIGN KEY ("USERID")
	  REFERENCES PROJECT2USERS ("USERID") ON DELETE CASCADE

ALTER TABLE MARTIS73.PROJECT2AGENDA ADD TASK_ID NUMBER NOT NULL;