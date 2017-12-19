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
-- Table structure for table `hotel`
--

DROP TABLE IF EXISTS `hotel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hotel` (
  `idhotel` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `plage` varchar(45) DEFAULT NULL,
  `parking` varchar(45) DEFAULT NULL,
  `promotions` varchar(45) DEFAULT NULL,
  `nombre_etoile` varchar(45) DEFAULT NULL,
  `num_tel` varchar(45) DEFAULT NULL,
  `descriptions` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotel`
--

LOCK TABLES `hotel` WRITE;
/*!40000 ALTER TABLE `hotel` DISABLE KEYS */;
INSERT INTO `hotel` VALUES ('sultane_nabeul','soltane','nabeul','oui','oui','oui','4 Etoiles','54789632','L hébergement indépendant Douja Apartment se trouve à Nabeul. La connexion Wi-Fi est gratuite. Cet appartement comporte une télévision, la climatisation et un coin salon.'),('kheops_nabeul','kheops','nabeul','oui','oui','oui',NULL,NULL,'Hotel kheops est situé à Nabeul, à 4 km du musée Néapolis. La connexion Wi-Fi gratuite est accessible dans toutes les pièces.'),('bizence_nabeul','bizence','nabeul','non','oui','non',NULL,NULL,'Lhôtel jouit d un emplacement idéal en face de la Méditerranée et à 500 mètres du centre et des souks.'),('delfino_nabeul','delfino','nabeul','oui','oui','non',NULL,NULL,'Doté dune piscine extérieure et dun spa, lHotel Delfino Beach Resort & Spa (Ex-Aldiana) est situé à Nabeul, dans la région de Nabeul, à 7 km du musée Neapolis.'),('movempick_sousse','movempick','sousse','oui','oui','oui',NULL,NULL,'Le Mövenpick Resort & Marine Spa Sousse est complexe hôtelier situé dans le centre-ville de Sousse.'),('leCorail_tunis','leCorail','tunis','oui','oui','oui',NULL,NULL,'Le Corail Suites Hotel vous accueille à 11 km du centre de Tunis et à 450 mètres du lac. Il propose des chambres et des suites dotées dune connexion Wi-Fi gratuite.\n'),('liberty_monastir','liberty','tunis','oui','oui','oui',NULL,NULL,'Situé sur le front de mer , le Liberty Hotels Lykia dispose dune plage privée de 750 mètres de long, de 19 piscines, dun parcours de golf de 3 trous et dun spa.'),('marhababeach_nabeul','marhababeach','nabeul','oui','oui','non',NULL,NULL,'Le Palace Hammamet Marhaba est situé à Hammamet, dans la région de Nabeul, à 700 mètres du site romain de Pupput.'),('tajmarhaba_sousse','tajmarhaba','sousse','non','oui','oui',NULL,NULL,'Le complexe Tej Marhaba est situé dans la station balnéaire de Sousse, en Tunisie. Il possède une plage privée à seulement 200 mètres et 3 restaurants servant une cuisine tunisienne et internationale....'),('princesse_sousse','princesse','nabeul','non','oui','non',NULL,NULL,'Situé à 1,6 km du musée Néapolis à Nabeul, le Princesse De La Mer Apartment est un appartement climatisé avec une connexion Wi-Fi gratuite et une terrasse Sa cuisine est équipée dun four ...'),('regency_paris','regency','paris','non','oui','non',NULL,NULL,'Le Hyatt Regency Paris Etoile, connu autrefois sous le nom dHotel Concorde La Fayette, vous accueille à 1,5 km de larc de triomphe et des célèbres Champs-Élysées.'),('Amir','BenSlm','test','hahha','lol','mooul','poo',NULL,'foul'),('Amir','BenSlm','test','hahha','lol','mooul','poo',NULL,'foul'),('Amir_BenSlm','Amir','BenSlm','test','hahha','lol','foul',NULL,'mooul'),('OnsHotel_Somaa_OnsHotel','OnsHotel_Somaa','OnsHotel','Somaa','5 Etoiles','oui','oui','oui','hhahah');
/*!40000 ALTER TABLE `hotel` ENABLE KEYS */;
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
