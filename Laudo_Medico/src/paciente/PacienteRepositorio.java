package paciente;

import conexao.Myconnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author arlindo
 */
public class PacienteRepositorio implements PacienteInterface{

    @Override
    public void cadastrarPaciente(Paciente p) throws PacienteErro {
        if(p!=null) {
            ResultSet rs_cpf;
            String comandoSQL_cpf;
            comandoSQL_cpf ="SELECT * FROM paciente WHERE cpf like  '"+p.getCpf()+"%'" ;
            String comandoSQL = "INSERT INTO paciente(nome,datanasc,cpf,sexo,tel) VALUES('"+p.getNome()+"','"+p.getDataNasc()+"','"+p.getCpf()+"','"+p.getSexo()+"','"+p.getTel()+"')";
            System.out.println(comandoSQL_cpf);
            
            try {
                    java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                    rs_cpf = stmt.executeQuery(comandoSQL_cpf);
                    System.out.println(rs_cpf.first());
                    //if(rs_cpf.first() == false){
                        stmt.executeUpdate(comandoSQL);
                        JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                   // }else{
                     //   JOptionPane.showMessageDialog(null, "Falha ao cadastrar. CPF já cadastrado no sistema!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    //}
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar paciente."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new PacienteErro();
        }
    }

    @Override
    public List listarPaciente(String nome) throws PacienteErro {
        ResultSet rs;
        List listar = new ArrayList();
        String comandoSQL;
        comandoSQL = "SELECT * FROM paciente WHERE nome LIKE '"+nome+"%'";
        try{
           Statement stmt =  Myconnection.getStatement();
           rs = stmt.executeQuery(comandoSQL);
           while(rs.next()) {
               Paciente p = new Paciente(rs.getInt("id"),rs.getString("nome"), rs.getString("datanasc"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("tel"));
               listar.add(p);
           }
           stmt.close();
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, "Erro no listar Paciente!");
            e.printStackTrace();
        }
        return listar;
    }

    @Override
    public Paciente pesquisarPacientePorCpf(int cpf) throws PacienteErro {
         ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM paciente WHERE cpf = " + cpf;
            
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
               Paciente p = new Paciente(rs.getString("nome"), rs.getString("datanasc"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("tel"));
                stmt.close();
                return p;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar por cpf!");
                e.printStackTrace();
            }
            
            return null;
    }
    
    @Override
    public Paciente pesquisarPacientePorId(int id) throws PacienteErro {
         ResultSet rs;
            String comandoSQL;
            comandoSQL ="SELECT * FROM paciente WHERE id = " + id;
            
            try{
                Statement stmt =  Myconnection.getStatement();
                rs = stmt.executeQuery(comandoSQL);
                rs.next();
                Paciente p = new Paciente(rs.getString("nome"), rs.getString("datanasc"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("tel"));
                p.setId(id);
                stmt.close();
                return p;
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no pesquisar por id!");
                e.printStackTrace();
            }
            
            return null;
    }

    @Override
    public void excluirPaciente(Paciente excluir) throws PacienteErro{
         if(excluir!=null) {
            String comandoSQL;
            comandoSQL ="DELETE FROM paciente WHERE cpf = " + excluir.getCpf();
            
            try{
                Statement stmt =  Myconnection.getStatement();
                stmt.executeUpdate(comandoSQL);
                stmt.close();
                
            } catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro no excluir Paciente!");
                e.printStackTrace();
            }
            
        }else {
			throw new PacienteErro();
         }
    }
    
    @Override
    public List pesquisarPacientePorNome(String nome) throws PacienteErro {
        ResultSet rs;
	List listar = new ArrayList();
	String comandoSQL;
	comandoSQL = "SELECT * FROM paciente WHERE nome LIKE'%"+nome+"%'";
	System.out.println(comandoSQL);
        try {
            java.sql.Statement stmt = Myconnection.getStatement();
            rs = stmt.executeQuery(comandoSQL);
            while(rs.next()) {            
                Paciente p = new Paciente(rs.getString("nome"), rs.getString("datanasc"), rs.getString("cpf"), rs.getString("sexo"), rs.getString("tel"));
                listar.add(p);
            }
            stmt.close();
	} catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro no listar!");
            e.printStackTrace();
    }
        return listar;
    }

    @Override
    public void editarPaciente(Paciente p) throws PacienteErro {
        if(p!=null) {
            String comandoSQL = "UPDATE paciente SET nome='"+p.getNome()+"',datanasc='"+p.getDataNasc()+"',cpf='"+p.getCpf()+"',sexo='"+p.getSexo()+"',tel='"+p.getTel()+"' WHERE id = "+p.getId();
            System.out.println(comandoSQL);
            try {
                    java.sql.Statement stmt = (Statement) Myconnection.getStatement();
                    stmt.executeUpdate(comandoSQL);
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso!", "Confirmação do Sistema", JOptionPane.INFORMATION_MESSAGE);
                    stmt.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null,"Erro ao cadastrar paciente."+e.getMessage());
                e.getStackTrace();
            }
        } else {
                throw new PacienteErro();
        }
    }
    
}
