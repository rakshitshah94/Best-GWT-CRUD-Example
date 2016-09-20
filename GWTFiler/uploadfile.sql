-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Sep 5, 2016 at 09:48 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `uploadfile`
--

CREATE TABLE IF NOT EXISTS `uploadfile` (
  `id` int(3) NOT NULL,
  `topic` varchar(50) DEFAULT NULL,
  `stream` varchar(50) DEFAULT NULL,
  `Tag` varchar(50) DEFAULT NULL,
  `PublicLink` varchar(100) DEFAULT NULL,
  `FileBody` varchar(200) DEFAULT NULL,
  `checkboxstatus` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `uploadfile`
--

INSERT INTO `uploadfile` (`id`, `topic`, `stream`, `Tag`, `PublicLink`, `FileBody`, `checkboxstatus`) VALUES
(3, 'Rakshit Shah', 'Computer Engineering', 'RaxTon Production', 'RaxTon Production is owner of Being Coders', 'C:\\fakepath\\Raxton production.jpg', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `uploadfile`
--
ALTER TABLE `uploadfile`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `uploadfile`
--
ALTER TABLE `uploadfile`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
