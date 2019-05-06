-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 06, 2019 at 09:04 AM
-- Server version: 5.7.24
-- PHP Version: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `clojure`
--

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `authorID` int(11) NOT NULL AUTO_INCREMENT,
  `author_name` text NOT NULL,
  `author_surname` text NOT NULL,
  `awards` text,
  PRIMARY KEY (`authorID`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`authorID`, `author_name`, `author_surname`, `awards`) VALUES
(1, 'Ivo', 'Andric', 'Nobelova nagrada'),
(6, 'Franc', 'Kafka', ''),
(7, 'Fjodor', 'Dostojevski', '');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `bookID` int(11) NOT NULL AUTO_INCREMENT,
  `name` text NOT NULL,
  `published` text,
  `authorID` int(11) NOT NULL,
  PRIMARY KEY (`bookID`),
  KEY `authorID` (`authorID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookID`, `name`, `published`, `authorID`) VALUES
(1, 'Na Drini cuprija', '1946', 1),
(6, 'Proces', '1925', 6),
(5, 'Prokleta avlija', '1954', 1),
(7, 'Zamak', '1930', 6),
(8, 'Zlocin i kazna', '1866', 7),
(9, 'Kockar', '1866', 7);

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
CREATE TABLE IF NOT EXISTS `review` (
  `reviewID` int(11) NOT NULL AUTO_INCREMENT,
  `text` text,
  `stars` int(11) DEFAULT NULL,
  `bookID` int(11) NOT NULL,
  PRIMARY KEY (`reviewID`),
  KEY `bookID` (`bookID`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`reviewID`, `text`, `stars`, `bookID`) VALUES
(17, 'Odlicno!', 5, 1),
(16, 'Konfuzna knjiga', 3, 6),
(15, 'Nije mi se dopala', 2, 9),
(14, 'Izuzetna knjiga', 5, 9);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
