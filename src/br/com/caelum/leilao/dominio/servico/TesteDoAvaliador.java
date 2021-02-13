package br.com.caelum.leilao.dominio.servico;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class TesteDoAvaliador {

	@Test
	public void deveEntenderLancesEmOrdemCrescente() {
		Usuario joao = new Usuario("Jo�o");
		Usuario jose = new Usuario("Jos�");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Playstation 3 Novo");

		leilao.propoe(new Lance(joao, 250.0));
		leilao.propoe(new Lance(jose, 300.0));
		leilao.propoe(new Lance(maria, 400.0));

		Avaliador leiloeiro = new Avaliador();
		leiloeiro.avalia(leilao);

		double maiorValorEsperado = 400;
		double menorValorEsperado = 250;
		/*
		 * Apesar de n�o fazer diferen�a nenhuma (afinal, esperamos que os dois n�meros
		 * sejam iguais), � importante manter essa ordem.
		 * Quando o teste falha, o JUnit usa esses valores para exibir uma mensagem de
		 * erro amig�vel. Por exemplo, expected 10, but was 20. Ou seja, esperava 10,
		 * mas veio 20. Se invert�ssemos os valores, a mensagem ficaria errada!
		 */
		assertEquals(maiorValorEsperado, leiloeiro.getMaiorLance(), 0.00001);
		assertEquals(menorValorEsperado, leiloeiro.getMenorLance(), 0.00001);
	}
	
	
    @Test
    public void testaMediaDeZeroLance(){

        // cenario
        Usuario ewertom = new Usuario("Ewertom");

        // acao
        Leilao leilao = new Leilao("Iphone 7");

        Avaliador avaliador = new Avaliador();
        avaliador.avalia(leilao);

        //validacao
        assertEquals(0, avaliador.getMedia(), 0.0001);

    }
    
    @Test
    public void deveEntenderLancesEmOrdemCrescenteComOutrosValores() {
        Usuario joao = new Usuario("Jo�o");
        Usuario jose = new Usuario("Jos�");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));
        leilao.propoe(new Lance(jose, 2000.0));
        leilao.propoe(new Lance(maria, 3000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(3000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }
    
    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        Usuario joao = new Usuario("Jo�o"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.0001);
    }
    
    @Test
    public void entendendoComparator() { 
    	
    	List<Integer> maiores = Arrays.asList(3,2,1);
    	
	Collections.sort(maiores,new Comparator<Integer>() {
		public int compare(Integer arg0, Integer arg1) {
			if (arg0<arg1)return 1;
			if (arg0>arg1)return -1;
			return 0;
		}
		});
	
	for (Integer integer : maiores) {
		System.out.println(maiores);
	}
    }
    
    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("Jo�o");
        Usuario maria = new Usuario("Maria");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();

        assertEquals(3, maiores.size());
    }

    
    
    
    
    
    
    
}
    
    
    
    

	
	
	

