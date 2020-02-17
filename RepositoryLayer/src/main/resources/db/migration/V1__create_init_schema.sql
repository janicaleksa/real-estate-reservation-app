create table advertisement (code  bigserial not null, advertisement_date date, description text,
 price numeric(19, 2), real_estate_name varchar(255), address varchar(255), quadrature int4, capacity int4,
  category varchar(255), city varchar(255), primary key (code));