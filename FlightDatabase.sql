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

-- Dumping data for table flight manager.airport: ~10 rows (approximately)
/*!40000 ALTER TABLE `airport` DISABLE KEYS */;
INSERT INTO `airport` (`PORT_ID`, `PORT_NAME`, `PORT_CITY`, `PORT_COUNTRY`, `PORT_LAT`, `PORT_LONG`, `PORT_TIMEZONE`) VALUES
	(1001, 'Brook Airport', '', 'United States', 37.120200, 95.652900, 'EST'),
	(1002, 'Doral Resort and Country Club Flightpark', '', 'France', 46.227600, -2.213700, 'CEST'),
	(1003, 'Swaids Helicopters', '', 'United Kingdom', 55.378100, 3.435000, 'BST'),
	(1004, 'O\'Dwyer Airfield', '', 'France', 46.416600, 2.214500, 'CEST'),
	(1005, 'Harrison County Airstrip', '', 'United States', 37.090200, 95.712900, 'EST'),
	(1006, 'Insivarst Landing Field', '', 'Saudi Arabia', 23.885900, -45.079200, 'AST'),
	(1007, 'Croo District Airport', '', 'Canada', 56.130400, 106.346800, 'CT'),
	(1008, 'Muld Strip', '', 'Canada', 56.313400, 103.321200, 'EST'),
	(1009, 'Impres District Airport', '', 'Mexico', 23.634500, 102.528000, 'MST'),
	(1010, 'Levissonly International Airport', '', 'Norway', 60.472000, -8.468900, 'CEST');
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

-- Dumping data for table flight manager.captain: ~50 rows (approximately)
/*!40000 ALTER TABLE `captain` DISABLE KEYS */;
INSERT INTO `captain` (`CAP_ID`, `CAP_FNAME`, `CAP_LNAME`, `CAP_ADDRESS`, `CAP_STATE`, `CAP_CITY`, `CAP_ZIP`, `CAP_PHONENUM`, `CAP_AGE`) VALUES
	(1001, 'David', 'Smith', '777 Brockton Avenue', 'California', 'New York', 87335, '404-624-7806', 38),
	(1002, 'John', 'Johnson', '777 Brockton Avenue', 'Alabama', 'Los Angeles', 77168, '717-721-3540', 27),
	(1003, 'Paul', 'Williams', '30 Memorial Drive', 'Arkansas', 'Chicago', 63757, '922-506-2360', 34),
	(1004, 'Mark', 'Brown', '250 Hartford Avenue', 'Delaware', 'Miami', 14485, '685-575-1480', 31),
	(1005, 'James', 'Jones', '700 Oak Street', 'Florida', 'Dallas', 62037, '360-484-3824', 29),
	(1006, 'Andrew', 'Miller', '66-4 Parkhurst Rd', 'Alabama', 'Philadelphia', 56633, '439-794-9752', 29),
	(1007, 'Scott', 'Davis', '591 Memorial Dr', 'Alaska', 'Houston', 65338, '279-262-4764', 35),
	(1008, 'Steven', 'Garcia', '55 Brooksby Village Way', 'Indiana', 'Washington', 25151, '430-696-6112', 39),
	(1009, 'Robert', 'Rodriguez', '137 Teaticket Hwy', 'Illinois', 'Atlanta', 41381, '276-633-9951', 33),
	(1010, 'Stephen', 'Wilson', '42 Fairhaven Commons Way', 'Hawaii', 'Boston', 38305, '428-804-9628', 28),
	(1011, 'William', 'Martinez', '374 William S Canning Blvd', 'Georgia', 'Phoenix', 89128, '540-845-5484', 43),
	(1012, 'Craig', 'Anderson', '121 Worcester Rd', 'Colorado', 'Seattle', 29080, '971-682-1477', 36),
	(1013, 'Michael', 'Taylor', '677 Timpany Blvd', 'Florida', 'San Francisco', 71424, '873-665-6861', 38),
	(1014, 'Stuart', 'Thomas', '337 Russell St', 'Alaska', 'Detroit', 51233, '616-249-7957', 38),
	(1015, 'Christopher', 'Hernandez', '295 Plymouth Street', 'Maine', 'San Diego', 34133, '917-990-1018', 29),
	(1016, 'Alan', 'Moore', '1775 Washington St', 'Nevada', 'Minneapolis', 53311, '683-311-6772', 37),
	(1017, 'Colin', 'Martin', '280 Washington Street', 'Nebraska', 'Tampa', 75425, '472-760-4567', 30),
	(1018, 'Brian', 'Jackson', '20 Soojian Dr', 'Idaho', 'Denver', 56226, '488-341-1299', 43),
	(1019, 'Kevin', 'Thompson', '11 Jungle Road', 'Georgia', 'Brooklyn', 71426, '425-970-6857', 36),
	(1020, 'Gary', 'White', '301 Massachusetts Ave', 'North Carolina', 'Queens', 78495, '760-527-8469', 43),
	(1021, 'Richard', 'Lopez', '780 Lynnway', 'New York', 'Baltimore', 66002, '739-468-7304', 35),
	(1022, 'Derek', 'Lee', '70 Pleasant Valley Street', 'Ohio', 'Riverside', 94087, '824-570-2893', 42),
	(1023, 'Martin', 'Gonzalez', '830 Curran Memorial Hwy', 'Oregon', 'Saint Louis', 17899, '665-259-3089', 31),
	(1024, 'Thomas', 'Harris', '1470 S Washington St', 'Ohio', 'Las Vegas', 90116, '780-284-6708', 40),
	(1025, 'Neil', 'Clark', '506 State Road', 'Kansas', 'Portland', 78316, '941-781-2530', 42),
	(1026, 'Barry', 'Lewis', '742 Main Street', 'Illinois', 'San Antonio', 78167, '312-513-2929', 39),
	(1027, 'Ian', 'Robinson', '72 Main St', 'Hawaii', 'Sacramento', 80860, '384-849-8034', 43),
	(1028, 'Jason', 'Walker', '200 Otis Street', 'Maryland', 'San Jose', 68130, '801-911-2785', 31),
	(1029, 'Iain', 'Perez', '180 North King Street', 'Massachusetts', 'Orlando', 43361, '527-676-5310', 43),
	(1030, 'Gordon', 'Hall', '555 East Main St', 'Michigan', 'Cleveland', 53809, '217-493-8675', 42),
	(1031, 'Alexander', 'Young', '555 Hubbard Ave-Suite 12', 'Indiana', 'Pittsburgh', 71305, '457-908-2134', 31),
	(1032, 'Graeme', 'Allen', '300 Colony Place', 'Alaska', 'Cincinnati', 64665, '317-429-6762', 42),
	(1033, 'Peter', 'Sanchez', '301 Falls Blvd', 'Missouri', 'Manhattan', 42779, '219-318-6538', 29),
	(1034, 'Darren', 'Wright', '36 Paramount Drive', 'Pennsylvania', 'Austin', 98475, '708-631-3864', 28),
	(1035, 'Graham', 'King', '450 Highland Ave', 'Rhode Island', 'Kansas City', 20882, '926-401-3027', 37),
	(1036, 'George', 'Scott', '1180 Fall River Avenue', 'South Carolina', 'Indianapolis', 88394, '534-559-2495', 43),
	(1037, 'Kenneth', 'Green', '1105 Boston Road', 'Wisconsin', 'Columbus', 76733, '845-515-6775', 26),
	(1038, 'Allan', 'Baker', '100 Charlton Road', 'Wisconsin', 'Virginia Beach', 44102, '551-252-7267', 32),
	(1039, 'Simon', 'Adams', '262 Swansea Mall Dr', 'Wyoming', 'Charlotte', 83367, '236-465-4003', 38),
	(1040, 'Douglas', 'Nelson', '333 Main Street', 'Washington', 'Bronx', 72197, '359-270-2370', 41),
	(1041, 'Keith', 'Hill', '550 Providence Hwy', 'Texas', 'Milwaukee', 95302, '364-983-6958', 40),
	(1042, 'Lee', 'Ramirez', '352 Palmer Road', 'Utah', 'Providence', 54285, '365-901-3732', 38),
	(1043, 'Anthony', 'Campbell', '3005 Cranberry Hwy Rt 6 28', 'Missouri', 'Jacksonville', 68329, '559-467-2632', 40),
	(1044, 'Grant', 'Mitchell', '250 Rt 59', 'Minnesota', 'Salt Lake City', 41288, '384-253-6081', 39),
	(1045, 'Ross', 'Roberts', '141 Washington Ave Extension', 'Michigan', 'Nashville', 23579, '540-550-5743', 37),
	(1046, 'Jonathan', 'Carter', '13858 Rt 31 W', 'Alaska', 'Memphis', 66572, '910-489-5968', 33),
	(1047, 'Gavin', 'Phillips', '2055 Niagara Falls Blvd', 'North Dakota', 'Richmond', 36242, '446-400-4809', 40),
	(1048, 'Nicholas', 'Evans', '101 Sanford Farm Shpg Center', 'Delaware', 'New Orleans', 55391, '700-808-2183', 33),
	(1049, 'Joseph', 'Turner', '297 Grant Avenue', 'Florida', 'Raleigh', 86842, '941-336-6942', 31),
	(1050, 'Stewart', 'Torres', '4133 Veterans Memorial Drive', 'West Virginia', 'Louisville', 85578, '946-719-4223', 43);
/*!40000 ALTER TABLE `captain` ENABLE KEYS */;

-- Dumping structure for table flight manager.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `CUST_ID` int(11) NOT NULL,
  `CUST_FNAME` varchar(25) NOT NULL,
  `CUST_LNAME` varchar(25) NOT NULL,
  `CUST_ADDRESS` varchar(50) NOT NULL,
  `CUST_CITY` varchar(50) NOT NULL,
  `CUST_STATE` varchar(20) NOT NULL,
  `CUST_ZIP` decimal(5,0) NOT NULL,
  `CUST_PHONENUM` varchar(12) DEFAULT NULL,
  `CUST_SEATNUM` varchar(25) NOT NULL,
  `CUST_AGE` decimal(3,0) DEFAULT NULL,
  `FLIGHT_NUM` int(11) NOT NULL,
  PRIMARY KEY (`CUST_ID`),
  UNIQUE KEY `CUST_PHONENUM` (`CUST_PHONENUM`),
  KEY `FLIGHT_NUM` (`FLIGHT_NUM`),
  CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`FLIGHT_NUM`) REFERENCES `flight` (`FLIGHT_NUM`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table flight manager.customer: ~150 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` (`CUST_ID`, `CUST_FNAME`, `CUST_LNAME`, `CUST_ADDRESS`, `CUST_CITY`, `CUST_STATE`, `CUST_ZIP`, `CUST_PHONENUM`, `CUST_SEATNUM`, `CUST_AGE`, `FLIGHT_NUM`) VALUES
	(1001, 'ETNA', 'ZENN', '835 Comanche Way', 'Portland', 'Maine', 4109, '207-748-8620', '1', 24, 1005),
	(1002, 'ISAIAH', 'ZUPAN', '441 3rd Drive', 'Fresno', 'California', 93773, '559-973-5371', '1', 22, 1001),
	(1003, 'PAULO', 'MUSTEDANAGIC', '93 Bayside Park', 'Mobile', 'Alabama', 36628, '251-539-0106', '1', 47, 1004),
	(1004, 'ADELA', 'LOEHRER', '2304 Glendale Plaza', 'Houston', 'Texas', 77020, '281-683-1330', '2', 40, 1004),
	(1005, 'AZZIE', 'BAJOR', '370 Washington Park', 'Palo Alto', 'California', 94302, '310-335-5647', '2', 61, 1001),
	(1006, 'AGNES', 'LECHELT', '0950 Buena Vista Road', 'Omaha', 'Nebraska', 68124, '402-878-4046', '1', 56, 1002),
	(1007, 'SHANA', 'DODERO', '39 Karstens Alley', 'Seattle', 'Washington', 98158, '425-288-2796', '3', 55, 1004),
	(1008, 'KAMILA', 'MINARICK', '259 Spaight Court', 'Chicago', 'Illinois', 60663, '312-702-7780', '2', 52, 1005),
	(1009, 'DEVAUGHN', 'DRELL', '21 Eagan Lane', 'Washington', 'District of Columbia', 20540, '202-860-5201', '2', 23, 1002),
	(1010, 'WILBUR', 'ECONOMOU', '8 Dwight Plaza', 'Redwood City', 'California', 94064, '650-546-9377', '3', 18, 1002),
	(1011, 'SIGURD', 'BODOH', '931 Daystar Terrace', 'Jacksonville', 'Florida', 32277, '904-711-7844', '4', 33, 1004),
	(1012, 'KALYN', 'AFFOLDER', '426 Killdeer Court', 'El Paso', 'Texas', 88574, '915-279-7311', '3', 56, 1001),
	(1013, 'NINNIE', 'TAUSCHEK', '69 Mayer Junction', 'Omaha', 'Nebraska', 68105, '402-341-1957', '5', 35, 1004),
	(1014, 'LEILA', 'SIDORSKI', '1 Atwood Junction', 'Oklahoma City', 'Oklahoma', 73190, '405-207-4732', '6', 20, 1004),
	(1015, 'WESLEY', 'ELSAYED', '1 Manley Parkway', 'Beaufort', 'South Carolina', 29905, '843-647-3700', '4', 21, 1001),
	(1016, 'ENRIQUETA', 'SCHOENY', '67 Prairie Rose Drive', 'Migrate', 'Kentucky', 41905, '502-677-9900', '3', 63, 1005),
	(1017, 'STAN', 'DARNABY', '7 Lyons Lane', 'Las Vegas', 'Nevada', 89150, '702-987-5476', '7', 28, 1004),
	(1018, 'CLAIBORNE', 'TAULTON', '33 Hudson Plaza', 'Houston', 'Texas', 77218, '713-122-4927', '8', 30, 1004),
	(1019, 'ALONSO', 'CUTWAY', '9473 Schiller Drive', 'Chicago', 'Illinois', 60663, '312-819-7272', '4', 64, 1002),
	(1020, 'CONSTANTINE', 'TELLERIA', '37 Banding Center', 'Port Charlotte', 'Florida', 33954, '941-485-9899', '5', 57, 1002),
	(1021, 'KYA', 'COUICK', '66 Myrtle Drive', 'Young America', 'Minnesota', 55573, '952-977-2188', '9', 18, 1004),
	(1022, 'LEORA', 'RENDULIC', '8855 Sachs Avenue', 'Inglewood', 'California', 90305, '310-143-7063', '10', 58, 1004),
	(1023, 'DELBERT', 'BETSCHER', '26053 Blackbird Point', 'Houston', 'Texas', 77025, '281-813-3418', '11', 57, 1004),
	(1024, 'MATHEWS', 'ENLUND', '0474 Westend Plaza', 'Houston', 'Texas', 77075, '832-391-3976', '12', 56, 1004),
	(1025, 'GANNON', 'BUSHWAY', '4 1st Avenue', 'Charlottesville', 'Virginia', 22903, '434-748-1768', '4', 36, 1005),
	(1026, 'PLUMA', 'AGOPIAN', '14685 Holy Cross Pass', 'Atlanta', 'Georgia', 31190, '404-102-2327', '6', 59, 1002),
	(1027, 'ODA', 'WALLAN', '5 Anhalt Avenue', 'Springfield', 'Missouri', 65805, '417-192-1288', '13', 28, 1004),
	(1028, 'SETH', 'HARGEST', '9596 Mesta Point', 'Biloxi', 'Mississippi', 39534, '228-684-2082', '7', 45, 1002),
	(1029, 'OCTA', 'DONATI', '378 Bunker Hill Trail', 'Boston', 'Massachusetts', 2109, '617-653-3434', '8', 63, 1002),
	(1030, 'MONSERRAT', 'HEMMES', '2 Bunting Avenue', 'Charleston', 'West Virginia', 25336, '304-604-7309', '5', 63, 1005),
	(1031, 'VIRA', 'ARRELLANO', '71435 Vahlen Alley', 'Billings', 'Montana', 59105, '406-334-6794', '6', 18, 1005),
	(1032, 'DENVER', 'MAILLE', '6 Laurel Pass', 'Raleigh', 'North Carolina', 27658, '919-429-2131', '9', 53, 1002),
	(1033, 'SIDDIE', 'SHILOW', '0252 Nevada Trail', 'Evansville', 'Indiana', 47732, '812-420-4829', '14', 39, 1004),
	(1034, 'RAGNA', 'BURIC', '77 David Junction', 'West Palm Beach', 'Florida', 33416, '561-401-4435', '15', 37, 1004),
	(1035, 'CLEVELAND', 'MAICHLE', '661 Reindahl Lane', 'Atlanta', 'Georgia', 30392, '404-315-9548', '5', 40, 1001),
	(1036, 'ORVAL', 'LANGREN', '74021 Kingsford Center', 'Columbus', 'Ohio', 43231, '614-304-9885', '16', 43, 1004),
	(1037, 'ZETTA', 'NEWNHAM', '3546 Michigan Pass', 'Memphis', 'Tennessee', 38114, '901-907-0003', '10', 23, 1002),
	(1038, 'LELLA', 'KOLCZYNSKI', '58 Hanson Terrace', 'Shreveport', 'Louisiana', 71130, '318-927-9672', '7', 57, 1005),
	(1039, 'PHILIP', 'FAMBROUGH', '96836 Crowley Road', 'Ventura', 'California', 93005, '805-914-4494', '17', 57, 1004),
	(1040, 'CHARLES', 'DOWNTON', '60487 Sugar Pass', 'Fairbanks', 'Alaska', 99709, '907-413-5656', '11', 48, 1002),
	(1041, 'PRICILLA', 'LEVITIN', '70878 Marquette Center', 'Houston', 'Texas', 77223, '713-806-7309', '18', 50, 1004),
	(1042, 'BENSON', 'TEIXEIRA', '906 Haas Way', 'Pueblo', 'Colorado', 81010, '719-434-5769', '19', 63, 1004),
	(1043, 'MCKENNA', 'RUSSEY', '7 Atwood Road', 'Palatine', 'Illinois', 60078, '847-912-5208', '20', 27, 1004),
	(1044, 'BURNETT', 'THIO', '36065 Comanche Avenue', 'Madison', 'Wisconsin', 53705, '608-524-0149', '21', 54, 1004),
	(1045, 'INGER', 'NEWNUM', '21691 Spohn Point', 'Chicago', 'Illinois', 60641, '312-740-2342', '12', 23, 1002),
	(1046, 'KRISTOFER', 'TRAMPOSCH', '20711 Marquette Way', 'Minneapolis', 'Minnesota', 55487, '612-455-7290', '22', 18, 1004),
	(1047, 'MARIANITA', 'HINTE', '457 Dryden Road', 'Conroe', 'Texas', 77305, '936-983-6771', '13', 38, 1002),
	(1048, 'COLLIS', 'REMACHE', '67 Lillian Lane', 'Charlotte', 'North Carolina', 28247, '704-647-3600', '8', 27, 1005),
	(1049, 'SAMUAL', 'BADORE', '6 Sutteridge Plaza', 'Birmingham', 'Alabama', 35263, '205-396-4054', '6', 47, 1001),
	(1050, 'ISMAEL', 'HOLKE', '18 Stone Corner Street', 'Dallas', 'Texas', 75392, '214-828-3143', '23', 29, 1004),
	(1051, 'RENARD', 'ELISH', '9 Corscot Junction', 'Reading', 'Pennsylvania', 19605, '610-204-2423', '14', 61, 1002),
	(1052, 'MADDEN', 'BROMS', '0215 Lakeland Circle', 'Dallas', 'Texas', 75310, '214-530-7168', '7', 48, 1001),
	(1053, 'LIZ', 'CHILA', '7 Glacier Hill Junction', 'Atlanta', 'Georgia', 31106, '404-175-8998', '8', 51, 1001),
	(1054, 'ORAN', 'ALMODOVAR', '9299 Tomscot Hill', 'Kansas City', 'Missouri', 64130, '816-861-6025', '15', 38, 1002),
	(1055, 'MILAS', 'CERULO', '92 Kensington Point', 'Topeka', 'Kansas', 66617, '785-672-9638', '9', 57, 1005),
	(1056, 'EDYTH', 'ZIGMUND', '875 Mallard Court', 'Houston', 'Texas', 77206, '713-613-6818', '24', 56, 1004),
	(1057, 'DUKE', 'FROHOCK', '98017 Victoria Drive', 'Colorado Springs', 'Colorado', 80920, '719-861-7747', '25', 65, 1004),
	(1058, 'ARIA', 'GOSSAGE', '06464 Cascade Plaza', 'Austin', 'Texas', 78732, '512-913-2598', '16', 39, 1002),
	(1059, 'TRENT', 'DIREGAN', '21919 Lakewood Gardens Court', 'Clearwater', 'Florida', 33758, '813-938-2917', '26', 46, 1004),
	(1060, 'CASSANDRA', 'LANYI', '74 Haas Lane', 'Washington', 'District of Columbia', 20508, '202-917-5813', '9', 25, 1001),
	(1061, 'SHELBIE', 'BLAZQUEZ', '6247 Bobwhite Junction', 'Saint Joseph', 'Missouri', 64504, '816-733-7365', '17', 41, 1002),
	(1062, 'EARLE', 'BURRIESCI', '27 Donald Lane', 'Austin', 'Texas', 78744, '512-825-8787', '18', 63, 1002),
	(1063, 'DEENA', 'MOHME', '5 Anderson Center', 'Saint Louis', 'Missouri', 63167, '314-385-9664', '27', 63, 1004),
	(1064, 'CHERELLE', 'MAZAS', '35 Meadow Valley Place', 'El Paso', 'Texas', 79999, '915-472-3028', '28', 54, 1004),
	(1065, 'COLONEL', 'HALLOM', '3400 Lakewood Gardens Pass', 'Durham', 'North Carolina', 27710, '919-544-0153', '19', 63, 1002),
	(1066, 'IVETTE', 'DYREK', '863 Anthes Lane', 'Fresno', 'California', 93721, '559-842-3809', '10', 40, 1005),
	(1067, 'CARMELO', 'REHN', '2017 Golf Course Road', 'Fresno', 'California', 93704, '559-278-6876', '10', 36, 1001),
	(1068, 'JALISSA', 'CLAUSELL', '23527 Maple Court', 'Chesapeake', 'Virginia', 23324, '757-380-4831', '11', 35, 1001),
	(1069, 'INGRID', 'LIMANNI', '297 Toban Hill', 'Oklahoma City', 'Oklahoma', 73179, '405-216-1191', '11', 35, 1005),
	(1070, 'MAGNOLIA', 'HAISMA', '9 Mariners Cove Center', 'Chattanooga', 'Tennessee', 37416, '423-656-7611', '20', 24, 1002),
	(1071, 'JACQUELINE', 'BOUY', '95175 Talmadge Drive', 'Springfield', 'Virginia', 22156, '571-924-5323', '12', 41, 1005),
	(1072, 'MARYELLEN', 'JANKORD', '82 Melvin Drive', 'Philadelphia', 'Pennsylvania', 19184, '215-980-0492', '12', 57, 1001),
	(1073, 'NEELY', 'BRUNSTAD', '88376 Vera Street', 'Birmingham', 'Alabama', 35242, '205-791-6413', '13', 58, 1001),
	(1074, 'RYLAND', 'SABLATURA', '308 Jana Plaza', 'Galveston', 'Texas', 77554, '409-498-7810', '21', 36, 1002),
	(1075, 'TEVIN', 'ENTWISLE', '066 Vidon Road', 'Washington', 'District of Columbia', 20503, '202-333-9815', '13', 51, 1005),
	(1076, 'RONA', 'BUTENKO', '681 Ridgeway Road', 'Washington', 'District of Columbia', 56944, '202-649-8057', '14', 41, 1005),
	(1077, 'REGINAL', 'ADI', '81409 Dryden Street', 'Berkeley', 'California', 94705, '510-948-7578', '15', 23, 1005),
	(1078, 'MILDA', 'GASPARIAN', '882 Warner Point', 'Santa Fe', 'New Mexico', 87592, '505-485-1508', '16', 34, 1005),
	(1079, 'ROXANA', 'DOUGET', '6455 American Place', 'Annapolis', 'Maryland', 21405, '410-348-8437', '22', 38, 1002),
	(1080, 'BEBE', 'SLIMMER', '2 Pepper Wood Way', 'Iowa City', 'Iowa', 52245, '319-696-5252', '14', 59, 1001),
	(1081, 'ALEC', 'ZANABRIA', '8 Eastlawn Terrace', 'Anderson', 'Indiana', 46015, '765-288-2115', '23', 45, 1002),
	(1082, 'DRUSILLA', 'KETHLEY', '96148 Granby Plaza', 'Honolulu', 'Hawaii', 96845, '808-416-3040', '24', 48, 1002),
	(1083, 'TORIE', 'MANTELL', '374 Forest Road', 'Saint Louis', 'Missouri', 63121, '314-922-5972', '17', 40, 1005),
	(1084, 'PATSY', 'CIUCCI', '067 Longview Center', 'Edmond', 'Oklahoma', 73034, '405-857-7526', '18', 61, 1005),
	(1085, 'LORETTO', 'HLAD', '33799 Kipling Alley', 'Monroe', 'Louisiana', 71208, '318-704-6619', '15', 29, 1001),
	(1086, 'RICHMOND', 'LOGSDON', '8 Hermina Circle', 'Houston', 'Texas', 77212, '713-607-0285', '25', 42, 1002),
	(1087, 'MERVIN', 'CHOROMANSKI', '3 Crescent Oaks Hill', 'Denver', 'Colorado', 80217, '303-233-3975', '29', 34, 1004),
	(1088, 'ZELMA', 'GARBISON', '870 Gale Circle', 'Roanoke', 'Virginia', 24040, '540-435-4722', '16', 62, 1001),
	(1089, 'DESTINEY', 'DELCOURE', '56063 Lukken Pass', 'Huntington Beach', 'California', 92648, '949-201-4976', '17', 51, 1001),
	(1090, 'MEKHI', 'KUBASTA', '880 Thierer Place', 'South Bend', 'Indiana', 46614, '574-523-4175', '26', 18, 1002),
	(1091, 'CONSUELA', 'SCHUMANN', '6 Hazelcrest Point', 'Montgomery', 'Alabama', 36119, '334-611-8257', '19', 60, 1005),
	(1092, 'EDITH', 'GERMAN', '591 Eastlawn Center', 'Boston', 'Massachusetts', 2114, '857-767-1018', '20', 39, 1005),
	(1093, 'ALBERTINA', 'DUMPHY', '8 Cardinal Court', 'Shawnee Mission', 'Kansas', 66205, '816-475-3209', '27', 43, 1002),
	(1094, 'JAVEN', 'KLIEN', '40938 Clove Center', 'Madison', 'Wisconsin', 53785, '608-529-5978', '21', 39, 1005),
	(1095, 'SAIGE', 'DONDE', '84754 Mallard Point', 'Shawnee Mission', 'Kansas', 66205, '816-819-9141', '30', 62, 1004),
	(1096, 'LIDIA', 'RICK', '51 Alpine Place', 'Modesto', 'California', 95397, '209-389-6392', '22', 39, 1005),
	(1097, 'BELINDA', 'SCHIEBEL', '48107 Crest Line Parkway', 'Louisville', 'Kentucky', 40225, '502-350-8412', '23', 24, 1005),
	(1098, 'FABIAN', 'FONG', '03 Glacier Hill Trail', 'Houston', 'Texas', 77055, '832-605-7981', '31', 62, 1004),
	(1099, 'BRANNON', 'HAVRILLA', '3 Esker Drive', 'Hialeah', 'Florida', 33018, '305-352-0430', '24', 56, 1005),
	(1100, 'DARIA', 'FRONDORF', '63 Kipling Junction', 'Fort Lauderdale', 'Florida', 33330, '954-116-6626', '25', 21, 1005),
	(1101, 'MASAO', 'MASLIN', '57904 Little Fleur Court', 'El Paso', 'Texas', 79905, '915-411-5134', '26', 53, 1005),
	(1102, 'METHA', 'DUCEY', '4176 Killdeer Court', 'Dallas', 'Texas', 75387, '214-972-3763', '32', 26, 1004),
	(1103, 'REBA', 'BISBIKIS', '27 Westend Place', 'Detroit', 'Michigan', 48206, '734-721-9450', '18', 60, 1001),
	(1104, 'VENNIE', 'HELMCAMP', '2185 Anniversary Circle', 'Bloomington', 'Illinois', 61709, '309-639-9629', '27', 42, 1005),
	(1105, 'PAYTON', 'DRAGG', '635 Division Court', 'Chicago', 'Illinois', 60697, '312-618-0048', '19', 22, 1001),
	(1106, 'ANTWAIN', 'ENGLADE', '8008 Atwood Road', 'Indianapolis', 'Indiana', 46266, '317-549-4398', '20', 43, 1001),
	(1107, 'KARLI', 'BUNES', '7445 Anderson Alley', 'Charlotte', 'North Carolina', 28220, '704-287-9855', '33', 39, 1004),
	(1108, 'VANCE', 'ORDUNEZ', '6 Carioca Lane', 'Minneapolis', 'Minnesota', 55446, '952-102-9011', '28', 59, 1002),
	(1109, 'JAYE', 'BULLEIT', '539 Twin Pines Drive', 'Cleveland', 'Ohio', 44125, '216-164-5657', '34', 52, 1004),
	(1110, 'DOUGLASS', 'MOZELLE', '5 Oakridge Center', 'Waltham', 'Massachusetts', 2453, '781-707-1022', '28', 57, 1005),
	(1111, 'JOURNEY', 'RUSSEL', '448 Rowland Point', 'Laredo', 'Texas', 78044, '956-429-6579', '35', 38, 1004),
	(1112, 'GALILEA', 'ROETZER', '0 Rieder Center', 'Columbus', 'Ohio', 43204, '614-341-6415', '29', 45, 1005),
	(1113, 'KRISH', 'BRICENO', '87112 Bayside Avenue', 'Chicago', 'Illinois', 60686, '312-139-9039', '30', 48, 1005),
	(1114, 'TISHIE', 'FOTOS', '70993 Hagan Crossing', 'Boise', 'Idaho', 83705, '208-668-6427', '29', 32, 1002),
	(1115, 'OTHA', 'STEINBRUEGGE', '9 Loftsgordon Drive', 'Charlottesville', 'Virginia', 22908, '434-191-0760', '21', 62, 1001),
	(1116, 'STEFAN', 'SARRASIN', '45 Northland Plaza', 'Cincinnati', 'Ohio', 45999, '513-414-3679', '36', 54, 1004),
	(1117, 'LINTON', 'WESTMARK', '3379 Oxford Park', 'Des Moines', 'Iowa', 50305, '515-457-6591', '22', 44, 1001),
	(1118, 'SELMA', 'LOCCISANO', '6997 Mariners Cove Terrace', 'Oakland', 'California', 94616, '510-576-5854', '23', 19, 1001),
	(1119, 'ARA', 'COLEMAN', '9 Blackbird Trail', 'Minneapolis', 'Minnesota', 55402, '763-779-7957', '30', 47, 1002),
	(1120, 'HANA', 'TOPF', '78588 Derek Road', 'Chula Vista', 'California', 91913, '619-696-5752', '24', 24, 1001),
	(1121, 'DEMETRIA', 'MOJENA', '117 Heffernan Street', 'Buffalo', 'New York', 14205, '716-314-6322', '31', 50, 1005),
	(1122, 'ELNORA', 'GRIVNA', '35870 Scofield Point', 'Tucson', 'Arizona', 85710, '520-668-6947', '37', 62, 1004),
	(1123, 'ANITA', 'RYBKA', '706 Kensington Center', 'Bryan', 'Texas', 77806, '979-198-0439', '25', 58, 1001),
	(1124, 'NYAH', 'GOMBASH', '4 Forest Run Park', 'Houston', 'Texas', 77234, '713-163-5211', '31', 47, 1002),
	(1125, 'GLENNIE', 'BALMOS', '707 Meadow Vale Street', 'Atlanta', 'Georgia', 31132, '404-776-5749', '26', 36, 1001),
	(1126, 'WALDEMAR', 'ORLOV', '626 Burning Wood Way', 'Provo', 'Utah', 84605, '801-647-3365', '32', 50, 1005),
	(1127, 'BASCOM', 'LAROUX', '9 Service Street', 'Houston', 'Texas', 77010, '713-509-8786', '33', 22, 1005),
	(1128, 'LILLARD', 'DELBALSO', '12023 Rigney Pass', 'Aurora', 'Colorado', 80015, '720-414-8552', '34', 33, 1005),
	(1129, 'ANTIONETTE', 'BRIGHTBILL', '39 Gulseth Park', 'Toledo', 'Ohio', 43615, '419-205-8382', '35', 54, 1005),
	(1130, 'MARY', 'OSKO', '4 Northridge Alley', 'Fresno', 'California', 93778, '559-132-4434', '38', 22, 1004),
	(1131, 'DESTANY', 'SCHABER', '56856 Acker Trail', 'Fort Myers', 'Florida', 33994, '239-745-6960', '27', 45, 1001),
	(1132, 'CHRIST', 'VANROY', '901 Sugar Circle', 'Fort Wayne', 'Indiana', 46825, '260-363-8891', '39', 51, 1004),
	(1133, 'CASIE', 'MCMANNIS', '8453 Graceland Alley', 'Hayward', 'California', 94544, '415-773-2253', '28', 59, 1001),
	(1134, 'SPRING', 'SCHNACKEL', '39692 Lawn Parkway', 'Tampa', 'Florida', 33694, '813-537-3943', '32', 26, 1002),
	(1135, 'DERECK', 'PALILLA', '9 Springs Avenue', 'Boise', 'Idaho', 83727, '208-686-6336', '36', 52, 1005),
	(1136, 'HEZEKIAH', 'BOCEK', '62 Union Trail', 'Lake Charles', 'Louisiana', 70616, '337-416-7842', '29', 42, 1001),
	(1137, 'JAYLEEN', 'WESTENBURG', '62 Melby Road', 'Migrate', 'Kentucky', 41905, '502-265-9158', '30', 44, 1001),
	(1138, 'MIRACLE', 'REICHE', '0059 Cherokee Circle', 'Evansville', 'Indiana', 47725, '812-952-4033', '33', 60, 1002),
	(1139, 'DERYL', 'GRANNUM', '3819 Jenifer Court', 'Orlando', 'Florida', 32825, '954-756-4622', '34', 36, 1002),
	(1140, 'KALLIE', 'ELEJALDE', '341 Ridgeview Avenue', 'Albuquerque', 'New Mexico', 87121, '505-474-8564', '35', 19, 1002),
	(1141, 'BLANCHE', 'FOLCH', '21 Forest Avenue', 'Washington', 'District of Columbia', 56944, '202-913-7298', '40', 55, 1004),
	(1142, 'LEATHA', 'LAFOE', '6 Elka Lane', 'Shawnee Mission', 'Kansas', 66286, '913-653-9553', '36', 42, 1002),
	(1143, 'MAMIE', 'EWIG', '78 Fieldstone Junction', 'Syracuse', 'New York', 13217, '315-924-8573', '41', 57, 1004),
	(1144, 'MILDRED', 'ZEPHIR', '37283 Brown Place', 'Milwaukee', 'Wisconsin', 53220, '414-315-4751', '31', 27, 1001),
	(1145, 'ALMON', 'NODAL', '4609 Burrows Hill', 'Stamford', 'Connecticut', 6905, '203-712-6009', '37', 64, 1005),
	(1146, 'BLUFORD', 'SYKES', '63657 Bobwhite Junction', 'Erie', 'Pennsylvania', 16505, '814-275-8352', '38', 50, 1005),
	(1147, 'ROEL', 'SERDA', '66 Green Ridge Circle', 'Tacoma', 'Washington', 98405, '253-817-5708', '32', 65, 1001),
	(1148, 'WES', 'GRABENHORST', '37902 Petterle Center', 'Toledo', 'Ohio', 43635, '419-763-9473', '33', 36, 1001),
	(1149, 'KENISHA', 'COHAGAN', '825 Londonderry Junction', 'Palo Alto', 'California', 94302, '650-253-9326', '42', 20, 1004),
	(1150, 'BALDWIN', 'RADJENOVICH', '1981 Commercial Park', 'Seattle', 'Washington', 98121, '206-971-5961', '37', 54, 1002);
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

-- Dumping data for table flight manager.flight: ~5 rows (approximately)
/*!40000 ALTER TABLE `flight` DISABLE KEYS */;
INSERT INTO `flight` (`FLIGHT_NUM`, `FLIGHT_DATE`, `ROUTE_ID`) VALUES
	(1001, '2022-01-04', 1001),
	(1002, '2022-01-05', 1001),
	(1003, '2022-01-04', 1002),
	(1004, '2022-01-02', 1008),
	(1005, '2022-01-06', 1010);
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

-- Dumping data for table flight manager.flight_attendant: ~25 rows (approximately)
/*!40000 ALTER TABLE `flight_attendant` DISABLE KEYS */;
INSERT INTO `flight_attendant` (`ATT_ID`, `ATT_FNAME`, `ATT_LNAME`, `ATT_ADDRESS`, `ATT_STATE`, `ATT_CITY`, `ATT_ZIP`, `ATT_PHONENUM`, `ATT_AGE`) VALUES
	(1001, 'Guy', 'Freeman', '900 Boston Post Road', 'Wyoming', 'Detroit', 95105, '682-621-6668', 26),
	(1002, 'Laurence', 'Burns', '2300 Dixwell Ave', 'California', 'San Diego', 75917, '930-484-2779', 26),
	(1003, 'Lawrence', 'Henry', '495 Flatbush Ave', 'Georgia', 'Minneapolis', 35721, '204-898-1470', 28),
	(1004, 'Magnus', 'Vasquez', '180 River Rd', 'Alaska', 'Tampa', 79099, '839-575-5299', 33),
	(1005, 'Crawford', 'Snyder', '420 Buckland Hills Dr', 'Nebraska', 'Denver', 91018, '246-978-9450', 20),
	(1006, 'Finlay', 'Simpson', '1365 Boston Post Road', 'Kansas', 'Brooklyn', 56164, '600-235-4476', 27),
	(1007, 'Frederick', 'Crawford', '1100 New Haven Road', 'Arizona', 'Queens', 13134, '557-670-2870', 23),
	(1008, 'Gregg', 'Jimenez', '315 Foxon Blvd', 'Minnesota', 'Baltimore', 23091, '640-298-8459', 22),
	(1009, 'Karl', 'Porter', '164 Danbury Rd', 'Iowa', 'Riverside', 50161, '741-788-4128', 26),
	(1010, 'Kerr', 'Mason', '3164 Berlin Turnpike', 'Iowa', 'Saint Louis', 90441, '350-225-5094', 31),
	(1011, 'Mohammed', 'Shaw', '474 Boston Post Road', 'Utah', 'Las Vegas', 52677, '565-315-1618', 28),
	(1012, 'Rodney', 'Gordon', '650 Main Ave', 'Illinois', 'Portland', 99893, '346-947-3871', 31),
	(1013, 'Victor', 'Wagner', '680 Connecticut Avenue', 'Idaho', 'San Antonio', 20327, '363-207-8505', 25),
	(1014, 'Carl', 'Hunter', '220 Salem Turnpike', 'Oregon', 'Sacramento', 79977, '557-388-1057', 25),
	(1015, 'Daryl', 'Romero', '655 Boston Post Rd', 'Montana', 'San Jose', 99243, '661-551-8663', 21),
	(1016, 'Don', 'Hicks', '625 School Street', 'California', 'Orlando', 36858, '857-960-9277', 24),
	(1017, 'Edwin', 'Dixon', '80 Town Line Rd', 'Wisconsin', 'Cleveland', 79524, '446-925-5039', 24),
	(1018, 'Erik', 'Hunt', '465 Bridgeport Avenue', 'New York', 'Pittsburgh', 79179, '956-239-8842', 22),
	(1019, 'Grahame', 'Palmer', '235 Queen St', 'Delaware', 'Cincinnati', 97295, '882-959-7904', 25),
	(1020, 'Ivan', 'Robertson', '150 Barnum Avenue Cutoff', 'Vermont', 'Manhattan', 28865, '644-603-9120', 28),
	(1021, 'Kyle', 'Black', '970 Torringford Street', 'Rhode Island', 'Austin', 28083, '815-323-7424', 27),
	(1022, 'Leigh', 'Holmes', '844 No Colony Road', 'Maine', 'Kansas City', 35677, '647-863-2359', 21),
	(1023, 'Lorne', 'Stone', '910 Wolcott St', 'Florida', 'Indianapolis', 64736, '208-552-8171', 31),
	(1024, 'Maurice', 'Meyer', '155 Waterford Parkway No', 'Mississippi', 'Columbus', 35573, '971-717-1693', 26),
	(1025, 'Murdo', 'Boyd', '515 Sawmill Road', 'Oregon', 'Virginia Beach', 88199, '756-958-5945', 34);
/*!40000 ALTER TABLE `flight_attendant` ENABLE KEYS */;

-- Dumping structure for table flight manager.plane
CREATE TABLE IF NOT EXISTS `plane` (
  `PLANE_ID` int(11) NOT NULL,
  `CAP_ID` int(11) NOT NULL,
  `BUS_CLS_CAP` int(11) NOT NULL,
  `ECO_CLAS_CAP` int(11) NOT NULL,
  `FIRST_CLASS_CAP` int(11) NOT NULL,
  `PLANE_MODEL` varchar(25) NOT NULL,
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

-- Dumping data for table flight manager.plane: ~4 rows (approximately)
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` (`PLANE_ID`, `CAP_ID`, `BUS_CLS_CAP`, `ECO_CLAS_CAP`, `FIRST_CLASS_CAP`, `PLANE_MODEL`, `FLIGHT_NUM`, `ATT_ID`) VALUES
	(101, 1003, 20, 62, 12, 'AIRBUS A220', 1001, 1001),
	(102, 1005, 30, 90, 20, 'AIRBUS A320NEO', 1005, 1024),
	(103, 1003, 0, 0, 7, 'EMBRAER PHENOM 100', 1002, 1003),
	(104, 1024, 20, 62, 12, 'AIRBUS A220', 1004, 1015);
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

-- Dumping data for table flight manager.route: ~4 rows (approximately)
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` (`ROUTE_ID`, `DEP_LOC`, `ARR_LOC`, `PORT_ID`) VALUES
	(1001, 'Brook Airport', 'Swaid Helicopters', 1001),
	(1002, 'Swaids Helicopters', 'O\'Dwyer Airfield', 1002),
	(1003, 'Muld Strip', 'Harrison County Airstrip', 1008),
	(1004, 'Levissonly International Airport', 'Muld Strip', 1010);
/*!40000 ALTER TABLE `route` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
