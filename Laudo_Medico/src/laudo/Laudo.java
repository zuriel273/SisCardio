/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudo;

import convenio.Convenio;
import java.util.GregorianCalendar;
import medico.Medico;
import paciente.Paciente;


/**
 *
 * @author Pereiras
 */
public class Laudo {
    private Paciente paciente;
    private Convenio convenio;
    private Medico medico;
    private String data_criacao;
    private int id;
    private int id_paciente;
    private int id_medico;
    private int id_convenio;
    
    GregorianCalendar data= new GregorianCalendar();

    public Laudo(Paciente paciente, Convenio convenio, Medico medico) {
        this.paciente = paciente;
        this.convenio = convenio;
        this.medico = medico;
        data_criacao = data.getTime().toGMTString();    
        
    }
    
    public Laudo(Paciente paciente, Convenio convenio, Medico medico, String data_criacao) {
        this.paciente = paciente;
        this.convenio = convenio;
        this.medico = medico;
        this.data_criacao = data_criacao;    
        
    }

    public Laudo(String data_criacao, int id_paciente, int id_medico, int id_convenio) {
        this.data_criacao = data_criacao;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        this.id_convenio = id_convenio;
    }

    
    
    

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Medico getMedico() {
        return medico;
    }
    
    

   /* public void setMedico(Medico medico) {
        this.medico = medico;
    }
    */ // Por solicitação

    public String getData_criacao() {
        return data_criacao;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public int getId_convenio() {
        return id_convenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public void setId_convenio(int id_convenio) {
        this.id_convenio = id_convenio;
    }
    
    
}
