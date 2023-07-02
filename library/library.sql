-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 18, 2023 at 09:00 AM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `bookId` int(4) NOT NULL,
  `bookTitle` varchar(10) DEFAULT NULL,
  `Price` int(4) DEFAULT NULL,
  `Author` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookId`, `bookTitle`, `Price`, `Author`) VALUES
(1, 'phython', 20, 'chacha'),
(3, 'science', 20, 'aslam'),
(4, 'sales', 300, 'virend'),
(5, 'java', 10000, 'me khod'),
(6, 'relax', 2, 'wasem'),
(8, 'english', 33, 'salman'),
(9, 'c++', 1200, 'johnshom'),
(10, 'english', 300, 'john');

-- --------------------------------------------------------

--
-- Table structure for table `issued`
--

CREATE TABLE `issued` (
  `sno` int(4) NOT NULL,
  `memberName` varchar(10) DEFAULT NULL,
  `bookName` varchar(10) DEFAULT NULL,
  `issueDate` date DEFAULT NULL,
  `returnDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `issued`
--

INSERT INTO `issued` (`sno`, `memberName`, `bookName`, `issueDate`, `returnDate`) VALUES
(1, '6', '6', '2023-06-15', '2023-06-30'),
(2, 'mohit', 'english', '2023-06-15', '2023-06-30'),
(3, 'mohit', 'english', '2023-06-11', '2023-06-20'),
(4, 'waseem', 'phython', '2023-08-12', '2023-08-20'),
(5, 'mahendra', 'science', '2023-06-10', '2023-06-20');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `id` int(4) NOT NULL,
  `fname` varchar(10) DEFAULT NULL,
  `lname` varchar(10) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`id`, `fname`, `lname`, `gender`) VALUES
(1, 'waseem', 'abbasi', 'male'),
(2, 'aslam', NULL, NULL),
(3, 'mahendra', 'gurjar', 'male'),
(6, 'rakhi', 'khanna', 'female'),
(7, 'mohit', 'chouhan', 'male'),
(8, 'mohit', 'sharma', 'male');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`bookId`);

--
-- Indexes for table `issued`
--
ALTER TABLE `issued`
  ADD PRIMARY KEY (`sno`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `bookId` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `issued`
--
ALTER TABLE `issued`
  MODIFY `sno` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `id` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
