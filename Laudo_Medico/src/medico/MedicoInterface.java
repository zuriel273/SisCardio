
package medico;

import java.util.List;

/**
 *
 * @author Pereiras
 */
public interface MedicoInterface {
    
   
    public void cadastrarMedico(Medico m)throws MedicoErro;
    public void cadastrarMedicoAux(Medico m)throws MedicoErro;
    public List listarMedico()throws MedicoErro;
    public Medico pesquisarMedicoAux() throws MedicoErro;
    public Medico pesquisarMedicoPorCrm(int crm) throws MedicoErro;
    public List pesquisarMedicoPorNome(String nome) throws MedicoErro;
    public List pesquisarMedicoPorNome(String nome,String status) throws MedicoErro;
    public Medico pesquisarMedicoPorId(int id) throws MedicoErro ;
    public void excluirMedico(Medico excluir)throws MedicoErro;
    public void excluirMedicoAux(Medico excluir)throws MedicoErro;
    public void editarMedico(Medico m) throws MedicoErro;

}
 