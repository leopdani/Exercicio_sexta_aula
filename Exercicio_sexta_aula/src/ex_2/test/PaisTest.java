package ex_2.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import ex_2.model.Pais;
import ex_2.service.PaisService;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PaisTest {
	Pais pais, copia;
	static int id = 0;
	double delta = 0.01;

	@Before
	public void setUp() throws Exception {
		System.out.println("Setup");
		pais = new Pais(1, "China", 1394550000, 9596961);
		copia = new Pais(1, "China", 1394550000, 9596961);
		System.out.println(pais);
		System.out.println(copia);
	}

	@Test
	public void test00Carregar() {
		System.out.println("Carregar");
		Pais fixture = new Pais(6, "Brasil", 210147125, 8515767);
		Pais novo = new Pais(6, null, 0, 0);
		PaisService service = new PaisService();
		novo = service.carregar(novo.getId());
		assertEquals(novo, fixture);
	}

	@Test
	public void test01Criar() {
		System.out.println("Criar");
		PaisService service = new PaisService();
		service.criar(pais);
		id = pais.getId();
		System.out.println(id);
		copia.setId(id);
		assertEquals(pais, copia);
	}

	@Test
	public void test02Atualizar() {
		System.out.println("atualizar");
		pais.setArea(555);
		copia.setArea(555);
		PaisService service = new PaisService();
		service.atualizar(pais);
		pais = service.carregar(pais.getId());
		assertEquals(pais, copia);
	}

	@Test
	public void test03Excluir() {
		System.out.println("Excluir");
		Pais vazio = new Pais();
		PaisService service = new PaisService();
		service.excluir(pais);
		pais = service.carregar(pais.getId());
		assertEquals(pais, vazio);
	}

	@Test
	public void test05MaiorPais() {
		PaisService service = new PaisService();
		service.criar(pais);
		Pais novo = new Pais(3, "Estados Unidos",328700000, 9371174);
		service.criar(novo);
		Pais maior = new Pais();

		maior = service.maiorPais(maior);
		assertEquals(maior.getNome(), "China");
		assertEquals(maior.getPopulacao(), 1394550000);
	}

	@Test
	public void test06TresPaises() {
		PaisService service = new PaisService();
		Pais[] paises = new Pais[3];
		for(int i = 0; i < 3; i++) {
			paises[i] = new Pais();
		}
		paises = service.tresPaises(paises);
		assertEquals(1, paises[0].getId());
		assertEquals("China", paises[0].getNome());
		assertEquals(2, paises[1].getId());
		assertEquals("India", paises[1].getNome());
		assertEquals(3, paises[2].getId());
		assertEquals("Estados Unidos", paises[2].getNome());

	}

	@Test
	public void test07MenorArea() {
		PaisService service = new PaisService();
		Pais menor = new Pais();
		menor = service.menorArea(menor);
		assertEquals(menor.getNome(), "Paquistao");
		assertEquals(menor.getArea(), 796095, delta);
	}

}