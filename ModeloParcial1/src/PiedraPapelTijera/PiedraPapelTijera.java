package PiedraPapelTijera;
import java.util.Scanner;

public class PiedraPapelTijera {
	public static final Scanner input = new Scanner(System.in);
	final static String PIEDRA = "Piedra", PAPEL = "papel", TIJERA = "tijera";

	public static void main(String[] args) {
		int puntajeMaximo, puntosAna = 0, puntosBartolo = 0;
		String opcionAna, opcionBartolo;
//		do {			
//			System.out.println("Ingrese la cantidad de puntos a la que van a jugar");
//			puntajeMaximo = Integer.parseInt(input.nextLine());
//		} while(puntajeMaximo <= 0);
		
		puntajeMaximo = ingresarYvalidarNumeroPositivo("Ingrese la cantidad de puntos a la que van a jugar");
		
		do {			
			opcionAna = ingresarOpcionJuego(PIEDRA, PAPEL, TIJERA);
			opcionBartolo = ingresarOpcionJuego(PIEDRA, PAPEL, TIJERA);
			
			if (opcionAna.equalsIgnoreCase(TIJERA) && opcionBartolo.equalsIgnoreCase(PAPEL) || opcionAna.equalsIgnoreCase(PAPEL) && opcionBartolo.equalsIgnoreCase(PIEDRA) || opcionAna.equalsIgnoreCase(PIEDRA) && opcionBartolo.equalsIgnoreCase(TIJERA)) {
				puntosAna++;
				System.out.println("Punto para Ana");
			} else if (!opcionAna.equalsIgnoreCase(opcionBartolo)) {
				puntosBartolo++;
				System.out.println("Punto para bartolo");
			} else {
				System.out.println("Empate");
			}
		
		
		} while (puntosAna < puntajeMaximo && puntosBartolo < puntajeMaximo);
		
		if (puntosAna == puntajeMaximo) {
			System.out.println("Gano Ana con " + puntosAna + " puntos");
		} else {
			System.out.println("Gano Bartolo con " + puntosBartolo + " puntos");
		}
		
		input.close();
	}
	
	public static int ingresarNumeroEntero(String mensaje) {
		int num;
		System.out.println(mensaje);
		num = Integer.parseInt(input.nextLine());
		return num;
	}
	
	public static int ingresarYvalidarNumeroPositivo(String mensaje) {
		int num;
		do {			
			num = ingresarNumeroEntero("Ingrese la cantidad de puntos a la que van a jugar");
		} while(num <= 0);
		return num;
	}
	
	public static String ingresarStringMinuscula(String mensaje) {
		String texto;
		System.out.println(mensaje);
		texto = input.nextLine().toLowerCase();
		return texto;
	}
	
	public static String ingresarOpcionJuego(String piedra, String papel, String tijera) {
		String opcion;
		do {			
			opcion = ingresarStringMinuscula("Ingrese una opcion entre \"Piedra\", \"Papel\" o \"Tijera\"");
			} while (!opcion.equalsIgnoreCase(piedra) && !opcion.equalsIgnoreCase(papel) && !opcion.equalsIgnoreCase(tijera));
		return opcion;
	}

}
