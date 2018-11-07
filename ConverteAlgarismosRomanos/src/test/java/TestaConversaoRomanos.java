import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aluno on 07/11/18.
 */
public class TestaConversaoRomanos {
    private int converteRomanos (String numeroRomano){
        if(eRomano(numeroRomano)){
            int numero = 0;
            for(int i=0; i<numeroRomano.length(); i++){
                if(numeroRomano.charAt(i) == 'M'){
                    numero+=1000;
                }
                else if(numeroRomano.charAt(i) == 'D'){
                    numero+=500;
                }
                else if(numeroRomano.charAt(i) == 'C'){
                    numero+=100;
                }
                else if(numeroRomano.charAt(i) == 'L'){
                    numero+=50;
                }
                else if(numeroRomano.charAt(i) == 'X'){
                    numero+=10;
                }
                else if(numeroRomano.charAt(i) == 'V'){
                    numero+=5;
                }
                else if(numeroRomano.charAt(i) == 'I'){
                    numero++;
                }
                else{
                    return -1;
                }
            }
            return numero;
        }
        return -1;
    }

    private boolean eRomano(String test){
        if(naoNulo(test) && charValidos(test) && formatacaoCorreta(test)){
            return true;
        }
        return false;
    }

    private boolean naoNulo(String test){
        if(test!=null && test.length()>0 & !test.trim().equals("")){
            return true;
        }
        return false;
    }

    private boolean charValidos(String test){
        for(int i=0; i<test.length(); i++){
            char a = test.charAt(i);
            if(a == 'M' || a == 'D'|| a == 'C' || a == 'L' || a == 'X' || a == 'V' || a == 'I'){
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }

    public boolean formatacaoCorreta(String test){
        char esquerda = test.charAt(0);
        int i=1;
        Contadores c = new Contadores();
        if(!inicializaCount(esquerda, c)){
            return false;
        }
        while(i<test.length()){
            char a = test.charAt(i);
            if(a == 'M'){
                c.contM++;
                if(esquerda != 'M'){
                    return false;
                }
            }
            else if( a == 'D'){
                c.contD++;
                if(esquerda != 'M'){
                    return false;
                }
            }
            else if( a == 'C'){
                c.contC++;
                if(esquerda != 'M' && esquerda !='D' && esquerda !='C'){
                    return false;
                }
            }
            else if(a == 'L'){
                c.contL++;
                if(esquerda != 'M' && esquerda !='D' && esquerda !='C'){
                    return false;
                }

            }
            else if(a == 'X'){
                c.contX++;
                if(esquerda != 'M' && esquerda !='D' && esquerda !='C' && esquerda !='L' && esquerda !='X'){
                    return false;
                }

            }
            else if(a == 'V'){
                c.contV++;
                if(esquerda != 'M' && esquerda !='D' && esquerda !='C' && esquerda !='L' && esquerda !='X'){
                    return false;
                }
            }
            else if( a == 'I'){
                c.contI++;
            }
            else{
                return false;
            }
            esquerda = a;
            i++;
            if(!c.testaContadores()){
                return false;
            }
        }
        return true;
    }

    private boolean inicializaCount(char esquerda, Contadores contadores){
        if(esquerda == 'M'){
            contadores.contM++;
        }
        else if(esquerda == 'D'){
            contadores.contD++;
        }
        else if(esquerda == 'C'){
            contadores.contC++;
        }
        else if(esquerda == 'L'){
            contadores.contL++;
        }
        else if(esquerda == 'X'){
            contadores.contX++;
        }
        else if(esquerda == 'V'){
            contadores.contV++;
        }
        else if(esquerda == 'I'){
            contadores.contI++;
        }
        else{
            return false;
        }
        return true;
    }

    @Test
    public void testa (){
        Assert.assertEquals(charValidos(" 8D "), false);
        Assert.assertEquals(charValidos("  "), false);
        Assert.assertEquals(charValidos("C"), true);
        Assert.assertEquals(charValidos("CLXVI"), true);
        Assert.assertEquals(charValidos("CCCCMMMMMMMMMLLLLXXXXIIIIIIIILXVI"), true);

        Assert.assertEquals(converteRomanos("CLXVI -"), -1, 0.001);
        Assert.assertEquals(converteRomanos("I I"), -1, 0.001);
        Assert.assertEquals(converteRomanos("CC LI"), -1, 0.001);
        Assert.assertEquals(converteRomanos("CCD"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XII94"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XII "), -1, 0.001);
        Assert.assertEquals(converteRomanos("XXIIVVC"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XIID"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XIIV"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XIIDD"), -1, 0.001);
        Assert.assertEquals(converteRomanos("MMMMMMM"), -1, 0.001);
        Assert.assertEquals(converteRomanos("MDIIIIII"), -1, 0.001);
        Assert.assertEquals(converteRomanos("MDCLXVIP"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XCI"), -1, 0.001);
        Assert.assertEquals(converteRomanos("LXI99"), -1, 0.001);
        Assert.assertEquals(converteRomanos("CPU"), -1, 0.001);
        Assert.assertEquals(converteRomanos(" "), -1, 0.001);
        Assert.assertEquals(converteRomanos("@#%"), -1, 0.001);
        Assert.assertEquals(converteRomanos("AAAAA"), -1, 0.001);
        Assert.assertEquals(converteRomanos("-668686"), -1, 0.001);
        Assert.assertEquals(converteRomanos("212"), -1, 0.001);
        Assert.assertEquals(converteRomanos("dsae"), -1, 0.001);
        Assert.assertEquals(converteRomanos("MMMMM"), -1, 0.001);
        Assert.assertEquals(converteRomanos("XIVI"), -1, 0.001);
        Assert.assertEquals(converteRomanos(""), -1, 0.001);
        Assert.assertEquals(converteRomanos("DD"), -1, 0.001);
        Assert.assertEquals(converteRomanos("LL"), -1, 0.001);
        Assert.assertEquals(converteRomanos("CCCCCC"), -1, 0.001);


        Assert.assertEquals(converteRomanos("M"), 1000, 0.001);
        Assert.assertEquals(converteRomanos("D"), 500, 0.001);
        Assert.assertEquals(converteRomanos("V"), 5, 0.001);
        Assert.assertEquals(converteRomanos("L"), 50, 0.001);
        Assert.assertEquals(converteRomanos("X"), 10, 0.001);
        Assert.assertEquals(converteRomanos("XVI"), 16, 0.001);
        Assert.assertEquals(converteRomanos("MMMMDCCCCLXXXXVIIII"), 4999, 0.001);
        Assert.assertEquals(converteRomanos("I"), 1, 0.001);
        Assert.assertEquals(converteRomanos("VI"), 6, 0.001);
        Assert.assertEquals(converteRomanos("LXXVII"), 77, 0.001);
        Assert.assertEquals(converteRomanos("MDCCCLXXXVIII"), 1888, 0.001);
        Assert.assertEquals(converteRomanos("CCCCI"), 401, 0.001);
        Assert.assertEquals(converteRomanos("DC"), 600, 0.001);
    }
}
