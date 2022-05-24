-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 10, 2022 at 12:30 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cs230dz07`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `customer_number` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `contact` varchar(128) NOT NULL,
  `phone` varchar(254) NOT NULL,
  `address` varchar(254) NOT NULL,
  `city` varchar(254) NOT NULL,
  `state` varchar(254) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `country` varchar(254) NOT NULL,
  `sales_rep_employee_number` int(11) NOT NULL,
  `credit_limit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `employee_number` int(11) NOT NULL,
  `parent_employee` int(11) NOT NULL,
  `customer_number` int(11) NOT NULL,
  `last_name` varchar(128) NOT NULL,
  `first_name` varchar(128) NOT NULL,
  `extension` varchar(254) NOT NULL,
  `email` varchar(254) NOT NULL,
  `office_code` int(11) NOT NULL,
  `reports_to` varchar(254) NOT NULL,
  `job_title` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `offices`
--

CREATE TABLE `offices` (
  `office_code` int(11) NOT NULL,
  `city` varchar(128) NOT NULL,
  `phone` varchar(128) NOT NULL,
  `address` varchar(254) NOT NULL,
  `state` varchar(254) NOT NULL,
  `country` varchar(254) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `territory` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `order_` int(11) NOT NULL,
  `date` date NOT NULL,
  `required_date` date NOT NULL,
  `shipped_date` date NOT NULL,
  `status` varchar(254) NOT NULL,
  `comment` varchar(254) NOT NULL,
  `customer_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `order_details`
--

CREATE TABLE `order_details` (
  `quantity_ordered` int(11) NOT NULL,
  `price_each` int(11) NOT NULL,
  `order_line_number` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `order_number` int(11) NOT NULL,
  `details_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `payments`
--

CREATE TABLE `payments` (
  `payment__date` date NOT NULL,
  `amount` int(11) NOT NULL,
  `customer_number` int(11) NOT NULL,
  `check_number` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `productilnes`
--

CREATE TABLE `productilnes` (
  `product_line` int(11) NOT NULL,
  `code` int(11) NOT NULL,
  `text_description` varchar(128) NOT NULL,
  `html_description` varchar(128) NOT NULL,
  `image` varchar(254) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `code` int(11) NOT NULL,
  `name` varchar(128) NOT NULL,
  `line` int(11) NOT NULL,
  `scale` int(11) NOT NULL,
  `vendor` int(11) NOT NULL,
  `description` varchar(254) NOT NULL,
  `quantity_in_stock` int(11) NOT NULL,
  `buy_price` float NOT NULL,
  `msrp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`customer_number`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`employee_number`),
  ADD KEY `fk_employees_employees` (`parent_employee`),
  ADD KEY `fk_employee_customers` (`customer_number`);

--
-- Indexes for table `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`office_code`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`order_`);

--
-- Indexes for table `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`details_id`),
  ADD KEY `fk_orderdetails_products` (`code`),
  ADD KEY `fk_orderdetails_orders` (`order_number`);

--
-- Indexes for table `payments`
--
ALTER TABLE `payments`
  ADD PRIMARY KEY (`check_number`),
  ADD KEY `fk_customers_payments` (`customer_number`);

--
-- Indexes for table `productilnes`
--
ALTER TABLE `productilnes`
  ADD PRIMARY KEY (`product_line`),
  ADD KEY `fk_productlines_product` (`code`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`code`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `customer_number` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `employee_number` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `offices`
--
ALTER TABLE `offices`
  MODIFY `office_code` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `order_details`
--
ALTER TABLE `order_details`
  MODIFY `details_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payments`
--
ALTER TABLE `payments`
  MODIFY `check_number` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `productilnes`
--
ALTER TABLE `productilnes`
  MODIFY `product_line` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `fk_employee_customers` FOREIGN KEY (`customer_number`) REFERENCES `customers` (`customer_number`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_employees_employees` FOREIGN KEY (`parent_employee`) REFERENCES `employees` (`employee_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `fk_orderdetails_orders` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_`),
  ADD CONSTRAINT `fk_orderdetails_products` FOREIGN KEY (`code`) REFERENCES `products` (`code`);

--
-- Constraints for table `payments`
--
ALTER TABLE `payments`
  ADD CONSTRAINT `fk_customers_payments` FOREIGN KEY (`customer_number`) REFERENCES `customers` (`customer_number`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `productilnes`
--
ALTER TABLE `productilnes`
  ADD CONSTRAINT `fk_productlines_product` FOREIGN KEY (`code`) REFERENCES `products` (`code`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
