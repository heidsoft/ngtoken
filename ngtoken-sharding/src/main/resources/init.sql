CREATE SCHEMA IF NOT EXISTS `ds_master`;

DROP TABLE IF EXISTS `ds_master`.`tb_employee`;
CREATE TABLE `ds_master`.`tb_employee` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) NULL ,
`from`  varchar(255) NULL ,
PRIMARY KEY (`id`)
);

INSERT INTO `ds_master`.`tb_employee` VALUES(1,'name1', 'ds_master');
INSERT INTO `ds_master`.`tb_employee` VALUES(2,'name2', 'ds_master');
INSERT INTO `ds_master`.`tb_employee` VALUES(3,'name3', 'ds_master');

####
CREATE SCHEMA IF NOT EXISTS `ds_slave_0`;

DROP TABLE IF EXISTS `ds_slave_0`.`tb_employee`;
CREATE TABLE `ds_slave_0`.`tb_employee` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) NULL ,
`from`  varchar(255) NULL ,
PRIMARY KEY (`id`)
);

INSERT INTO `ds_slave_0`.`tb_employee` VALUES(1,'name1', 'ds_slave_0');
INSERT INTO `ds_slave_0`.`tb_employee` VALUES(2,'name2', 'ds_slave_0');
INSERT INTO `ds_slave_0`.`tb_employee` VALUES(3,'name3', 'ds_slave_0');


####
CREATE SCHEMA IF NOT EXISTS `ds_slave_1`;

DROP TABLE IF EXISTS `ds_slave_1`.`tb_employee`;
CREATE TABLE `ds_slave_1`.`tb_employee` (
`id`  int NOT NULL AUTO_INCREMENT ,
`name`  varchar(255) NULL ,
`from`  varchar(255) NULL ,
PRIMARY KEY (`id`)
);

INSERT INTO `ds_slave_1`.`tb_employee` VALUES(1,'name1', 'ds_slave_1');
INSERT INTO `ds_slave_1`.`tb_employee` VALUES(2,'name2', 'ds_slave_1');
INSERT INTO `ds_slave_1`.`tb_employee` VALUES(3,'name3', 'ds_slave_1');