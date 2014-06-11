/*  
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEscore;

import fachada.Fachada;
import java.util.Vector;
import net.sf.jasperreports.engine.JRDataSource;

/**
 *
 * @author arlindo
 */
public class LaudoEscoreJRDataSourceFactory {
    private static JRDataSource data;

    public static JRDataSource createDatasource(int id){
            if (data == null) {
                Vector escore;
                escore = new Vector();
                Fachada f = new Fachada();
                escore.add(f.getLaudoEscoreById(id));
                data = new LaudoEscoreJRDataSource(escore);
            }
            return data;
    }
}
