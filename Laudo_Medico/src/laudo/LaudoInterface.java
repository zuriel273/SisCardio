/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudo;

import java.util.List;

/**
 *
 * @author arlindojr
 */
public interface LaudoInterface {
    
    
    public boolean cadastrarLaudo(Eco l)throws LaudoErro;
    public boolean cadastrarLaudoSub(Eco l)throws LaudoErro;
    public int LaudoUltimoId() throws LaudoErro;
    public List listarLaudo(int id_paciente)throws LaudoErro;
    public Eco pesquisarLaudoPorId(int id,String tipo) throws LaudoErro ;
    public Eco pesquisarLaudoEcoPorId(int id) throws LaudoErro ;
    public Eco pesquisarLaudoSubPorId(int id) throws LaudoErro ;
    public void cadastrarModelo(String nome, String texto) throws LaudoErro ;
    public String pesquisarModeloPorNome(String Nome) throws LaudoErro ;
    public String escreveTextoPorNome(String Nome) throws LaudoErro ;
    public List pesquisarComboPorTipo(String tipo) throws LaudoErro;
    public List pesquisarComboPorSigla(String sigla) throws LaudoErro;
    public void editarEcoSub(Eco s) throws LaudoErro;
    public void editarEcoTT(Eco s) throws LaudoErro;
    public Eco pesquisarLaudoEcoEstressePorId(int id) throws LaudoErro;
    public void excluirLaudoUltimoId() throws LaudoErro;
    public void cadastrarLaudoIreport(int id, String tipo) throws LaudoErro;
    public void excluirLaudoIreport() throws LaudoErro;
   
    
    

}
