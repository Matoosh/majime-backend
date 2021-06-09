--
-- Zapytanie uzupełnia bazę danych o następujące tabele: permission, role, role_permissions, lab_user, user_role
--
-- permission
--TRUNCATE TABLE public.permission CASCADE;
INSERT INTO public.permission (id, code, description, name) VALUES (1, 'ADMIN', 'Nadaje dostęp do podstrony Użytkownicy oraz Role i uprawnienia', 'Uprawnienia administracyjne');
INSERT INTO public.permission (id, code, description, name) VALUES (2, 'USER', 'Uprawniają do wyświetlania listy próbek, zmiany hasła i tak dalej.', 'Podstawowe uprawnienia');
INSERT INTO public.permission (id, code, description, name) VALUES (3, 'SAMPLE', 'Uprawnienie dające dostęp do podstrony Zgłoszenie próby oraz operacji wykonywanych w tle', 'Zgłoszenie próby');
INSERT INTO public.permission (id, code, description, name) VALUES (4, 'BATCH_COLLETION', 'Uprawnienie dające dostęp do podstrony Pobór próby oraz operacji wykonywanych w tle', 'Pobór próby');
INSERT INTO public.permission (id, code, description, name) VALUES (5, 'BATCH_ADOPTION', 'Uprawnienie dające dostęp do podstrony Przyjęcie próby oraz operacji wykonywanych w tle', 'Przyjęcie próby');
INSERT INTO public.permission (id, code, description, name) VALUES (6, 'ENTER_RESULTS', 'Uprawnienie dające dostęp do podstrony Wpisywanie wyników oraz operacji wykonywanych w tle', 'Wpisywanie wyników');
INSERT INTO public.permission (id, code, description, name) VALUES (7, 'OOS', 'Uprawnienie dające dostęp do podstrony Wynik poza specyfikacją oraz operacji wykonywanych w tle', 'Wynik poza specyfikacją');
INSERT INTO public.permission (id, code, description, name) VALUES (8, 'CHECKING_RESULTS', 'Uprawnienie dające dostęp do podstrony Sprawdzanie wyniku oraz operacji wykonywanych w tle', 'Sprawdzanie wyniku');
INSERT INTO public.permission (id, code, description, name) VALUES (9, 'CERTIFICATE_APPROVAL', 'Uprawnienie dające dostęp do podstrony Zatwierdzanie certyfikatu oraz operacji wykonywanych w tle', 'Zatwierdzanie certyfikatu');
INSERT INTO public.permission (id, code, description, name) VALUES (10, 'CERTIFICATE_PRINTS', 'Uprawnienie dające dostęp do podstrony Wydruk certyfikatu oraz operacji wykonywanych w tle', 'Wydruk certyfikatu');
INSERT INTO public.permission (id, code, description, name) VALUES (11, 'REPORTS', 'Uprawnienie dające dostęp do podstrony Raporty oraz operacji wykonywanych w tle', 'Raporty');
INSERT INTO public.permission (id, code, description, name) VALUES (12, 'LAB', 'Uprawnienie dające dostęp do podstrony Laboratoria oraz operacji wykonywanych w tle', 'Laboratoria');
INSERT INTO public.permission (id, code, description, name) VALUES (13, 'SPECIFICATION', 'Uprawnienie dające dostęp do podstrony Specyfikacje oraz operacji wykonywanych w tle', 'Specyfikacje');
INSERT INTO public.permission (id, code, description, name) VALUES (14, 'MATERIAL', 'Uprawnienie dające dostęp do podstrony Materiały oraz operacji wykonywanych w tle', 'Materiały');
INSERT INTO public.permission (id, code, description, name) VALUES (15, 'SUPPLIER', 'Uprawnienie dające dostęp do podstrony Dostawcy oraz operacji wykonywanych w tle', 'Dostawcy');
INSERT INTO public.permission (id, code, description, name) VALUES (16, 'MANUFACTURER', 'Uprawnienie dające dostęp do podstrony Producenci oraz operacji wykonywanych w tle', 'Producenci');
SELECT setval('permission_id_seq',((SELECT COUNT(*) FROM permission) + 1));
--role
--TRUNCATE TABLE public.role CASCADE;
INSERT INTO public.role (id, deleted, name) VALUES (1, 'FALSE', 'Administrator');
INSERT INTO public.role (id, deleted, name) VALUES (2, 'FALSE', 'Pracownik administracyjny');
INSERT INTO public.role (id, deleted, name) VALUES (3, 'FALSE', 'Kierownik pracownii');
INSERT INTO public.role (id, deleted, name) VALUES (4, 'FALSE', 'Kierownik laboratorium');
INSERT INTO public.role (id, deleted, name) VALUES (5, 'FALSE', 'Próbkarz');
INSERT INTO public.role (id, deleted, name) VALUES (6, 'FALSE', 'Laborant');
INSERT INTO public.role (id, deleted, name) VALUES (7, 'FALSE', 'Analityk');
SELECT setval('role_id_seq',((SELECT COUNT(*) FROM role) + 1));
--role_permission
--TRUNCATE TABLE public.role_permission CASCADE;
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 1);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 3);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 4);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 5);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 6);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 7);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 8);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 9);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 10);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 11);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 12);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 13);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 14);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 15);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (1, 16);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (3, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (3, 7);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (3, 10);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (4, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (4, 7);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (4, 8);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (4, 10);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 10);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 3);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 11);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 13);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 12);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 16);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 15);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (2, 14);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (6, 6);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (6, 5);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (6, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (5, 2);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (5, 4);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (7, 6);
INSERT INTO public.role_permission (role_id, permission_id) VALUES (7, 2);
/*
--address
TRUNCATE TABLE public.address CASCADE;
INSERT INTO public.address (id, apartment_number, city, country_code, created_by, deleted, district, house_number, post_code, post_office, reason, street) VALUES (1, '18', 'Centrum', 'PL', null, 'false', 'Centrum', '1', '00-000', 'Centrum', null, 'Centrum');
--lab
TRUNCATE TABLE public.lab CASCADE;
INSERT INTO public.lab (id, created_by, deleted, name, reason, address_id) VALUES (1, null, 'FALSE', 'Centrum', null, 1);
--lab_user
 */
--TRUNCATE TABLE public.lab_user CASCADE;
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (1, null, 'FALSE', 'administracja@majime.app', 'Jan', 'Brzechwa', '$2a$12$yNlbhpJlmPpMasc4Wh06IepaPRP6Mr6gtgMyln86E.Y1NyljuMlRC', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (2, null, 'FALSE', 'laborant@majime.app', 'Roman', 'Dmowski', '$2a$12$k4S6qZ1SsBEtbaaPeUvwb.lyyKym4QtFWBYY1J2.LkW/CyiT2lrb.', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (3, null, 'FALSE', 'probkarz@majime.app', 'Wojciech', 'Celiński', '$2a$12$6sPzaG9cGJ8F8.xT.4K3luJS.lwVp64f0zXS4rNo9edImrfG4gGwC', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (4, null, 'FALSE', 'analityk@majime.app', 'Bartek', 'Budyń', '$2a$12$4BKw4mzuhJOWLrDb1RnNOOjeZ6aw.hctizQyhc3Ca9AMHw9WKJBNK', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (5, null, 'FALSE', 'kpracowni@majime.app', 'Piotr', 'Drzewo', '$2a$12$Vp/QdPPfYLqTAbswMlX/o.euypKiaJywsxpCrtsqnhXl.qYlYexf2', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (6, null, 'FALSE', 'klaboratorium@majime.app', 'Mariusz', 'Skrzat', '$2a$12$KOLw1q0lFYLl8CzxS.vfwuLYLM2ER8OAyTj5sN3Z1tEL/FqlqImTO', '', null, 1);
INSERT INTO public.lab_user (id, created_by, deleted, email, first_name, last_name, password, phone, reason, lab_id) VALUES (7, null, 'FALSE', 'administrator@majime.app', 'Mateusz', 'Nieogarnięty', '$2a$12$dLII3WNHFC7KiU63GSoHGu1ElGPdRK1o/kLmSx02XngaRHG6hZt2m', '', null, 1);
--user_role
--TRUNCATE TABLE public.user_role CASCADE;
INSERT INTO public.user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO public.user_role (user_id, role_id) VALUES (2, 6);
INSERT INTO public.user_role (user_id, role_id) VALUES (3, 5);
INSERT INTO public.user_role (user_id, role_id) VALUES (4, 7);
INSERT INTO public.user_role (user_id, role_id) VALUES (5, 3);
INSERT INTO public.user_role (user_id, role_id) VALUES (6, 4);
INSERT INTO public.user_role (user_id, role_id) VALUES (7, 1);
