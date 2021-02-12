package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.linearSorting.CountingSort;
import sorting.linearSorting.ExtendedCountingSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;
	
	public AbstractSorting<Integer> countingSort;
	public AbstractSorting<Integer> extendedCountingSort;
	

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		getImplementation();
	}

	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		this.extendedCountingSort = new ExtendedCountingSort();
		this.countingSort = new CountingSort();
		}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
		}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
		}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
		}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
		}

	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericCountingSortTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
			}
		countingSort.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
		}

	@Test
	public void testCountingSort01() {
		genericCountingSortTest(vetorTamPar);
	}

	@Test
	public void testCountingSort02() {
		genericCountingSortTest(vetorTamImpar);
	}

	@Test
	public void testCountingSort03() {
		genericCountingSortTest(vetorVazio);
	}

	@Test
	public void testCountingSort04() {
		genericCountingSortTest(vetorValoresIguais);
	}

	@Test
	public void testCountingSort05() {
		genericCountingSortTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	public void genericExtendedCountingSortTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
			}
		extendedCountingSort.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
		}

	@Test
	public void testExtendedCountingSort01() {
		genericCountingSortTest(vetorTamPar);
	}

	@Test
	public void testExtendedCountingSort02() {
		genericCountingSortTest(vetorTamImpar);
	}

	@Test
	public void testExtendedCountingSort03() {
		genericCountingSortTest(vetorVazio);
	}

	@Test
	public void testExtendedCountingSort04() {
		genericCountingSortTest(vetorValoresIguais);
	}

	@Test
	public void testExtendedCountingSort05() {
		genericCountingSortTest(vetorValoresRepetidos);
	}
}