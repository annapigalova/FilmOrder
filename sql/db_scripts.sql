--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"USER_ID" NUMBER(8,0), 
	"LOGIN" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"LAST_NAME" VARCHAR2(50 BYTE), 
	"FIRST_NAME" VARCHAR2(25 BYTE), 
	"PHONE_NUM" VARCHAR2(15 BYTE), 
	"EMAIL" VARCHAR2(200 BYTE), 
	"ADMIN_FLG" NUMBER(1,0)
   ) 

--------------------------------------------------------
--  DDL for Table MOVIES
--------------------------------------------------------

  CREATE TABLE "MOVIES" 
   (	"MOVIE_ID" NUMBER(8,0), 
	"NAME" VARCHAR2(100 BYTE), 
	"DIRECTOR" VARCHAR2(100 BYTE), 
	"GENRE" VARCHAR2(50 BYTE), 
	"DURATION" NUMBER(4,0), 
	"DESCRIPTION" VARCHAR2(500 BYTE), 
	"PRICE" NUMBER(8,2)
   ) ;

--------------------------------------------------------
--  DDL for Table ORDERS
--------------------------------------------------------

  CREATE TABLE "ORDERS" 
   (	"ORDER_ID" NUMBER(8,0), 
	"MOVIE_ID" NUMBER(8,0), 
	"USER_ID" NUMBER(8,0), 
	"PAY_FLG" NUMBER(1,0), 
	"AMOUNT" NUMBER(8,2), 
	"ORDER_DT" DATE
   ) ;


--------------------------------------------------------
--  DDL for Table COMMENTS
--------------------------------------------------------

  CREATE TABLE  "COMMENTS" 
   (	"COMMENT_ID" NUMBER(8,0), 
	"USER_ID" NUMBER(8,0), 
	"MOVIE_ID" NUMBER(8,0), 
	"TEXT" VARCHAR2(500 BYTE), 
	"COMMENT_DTTM" TIMESTAMP (6)
   );

   CREATE SEQUENCE  "COMMENTS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 8 CACHE 20 NOORDER  NOCYCLE ;
   CREATE SEQUENCE  "ORDERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;    
   CREATE SEQUENCE  "USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 7 CACHE 20 NOORDER  NOCYCLE ;

Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (1,'ghost','ghost','ghost','ghost','123','ghost',0);
Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (2,'anakonda91','123456','Konda','Ana','+375297623535','anakonda@gmail.com',0);
Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (3,'anya','anya','pigalova','anna','+375293216565','a@gmail.com',0);
Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (4,'admin','admin','admin','admin','+375293214545','admin@gmail.com',1);
Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (5,'beeeye','beeeye','beeeye','beeeye','456890','beeeye',0);
Insert into USERS (USER_ID,LOGIN,PASSWORD,LAST_NAME,FIRST_NAME,PHONE_NUM,EMAIL,ADMIN_FLG) values (6,'oleg','oleg','sl','olef','+375293216865','o@gmail.com',0);
commit;
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (1,'Dogville','Fon Trier','Drama',160,null,500);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (2,'5 element','Luk','Drama',150,null,600);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (3,'Star wars','Lukas J.','Drama',500,null,1500);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (4,'Taxi','Fon Trier','Comedy',100,null,500);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (5,'Lord of the rings',null,'Drama',180,null,1000);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (6,'Matrix',null,'Drama',160,null,500);
Insert into MOVIES (MOVIE_ID,NAME,DIRECTOR,GENRE,DURATION,DESCRIPTION,PRICE) values (7,'Twin Peaks','Lynch D.','detective',810,'famous serial from Lynch',750);
commit;



