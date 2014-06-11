-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tempo de Geração: 
-- Versão do Servidor: 5.5.27-log
-- Versão do PHP: 5.4.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `laudo_medico`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `combo`
--

CREATE TABLE IF NOT EXISTS `combo` (
  `id` int(1) NOT NULL AUTO_INCREMENT,
  `sigla` varchar(45) NOT NULL,
  `texto` text NOT NULL,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `convenio`
--

CREATE TABLE IF NOT EXISTS `convenio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `escore`
--

CREATE TABLE IF NOT EXISTS `escore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laudo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `laudo_id` (`laudo_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `esforco`
--

CREATE TABLE IF NOT EXISTS `esforco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pa` varchar(45) NOT NULL,
  `fc` varchar(45) NOT NULL,
  `eletrocardiograma` varchar(45) NOT NULL,
  `atropina` varchar(45) NOT NULL,
  `laudoEstresse_id` int(11) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `laudoEstresse_id` (`laudoEstresse_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `estresse`
--

CREATE TABLE IF NOT EXISTS `estresse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laudo_id` int(11) NOT NULL,
  `esv` tinyint(1) NOT NULL,
  `essv` tinyint(1) NOT NULL,
  `tvns` tinyint(1) NOT NULL,
  `tv` tinyint(1) NOT NULL,
  `fa` tinyint(1) NOT NULL,
  `bradicardia` tinyint(1) NOT NULL,
  `outro_arritmia` varchar(255) NOT NULL,
  `dor_precordial` tinyint(1) NOT NULL,
  `hipotensao` tinyint(1) NOT NULL,
  `hipertensao` tinyint(1) NOT NULL,
  `nauseas` tinyint(1) NOT NULL,
  `outro_efeito_colateral` varchar(255) NOT NULL,
  `texto` text,
  `isEco` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `laudo_id` (`laudo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `ireport`
--

CREATE TABLE IF NOT EXISTS `ireport` (
  `laudo_id` int(11) NOT NULL,
  `laudo_tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `laudo`
--

CREATE TABLE IF NOT EXISTS `laudo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(45) DEFAULT NULL,
  `tipocalc` varchar(45) DEFAULT NULL,
  `tipo` varchar(45) DEFAULT NULL,
  `peso` float DEFAULT NULL,
  `siv` float DEFAULT NULL,
  `ae` float DEFAULT NULL,
  `ddve` float DEFAULT NULL,
  `ddvd` float DEFAULT NULL,
  `altura` float DEFAULT NULL,
  `aorta` float DEFAULT NULL,
  `dsve` float DEFAULT NULL,
  `pp` float DEFAULT NULL,
  `vsf` float DEFAULT NULL,
  `vdf` float DEFAULT NULL,
  `enccav` float DEFAULT NULL,
  `indespessurarel` float DEFAULT NULL,
  `superficiecorporea` float DEFAULT NULL,
  `massa` float DEFAULT NULL,
  `indmassave` float DEFAULT NULL,
  `relae_ao` float DEFAULT NULL,
  `fe` float DEFAULT NULL,
  `texto` text NOT NULL,
  `paciente_id` int(11) NOT NULL,
  `medico_id` int(11) NOT NULL,
  `medico_nome` varchar(45) NOT NULL,
  `medico_crm` int(11) NOT NULL,
  `convenio_id` int(11) NOT NULL,
  `convenio_nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `paciente_id` (`paciente_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE IF NOT EXISTS `medico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `crm` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `crm_UNIQUE` (`crm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `medicoaux`
--

CREATE TABLE IF NOT EXISTS `medicoaux` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medico_id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `crm` int(11) NOT NULL,
  `status` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE IF NOT EXISTS `paciente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `datanasc` varchar(45) DEFAULT NULL,
  `cpf` varchar(45) DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `tel` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

-- --------------------------------------------------------

--
-- Estrutura da tabela `segmento`
--

CREATE TABLE IF NOT EXISTS `segmento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `repouso` double NOT NULL,
  `baixa_dose` double NOT NULL,
  `pico` double NOT NULL,
  `recuperacao` double NOT NULL,
  `laudoEscore_Id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `laudoEscore_Id` (`laudoEscore_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Restrições para as tabelas dumpadas
--

--
-- Restrições para a tabela `escore`
--
ALTER TABLE `escore`
  ADD CONSTRAINT `escore_ibfk_1` FOREIGN KEY (`laudo_id`) REFERENCES `laudo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `esforco`
--
ALTER TABLE `esforco`
  ADD CONSTRAINT `esforco_ibfk_1` FOREIGN KEY (`laudoEstresse_id`) REFERENCES `estresse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `estresse`
--
ALTER TABLE `estresse`
  ADD CONSTRAINT `estresse_ibfk_1` FOREIGN KEY (`laudo_id`) REFERENCES `laudo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Restrições para a tabela `laudo`
--
ALTER TABLE `laudo`
  ADD CONSTRAINT `laudo_ibfk_1` FOREIGN KEY (`paciente_id`) REFERENCES `paciente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
