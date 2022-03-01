import java.util.Arrays;

public class RadixSort {

	  void countingSort(int arreglo[], int tamaño, int posicion) {
		  int[] salida = new int[tamaño + 1];
		  int max = arreglo[0];
		  for (int i = 1; i < tamaño; i++) {
			  if (arreglo[i] > max)
				  max = arreglo[i];
		  }
		  int[] contador = new int[max + 1];

		  for (int i = 0; i < max; ++i)
			  contador[i] = 0;

		  for (int i = 0; i < tamaño; i++)
			  contador[(arreglo[i] / posicion) % 10]++;

		  for (int i = 1; i < 10; i++)
			  contador[i] += contador[i - 1];

		  for (int i = tamaño - 1; i >= 0; i--) {
			  salida[contador[(arreglo[i] / posicion) % 10] - 1] = arreglo[i];
			  contador[(arreglo[i] / posicion) % 10]--;
		  }

		  for (int i = 0; i < tamaño; i++)
			  arreglo[i] = salida[i];
	  }

	  int getMax(int arreglo[], int n) {
		  int max = arreglo[0];
		  for (int i = 1; i < n; i++)
			  if (arreglo[i] > max)
				  max = arreglo[i];
		  return max;
	  }

	  void radixSort(int arreglo[], int size) {
		  int max = getMax(arreglo, size);

		  for (int place = 1; max / place > 0; place *= 10)
			  countingSort(arreglo, size, place);
	  }

	  public static void main(String args[]) {
		  
		  int[] datos = { 121, 432, 564, 23, 1, 45, 788 };
		  int tamaño = datos.length;
		  RadixSort rs = new RadixSort();
		  rs.radixSort(datos, tamaño);
		  System.out.println("Arreglo ordenada en orden ascendente: ");
		  System.out.println(Arrays.toString(datos));
	  }
}
