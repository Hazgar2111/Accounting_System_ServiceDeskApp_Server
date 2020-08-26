-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Авг 26 2020 г., 08:41
-- Версия сервера: 10.4.13-MariaDB
-- Версия PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `accountingsystem`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admins`
--

CREATE TABLE `admins` (
  `id` int(11) NOT NULL,
  `login` varchar(45) NOT NULL,
  `pass1` varchar(45) NOT NULL,
  `name1` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `group1` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `inventory`
--

CREATE TABLE `inventory` (
  `id` int(11) NOT NULL,
  `idinventory` varchar(15) NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `kto_vydal` varchar(100) NOT NULL,
  `recieved` varchar(100) NOT NULL,
  `location` varchar(45) NOT NULL,
  `date_of_issue` varchar(10) NOT NULL,
  `peremechenie_1C` varchar(45) DEFAULT NULL,
  `nakladnaya_1C` varchar(45) DEFAULT NULL,
  `REQ_number` varchar(45) DEFAULT NULL,
  `transport_nakladnaya` varchar(45) DEFAULT NULL,
  `description` varchar(200) DEFAULT NULL,
  `macAddress` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `inventorybu`
--

CREATE TABLE `inventorybu` (
  `idinventory` varchar(15) NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `kto_prinayl` varchar(45) NOT NULL,
  `kto_sdal` varchar(45) NOT NULL,
  `macAddress` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `new_inventory`
--

CREATE TABLE `new_inventory` (
  `id` int(11) NOT NULL,
  `idinventory` varchar(20) NOT NULL,
  `serial_number` varchar(20) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `macAddress` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `admins`
--
ALTER TABLE `admins`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `new_inventory`
--
ALTER TABLE `new_inventory`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `admins`
--
ALTER TABLE `admins`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `inventory`
--
ALTER TABLE `inventory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `new_inventory`
--
ALTER TABLE `new_inventory`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
