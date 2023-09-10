package NumerosMalvados;
import java.util.Scanner;

public class NumerosMalvados {

	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int num, contNums =0, primerNum = 0, segundoNum = 0, acumMayores = 0, contMayores =0;
		int aux, resultado, resto, cant1s = 0, contMalvados=0, mayorMalvado = 0, productoria = 1;
		do {
			System.out.println("Ingrese un numero positivo, 0 para salir");
			num = Integer.parseInt(input.nextLine());
		} while (num < 0);
		
		while (num != 0) {
			contNums++;
			if(contNums == 1) {
				primerNum = num;
			} else if (contNums == 2) {
				segundoNum = num;
			}
			 if (contNums > 2 && num > primerNum && num > segundoNum) {
				 acumMayores+=num;
				 contMayores++;
			 }
			
			aux = num;
			cant1s = 0;
			do {
				resultado = aux / 2;
				resto = aux % 2;
				if (resto == 1) {
					cant1s++;
				}
				aux = resultado;
			} while (resultado > 0);
			
			if (cant1s % 2 == 0) {
				System.out.println(num + " es un numero malvado");
				contMalvados++;
				if (num > mayorMalvado) {
					mayorMalvado = num;
				}
			}
			
			for (int i = 1; i <= num; i++) {
				productoria = productoria * i;
			}
			 
			do {
				System.out.println("Ingrese un numero positivo, 0 para salir");
				num = Integer.parseInt(input.nextLine());
			} while (num < 0);
		}
		
		System.out.println("Cantidad de numeros malvados: " + contMalvados);
		System.out.println("Mayor numero malvado:" + mayorMalvado);
		
		if (contNums > 2 ) {
			System.out.println("Promedio de numeros mayores a los dos primeros ingresados: " + (acumMayores / contMayores));
		}

		input.close();	
	
	}

}
