-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           8.0.13 - MySQL Community Server - GPL
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para heroisbd
CREATE DATABASE IF NOT EXISTS `heroisbd` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `heroisbd`;

-- Copiando estrutura para tabela heroisbd.heroi
CREATE TABLE IF NOT EXISTS `heroi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `alterego` varchar(45) DEFAULT NULL,
  `nome` text,
  `cores` varchar(45) DEFAULT NULL,
  `criador` text,
  `universo` varchar(15) DEFAULT NULL,
  `datacriacao` date DEFAULT NULL,
  `poder` varchar(45) DEFAULT NULL,
  `sinopse` mediumtext,
  `nemesis` varchar(45) DEFAULT NULL,
  `caminhofigura` varchar(45) DEFAULT NULL,
  `pontos` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Conterá os dados do herói';

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela heroisbd.heroi_copy
CREATE TABLE IF NOT EXISTS `heroi_copy` (
  `chave` int(11) NOT NULL AUTO_INCREMENT,
  `id` int(11) NOT NULL,
  `alterego` varchar(45) DEFAULT NULL,
  `nome` text,
  `cores` varchar(45) DEFAULT NULL,
  `criador` text,
  `universo` enum('Marvel','DC','Ebal') DEFAULT NULL,
  `datacriacao` date DEFAULT NULL,
  `poder` varchar(45) DEFAULT NULL,
  `sinopse` mediumtext,
  `nemesis` varchar(45) DEFAULT NULL,
  `caminhofigura` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`chave`)
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC COMMENT='Conterá os dados do herói';

-- Exportação de dados foi desmarcado.
-- Copiando estrutura para tabela heroisbd.vencedor
CREATE TABLE IF NOT EXISTS `vencedor` (
  `chave` int(11) NOT NULL AUTO_INCREMENT,
  `alterego` varchar(50) DEFAULT NULL,
  `pontos` int(11) DEFAULT NULL,
  PRIMARY KEY (`chave`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
