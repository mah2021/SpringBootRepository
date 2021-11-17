-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 17, 2021 at 10:59 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `employee`
--
CREATE DATABASE IF NOT EXISTS `employee` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `employee`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewEmployee` (IN `firstIN` VARCHAR(50) CHARSET utf8mb4, IN `lastIN` VARCHAR(50) CHARSET utf8mb4, IN `phoneIN` VARCHAR(12) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `addressIN` VARCHAR(300) CHARSET utf8mb4, IN `passwordIN` VARCHAR(200) CHARSET utf8mb4)  INSERT INTO `employee` (`employee`.`firstname`,`employee`.`lastname`,`employee`.`phone`,
                       `employee`.`email`,`employee`.`address`,
       `employee`.`password`
                      ) VALUES (firstIN,lastIN,phoneIN,emailIn,addressIN,passwordIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewLeaves` (IN `employeeidIN` INT(8), IN `fromdateIN` DATE, IN `todateIN` DATE, IN `reasonIN` VARCHAR(200) CHARSET utf8mb4, IN `status` BOOLEAN)  INSERT INTO `leaves` (`leaves`.`employeeid`,`leaves`.`fromdate`
                     ,`leaves`.`todate`,`leaves`.`reason`,`leaves`.`status`) VALUES (employeeidIN,fromdateIN,todateIN,reasonIN,false)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewRole` (IN `titleIN` VARCHAR(50) CHARSET utf8mb4)  INSERT INTO `role` (`role`.`name`) VALUES (titleIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addNewSalary` (IN `employeeidIN` INT(8), IN `totalworkingIN` INT(5), IN `basicsalaryIN` DOUBLE, IN `taxIN` DOUBLE, IN `remainsalaryIN` DOUBLE)  INSERT INTO `salary` (`salary`.`employeeid`,`salary`.`totalworking`
                     ,`salary`.`basicsalary`,`salary`.`tax`,`salary`.`remainsalary`) VALUES (employeeidIN,totalworkingIN,basicsalaryIN,taxIN,remainsalaryIN)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteEmployee` (IN `idIN` INT(8))  DELETE FROM `employee` WHERE `employee`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteLeaves` (IN `idIN` INT(8))  DELETE FROM `leaves` WHERE `leaves`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteRole` (IN `idIN` INT(8))  DELETE FROM `role` WHERE `role`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteSalary` (IN `idIN` INT(8))  DELETE FROM `salary` WHERE `salary`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getEmployee` ()  SELECT * FROM `employee`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getLeaves` ()  SELECT * FROM `leaves`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getRole` ()  SELECT * FROM `role`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getSalary` ()  SELECT * FROM `salary`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateEmployee` (IN `firstIN` VARCHAR(50) CHARSET utf8mb4, IN `lastIN` VARCHAR(50) CHARSET utf8mb4, IN `phoneIN` VARCHAR(12) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `addressIN` VARCHAR(300) CHARSET utf8mb4, IN `passwordIN` VARCHAR(200) CHARSET utf8mb4, IN `idIN` INT(8))  UPDATE `employee` SET `employee`.`firstname`=firstIN,
`employee`.`lastname`=lastIN,
`employee`.`phone`=phoneIN,
`employee`.`email`=emailIN,
`employee`.`address`=addressIN

WHERE
`employee`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateLeaves` (IN `status` BOOLEAN, IN `idIN` INT(8))  UPDATE `leaves` SET 

`leaves`.`status`= 1
WHERE
`leaves`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateRole` (IN `titleIN` VARCHAR(50) CHARSET utf8mb4, IN `idIN` INT(8))  UPDATE `role` SET 
`employee`.`name`=titleIN
WHERE
`role`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `updateSalary` (IN `employeeidIN` INT(8), IN `totalworkingIN` INT(5), IN `basicsalaryIN` DOUBLE, IN `taxIN` DOUBLE, IN `remainsalaryIN` DOUBLE, IN `idIN` INT(8))  UPDATE `salary` SET 
`salary`.`employeeid`=employeeidIN,
`salary`.`totalworking`=totalworkingIN,
`salary`.`basicsalary`=basicsalaryIN,
`salary`.`tax`=taxIN,
`salary`.`remainsalary`=remainsalaryIN
WHERE
`salary`.`id`=idIN$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(8) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `phone` varchar(12) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(300) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `firstname`, `lastname`, `phone`, `email`, `address`, `password`) VALUES
(1, 'Mahbobueh', 'Kianifard', '703227635', 'designerema3@gmail.com', '1081 Budapest,kun utca 4', 'designer'),
(3, 'Reza', 'Parviznia', '702589632', 'user@gmail.com', 'Elezabet Utca', 'user'),
(5, 'Sara', 'Rezaee', '205874523', 'admin@gmail.com', 'Vaci utca 30', 'admin'),
(6, 'Mohammad', 'Avazpour', '703227736', 'zeitongraph@gmail.com', 'Blaha ter', '13591363ma4');

-- --------------------------------------------------------

--
-- Table structure for table `leaves`
--

CREATE TABLE `leaves` (
  `id` int(8) NOT NULL,
  `employeeid` int(8) NOT NULL,
  `fromdate` date NOT NULL,
  `todate` date NOT NULL,
  `reason` varchar(200) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `leaves`
--

INSERT INTO `leaves` (`id`, `employeeid`, `fromdate`, `todate`, `reason`, `status`) VALUES
(2, 1, '2021-11-09', '2021-11-11', 'sick', 1),
(3, 3, '2021-11-09', '2021-11-15', 'travel', 0),
(4, 7, '2021-11-09', '2021-11-09', 'string', 1);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(8) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'employee'),
(2, 'admin'),
(3, 'accountant');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `id` int(8) NOT NULL,
  `employeeid` int(8) NOT NULL,
  `totalworking` int(5) NOT NULL,
  `basicsalary` double NOT NULL,
  `tax` double NOT NULL,
  `remainsalary` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`id`, `employeeid`, `totalworking`, `basicsalary`, `tax`, `remainsalary`) VALUES
(4, 1, 0, 2500000, 250000, 2250000),
(11, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `employee_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `user_entity`
--

CREATE TABLE `user_entity` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_entity`
--

INSERT INTO `user_entity` (`user_id`, `email`, `password`) VALUES
(1, 'designerema3@gmail.com', '$2a$10$sQX0.G6TRBf4ZQ3D4xDoOOmNcQoaoaJHGkNb3m3r9xWdKI20mOqeW'),
(3, 'user@gmail.com', '$2a$10$BUjW8wHCAVq7ehRw3Ikpme/OKWRk5.8r0hKpCiwH7RzrTgscwPa7C'),
(5, 'admin@gmail.com', '$2a$10$J92PaPe8VzkgJiI/PPGf5eL6MMZgzh/SRM281mMekXgcSGIH7XLxK'),
(6, 'zeitongraph@gmail.com', '$2a$12$ujold1.HcyJYVNor16ciY.SXh.647MJm9ShP.Em.NSOd.f6CPdXVq');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `leaves`
--
ALTER TABLE `leaves`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeid` (`employeeid`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`id`),
  ADD KEY `employeeid` (`employeeid`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKpsleqtlaammjh4nbyxnaed0y6` (`user_id`);

--
-- Indexes for table `user_entity`
--
ALTER TABLE `user_entity`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `leaves`
--
ALTER TABLE `leaves`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `salary`
--
ALTER TABLE `salary`
  MODIFY `id` int(8) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `user_entity`
--
ALTER TABLE `user_entity`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKpsleqtlaammjh4nbyxnaed0y6` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`user_id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
