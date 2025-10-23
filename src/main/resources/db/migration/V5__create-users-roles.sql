INSERT INTO users (name, email, password, nick_name, phone, rented_at, active)
VALUES
('Rodrigo', 'rodrigo@email.com', '$2a$10$Wz4pC/2PZcHclpRMsy6rdu0p9jYX5Lb4TH7X9UiqMABc3DyTsCUOy', 'rodrigo', '(11) 90000-0001', NULL, TRUE),
('João',    'joao@email.com',    '$2a$10$O7rMWvT5ZqjGuaz.9QWfN.6NUBsWhE.ygw1NRW9FvFJ4ab5N4oDRC', 'jao',     '(11) 90000-0002', NULL, TRUE),
('Igor',     'igor@email.com',     '$2a$10$PAP8n/XRYOQYrXr57/fN3eWplNHm9ZXdm06cQscvK9jru6.3TsoFu', 'igor',     '(11) 90000-0003', NULL, TRUE);

INSERT INTO users_profiles (user_id, profile_id) VALUES
(5, 2),
(6, 1),
(7, 3);
