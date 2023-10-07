/*
SQLyog Ultimate v8.55 
MySQL - 5.5.5-10.5.8-MariaDB : Database - petmsdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`petmsdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `petmsdb`;

/*Table structure for table `tbl_pet` */

DROP TABLE IF EXISTS `tbl_pet`;

CREATE TABLE `tbl_pet` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `pet_name` varchar(25) DEFAULT NULL,
  `category_id` int(3) DEFAULT NULL,
  `dob` varchar(20) DEFAULT NULL,
  `remark` varchar(250) DEFAULT NULL,
  `owner_id` int(5) DEFAULT NULL,
  `created_user` varchar(20) DEFAULT NULL,
  `created_datetime` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_user` varchar(20) DEFAULT NULL,
  `updated_datetime` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pet` */

/*Table structure for table `tbl_pet_category` */

DROP TABLE IF EXISTS `tbl_pet_category`;

CREATE TABLE `tbl_pet_category` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `category` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `tbl_pet_category` */

insert  into `tbl_pet_category`(`id`,`category`) values (1,'CAT');

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `role_code` varchar(20) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `pword` text DEFAULT NULL,
  `tp` int(10) DEFAULT NULL,
  `created_user` varchar(50) DEFAULT NULL,
  `created_datetime` timestamp NULL DEFAULT current_timestamp(),
  `updated_user` varchar(50) DEFAULT NULL,
  `updated_datetime` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `tbl_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
