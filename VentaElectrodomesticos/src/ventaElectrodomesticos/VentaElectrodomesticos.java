package ventaElectrodomesticos;

import java.util.Scanner;

public class VentaElectrodomesticos {
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		final char SALIDA = 'F', TURNO_TARDE='T', TURNO_MANANA='M';
		
		int contM = 0, contT = 0, acumM = 0, acumT = 0, vendedor, totalDia, acumTotal = 0, acumTotalM = 0, contVendedoresM = 0, acumTotalT = 0, contVendedoresT = 0, maximoDiario = 0, mayorVendedor = 0;
		int totalVendedores, totalVentas;
		double promedioVentas, porcentajeM, porcentajeT;
		char turno;
		boolean turnoValidado;
		for (int i =0; i < 15; i++) {
			contM = 0;
			contT = 0;
			acumM = 0;
			acumT = 0;
			maximoDiario = 0;
			mayorVendedor = 0;
			
			do {
				System.out.println("Ingrese el turno del operador, M/T. F para salir");
				turno = Character.toUpperCase(input.nextLine().charAt(0));
				turnoValidado = turno == SALIDA || turno == TURNO_TARDE || turno == TURNO_MANANA;
			} while (!turnoValidado);
			
			while (turno != SALIDA) {
				do {					
					System.out.println("Ingrese el codigo del vendedor");
					vendedor = Integer.parseInt(input.nextLine());
				} while (vendedor < 0);
				do {
					System.out.println("Ingrese el total vendido en el dia por el vendedor " + vendedor);
					totalDia = Integer.parseInt(input.nextLine());
				} while (totalDia < 0);
				
				acumTotal++;
				if (turno == TURNO_MANANA) {
					contM++;
					acumM += totalDia;
					acumTotalM += totalDia;
					contVendedoresM++;
				} else {
					contT++;
					acumT += totalDia;
					acumTotalT += totalDia;
					contVendedoresT++;
				}
				if(totalDia > maximoDiario) {
					maximoDiario = totalDia;
					mayorVendedor = vendedor;
				}
				
				do {
					System.out.println("Ingrese el turno del operador, M/T. F para salir");
					turno = Character.toUpperCase(input.nextLine().charAt(0));
					turnoValidado = turno == SALIDA || turno == TURNO_TARDE || turno == TURNO_MANANA;
				} while (!turnoValidado);
			}
			System.out.println("Total recaudado en sucursal " + (i+1) + " en el turno manana: " + acumM);
			System.out.println("Total recaudado en sucursal " + (i+1) + " en el turno tarde: " + acumT);
			System.out.println("Vendedor de mayor recaudacion: " + mayorVendedor);
		}
		
		totalVendedores = contVendedoresM + contVendedoresT;
		totalVentas = acumTotalM + acumTotalT;
		promedioVentas = (double) totalVentas / totalVendedores;
		porcentajeM = (double) acumTotalM * 100 / totalVentas;
		porcentajeT = 100 - (double) porcentajeM;
		
		System.out.println("promedio de ventas por vendedor: " + promedioVentas);
		System.out.println("porcentaje de turno manana: " + porcentajeM);
		System.out.println("porcentaje de turno tarde: " + porcentajeT);
		
		input.close();
	}

}
