/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import fachada.Fachada;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import medico.Medico;
import medico.MedicoErro;

/**
 *
 * @author arlindojr
 */
public class selecionaMedicoDial extends javax.swing.JDialog {
    
    DefaultTableModel modelo;

    /**
     * Creates new form selecionaMedicoDial
     */
    public selecionaMedicoDial(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
       try {
            atualizarLista("");
        } catch (MedicoErro ex) {
            Logger.getLogger(selecionaMedicoDial.class.getName()).log(Level.SEVERE, null, ex);
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

        jDesktopPane_Geral = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jTextField_pesquisa = new javax.swing.JTextField();
        jScrollPane_tabela = new javax.swing.JScrollPane();
        jTable_pesquisado = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Escolher Médico");

        jLabel1.setText("Buscar:");
        jLabel1.setBounds(20, 20, 620, 40);
        jDesktopPane_Geral.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTextField_pesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_pesquisaActionPerformed(evt);
            }
        });
        jTextField_pesquisa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_pesquisaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_pesquisaFocusLost(evt);
            }
        });
        jTextField_pesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_pesquisaKeyReleased(evt);
            }
        });
        jTextField_pesquisa.setBounds(20, 60, 500, 20);
        jDesktopPane_Geral.add(jTextField_pesquisa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jTable_pesquisado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable_pesquisado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_pesquisadoMouseClicked(evt);
            }
        });
        jScrollPane_tabela.setViewportView(jTable_pesquisado);

        jScrollPane_tabela.setBounds(20, 100, 740, 260);
        jDesktopPane_Geral.add(jScrollPane_tabela, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane_Geral, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_pesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_pesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_pesquisaActionPerformed

    private void jTextField_pesquisaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_pesquisaFocusGained
        jTextField_pesquisa.setText("");
    }//GEN-LAST:event_jTextField_pesquisaFocusGained

    private void jTextField_pesquisaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_pesquisaFocusLost

        String pesquisado = jTextField_pesquisa.getText();

        if(pesquisado.equals("")){
            jTextField_pesquisa.setText("Digite o nome do Medico");
        }
    }//GEN-LAST:event_jTextField_pesquisaFocusLost

    private void jTextField_pesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_pesquisaKeyReleased
        String filtro = jTextField_pesquisa.getText();
        try {
            atualizarLista(filtro);
        } catch (MedicoErro ex) {
            Logger.getLogger(selecionaMedicoDial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTextField_pesquisaKeyReleased

    
    public void atualizarLista(String pesquisa) throws MedicoErro{
        
        this.setAlwaysOnTop(false);
        
        String [] colunas = new String []{"Id do Medico","Nome", "CRM","Status"};
        modelo = new DefaultTableModel(null, colunas){
            
        @Override
        public boolean isCellEditable(int row, int col){
                return false;
            }
        };
        Fachada f = new Fachada();
        List listar = f.pesquisarMedicoPorNome(pesquisa,"Ativo");
        Iterator it = listar.iterator();
        while(it.hasNext()){
            Medico m = (Medico)it.next();
            modelo.addRow(new Object[]{m.getId(),m.getNome(),m.getCRM(),m.getStatus()});
        }
        
        jTable_pesquisado.setModel(modelo);
        jTable_pesquisado.setShowHorizontalLines(false);
        jTable_pesquisado.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /* Editado largura das Colunas
         * 0 - Id
         * 1 - Nome
         * 2 - CRM
         */
        jTable_pesquisado.getColumnModel().getColumn(0).setPreferredWidth(80);   
        jTable_pesquisado.getColumnModel().getColumn(1).setPreferredWidth(120);  
        jTable_pesquisado.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable_pesquisado.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        
    }
    
    
    private void jTable_pesquisadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_pesquisadoMouseClicked
        if(evt.getClickCount()==2){  
           try {
                int numLinhaSelecionada = jTable_pesquisado.getSelectedRow();

                int id = Integer.parseInt(jTable_pesquisado.getValueAt(numLinhaSelecionada, 0).toString());
                String nome = jTable_pesquisado.getValueAt(numLinhaSelecionada, 1).toString();
                int crm = Integer.parseInt(jTable_pesquisado.getValueAt(numLinhaSelecionada, 2).toString());
                String status = jTable_pesquisado.getValueAt(numLinhaSelecionada, 3).toString();

                Medico medico = new Medico(id,crm, nome);
                medico.setStatus(status);
                Fachada f = new Fachada();
                f.excluirMedicoAux(medico);
                f.cadastrarMedicoAux(medico);
                dispose();
            } catch (Exception e){
                JOptionPane.showMessageDialog(this, "Selecione um medico.","Sistema",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTable_pesquisadoMouseClicked

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane_Geral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane_tabela;
    private javax.swing.JTable jTable_pesquisado;
    private javax.swing.JTextField jTextField_pesquisa;
    // End of variables declaration//GEN-END:variables
}
