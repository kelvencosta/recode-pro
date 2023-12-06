-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: pro_agency
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `pro_agency`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `pro_agency` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `pro_agency`;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clients` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `rg` varchar(255) NOT NULL,
  `tel` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_7it9dgecuhaofss241235vdcn` (`cpf`),
  UNIQUE KEY `UK_srv16ica2c1csub334bxjjb59` (`email`),
  UNIQUE KEY `UK_608w8nxxaou29hk7ps12994bt` (`rg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinations`
--

DROP TABLE IF EXISTS `destinations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `destinations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` text,
  `img_url` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `price` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_i59qn7ny8xout82io6rh3ina4` (`img_url`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinations`
--

LOCK TABLES `destinations` WRITE;
/*!40000 ALTER TABLE `destinations` DISABLE KEYS */;
INSERT INTO `destinations` VALUES (1,'Explore a beleza arquitetônica e cultural da capital de Minas Gerais.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/belo-horizonte.jpg','Belo Horizonte',600,'Nacional'),(2,'Conheça os encantos ecológicos e urbanos da capital paranaense.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/curitiba.jpg','Curitiba',840,'Nacional'),(3,'Descubra a arquitetura modernista e os pontos turísticos da capital federal.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/brasilia.jpg','Brasília',1200,'Nacional'),(4,'Explore a maior cidade do Brasil, repleta de cultura, gastronomia e entretenimento.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/sao-paulo.jpg','São Paulo',1350,'Nacional'),(5,'Maravilhe-se com as praias icônicas, montanhas e o estilo de vida animado.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/rio-janeiro.jpg','Rio de Janeiro',1500,'Nacional'),(6,'Visite as famosas Cataratas do Iguaçu e aproveite a diversidade natural.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/foz-do-iguacu.jpg','Foz do Iguaçu',1400,'Nacional'),(7,'Explore a rica cultura e história de Buenos Aires. Com sua arquitetura elegante e atmosfera vibrante, esta cidade sul-americana é um destino imperdível.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/buenos-aires.jpg','Buenos Aires',2400,'Internacional'),(8,'Descubra a magia de Orlando, a capital mundial dos parques temáticos. Com a Disney, a Universal Studios e muito mais, é o lugar perfeito para umas férias em família.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/orlando.webp','Orlando',3200,'Internacional'),(9,'Mergulhe na beleza de Lisboa, a capital de Portugal. Com suas colinas pitorescas, ruas de paralelepípedos e rica herança, Lisboa oferece uma experiência encantadora.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/lisboa.jpg','Lisboa',2300,'Internacional'),(10,'Explore Barcelona, uma cidade cheia de arquitetura única de Gaudí, praias deslumbrantes e uma vida noturna animada. Uma mistura perfeita de cultura e diversão.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/barcelona.webp','Barcelona',2600,'Internacional'),(11,'Viaje para Tóquio, a cidade futurista onde tradição e inovação se encontram. Com tecnologia de ponta, templos antigos e uma culinária incrível, Tóquio é verdadeiramente única.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/tokyo.jpg','Tóquio',3200,'Internacional'),(12,'Descubra a grandiosidade do Cairo, lar das pirâmides e da esfinge. Uma viagem fascinante pela história do Egito e sua rica herança cultural.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/cairo.jpg','Cairo',2800,'Internacional'),(13,'Fortaleza, nordeste do Brasil: praias deslumbrantes, cultura rica, sol o ano todo. Descubra a culinária saborosa, mercados vibrantes e a hospitalidade única. Explore a Ponte dos Ingleses e o Mercado Central. Uma experiência única aguarda você em Fortaleza.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/fortaleza.webp','Fortaleza',1400,'Promocão'),(14,'Descubra a beleza de Maceió, no nordeste do Brasil. Com praias deslumbrantes, águas cristalinas e uma culinária rica em frutos do mar, Maceió é um destino tropical imperdível. Explore a Praia de Pajuçara, mergulhe nas piscinas naturais e aproveite a hospitalidade calorosa desta joia do litoral brasileiro.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/maceio.webp','Maceió',1500,'Promocão'),(15,'Salvador, nordeste do Brasil: cultura vibrante, praias deslumbrantes e arquitetura histórica. Explore o Pelourinho, sinta a energia do Carnaval e mergulhe na rica herança afro-brasileira. Uma experiência única aguarda você nesta cidade cheia de vida.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/salvador.webp','Salvador',1670,'Promocão'),(16,'Zurique, Suíça: Elegância, cultura e beleza natural se encontram nesta cidade cosmopolita. Explore museus renomados, saboreie uma culinária gourmet e desfrute das margens do Lago Zurique, garantindo uma experiência encantadora e memorável.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/zurique.webp','Zurique',3090,'Promocão'),(17,'Miami, EUA: Energia, praias deslumbrantes e uma cena cultural dinâmica. Explore distritos artísticos, saboreie gastronomia internacional e aproveite o sol em uma experiência única e vibrante.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/miame.webp','Miame',3400,'Promocão'),(18,'São Francisco, EUA: Beleza, inovação e diversidade. Da Ponte Golden Gate aos bairros charmosos, a cidade oferece uma experiência única. Explore, saboreie a gastronomia e absorva a atmosfera progressista de São Francisco, um destino fascinante.','https://kelvencosta.github.io/recode-pro/Entregas/Modulo-02/agencia-viagens/imagens/sao-francisco.webp','São Francisco',3590,'Promocão');
/*!40000 ALTER TABLE `destinations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservations` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `date_reserve` date DEFAULT NULL,
  `date_travel` date NOT NULL,
  `client_id` bigint NOT NULL,
  `destiny_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6lekctbt4u88agg0b7cjsj6lf` (`client_id`),
  KEY `FK3tjhb33rv0duoucfcsqc9hvlf` (`destiny_id`),
  CONSTRAINT `FK3tjhb33rv0duoucfcsqc9hvlf` FOREIGN KEY (`destiny_id`) REFERENCES `destinations` (`id`),
  CONSTRAINT `FK6lekctbt4u88agg0b7cjsj6lf` FOREIGN KEY (`client_id`) REFERENCES `clients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-06 16:07:44
