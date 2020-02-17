create table reservation (id bigserial not null, date_from date, date_to date, total_price numeric(19, 2),
 advertisement bigserial not null, renter varchar(255) not null, primary key (id), unique (date_from, date_to));

alter table reservation add constraint user_account_fk foreign key (renter) references user_account (username);

alter table reservation add constraint advertisement_fk foreign key (advertisement) references advertisement (code);

alter table advertisement alter column owner_username set not null;