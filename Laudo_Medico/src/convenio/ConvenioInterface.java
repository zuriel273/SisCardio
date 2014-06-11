/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convenio;

import java.util.List;

/**
 *
 * @author Pereiras
 */
public interface ConvenioInterface {
    
    public void cadastrarConvenio(Convenio c)throws ConvenioErro;
    public List<Convenio> listarConvenio()throws ConvenioErro;
    public List<Convenio> pesquisarConvenioPorStatus() throws ConvenioErro;
    public List<Convenio> pesquisarConvenioPorNomes(String Nome) throws ConvenioErro;
    public Convenio pesquisarConvenioPorNome(String Nome) throws ConvenioErro;
    public void excluirConvenio(Convenio excluir)throws ConvenioErro;
    public void editarConvenio(Convenio c) throws ConvenioErro;
    public Convenio pesquisarConvenioPorId(int id) throws ConvenioErro ;
    
}
