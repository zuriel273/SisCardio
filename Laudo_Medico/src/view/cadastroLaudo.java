/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import base.Base;
import conexao.Myconnection;
import convenio.Convenio;
import convenio.ConvenioErro;
import fachada.Fachada;
import java.awt.Dialog;
import java.util.*;
import java.util.logging.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import laudo.Eco;
import laudo.LaudoErro;
import medico.Medico;
import medico.MedicoErro;
import paciente.*; 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pereiras
 */
public class cadastroLaudo extends javax.swing.JFrame {

    /**
     * Creates new form cadastroLaudo
     */
    private JFrame pai;
    
    public cadastroLaudo(Paciente p, JFrame pai) {
        this.setAlwaysOnTop(true);
        this.pai = pai;
        initComponents();
        
        
         Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.p = p;
        jLabel_nome_paciente.setText(p.getNome());
        jRadioButton_tt.setSelected(true);
        jRadioButton_teicholz.setSelected(true);
        this.jRadioButton_teicholzActionPerformed(null);
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public cadastroLaudo(Paciente p,Medico m, Convenio c,boolean h, JFrame pai) {
        this.setAlwaysOnTop(true);
        initComponents();
        //this.getContentPane().add(new JScrollPane(this),BorderLayout.CENTER);
        //content.add(new JScrollPane(this),BorderLayout.CENTER);
        Toolkit tk = Toolkit.getDefaultToolkit();  
        Dimension x= tk.getScreenSize();
        jTextField_nome.setEnabled(false);
        
        //this.setSize(x);
       // jDesktopPane_Geral.setSize(x);
        this.m = m;
        this.c = c;
        this.p = p;
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        if(h == true){
            jRadioButton_tt.setSelected(true);}
        else{
            jRadioButton_t.setSelected(true);
        }
        jRadioButton_teicholz.setSelected(true);
        this.jRadioButton_teicholzActionPerformed(null);
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarCombo() throws ConvenioErro{
         this.setAlwaysOnTop(false);
         Fachada f = new Fachada();
         List listar = f.pesquisarConvenioPorStatus();
         Iterator it = listar.iterator();
         while(it.hasNext()){
             Convenio c = (Convenio)it.next();             
             jComboBox_convenio.addItem(c.getNome()); 
             if(this.c != null){
                if(this.c.getNome().equals(c.getNome())){
                       jComboBox_convenio.setSelectedItem(c.getNome());
                       
                }
             }
         }
         
        try {
            List listarCamarasCardiacas = f.pesquisarComboPorTipo("camaras_cardiacas");
            Iterator it2 = listarCamarasCardiacas.iterator();
            while(it2.hasNext()){
             String sigla = (String)it2.next();
             jComboBox_CamarasCardiacas.addItem(sigla);
             System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            List listar2 = f.pesquisarComboPorTipo("modelo");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_modelo.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try {
            List listar2 = f.pesquisarComboPorTipo("septos");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_septos.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listar2 = f.pesquisarComboPorTipo("ventriculos");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_Ventriculos.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listar2 = f.pesquisarComboPorTipo("aorta");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_aorta1.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listar2 = f.pesquisarComboPorTipo("observações");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_observacoes.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listarCamarasCardiacas = f.pesquisarComboPorTipo("pericardio");
            Iterator it2 = listarCamarasCardiacas.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_pericardio.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listarCamarasCardiacas = f.pesquisarComboPorTipo("valva_aortica");
            Iterator it2 = listarCamarasCardiacas.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_valvaAortica.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List listarCamarasCardiacas = f.pesquisarComboPorTipo("valva_tricuspide");
            Iterator it2 = listarCamarasCardiacas.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_valvaTricuspide.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            List listar2 = f.pesquisarComboPorTipo("valva_mitral");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_valvaMitral.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         try {
            List listar2 = f.pesquisarComboPorTipo("valva_pulmonar");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_valvaPulmonar.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
            List listar2 = f.pesquisarComboPorTipo("conclusao");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_conclusao.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
          
           try {
            List listar2 = f.pesquisarComboPorTipo("trombosEmassas");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_trombosEmassas1.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          try {
            List listar2 = f.pesquisarComboPorTipo("aortaEarteria_pulmonar");
            Iterator it2 = listar2.iterator();
            while(it2.hasNext()){
                String sigla = (String)it2.next();
                jComboBox_aortaEarteria1.addItem(sigla);
                System.out.println(sigla); 
            }           
            
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTextArea_texto.setText("");
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_tipos_laudos = new javax.swing.ButtonGroup();
        buttonGroup_metodo_calculo = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane_Geral = new javax.swing.JDesktopPane();
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
        jRadioButton_SEPE = new javax.swing.JRadioButton();
        jLabel_calculo = new javax.swing.JLabel();
        jRadioButton_teicholz = new javax.swing.JRadioButton();
        jRadioButton_simpson = new javax.swing.JRadioButton();
        jRadioButton_bidimensional = new javax.swing.JRadioButton();
        jLabel_borda = new javax.swing.JLabel();
        jLabel_borda_calculo = new javax.swing.JLabel();
        jLabel_peso = new javax.swing.JLabel();
        jTextField_peso = new javax.swing.JTextField();
        jLabel_SIV = new javax.swing.JLabel();
        jTextField_SIV = new javax.swing.JTextField();
        jLabel_AE = new javax.swing.JLabel();
        jTextField_AE = new javax.swing.JTextField();
        jLabel_DDVE = new javax.swing.JLabel();
        jTextField_DDVE = new javax.swing.JTextField();
        jLabel_DDVD = new javax.swing.JLabel();
        jTextField_DDVD = new javax.swing.JTextField();
        jLabel_altura = new javax.swing.JLabel();
        jTextField_altura = new javax.swing.JTextField();
        jLabel_aorta = new javax.swing.JLabel();
        jTextField_aorta = new javax.swing.JTextField();
        jLabel_DSVE = new javax.swing.JLabel();
        jTextField_DSVE = new javax.swing.JTextField();
        jLabel_PP = new javax.swing.JLabel();
        jTextField_pp = new javax.swing.JTextField();
        jButton_calcular = new javax.swing.JButton();
        jButton_fechar = new javax.swing.JButton();
        jButton_salvar = new javax.swing.JButton();
        jLabel_vsf = new javax.swing.JLabel();
        jTextField_vsf = new javax.swing.JTextField();
        jLabel_vdf = new javax.swing.JLabel();
        jTextField_vdf = new javax.swing.JTextField();
        jLabel_fe = new javax.swing.JLabel();
        jTextField_fe = new javax.swing.JTextField();
        jLabel_enc_cav = new javax.swing.JLabel();
        jTextField_endCav = new javax.swing.JTextField();
        jLabel_ind_expessura_rel = new javax.swing.JLabel();
        jTextField_indExpessuraRel = new javax.swing.JTextField();
        jLabel_superficie_corporea = new javax.swing.JLabel();
        jTextField_superficieCorporea = new javax.swing.JTextField();
        jLabel_massa_ve = new javax.swing.JLabel();
        jTextField_massa_ve = new javax.swing.JTextField();
        jLabel_ind_massa_ve = new javax.swing.JLabel();
        jTextField_ind_massa_ve = new javax.swing.JTextField();
        jLabel_rel_ae_por_ao = new javax.swing.JLabel();
        jTextField_relAEAO = new javax.swing.JTextField();
        jLabel_borda_calcular = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_modelo = new javax.swing.JComboBox();
        jLabel2_septos = new javax.swing.JLabel();
        jComboBox_septos = new javax.swing.JComboBox();
        jLabel2_CamarasCardiacas = new javax.swing.JLabel();
        jLabel2_aorta = new javax.swing.JLabel();
        jLabel2_valvaMitral = new javax.swing.JLabel();
        jLabel2_valvaAortica = new javax.swing.JLabel();
        jComboBox_CamarasCardiacas = new javax.swing.JComboBox();
        jComboBox_conclusao = new javax.swing.JComboBox();
        jComboBox_valvaMitral = new javax.swing.JComboBox();
        jComboBox_valvaAortica = new javax.swing.JComboBox();
        jComboBox_valvaTricuspide = new javax.swing.JComboBox();
        jComboBox_valvaPulmonar = new javax.swing.JComboBox();
        jLabel_tricuspide = new javax.swing.JLabel();
        jComboBox_Ventriculos = new javax.swing.JComboBox();
        jLabel_pulmonar = new javax.swing.JLabel();
        jComboBox_pericardio = new javax.swing.JComboBox();
        jLabel_ventriculos = new javax.swing.JLabel();
        jComboBox_observacoes = new javax.swing.JComboBox();
        jLabel_pericardio = new javax.swing.JLabel();
        jLabel_observacoes = new javax.swing.JLabel();
        jLabel2_borda_combo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_texto = new javax.swing.JTextArea();
        jLabel_aortaEarteria = new javax.swing.JLabel();
        jComboBox_aorta1 = new javax.swing.JComboBox();
        jLabel_trombosEmassas = new javax.swing.JLabel();
        jComboBox_aortaEarteria1 = new javax.swing.JComboBox();
        jLabel_conclusao = new javax.swing.JLabel();
        jComboBox_trombosEmassas1 = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Cadastro Laudo");
        setAlwaysOnTop(true);

        jDesktopPane_Geral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_paciente.setText("Paciente");
        jLabel_paciente.setBounds(10, 30, 70, 26);
        jDesktopPane_Geral.add(jLabel_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel_nome_paciente.setBounds(90, 30, 510, 26);
        jDesktopPane_Geral.add(jLabel_nome_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_Convenio.setText("Convênio");
        jLabel_Convenio.setBounds(10, 66, 70, 26);
        jDesktopPane_Geral.add(jLabel_Convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_convenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_convenio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_convenioActionPerformed(evt);
            }
        });
        jComboBox_convenio.setBounds(90, 66, 360, 26);
        jDesktopPane_Geral.add(jComboBox_convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_medicoResp.setText("Médico Responsável:");
        jLabel_medicoResp.setBounds(10, 102, 150, 26);
        jDesktopPane_Geral.add(jLabel_medicoResp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_crm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_crmActionPerformed(evt);
            }
        });
        jTextField_crm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_crmFocusLost(evt);
            }
        });
        jTextField_crm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_crmKeyReleased(evt);
            }
        });
        jTextField_crm.setBounds(160, 102, 60, 26);
        jDesktopPane_Geral.add(jTextField_crm, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_nome.setEditable(false);
        jTextField_nome.setBounds(230, 102, 370, 26);
        jDesktopPane_Geral.add(jTextField_nome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_medicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/busca.png"))); // NOI18N
        jButton_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_medicosActionPerformed(evt);
            }
        });
        jButton_medicos.setBounds(610, 97, 46, 36);
        jDesktopPane_Geral.add(jButton_medicos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tipo.setText("Tipos de laudos:");
        jLabel_tipo.setBounds(670, 30, 120, 14);
        jDesktopPane_Geral.add(jLabel_tipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tt.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_tt);
        jRadioButton_tt.setText("Transtorácico e Transesofágico");
        jRadioButton_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ttActionPerformed(evt);
            }
        });
        jRadioButton_tt.setBounds(790, 30, 260, 23);
        jDesktopPane_Geral.add(jRadioButton_tt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPD);
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });
        jRadioButton_SEPD.setBounds(790, 60, 260, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_sub);
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });
        jRadioButton_sub.setBounds(790, 90, 300, 23);
        jDesktopPane_Geral.add(jRadioButton_sub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_t.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_t);
        jRadioButton_t.setText("Transtorácico");
        jRadioButton_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_tActionPerformed(evt);
            }
        });
        jRadioButton_t.setBounds(1060, 30, 230, 23);
        jDesktopPane_Geral.add(jRadioButton_t, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPE.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPE);
        jRadioButton_SEPE.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPEActionPerformed(evt);
            }
        });
        jRadioButton_SEPE.setBounds(1060, 60, 230, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_calculo.setText("Método do cálculo:");
        jLabel_calculo.setBounds(10, 170, 160, 14);
        jDesktopPane_Geral.add(jLabel_calculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_teicholz.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_teicholz);
        jRadioButton_teicholz.setText("Teicholz");
        jRadioButton_teicholz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_teicholzActionPerformed(evt);
            }
        });
        jRadioButton_teicholz.setBounds(190, 170, 120, 23);
        jDesktopPane_Geral.add(jRadioButton_teicholz, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_simpson.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_simpson);
        jRadioButton_simpson.setText("Simpson");
        jRadioButton_simpson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_simpsonActionPerformed(evt);
            }
        });
        jRadioButton_simpson.setBounds(330, 170, 100, 23);
        jDesktopPane_Geral.add(jRadioButton_simpson, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_bidimensional.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_bidimensional);
        jRadioButton_bidimensional.setText("Bidimensional");
        jRadioButton_bidimensional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_bidimensionalActionPerformed(evt);
            }
        });
        jRadioButton_bidimensional.setBounds(490, 170, 130, 23);
        jDesktopPane_Geral.add(jRadioButton_bidimensional, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda.setBounds(660, 20, 645, 110);
        jDesktopPane_Geral.add(jLabel_borda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda_calculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda_calculo.setBounds(0, 160, 645, 40);
        jDesktopPane_Geral.add(jLabel_borda_calculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_peso.setText("Peso(kg)");
        jLabel_peso.setToolTipText("");
        jLabel_peso.setBounds(20, 230, 100, 28);
        jDesktopPane_Geral.add(jLabel_peso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_peso.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_pesoFocusLost(evt);
            }
        });
        jTextField_peso.setBounds(150, 230, 120, 28);
        jDesktopPane_Geral.add(jTextField_peso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_SIV.setText("SIV(cm)");
        jLabel_SIV.setBounds(20, 265, 100, 28);
        jDesktopPane_Geral.add(jLabel_SIV, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_SIV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_SIVFocusLost(evt);
            }
        });
        jTextField_SIV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_SIVKeyReleased(evt);
            }
        });
        jTextField_SIV.setBounds(150, 265, 120, 28);
        jDesktopPane_Geral.add(jTextField_SIV, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_AE.setText("AE(cm)");
        jLabel_AE.setBounds(20, 300, 100, 28);
        jDesktopPane_Geral.add(jLabel_AE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_AE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_AEFocusLost(evt);
            }
        });
        jTextField_AE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_AEKeyReleased(evt);
            }
        });
        jTextField_AE.setBounds(150, 300, 120, 28);
        jDesktopPane_Geral.add(jTextField_AE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DDVE.setText("DDVE(cm)");
        jLabel_DDVE.setBounds(20, 335, 100, 28);
        jDesktopPane_Geral.add(jLabel_DDVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_DDVE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DDVEFocusLost(evt);
            }
        });
        jTextField_DDVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DDVEKeyReleased(evt);
            }
        });
        jTextField_DDVE.setBounds(150, 335, 120, 28);
        jDesktopPane_Geral.add(jTextField_DDVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DDVD.setText("DDVD(cm)");
        jLabel_DDVD.setBounds(20, 370, 100, 28);
        jDesktopPane_Geral.add(jLabel_DDVD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_DDVD.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DDVDFocusLost(evt);
            }
        });
        jTextField_DDVD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DDVDKeyReleased(evt);
            }
        });
        jTextField_DDVD.setBounds(150, 370, 120, 28);
        jDesktopPane_Geral.add(jTextField_DDVD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_altura.setText("Altura(cm)");
        jLabel_altura.setBounds(400, 230, 100, 28);
        jDesktopPane_Geral.add(jLabel_altura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_altura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_alturaFocusLost(evt);
            }
        });
        jTextField_altura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_alturaKeyReleased(evt);
            }
        });
        jTextField_altura.setBounds(500, 230, 120, 28);
        jDesktopPane_Geral.add(jTextField_altura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_aorta.setText("Aorta(cm)");
        jLabel_aorta.setBounds(400, 270, 100, 28);
        jDesktopPane_Geral.add(jLabel_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_aorta.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_aortaFocusLost(evt);
            }
        });
        jTextField_aorta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_aortaKeyReleased(evt);
            }
        });
        jTextField_aorta.setBounds(500, 270, 120, 28);
        jDesktopPane_Geral.add(jTextField_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DSVE.setText("DSVE(cm)");
        jLabel_DSVE.setBounds(400, 340, 100, 28);
        jDesktopPane_Geral.add(jLabel_DSVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_DSVE.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_DSVEFocusLost(evt);
            }
        });
        jTextField_DSVE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DSVEKeyReleased(evt);
            }
        });
        jTextField_DSVE.setBounds(500, 340, 120, 28);
        jDesktopPane_Geral.add(jTextField_DSVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_PP.setText("PP(cm)");
        jLabel_PP.setBounds(400, 370, 100, 28);
        jDesktopPane_Geral.add(jLabel_PP, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_pp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_ppFocusLost(evt);
            }
        });
        jTextField_pp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ppKeyReleased(evt);
            }
        });
        jTextField_pp.setBounds(500, 370, 120, 28);
        jDesktopPane_Geral.add(jTextField_pp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book_keeping.png"))); // NOI18N
        jButton_calcular.setMnemonic('l');
        jButton_calcular.setText("Calcular");
        jButton_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularActionPerformed(evt);
            }
        });
        jButton_calcular.setBounds(270, 410, 120, 40);
        jDesktopPane_Geral.add(jButton_calcular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png"))); // NOI18N
        jButton_fechar.setMnemonic('v');
        jButton_fechar.setText("Voltar");
        jButton_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fecharActionPerformed(evt);
            }
        });
        jButton_fechar.setBounds(940, 980, 120, 40);
        jDesktopPane_Geral.add(jButton_fechar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_salvar.setMnemonic('s');
        jButton_salvar.setText("Salvar");
        jButton_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salvarActionPerformed(evt);
            }
        });
        jButton_salvar.setBounds(340, 980, 120, 40);
        jDesktopPane_Geral.add(jButton_salvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_vsf.setText("VSF(ml)");
        jLabel_vsf.setBounds(20, 470, 150, 28);
        jDesktopPane_Geral.add(jLabel_vsf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_vsf.setBounds(190, 470, 100, 28);
        jDesktopPane_Geral.add(jTextField_vsf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_vdf.setText("VDF(ml)");
        jLabel_vdf.setBounds(350, 470, 150, 28);
        jDesktopPane_Geral.add(jLabel_vdf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_vdf.setBounds(490, 470, 100, 28);
        jDesktopPane_Geral.add(jTextField_vdf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_fe.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_fe.setText("FE(%)");
        jLabel_fe.setBounds(350, 500, 150, 28);
        jDesktopPane_Geral.add(jLabel_fe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_fe.setBounds(490, 500, 100, 28);
        jDesktopPane_Geral.add(jTextField_fe, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_enc_cav.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_enc_cav.setText("Enc. Cav.(%)");
        jLabel_enc_cav.setBounds(20, 500, 150, 28);
        jDesktopPane_Geral.add(jLabel_enc_cav, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_endCav.setBounds(190, 500, 100, 28);
        jDesktopPane_Geral.add(jTextField_endCav, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ind_expessura_rel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_ind_expessura_rel.setText("Ind. Expessura Rel.");
        jLabel_ind_expessura_rel.setBounds(20, 530, 150, 28);
        jDesktopPane_Geral.add(jLabel_ind_expessura_rel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_indExpessuraRel.setBounds(190, 530, 100, 28);
        jDesktopPane_Geral.add(jTextField_indExpessuraRel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_superficie_corporea.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_superficie_corporea.setText("Superficie Corporea(m²)");
        jLabel_superficie_corporea.setBounds(20, 560, 160, 28);
        jDesktopPane_Geral.add(jLabel_superficie_corporea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_superficieCorporea.setBounds(190, 560, 100, 28);
        jDesktopPane_Geral.add(jTextField_superficieCorporea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_massa_ve.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_massa_ve.setText("Massa VE(g)");
        jLabel_massa_ve.setBounds(350, 530, 150, 28);
        jDesktopPane_Geral.add(jLabel_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_massa_ve.setBounds(490, 530, 100, 28);
        jDesktopPane_Geral.add(jTextField_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ind_massa_ve.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_ind_massa_ve.setText("Ind. Massa VE(g/m²)");
        jLabel_ind_massa_ve.setBounds(350, 560, 150, 28);
        jDesktopPane_Geral.add(jLabel_ind_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_ind_massa_ve.setBounds(490, 560, 100, 28);
        jDesktopPane_Geral.add(jTextField_ind_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_rel_ae_por_ao.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_rel_ae_por_ao.setText("Rel. AE/AO");
        jLabel_rel_ae_por_ao.setBounds(20, 590, 150, 28);
        jDesktopPane_Geral.add(jLabel_rel_ae_por_ao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_relAEAO.setBounds(190, 590, 100, 28);
        jDesktopPane_Geral.add(jTextField_relAEAO, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda_calcular.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda_calcular.setBounds(0, 210, 645, 430);
        jDesktopPane_Geral.add(jLabel_borda_calcular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Modelo:");
        jLabel1.setBounds(670, 190, 90, 14);
        jDesktopPane_Geral.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_modelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione .:" }));
        jComboBox_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_modeloActionPerformed(evt);
            }
        });
        jComboBox_modelo.setBounds(840, 180, 370, 30);
        jDesktopPane_Geral.add(jComboBox_modelo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_septos.setText("Septos:");
        jLabel2_septos.setBounds(670, 220, 70, 30);
        jDesktopPane_Geral.add(jLabel2_septos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_septos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_septos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_septosActionPerformed(evt);
            }
        });
        jComboBox_septos.setBounds(840, 220, 130, 30);
        jDesktopPane_Geral.add(jComboBox_septos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_CamarasCardiacas.setText("Câmaras Cardíacas:");
        jLabel2_CamarasCardiacas.setBounds(670, 260, 140, 30);
        jDesktopPane_Geral.add(jLabel2_CamarasCardiacas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_aorta.setText("Aorta:");
        jLabel2_aorta.setBounds(670, 310, 60, 14);
        jDesktopPane_Geral.add(jLabel2_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_valvaMitral.setText("Valva Mitral:");
        jLabel2_valvaMitral.setBounds(670, 350, 130, 14);
        jDesktopPane_Geral.add(jLabel2_valvaMitral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_valvaAortica.setText("Valva Aórtica:");
        jLabel2_valvaAortica.setBounds(670, 380, 100, 14);
        jDesktopPane_Geral.add(jLabel2_valvaAortica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_CamarasCardiacas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_CamarasCardiacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CamarasCardiacasActionPerformed(evt);
            }
        });
        jComboBox_CamarasCardiacas.setBounds(840, 260, 130, 30);
        jDesktopPane_Geral.add(jComboBox_CamarasCardiacas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_conclusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_conclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_conclusaoActionPerformed(evt);
            }
        });
        jComboBox_conclusao.setBounds(1150, 460, 130, 30);
        jDesktopPane_Geral.add(jComboBox_conclusao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaMitral.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaMitral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaMitralActionPerformed(evt);
            }
        });
        jComboBox_valvaMitral.setBounds(840, 340, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaMitral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaAortica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaAortica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaAorticaActionPerformed(evt);
            }
        });
        jComboBox_valvaAortica.setBounds(840, 380, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaAortica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaTricuspide.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaTricuspide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaTricuspideActionPerformed(evt);
            }
        });
        jComboBox_valvaTricuspide.setBounds(840, 420, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaTricuspide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaPulmonar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaPulmonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaPulmonarActionPerformed(evt);
            }
        });
        jComboBox_valvaPulmonar.setBounds(840, 460, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaPulmonar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tricuspide.setText("Valva Tricúspide:");
        jLabel_tricuspide.setBounds(670, 420, 140, 30);
        jDesktopPane_Geral.add(jLabel_tricuspide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_Ventriculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_Ventriculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_VentriculosActionPerformed(evt);
            }
        });
        jComboBox_Ventriculos.setBounds(840, 500, 130, 30);
        jDesktopPane_Geral.add(jComboBox_Ventriculos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_pulmonar.setText("Valva Pulmonar:");
        jLabel_pulmonar.setBounds(670, 460, 130, 30);
        jDesktopPane_Geral.add(jLabel_pulmonar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_pericardio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_pericardio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pericardioActionPerformed(evt);
            }
        });
        jComboBox_pericardio.setBounds(840, 540, 130, 30);
        jDesktopPane_Geral.add(jComboBox_pericardio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ventriculos.setText("Ventriculos:");
        jLabel_ventriculos.setBounds(670, 500, 100, 30);
        jDesktopPane_Geral.add(jLabel_ventriculos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_observacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_observacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_observacoesActionPerformed(evt);
            }
        });
        jComboBox_observacoes.setBounds(840, 580, 130, 30);
        jDesktopPane_Geral.add(jComboBox_observacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_pericardio.setText("Pericardio:");
        jLabel_pericardio.setBounds(670, 540, 90, 30);
        jDesktopPane_Geral.add(jLabel_pericardio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_observacoes.setText("Observações:");
        jLabel_observacoes.setBounds(670, 580, 110, 30);
        jDesktopPane_Geral.add(jLabel_observacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_borda_combo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2_borda_combo.setBounds(660, 160, 645, 480);
        jDesktopPane_Geral.add(jLabel2_borda_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea_texto.setColumns(20);
        jTextArea_texto.setRows(5);
        jScrollPane1.setViewportView(jTextArea_texto);

        jScrollPane1.setBounds(330, 650, 680, 310);
        jDesktopPane_Geral.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_aortaEarteria.setText("Aorta e Artéria:");
        jLabel_aortaEarteria.setBounds(1020, 310, 120, 20);
        jDesktopPane_Geral.add(jLabel_aortaEarteria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_aorta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_aorta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_aorta1ActionPerformed(evt);
            }
        });
        jComboBox_aorta1.setBounds(840, 300, 130, 30);
        jDesktopPane_Geral.add(jComboBox_aorta1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_trombosEmassas.setText("Trombos e Massas:");
        jLabel_trombosEmassas.setBounds(1010, 380, 140, 14);
        jDesktopPane_Geral.add(jLabel_trombosEmassas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_aortaEarteria1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_aortaEarteria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_aortaEarteria1ActionPerformed(evt);
            }
        });
        jComboBox_aortaEarteria1.setBounds(1150, 300, 130, 30);
        jDesktopPane_Geral.add(jComboBox_aortaEarteria1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_conclusao.setText("Conclusão:");
        jLabel_conclusao.setBounds(1020, 460, 90, 30);
        jDesktopPane_Geral.add(jLabel_conclusao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_trombosEmassas1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_trombosEmassas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_trombosEmassas1ActionPerformed(evt);
            }
        });
        jComboBox_trombosEmassas1.setBounds(1150, 370, 130, 30);
        jDesktopPane_Geral.add(jComboBox_trombosEmassas1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 1336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane2.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1264, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        this.setAlwaysOnTop(false);
        Fachada f = new Fachada();
        try {
            if(jRadioButton_SEPD.isSelected()){
                tt.setTipo("SEPD");
            }
            if(jRadioButton_SEPE.isSelected()){
                tt.setTipo("SEPE");
            }
            
            tt.setTexto(jTextArea_texto.getText());
            if(f.cadastrarLaudo(tt)){
                int id;
                id = f.LaudoUltimoId();
                f.excluirLaudoIreport();
                try{  
                    f.cadastrarLaudoIreport(id, tt.getTipo());

                    Connection con;
                    Myconnection conexao = new Myconnection();
                    con = conexao.getConnection();

                    String local = System.getProperty("user.dir");  

                    JasperDesign jasperDesign = JRXmlLoader.load(local+"/src/relatorio/Eco_Sab.jrxml");  
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);  

                    int ID_LAUDO = id;  

                    Map parametro = new HashMap();  

                    String imgNormalidade = local+"/src/imagens/", logo = local+"/src/imagens/logo.jpg";
                    parametro.put("Endereco",imgNormalidade); 



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
                    this.dispose();
                 }catch(Exception erro){  
                        erro.printStackTrace(); 
                        System.out.println(erro.getMessage());
                 }  

            }
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jButton_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fecharActionPerformed
        this.dispose();
        new exibirLaudo(p).setVisible(true);
    }//GEN-LAST:event_jButton_fecharActionPerformed

    private void jButton_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularActionPerformed
    this.setAlwaysOnTop(false);
    try{
        
        Float.parseFloat(jTextField_AE.getText()); 
        Float.parseFloat(jTextField_DDVE.getText());
        Float.parseFloat(jTextField_DDVD.getText());
        Float.parseFloat(jTextField_DSVE.getText());
        Float.parseFloat(jTextField_SIV.getText());
        Float.parseFloat(jTextField_altura.getText());
        Float.parseFloat(jTextField_aorta.getText());
        Float.parseFloat(jTextField_peso.getText());
        Float.parseFloat(jTextField_pp.getText());

        if((c != null) && (m != null)){      
            String crm = jTextField_crm.getText();
            
            float AE = Float.parseFloat(jTextField_AE.getText());
            float DDVE = Float.parseFloat(jTextField_DDVE.getText());
            float DDVD = Float.parseFloat(jTextField_DDVD.getText());
            float DSVE = Float.parseFloat(jTextField_DSVE.getText());
            float SIV = Float.parseFloat(jTextField_SIV.getText());
            float altura = Float.parseFloat(jTextField_altura.getText());
            float aorta = Float.parseFloat(jTextField_aorta.getText());
            //float endCav = Float.parseFloat(jTextField_endCav.getText());
            //float indExpessura = Float.parseFloat(jTextField_indExpessuraRel.getText());
            //float indMassaVe = Float.parseFloat(jTextField_ind_massa_ve.getText());
            //float massaVe = Float.parseFloat(jTextField_massa_ve.getText());
            float peso = Float.parseFloat(jTextField_peso.getText());
            float PP = (jTextField_pp.getText().isEmpty()) ? 0 : Float.parseFloat(jTextField_pp.getText());
            // float relAeAo = Float.parseFloat(jTextField_relAEAO.getText());
            // float superficieCorporea = Float.parseFloat(jTextField_superficieCorporea.getText());
            float VDF = 0;
            float VSF = 0;
            float FE = 0;
            
            Fachada f = new Fachada();
                     
            tt = null;
            boolean selecionado = jRadioButton_teicholz.isSelected();
            if(selecionado == true){
                tt = new Eco(peso, SIV, AE, DDVE, DDVD,DSVE, PP, altura, aorta, p, c, m);
                tt.calculo();
                FE = tt.getFE();
                VSF = tt.getVSF();
                VDF = tt.getVDF();

            }
            else {
                selecionado = jRadioButton_simpson.isSelected();
                if(selecionado == true){
                    VDF = Float.parseFloat(jTextField_vdf.getText());
                    VSF = Float.parseFloat(jTextField_vsf.getText());
                    tt = new Eco(peso, SIV, AE, DDVE, DDVD, DSVE, PP, altura, aorta, VSF, VDF, p, c, m);
                    tt.calculo();
                    FE = tt.getFE();
                    jTextField_fe.setText(""+FE);
                }
                else{
                    selecionado = jRadioButton_bidimensional.isSelected();
                    if(selecionado == true){
                        FE = Float.parseFloat(jTextField_fe.getText());
                        tt = new Eco(peso, SIV, AE, DDVE, DDVD, DSVE, PP, altura, aorta, VSF, VDF, FE, p, c, m);
                        tt.calculo();
                        VSF = tt.getVSF();
                        VDF = tt.getVDF();
                    }else{
                        JOptionPane.showMessageDialog(this, "Selecione o método de cálculo da Fração de Ejeção.","Sistema",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }

            if(jRadioButton_tt.isSelected() == true){
                tt.setTipo("tt");
            }
            if(jRadioButton_t.isSelected() == true){
                tt.setTipo("t");
            }
            NumberFormat formatter = new DecimalFormat("0.00"); 
            
            VDF = Float.parseFloat(formatter.format(VDF).toString().replace(",","."));
            VSF = Float.parseFloat(formatter.format(VSF).toString().replace(",","."));
            FE = Float.parseFloat(formatter.format(FE).toString().replace(",","."));
            float massa = Float.parseFloat(formatter.format(tt.getMassa()).toString().replace(",","."));
            float IndMassa = Float.parseFloat(formatter.format(tt.getIndMassaVE()).toString().replace(",","."));
            float IndEspessura = Float.parseFloat(formatter.format(tt.getIndEspessuraRel()).toString().replace(",","."));
            float enccav = Float.parseFloat(formatter.format(tt.getENCCAV()).toString().replace(",","."));
            float superficie = Float.parseFloat(formatter.format(tt.getSuperficieCorporea()).toString().replace(",","."));
            float relaeao = Float.parseFloat(formatter.format(tt.getRelAEAO()).toString().replace(",","."));
            
            jTextField_vdf.setText(VDF+"");
            jTextField_vsf.setText(VSF+"");
            jTextField_fe.setText(FE+"");
            jTextField_indExpessuraRel.setText(IndEspessura+"");
            jTextField_massa_ve.setText(massa+"");
            jTextField_ind_massa_ve.setText(IndMassa+"");
            jTextField_endCav.setText(enccav+"");
            jTextField_superficieCorporea.setText(superficie+"");
            jTextField_relAEAO.setText(relaeao+"");
        }else{
            if((c == null) && (m == null)){
                JOptionPane.showMessageDialog(this, "Escolha o convênio e o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(c == null){
                    JOptionPane.showMessageDialog(this, "Escolha o convênio.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Escolha o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
             }
        
        }

    }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(this, "Algum campo não é numero. "+e.getMessage(), "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    

    }//GEN-LAST:event_jButton_calcularActionPerformed

    private void jRadioButton_SEPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPEActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);
       // tt.setTipo("SEPE");
       /* if((c != null) && (m != null)){
        try {
            // TODO add your handling code here:

            new cadastroEcoEstresse(p,m,c,"SEPE",this).setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro Na chamada");
        }
        }else{
            if((c == null) && (m == null)){
                JOptionPane.showMessageDialog(this, "Escolha o convênio e o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(c == null){
                    JOptionPane.showMessageDialog(this, "Escolha o convênio.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Escolha o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
             }
            
            jRadioButton_tt.setSelected(true);
        }*/
        
    }//GEN-LAST:event_jRadioButton_SEPEActionPerformed

    JDialog escolhe;
    
    private void jButton_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_medicosActionPerformed
        
//        
//        escolhe = new JDialog(this);
//        escolhe.setModal(true);  
//        
//        escolhe.setTitle("Seleciona Medico");
//        escolhe.setContentPane(frame.getContentPane());  
//        escolhe.setBounds(frame.getBounds());  
//        
        
        /*WindowAdapter wind = new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
               JOptionPane.showMessageDialog(null,e.getWindow()+"\n"+e.paramString());
            }
        };
        
        escolhe.addWindowListener(wind);*/
//        escolhe.setUndecorated(false); 
//        escolhe.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        escolhe.pack();
//        escolhe.setVisible(true);
        
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

    



    
    private void jTextField_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_crmActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();

        try {
            m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
            jTextField_nome.setText(m.getNome());

        } catch (MedicoErro ex) {

            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);

        }
    }//GEN-LAST:event_jTextField_crmActionPerformed

    private void jComboBox_modeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_modeloActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_modelo.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_modelo.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_modeloActionPerformed

    private void jComboBox_CamarasCardiacasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_CamarasCardiacasActionPerformed
        Fachada f = new Fachada();
        if(jComboBox_CamarasCardiacas.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_CamarasCardiacas.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_CamarasCardiacasActionPerformed

    private void jComboBox_septosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_septosActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_septos.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_septos.getSelectedItem().toString());
                
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_septosActionPerformed

    private void jComboBox_aorta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_aorta1ActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_aorta1.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_aorta1.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_aorta1ActionPerformed

    private void jComboBox_valvaMitralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_valvaMitralActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_valvaMitral.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_valvaMitral.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_valvaMitralActionPerformed

    private void jComboBox_valvaAorticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_valvaAorticaActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_valvaAortica.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_valvaAortica.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_valvaAorticaActionPerformed

    private void jComboBox_valvaTricuspideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_valvaTricuspideActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_valvaTricuspide.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_valvaTricuspide.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_valvaTricuspideActionPerformed

    private void jComboBox_valvaPulmonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_valvaPulmonarActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_valvaPulmonar.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_valvaPulmonar.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_valvaPulmonarActionPerformed

    private void jComboBox_VentriculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_VentriculosActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_Ventriculos.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_Ventriculos.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_VentriculosActionPerformed

    private void jComboBox_pericardioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_pericardioActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_pericardio.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_pericardio.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_pericardioActionPerformed

    private void jComboBox_observacoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_observacoesActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_observacoes.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_observacoes.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_observacoesActionPerformed

    private void jComboBox_aortaEarteria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_aortaEarteria1ActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_aortaEarteria1.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_aortaEarteria1.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_aortaEarteria1ActionPerformed

    private void jComboBox_conclusaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_conclusaoActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_conclusao.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_conclusao.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_conclusaoActionPerformed

    private void jComboBox_trombosEmassas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_trombosEmassas1ActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        if(jComboBox_trombosEmassas1.getSelectedIndex() != 0){
            try {
                String Texto = f.escreveTextoPorNome(jComboBox_trombosEmassas1.getSelectedItem().toString());
                if(jTextArea_texto.getText().trim().equals("")){
                    jTextArea_texto.setText(Texto);
                }else{
                    jTextArea_texto.setText(jTextArea_texto.getText()+" \n"+Texto);
                }
            } catch (LaudoErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_trombosEmassas1ActionPerformed

    private void jRadioButton_ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_ttActionPerformed
        // TODO add your handling code here:
        jLabel_aortaEarteria.setEnabled(true);
        jComboBox_aortaEarteria1.setEnabled(true);
        jLabel_trombosEmassas.setEnabled(true);
        jComboBox_trombosEmassas1.setEnabled(true);
        
    }//GEN-LAST:event_jRadioButton_ttActionPerformed

    private void jRadioButton_SEPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPDActionPerformed
        // TODO add your handling code here:
       this.setAlwaysOnTop(false);
       //tt.setTipo("SEPD");
       
      /*  if((c != null) && (m != null)){
        try {
            

            new cadastroEcoEstresse(p,m,c,"SEPD",this).setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
            Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
            if((c == null) && (m == null)){
                JOptionPane.showMessageDialog(this, "Escolha o convênio e o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(c == null){
                    JOptionPane.showMessageDialog(this, "Escolha o convênio.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Escolha o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
             }
            
            jRadioButton_tt.setSelected(true);
        }*/
    }//GEN-LAST:event_jRadioButton_SEPDActionPerformed

    private void jRadioButton_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_subActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);
        if((c != null) && (m != null)){
            new cadastroSubjetivo(p, m, c, this).setVisible(true);
            this.dispose();
        }else{
            if((c == null) && (m == null)){
                JOptionPane.showMessageDialog(this, "Escolha o convênio e o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if(c == null){
                    JOptionPane.showMessageDialog(this, "Escolha o convênio.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(this, "Escolha o medico.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
             }
            
            jRadioButton_tt.setSelected(true);
        }
        
    }//GEN-LAST:event_jRadioButton_subActionPerformed

    private void jRadioButton_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_tActionPerformed
        // TODO add your handling code here:
        jLabel_aortaEarteria.setEnabled(false);
        jComboBox_aortaEarteria1.setEnabled(false);
        jLabel_trombosEmassas.setEnabled(false);
        jComboBox_trombosEmassas1.setEnabled(false);
        tt.setTipo("t");
    }//GEN-LAST:event_jRadioButton_tActionPerformed

    private void jRadioButton_teicholzActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_teicholzActionPerformed
        // TODO add your handling code here:
        jTextField_vdf.setEnabled(false);
        jTextField_vsf.setEnabled(false);
        jTextField_endCav.setEnabled(false);
        jTextField_indExpessuraRel.setEnabled(false);
        jTextField_ind_massa_ve.setEnabled(false);
        jTextField_fe.setEnabled(false);
        jTextField_relAEAO.setEnabled(false);
        jTextField_superficieCorporea.setEnabled(false);
        jTextField_massa_ve.setEnabled(false);
    }//GEN-LAST:event_jRadioButton_teicholzActionPerformed

    private void jRadioButton_simpsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_simpsonActionPerformed
        // TODO add your handling code here:
         jTextField_vdf.setEnabled(true);
        jTextField_vsf.setEnabled(true);
        jTextField_endCav.setEnabled(false);
        jTextField_indExpessuraRel.setEnabled(false);
        jTextField_ind_massa_ve.setEnabled(false);
        jTextField_fe.setEnabled(false);
        jTextField_relAEAO.setEnabled(false);
        jTextField_superficieCorporea.setEnabled(false);
        jTextField_massa_ve.setEnabled(false);
    }//GEN-LAST:event_jRadioButton_simpsonActionPerformed

    private void jRadioButton_bidimensionalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_bidimensionalActionPerformed
        // TODO add your handling code here: 
        jTextField_vdf.setEnabled(false);
        jTextField_vsf.setEnabled(false);
        jTextField_endCav.setEnabled(false);
        jTextField_indExpessuraRel.setEnabled(false);
        jTextField_ind_massa_ve.setEnabled(false);
        jTextField_fe.setEnabled(true);
        jTextField_relAEAO.setEnabled(false);
        jTextField_superficieCorporea.setEnabled(false);
        jTextField_massa_ve.setEnabled(false);
    }//GEN-LAST:event_jRadioButton_bidimensionalActionPerformed

    private void jComboBox_convenioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_convenioActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        String conv = jComboBox_convenio.getSelectedItem().toString();
        if(jComboBox_convenio.getSelectedIndex() != 0){
            try {
                c = f.pesquisarConvenioPorNome(conv);
            } catch (ConvenioErro ex) {
                Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            c = null;
        }
    }//GEN-LAST:event_jComboBox_convenioActionPerformed

    private void jTextField_crmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_crmKeyReleased
        String numero = jTextField_crm.getText();
        String t = ""+base.getNumero(numero);
        jTextField_crm.setText(t.equals("0") ? "":t);
    }//GEN-LAST:event_jTextField_crmKeyReleased

    private void jTextField_crmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_crmFocusLost
        Fachada f = new Fachada();

        try {
            m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
            jTextField_nome.setText(m.getNome());
        } catch (MedicoErro ex) {
            Logger.getLogger(cadastroLaudo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }//GEN-LAST:event_jTextField_crmFocusLost

    private void jTextField_SIVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_SIVKeyReleased
            
    }//GEN-LAST:event_jTextField_SIVKeyReleased

    private void jTextField_AEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_AEKeyReleased

    }//GEN-LAST:event_jTextField_AEKeyReleased

    private void jTextField_DDVEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DDVEKeyReleased

    }//GEN-LAST:event_jTextField_DDVEKeyReleased

    private void jTextField_DDVDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DDVDKeyReleased

    }//GEN-LAST:event_jTextField_DDVDKeyReleased

    private void jTextField_alturaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_alturaKeyReleased

    }//GEN-LAST:event_jTextField_alturaKeyReleased

    private void jTextField_aortaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_aortaKeyReleased

    }//GEN-LAST:event_jTextField_aortaKeyReleased

    private void jTextField_DSVEKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DSVEKeyReleased

    }//GEN-LAST:event_jTextField_DSVEKeyReleased

    private void jTextField_ppKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ppKeyReleased

    }//GEN-LAST:event_jTextField_ppKeyReleased

    private void jTextField_pesoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_pesoFocusLost
        String num = jTextField_peso.getText();
        String t = ""+base.getFloat(num);
        jTextField_peso.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_pesoFocusLost

    private void jTextField_SIVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SIVFocusLost
        String num = jTextField_SIV.getText();
        String t = ""+base.getFloat(num);
        jTextField_SIV.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_SIVFocusLost

    private void jTextField_AEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_AEFocusLost
       String num = jTextField_AE.getText();
       String t = ""+base.getFloat(num);
       jTextField_AE.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_AEFocusLost

    private void jTextField_DDVEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DDVEFocusLost
       String num = jTextField_DDVE.getText();
       String t = ""+base.getFloat(num);
       jTextField_DDVE.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_DDVEFocusLost

    private void jTextField_DDVDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DDVDFocusLost
       String num = jTextField_DDVD.getText();
       String t = ""+base.getFloat(num);
       jTextField_DDVD.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_DDVDFocusLost

    private void jTextField_alturaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_alturaFocusLost
       String num = jTextField_altura.getText();
       String t = ""+base.getFloat(num);
       jTextField_altura.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_alturaFocusLost

    private void jTextField_aortaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_aortaFocusLost
       String num = jTextField_aorta.getText();
       String t = ""+base.getFloat(num);
       jTextField_aorta.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_aortaFocusLost

    private void jTextField_DSVEFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_DSVEFocusLost
       String num = jTextField_DSVE.getText();
       String t = ""+base.getFloat(num);
       jTextField_DSVE.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_DSVEFocusLost

    private void jTextField_ppFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_ppFocusLost
        String num = jTextField_pp.getText();
        String t = ""+base.getFloat(num);
        jTextField_pp.setText(t.equals("0") ? "" : t);
    }//GEN-LAST:event_jTextField_ppFocusLost

    /**
     * @param args the command line arguments
     */
    
    Base base=  new Base();
    private JList lista;  
    private Eco tt;
    private Convenio c;
    private Medico m;
    private Paciente p;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_metodo_calculo;
    private javax.swing.ButtonGroup buttonGroup_tipos_laudos;
    private javax.swing.JButton jButton_calcular;
    private javax.swing.JButton jButton_fechar;
    private javax.swing.JButton jButton_medicos;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox jComboBox_CamarasCardiacas;
    private javax.swing.JComboBox jComboBox_Ventriculos;
    private javax.swing.JComboBox jComboBox_aorta1;
    private javax.swing.JComboBox jComboBox_aortaEarteria1;
    private javax.swing.JComboBox jComboBox_conclusao;
    private javax.swing.JComboBox jComboBox_convenio;
    private javax.swing.JComboBox jComboBox_modelo;
    private javax.swing.JComboBox jComboBox_observacoes;
    private javax.swing.JComboBox jComboBox_pericardio;
    private javax.swing.JComboBox jComboBox_septos;
    private javax.swing.JComboBox jComboBox_trombosEmassas1;
    private javax.swing.JComboBox jComboBox_valvaAortica;
    private javax.swing.JComboBox jComboBox_valvaMitral;
    private javax.swing.JComboBox jComboBox_valvaPulmonar;
    private javax.swing.JComboBox jComboBox_valvaTricuspide;
    private javax.swing.JDesktopPane jDesktopPane_Geral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2_CamarasCardiacas;
    private javax.swing.JLabel jLabel2_aorta;
    private javax.swing.JLabel jLabel2_borda_combo;
    private javax.swing.JLabel jLabel2_septos;
    private javax.swing.JLabel jLabel2_valvaAortica;
    private javax.swing.JLabel jLabel2_valvaMitral;
    private javax.swing.JLabel jLabel_AE;
    private javax.swing.JLabel jLabel_Convenio;
    private javax.swing.JLabel jLabel_DDVD;
    private javax.swing.JLabel jLabel_DDVE;
    private javax.swing.JLabel jLabel_DSVE;
    private javax.swing.JLabel jLabel_PP;
    private javax.swing.JLabel jLabel_SIV;
    private javax.swing.JLabel jLabel_altura;
    private javax.swing.JLabel jLabel_aorta;
    private javax.swing.JLabel jLabel_aortaEarteria;
    private javax.swing.JLabel jLabel_borda;
    private javax.swing.JLabel jLabel_borda_calcular;
    private javax.swing.JLabel jLabel_borda_calculo;
    private javax.swing.JLabel jLabel_calculo;
    private javax.swing.JLabel jLabel_conclusao;
    private javax.swing.JLabel jLabel_enc_cav;
    private javax.swing.JLabel jLabel_fe;
    private javax.swing.JLabel jLabel_ind_expessura_rel;
    private javax.swing.JLabel jLabel_ind_massa_ve;
    private javax.swing.JLabel jLabel_massa_ve;
    private javax.swing.JLabel jLabel_medicoResp;
    private javax.swing.JLabel jLabel_nome_paciente;
    private javax.swing.JLabel jLabel_observacoes;
    private javax.swing.JLabel jLabel_paciente;
    private javax.swing.JLabel jLabel_pericardio;
    private javax.swing.JLabel jLabel_peso;
    private javax.swing.JLabel jLabel_pulmonar;
    private javax.swing.JLabel jLabel_rel_ae_por_ao;
    private javax.swing.JLabel jLabel_superficie_corporea;
    private javax.swing.JLabel jLabel_tipo;
    private javax.swing.JLabel jLabel_tricuspide;
    private javax.swing.JLabel jLabel_trombosEmassas;
    private javax.swing.JLabel jLabel_vdf;
    private javax.swing.JLabel jLabel_ventriculos;
    private javax.swing.JLabel jLabel_vsf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton_SEPD;
    private javax.swing.JRadioButton jRadioButton_SEPE;
    private javax.swing.JRadioButton jRadioButton_bidimensional;
    private javax.swing.JRadioButton jRadioButton_simpson;
    private javax.swing.JRadioButton jRadioButton_sub;
    private javax.swing.JRadioButton jRadioButton_t;
    private javax.swing.JRadioButton jRadioButton_teicholz;
    private javax.swing.JRadioButton jRadioButton_tt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea_texto;
    private javax.swing.JTextField jTextField_AE;
    private javax.swing.JTextField jTextField_DDVD;
    private javax.swing.JTextField jTextField_DDVE;
    private javax.swing.JTextField jTextField_DSVE;
    private javax.swing.JTextField jTextField_SIV;
    private javax.swing.JTextField jTextField_altura;
    private javax.swing.JTextField jTextField_aorta;
    private javax.swing.JTextField jTextField_crm;
    private javax.swing.JTextField jTextField_endCav;
    private javax.swing.JTextField jTextField_fe;
    private javax.swing.JTextField jTextField_indExpessuraRel;
    private javax.swing.JTextField jTextField_ind_massa_ve;
    private javax.swing.JTextField jTextField_massa_ve;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_peso;
    private javax.swing.JTextField jTextField_pp;
    private javax.swing.JTextField jTextField_relAEAO;
    private javax.swing.JTextField jTextField_superficieCorporea;
    private javax.swing.JTextField jTextField_vdf;
    private javax.swing.JTextField jTextField_vsf;
    // End of variables declaration//GEN-END:variables
}
