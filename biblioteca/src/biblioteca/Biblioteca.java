package biblioteca;

import java.util.Scanner;

public class Biblioteca {

	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		final String FIN = "FIN";
		final char INFANTIL = 'I', NOVELA = 'N', HISTORIA = 'H';
		final int CANT_ESTANTES = 5;
		String nombre, libroMasPags = "";
		char genero;
		int cantPags, mayorCantPags = 0, contI = 0, contN = 0, contH = 0, totalLibros;
		double promedio;
		boolean nombreValidado, generoValidado;
				
		for (int i = 0; i < CANT_ESTANTES; i++) {
			
			// llevo estas variables as 0 para que no se comparen libros entre estantes
			mayorCantPags = 0;
			libroMasPags = "";
			
			do {
				System.out.println("Ingrese el nombre del libro. 'FIN' para salir");
				nombre = input.nextLine();
			} while (nombre == null);
			
			while(!nombre.equalsIgnoreCase(FIN)) {				
				do {
					System.out.println("Ingrese el genero del libro, 'I', 'N', o 'H'");
					genero = Character.toUpperCase(input.nextLine().charAt(0));
					generoValidado = genero == INFANTIL || genero == NOVELA || genero == HISTORIA;
				} while (!generoValidado);
						
				do {
					System.out.println("Ingrese la cantidad de paginas del libro " + nombre);
					cantPags = Integer.parseInt(input.nextLine());
				} while (cantPags <= 0);
				
				switch(genero) {
					case 'I':
						contI++;
						break;
					case 'N':
						contN++;
						break;
					case 'H':
						contH++;
						break;
				}
				
				if (cantPags > mayorCantPags) {
					mayorCantPags = cantPags;
					libroMasPags = nombre;
				}
				
				do {
					System.out.println("Ingrese el nombre del libro. 'FIN' para salir");
					nombre = input.nextLine();
					nombreValidado = nombre != null && nombre != FIN;
				} while (!nombreValidado);
			}
			
			System.out.println("Estante " + (i+1));
			if (mayorCantPags > 0) {				
				System.out.println("Libro con mas paginas: " + libroMasPags);
				System.out.println("Paginas del libro " + libroMasPags + ": " + mayorCantPags);
			}
			
		}
		
		totalLibros = contI + contN + contH;
		promedio = (double) totalLibros / CANT_ESTANTES;
		
		System.out.println("Libros infantiles: " + contI);
		System.out.println("Novelas: " + contN);
		System.out.println("Libros de historia: " + contH);
		System.out.println("Promedio libros por estante: " + promedio);
		
		input.close();

	}

}
