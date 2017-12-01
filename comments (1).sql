-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2017 a las 22:35:02
-- Versión del servidor: 10.1.28-MariaDB
-- Versión de PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `juegoonline`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comments`
--

CREATE TABLE `comments` (
  `id` int(11) NOT NULL,
  `Usuario` varchar(30) NOT NULL,
  `Email` varchar(30) DEFAULT NULL,
  `FechadeNacimiento` varchar(20) NOT NULL,
  `Contrasena` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `comments`
--

INSERT INTO `comments` (`id`, `Usuario`, `Email`, `FechadeNacimiento`, `Contrasena`) VALUES
(1, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(2, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(3, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(4, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(5, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(6, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena'),
(7, 'Usuario', 'Email', 'FechaDeNacimiento', 'Contrasena');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comments`
--
ALTER TABLE `comments`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
