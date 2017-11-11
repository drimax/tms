-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 11, 2017 at 07:59 PM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `tms`
--

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(100) NOT NULL AUTO_INCREMENT COMMENT 'primary_key for employee',
  `EPF_NO` varchar(100) NOT NULL COMMENT 'employee epf number',
  `initials` varchar(10) NOT NULL COMMENT 'initials of the employee',
  `first_name` varchar(150) NOT NULL COMMENT 'employee first name',
  `last_name` varchar(150) NOT NULL COMMENT 'employee last name',
  `mobile` varchar(100) NOT NULL COMMENT 'employee mobile ',
  `address1` varchar(150) NOT NULL COMMENT 'employee address 1',
  `address2` varchar(150) NOT NULL COMMENT 'employee address 1',
  `address3` varchar(150) NOT NULL COMMENT 'employee address 1',
  `id_number` varchar(50) NOT NULL COMMENT 'employee nice nummber',
  `basic_salary` decimal(65,0) NOT NULL COMMENT 'employee basic salary',
  `allowance` decimal(65,0) NOT NULL COMMENT 'employee allowance',
  `designation` varchar(100) NOT NULL COMMENT 'employee designation',
  `status` varchar(5) NOT NULL COMMENT 'currently working or not',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `fleet`
--

CREATE TABLE IF NOT EXISTS `fleet` (
  `fleet_id` int(100) NOT NULL AUTO_INCREMENT,
  `fleet_ref` varchar(100) NOT NULL,
  `route_id` int(100) NOT NULL,
  `vehicle_id` int(100) NOT NULL,
  `status` varchar(5) NOT NULL,
  `due_date` date NOT NULL,
  `start_time` time NOT NULL,
  `petty_cash` decimal(65,0) NOT NULL,
  `petty_cash_description` varchar(150) NOT NULL,
  PRIMARY KEY (`fleet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1),
(1);

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE IF NOT EXISTS `notes` (
  `source_key` varchar(255) DEFAULT NULL,
  `source_values` int(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` int(100) NOT NULL AUTO_INCREMENT,
  `product_category` varchar(255) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `weight` decimal(65,0) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `porfit_per_unit` decimal(65,0) NOT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` int(100) NOT NULL,
  `role` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_time` date NOT NULL,
  `modified_time` date NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role`, `description`, `active`, `created_time`, `modified_time`, `version`) VALUES
(1, 'view_dash_board', 'view dash board', 1, '2017-09-30', '2017-09-30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `route_id` int(100) NOT NULL AUTO_INCREMENT COMMENT 'primary key for routes',
  `route_name` varchar(150) NOT NULL COMMENT 'route name',
  `origin` varchar(100) NOT NULL COMMENT 'starting location',
  `destination` varchar(100) NOT NULL COMMENT 'ending location',
  `distance` decimal(65,0) NOT NULL,
  `duration` decimal(10,0) NOT NULL,
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `t_fleet_employee`
--

CREATE TABLE IF NOT EXISTS `t_fleet_employee` (
  `fleet_id` int(100) NOT NULL,
  `employee_id` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `t_vehicle`
--

CREATE TABLE IF NOT EXISTS `t_vehicle` (
  `vehicle_id` int(100) NOT NULL AUTO_INCREMENT,
  `vehicle_no` varchar(255) NOT NULL,
  `vehicle_type` varchar(255) NOT NULL,
  `vehicle_fuel_type` varchar(100) DEFAULT NULL COMMENT 'vehicle type',
  `vehicle_capacity` int(100) DEFAULT NULL COMMENT 'vehicle capacity',
  `vehicle_user` varchar(100) DEFAULT NULL,
  `vehicle_chassis_no` varchar(150) DEFAULT NULL,
  `vehicle_engine_no` varchar(100) DEFAULT NULL,
  `vehicle_model` varchar(100) DEFAULT NULL,
  `vehicle_mileage` bigint(250) DEFAULT NULL,
  `created_time` date DEFAULT NULL,
  `modified_time` date DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `vehicle_status` varchar(50) DEFAULT 'INA',
  `location` varchar(100) DEFAULT NULL,
  `eligible` char(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `t_vehicle`
--

INSERT INTO `t_vehicle` (`vehicle_id`, `vehicle_no`, `vehicle_type`, `vehicle_fuel_type`, `vehicle_capacity`, `vehicle_user`, `vehicle_chassis_no`, `vehicle_engine_no`, `vehicle_model`, `vehicle_mileage`, `created_time`, `modified_time`, `version`, `vehicle_status`, `location`, `eligible`) VALUES
(1, 'KC-6093', 'CAR', 'PETROl', 1000, 'RAVI', '121315135', '546546545', 'TOYOTA', 1500, '2017-11-01', '2017-11-01', 0, 'ACT', '', ''),
(9, 'dsas', 'CAR', 'PETROL', 2000, 'COMPANY', '133', '12321', 'dsad', 232, '2017-11-05', '2017-11-10', 0, 'ACT', '', ''),
(10, '12321', 'CAR', 'PETROL', 2000, 'RAVI', '31231211232', '213313', 'adas', 232, NULL, NULL, 0, NULL, NULL, NULL),
(11, '32113', 'CAR', 'HYBRID', 1000, 'COMPANY', '23213', '31213', 'dsda', 3213, '2017-11-12', '2017-11-12', 0, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL,
  `created_time` date NOT NULL,
  `modified_time` date NOT NULL,
  `version` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `user_id`, `email`, `password`, `name`, `active`, `created_time`, `modified_time`, `version`) VALUES
(1, 'harshika', 'hdranawaeera@gmail.com', 'harshika123', 'harshika', 1, '2017-09-30', '2017-09-30', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `id` int(100) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(100) NOT NULL,
  `role_id` int(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_role_ibfk_2` (`user_id`),
  KEY `user_role_ibfk_1` (`role_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
