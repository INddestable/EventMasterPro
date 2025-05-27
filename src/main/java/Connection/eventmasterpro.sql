-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-05-2025 a las 17:54:32
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `eventmasterpro`
--
CREATE DATABASE IF NOT EXISTS `eventmasterpro` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `eventmasterpro`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artist`
--

CREATE TABLE `artist` (
  `idartist` int(11) NOT NULL,
  `nameartist` varchar(100) NOT NULL,
  `technicalrequirement` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `artistrecord`
--

CREATE TABLE `artistrecord` (
  `idartist` int(11) NOT NULL,
  `idrecord` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `assistant`
--

CREATE TABLE `assistant` (
  `idassistant` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `event`
--

CREATE TABLE `event` (
  `idevent` int(11) NOT NULL,
  `nameevent` varchar(100) NOT NULL,
  `idlocation` int(11) DEFAULT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventartist`
--

CREATE TABLE `eventartist` (
  `idevent` int(11) NOT NULL,
  `idartist` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `history`
--

CREATE TABLE `history` (
  `idhistory` int(11) NOT NULL,
  `idassistant` int(11) DEFAULT NULL,
  `idevent` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `location`
--

CREATE TABLE `location` (
  `idlocation` int(11) NOT NULL,
  `namelocation` varchar(100) NOT NULL,
  `capacity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prueba`
--

CREATE TABLE `prueba` (
  `campogenerico` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `record`
--

CREATE TABLE `record` (
  `idrecord` int(11) NOT NULL,
  `namerecord` varchar(100) NOT NULL,
  `gender` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `idticket` int(11) NOT NULL,
  `idevent` int(11) DEFAULT NULL,
  `ticket_type` varchar(50) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `selled` tinyint(1) DEFAULT NULL,
  `idassistant` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`idartist`);

--
-- Indices de la tabla `artistrecord`
--
ALTER TABLE `artistrecord`
  ADD PRIMARY KEY (`idartist`,`idrecord`),
  ADD KEY `idrecord` (`idrecord`);

--
-- Indices de la tabla `assistant`
--
ALTER TABLE `assistant`
  ADD PRIMARY KEY (`idassistant`);

--
-- Indices de la tabla `event`
--
ALTER TABLE `event`
  ADD PRIMARY KEY (`idevent`),
  ADD KEY `idlocation` (`idlocation`);

--
-- Indices de la tabla `eventartist`
--
ALTER TABLE `eventartist`
  ADD PRIMARY KEY (`idevent`,`idartist`),
  ADD KEY `idartist` (`idartist`);

--
-- Indices de la tabla `history`
--
ALTER TABLE `history`
  ADD PRIMARY KEY (`idhistory`),
  ADD KEY `idassistant` (`idassistant`),
  ADD KEY `idevent` (`idevent`);

--
-- Indices de la tabla `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`idlocation`);

--
-- Indices de la tabla `record`
--
ALTER TABLE `record`
  ADD PRIMARY KEY (`idrecord`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idticket`),
  ADD KEY `idevent` (`idevent`),
  ADD KEY `idassistant` (`idassistant`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `artist`
--
ALTER TABLE `artist`
  MODIFY `idartist` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `assistant`
--
ALTER TABLE `assistant`
  MODIFY `idassistant` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `event`
--
ALTER TABLE `event`
  MODIFY `idevent` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `history`
--
ALTER TABLE `history`
  MODIFY `idhistory` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `location`
--
ALTER TABLE `location`
  MODIFY `idlocation` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `record`
--
ALTER TABLE `record`
  MODIFY `idrecord` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idticket` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `artistrecord`
--
ALTER TABLE `artistrecord`
  ADD CONSTRAINT `artistrecord_ibfk_1` FOREIGN KEY (`idartist`) REFERENCES `artist` (`idartist`),
  ADD CONSTRAINT `artistrecord_ibfk_2` FOREIGN KEY (`idrecord`) REFERENCES `record` (`idrecord`);

--
-- Filtros para la tabla `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_ibfk_1` FOREIGN KEY (`idlocation`) REFERENCES `location` (`idlocation`);

--
-- Filtros para la tabla `eventartist`
--
ALTER TABLE `eventartist`
  ADD CONSTRAINT `eventartist_ibfk_1` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`),
  ADD CONSTRAINT `eventartist_ibfk_2` FOREIGN KEY (`idartist`) REFERENCES `artist` (`idartist`);

--
-- Filtros para la tabla `history`
--
ALTER TABLE `history`
  ADD CONSTRAINT `history_ibfk_1` FOREIGN KEY (`idassistant`) REFERENCES `assistant` (`idassistant`),
  ADD CONSTRAINT `history_ibfk_2` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`);

--
-- Filtros para la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD CONSTRAINT `ticket_ibfk_1` FOREIGN KEY (`idevent`) REFERENCES `event` (`idevent`),
  ADD CONSTRAINT `ticket_ibfk_2` FOREIGN KEY (`idassistant`) REFERENCES `assistant` (`idassistant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
