create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, status int4 not null, value varchar(255), dictionary_id int8, primary key (id))
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
create table batch (id int8 not null, batch_no varchar(255), deleted varchar(1), manufacturer_id int8, supplier_id int8, user_id int8, primary key (id))
create table batch_batch_certificates (batch_id int8 not null, batch_certificates_id int8 not null, primary key (batch_id, batch_certificates_id))
create table certificate (id int8 not null, accepted_by int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), batch_id int8, user_id int8, primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table dictionary_dictionary_result (dictionary_id int8 not null, dictionary_result_id int8 not null, primary key (dictionary_id, dictionary_result_id))
create table dictionary_dictionary_sample (dictionary_id int8 not null, dictionary_sample_id int8 not null, primary key (dictionary_id, dictionary_sample_id))
create table dictionary_dictionary_specification (dictionary_id int8 not null, dictionary_specification_id int8 not null, primary key (dictionary_id, dictionary_specification_id))
create table lab (id int8 not null, deleted varchar(1), name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), lab_id int8, role_id int8, primary key (id))
create table lab_user_batches (user_id int8 not null, batches_id int8 not null, primary key (user_id, batches_id))
create table lab_user_certificates (user_id int8 not null, certificates_id int8 not null, primary key (user_id, certificates_id))
create table lab_user_materials (user_id int8 not null, materials_id int8 not null, primary key (user_id, materials_id))
create table lab_user_results (user_id int8 not null, results_id int8 not null, primary key (user_id, results_id))
create table lab_user_result_status_histories (user_id int8 not null, result_status_histories_id int8 not null, primary key (user_id, result_status_histories_id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table lab_user_sample_status_histories (user_id int8 not null, sample_status_histories_id int8 not null, primary key (user_id, sample_status_histories_id))
create table lab_user_specifications (user_id int8 not null, specifications_id int8 not null, primary key (user_id, specifications_id))
create table lab_user_specification_status_histories (user_id int8 not null, specification_status_histories_id int8 not null, primary key (user_id, specification_status_histories_id))
create table lab_user_units (user_id int8 not null, units_id int8 not null, primary key (user_id, units_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table material_material_specifications (material_id int8 not null, material_specifications_id int8 not null, primary key (material_id, material_specifications_id))
create table outofspec (id int8 not null, error char(1) not null, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table permission_role_permissions (permission_id int8 not null, role_permissions_id int8 not null, primary key (permission_id, role_permissions_id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), primary key (id))
create table role (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table role_role_permissions (role_id int8 not null, role_permissions_id int8 not null, primary key (role_id, role_permissions_id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, dictionary_id int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_sample_labs (sample_id int8 not null, sample_labs_id int8 not null, primary key (sample_id, sample_labs_id))
create table sample_sample_status_history (sample_id int8 not null, sample_status_history_id int8 not null, primary key (sample_id, sample_status_history_id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), specification_no varchar(50), status int8, dictionary_id int8, material_id int8, primary key (id))
create table specification_specification_status_histories (specification_id int8 not null, specification_status_histories_id int8 not null, primary key (specification_id, specification_status_histories_id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists batch_batch_certificates add constraint UK_4xv5o3ej6bb14hmjljhc7tq63 unique (batch_certificates_id)
alter table if exists dictionary_dictionary_result add constraint UK_d5yw3vs6wn2mar24b4npaxf6n unique (dictionary_result_id)
alter table if exists dictionary_dictionary_sample add constraint UK_o3epfcogd2na8i1i7y41yh6fj unique (dictionary_sample_id)
alter table if exists dictionary_dictionary_specification add constraint UK_hel8t42qewq5vgdmnqpdqf4iq unique (dictionary_specification_id)
alter table if exists lab_user_batches add constraint UK_1pdhp7br3qxq8g6bhyyi3v1jv unique (batches_id)
alter table if exists lab_user_certificates add constraint UK_dmwbbatxx80vao69sgm5k9pce unique (certificates_id)
alter table if exists lab_user_materials add constraint UK_kupklapy5aek0jo5pffk3o6be unique (materials_id)
alter table if exists lab_user_results add constraint UK_tmyafldxt7f1h6yx1orpp6yh0 unique (results_id)
alter table if exists lab_user_result_status_histories add constraint UK_ru45le0s5riv4eyxicdshhfmo unique (result_status_histories_id)
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists lab_user_sample_status_histories add constraint UK_hfpew16eb7a57f98w55fwhjhg unique (sample_status_histories_id)
alter table if exists lab_user_specifications add constraint UK_j0klnbmppgmje34q3npovvid2 unique (specifications_id)
alter table if exists lab_user_specification_status_histories add constraint UK_94x9ohgetimpnkswdg5itqkjy unique (specification_status_histories_id)
alter table if exists lab_user_units add constraint UK_e4y2c5sf1jee37hp2mk05xp57 unique (units_id)
alter table if exists material_material_specifications add constraint UK_g2o6ijo9itlwpvib5ghwupnx5 unique (material_specifications_id)
alter table if exists permission_role_permissions add constraint UK_1mfe70jfnuyo1ni0jpfxb8hke unique (role_permissions_id)
alter table if exists role_role_permissions add constraint UK_67aht2phhgp2bmkj9np13vdo unique (role_permissions_id)
alter table if exists sample_sample_labs add constraint UK_o5u5kwolo62sp59d16vup1n6h unique (sample_labs_id)
alter table if exists sample_sample_status_history add constraint UK_ph47xrxuu2xkcgfl0fb612p4i unique (sample_status_history_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists specification_specification_status_histories add constraint UK_q77jdxw1lnevpstce7icx1fam unique (specification_status_histories_id)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists public.result add constraint FKmi3qxlyuo8097b89f04vfa5gy foreign key (dictionary_id) references dictionary
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists batch_batch_certificates add constraint FK3cxo6n77v2vk64u04o1f9d0o0 foreign key (batch_certificates_id) references certificate
alter table if exists batch_batch_certificates add constraint FK5sgla19e9qhlnblr2xl3d8rl foreign key (batch_id) references batch
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FK1pqc0jbvfwwqe1pu8rh4y0231 foreign key (user_id) references lab_user
alter table if exists dictionary_dictionary_result add constraint FK7brjv46hx2m8aas5p5pn4obgw foreign key (dictionary_result_id) references public.result
alter table if exists dictionary_dictionary_result add constraint FK6o1rue65laing6o3oso2ycs9w foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_sample add constraint FKecpaq38aunye6m5pry84vi294 foreign key (dictionary_sample_id) references sample
alter table if exists dictionary_dictionary_sample add constraint FK9t6jmtmnt4i73yu0acl8230tw foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_specification add constraint FKch6pepgmenneokc9aryqmkxr1 foreign key (dictionary_specification_id) references specification
alter table if exists dictionary_dictionary_specification add constraint FKjkmlixkik51mfkrfknx5vv36r foreign key (dictionary_id) references dictionary
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table if exists lab_user_batches add constraint FK20v8tkus6nc0cbtt1kg4o8n5q foreign key (batches_id) references batch
alter table if exists lab_user_batches add constraint FKl85sow5cy9qywufnmkyrqcfpf foreign key (user_id) references lab_user
alter table if exists lab_user_certificates add constraint FKnc18ibkvoyhg9udfr6h1yvdsg foreign key (certificates_id) references certificate
alter table if exists lab_user_certificates add constraint FK2pmdjlni3yrqmphurlt0udwqe foreign key (user_id) references lab_user
alter table if exists lab_user_materials add constraint FK8lisllk42w63mjdk8yk1yxdqh foreign key (materials_id) references material
alter table if exists lab_user_materials add constraint FK98x1m45dcbi3kjnc9lbkc4yh foreign key (user_id) references lab_user
alter table if exists lab_user_results add constraint FKd23p56a6r6kc8w06x15btg78o foreign key (results_id) references public.result
alter table if exists lab_user_results add constraint FK8usx2ytyjnswbi0crvawkqp7o foreign key (user_id) references lab_user
alter table if exists lab_user_result_status_histories add constraint FKe2nug5r1j36sa8ekc9n9dm8db foreign key (result_status_histories_id) references result_status_history
alter table if exists lab_user_result_status_histories add constraint FKl0poaohk95f4jay7ukntgh9h1 foreign key (user_id) references lab_user
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists lab_user_sample_status_histories add constraint FK1pltu9dh0orjiem7axd6tqkkk foreign key (sample_status_histories_id) references sample_status_history
alter table if exists lab_user_sample_status_histories add constraint FKoj4962dcxj7uap12lo3sd3c2j foreign key (user_id) references lab_user
alter table if exists lab_user_specifications add constraint FKiu2g175gtlc0plfg17sdphm11 foreign key (specifications_id) references specification
alter table if exists lab_user_specifications add constraint FK3oxe0ify28t1yygabcdaajnqh foreign key (user_id) references lab_user
alter table if exists lab_user_specification_status_histories add constraint FKm5yan2m4v7tpojb23g0rbtiex foreign key (specification_status_histories_id) references specification_status_history
alter table if exists lab_user_specification_status_histories add constraint FKq5k7nyx9usd1yt9l0hgghhduf foreign key (user_id) references lab_user
alter table if exists lab_user_units add constraint FKqaxq3cka7kdi7n32u7xs742qh foreign key (units_id) references public.unit
alter table if exists lab_user_units add constraint FKpdm2ylq4vylegy5cu2i398ekd foreign key (user_id) references lab_user
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists material_material_specifications add constraint FKqqs2o9l1yl05ktq7xasmj2x5a foreign key (material_specifications_id) references specification
alter table if exists material_material_specifications add constraint FK3o9fh0v6oj1afim2ufiiwougw foreign key (material_id) references material
alter table if exists permission_role_permissions add constraint FKgtwgq3jxiuhbkdqu8pg2tlmjy foreign key (role_permissions_id) references role_permission
alter table if exists permission_role_permissions add constraint FK6waw1ga373he09v2mpml9u1th foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists role_role_permissions add constraint FKjv05nottgydlxaeix0cykmfgn foreign key (role_permissions_id) references role_permission
alter table if exists role_role_permissions add constraint FKe7klxo5ltt494cje6wkosd13e foreign key (role_id) references role
alter table if exists sample add constraint FKc4l0ss0nu2tfagemrset3if54 foreign key (dictionary_id) references dictionary
alter table if exists sample add constraint FKns071g9sb6pms65ljllilef3k foreign key (user_id) references lab_user
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists sample_sample_labs add constraint FKgcspgpw94galrx4kqeoynljh9 foreign key (sample_labs_id) references sample_lab
alter table if exists sample_sample_labs add constraint FKfak1k731mraw5u110lma9nkc foreign key (sample_id) references sample
alter table if exists sample_sample_status_history add constraint FKt9b2po5e6hl9wvxb1cs80y5wt foreign key (sample_status_history_id) references sample_status_history
alter table if exists sample_sample_status_history add constraint FK1mlsuwg3s11u0wfdi8b5h5niy foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table if exists specification add constraint FKktty9hsdwwvpbau47nms6e2gy foreign key (dictionary_id) references dictionary
alter table if exists specification add constraint FKca9sf0ycou1q3nwhnlyf23829 foreign key (material_id) references specification
alter table if exists specification_specification_status_histories add constraint FKivkqaf2lyfbo4o0u3up98ac2u foreign key (specification_status_histories_id) references specification_status_history
alter table if exists specification_specification_status_histories add constraint FK51dkhnapcnlloso5b2cq1ka36 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, status int4 not null, value varchar(255), dictionary_id int8, primary key (id))
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
create table batch (id int8 not null, batch_no varchar(255), deleted varchar(1), manufacturer_id int8, supplier_id int8, user_id int8, primary key (id))
create table batch_batch_certificates (batch_id int8 not null, batch_certificates_id int8 not null, primary key (batch_id, batch_certificates_id))
create table certificate (id int8 not null, accepted_by int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), batch_id int8, user_id int8, primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table dictionary_dictionary_result (dictionary_id int8 not null, dictionary_result_id int8 not null, primary key (dictionary_id, dictionary_result_id))
create table dictionary_dictionary_sample (dictionary_id int8 not null, dictionary_sample_id int8 not null, primary key (dictionary_id, dictionary_sample_id))
create table dictionary_dictionary_specification (dictionary_id int8 not null, dictionary_specification_id int8 not null, primary key (dictionary_id, dictionary_specification_id))
create table lab (id int8 not null, deleted varchar(1), name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), lab_id int8, role_id int8, primary key (id))
create table lab_user_batches (user_id int8 not null, batches_id int8 not null, primary key (user_id, batches_id))
create table lab_user_certificates (user_id int8 not null, certificates_id int8 not null, primary key (user_id, certificates_id))
create table lab_user_materials (user_id int8 not null, materials_id int8 not null, primary key (user_id, materials_id))
create table lab_user_results (user_id int8 not null, results_id int8 not null, primary key (user_id, results_id))
create table lab_user_result_status_histories (user_id int8 not null, result_status_histories_id int8 not null, primary key (user_id, result_status_histories_id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table lab_user_sample_status_histories (user_id int8 not null, sample_status_histories_id int8 not null, primary key (user_id, sample_status_histories_id))
create table lab_user_specifications (user_id int8 not null, specifications_id int8 not null, primary key (user_id, specifications_id))
create table lab_user_specification_status_histories (user_id int8 not null, specification_status_histories_id int8 not null, primary key (user_id, specification_status_histories_id))
create table lab_user_units (user_id int8 not null, units_id int8 not null, primary key (user_id, units_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table material_material_specifications (material_id int8 not null, material_specifications_id int8 not null, primary key (material_id, material_specifications_id))
create table outofspec (id int8 not null, error char(1) not null, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table permission_role_permissions (permission_id int8 not null, role_permissions_id int8 not null, primary key (permission_id, role_permissions_id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), primary key (id))
create table role (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table role_role_permissions (role_id int8 not null, role_permissions_id int8 not null, primary key (role_id, role_permissions_id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, dictionary_id int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_sample_labs (sample_id int8 not null, sample_labs_id int8 not null, primary key (sample_id, sample_labs_id))
create table sample_sample_status_history (sample_id int8 not null, sample_status_history_id int8 not null, primary key (sample_id, sample_status_history_id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), specification_no varchar(50), status int8, dictionary_id int8, material_id int8, primary key (id))
create table specification_specification_status_histories (specification_id int8 not null, specification_status_histories_id int8 not null, primary key (specification_id, specification_status_histories_id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists batch_batch_certificates add constraint UK_4xv5o3ej6bb14hmjljhc7tq63 unique (batch_certificates_id)
alter table if exists dictionary_dictionary_result add constraint UK_d5yw3vs6wn2mar24b4npaxf6n unique (dictionary_result_id)
alter table if exists dictionary_dictionary_sample add constraint UK_o3epfcogd2na8i1i7y41yh6fj unique (dictionary_sample_id)
alter table if exists dictionary_dictionary_specification add constraint UK_hel8t42qewq5vgdmnqpdqf4iq unique (dictionary_specification_id)
alter table if exists lab_user_batches add constraint UK_1pdhp7br3qxq8g6bhyyi3v1jv unique (batches_id)
alter table if exists lab_user_certificates add constraint UK_dmwbbatxx80vao69sgm5k9pce unique (certificates_id)
alter table if exists lab_user_materials add constraint UK_kupklapy5aek0jo5pffk3o6be unique (materials_id)
alter table if exists lab_user_results add constraint UK_tmyafldxt7f1h6yx1orpp6yh0 unique (results_id)
alter table if exists lab_user_result_status_histories add constraint UK_ru45le0s5riv4eyxicdshhfmo unique (result_status_histories_id)
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists lab_user_sample_status_histories add constraint UK_hfpew16eb7a57f98w55fwhjhg unique (sample_status_histories_id)
alter table if exists lab_user_specifications add constraint UK_j0klnbmppgmje34q3npovvid2 unique (specifications_id)
alter table if exists lab_user_specification_status_histories add constraint UK_94x9ohgetimpnkswdg5itqkjy unique (specification_status_histories_id)
alter table if exists lab_user_units add constraint UK_e4y2c5sf1jee37hp2mk05xp57 unique (units_id)
alter table if exists material_material_specifications add constraint UK_g2o6ijo9itlwpvib5ghwupnx5 unique (material_specifications_id)
alter table if exists permission_role_permissions add constraint UK_1mfe70jfnuyo1ni0jpfxb8hke unique (role_permissions_id)
alter table if exists role_role_permissions add constraint UK_67aht2phhgp2bmkj9np13vdo unique (role_permissions_id)
alter table if exists sample_sample_labs add constraint UK_o5u5kwolo62sp59d16vup1n6h unique (sample_labs_id)
alter table if exists sample_sample_status_history add constraint UK_ph47xrxuu2xkcgfl0fb612p4i unique (sample_status_history_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists specification_specification_status_histories add constraint UK_q77jdxw1lnevpstce7icx1fam unique (specification_status_histories_id)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists public.result add constraint FKmi3qxlyuo8097b89f04vfa5gy foreign key (dictionary_id) references dictionary
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists batch_batch_certificates add constraint FK3cxo6n77v2vk64u04o1f9d0o0 foreign key (batch_certificates_id) references certificate
alter table if exists batch_batch_certificates add constraint FK5sgla19e9qhlnblr2xl3d8rl foreign key (batch_id) references batch
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FK1pqc0jbvfwwqe1pu8rh4y0231 foreign key (user_id) references lab_user
alter table if exists dictionary_dictionary_result add constraint FK7brjv46hx2m8aas5p5pn4obgw foreign key (dictionary_result_id) references public.result
alter table if exists dictionary_dictionary_result add constraint FK6o1rue65laing6o3oso2ycs9w foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_sample add constraint FKecpaq38aunye6m5pry84vi294 foreign key (dictionary_sample_id) references sample
alter table if exists dictionary_dictionary_sample add constraint FK9t6jmtmnt4i73yu0acl8230tw foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_specification add constraint FKch6pepgmenneokc9aryqmkxr1 foreign key (dictionary_specification_id) references specification
alter table if exists dictionary_dictionary_specification add constraint FKjkmlixkik51mfkrfknx5vv36r foreign key (dictionary_id) references dictionary
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table if exists lab_user_batches add constraint FK20v8tkus6nc0cbtt1kg4o8n5q foreign key (batches_id) references batch
alter table if exists lab_user_batches add constraint FKl85sow5cy9qywufnmkyrqcfpf foreign key (user_id) references lab_user
alter table if exists lab_user_certificates add constraint FKnc18ibkvoyhg9udfr6h1yvdsg foreign key (certificates_id) references certificate
alter table if exists lab_user_certificates add constraint FK2pmdjlni3yrqmphurlt0udwqe foreign key (user_id) references lab_user
alter table if exists lab_user_materials add constraint FK8lisllk42w63mjdk8yk1yxdqh foreign key (materials_id) references material
alter table if exists lab_user_materials add constraint FK98x1m45dcbi3kjnc9lbkc4yh foreign key (user_id) references lab_user
alter table if exists lab_user_results add constraint FKd23p56a6r6kc8w06x15btg78o foreign key (results_id) references public.result
alter table if exists lab_user_results add constraint FK8usx2ytyjnswbi0crvawkqp7o foreign key (user_id) references lab_user
alter table if exists lab_user_result_status_histories add constraint FKe2nug5r1j36sa8ekc9n9dm8db foreign key (result_status_histories_id) references result_status_history
alter table if exists lab_user_result_status_histories add constraint FKl0poaohk95f4jay7ukntgh9h1 foreign key (user_id) references lab_user
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists lab_user_sample_status_histories add constraint FK1pltu9dh0orjiem7axd6tqkkk foreign key (sample_status_histories_id) references sample_status_history
alter table if exists lab_user_sample_status_histories add constraint FKoj4962dcxj7uap12lo3sd3c2j foreign key (user_id) references lab_user
alter table if exists lab_user_specifications add constraint FKiu2g175gtlc0plfg17sdphm11 foreign key (specifications_id) references specification
alter table if exists lab_user_specifications add constraint FK3oxe0ify28t1yygabcdaajnqh foreign key (user_id) references lab_user
alter table if exists lab_user_specification_status_histories add constraint FKm5yan2m4v7tpojb23g0rbtiex foreign key (specification_status_histories_id) references specification_status_history
alter table if exists lab_user_specification_status_histories add constraint FKq5k7nyx9usd1yt9l0hgghhduf foreign key (user_id) references lab_user
alter table if exists lab_user_units add constraint FKqaxq3cka7kdi7n32u7xs742qh foreign key (units_id) references public.unit
alter table if exists lab_user_units add constraint FKpdm2ylq4vylegy5cu2i398ekd foreign key (user_id) references lab_user
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists material_material_specifications add constraint FKqqs2o9l1yl05ktq7xasmj2x5a foreign key (material_specifications_id) references specification
alter table if exists material_material_specifications add constraint FK3o9fh0v6oj1afim2ufiiwougw foreign key (material_id) references material
alter table if exists permission_role_permissions add constraint FKgtwgq3jxiuhbkdqu8pg2tlmjy foreign key (role_permissions_id) references role_permission
alter table if exists permission_role_permissions add constraint FK6waw1ga373he09v2mpml9u1th foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists role_role_permissions add constraint FKjv05nottgydlxaeix0cykmfgn foreign key (role_permissions_id) references role_permission
alter table if exists role_role_permissions add constraint FKe7klxo5ltt494cje6wkosd13e foreign key (role_id) references role
alter table if exists sample add constraint FKc4l0ss0nu2tfagemrset3if54 foreign key (dictionary_id) references dictionary
alter table if exists sample add constraint FKns071g9sb6pms65ljllilef3k foreign key (user_id) references lab_user
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists sample_sample_labs add constraint FKgcspgpw94galrx4kqeoynljh9 foreign key (sample_labs_id) references sample_lab
alter table if exists sample_sample_labs add constraint FKfak1k731mraw5u110lma9nkc foreign key (sample_id) references sample
alter table if exists sample_sample_status_history add constraint FKt9b2po5e6hl9wvxb1cs80y5wt foreign key (sample_status_history_id) references sample_status_history
alter table if exists sample_sample_status_history add constraint FK1mlsuwg3s11u0wfdi8b5h5niy foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table if exists specification add constraint FKktty9hsdwwvpbau47nms6e2gy foreign key (dictionary_id) references dictionary
alter table if exists specification add constraint FKca9sf0ycou1q3nwhnlyf23829 foreign key (material_id) references specification
alter table if exists specification_specification_status_histories add constraint FKivkqaf2lyfbo4o0u3up98ac2u foreign key (specification_status_histories_id) references specification_status_history
alter table if exists specification_specification_status_histories add constraint FK51dkhnapcnlloso5b2cq1ka36 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, status int4 not null, value varchar(255), dictionary_id int8, primary key (id))
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
create table batch (id int8 not null, batch_no varchar(255), deleted varchar(1), manufacturer_id int8, supplier_id int8, user_id int8, primary key (id))
create table batch_batch_certificates (batch_id int8 not null, batch_certificates_id int8 not null, primary key (batch_id, batch_certificates_id))
create table certificate (id int8 not null, accepted_by int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), batch_id int8, user_id int8, primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table dictionary_dictionary_result (dictionary_id int8 not null, dictionary_result_id int8 not null, primary key (dictionary_id, dictionary_result_id))
create table dictionary_dictionary_sample (dictionary_id int8 not null, dictionary_sample_id int8 not null, primary key (dictionary_id, dictionary_sample_id))
create table dictionary_dictionary_specification (dictionary_id int8 not null, dictionary_specification_id int8 not null, primary key (dictionary_id, dictionary_specification_id))
create table lab (id int8 not null, deleted varchar(1), name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), lab_id int8, role_id int8, primary key (id))
create table lab_user_batches (user_id int8 not null, batches_id int8 not null, primary key (user_id, batches_id))
create table lab_user_certificates (user_id int8 not null, certificates_id int8 not null, primary key (user_id, certificates_id))
create table lab_user_materials (user_id int8 not null, materials_id int8 not null, primary key (user_id, materials_id))
create table lab_user_results (user_id int8 not null, results_id int8 not null, primary key (user_id, results_id))
create table lab_user_result_status_histories (user_id int8 not null, result_status_histories_id int8 not null, primary key (user_id, result_status_histories_id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table lab_user_sample_status_histories (user_id int8 not null, sample_status_histories_id int8 not null, primary key (user_id, sample_status_histories_id))
create table lab_user_specifications (user_id int8 not null, specifications_id int8 not null, primary key (user_id, specifications_id))
create table lab_user_specification_status_histories (user_id int8 not null, specification_status_histories_id int8 not null, primary key (user_id, specification_status_histories_id))
create table lab_user_units (user_id int8 not null, units_id int8 not null, primary key (user_id, units_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table material_material_specifications (material_id int8 not null, material_specifications_id int8 not null, primary key (material_id, material_specifications_id))
create table outofspec (id int8 not null, error char(1) not null, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table permission_role_permissions (permission_id int8 not null, role_permissions_id int8 not null, primary key (permission_id, role_permissions_id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), primary key (id))
create table role (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table role_role_permissions (role_id int8 not null, role_permissions_id int8 not null, primary key (role_id, role_permissions_id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, dictionary_id int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_sample_labs (sample_id int8 not null, sample_labs_id int8 not null, primary key (sample_id, sample_labs_id))
create table sample_sample_status_history (sample_id int8 not null, sample_status_history_id int8 not null, primary key (sample_id, sample_status_history_id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), specification_no varchar(50), status int8, dictionary_id int8, material_id int8, primary key (id))
create table specification_specification_status_histories (specification_id int8 not null, specification_status_histories_id int8 not null, primary key (specification_id, specification_status_histories_id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists batch_batch_certificates add constraint UK_4xv5o3ej6bb14hmjljhc7tq63 unique (batch_certificates_id)
alter table if exists dictionary_dictionary_result add constraint UK_d5yw3vs6wn2mar24b4npaxf6n unique (dictionary_result_id)
alter table if exists dictionary_dictionary_sample add constraint UK_o3epfcogd2na8i1i7y41yh6fj unique (dictionary_sample_id)
alter table if exists dictionary_dictionary_specification add constraint UK_hel8t42qewq5vgdmnqpdqf4iq unique (dictionary_specification_id)
alter table if exists lab_user_batches add constraint UK_1pdhp7br3qxq8g6bhyyi3v1jv unique (batches_id)
alter table if exists lab_user_certificates add constraint UK_dmwbbatxx80vao69sgm5k9pce unique (certificates_id)
alter table if exists lab_user_materials add constraint UK_kupklapy5aek0jo5pffk3o6be unique (materials_id)
alter table if exists lab_user_results add constraint UK_tmyafldxt7f1h6yx1orpp6yh0 unique (results_id)
alter table if exists lab_user_result_status_histories add constraint UK_ru45le0s5riv4eyxicdshhfmo unique (result_status_histories_id)
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists lab_user_sample_status_histories add constraint UK_hfpew16eb7a57f98w55fwhjhg unique (sample_status_histories_id)
alter table if exists lab_user_specifications add constraint UK_j0klnbmppgmje34q3npovvid2 unique (specifications_id)
alter table if exists lab_user_specification_status_histories add constraint UK_94x9ohgetimpnkswdg5itqkjy unique (specification_status_histories_id)
alter table if exists lab_user_units add constraint UK_e4y2c5sf1jee37hp2mk05xp57 unique (units_id)
alter table if exists material_material_specifications add constraint UK_g2o6ijo9itlwpvib5ghwupnx5 unique (material_specifications_id)
alter table if exists permission_role_permissions add constraint UK_1mfe70jfnuyo1ni0jpfxb8hke unique (role_permissions_id)
alter table if exists role_role_permissions add constraint UK_67aht2phhgp2bmkj9np13vdo unique (role_permissions_id)
alter table if exists sample_sample_labs add constraint UK_o5u5kwolo62sp59d16vup1n6h unique (sample_labs_id)
alter table if exists sample_sample_status_history add constraint UK_ph47xrxuu2xkcgfl0fb612p4i unique (sample_status_history_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists specification_specification_status_histories add constraint UK_q77jdxw1lnevpstce7icx1fam unique (specification_status_histories_id)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists public.result add constraint FKmi3qxlyuo8097b89f04vfa5gy foreign key (dictionary_id) references dictionary
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists batch_batch_certificates add constraint FK3cxo6n77v2vk64u04o1f9d0o0 foreign key (batch_certificates_id) references certificate
alter table if exists batch_batch_certificates add constraint FK5sgla19e9qhlnblr2xl3d8rl foreign key (batch_id) references batch
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FK1pqc0jbvfwwqe1pu8rh4y0231 foreign key (user_id) references lab_user
alter table if exists dictionary_dictionary_result add constraint FK7brjv46hx2m8aas5p5pn4obgw foreign key (dictionary_result_id) references public.result
alter table if exists dictionary_dictionary_result add constraint FK6o1rue65laing6o3oso2ycs9w foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_sample add constraint FKecpaq38aunye6m5pry84vi294 foreign key (dictionary_sample_id) references sample
alter table if exists dictionary_dictionary_sample add constraint FK9t6jmtmnt4i73yu0acl8230tw foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_specification add constraint FKch6pepgmenneokc9aryqmkxr1 foreign key (dictionary_specification_id) references specification
alter table if exists dictionary_dictionary_specification add constraint FKjkmlixkik51mfkrfknx5vv36r foreign key (dictionary_id) references dictionary
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table if exists lab_user_batches add constraint FK20v8tkus6nc0cbtt1kg4o8n5q foreign key (batches_id) references batch
alter table if exists lab_user_batches add constraint FKl85sow5cy9qywufnmkyrqcfpf foreign key (user_id) references lab_user
alter table if exists lab_user_certificates add constraint FKnc18ibkvoyhg9udfr6h1yvdsg foreign key (certificates_id) references certificate
alter table if exists lab_user_certificates add constraint FK2pmdjlni3yrqmphurlt0udwqe foreign key (user_id) references lab_user
alter table if exists lab_user_materials add constraint FK8lisllk42w63mjdk8yk1yxdqh foreign key (materials_id) references material
alter table if exists lab_user_materials add constraint FK98x1m45dcbi3kjnc9lbkc4yh foreign key (user_id) references lab_user
alter table if exists lab_user_results add constraint FKd23p56a6r6kc8w06x15btg78o foreign key (results_id) references public.result
alter table if exists lab_user_results add constraint FK8usx2ytyjnswbi0crvawkqp7o foreign key (user_id) references lab_user
alter table if exists lab_user_result_status_histories add constraint FKe2nug5r1j36sa8ekc9n9dm8db foreign key (result_status_histories_id) references result_status_history
alter table if exists lab_user_result_status_histories add constraint FKl0poaohk95f4jay7ukntgh9h1 foreign key (user_id) references lab_user
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists lab_user_sample_status_histories add constraint FK1pltu9dh0orjiem7axd6tqkkk foreign key (sample_status_histories_id) references sample_status_history
alter table if exists lab_user_sample_status_histories add constraint FKoj4962dcxj7uap12lo3sd3c2j foreign key (user_id) references lab_user
alter table if exists lab_user_specifications add constraint FKiu2g175gtlc0plfg17sdphm11 foreign key (specifications_id) references specification
alter table if exists lab_user_specifications add constraint FK3oxe0ify28t1yygabcdaajnqh foreign key (user_id) references lab_user
alter table if exists lab_user_specification_status_histories add constraint FKm5yan2m4v7tpojb23g0rbtiex foreign key (specification_status_histories_id) references specification_status_history
alter table if exists lab_user_specification_status_histories add constraint FKq5k7nyx9usd1yt9l0hgghhduf foreign key (user_id) references lab_user
alter table if exists lab_user_units add constraint FKqaxq3cka7kdi7n32u7xs742qh foreign key (units_id) references public.unit
alter table if exists lab_user_units add constraint FKpdm2ylq4vylegy5cu2i398ekd foreign key (user_id) references lab_user
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists material_material_specifications add constraint FKqqs2o9l1yl05ktq7xasmj2x5a foreign key (material_specifications_id) references specification
alter table if exists material_material_specifications add constraint FK3o9fh0v6oj1afim2ufiiwougw foreign key (material_id) references material
alter table if exists permission_role_permissions add constraint FKgtwgq3jxiuhbkdqu8pg2tlmjy foreign key (role_permissions_id) references role_permission
alter table if exists permission_role_permissions add constraint FK6waw1ga373he09v2mpml9u1th foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists role_role_permissions add constraint FKjv05nottgydlxaeix0cykmfgn foreign key (role_permissions_id) references role_permission
alter table if exists role_role_permissions add constraint FKe7klxo5ltt494cje6wkosd13e foreign key (role_id) references role
alter table if exists sample add constraint FKc4l0ss0nu2tfagemrset3if54 foreign key (dictionary_id) references dictionary
alter table if exists sample add constraint FKns071g9sb6pms65ljllilef3k foreign key (user_id) references lab_user
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists sample_sample_labs add constraint FKgcspgpw94galrx4kqeoynljh9 foreign key (sample_labs_id) references sample_lab
alter table if exists sample_sample_labs add constraint FKfak1k731mraw5u110lma9nkc foreign key (sample_id) references sample
alter table if exists sample_sample_status_history add constraint FKt9b2po5e6hl9wvxb1cs80y5wt foreign key (sample_status_history_id) references sample_status_history
alter table if exists sample_sample_status_history add constraint FK1mlsuwg3s11u0wfdi8b5h5niy foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table if exists specification add constraint FKktty9hsdwwvpbau47nms6e2gy foreign key (dictionary_id) references dictionary
alter table if exists specification add constraint FKca9sf0ycou1q3nwhnlyf23829 foreign key (material_id) references specification
alter table if exists specification_specification_status_histories add constraint FKivkqaf2lyfbo4o0u3up98ac2u foreign key (specification_status_histories_id) references specification_status_history
alter table if exists specification_specification_status_histories add constraint FK51dkhnapcnlloso5b2cq1ka36 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, status int4 not null, value varchar(255), dictionary_id int8, primary key (id))
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
create table batch (id int8 not null, batch_no varchar(255), deleted varchar(1), manufacturer_id int8, supplier_id int8, user_id int8, primary key (id))
create table batch_batch_certificates (batch_id int8 not null, batch_certificates_id int8 not null, primary key (batch_id, batch_certificates_id))
create table certificate (id int8 not null, accepted_by int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), batch_id int8, user_id int8, primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table dictionary_dictionary_result (dictionary_id int8 not null, dictionary_result_id int8 not null, primary key (dictionary_id, dictionary_result_id))
create table dictionary_dictionary_sample (dictionary_id int8 not null, dictionary_sample_id int8 not null, primary key (dictionary_id, dictionary_sample_id))
create table dictionary_dictionary_specification (dictionary_id int8 not null, dictionary_specification_id int8 not null, primary key (dictionary_id, dictionary_specification_id))
create table lab (id int8 not null, deleted varchar(1), name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), lab_id int8, role_id int8, primary key (id))
create table lab_user_batches (user_id int8 not null, batches_id int8 not null, primary key (user_id, batches_id))
create table lab_user_certificates (user_id int8 not null, certificates_id int8 not null, primary key (user_id, certificates_id))
create table lab_user_materials (user_id int8 not null, materials_id int8 not null, primary key (user_id, materials_id))
create table lab_user_results (user_id int8 not null, results_id int8 not null, primary key (user_id, results_id))
create table lab_user_result_status_histories (user_id int8 not null, result_status_histories_id int8 not null, primary key (user_id, result_status_histories_id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table lab_user_sample_status_histories (user_id int8 not null, sample_status_histories_id int8 not null, primary key (user_id, sample_status_histories_id))
create table lab_user_specifications (user_id int8 not null, specifications_id int8 not null, primary key (user_id, specifications_id))
create table lab_user_specification_status_histories (user_id int8 not null, specification_status_histories_id int8 not null, primary key (user_id, specification_status_histories_id))
create table lab_user_units (user_id int8 not null, units_id int8 not null, primary key (user_id, units_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table material_material_specifications (material_id int8 not null, material_specifications_id int8 not null, primary key (material_id, material_specifications_id))
create table outofspec (id int8 not null, error char(1) not null, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table permission_role_permissions (permission_id int8 not null, role_permissions_id int8 not null, primary key (permission_id, role_permissions_id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), primary key (id))
create table role (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table role_role_permissions (role_id int8 not null, role_permissions_id int8 not null, primary key (role_id, role_permissions_id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, dictionary_id int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_sample_labs (sample_id int8 not null, sample_labs_id int8 not null, primary key (sample_id, sample_labs_id))
create table sample_sample_status_history (sample_id int8 not null, sample_status_history_id int8 not null, primary key (sample_id, sample_status_history_id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), specification_no varchar(50), status int8, dictionary_id int8, material_id int8, primary key (id))
create table specification_specification_status_histories (specification_id int8 not null, specification_status_histories_id int8 not null, primary key (specification_id, specification_status_histories_id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists batch_batch_certificates add constraint UK_4xv5o3ej6bb14hmjljhc7tq63 unique (batch_certificates_id)
alter table if exists dictionary_dictionary_result add constraint UK_d5yw3vs6wn2mar24b4npaxf6n unique (dictionary_result_id)
alter table if exists dictionary_dictionary_sample add constraint UK_o3epfcogd2na8i1i7y41yh6fj unique (dictionary_sample_id)
alter table if exists dictionary_dictionary_specification add constraint UK_hel8t42qewq5vgdmnqpdqf4iq unique (dictionary_specification_id)
alter table if exists lab_user_batches add constraint UK_1pdhp7br3qxq8g6bhyyi3v1jv unique (batches_id)
alter table if exists lab_user_certificates add constraint UK_dmwbbatxx80vao69sgm5k9pce unique (certificates_id)
alter table if exists lab_user_materials add constraint UK_kupklapy5aek0jo5pffk3o6be unique (materials_id)
alter table if exists lab_user_results add constraint UK_tmyafldxt7f1h6yx1orpp6yh0 unique (results_id)
alter table if exists lab_user_result_status_histories add constraint UK_ru45le0s5riv4eyxicdshhfmo unique (result_status_histories_id)
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists lab_user_sample_status_histories add constraint UK_hfpew16eb7a57f98w55fwhjhg unique (sample_status_histories_id)
alter table if exists lab_user_specifications add constraint UK_j0klnbmppgmje34q3npovvid2 unique (specifications_id)
alter table if exists lab_user_specification_status_histories add constraint UK_94x9ohgetimpnkswdg5itqkjy unique (specification_status_histories_id)
alter table if exists lab_user_units add constraint UK_e4y2c5sf1jee37hp2mk05xp57 unique (units_id)
alter table if exists material_material_specifications add constraint UK_g2o6ijo9itlwpvib5ghwupnx5 unique (material_specifications_id)
alter table if exists permission_role_permissions add constraint UK_1mfe70jfnuyo1ni0jpfxb8hke unique (role_permissions_id)
alter table if exists role_role_permissions add constraint UK_67aht2phhgp2bmkj9np13vdo unique (role_permissions_id)
alter table if exists sample_sample_labs add constraint UK_o5u5kwolo62sp59d16vup1n6h unique (sample_labs_id)
alter table if exists sample_sample_status_history add constraint UK_ph47xrxuu2xkcgfl0fb612p4i unique (sample_status_history_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists specification_specification_status_histories add constraint UK_q77jdxw1lnevpstce7icx1fam unique (specification_status_histories_id)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists public.result add constraint FKmi3qxlyuo8097b89f04vfa5gy foreign key (dictionary_id) references dictionary
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists batch_batch_certificates add constraint FK3cxo6n77v2vk64u04o1f9d0o0 foreign key (batch_certificates_id) references certificate
alter table if exists batch_batch_certificates add constraint FK5sgla19e9qhlnblr2xl3d8rl foreign key (batch_id) references batch
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FK1pqc0jbvfwwqe1pu8rh4y0231 foreign key (user_id) references lab_user
alter table if exists dictionary_dictionary_result add constraint FK7brjv46hx2m8aas5p5pn4obgw foreign key (dictionary_result_id) references public.result
alter table if exists dictionary_dictionary_result add constraint FK6o1rue65laing6o3oso2ycs9w foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_sample add constraint FKecpaq38aunye6m5pry84vi294 foreign key (dictionary_sample_id) references sample
alter table if exists dictionary_dictionary_sample add constraint FK9t6jmtmnt4i73yu0acl8230tw foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_specification add constraint FKch6pepgmenneokc9aryqmkxr1 foreign key (dictionary_specification_id) references specification
alter table if exists dictionary_dictionary_specification add constraint FKjkmlixkik51mfkrfknx5vv36r foreign key (dictionary_id) references dictionary
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table if exists lab_user_batches add constraint FK20v8tkus6nc0cbtt1kg4o8n5q foreign key (batches_id) references batch
alter table if exists lab_user_batches add constraint FKl85sow5cy9qywufnmkyrqcfpf foreign key (user_id) references lab_user
alter table if exists lab_user_certificates add constraint FKnc18ibkvoyhg9udfr6h1yvdsg foreign key (certificates_id) references certificate
alter table if exists lab_user_certificates add constraint FK2pmdjlni3yrqmphurlt0udwqe foreign key (user_id) references lab_user
alter table if exists lab_user_materials add constraint FK8lisllk42w63mjdk8yk1yxdqh foreign key (materials_id) references material
alter table if exists lab_user_materials add constraint FK98x1m45dcbi3kjnc9lbkc4yh foreign key (user_id) references lab_user
alter table if exists lab_user_results add constraint FKd23p56a6r6kc8w06x15btg78o foreign key (results_id) references public.result
alter table if exists lab_user_results add constraint FK8usx2ytyjnswbi0crvawkqp7o foreign key (user_id) references lab_user
alter table if exists lab_user_result_status_histories add constraint FKe2nug5r1j36sa8ekc9n9dm8db foreign key (result_status_histories_id) references result_status_history
alter table if exists lab_user_result_status_histories add constraint FKl0poaohk95f4jay7ukntgh9h1 foreign key (user_id) references lab_user
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists lab_user_sample_status_histories add constraint FK1pltu9dh0orjiem7axd6tqkkk foreign key (sample_status_histories_id) references sample_status_history
alter table if exists lab_user_sample_status_histories add constraint FKoj4962dcxj7uap12lo3sd3c2j foreign key (user_id) references lab_user
alter table if exists lab_user_specifications add constraint FKiu2g175gtlc0plfg17sdphm11 foreign key (specifications_id) references specification
alter table if exists lab_user_specifications add constraint FK3oxe0ify28t1yygabcdaajnqh foreign key (user_id) references lab_user
alter table if exists lab_user_specification_status_histories add constraint FKm5yan2m4v7tpojb23g0rbtiex foreign key (specification_status_histories_id) references specification_status_history
alter table if exists lab_user_specification_status_histories add constraint FKq5k7nyx9usd1yt9l0hgghhduf foreign key (user_id) references lab_user
alter table if exists lab_user_units add constraint FKqaxq3cka7kdi7n32u7xs742qh foreign key (units_id) references public.unit
alter table if exists lab_user_units add constraint FKpdm2ylq4vylegy5cu2i398ekd foreign key (user_id) references lab_user
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists material_material_specifications add constraint FKqqs2o9l1yl05ktq7xasmj2x5a foreign key (material_specifications_id) references specification
alter table if exists material_material_specifications add constraint FK3o9fh0v6oj1afim2ufiiwougw foreign key (material_id) references material
alter table if exists permission_role_permissions add constraint FKgtwgq3jxiuhbkdqu8pg2tlmjy foreign key (role_permissions_id) references role_permission
alter table if exists permission_role_permissions add constraint FK6waw1ga373he09v2mpml9u1th foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists role_role_permissions add constraint FKjv05nottgydlxaeix0cykmfgn foreign key (role_permissions_id) references role_permission
alter table if exists role_role_permissions add constraint FKe7klxo5ltt494cje6wkosd13e foreign key (role_id) references role
alter table if exists sample add constraint FKc4l0ss0nu2tfagemrset3if54 foreign key (dictionary_id) references dictionary
alter table if exists sample add constraint FKns071g9sb6pms65ljllilef3k foreign key (user_id) references lab_user
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists sample_sample_labs add constraint FKgcspgpw94galrx4kqeoynljh9 foreign key (sample_labs_id) references sample_lab
alter table if exists sample_sample_labs add constraint FKfak1k731mraw5u110lma9nkc foreign key (sample_id) references sample
alter table if exists sample_sample_status_history add constraint FKt9b2po5e6hl9wvxb1cs80y5wt foreign key (sample_status_history_id) references sample_status_history
alter table if exists sample_sample_status_history add constraint FK1mlsuwg3s11u0wfdi8b5h5niy foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table if exists specification add constraint FKktty9hsdwwvpbau47nms6e2gy foreign key (dictionary_id) references dictionary
alter table if exists specification add constraint FKca9sf0ycou1q3nwhnlyf23829 foreign key (material_id) references specification
alter table if exists specification_specification_status_histories add constraint FKivkqaf2lyfbo4o0u3up98ac2u foreign key (specification_status_histories_id) references specification_status_history
alter table if exists specification_specification_status_histories add constraint FK51dkhnapcnlloso5b2cq1ka36 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
create table public.manufacturer (address_id int8 not null, deleted char(1) not null, name varchar(255), primary key (address_id))
create table public.result (id int8 not null, status int4 not null, value varchar(255), dictionary_id int8, primary key (id))
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
create table batch (id int8 not null, batch_no varchar(255), deleted varchar(1), manufacturer_id int8, supplier_id int8, user_id int8, primary key (id))
create table batch_batch_certificates (batch_id int8 not null, batch_certificates_id int8 not null, primary key (batch_id, batch_certificates_id))
create table certificate (id int8 not null, accepted_by int8, certificate_no varchar(255), deleted char(1) not null, name varchar(255), batch_id int8, user_id int8, primary key (id))
create table dictionary (id int8 not null, code varchar(255), deleted char(1) not null, dictionary_code varchar(255), value varchar(255), primary key (id))
create table dictionary_dictionary_result (dictionary_id int8 not null, dictionary_result_id int8 not null, primary key (dictionary_id, dictionary_result_id))
create table dictionary_dictionary_sample (dictionary_id int8 not null, dictionary_sample_id int8 not null, primary key (dictionary_id, dictionary_sample_id))
create table dictionary_dictionary_specification (dictionary_id int8 not null, dictionary_specification_id int8 not null, primary key (dictionary_id, dictionary_specification_id))
create table lab (id int8 not null, deleted varchar(1), name varchar(255), address_id int8, primary key (id))
create table lab_user (id int8 not null, email varchar(255), first_name varchar(255), last_name varchar(255), login varchar(255), password varchar(255), phone varchar(255), lab_id int8, role_id int8, primary key (id))
create table lab_user_batches (user_id int8 not null, batches_id int8 not null, primary key (user_id, batches_id))
create table lab_user_certificates (user_id int8 not null, certificates_id int8 not null, primary key (user_id, certificates_id))
create table lab_user_materials (user_id int8 not null, materials_id int8 not null, primary key (user_id, materials_id))
create table lab_user_results (user_id int8 not null, results_id int8 not null, primary key (user_id, results_id))
create table lab_user_result_status_histories (user_id int8 not null, result_status_histories_id int8 not null, primary key (user_id, result_status_histories_id))
create table lab_user_samples (user_id int8 not null, samples_id int8 not null, primary key (user_id, samples_id))
create table lab_user_sample_status_histories (user_id int8 not null, sample_status_histories_id int8 not null, primary key (user_id, sample_status_histories_id))
create table lab_user_specifications (user_id int8 not null, specifications_id int8 not null, primary key (user_id, specifications_id))
create table lab_user_specification_status_histories (user_id int8 not null, specification_status_histories_id int8 not null, primary key (user_id, specification_status_histories_id))
create table lab_user_units (user_id int8 not null, units_id int8 not null, primary key (user_id, units_id))
create table material (id int8 not null, name varchar(255), user_id int8, primary key (id))
create table material_material_specifications (material_id int8 not null, material_specifications_id int8 not null, primary key (material_id, material_specifications_id))
create table outofspec (id int8 not null, error char(1) not null, text varchar(255), value varchar(255), primary key (id))
create table parameter (id int8 not null, border int4 not null, name varchar(255), specification_id int4 not null, type varchar(255), unit_id int4 not null, primary key (id))
create table permission (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table permission_role_permissions (permission_id int8 not null, role_permissions_id int8 not null, primary key (permission_id, role_permissions_id))
create table result_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), primary key (id))
create table role (id int8 not null, code varchar(255), description varchar(255), name varchar(255), primary key (id))
create table role_permission (id int8 not null, permission_id int8, role_id int8, primary key (id))
create table role_role_permissions (role_id int8 not null, role_permissions_id int8 not null, primary key (role_id, role_permissions_id))
create table sample (id int8 not null, batch_id int8, quantity int4 not null, sample_no varchar(50), specification_id int8, status int8, dictionary_id int8, user_id int8, primary key (id))
create table sample_lab (id int8 not null, lab_id int8, quantity int4 not null, sample_id int8, primary key (id))
create table sample_sample_labs (sample_id int8 not null, sample_labs_id int8 not null, primary key (sample_id, sample_labs_id))
create table sample_sample_status_history (sample_id int8 not null, sample_status_history_id int8 not null, primary key (sample_id, sample_status_history_id))
create table sample_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), sample_id int8, user_id int8, primary key (id))
create table specification (id int8 not null, accepted_by int8, confirmed varchar(1), specification_no varchar(50), status int8, dictionary_id int8, material_id int8, primary key (id))
create table specification_specification_status_histories (specification_id int8 not null, specification_status_histories_id int8 not null, primary key (specification_id, specification_status_histories_id))
create table specification_status_history (id int8 not null, new_value varchar(50), old_value varchar(50), specification_id int8, user_id int8, primary key (id))
create table supplier (address_id int8 not null, deleted varchar(1), name varchar(50), primary key (address_id))
alter table if exists batch_batch_certificates add constraint UK_4xv5o3ej6bb14hmjljhc7tq63 unique (batch_certificates_id)
alter table if exists dictionary_dictionary_result add constraint UK_d5yw3vs6wn2mar24b4npaxf6n unique (dictionary_result_id)
alter table if exists dictionary_dictionary_sample add constraint UK_o3epfcogd2na8i1i7y41yh6fj unique (dictionary_sample_id)
alter table if exists dictionary_dictionary_specification add constraint UK_hel8t42qewq5vgdmnqpdqf4iq unique (dictionary_specification_id)
alter table if exists lab_user_batches add constraint UK_1pdhp7br3qxq8g6bhyyi3v1jv unique (batches_id)
alter table if exists lab_user_certificates add constraint UK_dmwbbatxx80vao69sgm5k9pce unique (certificates_id)
alter table if exists lab_user_materials add constraint UK_kupklapy5aek0jo5pffk3o6be unique (materials_id)
alter table if exists lab_user_results add constraint UK_tmyafldxt7f1h6yx1orpp6yh0 unique (results_id)
alter table if exists lab_user_result_status_histories add constraint UK_ru45le0s5riv4eyxicdshhfmo unique (result_status_histories_id)
alter table if exists lab_user_samples add constraint UK_drqr6uslw01q4ioqkq1a9v3gv unique (samples_id)
alter table if exists lab_user_sample_status_histories add constraint UK_hfpew16eb7a57f98w55fwhjhg unique (sample_status_histories_id)
alter table if exists lab_user_specifications add constraint UK_j0klnbmppgmje34q3npovvid2 unique (specifications_id)
alter table if exists lab_user_specification_status_histories add constraint UK_94x9ohgetimpnkswdg5itqkjy unique (specification_status_histories_id)
alter table if exists lab_user_units add constraint UK_e4y2c5sf1jee37hp2mk05xp57 unique (units_id)
alter table if exists material_material_specifications add constraint UK_g2o6ijo9itlwpvib5ghwupnx5 unique (material_specifications_id)
alter table if exists permission_role_permissions add constraint UK_1mfe70jfnuyo1ni0jpfxb8hke unique (role_permissions_id)
alter table if exists role_role_permissions add constraint UK_67aht2phhgp2bmkj9np13vdo unique (role_permissions_id)
alter table if exists sample_sample_labs add constraint UK_o5u5kwolo62sp59d16vup1n6h unique (sample_labs_id)
alter table if exists sample_sample_status_history add constraint UK_ph47xrxuu2xkcgfl0fb612p4i unique (sample_status_history_id)
alter table if exists specification add constraint UK_aimxplkar6nb74qw9q5rwyqw unique (specification_no)
alter table if exists specification_specification_status_histories add constraint UK_q77jdxw1lnevpstce7icx1fam unique (specification_status_histories_id)
alter table if exists public.manufacturer add constraint FKaselfumd9974uilhj1mwylo2p foreign key (address_id) references address
alter table if exists public.result add constraint FKmi3qxlyuo8097b89f04vfa5gy foreign key (dictionary_id) references dictionary
alter table if exists batch add constraint FKbe1johjqjq2fty1ef7a4m1tak foreign key (manufacturer_id) references public.manufacturer
alter table if exists batch add constraint FK940908d84s8fx60tfkx42r538 foreign key (supplier_id) references supplier
alter table if exists batch add constraint FKrucbaup8rpcphqjlmx9xj3h6f foreign key (user_id) references lab_user
alter table if exists batch_batch_certificates add constraint FK3cxo6n77v2vk64u04o1f9d0o0 foreign key (batch_certificates_id) references certificate
alter table if exists batch_batch_certificates add constraint FK5sgla19e9qhlnblr2xl3d8rl foreign key (batch_id) references batch
alter table if exists certificate add constraint FKfn1oqpx8bmt2doav7rtjgmoj foreign key (batch_id) references batch
alter table if exists certificate add constraint FK1pqc0jbvfwwqe1pu8rh4y0231 foreign key (user_id) references lab_user
alter table if exists dictionary_dictionary_result add constraint FK7brjv46hx2m8aas5p5pn4obgw foreign key (dictionary_result_id) references public.result
alter table if exists dictionary_dictionary_result add constraint FK6o1rue65laing6o3oso2ycs9w foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_sample add constraint FKecpaq38aunye6m5pry84vi294 foreign key (dictionary_sample_id) references sample
alter table if exists dictionary_dictionary_sample add constraint FK9t6jmtmnt4i73yu0acl8230tw foreign key (dictionary_id) references dictionary
alter table if exists dictionary_dictionary_specification add constraint FKch6pepgmenneokc9aryqmkxr1 foreign key (dictionary_specification_id) references specification
alter table if exists dictionary_dictionary_specification add constraint FKjkmlixkik51mfkrfknx5vv36r foreign key (dictionary_id) references dictionary
alter table if exists lab add constraint FK3pqrgrrijol0sq3bqovuiev2u foreign key (address_id) references address
alter table if exists lab_user add constraint FKn3bo7i559uu2x6e6ls911gus0 foreign key (lab_id) references lab
alter table if exists lab_user add constraint FKoe3htwm00ikfkica3xmpjrkrc foreign key (role_id) references role
alter table if exists lab_user_batches add constraint FK20v8tkus6nc0cbtt1kg4o8n5q foreign key (batches_id) references batch
alter table if exists lab_user_batches add constraint FKl85sow5cy9qywufnmkyrqcfpf foreign key (user_id) references lab_user
alter table if exists lab_user_certificates add constraint FKnc18ibkvoyhg9udfr6h1yvdsg foreign key (certificates_id) references certificate
alter table if exists lab_user_certificates add constraint FK2pmdjlni3yrqmphurlt0udwqe foreign key (user_id) references lab_user
alter table if exists lab_user_materials add constraint FK8lisllk42w63mjdk8yk1yxdqh foreign key (materials_id) references material
alter table if exists lab_user_materials add constraint FK98x1m45dcbi3kjnc9lbkc4yh foreign key (user_id) references lab_user
alter table if exists lab_user_results add constraint FKd23p56a6r6kc8w06x15btg78o foreign key (results_id) references public.result
alter table if exists lab_user_results add constraint FK8usx2ytyjnswbi0crvawkqp7o foreign key (user_id) references lab_user
alter table if exists lab_user_result_status_histories add constraint FKe2nug5r1j36sa8ekc9n9dm8db foreign key (result_status_histories_id) references result_status_history
alter table if exists lab_user_result_status_histories add constraint FKl0poaohk95f4jay7ukntgh9h1 foreign key (user_id) references lab_user
alter table if exists lab_user_samples add constraint FKh75bhg768jncbnqlv79lyusgb foreign key (samples_id) references sample
alter table if exists lab_user_samples add constraint FKj3w8m7wndefb7av6xdb0a6mf6 foreign key (user_id) references lab_user
alter table if exists lab_user_sample_status_histories add constraint FK1pltu9dh0orjiem7axd6tqkkk foreign key (sample_status_histories_id) references sample_status_history
alter table if exists lab_user_sample_status_histories add constraint FKoj4962dcxj7uap12lo3sd3c2j foreign key (user_id) references lab_user
alter table if exists lab_user_specifications add constraint FKiu2g175gtlc0plfg17sdphm11 foreign key (specifications_id) references specification
alter table if exists lab_user_specifications add constraint FK3oxe0ify28t1yygabcdaajnqh foreign key (user_id) references lab_user
alter table if exists lab_user_specification_status_histories add constraint FKm5yan2m4v7tpojb23g0rbtiex foreign key (specification_status_histories_id) references specification_status_history
alter table if exists lab_user_specification_status_histories add constraint FKq5k7nyx9usd1yt9l0hgghhduf foreign key (user_id) references lab_user
alter table if exists lab_user_units add constraint FKqaxq3cka7kdi7n32u7xs742qh foreign key (units_id) references public.unit
alter table if exists lab_user_units add constraint FKpdm2ylq4vylegy5cu2i398ekd foreign key (user_id) references lab_user
alter table if exists material add constraint FK2b6uo3bd3t45n1su02jjmoeh foreign key (user_id) references lab_user
alter table if exists material_material_specifications add constraint FKqqs2o9l1yl05ktq7xasmj2x5a foreign key (material_specifications_id) references specification
alter table if exists material_material_specifications add constraint FK3o9fh0v6oj1afim2ufiiwougw foreign key (material_id) references material
alter table if exists permission_role_permissions add constraint FKgtwgq3jxiuhbkdqu8pg2tlmjy foreign key (role_permissions_id) references role_permission
alter table if exists permission_role_permissions add constraint FK6waw1ga373he09v2mpml9u1th foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKf8yllw1ecvwqy3ehyxawqa1qp foreign key (permission_id) references permission
alter table if exists role_permission add constraint FKa6jx8n8xkesmjmv6jqug6bg68 foreign key (role_id) references role
alter table if exists role_role_permissions add constraint FKjv05nottgydlxaeix0cykmfgn foreign key (role_permissions_id) references role_permission
alter table if exists role_role_permissions add constraint FKe7klxo5ltt494cje6wkosd13e foreign key (role_id) references role
alter table if exists sample add constraint FKc4l0ss0nu2tfagemrset3if54 foreign key (dictionary_id) references dictionary
alter table if exists sample add constraint FKns071g9sb6pms65ljllilef3k foreign key (user_id) references lab_user
alter table if exists sample_lab add constraint FKqyx7pdryclg0y30e0os61rc5l foreign key (sample_id) references sample
alter table if exists sample_sample_labs add constraint FKgcspgpw94galrx4kqeoynljh9 foreign key (sample_labs_id) references sample_lab
alter table if exists sample_sample_labs add constraint FKfak1k731mraw5u110lma9nkc foreign key (sample_id) references sample
alter table if exists sample_sample_status_history add constraint FKt9b2po5e6hl9wvxb1cs80y5wt foreign key (sample_status_history_id) references sample_status_history
alter table if exists sample_sample_status_history add constraint FK1mlsuwg3s11u0wfdi8b5h5niy foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKpact184o818c2sbwcexb808n0 foreign key (sample_id) references sample
alter table if exists sample_status_history add constraint FKdnlwuj3qwh6fqq7hpny6lknvi foreign key (user_id) references lab_user
alter table if exists specification add constraint FKktty9hsdwwvpbau47nms6e2gy foreign key (dictionary_id) references dictionary
alter table if exists specification add constraint FKca9sf0ycou1q3nwhnlyf23829 foreign key (material_id) references specification
alter table if exists specification_specification_status_histories add constraint FKivkqaf2lyfbo4o0u3up98ac2u foreign key (specification_status_histories_id) references specification_status_history
alter table if exists specification_specification_status_histories add constraint FK51dkhnapcnlloso5b2cq1ka36 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKobnyglv75kxr1gn8y1tlkdby5 foreign key (specification_id) references specification
alter table if exists specification_status_history add constraint FKjpcgoy9cdab84exa06hre2rm2 foreign key (user_id) references lab_user
alter table if exists supplier add constraint FK95a8oipih48obtbhltjy7hgvb foreign key (address_id) references address
