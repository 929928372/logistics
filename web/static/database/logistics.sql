/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.5.40 : Database - db_logistics
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_logistics` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_logistics`;

/*Table structure for table `t_admin` */

DROP TABLE IF EXISTS `t_admin`;

CREATE TABLE `t_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_user` varchar(50) DEFAULT NULL,
  `admin_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `admin_user` (`admin_user`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_admin` */

insert  into `t_admin`(`id`,`admin_user`,`admin_password`) values (6,'xishi','000'),(7,'wangzhaojun','111'),(8,'diaochan','222'),(9,'yangyuhuan','333'),(10,'root','root');

/*Table structure for table `t_car` */

DROP TABLE IF EXISTS `t_car`;

CREATE TABLE `t_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `user_number` varchar(50) DEFAULT NULL,
  `car_number` varchar(50) DEFAULT NULL,
  `tel` varchar(50) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `car_road` varchar(50) DEFAULT NULL,
  `car_content` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_number` (`user_number`),
  UNIQUE KEY `user_number_2` (`user_number`),
  UNIQUE KEY `user_number_3` (`user_number`),
  UNIQUE KEY `user_number_4` (`user_number`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_car` */

insert  into `t_car`(`id`,`username`,`user_number`,`car_number`,`tel`,`address`,`car_road`,`car_content`) values (1,'关二爷','0011','马S666','0769-1351','广州天河','广州->北京',''),(2,'娜可露露','0012','鸟S666','0769-1352','广州白云','广州->上海',''),(3,'庄周','0013','鱼S666','0769-1353','广州越秀','广州->重庆',''),(4,'阿古朵','0014','熊S666','0769-1354','广州海珠','广州->新疆',''),(5,'成吉思汗','0015','狼S666','0769-1355','广州荔湾','广州->湖南',''),(13,'1','1','1','1','1','1','1'),(15,'孙策','0016','船666','0769-1356','广州','广州->北京','车速较快但费用较高'),(16,'李师傅','0017','粤S666','0769-1357','广州','广州->北京','容量很大价格实惠，但速度较慢'),(17,'痞子辉','8208208220','粤AXXXXX','7758258','广州天河区','广州->新疆','充满痞气的一辆车，可运输任何货物');

/*Table structure for table `t_carlog` */

DROP TABLE IF EXISTS `t_carlog`;

CREATE TABLE `t_carlog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_id` varchar(255) DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `startTime` varchar(255) DEFAULT NULL,
  `endTime` varchar(255) DEFAULT NULL,
  `describer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `good_id` (`good_id`),
  KEY `car_id` (`car_id`),
  CONSTRAINT `t_carlog_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

/*Data for the table `t_carlog` */

insert  into `t_carlog`(`id`,`good_id`,`car_id`,`startTime`,`endTime`,`describer`) values (18,'Ly1sHQZSToNF5ou',1,'2021-04-27','2021-04-29','给hhh发五件内裤'),(19,'7RfDHDwmymKQMB2',1,'2021-04-27','2021-04-29','给hhh发五个核桃'),(20,'3iwJWAGfgCDE6vZ',2,'2021-04-28','2021-04-29','监狱录取通知书'),(21,'gUrAwXyg1wBTNXp',1,'2021-04-28','2021-04-30','安全套十箱'),(22,'jQAUT6rFMORijUC',1,'2021-04-27','2021-04-30','花呗建议不用还'),(23,'StB0flFczl8RpPc',1,'2021-04-27','2021-04-28','小笨小笨'),(33,'d71sTViHbLiCK2v',1,'2021-04-28','2021-04-29','菜菜不菜'),(40,'GqKmxkFiX6o2ItM',2,'2021-04-28','','五十箱内裤'),(41,'VD1LHZFSPDX6U7C',1,'2021-04-28','2021-04-30','66666666666666666666'),(45,'CdjCceZNwNHCM01',1,'2021-04-29','','啊啊啊啊'),(48,'LKG011Q8zubMcoD',4,'2021-05-01','2021-05-02','发十吨煤炭'),(49,'dYUepjfsPkxnvAY',NULL,NULL,NULL,'无'),(50,'O77cG3VzAy88HP2',NULL,NULL,NULL,'十盒发蜡');

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_user` varchar(50) DEFAULT NULL,
  `customer_tel` varchar(50) DEFAULT NULL,
  `customer_address` varchar(80) DEFAULT NULL,
  `customer_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`customer_id`,`customer_user`,`customer_tel`,`customer_address`,`customer_password`) values (1,'police','110','广州','123456'),(10,'hj','13622664636','广州','123456'),(11,'root','123456','广州','root'),(24,'痞子辉','7758258','广州','123456'),(25,'大帅哥','7758258','广州','123456'),(26,'hj2','1','1','1');

/*Table structure for table `t_operationgoods` */

DROP TABLE IF EXISTS `t_operationgoods`;

CREATE TABLE `t_operationgoods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `car_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `goods_id` varchar(255) DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_tel` varchar(255) DEFAULT NULL,
  `goods_address` varchar(255) DEFAULT NULL,
  `goods_sure` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `goods_id` (`goods_id`),
  KEY `car_id` (`car_id`),
  KEY `customer_id` (`customer_id`),
  CONSTRAINT `t_operationgoods_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`),
  CONSTRAINT `t_operationgoods_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

/*Data for the table `t_operationgoods` */

insert  into `t_operationgoods`(`id`,`car_id`,`customer_id`,`goods_id`,`goods_name`,`goods_tel`,`goods_address`,`goods_sure`) values (20,1,1,'Ly1sHQZSToNF5ou','hhh','13538470496','北京',1),(21,1,1,'7RfDHDwmymKQMB2','hhh','13598462846','北京',0),(22,2,1,'3iwJWAGfgCDE6vZ','痞子辉','13517758258','上海',0),(23,1,10,'gUrAwXyg1wBTNXp','痞子辉','13517758258','北京',0),(24,1,10,'jQAUT6rFMORijUC','马云','555666777','北京',0),(25,1,1,'StB0flFczl8RpPc','小笨','1107758258','北京',0),(44,1,1,'d71sTViHbLiCK2v','菜菜','7758258','北京',0),(56,2,1,'GqKmxkFiX6o2ItM','帅哥健','13622664636','上海',0),(58,1,1,'VD1LHZFSPDX6U7C','hj','7758258','北京',1),(63,1,10,'CdjCceZNwNHCM01','痞子辉','1113','北京',0),(66,4,10,'LKG011Q8zubMcoD','老铁','7758258','新疆',0),(67,NULL,11,'dYUepjfsPkxnvAY','痞子辉','110','新疆',0),(68,NULL,11,'O77cG3VzAy88HP2','痞子辉','110','新疆',0);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
