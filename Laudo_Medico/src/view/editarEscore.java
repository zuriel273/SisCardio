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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.*;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import laudo.Eco;
import laudo.LaudoErro;
import laudoEscore.*;
import laudoEstresse.LaudoEstresse;
import medico.Medico;
import medico.MedicoErro;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import paciente.Paciente;
import segmento.*;

/**
 *
 * @author massilva
 */
public class editarEscore extends javax.swing.JFrame {

    /**
     * Creates new form cadastroEscore
     */
    int laudoEcoId;
    LaudoEscore escore;
    
     public editarEscore(Paciente p, Medico m, Convenio c,LaudoEscore escore,int laudoEcoId, String tipo) {
       
        this.setAlwaysOnTop(true);
        
        initComponents();
        
        Dimension d = new Dimension (  
            (int) Toolkit.getDefaultToolkit ().getScreenSize ().getWidth (),(int) Toolkit.getDefaultToolkit().getScreenSize().getHeight());  

        this.setSize(d);
        
        System.out.println(d.height); 
        System.out.println(d.width); 
        
        
        
        this.setPreferredSize(d);
        this.setMinimumSize(d);
        
        this.laudoEcoId = laudoEcoId;
        this.escore = escore;
        this.p = p;
        this.c = c;
        this.m = m;
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        
        jRadioButton_esc.setSelected(true);
        
        this.tipo = tipo;
        
        jRadioButton_tt.setEnabled(false);
        jRadioButton_t.setEnabled(false);
        
        Segmento[] segmento = escore.getSegmento();
        
        jTextField_baixa_dose_1.setText(segmento[0].getBaixaDose()+"");
        jTextField_baixa_dose_10.setText(segmento[9].getBaixaDose()+"");
        jTextField_baixa_dose_11.setText(segmento[10].getBaixaDose()+"");
        jTextField_baixa_dose_12.setText(segmento[11].getBaixaDose()+"");
        jTextField_baixa_dose_13.setText(segmento[12].getBaixaDose()+"");
        jTextField_baixa_dose_14.setText(segmento[13].getBaixaDose()+"");
        jTextField_baixa_dose_15.setText(segmento[14].getBaixaDose()+"");
        jTextField_baixa_dose_16.setText(segmento[15].getBaixaDose()+"");
        jTextField_baixa_dose_17.setText(segmento[16].getBaixaDose()+"");
        jTextField_baixa_dose_2.setText(segmento[1].getBaixaDose()+"");
        jTextField_baixa_dose_3.setText(segmento[2].getBaixaDose()+"");
        jTextField_baixa_dose_4.setText(segmento[3].getBaixaDose()+"");
        jTextField_baixa_dose_5.setText(segmento[4].getBaixaDose()+"");
        jTextField_baixa_dose_6.setText(segmento[5].getBaixaDose()+"");
        jTextField_baixa_dose_7.setText(segmento[6].getBaixaDose()+"");
        jTextField_baixa_dose_8.setText(segmento[7].getBaixaDose()+"");
        jTextField_baixa_dose_9.setText(segmento[8].getBaixaDose()+"");
        jTextField_pico_1.setText(segmento[0].getPico()+"");
        jTextField_pico_10.setText(segmento[9].getPico()+"");
        jTextField_pico_11.setText(segmento[10].getPico()+"");
        jTextField_pico_12.setText(segmento[11].getPico()+"");
        jTextField_pico_13.setText(segmento[12].getPico()+"");
        jTextField_pico_14.setText(segmento[13].getPico()+"");
        jTextField_pico_15.setText(segmento[14].getPico()+"");
        jTextField_pico_16.setText(segmento[15].getPico()+"");
        jTextField_pico_17.setText(segmento[16].getPico()+"");
        jTextField_pico_2.setText(segmento[1].getPico()+"");
        jTextField_pico_3.setText(segmento[2].getPico()+"");
        jTextField_pico_4.setText(segmento[3].getPico()+"");
        jTextField_pico_5.setText(segmento[4].getPico()+"");
        jTextField_pico_6.setText(segmento[5].getPico()+"");
        jTextField_pico_7.setText(segmento[6].getPico()+"");
        jTextField_pico_8.setText(segmento[7].getPico()+"");
        jTextField_pico_9.setText(segmento[8].getPico()+"");
        jTextField_recuperacao_1.setText(segmento[0].getRecuperacao()+"");
        jTextField_recuperacao_10.setText(segmento[9].getRecuperacao()+"");
        jTextField_recuperacao_11.setText(segmento[10].getRecuperacao()+"");
        jTextField_recuperacao_12.setText(segmento[11].getRecuperacao()+"");
        jTextField_recuperacao_13.setText(segmento[12].getRecuperacao()+"");
        jTextField_recuperacao_14.setText(segmento[13].getRecuperacao()+"");
        jTextField_recuperacao_15.setText(segmento[14].getRecuperacao()+"");
        jTextField_recuperacao_16.setText(segmento[15].getRecuperacao()+"");
        jTextField_recuperacao_17.setText(segmento[16].getRecuperacao()+"");
        jTextField_recuperacao_2.setText(segmento[1].getRecuperacao()+"");
        jTextField_recuperacao_3.setText(segmento[2].getRecuperacao()+"");
        jTextField_recuperacao_4.setText(segmento[3].getRecuperacao()+"");
        jTextField_recuperacao_5.setText(segmento[4].getRecuperacao()+"");
        jTextField_recuperacao_6.setText(segmento[5].getRecuperacao()+"");
        jTextField_recuperacao_7.setText(segmento[6].getRecuperacao()+"");
        jTextField_recuperacao_8.setText(segmento[7].getRecuperacao()+"");
        jTextField_recuperacao_9.setText(segmento[8].getRecuperacao()+"");
        jTextField_repouso_1.setText(segmento[0].getRepouso()+"");
        jTextField_repouso_10.setText(segmento[9].getRepouso()+"");
        jTextField_repouso_11.setText(segmento[10].getRepouso()+"");
        jTextField_repouso_12.setText(segmento[11].getRepouso()+"");
        jTextField_repouso_13.setText(segmento[12].getRepouso()+"");
        jTextField_repouso_14.setText(segmento[13].getRepouso()+"");
        jTextField_repouso_15.setText(segmento[14].getRepouso()+"");
        jTextField_repouso_16.setText(segmento[15].getRepouso()+"");
        jTextField_repouso_17.setText(segmento[16].getRepouso()+"");
        jTextField_repouso_2.setText(segmento[1].getRepouso()+"");
        jTextField_repouso_3.setText(segmento[2].getRepouso()+"");
        jTextField_repouso_4.setText(segmento[3].getRepouso()+"");
        jTextField_repouso_5.setText(segmento[4].getRepouso()+"");
        jTextField_repouso_6.setText(segmento[5].getRepouso()+"");
        jTextField_repouso_7.setText(segmento[6].getRepouso()+"");
        jTextField_repouso_8.setText(segmento[7].getRepouso()+"");
        jTextField_repouso_9.setText(segmento[8].getRepouso()+"");
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
            
    public editarEscore(Paciente p, Medico m, Convenio c,LaudoEscore escore,int laudoEcoId) {
       
        this.setAlwaysOnTop(true);
        
        initComponents();
        this.laudoEcoId = laudoEcoId;
        this.escore = escore;
        this.p = p;
        this.c = c;
        this.m = m;
        jLabel_nome_paciente.setText(p.getNome());
        jTextField_crm.setText(m.getCRM()+"");
        jTextField_nome.setText(m.getNome());
        
        jRadioButton_esc.setSelected(true);
        
        jRadioButton_sub.setEnabled(false);
        
        Segmento[] segmento = escore.getSegmento();
        
        jTextField_baixa_dose_1.setText(segmento[0].getBaixaDose()+"");
        jTextField_baixa_dose_10.setText(segmento[9].getBaixaDose()+"");
        jTextField_baixa_dose_11.setText(segmento[10].getBaixaDose()+"");
        jTextField_baixa_dose_12.setText(segmento[11].getBaixaDose()+"");
        jTextField_baixa_dose_13.setText(segmento[12].getBaixaDose()+"");
        jTextField_baixa_dose_14.setText(segmento[13].getBaixaDose()+"");
        jTextField_baixa_dose_15.setText(segmento[14].getBaixaDose()+"");
        jTextField_baixa_dose_16.setText(segmento[15].getBaixaDose()+"");
        jTextField_baixa_dose_17.setText(segmento[16].getBaixaDose()+"");
        jTextField_baixa_dose_2.setText(segmento[1].getBaixaDose()+"");
        jTextField_baixa_dose_3.setText(segmento[2].getBaixaDose()+"");
        jTextField_baixa_dose_4.setText(segmento[3].getBaixaDose()+"");
        jTextField_baixa_dose_5.setText(segmento[4].getBaixaDose()+"");
        jTextField_baixa_dose_6.setText(segmento[5].getBaixaDose()+"");
        jTextField_baixa_dose_7.setText(segmento[6].getBaixaDose()+"");
        jTextField_baixa_dose_8.setText(segmento[7].getBaixaDose()+"");
        jTextField_baixa_dose_9.setText(segmento[8].getBaixaDose()+"");
        jTextField_pico_1.setText(segmento[0].getPico()+"");
        jTextField_pico_10.setText(segmento[9].getPico()+"");
        jTextField_pico_11.setText(segmento[10].getPico()+"");
        jTextField_pico_12.setText(segmento[11].getPico()+"");
        jTextField_pico_13.setText(segmento[12].getPico()+"");
        jTextField_pico_14.setText(segmento[13].getPico()+"");
        jTextField_pico_15.setText(segmento[14].getPico()+"");
        jTextField_pico_16.setText(segmento[15].getPico()+"");
        jTextField_pico_17.setText(segmento[16].getPico()+"");
        jTextField_pico_2.setText(segmento[1].getPico()+"");
        jTextField_pico_3.setText(segmento[2].getPico()+"");
        jTextField_pico_4.setText(segmento[3].getPico()+"");
        jTextField_pico_5.setText(segmento[4].getPico()+"");
        jTextField_pico_6.setText(segmento[5].getPico()+"");
        jTextField_pico_7.setText(segmento[6].getPico()+"");
        jTextField_pico_8.setText(segmento[7].getPico()+"");
        jTextField_pico_9.setText(segmento[8].getPico()+"");
        jTextField_recuperacao_1.setText(segmento[0].getRecuperacao()+"");
        jTextField_recuperacao_10.setText(segmento[9].getRecuperacao()+"");
        jTextField_recuperacao_11.setText(segmento[10].getRecuperacao()+"");
        jTextField_recuperacao_12.setText(segmento[11].getRecuperacao()+"");
        jTextField_recuperacao_13.setText(segmento[12].getRecuperacao()+"");
        jTextField_recuperacao_14.setText(segmento[13].getRecuperacao()+"");
        jTextField_recuperacao_15.setText(segmento[14].getRecuperacao()+"");
        jTextField_recuperacao_16.setText(segmento[15].getRecuperacao()+"");
        jTextField_recuperacao_17.setText(segmento[16].getRecuperacao()+"");
        jTextField_recuperacao_2.setText(segmento[1].getRecuperacao()+"");
        jTextField_recuperacao_3.setText(segmento[2].getRecuperacao()+"");
        jTextField_recuperacao_4.setText(segmento[3].getRecuperacao()+"");
        jTextField_recuperacao_5.setText(segmento[4].getRecuperacao()+"");
        jTextField_recuperacao_6.setText(segmento[5].getRecuperacao()+"");
        jTextField_recuperacao_7.setText(segmento[6].getRecuperacao()+"");
        jTextField_recuperacao_8.setText(segmento[7].getRecuperacao()+"");
        jTextField_recuperacao_9.setText(segmento[8].getRecuperacao()+"");
        jTextField_repouso_1.setText(segmento[0].getRepouso()+"");
        jTextField_repouso_10.setText(segmento[9].getRepouso()+"");
        jTextField_repouso_11.setText(segmento[10].getRepouso()+"");
        jTextField_repouso_12.setText(segmento[11].getRepouso()+"");
        jTextField_repouso_13.setText(segmento[12].getRepouso()+"");
        jTextField_repouso_14.setText(segmento[13].getRepouso()+"");
        jTextField_repouso_15.setText(segmento[14].getRepouso()+"");
        jTextField_repouso_16.setText(segmento[15].getRepouso()+"");
        jTextField_repouso_17.setText(segmento[16].getRepouso()+"");
        jTextField_repouso_2.setText(segmento[1].getRepouso()+"");
        jTextField_repouso_3.setText(segmento[2].getRepouso()+"");
        jTextField_repouso_4.setText(segmento[3].getRepouso()+"");
        jTextField_repouso_5.setText(segmento[4].getRepouso()+"");
        jTextField_repouso_6.setText(segmento[5].getRepouso()+"");
        jTextField_repouso_7.setText(segmento[6].getRepouso()+"");
        jTextField_repouso_8.setText(segmento[7].getRepouso()+"");
        jTextField_repouso_9.setText(segmento[8].getRepouso()+"");
        try {
            atualizarCombo();
        } catch (ConvenioErro ex) {
            Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
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
    
    private Base base = new Base();
    private void clicadoKeyReleased(java.awt.event.KeyEvent evt, JTextField campo){
       String t = campo.getText();
       campo.setText(base.getDigNum(t));
    }
    
    private void perdaFocus(java.awt.event.FocusEvent evt, JTextField campo){
       String t = campo.getText();
       campo.setText(base.getDigNum(t));
    }
    public void atualizarCombo() throws ConvenioErro{
        
         jTextField_crm.setEnabled(false);
        jButton_medicos.setEnabled(false);
        jComboBox_convenio.setEnabled(false);
        jTextField_nome.setEnabled(false);
        
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
    }

    
    private void imprimeRelatorio(int id)  {  
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel_rodape = new javax.swing.JPanel();
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
        jLabel_tipo = new javax.swing.JLabel();
        jRadioButton_tt = new javax.swing.JRadioButton();
        jRadioButton_SEPD = new javax.swing.JRadioButton();
        jRadioButton_sub = new javax.swing.JRadioButton();
        jRadioButton_esc = new javax.swing.JRadioButton();
        jRadioButton_SEPE1 = new javax.swing.JRadioButton();
        jRadioButton_t = new javax.swing.JRadioButton();
        jLabel_nome_paciente = new javax.swing.JLabel();
        jButton_medicos = new javax.swing.JButton();
        jButton_Salvar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton_voltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SisCardio :: Atualizar Dados de Laudo Escore");
        setAlwaysOnTop(true);

        javax.swing.GroupLayout jPanel_rodapeLayout = new javax.swing.GroupLayout(jPanel_rodape);
        jPanel_rodape.setLayout(jPanel_rodapeLayout);
        jPanel_rodapeLayout.setHorizontalGroup(
            jPanel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel_rodapeLayout.setVerticalGroup(
            jPanel_rodapeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel_rodape.setBounds(30, 760, 660, 50);
        jDesktopPane1.add(jPanel_rodape, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_imagem_indice_escore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/indice_escore.png"))); // NOI18N

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("INDICE DE ESCORE DE CONTRATILIDADE");

        javax.swing.GroupLayout jPanel_esquerdaLayout = new javax.swing.GroupLayout(jPanel_esquerda);
        jPanel_esquerda.setLayout(jPanel_esquerdaLayout);
        jPanel_esquerdaLayout.setHorizontalGroup(
            jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_esquerdaLayout.createSequentialGroup()
                .addGroup(jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_imagem_indice_escore)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(6, 6, 6))
        );
        jPanel_esquerdaLayout.setVerticalGroup(
            jPanel_esquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_esquerdaLayout.createSequentialGroup()
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jLabel_imagem_indice_escore, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );

        jPanel_esquerda.setBounds(80, 120, 470, 530);
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
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField_repouso_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_baixa_dose_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel_repouso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel_baixa)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_pico_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_pico, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_recuperacao_1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_recuperacao)))
                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_segmento_17, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_15, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_15))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_14))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_13, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_12))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_11))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_10))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_9))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_8))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_7))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_6))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_5))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_4))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_3))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField_repouso_2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel_direitaLayout.createSequentialGroup()
                                        .addComponent(jLabel_segmento_16, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_repouso_17)
                                            .addComponent(jTextField_repouso_16))))
                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_baixa_dose_15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_17, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_baixa_dose_14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                    .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jTextField_baixa_dose_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_baixa_dose_3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_baixa_dose_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(1, 1, 1))
                                                .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                                    .addGap(2, 2, 2)
                                                    .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField_baixa_dose_6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_baixa_dose_5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_baixa_dose_7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel_direitaLayout.createSequentialGroup()
                                                .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jTextField_baixa_dose_13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTextField_baixa_dose_12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                                        .addGap(1, 1, 1)
                                                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jTextField_baixa_dose_11, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField_baixa_dose_9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField_baixa_dose_8, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField_baixa_dose_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(1, 1, 1)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_pico_17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_pico_12, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_13, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_14, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_16, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createSequentialGroup()
                                    .addComponent(jTextField_pico_10, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_pico_9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextField_pico_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_pico_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField_pico_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField_pico_3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_pico_5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_pico_7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_recuperacao_17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_direitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField_recuperacao_4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField_recuperacao_3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField_recuperacao_12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_recuperacao_6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

        jPanel_direita.setBounds(720, 130, 480, 600);
        jDesktopPane1.add(jPanel_direita, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_paciente.setText("Paciente");
        jLabel_paciente.setBounds(20, 20, 80, 14);
        jDesktopPane1.add(jLabel_paciente, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_Convenio.setText("Convênio");
        jLabel_Convenio.setBounds(20, 50, 80, 20);
        jDesktopPane1.add(jLabel_Convenio, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel_medicoResp.setText("Médico Responsável:");
        jLabel_medicoResp.setBounds(20, 77, 140, 30);
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
        jRadioButton_tt.setBounds(770, 20, 220, 23);
        jDesktopPane1.add(jRadioButton_tt, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPD.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPD.setText("Sob estresse pela Dobutamina");
        jRadioButton_SEPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPDActionPerformed(evt);
            }
        });
        jRadioButton_SEPD.setBounds(770, 50, 220, 23);
        jDesktopPane1.add(jRadioButton_SEPD, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_sub.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_sub.setText("Subjetivo");
        jRadioButton_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_subActionPerformed(evt);
            }
        });
        jRadioButton_sub.setBounds(770, 80, 220, 23);
        jDesktopPane1.add(jRadioButton_sub, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_esc.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_esc.setText("Escore");
        jRadioButton_esc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_escActionPerformed(evt);
            }
        });
        jRadioButton_esc.setBounds(1030, 80, 190, 23);
        jDesktopPane1.add(jRadioButton_esc, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jRadioButton_SEPE1.setBackground(new java.awt.Color(254, 254, 254));
        jRadioButton_SEPE1.setText("Sob estresse pelo Esforço");
        jRadioButton_SEPE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_SEPE1ActionPerformed(evt);
            }
        });
        jRadioButton_SEPE1.setBounds(1030, 50, 190, 23);
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

        jButton_medicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/busca.png"))); // NOI18N
        jButton_medicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_medicosActionPerformed(evt);
            }
        });
        jButton_medicos.setBounds(600, 70, 50, 40);
        jDesktopPane1.add(jButton_medicos, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_Salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/document-save22x22.png"))); // NOI18N
        jButton_Salvar.setMnemonic('a');
        jButton_Salvar.setText("Atualizar");
        jButton_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SalvarActionPerformed(evt);
            }
        });
        jButton_Salvar.setBounds(80, 670, 120, 40);
        jDesktopPane1.add(jButton_Salvar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/print.png"))); // NOI18N
        jButton1.setToolTipText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.setBounds(260, 670, 120, 40);
        jDesktopPane1.add(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/br_prev16x16.png"))); // NOI18N
        jButton_voltar.setMnemonic('v');
        jButton_voltar.setText("Voltar");
        jButton_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_voltarActionPerformed(evt);
            }
        });
        jButton_voltar.setBounds(430, 670, 120, 40);
        jDesktopPane1.add(jButton_voltar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_voltarActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_jButton_voltarActionPerformed

    private void jButton_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SalvarActionPerformed
        Segmento[] segmento = this.escore.getSegmento();
        
        segmento[0].setBaixaDose((jTextField_baixa_dose_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_1.getText()));
        segmento[0].setPico((jTextField_pico_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_1.getText()));
        segmento[0].setRecuperacao((jTextField_recuperacao_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_1.getText()));
        segmento[0].setRepouso((jTextField_repouso_1.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_1.getText()));
        
        segmento[1].setBaixaDose((jTextField_baixa_dose_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_2.getText()));
        segmento[1].setPico((jTextField_pico_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_2.getText()));
        segmento[1].setRecuperacao((jTextField_recuperacao_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_2.getText()));
        segmento[1].setRepouso((jTextField_repouso_2.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_2.getText()));
        
        segmento[2].setBaixaDose((jTextField_baixa_dose_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_3.getText()));
        segmento[2].setPico((jTextField_pico_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_3.getText()));
        segmento[2].setRecuperacao((jTextField_recuperacao_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_3.getText()));
        segmento[2].setRepouso((jTextField_repouso_3.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_3.getText()));
        
        segmento[3].setBaixaDose((jTextField_baixa_dose_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_4.getText()));
        segmento[3].setPico((jTextField_pico_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_4.getText()));
        segmento[3].setRecuperacao((jTextField_recuperacao_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_4.getText()));
        segmento[3].setRepouso((jTextField_repouso_4.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_4.getText()));
        
        segmento[4].setBaixaDose((jTextField_baixa_dose_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_5.getText()));
        segmento[4].setPico((jTextField_pico_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_5.getText()));
        segmento[4].setRecuperacao((jTextField_recuperacao_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_5.getText()));
        segmento[4].setRepouso((jTextField_repouso_5.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_5.getText()));
        
        segmento[5].setBaixaDose((jTextField_baixa_dose_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_6.getText()));
        segmento[5].setPico((jTextField_pico_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_6.getText()));
        segmento[5].setRecuperacao((jTextField_recuperacao_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_6.getText()));
        segmento[5].setRepouso((jTextField_repouso_6.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_6.getText()));
        
        segmento[6].setBaixaDose((jTextField_baixa_dose_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_7.getText()));
        segmento[6].setPico((jTextField_pico_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_7.getText()));
        segmento[6].setRecuperacao((jTextField_recuperacao_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_7.getText()));
        segmento[6].setRepouso((jTextField_repouso_7.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_7.getText()));
        
        segmento[7].setBaixaDose((jTextField_baixa_dose_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_8.getText()));
        segmento[7].setPico((jTextField_pico_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_8.getText()));
        segmento[7].setRecuperacao((jTextField_recuperacao_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_8.getText()));
        segmento[7].setRepouso((jTextField_repouso_8.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_8.getText()));
        
        segmento[8].setBaixaDose((jTextField_baixa_dose_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_9.getText()));
        segmento[8].setPico((jTextField_pico_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_9.getText()));
        segmento[8].setRecuperacao((jTextField_recuperacao_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_9.getText()));
        segmento[8].setRepouso((jTextField_repouso_9.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_9.getText()));
        
        segmento[9].setBaixaDose((jTextField_baixa_dose_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_10.getText()));
        segmento[9].setPico((jTextField_pico_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_10.getText()));
        segmento[9].setRecuperacao((jTextField_recuperacao_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_10.getText()));
        segmento[9].setRepouso((jTextField_repouso_10.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_10.getText()));
        
        segmento[10].setBaixaDose((jTextField_baixa_dose_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_11.getText()));
        segmento[10].setPico((jTextField_pico_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_11.getText()));
        segmento[10].setRecuperacao((jTextField_recuperacao_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_11.getText()));
        segmento[10].setRepouso((jTextField_repouso_11.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_11.getText()));
        
        segmento[11].setBaixaDose((jTextField_baixa_dose_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_12.getText()));
        segmento[11].setPico((jTextField_pico_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_12.getText()));
        segmento[11].setRecuperacao((jTextField_recuperacao_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_12.getText()));
        segmento[11].setRepouso((jTextField_repouso_12.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_12.getText()));
        
        segmento[12].setBaixaDose((jTextField_baixa_dose_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_13.getText()));
        segmento[12].setPico((jTextField_pico_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_13.getText()));
        segmento[12].setRecuperacao((jTextField_recuperacao_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_13.getText()));
        segmento[12].setRepouso((jTextField_repouso_13.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_13.getText()));
        
        segmento[13].setBaixaDose((jTextField_baixa_dose_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_14.getText()));
        segmento[13].setPico((jTextField_pico_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_14.getText()));
        segmento[13].setRecuperacao((jTextField_recuperacao_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_14.getText()));
        segmento[13].setRepouso((jTextField_repouso_14.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_14.getText()));
        
        segmento[14].setBaixaDose((jTextField_baixa_dose_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_15.getText()));
        segmento[14].setPico((jTextField_pico_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_15.getText()));
        segmento[14].setRecuperacao((jTextField_recuperacao_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_15.getText()));
        segmento[14].setRepouso((jTextField_repouso_15.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_15.getText()));
        
        segmento[15].setBaixaDose((jTextField_baixa_dose_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_16.getText()));
        segmento[15].setPico((jTextField_pico_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_16.getText()));
        segmento[15].setRecuperacao((jTextField_recuperacao_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_16.getText()));
        segmento[15].setRepouso((jTextField_repouso_16.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_16.getText()));
        
        segmento[16].setBaixaDose((jTextField_baixa_dose_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_baixa_dose_17.getText()));
        segmento[16].setPico((jTextField_pico_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_pico_17.getText()));
        segmento[16].setRecuperacao((jTextField_recuperacao_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_recuperacao_17.getText()));
        segmento[16].setRepouso((jTextField_repouso_17.getText().isEmpty()) ? 0 : Double.parseDouble(jTextField_repouso_17.getText())); 
        
        int id = escore.getId();
        this.escore = new LaudoEscore(id,laudoEcoId,segmento);
        Fachada f = new Fachada();
        try {
            String atualiza = f.atualizarLaudoEscore(this.escore);
            if(atualiza.equals("true")){
                JOptionPane.showMessageDialog(this, "Atualizado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(this, "Erro ao atualizar Laudo Escore." + atualiza);
            }
        } catch (LaudoEscoreErro ex) {
            Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton_SalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        imprimeRelatorio(escore.getId());
    }//GEN-LAST:event_jButton1ActionPerformed

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
        if(tipo.equals("sub")){
            LaudoEstresse es = f.getLaudoEstresseById(laudoEcoId);
            if(es.getLaudoEcoId() != 0){
                try {
                    new editarCadastroEstresse1(p,m,c,es,laudoEcoId,"SEPD","sub").setVisible(true);
                    this.dispose();
                } catch (LaudoErro ex) {
                   
                }
            }else{
                 try {
                        new cadastroEcoEstresse(p, m, c, "SEPD",laudoEcoId, this,"sub").setVisible(true);
                    } catch (LaudoErro ex1) {
                        Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex1);
                    }
            }
        
        }else{
            LaudoEstresse es = f.getLaudoEstresseById(laudoEcoId);
                if(es.getLaudoEcoId() != 0){
                    try {
                        new editarCadastroEstresse1(p,m,c,es,laudoEcoId,"SEPD").setVisible(true);
                        this.dispose();
                    } catch (LaudoErro ex) {
                        

                    }
                }else{
                    try {
                        new cadastroEcoEstresse(p, m, c, "SEPD",laudoEcoId, this).setVisible(true);
                         } catch (LaudoErro ex1) {
                        Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex1);
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
        if(tipo.equals("sub")){
            LaudoEstresse es = f.getLaudoEstresseById(laudoEcoId);
            if(es.getLaudoEcoId() != 0){
                try {
                    new editarCadastroEstresse1(p,m,c,es,laudoEcoId,"SEPE","sub").setVisible(true);
                    this.dispose();
                } catch (LaudoErro ex) {
                    
                }
            }else{
                try {
                        new cadastroEcoEstresse(p, m, c, "SEPE",laudoEcoId, this,"sub").setVisible(true);
                    } catch (LaudoErro ex1) {
                        Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex1);
                    }
            }
        
        }else{
            LaudoEstresse es = f.getLaudoEstresseById(laudoEcoId);
                if(es.getLaudoEcoId() != 0){
                    try {
                        new editarCadastroEstresse1(p,m,c,es,laudoEcoId,"SEPE").setVisible(true);
                        this.dispose();
                    } catch (LaudoErro ex) {
                       

                    }
                } else{
                     try {
                        new cadastroEcoEstresse(p, m, c, "SEPE",laudoEcoId, this).setVisible(true);
                     } catch (LaudoErro ex1) {
                        Logger.getLogger(editarEscore.class.getName()).log(Level.SEVERE, null, ex1);
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
    
    
    String tipo="";
    Eco eco;
    Medico m;
    Paciente p;
    Convenio c;
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
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
    private javax.swing.JPanel jPanel_direita;
    private javax.swing.JPanel jPanel_esquerda;
    private javax.swing.JPanel jPanel_rodape;
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
