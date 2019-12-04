-- 基本用户表
CREATE TABLE `user` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`username` VARCHAR ( 300 ) NOT NULL UNIQUE,
	`password` VARCHAR ( 300 ) NOT NULL,
	`nickname` VARCHAR ( 3600 ),
	`avatar_url` VARCHAR ( 3600 ),
	`tel_number` VARCHAR ( 300 ),
	`rank` VARCHAR ( 300 ),
	`sign` VARCHAR ( 3600 ),
	`status` INTEGER,
	`ans_number` INTEGER,
	`correct_number` INTEGER,
	`good_at` VARCHAR ( 300 ),
	`register_time` VARCHAR ( 300 )
);
ALTER TABLE `user` AUTO_INCREMENT = 100;

-- 角色表
CREATE TABLE `role` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`role_name` VARCHAR ( 300 ),
	`role_describe` VARCHAR ( 3600 )
	);
ALTER TABLE `role` AUTO_INCREMENT = 100;


-- 权限表
CREATE TABLE `permission` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`permission_name` VARCHAR ( 300 ),
	`permission_describe` VARCHAR ( 3600 )
	);
ALTER TABLE `permission` AUTO_INCREMENT = 100;

-- 用户角色表
CREATE TABLE `user_role` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`uid` INTEGER,
	`rid` INTEGER,
	FOREIGN KEY ( `uid` ) REFERENCES `user` ( `id` ),
	FOREIGN KEY ( `rid` ) REFERENCES `role` ( `id` )
);
ALTER TABLE `user_role` AUTO_INCREMENT = 100;


-- 角色权限表
CREATE TABLE `role_permission` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`rid` INTEGER,
	`pid` INTEGER,
	FOREIGN KEY ( `rid` ) REFERENCES `role` ( `id` ),
	FOREIGN KEY ( `pid` ) REFERENCES `permission` ( `id` )
);
ALTER TABLE `user_role` AUTO_INCREMENT = 100;


-- 好友表
CREATE TABLE `friend` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`sid` INTEGER NOT NULL,
	`oid` INTEGER NOT NULL,
	`add_time` VARCHAR ( 300 ),
	FOREIGN KEY ( `sid` ) REFERENCES `user` ( `id` )
);
ALTER TABLE `friend` AUTO_INCREMENT = 100;

-- 好友验证表，
CREATE TABLE `verification` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`send_id` INTEGER,
	`receive_id` INTEGER,
	`ver_time` VARCHAR ( 300 ),
	`ver_status` INTEGER,
	FOREIGN KEY ( `send_id` ) REFERENCES `user` ( `id` )
);
ALTER TABLE `verification` AUTO_INCREMENT = 100;

-- 聊天表
CREATE TABLE `chat` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`send_id` INTEGER,
	`receive_id` INTEGER,
	`content` VARCHAR ( 3600 ),
	`read_status` INTEGER,
	`time` VARCHAR ( 300 )
);
ALTER TABLE `chat` AUTO_INCREMENT = 100;

-- 类型表
CREATE TABLE `type` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`type_name` VARCHAR(300),
	`type_describe` VARCHAR(3600),
	`hot` INTEGER,
	`difficulty` INTEGER
);
ALTER TABLE `type` AUTO_INCREMENT = 100;

-- 题目表
CREATE TABLE `question` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`create_time` VARCHAR ( 300 ),
	`type_name` VARCHAR ( 300 ),
	`question_owner` INTEGER,
	`question_describe` VARCHAR ( 3600 ),
	`question_explain` VARCHAR ( 3600 ),
	`item_a` VARCHAR ( 30 ),
	`item_b` VARCHAR ( 30 ),
	`item_c` VARCHAR ( 30 ),
	`item_d` VARCHAR ( 30 ),
	`item_ans` VARCHAR ( 30 ),
	`question_status` INTEGER
);
ALTER TABLE `question` AUTO_INCREMENT = 100;

-- 比赛表
CREATE TABLE `contest` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`user_a` INTEGER,
	`user_b` INTEGER,
	`win_id` INTEGER,
	`contest_time` VARCHAR ( 300 ) );
ALTER TABLE `contest` AUTO_INCREMENT = 100;

-- 比赛记录表
CREATE TABLE `contest_record` (
	`id` INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`contest_id` INTEGER,
	`question_id` INTEGER,
	`win_id` INTEGER
	);
ALTER TABLE `contest_record` AUTO_INCREMENT = 100;







-- 插入角色
INSERT `role` (`role_name`, `role_describe`) VALUES ('小白', '小白乃最初级学者');
UPDATE `role` SET `role_name` = '小白', `role_describe` = '小白是最菜的' WHERE `id` = 100;
SELECT * FROM `role`;
DELETE FROM `role` WHERE `id` = 100;

-- 插入权限
INSERT `permission` (`permission_name`, `permission_describe`) VALUES ('普通', '答普通题的权限');

SELECT * FROM `permission`;

-- 赋予用户角色
INSERT `user_role` (`uid`, `rid`) VALUES (1, 101);
SELECT * FROM `user_role`;
DELETE FROM `user_role` WHERE `id` = 100;

-- 查询某一用户多种角色
SELECT * FROM `role` WHERE `id` IN (SELECT `rid` FROM `user_role` WHERE `uid` = 1);

-- 插入角色权限
INSERT `role_permission`(`rid`, `pid`) VALUES (101, 100);

-- 通过用户id查询其权限
SELECT * FROM `permission` WHERE `id` IN (
	SELECT `pid` FROM `role_permission` WHERE `rid` IN (
	SELECT `rid` FROM `user_role` WHERE `uid` = 1 ) );

SELECT * FROM `role`;
DELETE FROM `role` WHERE `id` = 104;

SELECT * FROM `role` WHERE `id` IN (SELECT `rid` FROM `user_role` WHERE `uid` = 100);

INSERT `user_role`(`uid`, `rid`) VALUES(100, 101);

DELETE FROM `user_role` WHERE `id` = 109;


INSERT `user` ( `username`, `password`, `nickname`, `avatar_url`,`register_time` ) VALUES ( 'ecin5201', 'qwer1234', '智学者', 'http://148.70.50.70/source/1572837893695.jpg', NOW());

SELECT * FROM `user`;
