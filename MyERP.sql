select * from ERP_Resources;
insert into ERP_Resources values(1,'ProjectName','MyJob','String');
update ERP_Resources set name='ProjectName', Value='MyJob' where Name='MyJob';
commit;

select * from ERP_Job;
