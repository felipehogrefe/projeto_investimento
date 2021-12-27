INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
INSERT INTO tb_user (name, email, password) VALUES ('User User', 'user@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');

INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (role_name) VALUES ('ROLE_USER');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);

INSERT INTO tb_share (acronym) VALUES ('GOG');
INSERT INTO tb_share (acronym) VALUES ('OGO');

INSERT INTO tb_share_value (value, date, share_id) VALUES (100, {ts '2012-09-17 00:00:00.00'},1);
INSERT INTO tb_share_value (value, date, share_id) VALUES (110, {ts '2012-09-18 00:00:00.00'},1);
INSERT INTO tb_share_value (value, date, share_id) VALUES (120, {ts '2012-09-19 00:00:00.00'},1);
INSERT INTO tb_share_value (value, date, share_id) VALUES (90, {ts '2012-09-20 00:00:00.00'},1);

INSERT INTO tb_share_value (value, date, share_id) VALUES (10, {ts '2012-09-17 00:00:00.00'},2);
INSERT INTO tb_share_value (value, date, share_id) VALUES (11, {ts '2012-09-18 00:00:00.00'},2);
INSERT INTO tb_share_value (value, date, share_id) VALUES (12, {ts '2012-09-19 00:00:00.00'},2);
INSERT INTO tb_share_value (value, date, share_id) VALUES (9, {ts '2012-09-20 00:00:00.00'},2);

INSERT INTO tb_investment (share_id, user_id, initial_value, start_date, end_date, quantity_of_quotas) VALUES (1, 3, 100, {ts '2012-09-17 00:00:00.00'}, {ts '2012-09-19 00:00:00.00'},5);
INSERT INTO tb_investment (share_id, user_id, initial_value, start_date, end_date, quantity_of_quotas) VALUES (2, 3, 100, {ts '2012-09-17 00:00:00.00'}, {ts '2012-09-19 00:00:00.00'},5);

