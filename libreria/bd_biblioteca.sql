-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generaci�n: 07-05-2024 a las 06:39:59
-- Versi�n del servidor: 10.4.18-MariaDB
-- Versi�n de PHP: 7.4.18

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

--
-- Base de datos: `bd_biblioteca`
--
CREATE DATABASE IF NOT EXISTS `bd_biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `bd_biblioteca`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_libro`
--
-- Creaci�n: 07-05-2024 a las 01:42:39
-- �ltima actualizaci�n: 07-05-2024 a las 02:13:29
--

DROP TABLE IF EXISTS `tb_libro`;
CREATE TABLE IF NOT EXISTS `tb_libro` (
  `isbn` int(11) NOT NULL COMMENT 'codigo isbn de registro',
  `nombre` varchar(100) NOT NULL COMMENT 'nombre del libro',
  `autor` varchar(100) NOT NULL COMMENT 'autor del libro',
  `editorial` varchar(50) NOT NULL COMMENT 'nombre de la editorial del libro',
  `anio` int(11) NOT NULL COMMENT 'a�o de publicaci�n del libro',
  PRIMARY KEY (`isbn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELACIONES PARA LA TABLA `tb_libro`:
--

--
-- Volcado de datos para la tabla `tb_libro`
--

INSERT DELAYED IGNORE INTO `tb_libro` (`isbn`, `nombre`, `autor`, `editorial`, `anio`) VALUES
(978958612, 'Aprender PHP, MySQL y JavaScript', 'Robin Nixon', 'Marcombo', 2019),
(978958682, 'JEE 7 a Fondo', 'Pablo Sznajdleder', 'Alfaomega', 2015),
(978958778, 'Desarrollo de aplicaciones Web con Jakarta EE', 'Cesar Francisco Castillo', 'Marcombo', 2022),
(978958850, 'Creaci�n de un portal con PHP y MySQL', 'Jacobo Pav�n Puertas', 'Alfaomega', 2011);


--
-- Metadatos
--
USE `phpmyadmin`;

--
-- Metadatos para la tabla tb_libro
--

--
-- Metadatos para la base de datos bd_biblioteca
--
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
