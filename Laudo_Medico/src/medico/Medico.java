/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package medico;

/**
 *
 * @author Pereiras
 */
public class Medico {
    
    private int id;
    private int CRM;
    private String nome;
    private String status;
     
    public Medico(){}

    public Medico(int id, int CRM, String nome) {
        this.id = id;
        this.CRM = CRM;
        this.nome = nome;
    }
   
    
    public Medico(int CRM, String nome) {
        this.CRM = CRM;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

        
    public int getCRM() {
        return CRM;
    }

    public void setCRM(int CRM) {
        this.CRM = CRM;
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
