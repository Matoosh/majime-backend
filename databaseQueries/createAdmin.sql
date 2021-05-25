-- --------------------------------------------------------------------------
--Create Admin (test123)
--(lab_user, role, permission, role_permission, user_role)
-- --------------------------------------------------------------------------

-- Zrzucanie danych dla tabeli public.lab_user: 0 rows
/*!40000 ALTER TABLE "lab_user" DISABLE KEYS */;
INSERT INTO "lab_user" ("id", "created_by", "deleted", "email", "first_name", "last_name", "password", "phone", "reason", "lab_id") VALUES
(1, NULL, 'FALSE', 'pkwiatek@majime.app', 'Piotr', 'Kwiatek', '$2a$12$suCJEG5il221Z7aLZhNajuJKcxtzb29ACt4AkMdw9iWblQx.5.Z06', '667958468', NULL, NULL);
/*!40000 ALTER TABLE "lab_user" ENABLE KEYS */;

-- Zrzucanie danych dla tabeli public.role: 0 rows
/*!40000 ALTER TABLE "role" DISABLE KEYS */;
INSERT INTO "role" ("id", "name", "deleted") VALUES
(1, 'ROLE_ADMIN', NULL);
/*!40000 ALTER TABLE "role" ENABLE KEYS */;

INSERt INTO "permission" (id, code, description, name)
VALUES
(1,'ADMIN_READ',null,null),
(2,'ADMIN_WRITE',null,null);

-- Zrzucanie danych dla tabeli public.role_permission: 0 rows
/*!40000 ALTER TABLE "role_permission" DISABLE KEYS */;
INSERT INTO "role_permission" ("role_id", "permission_id") VALUES
(1, 1),
(1, 2);
/*!40000 ALTER TABLE "role_permission" ENABLE KEYS */;

-- Zrzucanie danych dla tabeli public.user_role: 0 rows
/*!40000 ALTER TABLE "user_role" DISABLE KEYS */;
INSERT INTO "user_role" ("user_id", "role_id") VALUES
(1, 1);
/*!40000 ALTER TABLE "user_role" ENABLE KEYS */;

