create sequence address_id_seq start with 1 increment by 1
create sequence batch_id_seq start with 1 increment by 1
create sequence certificate_id_seq start with 1 increment by 1
create sequence lab_id_seq start with 1 increment by 1
create sequence lab_user_id_seq start with 1 increment by 1
create sequence manufacturer_id_seq start with 1 increment by 1
create sequence material_id_seq start with 1 increment by 1
create sequence out_of_spec_id_seq start with 1 increment by 1
create sequence parameter_id_seq start with 1 increment by 1
create sequence permission_id_seq start with 1 increment by 1
create sequence result_id_seq start with 1 increment by 1
create sequence result_status_history_id_seq start with 1 increment by 1
create sequence role_id_seq start with 1 increment by 1
create sequence role_permission_id_seq start with 1 increment by 1
create sequence sample_id_seq start with 1 increment by 1
create sequence sample_lab_id_seq start with 1 increment by 1
create sequence sample_status_history_id_seq start with 1 increment by 1
create sequence specification_id_seq start with 1 increment by 1
create sequence specification_status_history_id_seq start with 1 increment by 1
create sequence supplier_id_seq start with 1 increment by 1
create sequence unit_id_seq start with 1 increment by 1
create table address (id bigint not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), created_by varchar(255), deleted varchar(255), district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), reason varchar(255), street varchar(255), primary key (id))
create table batch (id bigint not null, created_by varchar(255), deleted varchar(255), internal_batch_no varchar(255), manufacturer_batch_no varchar(255), reason varchar(255), manufacturer_id bigint, supplier_id bigint, user_id bigint, primary key (id))
create table certificate (id bigint not null, certificate_no varchar(255), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), batch_id bigint, accepted_by bigint, primary key (id))
create table lab (id bigint not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), address_id bigint, primary key (id))
create table lab_user (id bigint not null, created_by varchar(255), deleted varchar(255), email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), reason varchar(255), lab_id bigint, role_id bigint, primary key (id))
create table manufacturer (id bigint not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), address_id bigint, primary key (id))
create table material (id bigint not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), user_id bigint, primary key (id))
create table out_of_spec (id bigint not null, complete_investigation varchar(255), created_by varchar(255), deleted varchar(255), error varchar(255), name varchar(255), reason varchar(255), simple_investigation varchar(255), value varchar(255), result_id bigint, primary key (id))
create table parameter (id bigint not null, accuracy varchar(255), border varchar(255), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), type varchar(255), specification_id bigint, unit_id bigint, primary key (id))
create table permission (id bigint not null, code varchar(255), created_by varchar(255), deleted varchar(255), description varchar(255), name varchar(255), reason varchar(255), primary key (id))
create table result (id bigint not null, created_by varchar(255), deleted varchar(255), reason varchar(255), status integer, value varchar(255), parameter_id bigint, sample_id bigint, user_id bigint, primary key (id))
create table result_status_history (id bigint not null, created_by varchar(255), deleted varchar(255), new_value varchar(50), old_value varchar(50), reason varchar(255), result_id bigint, user_id bigint, primary key (id))
create table role (id bigint not null, code varchar(255), created_by varchar(255), deleted varchar(255), description varchar(255), name varchar(255), reason varchar(255), primary key (id))
create table role_permission (id bigint not null, created_by varchar(255), deleted varchar(255), reason varchar(255), permission_id bigint, role_id bigint, primary key (id))
create table sample (id bigint not null, created_by varchar(255), deleted varchar(255), quantity integer not null, reason varchar(255), sample_no varchar(50), status varchar(255), type varchar(255), batch_id bigint, specification_id bigint, primary key (id))
create table sample_lab (id bigint not null, created_by varchar(255), deleted varchar(255), quantity varchar(255), reason varchar(255), lab_id bigint, sample_id bigint, primary key (id))
create table sample_status_history (id bigint not null, created_by varchar(255), deleted varchar(255), new_value varchar(50), old_value varchar(50), reason varchar(255), sample_id bigint, user_id bigint, primary key (id))
create table specification (id bigint not null, confirmed varchar(1), created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), specification_no varchar(50), status integer, type varchar(255), accepted_by bigint, material_id bigint, user_id bigint, primary key (id))
create table specification_status_history (id bigint not null, created_by varchar(255), deleted varchar(255), new_value varchar(50), old_value varchar(50), reason varchar(255), specification_id bigint, user_id bigint, primary key (id))
create table supplier (id bigint not null, created_by varchar(255), deleted varchar(255), name varchar(50), reason varchar(255), address_id bigint, primary key (id))
create table unit (id bigint not null, created_by varchar(255), deleted varchar(255), name varchar(255), reason varchar(255), value varchar(255), user_id bigint, primary key (id))
alter table specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references manufacturer
alter table batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table certificate add constraint FKp04ap8lu3ldvwli3ohq998ukl foreign key (accepted_by) references lab_user
alter table lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table out_of_spec add constraint FKkg6indjf586gaf3c6ti7hja6b foreign key (result_id) references result
alter table parameter add constraint FKas7wfsgc7h7ufgy5py8yqy563 foreign key (specification_id) references specification
alter table parameter add constraint FKh1hlqyu8cbc79uuquvswh6es0 foreign key (unit_id) references unit
alter table result add constraint FK1slg1kk7a0wtottkl20d1j9g8 foreign key (parameter_id) references parameter
alter table result add constraint FKqbsofayp40a5cw34s7q61ojk9 foreign key (sample_id) references sample
alter table result add constraint FKr2nx6knvns6god678lnjh0tp2 foreign key (user_id) references lab_user
alter table result_status_history add constraint FKa39f47s74pilpr6ccfvl8ce77 foreign key (result_id) references result
alter table result_status_history add constraint FKshiy2ok5ikcwxp5mj1a5g7ke8 foreign key (user_id) references lab_user
alter table role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table sample add constraint FKtouf1lnms1s4hc7dnv09gb788 foreign key (batch_id) references batch
alter table sample add constraint FKiwk2q36r4s49m2olj0s2m3f9d foreign key (specification_id) references specification
alter table sample_lab add constraint FK3d2qdmqacbhu62ivmtwcg4ohd foreign key (lab_id) references lab
alter table sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table specification add constraint FK5vjwndq6ugietd7tw12ow2vqr foreign key (accepted_by) references lab_user
alter table specification add constraint FKi6o02juk5tog9yggcs3yvly2u foreign key (material_id) references material
alter table specification add constraint FKbpa2y9wr2b80vwdwkixj8v9sb foreign key (user_id) references lab_user
alter table specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
alter table unit add constraint FKiduykkp13q5thv4bxokqm7gn9 foreign key (user_id) references lab_user
