package segmento;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arlindo
 */
public class Segmento {
    private int id;
    private double repouso;
    private double baixaDose;
    private double pico;
    private double recuperacao;
    private int laudoEscoreId;
    
    public Segmento() {
    }

    public Segmento(int id, double repouso, double baixaDose, double pico, double recuperacao, int laudoEscoreId) {
        this.id = id;
        this.repouso = repouso;
        this.baixaDose = baixaDose;
        this.pico = pico;
        this.recuperacao = recuperacao;
        this.laudoEscoreId = laudoEscoreId;
    }

    public Segmento(double repouso, double baixaDose, double pico, double recuperacao) {
        this.repouso = repouso;
        this.baixaDose = baixaDose;
        this.pico = pico;
        this.recuperacao = recuperacao;
    }

    public Segmento(double repouso, double baixaDose, double pico, double recuperacao, int laudoEscoreId) {
        this.repouso = repouso;
        this.baixaDose = baixaDose;
        this.pico = pico;
        this.recuperacao = recuperacao;
        this.laudoEscoreId = laudoEscoreId;
    }
    
    public int getLaudoEscoreId() {
        return laudoEscoreId;
    }

    public void setLaudoEscoreId(int laudoEscoreId) {
        this.laudoEscoreId = laudoEscoreId;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public double getRepouso() {
        return repouso;
    }

    public void setRepouso(double repouso) {
        this.repouso = repouso;
    }

    public double getBaixaDose() {
        return baixaDose;
    }

    public void setBaixaDose(double baixaDose) {
        this.baixaDose = baixaDose;
    }

    public double getPico() {
        return pico;
    }

    public void setPico(double pico) {
        this.pico = pico;
    }

    public double getRecuperacao() {
        return recuperacao;
    }

    public void setRecuperacao(double recuperacao) {
        this.recuperacao = recuperacao;
    }
    
}
