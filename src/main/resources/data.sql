INSERT INTO USER(id, email, password)
VALUES (1, 'admin@byom.de', '{noop}asdf'), (2, 'arczi55455@gmail.com', '{noop}asdf'), (3, 'jojo@byom', '{noop}asdf');


INSERT INTO user_role(user_id, role)
VALUES (1, 'ROLE_ADMIN'), (1, 'ROLE_USER'), (2, 'ROLE_USER');


