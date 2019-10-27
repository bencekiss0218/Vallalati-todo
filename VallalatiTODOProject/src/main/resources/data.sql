INSERT INTO user (name, username, password, role) VALUES ('Bence', 'bence', '$2y$12$EN6Mwtf4ZlHniy08yI27QO.A./R.oILe181Nnv40PRLJxJo64e3X6', 'ROLE_TEAM_LEADER');
INSERT INTO user (name, username, password, role) VALUES ('Péter', 'peter', '$2y$12$WeaNrv0kj6jncBpFI60Sb.0Cgjvh.5ZNtWvW9M9FdLuoRJTDWUnEC', 'ROLE_TEAM_LEADER');
INSERT INTO user (name, username, password, role) VALUES ('Balázs', 'balazs', '$2y$12$dtJ9VZxHI5M8muDo8pddz.yWGsDZoZhe6lwKfh5z.AsQ8nuTOTytm', 'ROLE_TEAM_MEMBER');

INSERT INTO task (name, description, status, duedate, created_at, modified_at, priority) VALUES ('Work1', 'Description1', 'NEW', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 'HIGH');
INSERT INTO task (name, description, status, duedate, created_at, modified_at, priority) VALUES ('Work2', 'Description2', 'IN_WORK', CURRENT_TIMESTAMP() , CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 'HIGH');
INSERT INTO task (name, description, status, duedate, created_at, modified_at, priority) VALUES ('Work3', 'Description3', 'DONE', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 'HIGH');
INSERT INTO task (name, description, status, duedate, created_at, modified_at, priority) VALUES ('Work4', 'Description4', 'ON_HOLD', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP(),  CURRENT_TIMESTAMP(), 'LOW');

INSERT INTO comment (body, created_at, task_id, user_id) VALUES ('Ez mar kesz', CURRENT_TIMESTAMP(), 1, 1);
INSERT INTO comment (body, created_at, task_id, user_id) VALUES ('Ez is kesz', CURRENT_TIMESTAMP(), 2, 3);

INSERT INTO label (text) VALUES ('text1');
INSERT INTO label (text) VALUES ('text2');
INSERT INTO label (text) VALUES ('text3');
INSERT INTO label (text) VALUES ('text4');
INSERT INTO label (text) VALUES ('text5');

INSERT INTO task_labels (tasks_id, labels_id) VALUES (1, 1);
INSERT INTO task_labels (tasks_id, labels_id) VALUES (1, 3);
INSERT INTO task_labels (tasks_id, labels_id) VALUES (3, 2);
INSERT INTO task_labels (tasks_id, labels_id) VALUES (3, 4);
INSERT INTO task_labels (tasks_id, labels_id) VALUES (2, 5);


