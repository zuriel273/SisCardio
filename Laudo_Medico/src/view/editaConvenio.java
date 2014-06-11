/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import base.Base;
import base.ExpressaoRegular;
import convenio.Convenio;
import convenio.ConvenioErro;
import fachada.Fachada;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pereiras
 */
public class editaConvenio extends javax.swing.JFrame {

    /**
     * Creates new form cadastroConvenio
     */
    public editaConvenio(Convenio c) {
        this.setAlwaysOnTop(false);
        initComponents();
        
        
        
         Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.c = c;
        jTextField_nome.setText(this.c.getNome());
        if(this.c.getStatus().equals("Ativo")) {
            jComboBox_status.setSelectedIndex(0);
        }
        else {
            jComboBox_status.setSelectedIndex(1);
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

        jLabel_topo = new javax.swing.JLabel();
        jLabel_status = new javax.swing.JLabel();
        jComboBox_status = new javax.swing.JComboBox();
        jLabel_nome = new javax.swing.JLabel();
        jTextField_nome = new javax.swing.JTextField();
        jButton_salvar = new javax.swing.JButton();
        jButton_cancelar = new javax.swing.JButton();
        jLabel_msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Atualizar Dados de Convênio");
        setAlwaysOnTop(true);

        jLabel_topo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel_topo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar.png"))); // NOI18N
        jLabel_topo.setText("Editar de Convênio");

        jLabel_status.setText("Status:");

        jComboBox_status.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ativo", "Inativo" }));
        jComboBox_status.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox_status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_statusActionPerformed(evt);
            }
        });

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

        jLabel_msg.setForeground(new java.awt.Color(250, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel_status)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_status, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButton_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(174, 174, 174)
                        .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_nome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(532, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel_topo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_msg, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_status, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_status, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(354, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox_statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_statusActionPerformed

    private void jButton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelarActionPerformed
            this.setAlwaysOnTop(false);
            this.dispose();
           // new principal().setVisible(true);
        
    }//GEN-LAST:event_jButton_cancelarActionPerformed

    private void jButton_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_salvarActionPerformed
       String nome = jTextField_nome.getText();
       String status = jComboBox_status.getSelectedItem().toString();
       this.setAlwaysOnTop(false);
       
       if(nome.trim().equals("")){
           JOptionPane.showMessageDialog(this, "Todos os campos são obrigatório. Preenchá-los.", "Alerta do Sistema",JOptionPane.WARNING_MESSAGE);
       }else{
           
       Fachada f = new Fachada();
       Convenio c = new Convenio(this.c.getId(),nome, status);
       
       try{
           f.editarConvenio(c);
           jTextField_nome.setText(null);
           jButton_cancelar.setText("Voltar");
       }catch(ConvenioErro ex){
           Logger.getLogger(editaConvenio.class.getName()).log(Level.SEVERE, null, ex);
       }
           
       }
    }//GEN-LAST:event_jButton_salvarActionPerformed

    private void jTextField_nomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_nomeKeyReleased
        String t = base.getTexto(jTextField_nome.getText());
        jTextField_nome.setText(t);
        this.nomeValido = !t.equals("");
        jButton_salvar.setEnabled(this.camposValidos());
    }//GEN-LAST:event_jTextField_nomeKeyReleased

    private void jTextField_nomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_nomeFocusLost
        ExpressaoRegular er = new ExpressaoRegular();
        if(er.isTexto(jTextField_nome.getText())) {
            jLabel_msg.setIcon(null);
            jButton_salvar.setEnabled(true);
        } 
        else {
            jLabel_msg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/nook16x16.png")));
            jLabel_msg.setText("Campo alfabéticos");
            jButton_salvar.setEnabled(false);
        }
    }//GEN-LAST:event_jTextField_nomeFocusLost

    private boolean camposValidos(){
        return this.nomeValido;
    }
    /**
     * @param args the command line arguments
     */
    private Convenio c;
    private boolean nomeValido = true;
    private Base base =  new Base();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_cancelar;
    private javax.swing.JButton jButton_salvar;
    private javax.swing.JComboBox jComboBox_status;
    private javax.swing.JLabel jLabel_msg;
    private javax.swing.JLabel jLabel_nome;
    private javax.swing.JLabel jLabel_status;
    private javax.swing.JLabel jLabel_topo;
    private javax.swing.JTextField jTextField_nome;
    // End of variables declaration//GEN-END:variables
}
