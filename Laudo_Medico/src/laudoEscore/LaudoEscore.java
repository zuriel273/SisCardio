
package laudoEscore;

import segmento.*;

/**
 *
 * @author arlindo
 */
public class LaudoEscore {
    
    private int id;
    private int laudoEcoId;
    private Segmento[] segmento = new Segmento[17];
    
    public LaudoEscore() {
    }

    public LaudoEscore(int id, int laudoEcoId, Segmento[] segmento) {
        this.id = id;
        this.laudoEcoId = laudoEcoId;
        this.segmento = segmento;
    }
    
    public LaudoEscore(int id, int laudoEcoId, Segmento segmento1,Segmento segmento2,Segmento segmento3,Segmento segmento4,Segmento segmento5,Segmento segmento6,Segmento segmento7,Segmento segmento8,Segmento segmento9,Segmento segmento10, Segmento segmento11,Segmento segmento12,Segmento segmento13,Segmento segmento14,Segmento segmento15,Segmento segmento16,Segmento segmento17){
        this.id = id;
        this.laudoEcoId = laudoEcoId;
        this.segmento[0]  = segmento1;
        this.segmento[1]  = segmento2;
        this.segmento[2]  = segmento3;
        this.segmento[3]  = segmento4;
        this.segmento[4]  = segmento5;
        this.segmento[5]  = segmento6;
        this.segmento[6]  = segmento7;
        this.segmento[7]  = segmento8;
        this.segmento[8]  = segmento9;
        this.segmento[9]  = segmento10;
        this.segmento[10] = segmento11;
        this.segmento[11] = segmento12;
        this.segmento[12] = segmento13;
        this.segmento[13] = segmento14;
        this.segmento[14] = segmento15;
        this.segmento[15] = segmento16;
        this.segmento[16] = segmento17;
    }
    
    public LaudoEscore(int laudoEcoId, Segmento segmento1,Segmento segmento2,Segmento segmento3,Segmento segmento4,Segmento segmento5,Segmento segmento6,Segmento segmento7,Segmento segmento8,Segmento segmento9,Segmento segmento10, Segmento segmento11,Segmento segmento12,Segmento segmento13,Segmento segmento14,Segmento segmento15,Segmento segmento16,Segmento segmento17){
        this.laudoEcoId = laudoEcoId;
        this.segmento[0]  = segmento1;
        this.segmento[1]  = segmento2;
        this.segmento[2]  = segmento3;
        this.segmento[3]  = segmento4;
        this.segmento[4]  = segmento5;
        this.segmento[5]  = segmento6;
        this.segmento[6]  = segmento7;
        this.segmento[7]  = segmento8;
        this.segmento[8]  = segmento9;
        this.segmento[9]  = segmento10;
        this.segmento[10] = segmento11;
        this.segmento[11] = segmento12;
        this.segmento[12] = segmento13;
        this.segmento[13] = segmento14;
        this.segmento[14] = segmento15;
        this.segmento[15] = segmento16;
        this.segmento[16] = segmento17;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaudoEcoId() {
        return laudoEcoId;
    }

    public void setLaudoEcoId(int laudoEcoId) {
        this.laudoEcoId = laudoEcoId;
    }
    
    public Segmento[] getSegmento(){
        return segmento;
    }

    public void setSegmento(Segmento[] segmento) {
        this.segmento = segmento;
    }
    
    /**
     * 
     * @param segmento
     * @param posicao 
     */
    public void setSegmento(Segmento segmento, int posicao){
        this.segmento[posicao] = segmento;
    }
    
}
