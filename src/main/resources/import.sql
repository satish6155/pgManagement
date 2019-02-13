Insert into COUNTRY (ID,ACTIVE_FLAG,COUNTRY_ISD_CODE,COUNTRY_ISO_CODE,COUNTRY_NAME,NATIONALITY) values (1,1,'91','IND','INDIA','INDIA');
Insert into STATE (ID,ACTIVE_FLAG,STATE_CODE,STATE_NAME,COUNTRY) values (1,1,'1','MAHARASHTRA',1);
Insert into CITY (ID,ACTIVE_FLAG,CITY_CODE,CITY_NAME,STD_CODE,STATE) values (496,1,'496','MUMBAI','22',1);
Insert into ZIP_CODE (ID,ACTIVE_FLAG,PLACE_NAME,ZIP_CODE,CITY) values (23005,1,'MALABAR HILL - 400006','400006',496);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (1,'AddressType','OfficeAddress','Office/ Business Address',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (2,'AddressType','PermanentAddress','Permanent Address',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (3,'AddressType','ResidentialAddress','Residential Address',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (4,'GenderType','Male','Male',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (5,'GenderType','Female','Female',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (6,'GenderType','NotSpecified','Not Specified',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (7,'UserRole','Owner','Owner',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (8,'UserRole','Manager','Manager',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (9,'UserRole','CareTaker','Care Taker',1);
Insert into generic_parameter (ID,DTYPE,CODE,DESCRIPTION,ACTIVE_FLAG) values (10,'UserRole','Admin','Admin',1);

Insert into pg_user (ID,STATUS,AGE,CREATION_TIME_STAMP,EMAIL,FIRST_NAME,LAST_NAME,LAST_UPDATED_TIME_STAMP,MOBILE_NUMBER,PASSWORD,USERNAME,role,gender) values (1,1,0,null,null,'Satish','Verma',null,8744956983,'123','sat',10,4);
Insert into pg_user (ID,STATUS,AGE,CREATION_TIME_STAMP,EMAIL,FIRST_NAME,LAST_NAME,LAST_UPDATED_TIME_STAMP,MOBILE_NUMBER,PASSWORD,USERNAME,role,gender) values (2,1,0,null,null,'Deepali','Jain',null,96523589652,'123','dee',7,5);
Insert into pg_user (ID,STATUS,AGE,CREATION_TIME_STAMP,EMAIL,FIRST_NAME,LAST_NAME,LAST_UPDATED_TIME_STAMP,MOBILE_NUMBER,PASSWORD,USERNAME,CREATED_BY,LAST_UPDATED_BY,GENDER,ROLE) values (3,1,0,null,null,'Vishal','Tyagi',null,85412589652,'123','vis',2,null,4,7);


