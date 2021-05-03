INSERT INTO
    role (id,name)
VALUES
    (1,'ROLE_ADMIN');

INSERt INTO
    permission (id, code, description, name)
VALUES
    (1,'ADMIN_READ',null,null),
    (2,'ADMIN_WRITE',null,null);

INSERT INTO
    role_permission (role_id, permission_id)
VALUES
    (1,1),
    (1,1);

INSERT INTO
    user_role (user_id, role_id)
VALUES
    (1,1);


