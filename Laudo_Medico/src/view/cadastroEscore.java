/*
 * To change this template  = new Segmento(), choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import base.Base;
import base.ExpressaoRegular;
import conexao.Myconnection;
import convenio.Convenio;
import convenio.ConvenioErro;
import fachada.Fachada;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;
import laudo.Eco;
import laudo.LaudoErro;
import laudoEscore.LaudoEscore;
import laudoEscore.LaudoEscoreErro;
import laudoEstresse.LaudoEstresse;
import medico.Medico;
import medico.MedicoErro;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import paciente.Paciente;
import segmento.Segmento;

/**
 *
 * @author arlindo
 */
public class cadastroEscore extends javax.swing.JFrame {

    /**
     * Creates new form cadastroEscore
     */
    int laudoEcoId;
    
    public cadastroEscore(int laudoEcoId) {
        this.setAlwaysOnTop(true);
        initComponents();
        this.laudoEcoId = laudoEcoId;
         this.setAlwaysOnTop(false);
          
          
         Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
    }
    
    public cadastroEscore(int laudoEcoId,Paciente p,Medico m,Convenio c,JFrame pai, String tipo) {
        this.setAlwaysOnTop(true);
        
        initComponents();
        
        Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        
        this.p = p;
        this.c = c;
        this.m = m;
        this.tipo = tipo;
        
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        
        this.laudoEcoId = laudoEcoId;
        
        this.setAlwaysOnTop(false);
        
        jRadioButton_esc.setSelected(true);
        
        
        
        jRadioButton_t.setEnabled(false);
        jRadioButton_tt.setEnabled(false);
        
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(cadastroEscore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public cadastroEscore(int laudoEcoId,Paciente p,Medico m,Convenio c,JFrame pai) {
        this.setAlwaysOnTop(true);
        initComponents();
        this.p = p;
        this.c = c;
        this.m = m;
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        this.laudoEcoId = laudoEcoId;
        this.setAlwaysOnTop(false);
        jRadioButton_esc.setSelected(true);
        jRadioButton_sub.setEnabled(false);
        
       
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(cadastroEscore.class.getName()).log(Level.SEVERE, null, ex);
        }
        addListener();
    }
    
    private void addListener()
    {
        
        jTextField_repouso_1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_1);
            }
        });

        jTextField_repouso_2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_2);
            }
        });

        jTextField_repouso_3.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_3);
            }
        });

        jTextField_repouso_4.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_repouso_4);
            }
        });

        jTextField_repouso_5.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_5);
            }
        });

        jTextField_repouso_6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_repouso_6);
            }
        });

        jTextField_repouso_7.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_7);
            }
        });

        jTextField_repouso_8.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_repouso_8);
            }
        });
        
        jTextField_repouso_9.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_9);
            }
        });
        
        jTextField_repouso_10.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_10);
            }
        });
        
        jTextField_repouso_11.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_11);
            }
        });
        
        jTextField_repouso_12.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_12);
            }
        });
        
        jTextField_repouso_13.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_13);
            }
        });
        
        jTextField_repouso_14.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_14);
            }
        });
        
        
        jTextField_repouso_15.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_15);
            }
        });
        
        jTextField_repouso_16.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_16);
            }
        });
        
        jTextField_repouso_17.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_repouso_17);
            }
        });
        
        jTextField_recuperacao_1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_1);
            }
        });

        jTextField_recuperacao_2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_2);
            }
        });

        jTextField_recuperacao_3.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_3);
            }
        });

        jTextField_recuperacao_4.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_recuperacao_4);
            }
        });

        jTextField_recuperacao_5.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_5);
            }
        });

        jTextField_recuperacao_6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_recuperacao_6);
            }
        });

        jTextField_recuperacao_7.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_7);
            }
        });

        jTextField_recuperacao_8.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_recuperacao_8);
            }
        });
        
        jTextField_recuperacao_9.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_9);
            }
        });
        
        jTextField_recuperacao_10.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_10);
            }
        });
        
        jTextField_recuperacao_11.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_11);
            }
        });
        
        jTextField_recuperacao_12.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_12);
            }
        });
        
        jTextField_recuperacao_13.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_13);
            }
        });
        
        jTextField_recuperacao_14.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_14);
            }
        });
        
        
        jTextField_recuperacao_15.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_15);
            }
        });
        
        jTextField_recuperacao_16.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_16);
            }
        });
        
        jTextField_recuperacao_17.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_recuperacao_17);
            }
        });
        
        jTextField_baixa_dose_1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_1);
            }
        });

        jTextField_baixa_dose_2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_2);
            }
        });

        jTextField_baixa_dose_3.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_3);
            }
        });

        jTextField_baixa_dose_4.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_baixa_dose_4);
            }
        });

        jTextField_baixa_dose_5.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_5);
            }
        });

        jTextField_baixa_dose_6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_baixa_dose_6);
            }
        });

        jTextField_baixa_dose_7.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_7);
            }
        });

        jTextField_baixa_dose_8.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_baixa_dose_8);
            }
        });
        
        jTextField_baixa_dose_9.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_9);
            }
        });
        
        jTextField_baixa_dose_10.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_10);
            }
        });
        
        jTextField_baixa_dose_11.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_11);
            }
        });
        
        jTextField_baixa_dose_12.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_12);
            }
        });
        
        jTextField_baixa_dose_13.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_13);
            }
        });
        
        jTextField_baixa_dose_14.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_14);
            }
        });
        
        
        jTextField_baixa_dose_15.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_15);
            }
        });
        
        jTextField_baixa_dose_16.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_16);
            }
        });
        
        jTextField_baixa_dose_17.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_baixa_dose_17);
            }
        });
        
        jTextField_pico_1.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_1);
            }
        });

        jTextField_pico_2.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_2);
            }
        });

        jTextField_pico_3.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_3);
            }
        });

        jTextField_pico_4.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_pico_4);
            }
        });

        jTextField_pico_5.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_5);
            }
        });

        jTextField_pico_6.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
               clicadoKeyReleased(evt, jTextField_pico_6);
            }
        });

        jTextField_pico_7.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_7);
            }
        });

        jTextField_pico_8.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt, jTextField_pico_8);
            }
        });
        
        jTextField_pico_9.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_9);
            }
        });
        
        jTextField_pico_10.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_10);
            }
        });
        
        jTextField_pico_11.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_11);
            }
        });
        
        jTextField_pico_12.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_12);
            }
        });
        
        jTextField_pico_13.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_13);
            }
        });
        
        jTextField_pico_14.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_14);
            }
        });
        
        
        jTextField_pico_15.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_15);
            }
        });
        
        jTextField_pico_16.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_16);
            }
        });
        
        jTextField_pico_17.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                clicadoKeyReleased(evt,jTextField_pico_17);
            }
        });

    }
    
    private void focusLost()
    {
        jTextField_repouso_1.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_1);
            }
        });    
        
        jTextField_repouso_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_repouso_2);
            }
        });

        jTextField_repouso_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_repouso_3);
            }
        });

        jTextField_repouso_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_repouso_4);
            }
        });

        jTextField_repouso_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_repouso_5);
            }
        });

        jTextField_repouso_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_repouso_6);
            }
        });

        jTextField_repouso_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_repouso_7);
            }
        });

        jTextField_repouso_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_repouso_8);
            }
        });
        
        jTextField_repouso_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_9);
            }
        });
        
        jTextField_repouso_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_10);
            }
        });
        
        jTextField_repouso_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_11);
            }
        });
        
        jTextField_repouso_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_12);
            }
        });
        
        jTextField_repouso_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_13);
            }
        });
        
        jTextField_repouso_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_14);
            }
        });
        
        
        jTextField_repouso_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_15);
            }
        });
        
        jTextField_repouso_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_16);
            }
        });
        
        jTextField_repouso_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_repouso_17);
            }
        });
        
        jTextField_recuperacao_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_1);
            }
        });

        jTextField_recuperacao_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_2);
            }
        });

        jTextField_recuperacao_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_3);
            }
        });

        jTextField_recuperacao_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_recuperacao_4);
            }
        });

        jTextField_recuperacao_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_5);
            }
        });

        jTextField_recuperacao_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_recuperacao_6);
            }
        });

        jTextField_recuperacao_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_7);
            }
        });

        jTextField_recuperacao_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_recuperacao_8);
            }
        });
        
        jTextField_recuperacao_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_9);
            }
        });
        
        jTextField_recuperacao_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_10);
            }
        });
        
        jTextField_recuperacao_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_11);
            }
        });
        
        jTextField_recuperacao_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_12);
            }
        });
        
        jTextField_recuperacao_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_13);
            }
        });
        
        jTextField_recuperacao_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_14);
            }
        });
        
        
        jTextField_recuperacao_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_15);
            }
        });
        
        jTextField_recuperacao_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_16);
            }
        });
        
        jTextField_recuperacao_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_recuperacao_17);
            }
        });
        
        jTextField_baixa_dose_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_1);
            }
        });

        jTextField_baixa_dose_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_2);
            }
        });

        jTextField_baixa_dose_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_3);
            }
        });

        jTextField_baixa_dose_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_baixa_dose_4);
            }
        });

        jTextField_baixa_dose_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_5);
            }
        });

        jTextField_baixa_dose_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_baixa_dose_6);
            }
        });

        jTextField_baixa_dose_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_7);
            }
        });

        jTextField_baixa_dose_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_baixa_dose_8);
            }
        });
        
        jTextField_baixa_dose_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_9);
            }
        });
        
        jTextField_baixa_dose_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_10);
            }
        });
        
        jTextField_baixa_dose_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_11);
            }
        });
        
        jTextField_baixa_dose_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_12);
            }
        });
        
        jTextField_baixa_dose_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_13);
            }
        });
        
        jTextField_baixa_dose_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_14);
            }
        });
        
        
        jTextField_baixa_dose_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_15);
            }
        });
        
        jTextField_baixa_dose_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_16);
            }
        });
        
        jTextField_baixa_dose_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_baixa_dose_17);
            }
        });
        
        jTextField_pico_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_1);
            }
        });

        jTextField_pico_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_2);
            }
        });

        jTextField_pico_3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_3);
            }
        });

        jTextField_pico_4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_pico_4);
            }
        });

        jTextField_pico_5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_5);
            }
        });

        jTextField_pico_6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
               perdaFocus(evt, jTextField_pico_6);
            }
        });

        jTextField_pico_7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_7);
            }
        });

        jTextField_pico_8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt, jTextField_pico_8);
            }
        });
        
        jTextField_pico_9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_9);
            }
        });
        
        jTextField_pico_10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_10);
            }
        });
        
        jTextField_pico_11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_11);
            }
        });
        
        jTextField_pico_12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_12);
            }
        });
        
        jTextField_pico_13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_13);
            }
        });
        
        jTextField_pico_14.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_14);
            }
        });
        
        
        jTextField_pico_15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_15);
            }
        });
        
        jTextField_pico_16.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_16);
            }
        });
        
        jTextField_pico_17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                perdaFocus(evt,jTextField_pico_17);
            }
        });
        
    }
    
    public void atualizarCombo() throws ConvenioErro
    {
        
        this.setAlwaysOnTop(false);
         
         Fachada f = new Fachada();
         List listar = f.pesquisarConvenioPorStatus();
         Iterator it = listar.iterator();
         while(it.hasNext()){
             Convenio co = (Convenio)it.next();             
             jComboBox_convenio.addItem(co.getNome()); 
             if(this.c != null){
                if(this.c.getNome().equals(co.getNome())){
                       jComboBox_convenio.setSelectedItem(co.getNome());
                       
                }
             }
         }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel_esquerda = new javax.swing.JPanel();
        jLabel_imagem_indice_escore = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel_direita = new javax.swing.JPanel();
        jLabel_segmento = new javax.swing.JLabel();
        jLabel_repouso = new javax.swing.JLabel();
        jLabel_baixa = new javax.swing.JLabel();
        jLabel_pico = new javax.swing.JLabel();
        jLabel_recuperacao = new javax.swing.JLabel();
        jLabel_segmento_1 = new javax.swing.JLabel();
        jLabel_segmento_2 = new javax.swing.JLabel();
        jLabel_segmento_3 = new javax.swing.JLabel();
        jLabel_segmento_4 = new javax.swing.JLabel();
        jLabel_segmento_5 = new javax.swing.JLabel();
        jLabel_segmento_6 = new javax.swing.JLabel();
        jLabel_segmento_7 = new javax.swing.JLabel();
        jLabel_segmento_8 = new javax.swing.JLabel();
        jLabel_segmento_9 = new javax.swing.JLabel();
        jLabel_segmento_10 = new javax.swing.JLabel();
        jLabel_segmento_11 = new javax.swing.JLabel();
        jLabel_segmento_12 = new javax.swing.JLabel();
        jLabel_segmento_13 = new javax.swing.JLabel();
        jLabel_segmento_14 = new javax.swing.JLabel();
        jLabel_segmento_15 = new javax.swing.JLabel();
        jLabel_segmento_17 = new javax.swing.JLabel();
        jLabel_segmento_16 = new javax.swing.JLabel();
        jTextField_repouso_1 = new javax.swing.JTextField();
        jTextField_baixa_dose_1 = new javax.swing.JTextField();
        jTextField_pico_1 = new javax.swing.JTextField();
        jTextField_recuperacao_1 = new javax.swing.JTextField();
        jTextField_repouso_2 = new javax.swing.JTextField();
        jTextField_baixa_dose_2 = new javax.swing.JTextField();
        jTextField_pico_2 = new javax.swing.JTextField();
        jTextField_recuperacao_2 = new javax.swing.JTextField();
        jTextField_repouso_3 = new javax.swing.JTextField();
        jTextField_baixa_dose_3 = new javax.swing.JTextField();
        jTextField_pico_3 = new javax.swing.JTextField();
        jTextField_recuperacao_3 = new javax.swing.JTextField();
        jTextField_repouso_4 = new javax.swing.JTextField();
        jTextField_baixa_dose_4 = new javax.swing.JTextField();
        jTextField_pico_4 = new javax.swing.JTextField();
        jTextField_recuperacao_4 = new javax.swing.JTextField();
        jTextField_repouso_5 = new javax.swing.JTextField();
        jTextField_baixa_dose_5 = new javax.swing.JTextField();
        jTextField_pico_5 = new javax.swing.JTextField();
        jTextField_recuperacao_5 = new javax.swing.JTextField();
        jTextField_repouso_6 = new javax.swing.JTextField();
        jTextField_baixa_dose_6 = new javax.swing.JTextField();
        jTextField_pico_6 = new javax.swing.JTextField();
        jTextField_recuperacao_6 = new javax.swing.JTextField();
        jTextField_repouso_7 = new javax.swing.JTextField();
        jTextField_baixa_dose_7 = new javax.swing.JTextField();
        jTextField_pico_7 = new javax.swing.JTextField();
        jTextField_recuperacao_7 = new javax.swing.JTextField();
        jTextField_repouso_8 = new javax.swing.JTextField();
        jTextField_baixa_dose_8 = new javax.swing.JTextField();
        jTextField_pico_8 = new javax.swing.JTextField();
        jTextField_recuperacao_8 = new javax.swing.JTextField();
        jTextField_repouso_9 = new javax.swing.JTextField();
        jTextField_baixa_dose_9 = new javax.swing.JTextField();
        jTextField_pico_9 = new javax.swing.JTextField();
        jTextField_recuperacao_9 = new javax.swing.JTextField();
        jTextField_repouso_10 = new javax.swing.JTextField();
        jTextField_baixa_dose_10 = new javax.swing.JTextField();
        jTextField_pico_10 = new javax.swing.JTextField();
        jTextField_recuperacao_10 = new javax.swing.JTextField();
        jTextField_repouso_11 = new javax.swing.JTextField();
        jTextField_baixa_dose_11 = new javax.swing.JTextField();
        jTextField_pico_11 = new javax.swing.JTextField();
        jTextField_recuperacao_11 = new javax.swing.JTextField();
        jTextField_repouso_12 = new javax.swing.JTextField();
        jTextField_baixa_dose_12 = new javax.swing.JTextField();
        jTextField_pico_12 = new javax.swing.JTextField();
        jTextField_recuperacao_12 = new javax.swing.JTextField();
        jTextField_repouso_13 = new javax.swing.JTextField();
        jTextField_baixa_dose_13 = new javax.swing.JTextField();
        jTextField_pico_13 = new javax.swing.JTextField();
        jTextField_recuperacao_13 = new javax.swing.JTextField();
        jTextField_repouso_14 = new javax.swing.JTextField();
        jTextField_baixa_dose_14 = new javax.swing.JTextField();
        jTextField_pico_14 = new javax.swing.JTextField();
        jTextField_recuperacao_14 = new javax.swing.JTextField();
        jTextField_repouso_15 = new javax.swing.JTextField();
        jTextField_baixa_dose_15 = new javax.swing.JTextField();
        jTextField_pico_15 = new javax.swing.JTextField();
        jTextField_recuperacao_15 = new javax.swing.JTextField();
        jTextField_repouso_16 = new javax.swing.JTextField();
        jTextField_baixa_dose_16 = new javax.swing.JTextField();
        jTextField_pico_16 = new javax.swing.JTextField();
        jTextField_recuperacao_16 = new javax.swing.JTextField();
        jTextField_recuperacao_17 = new javax.swing.JTextField();
        jTextField_pico_17 = new javax.swing.JTextField();
        jTextField_baixa_dose_17 = new javax.swing.JTextField();
        jTextField_repouso_17 = new javax.swing.JTextField();
        jLabel_paciente = new javax.swing.JLabel();
        jLabel_Convenio = new javax.swing.JLabel();
        jLabel_medicoResp = new javax.swing.JLabel();
        jComboBox_convenio = new javax.swing.JComboBox();
        jTextField_crm = new javax.swing.JTextField();
        jTextField_nome = new javax.swing.JTextField();
        jButton_medicos = new javax.swing.JButton();
        jLabel_tipo = new javax.swing.JLabel();
        jRadioButton_tt = new javax.swing.JRadioButton();
        jRadioButton_SEPD = new javax.swing.JRadioButton();
        jRadioButton_sub = new javax.swing.JRadioButton();
        jRadioButton_esc = new javax.swing.JRadioButton();
        jRadioButton_SEPE1 = new javax.swing.JRadioButton();
        jRadioButton_t = new javax.swing.JRadioButton();
        jLabel_nome_paciente = new javax.swing.JLabel();
        jButton_Salvar = new javax.swing.JButton();
        jButton_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Cadastro Laudo Escore");
        setAlwaysOnTop(true);

        jLabel_imagem_indice_escore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/indice_escore.png"))); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("INDICE DE ESCORE DE CONTRATILIDADE");

        javax.swing.GroupLayout jPanel_esquerdaLayout = new javax.swing.GroupLayout(jPanel_esquerda);
        jPanel_esquerda.setLayout(jPanel_esquerdaLayout);
        jPanel_esquerdaLayout.setHorizontalGroup(
            jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_esquerdaLayout.createSequentialGroup()
                .addGroup(jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 464, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_imagem_indice_escore, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_esquerdaLayout.setVerticalGroup(
            jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_esquerdaLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_imagem_indice_escore, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        jPanel_esquerda.setBounds(10, 150, 470, 530);
        jDesktopPane1.add(jPanel_esquerda, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_segmento.setText("Segmento");

        jLabel_repouso.setText("Repouso");

        jLabel_baixa.setText("Baixa Dose");

        jLabel_pico.setText("Pico");

        jLabel_recuperacao.setText("Recuperação");

        jLabel_segmento_1.setText("1");

        jLabel_segmento_2.setText("2");

        jLabel_segmento_3.setText("3");

        jLabel_segmento_4.setText("4");

        jLabel_segmento_5.setText("5");

        jLabel_segmento_6.setText("6");

        jLabel_segmento_7.setText("7");

        jLabel_segmento_8.setText("8");

        jLabel_segmento_9.setText("9");

        jLabel_segmento_10.setText("10");

        jLabel_segmento_11.setText("11");

        jLabel_segmento_12.setText("12");

        jLabel_segmento_13.setText("13");

        jLabel_segmento_14.setText("14");

        jLabel_segmento_15.setText("15");

        jLabel_segmento_17.setText("17");

        jLabel_segmento_16.setText("16");

        jTextField_repouso_1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_repouso_1FocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel_direitaLayout = new javax.swing.GroupLayout(jPanel_direita);
        jPanel_direita.setLayout(jPanel_direitaLayout);
        jPanel_direitaLayout.setHorizontalGroup(
            jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_segmento_1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_segmento))
                        .addGap(38, 38, 38)
                        .addComponent(jLabel_repouso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel_baixa)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel_pico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel_recuperacao))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                        .addComponent(jLabel_segmento_17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField_recuperacao_17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                .addComponent(jLabel_segmento_16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_repouso_17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_repouso_16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jTextField_repouso_1)))
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_baixa_dose_4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_baixa_dose_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_baixa_dose_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_baixa_dose_1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jTextField_pico_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField_recuperacao_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_pico_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_pico_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_recuperacao_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jTextField_pico_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTextField_recuperacao_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_baixa_dose_15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField_pico_12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField_pico_13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField_pico_14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField_pico_15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField_pico_16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jTextField_pico_17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_recuperacao_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_baixa_dose_6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_pico_5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_pico_6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_pico_7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_recuperacao_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_recuperacao_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField_baixa_dose_11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jTextField_recuperacao_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                        .addComponent(jTextField_pico_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField_recuperacao_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(jTextField_pico_9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                        .addComponent(jTextField_pico_8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jTextField_recuperacao_8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                .addComponent(jTextField_pico_11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jTextField_recuperacao_11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))))))
                .addContainerGap())
        );
        jPanel_direitaLayout.setVerticalGroup(
            jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento)
                    .addComponent(jLabel_repouso)
                    .addComponent(jLabel_baixa)
                    .addComponent(jLabel_pico)
                    .addComponent(jLabel_recuperacao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_14, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_segmento_16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_repouso_16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_16, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_repouso_17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_baixa_dose_17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_recuperacao_17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_pico_17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_segmento_17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel_direita.setBounds(650, 130, 480, 600);
        jDesktopPane1.add(jPanel_direita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_paciente.setText("Paciente");
        jLabel_paciente.setBounds(20, 20, 70, 14);
        jDesktopPane1.add(jLabel_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_Convenio.setText("Convênio");
        jLabel_Convenio.setBounds(20, 50, 70, 20);
        jDesktopPane1.add(jLabel_Convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_medicoResp.setText("Médico Responsável:");
        jLabel_medicoResp.setBounds(20, 77, 160, 30);
        jDesktopPane1.add(jLabel_medicoResp, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jComboBox_convenio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { ".: Selecione :." }));
        jComboBox_convenio.setBounds(100, 47, 460, 30);
        jDesktopPane1.add(jComboBox_convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

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
        jTextField_crm.setBounds(180, 80, 60, 26);
        jDesktopPane1.add(jTextField_crm, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jTextField_nome.setBounds(250, 80, 340, 26);
        jDesktopPane1.add(jTextField_nome, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_medicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/busca.png"))); // NOI18N
        jButton_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_medicosActionPerformed(evt);
            }
        });
        jButton_medicos.setBounds(600, 70, 50, 40);
        jDesktopPane1.add(jButton_medicos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_tipo.setText("Tipos de laudos:");
        jLabel_tipo.setBounds(640, 20, 120, 14);
        jDesktopPane1.add(jLabel_tipo, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_tt.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_tt.setText("Transtorácico e Transesofágico");
        jRadioButton_tt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_ttActionPerformed(evt);
            }
        });
        jRadioButton_tt.setBounds(770, 20, 200, 23);
        jDesktopPane1.add(jRadioButton_tt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });
        jRadioButton_SEPD.setBounds(770, 50, 200, 23);
        jDesktopPane1.add(jRadioButton_SEPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });
        jRadioButton_sub.setBounds(770, 80, 200, 23);
        jDesktopPane1.add(jRadioButton_sub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esc.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_esc.setText("Escore");
        jRadioButton_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_escActionPerformed(evt);
            }
        });
        jRadioButton_esc.setBounds(1030, 80, 200, 23);
        jDesktopPane1.add(jRadioButton_esc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPE1.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPE1.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPE1ActionPerformed(evt);
            }
        });
        jRadioButton_SEPE1.setBounds(1030, 50, 200, 23);
        jDesktopPane1.add(jRadioButton_SEPE1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_t.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_t.setText("Transtorácico");
        jRadioButton_t.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_tActionPerformed(evt);
            }
        });
        jRadioButton_t.setBounds(1030, 20, 200, 23);
        jDesktopPane1.add(jRadioButton_t, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLabel_nome_paciente.setBounds(90, 10, 500, 30);
        jDesktopPane1.add(jLabel_nome_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_Salvar.setMnemonic('s');
        jButton_Salvar.setText("Salvar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });
        jButton_Salvar.setBounds(10, 700, 120, 40);
        jDesktopPane1.add(jButton_Salvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cancel.png"))); // NOI18N
        jButton_voltar.setMnemonic('c');
        jButton_voltar.setText("Cancelar");
        jButton_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_voltarActionPerformed(evt);
            }
        });
        jButton_voltar.setBounds(360, 700, 120, 40);
        jDesktopPane1.add(jButton_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_voltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton_voltarActionPerformed

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
        this.setAlwaysOnTop(false);
        
        Segmento segmento1  = new Segmento(), segmento2 = new Segmento(), segmento3  = new Segmento(),segmento4  = new Segmento(),segmento5  = new Segmento(),segmento6  = new Segmento(),segmento7  = new Segmento(),segmento8  = new Segmento(),segmento9  = new Segmento(),segmento10  = new Segmento(), segmento11  = new Segmento(),segmento12  = new Segmento(),segmento13  = new Segmento(),segmento14  = new Segmento(),segmento15  = new Segmento(),segmento16  = new Segmento(),segmento17 = new Segmento();
        
        segmento1.setBaixaDose((jTextField_baixa_dose_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_1.getText()));
        segmento1.setPico((jTextField_pico_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_1.getText()));
        segmento1.setRecuperacao((jTextField_recuperacao_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_1.getText()));
        segmento1.setRepouso((jTextField_repouso_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_1.getText()));
        
        segmento2.setBaixaDose((jTextField_baixa_dose_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_2.getText()));
        segmento2.setPico((jTextField_pico_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_2.getText()));
        segmento2.setRecuperacao((jTextField_recuperacao_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_2.getText()));
        segmento2.setRepouso((jTextField_repouso_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_2.getText()));
        
        segmento3.setBaixaDose((jTextField_baixa_dose_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_3.getText()));
        segmento3.setPico((jTextField_pico_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_3.getText()));
        segmento3.setRecuperacao((jTextField_recuperacao_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_3.getText()));
        segmento3.setRepouso((jTextField_repouso_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_3.getText()));
        
        segmento4.setBaixaDose((jTextField_baixa_dose_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_4.getText()));
        segmento4.setPico((jTextField_pico_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_4.getText()));
        segmento4.setRecuperacao((jTextField_recuperacao_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_4.getText()));
        segmento4.setRepouso((jTextField_repouso_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_4.getText()));
        
        segmento5.setBaixaDose((jTextField_baixa_dose_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_5.getText()));
        segmento5.setPico((jTextField_pico_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_5.getText()));
        segmento5.setRecuperacao((jTextField_recuperacao_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_5.getText()));
        segmento5.setRepouso((jTextField_repouso_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_5.getText()));
        
        segmento6.setBaixaDose((jTextField_baixa_dose_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_6.getText()));
        segmento6.setPico((jTextField_pico_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_6.getText()));
        segmento6.setRecuperacao((jTextField_recuperacao_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_6.getText()));
        segmento6.setRepouso((jTextField_repouso_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_6.getText()));
        
        segmento7.setBaixaDose((jTextField_baixa_dose_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_7.getText()));
        segmento7.setPico((jTextField_pico_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_7.getText()));
        segmento7.setRecuperacao((jTextField_recuperacao_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_7.getText()));
        segmento7.setRepouso((jTextField_repouso_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_7.getText()));
        
        segmento8.setBaixaDose((jTextField_baixa_dose_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_8.getText()));
        segmento8.setPico((jTextField_pico_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_8.getText()));
        segmento8.setRecuperacao((jTextField_recuperacao_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_8.getText()));
        segmento8.setRepouso((jTextField_repouso_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_8.getText()));
        
        segmento9.setBaixaDose((jTextField_baixa_dose_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_9.getText()));
        segmento9.setPico((jTextField_pico_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_9.getText()));
        segmento9.setRecuperacao((jTextField_recuperacao_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_9.getText()));
        segmento9.setRepouso((jTextField_repouso_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_9.getText()));
        
        segmento10.setBaixaDose((jTextField_baixa_dose_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_10.getText()));
        segmento10.setPico((jTextField_pico_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_10.getText()));
        segmento10.setRecuperacao((jTextField_recuperacao_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_10.getText()));
        segmento10.setRepouso((jTextField_repouso_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_10.getText()));
        
        segmento11.setBaixaDose((jTextField_baixa_dose_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_11.getText()));
        segmento11.setPico((jTextField_pico_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_11.getText()));
        segmento11.setRecuperacao((jTextField_recuperacao_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_11.getText()));
        segmento11.setRepouso((jTextField_repouso_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_11.getText()));
        
        segmento12.setBaixaDose((jTextField_baixa_dose_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_12.getText()));
        segmento12.setPico((jTextField_pico_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_12.getText()));
        segmento12.setRecuperacao((jTextField_recuperacao_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_12.getText()));
        segmento12.setRepouso((jTextField_repouso_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_12.getText()));
        
        segmento13.setBaixaDose((jTextField_baixa_dose_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_13.getText()));
        segmento13.setPico((jTextField_pico_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_13.getText()));
        segmento13.setRecuperacao((jTextField_recuperacao_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_13.getText()));
        segmento13.setRepouso((jTextField_repouso_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_13.getText()));
        
        segmento14.setBaixaDose((jTextField_baixa_dose_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_14.getText()));
        segmento14.setPico((jTextField_pico_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_14.getText()));
        segmento14.setRecuperacao((jTextField_recuperacao_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_14.getText()));
        segmento14.setRepouso((jTextField_repouso_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_14.getText()));
        
        segmento15.setBaixaDose((jTextField_baixa_dose_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_15.getText()));
        segmento15.setPico((jTextField_pico_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_15.getText()));
        segmento15.setRecuperacao((jTextField_recuperacao_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_15.getText()));
        segmento15.setRepouso((jTextField_repouso_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_15.getText()));
        
        segmento16.setBaixaDose((jTextField_baixa_dose_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_16.getText()));
        segmento16.setPico((jTextField_pico_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_16.getText()));
        segmento16.setRecuperacao((jTextField_recuperacao_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_16.getText()));
        segmento16.setRepouso((jTextField_repouso_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_16.getText()));
        
        segmento17.setBaixaDose((jTextField_baixa_dose_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_17.getText()));
        segmento17.setPico((jTextField_pico_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_17.getText()));
        segmento17.setRecuperacao((jTextField_recuperacao_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_17.getText()));
        segmento17.setRepouso((jTextField_repouso_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_17.getText())); 
        
        LaudoEscore escore = new LaudoEscore(laudoEcoId,segmento1, segmento2, segmento3, segmento4, segmento5, segmento6, segmento7, segmento8, segmento9, segmento10, segmento11, segmento12, segmento13, segmento14, segmento15, segmento16, segmento17);
        Fachada f = new Fachada();
        try {
            // verifica e pega id e imprime
            if(f.cadastrarLaudoEscore(escore)){
                int id;
                id = f.LaudoUltimoIdEscore();
                
                try{  
                    Connection con;
                    Myconnection conexao = new Myconnection();
                    con = conexao.getConnection();

                    String local = System.getProperty("user.dir");  
                    String logo = local+"/src/imagens/logo.jpg";
                    String imgEscore = local+"/src/imagens/indice_escore.png";
                    String imgFooter = local+"/src/imagens/Escore_baixo.png";

                    JasperDesign jasperDesign = JRXmlLoader.load(local+"/src/relatorio/Escore.jrxml");  
                    JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);  

                    Map parametro = new HashMap();  
                    parametro.put("LaudoEscore_id",id);  
                    parametro.put("Logo",logo);
                    parametro.put("imgEscore",imgEscore);
                    parametro.put("imgFooter",imgFooter);

                    JasperPrint print;  
                    print = JasperFillManager.fillReport(jasperReport,parametro,con);
                    JasperViewer viewer = new JasperViewer(print,false);  

                    viewer.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);  
                    if (!print.getPages().isEmpty()) {  
                        float zoom = (float) 1;
                        viewer.setTitle("Visualização de Impressão");
                        viewer.setZoomRatio(zoom);
                        viewer.setAlwaysOnTop(true);
                        viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);  
                        viewer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);  
                        viewer.setVisible(true);  
                    }
                    this.dispose();
                }catch(Exception erro){  
                    System.out.println(erro.getMessage());
                    this.dispose();
                }  
                 
          }
       } catch (LaudoEscoreErro ex) {
            Logger.getLogger(cadastroEscore.class.getName()).log(Level.SEVERE, null, ex);
       }
        
    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jTextField_crmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_crmActionPerformed
        String crm = jTextField_crm.getText();
        ExpressaoRegular er = new ExpressaoRegular();
        if(er.isNum(crm)){
            Fachada f = new Fachada();
            this.setAlwaysOnTop(false);
            try {
                m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
                jTextField_nome.setText(m.getNome());

            } catch (MedicoErro ex) {

                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);

            }
        }else{
            jTextField_crm.setText("");
        }
    }//GEN-LAST:event_jTextField_crmActionPerformed

    private void jTextField_crmFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_crmFocusLost
        String crm = jTextField_crm.getText();
        ExpressaoRegular er = new ExpressaoRegular();
        if(er.isNum(crm)){
            Fachada f = new Fachada();
            this.setAlwaysOnTop(false);
            try {
                m = f.pesquisarMedicoPorCrm(Integer.parseInt(jTextField_crm.getText()));
                jTextField_nome.setText(m.getNome());

            } catch (MedicoErro ex) {

                Logger.getLogger(cadastroSubjetivo.class.getName()).log(Level.SEVERE, null, ex);

            }
        }else{
            jTextField_crm.setText("");
        }
    }//GEN-LAST:event_jTextField_crmFocusLost

    private void jButton_medicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_medicosActionPerformed
        // TODO add your handling code here:
        JDialog dialogo = new selecionaMedicoDial(this,true);
        dialogo.setVisible(true);
        Fachada f = new Fachada();
        try {
            
            this.setEnabled(true);
            Medico med = null;
            med = f.pesquisarMedicoAux();
            jTextField_nome.setText(med.getNome());
            jTextField_crm.setText(med.getCRM()+"");
                if(m!=null) {
                    this.m = med;
                }
            f.excluirMedicoAux(med);
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
        Fachada f = new Fachada();
        int idx =laudoEcoId;
        
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(this.tipo.equals("sub")){
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
        }else{
            if(es.getLaudoEcoId() != 0){
                try {
                new editarCadastroEstresse1(p,m,c,es,idx,"SEPD").setVisible(true);
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
        
        }
        
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

    private void jRadioButton_escActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_escActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton_escActionPerformed

    private void jRadioButton_SEPE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_SEPE1ActionPerformed
        // TODO add your handling code here:
        Fachada f = new Fachada();
        int idx =laudoEcoId;
        
        LaudoEstresse es = f.getLaudoEstresseById(idx);
        if(this.tipo.equals("sub")){
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
        }else{
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
        
        }
    }//GEN-LAST:event_jRadioButton_SEPE1ActionPerformed

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

    private void jTextField_repouso_1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_repouso_1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_repouso_1FocusLost
    
    private void clicadoKeyReleased(java.awt.event.KeyEvent evt, JTextField campo){
       String t = campo.getText();
       campo.setText(base.getDigNum(t));
    }
    
    private void perdaFocus(java.awt.event.FocusEvent evt, JTextField campo){
       String t = campo.getText();
       campo.setText(base.getDigNum(t));
    }
    
    String tipo = "";
    Eco eco;
    Medico m;
    Paciente p;
    Convenio c;
    Base base = new Base();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Salvar;
    private javax.swing.JButton jButton_medicos;
    private javax.swing.JButton jButton_voltar;
    private javax.swing.JComboBox jComboBox_convenio;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel_Convenio;
    private javax.swing.JLabel jLabel_baixa;
    private javax.swing.JLabel jLabel_imagem_indice_escore;
    private javax.swing.JLabel jLabel_medicoResp;
    private javax.swing.JLabel jLabel_nome_paciente;
    private javax.swing.JLabel jLabel_paciente;
    private javax.swing.JLabel jLabel_pico;
    private javax.swing.JLabel jLabel_recuperacao;
    private javax.swing.JLabel jLabel_repouso;
    private javax.swing.JLabel jLabel_segmento;
    private javax.swing.JLabel jLabel_segmento_1;
    private javax.swing.JLabel jLabel_segmento_10;
    private javax.swing.JLabel jLabel_segmento_11;
    private javax.swing.JLabel jLabel_segmento_12;
    private javax.swing.JLabel jLabel_segmento_13;
    private javax.swing.JLabel jLabel_segmento_14;
    private javax.swing.JLabel jLabel_segmento_15;
    private javax.swing.JLabel jLabel_segmento_16;
    private javax.swing.JLabel jLabel_segmento_17;
    private javax.swing.JLabel jLabel_segmento_2;
    private javax.swing.JLabel jLabel_segmento_3;
    private javax.swing.JLabel jLabel_segmento_4;
    private javax.swing.JLabel jLabel_segmento_5;
    private javax.swing.JLabel jLabel_segmento_6;
    private javax.swing.JLabel jLabel_segmento_7;
    private javax.swing.JLabel jLabel_segmento_8;
    private javax.swing.JLabel jLabel_segmento_9;
    private javax.swing.JLabel jLabel_tipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel_direita;
    private javax.swing.JPanel jPanel_esquerda;
    private javax.swing.JRadioButton jRadioButton_SEPD;
    private javax.swing.JRadioButton jRadioButton_SEPE1;
    private javax.swing.JRadioButton jRadioButton_esc;
    private javax.swing.JRadioButton jRadioButton_sub;
    private javax.swing.JRadioButton jRadioButton_t;
    private javax.swing.JRadioButton jRadioButton_tt;
    private javax.swing.JTextField jTextField_baixa_dose_1;
    private javax.swing.JTextField jTextField_baixa_dose_10;
    private javax.swing.JTextField jTextField_baixa_dose_11;
    private javax.swing.JTextField jTextField_baixa_dose_12;
    private javax.swing.JTextField jTextField_baixa_dose_13;
    private javax.swing.JTextField jTextField_baixa_dose_14;
    private javax.swing.JTextField jTextField_baixa_dose_15;
    private javax.swing.JTextField jTextField_baixa_dose_16;
    private javax.swing.JTextField jTextField_baixa_dose_17;
    private javax.swing.JTextField jTextField_baixa_dose_2;
    private javax.swing.JTextField jTextField_baixa_dose_3;
    private javax.swing.JTextField jTextField_baixa_dose_4;
    private javax.swing.JTextField jTextField_baixa_dose_5;
    private javax.swing.JTextField jTextField_baixa_dose_6;
    private javax.swing.JTextField jTextField_baixa_dose_7;
    private javax.swing.JTextField jTextField_baixa_dose_8;
    private javax.swing.JTextField jTextField_baixa_dose_9;
    private javax.swing.JTextField jTextField_crm;
    private javax.swing.JTextField jTextField_nome;
    private javax.swing.JTextField jTextField_pico_1;
    private javax.swing.JTextField jTextField_pico_10;
    private javax.swing.JTextField jTextField_pico_11;
    private javax.swing.JTextField jTextField_pico_12;
    private javax.swing.JTextField jTextField_pico_13;
    private javax.swing.JTextField jTextField_pico_14;
    private javax.swing.JTextField jTextField_pico_15;
    private javax.swing.JTextField jTextField_pico_16;
    private javax.swing.JTextField jTextField_pico_17;
    private javax.swing.JTextField jTextField_pico_2;
    private javax.swing.JTextField jTextField_pico_3;
    private javax.swing.JTextField jTextField_pico_4;
    private javax.swing.JTextField jTextField_pico_5;
    private javax.swing.JTextField jTextField_pico_6;
    private javax.swing.JTextField jTextField_pico_7;
    private javax.swing.JTextField jTextField_pico_8;
    private javax.swing.JTextField jTextField_pico_9;
    private javax.swing.JTextField jTextField_recuperacao_1;
    private javax.swing.JTextField jTextField_recuperacao_10;
    private javax.swing.JTextField jTextField_recuperacao_11;
    private javax.swing.JTextField jTextField_recuperacao_12;
    private javax.swing.JTextField jTextField_recuperacao_13;
    private javax.swing.JTextField jTextField_recuperacao_14;
    private javax.swing.JTextField jTextField_recuperacao_15;
    private javax.swing.JTextField jTextField_recuperacao_16;
    private javax.swing.JTextField jTextField_recuperacao_17;
    private javax.swing.JTextField jTextField_recuperacao_2;
    private javax.swing.JTextField jTextField_recuperacao_3;
    private javax.swing.JTextField jTextField_recuperacao_4;
    private javax.swing.JTextField jTextField_recuperacao_5;
    private javax.swing.JTextField jTextField_recuperacao_6;
    private javax.swing.JTextField jTextField_recuperacao_7;
    private javax.swing.JTextField jTextField_recuperacao_8;
    private javax.swing.JTextField jTextField_recuperacao_9;
    private javax.swing.JTextField jTextField_repouso_1;
    private javax.swing.JTextField jTextField_repouso_10;
    private javax.swing.JTextField jTextField_repouso_11;
    private javax.swing.JTextField jTextField_repouso_12;
    private javax.swing.JTextField jTextField_repouso_13;
    private javax.swing.JTextField jTextField_repouso_14;
    private javax.swing.JTextField jTextField_repouso_15;
    private javax.swing.JTextField jTextField_repouso_16;
    private javax.swing.JTextField jTextField_repouso_17;
    private javax.swing.JTextField jTextField_repouso_2;
    private javax.swing.JTextField jTextField_repouso_3;
    private javax.swing.JTextField jTextField_repouso_4;
    private javax.swing.JTextField jTextField_repouso_5;
    private javax.swing.JTextField jTextField_repouso_6;
    private javax.swing.JTextField jTextField_repouso_7;
    private javax.swing.JTextField jTextField_repouso_8;
    private javax.swing.JTextField jTextField_repouso_9;
    // End of variables declaration//GEN-END:variables
}
