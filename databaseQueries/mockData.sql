--OGÓLNE
--Wszystkie tabele powinny mieć deleted (rozmawialiśmy, że robimu char // zmieniamy na String (ms))
--Jeśli chcemy do logu wpisywać przyczynę i autora zmiany, to powinniśmy dodać do każdej tabel dodać pola "user" i "reason" i wypełniać je wartościami
--(dla pierwszej zmiany jakaś wartość default) i te wartości powinnismy zaciągać triggerem do tabeli audit_log.
--czasem podwójne tabele

SELECT disableTriggers(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';
SELECT truncTable(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';

INSERT INTO
    address	(id,apartment_number,city,country_code,created_by,deleted,district,house_number,post_code,post_office,reason,street)
VALUES
(0,	'11',	'Warszawa',	'PL',	'user',	'false',	'Ochota',	'1',	'09-500',	'Warszawa',	null,	'Zielna'	),
(1,	'25',	'Kutno',	'PL',	'user',	'false',	null,	'5',	'05-123',	'Kutno',	null,	'Sienkiewicza'	),
(2,	'123',	'Kutno',	'PL',	'user',	'false',	null,	'1123',	'05-123',	'Warszawa',	null,	'Sklęczkowska'	),
(3,	'11',	'Warszawa',	'PL',	'user',	'false',	'Ochota',	'131',	'09-500',	'Warszawa',	null,	'Zielna'	),
(4,	'2',	'Łódź',	    'PL',	'user',	'false',	null,	'21',	'11-300',	'Łódź',	null,	'Biała'	),
(5,	'11',	'Toruń',	'PL',	'user',	'false',	null,	'151',	'11-200',	'Toruń',	null,	'Gagarina'	),
(6,	'str.',	'Mumbai',	'IN',	'user',	'false',	null,	'str.1',	'2',	'12345',	null,	'Queens'	),
(7,	'11',	'Wuchan',	'CN',	'user',	'false',	null,	'161',	'54321',	'Wuchan',	null,	'HuangHo'	),
(8,	'11',	'Konin',	'PL',	'user',	'false',	null,	'171',	'05-200',	'Konin',	null,	'Zielona'	),
(9,	'56',	'Delhi',	'PL',	'user',	'true',	    null,	'str.1',	'25a',	'400700',	null,	'Ghandi'	),
(10, '2',	null,	    'Toruń','user',	'true',	    'Gagarina',	'2',	'Toruń',	null,	null,	'11'	);

INSERT INTO "manufacturer" ("id", "deleted", "name", "address_id", "created_by", "reason") VALUES
(0, 'false', 'Polfa Kutno S.A.', 1,'user',null),
(1, 'false', 'Pearl, Indie', 6,'user',null),
(2, 'false', 'Hebei Welcome, Chiny', 7,'user',null),
(3, 'false', 'Hortimex', 8,'user',null),
(4, 'false', 'Aastrid International', 9,'user',null),
(5, 'false', 'BASF', 2,'user',null);

INSERT INTO "lab" ("id", "deleted", "name", "address_id", "created_by", "reason") VALUES
(0, 'F', 'Laboratorium fizykochemiczne', 1, null, 'false'),
(1, 'F', 'Laboratorium mikrobiologiczne', 1, null, 'false'),
(2, 'F', 'Pomieszczenia do badan stabilności', 1, null, 'false'),
(3, 'F', 'Archiwum prób', 1, null, 'false'),
(4, 'F', 'Usługi laboratoryjne Sp. z o.o.', 4, null, 'false'),
(5, 'F', 'Uniwersytet Mikołaja Kopernika, pracownia NMR', 5, null, 'false');

INSERT INTO "lab_user" ("id", "email", "first_name", "last_name", "login", "password", "phone", "lab_id", "role_id", "created_by", "reason", "deleted") VALUES
(0, 'jkowalski0@wp.pl', 'Jan', 'Kowalski0', 'jkowalski', 'haslo123a', '0507082303', 1, 0,'user', null, 'false'),
(1, 'jkowalski1@wp.pl', 'Jan', 'Kowalski1', 'jkowalski', 'haslo123b', '0507082303', 1, 0,'user', null, 'false'),
(2, 'jkowalski2@wp.pl', 'Jan', 'Kowalski2', 'jkowalski', 'haslo123c', '0507082303', 1, 0,'user', null, 'false'),
(3, 'jkowalski3@wp.pl', 'Jan', 'Kowalski3', 'jkowalski', 'haslo123d', '0507082303', 1, 0,'user', null, 'false'),
(4, 'jkowalski4@wp.pl', 'Jan', 'Kowalski4', 'jkowalski', 'haslo123e', '0507082303', 1, 0,'user', null, 'false'),
(5, 'jkowalski5@wp.pl', 'Jan', 'Kowalski5', 'jkowalski', 'haslo123f', '0507082303', 1, 0,'user', null, 'false');

INSERT INTO "supplier" ("id", "deleted", "name", "address_id", "created_by", "reason") VALUES
(0, 'F', 'BASF', 2, 'user', null),
(1, 'F', 'Hortimex', 8, 'user', null),
(2, 'F', 'Aastrid International', 9, 'user', null),
(3, 'F', 'Polfa Kutno S.A.', 0, 'user', null),
(4, 'F', 'Chempol S.A. v2', 3, 'user', null),
(5, 'F', 'Chempol S.A. v3', 3, 'user', null);

--Jakie jest zastosowanie code
INSERT INTO "role" ("id", "code", "description", "name", "created_by", "reason", "deleted") VALUES
(0, 'LA', 'Pobieranie prób, wykonywanie analiz i wprowadzanie wyników.', 'Laborant', 'user', null, 'false'),
(1, 'LS', 'Wykonywanie analiz i wprowadzanie wyników.', 'Starszy laborant', 'user', null, 'false'),
(2, 'AM', 'Wykonywanie analiz i wprowadzanie wyników.', 'Młodszy analityk', 'user', null, 'false'),
(3, 'AN', 'Wykonywanie analiz i wprowadzanie wyników.', 'Analityk', 'user', null, 'false'),
(4, 'AS', 'Wykonywanie analiz i wprowadzanie wyników.', 'Starszy analityk', 'user', null, 'false'),
(5, 'KP', 'Sprawdzanie wyników.', 'Kierownik pracowni', 'user', null, 'false'),
(6, 'KL', 'Zatwierdzanie certyfikatów.', 'Kierownik laboratorium', 'user', null, 'false'),
(7, 'PA', 'Wprowadzanie zleceń, drukowanie certyfikatów.', 'Pracownik administracyjny', 'user', null, 'false'),
(8, 'SA', 'Administracja systemem.', 'Administrator systemu', 'user', null, 'false'),
(9, 'GO', 'Podgląd wyników.', 'Gość', 'user', null, 'false');

--powinien być internal batch no i manufacturer batch no (dla produktów własnych jest to ten sam numer)
INSERT INTO "batch" ("id", "internal_batch_no","manufacturer_batch_no", "deleted", "manufacturer_id", "supplier_id", "user_id", "created_by", "reason") VALUES
(0, '0212244','0212244', 'false', 1, 1, 0,'user',null),
(1, '45230871', '45230871','false', 0, 1, 0,'user',null),
(2, '202102/0001A', '202102/0001A','false', 3, 1, 0,'user',null),
(3, '202102/0002A','202102/0002A', 'false', 2, 1, 0,'user',null),
(4, '202102/0003A','202102/0003A', 'false', 1, 3, 0,'user',null),
(5, '202102/0004A','202102/0004A', 'false', 1, 4, 0,'user',null);

INSERT INTO "certificate" ("id", "accepted_by", "certificate_no", "deleted", "name", "batch_id", "user_id", "created_by", "reason") VALUES
(0, 0, 'ZS030148', 'F', 'Witamina C', 0, 5,'user',null),
(1, 0, 'ZP042071', 'F', 'VITAMINUM C tabletki 200 mg', 1, 5,'user',null);

INSERT INTO "dictionary" ("id", "code", "deleted", "dictionary_code", "value", "created_by", "reason") VALUES
(0, '1', 'F', '1', '1','user',null),
(1, '1', 'F', '1', '1','user',null);

INSERT INTO "material" ("id", "name", "user_id", "created_by", "reason", "deleted") VALUES
(0, 'Witamina C', 0,'user', null, 'false'),
(1, 'Witamina C tabletki 200mg', 0,'user', null, 'false'),
(2, 'Witamina C tabletki 1000mg', 0,'user', null, 'false');

--Są 2 razy tabele outofspec.
--Tabelę należy uzupełnić o pola zgodnie ze schematem postępowania, czyli poszukiwanie błędu oczywistego z czeklistą, poszukiwanie błędu nieoczywistego z opisem
--decyzję o zaakceptowaniu wyniku pierwotnego lub wprowadzeniu nowego wyniku po postępowaniu.
INSERT INTO "out_of_spec" ("id", "error", "result_id","name", "simple_investigation", "complete_investigation", "value", "created_by", "reason", "deleted") VALUES
(0, 'T', 0, 'outOfSpec1', 'Opis postępowania wyjaśniającego.', 'złożona analiza', '2,5 mg','user', null, 'false'),
(1, 'T', 0, 'outOfSpec2','Opis postępowania wyjaśniającego.', 'złożona analiza', '5,0 mg','user', null, 'false'),
(2, 'T', 0, 'outOfSpec3','Opis postępowania wyjaśniającego.', 'złożona analiza', '7,0 mg','user', null, 'false');

--Konieczna liczba porządkowa do sortowania i jakaś możliwość robienia "podparametrów"
--Brak limitów (ważne!)
--Brak liczby miejsc po przecinku (np. accuracy)
--Jakie jest zastosowanie pola "border"
--Jakie jest zastosowanie pola type
--Rozumiem, że jednostka będzie w name i tutaj "unit_id" jest do wykorzystania np. na wykresach i w innych przpadkach. Musi być nillowalne np. dla wyglądu.
INSERT INTO "parameter" ("id", "border", "name", "type", "specification_id", "unit_id", "created_by", "reason", "deleted") VALUES
( 0, 1, 'Wygląd', 'Type', 0, null ,'user', null, 'false'),
( 1, 1, 'Tożsamość', 'Type', 0, null ,'user', null, 'false'),
( 2, 1, 'Strata po suszeniu, nie więcej niż, %', 'Type', 0, 0 ,'user', null, 'false'),
( 3, 1, 'Zawartość witaminy C w przeliczeniu na substancję bezwodną, %', 'Type', 0, 0 ,'user', null, 'false'),
( 4, 1, 'Ogólna liczba bakterii w 1 g, nie więcej niż', 'Type', 0, null ,'user', null, 'false'),
( 5, 1, 'Ogólna liczba grzybów w 1 g, nie więcej niż', 'Type', 0, null ,'user', null, 'false'),
( 6, 1, 'Staphylococcus aureus w 1 g', 'Type', 0, null ,'user', null, 'false'),
( 7, 1, 'Pseudomonas aeruginosa w 1 g', 'Type', 0, null ,'user', null, 'false'),
( 8, 1, 'Rodzina Enterobacteriaceae w 1 g', 'Type', 0, null ,'user', null, 'false'),
(10, 1, 'Wygląd', 'Type', 0, null ,'user', null, 'false'),
(11, 1, 'Tożsamość', 'Type', 0, null ,'user', null, 'false'),
(12, 1, 'Średnica tabletki, mm', 'Type', 0, 1 ,'user', null, 'false'),
(13, 1, 'Średnia masa 1 tabletki, g', 'Type', 0, 2 ,'user', null, 'false'),
(14, 1, 'Jednolitość masy pojedynczych tabletek', 'Type', 0, null ,'user', null, 'false'),
(15, 1, 'Czas rozpadu tabletki w wodzie, min', 'Type', 0, 3 ,'user', null, 'false'),
(16, 1, 'Zawartość kwasu askorbowego, g/tabl', 'Type', 0, 4 ,'user', null, 'false'),
(17, 1, 'Ogólna liczba bakterii', 'Type', 0, null ,'user', null, 'false'),
(18, 1, 'Ogólna liczba grzybów', 'Type', 0, null ,'user', null, 'false'),
(19, 1, 'Escherichia coli w 1g', 'Type', 0, null ,'user', null, 'false'),
(20, 1, 'Rodzina Enterobacteriaceae i inne pałeczki Gram-ujemne', 'Type', 0, null ,'user', null, 'false');

--chyba brak tabeli status (koumna 3)
--czy sprawdzony i zakończony dodajemy tu, czy obsługujemy przez status?
--czy value będziemy obsługiwać przez string, czy jsonb
--pytanie, czy nazwę parametrów i limity kopiujemy z tabeli "parameter", czy robimy to przez relację (chyba przez relację, ale warto wspomnieć o tej drugiej możliwości)
--wyniki mikrobiologiczne, czasem liczba czasem tekst, sposób przechowywania wyników typu wartość, zakres, średnia i zakres,
INSERT INTO "result" ("id", "value", "status", "parameter_id", "sample_id", "user_id", "created_by", "reason", "deleted") VALUES
( 0, 'odpowiada', NULL, 0, 0, 3 ,'user', null, 'false'),
( 1, 'odpowiada', NULL, 1, 0, 3 ,'user', null, 'false'),
( 2, 'bezwodna', NULL, 2, 0, 3 ,'user', null, 'false'),
( 3, '100,17', NULL, 3, 0, 3 ,'user', null, 'false'),
( 4, '0', NULL, 4, 0, 3 ,'user', null, 'false'),
( 5, '0', NULL, 5, 0, 3 ,'user', null, 'false'),
( 6, 'nieobecne', NULL, 6, 0, 3 ,'user', null, 'false'),
( 7, 'nieobecne', NULL, 7, 0, 3 ,'user', null, 'false'),
( 8, 'nieobecne', NULL, 8, 0, 3 ,'user', null, 'false'),
(10, 'odpowiada', NULL, 10, 0, 3 ,'user', null, 'false'),
(11, 'odpowiada', NULL, 11, 0, 3 ,'user', null, 'false'),
(12, '10,15', NULL, 12, 0, 3 ,'user', null, 'false'),
(13, '0,46', NULL, 13, 0, 3 ,'user', null, 'false'),
(14, '0,46(0,451-0,475)', NULL, 14, 0, 3 ,'user', null, 'false'),
(15, '00:10:59(00:07:49-00:14:32)', NULL, 15, 0, 3 ,'user', null, 'false'),
(16, '0,196', NULL, 16, 0, 3 ,'user', null, 'false'),
(17, '100', NULL, 17, 0, 3 ,'user', null, 'false'),
(18, '<10', NULL, 18, 0, 3 ,'user', null, 'false'),
(19, 'nieobecne', NULL, 19, 0, 3 ,'user', null, 'false'),
(20, 'nieobecne', NULL, 20, 0, 3 ,'user', null, 'false');

--Jakie jest zastosowanie code
INSERT INTO "permission" ("id", "code", "description", "name", "created_by", "reason", "deleted") VALUES
( 0, 'zp', 'zgłaszanie prób', 'zgłaszanie prób' ,'user', null, 'false'),
( 1, 'pp', 'pobór prób', 'pobór prób' ,'user', null, 'false'),
( 2, 'rp', 'pobór prób', 'przyjmowanie prób' ,'user', null, 'false'),
( 3, 'dp', 'pobór prób', 'przydział prób' ,'user', null, 'false'),
( 4, 'ww', 'pobór prób', 'wprowadzanie wyników' ,'user', null, 'false'),
( 5, 'wp', 'pobór prób', 'wprowadzanie wyników poza specyfikacją' ,'user', null, 'false'),
( 6, 'zp', 'pobór prób', 'zatwierdzanie wyników poza specyfikacją' ,'user', null, 'false'),
( 7, 'sw', 'pobór prób', 'sprawdzanie wyników' ,'user', null, 'false'),
( 8, 'zc', 'pobór prób', 'zatwierdzanie certyfikatu' ,'user', null, 'false'),
( 9, 'wc', 'pobór prób', 'wydruk certyfikatu' ,'user', null, 'false'),
(10, 'ws', 'pobór prób', 'wprowadzanie specyfikacji' ,'user', null, 'false'),
(11, 'zs', 'pobór prób', 'zatwierdzanie specyfikacji' ,'user', null, 'false'),
(12, 'wu', 'pobór prób', 'wprowadzanie użytkowników' ,'user', null, 'false'),
(13, 'ww', 'pobór prób', 'wprowadzanie wytwórców' ,'user', null, 'false'),
(14, 'wd', 'pobór prób', 'wprowadzanie dostawców' ,'user', null, 'false'),
(15, 'wa', 'pobór prób', 'wprowadzanie adresów' ,'user', null, 'false');

INSERT INTO "role_permission" ("id", "permission_id", "role_id", "created_by", "reason", "deleted") VALUES
(0, 0, 0 ,'user', null, 'false');

--quantity powinno być float
--brak data poboru (sampling_date), data dostarczenia (delivery_date), data produkcji (manufacturing_date), data ważności (expiry_date)
--czy będzie informacja o opakowaniach (chyba jeden wiersz)
INSERT INTO "sample" ("id", "batch_id", "quantity", "sample_no", "specification_id", "status", "dictionary_id", "user_id", "created_by", "reason", "deleted") VALUES
(0, 0, 100, 'ZS030148', 0, 1, NULL, 0 ,'user', null, 'false'),
(1, 1,  50, 'ZP/21/00002', 2, 2, NULL, 1,'user', null, 'false'),
(2, 2,  20, 'ZP/21/00003', 1, 1, NULL, 4,'user', null, 'false'),
(3, 3, 100, 'ZP/21/00004', 2, 2, NULL, 4,'user', null, 'false'),
(4, 4, 500, 'ZP/21/00005', 3, 1, NULL, 1,'user', null, 'false'),
(5, 5,  15, 'ZP/21/00006', 4, 2, NULL, 5,'user', null, 'false');

--quantity powinno być float
INSERT INTO "sample_lab" ("id", "lab_id", "quantity", "sample_id", "created_by", "reason", "deleted") VALUES
(0, 1, 10, 2,'user', null, 'false');

--Brak nazwy i rynku
INSERT INTO "specification" ("id", "confirmed", "specification_no", "accepted_by", "material_id", "status", "user_id", "created_by", "reason", "deleted") VALUES
(0, 'T', 'S-J41907/A', 5, 0, 0, 4,'user', null, 'false'),
(1, 'T', 'ZN-99/MP/F/Ku-3066', 5, 1, 0, 4,'user', null, 'false'),
(2, 'T', 'SP/0002/A', 5, 0, 0, 4,'user', null, 'false'),
(3, 'T', 'SP/0003/A', 5, 0, 0, 4,'user', null, 'false'),
(4, 'T', 'SP/0004/A', 5, 0, 0, 4,'user', null, 'false'),
(5, 'T', 'SP/0005/A', 5, 0, 0, 4,'user', null, 'false');

--Co będziemy wpisywać w pole name?
--Jak obsłużymy zmiany (bo zmienią się wszystkie dokumenty). Może jednak kopiować jednostki do parametrów, albo tam wpisywać z ręki?
INSERT INTO "unit" ("id", "name", "value", "user_id", "created_by", "reason", "deleted") VALUES
(0, 'procent', '%', 0,'user', null, 'false'),
(1, 'milimetr', 'mm', 0,'user', null, 'false'),
(2, 'gram', 'g', 0,'user', null, 'false'),
(3, 'minuta', 'min.', 0,'user', null, 'false'),
(4, 'gram w tabletce', 'g/tabl.', 0,'user', null, 'false');

SELECT enableTriggers(TABLE_NAME) FROM information_schema.tables WHERE table_schema = 'public';
