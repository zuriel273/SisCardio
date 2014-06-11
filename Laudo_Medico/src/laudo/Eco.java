/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package laudo;

import convenio.Convenio;
import java.text.DecimalFormat;
import medico.Medico;
import paciente.Paciente;

/**
 *
 * @author Pereiras
 */
public class Eco extends Laudo{
    
    private Float peso;
    private Float SIV;
    private Float AE;
    private Float DDVE;
    private Float DDVD;
    private Float DSVE;
    private Float PP;
    private Float altura;
    private Float aorta;
    private Float VSF;
    private Float VDF;
    private Float ENCCAV;
    private Float IndEspessuraRel;
    private Float SuperficieCorporea;
    private Float massa;
    private Float IndMassaVE;
    private Float RelAEAO;
    private Float FE;
    private String tipoCalc;
    private String tipo;
    private String texto;

    public Eco(Paciente paciente, Convenio convenio, Medico medico) {
        super(paciente, convenio, medico);
    }

    // Recuperação de laudo: o sistema recebe todos os parametros do banco. 
    public Eco(Float peso, Float SIV, Float AE, Float DDVE, Float DDVD, Float DSVE, Float PP, Float altura, Float aorta, Float VSF, Float VDF, Float ENCCAV, Float IndEspessuraRel, Float SuperficieCorporea, Float massa, Float IndMassaVE, Float RelAEAO, Float FE, String tipoCalc,String tipo, String data_criacao, int id_paciente, int id_medico, int id_convenio) {
        super(data_criacao, id_paciente, id_medico, id_convenio);
        this.peso = peso;
        this.SIV = SIV;
        this.AE = AE;
        this.DDVE = DDVE;
        this.DDVD = DDVD;
        this.DSVE = DSVE;
        this.PP = PP;
        this.altura = altura;
        this.aorta = aorta;
        this.VSF = VSF;
        this.VDF = VDF;
        this.ENCCAV = ENCCAV;
        this.IndEspessuraRel = IndEspessuraRel;
        this.SuperficieCorporea = SuperficieCorporea;
        this.massa = massa;
        this.IndMassaVE = IndMassaVE;
        this.RelAEAO = RelAEAO;
        this.FE = FE;
        this.tipoCalc = tipoCalc;
        this.tipo = tipo;
    }
      

    public Eco(Float peso, Float SIV, Float AE, Float DDVE, Float DDVD, Float DSVE, Float PP, Float altura, Float aorta, Paciente paciente, Convenio convenio, Medico medico) {
        super(paciente, convenio, medico);
        this.peso = peso;
        this.SIV = SIV;
        this.AE = AE;
        this.DDVE = DDVE;
        this.DDVD = DDVD;
        this.DSVE = DSVE;
        this.PP = PP;
        this.altura = altura;
        this.aorta = aorta;
        tipoCalc = "TEICHOLZ";
        calculo();
    }

    public Eco(Float peso, Float SIV, Float AE, Float DDVE, Float DDVD, Float DSVE, Float PP, Float altura, Float aorta, Float VSF, Float VDF, Paciente paciente, Convenio convenio, Medico medico) {
        super(paciente, convenio, medico);
        this.peso = peso;
        this.SIV = SIV;
        this.AE = AE;
        this.DDVE = DDVE;
        this.DDVD = DDVD;
        this.DSVE = DSVE;
        this.PP = PP;
        this.altura = altura;
        this.aorta = aorta;
        this.VSF = VSF;
        this.VDF = VDF;
        tipoCalc = "SIMPSON";
        calculo();
    }

    public Eco(Float peso, Float SIV, Float AE, Float DDVE, Float DDVD, Float DSVE, Float PP, Float altura, Float aorta, Float VSF, Float VDF, Float FE, Paciente paciente, Convenio convenio, Medico medico) {
        super(paciente, convenio, medico);
        this.peso = peso;
        this.SIV = SIV;
        this.AE = AE;
        this.DDVE = DDVE;
        this.DDVD = DDVD;
        this.DSVE = DSVE;
        this.PP = PP;
        this.altura = altura;
        this.aorta = aorta;
        this.VSF = VSF;
        this.VDF = VDF;
        this.FE = FE;
        tipoCalc = "BIDIMENSIONAL";
    }
    
    public Eco(String texto,String tipo, Paciente p, Convenio c, Medico m){
        super(p,c,m);
        this.texto = texto;
        this.tipo = tipo;
    }

    public Eco(String tipo, String texto, String data_criacao, int id_paciente, int id_medico, int id_convenio) {
        super(data_criacao, id_paciente, id_medico, id_convenio);
        this.tipo = tipo;
        this.texto = texto;
    }
    
    

    public Float getPeso() {
        return peso;
    }

    public Float getSIV() {
        return SIV;
    }

    public Float getAE() {
        return AE;
    }

    public Float getDDVE() {
        return DDVE;
    }

    public Float getDDVD() {
        return DDVD;
    }

    public Float getDSVE() {
        return DSVE;
    }

    public Float getPP() {
        return PP;
    }

    public Float getAltura() {
        return altura;
    }

    public Float getAorta() {
        return aorta;
    }

    public Float getVSF() {
        return VSF;
    }

    public Float getVDF() {
        return VDF;
    }

    public Float getENCCAV() {
        return ENCCAV;
    }

    public Float getIndEspessuraRel() {
        return IndEspessuraRel;
    }
       
    public Float getSuperficieCorporea() {
        return SuperficieCorporea;
    }

    public Float getMassa() {
        return massa;
    }

    public Float getIndMassaVE() {
        return IndMassaVE;
    }

    public Float getRelAEAO() {
        return RelAEAO;
    }

    public Float getFE() {
        return FE;
    }
    
    public void calculo(){
        if(tipoCalc.equals("TEICHOLZ")){
            VDF = (7*((float)Math.pow((double)DDVE,3))/((2.4f) * DDVE));
            VSF = (7*((float)Math.pow((double)DSVE,3))/((2.4f) * DSVE));
            FE = ((VDF-VSF)/VDF)*100;          
        } 
        if(tipoCalc.equals("SIMPSON")){
            FE = (VDF-VSF)/VDF;
        }
        SuperficieCorporea = (0.0001f)*(71.74f)*((float)Math.pow((double)peso,(double)0.425f))*((float)Math.pow((double)altura,(double)0.725f));
        massa = ((((float)Math.pow((double)(DDVE+SIV+PP),3))-(((float)Math.pow((double)DDVE, 3))))*1.04f+0.6f)/1000;
        IndMassaVE  = massa/(SuperficieCorporea);
        RelAEAO = AE/aorta; // não tenho certeza AO == aorta
        ENCCAV = ((DDVE - DSVE)/DDVE)*100;
        IndEspessuraRel = (2*PP)/DDVE;
        
         
        
        
        
    }

    public String getTipoCalc() {
        return tipoCalc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
    

   
    
    
    
    
    
}
