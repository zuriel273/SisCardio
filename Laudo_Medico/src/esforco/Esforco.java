/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package esforco;

/**
 *
 * @author arlindojr
 */
public class Esforco {
  int id;
   int estresseId;
   String pa;
   String fc;
   String atropina;
   String eletrocardiograma;
   String tipo;
   
   public Esforco(int id, int estresseId, String pa, String fc, String atropina, String eletrocardiograma,String tipo) {
        this.id = id;
        this.estresseId = estresseId;
        this.pa = pa;
        this.fc = fc;
        this.atropina = atropina;
        this.eletrocardiograma = eletrocardiograma;
        this.tipo = tipo;
    }
   
    public Esforco(String pa, String fc, String atropina, String eletrocardiograma,int estresseId) {
        this.estresseId = estresseId;
        this.pa = pa;
        this.fc = fc;
        this.atropina = atropina;
        this.eletrocardiograma = eletrocardiograma;
    }

    public Esforco(int id, String pa, String fc, String atropina, String eletrocardiograma) {
        this.id = id;
        this.pa = pa;
        this.fc = fc;
        this.atropina = atropina;
        this.eletrocardiograma = eletrocardiograma;
    }

    public Esforco(String pa, String fc, String atropina, String eletrocardiograma) {
        this.pa = pa;
        this.fc = fc;
        this.atropina = atropina;
        this.eletrocardiograma = eletrocardiograma;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstresseId() {
        return estresseId;
    }

    public void setEstresseId(int estresseId) {
        this.estresseId = estresseId;
    }

    public Esforco() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getFc() {
        return fc;
    }

    public void setFc(String fc) {
        this.fc = fc;
    }

    public String getAtropina() {
        return atropina;
    }

    public void setAtropina(String atropina) {
        this.atropina = atropina;
    }

    public String getEletrocardiograma() {
        return eletrocardiograma;
    }

    public void setEletrocardiograma(String eletrocardiograma) {
        this.eletrocardiograma = eletrocardiograma;
    }
      
}
