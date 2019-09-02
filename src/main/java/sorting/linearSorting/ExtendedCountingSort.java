package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos: - Alocar o tamanho minimo
 * possivel para o array de contadores (C) - Ser capaz de ordenar arrays
 * contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int max = 0;
		int min = 0;
		if (array.length != 0) {
			max = -10000;
			min = 1000000000;
		}
		Integer[] result = new Integer[array.length];

		for (Integer e : array) {
			if (e >= max) {
				max = e;
			}
			if(e <= min) {
				min = e;
			}
		}
		int diff = Math.abs(max - min) + 1 ;
		
		int[] count = new int[diff];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		for (int j = 0; j < array.length; j++) {
			count[array[j] - min] = count[array[j] - min] + 1;
		}
		for (int k = 1; k < count.length; k++) {
			count[k] = count[k] + count[k - 1];
		}
		for (int l = array.length ; l > 0; l--) {
			result[count[array[l - 1] - min] - 1] = array[l - 1];
			count[array[l - 1] - min] = count[array[l - 1] - min] - 1;
		}
		for (int m = 0; m < array.length; m++) {
			array[m] = result[m];
		}
	}

}
