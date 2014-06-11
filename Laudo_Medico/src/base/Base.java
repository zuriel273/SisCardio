/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.InputMismatchException;

/**
 *
 * @author arlindo
 */
public class Base {
    
    public String getDigNum(String texto){
       String t = texto, digitado = "";
       
       if(t.length() == 1) {
            digitado = this.getNumero(t)+"";
        }
       else if(t.length() > 1){
            digitado = this.getNumero(t.substring(0,1)+"")+"";
        }
        
       return digitado;
    }
    
    public char getNumber(char ch) {
        return (!Character.isDigit(ch)) ? ' ' : ch;
    }

    public String getTexto(String texto) {
        return texto.replaceAll("[0-9]", "");
    }

    public int getNumero(String texto) {
        String t = texto.replaceAll("\\D", "");
        return Integer.parseInt(t.equals("") ? "0" : t + "");
    }

    public float getFloat(String texto) {
        boolean t = texto.matches("^([0-9]*\\.?[0-9]*)$");
        return (t == true) ? Float.parseFloat(texto) : (float)0;
    }

    public boolean validaCPF(String t) {
        String CPF = t;
        String cpf;
        if (CPF.length() == 14) {

            cpf = CPF.substring(0, 3) + "." + CPF.substring(4, 7) + "." + CPF.substring(8, 11) + "-" + CPF.substring(12, 14);

            if (CPF.equals(cpf)) {

                cpf = CPF.substring(0, 3) + CPF.substring(4, 7) + CPF.substring(8, 11) + CPF.substring(12, 14);
                CPF = cpf;

            }
        }

        if (CPF.equals("00000000000") || CPF.equals("11111111111")
                || CPF.equals("22222222222") || CPF.equals("33333333333")
                || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777")
                || CPF.equals("88888888888") || CPF.equals("99999999999")
                || (CPF.length() != 11)) {
            return false;
        } else {
            char dig10, dig11;
            int sm, i, r, num, peso;
            try {
                // Calculo do 1o. Digito Verificador
                sm = 0;
                peso = 10;
                for (i = 0; i < 9; i++) {
                    // converte o i-esimo caractere do CPF em um numero:
                    // por exemplo, transforma o caractere '0' no inteiro 0        
                    // (48 eh a posicao de '0' na tabela ASCII)        
                    num = (int) (CPF.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig10 = '0';
                } else {
                    dig10 = (char) (r + 48);
                } // converte no respectivo caractere numerico

                // Calculo do 2o. Digito Verificador
                sm = 0;
                peso = 11;
                for (i = 0; i < 10; i++) {
                    num = (int) (CPF.charAt(i) - 48);
                    sm = sm + (num * peso);
                    peso = peso - 1;
                }

                r = 11 - (sm % 11);
                if ((r == 10) || (r == 11)) {
                    dig11 = '0';
                } else {
                    dig11 = (char) (r + 48);
                }

                // Verifica se os digitos calculados conferem com os digitos informados.
                if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10))) {
                    cpf = CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-" + CPF.substring(9, 11);
                    //              return true;
                } else {
                    return false;
                }
            } catch (InputMismatchException erro) {
                return false;
            }
        }

        return true;
    }
}
