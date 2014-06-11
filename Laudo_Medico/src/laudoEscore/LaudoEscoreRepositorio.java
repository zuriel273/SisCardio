/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEscore;

import conexao.Myconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import laudo.LaudoErro;
import segmento.Segmento;

/**
 *
 * @author arlindo
 */
public class LaudoEscoreRepositorio implements LaudoEscoreInterface {

    @Override
    public boolean cadastrarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro {
        String comandoSQL = "INSERT INTO `escore`(laudo_id) VALUES(" + laudoEscore.getLaudoEcoId() + ")";
        System.out.println(comandoSQL);
        ResultSet rs;
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            stmt.executeUpdate(comandoSQL);
            comandoSQL = "SELECT MAX(id) AS id FROM escore";
            rs = stmt.executeQuery(comandoSQL);
            int idLaudoEscoreInserido = 0;

            while (rs.next()) {
                idLaudoEscoreInserido = Integer.parseInt(rs.getString("id"));
            }
            System.out.print(idLaudoEscoreInserido);
            Segmento[] segmento = laudoEscore.getSegmento();
            for (int i = 0; i < 17; i++) {
                comandoSQL = "INSERT INTO `segmento`(`repouso`, `baixa_dose`, `pico`, `recuperacao`, `laudoEscore_Id`) VALUES(" + segmento[i].getRepouso() + "," + segmento[i].getBaixaDose() + "," + segmento[i].getPico() + "," + segmento[i].getRecuperacao() + "," + idLaudoEscoreInserido + ")";
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
            }

            stmt.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Laudo Escore." + ex.getMessage());
            ex.getStackTrace();
            return false;
        }
    }

    @Override
     public int LaudoUltimoIdEscore() throws LaudoEscoreErro{
            ResultSet rs;
            String comandoSQL;
            //comandoSQL ="SELECT * FROM escore WHERE id = LAST_INSERT_ID()";
            comandoSQL = "SELECT MAX(id) AS id FROM escore";
            int id =0;
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                while(rs.next()){                
                    id = Integer.parseInt(rs.getString("id"));
                }
                    stmt.close(); 
                return id;
                
            } catch(SQLException e){                
                
                e.printStackTrace();                
                return 0;
                
            }
            
    }
    
    @Override
    public String atualizarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro {
        
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            Segmento[] segmento = laudoEscore.getSegmento();
            for (int i = 0; i < 17; i++){
                String comandoSQL = "UPDATE `segmento` SET `repouso` = "+segmento[i].getRepouso()+", `baixa_dose` = "+segmento[i].getBaixaDose()+", `pico` = "+segmento[i].getPico()+", `recuperacao` = "+segmento[i].getRecuperacao()+" WHERE id = "+segmento[i].getId();
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
            }
            stmt.close();
            return "true";
        } catch (SQLException ex) {
            return ex.getMessage();
        }
    }

    @Override
    public List listarLaudoEscoreByPacienteID(int id_paciente) throws LaudoEscoreErro {
        List lista = new ArrayList();
        return lista;
    }

    @Override
    public List listarLaudoEscoreByLaudoEcoID(int id_laudo_eco) throws LaudoEscoreErro {
        List lista = new ArrayList();
        try {
            ResultSet rs, res;

            String query = "SELECT * from escore WHERE laudo_id = " + id_laudo_eco;
            System.out.println(query);
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                LaudoEscore escore = new LaudoEscore();
                escore.setId(rs.getInt("id"));
                escore.setLaudoEcoId(id_laudo_eco);
                lista.add(escore);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEscoreRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + this.getClass() + " - " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public LaudoEscore getLaudoEscoreById(int id) {
        
        ResultSet rs;
        ResultSet res;
        LaudoEscore escore = new LaudoEscore();
        java.sql.Statement stmt;
        String query = "SELECT * from escore WHERE laudo_id = " + id;
        
        
        LaudoEscore esc = new LaudoEscore();
        try {
                stmt = Myconnection.getStatement();
                rs = stmt.executeQuery(query);
                
                while(rs.next()){                
                    esc.setId(rs.getInt("id"));
                    esc.setLaudoEcoId(id);
                }
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEscoreRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String comandoSQL = "SELECT * FROM segmento WHERE laudoEscore_id = " + esc.getId();
        System.out.println(comandoSQL);
        
        try {
            stmt = Myconnection.getStatement();
            res = stmt.executeQuery(comandoSQL);
            escore.setId(esc.getId());
            escore.setLaudoEcoId(esc.getLaudoEcoId());
            Segmento[] segmento = new Segmento[17];
            int i = 0;
            while (res.next()) {
                segmento[i] = new Segmento(res.getInt("id"), res.getDouble("repouso"), res.getDouble("baixa_dose"), res.getDouble("pico"), res.getDouble("recuperacao"), escore.getId());
                i++;
            }
            //escore.setId(res.getInt("laudo_id"));
            escore.setSegmento(segmento);
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEscoreRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }

        return escore;
    }
}
