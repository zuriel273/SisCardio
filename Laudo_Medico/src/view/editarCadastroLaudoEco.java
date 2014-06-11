/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.Myconnection;
import convenio.Convenio;
import convenio.ConvenioErro;
import fachada.Fachada;
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
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JList;
import laudoEscore.LaudoEscore;
import laudoEscore.LaudoEscoreErro;
import laudoEstresse.LaudoEstresse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Pereiras
 */
public class editarCadastroLaudoEco extends javax.swing.JFrame {

    /**
     * Creates new form cadastroLaudo
     */
        
     public editarCadastroLaudoEco(Eco s, JFrame pai) {
        this.setAlwaysOnTop(true);
        this.tt = s;
        idx = s.getId();
        tt.setId(s.getId());
        tt.setId_convenio(s.getId_convenio());
        tt.setId_medico(s.getId_medico());
        tt.setId_paciente(s.getId_paciente());
        
        Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.setAlwaysOnTop(false);
        Fachada f = new Fachada();
        try {                     
            this.m = f.pesquisarMedicoPorId(s.getId_medico());
        } catch (MedicoErro ex) {
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }
        try { 
            this.p = f.pesquisarPacientePorId(s.getId_paciente());
        } catch (PacienteErro ex) {
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.c = f.pesquisarConvenioPorId(s.getId_convenio());
        } catch (ConvenioErro ex) {
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        initComponents();
        
        jTextField_nome.setEnabled(false);
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        
        if(s.getTipo().equals("tt")){
            jRadioButton_tt.setSelected(true);}
        else{
            jRadioButton_t.setSelected(true);
        }
        
        jTextField_crm.setEnabled(false);
        jButton_medicos.setEnabled(false);
        jRadioButton_SEPD.setEnabled(true);
        jRadioButton_SEPE.setEnabled(true);
        jRadioButton_t.setEnabled(false);
        jRadioButton_tt.setEnabled(false);
        jRadioButton_sub.setEnabled(false);
        jComboBox_convenio.setEnabled(false);
        
        if(s.getTipoCalc().equals("TEICHOLZ")){
            jRadioButton_teicholz.setSelected(true);
            this.jRadioButton_teicholzActionPerformed(null);
        }
       if(s.getTipoCalc().equals("SIMPSON")){
            jRadioButton_simpson.setSelected(true);
            this.jRadioButton_simpsonActionPerformed(null);
        }
       if(s.getTipoCalc().equals("BIDIMENSIONAL")){
            jRadioButton_bidimensional.setSelected(true);
            this.jRadioButton_bidimensionalActionPerformed(null);
        }
        
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    jTextField_AE.setText(s.getAE()+""); 
    jTextField_DDVE.setText(s.getDDVE()+"");
    jTextField_DDVD.setText(s.getDDVD()+"");
    jTextField_DSVE.setText(s.getDDVE()+"");
    jTextField_SIV.setText(s.getSIV()+"");
    jTextField_altura.setText(s.getAltura()+"");
    jTextField_aorta.setText(s.getAorta()+"");
    jTextField_peso.setText(s.getPeso()+"");
    jTextField_pp.setText(s.getPP()+"");
    jTextField_vdf.setText(s.getVDF()+"");
    jTextField_vsf.setText(s.getVSF()+"");
    jTextField_fe.setText(s.getFE()+"");
    jTextArea_texto.setText(s.getTexto());
    this.tt = s;
    this.jButton_calcularActionPerformed(null);
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
         if(jComboBox_convenio.getSelectedIndex() == 0){
             jComboBox_convenio.addItem(this.c.getNome());
             jComboBox_convenio.setSelectedItem(this.c.getNome());
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

    private void imprimeRelatorio(int id)  {  
                
        try{  
                
            Fachada f = new Fachada();
            f.excluirLaudoIreport();
            f.cadastrarLaudoIreport(id, tt.getTipo());
            
            Connection con;
                Myconnection conexao = new Myconnection();
                con = conexao.getConnection();
                
                String local = System.getProperty("user.dir");  
//                String jasperFile = local+"/src/relatorio/java.jasper";  
//                String jasperFile = local+"/src/relatorio/Eco_Teste_F.jasper";  
                JasperDesign jasperDesign = JRXmlLoader.load(local+"/src/relatorio/Eco_Sab.jrxml");  
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);  
//                InputStream streamReport = JRLoader.getFileInputStream(jasperFile);
                int ID_LAUDO = id;  
//                System.out.println(jasperFile);
                Map parametro = new HashMap();  
//                Fachada f = new Fachada();
//                List l = new ArrayList();
//                l = f.listarLaudoEscoreByLaudoEcoID(id);
//                
//                JRDataSource data = new JRBeanCollectionDataSource(l);
                
//                parametro.put(JRParameter.REPORT_DATA_SOURCE,data);  
                String imgNormalidade = local+"/src/imagens/", logo = local+"/src/imagens/logo.jpg";
                parametro.put("Endereco",imgNormalidade); 
                
                
               /* parametro.put("Id",ID_LAUDO);  
                parametro.put("Logo",logo);
                parametro.put("Normalidade",imgNormalidade);*/
                
                JasperPrint print;  
//                print = JasperFillManager.fillReport(jasperFile,parametro,con);
                print = JasperFillManager.fillReport(jasperReport,parametro,con);
//                JasperViewer.viewReport(print);
                 
                
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
        jScrollPane3 = new javax.swing.JScrollPane();
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
        jRadioButton_SEPE = new javax.swing.JRadioButton();
        jLabel_borda = new javax.swing.JLabel();
        jLabel_calculo = new javax.swing.JLabel();
        jRadioButton_teicholz = new javax.swing.JRadioButton();
        jRadioButton_simpson = new javax.swing.JRadioButton();
        jRadioButton_bidimensional = new javax.swing.JRadioButton();
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
        jButton_Editar = new javax.swing.JButton();
        jLabel_aortaEarteria = new javax.swing.JLabel();
        jComboBox_aorta1 = new javax.swing.JComboBox();
        jLabel_trombosEmassas = new javax.swing.JLabel();
        jComboBox_aortaEarteria1 = new javax.swing.JComboBox();
        jLabel_conclusao = new javax.swing.JLabel();
        jComboBox_trombosEmassas1 = new javax.swing.JComboBox();
        jRadioButton_tt = new javax.swing.JRadioButton();
        jRadioButton_SEPD = new javax.swing.JRadioButton();
        jRadioButton_sub = new javax.swing.JRadioButton();
        jRadioButton_t = new javax.swing.JRadioButton();
        jRadioButton_esc = new javax.swing.JRadioButton();
        jButton_print = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Atualizar Dados de Laudo");
        setAlwaysOnTop(true);

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jDesktopPane_Geral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_paciente.setText("Paciente");
        jLabel_paciente.setBounds(10, 30, 70, 26);
        jDesktopPane_Geral.add(jLabel_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel_nome_paciente.setBounds(90, 30, 460, 26);
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
        jTextField_crm.setBounds(160, 102, 60, 26);
        jDesktopPane_Geral.add(jTextField_crm, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
        jLabel_tipo.setBounds(680, 40, 120, 14);
        jDesktopPane_Geral.add(jLabel_tipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPE.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPE);
        jRadioButton_SEPE.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPEActionPerformed(evt);
            }
        });
        jRadioButton_SEPE.setBounds(1050, 70, 250, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda.setBounds(670, 30, 645, 110);
        jDesktopPane_Geral.add(jLabel_borda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_calculo.setText("Método do cálculo:");
        jLabel_calculo.setBounds(20, 160, 160, 14);
        jDesktopPane_Geral.add(jLabel_calculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_teicholz.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_teicholz);
        jRadioButton_teicholz.setText("Teicholz");
        jRadioButton_teicholz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_teicholzActionPerformed(evt);
            }
        });
        jRadioButton_teicholz.setBounds(200, 160, 80, 23);
        jDesktopPane_Geral.add(jRadioButton_teicholz, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_simpson.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_simpson);
        jRadioButton_simpson.setText("Simpson");
        jRadioButton_simpson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_simpsonActionPerformed(evt);
            }
        });
        jRadioButton_simpson.setBounds(340, 160, 100, 23);
        jDesktopPane_Geral.add(jRadioButton_simpson, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_bidimensional.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_metodo_calculo.add(jRadioButton_bidimensional);
        jRadioButton_bidimensional.setText("Bidimensional");
        jRadioButton_bidimensional.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_bidimensionalActionPerformed(evt);
            }
        });
        jRadioButton_bidimensional.setBounds(500, 160, 130, 23);
        jDesktopPane_Geral.add(jRadioButton_bidimensional, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda_calculo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda_calculo.setBounds(10, 150, 645, 40);
        jDesktopPane_Geral.add(jLabel_borda_calculo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_peso.setText("Peso(kg)");
        jLabel_peso.setToolTipText("");
        jLabel_peso.setBounds(30, 220, 100, 28);
        jDesktopPane_Geral.add(jLabel_peso, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_peso.setBounds(160, 220, 120, 28);
        jDesktopPane_Geral.add(jTextField_peso, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_SIV.setText("SIV(cm)");
        jLabel_SIV.setBounds(30, 260, 100, 28);
        jDesktopPane_Geral.add(jLabel_SIV, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_SIV.setBounds(160, 260, 120, 28);
        jDesktopPane_Geral.add(jTextField_SIV, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_AE.setText("AE(cm)");
        jLabel_AE.setBounds(30, 290, 100, 28);
        jDesktopPane_Geral.add(jLabel_AE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_AE.setBounds(160, 290, 120, 28);
        jDesktopPane_Geral.add(jTextField_AE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DDVE.setText("DDVE(cm)");
        jLabel_DDVE.setBounds(30, 330, 100, 28);
        jDesktopPane_Geral.add(jLabel_DDVE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_DDVE.setBounds(160, 330, 120, 28);
        jDesktopPane_Geral.add(jTextField_DDVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DDVD.setText("DDVD(cm)");
        jLabel_DDVD.setBounds(30, 360, 100, 28);
        jDesktopPane_Geral.add(jLabel_DDVD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_DDVD.setBounds(160, 360, 120, 28);
        jDesktopPane_Geral.add(jTextField_DDVD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_altura.setText("Altura(cm)");
        jLabel_altura.setBounds(400, 220, 100, 28);
        jDesktopPane_Geral.add(jLabel_altura, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_altura.setBounds(510, 220, 120, 28);
        jDesktopPane_Geral.add(jTextField_altura, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_aorta.setText("Aorta(cm)");
        jLabel_aorta.setBounds(400, 260, 100, 28);
        jDesktopPane_Geral.add(jLabel_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_aorta.setBounds(510, 260, 120, 28);
        jDesktopPane_Geral.add(jTextField_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_DSVE.setText("DSVE(cm)");
        jLabel_DSVE.setBounds(400, 330, 100, 28);
        jDesktopPane_Geral.add(jLabel_DSVE, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_DSVE.setBounds(510, 330, 120, 28);
        jDesktopPane_Geral.add(jTextField_DSVE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_PP.setText("PP(cm)");
        jLabel_PP.setBounds(400, 360, 100, 28);
        jDesktopPane_Geral.add(jLabel_PP, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_pp.setBounds(510, 360, 120, 28);
        jDesktopPane_Geral.add(jTextField_pp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_calcular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/book_keeping.png"))); // NOI18N
        jButton_calcular.setMnemonic('l');
        jButton_calcular.setText("Calcular");
        jButton_calcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_calcularActionPerformed(evt);
            }
        });
        jButton_calcular.setBounds(290, 410, 120, 40);
        jDesktopPane_Geral.add(jButton_calcular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png"))); // NOI18N
        jButton_fechar.setMnemonic('v');
        jButton_fechar.setText("Voltar");
        jButton_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fecharActionPerformed(evt);
            }
        });
        jButton_fechar.setBounds(850, 990, 130, 40);
        jDesktopPane_Geral.add(jButton_fechar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_vsf.setText("VSF(ml)");
        jLabel_vsf.setBounds(30, 460, 150, 28);
        jDesktopPane_Geral.add(jLabel_vsf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_vsf.setBounds(200, 460, 100, 28);
        jDesktopPane_Geral.add(jTextField_vsf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_vdf.setText("VDF(ml)");
        jLabel_vdf.setBounds(360, 460, 150, 28);
        jDesktopPane_Geral.add(jLabel_vdf, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_vdf.setBounds(500, 460, 100, 28);
        jDesktopPane_Geral.add(jTextField_vdf, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_fe.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_fe.setText("FE(%)");
        jLabel_fe.setBounds(360, 490, 150, 28);
        jDesktopPane_Geral.add(jLabel_fe, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_fe.setBounds(500, 490, 100, 28);
        jDesktopPane_Geral.add(jTextField_fe, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_enc_cav.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_enc_cav.setText("Enc. Cav.(%)");
        jLabel_enc_cav.setBounds(30, 490, 150, 28);
        jDesktopPane_Geral.add(jLabel_enc_cav, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_endCav.setBounds(200, 490, 100, 28);
        jDesktopPane_Geral.add(jTextField_endCav, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ind_expessura_rel.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_ind_expessura_rel.setText("Ind. Expessura Rel.");
        jLabel_ind_expessura_rel.setBounds(30, 520, 150, 28);
        jDesktopPane_Geral.add(jLabel_ind_expessura_rel, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_indExpessuraRel.setBounds(200, 520, 100, 28);
        jDesktopPane_Geral.add(jTextField_indExpessuraRel, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_superficie_corporea.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_superficie_corporea.setText("Superficie Corporea(m²)");
        jLabel_superficie_corporea.setBounds(30, 550, 160, 28);
        jDesktopPane_Geral.add(jLabel_superficie_corporea, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_superficieCorporea.setBounds(200, 550, 100, 28);
        jDesktopPane_Geral.add(jTextField_superficieCorporea, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_massa_ve.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_massa_ve.setText("Massa VE(g)");
        jLabel_massa_ve.setBounds(360, 520, 150, 28);
        jDesktopPane_Geral.add(jLabel_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_massa_ve.setBounds(500, 520, 100, 28);
        jDesktopPane_Geral.add(jTextField_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ind_massa_ve.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_ind_massa_ve.setText("Ind. Massa VE(g/m²)");
        jLabel_ind_massa_ve.setBounds(360, 550, 150, 28);
        jDesktopPane_Geral.add(jLabel_ind_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_ind_massa_ve.setBounds(500, 550, 100, 28);
        jDesktopPane_Geral.add(jTextField_ind_massa_ve, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_rel_ae_por_ao.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel_rel_ae_por_ao.setText("Rel. AE/AO");
        jLabel_rel_ae_por_ao.setBounds(30, 580, 150, 28);
        jDesktopPane_Geral.add(jLabel_rel_ae_por_ao, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_relAEAO.setBounds(200, 580, 100, 28);
        jDesktopPane_Geral.add(jTextField_relAEAO, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda_calcular.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda_calcular.setBounds(10, 200, 645, 430);
        jDesktopPane_Geral.add(jLabel_borda_calcular, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Modelo:");
        jLabel1.setBounds(680, 180, 90, 14);
        jDesktopPane_Geral.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_modelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione .:" }));
        jComboBox_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_modeloActionPerformed(evt);
            }
        });
        jComboBox_modelo.setBounds(850, 170, 370, 30);
        jDesktopPane_Geral.add(jComboBox_modelo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_septos.setText("Septos:");
        jLabel2_septos.setBounds(680, 210, 70, 30);
        jDesktopPane_Geral.add(jLabel2_septos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_septos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_septos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_septosActionPerformed(evt);
            }
        });
        jComboBox_septos.setBounds(850, 210, 130, 30);
        jDesktopPane_Geral.add(jComboBox_septos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_CamarasCardiacas.setText("Câmaras Cardíacas:");
        jLabel2_CamarasCardiacas.setBounds(680, 250, 140, 30);
        jDesktopPane_Geral.add(jLabel2_CamarasCardiacas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_aorta.setText("Aorta:");
        jLabel2_aorta.setBounds(680, 300, 60, 14);
        jDesktopPane_Geral.add(jLabel2_aorta, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_valvaMitral.setText("Valva Mitral:");
        jLabel2_valvaMitral.setBounds(680, 340, 130, 14);
        jDesktopPane_Geral.add(jLabel2_valvaMitral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_valvaAortica.setText("Valva Aórtica:");
        jLabel2_valvaAortica.setBounds(680, 370, 100, 14);
        jDesktopPane_Geral.add(jLabel2_valvaAortica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_CamarasCardiacas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_CamarasCardiacas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_CamarasCardiacasActionPerformed(evt);
            }
        });
        jComboBox_CamarasCardiacas.setBounds(850, 250, 130, 30);
        jDesktopPane_Geral.add(jComboBox_CamarasCardiacas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_conclusao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_conclusao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_conclusaoActionPerformed(evt);
            }
        });
        jComboBox_conclusao.setBounds(1160, 450, 130, 30);
        jDesktopPane_Geral.add(jComboBox_conclusao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaMitral.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaMitral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaMitralActionPerformed(evt);
            }
        });
        jComboBox_valvaMitral.setBounds(850, 330, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaMitral, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaAortica.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaAortica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaAorticaActionPerformed(evt);
            }
        });
        jComboBox_valvaAortica.setBounds(850, 370, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaAortica, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaTricuspide.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaTricuspide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaTricuspideActionPerformed(evt);
            }
        });
        jComboBox_valvaTricuspide.setBounds(850, 410, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaTricuspide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_valvaPulmonar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_valvaPulmonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_valvaPulmonarActionPerformed(evt);
            }
        });
        jComboBox_valvaPulmonar.setBounds(850, 450, 130, 30);
        jDesktopPane_Geral.add(jComboBox_valvaPulmonar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tricuspide.setText("Valva Tricúspide:");
        jLabel_tricuspide.setBounds(680, 410, 140, 30);
        jDesktopPane_Geral.add(jLabel_tricuspide, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_Ventriculos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_Ventriculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_VentriculosActionPerformed(evt);
            }
        });
        jComboBox_Ventriculos.setBounds(850, 490, 130, 30);
        jDesktopPane_Geral.add(jComboBox_Ventriculos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_pulmonar.setText("Valva Pulmonar:");
        jLabel_pulmonar.setBounds(680, 450, 130, 30);
        jDesktopPane_Geral.add(jLabel_pulmonar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_pericardio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_pericardio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_pericardioActionPerformed(evt);
            }
        });
        jComboBox_pericardio.setBounds(850, 530, 130, 30);
        jDesktopPane_Geral.add(jComboBox_pericardio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_ventriculos.setText("Ventriculos:");
        jLabel_ventriculos.setBounds(680, 490, 100, 30);
        jDesktopPane_Geral.add(jLabel_ventriculos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_observacoes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_observacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_observacoesActionPerformed(evt);
            }
        });
        jComboBox_observacoes.setBounds(850, 570, 130, 30);
        jDesktopPane_Geral.add(jComboBox_observacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_pericardio.setText("Pericardio:");
        jLabel_pericardio.setBounds(680, 530, 90, 30);
        jDesktopPane_Geral.add(jLabel_pericardio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_observacoes.setText("Observações:");
        jLabel_observacoes.setBounds(680, 570, 110, 30);
        jDesktopPane_Geral.add(jLabel_observacoes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2_borda_combo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2_borda_combo.setBounds(670, 150, 645, 480);
        jDesktopPane_Geral.add(jLabel2_borda_combo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea_texto.setColumns(20);
        jTextArea_texto.setRows(5);
        jScrollPane1.setViewportView(jTextArea_texto);

        jScrollPane1.setBounds(340, 650, 640, 310);
        jDesktopPane_Geral.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_Editar.setMnemonic('a');
        jButton_Editar.setText("Atualizar");
        jButton_Editar.setToolTipText("");
        jButton_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_EditarActionPerformed(evt);
            }
        });
        jButton_Editar.setBounds(340, 990, 130, 40);
        jDesktopPane_Geral.add(jButton_Editar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_aortaEarteria.setText("Aorta e Artéria:");
        jLabel_aortaEarteria.setBounds(1030, 300, 120, 20);
        jDesktopPane_Geral.add(jLabel_aortaEarteria, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_aorta1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_aorta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_aorta1ActionPerformed(evt);
            }
        });
        jComboBox_aorta1.setBounds(850, 290, 130, 30);
        jDesktopPane_Geral.add(jComboBox_aorta1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_trombosEmassas.setText("Trombos e Massas:");
        jLabel_trombosEmassas.setBounds(1020, 370, 140, 14);
        jDesktopPane_Geral.add(jLabel_trombosEmassas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_aortaEarteria1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_aortaEarteria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_aortaEarteria1ActionPerformed(evt);
            }
        });
        jComboBox_aortaEarteria1.setBounds(1160, 290, 130, 30);
        jDesktopPane_Geral.add(jComboBox_aortaEarteria1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_conclusao.setText("Conclusão:");
        jLabel_conclusao.setBounds(1030, 450, 90, 30);
        jDesktopPane_Geral.add(jLabel_conclusao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_trombosEmassas1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_trombosEmassas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_trombosEmassas1ActionPerformed(evt);
            }
        });
        jComboBox_trombosEmassas1.setBounds(1160, 360, 130, 30);
        jDesktopPane_Geral.add(jComboBox_trombosEmassas1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tt.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_tt);
        jRadioButton_tt.setText("Transtorácico e Transesofágico");
        jRadioButton_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ttActionPerformed(evt);
            }
        });
        jRadioButton_tt.setBounds(800, 40, 250, 23);
        jDesktopPane_Geral.add(jRadioButton_tt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPD);
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });
        jRadioButton_SEPD.setBounds(800, 70, 240, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_sub);
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });
        jRadioButton_sub.setBounds(800, 100, 220, 23);
        jDesktopPane_Geral.add(jRadioButton_sub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_t.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_t);
        jRadioButton_t.setText("Transtorácico");
        jRadioButton_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_tActionPerformed(evt);
            }
        });
        jRadioButton_t.setBounds(1050, 40, 250, 23);
        jDesktopPane_Geral.add(jRadioButton_t, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esc.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_esc.setText("Escore");
        jRadioButton_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_escActionPerformed(evt);
            }
        });
        jRadioButton_esc.setBounds(1050, 100, 190, 23);
        jDesktopPane_Geral.add(jRadioButton_esc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_print.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton_print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_printActionPerformed(evt);
            }
        });
        jButton_print.setBounds(570, 30, 90, 40);
        jDesktopPane_Geral.add(jButton_print, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, 1330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, 1082, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1057, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_EditarActionPerformed
        Fachada f = new Fachada();
        tt.setTexto(jTextArea_texto.getText());
        tt.setId_convenio(c.getId());
        tt.setId_medico(m.getId());
        tt.setId_paciente(p.getId());
        tt.setId(idx);
        
        try {
            f.editarEcoTT(tt);
        } catch (LaudoErro ex) {
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_EditarActionPerformed

    private void jButton_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_fecharActionPerformed

    private void jButton_calcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_calcularActionPerformed

try{
    Float.parseFloat(jTextField_AE.getText()); 
    Float.parseFloat(jTextField_DDVE.getText()) ;
    Float.parseFloat(jTextField_DDVD.getText()) ;
    Float.parseFloat(jTextField_DSVE.getText()) ;
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
        JOptionPane.showMessageDialog(this, "Algum campo não é numero.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
    }
    

    }//GEN-LAST:event_jButton_calcularActionPerformed

    private void jRadioButton_SEPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPEActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(es.getLaudoEcoId() != 0){
        try {
            new editarCadastroEstresse1(p,m,c,es,idx,"SEPE").setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
           
        }
        }else{
         try {
                new cadastroEcoEstresse(p, m, c, "SEPE",idx, this).setVisible(true);
                this.dispose();
            } catch (LaudoErro ex1) {
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex1);
            }
        
        }
    }//GEN-LAST:event_jRadioButton_SEPEActionPerformed

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

    private void jTextField_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_crmActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();

        try {
            m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
            jTextField_nome.setText(m.getNome());

        } catch (MedicoErro ex) {

            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);

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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
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
         Fachada f = new Fachada();
        
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(es.getLaudoEcoId() != 0){
        try {
            new editarCadastroEstresse1(p,m,c,es, idx,"SEPD").setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
           
        }
        }else{
         try {
                new cadastroEcoEstresse(p, m, c, "SEPD",idx, this).setVisible(true);
                this.dispose();
            } catch (LaudoErro ex1) {
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex1);
            }
        
        }
    }//GEN-LAST:event_jRadioButton_SEPDActionPerformed

    private void jRadioButton_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_subActionPerformed
        // TODO add your handling code here:
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
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            c = null;
        }
    }//GEN-LAST:event_jComboBox_convenioActionPerformed

    private void jButton_printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_printActionPerformed
        imprimeRelatorio(idx);
    }//GEN-LAST:event_jButton_printActionPerformed

    private void jRadioButton_escActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_escActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        //int laudoEcoId,Paciente p,Medico m,Convenio c,JFrame pai
        LaudoEscore es = f.getLaudoEscoreById(idx);
        if(es.getLaudoEcoId() == 0){
            new cadastroEscore(idx,p, m, c, this).setVisible(true);
                this.dispose();
        /*try {
            //new editarCadastroEstresse1(p,m,c,es,idx,"SEPE").setVisible(true);
            this.dispose();
        } catch (LaudoEscoreErro ex) {
            Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        }else{
         
                new editarEscore(p, m, c, es,idx).setVisible(true);
                this.dispose();
            
        
        }
    }//GEN-LAST:event_jRadioButton_escActionPerformed

    /**
     * @param args the command line arguments
     */
    private int idx;
    private JList lista;  
    private Eco tt;
    private Convenio c;
    private Medico m;
    private Paciente p;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_metodo_calculo;
    private javax.swing.ButtonGroup buttonGroup_tipos_laudos;
    private javax.swing.JButton jButton_Editar;
    private javax.swing.JButton jButton_calcular;
    private javax.swing.JButton jButton_fechar;
    private javax.swing.JButton jButton_medicos;
    private javax.swing.JButton jButton_print;
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
    private javax.swing.JRadioButton jRadioButton_esc;
    private javax.swing.JRadioButton jRadioButton_simpson;
    private javax.swing.JRadioButton jRadioButton_sub;
    private javax.swing.JRadioButton jRadioButton_t;
    private javax.swing.JRadioButton jRadioButton_teicholz;
    private javax.swing.JRadioButton jRadioButton_tt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
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
