/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convenio;

/**
 *
 * @author Pereiras
 */
public class Convenio {
   
     private int id;
     private String nome;
     private String status;

    public Convenio(int id, String nome, String status) {
        this.id = id;
        this.nome = nome;
        this.status = status;
    }

          
    public Convenio(String nome, String status) {
        this.nome = nome;
        this.status = status;
    }
    
    public Convenio(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
     
    
    
}
