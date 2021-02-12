package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.divideAndConquer.MergeSort;
import sorting.divideAndConquer.QuickSort;
import sorting.divideAndConquer.hybridMergesort.HybridMergeSort;
import sorting.divideAndConquer.quicksort3.QuickSortMedianOfThree;

public class StudentSortingTest {

	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	public AbstractSorting<Integer> mergeSort;
	public AbstractSorting<Integer> quickSort;
	public AbstractSorting<Integer> hybridMergeSort;
	public AbstractSorting<Integer> quickSortMedian;

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
		this.mergeSort = new MergeSort<>();
		this.quickSort = new QuickSort<>();
		this.hybridMergeSort = new HybridMergeSort<>();
		this.quickSortMedian = new QuickSortMedianOfThree<>();

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

	// TESTE MERGE SORT
	public void genericTestMergeSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		mergeSort.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testMergeSort01() {
		genericTestMergeSort(vetorTamPar);
	}

	@Test
	public void testMergeSort02() {
		genericTestMergeSort(vetorTamImpar);
	}

	@Test
	public void testMergeSort03() {
		genericTestMergeSort(vetorVazio);
	}

	@Test
	public void testMergeSort04() {
		genericTestMergeSort(vetorValoresIguais);
	}

	@Test
	public void testMergeSort05() {
		genericTestMergeSort(vetorValoresRepetidos);
	}

	// TESTE QUICK SORT
	
	public void genericTestQuickSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		quickSort.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testQuickSort01() {
		genericTestQuickSort(vetorTamPar);
	}

	@Test
	public void testQuickSort02() {
		genericTestQuickSort(vetorTamImpar);
	}

	@Test
	public void testQuickSort03() {
		genericTestQuickSort(vetorVazio);
	}

	@Test
	public void testQuickSort04() {
		genericTestQuickSort(vetorValoresIguais);
	}

	@Test
	public void testQuickSort05() {
		genericTestQuickSort(vetorValoresRepetidos);
	}

	// TESTE HYBRID MERGE SORT
	
	public void genericTestHybridMergeSort(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		hybridMergeSort.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testHybridMergeSort01() {
		genericTestQuickSortMedian(vetorTamPar);
	}

	@Test
	public void testHybridMergeSort02() {
		genericTestQuickSortMedian(vetorTamImpar);
	}

	@Test
	public void testHybridMergeSort03() {
		genericTestQuickSortMedian(vetorVazio);
	}

	@Test
	public void testHybridMergeSort04() {
		genericTestQuickSortMedian(vetorValoresIguais);
	}

	@Test
	public void testHybridMergeSortn05() {
		genericTestQuickSortMedian(vetorValoresRepetidos);
	}
	
	// TESTE QUICK SORT MEDIAN OF THREE
	
	public void genericTestQuickSortMedian(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);			
		}
		quickSortMedian.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testQuickSortMedian01() {
		genericTestQuickSortMedian(vetorTamPar);
	}

	@Test
	public void testQuickSortMedian02() {
		genericTestQuickSortMedian(vetorTamImpar);
	}

	@Test
	public void testQuickSortMedian03() {
		genericTestQuickSortMedian(vetorVazio);
	}

	@Test
	public void testQuickSortMedian04() {
		genericTestQuickSortMedian(vetorValoresIguais);
	}

	@Test
	public void testQuickSortMedian05() {
		genericTestQuickSortMedian(vetorValoresRepetidos);
	}
	
}