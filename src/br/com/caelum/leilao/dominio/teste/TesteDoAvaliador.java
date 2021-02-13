package br.com.caelum.leilao.dominio.teste;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.dominio.servico.Avaliador;

public class TesteDoAvaliador {
	
	@Test
	public void deveEntenderLancesEmOrdemCrescente(){
		   Usuario joao = new Usuario("João");
	        Usuario jose = new Usuario("José");
	        Usuario maria = new Usuario("Maria");

	        Leilao leilao = new Leilao("Playstation 3 Novo");

	        leilao.propoe(new Lance(joao, 250.0));
	        leilao.propoe(new Lance(jose, 300.0));
	        leilao.propoe(new Lance(maria, 400.0));

	        Avaliador leiloeiro = new Avaliador();
	        leiloeiro.avalia(leilao);
	        
	        double maiorValorEsperado = 400;
	        double menorValorEsperado = 250;
	        
	        Assert.assertEquals(maiorValorEsperado,leiloeiro.getMaiorLance(),0.00001);
	        Assert.assertEquals(menorValorEsperado,leiloeiro.getMenorLance(),0.00001);
	}

}
