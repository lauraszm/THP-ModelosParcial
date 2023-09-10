package calentamientoGlobal;

import java.util.Scanner;

public class CalentamientoGlobal {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		final int SALIDA = -1;
		int fecha, contIngresos = 0, fechaAnterior, fechaMayorDiferencia = 0;
		double alturaMin, alturaMax, auxAltura, diferencia, mayorDiferencia = 0;
		
		System.out.println("Ingrese la fecha en formato numero de 8 digitos, -1 para salir");
		fecha = Integer.parseInt(input.nextLine());
		
		while (fecha != SALIDA) {
			contIngresos++;
			fechaAnterior = fecha;
			
			do {
				System.out.println("Ingrese la altura minima del dia " + fecha);
				alturaMin = Double.parseDouble(input.nextLine());
			} while (alturaMin < 0);
			do {
				System.out.println("Ingrese la altura maxima del dia " + fecha);
				alturaMax = Double.parseDouble(input.nextLine());
			} while (alturaMax < 0);
			
			if (alturaMax < alturaMin) {
				auxAltura = alturaMax;
				alturaMax = alturaMin;
				alturaMin = auxAltura;
				System.out.println("Altura maxima y minima estaban invertidas, fueron Corregidas para su correcto procesamiento");
			}
			diferencia = alturaMax - alturaMin;
			System.out.println("Datos ingresados:");
			System.out.println("Fecha: " + fecha);
			System.out.println("Altura minima de la fecha " + fecha + ": " + alturaMin);
			System.out.println("Altura maxima de la fecha " + fecha + ": " + alturaMax);
			System.out.println("Diferencia de alturas de la fecha " + fecha + ": " + diferencia);
			
			if (diferencia > mayorDiferencia) {
				mayorDiferencia = diferencia;
				fechaMayorDiferencia = fecha;
			}
			
			do {
				System.out.println("Ingrese la fecha en formato numero de 8 digitos, -1 para salir");
				fecha = Integer.parseInt(input.nextLine());
				if (fecha < fechaAnterior && fecha != SALIDA) {
					System.out.println("la fecha no puede ser menor a la fecha anterior, por favor reingrese");
				}} while (fecha < fechaAnterior && fecha != SALIDA);
				
			}
			
		if(contIngresos >=1) {
			System.out.println("Mayor diferencia registrada: " + mayorDiferencia + " en la fecha " + fechaMayorDiferencia);
		} else {
			System.out.println("Se necesita al menos un dato");
		}
		
		
		
		input.close();
	}

}
