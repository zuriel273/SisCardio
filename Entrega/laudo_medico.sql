-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 04/03/2013 às 22:24:13
-- Versão do Servidor: 5.5.27
-- Versão do PHP: 5.4.7

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
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=500 ;

--
-- Extraindo dados da tabela `combo`
--

INSERT INTO `combo` (`id`, `sigla`, `texto`, `tipo`) VALUES
(1, 'CCTN', 'Câmaras cardíacas de tamanhos normais.\r\n', 'camaras_cardiacas'),
(2, 'AAD0', 'Átrio direito com seus diâmetros nos limites superiores da normalidade.\r\n', 'camaras_cardiacas'),
(3, 'AAD1', 'Aumento discreto de átrio direito.\r\n', 'camaras_cardiacas'),
(4, 'AAD2', 'Aumento moderado de átrio direito.\r\n', 'camaras_cardiacas'),
(5, 'AAD3', 'Aumento importante de átrio direito.\r\n', 'camaras_cardiacas'),
(6, 'AAE0', 'Átrio esquerdo com seus diâmetros nos limites superiores da normalidade.\r\n', 'camaras_cardiacas'),
(7, 'AAE1', 'Aumento discreto de átrio esquerdo.\r\n', 'camaras_cardiacas'),
(8, 'AAE2', 'Aumento moderado de átrio esquerdo.\r\n', 'camaras_cardiacas'),
(9, 'AAE3', 'Aumento importante de átrio esquerdo.\r\n', 'camaras_cardiacas'),
(10, 'VAE', 'Volume do átrio esquerdo estimado em <x>ml/m² (VN<29ml/m²).\r\n', 'camaras_cardiacas'),
(11, 'AAE', 'Área do átrio esquerdo estimada em <x>cm².\r\n', 'camaras_cardiacas'),
(12, 'AADE1', 'Aumento discreto dos átrios direito e esquerdo.\r\n', 'camaras_cardiacas'),
(13, 'AADE2', 'Aumento moderado dos átrios direito e esquerdo.\r\n', 'camaras_cardiacas'),
(14, 'AADE3', 'Aumento importante dos átrios direito e esquerdo.\r\n', 'camaras_cardiacas'),
(15, 'ACOO', 'Câmaras direitas com seus diâmetros nos limites superiores da normalidade.\r\n', 'camaras_cardiacas'),
(16, 'ACD1', 'Aumento discreto de câmaras direitas.\r\n', 'camaras_cardiacas'),
(17, 'ACD2  ', 'Aumento moderado de câmaras direitas. \r\n', 'camaras_cardiacas'),
(18, 'ACD3 ', 'Aumento importante de câmaras direitas. \r\n', 'camaras_cardiacas'),
(19, 'ACEO ', 'Câmaras esquerdas com seus diâmetros nos limites superiores da normalidade. \r\n', 'camaras_cardiacas'),
(20, 'ACE1 ', 'Aumento discreto de câmaras esquerdas. \r\n', 'camaras_cardiacas'),
(21, 'ACE2 ', 'Aumento moderado de câmaras esquerdas. \r\n', 'camaras_cardiacas'),
(22, 'ACE3 ', 'Aumento importante de câmaras esquerdas. \r\n', 'camaras_cardiacas'),
(23, 'AVD0', 'Ventrículo direito com seus diâmetros nos limites superiores da normalidade. \r\n', 'camaras_cardiacas'),
(24, 'AVD1 ', 'Aumento discreto do ventrículo direito. \r\n', 'camaras_cardiacas'),
(25, 'AVD2 ', 'Aumento moderado do ventrículo direito. \r\n', 'camaras_cardiacas'),
(26, 'AVD3 ', 'Aumento importante do ventrículo direito. \r\n', 'camaras_cardiacas'),
(27, 'AVE0 ', 'Ventrículo esquerdo com seus diâmetros nos limites superiores da normalidade. \r\n', 'camaras_cardiacas'),
(28, 'AVE1 ', 'Aumento discreto do ventrículo esquerdo. \r\n', 'camaras_cardiacas'),
(29, 'AVE2 ', 'Aumento moderado do ventrículo esquerdo. \r\n', 'camaras_cardiacas'),
(30, 'AVE3 ', 'Aumento importante do ventrículo esquerdo. \r\n', 'camaras_cardiacas'),
(31, 'DCTN', 'Demais câmaras de tamanhos normais. \r\n', 'camaras_cardiacas'),
(35, 'RPN', 'Retorno aos padrões do repouso', 'analise_ve_na_recuperacao'),
(36, 'MN', 'Mobilidade normal dos 17 segmentos miocárdicos, não sendo observado alterações na mobilidade segmentar de parede em repouso', 'analise_ve_no_repouso'),
(37, 'DA', 'Com a infusão de dobutamina <x>mcg/Kg/min e atropina <x>mg a freqüência cardíaca atingida foi de <x> bpm (<x>  % da frequência cardíaca máxima predita para a idade). ', 'analise_ve_pico_do_estresse'),
(38, 'D', 'Com a infusão de dobutamina <x> mcg/Kg/min a freqüência cardíaca atingida foi de <x> bpm (<x> % da frequência cardíaca máxima predita para a idade). ', 'analise_ve_pico_do_estresse'),
(39, 'RH', 'Observada resposta hiperdinâmica dos 17 segmentos do ventrículo esquerdo durante o pico do estresse cardiaco, sem anormalidades segmentares da mobilidade', 'analise_ve_pico_do_estresse'),
(40, 'RHN', 'Observada resposta hiperdinâmica dos segmentos normais do ventrículo esquerdo durante o pico do estresse cardíaco.', 'analise_ve_pico_do_estresse'),
(41, 'SANG', 'Não houve referências a sintomas sugestivos de angina durante o exame.', 'analise_ve_pico_do_estresse'),
(42, 'INT', 'Exame interrompido por <x>.', 'analise_ve_pico_do_estresse'),
(43, 'PNR', 'Não foi observado defeito de perfusão em nenhum dos 17 segmentos do ventrículo esquerdo em repouso.', 'analise_ve_pico_do_estresse'),
(44, 'PNP', 'Não foi observado defeito de perfusão em nenhum dos 17 segmentos do ventrículo esquerdo no pico do estresse cardíaco. ', 'analise_ve_pico_do_estresse'),
(45, 'UCEB', 'Utilizado contraste ecocardiográfico à base de microbolhas para a melhor delimitação dos bordos do endocárdio e para a avaliação da perfusão miocárdica. ', 'analise_ve_pico_do_estresse'),
(46, 'UCEP', 'Utilizado contraste ecocardiográfico à base de microbolhas para avaliação da perfusão miocárdica. ', 'analise_ve_pico_do_estresse'),
(47, 'AONL', 'Seios aórticos, aorta ascendente, e arco aórtico com diâmetros e fluxo normais. ', 'aortaEarteria_pulmonar'),
(48, 'AOAPNL ', 'Seios aórticos, aorta ascendente, arco aórtico e artéria pulmonar sem alterações anatômicas significativas. ', 'aortaEarteria_pulmonar'),
(49, 'MEDAO ', 'Medidas da aorta: seios aórticos ( .. ) cm, junção sinotubular ( ... ) cm, aorta ascendente ( ... ) cm, arco aórtico ( ... ) cm. ', 'aortaEarteria_pulmonar'),
(50, 'ARCONL ', 'Arco aórtico sem anormalidades anatômicas. ', 'aortaEarteria_pulmonar'),
(51, 'ARCONV ', 'Arco aórtico não visibilizado. ', 'aortaEarteria_pulmonar'),
(52, 'ARCONA', 'Imagem do arco aórtico inadequada para análise. ', 'aortaEarteria_pulmonar'),
(53, 'ECRA01', 'Ectasia discreta dos seios aórticos. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(54, 'ECRA02 ', 'Ectasia moderada dos seios aórticos. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(55, 'ECRA03', 'Ectasia importante dos seios aórticos. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(56, 'ECAO1 ', 'Dilatação discreta de aorta ascendente. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(57, 'ECAO2 ', 'Dilatação moderada de aorta ascendente. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(58, 'ECAO3 ', 'Dilatação importante de aorta ascendente. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(59, 'ANEAO ', 'Aneurisma de aorta ascendente. ', 'aortaEarteria_pulmonar'),
(60, 'ERAASC', 'Ectasia <x> dos seios aórticos e <x> da aorta ascendente. Demais segmentos da aorta com diâmetros normais. ', 'aortaEarteria_pulmonar'),
(61, 'ATARCO ', 'Sinais sugestivos de placas de ateroma pequenas e esparsas na curvatura interna do arco aórtico. ', 'aortaEarteria_pulmonar'),
(62, 'AT1 ', 'Aorta com sinais de ateromatose discreta em <X>. ', 'aortaEarteria_pulmonar'),
(63, 'AT2 ', 'Aorta com sinais de ateromatose moderada em <X>. ', 'aortaEarteria_pulmonar'),
(64, 'AT3', 'Aorta com sinais de ateromatose importante em <x>. ', 'aortaEarteria_pulmonar'),
(65, 'AOOK', 'Aorta sem sinais de ateromatose significativa. ', 'aortaEarteria_pulmonar'),
(66, 'EEDAN', 'Ecocardiograma sob estresse pela dobutamina-atropina negativo para isquemia miocárdica. ', 'coclusao_do_estresse'),
(67, 'EEDN', 'Ecocardiograma sob estresse pela dobutamina negativo para isquemia miocárdica. ', 'coclusao_do_estresse'),
(68, 'EEDANV', 'Ecocardiograma sob estresse pela dobutamina-atropina negativo para viabilidade miocárdica.', 'coclusao_do_estresse'),
(69, 'EEDNV', 'Ecocardiograma sob estresse pela dobutamina negativo para viabilidade miocárdica. ', 'coclusao_do_estresse'),
(70, 'EEDAP', 'Ecocardiograma sob estresse pela dobutamina-atropina positivo para a presença de isquemia miocárdica em parede (s) <X>. ', 'coclusao_do_estresse'),
(71, 'EEDP', 'Ecocardiograma sob estresse pela dobutamina positivo para a presença de isquemia miocárdica em parede (s) <X>. ', 'coclusao_do_estresse'),
(72, 'EEDAPIV', 'Ecocardiograma sob estresse pela dobutamina-atropina positivo para a presença de isquemia e viabilidade em parede (s) <X>. ', 'coclusao_do_estresse'),
(73, 'EEDPOSMV', 'Ecocardiograma sob estresse pela dobutamina positivo para a presença de miocárdio viável em parede (s)<x>. ', 'coclusao_do_estresse'),
(74, 'EEDAI', 'Ecocardiograma sob estresse pela dobutamina-atropina ineficaz para pesquisa de isquemia miocárdica. ', 'coclusao_do_estresse'),
(75, 'EEDI', 'Ecocardiograma sob estresse pela dobutamina ineficaz para pesquisa de isquemia miocárdica. ', 'coclusao_do_estresse'),
(76, 'PNL', 'Ausência de defeitos de perfusão no ventrículo esquerdo.', 'coclusao_do_estresse'),
(77, 'EN ', 'Ecocardiograma bidimensional com Doppler e mapeamento com fluxo em cores dentro dos limites da normalidade para a faixa etária e biotipo. ', 'conclusao'),
(78, 'ADAVS ', 'Ausência de dissincronia atrioventricular significativa. ', 'conclusao'),
(79, 'ADVS ', 'Ausência de dissincronia interventricular significativa. ', 'conclusao'),
(80, 'ADIVS ', 'Ausência de dissincronia intraventricular esquerda significativa. ', 'conclusao'),
(81, 'ADCS ', 'Ausência de dissincronia cardíaca significativa. ', 'conclusao'),
(82, 'CDM1', 'Comprometimento difuso do miocárdio de grau discreto. ', 'conclusao'),
(83, 'CDM2 ', 'Comprometimento difuso do miocárdio de grau moderado. ', 'conclusao'),
(84, 'CDM3 ', 'Comprometimento difuso do miocárdio de grau importante. ', 'conclusao'),
(85, 'CH ', 'Cardiomiopatia hipertrófica. ', 'conclusao'),
(86, 'CHNO ', 'Cardiomiopatia hipertrófica não obstrutiva. ', 'conclusao'),
(87, 'CHA ', 'Cardiomiopatia hipertrófica apical. ', 'conclusao'),
(88, 'CHO0 ', 'Cardiomiopatia hipertrófica assimétrica sem sinais de obstrução à via de saída do ventrículo esquerdo. ', 'conclusao'),
(89, 'CHO1 ', 'Cardiomiopatia hipertrófica assimétrica  com discreto grau de obstrução na via de saída do ventrículo esquerdo.', 'conclusao'),
(90, 'CHO2 ', 'Cardiomiopatia hipertrófica assimétrica com moderado grau de obstrução na via de saída do ventrículo esquerdo. ', 'conclusao'),
(91, 'CHO3 ', 'Cardiomiopatia hipertrófica assimétrica forma obstrutiva com importante grau de obstrução à via de saída do ventrículo esquerdo. ', 'conclusao'),
(92, 'CSM ', 'Comprometimento miocárdico segmentar do ventrículo esquerdo. ', 'conclusao'),
(93, 'CSM1 ', 'Comprometimento miocárdico segmentar do ventrículo esquerdo com disfunção sistólica discreta. ', 'conclusao'),
(94, 'CSM2 ', 'Comprometimento miocárdico segmentar do ventrículo esquerdo com disfunção sistólica moderada. ', 'conclusao'),
(95, 'CSM3 ', 'Comprometimento miocárdico segmentar do ventrículo esquerdo com disfunção sistólica importante. ', 'conclusao'),
(96, 'DDVE1 ', 'Disfunção diastólica do ventrículo esquerdo grau 1. ', 'conclusao'),
(97, 'DDVE2 ', 'Disfunção diastólica do ventrículo esquerdo grau 2. ', 'conclusao'),
(98, 'DDVE3 ', 'Disfunção diastólica do ventrículo esquerdo grau 3. ', 'conclusao'),
(99, 'DOVE4 ', 'Disfunção diastólica do ventrículo esquerdo grau 4. ', 'conclusao'),
(100, 'DLAO1 ', 'Dupla lesão aórtica de grau discreto. ', 'conclusao'),
(101, 'DLAO2 ', 'Dupla lesão aórtica de grau moderado. ', 'conclusao'),
(102, 'DLAO3 ', 'Dupla lesão aórtica de grau importante. ', 'conclusao'),
(103, 'DLAOG ', 'Dupla lesão aórtica. ', 'conclusao'),
(104, 'DLM ', 'Dupla lesão mitral. ', 'conclusao'),
(105, 'DLM1 ', 'Dupla lesão mitral de grau discreto. ', 'conclusao'),
(106, 'DLM2', 'Dupla lesão mitral de grau moderado. ', 'conclusao'),
(107, 'DLM3 ', 'Dupla lesão mitral de grau importante. ', 'conclusao'),
(108, 'DLP1 ', 'Dupla lesão pulmonar de grau discreto. ', 'conclusao'),
(109, 'DLP2 ', 'Dupla lesão pulmonar de grau moderado. ', 'conclusao'),
(110, 'DLP3 ', 'Dupla lesão pulmonar de grau importante. ', 'conclusao'),
(111, 'DLT1 ', 'Dupla lesão tricúspide de grau discreto. ', 'conclusao'),
(112, 'DLT2 ', 'Dupla lesão tricúspide de grau moderado. ', 'conclusao'),
(113, 'DLT3 ', 'Dupla lesão tricúspide de grau importante. ', 'conclusao'),
(114, 'DP ', 'Derrame pericárdico. ', 'conclusao'),
(115, 'DP1', 'Derrame pericárdico de grau discreto. ', 'conclusao'),
(116, 'DP2', 'Derrame pericárdio de grau moderado', 'conclusao'),
(117, 'DP3', 'Derrame pericárdico de grau importante. ', 'conclusao'),
(118, 'EAO ', 'Estenose aórtica. ', 'conclusao'),
(119, 'EAO1 ', 'Estenose aórtica de grau discreto. ', 'conclusao'),
(120, 'EAO2 ', 'Estenose aórtica de grau moderado. ', 'conclusao'),
(121, 'EAO3 ', 'Estenose aórtica de grau importante. ', 'conclusao'),
(122, 'ECAOR1 ', 'Ectasia discreta de aorta ascendente ', 'conclusao'),
(123, 'ECAOR2 ', 'Ectasia moderada de aorta ascendente ', 'conclusao'),
(124, 'ECAOR3 ', 'Ectasia importante de aorta ascendente ', 'conclusao'),
(125, 'ECAO', 'Ectasia de aorta ascendente. ', 'conclusao'),
(126, 'EMl ', 'Estenose mitral. ', 'conclusao'),
(127, 'EMl1 ', 'Estenose mitral de grau discreto. ', 'conclusao'),
(128, 'EMI2 ', 'Estenose mitral de grau moderado. ', 'conclusao'),
(129, 'EMI3', 'Estenose mitral de grau importante. ', 'conclusao'),
(130, 'ETR1 ', 'Estenose tricúspide de grau discreto. ', 'conclusao'),
(131, 'ETR2 ', 'Estenose tricúspide de grau moderado. ', 'conclusao'),
(132, 'ETR3 ', 'Estenose tricúspide de grau importante. ', 'conclusao'),
(133, 'HCVE1 ', 'Hipertrofia concêntrica do ventrículo esquerdo de grau discreto. ', 'conclusao'),
(134, 'HCVE2 ', 'Hipertrofia concêntrica do ventrículo esquerdo de grau moderado. ', 'conclusao'),
(135, 'HCVE3 ', 'Hipertrofia concêntrica do ventrículo esquerdo de grau importante. ', 'conclusao'),
(136, 'HP1 ', 'Hipertensão arterial pulmonar de grau discreto. ', 'conclusao'),
(137, 'HP2 ', 'Hipertensão arterial pulmonar de grau moderado. ', 'conclusao'),
(138, 'HP3 ', 'Hipertensão arterial pulmonar de grau importante. ', 'conclusao'),
(139, 'HPG ', 'Hipertensão arterial pulmonar. ', 'conclusao'),
(140, 'IAOR ', 'Insuficiência aórtica. ', 'conclusao'),
(141, 'IAOR1', 'Insuficiência aórtica de grau discreto. ', 'conclusao'),
(142, 'IAOR2', 'Insuficiência aórtica de grau moderado. ', 'conclusao'),
(143, 'IAOR3', 'Insuficiência aórtica de grau importante. ', 'conclusao'),
(144, 'IMl ', 'Insuficiência mitral. ', 'conclusao'),
(145, 'IM1', 'Insuficiência mitral de grau discreto. ', 'conclusao'),
(146, 'IM2 ', 'Insuficiência mitral de grau moderado. ', 'conclusao'),
(147, 'IM3', 'Insuficiência mitral de grau importante. ', 'conclusao'),
(148, 'IPUL1 ', 'Insuficiência pulmonar de grau discreto. ', 'conclusao'),
(149, 'IPUL2 ', 'Insuficiência pulmonar de grau moderado. ', 'conclusao'),
(150, 'IPUL3 ', 'Insuficiência pulmonar de grau importante. ', 'conclusao'),
(151, 'ITR1 ', 'Insuficiência tricúspide de grau discreto. ', 'conclusao'),
(152, 'ITR2 ', 'Insuficiência tricúspide de grau moderado. ', 'conclusao'),
(153, 'ITR3 ', 'Insuficiência tricúspide de grau importante. ', 'conclusao'),
(154, 'PBAD1 ', 'Prótese biológica em posição aórtica com discreto grau de disfunção. ', 'conclusao'),
(155, 'PBAD2 ', 'Prótese biológica em posição aórtica com moderado grau de disfunção. ', 'conclusao'),
(156, 'PBAD3 ', 'Prótese biológica em posição aórtica com importante grau de disfunção. ', 'conclusao'),
(157, 'PBAOK ', 'Prótese biológica em posição aórtica sem sinais de disfunção. ', 'conclusao'),
(158, 'PBMD1 ', 'Prótese biológica em posição mitral com discreto grau de disfunção. ', 'conclusao'),
(159, 'PBMD2 ', 'Prótese biológica em posição mitral com moderado grau de disfunção. ', 'conclusao'),
(160, 'PBMD3 ', 'Prótese biológica em posição mitral com importante grau de disfunção. ', 'conclusao'),
(161, 'PBMOK ', 'Prótese biológica em posição mitral sem sinais de disfunção. ', 'conclusao'),
(162, 'PCVM ', 'Prolapso competente de valva mitral. ', 'conclusao'),
(163, 'PDAVS ', 'Presença de dissincronia atrioventricular significativa. ', 'conclusao'),
(164, 'PDVS ', 'Presença de dissincronia ventricular esquerda significativa. ', 'conclusao'),
(165, 'PIVM ', 'Prolapso incompetente de valva mitral. ', 'conclusao'),
(166, 'PMAD1', 'Prótese mecânica em posição aórtica com discreto grau de disfunção. ', 'conclusao'),
(167, 'PMAD2 ', 'Prótese mecaruca em posição aórtica com moderado grau de disfunção. ', 'conclusao'),
(168, 'PMAD3 ', 'Prótese mecânica em posição aórtica com importante grau de disfunção. ', 'conclusao'),
(169, 'PMAOK ', 'Prótese mecânica em posição aórtica sem sinais de disfunção. ', 'conclusao'),
(170, 'PMMD1 ', 'Prótese mecânica em posição mitral com discreto grau de disfunção. ', 'conclusao'),
(171, 'PMMD2 ', 'Prótese mecaruca em posição mitral com moderado grau de disfunção. ', 'conclusao'),
(172, 'PMMD3 ', 'Prótese mecânica em posição mitral com importante grau de disfunção. ', 'conclusao'),
(173, 'PMMOK', 'Prótese mecânica em posição mitral sem sinais de disfunção. ', 'conclusao'),
(174, 'PVM', 'Prolapso de valva mitral.', 'conclusao'),
(175, 'PVT', 'Prolapso de valva tricúspide.', 'conclusao'),
(176, 'TIC', 'Trombo intracavitário.', 'conclusao'),
(177, 'VAB', 'Valva aórtica bivalvular.', 'conclusao'),
(178, 'LETT', 'Não foi possível avaliar <x> adequadamente pelo ecocardiograma transtorácico. ', 'observações'),
(179, 'SETE', 'A critério clinico sugerimos estudo transesofágico devido a <x> . ', 'observações'),
(180, 'EDT', 'Exame de difícil realização técnica. ', 'observações'),
(181, 'EAC ', 'Exame realizado na presença de arritmia cardíaca. ', 'observações'),
(182, 'EBLDT ', 'Exame realizado na beira do leito, com dificuldades técnicas. ', 'observações'),
(183, 'EBLU ', 'Exame realizado na beira do leito, em caráter de urgência. ', 'observações'),
(184, 'VM', 'Paciente sob ventilação mecânica. ', 'observações'),
(185, 'DVAT ', 'Paciente em uso de drogas vasoativas. ', 'observações'),
(186, 'CI ', 'Achados consistentes com "coração do idoso". ', 'observações'),
(187, 'CA ', 'Achados consistentes com "coração do atleta". ', 'observações'),
(188, 'DIDOSO', 'Os achados do Doppler são compatíveis com padrão da função diastólica do ventrículo esquerdo normal para a idade. ', 'observações'),
(189, 'FOP ', 'Septo atrial com fluxo transeptal mínimo na região da fossa oval, do átrio esquerdo para o direito, sugestivo de forame oval patente. ', 'observações'),
(190, 'AHP ', 'Ausência de sinais de hipertensão pulmonar. ', 'observações'),
(191, 'AHPSM', 'Ausência de sinais de hipertensão pulmonar. Pressão sistólica máxima em artéria pulmonar estimada em <x> mmHg (VN< 30 mmHg). ', 'observações'),
(192, 'PSAP ', 'Pressão sistólica em artéria pulmonar estimada em <x> mmHg (VN< 30 mmHg). ', 'observações'),
(193, 'PMAP ', 'Pressão média em artéria pulmonar estimada em <x> mmHg (VN< 20 mmHg). ', 'observações'),
(194, 'PDAP ', 'Pressão diastólica em artéria pulmonar estimada em <x> mmHg (VN< 14 mmHg). ', 'observações'),
(195, 'AVEG ', 'Ausência de imagens sugestivas de vegetações ao ecocardiograma transtorácico. ', 'observações'),
(196, 'ATICC ', 'Ausência de imagens sugestivas de trombos intracavitários ao ecocardiograma transtorácico. ', 'observações'),
(197, 'CONT ', 'Contraste ecocardiográfico foi injetado por via venosa para melhora do delineamento dos bordos endocárdicos e opacificação do ventrículo esquerdo. ', 'observações'),
(198, 'CEP ', 'Comparado ao exame de <x> observa-se <x>. ', 'observações'),
(199, 'ESV', 'Exame sem variações expressivas em relação ao de <x>. ', 'observações'),
(200, 'PN', 'Pericárdio com aspecto ecocardiográfico normal. ', 'pericardio'),
(201, 'OP0', 'Pericárdio com espessura normal e aumento mínimo do líquido, sem características patológicas. ', 'pericardio'),
(202, 'OP1', 'Derrame pericárdico discreto. ', 'pericardio'),
(203, 'OP2', 'Derrame pericárdico moderado. ', 'pericardio'),
(204, 'OP3 ', 'Derrame pericárdico importante. ', 'pericardio'),
(205, 'EPSO ', 'Pericárdio com espessamento <x>, sem sinais de derrame. ', 'pericardio'),
(206, 'EPCO ', 'Pericárdio com espessamento <X>, e derrame pericárdico <X>. ', 'pericardio'),
(207, 'SREV ', 'Ausência de sinais de restrição ao enchimento ventricular. ', 'pericardio'),
(208, 'REV ', 'Sinais sugestivos de restrição ao enchimento ventricular. ', 'pericardio'),
(209, 'OPF ', 'Derrame pericárdico com aspecto de fibrina em seu conteúdo. ', 'pericardio'),
(210, 'OC', 'Estudo Doppler sugestivo de fisiologia constrictiva. ', 'pericardio'),
(211, 'OPLE ', 'Observado derrame pleural esquerdo. ', 'pericardio'),
(212, 'DPP1 ', 'Derrame pericárdico posterior de grau discreto. ', 'pericardio'),
(213, 'DPP2 ', 'Derrame pericárdico posterior de grau moderado. ', 'pericardio'),
(214, 'DPP3 ', 'Derrame pericárdico posterior de grau importante. ', 'pericardio'),
(215, 'CIAOP ', 'Septo atrial apresenta descontinuidade na região do septo primo de aproximadamente <x> mm de diâmetro, com fluxo do átrio esquerdo para o direito. ', 'septos'),
(216, 'CIAOS ', 'Septo atrial apresenta descontinuidade na região da fossa oval de aproximadamente <x> mm de diâmetro, com fluxo do átrio esquerdo para o direito. ', 'septos'),
(217, 'CIASV ', 'Septo atrial apresenta descontinuidade na região do seio venoso de aproximadamente <x> mm de diâmetro, com fluxo do átrio esquerdo para o direito. ', 'septos'),
(218, 'CIVMA ', 'Septo ventricular apresenta descontinuidade na reqiao do septo muscular próximo ao ápice ventricular de aproximadamente <x> mm de diâmetro, com fluxo do ventrículo esquerdo para o direito. ', 'septos'),
(219, 'CIVMM ', 'Septo ventricular apresenta descontinuidade na reqiao do septo muscular em sua porção média de aproximadamente <x> mm de diâmetro, com fluxo do ventrículo esquerdo para o direito. ', 'septos'),
(220, 'CIVPMVE ', 'Septo ventricular apresenta descontinuidade do septo membranoso, próximo da via de entrada do ventrículo direito, de aproximadamente <x> mm de diâmetro. ', 'septos'),
(221, 'CIVPMVS ', 'Septo ventricular apresenta descontinuidade na região do septo membranoso, próximo da via de saída do ventrículo direito de aproximadamente <x> mm de diâmetro. ', 'septos'),
(222, 'EDED ', 'Estudo Doppler demonstra fluxo preferencial esquerda-direita com Qp/Qs calculado em <x>. ', 'septos'),
(223, 'SAS ', 'Solução de salina agitada foi injetada por via venosa para auxiliar na identificação fluxo transeptal atrial. ', 'septos'),
(224, 'SIA ', 'Septo atrial integro. ', 'septos'),
(225, 'FOPS ', 'Septo atrial com fluxo transeptal mínimo na região da fossa oval, do átrio esquerdo para o direito, sugestivo de forame oval patente. ', 'septos'),
(226, 'DVPN', 'Drenagem das veias pulmonares normal. ', 'septos'),
(227, 'ATA', 'Ausência de imagens de trombos em átrios e respectivos apêndices. ', 'trombosEmassas'),
(228, 'ATIC', 'Não visibilizados trombos ou massas intracavitárias. ', 'trombosEmassas'),
(229, 'AISTIC', 'Ausência de imagens de trombos ou massas intracavitárias. ', 'trombosEmassas'),
(230, 'ACE', 'Ausência de sinais de contraste espontâneo.', 'trombosEmassas'),
(231, 'CE', 'Sinais de contraste espontâneo no <X>. ', 'trombosEmassas'),
(232, 'AAEDN', 'Apêndice atrial esquerdo com dinâmica contrátil normal.', 'trombosEmassas'),
(233, 'AAEDD', 'Apêndice atrial esquerdo com dinâmica contrátil diminuída.', 'trombosEmassas'),
(234, 'AVEGT', 'Ausência de imagens sugestivas de vegetações. ', 'trombosEmassas'),
(235, 'VAN ', 'Apresenta aspecto e movimentação normais de suas válvulas. ', 'valva_aortica'),
(236, 'EDNA ', 'O estudo Doppler e mapeamento com fluxo em cores são normais. ', 'valva_aortica'),
(237, 'VABSD ', 'Valva aórtica bivalvularizada, sem disfunção. ', 'valva_aortica'),
(238, 'VABRM ', 'Valva aórtica bivalvularizada, sem redução da mobilidade. ', 'valva_aortica'),
(239, 'VAOE ', 'Apresenta movimentação normal e espessamento <x> de suas válvulas. ', 'valva_aortica'),
(240, 'FCX ', 'Apresenta sinais de fibrocalcificação <x>, com mobilidade <x> de suas válvulas. ', 'valva_aortica'),
(241, 'FCO ', 'Apresenta sinais de fibrocalcificação mínima, com mobilidade preservada de suas válvulas. ', 'valva_aortica'),
(242, 'FC1', 'Apresenta sinais de fibrocalcificação discreta, com mobilidade preservada de suas válvulas. ', 'valva_aortica'),
(243, 'FC2', 'Apresenta sinais de fibrocalcificação moderada, com mobilidade preservada de suas válvulas. ', 'valva_aortica'),
(244, 'EAORO ', 'Apresenta sinais de fibrocalcificação mínima, com redução da mobilidade de suas válvulas. ', 'valva_aortica'),
(245, 'EAOR1 ', 'Apresenta sinais de fibrocalcificação discreta, com redução da mobilidade de suas válvulas. ', 'valva_aortica'),
(246, 'EAOR2 ', 'Apresenta sinais de fibrocalcificação moderada com redução da mobilidade de suas válvulas ', 'valva_aortica'),
(247, 'EAOR3 ', 'Apresenta sinais de fibrocalcificação importante com redução da mobilidade de suas válvulas. ', 'valva_aortica'),
(248, 'GRADA ', 'Gradiente sistólico máximo VE-Ao estimado em <x> mmHg e médio em <x> mmHg. ', 'valva_aortica'),
(249, 'GRADMA ', 'Gradiente sistólico médio VE-Ao estimado em <x> mmHg. ', 'valva_aortica'),
(250, 'AVA ', 'Área valvar estimada em <x> cm². ', 'valva_aortica'),
(251, 'JAOSR', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo, sem repercussão hemodinâmica. ', 'valva_aortica'),
(252, 'IAO0 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo. ', 'valva_aortica'),
(253, 'IAO1 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau discreto. ', 'valva_aortica'),
(254, 'IA02 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau moderado. ', 'valva_aortica'),
(255, 'IAO3 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau importante. ', 'valva_aortica'),
(256, 'AORVRA ', 'Área do orifício regurgitante estimada em <x> cm² e volume regurgitante em <x> ml/bat. ', 'valva_aortica'),
(257, 'PVAO ', 'Apresenta espessamento <x> e prolapso da válvula <x>. ', 'valva_aortica'),
(258, 'VCA ', 'Vena contracta estimada em <x> mm. ', 'valva_aortica'),
(259, 'PBAN ', 'Prótese biológica sem alterações estruturais e mobilidade preservada. ', 'valva_aortica'),
(260, 'PBAE ', 'Prótese biológica apresentando espessamento dos seus folhetos, sem alteração funcioanl ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(261, 'PBAEE ', 'Prótese biológica apresentando espessamento e redução da mobilidade dos seus folhetos. ', 'valva_aortica'),
(262, 'PBAC ', 'Prótese biológica apresentando calcificação e redução da mobilidade dos seus folhetos. ', 'valva_aortica'),
(263, 'PBAICO ', 'Prótese biológica com espessamento dos seus folhetos e rmrurna regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(264, 'PBAIC1 ', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(265, 'PBAIC2 ', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(266, 'PBAIC3 ', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(267, 'PBAIPVO', 'Prótese biológica com espessamento dos seus folhetos e mínima regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(268, 'PBAIPV1', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(269, 'PBAIPV2 ', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(270, 'PBAIPV3 ', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(271, 'PBROT AA', 'Prótese biológica com espessamento e imagem sugestiva de ruptura de folheto <x>. ', 'valva_aortica'),
(272, 'PBVEGA ', 'Prótese biológica com imagem ecodensa compatível com vegetação. ', 'valva_aortica'),
(273, 'PBVEGXA', 'Prótese biológica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_aortica'),
(274, 'PBVEGPA ', 'Prótese biológica aumento da ecogenicidade difusa dos folhetos compatível com vegetação tipo "panus". ', 'valva_aortica'),
(275, 'PBABA ', 'Prótese biológica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_aortica'),
(276, 'PMNA ', 'Prótese mecamcasem alterações estruturais e mobilidade preservada. ', 'valva_aortica'),
(277, 'PMTA', 'Prótese mecânica apresentando redução da mobilidade de seus elementos e sinais de trombose. ', 'valva_aortica'),
(278, 'PMAICO', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação central ao Doppler e mapeamento de fluxo em cores (refluxo fisiológico). ', 'valva_aortica'),
(279, 'PMAIC1', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(280, 'PMAIC2', 'Prótese rnecarnca com mobilidade normal de seus elementos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(281, 'PMAIC3 ', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(282, 'PMAIPVO', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(283, 'PMAIPV1 ', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(284, 'PMAIPV2', 'Prótese mecânica com mobilidade normal de seus elementos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(285, 'PMAIPV3', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_aortica'),
(286, 'PMAVEG', 'Prótese mecânica com imagem ecodensa compatível com  vegetação', 'valva_aortica'),
(287, 'PMAVEGX', 'Prótese mecânica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_aortica'),
(288, 'PMAAB', 'Prótese mecânica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_aortica'),
(289, 'VACO', 'Apresenta mobilidade preservada e mínima calcificação e espessamento de seu anel e válvulas.', 'valva_aortica'),
(290, 'VACE1', 'Apresenta mobilidade preservada e discreta calcificação e espessamento de seu anel e válvulas.', 'valva_aortica'),
(291, 'VACE2', 'Apresenta mobilidade preservada e moderada calcificação e espessamento de seu anel e válvulas.', 'valva_aortica'),
(292, 'VACE3', 'Apresenta mobilidade preservada e importante calcificação e espessamento de seu anel e válvulas.', 'valva_aortica'),
(294, 'VMN ', 'Apresenta aspecto e movimentação normais de suas cúspides. ', 'valva_mitral'),
(295, 'EDNM ', 'Estudo Doppler e mapeamento com fluxo em cores são normais. ', 'valva_mitral'),
(296, 'CAO ', 'Calcificação do anel valvar de grau mínimo. ', 'valva_mitral'),
(297, 'CA1 ', 'Calcificação do anel valvar de grau discreto. ', 'valva_mitral'),
(298, 'CA2 ', 'Calcificação do anel valvar de grau moderado. ', 'valva_mitral'),
(299, 'CA3 ', 'Calcificação do anel valvar de grau importante. ', 'valva_mitral'),
(300, 'CA3RA ', 'Calcificação do anel valvar de grau importante, com redução da abertura valvar. ', 'valva_mitral'),
(301, 'PCA ', 'Apresenta pontos de calcificação no anel valvar. ', 'valva_mitral'),
(302, 'PCASV ', 'Apresenta pontos de calcificação no anel e aparelho subvalvar. ', 'valva_mitral'),
(303, 'DMP ', 'Apresenta boa mobilidade e sínais indiretos de disfunção de musculatura papilar. ', 'valva_mitral'),
(304, 'EMO ', 'Apresenta fusão comissural e espessamento de suas cúspides compatíveis com comprometimento reumático mínimo. ', 'valva_mitral'),
(305, 'EM1 ', 'Apresenta fusão comissural, espessamento de suas cúspides e redução da abertura valvar compatíveis com comprometimento reumático discreto. ', 'valva_mitral'),
(306, 'EM2 ', 'Apresenta fusão comissural, espessamento de suas cúspides e redução da abertura valvar compatíveis com comprometimento reumático moderado. ', 'valva_mitral'),
(307, 'EM3', 'Apresenta fusão comissural, espessamento de suas cúspides e redução da abertura valvar compatíveis com comprometimento reumático importante. ', 'valva_mitral'),
(308, 'GRADM ', 'Gradiente diastólico máximo AE-VE estimado em <x> mmHg e médio em <x> mmHg. ', 'valva_mitral'),
(309, 'GRADMM ', 'Gradiente diastólico médio AE-VE estimado em <x> mmHg. ', 'valva_mitral'),
(310, 'AVM ', 'Area valvar estimada em <x> cm². ', 'valva_mitral'),
(311, 'EW ', 'Escore ecocardiográfico de Wilkins: <x> (espessamento: <x>, calcificação: <x>, mobilidade: <x>, aparelho subvalvar: <x> ). ', 'valva_mitral'),
(312, 'IMSR ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo, sem características patológicas, e sem repercussão hemodinâmica. ', 'valva_mitral'),
(313, 'IMO ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo. ', 'valva_mitral'),
(314, 'IM1 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau discreto. ', 'valva_mitral'),
(315, '1M2 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau moderado. ', 'valva_mitral'),
(316, '1M3 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau importante. ', 'valva_mitral'),
(317, 'AOR ', 'Área do orifício regurgítante estimada em <x> cm². ', 'valva_mitral'),
(318, 'AORVRM ', 'Área ao orifício regurgitante estimada em <x> cm2 e volume regurgitante em <x> ml/bat. ', 'valva_mitral'),
(319, 'VCM', 'Vena contracta estimada em <x> mm. ', 'valva_mitral'),
(320, 'MSA ', 'Apresenta boa abertura e movimento sistólico anterior da cúspide anterior. ', 'valva_mitral'),
(321, 'APVM ', 'Ausência de sinais de prolapso da valva mitral. ', 'valva_mitral'),
(322, 'DPSPVM ', 'Apresenta deslocamento sistólico rrurumo da cúspide posterior em direção ao átrio esquerdo, sem preencher critérios diagnósticos de prolapso. ', 'valva_mitral'),
(323, 'DASPVM ', 'Apresenta deslocamento sistólico rrurumo da cúspide anterior em direção ao átrio esquerdo, sem preencher critérios diagnósticos de prolapso. ', 'valva_mitral'),
(324, 'MEG', 'Apresenta megalacínea da cúspide anterior e redundância de cordas tendíneas. ', 'valva_mitral'),
(325, 'PVMM ', 'Apresenta espessamento <x> e prolapso de ambas as cúspides. ', 'valva_mitral'),
(326, 'PVMA ', 'Apresenta espessamento <x> e prolapso da cúspide anterior. ', 'valva_mitral'),
(327, 'PVMP ', 'Apresenta espessamento <x> e prolapso da cúspide posterior. ', 'valva_mitral'),
(328, 'ROTA ', 'Sinais sugestivos de ruptura de cordas da cúspide anterior. ', 'valva_mitral'),
(329, 'ROTP ', 'Sinais sugestivos de ruptura de cordas da cúspide posterior. ', 'valva_mitral'),
(330, 'MNEX ', 'Apresenta movimentação normal e espessamento <x> de suas cúspides. ', 'valva_mitral'),
(331, 'MNEXA ', 'Apresenta movimentação normal e espessamento <x> de sua cúspide anterior. ', 'valva_mitral'),
(332, 'MXEXP ', 'Apresenta movimentação normal e espessamento <x> de sua cúspide posterior. ', 'valva_mitral'),
(333, 'PBMN ', 'Prótese biológica sem alterações estruturais e mobilidade preservada, ', 'valva_mitral'),
(334, 'PBME ', 'Prótese biológica apresentando espessamento dos seus folhetos, sem alteração funcioanl ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(335, 'PBMEE ', 'Prótese biológica apresentando espessamento e redução da mobilidade dos seus folhetos. ', 'valva_mitral'),
(336, 'PBMC ', 'Prótese biológica apresentando calcificação e redução da mobilidade dos seus folhetos. ', 'valva_mitral'),
(337, 'PBMICO ', 'Prótese biológica com espessamento dos seus folhetos e rrururna regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(338, 'PBMIC1 ', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(339, 'PBMIC2 ', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(340, 'PBMIC3', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(341, 'PBMIPVO ', 'Prótese biológica com espessamento dos seus folhetos e rrururna regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(342, 'PBMIPV1 ', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(343, 'PBMIPV2 ', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(344, 'PBMIPV3 ', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(345, 'PBROTAM', 'Prótese biológica com espessamento e imagem sugestiva de ruptura de folheto <x>. ', 'valva_mitral'),
(346, 'PBVEGM', 'Prótese biológica com imagem ecodensa compatível com vegetação. ', 'valva_mitral'),
(347, 'PBVEGXM', 'Prótese biológica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_mitral'),
(348, 'PBVEGPM ', 'Prótese biológica aumento da ecogenicidade difusa dos folhetos compatível com vegetação tipo "panus". ', 'valva_mitral'),
(349, 'PBABM', 'Prótese biológica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_mitral'),
(350, 'PMNM', 'Prótese mecânica sem alterações estruturais e mobilidade preservada. ', 'valva_mitral'),
(351, 'PMTM', 'Prótese mecânica apresentando redução da mobilidade de seus elementos e sinais de trombose. ', 'valva_mitral'),
(352, 'PMMICO', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação central ao Doppler e mapeamento de fluxo em cores (refluxo fisiológico). ', 'valva_mitral'),
(353, 'PMMIC1 ', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(354, 'PMMIC2 ', 'Prótese mecânica com mobilidade normal de seus elementos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(355, 'PMMIC3 ', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(356, 'PMMIPVO ', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(357, 'PMMIPV1', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(358, 'PMMIPV2 ', 'Prótese mecânica com mobilidade normal de seus elementos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(359, 'PMMIPV3 ', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_mitral'),
(360, 'PMMVEG ', 'Prótese mecânica com imagem ecodensa compatível com vegetação. ', 'valva_mitral'),
(361, 'PMMVEGX', 'Prótese mecânica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_mitral'),
(362, 'PMMAB ', 'Prótese mecânica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_mitral'),
(363, 'VMC1', 'Apresenta mobilidade preservada e discreta calcificação e espessamento de seu anel e cúspides. ', 'valva_mitral'),
(364, 'VMC2', 'Apresenta mobilidade preservada e moderada calcificação e espessamento de seu anel e cúspides. ', 'valva_mitral'),
(365, 'VMC3 ', 'Apresenta mobilidade reduzida e importante calcificação e espessamento de seu anel e cúspides. ', 'valva_mitral'),
(366, 'VMCP ', 'Apresenta movimentação e espessura normais e coaptação sistolica plana de suas cúspides. ', 'valva_mitral'),
(367, 'VPN ', 'Apresenta aspecto e movimentação normais de suas válvulas. ', 'valva_pulmonar'),
(368, 'EDNP ', 'O estudo Doppler e mapeamento com fluxo em cores são normais. ', 'valva_pulmonar'),
(369, 'C0', 'Demonstra mirumo grau de calcificação de suas válvulas com diminuição de sua abertura. ', 'valva_pulmonar'),
(370, 'C1 ', 'Demonstra discreto grau calcificação de suas válvulas com diminuição de sua abertura. ', 'valva_pulmonar'),
(371, 'C2 ', 'Demonstra moderado grau de calcificação de suas válvulas com diminuição de sua abertura. ', 'valva_pulmonar'),
(372, 'C3 ', 'Demonstra importante grau de calcificação de suas válvulas com diminuição de sua abertura. ', 'valva_pulmonar'),
(373, 'EXMXP ', 'Apresenta espessamento <x> e movimentação <x> de suas válvulas. ', 'valva_pulmonar'),
(374, 'MNEPO ', 'Apresenta movimentação normal e espessamento mínimo de suas válvulas. ', 'valva_pulmonar'),
(375, 'MNEP1 ', 'Apresenta movimentação normal e espessamento discreto de suas válvulas. ', 'valva_pulmonar'),
(376, 'MNEP2 ', 'Apresenta movimentação normal e espessamento moderado de suas válvulas. ', 'valva_pulmonar'),
(377, 'MNEP3 ', 'Apresenta movimentação normal e espessamento importante de suas válvulas. ', 'valva_pulmonar'),
(378, 'GRADP ', 'Gradiente sistólico máximo VD-TD estimado em <x> mmHg e médio em <x> mmHg. ', 'valva_pulmonar'),
(379, 'GRADMP', 'Gradiente sistólico médio VD- TD estimado em <x> mmHg. ', 'valva_pulmonar'),
(380, 'AVP', 'Área valvar estimada em <x> cm².', 'valva_pulmonar'),
(381, 'HP ', 'Apresenta sinais indiretos de hipertensão arterial pulmonar. ', 'valva_pulmonar'),
(382, 'IPFiS ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo, que na ausência de alterações morfológicas, pode ser considerado fisiológico. ', 'valva_pulmonar'),
(383, 'IP0 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo. ', 'valva_pulmonar'),
(384, 'IP1 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau discreto. ', 'valva_pulmonar'),
(385, 'IP2 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau moderado. ', 'valva_pulmonar'),
(386, 'IP3 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau importante. ', 'valva_pulmonar'),
(387, 'NV ', 'Não visibilizada. ', 'valva_pulmonar'),
(388, 'PBNP ', 'Prótese biológica sem alterações estruturais e mobilidade preservada. ', 'valva_pulmonar'),
(389, 'PMNP ', 'Prótese mecânica sem alterações estruturais e mobilidade preservada. ', 'valva_pulmonar'),
(390, 'VTN ', 'Apresenta aspecto e movimentação normaisde suas cúspides ', 'valva_tricuspide'),
(391, 'EDNT ', 'O estudo Doppler e mapeamento com fluxo em cores são normais. ', 'valva_tricuspide'),
(392, 'ET ', 'Apresenta sinais de fusão comissural, espessamento <x> de suas cúspides e mobilidade<x>. ', 'valva_tricuspide'),
(393, 'EXMXT ', 'Apresenta espessamento <x> e movimentação <x> de suas cúspides. ', 'valva_tricuspide'),
(394, 'MNETO ', 'Apresenta movimentação normal e espessamento mínimo de suas cúspides. ', 'valva_tricuspide'),
(395, 'MNET1 ', 'Apresenta movimentação normal e espessamento discreto de suas cúspides. ', 'valva_tricuspide'),
(396, 'MNET2 ', 'Apresenta movimentação normal e espessamento moderado de suas cúspides. ', 'valva_tricuspide'),
(397, 'MNET3 ', 'Apresenta movimentação normal e espessamento importante de suas cúspides. ', 'valva_tricuspide'),
(398, 'GRADT ', 'Gradiente diastólico máximo AD-VD estimado em <x> mmHg e médio em <x> mmHg. ', 'valva_tricuspide'),
(399, 'GRADMT ', 'Gradiente diastólico médio AD-VD estimado em <x> mmHg. ', 'valva_tricuspide'),
(400, 'AVT ', 'Área valvar estimada em <x> cm². ', 'valva_tricuspide'),
(401, 'ITFIS ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo, que na ausência de alterações morfológicas, pode ser considerado fisiológico. ', 'valva_tricuspide'),
(402, 'ITO ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau mínimo. ', 'valva_tricuspide'),
(403, 'IT1 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau discreto. ', 'valva_tricuspide'),
(404, 'IT2 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau moderado. ', 'valva_tricuspide'),
(405, 'IT3 ', 'O estudo Doppler e mapeamento com fluxo em cores demonstraram insuficiência de grau importante. ', 'valva_tricuspide'),
(406, 'PBTN ', 'Prótese biológica sem alterações estruturais e mobilidade preservada. ', 'valva_tricuspide'),
(407, 'PBTE ', 'Prótese biológica apresentando espessamento dos seus folhetos, sem alteração funcioanl ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(408, 'PBTEE ', 'Prótese biológica apresentando espessamento e redução da mobilidade dos seus folhetos. ', 'valva_tricuspide'),
(409, 'PBTC ', 'Prótese biológica apresentando calcificação e redução da mobilidade dos seus folhetos. ', 'valva_tricuspide'),
(410, 'PBTICO', 'Prótese biológica com espessamento dos seus folhetos e mínima  regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(411, 'PBTIC1 ', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(412, 'PBTIC2 ', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(413, 'PBTIC3 ', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(414, 'PBTIPVO ', 'Prótese biológica com espessamento dos seus folhetos e mínima regurgitação periprotética ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(415, 'PBTIPV1', 'Prótese biológica com espessamento dos seus folhetos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(416, 'PBTIPV2', 'Prótese biológica com espessamento dos seus folhetos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(417, 'PBTIPV3', 'Prótese biológica com espessamento dos seus folhetos e importante regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(418, 'PBROTAT', 'Prótese biológica com espessamento e imagem sugestiva de ruptura de folheto <x>. ', 'valva_tricuspide'),
(419, 'PBVEGT', 'Prótese biológica com imagem ecodensa compatível com vegetação. ', 'valva_tricuspide'),
(420, 'PBVEGXT', 'Prótese biológica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_tricuspide'),
(421, 'PBVEGPT', 'Prótese biológica apresentando aumento da ecogenicidade difusa dos folhetos compatível com vegetação tipo "panus". ', 'valva_tricuspide'),
(422, 'PBABT', 'Prótese biológica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_tricuspide'),
(423, 'PMNT', 'Prótese mecânica sem alterações estruturais e mobilidade preservada. ', 'valva_tricuspide'),
(424, 'PMTT', 'Prótese mecânica apresentando redução da mobilidade de seus elementos e sinais de trombose.', 'valva_tricuspide'),
(425, 'PMTICO', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação central ao Doppler e mapeamento de fluxo em cores (refluxo fisiológico).', 'valva_tricuspide'),
(426, 'PMTIC1', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação central ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(427, 'PMTIC2', 'Prótese mecânica com mobilidade normal de seus elementos e moderada regurgitação central ao Doppler e mapeamento de fluxo em cores. ', 'valva_tricuspide'),
(428, 'PMTIC3 ', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação central ao Doppler e mapeamento de fluxo em coes.', 'valva_tricuspide'),
(429, 'PMTIPVO', 'Prótese mecânica com mobilidade normal de seus elementos e mínima regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(430, 'PMTIPV1', 'Prótese mecânica com mobilidade normal de seus elementos e discreta regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(431, 'PMTIPV2', 'Prótese mecânica com mobilidade normal de seus elementos e moderada regurgitação periprotética ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(432, 'PMTIPV3 ', 'Prótese mecânica com mobilidade normal de seus elementos e importante regurgitação periprotétíca ao Doppler e mapeamento de fluxo em cores.', 'valva_tricuspide'),
(433, 'PMTVEG', 'Prótese mecânica com imagem ecodensa compatível com vegetação. ', 'valva_tricuspide');
INSERT INTO `combo` (`id`, `sigla`, `texto`, `tipo`) VALUES
(434, 'PMTVEGX ', 'Prótese mecânica com imagem ecodensa aderida ao folheto <x> compatível com vegetação. ', 'valva_tricuspide'),
(435, 'PMTAB', 'Prótese mecânica apresentando imagem livre de ecos em anel <x> compatível com abscesso de anel. ', 'valva_tricuspide'),
(436, 'VEN ', 'Ventrículo esquerdo apresenta função sistólica e espessura miocárdica preservadas, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(437, 'VEFDN ', 'índices de função diastólica normais. ', 'ventriculos'),
(438, 'AEMIV ', 'A diferença no atraso eletromecânico intraventricular esquerdo é de <x> ms (dissincronia significativa quando ? 65 ms). ', 'ventriculos'),
(439, 'AEMSP', 'A diferença no atraso eletromecânico entre o septo interventricular e a parede posterior do ventrículo esquerdo é de <x> ms (dissincronia significativa quando >130 ms). ', 'ventriculos'),
(440, '', 'A diferença entre os tempos pré-ejetivos aórtico e pulmonar é de <x> ms (dissincronia significativa quando > 40 ms)', 'ventriculos'),
(441, 'AEMS ', 'A soma da dissincronia intraventricular esquerda e interventricular é de <x> ms (dissincronia significativa quando >100 ms). ', 'ventriculos'),
(442, 'VEHX ', 'Ventrículo esquerdo apresenta função sistólica preservada e hipertrofia miocárdica de grau <x>, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(443, 'VEH1 ', 'Ventrículo esquerdo apresenta função sistólica preservada e hipertrofia miocárdica de grau discreto, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(444, 'VEH2 ', 'Ventrículo esquerdo apresenta função sistólica preservada e hipertrofia miocárdica de grau moderado, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(445, 'VEH3 ', 'Ventrículo esquerdo apresenta função sistólica preservada e hipertrofia miocárdica de grau importante, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(446, 'VERC ', 'Ventrículo esquerdo apresenta função sistólica preservada e aumento da espessura relativa de parede sugestivo de remodelamento concêntrico, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(447, 'VENO', 'Ventrículo esquerdo apresenta espessura preservada e função sistólica no limite inferior da normalidade, não sendo observadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(448, 'VEHS ', 'Ventrículo esquerdo apresenta função sistólica e espessura preservadas, apesar de hipertrofia do septo basal (sigmóide) não sendo notadas alterações na mobilidade segmentar de parede. ', 'ventriculos'),
(449, 'VENSX ', 'Ventrículo esquerdo apresenta espessura normal e função sistólica preservada apesar de <x> em parede (s) <x>. ', 'ventriculos'),
(450, 'VENSA ', 'Ventrículo esquerdo apresenta espessura normal e função sistólica preservada apesar de acinesia em parede (s) <X>. ', 'ventriculos'),
(451, 'VENSH ', 'Ventrículo esquerdo apresenta espessura normal e função sistólica preservada apesar de hipocinesia em parede (s) <X>. ', 'ventriculos'),
(452, 'VENSD ', 'Ventrículo esquerdo apresenta espessura normal e função sistólica preservada apesar de discinesia em parede (s) <X>. ', 'ventriculos'),
(453, 'VEDHD ', 'Ventrículo esquerdo apresenta espessura preservada e função sistólica diminuída à custa de hipocinesia difusa. ', 'ventriculos'),
(454, 'VEDSX ', 'Ventrículo esquerdo apresenta espessura preservada e função sistólica diminuída à custa de <x> em parede (s) <X>. ', 'ventriculos'),
(455, 'VEDSA ', 'Ventrículo esquerdo apresenta espessura preservada e função sistólica diminuída à custa de acinesia em parede (s) <x>. ', 'ventriculos'),
(456, 'VEDSD ', 'Ventrículo esquerdo apresenta espessura preservada e função sistólica diminuída à custa de discínesia em parede (s) <X>. ', 'ventriculos'),
(457, 'VEHNSX ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica preservada apesar de <X> em parede (s) <x>. ', 'ventriculos'),
(458, 'VEHNSA', 'Ventrículo esquerdo apresenta hipertrofia <X> e função sistólica preservada apesar de acinesia em parede (s) <x>. ', 'ventriculos'),
(459, 'VEHNSH ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica preservada apesar de hipocinesia em parede (s) <X>. ', 'ventriculos'),
(460, 'VEHNSD ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica preservada apesar de discinesia em parede (s) <X>. ', 'ventriculos'),
(461, 'VERCSA ', 'Ventrículo esquerdo apresenta aumento da espessura relativa de parede sugestivo de remodelamento concêntrico e função sistólica preservada apesar de acinesia em parede (s) <X>. ', 'ventriculos'),
(462, 'VERCSH ', 'Ventrículo esquerdo apresenta aumento da espessura relativa de parede sugestivo de remodelamento concêntrico e função sistólica preservada apesar de hipocinesia em parede (s) <x>. ', 'ventriculos'),
(463, 'VERCSD ', 'Ventrículo esquerdo apresenta aumento da espessura relativa de parede, sugestivo de remodelamento concêntrico, e função sistólica preservada apesar de discinesia em parede (s) <x>. ', 'ventriculos'),
(464, 'VEHDHD ', 'Ventrículo esquerdo apresenta hipertrofia <X> e função sistólica diminuída à custa de hipocinesia difusa. ', 'ventriculos'),
(465, 'VEHDSX ', 'Ventrículo esquerdo apresenta hipertrofia <X> e função sistólica diminuída à custa de <x> em parede (s) <X>. ', 'ventriculos'),
(466, 'VEHDSA ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica diminuída à custa de acinesia em parede (s) <x>. ', 'ventriculos'),
(467, 'VEHDSH ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica diminuída à custa de hipocinesia em parede (s) <x>. ', 'ventriculos'),
(468, 'VEHDSD ', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica diminuída à custa de discinesia em parede (s) <x>. ', 'ventriculos'),
(469, 'VEHNH', 'Ventrículo esquerdo apresenta hipertrofia <x> e função sistólica preservada apesar de hipocinesia em parede (s) <x>. ', 'ventriculos'),
(470, 'VEHIPER ', 'Ventrículo esquerdo apresenta espessura normal e desempenho sistólico hiperdinâmico, sem alterações da mobilidade segmentar. ', 'ventriculos'),
(471, 'VEHHIPER ', 'Ventrículo esquerdo apresenta hipertrofia <x> e desempenho sistólico hiperdinâmico, sem alterações da mobilidade segmentar.', 'ventriculos'),
(472, 'VERCHIPER', 'Ventrículo esquerdo apresenta aumento da espessura relativa de parede sugestivo de remodelamento concêntrico e desempenho sistólico hiperdinâmico, sem alterações da mobilidade segmentar. ', 'ventriculos'),
(473, 'STRAVE ', 'Imagem sugestiva de trombo em ápice do ventrículo esquerdo. ', 'ventriculos'),
(474, 'TRAVE ', 'Imagem de trombo em ápice do ventrículo esquerdo medindo aproximadamente <x> cm. ', 'ventriculos'),
(475, 'TRVE ', 'Imagem sugestiva de trombo na região <x> do ventrículo esquerdo medindo aproximadamente <x> cm. ', 'ventriculos'),
(476, 'VEFDO ', 'Não foi possível análise da função diastólica. ', 'ventriculos'),
(477, 'VEDD1 ', 'Achados de Doppler compatíveis com alteração de relaxamento ventricular esquerdo. ', 'ventriculos'),
(478, 'VEDD2 ', 'Achados de Doppler compatíveis com padrão pseudonormal. ', 'ventriculos'),
(479, 'VEDD3 ', 'Achados de Doppler compatíveis com padrão restritivo com reversão após manobra de Valsalva. ', 'ventriculos'),
(480, 'VEDD4 ', 'Achados de Doppler compatíveis com padrão restritivo sem reversão após manobra de Valsalva. ', 'ventriculos'),
(481, 'VDN ', 'Ventrículo direito apresenta função sistólica normal. ', 'ventriculos'),
(482, 'HVD1 ', 'Ventrículo direito apresenta hipertrofia de grau discreto e função sistólica preservada. ', 'ventriculos'),
(483, 'HVD2 ', 'Ventrículo direito apresenta hipertrofia de grau moderado e função sistólica preservada. ', 'ventriculos'),
(484, 'HVD3 ', 'Ventrículo direito apresenta hipertrofia de grau importante e função sistólica preservada. ', 'ventriculos'),
(485, 'VDHD1 ', 'Ventrículo direito apresenta hipocinesia discreta. ', 'ventriculos'),
(486, 'VDHD2 ', 'Ventrículo direito apresenta hipocinesia moderada. ', 'ventriculos'),
(487, 'VDHD3 ', 'Ventrículo direito apresenta hipocinesia importante. ', 'ventriculos'),
(488, 'VDHHD1 ', 'Ventrículo direito apresenta hipertrofia <x> e hipocinesia discreta. ', 'ventriculos'),
(489, 'VDHHD2 ', 'Ventrículo direito apresenta hipertrofia <x> e hipocinesia moderada. ', 'ventriculos'),
(490, 'VDHHD3 ', 'Ventrículo direito apresenta hipertrofia <x> e hipocinesia importante. ', 'ventriculos'),
(491, 'CAT ', 'Presença de catéter em câmaras direitas. ', 'ventriculos'),
(492, 'MP ', 'Eletrodo de marca passo em câmaras cardíacas direitas. ', 'ventriculos'),
(493, 'MAS ', 'Movimentação atípica do septo ventricular. ', 'ventriculos'),
(494, 'MPS ', 'Movimentação paradoxal do septo ventricular. ', 'ventriculos'),
(495, 'SPVD ', 'Movimentação atípica do septo ventricular sugestiva de sobrecarga pressórica do ventrículo direito. ', 'ventriculos'),
(496, 'SWD ', 'Movimentação atípica do septo ventricular sugestiva de sobrecarga volumétrica do ventrículo direito. ', 'ventriculos'),
(497, 'GVSVE ', 'Gradiente sistólico máximo na via de saída do ventrículo esquerdo estimado em <x> mmHg. ', 'ventriculos'),
(498, 'GVSVD', 'Gradiente sistólico máximo na via de saída do ventrículo direito estimado em <x> mmHg. ', 'ventriculos');


-- --------------------------------------------------------

--
-- Estrutura da tabela `convenio`
--

CREATE TABLE IF NOT EXISTS `convenio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Extraindo dados da tabela `convenio`
--

INSERT INTO `convenio` (`id`, `nome`, `status`) VALUES
(1, 'SUS', 'Ativo');


-- --------------------------------------------------------

--
-- Estrutura da tabela `escore`
--

CREATE TABLE IF NOT EXISTS `escore` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laudo_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `laudo_id` (`laudo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1;

--
-- Extraindo dados da tabela `escore`
--




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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `esforco`
--




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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `estresse`
--




-- --------------------------------------------------------

--
-- Estrutura da tabela `ireport`
--

CREATE TABLE IF NOT EXISTS `ireport` (
  `laudo_id` int(11) NOT NULL,
  `laudo_tipo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `ireport`
--




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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `laudo`
--



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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `medico`
--




-- --------------------------------------------------------

--
-- Estrutura da tabela `medicoAux`
--

CREATE TABLE IF NOT EXISTS `medicoAux` (
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `paciente`
--




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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Extraindo dados da tabela `segmento`
--




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
