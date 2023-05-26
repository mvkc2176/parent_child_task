-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 25, 2023 at 11:57 PM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `parent_child`
--

-- --------------------------------------------------------

--
-- Table structure for table `children`
--

CREATE TABLE `children` (
  `id` bigint(20) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `paid_amount` float DEFAULT NULL,
  `created_at` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `children`
--

INSERT INTO `children` (`id`, `parent_id`, `paid_amount`, `created_at`) VALUES
(1, 1, 10, '2023-05-25 12:28:23'),
(2, 2, 50, '2023-05-25 12:28:23'),
(3, 1, 40, '2023-05-25 12:28:23'),
(4, 2, 100, '2023-05-25 12:28:23'),
(5, 3, 10, '2023-05-25 12:28:23'),
(6, 3, 150, '2023-05-25 12:28:23'),
(7, 3, 100, '2023-05-25 12:28:23'),
(8, 4, 300, '2023-05-25 12:28:23'),
(9, 4, 300, '2023-05-25 12:28:23'),
(12, 5, 10, '2023-05-25 12:28:23'),
(13, 5, 10, '2023-05-25 12:28:23'),
(14, 5, 10, '2023-05-25 12:28:23'),
(15, 5, 10, '2023-05-25 12:28:23'),
(16, 6, 125, '2023-05-25 12:28:23');

-- --------------------------------------------------------

--
-- Table structure for table `parents`
--

CREATE TABLE `parents` (
  `id` bigint(20) NOT NULL,
  `sender` varchar(255) NOT NULL,
  `receiver` varchar(255) NOT NULL,
  `created_at` varchar(255) DEFAULT NULL,
  `total_amount` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `parents`
--

INSERT INTO `parents` (`id`, `sender`, `receiver`, `created_at`, `total_amount`) VALUES
(1, 'ABC', 'XYZ', '2023-05-25 12:28:23', 200),
(2, 'XYZ', 'MNP', '2023-05-25 12:28:23', 100),
(3, 'XYZ', 'MNP', '2023-05-25 12:28:23', 300),
(4, 'ABC', 'MNP', '2023-05-25 12:28:23', 1000),
(5, 'XYZ', 'ABC', '2023-05-25 12:28:23', 50),
(6, 'MNP', 'PQRS', '2023-05-25 12:28:23', 200),
(7, 'ABC', 'PQRS', '2023-05-25 12:28:23', 200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `children`
--
ALTER TABLE `children`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK80yjq0eid40qils83jpgpo6t6` (`parent_id`);

--
-- Indexes for table `parents`
--
ALTER TABLE `parents`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `children`
--
ALTER TABLE `children`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `parents`
--
ALTER TABLE `parents`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `children`
--
ALTER TABLE `children`
  ADD CONSTRAINT `FK80yjq0eid40qils83jpgpo6t6` FOREIGN KEY (`parent_id`) REFERENCES `parents` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
