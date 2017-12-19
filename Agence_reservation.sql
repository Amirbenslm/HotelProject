-- MySQL dump 10.13  Distrib 5.6.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Agence
-- ------------------------------------------------------
-- Server version	5.6.31-0ubuntu0.15.10.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id_reservation` varchar(45) DEFAULT NULL,
  `id_client` varchar(45) DEFAULT NULL,
  `room_type` varchar(45) DEFAULT NULL,
  `idHotel` varchar(45) DEFAULT NULL,
  `date_checkin` varchar(45) DEFAULT NULL,
  `date_checkout` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES ('ss-69','Bayram','triple room','sultane_nabeul','2017-05-03','2017-05-05'),('ss-70','Amine','Double room','liberty_monastir','2017-05-11','2017-05-13'),('s-80','Marwen','Single room','movempick_sousse','2017-05-13','2017-05-15'),('ss-81','id-001','Single room','kheops_nabeul','2017-05-14','2017-05-15'),('ss-82','id-001','Double room','kheops_nabeul','2017-05-14','2017-05-15'),('s-91','Saif','Double room','marhababeach_nabeul','2017-05-19','2017-05-23'),('s-88','Bayram','Double room','movempick_sousse','2017-05-10','2017-05-19'),('s-60','saif','Double room','sultane_nabeul','2017-05-03','2017-05-20'),('s-61','Id-001','Single room','delfino_nabeul','2017-05-03','2017-05-06'),('s-62','09865-Mohamed','Double room','movempick_sousse','2017-05-04','2017-05-13'),('s-63','Bayram','Double room','movempick_sousse','2017-05-04','2017-05-13'),('s-64','Id-001','triple room','bizence_nabeul','2017-05-03','2017-05-04'),('s-65','saif','Double room','kheops_nabeul','2017-05-03','2017-05-06'),('s-66','Test','Double room','kheops_nabeul','2017-05-05','2017-05-20'),('s-67','Test','Double room','sultane_nabeul','2017-05-05','2017-05-20');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-10 17:10:05