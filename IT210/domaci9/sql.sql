-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.0.0.5919
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for garderoba
CREATE DATABASE IF NOT EXISTS `garderoba` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `garderoba`;

-- Dumping structure for table garderoba.modeli
CREATE TABLE IF NOT EXISTS `modeli` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(20) DEFAULT NULL,
  `cena` int(10) DEFAULT NULL,
  `kolicina` int(10) DEFAULT NULL,
  `sifra` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table garderoba.modeli: ~0 rows (approximately)
/*!40000 ALTER TABLE `modeli` DISABLE KEYS */;
/*!40000 ALTER TABLE `modeli` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
