package autopistas;

import java.util.Scanner;

public class Autopistas {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		final int SALIR = 0, CANT_TURNOS = 3;
		int autopista, cantCabinas, numCabina, cabinaMayorRecaudacion = 0, autopistaMaxRecaudacion = 0;
		double promedioPorTurno, acumGralTurno1 = 0, acumGralTurno2 = 0, acumGralTurno3 = 0, acumRecaudadoTurno1 = 0, acumRecaudadoTurno2 = 0, acumRecaudadoTurno3 = 0, totalRecaudadoAutopista = 0, mayorRecaudacion = 0, totalRecaudadoCabina, acumTotalGeneral = 0, maxRecaudacionAutopista = 0;  
		boolean numCabinaValido;
		
		do {
			System.out.println("Ingrese el numero de autopista, 0 para salir");
			autopista = Integer.parseInt(input.nextLine());
		} while (autopista <= SALIR);
		
		while (autopista != SALIR) {
			do {				
				System.out.println("Ingrese la cantidad de cabinas de la autopista " + autopista);
				cantCabinas = Integer.parseInt(input.nextLine());
			} while (cantCabinas <= 0);
			for (int i =0; i < cantCabinas; i++) {
				acumRecaudadoTurno1 = 0;
				acumRecaudadoTurno2 = 0;
				acumRecaudadoTurno3 = 0; 
				totalRecaudadoAutopista = 0; 
				mayorRecaudacion = 0;
				
				do {
					System.out.println("Ingrese numero de cabina");
					numCabina = Integer.parseInt(input.nextLine());
					numCabinaValido = numCabina > 0 && numCabina <= cantCabinas;
				} while (!numCabinaValido);
				
				for (int j = 0; j < CANT_TURNOS; j++) {
					do {						
						System.out.println("Ingrese lo recaudado por la cabina " + numCabina + "en el turno " + (j+1));
						totalRecaudadoCabina = Integer.parseInt(input.nextLine());
					} while (totalRecaudadoCabina < 0);
					switch (j+1) {
					case 1:
						acumRecaudadoTurno1+=totalRecaudadoCabina;
						acumGralTurno1 += totalRecaudadoCabina;
						break;
					case 2:
						acumRecaudadoTurno2+=totalRecaudadoCabina;
						acumGralTurno2 += totalRecaudadoCabina;
						break;
					case 3:
						acumRecaudadoTurno3+=totalRecaudadoCabina;
						acumGralTurno3 += totalRecaudadoCabina;
						break;
					}
				}
				
				totalRecaudadoAutopista = acumRecaudadoTurno1 + acumRecaudadoTurno2 + acumRecaudadoTurno3;
				acumTotalGeneral+=totalRecaudadoAutopista;
				if (totalRecaudadoAutopista > mayorRecaudacion) {
					cabinaMayorRecaudacion = numCabina;
				}
				if (totalRecaudadoAutopista > maxRecaudacionAutopista) {
					autopistaMaxRecaudacion = autopista;
					maxRecaudacionAutopista = totalRecaudadoAutopista;
				}
				
			}
			System.out.println("Total recaudado por autopista " + autopista + ": " + totalRecaudadoAutopista);
			System.out.println("La cabina que mas recaudo fue " + cabinaMayorRecaudacion);
			do {
				System.out.println("Ingrese el numero de autopista, 0 para salir");
				autopista = Integer.parseInt(input.nextLine());
			} while (autopista > SALIR);
		}
		
		promedioPorTurno = acumTotalGeneral / CANT_TURNOS;
		System.out.println("Total recaudado general" + acumTotalGeneral);
		System.out.println("Autopista con mas recaudacion: " + autopistaMaxRecaudacion + "y total recaudado: " + maxRecaudacionAutopista );
		System.out.println("El promedio por cada turno fue de " + promedioPorTurno);	
			
		input.close();
	}
}
