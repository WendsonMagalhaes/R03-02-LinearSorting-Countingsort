package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 * 
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		int max = 0;
		if (array.length != 0) {
			max = -10000;
		}
		Integer[] result = new Integer[array.length];

		for (Integer e : array) {
			if (e >= max) {
				max = e;
			}
		}
		int[] count = new int[max + 1];
		for (int i = 0; i < count.length; i++) {
			count[i] = 0;
		}

		for (int j = 0; j < array.length; j++) {
			count[array[j]] = count[array[j]] + 1;
		}
		for (int k = 1; k < count.length; k++) {
			count[k] = count[k] + count[k - 1];
		}
		for (int l = array.length ; l > 0; l--) {
			result[count[array[l - 1]] - 1] = array[l - 1];
			count[array[l - 1]] = count[array[l - 1]] - 1;
		}
		for (int m = 0; m < array.length; m++) {
			array[m] = result[m];
		}
	}

}
