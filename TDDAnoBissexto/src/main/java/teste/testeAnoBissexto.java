package teste;

import org.junit.Assert;
import org.junit.Test;

public class testeAnoBissexto {
    public boolean anoBissexto (int ano){
        //São bissextos todos os anos múltiplos de 400, p.ex: 1600, 2000, 2400, 2800...
        //São bissextos todos os múltiplos de 4, exceto se for múltiplo de 100 mas não de 400, p.ex: 1996, 2000, 2004, 2008, 2012, 2016…
        //Não são bissextos todos os demais anos.
        if(ano<0){
            return false;
        }
        if(ano % 400 == 0){
            return true;
        }
        else if(ano % 4 == 0 && ano % 100 != 0){
            return true;
        }
        else{
            return false;
        }
    }

    @Test
    public void testa (){
        Assert.assertEquals(anoBissexto(4), true);
        Assert.assertEquals(anoBissexto(400), true);
        Assert.assertEquals(anoBissexto(100), false);
        Assert.assertEquals(anoBissexto(16), true);
        Assert.assertEquals(anoBissexto(1616), true);
        Assert.assertEquals(anoBissexto(1677), false);
        Assert.assertEquals(anoBissexto(2017), false);
        Assert.assertEquals(anoBissexto(1), false);
        Assert.assertEquals(anoBissexto(-678), false);
        Assert.assertEquals(anoBissexto(-6546678), false);
        Assert.assertEquals(anoBissexto(-642123678), false);
        Assert.assertEquals(anoBissexto(444444444), true);
        Assert.assertEquals(anoBissexto(0), true);
        Assert.assertEquals(anoBissexto(1999), false);
        Assert.assertEquals(anoBissexto(1400), false);
    }
}
