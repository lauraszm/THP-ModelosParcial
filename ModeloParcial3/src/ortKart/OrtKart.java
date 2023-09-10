package ortKart;

import java.util.Scanner;

public class OrtKart {
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		final char FINAL_ABRUPTO ='F', KART_ROJO = 'R', KART_VERDE = 'V';
		final int MAXIMO_VUELTAS = 5;
		int contVueltasR = 0, contVueltasV = 0, pianitoR = 0, pianitoV = 0, pianito = 0;
		char karting;
		double promedioPianitoV, promedioPianitoR;
		do {
			System.out.println("Ingrese el karting que finalizo la vuelta, 'F' para finalizar abruptamente");
			karting = Character.toUpperCase(input.nextLine().charAt(0));
		} while (karting != FINAL_ABRUPTO && karting != KART_ROJO && karting != KART_VERDE);
		
		while (karting != FINAL_ABRUPTO && contVueltasR < MAXIMO_VUELTAS && contVueltasV < MAXIMO_VUELTAS) {
			do {				
				System.out.println("Ingrese las veces que piso el pianito el karting " + karting);
				pianito = Integer.parseInt(input.nextLine());
			} while (pianito < 0);
			
			switch (karting) {
			case 'R':
				contVueltasR++;
				pianitoR += pianito;
				break;
			case 'V':
				contVueltasV++;
				pianitoV += pianito;
				break;
			default:
				System.out.println("Ingrese una opcion valida");
			}
			if (contVueltasR < MAXIMO_VUELTAS && contVueltasV < MAXIMO_VUELTAS) {			
				do {					
					System.out.println("Ingrese el karting que finalizo la vuelta, 'F' para finalizar abruptamente");
					karting = Character.toUpperCase(input.nextLine().charAt(0));
				} while (karting != FINAL_ABRUPTO && karting != KART_ROJO && karting != KART_VERDE);
			}
		}
		promedioPianitoR = (double) pianitoR / contVueltasR;
		promedioPianitoV = (double) pianitoV / contVueltasV;
				
				
		if (karting == FINAL_ABRUPTO) {
			System.out.println("final abrupto - ganador indefinido");
		}
		if (contVueltasR == MAXIMO_VUELTAS && contVueltasR > contVueltasV) {
			System.out.println("El ganador es el karting rojo");
		}
		if (contVueltasV == MAXIMO_VUELTAS && contVueltasV > contVueltasR) {
			System.out.println("El ganador es el karting verde");
		}
		if (karting != FINAL_ABRUPTO) {			
			if (promedioPianitoR < promedioPianitoV) {
				System.out.println("El karting rojo piso en promedio menos veces el pianito");
			} else if (promedioPianitoR > promedioPianitoV) {
				System.out.println("El karting verde piso en promedio menos veces el pianito");
			} else {
				System.out.println("El promedio de pisar el pianito fue el mismo");
			}
		}
	}

}
