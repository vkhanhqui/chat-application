create database detai1;

use detai1;

create login mylogin with password = 'mylogin';
sp_changedbowner mylogin;

create table account(
	username char(30) primary key not null,
	password char(30) not null	
);

insert into account values('KhanhQui','1');
insert into account values('PhucNguyen','1');
insert into account values('LongMap','1');
insert into account values('TanPhat','1');
insert into account values('GiangHoa','1');
insert into account values('QuangHung','1');
insert into account values('GiaHuy','1');
insert into account values('QuocGia','1');

select * 
from account
where username='KhanhQui'
and password = '1';

