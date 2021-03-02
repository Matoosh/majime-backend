--OGÓLNE
--Wszystkie tabele powinny mieć deleted (rozmawialiśmy, że robimu char)
--Jeśli chcemy do logu wpisywać przyczynę i autora zmiany, to powinniśmy dodać do każdej tabel dodać pola "user" i "reason" i wypełniać je wartościami
--(dla pierwszej zmiany jakaś wartość default) i te wartości powinnismy zaciągać triggerem do tabeli audit_log.

SELECT disableTriggers(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';
SELECT truncTable(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';

INSERT INTO address(id, deleted, country_code, city, district, street, house_number, apartment_number, post_code, post_office) VALUES
(0, 'F', 'PL', 'Warszawa', 'Ochota', 'Zielna', '11', '5', '09-500', 'Warszawa'),
(1, 'F', 'PL', 'Kutno', null, 'Sienkiewicza', '25', NULL, '05-123', 'Kutno'),
(2, 'F', 'PL', 'Kutno', null, 'Sklęczkowska', '123', '5', '05-123', 'Warszawa'),
(3, 'F', 'PL', 'Warszawa', 'Ochota', 'Zielna', '11', '5', '09-500', 'Warszawa'),
(4, 'F', 'PL', 'Łódź', null, 'Biała', '2', '53', '11-300', 'Łódź'),
(5, 'F', 'PL', 'Toruń', null, 'Gagarina', '11', '2', '11-200', 'Toruń'),
(6, 'F', 'IN', 'Mumbai', null, 'Queens str.', '11', '2', '12345', 'Mumbai'),
(7, 'F', 'CN', 'Wuchan', null, 'HuangHo', '11', '2', '54321', 'Wuchan 19'),
(8, 'F', 'PL', 'Konin', null, 'Zielona', '11', '2', '05-200', 'Konin'),
(9, 'F', 'PL', 'Delhi', null, 'Ghandi str.', '123', '25a', '400700', 'Delhi 5'),
(10, 'F', 'PL', 'Toruń', null, 'Gagarina', '11', '2', '11-200', 'Toruń');

--powinien być internal batch no i manufacturer batch no (dla produktów własnych jest to ten sam numer)
INSERT INTO "batch" ("id", "batch_no", "deleted", "manufacturer_id", "supplier_id", "user_id") VALUES
(0, '0212244', 'F', 1, 1, 0),
(1, '202101/1235A', 'F', 2, 1, 0),
(2, '202102/0001A', 'F', 3, 1, 0),
(3, '202102/0002A', 'F', 2, 1, 0),
(4, '202102/0003A', 'F', 1, 3, 0),
(5, '202102/0004A', 'F', 1, 4, 0);

INSERT INTO "certificate" ("id", "accepted_by", "certificate_no", "deleted", "name", "batch_id", "user_id") VALUES
(0, 0, 'ZS030148', 'F', 'Witamina C', 0, 5);

INSERT INTO "dictionary" ("id", "code", "deleted", "dictionary_code", "value") VALUES
(0, '1', 'F', '1', '1');

INSERT INTO "lab" ("id", "deleted", "name", "address_id") VALUES
(0, 'F', 'Laboratorium fizykochemiczne', 1),
(1, 'F', 'Laboratorium mikrobiologiczne', 1),
(2, 'F', 'Pomieszczenia do badan stabilności', 1),
(3, 'F', 'Archiwum prób', 1),
(4, 'F', 'Usługi laboratoryjne Sp. z o.o.', 4),
(5, 'F', 'Uniwersytet Mikołaja Kopernika, pracownia NMR', 5);

INSERT INTO "lab_user" ("id", "email", "first_name", "last_name", "login", "password", "phone", "lab_id", "role_id") VALUES
(0, 'jkowalski0@wp.pl', 'Jan', 'Kowalski0', 'jkowalski', 'haslo123a', '0507082303', 1, 0),
(1, 'jkowalski1@wp.pl', 'Jan', 'Kowalski1', 'jkowalski', 'haslo123b', '0507082303', 1, 0),
(2, 'jkowalski2@wp.pl', 'Jan', 'Kowalski2', 'jkowalski', 'haslo123c', '0507082303', 1, 0),
(3, 'jkowalski3@wp.pl', 'Jan', 'Kowalski3', 'jkowalski', 'haslo123d', '0507082303', 1, 0),
(4, 'jkowalski4@wp.pl', 'Jan', 'Kowalski4', 'jkowalski', 'haslo123e', '0507082303', 1, 0),
(5, 'jkowalski5@wp.pl', 'Jan', 'Kowalski5', 'jkowalski', 'haslo123f', '0507082303', 1, 0);

INSERT INTO "manufacturer" ("id", "deleted", "name", "address_id") VALUES
(0, 'F', 'Polfa Kutno S.A.', 1),
(1, 'F', 'Pearl, Indie', 6),
(2, 'F', 'Hebei Welcome, Chiny', 7),
(3, 'F', 'Hortimex', 8),
(4, 'F', 'Aastrid International', 9),
(5, 'F', 'BASF', 2);

INSERT INTO "material" ("id", "name", "user_id") VALUES
(0, 'Witamina C', 0);

--Są 2 razy tabele outofspec.
--Tabelę należy uzupełnić o pola zgodnie ze schematem postępowania, czyli poszukiwanie błędu oczywistego z czeklistą, poszukiwanie błędu nieoczywistego z opisem
--decyzję o zaakceptowaniu wyniku pierwotnego lub wprowadzeniu nowego wyniku po postępowaniu.
INSERT INTO "outofspec" ("id", "error", "result_id", "text", "value") VALUES
(0, 'T', 0, 'Opis postępowania wyjaśniającego.', '2,5 mg');

INSERT INTO "out_of_spec" ("id", "description", "error", "value", "result_id") VALUES
(0, 'asd', 'T', '2,5 mg', 0);

--Konieczna liczba porządkowa do sortowania i jakaś możliwość robienia "podparametrów"
--Brak limitów (ważne!)
--Brak liczby miejsc po przecinku (np. accuracy)
--Jakie jest zastosowanie pola "border"
--Jakie jest zastosowanie pola type
--Rozumiem, że jednostka będzie w name i tutaj "unit_id" jest do wykorzystania np. na wykresach i w innych przpadkach. Musi być nillowalne np. dla wyglądu.
INSERT INTO "parameter" ("id", "border", "name", "type", "specification_id", "unit_id") VALUES
( 0, 1, 'Wygląd', 'Type', 0, null),
( 1, 1, 'Tożsamość', 'Type', 0, null),
( 2, 1, 'Strata po suszeniu, nie więcej niż, %', 'Type', 0, 0),
( 3, 1, 'Zawartość witaminy C w przeliczeniu na substancję bezwodną, %', 'Type', 0, 0),
( 4, 1, 'Ogólna liczba bakterii w 1 g, nie więcej niż', 'Type', 0, null),
( 5, 1, 'Ogólna liczba grzybów w 1 g, nie więcej niż', 'Type', 0, null),
( 6, 1, 'Staphylococcus aureus w 1 g', 'Type', 0, null),
( 7, 1, 'Pseudomonas aeruginosa w 1 g', 'Type', 0, null),
( 8, 1, 'Rodzina Enterobacteriaceae w 1 g', 'Type', 0, null);

--chyba brak tabeli status (koumna 3)
--czy sprawdzony i zakończony dodajemy tu, czy obsługujemy przez status?
--czy value będziemy obsługiwać przez string, czy jsonb
--pytanie, czy nazwę parametrów i limity kopiujemy z tabeli "parameter", czy robimy to przez relację (chyba przez relację, ale warto wspomnieć o tej drugiej możliwości)
INSERT INTO "result" ("id", "value", "status", "parameter_id", "sample_id", "user_id") VALUES
( 0, 'odpowiada', NULL, 0, 0, 3),
( 1, 'odpowiada', NULL, 1, 0, 3),
( 2, 'bezwodna', NULL, 2, 0, 3),
( 3, '100,17', NULL, 3, 0, 3),
( 4, '0', NULL, 4, 0, 3),
( 5, '0', NULL, 5, 0, 3),
( 6, 'nieobecne', NULL, 6, 0, 3),
( 7, 'nieobecne', NULL, 7, 0, 3),
( 8, 'nieobecne', NULL, 8, 0, 3);

--Jakie jest zastosowanie code
INSERT INTO "permission" ("id", "code", "description", "name") VALUES
( 0, 'zp', 'zgłaszanie prób', 'zgłaszanie prób'),
( 1, 'pp', 'pobór prób', 'pobór prób'),
( 2, 'rp', 'pobór prób', 'przyjmowanie prób'),
( 3, 'dp', 'pobór prób', 'przydział prób'),
( 4, 'ww', 'pobór prób', 'wprowadzanie wyników'),
( 5, 'wp', 'pobór prób', 'wprowadzanie wyników poza specyfikacją'),
( 6, 'zp', 'pobór prób', 'zatwierdzanie wyników poza specyfikacją'),
( 7, 'sw', 'pobór prób', 'sprawdzanie wyników'),
( 8, 'zc', 'pobór prób', 'zatwierdzanie certyfikatu'),
( 9, 'wc', 'pobór prób', 'wydruk certyfikatu'),
(10, 'ws', 'pobór prób', 'wprowadzanie specyfikacji'),
(11, 'zs', 'pobór prób', 'zatwierdzanie specyfikacji'),
(12, 'wu', 'pobór prób', 'wprowadzanie użytkowników'),
(13, 'ww', 'pobór prób', 'wprowadzanie wytwórców'),
(14, 'wd', 'pobór prób', 'wprowadzanie dostawców'),
(15, 'wa', 'pobór prób', 'wprowadzanie adresów');

--Jakie jest zastosowanie code
INSERT INTO "role" ("id", "code", "description", "name") VALUES
(0, 'LA', 'Pobieranie prób, wykonywanie analiz i wprowadzanie wyników.', 'Laborant'),
(1, 'LS', 'Wykonywanie analiz i wprowadzanie wyników.', 'Starszy laborant'),
(2, 'AM', 'Wykonywanie analiz i wprowadzanie wyników.', 'Młodszy analityk'),
(3, 'AN', 'Wykonywanie analiz i wprowadzanie wyników.', 'Analityk'),
(4, 'AS', 'Wykonywanie analiz i wprowadzanie wyników.', 'Starszy analityk'),
(5, 'KP', 'Wykonywanie analiz i wprowadzanie wyników.', 'Kierownik pracowni'),
(6, 'KL', 'Wykonywanie analiz i wprowadzanie wyników.', 'Kierownik laboratorium'),
(7, 'PA', 'Wykonywanie analiz i wprowadzanie wyników.', 'Pracownik administracyjny'),
(8, 'SA', 'Wykonywanie analiz i wprowadzanie wyników.', 'Administrator systemu'),
(9, 'GO', 'Wykonywanie analiz i wprowadzanie wyników.', 'Gość');

INSERT INTO "role_permission" ("id", "permission_id", "role_id") VALUES
(0, 0, 0);

--quantity powinno być float
--brak data poboru (sampling_date), data dostarczenia (delivery_date), data produkcji (manufacturing_date), data ważności (expiry_date)
INSERT INTO "sample" ("id", "batch_id", "quantity", "sample_no", "specification_id", "status", "dictionary_id", "user_id") VALUES
(0, 0, 100, 'ZS030148', 0, 1, NULL, 0),
(1, 1, 50, 'ZP/21/00002', 2, 2, NULL, 1),
(2, 2, 20, 'ZP/21/00003', 1, 1, NULL, 4),
(3, 3, 100, 'ZP/21/00004', 2, 2, NULL, 4),
(4, 4, 500, 'ZP/21/00005', 3, 1, NULL, 1),
(5, 5, 15, 'ZP/21/00006', 4, 2, NULL, 5);

--quantity powinno być float
INSERT INTO "sample_lab" ("id", "lab_id", "quantity", "sample_id") VALUES
(0, 1, 10, 2);

--Brak nazwy i rynku
INSERT INTO "specification" ("id", "confirmed", "specification_no", "accepted_by", "material_id", "status", "user_id") VALUES
(0, 'T', 'S-J41907/A', 5, 0, 0, 4),
(1, 'T', 'SP/0001/A', 5, 0, 0, 4),
(2, 'T', 'SP/0002/A', 5, 0, 0, 4),
(3, 'T', 'SP/0003/A', 5, 0, 0, 4),
(4, 'T', 'SP/0004/A', 5, 0, 0, 4),
(5, 'T', 'SP/0005/A', 5, 0, 0, 4);

INSERT INTO "supplier" ("id", "deleted", "name", "address_id") VALUES
(0, 'F', 'BASF', 2),
(1, 'F', 'Hortimex', 8),
(2, 'F', 'Aastrid International', 9),
(3, 'F', 'Chempol S.A.', 3),
(4, 'F', 'Chempol S.A. v2', 3),
(5, 'F', 'Chempol S.A. v3', 3);

--Co będziemy wpisywać w pole name?
--Jak obsłużymy zmiany (bo zmienią się wszystkie dokumenty). Może jednak kopiować jednostki do parametrów, albo tam wpisywać z ręki?
INSERT INTO "unit" ("id", "name", "value", "user_id") VALUES
(0, 'procent', '%', 0),
(1, 'procent', '%', 0);

SELECT enableTriggers(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';