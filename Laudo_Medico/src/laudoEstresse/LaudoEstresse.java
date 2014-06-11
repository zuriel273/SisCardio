/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudoEstresse;

import esforco.Esforco;

/**
 *
 * @author arlindo
 */
public class LaudoEstresse {
    
    int id;
    int laudoEcoId;
    Esforco[] repouso;
    Esforco[] cincomcg;
    Esforco[] dezmcg;
    Esforco[] vintemcg;
    boolean esv;
    boolean essv;
    boolean tv;
    boolean tvns;
    boolean fa;
    boolean bradicardia;
    boolean dor_precordial;
    boolean hipertensao;
    boolean hipotensao;
    boolean nausea;
    boolean eco;
    String outro_arritmia;
    String outro_ef_colateral;
    String texto;
        
    public LaudoEstresse() {
    }

    public LaudoEstresse(int id, int laudoEcoId, Esforco[] repouso, Esforco[] cincomcg, Esforco[] dezmcg, Esforco[] vintemcg, boolean esv, boolean essv, boolean tv, boolean tvns, boolean fa, boolean bradicardia, boolean dor_precordial, boolean hipertensao, boolean hipotensao, boolean nausea, String outro_arritmia, String outro_ef_colateral,String texto) {
        this.id = id;
        this.laudoEcoId = laudoEcoId;
        this.repouso = repouso;
        this.cincomcg = cincomcg;
        this.dezmcg = dezmcg;
        this.vintemcg = vintemcg;
        this.esv = esv;
        this.essv = essv;
        this.tv = tv;
        this.tvns = tvns;
        this.fa = fa;
        this.bradicardia = bradicardia;
        this.dor_precordial = dor_precordial;
        this.hipertensao = hipertensao;
        this.hipotensao = hipotensao;
        this.nausea = nausea;
        this.outro_arritmia = outro_arritmia;
        this.outro_ef_colateral = outro_ef_colateral;
        this.texto = texto;
    }
    
    public LaudoEstresse(int laudoEcoId, Esforco[] repouso, Esforco[] cincomcg, Esforco[] dezmcg, Esforco[] vintemcg, boolean esv, boolean essv, boolean tv, boolean tvns, boolean fa, boolean bradicardia, boolean dor_precordial, boolean hipertensao, boolean hipotensao, boolean nausea, String outro_arritmia, String outro_ef_colateral, String texto) {
        this.laudoEcoId = laudoEcoId;
        this.repouso = repouso;
        this.cincomcg = cincomcg;
        this.dezmcg = dezmcg;
        this.vintemcg = vintemcg;
        this.esv = esv;
        this.essv = essv;
        this.tv = tv;
        this.tvns = tvns;
        this.fa = fa;
        this.bradicardia = bradicardia;
        this.dor_precordial = dor_precordial;
        this.hipertensao = hipertensao;
        this.hipotensao = hipotensao;
        this.nausea = nausea;
        this.outro_arritmia = outro_arritmia;
        this.outro_ef_colateral = outro_ef_colateral;
        this.texto = texto;
    }

    public LaudoEstresse(Esforco repouso_0,Esforco repouso_1, Esforco cincomcg_0, Esforco cincomcg_1, Esforco dezmcg_0, Esforco dezmcg_1, Esforco vintemcg_0, Esforco vintemcg_1) {
        this.repouso[0] = repouso_0;
        this.repouso[1] = repouso_1;
        this.cincomcg[0] = cincomcg_0;
        this.cincomcg[1] = cincomcg_1;
        this.dezmcg[0] = dezmcg_0;
        this.dezmcg[1] = dezmcg_1;
        this.vintemcg[0] = vintemcg_0;
        this.vintemcg[1] = vintemcg_1;
    }

    public boolean isEco() {
        return eco;
    }

    public void setEco(boolean eco) {
        this.eco = eco;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    public boolean isEsv() {
        return esv;
    }

    public void setEsv(boolean esv) {
        this.esv = esv;
    }

    public boolean isEssv() {
        return essv;
    }

    public void setEssv(boolean essv) {
        this.essv = essv;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }

    public boolean isTvns() {
        return tvns;
    }

    public void setTvns(boolean tvns) {
        this.tvns = tvns;
    }

    public boolean isFa() {
        return fa;
    }

    public void setFa(boolean fa) {
        this.fa = fa;
    }

    public boolean isBradicardia() {
        return bradicardia;
    }

    public void setBradicardia(boolean bradicardia) {
        this.bradicardia = bradicardia;
    }

    public boolean isDor_precordial() {
        return dor_precordial;
    }

    public void setDor_precordial(boolean dor_precordial) {
        this.dor_precordial = dor_precordial;
    }

    public boolean isHipertensao() {
        return hipertensao;
    }

    public void setHipertensao(boolean hipertensao) {
        this.hipertensao = hipertensao;
    }

    public boolean isHipotensao() {
        return hipotensao;
    }

    public void setHipotensao(boolean hipotensao) {
        this.hipotensao = hipotensao;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public String getOutro_arritmia() {
        return outro_arritmia;
    }

    public void setOutro_arritmia(String outro_arritmia) {
        this.outro_arritmia = outro_arritmia;
    }

    public String getOutro_ef_colateral() {
        return outro_ef_colateral;
    }

    public void setOutro_ef_colateral(String outro_ef_colateral) {
        this.outro_ef_colateral = outro_ef_colateral;
    }

    public int getLaudoEcoId() {
        return laudoEcoId;
    }

    public void setLaudoEcoId(int laudoEcoId) {
        this.laudoEcoId = laudoEcoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Esforco[] getRepouso() {
        return repouso;
    }

    public void setRepouso(Esforco[] repouso) {
        this.repouso = repouso;
    }
    
    public Esforco[] getCincomcg() {
        return cincomcg;
    }

    public void setCincomcg(Esforco[] cincomcg) {
        this.cincomcg = cincomcg;
    }

    public Esforco[] getDezmcg() {
        return dezmcg;
    }

    public void setDezmcg(Esforco[] dezmcg) {
        this.dezmcg = dezmcg;
    }

    public Esforco[] getVintemcg() {
        return vintemcg;
    }

    public void setVintemcg(Esforco[] vintemcg) {
        this.vintemcg = vintemcg;
    }
    
    
}
