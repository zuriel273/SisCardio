/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conexao.Myconnection;
import convenio.Convenio;
import convenio.ConvenioErro;
import fachada.Fachada;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import laudo.Eco;
import laudo.LaudoErro;
import medico.Medico;
import medico.MedicoErro;
import paciente.*; 
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import laudoEscore.LaudoEscore;
import laudoEstresse.LaudoEstresse;
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
public class editaCadastroSubjetivo extends javax.swing.JFrame {

    /**
     * Creates new form cadastroLaudo
     */
    public editaCadastroSubjetivo(Eco s, JFrame pai) {
        this.setAlwaysOnTop(true);
       
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
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.p = f.pesquisarPacientePorId(s.getId_paciente());
        } catch (PacienteErro ex) {
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            this.c = f.pesquisarConvenioPorId(s.getId_convenio());
        } catch (ConvenioErro ex) {
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
         System.out.println("Teste-Antes");
         System.out.println(c.getNome());
         System.out.println(c.getStatus());
         System.out.println(c.getId());
                
        initComponents();
        
        this.tt = s;
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        
        jRadioButton_sub.setSelected(true);
        
       
        jTextField_nome.setEnabled(false);
        jRadioButton_sub.setEnabled(false);
        jRadioButton_SEPD.setEnabled(true);
        jRadioButton_SEPE.setEnabled(true);
        jRadioButton_t.setEnabled(false);
        jRadioButton_tt.setEnabled(false);
        
        jTextField_crm.setEnabled(false);
        jButton_medicos.setEnabled(false);
        
        
        jRadioButton_sub.setEnabled(false);
        jComboBox_convenio.setEnabled(false);
        
        jTextArea_texto.setText(s.getTexto());
        
        this.setAlwaysOnTop(false);
        
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizarCombo() throws ConvenioErro{
        
        jTextField_crm.setEnabled(false);
        jButton_medicos.setEnabled(false);
        jComboBox_convenio.setEnabled(false);
        jTextField_nome.setEnabled(false);
         
         Fachada f = new Fachada();
         List listar = f.pesquisarConvenioPorStatus();
         Iterator it = listar.iterator();
         while(it.hasNext()){
             Convenio c = (Convenio)it.next();             
             jComboBox_convenio.addItem(c.getNome());  
              if(this.c.getNome().equals(c.getNome())){
                    jComboBox_convenio.setSelectedItem(c.getNome());
                }
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
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel_borda = new javax.swing.JLabel();
        jButton_fechar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox_modelo = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_texto = new javax.swing.JTextArea();
        jButton_editar = new javax.swing.JButton();
        jRadioButton_tt = new javax.swing.JRadioButton();
        jRadioButton_SEPD = new javax.swing.JRadioButton();
        jRadioButton_sub = new javax.swing.JRadioButton();
        jRadioButton_t = new javax.swing.JRadioButton();
        jRadioButton_SEPE = new javax.swing.JRadioButton();
        jRadioButton_esc = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Atualizar Dados de Laudo Subjetivo");
        setAlwaysOnTop(true);

        jDesktopPane_Geral.setAlignmentX(0.0F);
        jDesktopPane_Geral.setAlignmentY(0.0F);
        jDesktopPane_Geral.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel_paciente.setText("Paciente");
        jLabel_paciente.setBounds(10, 10, 70, 26);
        jDesktopPane_Geral.add(jLabel_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel_nome_paciente.setBounds(90, 10, 510, 26);
        jDesktopPane_Geral.add(jLabel_nome_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_Convenio.setText("Convênio");
        jLabel_Convenio.setBounds(10, 40, 45, 26);
        jDesktopPane_Geral.add(jLabel_Convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_convenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_convenio.setBounds(100, 40, 500, 26);
        jDesktopPane_Geral.add(jComboBox_convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_medicoResp.setText("Médico Responsável:");
        jLabel_medicoResp.setBounds(10, 80, 150, 26);
        jDesktopPane_Geral.add(jLabel_medicoResp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_crm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_crmActionPerformed(evt);
            }
        });
        jTextField_crm.setBounds(160, 80, 60, 26);
        jDesktopPane_Geral.add(jTextField_crm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_nome.setBounds(230, 80, 370, 26);
        jDesktopPane_Geral.add(jTextField_nome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_medicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/busca.png"))); // NOI18N
        jButton_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_medicosActionPerformed(evt);
            }
        });
        jButton_medicos.setBounds(610, 80, 46, 36);
        jDesktopPane_Geral.add(jButton_medicos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tipo.setText("Tipos de laudos:");
        jLabel_tipo.setBounds(670, 20, 120, 14);
        jDesktopPane_Geral.add(jLabel_tipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_borda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel_borda.setBounds(660, 10, 600, 110);
        jDesktopPane_Geral.add(jLabel_borda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_fechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png"))); // NOI18N
        jButton_fechar.setMnemonic('v');
        jButton_fechar.setText("Voltar");
        jButton_fechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_fecharActionPerformed(evt);
            }
        });
        jButton_fechar.setBounds(480, 570, 120, 40);
        jDesktopPane_Geral.add(jButton_fechar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Modelo:");
        jLabel1.setBounds(20, 237, 70, 30);
        jDesktopPane_Geral.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_modelo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione .:" }));
        jComboBox_modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_modeloActionPerformed(evt);
            }
        });
        jComboBox_modelo.setBounds(90, 240, 540, 20);
        jDesktopPane_Geral.add(jComboBox_modelo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextArea_texto.setColumns(20);
        jTextArea_texto.setRows(5);
        jScrollPane1.setViewportView(jTextArea_texto);

        jScrollPane1.setBounds(660, 150, 610, 460);
        jDesktopPane_Geral.add(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_editar.setMnemonic('a');
        jButton_editar.setText("Atualizar");
        jButton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_editarActionPerformed(evt);
            }
        });
        jButton_editar.setBounds(10, 570, 120, 40);
        jDesktopPane_Geral.add(jButton_editar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tt.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_tt);
        jRadioButton_tt.setText("Transtorácico e Transesofágico");
        jRadioButton_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ttActionPerformed(evt);
            }
        });
        jRadioButton_tt.setBounds(790, 20, 175, 23);
        jDesktopPane_Geral.add(jRadioButton_tt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPD);
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });
        jRadioButton_SEPD.setBounds(790, 50, 240, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_sub);
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });
        jRadioButton_sub.setBounds(790, 80, 160, 23);
        jDesktopPane_Geral.add(jRadioButton_sub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_t.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_t);
        jRadioButton_t.setText("Transtorácico");
        jRadioButton_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_tActionPerformed(evt);
            }
        });
        jRadioButton_t.setBounds(1040, 20, 260, 23);
        jDesktopPane_Geral.add(jRadioButton_t, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPE.setBackground(new java.awt.Color(254, 254, 254));
        buttonGroup_tipos_laudos.add(jRadioButton_SEPE);
        jRadioButton_SEPE.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPEActionPerformed(evt);
            }
        });
        jRadioButton_SEPE.setBounds(1040, 50, 260, 23);
        jDesktopPane_Geral.add(jRadioButton_SEPE, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esc.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_esc.setText("Escore");
        jRadioButton_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_escActionPerformed(evt);
            }
        });
        jRadioButton_esc.setBounds(1040, 80, 57, 23);
        jDesktopPane_Geral.add(jRadioButton_esc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(230, 570, 120, 40);
        jDesktopPane_Geral.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.DEFAULT_SIZE, 1364, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editarActionPerformed
        Fachada f = new Fachada();
        int i = tt.getId();
        tt = new Eco(jTextArea_texto.getText(),"sub", p, c, m);
        tt.setId(i);
        try {
            f.editarEcoSub(tt);
        } catch (LaudoErro ex) {
            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_editarActionPerformed

    private void jButton_fecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_fecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_fecharActionPerformed

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

            Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);

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
                Logger.getLogger(editaCadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jComboBox_modeloActionPerformed

    private void jRadioButton_ttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_ttActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton_ttActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setAlwaysOnTop(false);
        
        try{  
                
            Fachada f = new Fachada();
            f.excluirLaudoIreport();
            f.cadastrarLaudoIreport(tt.getId(), tt.getTipo());
            
            Connection con;
                Myconnection conexao = new Myconnection();
                con = conexao.getConnection();
                
                String local = System.getProperty("user.dir");  

                JasperDesign jasperDesign = JRXmlLoader.load(local+"/src/relatorio/Eco_Sub.jrxml");  
                JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);  

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
            }catch(Exception erro){  
                erro.printStackTrace(); 
                System.out.println(erro.getMessage());
            }  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton_tActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_tActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jRadioButton_tActionPerformed

    private void jRadioButton_SEPEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPEActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        int idx = tt.getId();
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(es.getLaudoEcoId() != 0){
        try {
            new editarCadastroEstresse1(p,m,c,es,idx,"SEPE","sub").setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
           
        }
        }else{
         try {
                new cadastroEcoEstresse(p, m, c, "SEPE",idx, this,"sub").setVisible(true);
                this.dispose();
            } catch (LaudoErro ex1) {
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex1);
            }
        
        }
    }//GEN-LAST:event_jRadioButton_SEPEActionPerformed

    private void jRadioButton_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_subActionPerformed

    private void jRadioButton_SEPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPDActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        int idx = tt.getId();
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(es.getLaudoEcoId() != 0){
        try {
            new editarCadastroEstresse1(p,m,c,es,idx,"SEPD","sub").setVisible(true);
            this.dispose();
        } catch (LaudoErro ex) {
           
        }
        }else{
         try {
                new cadastroEcoEstresse(p, m, c, "SEPD",idx, this,"sub").setVisible(true);
                this.dispose();
            } catch (LaudoErro ex1) {
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex1);
            }
        
        }
    }//GEN-LAST:event_jRadioButton_SEPDActionPerformed

    private void jRadioButton_escActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_escActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        int idx = tt.getId();
        //int laudoEcoId,Paciente p,Medico m,Convenio c,JFrame pai
        LaudoEscore es = f.getLaudoEscoreById(idx);
        if(es.getLaudoEcoId() == 0){
            new cadastroEscore(idx,p, m, c, this,"sub").setVisible(true);
            this.dispose();
            /*try {
                //new editarCadastroEstresse1(p,m,c,es,idx,"SEPE").setVisible(true);
                this.dispose();
            } catch (LaudoEscoreErro ex) {
                Logger.getLogger(editarCadastroLaudoEco.class.getName()).log(Level.SEVERE, null, ex);
            }*/
        }else{

            new editarEscore(p, m, c, es,idx,"sub").setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_jRadioButton_escActionPerformed

    /**
     * @param args the command line arguments
     */
    
    private JList lista;  
    private Eco tt;
    private Convenio c;
    private Medico m;
    private Paciente p;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_metodo_calculo;
    private javax.swing.ButtonGroup buttonGroup_tipos_laudos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_editar;
    private javax.swing.JButton jButton_fechar;
    private javax.swing.JButton jButton_medicos;
    private javax.swing.JComboBox jComboBox_convenio;
    private javax.swing.JComboBox jComboBox_modelo;
    private javax.swing.JDesktopPane jDesktopPane_Geral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Convenio;
    private javax.swing.JLabel jLabel_borda;
    private javax.swing.JLabel jLabel_medicoResp;
    private javax.swing.JLabel jLabel_nome_paciente;
    private javax.swing.JLabel jLabel_paciente;
    private javax.swing.JLabel jLabel_tipo;
    private javax.swing.JRadioButton jRadioButton_SEPD;
    private javax.swing.JRadioButton jRadioButton_SEPE;
    private javax.swing.JRadioButton jRadioButton_esc;
    private javax.swing.JRadioButton jRadioButton_sub;
    private javax.swing.JRadioButton jRadioButton_t;
    private javax.swing.JRadioButton jRadioButton_tt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea_texto;
    private javax.swing.JTextField jTextField_crm;
    private javax.swing.JTextField jTextField_nome;
    // End of variables declaration//GEN-END:variables
}
