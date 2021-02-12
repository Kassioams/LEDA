package sorting.linearSorting;

import java.util.Arrays;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex && rightIndex <  array.length && leftIndex >= 0) {
			int maior = 0;
			int menor = 0;

			for (int i : array) {
				if (i > maior) {
					maior = i;
				}
				if (i < menor) {
					menor = i;
				}
			}

			int[] arrayOrdenacao = new int[maior - menor + 1];
			int[] arrayFinal = new int[rightIndex - leftIndex + 1];
			Arrays.fill(arrayOrdenacao, 0);

			for (int i = leftIndex; i <= rightIndex; i++) {
				arrayOrdenacao[array[i] - menor]++;
			}

			for (int i = 0; i < arrayOrdenacao.length - 1; i++) {
				arrayOrdenacao[i + 1] += arrayOrdenacao[i];
			}

			for (int i = rightIndex; i >= leftIndex; i--) {
				arrayFinal[--arrayOrdenacao[array[i] - menor]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = arrayFinal[i - leftIndex];
			}
		}
	}
}