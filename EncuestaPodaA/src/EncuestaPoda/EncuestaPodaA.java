package EncuestaPoda;

import java.util.Scanner;

public class EncuestaPodaA {
	
	public static final Scanner input = new Scanner (System.in);
	public static void main(String[] args) {
		final char VOTO_SI = 'S', VOTO_NO = 'N', VOTO_BLANCO = 'B', SALIR = 'F';
		boolean votoValido;
		int edad, acumEdades = 0, contVotoSi = 0, contVotoNo = 0, contVotoBlanco = 0, totalVotos = 0;
		double porcentajeNo, promedioEdad;
		char voto;
		String opcionGanadora;
		
		do {
			System.out.println("Ingrese la edad del votante");
			edad = Integer.parseInt(input.nextLine());
		} while (edad <= 18 || edad > 120);
		do {
			System.out.println("Desea que poden los arboles? Ingrese su voto - F para salir");
			voto = Character.toUpperCase(input.nextLine().charAt(0));
			votoValido = voto == VOTO_SI || voto == VOTO_NO || voto == VOTO_BLANCO || voto == SALIR;
		} while (!votoValido);
		
		while (voto != SALIR) {
			acumEdades += edad;
			if (voto == VOTO_SI) {
				contVotoSi++;
			} else if (voto == VOTO_NO) {
				contVotoNo++;
			} else {
				contVotoBlanco++;
			}
			do {
				System.out.println("Ingrese la edad del votante");
				edad = Integer.parseInt(input.nextLine());
			} while (edad <= 18 || edad > 120);
			do {
				System.out.println("Desea que poden los arboles? Ingrese su voto - F para salir");
				voto = Character.toUpperCase(input.nextLine().charAt(0));
				votoValido = voto == VOTO_SI || voto == VOTO_NO || voto == VOTO_BLANCO || voto == SALIR;
			} while (!votoValido);
		}
		
		totalVotos = contVotoSi + contVotoNo + contVotoBlanco;
		porcentajeNo = (double) contVotoNo * 100 / totalVotos;
		promedioEdad = (double) acumEdades / totalVotos;
		
		if (contVotoSi > contVotoNo && contVotoSi > contVotoBlanco) {
			opcionGanadora = "Si";
		} else if (contVotoNo > contVotoBlanco) {
			opcionGanadora = "No";
		} else {
			opcionGanadora = "Indeterminado";
		}
		
		System.out.println("Ganador: " + opcionGanadora);
		System.out.println("Porcentaje de votos negativos: " + porcentajeNo);
		System.out.println("Promedio edad votantes: " + promedioEdad);
		
			
		
		input.close();
	}

}
