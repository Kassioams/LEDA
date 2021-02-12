package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex){
		if (leftIndex < rightIndex && leftIndex >= 0) {
			int center = (leftIndex + rightIndex) / 2;
			mediana(array, leftIndex, rightIndex, center);
			
			Util.swap(array, center, rightIndex - 1);
			int posiPivot = particiona(array, leftIndex, rightIndex - 1);
			sort(array, leftIndex, posiPivot - 1);
			sort(array, posiPivot + 1, rightIndex);
		}
	}

	private void mediana(T[] array, int leftIndex, int rightIndex,int center) {
		if(array[leftIndex].compareTo(array[rightIndex]) > 0){
			Util.swap(array, leftIndex, rightIndex);
		}
		if(array[center].compareTo(array[leftIndex]) < 0){
			Util.swap(array, center, leftIndex);
		} 
		else if(array[center].compareTo(array[rightIndex]) > 0){
			Util.swap(array, center, rightIndex);
		}
	}
	
	private int particiona(T[] array, int leftIndex, int rightIndex){
		T pivot = array[leftIndex];
		int indiceInicio = leftIndex;
		int indiceFim = leftIndex + 1;
		
		while(indiceFim <= rightIndex){
			if(array[indiceFim].compareTo(pivot) < 0){
				indiceInicio++;
				Util.swap(array, indiceInicio, indiceFim);
			}
			indiceFim++;
		}
		Util.swap(array, leftIndex, indiceInicio);
		return indiceInicio;
	}
}

