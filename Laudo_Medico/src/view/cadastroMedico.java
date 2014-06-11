/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import base.Base;
import base.ExpressaoRegular;
import fachada.Fachada;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import medico.Medico;
import medico.MedicoErro;

/**
 *
 * @author Pereiras
 */
public class cadastroMedico extends javax.swing.JFrame {

    boolean nomeValido = false, crmValido = false;
    
    /**
     * Creates new form cadastroConvenio
     */
    public cadastroMedico() {
        this.setAlwaysOnTop(true);
        setExtendedState(MAXIMIZED_BOTH); 
        
         Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
       
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        initComponents();
        jButton_salvar.setEnabled(this.camposValidos());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_topo = new javax.swing.JLabel();
        jLabel_nome = new javax.swing.JLabel();
        jTextField_nome = new javax.swing.JTextField();
        jLabel_crm = new javax.swing.JLabel();
        jFormattedTextField_crm = new javax.swing.JFormattedTextField();
        jButton_salvar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jComboBox_status3 = new javax.swing.JComboBox();
        jLabel_status = new javax.swing.JLabel();
        jLabel_msg_nome = new javax.swing.JLabel();
        jLabel_msg_crm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Cadastro de Médico");
        setAlwaysOnTop(true);

        jLabel_topo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_topo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/list_add_user32x32.png"))); // NOI18N
        jLabel_topo.setText("Cadastro de Médico");

        jLabel_nome.setText("Nome:");

        jTextField_nome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_nomeFocusLost(evt);
            }
        });
        jTextField_nome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_nomeKeyReleased(evt);
            }
        });

        jLabel_crm.setText("CRM:");

        jFormattedTextField_crm.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jFormattedTextField_crmFocusLost(evt);
            }
        });
        jFormattedTextField_crm.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextField_crmKeyReleased(evt);
            }
        });

        jButton_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_salvar.setMnemonic('s');
        jButton_salvar.setText("Salvar");
        jButton_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_salvarActionPerformed(evt);
            }
        });

        jButton_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton_cancelar.setMnemonic('c');
        jButton_cancelar.setText("Cancelar");
        jButton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelarActionPerformed(evt);
            }
        });

        jComboBox_status3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBox_status3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_status3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_status3ActionPerformed(evt);
            }
        });

        jLabel_status.setText("Status:");

        jLabel_msg_nome.setForeground(new java.awt.Color(250, 0, 0));
        jLabel_msg_nome.setLabelFor(jTextField_nome);

        jLabel_msg_crm.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_msg_crm.setLabelFor(jFormattedTextField_crm);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel_nome, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                            .addComponent(jLabel_crm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(148, 148, 148)
                                .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jFormattedTextField_crm, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel_msg_crm, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField_nome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel_status, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jComboBox_status3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel_msg_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(557, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel_msg_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel_crm, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jComboBox_status3, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jLabel_status, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jFormattedTextField_crm)
                    .addComponent(jLabel_msg_crm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(357, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private boolean camposValidos(){
        return this.nomeValido && this.crmValido;
    }
    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
        this.setAlwaysOnTop(false);
        
        this.dispose();
        
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
        this.setAlwaysOnTop(false);
        
        String nome = jTextField_nome.getText();
        //int crm = Integer.parseInt(jFormattedTextField_crm.getText());
        String crmT = jFormattedTextField_crm.getText();
        String status = jComboBox_status3.getSelectedItem().toString();
        
         
        
        if(nome.trim().equals("") || (crmT.trim().equals(""))){
            JOptionPane.showMessageDialog(null, "Todos os campos são obrigatório. Preenchá-los.", "Alerta do Sistema",JOptionPane.WARNING_MESSAGE);
        }else{
            int crm = Integer.parseInt(jFormattedTextField_crm.getText());
            Fachada f = new Fachada();
            Medico m = new Medico(crm, nome);
            m.setStatus(status);
            try {
                f.cadastrarMedico(m);
                jFormattedTextField_crm.setText(null);
                jTextField_nome.setText(null);
                jLabel_crm.setIcon(null);
                jLabel_nome.setIcon(null);
                jButton_cancelar.setText("Voltar");
                jButton_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png")));
                jButton_cancelar.setMnemonic('v');
            } catch (MedicoErro ex) {
                Logger.getLogger(cadastroMedico.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jComboBox_status3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_status3ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jComboBox_status3ActionPerformed

    private void jTextField_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nomeFocusLost
        ExpressaoRegular er = new ExpressaoRegular();
        this.nomeValido = er.isTexto(jTextField_nome.getText());
        if(this.nomeValido){
            jLabel_msg_nome.setIcon(null);
            jLabel_msg_nome.setText("");
        } 
        else {
            jLabel_msg_nome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nook16x16.png")));
            jLabel_msg_nome.setText("Campo alfabético");
            jTextField_nome.setText("");
        }
        jButton_salvar.setEnabled(this.camposValidos());
    }//GEN-LAST:event_jTextField_nomeFocusLost

    private void jFormattedTextField_crmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jFormattedTextField_crmFocusLost
        ExpressaoRegular er = new ExpressaoRegular();
        this.crmValido = er.isNum(jFormattedTextField_crm.getText());
        if(this.crmValido){
            jLabel_msg_crm.setIcon(null);
            jLabel_msg_crm.setText("");
        } 
        else {
            jLabel_msg_crm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nook16x16.png")));
            jLabel_msg_crm.setText("Campo numerico");
            jFormattedTextField_crm.setText("");
        }
        jButton_salvar.setEnabled(this.camposValidos());
    }//GEN-LAST:event_jFormattedTextField_crmFocusLost

    private void jTextField_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nomeKeyReleased
        String t = base.getTexto(jTextField_nome.getText());
        jTextField_nome.setText(t);
        this.nomeValido = !t.equals("");
        jButton_salvar.setEnabled(this.camposValidos());
    }//GEN-LAST:event_jTextField_nomeKeyReleased

    private void jFormattedTextField_crmKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextField_crmKeyReleased
        String t = ""+base.getNumero(jFormattedTextField_crm.getText());
        jFormattedTextField_crm.setText(t.equals("0") ? "" : t);
        this.crmValido = !t.equals("0");
        jButton_salvar.setEnabled(this.camposValidos());
    }//GEN-LAST:event_jFormattedTextField_crmKeyReleased

    /**
     * @param args the command line arguments
     */
    Base base = new Base();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox jComboBox_status3;
    private javax.swing.JFormattedTextField jFormattedTextField_crm;
    private javax.swing.JLabel jLabel_crm;
    private javax.swing.JLabel jLabel_msg_crm;
    private javax.swing.JLabel jLabel_msg_nome;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JLabel jLabel_topo;
    private javax.swing.JTextField jTextField_nome;
    // End of variables declaration//GEN-END:variables
}