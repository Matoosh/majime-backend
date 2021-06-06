-- adress, manufacturer, supplier, lab, 
-- material, specification, parameter, result
-- batch, sample

INSERT INTO "address" ("id", "apartment_number", "city", "country_code", "created_by", "deleted", "district", "house_number", "post_code", "post_office", "reason", "street") VALUES
(1, '--', 'Kutno', 'Polska', NULL, 'false', '--', '25', '99-300', 'Kutno', NULL, 'Sienkiewicza'),
(2, '--', 'Kutno', 'Polska', NULL, 'false', '--', '25', '99-300', 'Kutno', NULL, 'Sienkiewicza'),
(3, '--', 'Zhejang', 'Chiny', NULL, 'false', '--', '1234', '12345', 'Zhejang', NULL, 'Ping-Pong'),
(4, '--', 'Pekin', 'Chiny', NULL, 'false', '--', '12345', '12345', 'Pekin', NULL, 'Pong-Ping'),
(5, '1', 'BeerSeba', 'IL', NULL, 'false', '--', '1', '12345', 'BeerSeba', NULL, 'Ben-Gurion'),
(6, '--', 'Płock', 'Polska', NULL, 'false', '--', '25', '99-300', 'Kutno', NULL, 'Sienkiewicza'),
(7, '--', 'Płock', 'Polska', NULL, 'false', '--', '25', '99-300', 'Kutno', NULL, 'Sienkiewicza'),
(8, '--', 'Berlin', 'Niemcy', NULL, 'false', '--', '1234', '12345', 'Berlin', NULL, 'Neue'),
(9, '--', 'Berlin', 'Niemcy', NULL, 'false', '--', '12345', '12345', 'Darmstadt', NULL, 'Hoh'),
(10, '1', 'Paryż', 'IL', NULL, 'false', '--', '1', '12345', 'Paryż', NULL, 'DeGaulle');
SELECT setval('address_id_seq',((SELECT COUNT(*) FROM address) + 1));

INSERT INTO "manufacturer" ("id", "created_by", "deleted", "name", "reason", "address_id") VALUES
(1, NULL, 1, 'BASF', NULL, 6),
(2, NULL, 1, 'Huang-Ho', NULL, 4),
(3, NULL, 1, 'Teva', NULL, 5);
SELECT setval('manufacturer_id_seq',((SELECT COUNT(*) FROM manufacturer) + 1));

INSERT INTO "supplier" ("id", "created_by", "deleted", "name", "reason", "address_id") VALUES
(1, NULL, 1, 'Huahai', NULL, 3);
SELECT setval('supplier_id_seq',((SELECT COUNT(*) FROM supplier) + 1));

INSERT INTO "lab" ("id", "created_by", "deleted", "name", "reason", "address_id") VALUES
(1, NULL, 'FALSE', 'Laboratorium fizykochemiczne', NULL, 1),
(2, NULL, 'FALSE', 'Laboratorium mikrobiologiczne', NULL, 2);
SELECT setval('lab_id_seq',((SELECT COUNT(*) FROM lab) + 1));

--start bez full drop

INSERT INTO "material" ("id", "created_by", "deleted", "name", "reason", "user_id") VALUES
(1, NULL, 'FALSE', 'Witamina C', NULL, NULL),
(2, NULL, 'FALSE', 'Witamina B1', NULL, NULL);
SELECT setval('material_id_seq',((SELECT COUNT(*) FROM material) + 1));

INSERT INTO "specification" ("id", "confirmed", "created_by", "deleted", "name", "reason", "specification_no", "status", "type", "unit", "accepted_by", "material_id", "user_id") VALUES
(1, 'F', NULL, 'FALSE', 'Witamina C', NULL, 'S0001/17/A', 'CREATED', 'MATERIAŁ', 'g', NULL, 1, NULL),
(2, 'F', NULL, 'FALSE', 'Monovitan C 200 mg, tabletki powlekane', NULL, 'SL0001/17/A', 'CREATED', 'PRODUKT_LUZEM', 'g', NULL, 1, NULL),
(3, 'F', NULL, 'FALSE', 'Monovitan C 200 mg, kartonik', NULL, 'SO0003/17/A', 'CREATED', 'OPAKOWANIE', 'szt.', NULL, 1, NULL),
(4, 'F', NULL, 'FALSE', 'Monovitan C 200 mg, a''25', NULL, 'SG0003/17/A', 'CREATED', 'PRODUKT_GOTOWY', 'szt.', NULL, 1, NULL),
(5, 'F', NULL, 'FALSE', 'Monovitan C 200 mg, tabletki powlekane', NULL, 'SL0003/17/A', 'CREATED', 'PRODUKT_POŚREDNI', 'g', NULL, 1, NULL);
SELECT setval('specification_id_seq',((SELECT COUNT(*) FROM specification) + 1));

INSERT INTO "parameter" ("id", "accuracy", "border", "created_by", "deleted", "name", "reason", "type", "unit", "specification_id") VALUES
(1, '1', 'Biały lub prawie biały proszek', NULL, 'FALSE', 'Wygląd', NULL, 'Tekst', '--', 1),
(2, '1', '<5', NULL, 'FALSE', 'Zawartość wody', NULL, 'Średnia', '%', 1),
(3, '0', '190 - 210', NULL, 'FALSE', 'Zawartość witaminy C', NULL, 'Wartość', 'mg/tabl.', 2),
(4, '--', 'Białe lub prawie białe tabletki, bez plam i uszkodzeń', NULL, 'FALSE', 'Wygląd tabletek', NULL, 'Opis', '--', 2),
(5, '0', '240 - 260', NULL, 'FALSE', 'Średni ciężar tabletki', NULL, 'Wartość', 'mg', 2),
(6, '--', 'Zgodna ze wzorcem pantone', NULL, 'FALSE', 'Kolorystyka', NULL, 'Opis', '--', 3),
(7, '1', '44 - 46', NULL, 'FALSE', 'Wysokość', NULL, 'Wartość', 'mm', 3);
SELECT setval('parameter_id_seq',((SELECT COUNT(*) FROM parameter) + 1));

INSERT INTO "batch" ("id", "created_by", "deleted", "internal_batch_no", "manufacturer_batch_no", "reason", "manufacturer_id", "material_id", "supplier_id", "user_id") VALUES
(1, NULL, 'false', 'MP0000001/21', '01/05/VC', NULL, 2, 1, 1, NULL),
(2, NULL, 'false', 'O0001', 'ASD1234', NULL, 2, 1, 1, NULL),
(3, NULL, 'false', 'P001', 'P001', NULL, 2, 1, 1, NULL),
(4, NULL, 'false', 'PL01', 'PL01', NULL, 2, 1, 1, NULL);
SELECT setval('batch_id_seq',((SELECT COUNT(*) FROM batch) + 1));

INSERT INTO "sample" ("id", "created_at", "created_by", "deleted", "name", "quantity", "reason", "sample_no", "status", "type", "batch_id", "specification_id") VALUES
(3, '2021-05-19 11:44:44.379266', NULL, 'FALSE', 'Monowitan C, kartonik', 0, NULL, 'PMV1', 'CREATED', 'OPAKOWANIE', 2, 3),
(2, '2021-05-19 10:31:49.40736', NULL, 'FALSE', 'Witamina C', 200, NULL, 'P02', 'OOS', 'MATERIAŁ', 1, 1),
(5, '2021-05-19 23:28:03.359889', NULL, 'FALSE', 'Witamina C (kartonik)', 0, NULL, 'P1K', 'CREATED', 'OPAKOWANIE', 4, 3),
(6, '2021-05-18 08:07:24.226619', NULL, 'FALSE', 'Witamina C', 0, NULL, 'ZS0001/21', 'CREATED', 'MATERIAŁ', 1, 1),
(8, '2021-05-19 10:31:49.40736', NULL, 'FALSE', 'Witamina C', 0, NULL, 'P02', 'CREATED', 'MATERIAŁ', 1, 1),
(9, '2021-05-19 23:26:14.294445', NULL, 'FALSE', 'Witamina C (produkt gotowy)', 0, NULL, 'SP001', 'CREATED', 'PRODUKT_GOTOWY', 3, 4),
(10, '2021-05-19 23:28:03.359889', NULL, 'FALSE', 'Witamina C (kartonik)', 0, NULL, 'P1K', 'CREATED', 'OPAKOWANIE', 4, 3),
(11, '2021-05-18 08:07:24.226619', NULL, 'FALSE', 'Witamina C', 0, NULL, 'ZS0001/21', 'CREATED', 'MATERIAŁ', 1, 1),
(12, '2021-05-19 11:44:44.379266', NULL, 'FALSE', 'Monowitan C, kartonik', 0, NULL, 'PMV1', 'CREATED', 'OPAKOWANIE', 2, 3),
(14, '2021-05-19 23:26:14.294445', NULL, 'FALSE', 'Witamina C (produkt gotowy)', 0, NULL, 'SP001', 'CREATED', 'PRODUKT_GOTOWY', 3, 4),
(17, '2021-05-19 11:44:44.379266', NULL, 'FALSE', 'Monowitan C, kartonik', 0, NULL, 'PMV1', 'CREATED', 'OPAKOWANIE', 2, 3),
(18, '2021-05-19 10:31:49.40736', NULL, 'FALSE', 'Witamina C', 0, NULL, 'P02', 'CREATED', 'MATERIAŁ', 1, 1),
(19, '2021-05-19 23:26:14.294445', NULL, 'FALSE', 'Witamina C (produkt gotowy)', 0, NULL, 'SP001', 'CREATED', 'PRODUKT_GOTOWY', 3, 4),
(20, '2021-05-19 23:28:03.359889', NULL, 'FALSE', 'Witamina C (kartonik)', 0, NULL, 'P1K', 'CREATED', 'OPAKOWANIE', 4, 3),
(21, '2021-05-18 08:07:24.226619', NULL, 'FALSE', 'Witamina C', 0, NULL, 'ZS0001/21', 'CREATED', 'MATERIAŁ', 1, 1),
(23, '2021-05-19 10:31:49.40736', NULL, 'FALSE', 'Witamina C', 0, NULL, 'P02', 'CREATED', 'MATERIAŁ', 1, 1),
(24, '2021-05-19 23:26:14.294445', NULL, 'FALSE', 'Witamina C (produkt gotowy)', 0, NULL, 'SP001', 'CREATED', 'PRODUKT_GOTOWY', 3, 4),
(4, '2021-05-19 23:26:14.294445', NULL, 'FALSE', 'Witamina C (produkt gotowy)', 10, NULL, 'SP001', 'SAMPLED', 'PRODUKT_GOTOWY', 3, 4),
(13, '2021-05-19 10:31:49.40736', NULL, 'FALSE', 'Witamina C', 30, NULL, 'P02', 'SAMPLED', 'MATERIAŁ', 1, 1),
(15, '2021-05-19 23:28:03.359889', NULL, 'FALSE', 'Witamina C (kartonik)', 40, NULL, 'P1K', 'SAMPLED', 'OPAKOWANIE', 4, 3),
(22, '2021-05-19 11:44:44.379266', NULL, 'FALSE', 'Monowitan C, kartonik', 50, NULL, 'PMV1', 'SAMPLED', 'OPAKOWANIE', 2, 3),
(25, '2021-05-19 23:28:03.359889', NULL, 'FALSE', 'Witamina C (kartonik)', 60, NULL, 'P1K', 'SAMPLED', 'OPAKOWANIE', 4, 3),
(7, '2021-05-19 11:44:44.379266', NULL, 'FALSE', 'Monowitan C, kartonik', 20, NULL, 'PMV1', 'DELIVERED', 'OPAKOWANIE', 2, 3),
(16, '2021-05-18 08:07:24.226619', NULL, 'FALSE', 'Witamina C', 10, NULL, 'ZS0001/21', 'SAMPLED', 'MATERIAŁ', 1, 1),
(1, '2021-05-18 08:07:24.226619', NULL, 'FALSE', 'Witamina C', 10, NULL, 'ZS0001/21', 'PRINTED', 'MATERIAŁ', 1, 1);
SELECT setval('sample_id_seq',((SELECT COUNT(*) FROM sample) + 1));

INSERT INTO "sample_lab" ("id", "created_by", "deleted", "quantity", "reason", "lab_id", "sample_id") VALUES
(1, NULL, 'FALSE', '10', NULL, 1, 1),
(2, NULL, 'FALSE', '200', NULL, 1, 2),
(3, NULL, 'FALSE', '5', NULL, 1, 4),
(4, NULL, 'FALSE', '10', NULL, 1, 7),
(5, NULL, 'FALSE', '10', NULL, 2, 7);
SELECT setval('sample_lab_id_seq',((SELECT COUNT(*) FROM sample_lab) + 1));

INSERT INTO "result" ("id", "created_by", "deleted", "reason", "status", "value", "parameter_id", "sample_id", "user_id") VALUES
(2, NULL, 'FALSE', NULL, 'APPROVED', '4,5', 2, 1, NULL),
(4, NULL, 'FALSE', NULL, 'OOS', '6', 2, 2, NULL),
(3, NULL, 'FALSE', NULL, 'APPROVED', '3', 2, 1, NULL);
SELECT setval('result_id_seq',((SELECT COUNT(*) FROM result) + 1));

INSERT INTO "out_of_spec" ("id", "complete_investigation", "created_by", "deleted", "error", "name", "reason", "simple_investigation", "value", "result_id") VALUES
(1, 'Znaleziono błąd', NULL, 1, 'Tak', NULL, NULL, 'Nie stwierdzono błędu', '4,5', 2);
SELECT setval('out_of_spec_id_seq',((SELECT COUNT(*) FROM out_of_spec) + 1));
