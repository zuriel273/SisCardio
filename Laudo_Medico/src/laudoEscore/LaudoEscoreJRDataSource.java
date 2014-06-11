package laudoEscore;

import java.util.Iterator;
import java.util.Vector;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

public class LaudoEscoreJRDataSource implements JRDataSource {



    private Iterator<LaudoEscore> iterator;
    private LaudoEscore cursor;

    public LaudoEscoreJRDataSource(Vector<LaudoEscore> escore) {
            super();
            iterator = escore.iterator();
    }

    @Override
    public boolean next() throws JRException {
            boolean retorno = iterator.hasNext();
            if(retorno){
                    cursor=iterator.next();
            }
            return retorno;
    }

    @Override
    public Object getFieldValue(JRField nome) throws JRException {
            LaudoEscore escore = cursor;
            if(nome.getName().equals("REPOUSO_0")) {
                    return escore.getSegmento()[0].getRepouso();
            }
            if(nome.getName().equals("BAIXA_0")) {
                    return escore.getSegmento()[0].getBaixaDose();
            }
            if(nome.getName().equals("RECUPERACAO_0")) {
                    return escore.getSegmento()[0].getRecuperacao();
            }
            if(nome.getName().equals("PICO_0")) {
                    return escore.getSegmento()[0].getPico();
            }
            return null;
    }

}