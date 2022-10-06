insert into UserInfo values ('sanadaf', 'Saleem Nadaf', 'saleem.nadaf@capgemini.com','admin', 'Tanmaya');
insert into UserInfo values ('abhilasha', 'Abhilasha', 'abhilasha@capgemini.com','user', 'Saleem');
insert into UserInfo values ('sahoo', 'Sahoo Ram', 'saho.ram@capgemini.com','user','Saleem');
insert into UserInfo values ('akshay', 'Akshay', 'akshay@capgemini.com','user', 'Saleem');
insert into UserInfo values ('sunil', 'Sunil K', 'sunil@capgemini.com','user','Saleem');
insert into UserInfo values ('basha', 'Imtiaz B', 'imtiaz.basha@capgemini.com','user','Saleem');

insert into AuthorizationInfo values ('sanadaf', 'Saleem@123', CURRENT_TIMESTAMP());
insert into AuthorizationInfo values ('abhilasha', 'Abhilasha@123', CURRENT_TIMESTAMP());

insert into LeaveInfo values (1121, 'abhilasha', 'Privilege Leave', 'Full Day', '2022-09-20', '2022-09-21','Not well');
insert into LeaveInfo values (1122, 'sahoo', 'Privilege Leave', 'Full Day', '2022-09-22', '2022-09-24','Not well' );
insert into LeaveInfo values (1123, 'akshay', 'Privilege Leave', 'Full Day', '2022-09-24', '2022-09-25','Not well');
insert into LeaveInfo values (1124, 'sunil', 'Privilege Leave', 'Full Day', '2022-09-23', '2022-09-26','Not well' );
insert into LeaveInfo values (1125, 'basha', 'Privilege Leave', 'Full Day', '2022-09-28', '2022-09-29','Not well');

insert into ApprovalInfo values (1, 'sanadaf', 1122, 'Approved', 'approved admin' , CURRENT_TIMESTAMP());

insert into TimeCardInfo values (111, 'abhilasha', 122334, 'volkswagen', '2022-09-24', 'time entry');
insert into TimeCardInfo values (112, 'sahoo', 122334, 'volkswagen', '2022-09-24', 'time entry');





