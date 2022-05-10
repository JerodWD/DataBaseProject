-- --------------------------------------------------------
-- Host:                         137.104.254.238
-- Server version:               10.6.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for flight manager
CREATE DATABASE IF NOT EXISTS `flight manager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `flight manager`;

-- Dumping structure for table flight manager.airport
CREATE TABLE IF NOT EXISTS `airport` (
  `PORT_ID` int(11) NOT NULL,
  `PORT_NAME` varchar(50) NOT NULL,
  `PORT_CITY` varchar(50) NOT NULL,
  `PORT_COUNTRY` varchar(50) NOT NULL,
  `PORT_LAT` decimal(8,6) NOT NULL,
  `PORT_LONG` decimal(9,6) NOT NULL,
  `PORT_TIMEZONE` varchar(5) NOT NULL,
  PRIMARY KEY (`PORT_ID`),
  UNIQUE KEY `PORT_NAME` (`PORT_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.airport: ~0 rows (approximately)
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
/*!40000 ALTER TABLE `airport` ENABLE KEYS */;

-- Dumping structure for table flight manager.captain
CREATE TABLE IF NOT EXISTS `captain` (
  `CAP_ID` int(11) NOT NULL,
  `CAP_FNAME` varchar(25) NOT NULL,
  `CAP_LNAME` varchar(25) NOT NULL,
  `CAP_ADDRESS` varchar(50) NOT NULL,
  `CAP_STATE` varchar(50) NOT NULL,
  `CAP_CITY` varchar(50) NOT NULL,
  `CAP_ZIP` decimal(5,0) NOT NULL,
  `CAP_PHONENUM` varchar(12) NOT NULL,
  `CAP_AGE` decimal(3,0) NOT NULL,
  PRIMARY KEY (`CAP_ID`),
  UNIQUE KEY `CAP_PHONENUM` (`CAP_PHONENUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.captain: ~0 rows (approximately)
/*!40000 ALTER TABLE `captain` DISABLE KEYS */;
/*!40000 ALTER TABLE `captain` ENABLE KEYS */;

-- Dumping structure for table flight manager.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `CUST_ID` int(11) NOT NULL,
  `CUST_FNAME` varchar(25) NOT NULL,
  `CUST_LNAME` varchar(25) NOT NULL,
  `CUST_ADDRESS` varchar(50) NOT NULL,
  `CUST_CITY` varchar(50) NOT NULL,
  `CUST_STATE` varchar(15) NOT NULL,
  `CUST_ZIP` decimal(5,0) NOT NULL,
  `CUST_PHONENUM` varchar(12) DEFAULT NULL,
  `CUST_SEATNUM` varchar(25) NOT NULL,
  `CUST_AGE` decimal(3,0) DEFAULT NULL,
  `FLIGHT_NUM` int(11) NOT NULL,
  PRIMARY KEY (`CUST_ID`),
  UNIQUE KEY `CUST_SEATNUM` (`CUST_SEATNUM`),
  UNIQUE KEY `CUST_PHONENUM` (`CUST_PHONENUM`),
  KEY `FLIGHT_NUM` (`FLIGHT_NUM`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`FLIGHT_NUM`) REFERENCES `flight` (`FLIGHT_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table flight manager.flight
CREATE TABLE IF NOT EXISTS `flight` (
  `FLIGHT_NUM` int(11) NOT NULL,
  `FLIGHT_DATE` date NOT NULL,
  `ROUTE_ID` int(11) NOT NULL,
  PRIMARY KEY (`FLIGHT_NUM`),
  KEY `ROUTE_ID` (`ROUTE_ID`),
  CONSTRAINT `flight_ibfk_1` FOREIGN KEY (`ROUTE_ID`) REFERENCES `route` (`ROUTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.flight: ~0 rows (approximately)
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight` ENABLE KEYS */;

-- Dumping structure for table flight manager.flight_attendant
CREATE TABLE IF NOT EXISTS `flight_attendant` (
  `ATT_ID` int(11) NOT NULL,
  `ATT_FNAME` varchar(25) NOT NULL,
  `ATT_LNAME` varchar(25) NOT NULL,
  `ATT_ADDRESS` varchar(50) NOT NULL,
  `ATT_STATE` varchar(50) NOT NULL,
  `ATT_CITY` varchar(50) NOT NULL,
  `ATT_ZIP` decimal(5,0) NOT NULL,
  `ATT_PHONENUM` varchar(12) NOT NULL,
  `ATT_AGE` decimal(3,0) NOT NULL,
  PRIMARY KEY (`ATT_ID`),
  UNIQUE KEY `ATT_PHONENUM` (`ATT_PHONENUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.flight_attendant: ~0 rows (approximately)
/*!40000 ALTER TABLE `flight_attendant` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_attendant` ENABLE KEYS */;

-- Dumping structure for table flight manager.plane
CREATE TABLE IF NOT EXISTS `plane` (
  `PLANE_ID` int(11) NOT NULL,
  `CAP_ID` int(11) NOT NULL,
  `DEST` varchar(50) NOT NULL,
  `BUS_CLS_CAP` int(11) NOT NULL,
  `ECO_CLAS_CAP` int(11) NOT NULL,
  `FIRST_CLASS_CAP` int(11) NOT NULL,
  `PLANE_NAME` varchar(25) NOT NULL,
  `FLIGHT_NUM` int(11) NOT NULL,
  `ATT_ID` int(11) NOT NULL,
  PRIMARY KEY (`PLANE_ID`),
  KEY `CAP_ID` (`CAP_ID`),
  KEY `FLIGHT_NUM` (`FLIGHT_NUM`),
  KEY `ATT_ID` (`ATT_ID`),
  CONSTRAINT `plane_ibfk_1` FOREIGN KEY (`CAP_ID`) REFERENCES `captain` (`CAP_ID`),
  CONSTRAINT `plane_ibfk_2` FOREIGN KEY (`FLIGHT_NUM`) REFERENCES `flight` (`FLIGHT_NUM`),
  CONSTRAINT `plane_ibfk_3` FOREIGN KEY (`ATT_ID`) REFERENCES `flight_attendant` (`ATT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.plane: ~0 rows (approximately)
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;

-- Dumping structure for table flight manager.route
CREATE TABLE IF NOT EXISTS `route` (
  `ROUTE_ID` int(11) NOT NULL,
  `DEP_LOC` varchar(50) NOT NULL,
  `ARR_LOC` varchar(50) NOT NULL,
  `PORT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ROUTE_ID`),
  KEY `PORT_ID` (`PORT_ID`),
  CONSTRAINT `route_ibfk_1` FOREIGN KEY (`PORT_ID`) REFERENCES `airport` (`PORT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.route: ~0 rows (approximately)
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
/*!40000 ALTER TABLE `route` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
