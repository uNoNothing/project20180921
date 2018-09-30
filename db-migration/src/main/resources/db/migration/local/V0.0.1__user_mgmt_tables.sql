create table address_info (id integer not null auto_increment, disabled bit not null, uuid varchar(255) not null, created_by varchar(255) not null, created_date varchar(255) not null, updated_date varchar(255), updated_by varchar(255), preferred bit not null, address1 varchar(255) not null, address2 varchar(255), address3 varchar(255), city varchar(255) not null, country varchar(255) not null, state varchar(255) not null, type varchar(255) not null, zip varchar(255) not null, user_id integer not null, primary key (id)) engine=InnoDB;

create table email_info (id integer not null auto_increment, disabled bit not null, uuid varchar(255) not null, created_by varchar(255) not null, created_date varchar(255) not null, updated_date varchar(255), updated_by varchar(255), preferred bit not null, email varchar(255) not null, type varchar(255) not null, user_id integer not null, primary key (id)) engine=InnoDB;

create table name_info (id integer not null auto_increment, disabled bit not null, uuid varchar(255) not null, created_by varchar(255) not null, created_date varchar(255) not null, updated_date varchar(255), updated_by varchar(255), preferred bit not null, first_name varchar(255) not null, last_name varchar(255) not null, middle_name varchar(255), title varchar(255), user_id integer not null, primary key (id)) engine=InnoDB;

create table phone_info (id integer not null auto_increment, disabled bit not null, uuid varchar(255) not null, created_by varchar(255) not null, created_date varchar(255) not null, updated_date varchar(255), updated_by varchar(255), preferred bit not null, phone varchar(255), type varchar(255) not null, user_id integer not null, primary key (id)) engine=InnoDB;

create table user_info (id integer not null auto_increment, disabled bit not null, uuid varchar(255) not null, created_by varchar(255) not null, created_date varchar(255) not null, updated_date varchar(255), updated_by varchar(255), username varchar(255), primary key (id)) engine=InnoDB;

alter table user_info add constraint UK_userName unique (username);

alter table address_info add constraint FK_addressInfo_userInfo foreign key (user_id) references user_info (id);

alter table email_info add constraint FK_emailInfo_userInfo foreign key (user_id) references user_info (id);

alter table name_info add constraint FK_nameInfo_userInfo foreign key (user_id) references user_info (id);

alter table phone_info add constraint FK_phoneInfo_userInfo foreign key (user_id) references user_info (id);