create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, parameter_id int8, sample_id int8, status int4 not null, user_id int8, value varchar(255), primary key (id))
create table public.unit (id int8 not null, name varchar(255), user_id int8, value varchar(255), primary key (id))
create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence dictionary_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence outofspec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence result_status_history_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence role_permission_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence sample_status_history_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence specification_status_history_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), deleted char(1) not null, district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), street varchar(255), primary key (id))
create table batch (id int8 not null, batch_no varchar(255), deleted char(1) not null, user_id int8, manufacturer_id int8, supplier_id int8, primary key (id))
create table certificate (id int8 not null, accepted_by int8, batch_id int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table lab (id int8 not null, adress_id varchar(255), deleted char(1) not null, name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), lab_id int8, last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), role_id int8, primary key (id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table outofspec (id int8 not null, error char(1) not null, result_id int8, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), result_id int8, user_id int8, primary key (id))
create table role (id int8 not null, name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), material_id int8, specification_no varchar(50), status int8, user_id int8, primary key (id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, parameter_id int8, sample_id int8, status int4 not null, user_id int8, value varchar(255), primary key (id))
create table public.unit (id int8 not null, name varchar(255), user_id int8, value varchar(255), primary key (id))
create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence dictionary_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence outofspec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence result_status_history_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence role_permission_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence sample_status_history_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence specification_status_history_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), deleted char(1) not null, district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), street varchar(255), primary key (id))
create table batch (id int8 not null, batch_no varchar(255), deleted char(1) not null, user_id int8, manufacturer_id int8, supplier_id int8, primary key (id))
create table certificate (id int8 not null, accepted_by int8, batch_id int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table lab (id int8 not null, adress_id varchar(255), deleted char(1) not null, name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), lab_id int8, last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), role_id int8, primary key (id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table outofspec (id int8 not null, error char(1) not null, result_id int8, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), result_id int8, user_id int8, primary key (id))
create table role (id int8 not null, name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), material_id int8, specification_no varchar(50), status int8, user_id int8, primary key (id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, parameter_id int8, sample_id int8, status int4 not null, user_id int8, value varchar(255), primary key (id))
create table public.unit (id int8 not null, name varchar(255), user_id int8, value varchar(255), primary key (id))
create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence dictionary_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence outofspec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence result_status_history_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence role_permission_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence sample_status_history_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence specification_status_history_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), deleted char(1) not null, district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), street varchar(255), primary key (id))
create table batch (id int8 not null, batch_no varchar(255), deleted char(1) not null, user_id int8, manufacturer_id int8, supplier_id int8, primary key (id))
create table certificate (id int8 not null, accepted_by int8, batch_id int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table lab (id int8 not null, adress_id varchar(255), deleted char(1) not null, name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), lab_id int8, last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), role_id int8, primary key (id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table outofspec (id int8 not null, error char(1) not null, result_id int8, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), result_id int8, user_id int8, primary key (id))
create table role (id int8 not null, name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), material_id int8, specification_no varchar(50), status int8, user_id int8, primary key (id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, parameter_id int8, sample_id int8, status int4 not null, user_id int8, value varchar(255), primary key (id))
create table public.unit (id int8 not null, name varchar(255), user_id int8, value varchar(255), primary key (id))
create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence dictionary_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence outofspec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence result_status_history_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence role_permission_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence sample_status_history_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence specification_status_history_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), deleted char(1) not null, district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), street varchar(255), primary key (id))
create table batch (id int8 not null, batch_no varchar(255), deleted char(1) not null, user_id int8, manufacturer_id int8, supplier_id int8, primary key (id))
create table certificate (id int8 not null, accepted_by int8, batch_id int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table lab (id int8 not null, adress_id varchar(255), deleted char(1) not null, name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), lab_id int8, last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), role_id int8, primary key (id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table outofspec (id int8 not null, error char(1) not null, result_id int8, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), result_id int8, user_id int8, primary key (id))
create table role (id int8 not null, name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), material_id int8, specification_no varchar(50), status int8, user_id int8, primary key (id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, parameter_id int8, sample_id int8, status int4 not null, user_id int8, value varchar(255), primary key (id))
create table public.unit (id int8 not null, name varchar(255), user_id int8, value varchar(255), primary key (id))
create sequence address_id_seq start 1 increment 1
create sequence batch_id_seq start 1 increment 1
create sequence certificate_id_seq start 1 increment 1
create sequence dictionary_id_seq start 1 increment 1
create sequence lab_id_seq start 1 increment 1
create sequence lab_user_id_seq start 1 increment 1
create sequence material_id_seq start 1 increment 1
create sequence outofspec_id_seq start 1 increment 1
create sequence parameter_id_seq start 1 increment 1
create sequence permission_id_seq start 1 increment 1
create sequence result_id_seq start 1 increment 1
create sequence result_status_history_id_seq start 1 increment 1
create sequence role_id_seq start 1 increment 1
create sequence role_permission_id_seq start 1 increment 1
create sequence sample_id_seq start 1 increment 1
create sequence sample_lab_id_seq start 1 increment 1
create sequence sample_status_history_id_seq start 1 increment 1
create sequence specification_id_seq start 1 increment 1
create sequence specification_status_history_id_seq start 1 increment 1
create sequence unit_id_seq start 1 increment 1
create table address (id int8 not null, apartment_number varchar(255), city varchar(255), country_code varchar(255), deleted char(1) not null, district varchar(255), house_number varchar(255), post_code varchar(255), post_office varchar(255), street varchar(255), primary key (id))
create table batch (id int8 not null, batch_no varchar(255), deleted char(1) not null, user_id int8, manufacturer_id int8, supplier_id int8, primary key (id))
create table certificate (id int8 not null, accepted_by int8, batch_id int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table lab (id int8 not null, adress_id varchar(255), deleted char(1) not null, name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), lab_id int8, last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), role_id int8, primary key (id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table outofspec (id int8 not null, error char(1) not null, result_id int8, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), result_id int8, user_id int8, primary key (id))
create table role (id int8 not null, name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), material_id int8, specification_no varchar(50), status int8, user_id int8, primary key (id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
