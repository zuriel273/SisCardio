/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convenio;

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
public class ConvenioRepositorio implements ConvenioInterface{

    @Override
    public void cadastrarConvenio(Convenio c) throws ConvenioErro {
        if(c!=null) {
            String comandoSQL = "insert into convenio(nome,status) values('"+c.getNome()+"','"+c.getStatus()+"')";
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar convenio.");
                e.getStackTrace();
            }
        } else {
                throw new ConvenioErro();
        }
    }

    @Override
    public List <Convenio> listarConvenio() throws ConvenioErro {
        ResultSet rs;
        List <Convenio> listar = new ArrayList();
        String comandoSQL;
        comandoSQL = "select * from convenio";
        try{
           Statement stmt =  Myconnection.getStatement();
           rs = stmt.executeQuery(comandoSQL);
           while(rs.next()) {
               Convenio c = new Convenio(rs.getString("nome"), rs.getString("status"));
               listar.add(c);
           }
           stmt.close();
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "Erro no listar!");
            e.printStackTrace();
        }
        return listar;
    }

    @Override
    public List <Convenio> pesquisarConvenioPorNomes(String Nome) throws ConvenioErro {
        ResultSet rs;
	List <Convenio> listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from convenio where nome like'%"+Nome+"%'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL); 
		while(rs.next()) {            
                    Convenio c = new Convenio(rs.getInt("id"),rs.getString("nome"), rs.getString("status"));
                    listar.add(c);
                }
                stmt.close();
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no listar!");
			e.printStackTrace();
    }
        return listar;
    }
    
    @Override
    public Convenio pesquisarConvenioPorNome(String Nome) throws ConvenioErro {
        ResultSet rs;
	
	String comandoSQL;
	comandoSQL = "select * from convenio where nome like'"+Nome+"'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL); 
		rs.next();        
                Convenio c = new Convenio(rs.getInt("id"),rs.getString("nome"), rs.getString("status"));
                               
                stmt.close();
                return c;
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no Convenio!");
			e.printStackTrace();
    }
        return null;
    }
    
    @Override
    public List <Convenio> pesquisarConvenioPorStatus() throws ConvenioErro {
        ResultSet rs;
	List <Convenio> listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "select * from convenio where status like'Ativo%'";
	System.out.println(comandoSQL);
        try {
		java.sql.Statement stmt = Myconnection.getStatement();
		rs = stmt.executeQuery(comandoSQL); 
		while(rs.next()) {            
                    Convenio c = new Convenio(rs.getInt("id"),rs.getString("nome"), rs.getString("status"));
                    listar.add(c);
                }
                stmt.close();
	} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"Erro no listar!");
			e.printStackTrace();
    }
        return listar;
    }
    
   
    
    @Override
    public Convenio pesquisarConvenioPorId(int id) throws ConvenioErro {
            ResultSet rs;
            String comandoSQL;
            comandoSQL ="select * from convenio where id = " + id;
            System.out.println(comandoSQL);
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
                Convenio c = new Convenio(rs.getString("nome"),rs.getString("status"));
                c.setId(id);
                               
                stmt.close();
                return c;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar por id!");
                e.printStackTrace();
            }
            
            return null;
    }

    @Override
    public void excluirConvenio(Convenio excluir) throws ConvenioErro {
        if(excluir!=null) {
            String comandoSQL;
            comandoSQL ="delete from convenio where nome = " + excluir.getNome();
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no excluir!");
                e.printStackTrace();
            }
            
        }else {
			throw new ConvenioErro();
         }
    }
    
    @Override
    public void editarConvenio(Convenio c) throws ConvenioErro{
        if(c!=null) {
            String comandoSQL = "UPDATE convenio SET nome='"+c.getNome()+"', status='"+c.getStatus()+"' WHERE id = "+c.getId();
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
                throw new ConvenioErro();
        }
    }
    
}
