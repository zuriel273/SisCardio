/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEscore;

import java.util.List;

/**
 *
 * @author arlindo
 */
public interface LaudoEscoreInterface {
    public boolean cadastrarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro;
    public int LaudoUltimoIdEscore() throws LaudoEscoreErro;
    public String atualizarLaudoEscore(LaudoEscore laudoEscore) throws LaudoEscoreErro;
    public List listarLaudoEscoreByPacienteID(int id_paciente)throws LaudoEscoreErro;
    public List listarLaudoEscoreByLaudoEcoID(int id_laudo_eco)throws LaudoEscoreErro;
    public LaudoEscore getLaudoEscoreById(int id);
}
