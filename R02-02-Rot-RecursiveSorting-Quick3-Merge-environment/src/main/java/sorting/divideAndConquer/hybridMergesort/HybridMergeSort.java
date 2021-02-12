package sorting.divideAndConquer.hybridMergesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe HybridMergeSort representa a implementação de uma variação do
 * MergeSort que pode fazer uso do InsertionSort (um algoritmo híbrido) da
 * seguinte forma: o MergeSort é aplicado a entradas maiores a um determinado
 * limite. Caso a entrada tenha tamanho menor ou igual ao limite o algoritmo usa
 * o InsertionSort.
 * 
 * A implementação híbrida deve considerar os seguintes detalhes:
 * - Ter contadores das quantidades de MergeSorts e InsertionSorts aplicados, de forma
 *   que essa informação possa ser capturada pelo teste.
 * - A cada chamado do método de sort(T[] array) esses contadores são resetados. E a cada chamada
 *   interna de um merge ou insertion, os contadores MERGESORT_APPLICATIONS e
 *   INSERTIONSORT_APPLICATIONS são incrementados.
 * - O InsertionSort utilizado no algoritmo híbrido deve ser in-place.
 */
public class HybridMergeSort<T extends Comparable<T>> extends AbstractSorting<T> {

	/**
	 * For inputs with size less or equal to this value, the insertionsort
	 * algorithm will be used instead of the mergesort.
	 */
	public static final int SIZE_LIMIT = 4;

	protected static int MERGESORT_APPLICATIONS = 0;
	protected static int INSERTIONSORT_APPLICATIONS = 0;

	public void sort(T[] array, int leftIndex, int rightIndex) {
		MERGESORT_APPLICATIONS = 0;
		INSERTIONSORT_APPLICATIONS = 0;	
		if (array.length <= SIZE_LIMIT) {
			insertion(array, leftIndex, rightIndex);
			INSERTIONSORT_APPLICATIONS ++;
		}
		else {
			int mid = (leftIndex + rightIndex)/2;
			merge(array, leftIndex, mid, rightIndex);
			MERGESORT_APPLICATIONS ++;
		}
		
	}
	private void merge(T[] array, int leftIndex, int mid, int rightIndex) {
		@SuppressWarnings("unchecked")
		T[] copy = (T[]) new Comparable[array.length];
		
		for(int i = 0; i < array.length; i++) {
			copy[i] = array[i];
		}
		
		int i = leftIndex;
		int j = mid +1;
		int k = leftIndex;
		
		while(i <= mid && j <= rightIndex) {
			if(copy[i].compareTo(copy[j]) < 0) {
				array[k] = copy[i++];
			}else {
				array[k] = copy[j++];
			}
			k++;
		}
		while(i <= mid) {
			array[k] = copy[i++];
			k++;
		}
		while(j <= rightIndex) {
			array[k] = copy[j++];
			k++;
		}
	}
	
	private void insertion(T[] array, int leftIndex, int rightIndex) {
		for (int i = leftIndex; i <= rightIndex; i++) {
			int iAtual = i;
			int iAnterior = i - 1;
			while(iAnterior >= leftIndex && (array[iAtual].compareTo(array[iAnterior]) < 0)) {
				Util.swap(array, iAtual, iAnterior);
				iAtual--;
				iAnterior--;
			}
		}
	}
}

