package functionalTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Fatura;
import main.GeradorNotaFiscal;
import main.NotaFiscal;
import main.TipoServico;

class AnaliseValoresLimitesTest {
	private GeradorNotaFiscal gerador;

	@BeforeEach
	void inicializaGerador() {
		gerador = new GeradorNotaFiscal();
		
	}


	@Test
	void testAbaixoDoMinimo() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, -1));

	}
	
	@Test
	void testIgualAMinimo() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 0);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(0.0, nota.getImposto());

	}
	
	@Test
	void testAcimaDoMinimo() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 1);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(0.25, nota.getImposto());

	}
	
	@Test
	void testValorQualquer() {
		Fatura fatura = new Fatura("Jose Silva", "Rua Silva Barbosa, 975", TipoServico.CONSULTORIA, 100);

		NotaFiscal nota = gerador.geraNotaFiscal(fatura);
		assertEquals(25.0, nota.getImposto());

	}
}
