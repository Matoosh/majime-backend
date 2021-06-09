create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence manufacturer_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence out_of_spec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence supplier_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), created_by varchar(255), deleted varchar(255), district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), reason varchar(255), street varchar(255), primary key (id))
create table audit_log (id int8 not null, dml_created_by varchar(255), dml_reason varchar(255), dml_timestamp varchar(255), element_id int8, new_row_data jsonb, old_row_data jsonb, tab_name varchar(255), primary key (id))
create table batch (id int8 not null, created_by varchar(255), deleted varchar(255), internal_batch_no varchar(255), manufacturer_batch_no varchar(255), reason varchar(255), manufacturer_id int8, material_id int8, supplier_id int8, user_id int8, primary key (id))
create table certificate (id int8 not null, certificate_no varchar(255), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), batch_id int8, accepted_by int8, primary key (id))
create table lab (id int8 not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, created_by varchar(255), deleted varchar(255), email varchar(255), first_name varchar(255), last_name varchar(255), password varchar(255), phone varchar(255), reason varchar(255), lab_id int8, primary key (id))
create table manufacturer (id int8 not null, created_by varchar(255), deleted int4, name varchar(255), reason varchar(255), address_id int8, primary key (id))
create table material (id int8 not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), user_id int8, primary key (id))
create table out_of_spec (id int8 not null, complete_investigation varchar(255), created_by varchar(255), deleted int4, error varchar(255), name varchar(255), reason varchar(255), simple_investigation varchar(255), value varchar(255), result_id int8, primary key (id))
create table parameter (id int8 not null, accuracy varchar(255), border varchar(255), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), type varchar(255), unit varchar(255), specification_id int8, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result (id int8 not null, created_by varchar(255), deleted varchar(255), reason varchar(255), status varchar(255), value varchar(255), parameter_id int8, sample_id int8, user_id int8, primary key (id))
create table role (id int8 not null, deleted varchar(255), name varchar(255), primary key (id))
create table role_permission (role_id int8 not null, permission_id int8 not null)
create table sample (id int8 not null, created_at timestamp, created_by varchar(255), deleted varchar(255), name varchar(255), quantity int4 not null, reason varchar(255), sample_no varchar(50), status varchar(255), type varchar(255), batch_id int8, specification_id int8, primary key (id))
create table sample_lab (id int8 not null, created_by varchar(255), deleted varchar(255), quantity varchar(255), reason varchar(255), lab_id int8, sample_id int8, primary key (id))
create table sample_chart (id int8 not null, count int8, status varchar(255), type varchar(255), primary key (id))
create table sample_time (id int8 not null, avg float4, count int4, status varchar(255), type varchar(255), week int4, year int4, primary key (id))
create table specification (id int8 not null, confirmed varchar(1), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), specification_no varchar(50), status varchar(255), type varchar(255), unit varchar(255), accepted_by int8, material_id int8, user_id int8, primary key (id))
create table supplier (id int8 not null, created_by varchar(255), deleted int4, name varchar(255), reason varchar(255), address_id int8, primary key (id))
create table unit (id int8 not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), value varchar(255), user_id int8, primary key (id))
create table user_role (user_id int8 not null, role_id int8 not null)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references manufacturer
alter table if exists batch add constraint FK6mfdu0bhlfw7temo5gxp3g6bv foreign key (material_id) references material
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FKp04ap8lu3ldvwli3ohq998ukl foreign key (accepted_by) references lab_user
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists out_of_spec add constraint FKkg6indjf586gaf3c6ti7hja6b foreign key (result_id) references result
alter table if exists parameter add constraint FKas7wfsgc7h7ufgy5py8yqy563 foreign key (specification_id) references specification
alter table if exists result add constraint FK1slg1kk7a0wtottkl20d1j9g8 foreign key (parameter_id) references parameter
alter table if exists result add constraint FKqbsofayp40a5cw34s7q61ojk9 foreign key (sample_id) references sample
alter table if exists result add constraint FKr2nx6knvns6god678lnjh0tp2 foreign key (user_id) references lab_user
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists sample add constraint FKtouf1lnms1s4hc7dnv09gb788 foreign key (batch_id) references batch
alter table if exists sample add constraint FKiwk2q36r4s49m2olj0s2m3f9d foreign key (specification_id) references specification
alter table if exists sample_lab add constraint FK3d2qdmqacbhu62ivmtwcg4ohd foreign key (lab_id) references lab
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists specification add constraint FK5vjwndq6ugietd7tw12ow2vqr foreign key (accepted_by) references lab_user
alter table if exists specification add constraint FKi6o02juk5tog9yggcs3yvly2u foreign key (material_id) references material
alter table if exists specification add constraint FKbpa2y9wr2b80vwdwkixj8v9sb foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
alter table if exists unit add constraint FKiduykkp13q5thv4bxokqm7gn9 foreign key (user_id) references lab_user
alter table if exists user_role add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role
alter table if exists user_role add constraint FKpap1hs5b5p4mpdnlnwa8uuj5g foreign key (user_id) references lab_user
alter table role_permission add constraint role_permission_pk primary key (role_id, permission_id)
alter table user_role add constraint user_role_pk primary key (user_id, role_id)
