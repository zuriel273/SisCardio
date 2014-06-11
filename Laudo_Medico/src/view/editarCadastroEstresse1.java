/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.Myconnection;
import convenio.Convenio;
import convenio.ConvenioErro;
import esforco.Esforco;
import fachada.Fachada;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;
import laudo.Eco;
import laudo.LaudoErro;
import laudoEscore.LaudoEscore;
import laudoEstresse.*;
import medico.*;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import paciente.Paciente;

/**
 *
 * @author arlindo
 */
public class editarCadastroEstresse1 extends javax.swing.JFrame {

    /**
     * Creates new form cadastroEstresse
     */
    int laudoEcoId;
    LaudoEstresse estresse;
    
    public editarCadastroEstresse1(Paciente p, Medico m,Convenio c,LaudoEstresse estresse, int laudoEcoId,String tipo, String tipoLaudo) throws LaudoErro {
        this.setAlwaysOnTop(true);
        initComponents();
        
        Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.c = c;
        this.p = p;
        this.m = m;
        this.laudoEcoId = laudoEcoId;
        this.estresse = estresse;
        
        this.tipoLaudo = tipoLaudo;
        this.tipo=tipo;
        
        if(tipo.equals("SEPD")){
            jRadioButton_SEPD.setSelected(true);
        
        }else{
            jRadioButton_SEPE1.setSelected(true);
        }
        
         jRadioButton_tt.setEnabled(false);
        jRadioButton_t.setEnabled(false);
        
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        System.out.println("=>"+estresse.isEco());
        jTextField_arritmias_outros.setVisible(false);
        jTextField_efeito_colateral_outros.setVisible(false);
        
        atualizaCombo();
        carregarCampos();
    }

    public editarCadastroEstresse1(Paciente p, Medico m,Convenio c,LaudoEstresse estresse, int laudoEcoId,String tipo) throws LaudoErro {
        this.setAlwaysOnTop(true);
        initComponents();
        
         Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.c = c;
        this.p = p;
        this.m = m;
        this.laudoEcoId = laudoEcoId;
        this.estresse = estresse;
        this.tipo=tipo;
        if(tipo.equals("SEPD")){
            jRadioButton_SEPD.setSelected(true);
        
        }else{
            jRadioButton_SEPE1.setSelected(true);
        }
        
        jRadioButton_sub.setEnabled(false);
        
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        System.out.println("=>"+estresse.isEco());
        jTextField_arritmias_outros.setVisible(false);
        jTextField_efeito_colateral_outros.setVisible(false);
        
        atualizaCombo();
        carregarCampos();
    }
    
    private void atualizaCombo() throws LaudoErro {
        
        jTextField_crm.setEnabled(false);
        jButton_medicos.setEnabled(false);
        jComboBox_convenio.setEnabled(false);
        jTextField_nome.setEnabled(false);

        this.setAlwaysOnTop(false);

        Fachada f = new Fachada();
        List listar2;
        try {
            listar2 = f.pesquisarConvenioPorStatus();
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                Convenio c = (Convenio)it2.next();             
                jComboBox_convenio.addItem(c.getNome());  
                 if(this.c.getNome().equals(c.getNome())){
                       jComboBox_convenio.setSelectedItem(c.getNome());
                   }
            }
        } catch (ConvenioErro ex) {
            Logger.getLogger(editarCadastroEstresse1.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        List listar = f.pesquisarComboPorTipo("coclusao_do_estresse");
        Iterator it = listar.iterator();
        while (it.hasNext()) {
            String sigla = (String) it.next();
            jComboBox_conclusao_estresse.addItem(sigla);
        }
        listar = f.pesquisarComboPorTipo("analise_ve_na_recuperacao");
        it = listar.iterator();
        while (it.hasNext()) {
            String sigla = (String) it.next();
            jComboBox_analise_v_e_recuperacao.addItem(sigla);
        }
        listar = f.pesquisarComboPorTipo("analise_ve_pico_do_estresse");
        it = listar.iterator();
        while (it.hasNext()) {
            String sigla = (String) it.next();
            jComboBox_analise_v_e_pico_estresse.addItem(sigla);
        }
        listar = f.pesquisarComboPorTipo("analise_ve_no_repouso");
        it = listar.iterator();
        while (it.hasNext()) {
            String sigla = (String) it.next();
            jComboBox_analise_v_e_repouso.addItem(sigla);
        }
    }

    private void carregarCampos() {

        this.setAlwaysOnTop(false);
        jTextArea_texto.setText(estresse.getTexto());
        if (estresse.isBradicardia()) {
            jRadioButton_bradicardia_sim.setSelected(true);
        } else {
            jRadioButton_bradicardia_nao.setSelected(true);
        }
        if (estresse.isDor_precordial()) {
            jRadioButton_dor_precordial_sim.setSelected(true);
        } else {
            jRadioButton_dor_precordial_nao.setSelected(true);
        }
        if (estresse.isEssv()) {
            jRadioButton_essv_sim.setSelected(true);
        } else {
            jRadioButton_essv_nao.setSelected(true);
        }
        if (estresse.isEsv()) {
            jRadioButton_esv_sim.setSelected(true);
        } else {
            jRadioButton_esv_nao.setSelected(true);
        }
        if (estresse.isFa()) {
            jRadioButton_fa_sim.setSelected(true);
        } else {
            jRadioButton_fa_nao.setSelected(true);
        }
        if (estresse.isHipertensao()) {
            jRadioButton_hipertensao_sim.setSelected(true);
        } else {
            jRadioButton_hipertensao_nao.setSelected(true);
        }
        if (estresse.isHipotensao()) {
            jRadioButton_hipotensao_sim.setSelected(true);
        } else {
            jRadioButton_hipotensao_nao.setSelected(true);
        }
        if (estresse.isNausea()) {
            jRadioButton_nausea_sim.setSelected(true);
        } else {
            jRadioButton_nausea_nao.setSelected(true);
        }
        if (estresse.isTv()) {
            jRadioButton_tv_sim.setSelected(true);
        } else {
            jRadioButton_tv_nao.setSelected(true);
        }
        if (estresse.isTvns()) {
            jRadioButton_tvns_sim1.setSelected(true);
        } else {
            jRadioButton_tvns_nao1.setSelected(true);
        }
        if (estresse.getOutro_arritmia().trim().equals("")) {
            jRadioButton_arritmias_outros_nao.setSelected(true);
        } else {
            jRadioButton_arritmias_outros_sim.setSelected(true);
            jTextField_arritmias_outros.setText(estresse.getOutro_arritmia());
            jTextField_arritmias_outros.setVisible(true);
        }
        if (estresse.getOutro_ef_colateral().trim().equals("")) {
            jRadioButton_efeito_colateral_outros_nao.setSelected(true);
        } else {
            jRadioButton_efeito_colateral_outros_sim.setSelected(true);
            jTextField_efeito_colateral_outros.setText(estresse.getOutro_ef_colateral());
            jTextField_efeito_colateral_outros.setVisible(true);
        }


        Esforco[] cincomcg = estresse.getCincomcg(), dezmcg = estresse.getDezmcg(), vintemcg = estresse.getVintemcg(), repouso = estresse.getRepouso();
        jTextField_10mcg_0_atropina.setText("" + dezmcg[0].getAtropina());
        jTextField_10mcg_0_eletrocardiograma.setText("" + dezmcg[0].getEletrocardiograma());
        jTextField_10mcg_0_fc.setText("" + dezmcg[0].getFc());
        jTextField_10mcg_0_pa.setText("" + dezmcg[0].getPa());
        jTextField_10mcg_1_atropina.setText("" + dezmcg[1].getAtropina());
        jTextField_10mcg_1_eletrocardiograma.setText("" + dezmcg[1].getEletrocardiograma());
        jTextField_10mcg_1_fc.setText("" + dezmcg[1].getFc());
        jTextField_10mcg_1_pa.setText("" + dezmcg[1].getPa());
        jTextField_20mcg_0_atropina.setText("" + vintemcg[0].getAtropina());
        jTextField_20mcg_0_eletrocardiograma.setText("" + vintemcg[0].getEletrocardiograma());
        jTextField_20mcg_0_fc.setText("" + vintemcg[0].getFc());
        jTextField_20mcg_0_pa.setText("" + vintemcg[0].getPa());
        jTextField_20mcg_1_atropina.setText("" + vintemcg[1].getAtropina());
        jTextField_20mcg_1_eletrocardiograma.setText("" + vintemcg[1].getEletrocardiograma());
        jTextField_20mcg_1_fc.setText("" + vintemcg[1].getFc());
        jTextField_20mcg_1_pa.setText("" + vintemcg[1].getPa());
        jTextField_5mcg_0_atropina.setText("" + cincomcg[0].getAtropina());
        jTextField_5mcg_0_eletrocardiograma.setText("" + cincomcg[0].getEletrocardiograma());
        jTextField_5mcg_0_fc.setText("" + cincomcg[0].getFc());
        jTextField_5mcg_0_pa.setText("" + cincomcg[0].getPa());
        jTextField_5mcg_1_atropina.setText("" + cincomcg[1].getAtropina());
        jTextField_5mcg_1_eletrocardiograma.setText("" + cincomcg[1].getEletrocardiograma());
        jTextField_5mcg_1_fc.setText("" + cincomcg[1].getFc());
        jTextField_5mcg_1_pa.setText("" + cincomcg[1].getPa());
        jTextField_repouso_0_atropina.setText("" + repouso[0].getAtropina());
        jTextField_repouso_0_eletrocardiograma.setText("" + repouso[0].getEletrocardiograma());
        jTextField_repouso_0_fc.setText("" + repouso[0].getFc());
        jTextField_repouso_0_pa.setText("" + repouso[0].getPa());
        jTextField_repouso_1_atropina.setText("" + repouso[1].getAtropina());
        jTextField_repouso_1_eletrocardiograma.setText("" + repouso[1].getEletrocardiograma());
        jTextField_repouso_1_fc.setText("" + repouso[1].getFc());
        jTextField_repouso_1_pa.setText("" + repouso[1].getPa());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_esv = new javax.swing.ButtonGroup();
        buttonGroup_tvns = new javax.swing.ButtonGroup();
        buttonGroup_fa = new javax.swing.ButtonGroup();
        buttonGroup_outros = new javax.swing.ButtonGroup();
        buttonGroup_essv = new javax.swing.ButtonGroup();
        buttonGroup_tv = new javax.swing.ButtonGroup();
        buttonGroup_bradicardia = new javax.swing.ButtonGroup();
        buttonGroup_dor_precordial = new javax.swing.ButtonGroup();
        buttonGroup_hiportensao = new javax.swing.ButtonGroup();
        buttonGroup_efeito_colateral_outros = new javax.swing.ButtonGroup();
        buttonGroup_nausea = new javax.swing.ButtonGroup();
        buttonGroup_hipertensao = new javax.swing.ButtonGroup();
        jPanel_geral = new javax.swing.JPanel();
        jDesktopPane_geral = new javax.swing.JDesktopPane();
        jLabel_est_esforco = new javax.swing.JLabel();
        jLabel_pa = new javax.swing.JLabel();
        jLabel_fc = new javax.swing.JLabel();
        jLabel_atropina = new javax.swing.JLabel();
        jLabel_eletrocardiograma = new javax.swing.JLabel();
        jLabel_repouso_0 = new javax.swing.JLabel();
        jLabel_repouso_1 = new javax.swing.JLabel();
        jLabel_5mcg_0 = new javax.swing.JLabel();
        jLabel_5mcg_1 = new javax.swing.JLabel();
        jLabel_10mcg_0 = new javax.swing.JLabel();
        jLabel_10mcg_1 = new javax.swing.JLabel();
        jLabel_20mcg_0 = new javax.swing.JLabel();
        jLabel_20mcg_1 = new javax.swing.JLabel();
        jTextField_repouso_0_pa = new javax.swing.JTextField();
        jTextField_repouso_0_fc = new javax.swing.JTextField();
        jTextField_repouso_0_atropina = new javax.swing.JTextField();
        jTextField_repouso_0_eletrocardiograma = new javax.swing.JTextField();
        jTextField_repouso_1_pa = new javax.swing.JTextField();
        jTextField_repouso_1_fc = new javax.swing.JTextField();
        jTextField_repouso_1_atropina = new javax.swing.JTextField();
        jTextField_repouso_1_eletrocardiograma = new javax.swing.JTextField();
        jTextField_5mcg_0_pa = new javax.swing.JTextField();
        jTextField_5mcg_0_fc = new javax.swing.JTextField();
        jTextField_5mcg_0_atropina = new javax.swing.JTextField();
        jTextField_5mcg_0_eletrocardiograma = new javax.swing.JTextField();
        jTextField_5mcg_1_pa = new javax.swing.JTextField();
        jTextField_5mcg_1_fc = new javax.swing.JTextField();
        jTextField_5mcg_1_atropina = new javax.swing.JTextField();
        jTextField_5mcg_1_eletrocardiograma = new javax.swing.JTextField();
        jTextField_10mcg_0_pa = new javax.swing.JTextField();
        jTextField_10mcg_0_fc = new javax.swing.JTextField();
        jTextField_10mcg_0_atropina = new javax.swing.JTextField();
        jTextField_10mcg_0_eletrocardiograma = new javax.swing.JTextField();
        jTextField_10mcg_1_pa = new javax.swing.JTextField();
        jTextField_10mcg_1_fc = new javax.swing.JTextField();
        jTextField_10mcg_1_atropina = new javax.swing.JTextField();
        jTextField_10mcg_1_eletrocardiograma = new javax.swing.JTextField();
        jTextField_20mcg_0_pa = new javax.swing.JTextField();
        jTextField_20mcg_0_fc = new javax.swing.JTextField();
        jTextField_20mcg_0_atropina = new javax.swing.JTextField();
        jTextField_20mcg_0_eletrocardiograma = new javax.swing.JTextField();
        jTextField_20mcg_1_pa = new javax.swing.JTextField();
        jTextField_20mcg_1_fc = new javax.swing.JTextField();
        jTextField_20mcg_1_atropina = new javax.swing.JTextField();
        jTextField_20mcg_1_eletrocardiograma = new javax.swing.JTextField();
        jLabel_bg_est_esforco = new javax.swing.JLabel();
        jLabel_esv = new javax.swing.JLabel();
        jRadioButton_esv_sim = new javax.swing.JRadioButton();
        jRadioButton_esv_nao = new javax.swing.JRadioButton();
        jLabel_tvns = new javax.swing.JLabel();
        jRadioButton_tvns_sim1 = new javax.swing.JRadioButton();
        jRadioButton_tvns_nao1 = new javax.swing.JRadioButton();
        jLabel_fa = new javax.swing.JLabel();
        jRadioButton_fa_sim = new javax.swing.JRadioButton();
        jRadioButton_fa_nao = new javax.swing.JRadioButton();
        jLabel_arritmias_outros = new javax.swing.JLabel();
        jRadioButton_arritmias_outros_sim = new javax.swing.JRadioButton();
        jRadioButton_arritmias_outros_nao = new javax.swing.JRadioButton();
        jTextField_arritmias_outros = new javax.swing.JTextField();
        jLabel_essv = new javax.swing.JLabel();
        jRadioButton_essv_sim = new javax.swing.JRadioButton();
        jRadioButton_essv_nao = new javax.swing.JRadioButton();
        jLabel_tv = new javax.swing.JLabel();
        jRadioButton_tv_sim = new javax.swing.JRadioButton();
        jRadioButton_tv_nao = new javax.swing.JRadioButton();
        jLabel_bradicardia = new javax.swing.JLabel();
        jRadioButton_bradicardia_sim = new javax.swing.JRadioButton();
        jRadioButton_bradicardia_nao = new javax.swing.JRadioButton();
        jLabel_bg_attitmias = new javax.swing.JLabel();
        jLabel_dor_precordial = new javax.swing.JLabel();
        jRadioButton_dor_precordial_sim = new javax.swing.JRadioButton();
        jRadioButton_dor_precordial_nao = new javax.swing.JRadioButton();
        jLabel_hipotensao = new javax.swing.JLabel();
        jRadioButton_hipotensao_sim = new javax.swing.JRadioButton();
        jRadioButton_hipotensao_nao = new javax.swing.JRadioButton();
        jLabel_efeito_colateral_outros = new javax.swing.JLabel();
        jRadioButton_efeito_colateral_outros_sim = new javax.swing.JRadioButton();
        jRadioButton_efeito_colateral_outros_nao = new javax.swing.JRadioButton();
        jTextField_efeito_colateral_outros = new javax.swing.JTextField();
        jLabel_nausea = new javax.swing.JLabel();
        jRadioButton_nausea_sim = new javax.swing.JRadioButton();
        jRadioButton_nausea_nao = new javax.swing.JRadioButton();
        jLabel_hipertensao = new javax.swing.JLabel();
        jRadioButton_hipertensao_sim = new javax.swing.JRadioButton();
        jRadioButton_hipertensao_nao = new javax.swing.JRadioButton();
        jLabel_bg_attitmias1 = new javax.swing.JLabel();
        jLabel_analise_v_e_repouso = new javax.swing.JLabel();
        jComboBox_analise_v_e_repouso = new javax.swing.JComboBox();
        jLabel_analise_v_e_pico_estresse = new javax.swing.JLabel();
        jComboBox_analise_v_e_pico_estresse = new javax.swing.JComboBox();
        jLabel_analise_v_e_recuperacao = new javax.swing.JLabel();
        jComboBox_analise_v_e_recuperacao = new javax.swing.JComboBox();
        jLabel_conclusao_estresse = new javax.swing.JLabel();
        jComboBox_conclusao_estresse = new javax.swing.JComboBox();
        jButton_atualizar = new javax.swing.JButton();
        jButton_Imprimir = new javax.swing.JButton();
        jButton_sair = new javax.swing.JButton();
        jScrollPane_texto = new javax.swing.JScrollPane();
        jTextArea_texto = new javax.swing.JTextArea();
        jLabel_paciente = new javax.swing.JLabel();
        jLabel_nome_paciente = new javax.swing.JLabel();
        jLabel_Convenio = new javax.swing.JLabel();
        jComboBox_convenio = new javax.swing.JComboBox();
        jLabel_medicoResp = new javax.swing.JLabel();
        jTextField_crm = new javax.swing.JTextField();
        jTextField_nome = new javax.swing.JTextField();
        jButton_medicos = new javax.swing.JButton();
        jLabel_tipo = new javax.swing.JLabel();
        jRadioButton_tt = new javax.swing.JRadioButton();
        jRadioButton_SEPD = new javax.swing.JRadioButton();
        jRadioButton_sub = new javax.swing.JRadioButton();
        jRadioButton_t = new javax.swing.JRadioButton();
        jRadioButton_SEPE1 = new javax.swing.JRadioButton();
        jRadioButton_esc = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Atualizar Dados de Laudo Estresse");
        setAlwaysOnTop(true);
        setResizable(false);

        jLabel_est_esforco.setText("Est. de Esforço");
        jLabel_est_esforco.setBounds(40, 30, 120, 14);
        jDesktopPane_geral.add(jLabel_est_esforco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_pa.setText("PA (mmHg)");
        jLabel_pa.setBounds(180, 30, 100, 14);
        jDesktopPane_geral.add(jLabel_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_fc.setText("FC (bpm)");
        jLabel_fc.setBounds(290, 30, 100, 14);
        jDesktopPane_geral.add(jLabel_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_atropina.setText("Atropina");
        jLabel_atropina.setBounds(400, 30, 100, 14);
        jDesktopPane_geral.add(jLabel_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_eletrocardiograma.setText("Eletrocardiograma");
        jLabel_eletrocardiograma.setBounds(510, 30, 150, 14);
        jDesktopPane_geral.add(jLabel_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_repouso_0.setText("Repouso");
        jLabel_repouso_0.setBounds(40, 60, 100, 14);
        jDesktopPane_geral.add(jLabel_repouso_0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_repouso_1.setText("Repouso");
        jLabel_repouso_1.setBounds(40, 90, 100, 14);
        jDesktopPane_geral.add(jLabel_repouso_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_5mcg_0.setText("5mcg");
        jLabel_5mcg_0.setBounds(40, 120, 100, 14);
        jDesktopPane_geral.add(jLabel_5mcg_0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_5mcg_1.setText("5mcg");
        jLabel_5mcg_1.setBounds(40, 150, 100, 14);
        jDesktopPane_geral.add(jLabel_5mcg_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_10mcg_0.setText("10mcg");
        jLabel_10mcg_0.setBounds(40, 180, 100, 14);
        jDesktopPane_geral.add(jLabel_10mcg_0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_10mcg_1.setText("10mcg");
        jLabel_10mcg_1.setBounds(40, 210, 100, 14);
        jDesktopPane_geral.add(jLabel_10mcg_1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_20mcg_0.setText("20mcg");
        jLabel_20mcg_0.setBounds(40, 240, 100, 14);
        jDesktopPane_geral.add(jLabel_20mcg_0, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_20mcg_1.setText("20mcg");
        jLabel_20mcg_1.setBounds(40, 270, 100, 14);
        jDesktopPane_geral.add(jLabel_20mcg_1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_0_pa.setBounds(180, 60, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_0_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_0_fc.setBounds(290, 60, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_0_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_0_atropina.setBounds(400, 60, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_0_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_0_eletrocardiograma.setBounds(510, 60, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_0_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_1_pa.setBounds(180, 90, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_1_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_1_fc.setBounds(290, 90, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_1_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_1_atropina.setBounds(400, 90, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_1_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_repouso_1_eletrocardiograma.setBounds(510, 90, 100, 26);
        jDesktopPane_geral.add(jTextField_repouso_1_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_0_pa.setBounds(180, 120, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_0_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_0_fc.setBounds(290, 120, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_0_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_0_atropina.setBounds(400, 120, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_0_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_0_eletrocardiograma.setBounds(510, 120, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_0_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_1_pa.setBounds(180, 150, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_1_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_1_fc.setBounds(290, 150, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_1_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_1_atropina.setBounds(400, 150, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_1_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_5mcg_1_eletrocardiograma.setBounds(510, 150, 100, 26);
        jDesktopPane_geral.add(jTextField_5mcg_1_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_0_pa.setBounds(180, 180, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_0_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_0_fc.setBounds(290, 180, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_0_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_0_atropina.setBounds(400, 180, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_0_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_0_eletrocardiograma.setBounds(510, 180, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_0_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_1_pa.setBounds(180, 210, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_1_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_1_fc.setBounds(290, 210, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_1_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_1_atropina.setBounds(400, 210, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_1_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_10mcg_1_eletrocardiograma.setBounds(510, 210, 100, 26);
        jDesktopPane_geral.add(jTextField_10mcg_1_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_0_pa.setBounds(180, 240, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_0_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_0_fc.setBounds(290, 240, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_0_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_0_atropina.setBounds(400, 240, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_0_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_0_eletrocardiograma.setBounds(510, 240, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_0_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_1_pa.setBounds(180, 270, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_1_pa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_1_fc.setBounds(290, 270, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_1_fc, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_1_atropina.setBounds(400, 270, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_1_atropina, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_20mcg_1_eletrocardiograma.setBounds(510, 270, 100, 26);
        jDesktopPane_geral.add(jTextField_20mcg_1_eletrocardiograma, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_bg_est_esforco.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_bg_est_esforco.setBounds(20, 20, 640, 290);
        jDesktopPane_geral.add(jLabel_bg_est_esforco, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_esv.setText("ESV");
        jLabel_esv.setBounds(720, 40, 40, 25);
        jDesktopPane_geral.add(jLabel_esv, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esv_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_esv.add(jRadioButton_esv_sim);
        jRadioButton_esv_sim.setText("Sim");
        jRadioButton_esv_sim.setBounds(790, 40, 70, 25);
        jDesktopPane_geral.add(jRadioButton_esv_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esv_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_esv.add(jRadioButton_esv_nao);
        jRadioButton_esv_nao.setText("Não");
        jRadioButton_esv_nao.setBounds(860, 40, 70, 25);
        jDesktopPane_geral.add(jRadioButton_esv_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tvns.setText("TVNS");
        jLabel_tvns.setBounds(720, 70, 40, 25);
        jDesktopPane_geral.add(jLabel_tvns, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tvns_sim1.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_tvns.add(jRadioButton_tvns_sim1);
        jRadioButton_tvns_sim1.setText("Sim");
        jRadioButton_tvns_sim1.setBounds(790, 70, 70, 25);
        jDesktopPane_geral.add(jRadioButton_tvns_sim1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tvns_nao1.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_tvns.add(jRadioButton_tvns_nao1);
        jRadioButton_tvns_nao1.setText("Não");
        jRadioButton_tvns_nao1.setBounds(860, 70, 70, 25);
        jDesktopPane_geral.add(jRadioButton_tvns_nao1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_fa.setText("FA");
        jLabel_fa.setBounds(720, 100, 40, 25);
        jDesktopPane_geral.add(jLabel_fa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_fa_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_fa.add(jRadioButton_fa_sim);
        jRadioButton_fa_sim.setText("Sim");
        jRadioButton_fa_sim.setBounds(790, 100, 70, 25);
        jDesktopPane_geral.add(jRadioButton_fa_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_fa_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_fa.add(jRadioButton_fa_nao);
        jRadioButton_fa_nao.setText("Não");
        jRadioButton_fa_nao.setBounds(860, 100, 70, 25);
        jDesktopPane_geral.add(jRadioButton_fa_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_arritmias_outros.setText("Outros");
        jLabel_arritmias_outros.setBounds(720, 130, 60, 25);
        jDesktopPane_geral.add(jLabel_arritmias_outros, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_arritmias_outros_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_outros.add(jRadioButton_arritmias_outros_sim);
        jRadioButton_arritmias_outros_sim.setText("Sim");
        jRadioButton_arritmias_outros_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_arritmias_outros_simActionPerformed(evt);
            }
        });
        jRadioButton_arritmias_outros_sim.setBounds(790, 130, 70, 25);
        jDesktopPane_geral.add(jRadioButton_arritmias_outros_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_arritmias_outros_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_outros.add(jRadioButton_arritmias_outros_nao);
        jRadioButton_arritmias_outros_nao.setText("Não");
        jRadioButton_arritmias_outros_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_arritmias_outros_naoActionPerformed(evt);
            }
        });
        jRadioButton_arritmias_outros_nao.setBounds(860, 130, 70, 25);
        jDesktopPane_geral.add(jRadioButton_arritmias_outros_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_arritmias_outros.setBounds(970, 130, 230, 20);
        jDesktopPane_geral.add(jTextField_arritmias_outros, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_essv.setText("ESSV");
        jLabel_essv.setBounds(970, 40, 40, 25);
        jDesktopPane_geral.add(jLabel_essv, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_essv_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_essv.add(jRadioButton_essv_sim);
        jRadioButton_essv_sim.setText("Sim");
        jRadioButton_essv_sim.setBounds(1080, 40, 70, 25);
        jDesktopPane_geral.add(jRadioButton_essv_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_essv_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_essv.add(jRadioButton_essv_nao);
        jRadioButton_essv_nao.setText("Não");
        jRadioButton_essv_nao.setBounds(1150, 40, 70, 25);
        jDesktopPane_geral.add(jRadioButton_essv_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tv.setText("TV");
        jLabel_tv.setBounds(970, 70, 40, 25);
        jDesktopPane_geral.add(jLabel_tv, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tv_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_tv.add(jRadioButton_tv_sim);
        jRadioButton_tv_sim.setText("Sim");
        jRadioButton_tv_sim.setBounds(1080, 70, 70, 25);
        jDesktopPane_geral.add(jRadioButton_tv_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tv_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_tv.add(jRadioButton_tv_nao);
        jRadioButton_tv_nao.setText("Não");
        jRadioButton_tv_nao.setBounds(1150, 70, 70, 25);
        jDesktopPane_geral.add(jRadioButton_tv_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_bradicardia.setText("BRADICARDIA");
        jLabel_bradicardia.setBounds(970, 100, 110, 25);
        jDesktopPane_geral.add(jLabel_bradicardia, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_bradicardia_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_bradicardia.add(jRadioButton_bradicardia_sim);
        jRadioButton_bradicardia_sim.setText("Sim");
        jRadioButton_bradicardia_sim.setBounds(1080, 100, 70, 25);
        jDesktopPane_geral.add(jRadioButton_bradicardia_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_bradicardia_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_bradicardia.add(jRadioButton_bradicardia_nao);
        jRadioButton_bradicardia_nao.setText("Não");
        jRadioButton_bradicardia_nao.setBounds(1150, 100, 70, 25);
        jDesktopPane_geral.add(jRadioButton_bradicardia_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_bg_attitmias.setBorder(javax.swing.BorderFactory.createTitledBorder("Arritmias"));
        jLabel_bg_attitmias.setBounds(680, 20, 580, 150);
        jDesktopPane_geral.add(jLabel_bg_attitmias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_dor_precordial.setText("Dor Precordial");
        jLabel_dor_precordial.setBounds(720, 200, 110, 25);
        jDesktopPane_geral.add(jLabel_dor_precordial, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_dor_precordial_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_dor_precordial.add(jRadioButton_dor_precordial_sim);
        jRadioButton_dor_precordial_sim.setText("Sim");
        jRadioButton_dor_precordial_sim.setBounds(840, 200, 70, 25);
        jDesktopPane_geral.add(jRadioButton_dor_precordial_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_dor_precordial_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_dor_precordial.add(jRadioButton_dor_precordial_nao);
        jRadioButton_dor_precordial_nao.setText("Não");
        jRadioButton_dor_precordial_nao.setBounds(910, 200, 70, 25);
        jDesktopPane_geral.add(jRadioButton_dor_precordial_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_hipotensao.setText("Hiportensão");
        jLabel_hipotensao.setBounds(720, 230, 90, 25);
        jDesktopPane_geral.add(jLabel_hipotensao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_hipotensao_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_hiportensao.add(jRadioButton_hipotensao_sim);
        jRadioButton_hipotensao_sim.setText("Sim");
        jRadioButton_hipotensao_sim.setBounds(840, 230, 70, 25);
        jDesktopPane_geral.add(jRadioButton_hipotensao_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_hipotensao_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_hiportensao.add(jRadioButton_hipotensao_nao);
        jRadioButton_hipotensao_nao.setText("Não");
        jRadioButton_hipotensao_nao.setBounds(910, 230, 70, 25);
        jDesktopPane_geral.add(jRadioButton_hipotensao_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_efeito_colateral_outros.setText("Outros");
        jLabel_efeito_colateral_outros.setBounds(720, 260, 60, 25);
        jDesktopPane_geral.add(jLabel_efeito_colateral_outros, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_efeito_colateral_outros_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_efeito_colateral_outros.add(jRadioButton_efeito_colateral_outros_sim);
        jRadioButton_efeito_colateral_outros_sim.setText("Sim");
        jRadioButton_efeito_colateral_outros_sim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_efeito_colateral_outros_simActionPerformed(evt);
            }
        });
        jRadioButton_efeito_colateral_outros_sim.setBounds(840, 260, 70, 25);
        jDesktopPane_geral.add(jRadioButton_efeito_colateral_outros_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_efeito_colateral_outros_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_efeito_colateral_outros.add(jRadioButton_efeito_colateral_outros_nao);
        jRadioButton_efeito_colateral_outros_nao.setText("Não");
        jRadioButton_efeito_colateral_outros_nao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_efeito_colateral_outros_naoActionPerformed(evt);
            }
        });
        jRadioButton_efeito_colateral_outros_nao.setBounds(910, 260, 70, 25);
        jDesktopPane_geral.add(jRadioButton_efeito_colateral_outros_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_efeito_colateral_outros.setBounds(990, 260, 230, 20);
        jDesktopPane_geral.add(jTextField_efeito_colateral_outros, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_nausea.setText("Nausea");
        jLabel_nausea.setBounds(990, 200, 80, 25);
        jDesktopPane_geral.add(jLabel_nausea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_nausea_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_nausea.add(jRadioButton_nausea_sim);
        jRadioButton_nausea_sim.setText("Sim");
        jRadioButton_nausea_sim.setBounds(1100, 200, 70, 25);
        jDesktopPane_geral.add(jRadioButton_nausea_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_nausea_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_nausea.add(jRadioButton_nausea_nao);
        jRadioButton_nausea_nao.setText("Não");
        jRadioButton_nausea_nao.setBounds(1170, 200, 70, 25);
        jDesktopPane_geral.add(jRadioButton_nausea_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_hipertensao.setText("Hipertensão");
        jLabel_hipertensao.setBounds(990, 230, 100, 25);
        jDesktopPane_geral.add(jLabel_hipertensao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_hipertensao_sim.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_hipertensao.add(jRadioButton_hipertensao_sim);
        jRadioButton_hipertensao_sim.setText("Sim");
        jRadioButton_hipertensao_sim.setBounds(1100, 230, 70, 25);
        jDesktopPane_geral.add(jRadioButton_hipertensao_sim, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_hipertensao_nao.setBackground(new java.awt.Color(250, 250, 250));
        buttonGroup_hipertensao.add(jRadioButton_hipertensao_nao);
        jRadioButton_hipertensao_nao.setText("Não");
        jRadioButton_hipertensao_nao.setBounds(1170, 230, 70, 25);
        jDesktopPane_geral.add(jRadioButton_hipertensao_nao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_bg_attitmias1.setBorder(javax.swing.BorderFactory.createTitledBorder("Efeitos Colaterais"));
        jLabel_bg_attitmias1.setBounds(680, 180, 580, 130);
        jDesktopPane_geral.add(jLabel_bg_attitmias1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_analise_v_e_repouso.setText("Análise do Ventrículo Esquerdo em Repouso: ");
        jLabel_analise_v_e_repouso.setBounds(20, 340, 320, 30);
        jDesktopPane_geral.add(jLabel_analise_v_e_repouso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_analise_v_e_repouso.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:: Selecione ::." }));
        jComboBox_analise_v_e_repouso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_analise_v_e_repousoActionPerformed(evt);
            }
        });
        jComboBox_analise_v_e_repouso.setBounds(400, 340, 190, 30);
        jDesktopPane_geral.add(jComboBox_analise_v_e_repouso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_analise_v_e_pico_estresse.setText("Análise do Ventrículo Esquerdo no Pico do Estresse: ");
        jLabel_analise_v_e_pico_estresse.setBounds(20, 380, 360, 30);
        jDesktopPane_geral.add(jLabel_analise_v_e_pico_estresse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_analise_v_e_pico_estresse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:: Selecione ::." }));
        jComboBox_analise_v_e_pico_estresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_analise_v_e_pico_estresseActionPerformed(evt);
            }
        });
        jComboBox_analise_v_e_pico_estresse.setBounds(400, 380, 190, 30);
        jDesktopPane_geral.add(jComboBox_analise_v_e_pico_estresse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_analise_v_e_recuperacao.setText("Análise do Ventrículo Esquerdo na Recuperação:");
        jLabel_analise_v_e_recuperacao.setBounds(20, 420, 370, 30);
        jDesktopPane_geral.add(jLabel_analise_v_e_recuperacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_analise_v_e_recuperacao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:: Selecione ::." }));
        jComboBox_analise_v_e_recuperacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_analise_v_e_recuperacaoActionPerformed(evt);
            }
        });
        jComboBox_analise_v_e_recuperacao.setBounds(400, 420, 190, 30);
        jDesktopPane_geral.add(jComboBox_analise_v_e_recuperacao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_conclusao_estresse.setText("Conclusão do Estresse:");
        jLabel_conclusao_estresse.setBounds(20, 460, 320, 30);
        jDesktopPane_geral.add(jLabel_conclusao_estresse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_conclusao_estresse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".:: Selecione ::." }));
        jComboBox_conclusao_estresse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_conclusao_estresseActionPerformed(evt);
            }
        });
        jComboBox_conclusao_estresse.setBounds(400, 460, 190, 30);
        jDesktopPane_geral.add(jComboBox_conclusao_estresse, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_atualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_atualizar.setMnemonic('a');
        jButton_atualizar.setText("Atualizar");
        jButton_atualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_atualizarActionPerformed(evt);
            }
        });
        jButton_atualizar.setBounds(130, 560, 120, 40);
        jDesktopPane_geral.add(jButton_atualizar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton_Imprimir.setToolTipText("");
        jButton_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ImprimirActionPerformed(evt);
            }
        });
        jButton_Imprimir.setBounds(530, 560, 120, 40);
        jDesktopPane_geral.add(jButton_Imprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png"))); // NOI18N
        jButton_sair.setMnemonic('v');
        jButton_sair.setText("Voltar");
        jButton_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sairActionPerformed(evt);
            }
        });
        jButton_sair.setBounds(960, 560, 120, 40);
        jDesktopPane_geral.add(jButton_sair, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea_texto.setColumns(20);
        jTextArea_texto.setRows(5);
        jScrollPane_texto.setViewportView(jTextArea_texto);

        jScrollPane_texto.setBounds(680, 320, 570, 190);
        jDesktopPane_geral.add(jScrollPane_texto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_paciente.setText("Paciente");

        jLabel_Convenio.setText("Convênio");

        jComboBox_convenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));

        jLabel_medicoResp.setText("Médico Responsável:");

        jTextField_crm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_crmActionPerformed(evt);
            }
        });

        jButton_medicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/busca.png"))); // NOI18N
        jButton_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_medicosActionPerformed(evt);
            }
        });

        jLabel_tipo.setText("Tipos de laudos:");

        jRadioButton_tt.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_tt.setText("Transtorácico e Transesofágico");
        jRadioButton_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ttActionPerformed(evt);
            }
        });

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });

        jRadioButton_t.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_t.setText("Transtorácico");
        jRadioButton_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_tActionPerformed(evt);
            }
        });

        jRadioButton_SEPE1.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPE1.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPE1ActionPerformed(evt);
            }
        });

        jRadioButton_esc.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_esc.setText("Escore");
        jRadioButton_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_escActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_geralLayout = new javax.swing.GroupLayout(jPanel_geral);
        jPanel_geral.setLayout(jPanel_geralLayout);
        jPanel_geralLayout.setHorizontalGroup(
            jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_geralLayout.createSequentialGroup()
                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_geralLayout.createSequentialGroup()
                        .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_Convenio))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_nome_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_convenio, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel_geralLayout.createSequentialGroup()
                        .addComponent(jLabel_medicoResp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_crm, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton_medicos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton_tt)
                    .addComponent(jRadioButton_SEPD, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRadioButton_esc, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_SEPE1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton_t, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_geralLayout.createSequentialGroup()
                    .addComponent(jDesktopPane_geral, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel_geralLayout.setVerticalGroup(
            jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_geralLayout.createSequentialGroup()
                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_geralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_medicos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_geralLayout.createSequentialGroup()
                                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_nome_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_geralLayout.createSequentialGroup()
                                        .addComponent(jLabel_paciente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel_Convenio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox_convenio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel_medicoResp, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_crm, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel_geralLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_geralLayout.createSequentialGroup()
                                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_tt)
                                    .addComponent(jRadioButton_t))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_SEPD)
                                    .addComponent(jRadioButton_SEPE1))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton_sub)
                                    .addComponent(jRadioButton_esc)))
                            .addComponent(jLabel_tipo))))
                .addGap(0, 652, Short.MAX_VALUE))
            .addGroup(jPanel_geralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_geralLayout.createSequentialGroup()
                    .addGap(120, 120, 120)
                    .addComponent(jDesktopPane_geral, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel_geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel_geral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_atualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_atualizarActionPerformed

        try {
            Esforco[] dezmcg = new Esforco[2], vintemcg = new Esforco[2], cincomcg = new Esforco[2], repouso = new Esforco[2];

            String atropina = jTextField_10mcg_0_atropina.getText();
            String eletrocardiograma = jTextField_10mcg_0_eletrocardiograma.getText();
            String fc = jTextField_10mcg_0_fc.getText();
            String pa = jTextField_10mcg_0_pa.getText();
            dezmcg[0] = new Esforco(estresse.getDezmcg()[0].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_10mcg_1_atropina.getText();
            eletrocardiograma = jTextField_10mcg_1_eletrocardiograma.getText();
            fc = jTextField_10mcg_1_fc.getText();
            pa = jTextField_10mcg_1_pa.getText();
            dezmcg[1] = new Esforco(estresse.getDezmcg()[1].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_20mcg_0_atropina.getText();
            eletrocardiograma = jTextField_20mcg_0_eletrocardiograma.getText();
            fc = jTextField_20mcg_0_fc.getText();
            pa = jTextField_20mcg_0_pa.getText();
            vintemcg[0] = new Esforco(estresse.getVintemcg()[0].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_20mcg_1_atropina.getText();
            eletrocardiograma = jTextField_20mcg_1_eletrocardiograma.getText();
            fc = jTextField_20mcg_1_fc.getText();
            pa = jTextField_20mcg_1_pa.getText();
            vintemcg[1] = new Esforco(estresse.getVintemcg()[1].getId(), pa, fc, atropina, eletrocardiograma);

            atropina =jTextField_5mcg_0_atropina.getText();
            eletrocardiograma = jTextField_5mcg_0_eletrocardiograma.getText();
            fc = jTextField_5mcg_0_fc.getText();
            pa = jTextField_5mcg_0_pa.getText();
            cincomcg[0] = new Esforco(estresse.getCincomcg()[0].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_5mcg_1_atropina.getText();
            eletrocardiograma = jTextField_5mcg_1_eletrocardiograma.getText();
            fc = jTextField_5mcg_1_fc.getText();
            pa = jTextField_5mcg_1_pa.getText();
            cincomcg[1] = new Esforco(estresse.getCincomcg()[1].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_repouso_0_atropina.getText();
            eletrocardiograma = jTextField_repouso_0_eletrocardiograma.getText();
            fc = jTextField_repouso_0_fc.getText();
            pa = jTextField_repouso_0_pa.getText();
            repouso[0] = new Esforco(estresse.getRepouso()[0].getId(), pa, fc, atropina, eletrocardiograma);

            atropina = jTextField_repouso_1_atropina.getText();
            eletrocardiograma = jTextField_repouso_1_eletrocardiograma.getText();
            fc = jTextField_repouso_1_fc.getText();
            pa = jTextField_repouso_1_pa.getText();
            repouso[1] = new Esforco(estresse.getRepouso()[1].getId(), pa, fc, atropina, eletrocardiograma);

            boolean esv = jRadioButton_esv_sim.isSelected();
            boolean essv = jRadioButton_essv_sim.isSelected();
            boolean tvns = jRadioButton_tvns_sim1.isSelected();
            boolean tv = jRadioButton_tv_sim.isSelected();
            boolean fa = jRadioButton_fa_sim.isSelected();
            boolean bradicardia = jRadioButton_bradicardia_sim.isSelected();
            boolean dor_precordial = jRadioButton_dor_precordial_sim.isSelected();
            boolean nauseas = jRadioButton_nausea_sim.isSelected();
            boolean hipotensao = jRadioButton_hipotensao_sim.isSelected();
            boolean hipertensao = jRadioButton_hipertensao_sim.isSelected();
            String outro_arritmia = (jRadioButton_arritmias_outros_sim.isSelected()) ? jTextField_arritmias_outros.getText() : "";
            String outro_colateral = (jRadioButton_efeito_colateral_outros_sim.isSelected()) ? jTextField_efeito_colateral_outros.getText() : "";

            String texto = jTextArea_texto.getText();
            System.out.println(texto);
            LaudoEstresse estress;
            estress = new LaudoEstresse(estresse.getId(), laudoEcoId, repouso, cincomcg, dezmcg, vintemcg, esv, essv, tv, tvns, fa, bradicardia, dor_precordial, hipertensao, hipotensao, nauseas, outro_arritmia, outro_colateral, texto);
            Fachada f = new Fachada();

            try {
                String retorno = f.atualizarLaudoEstresse(estress);
                if (!retorno.equals("true")) {
                    JOptionPane.showMessageDialog(this, "Erro: " + retorno, "Sistema", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Atualizado com Sucesso!", "Sistema", JOptionPane.INFORMATION_MESSAGE);
                    estresse = estress;
                    carregarCampos();
                }
            } catch (LaudoEstresseErro ex) {
                Logger.getLogger(editarCadastroEstresse1.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Sistema", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(this, "Os campos são numericos.", "Sistema", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton_atualizarActionPerformed

    private void jRadioButton_efeito_colateral_outros_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_efeito_colateral_outros_simActionPerformed
        jTextField_efeito_colateral_outros.setVisible(true);
    }//GEN-LAST:event_jRadioButton_efeito_colateral_outros_simActionPerformed

    private void jRadioButton_arritmias_outros_simActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_arritmias_outros_simActionPerformed
        jTextField_arritmias_outros.setVisible(true);
    }//GEN-LAST:event_jRadioButton_arritmias_outros_simActionPerformed

    private void jRadioButton_arritmias_outros_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_arritmias_outros_naoActionPerformed
        jTextField_arritmias_outros.setVisible(false);
        jTextField_arritmias_outros.setText("");
    }//GEN-LAST:event_jRadioButton_arritmias_outros_naoActionPerformed

    private void jRadioButton_efeito_colateral_outros_naoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_efeito_colateral_outros_naoActionPerformed
        jTextField_efeito_colateral_outros.setVisible(false);
        jTextField_efeito_colateral_outros.setText("");
    }//GEN-LAST:event_jRadioButton_efeito_colateral_outros_naoActionPerformed

    private void jButton_sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sairActionPerformed
        this.dispose();
       
        
    }//GEN-LAST:event_jButton_sairActionPerformed

    private void jComboBox_analise_v_e_repousoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_analise_v_e_repousoActionPerformed
        Fachada f = new Fachada();
        
        if(jComboBox_analise_v_e_repouso.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_analise_v_e_repouso.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_analise_v_e_repousoActionPerformed

    private void jComboBox_analise_v_e_pico_estresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_analise_v_e_pico_estresseActionPerformed
        Fachada f = new Fachada();
        
        if(jComboBox_analise_v_e_pico_estresse.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_analise_v_e_pico_estresse.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_analise_v_e_pico_estresseActionPerformed

    private void jComboBox_analise_v_e_recuperacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_analise_v_e_recuperacaoActionPerformed
        Fachada f = new Fachada();
        
        if(jComboBox_analise_v_e_recuperacao.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_analise_v_e_recuperacao.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_analise_v_e_recuperacaoActionPerformed

    private void jComboBox_conclusao_estresseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_conclusao_estresseActionPerformed
        Fachada f = new Fachada();
        
        if(jComboBox_conclusao_estresse.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_conclusao_estresse.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_conclusao_estresseActionPerformed

    private void jButton_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ImprimirActionPerformed
        // TODO add your handling code here:
        
        Esforco[] cincomcg = estresse.getCincomcg(), dezmcg = estresse.getDezmcg(), vintemcg = estresse.getVintemcg(), repouso = estresse.getRepouso();
        jTextField_10mcg_0_atropina.setText("" + dezmcg[0].getAtropina());
        jTextField_10mcg_0_eletrocardiograma.setText("" + dezmcg[0].getEletrocardiograma());
        jTextField_10mcg_0_fc.setText("" + dezmcg[0].getFc());
        jTextField_10mcg_0_pa.setText("" + dezmcg[0].getPa());
        jTextField_10mcg_1_atropina.setText("" + dezmcg[1].getAtropina());
        jTextField_10mcg_1_eletrocardiograma.setText("" + dezmcg[1].getEletrocardiograma());
        jTextField_10mcg_1_fc.setText("" + dezmcg[1].getFc());
        jTextField_10mcg_1_pa.setText("" + dezmcg[1].getPa());
        jTextField_20mcg_0_atropina.setText("" + vintemcg[0].getAtropina());
        jTextField_20mcg_0_eletrocardiograma.setText("" + vintemcg[0].getEletrocardiograma());
        jTextField_20mcg_0_fc.setText("" + vintemcg[0].getFc());
        jTextField_20mcg_0_pa.setText("" + vintemcg[0].getPa());
        jTextField_20mcg_1_atropina.setText("" + vintemcg[1].getAtropina());
        jTextField_20mcg_1_eletrocardiograma.setText("" + vintemcg[1].getEletrocardiograma());
        jTextField_20mcg_1_fc.setText("" + vintemcg[1].getFc());
        jTextField_20mcg_1_pa.setText("" + vintemcg[1].getPa());
        jTextField_5mcg_0_atropina.setText("" + cincomcg[0].getAtropina());
        jTextField_5mcg_0_eletrocardiograma.setText("" + cincomcg[0].getEletrocardiograma());
        jTextField_5mcg_0_fc.setText("" + cincomcg[0].getFc());
        jTextField_5mcg_0_pa.setText("" + cincomcg[0].getPa());
        jTextField_5mcg_1_atropina.setText("" + cincomcg[1].getAtropina());
        jTextField_5mcg_1_eletrocardiograma.setText("" + cincomcg[1].getEletrocardiograma());
        jTextField_5mcg_1_fc.setText("" + cincomcg[1].getFc());
        jTextField_5mcg_1_pa.setText("" + cincomcg[1].getPa());
        jTextField_repouso_0_atropina.setText("" + repouso[0].getAtropina());
        jTextField_repouso_0_eletrocardiograma.setText("" + repouso[0].getEletrocardiograma());
        jTextField_repouso_0_fc.setText("" + repouso[0].getFc());
        jTextField_repouso_0_pa.setText("" + repouso[0].getPa());
        jTextField_repouso_1_atropina.setText("" + repouso[1].getAtropina());
        jTextField_repouso_1_eletrocardiograma.setText("" + repouso[1].getEletrocardiograma());
        jTextField_repouso_1_fc.setText("" + repouso[1].getFc());
        jTextField_repouso_1_pa.setText("" + repouso[1].getPa());
        
        try{  
                
            Fachada f = new Fachada();
            f.excluirLaudoIreport();
            f.cadastrarLaudoIreport(estresse.getLaudoEcoId(), "");
            
            Connection con;
                Myconnection conexao = new Myconnection();
                con = conexao.getConnection();
                
                String local = System.getProperty("user.dir");  
 
                JasperDesign jasperDesign = JRXmlLoader.load(local+"/src/relatorio/Estresse.jrxml");  
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);  

                int ID_LAUDO = estresse.getLaudoEcoId();  

                Map parametro = new HashMap();  

                String imgNormalidade = local+"/src/imagens/", logo = local+"/src/imagens/logo.jpg";
                
                String arr01; String arr02; String arr03; String arr04; String arr05; String arr06; String arr07;
                String arr07_texto; 
                
                String ec01; String ec02; String ec03; String ec04; String ec05;
                String ec05_texto;
              
               
                if (estresse.isEsv()){
                    arr01 = "SIM";
                }else{
                    arr01 = "NÃO";
                }
                if (estresse.isEssv()){
                    arr02 = "SIM";
                }else{
                    arr02 = "NÃO";
                }
                if (estresse.isTvns()){
                    arr03 = "SIM";
                }else{
                    arr03 = "NÃO";
                }
                if (estresse.isTv()){
                    arr04 = "SIM";
                }else{
                    arr04 = "NÃO";
                }
                if (estresse.isFa()){
                    arr05 = "SIM";
                }else{
                    arr05 = "NÃO";
                }
                if (estresse.isBradicardia()){
                    arr06 = "SIM";
                }else{
                    arr06 = "NÃO";
                }
                if (estresse.getOutro_arritmia().trim().equals("")){
                    arr07 = "NÃO";                    
                }else{
                    arr07 = "SIM";                    
                }
               arr07_texto=estresse.getOutro_arritmia();
               
               
               if(estresse.isDor_precordial()){
                   ec01 = "SIM";
               }else{
                   ec01 = "NÃO";
               }
               
               if(estresse.isNausea()){
                   ec02 = "SIM";
               }else{
                   ec02 = "NÃO";
               }
               
               if(estresse.isHipotensao()){
                   ec03 = "SIM";
               }else{
                   ec03 = "NÃO";
               }
               
               if(estresse.isHipertensao()){
                   ec04 = "SIM";
               }else{
                   ec04 = "NÃO";
               }
                
               if (estresse.getOutro_ef_colateral().trim().equals("")){
                    ec05 = "NÃO";                    
               }else{
                    ec05 = "SIM";                    
               }
                ec05_texto=estresse.getOutro_ef_colateral();
                
                parametro.put("arr01",arr01); parametro.put("arr02",arr02); parametro.put("arr03",arr03); parametro.put("arr04",arr04);
                parametro.put("arr05",arr05); parametro.put("arr06",arr06); parametro.put("arr07",arr07); parametro.put("arr07_texto",arr07_texto);
                
                parametro.put("ec01",ec01); parametro.put("ec02",ec02); parametro.put("ec03",ec03); parametro.put("ec04",ec04);
                parametro.put("ec05",ec05); parametro.put("ec05_texto",ec05_texto); 
                
                parametro.put("11",""+repouso[0].getPa());  parametro.put("21",""+repouso[0].getFc());  parametro.put("31",""+repouso[0].getAtropina());  parametro.put("41",""+repouso[0].getEletrocardiograma()); 
                parametro.put("12",""+repouso[1].getPa());  parametro.put("22",""+repouso[1].getFc());  parametro.put("32",""+repouso[1].getAtropina());  parametro.put("42",""+repouso[1].getEletrocardiograma()); 
                parametro.put("13",""+cincomcg[0].getPa());  parametro.put("23",""+cincomcg[0].getFc());  parametro.put("33",""+cincomcg[0].getAtropina());  parametro.put("43",""+cincomcg[0].getEletrocardiograma());
                parametro.put("14",""+cincomcg[1].getPa());  parametro.put("24",""+cincomcg[1].getFc());  parametro.put("34",""+cincomcg[1].getAtropina());  parametro.put("44",""+cincomcg[1].getEletrocardiograma());
                parametro.put("15",""+dezmcg[0].getPa());  parametro.put("25",""+dezmcg[0].getFc());  parametro.put("35",""+dezmcg[0].getAtropina());  parametro.put("45",""+dezmcg[0].getEletrocardiograma());
                parametro.put("16",""+dezmcg[1].getPa());  parametro.put("26",""+dezmcg[1].getFc());  parametro.put("36",""+dezmcg[1].getAtropina());  parametro.put("46",""+dezmcg[1].getEletrocardiograma());
                parametro.put("17",""+vintemcg[0].getPa());  parametro.put("27",""+vintemcg[0].getFc());  parametro.put("37",""+vintemcg[0].getAtropina());  parametro.put("47",""+vintemcg[0].getEletrocardiograma());
                parametro.put("18",""+vintemcg[1].getPa());  parametro.put("28",""+vintemcg[1].getFc());  parametro.put("38",""+vintemcg[1].getAtropina());  parametro.put("48",""+vintemcg[1].getEletrocardiograma());
                
                parametro.put("Endereco",imgNormalidade);
                
                parametro.put("isEco",""+estresse.isEco());
                
                parametro.put("texto", estresse.getTexto());
                
                parametro.put("tipo", tipo);
                
                System.out.println(estresse.isEco()+"\n"+estresse.getLaudoEcoId());
                           
                JasperPrint print;  
              
                print = JasperFillManager.fillReport(jasperReport,parametro,con);
                         
                JasperViewer viewer = new JasperViewer(print,false);  
                
                viewer.setTitle("Visualização de impressão Laudo Eco");
                viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  
                if (!print.getPages().isEmpty()) {  
                        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);  
                        viewer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
                        viewer.setVisible(true);  
                }  
            }catch(Exception erro){  
                erro.printStackTrace(); 
                System.out.println(erro.getMessage());
            }  
    }//GEN-LAST:event_jButton_ImprimirActionPerformed

    private void jTextField_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_crmActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        this.setAlwaysOnTop(false);
        try {
            m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
            jTextField_nome.setText(m.getNome());

        } catch (MedicoErro ex) {

            Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jTextField_crmActionPerformed

    private void jButton_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_medicosActionPerformed
        // TODO add your handling code here:
        JDialog dialogo = new selecionaMedicoDial(this,true);
        dialogo.setVisible(true);
        Fachada f = new Fachada();
        try {
            
            this.setEnabled(true);
            Medico m = null;
            m = f.pesquisarMedicoAux();
            jTextField_nome.setText(m.getNome());
            jTextField_crm.setText(m.getCRM()+"");
                if(m!=null)
                    this.m = m;
            f.excluirMedicoAux(m);
        } catch (MedicoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_medicosActionPerformed

    private void jRadioButton_ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_ttActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        try {
            Eco ec = f.pesquisarLaudoEcoPorId(laudoEcoId);
            new editarCadastroLaudoEco(ec, this).setVisible(true);
            this.setVisible(false);
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jRadioButton_ttActionPerformed

    private void jRadioButton_SEPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPDActionPerformed
        // TODO add your handling code here:
        /*Fachada f = new Fachada();
        try {
            f.excluirLaudoUltimoId();
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        tipo = "SEPD";
        //eco.setTipo(tipo);
        jRadioButton_SEPE1.setSelected(false);
       /* try {
            f.cadastrarLaudoSub(eco);
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jRadioButton_SEPDActionPerformed

    private void jRadioButton_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_subActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        try {
            Eco e = f.pesquisarLaudoSubPorId(laudoEcoId);
            new editaCadastroSubjetivo(e, this).setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRadioButton_subActionPerformed

    private void jRadioButton_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_tActionPerformed
        // TODO add your handling code here:
         Fachada f = new Fachada();
        try {
            Eco ec = f.pesquisarLaudoEcoPorId(laudoEcoId);
            new editarCadastroLaudoEco(ec, this).setVisible(true);
            this.setVisible(false);
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jRadioButton_tActionPerformed

    private void jRadioButton_SEPE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPE1ActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
       /* try {
            f.excluirLaudoUltimoId();
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        tipo = "SEPE";
        //eco.setTipo(tipo);
        /*try {
            f.cadastrarLaudoSub(eco);
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroEcoEstresse.class.getName()).log(Level.SEVERE, null, ex);
        }*/

        jRadioButton_SEPD.setSelected(false);
    }//GEN-LAST:event_jRadioButton_SEPE1ActionPerformed

    private void jRadioButton_escActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_escActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        
        LaudoEscore es = f.getLaudoEscoreById(laudoEcoId);
        if(this.tipoLaudo.equals("sub")){
            if(es.getLaudoEcoId() == 0){
                new cadastroEscore(laudoEcoId,p, m, c, this,"sub").setVisible(true);
                    this.dispose();
           
            }else{

                    new editarEscore(p, m, c, es,laudoEcoId,"sub").setVisible(true);
                    this.dispose();


            }
        }else{
             if(es.getLaudoEcoId() == 0){
                new cadastroEscore(laudoEcoId,p, m, c, this).setVisible(true);
                    this.dispose();
           
            }else{

                    new editarEscore(p, m, c, es,laudoEcoId).setVisible(true);
                    this.dispose();


            }        
        }
    }//GEN-LAST:event_jRadioButton_escActionPerformed
    
    
    String tipoLaudo="";
    String tipo="";
    Eco eco;
    Medico m;
    Paciente p;
    Convenio c;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_bradicardia;
    private javax.swing.ButtonGroup buttonGroup_dor_precordial;
    private javax.swing.ButtonGroup buttonGroup_efeito_colateral_outros;
    private javax.swing.ButtonGroup buttonGroup_essv;
    private javax.swing.ButtonGroup buttonGroup_esv;
    private javax.swing.ButtonGroup buttonGroup_fa;
    private javax.swing.ButtonGroup buttonGroup_hipertensao;
    private javax.swing.ButtonGroup buttonGroup_hiportensao;
    private javax.swing.ButtonGroup buttonGroup_nausea;
    private javax.swing.ButtonGroup buttonGroup_outros;
    private javax.swing.ButtonGroup buttonGroup_tv;
    private javax.swing.ButtonGroup buttonGroup_tvns;
    private javax.swing.JButton jButton_Imprimir;
    private javax.swing.JButton jButton_atualizar;
    private javax.swing.JButton jButton_medicos;
    private javax.swing.JButton jButton_sair;
    private javax.swing.JComboBox jComboBox_analise_v_e_pico_estresse;
    private javax.swing.JComboBox jComboBox_analise_v_e_recuperacao;
    private javax.swing.JComboBox jComboBox_analise_v_e_repouso;
    private javax.swing.JComboBox jComboBox_conclusao_estresse;
    private javax.swing.JComboBox jComboBox_convenio;
    private javax.swing.JDesktopPane jDesktopPane_geral;
    private javax.swing.JLabel jLabel_10mcg_0;
    private javax.swing.JLabel jLabel_10mcg_1;
    private javax.swing.JLabel jLabel_20mcg_0;
    private javax.swing.JLabel jLabel_20mcg_1;
    private javax.swing.JLabel jLabel_5mcg_0;
    private javax.swing.JLabel jLabel_5mcg_1;
    private javax.swing.JLabel jLabel_Convenio;
    private javax.swing.JLabel jLabel_analise_v_e_pico_estresse;
    private javax.swing.JLabel jLabel_analise_v_e_recuperacao;
    private javax.swing.JLabel jLabel_analise_v_e_repouso;
    private javax.swing.JLabel jLabel_arritmias_outros;
    private javax.swing.JLabel jLabel_atropina;
    private javax.swing.JLabel jLabel_bg_attitmias;
    private javax.swing.JLabel jLabel_bg_attitmias1;
    private javax.swing.JLabel jLabel_bg_est_esforco;
    private javax.swing.JLabel jLabel_bradicardia;
    private javax.swing.JLabel jLabel_conclusao_estresse;
    private javax.swing.JLabel jLabel_dor_precordial;
    private javax.swing.JLabel jLabel_efeito_colateral_outros;
    private javax.swing.JLabel jLabel_eletrocardiograma;
    private javax.swing.JLabel jLabel_essv;
    private javax.swing.JLabel jLabel_est_esforco;
    private javax.swing.JLabel jLabel_esv;
    private javax.swing.JLabel jLabel_fa;
    private javax.swing.JLabel jLabel_fc;
    private javax.swing.JLabel jLabel_hipertensao;
    private javax.swing.JLabel jLabel_hipotensao;
    private javax.swing.JLabel jLabel_medicoResp;
    private javax.swing.JLabel jLabel_nausea;
    private javax.swing.JLabel jLabel_nome_paciente;
    private javax.swing.JLabel jLabel_pa;
    private javax.swing.JLabel jLabel_paciente;
    private javax.swing.JLabel jLabel_repouso_0;
    private javax.swing.JLabel jLabel_repouso_1;
    private javax.swing.JLabel jLabel_tipo;
    private javax.swing.JLabel jLabel_tv;
    private javax.swing.JLabel jLabel_tvns;
    private javax.swing.JPanel jPanel_geral;
    private javax.swing.JRadioButton jRadioButton_SEPD;
    private javax.swing.JRadioButton jRadioButton_SEPE1;
    private javax.swing.JRadioButton jRadioButton_arritmias_outros_nao;
    private javax.swing.JRadioButton jRadioButton_arritmias_outros_sim;
    private javax.swing.JRadioButton jRadioButton_bradicardia_nao;
    private javax.swing.JRadioButton jRadioButton_bradicardia_sim;
    private javax.swing.JRadioButton jRadioButton_dor_precordial_nao;
    private javax.swing.JRadioButton jRadioButton_dor_precordial_sim;
    private javax.swing.JRadioButton jRadioButton_efeito_colateral_outros_nao;
    private javax.swing.JRadioButton jRadioButton_efeito_colateral_outros_sim;
    private javax.swing.JRadioButton jRadioButton_esc;
    private javax.swing.JRadioButton jRadioButton_essv_nao;
    private javax.swing.JRadioButton jRadioButton_essv_sim;
    private javax.swing.JRadioButton jRadioButton_esv_nao;
    private javax.swing.JRadioButton jRadioButton_esv_sim;
    private javax.swing.JRadioButton jRadioButton_fa_nao;
    private javax.swing.JRadioButton jRadioButton_fa_sim;
    private javax.swing.JRadioButton jRadioButton_hipertensao_nao;
    private javax.swing.JRadioButton jRadioButton_hipertensao_sim;
    private javax.swing.JRadioButton jRadioButton_hipotensao_nao;
    private javax.swing.JRadioButton jRadioButton_hipotensao_sim;
    private javax.swing.JRadioButton jRadioButton_nausea_nao;
    private javax.swing.JRadioButton jRadioButton_nausea_sim;
    private javax.swing.JRadioButton jRadioButton_sub;
    private javax.swing.JRadioButton jRadioButton_t;
    private javax.swing.JRadioButton jRadioButton_tt;
    private javax.swing.JRadioButton jRadioButton_tv_nao;
    private javax.swing.JRadioButton jRadioButton_tv_sim;
    private javax.swing.JRadioButton jRadioButton_tvns_nao1;
    private javax.swing.JRadioButton jRadioButton_tvns_sim1;
    private javax.swing.JScrollPane jScrollPane_texto;
    private javax.swing.JTextArea jTextArea_texto;
    private javax.swing.JTextField jTextField_10mcg_0_atropina;
    private javax.swing.JTextField jTextField_10mcg_0_eletrocardiograma;
    private javax.swing.JTextField jTextField_10mcg_0_fc;
    private javax.swing.JTextField jTextField_10mcg_0_pa;
    private javax.swing.JTextField jTextField_10mcg_1_atropina;
    private javax.swing.JTextField jTextField_10mcg_1_eletrocardiograma;
    private javax.swing.JTextField jTextField_10mcg_1_fc;
    private javax.swing.JTextField jTextField_10mcg_1_pa;
    private javax.swing.JTextField jTextField_20mcg_0_atropina;
    private javax.swing.JTextField jTextField_20mcg_0_eletrocardiograma;
    private javax.swing.JTextField jTextField_20mcg_0_fc;
    private javax.swing.JTextField jTextField_20mcg_0_pa;
    private javax.swing.JTextField jTextField_20mcg_1_atropina;
    private javax.swing.JTextField jTextField_20mcg_1_eletrocardiograma;
    private javax.swing.JTextField jTextField_20mcg_1_fc;
    private javax.swing.JTextField jTextField_20mcg_1_pa;
    private javax.swing.JTextField jTextField_5mcg_0_atropina;
    private javax.swing.JTextField jTextField_5mcg_0_eletrocardiograma;
    private javax.swing.JTextField jTextField_5mcg_0_fc;
    private javax.swing.JTextField jTextField_5mcg_0_pa;
    private javax.swing.JTextField jTextField_5mcg_1_atropina;
    private javax.swing.JTextField jTextField_5mcg_1_eletrocardiograma;
    private javax.swing.JTextField jTextField_5mcg_1_fc;
    private javax.swing.JTextField jTextField_5mcg_1_pa;
    private javax.swing.JTextField jTextField_arritmias_outros;
    private javax.swing.JTextField jTextField_crm;
    private javax.swing.JTextField jTextField_efeito_colateral_outros;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_repouso_0_atropina;
    private javax.swing.JTextField jTextField_repouso_0_eletrocardiograma;
    private javax.swing.JTextField jTextField_repouso_0_fc;
    private javax.swing.JTextField jTextField_repouso_0_pa;
    private javax.swing.JTextField jTextField_repouso_1_atropina;
    private javax.swing.JTextField jTextField_repouso_1_eletrocardiograma;
    private javax.swing.JTextField jTextField_repouso_1_fc;
    private javax.swing.JTextField jTextField_repouso_1_pa;
    // End of variables declaration//GEN-END:variables
}
