# SQL Manager 2010 for MySQL 4.5.0.9
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : pbol


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES latin1 */;

SET FOREIGN_KEY_CHECKS=0;

DROP DATABASE IF EXISTS `pbol`;

CREATE DATABASE `pbol`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

USE `pbol`;

#
# Structure for the `tbroom` table : 
#

CREATE TABLE `tbroom` (
  `kdroom` varchar(20) NOT NULL,
  `nama` varchar(20) DEFAULT NULL,
  `harga` int(11) DEFAULT NULL,
  `status` int(1) DEFAULT '0',
  PRIMARY KEY (`kdroom`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `tbuser` table : 
#

CREATE TABLE `tbuser` (
  `dtuser` varchar(20) NOT NULL,
  `passwd` varchar(200) DEFAULT NULL,
  `hakakses` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`dtuser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `tbroom` table  (LIMIT 0,500)
#

INSERT INTO `tbroom` (`kdroom`, `nama`, `harga`, `status`) VALUES 
  ('K0001','SIntha',1000000,0),
  ('K0002','Drupadi',1000000,0);
COMMIT;

#
# Data for the `tbuser` table  (LIMIT 0,500)
#

INSERT INTO `tbuser` (`dtuser`, `passwd`, `hakakses`) VALUES 
  ('admin','827ccb0eea8a706c4c34a16891f84e7b','CDEFGHI'),
  ('aku','202cb962ac59075b964b07152d234b70','CE');
COMMIT;



/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;