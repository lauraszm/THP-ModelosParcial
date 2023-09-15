package parcial1THP;

import java.util.Scanner;

public class Parcial1THP {

	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {

		final int SALIR = 0, MAX = 100;
		int numActual, numAnterior = 0, contMesetas = 0, digitoMesetaMasLarga = 0, contDigitosMeseta = 1, contDigitosMayorMeseta = 0; 
		//se inicializa numAnterior para evitar errores de compilacion
		//se inicia el contDigitosMeseta en 1 porque donde encuentra el primer repetido, ya son 2 digitos
		String concatMesetas = "";
		boolean numValidado, hayMeseta = false;

		//dos lecturas anticipadas para conseguir primer y segundo numero para comparar
		do {			
			System.out.println("Ingrese un numero de 1 a 100, 0 para salir");
			numActual = Integer.parseInt(input.nextLine());
			numValidado = numActual >=SALIR && numActual <=MAX;
		} while (!numValidado);
		
		//solo pedimos el segundo numero si el primero no es SALIR
		if (numActual > SALIR) {			
			do {			
				System.out.println("Ingrese un numero de 1 a 100, 0 para salir");
				numAnterior = Integer.parseInt(input.nextLine());
				numValidado = numAnterior >=SALIR && numAnterior <=MAX;
			} while (!numValidado);
		}

		while (numActual > SALIR) {
			
			//si hayMeseta es true quiere decir que ya hay acumulandose meseta asi que no sumamos al contador de mesetas
			if (numActual == numAnterior && hayMeseta) {
				hayMeseta = true;
				contDigitosMeseta++;
				numAnterior = numActual;
				if (contDigitosMeseta > contDigitosMayorMeseta) {
					digitoMesetaMasLarga = numActual;
					contDigitosMayorMeseta = contDigitosMeseta;
				}
			} 
			//si hayMeseta es false es una meseta nueva
			else if (numActual == numAnterior && !hayMeseta) {
				contMesetas++;
				hayMeseta = true;
				numAnterior = numActual;
				contDigitosMeseta++;
				if (contDigitosMeseta > contDigitosMayorMeseta) {
					digitoMesetaMasLarga = numActual;
					contDigitosMayorMeseta = contDigitosMeseta;
				}
			} 
			//donde no hay meseta llevamos el booleano a false y reiniciamos el contador de digitos de la meseta
			else if (numActual != numAnterior) {
				numAnterior = numActual;
				hayMeseta = false;
				contDigitosMeseta = 1;
			}
			
			//necesitamos una sola lectura ahora
			do {			
				System.out.println("Ingrese un numero de 1 a 100, 0 para salir");
				numActual = Integer.parseInt(input.nextLine());
				numValidado = numActual >=SALIR && numActual <=MAX;
			} while (!numValidado);

		}

		System.out.println("Cantidad de mesetas detectadas: " + contMesetas);
		if (contMesetas > 0) {
			for (int i = 0; i < contDigitosMayorMeseta; i ++) {
				concatMesetas += Integer.valueOf(digitoMesetaMasLarga);
				if (i != (contDigitosMayorMeseta -1)) {
					concatMesetas += "-";
				}
			}
			System.out.println("Meseta de mayor extension: " + concatMesetas);
		}
		
		input.close();
	}

}
