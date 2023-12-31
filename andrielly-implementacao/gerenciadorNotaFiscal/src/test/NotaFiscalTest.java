package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.Fatura;
import main.NotaFiscal;
import main.TipoServico;

class NotaFiscalTest {
	
	@Test
	void testNotaFiscalCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		assertTrue(notaFiscal.isValid);
	}
	
	@Test
	void testCalculaImpostoConsultoria() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals(25.0, notaFiscal.getImposto());
	}

	@Test
	void testCalculaImpostoTreinamento() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.TREINAMENTO, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);

		assertEquals(15.0, notaFiscal.getImposto());
	}
	
	@Test
	void testCalculaImpostoOutroServico() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.OUTROS, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", null, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		NotaFiscal notaFiscal2 = new NotaFiscal(fatura2);

		assertEquals(6.0, notaFiscal.getImposto());
		assertEquals(6.0, notaFiscal2.getImposto());
	}
	
	@Test
	void testNotaFiscalGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		assertEquals(fatura, notaFiscal.getFatura());
		assertEquals(25.0, notaFiscal.getImposto());
	}
	
	@Test
	void testFaturaSetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 250.0);
		
		notaFiscal.setFatura(fatura2);
		
		assertEquals(fatura2, notaFiscal.getFatura());
		assertEquals(62.5, notaFiscal.getImposto());
		
	}
	
	@Test
	void testSetFaturaNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		NotaFiscal notaFiscal = new NotaFiscal(fatura);
		notaFiscal.setFatura(null);
		assertEquals(fatura, notaFiscal.getFatura());
	}
}
