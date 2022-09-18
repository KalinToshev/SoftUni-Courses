CREATE TABLE `users` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(26) NOT NULL,
    `profile_picture` BLOB,
    `last_login_time` TIME,
    `is_deleted` BOOLEAN
);

INSERT INTO `users` (`username`, `password`, `last_login_time`, `is_deleted`) 
VALUES ('Medunq6996', '$p9W7SCVxwJFqW6V2!DNpkCP#7', '14:39', FALSE),
       ('Dimitrovvv04_', 'GL&*VerS3Ak^Ks@aL5%(2Z^+m*', '14:39', TRUE),
       ('Hamburg.gerii', '3nFW!A(k5$99t@@mpIcnhVjX3!', '14:40', TRUE),
       ('Gosuaethelthryth', 'u&Uf84cYuQtN5I3Xxj8f7fxh4(', '14:40', TRUE),
       ('_blitzy', 'p$4mbyP%PEct*G)v^H7pj(Q5QJ', '14:41', FALSE);
