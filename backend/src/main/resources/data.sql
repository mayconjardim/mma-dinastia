INSERT INTO tb_user (username, email, password, camp_name, register_date)VALUES ( 'Maycon', 'maycon@gmail.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'CampX', NOW());
INSERT INTO tb_user (username, email, password, camp_name, register_date)VALUES ( 'Teste', 'teste@example.com', '$2a$10$eACCYoNOHEqXve8aIWT8Nu3PkMXWBaOxJ9aORUYzfMQCbVBIhZ8tG', 'BTT', NOW());

INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_MANAGER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_organization ( name, initials, register_date) VALUES ('Dinastia Fight Championship', 'DFC', NOW());
