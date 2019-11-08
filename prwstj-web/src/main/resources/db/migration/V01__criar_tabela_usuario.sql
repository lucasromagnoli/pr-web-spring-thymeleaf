CREATE TABLE user (
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	email VARCHAR(100) NOT NULL UNIQUE,
	password_hash VARCHAR(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO user VALUES (0, 'Lucas Ramos Romagnoli', 'lucasr.romagnoli@gmail.com', '123456');