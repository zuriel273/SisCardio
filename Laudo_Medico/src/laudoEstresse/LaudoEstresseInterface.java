/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEstresse;

import java.util.*;

/**
 *
 * @author arlindo
 */
public interface LaudoEstresseInterface {
    public String cadastrarLaudoEstresse(LaudoEstresse estresse) throws LaudoEstresseErro;
    public String atualizarLaudoEstresse(LaudoEstresse estresse) throws LaudoEstresseErro;
    public List listarLaudoEstresseByPacienteID(int id_paciente)throws LaudoEstresseErro;
    public List listarLaudoEstresseByLaudoEcoID(int id_laudo_eco,boolean isEco)throws LaudoEstresseErro;
    public LaudoEstresse getLaudoEstresseById(int id);
    public List getLaudoEstresseByLaudoEcoId(int id);
}
