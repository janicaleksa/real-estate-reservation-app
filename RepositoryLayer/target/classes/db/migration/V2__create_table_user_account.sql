create table user_account (username varchar(255) not null, user_password varchar(255) not null,
 firstname varchar(255), lastname varchar(255), email varchar(255), date_of_birth date, phone_number varchar(255),
 gender varchar(255), city varchar(255), primary key (username));
 
 alter table advertisement add column owner_username varchar(255);
 
 alter table advertisement add constraint user_account_fk foreign key (owner_username) references user_account (username);
 