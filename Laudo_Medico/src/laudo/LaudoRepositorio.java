/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudo;

import conexao.Myconnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import javax.swing.JOptionPane;

/**
 *
 * @author arlindojr
 */
public class LaudoRepositorio implements LaudoInterface{

    @Override
    public boolean cadastrarLaudo(Eco l) throws LaudoErro { //Vou usar assinatura os outros tipos terão o mesmo nome de metodo só que mudo o tipo
        Eco tt = (Eco)l;
        if(tt!=null) {
            
            Date d = new Date();
            System.out.println( d );
            
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");  

            d = Calendar.getInstance( TimeZone.getTimeZone("GMT-03:00") ).getTime();
            System.out.println( d );

            TimeZone tz = new SimpleTimeZone(Calendar.ZONE_OFFSET, "GMT-03:00");
            
            GregorianCalendar data= new GregorianCalendar();
            
            
            
            Calendar ca = GregorianCalendar.getInstance(tz);
            
            
            
            d = ca.getTime();
            
            
            
            System.out.println( d );
            
            
            String comandoSQL = "INSERT INTO `laudo`(`data`, `tipocalc`, `tipo`, `peso`, `siv`, `ae`, `ddve`, `ddvd`, `altura`, `aorta`, `dsve`, `pp`, `vsf`, `vdf`, `enccav`, `indespessurarel`, `superficiecorporea`, `massa`, `indmassave`, `relae_ao`, `fe`, `texto`, `paciente_id`, `medico_id`, `medico_nome`, `medico_crm`, `convenio_id`, `convenio_nome`) values('"+sd.format(d) +"','"+tt.getTipoCalc()+"','"+tt.getTipo()+"','"+tt.getPeso()+"','"+tt.getSIV()+"','"+tt.getAE()+"','"+tt.getDDVE()+"','"+tt.getDDVD()+"','"+tt.getAltura()+"','"+tt.getAorta()+"','"+tt.getDSVE()+"','"+tt.getPP()+"','"+tt.getVSF()+"','"+tt.getVDF()+"','"+tt.getENCCAV()+"','"+tt.getIndEspessuraRel()+"','"+tt.getSuperficieCorporea()+"','"+tt.getMassa()+"','"+tt.getIndMassaVE()+"','"+tt.getRelAEAO()+"','"+tt.getFE()+"','"+tt.getTexto()+"','"+tt.getPaciente().getId()+"','"+tt.getMedico().getId()+"','"+tt.getMedico().getNome()+"','"+tt.getMedico().getCRM()+"','"+tt.getConvenio().getId()+"','"+tt.getConvenio().getNome()+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    stmt.close();
                    return true;
                    
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar Laudo."+e.getMessage());
                e.getStackTrace();
                return false;
            }
        } else {
                return false;
        }
       
    }
    @Override
    public boolean cadastrarLaudoSub(Eco l) throws LaudoErro { //Vou usar assinatura os outros tipos terão o mesmo nome de metodo só que mudo o tipo
        Eco tt = (Eco)l;
        if(tt!=null) {
            Date d = new Date();
            System.out.println( d );

            d = Calendar.getInstance( TimeZone.getTimeZone("GMT-03:00") ).getTime();
            System.out.println( d );
            
            SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

            TimeZone tz = new SimpleTimeZone(Calendar.ZONE_OFFSET, "GMT-03:00");
            
            GregorianCalendar data= new GregorianCalendar();
            
            Calendar ca = GregorianCalendar.getInstance(tz);
            d = ca.getTime();
            System.out.println( d );
            
            String comandoSQL = "INSERT INTO `laudo`(`data`, `tipo`, `texto`, `paciente_id`, `medico_id`, `medico_nome`, `medico_crm`, `convenio_id`, `convenio_nome`) values('"+sd.format(d)+"','"+tt.getTipo()+"','"+tt.getTexto()+"','"+tt.getPaciente().getId()+"','"+tt.getMedico().getId()+"','"+tt.getMedico().getNome()+"','"+tt.getMedico().getCRM()+"','"+tt.getConvenio().getId()+"','"+tt.getConvenio().getNome()+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    stmt.close();
                    if(l.getTipo().equals("sub")){
                        return true;
                        //JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
            } catch (SQLException e) {
                
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar Laudo."+e.getMessage());
                e.getStackTrace();
                 return false;
            }
        } else {
                return false;
        }
        return false;
    }

    @Override
    public void cadastrarLaudoIreport(int id, String tipo) throws LaudoErro { //Vou usar assinatura os outros tipos terão o mesmo nome de metodo só que mudo o tipo
        
                       
            String comandoSQL = "INSERT INTO `ireport`(`laudo_id`, `laudo_tipo`) values('"+id+"','"+tipo+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    stmt.close();
                    
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar Laudo."+e.getMessage());
                e.getStackTrace();
            }
        
       
    }
    
    @Override
    public void excluirLaudoIreport() throws LaudoErro{
         
            String comandoSQL;
            comandoSQL ="DELETE  FROM `ireport` WHERE 1";
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                System.out.println("Erro no excluir laudoEco!");
                e.printStackTrace();
            }
            
      
			
         
    }
    
    @Override
    public List listarLaudo(int id_paciente) throws LaudoErro {
        ResultSet rs;
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "SELECT * FROM laudo WHERE paciente_id = "+id_paciente;
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL);
		while(rs.next()){     
                    Eco tt = new Eco(rs.getFloat("peso"), rs.getFloat("siv"), rs.getFloat("ae"), rs.getFloat("ddve"), rs.getFloat("ddvd"), rs.getFloat("dsve"), rs.getFloat("pp"), rs.getFloat("altura"), rs.getFloat("aorta"), rs.getFloat("vsf"), rs.getFloat("vdf"), rs.getFloat("enccav"), rs.getFloat("indespessurarel"), rs.getFloat("superficiecorporea"), rs.getFloat("massa"), rs.getFloat("indmassave"), rs.getFloat("relae_ao"), rs.getFloat("fe"),rs.getString("tipocalc"),rs.getString("tipo"),rs.getString("data"),rs.getInt("medico_id"),rs.getInt("convenio_id"),id_paciente);
                    tt.setId(rs.getInt("id"));
                    listar.add(tt);
                }
                stmt.close();
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"Erro no listar!");
		e.printStackTrace();
        }
        return listar;
    }
    
    @Override
     public Eco pesquisarLaudoEcoPorId(int id) throws LaudoErro {
        ResultSet rs;
        String comandoSQL;
        comandoSQL ="select * from laudo where id = " + id;
        System.out.println(comandoSQL); 
        try{
            Statement stmt =  Myconnection.getStatement();
            rs = stmt.executeQuery(comandoSQL);
            rs.next();
            Eco s = new Eco(rs.getFloat("peso"), rs.getFloat("siv"), rs.getFloat("ae"), rs.getFloat("ddve"), rs.getFloat("ddvd"), rs.getFloat("dsve"), rs.getFloat("pp"), rs.getFloat("altura"), rs.getFloat("aorta"), rs.getFloat("vsf"), rs.getFloat("vdf"), rs.getFloat("enccav"), rs.getFloat("indespessurarel"), rs.getFloat("superficiecorporea"), rs.getFloat("massa"), rs.getFloat("indmassave"), rs.getFloat("relae_ao"), rs.getFloat("fe"),rs.getString("tipocalc"),rs.getString("tipo"),rs.getString("data"),rs.getInt("paciente_id"),rs.getInt("medico_id"),rs.getInt("convenio_id"));
            s.setId(id);
            s.setTexto(rs.getString("texto")); 
            stmt.close(); 
            return s;

        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro no pesquisar por id!");
            e.printStackTrace();

        }

        return null;
    }
    
    @Override
     public Eco pesquisarLaudoEcoEstressePorId(int id) throws LaudoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM laudo WHERE id ="+id;
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                if(!rs.next()){
                    Eco a = new Eco(null,null,null);
                    return a;
                }
                Eco s = new Eco(rs.getString("tipo"),rs.getString("texto"),rs.getString("data"),rs.getInt("paciente_id"),rs.getInt("medico_id"),rs.getInt("convenio_id"));
                s.setId(rs.getInt("id"));
                stmt.close(); 
                return s;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar LaudoSub por id!");
                e.printStackTrace();
                
            }
            return null;
    }
    /*
     public Eco pesquisarLaudoEcoEstressePorId(String tipo) throws LaudoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM laudo WHERE id = LAST_INSERT_ID() AND tipo = '"+tipo+"'";
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                if(!rs.next()){
                    Eco a = new Eco(null,null,null);
                    return a;
                }
                Eco s = new Eco(rs.getString("tipo"),rs.getString("texto"),rs.getString("data"),rs.getInt("paciente_id"),rs.getInt("medico_id"),rs.getInt("convenio_id"));
                s.setId(rs.getInt("id"));
                stmt.close(); 
                return s;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar LaudoSub por id!");
                e.printStackTrace();
                
            }
            return null;
    }
     
     */
    
    @Override
    public void excluirLaudoUltimoId() throws LaudoErro{
         
            String comandoSQL;
            comandoSQL ="DELETE  FROM laudo WHERE id = LAST_INSERT_ID()";
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                System.out.println("Erro no excluir laudoEco!");
                e.printStackTrace();
            }
            
      
			
         
    }
    
     public int LaudoUltimoId() throws LaudoErro{
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM laudo WHERE id = LAST_INSERT_ID()";
            int id =0;
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();                
                id = rs.getInt("id");
                stmt.close(); 
                return id;
                
            } catch(SQLException e){                
                
                e.printStackTrace();                
                return 0;
                
            }
            
    }
    
    @Override
     public Eco pesquisarLaudoSubPorId(int id) throws LaudoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM laudo WHERE id = " + id+" AND tipo = 'sub'";
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                if(!rs.next()){
                    Eco a = new Eco(null,null,null);
                    return a;
                }
                Eco s = new Eco(rs.getString("tipo"),rs.getString("texto"),rs.getString("data"),rs.getInt("paciente_id"),rs.getInt("medico_id"),rs.getInt("convenio_id"));
                s.setId(id);
                stmt.close(); 
                return s;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar LaudoSub por id!");
                e.printStackTrace();
                
            }
            return null;
    }
    
    @Override
    public Eco pesquisarLaudoPorId(int id,String tipo) throws LaudoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM laudo WHERE id = " + id+" AND tipo = '"+tipo+"'";
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                if(!rs.next()){
                    Eco a = new Eco(null,null,null);
                    return a;
                }
                
                Eco s = new Eco(rs.getFloat("peso"), rs.getFloat("siv"), rs.getFloat("ae"), rs.getFloat("ddve"), rs.getFloat("ddvd"), rs.getFloat("dsve"), rs.getFloat("pp"), rs.getFloat("altura"), rs.getFloat("aorta"), rs.getFloat("vsf"), rs.getFloat("vdf"), rs.getFloat("enccav"), rs.getFloat("indespessurarel"), rs.getFloat("superficiecorporea"), rs.getFloat("massa"), rs.getFloat("indmassave"), rs.getFloat("relae_ao"), rs.getFloat("fe"),rs.getString("tipocalc"),rs.getString("tipo"),rs.getString("data"),rs.getInt("paciente_id"),rs.getInt("medico_id"),rs.getInt("convenio_id"));
                s.setId(id);
                s.setTexto(rs.getString("texto"));
                stmt.close(); 
                return s;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar Laudo por id!");
                e.printStackTrace();
                
            }
            return null;
    }
    
    @Override
    public void cadastrarModelo(String nome, String texto) throws LaudoErro {
        if((nome!=null)&&(texto!=null)) {
            ResultSet rs_nome;
            String comandoSQL_nome ="SELECT * FROM combo WHERE sigla like '"+nome+"%'" ;
            String comandoSQL = "insert into combo(sigla,texto,tipo) values('"+nome+"','"+texto+"','modelo')";
            try {
                java.sql.Statement stmt = Myconnection.getStatement();
                rs_nome = stmt.executeQuery(comandoSQL_nome); 
                if(rs_nome.first() == false){
                    stmt.executeUpdate(comandoSQL);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar modelo. Nome já existe!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                }
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar Modelo.");
                e.getStackTrace();
            }
        } else {
                throw new LaudoErro();
        }
    }
    
    @Override
    public String pesquisarModeloPorNome(String Nome) throws LaudoErro {
        ResultSet rs;
	
	String comandoSQL;
	comandoSQL = "select * from combo where sigla like'"+Nome+"'";
	System.out.println(comandoSQL);
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(comandoSQL); 
            rs.next();        
            String sigla = rs.getString("sigla");
            stmt.close();
            return sigla;
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro no Modelo!");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public String escreveTextoPorNome(String Nome) throws LaudoErro {
        ResultSet rs;
	String comandoSQL;
	comandoSQL = "select * from combo where sigla like'"+Nome+"'";
	System.out.println(comandoSQL);
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(comandoSQL); 
            rs.next();        
            String sigla = rs.getString("texto");
            stmt.close();
            return sigla;
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro no Modelo!");
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List pesquisarComboPorTipo(String tipo) throws LaudoErro {
        ResultSet rs;   
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from combo where tipo like'"+tipo+"%'";
	System.out.println(comandoSQL);
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(comandoSQL); 
            while(rs.next()) {            
                String sigla = rs.getString("sigla");
                listar.add(sigla);
            }
            stmt.close();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro no listar Combo por tipo!");
            e.printStackTrace();
        }
        return listar;
    }
    
    @Override
 public void editarEcoSub(Eco s) throws LaudoErro{
        if(s!=null) {
            String comandoSQL = "UPDATE laudo SET texto='"+s.getTexto()+"' WHERE id = "+s.getId();
            System.out.println(comandoSQL);
            try {
                java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                JOptionPane.showMessageDialog(null, "Alteraçao de cadastro efetuada com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new LaudoErro();
        }
    } 
    
    @Override
    public void editarEcoTT(Eco s) throws LaudoErro{
        if(s!=null) {
            String comandoSQL = "UPDATE laudo SET tipocalc='"+s.getTipoCalc()+"',tipo='"+s.getTipo()+"',peso='"+s.getPeso()+"',siv='"+s.getSIV()+"',ae='"+s.getAE()+"',ddve='"+s.getDDVE()+"',ddvd='"+s.getDDVD()+"',altura='"+s.getAltura()+"',aorta='"+s.getAorta()+"',dsve='"+s.getDSVE()+"',pp='"+s.getPP()+"',vsf='"+s.getVSF()+"',vdf='"+s.getVDF()+"',enccav='"+s.getENCCAV()+"',indespessurarel='"+s.getIndEspessuraRel()+"',superficiecorporea='"+s.getSuperficieCorporea()+"',massa='"+s.getMassa()+"',indmassave='"+s.getIndMassaVE()+"',relae_ao='"+s.getRelAEAO()+"',fe='"+s.getFE()+"',texto='"+s.getTexto()+"',paciente_id='"+s.getId_paciente()+"',`medico_id`='"+s.getId_medico()+"',convenio_id='"+s.getId_convenio()+"' WHERE id = "+s.getId();
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    JOptionPane.showMessageDialog(null, "Alteraçao de cadastro efetuada com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new LaudoErro();
        }
    }

    @Override
    public List pesquisarComboPorSigla(String sigla) throws LaudoErro {
        ResultSet rs;   
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from combo where sigla like'"+sigla+"'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL); 
		while(rs.next()) {            
                    int id = rs.getInt("id");
                    listar.add(id);
                }
                stmt.close();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro no listar Combo por Sigla!");
            e.printStackTrace();
        }
        return listar;
    }

}
