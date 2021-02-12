package sorting.variationsOfSelectionsort;

import sorting.AbstractSorting;
import util.Util;

public class RecursiveSelectionSort<T extends Comparable<T>> extends
AbstractSorting<T> {

	/**
	 * Implementação recursiva do selection sort. Você deve implementar apenas
	 * esse método sem usar nenhum outro método auxiliar (exceto
	 * Util.swap(array,int,int)). Para isso, tente definir o caso base do
	 * algoritmo e depois o caso indutivo, que reduz o problema para uma entrada
	 * menor em uma chamada recursiva. Seu algoritmo deve ter complexidade
	 * quadrática O(n^2).
	 */
	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		recursiveSelectionSort(array, leftIndex, rightIndex, leftIndex);
	}

	public void recursiveSelectionSort(T[] array, int leftIndex, int rightIndex, int i) {
		if( i > rightIndex) {
			return;
		}
		int iMenor = i;
		boolean troca = false;
		for (int j = i+1; j <= rightIndex; j++) {
			if (array[j].compareTo(array[iMenor]) < 0) {
				iMenor = j;
				troca = true;
			}
		}
		if (troca) {
			Util.swap(array, i, iMenor);
		}
		recursiveSelectionSort(array, leftIndex, rightIndex, i+1);
	}
}
