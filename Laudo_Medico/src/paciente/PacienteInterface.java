package paciente;

import java.util.List;

/**
 *
 * @author arlindo
 */
public interface PacienteInterface {
    public void cadastrarPaciente(Paciente p)throws PacienteErro;
    public void editarPaciente(Paciente p)throws PacienteErro;
    public List listarPaciente(String nome)throws PacienteErro;
    public Paciente pesquisarPacientePorCpf(int cpf) throws PacienteErro;
    public void excluirPaciente(Paciente excluir)throws PacienteErro;
    public List pesquisarPacientePorNome(String nome) throws PacienteErro;
    public Paciente pesquisarPacientePorId(int id) throws PacienteErro;
}
