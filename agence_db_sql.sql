-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mar 19 Décembre 2017 à 23:27
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `agence`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idclient` varchar(50) DEFAULT NULL,
  `cin` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `prenom` varchar(45) DEFAULT NULL,
  `datenaissance` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idclient`, `cin`, `nom`, `prenom`, `datenaissance`, `email`, `tel`) VALUES
('Id-001', '098765412', 'Amir', 'BenSalem', '11-20-1994', 'amirbensalem30@gmail.com', '54898466'),
('09865-Mohamed', '09865471', 'Ahmed', 'Tounsi', 'Hello', 'amir.bensalem.tn@ieee.org', '23217466'),
('Bayram', '09832140', 'Mohamed', 'Bayram', '2017-05-12', 'amir.bensalem.tn@ieee.org', '09836547'),
('Test', 'Cin', '', '', '2017-05-17', 'amir.bensalem.tn@ieee.org', ''),
('test3', 'Cin', 'nom', 'prenom', '2017-05-12', 'amirbensalem30@gmail.com', 'N° telephone'),
('saif', '98632145', 'Debbichi', 'Saifoun', '1994-05-05', 'amirbensalem30@gmail.com', '55879654'),
('Firas', '98654744', 'Firas', 'benyoussef', '2017-05-05', 'amirbensalem30@gmail.com', '12369587'),
('cient', '23658974', 'nom', 'prenom', '2017-05-05', 'amirbensalem30@gmail.com', '23258741'),
('123', '23659874', 'aze', 'ez', '2017-05-04', 'abdallah.skandar@gmail.com', '14785236');

-- --------------------------------------------------------

--
-- Structure de la table `hotel`
--

CREATE TABLE `hotel` (
  `idhotel` varchar(45) DEFAULT NULL,
  `nom` varchar(45) DEFAULT NULL,
  `ville` varchar(45) DEFAULT NULL,
  `plage` varchar(45) DEFAULT NULL,
  `parking` varchar(45) DEFAULT NULL,
  `promotions` varchar(45) DEFAULT NULL,
  `nombre_etoile` varchar(45) DEFAULT NULL,
  `num_tel` varchar(45) DEFAULT NULL,
  `descriptions` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `hotel`
--

INSERT INTO `hotel` (`idhotel`, `nom`, `ville`, `plage`, `parking`, `promotions`, `nombre_etoile`, `num_tel`, `descriptions`) VALUES
('sultane_nabeul', 'soltane', 'nabeul', 'oui', 'oui', 'oui', '4 Etoiles', '54789632', 'L hébergement indépendant Douja Apartment se trouve à Nabeul. La connexion Wi-Fi est gratuite. Cet appartement comporte une télévision, la climatisation et un coin salon.'),
('kheops_nabeul', 'kheops', 'nabeul', 'oui', 'oui', 'oui', NULL, NULL, 'Hotel kheops est situé à Nabeul, à 4 km du musée Néapolis. La connexion Wi-Fi gratuite est accessible dans toutes les pièces.'),
('bizence_nabeul', 'bizence', 'nabeul', 'non', 'oui', 'non', NULL, NULL, 'Lhôtel jouit d un emplacement idéal en face de la Méditerranée et à 500 mètres du centre et des souks.'),
('delfino_nabeul', 'delfino', 'nabeul', 'oui', 'oui', 'non', NULL, NULL, 'Doté dune piscine extérieure et dun spa, lHotel Delfino Beach Resort & Spa (Ex-Aldiana) est situé à Nabeul, dans la région de Nabeul, à 7 km du musée Neapolis.'),
('movempick_sousse', 'movempick', 'sousse', 'oui', 'oui', 'oui', NULL, NULL, 'Le Mövenpick Resort & Marine Spa Sousse est complexe hôtelier situé dans le centre-ville de Sousse.'),
('leCorail_tunis', 'leCorail', 'tunis', 'oui', 'oui', 'oui', NULL, NULL, 'Le Corail Suites Hotel vous accueille à 11 km du centre de Tunis et à 450 mètres du lac. Il propose des chambres et des suites dotées dune connexion Wi-Fi gratuite.\n'),
('liberty_monastir', 'liberty', 'tunis', 'oui', 'oui', 'oui', NULL, NULL, 'Situé sur le front de mer , le Liberty Hotels Lykia dispose dune plage privée de 750 mètres de long, de 19 piscines, dun parcours de golf de 3 trous et dun spa.'),
('marhababeach_nabeul', 'marhababeach', 'nabeul', 'oui', 'oui', 'non', NULL, NULL, 'Le Palace Hammamet Marhaba est situé à Hammamet, dans la région de Nabeul, à 700 mètres du site romain de Pupput.'),
('tajmarhaba_sousse', 'tajmarhaba', 'sousse', 'non', 'oui', 'oui', NULL, NULL, 'Le complexe Tej Marhaba est situé dans la station balnéaire de Sousse, en Tunisie. Il possède une plage privée à seulement 200 mètres et 3 restaurants servant une cuisine tunisienne et internationale....'),
('princesse_sousse', 'princesse', 'nabeul', 'non', 'oui', 'non', NULL, NULL, 'Situé à 1,6 km du musée Néapolis à Nabeul, le Princesse De La Mer Apartment est un appartement climatisé avec une connexion Wi-Fi gratuite et une terrasse Sa cuisine est équipée dun four ...'),
('regency_paris', 'regency', 'paris', 'non', 'oui', 'non', NULL, NULL, 'Le Hyatt Regency Paris Etoile, connu autrefois sous le nom dHotel Concorde La Fayette, vous accueille à 1,5 km de larc de triomphe et des célèbres Champs-Élysées.'),
('Amir', 'BenSlm', 'test', 'hahha', 'lol', 'mooul', 'poo', NULL, 'foul'),
('Amir', 'BenSlm', 'test', 'hahha', 'lol', 'mooul', 'poo', NULL, 'foul'),
('Amir_BenSlm', 'Amir', 'BenSlm', 'test', 'hahha', 'lol', 'foul', NULL, 'mooul'),
('OnsHotel_Somaa_OnsHotel', 'OnsHotel_Somaa', 'OnsHotel', 'Somaa', '5', 'lol', 'foul', NULL, 'mooul'),
('ajout_Sousse_ajout', 'ajout_Sousse', 'ajout', 'Sousse', '3 Etoiles', 'oui', 'oui', 'oui', 'hhahah');

-- --------------------------------------------------------

--
-- Structure de la table `reservation`
--

CREATE TABLE `reservation` (
  `id_reservation` varchar(45) DEFAULT NULL,
  `id_client` varchar(45) DEFAULT NULL,
  `room_type` varchar(45) DEFAULT NULL,
  `idHotel` varchar(45) DEFAULT NULL,
  `date_checkin` varchar(45) DEFAULT NULL,
  `date_checkout` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `reservation`
--

INSERT INTO `reservation` (`id_reservation`, `id_client`, `room_type`, `idHotel`, `date_checkin`, `date_checkout`) VALUES
('ss-69', 'Bayram', 'triple room', 'sultane_nabeul', '2017-05-03', '2017-05-05'),
('ss-70', 'Amine', 'Double room', 'liberty_monastir', '2017-05-11', '2017-05-13'),
('s-80', 'Marwen', 'Single room', 'movempick_sousse', '2017-05-13', '2017-05-15'),
('ss-81', 'id-001', 'Single room', 'kheops_nabeul', '2017-05-14', '2017-05-15'),
('ss-82', 'id-001', 'Double room', 'kheops_nabeul', '2017-05-14', '2017-05-15'),
('s-91', 'Saif', 'Double room', 'marhababeach_nabeul', '2017-05-19', '2017-05-23'),
('s-88', 'Bayram', 'Double room', 'movempick_sousse', '2017-05-10', '2017-05-19'),
('s-60', 'saif', 'Double room', 'sultane_nabeul', '2017-05-03', '2017-05-20'),
('s-61', 'Id-001', 'Single room', 'delfino_nabeul', '2017-05-03', '2017-05-06'),
('s-62', '09865-Mohamed', 'Double room', 'movempick_sousse', '2017-05-04', '2017-05-13'),
('s-63', 'Bayram', 'Double room', 'movempick_sousse', '2017-05-04', '2017-05-13'),
('s-64', 'Id-001', 'triple room', 'bizence_nabeul', '2017-05-03', '2017-05-04'),
('s-65', 'saif', 'Double room', 'kheops_nabeul', '2017-05-03', '2017-05-06'),
('s-66', 'Test', 'Double room', 'kheops_nabeul', '2017-05-05', '2017-05-20'),
('s-67', 'Test', 'Double room', 'sultane_nabeul', '2017-05-05', '2017-05-20');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
