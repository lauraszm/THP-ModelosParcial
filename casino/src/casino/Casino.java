package casino;

import java.util.Scanner;

public class Casino {
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		final int MAXIMO_PERMITIDO = 5000, COSTO_RULETA = 100, COSTO_BLACKJACK = 200, COSTO_POCKER = 500, GANO_DOBLE = 2, GANO_SIMPLE = 1, PERDIO = 0;
		final String RULETA = "RUL", BLACK_JACK = "BJK", POCKER = "PKR";
		String nombreJugador, juegoElegido;
		int dineroInicial, dineroActual = 0, resultado, cantASumar, contRuleta = 0, contBJK = 0, contPocker = 0, totalJugadas = 0;
		double minPermitido, rand, porcentajeRuleta, porcentajeBJK, porcentajePocker;
		boolean hayDineroSuficiente, juegoValidado, resultadoValidado;

		System.out.println("Bienvenido al casino Nunca Pierdo");

		System.out.println("Ingrese su nombre");
		nombreJugador = input.nextLine();

		do {
			System.out.println("Ingrese el dinero inicial (minimo $500)");
			dineroInicial = Integer.parseInt(input.nextLine());
		} while (dineroInicial < 500);

		dineroActual += dineroInicial;
		minPermitido = (double) dineroInicial * 0.2;
		hayDineroSuficiente = dineroActual >= minPermitido || dineroActual >= COSTO_RULETA;

		while(hayDineroSuficiente && dineroActual <= MAXIMO_PERMITIDO) {
			do {				
				System.out.println("Ingrese el juego elegido");
				juegoElegido = input.nextLine();
				juegoValidado = juegoElegido.equalsIgnoreCase(RULETA) || juegoElegido.equalsIgnoreCase(BLACK_JACK) || juegoElegido.equalsIgnoreCase(POCKER);
			} while (!juegoValidado);

			if (juegoElegido.equalsIgnoreCase(RULETA)){

				if ( dineroActual >= COSTO_RULETA){
					contRuleta++;
					dineroActual -= COSTO_RULETA;
					rand = Math.random()*(3);
					resultado = (int) rand;
					System.out.println("Resultado: " + resultado);
					switch (resultado) {
					case GANO_DOBLE:
						cantASumar = COSTO_RULETA * GANO_DOBLE;
						dineroActual += cantASumar;
						break;
					case GANO_SIMPLE:
						cantASumar = COSTO_RULETA * GANO_SIMPLE;
						dineroActual += cantASumar;
						break;
					case PERDIO:
						cantASumar = COSTO_RULETA * PERDIO;
						dineroActual += cantASumar;
						break;
					}
				} else {
					System.out.println("No tiene dinero suficiente para jugar a este juego");
				}
			} else if(juegoElegido.equalsIgnoreCase(BLACK_JACK)){
				if ( dineroActual >= COSTO_BLACKJACK){
					contBJK++;
					dineroActual -= COSTO_BLACKJACK;
					rand = Math.random()*(GANO_DOBLE + 1);
					resultado = (int) rand;
					System.out.println("Resultado: " + resultado);
					switch (resultado) {
					case GANO_DOBLE:
						cantASumar = COSTO_BLACKJACK * GANO_DOBLE;
						dineroActual += cantASumar;
						break;
					case GANO_SIMPLE:
						cantASumar = COSTO_BLACKJACK * GANO_SIMPLE;
						dineroActual += cantASumar;
						break;
					case PERDIO:
						cantASumar = COSTO_BLACKJACK * PERDIO;
						dineroActual += cantASumar;
						break;
					}
				} else {
					System.out.println("No hay dinero suficiente para jugar a este juego");
				}
			} else {
				if ( dineroActual >= COSTO_POCKER){
					contPocker++;
					dineroActual -= COSTO_POCKER;
					rand = Math.random()*(GANO_DOBLE + 1);
					resultado = (int) rand;
					System.out.println("Resultado: " + resultado);
					switch (resultado) {
					case GANO_DOBLE:
						cantASumar = COSTO_POCKER * GANO_DOBLE;
						dineroActual += cantASumar;
						break;
					case GANO_SIMPLE:
						cantASumar = COSTO_POCKER * GANO_SIMPLE;
						dineroActual += cantASumar;
						break;
					case PERDIO:
						cantASumar = COSTO_POCKER * PERDIO;
						dineroActual += cantASumar;
						break;
					}
				} else {
					System.out.println("No hay dinero suficiente para jugar a este juego");
				}
			} 

		}
		
		totalJugadas = contRuleta + contBJK + contPocker;
		
		System.out.println("Dinero restante: " + dineroActual);
		if (totalJugadas > 0) {
			porcentajeRuleta = contRuleta * 100 / totalJugadas;
			porcentajeBJK = contBJK * 100 / totalJugadas;
			porcentajePocker = contPocker * 100 / totalJugadas;
			
			System.out.println("Total juegos en ruleta: " + contRuleta + " que es el " + porcentajeRuleta + "% del total");
			System.out.println("Total juegos en black jack: " + contBJK + " que es el " + porcentajeBJK + "% del total");
			System.out.println("Total juegos en ruleta: " + contPocker + " que es el " + porcentajePocker + "% del total");

		}
	

		input.close();
	}
}
