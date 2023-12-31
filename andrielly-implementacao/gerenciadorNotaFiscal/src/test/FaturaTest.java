package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.TipoServico;

class FaturaTest {

	@Test
	void testFaturaCreation() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertTrue(fatura.isValid);
	}
	
	@Test
	void testFaturaCreationNomeNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura(null, "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	void testFaturaCreationEnderecoNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", null, TipoServico.CONSULTORIA, 100.0));
	}
	
	@Test
	void testFaturaCreationValorFaturaMenorQueZero() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 0.0));
	}

	@Test
	void testFaturaGetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		assertEquals("Jose Silva", fatura.getNome());
		assertEquals("Rua Silva Barbosa, 975", fatura.getEndereco());
		assertEquals(TipoServico.CONSULTORIA, fatura.getTipoServico());
		assertEquals(100.0, fatura.getValor());
	}
	
	@Test
	void testFaturaSetAtributos() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		fatura.setNome("Joaquim Silva");
		assertEquals("Joaquim Silva", fatura.getNome());
		
		fatura.setEndereco("Rua Silva Barbosa, 975, Campina Grande, Paraíba");
		assertEquals("Rua Silva Barbosa, 975, Campina Grande, Paraíba", fatura.getEndereco());
		
		fatura.setTipoServico(TipoServico.TREINAMENTO);
		assertEquals(TipoServico.TREINAMENTO, fatura.getTipoServico());
		
		fatura.setValor(200.0);
		assertEquals(200.0, fatura.getValor());
	}
	
	@Test
	void testSetNomeNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setNome(null));
	}
	
	@Test
	void testSetEnderecoNull() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setEndereco(null));
	}
	
	@Test
	void testSetValorFaturaMenorIgualQueZero() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setValor(0.0));
		Assertions.assertThrows(IllegalArgumentException.class, () -> fatura.setValor(-1.0));
	}
	
	@Test
	void testEquals() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertTrue(fatura.equals(fatura2));
	}
	
	@Test
	void testHashCode() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		Fatura fatura2 = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100.0);
		
		assertEquals(fatura.hashCode(), fatura2.hashCode());
	}
}
