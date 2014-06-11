/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author Pereiras
 */ 
public class Myconnection{

    private static Connection connection = null;
    
    public static Statement getStatement() throws SQLException{
        
        if(connection == null){
            String url = "jdbc:mysql://localhost:3306/laudo_medico";
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection(url, "root","");
            } 
            catch(Exception e){}
        }
        return connection.createStatement();
    }
    
    public Connection getConnection(){  
       try{  
          Class.forName("com.mysql.jdbc.Driver").newInstance();  
          String driver = "jdbc:mysql://localhost:3306/laudo_medico";  
          Connection con = DriverManager.getConnection(driver,"root","");  
          return con;  
        }  
        catch(Exception e){  
            e.printStackTrace();  
        }  
        return null;  
    }  
    
}
