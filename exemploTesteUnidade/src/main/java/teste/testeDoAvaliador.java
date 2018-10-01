package teste;

import dominio.Lance;
import dominio.Leilao;
import dominio.Usuario;
import org.junit.Assert;
import org.junit.Test;
import serviço.Avaliador;

public class testeDoAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente (){
        Usuario joao = new Usuario("João");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 novo");

        leilao.propoe(new Lance(joao, 250.00));
        leilao.propoe(new Lance(jose, 300.00));
        leilao.propoe(new Lance(maria, 400.00));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double maiorEsperado = 400.0;
        double menorEsperado = 250.0;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }
}
