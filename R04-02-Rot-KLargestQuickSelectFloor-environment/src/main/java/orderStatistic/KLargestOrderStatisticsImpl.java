package orderStatistic;

import java.util.ArrayList;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{
	
	@Override
	public T[] getKLargest(T[] array, int k) {
		if(k > 0 && array.length != 0 && k < array.length) {
			T menor = orderStatistics(array, 1); 
			T[] arrayMaioresElementos = (T[]) new Comparable[k];
			Integer[] indicesMaiores = new Integer[k];
		
			
			for(int j = 0; j < k; j++) {
				int indiceMaior  = 0;
				T valorMaior = menor;
				boolean saida = false;
				for(int i = 0; i < array.length; i++) {
					saida = false;
					for(int l = 0; l < indicesMaiores.length; l++) {
						if(indicesMaiores[l] != null) {
							if(i == indicesMaiores[l]) {
								saida = true;
								break;
							}
						}
					}
					if (saida) {
						continue;
					}
					if (array[i].compareTo(valorMaior) > 0) {
						indiceMaior = i;
						valorMaior = array[i];
					}
				}
				indicesMaiores[j] = indiceMaior;
				indiceMaior = 0;
				valorMaior = menor;
			}
			for(int i = 0; i < k; i++) {
				arrayMaioresElementos[i] = array[indicesMaiores[i]];
			}
			return arrayMaioresElementos;
		}else {
			return (T[]) new Comparable[0];
		}
		
	}

	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		if(k  > 0 && k <= array.length) {
			T menor = array[0];
			T maior = array[0];
			
			for(T i : array) {
				if(i.compareTo(menor) < 0) {
					menor = i;
				}
				if(i.compareTo(maior) > 0) {
					maior = i;
				}
			}
			if(k == 1) {
				return menor;
			} else {
				return orderStatistics(array, k-1, maior, menor);
			}
		} else {
			return null;
		}	
	}

	private T orderStatistics(T[] array, int k, T maiorArray, T menorAnterior) {
		T menor = maiorArray;
		for(T i : array) {
			if(i.compareTo(menor) < 0 && i.compareTo(menorAnterior) > 0) {
				menor = i;
			}
		}
		if(k == 1) {
			return menor;
		} else {
			return orderStatistics(array, k-1, maiorArray, menor);
		}
	}
}
