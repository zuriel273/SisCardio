/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachada;

import convenio.*;
import java.util.List;
import medico.*;
import paciente.*;
import laudo.*;
import laudoEscore.*;
import laudoEstresse.*;

/**
 *
 * @author arlindo
 */
public class Fachada {

    private PacienteInterface pi;
    private ConvenioInterface ci;
    private MedicoInterface mi;
    private LaudoInterface li;
    private LaudoEscoreInterface le;
    private LaudoEstresseInterface lt;

    public Fachada() {
        pi = new PacienteRepositorio();
        ci = new ConvenioRepositorio();
        mi = new MedicoRepositorio();
        li = new LaudoRepositorio();
        le = new LaudoEscoreRepositorio();
        lt = new LaudoEstresseRepositorio();
    }
    
    /**
     * 
     * Laudo Estresse
     *
     */
    public String cadastrarLaudoEstresse(LaudoEstresse estresse) throws LaudoEstresseErro{
        String l = lt.cadastrarLaudoEstresse(estresse);
        return l;
    }
    
    public String atualizarLaudoEstresse(LaudoEstresse estresse) throws LaudoEstresseErro{
        String l = lt.atualizarLaudoEstresse(estresse);
        return l;
    }
    
    public List listarLaudoEstresseByPacienteID(int id_paciente)throws LaudoEstresseErro{
        List l = lt.listarLaudoEstresseByPacienteID(id_paciente);
        return l;
    }
    
    public List listarLaudoEstresseByLaudoEcoID(int id_laudo_eco, boolean isEco)throws LaudoEstresseErro{
        List l = lt.listarLaudoEstresseByLaudoEcoID(id_laudo_eco,isEco);
        return l;
    }
    
    public LaudoEstresse getLaudoEstresseById(int id){
        LaudoEstresse l = lt.getLaudoEstresseById(id);
        return l;
    }
    
    public List getLaudoEstresseByLaudoEcoId(int id){
        List l = lt.getLaudoEstresseByLaudoEcoId(id);
        return l;
    }
     /**
     * Laudo Escore
     */

    public String atualizarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro {
        String l = le.atualizarLaudoEscore(laudoEscore);
        return l;
    }

    public boolean cadastrarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro {
        return le.cadastrarLaudoEscore(laudoEscore);
    }
    
    public int LaudoUltimoIdEscore() throws LaudoEscoreErro{
        return le.LaudoUltimoIdEscore();
    }

    public List listarLaudoEscoreByPacienteID(int id_paciente) throws LaudoEscoreErro {
        List l = le.listarLaudoEscoreByPacienteID(id_paciente);
        return l;
    }

    public List listarLaudoEscoreByLaudoEcoID(int id_laudo_eco) throws LaudoEscoreErro {
        List l = le.listarLaudoEscoreByLaudoEcoID(id_laudo_eco);
        return l;
    }

    public LaudoEscore getLaudoEscoreById(int id) {
        LaudoEscore escore = le.getLaudoEscoreById(id);
        return escore;
    }

    /**
     * Laudo
     */
    public boolean cadastrarLaudo(Eco l) throws LaudoErro {
       return li.cadastrarLaudo(l);
    }
    
    public boolean cadastrarLaudoSub(Eco l) throws LaudoErro {
        
        return li.cadastrarLaudoSub(l);
    }
    public int LaudoUltimoId() throws LaudoErro{
        return li.LaudoUltimoId();
    }
    
    public void cadastrarLaudoIreport(int id, String tipo) throws LaudoErro{
        li.cadastrarLaudoIreport(id, tipo);
    }

    public List listarLaudo(int id_paciente) throws LaudoErro {
        List l = li.listarLaudo(id_paciente);
        return l;
    }
    
    public Eco pesquisarLaudoPorId(int id,String tipo) throws LaudoErro{
        Eco e = li.pesquisarLaudoPorId(id,tipo);
        return e;
    }
    
    public Eco pesquisarLaudoEcoPorId(int id) throws LaudoErro{
        Eco e = li.pesquisarLaudoEcoPorId(id);
        return e;
    }
    
    public Eco pesquisarLaudoSubPorId(int id) throws LaudoErro {
      Eco e = li.pesquisarLaudoSubPorId(id);
      return e;
    
    }
    
    public String escreveTextoPorNome(String Nome) throws LaudoErro {
        String l = li.escreveTextoPorNome(Nome);
        return l;
    }
    
     public String pesquisarModeloPorNome(String Nome) throws LaudoErro {
         String l = li.pesquisarModeloPorNome(Nome);
        return l;
     }
    
    public List pesquisarComboPorTipo(String tipo) throws LaudoErro {
        List l = li.pesquisarComboPorTipo(tipo);
        return l;
    }
    
    public List pesquisarComboPorSigla(String sigla) throws LaudoErro {
        List l = li.pesquisarComboPorSigla(sigla);
        return l;
    }

    public void cadastrarModelo(String nome, String texto) throws LaudoErro {
        li.cadastrarModelo(nome, texto);
    }
    
    public void editarEcoSub(Eco s) throws LaudoErro{
       li.editarEcoSub(s);
    }
    
     public void editarEcoTT(Eco s) throws LaudoErro{
         li.editarEcoTT(s);
     }
     
     public Eco pesquisarLaudoEcoEstressePorId(int id) throws LaudoErro{
         Eco e = li.pesquisarLaudoEcoEstressePorId(id);
         return e;
     }
      public void excluirLaudoUltimoId() throws LaudoErro{
       li.excluirLaudoUltimoId();
      }

      public void excluirLaudoIreport() throws LaudoErro{
          li.excluirLaudoIreport();
      }
      
    /**
     *
     * Paciente
     */
    public void cadastrarPaciente(Paciente p) throws PacienteErro {
        pi.cadastrarPaciente(p);
    }

    public List listarPaciente(String nome) throws PacienteErro {
        List a = pi.listarPaciente(nome);
        return a;
    }

    public Paciente pesquisarPacientePorCpf(int cpf) throws PacienteErro {
        Paciente p = pi.pesquisarPacientePorCpf(cpf);
        return p;
    }

    public void excluirPaciente(Paciente excluir) throws PacienteErro {
        pi.excluirPaciente(excluir);
    }

    public List pesquisarPacientePorNome(String Nome) throws PacienteErro {
        List p = pi.pesquisarPacientePorNome(Nome);
        return p;
    }

    public void editarPaciente(Paciente p) throws PacienteErro {
        pi.editarPaciente(p);
    }
    public Paciente pesquisarPacientePorId(int id) throws PacienteErro{
        Paciente p = pi.pesquisarPacientePorId(id);
        return p;
    }

    /**
     *
     * Convenio
     */
    public void cadastrarConvenio(Convenio c) throws ConvenioErro {
        ci.cadastrarConvenio(c);
    }

    public List listarConvenio() throws ConvenioErro {
        List a = ci.listarConvenio();
        return a;
    }

    public List pesquisarConvenioPorStatus() throws ConvenioErro {
        List c = ci.pesquisarConvenioPorStatus();
        return c;
    }

    public List pesquisarConvenioPorNomes(String Nome) throws ConvenioErro {
        List c = ci.pesquisarConvenioPorNomes(Nome);
        return c;
    }

    public Convenio pesquisarConvenioPorNome(String Nome) throws ConvenioErro {
        Convenio c = ci.pesquisarConvenioPorNome(Nome);
        return c;
    }

    public void excluirConvenio(Convenio excluir) throws ConvenioErro {
        ci.excluirConvenio(excluir);
    }

    public void editarConvenio(Convenio c) throws ConvenioErro {
        ci.editarConvenio(c);
    }
    
    public Convenio pesquisarConvenioPorId(int id) throws ConvenioErro {
        Convenio c = ci.pesquisarConvenioPorId(id);
        return c;
    }

    /**
     *
     * Medico
     */
    public void cadastrarMedico(Medico m) throws MedicoErro {
        mi.cadastrarMedico(m);
    }

    public void cadastrarMedicoAux(Medico m) throws MedicoErro {
        mi.cadastrarMedicoAux(m);
    }

    public List listarMedico() throws MedicoErro {
        List m = mi.listarMedico();
        return m;
    }

    public List pesquisarMedicoPorNome(String Nome) throws MedicoErro {
        List m = mi.pesquisarMedicoPorNome(Nome);
        return m;
    }
    
    public List pesquisarMedicoPorNome(String nome,String status) throws MedicoErro{
        List m = mi.pesquisarMedicoPorNome(nome, status);
        return m;
    }

    public Medico pesquisarMedicoPorCrm(int crm) throws MedicoErro {
        Medico m = mi.pesquisarMedicoPorCrm(crm);
        return m;
    }

    public Medico pesquisarMedicoAux() throws MedicoErro {
        Medico m = mi.pesquisarMedicoAux();
        return m;
    }

    public void excluirMedico(Medico excluir) throws MedicoErro {
        mi.excluirMedico(excluir);
    }

    public void excluirMedicoAux(Medico excluir) throws MedicoErro {
        mi.excluirMedicoAux(excluir);
    }

    public void editarMedico(Medico m) throws MedicoErro {
        mi.editarMedico(m);
    }
    
    public Medico pesquisarMedicoPorId(int id) throws MedicoErro {
        Medico m= mi.pesquisarMedicoPorId(id);
        return m;
    }
    /**
     *
     * Medico
     */
}
