package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex <  array.length && leftIndex >=0) {
			int maior = 0;

			for (int i : array) {
				if (i > maior) {
					maior = i;
				}
			}

			int[] arrayOrdenacao = new int[maior + 1];
			int[] arrayFinal = new int[rightIndex - leftIndex + 1];
			Arrays.fill(arrayOrdenacao, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayOrdenacao[array[i]]++;
			}

			for (int i = 0; i < arrayOrdenacao.length - 1; i++) {
				arrayOrdenacao[i + 1] += arrayOrdenacao[i];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayFinal[--arrayOrdenacao[array[i]]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayFinal[i - leftIndex];
			}
		}
	}
}