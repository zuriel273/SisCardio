/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

import conexao.Myconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Pereiras
 */
public class MedicoRepositorio implements MedicoInterface{
    
    
    @Override
    public void cadastrarMedico(Medico m) throws MedicoErro {
        if(m!=null) { 
            ResultSet rs_crm;
            String comandoSQL_crm ="SELECT * FROM medico WHERE crm =" +m.getCRM() ;
            String comandoSQL = "insert into medico(nome,crm,status) values('"+m.getNome()+"','"+m.getCRM()+"','"+m.getStatus()+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    rs_crm = stmt.executeQuery(comandoSQL_crm); 
                    
                    if(rs_crm.first() == false){
                        stmt.executeUpdate(comandoSQL);
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                         JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR MEDICO!!! CRM JÁ EXISTE NO SISTEMA.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar medico."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new MedicoErro();
        }
    }
    
    @Override
     public void cadastrarMedicoAux(Medico m) throws MedicoErro {
        if(m!=null) {
            ResultSet rs_crm;
            String comandoSQL_crm ="SELECT * FROM medicoAux WHERE crm =" +m.getCRM() ;
            String comandoSQL = "insert into medicoAux(medico_id,nome,crm,status) values('"+m.getId()+"','"+m.getNome()+"','"+m.getCRM()+"','"+m.getStatus()+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    rs_crm = stmt.executeQuery(comandoSQL_crm);
                    
                    if(rs_crm.first() == false){
                        stmt.executeUpdate(comandoSQL);
                       // JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        // JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR MEDICO!!! CRM JÁ EXISTE NO SISTEMA.", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    }
                    stmt.close();
            } catch (SQLException e) {
               //JOptionPane.showMessageDialog(null,"Erro ao cadastrar medico."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new MedicoErro();
        }
    }

    @Override
    public List listarMedico() throws MedicoErro {
        ResultSet rs;
        List listar = new ArrayList();
        String comandoSQL;
        comandoSQL = "select * from medico";
        try{
           Statement stmt =  Myconnection.getStatement();
           rs = stmt.executeQuery(comandoSQL);
           while(rs.next()) {
               Medico m = new Medico(rs.getInt("crm"),rs.getString("nome"));
               m.setStatus(rs.getString("status"));
               listar.add(m);
           }
           stmt.close();
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "Erro no listar!");
            e.printStackTrace();
        }
        return listar;
    }

    @Override
    public Medico pesquisarMedicoPorCrm(int crm) throws MedicoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="select * from medico where crm = " + crm;
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
                Medico m = new Medico();
                if(rs.getRow()!=0){
                    m = new Medico(rs.getInt("crm"),rs.getString("nome"));
                    m.setId(rs.getInt("id"));
                    m.setStatus(rs.getString("status"));
                    stmt.close();
                }
                return m;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Medico não encontrado.");
                e.printStackTrace();
                
            }
            
            return null;
    }
    
    @Override
    public Medico pesquisarMedicoAux() throws MedicoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="select * from medicoAux where 1"; 
            System.out.println(comandoSQL); 
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
                Medico m = new Medico(rs.getInt("crm"),rs.getString("nome"));
                m.setStatus(rs.getString("status"));
                m.setId(rs.getInt("medico_id")); //''''''''9:17
                stmt.close();
                return m;
                
            } catch(SQLException e){
                //JOptionPane.showMessageDialog(null, "Erro no pesquisar por crm!");
                e.printStackTrace();
                
            }
            
            return null;
    }
    
    @Override
    public Medico pesquisarMedicoPorId(int id) throws MedicoErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="select * from medico where id = " +id;
            System.out.println(comandoSQL);
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
                Medico m = new Medico(rs.getInt("crm"),rs.getString("nome"));
                m.setId(id);
                m.setStatus(rs.getString("status"));
                stmt.close();
                return m;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar por id!");
                e.printStackTrace();
            }
            
            return null;
    }

    @Override
    public void excluirMedico(Medico excluir) throws MedicoErro {
        if(excluir!=null) {
            String comandoSQL;
            String comandoSQL2;
            comandoSQL ="delete from medico where crm = " + excluir.getCRM();
            comandoSQL2 = "select from laudo where medico_id = " + excluir.getId(); // se existir laudo com o medico ele não pode ser excluido isso se segue para convenio e paciente
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no excluir!");
                e.printStackTrace();
            }
            
        }else {
			throw new MedicoErro();
         }
    }
    
    @Override
     public void excluirMedicoAux(Medico excluir) throws MedicoErro {
        if(excluir!=null) {
            String comandoSQL;
            String comandoSQL2;
            comandoSQL ="DELETE FROM `medicoAux` WHERE 1";
            //comandoSQL2 = "select from laudo where medico_id = " + excluir.getId(); // se existir laudo com o medico ele não pode ser excluido isso se segue para convenio e paciente
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no excluir!");
                e.printStackTrace();
            }
            
        }else {
			throw new MedicoErro();
         }
    }

    @Override
    public List pesquisarMedicoPorNome(String nome) throws MedicoErro {
        ResultSet rs;
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from medico where nome like'%"+nome+"%'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL);
		while(rs.next()) {            
                    Medico m = new Medico(rs.getInt("id"),rs.getInt("crm"),rs.getString("nome"));
                    m.setStatus(rs.getString("status"));
                    listar.add(m);
                }
                stmt.close();
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no listar!");
			e.printStackTrace();
    }
        return listar;
    }
    
    @Override
     public List pesquisarMedicoPorNome(String nome,String status) throws MedicoErro {
        ResultSet rs;
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from medico where nome like'%"+nome+"%' AND status = '"+status+"'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL);
		while(rs.next()) {            
                    Medico m = new Medico(rs.getInt("id"),rs.getInt("crm"),rs.getString("nome"));
                    m.setStatus(rs.getString("status"));
                    listar.add(m);
                }
                stmt.close();
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no listar!");
			e.printStackTrace();
    }
        return listar;
    }
    
    @Override
    public void editarMedico(Medico m) throws MedicoErro {
        if(m!=null) {
            String comandoSQL = "UPDATE medico SET nome='"+m.getNome()+"', crm='"+m.getCRM()+"',status='"+m.getStatus()+"' WHERE id = "+m.getId();
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    JOptionPane.showMessageDialog(null, "Alteração de cadastro efetuada com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao alterar cadastro."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new MedicoErro();
        }
    }
     
    
}
