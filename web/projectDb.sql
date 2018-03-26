use [HrsystemDatabase]



create table applicants
(
ID int primary key,
Name varchar(255),
SecondName varchar(255),
UserName varchar(255),
loginpassword varchar(255),
CNIC varchar(255),
CellNo varchar(255),
profilepic varchar(255),
coverphoto varchar(255),
postalcode varchar(255),
city varchar(255),
applicantaddress varchar(255),
email varchar(255),
);




create table sme
(
Id int primary key,
Name varchar(255),
username varchar(255),
loginpassword varchar(255),
profilepic varchar(255),
coverphoto varchar(255),
specialiazations varchar(255),
lettersent bit
);


alter table sme add CNIC varchar(255)
drop table sme

create table hrpersonal
(
Id int primary key,
Name varchar(255),
username varchar(255),
loginpassword varchar(255),
profilepic varchar(255),
coverphoto varchar(255),
);

create table hrmanager
(
Id int primary key,
Name varchar(255),
username varchar(255),
loginpassword varchar(255),
profilepic varchar(255),
coverphoto varchar(255),
);


create table jobsdetail
(
id int primary key,
picture varchar(255),
jobtitle varchar(255),
jobdescription varchar(255),
resposibilities varchar(255),
jobbrief varchar (255),
requirements varchar(255)
);



create table jobsadvertised
(
personalid int,
jobid int,
FOREIGN KEY (personalid) references hrpersonal(Id),
FOREIGN KEY (jobid) references jobsdetail(id)
);


create trigger triggerforjobadvertisedupdate
on jobsdetail
for insert 
as
@jobid = select jobid from inserted
insert into jobsadvertised values(1,@jobid)




create table applicantapplying
(
applicationid int primary key,
whywantoapply varchar (255),
cvfilepath varchar(255),
experience varchar(255),
applicantid int,
jobid int,
FOREIGN KEY (applicantid) references applicants(ID),
FOREIGN KEY (jobid) references jobsdetail(id)
);

create table cvrejectionletter
(
letter varchar(500),
applicantid int,
jobid int,
FOREIGN KEY (applicantid) references applicants(ID), 
FOREIGN KEY (jobid) references jobsdetail(id)
);

create table lettertosme
(
letter varchar(500),
smeid int,
FOREIGN KEY (smeid) references sme(Id), 
);

create table replyfromsme
(
timeanddate datetime,
smeid int,
FOREIGN KEY (smeid) references sme(Id)
);

create table interviewcall
(
applicantid int,
letter varchar(255),
dateandtime datetime,
FOREIGN KEY (applicantid) references applicants(ID)
);

create table sendittosme
(
smeid int,
applicantid int,
FOREIGN KEY (smeid) references sme(Id),
FOREIGN KEY (smeid) references applicants(ID),
);



create table interviewquestions
(
interviewid int primary key,
Name varchar(400),
workedbefore varchar(400),
Whyyouleftyourpreviousjob varchar(400),
Whyyouwanttoapplyforthisjob varchar(400),
Uploadyourcvhere varchar(400),
payexpecting varchar(400),
noofchildren varchar(400),
achievements varchar(400),
extracirricularactivities varchar(400),
favouriteHobies varchar(400),
projects varchar (400),
GPA decimal,
goodandbadmovements varchar(400),
);

create table interviewrecords
(
interviewid int,
applicantid int,
FOREIGN KEY (interviewid) references interviewquestions(interviewid),
FOREIGN KEY (applicantid) references applicants(ID)
);



create table reviewoninterviewbysme
(
interviewid int,
smeid int,
userid int,
generalcomments varchar(400),
hireapplicant bit,
rating varchar(50),
FOREIGN KEY (userid) references applicants(ID),
FOREIGN KEY (smeid) references sme(Id),
FOREIGN KEY (interviewid) references interviewquestions(interviewid)
);


create table reviewoninterviewbyhrpersonal
(
interviewid int,
userid int,
generalcomments varchar(400),
hireapplicant bit,
rating varchar(50),
FOREIGN KEY (userid) references applicants(ID),
FOREIGN KEY (interviewid) references interviewquestions(interviewid)
);

create table rejectionletterfromhrmanager
(
applicantid int primary key,
letter varchar(400),
FOREIGN KEY (applicantid) references applicants(ID),
);

create table interviewquestionsfromhrmanager
(
interviewid int primary key,
whytojoinus varchar(400),
hobbies varchar(400),
salary int,
noofchildren int
);

create table hrmanagerinterviewrecord
(
interviewid int,
applicantid int,

FOREIGN KEY (interviewid) references interviewquestionsfromhrmanager(interviewid),
FOREIGN KEY (applicantid) references interviewquestionsfromhrmanager(interviewid)
);


create table jobofferfromhrmanager
(
letter varchar(400),
applicantid int,
FOREIGN KEY (applicantid) references applicants(ID) 
);

create table jobrejectionfromhrmanager
(
letter varchar(400),
applicantid int,
FOREIGN KEY (applicantid) references applicants(ID) 

);



























create trigger trigger_forupdate
on lettertosme
for update 
as
update sme 
set lettersent = 1
where Id = (select smeid from deleted)












drop table cvrejectionletter


select * from applicants;
select * from hrmanager;
select * from hrpersonal;
select * from jobsadvertised;
select * from jobsdetail;
select * from sme;
select * from applicantapplying



