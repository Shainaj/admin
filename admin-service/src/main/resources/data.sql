insert into UserInfo values ('sanadaf', 'Saleem Nadaf', 'saleem.nadaf@capgemini.com','admin');
insert into UserInfo values ('abhilasha', 'Abhilasha', 'saleem.nadaf@capgemini.com','user');
insert into UserInfo values ('Sahoo', 'Sahoo Ram', 'saho.ram@capgemini.com','user');

insert into AuthorizationInfo values ('sanadaf', 'Saleem@123', CURRENT_TIMESTAMP());
insert into AuthorizationInfo values ('abhilasha', 'Abhilasha@123', CURRENT_TIMESTAMP());

insert into LeaveInfo values (1122, 'abhilasha', 'Privilege Leave', 'Full Day', '2022-09-20', CURRENT_TIMESTAMP());
insert into LeaveInfo values (1123, 'Sahoo', 'Privilege Leave', 'Full Day', '2022-09-21', CURRENT_TIMESTAMP());

insert into ApprovalInfo values (1, 'sanadaf', 1122, 'Approved',CURRENT_TIMESTAMP());





