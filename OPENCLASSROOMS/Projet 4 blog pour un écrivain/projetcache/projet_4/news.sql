-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 21 Mars 2018 à 23:35
-- Version du serveur :  5.6.17-log
-- Version de PHP :  7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `news`
--

-- --------------------------------------------------------

--
-- Structure de la table `comments`
--

DROP TABLE IF EXISTS `comments`;
CREATE TABLE IF NOT EXISTS `comments` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `news` smallint(6) NOT NULL,
  `auteur` varchar(50) NOT NULL,
  `contenu` text NOT NULL,
  `date` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `comments`
--

INSERT INTO `comments` (`id`, `news`, `auteur`, `contenu`, `date`) VALUES
(1, 1, 'isis', 'aaaaaaaaaaaaaaaaaaaaaubhiniffdnnid fi  vsiuiuuzi huivhodchu uhduhsuh uhduhoscho uchsuvhf uhcsi', '2018-03-19 15:45:14');

-- --------------------------------------------------------

--
-- Structure de la table `news`
--

DROP TABLE IF EXISTS `news`;
CREATE TABLE IF NOT EXISTS `news` (
  `id` smallint(5) UNSIGNED NOT NULL AUTO_INCREMENT,
  `auteur` varchar(30) NOT NULL,
  `titre` varchar(100) NOT NULL,
  `contenu` text NOT NULL,
  `dateAjout` datetime NOT NULL,
  `dateModif` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `news`
--

INSERT INTO `news` (`id`, `auteur`, `titre`, `contenu`, `dateAjout`, `dateModif`) VALUES
(1, 'Fan', 'Basketball', 'Dans sa quÃªte pour la 3e place Ã  lâ€™Ouest, OKC a poursuivi sa marche en avant sur le parquet de Toronto, privÃ© de Fred VanVleet (touchÃ© Ã  la main), en sâ€™imposant 132-125 Ã  lâ€™issue dâ€™un match de haut niveau terni par les Ã©jections de DeMar DeRozan (24 points), Serge Ibaka et du coach Dwane Casey en fin de partie.\r\n\r\nKyle Lowry y compris (22 points et 10 passes, sorti pour six fautes), les cadres des Raptors ont tout simplement fini par craquer face Ã  lâ€™appÃ©tit insatiable dâ€™un monstre pour le moins vorace, Russell Westbrook, auteur de son cinquiÃ¨me triple-double de suite (37 points Ã  15/22, 13 rebonds, 14 passes) et de 17 points dans le dernier quart-temps.\r\n\r\nDans un mega money-time tendu jusquâ€™au bout, câ€™est en effet lui qui a inscrit les deux paniers qui ont complÃ¨tement fait disjoncter la meilleure Ã©quipe de lâ€™Est qui restait pourtant sur onze victoires de suite.', '2018-03-19 15:40:39', '2018-03-19 15:40:39');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
