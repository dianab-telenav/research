-- MySQL dump 10.13  Distrib 5.6.22, for osx10.8 (x86_64)
--
-- Host: localhost    Database: itdays_db
-- ------------------------------------------------------
-- Server version	5.6.24

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
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nume` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (1,'gheo','geo@mail.com'),(2,'new name','diana@mail.com'),(3,'silviu','diana@mail.com'),(4,'silviu','diana@mail.com'),(5,'new name','eu@mail.com'),(6,'new name','vasile@mail.com'),(7,'new name','vasile@mail.com'),(8,'new name','vasile@mail.com'),(9,'new name','vasile@mail.com'),(10,'new name','vasile@mail.com'),(11,'new name','vasile@mail.com'),(12,'new name','vasile@mail.com'),(13,'new name','vasile@mail.com'),(14,'new name','vasile@mail.com'),(15,'vasile','vasile@mail.com'),(22,'new name','vasile@mail.com'),(30,'Ioana','ioana@mail.com'),(31,'Gheorghe','gheorghe'),(32,'Oana','oana@mail.com'),(33,'Ana','ana@mail.com'),(34,'Ion','ion@mail.com'),(35,'Laurentiu','laur@mail.com'),(36,'Bogdan','bogdan@mail.com'),(37,'new name','vasile@mail.com'),(38,'new name','vasile@mail.com'),(39,'Ioana','ioana@mail.com'),(40,'Gheorghe','gheorghe'),(41,'Oana','oana@mail.com'),(42,'Ana','ana@mail.com'),(43,'Ion','ion@mail.com'),(44,'Laurentiu','laur@mail.com'),(45,'Bogdan','bogdan@mail.com'),(46,'Ioana','ioana@mail.com'),(47,'Gheorghe','gheorghe'),(48,'Oana','oana@mail.com'),(49,'Ana','ana@mail.com'),(50,'Ion','ion@mail.com'),(51,'Laurentiu','laur@mail.com'),(52,'Bogdan','bogdan@mail.com'),(53,'new name','vasile@mail.com'),(54,'new name','vasile@mail.com'),(55,'new name','vasile@mail.com'),(56,'new name','vasile@mail.com'),(57,'new name','vasile@mail.com'),(58,'new name','vasile@mail.com'),(59,'new name','vasile@mail.com'),(60,'new name','vasile@mail.com'),(61,'new name','vasile@mail.com'),(62,'new name','vasile@mail.com'),(63,'new name','vasile@mail.com'),(64,'new name','vasile@mail.com'),(65,'new name','vasile@mail.com'),(66,'new name','vasile@mail.com'),(67,'new name','vasile@mail.com'),(68,'new name','vasile@mail.com'),(69,'new name','vasile@mail.com'),(70,'new name','vasile@mail.com'),(71,'new name','vasile@mail.com'),(72,'new name','vasile@mail.com'),(73,'new name','vasile@mail.com'),(74,'new name','vasile@mail.com'),(75,'new name','vasile@mail.com'),(76,'new name','vasile@mail.com'),(77,'new name','vasile@mail.com'),(78,'new name','vasile@mail.com'),(79,'new name','vasile@mail.com'),(80,'new name','vasile@mail.com'),(81,'new name','vasile@mail.com'),(82,'new name','vasile@mail.com'),(83,'new name','vasile@mail.com'),(84,'new name','vasile@mail.com'),(85,'new name','vasile@mail.com'),(86,'new name','vasile@mail.com'),(87,'new name','vasile@mail.com'),(88,'new name','vasile@mail.com'),(89,'new name','vasile@mail.com'),(90,'new name','vasile@mail.com'),(91,'new name','vasile@mail.com'),(92,'new name','vasile@mail.com'),(93,'new name','vasile@mail.com');
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-12 18:24:15
