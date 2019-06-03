/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE IF NOT EXISTS `txweb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `txweb`;

CREATE TABLE IF NOT EXISTS `t_emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ename` varchar(30) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `birthday` varchar(15) DEFAULT NULL,
  `edate` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_emp` DISABLE KEYS */;
INSERT INTO `t_emp` (`id`, `ename`, `age`, `sex`, `sal`, `birthday`, `edate`) VALUES
	(4, '熊大', 22, '男', 10000, '1980‐1‐1', '2018‐1‐1'),
	(5, '熊三', 12, '男', 10000, '1980‐1‐1', '2018‐1‐1'),
	(6, '光头强', 12, '男', 8000, '1980‐1‐1', '2018‐1‐1'),
	(9, '哈哈哈', 10, '男', 51110, '2015-4-4', '2019-4-9'),
	(22, '张思', 26, '女', 20000, '2019-03-05', '2019-03-30');
/*!40000 ALTER TABLE `t_emp` ENABLE KEYS */;

CREATE TABLE IF NOT EXISTS `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `nickname` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `username`, `password`, `nickname`) VALUES
	(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
