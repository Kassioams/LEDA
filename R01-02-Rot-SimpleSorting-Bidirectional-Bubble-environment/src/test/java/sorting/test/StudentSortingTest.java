package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> bubble;
	public AbstractSorting<Integer> insertion;
	public AbstractSorting<Integer> selection;
	public AbstractSorting<Integer> bidiBubble;
	public AbstractSorting<Integer> recurBubble;
	public AbstractSorting<Integer> recurSelection;
	
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
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de null
		this.bubble = new BubbleSort<Integer>();
		this.insertion = new InsertionSort<Integer>();
		this.selection = new SelectionSort<Integer>();
		this.bidiBubble = new BidirectionalBubbleSort<Integer>();
		this.recurBubble = new RecursiveBubbleSort<Integer>();
		this.recurSelection = new RecursiveSelectionSort<Integer>();
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
	
	// TESTES BUBBLE SORT

	public void genericTestBubbleSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		bubble.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testBubbleSort01() {
		genericTestBubbleSort(vetorTamPar);
	}

	@Test
	public void testBubbleSort02() {
		genericTestBubbleSort(vetorTamImpar);
	}

	@Test
	public void testBubbleSort03() {
		genericTestBubbleSort(vetorVazio);
	}

	@Test
	public void testBubbleSort04() {
		genericTestBubbleSort(vetorValoresIguais);
	}

	@Test
	public void testBubbleSort05() {
		genericTestBubbleSort(vetorValoresRepetidos);
	}
	
	

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	
	// TESTE INSERTION SORT
	
	public void genericTestInsertionSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		insertion.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testInsertionSort01() {
		genericTestInsertionSort(vetorTamPar);
	}

	@Test
	public void testInsertionSort02() {
		genericTestInsertionSort(vetorTamImpar);
	}

	@Test
	public void testInsertionSort03() {
		genericTestInsertionSort(vetorVazio);
	}

	@Test
	public void testInsertionSort04() {
		genericTestInsertionSort(vetorValoresIguais);
	}

	@Test
	public void testInsertionSort05() {
		genericTestInsertionSort(vetorValoresRepetidos);
	}
	
	// TESTE SELECTION SORT
	public void genericTestSelectionSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		selection.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSelectionSort01() {
		genericTestSelectionSort(vetorTamPar);
	}

	@Test
	public void testSelectionSort02() {
		genericTestSelectionSort(vetorTamImpar);
	}

	@Test
	public void testSelectionSort03() {
		genericTestSelectionSort(vetorVazio);
	}

	@Test
	public void testSelectionSort04() {
		genericTestSelectionSort(vetorValoresIguais);
	}

	@Test
	public void testSelectionSort05() {
		genericTestSelectionSort(vetorValoresRepetidos);
	}
	
	// TESTE BIDIRECTIONAL BUBBLE SORT
	public void genericTestRecurviseBubbleSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		bidiBubble.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testBidiBubbleSort01() {
		genericTestRecurviseBubbleSort(vetorTamPar);
	}

	@Test
	public void testBidiBubbleSort02() {
		genericTestRecurviseBubbleSort(vetorTamImpar);
	}

	@Test
	public void testBidiBubbleSort03() {
		genericTestRecurviseBubbleSort(vetorVazio);
	}

	@Test
	public void testBidiBubbleSort04() {
		genericTestRecurviseBubbleSort(vetorValoresIguais);
	}

	@Test
	public void testBidiBubbleSort05() {
		genericTestRecurviseBubbleSort(vetorValoresRepetidos);
	}
	
	// TEST RECURSIVE BUBBLE SORT
	public void genericTestRecursiveBubbleSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		recurBubble.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testRecursiveBubbleSort01() {
		genericTestRecursiveBubbleSort(vetorTamPar);
	}

	@Test
	public void testRecursiveBubbleSort02() {
		genericTestRecursiveBubbleSort(vetorTamImpar);
	}

	@Test
	public void testRecursiveBubbleSort03() {
		genericTestRecursiveBubbleSort(vetorVazio);
	}

	@Test
	public void testRecursiveBubbleSort04() {
		genericTestRecursiveBubbleSort(vetorValoresIguais);
	}

	@Test
	public void testRecursiveBubbleSort05() {
		genericTestRecursiveBubbleSort(vetorValoresRepetidos);
	}
	
	// TESTE RECURSIVE SELECTION SORT
	public void genericTestRecursiveSelectionSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		recurSelection.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testRecursiveSelectionSort01() {
		genericTestRecursiveBubbleSort(vetorTamPar);
	}

	@Test
	public void testRecursiveSelectionSort02() {
		genericTestRecursiveBubbleSort(vetorTamImpar);
	}

	@Test
	public void testRecursiveSelectionSort03() {
		genericTestRecursiveBubbleSort(vetorVazio);
	}

	@Test
	public void testRecursiveSelectionSort04() {
		genericTestRecursiveBubbleSort(vetorValoresIguais);
	}

	@Test
	public void testRecursiveSelectionSort05() {
		genericTestRecursiveBubbleSort(vetorValoresRepetidos);
	}
}