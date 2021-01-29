create table public.user (id int8 not null, batch_id int4 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), status int4 not null, primary key (id))
create sequence hibernate_sequence start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create table sample (id int8 not null, batch_id int4 not null, quantity int4 not null, sample_no varchar(255), specification_id int4 not null, status int4 not null, user_id int8, primary key (id))
alter table if exists sample add constraint FKeugkgqdrooa9puw83rae7pu6b foreign key (user_id) references public.user
create table public.user (id int8 not null, batch_id int4 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), status int4 not null, primary key (id))
create sequence hibernate_sequence start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create table sample (id int8 not null, batch_id int4 not null, quantity int4 not null, sample_no varchar(255), specification_id int4 not null, status int4 not null, user_id int8, primary key (id))
alter table if exists sample add constraint FKeugkgqdrooa9puw83rae7pu6b foreign key (user_id) references public.user
create table public.user (id int8 not null, batch_id int4 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), status int4 not null, primary key (id))
create sequence hibernate_sequence start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create table sample (id int8 not null, batch_id int4 not null, quantity int4 not null, sample_no varchar(255), specification_id int4 not null, status int4 not null, user_id int8, primary key (id))
alter table if exists sample add constraint FKeugkgqdrooa9puw83rae7pu6b foreign key (user_id) references public.user
