-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2017 a las 00:54:37
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
-- Base de datos: `formulario`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `contra` varchar(100) NOT NULL,
  `Fecha de Nacimiento` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `email`, `contra`, `Fecha de Nacimiento`) VALUES
('melon', 'melonnnn@gmail.com', '123456', '26/04/2017'),
('esrfs', 'fsdfsdfsd', 'dfsdfsdfs', 'dsfsdfsdfsd'),
('tryrty', 'tryrtyrtyrt', 'tryrtyrty', 'tryrtyrty'),
('Paris Lara', 'parisl@gmail.com', '123456', '12/02/2000'),
('profe', 'profe@gmail.com', '123', '12/03/2012'),
('hola', 'hola', '123', '123456'),
('oriana', 'dsadas', 'asdasdas', 'asdasasd'),
('asdasdas', 'asdasdasdsadasdd', 'sadasdasd', 'sadasdasd'),
('asdasdas', 'adsadas@asd', 'sadasdasd', 'sadasdasd');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
