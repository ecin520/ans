CREATE TABLE `user` (
	`id` INTEGER NOT NULL AUTO_INCREMENT,
	`username` VARCHAR ( 300 ) UNIQUE,
	 `password` VARCHAR ( 300 ),
	`nickname` VARCHAR ( 3600 ),
	`avatar_url` VARCHAR ( 3600 ),
	`tel_number` VARCHAR ( 300 ),
	`rank` VARCHAR ( 300 ),
	`sign` VARCHAR ( 3600 ),
	`status` INTEGER,
	`ans_number` INTEGER,
	`correct_number` INTEGER,
	`good_at` VARCHAR ( 300 ),
	`register_time` VARCHAR ( 300 ),
	PRIMARY KEY ( `id` )

);

INSERT `user` ( `username`, `password`, `nickname`, `avatar_url`,`register_time` ) VALUES ( 'ecin5201', 'qwer1234', '智学者', 'http://148.70.50.70/source/1572837893695.jpg', NOW());

SELECT * FROM `user`;
