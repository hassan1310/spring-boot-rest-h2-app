insert into user_details(id,birth_date,name)
values(10001, current_date(), 'Ranga');

insert into user_details(id,birth_date,name)
values(10002, current_date(), 'Ravi');

insert into user_details(id,birth_date,name)
values(10003, current_date(), 'Sathish');

insert into post(id,description,POSTING_TIME,user_id)
values(20001,'I want to learn AWS', current_date(), 10001);

insert into post(id,description,POSTING_TIME,user_id)
values(20002,'I want to learn DevOps', current_date(), 10001);

insert into post(id,description,POSTING_TIME,user_id)
values(20003,'I want to Get AWS Certified', current_date(), 10002);

insert into post(id,description,POSTING_TIME,user_id)
values(20004,'I want to learn Multi Cloud', current_date(), 10002);