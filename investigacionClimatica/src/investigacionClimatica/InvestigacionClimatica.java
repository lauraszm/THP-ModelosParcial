package investigacionClimatica;
import java.util.Scanner;

public class InvestigacionClimatica {
	
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		final int HORA_MIN = 0, HORA_MAX = 23, MINUTOS_MIN = 0, MINUTOS_MAX = 59;
		final double TEMP_MIN = -20.00, TEMP_MAX = 55.00, HUMEDAD_MIN = 0.00, HUMEDAD_MAX = 100.00;
		final char SI = 'S', NO = 'N';
		String fecha;
		boolean continuar = true, horaValidada, minutosValidado, seguirValidado;
		int hora, minutos, mayorHora = 0, mayorMinutos = 0;
		double temp, humedad, heatIndex, mayorHeatIndex = 0;
		char seguir;
		
		System.out.println("Ingrese la fecha en que se realizo el estudio en formato dd/mm/aaaa");
		fecha = input.nextLine();
		while (continuar) {
			do {				
				System.out.println("Ingrese la hora de la medicion");
				hora = Integer.parseInt(input.nextLine());
				horaValidada = hora >= HORA_MIN && hora <= HORA_MAX;
			} while (!horaValidada);
			do {
				System.out.println("Ingrese los minutos de la medicion");
				minutos = Integer.parseInt(input.nextLine());
				minutosValidado = minutos >= MINUTOS_MIN && minutos <= MINUTOS_MAX;
			} while (!minutosValidado);
			do {
				System.out.println("Ingrese la temperatura");
				temp = Double.parseDouble(input.nextLine());
			} while (temp < TEMP_MIN && temp > TEMP_MAX);
			do {
				System.out.println("Ingrese la humedad");
				humedad = Double.parseDouble(input.nextLine());
			} while (humedad < HUMEDAD_MIN && humedad > HUMEDAD_MAX);
			
			heatIndex = (double) temp * (humedad/100);
			if (heatIndex > mayorHeatIndex) {
				mayorHeatIndex = heatIndex;
				mayorHora = hora;
				mayorMinutos = minutos;
			}
			
			System.out.println("Hora: " + hora + ":" + minutos);
			System.out.println("Temperatura registrada: " + temp + "co");
			System.out.println("Porcentaje de humedad: " + humedad + "%");
			System.out.println("Heat Index: " + heatIndex);
			
			do {
				System.out.println("Tiene mas mediciones para el dia " + fecha + "? Ingrese S o N");
				seguir = Character.toUpperCase(input.nextLine().charAt(0));
				seguirValidado = seguir == SI || seguir == NO;
				if(seguir == SI) {
					continuar = true;
				} else {
					continuar = false;
				}
				
			} while(!seguirValidado);
			
			
		}
		
		if (mayorHeatIndex > 0) {			
			System.out.println("Para la fecha " + fecha + ": A las " + mayorHora + ":" + mayorMinutos + " se registro el mayor heat index con un valor de " + mayorHeatIndex);
		}
		
		input.close();
	}

}
