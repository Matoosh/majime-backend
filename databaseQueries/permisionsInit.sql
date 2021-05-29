DO $$
    DECLARE
        counter integer := 1;
        permissionsArray varchar[];
        permissionArray varchar[];
    BEGIN
        permissionsArray := array[['ADMIN','Uprawnienia administracyjne','Nadaje dostęp do podstrony Użytkownicy oraz Role i uprawnienia'],['USER','Podstawowe uprawnienia','Uprawniają do wyświetlania listy próbek, zmiany hasła i tak dalej.'],['SAMPLE','Zgłoszenie próby','Uprawnienie dające dostęp do podstrony Zgłoszenie próby oraz operacji wykonywanych w tle'],['BATCH_COLLETION','Pobór próby','Uprawnienie dające dostęp do podstrony Pobór próby oraz operacji wykonywanych w tle'],['BATCH_ADOPTION','Przyjęcie próby','Uprawnienie dające dostęp do podstrony Przyjęcie próby oraz operacji wykonywanych w tle'],['ENTER_RESULTS','Wpisywanie wyników','Uprawnienie dające dostęp do podstrony Wpisywanie wyników oraz operacji wykonywanych w tle'],['OOS','Wynik poza specyfikacją','Uprawnienie dające dostęp do podstrony Wynik poza specyfikacją oraz operacji wykonywanych w tle'],['CHECKING_RESULTS','Sprawdzanie wyniku','Uprawnienie dające dostęp do podstrony Sprawdzanie wyniku oraz operacji wykonywanych w tle'],['CERTIFICATE_APPROVAL','Zatwierdzanie certyfikatu','Uprawnienie dające dostęp do podstrony Zatwierdzanie certyfikatu oraz operacji wykonywanych w tle'],['CERTIFICATE_PRINTS','Wydruk certyfikatu','Uprawnienie dające dostęp do podstrony Wydruk certyfikatu oraz operacji wykonywanych w tle'],['REPORTS','Raporty','Uprawnienie dające dostęp do podstrony Raporty oraz operacji wykonywanych w tle'],['LAB','Laboratoria','Uprawnienie dające dostęp do podstrony Laboratoria oraz operacji wykonywanych w tle'],['SPECIFICATION','Specyfikacje','Uprawnienie dające dostęp do podstrony Specyfikacje oraz operacji wykonywanych w tle'],['MATERIAL','Materiały','Uprawnienie dające dostęp do podstrony Materiały oraz operacji wykonywanych w tle'],['SUPPLIER ','Dostawcy','Uprawnienie dające dostęp do podstrony Dostawcy oraz operacji wykonywanych w tle'],['MANUFACTURER','Producenci','Uprawnienie dające dostęp do podstrony Producenci oraz operacji wykonywanych w tle']];
        FOREACH permissionArray SLICE 1 IN ARRAY permissionsArray
            LOOP
                INSERT INTO permission(id, code, description, name) VALUES (counter, permissionArray[1], permissionArray[3], permissionArray[2]);
                counter := counter + 1;
            END LOOP;
    END $$;