INSERT INTO tb_user (id, username, email, password, camp_name, register_date)VALUES (1L, 'Maycon', 'maycon@gmail.com', 'password123', 'CampX', NOW());
INSERT INTO tb_user (id, username, email, password, camp_name, register_date)VALUES (2L, 'Teste', 'teste@example.com', 'password123', 'BTT', NOW());

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_MANAGER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
