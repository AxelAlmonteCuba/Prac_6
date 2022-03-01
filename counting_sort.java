package orden;

import java.util.Arrays;

public class CountingSort {

	void countSort(int array[], int tamaño) {
	    int[] resultado = new int[tamaño + 1];

	    int maximo = array[0];
	    for (int i = 1; i < tamaño; i++) {
	      if (array[i] > maximo)
	        maximo = array[i];
	    }
	    int[] conteo = new int[maximo + 1];

	    for (int i = 0; i < maximo; ++i) {
	      conteo[i] = 0;
	    }

	    for (int i = 0; i < tamaño; i++) {
	      conteo[array[i]]++;
	    }

	    for (int i = 1; i <= maximo; i++) {
	      conteo[i] += conteo[i - 1];
	    }

	    for (int i = tamaño - 1; i >= 0; i--) {
	      resultado[conteo[array[i]] - 1] = array[i];
	      conteo[array[i]]--;
	    }

	    for (int i = 0; i < tamaño; i++) {
	      array[i] = resultado[i];
	    }
	  }
	  public static void main(String args[]) {
	    int[] array = { 4, 2, 2, 8, 3, 3, 1 };
	    int tanaño = array.length;
	    CountingSort cs = new CountingSort();
	    cs.countSort(array, tanaño);
	    System.out.println("Matriz ordenada en orden ascendente: ");
	    System.out.println(Arrays.toString(array));
	  }
	}
