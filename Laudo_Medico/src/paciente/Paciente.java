/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package paciente;

import java.util.ArrayList;
import java.util.List;
import laudo.Laudo;

/**
 *
 * @author Pereiras
 */
public class Paciente {
    
    private int id;
    private String nome;
    private String dataNasc;
    private String cpf;
    private String sexo;
    private String tel;
    private List<Laudo> laudos = new ArrayList<Laudo>(); 

    public Paciente() {
    }

    public Paciente(int id, String nome, String dataNasc, String cpf, String sexo, String tel) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.sexo = sexo;
        this.tel = tel;
    }
    
    //public Laudo laudos; Ativar depois
    public Paciente(String nome, String dataNasc, String cpf, String sexo, String tel) {
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.cpf = cpf;
        this.sexo = sexo;
        this.tel = tel;
    }

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

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    




}
