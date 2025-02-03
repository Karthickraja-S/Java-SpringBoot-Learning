## Used MSSQL Database

create table Apartment (
id int IDENTITY(1, 1) NOT NULL primary key,
name varchar(50) not null,
areaLocated varchar(70) not null,
noOfFlatsAvailable int not null,
noOfFlatsSold int default 0,
ratePerFlat int not null CHECK (ratePerFlat > 0)
)

insert into Apartment(name,arealocated,noofflatsavailable,rateperflat) values('ABC Apartments','KR Puram',10,1500000)
insert into Apartment(name,arealocated,noofflatsavailable,rateperflat) values('XYZ Apartments','KR Puram',20,1500000)
insert into Apartment(name,arealocated,noofflatsavailable,rateperflat) values('SK Apartments' ,'Chennai' ,15,1000000)