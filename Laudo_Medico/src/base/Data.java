/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.GregorianCalendar;

/**
 *
 * @author arlindo
 */
public class Data {
    public boolean isDataValida(String data){
        System.out.println(data.length());
        if(!data.replace("/","").trim().equals("")){
            String d, m, y;
            int dia, mes;

            GregorianCalendar calendar = new GregorianCalendar();
            int qtdDiasMes = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);

            d = (String) data.subSequence(0,2);
            m = (String) data.subSequence(3,5);
            y = (String) data.subSequence(6,10);
            if((!m.trim().equals(""))&&(!d.trim().equals(""))&&(!y.trim().equals(""))){
                dia = Integer.parseInt(d);
                mes = Integer.parseInt(m);

                if(dia > qtdDiasMes || mes > 12){
                    return false;
                }
            }else{
                return false;
            }
        }
        else
        {
            return false;
        }
        return true;
    }
}
