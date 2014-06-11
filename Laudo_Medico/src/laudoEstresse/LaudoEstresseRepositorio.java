/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEstresse;

import conexao.Myconnection;
import esforco.Esforco;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author arlindo
 */
public class LaudoEstresseRepositorio implements LaudoEstresseInterface{

    @Override
    public String cadastrarLaudoEstresse(LaudoEstresse laudoEstresse) throws LaudoEstresseErro {
        String comandoSQL = "INSERT INTO `estresse`(laudo_id,esv,essv,tvns,tv,fa,bradicardia,outro_arritmia,dor_precordial,hipotensao,hipertensao,nauseas,outro_efeito_colateral,texto,isEco) VALUES(" + laudoEstresse.getLaudoEcoId()+","+laudoEstresse.isEsv()+","+laudoEstresse.isEssv()+","+laudoEstresse.isTvns()+","+laudoEstresse.isTv()+","+laudoEstresse.isFa()+","+laudoEstresse.isBradicardia()+",'"+laudoEstresse.getOutro_arritmia()+"',"+laudoEstresse.isDor_precordial()+","+laudoEstresse.isHipotensao()+","+laudoEstresse.isHipertensao()+","+laudoEstresse.isNausea()+",'"+laudoEstresse.getOutro_ef_colateral()+"','"+laudoEstresse.getTexto()+"',"+laudoEstresse.isEco()+")";
        System.out.println(comandoSQL);
        ResultSet rs;
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            stmt.executeUpdate(comandoSQL);
            comandoSQL = "SELECT MAX(id) AS id FROM estresse";
            rs = stmt.executeQuery(comandoSQL);
            int idLaudoEstresseInserido = 0;

            while (rs.next()) {
                idLaudoEstresseInserido = Integer.parseInt(rs.getString("id"));
            }
            System.out.print(idLaudoEstresseInserido);
            Esforco [] dezmcg = laudoEstresse.getDezmcg(), vintemcg = laudoEstresse.getVintemcg(), cincomcg = laudoEstresse.getCincomcg(), repouso = laudoEstresse.getRepouso();
            
            for (int i = 0; i < 2; i++) {
                comandoSQL = "INSERT INTO `esforco`(`pa`, `fc`, `atropina`, `eletrocardiograma`, `laudoEstresse_Id`,`tipo`) VALUES('" + dezmcg[i].getPa() + "','" + dezmcg[i].getFc() + "','" + dezmcg[i].getAtropina() + "','" + dezmcg[i].getEletrocardiograma() + "'," + idLaudoEstresseInserido + ",'dezmcg')";
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "INSERT INTO `esforco`(`pa`, `fc`, `atropina`, `eletrocardiograma`, `laudoEstresse_Id`,`tipo`) VALUES('" + vintemcg[i].getPa() + "','" + vintemcg[i].getFc() +"','" + vintemcg[i].getAtropina() + "','" + vintemcg[i].getEletrocardiograma() + "'," + idLaudoEstresseInserido + ",'vintemcg')";
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "INSERT INTO `esforco`(`pa`, `fc`, `atropina`, `eletrocardiograma`, `laudoEstresse_Id`,`tipo`) VALUES('" + cincomcg[i].getPa() + "','" + cincomcg[i].getFc() + "','" + cincomcg[i].getAtropina() + "','" + cincomcg[i].getEletrocardiograma() + "'," + idLaudoEstresseInserido + ",'cincomcg')";
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "INSERT INTO `esforco`(`pa`, `fc`, `atropina`, `eletrocardiograma`, `laudoEstresse_Id`,`tipo`) VALUES('" + repouso[i].getPa() + "','" + repouso[i].getFc() + "','" + repouso[i].getAtropina() + "','" + repouso[i].getEletrocardiograma() + "',"+ idLaudoEstresseInserido + ",'repouso')";
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
            }

            stmt.close();
            return "true";
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            ex.getStackTrace();
            return ex.getMessage();
        }
    }

    @Override
    public String atualizarLaudoEstresse(LaudoEstresse estresse) throws LaudoEstresseErro {
        try {
            java.sql.Statement stmt;
            String comandoSQL = "UPDATE `estresse` SET laudo_id = " + estresse.getLaudoEcoId()+",esv = "+estresse.isEsv()+", essv = "+estresse.isEssv()+", tvns = "+estresse.isTvns()+", tv = "+estresse.isTv()+", fa = "+estresse.isFa()+", bradicardia = "+estresse.isBradicardia()+", outro_arritmia = '"+estresse.getOutro_arritmia()+"', dor_precordial = "+estresse.isDor_precordial()+", hipotensao = "+estresse.isHipotensao()+", hipertensao = "+estresse.isHipertensao()+", nauseas = "+estresse.isNausea()+", outro_efeito_colateral = '"+estresse.getOutro_ef_colateral()+"', texto = '"+estresse.getTexto()+"' WHERE id = "+estresse.getId();
            System.out.println(comandoSQL);
            stmt = Myconnection.getStatement();
            stmt.executeUpdate(comandoSQL);
            
            Esforco [] dezmcg = estresse.getDezmcg(), vintemcg = estresse.getVintemcg(), cincomcg = estresse.getCincomcg(), repouso = estresse.getRepouso();
            for (int i = 0; i < 2; i++) {
                comandoSQL = "UPDATE `esforco` SET `pa` = '"+dezmcg[i].getPa()+ "', `fc` = '" + dezmcg[i].getFc() + "', `atropina` = '" + dezmcg[i].getAtropina() + "', `eletrocardiograma` = '" + dezmcg[i].getEletrocardiograma() + "' WHERE `laudoEstresse_Id` = " + estresse.getId()+" AND id = "+dezmcg[i].getId();
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "UPDATE `esforco` SET `pa` = '"+vintemcg[i].getPa()+ "', `fc` = '" + vintemcg[i].getFc() + "', `atropina` = '" + vintemcg[i].getAtropina() + "', `eletrocardiograma` = '" + vintemcg[i].getEletrocardiograma() + "' WHERE `laudoEstresse_Id` = " + estresse.getId()+" AND id = "+vintemcg[i].getId();
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "UPDATE `esforco` SET `pa` = '"+cincomcg[i].getPa()+ "', `fc` = '" + cincomcg[i].getFc() + "', `atropina` = '" + cincomcg[i].getAtropina() + "', `eletrocardiograma` = '" + cincomcg[i].getEletrocardiograma() + "' WHERE `laudoEstresse_Id` = " + estresse.getId()+" AND id = "+cincomcg[i].getId();
                System.out.println(comandoSQL);
                stmt = Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                comandoSQL = "UPDATE `esforco` SET `pa` = '"+repouso[i].getPa()+ "', `fc` = '" + repouso[i].getFc() + "', `atropina` = '" + repouso[i].getAtropina() + "', `eletrocardiograma` = '" + repouso[i].getEletrocardiograma() + "' WHERE `laudoEstresse_Id` = " + estresse.getId()+" AND id = "+repouso[i].getId();
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
    public List listarLaudoEstresseByPacienteID(int id_paciente) throws LaudoEstresseErro {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List listarLaudoEstresseByLaudoEcoID(int id_laudo_eco,boolean isEco) throws LaudoEstresseErro {
        List lista = new ArrayList();
        try {
            ResultSet rs;

            String query = "SELECT * from estresse WHERE laudo_id = " + id_laudo_eco +" AND isEco = "+isEco;
            System.out.println(query);
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                LaudoEstresse estresse = new LaudoEstresse();
                estresse.setId(rs.getInt("id"));
                estresse.setLaudoEcoId(id_laudo_eco);
                estresse.setEsv(rs.getBoolean("esv"));
                estresse.setEssv(rs.getBoolean("essv"));
                estresse.setTvns(rs.getBoolean("tvns"));
                estresse.setTv(rs.getBoolean("tv"));
                estresse.setFa(rs.getBoolean("fa"));
                estresse.setBradicardia(rs.getBoolean("bradicardia"));
                estresse.setOutro_arritmia(rs.getString("outro_arritmia"));
                estresse.setDor_precordial(rs.getBoolean("dor_precordial"));
                estresse.setHipotensao(rs.getBoolean("hipotensao"));
                estresse.setHipertensao(rs.getBoolean("hipertensao"));
                estresse.setNausea(rs.getBoolean("nauseas"));
                estresse.setOutro_ef_colateral(rs.getString("outro_efeito_colateral"));
                estresse.setTexto(rs.getString("texto"));
                lista.add(estresse);
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro: " + this.getClass() + " - " + ex.getMessage());
        }

        return lista;
    }

    @Override
    public LaudoEstresse getLaudoEstresseById(int id) {
        ResultSet res,rs;
        LaudoEstresse estresse = new LaudoEstresse();
        java.sql.Statement stmt;
        String query = "SELECT * FROM estresse WHERE laudo_id = "+id;
        System.out.println(query);
        try {
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                estresse.setId(rs.getInt("id"));
                estresse.setLaudoEcoId(rs.getInt("laudo_id"));
                estresse.setEsv(rs.getBoolean("esv"));
                estresse.setEssv(rs.getBoolean("essv"));
                estresse.setTvns(rs.getBoolean("tvns"));
                estresse.setTv(rs.getBoolean("tv"));
                estresse.setFa(rs.getBoolean("fa"));
                estresse.setBradicardia(rs.getBoolean("bradicardia"));
                estresse.setOutro_arritmia(rs.getString("outro_arritmia"));
                estresse.setDor_precordial(rs.getBoolean("dor_precordial"));
                estresse.setHipotensao(rs.getBoolean("hipotensao"));
                estresse.setHipertensao(rs.getBoolean("hipertensao"));
                estresse.setNausea(rs.getBoolean("nauseas"));
                estresse.setOutro_ef_colateral(rs.getString("outro_efeito_colateral"));
                estresse.setTexto(rs.getString("texto"));
                estresse.setEco(rs.getBoolean("isEco"));
            }

            String comandoSQL = "SELECT * FROM esforco WHERE laudoEstresse_id = " + estresse.getId();
            System.out.println(comandoSQL);
            
            try {
                stmt = Myconnection.getStatement();
                res = stmt.executeQuery(comandoSQL);
                //estresse.setId(id);
                Esforco[] repouso = new Esforco[2], cincomcg = new Esforco[2], dezmcg = new Esforco[2], vintemcg = new Esforco[2];
                int a = 0,b = 0,c = 0,i = 0; //indices cincomcg, dezmcg, vintemcg e repouso respectivamente.
                while (res.next()) {
                    int id_esforco = res.getInt("id");
                    String pa = res.getString("pa");
                    String fc = res.getString("fc");
                    String eletrocardiograma = res.getString("eletrocardiograma");
                    String atropina = res.getString("atropina");
                    String tipo = res.getString("tipo");

                    if(tipo.equals("cincomcg")){
                        cincomcg[a] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                        a++;
                    }
                    else if(tipo.equals("dezmcg")){
                        dezmcg[b] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                        b++;
                    }else if(tipo.equals("vintemcg")){
                        vintemcg[c] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                        c++;
                    }else if(tipo.equals("repouso")){
                        repouso[i] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                        i++;
                    }                
                }
                estresse.setCincomcg(cincomcg);
                estresse.setDezmcg(dezmcg);
                estresse.setVintemcg(vintemcg);
                estresse.setRepouso(repouso);

            } catch (SQLException ex) {
                Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        return estresse;
    }
    
    @Override
    public List getLaudoEstresseByLaudoEcoId(int id) {
        ResultSet res,rs;
        List lista = new <LaudoEstresse>ArrayList();
        LaudoEstresse estresse = new LaudoEstresse();
        java.sql.Statement stmt;
        String query = "SELECT * FROM estresse WHERE laudo_id = "+id+" AND isEco = 1";
        System.out.println(query);
        try {
            stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                estresse.setId(rs.getInt("id"));
                estresse.setLaudoEcoId(rs.getInt("laudo_id"));
                estresse.setEsv(rs.getBoolean("esv"));
                estresse.setEssv(rs.getBoolean("essv"));
                estresse.setTvns(rs.getBoolean("tvns"));
                estresse.setTv(rs.getBoolean("tv"));
                estresse.setFa(rs.getBoolean("fa"));
                estresse.setBradicardia(rs.getBoolean("bradicardia"));
                estresse.setOutro_arritmia(rs.getString("outro_arritmia"));
                estresse.setDor_precordial(rs.getBoolean("dor_precordial"));
                estresse.setHipotensao(rs.getBoolean("hipotensao"));
                estresse.setHipertensao(rs.getBoolean("hipertensao"));
                estresse.setNausea(rs.getBoolean("nauseas"));
                estresse.setOutro_ef_colateral(rs.getString("outro_efeito_colateral"));
                estresse.setTexto(rs.getString("texto"));
                estresse.setEco(rs.getBoolean("isEco"));
            
                String comandoSQL = "SELECT * FROM esforco WHERE laudoEstresse_id = " + rs.getInt("id");
                System.out.println(comandoSQL);

                try {
                    stmt = Myconnection.getStatement();
                    res = stmt.executeQuery(comandoSQL);
                    estresse.setId(rs.getInt("id"));
                    Esforco[] repouso = new Esforco[2], cincomcg = new Esforco[2], dezmcg = new Esforco[2], vintemcg = new Esforco[2];
                    int a = 0,b = 0,c = 0,i = 0; //indices cincomcg, dezmcg, vintemcg e repouso respectivamente.
                    while (res.next()) {
                        int id_esforco = res.getInt("id");
                        String pa = res.getString("pa");
                        String fc = res.getString("fc");
                        String eletrocardiograma = res.getString("eletrocardiograma");
                        String atropina = res.getString("atropina");
                        String tipo = res.getString("tipo");

                        if(tipo.equals("cincomcg")){
                            cincomcg[a] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                            a++;
                        }
                        else if(tipo.equals("dezmcg")){
                            dezmcg[b] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                            b++;
                        }else if(tipo.equals("vintemcg")){
                            vintemcg[c] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                            c++;
                        }else if(tipo.equals("repouso")){
                            repouso[i] = new Esforco(id_esforco,id, pa, fc, atropina, eletrocardiograma,tipo);
                            i++;
                        }                
                    }
                    estresse.setCincomcg(cincomcg);
                    estresse.setDezmcg(dezmcg);
                    estresse.setVintemcg(vintemcg);
                    estresse.setRepouso(repouso);

                } catch (SQLException ex) {
                    Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
                }
                lista.add(estresse);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LaudoEstresseRepositorio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
    }
    
}
