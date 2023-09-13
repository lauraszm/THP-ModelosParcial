package freddort;

import java.util.Scanner;

public class FreddORT {

	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		final char CHICO = 'C', MEDIANO = 'M', GRANDE = 'G', SALIR = 'Z';
		final int FIN = 20, COMISION = 50;

		char tamano;
		boolean tamanoValido, cantGustosValido;
		int cantGustos, caloriasSabor, minCalorias = Integer.MAX_VALUE, contC = 0, contM = 0, contG = 0, totalCompras,
				ordenMenosCalorias = 0;
		double acumVentas = 0, precio, precioFinal, porcentajeC, pedidoMasCaro = 0, promedioCompras;
		String cliente = "", gusto, gustoMenosCalorias = "", clientePedidoMasCaro = "";

		System.out.println("Bienvenido a FreddORT");

		do {
			System.out.println("Ingrese el tamano del pedido");
			tamano = Character.toUpperCase(input.nextLine().charAt(0));
			tamanoValido = tamano == CHICO || tamano == MEDIANO || tamano == GRANDE || tamano == SALIR;
		} while (!tamanoValido);

		while (tamano != SALIR && contG < FIN) {

			do {
				System.out.println("Ingrese la cantidad de gustos");
				cantGustos = Integer.parseInt(input.nextLine());
				cantGustosValido = cantGustos > 0 && cantGustos <= 4;
			} while (!cantGustosValido);
			do {
				System.out.println("Ingrese el importe a cobrar");
				precio = Double.parseDouble(input.nextLine());
			} while (precio < 0);

			precioFinal = precio + COMISION;
			acumVentas += precioFinal;

			do {
				System.out.println("Ingrese el nombre del cliente");
				cliente = input.nextLine();
			} while (cliente == null);

			if (precioFinal > pedidoMasCaro) {
				pedidoMasCaro = precioFinal;
				clientePedidoMasCaro = cliente;
			}

			switch (tamano) {
			case 'C':
				contC++;
				break;
			case 'M':
				contM++;
				break;
			case 'G':
				contG++;
				break;
			}

			for (int i = 0; i < cantGustos; i++) {
				do {
					System.out.println("Ingrese el nombre del gusto " + (i + 1));
					gusto = input.nextLine();
				} while (gusto == null);
				do {
					System.out.println("Ingrese la cantidad de calorias");
					caloriasSabor = Integer.parseInt(input.nextLine());
				} while (caloriasSabor <= 0);

				if (caloriasSabor < minCalorias) {
					minCalorias = caloriasSabor;
					gustoMenosCalorias = gusto;
					ordenMenosCalorias = (i + 1);
				}
			}

			System.out.println("el gusto con menos calorias fue " + gustoMenosCalorias + " y fue agregado en el orden "
					+ ordenMenosCalorias);

			do {
				System.out.println("Ingrese el tamano del pedido");
				tamano = Character.toUpperCase(input.nextLine().charAt(0));
				tamanoValido = tamano == CHICO || tamano == MEDIANO || tamano == GRANDE || tamano == SALIR;
			} while (!tamanoValido);
		}

		totalCompras = contC + contM + contG;

		System.out.println("Pedidos chicos: " + contC);
		System.out.println("Pedidos medianos: " + contM);
		System.out.println("Pedidos grandes: " + contG);
		System.out.println("Pedido mas caro: " + pedidoMasCaro + " comprado por " + clientePedidoMasCaro);

		if (totalCompras != 0) {
			promedioCompras = acumVentas / totalCompras;
			porcentajeC = contC * 100 / totalCompras;
			System.out.println("Promedio importe: " + promedioCompras);
			System.out.println("Porcentaje de pedidos chicos: " + porcentajeC + "%");
		}

		input.close();
	}

}
