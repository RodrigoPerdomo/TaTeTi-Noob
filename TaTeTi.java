package TaTeTi;

import java.util.Scanner;

public class TaTeTi {

	public static void main(String[] args) {

		// Variables
		boolean turnoX = true;
		char x = 'x';
		char o = 'o';
		byte termino = 0;
		char[][] tablero = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };

		// Entrada de datos
		Scanner entrada = new Scanner(System.in);

		while (termino != 1) {

			// Verifico turno de X
			if (turnoX) {
				// Pido fila
				byte fila = pedirFila(entrada, x);

				// Pido columna
				byte columna = pedirColumna(entrada, x);

				// Verifico si esa posicion no esta usada
				if (tablero[fila][columna] == x || tablero[fila][columna] == o) {
					System.out.println("---------------------------------");
					System.out.println("Error: ese casillero esta ocupado");
					System.out.println("---------------------------------");
					// Pido devuelta los datos
					fila = pedirFila(entrada, x);
					columna = pedirColumna(entrada, x);
					// Relleno el tablero y lo muestro por consola
					tablero[fila][columna] = x;
					pintarTablero(tablero);
					// Cambio de turno
					turnoX = false;
				} else {
					// Relleno el tablero y lo muestro por consola
					tablero[fila][columna] = x;
					pintarTablero(tablero);
					// Cambio de turno
					turnoX = false;
				}

			} else {
				// Pido fila
				byte fila = pedirFila(entrada, o);

				// Pido columna
				byte columna = pedirColumna(entrada, o);

				// Verifico si esa posicion no esta usada
				if (tablero[fila][columna] == o || tablero[fila][columna] == x) {
					System.out.println("---------------------------------");
					System.out.println("Error: ese casillero esta ocupado");
					System.out.println("---------------------------------");
					// Pido devuelta los datos
					fila = pedirFila(entrada, o);
					columna = pedirColumna(entrada, o);
					// Relleno el tablero y lo muestro por consola
					tablero[fila][columna] = o;
					pintarTablero(tablero);
					// Cambio de turno
					turnoX = true;
				} else {
					// Relleno el tablero y lo muestro por consola
					tablero[fila][columna] = o;
					pintarTablero(tablero);
					// Cambio de turno
					turnoX = true;
				}

			}

			// Verifico ganador
			if (ganoX(tablero, x) == 1 || ganoO(tablero, o) == 1 || empate(tablero) == 0) {
				termino = 1;
			} else {
				termino = 0;
			}

		}

	}

	// Funcion pintar Tablero
	static void pintarTablero(char[][] tablero) {
		System.out.println("-------");
		System.out.println("Tablero");
		System.out.println("-------");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print("|");
				System.out.print(tablero[i][j]);
				System.out.print("|");
			}
			System.out.println();
		}
	}

	// Funcion para pedir fila para colocar letra
	static byte pedirFila(Scanner entrada, char letra) {
		boolean datoCorrecto = false;
		byte fila = 0;
		String entrada2;
		while (datoCorrecto == false) {
			System.out.println("-----------------------------------------------------");
			System.out.println("Ingrese numero de fila a colocar la " + letra + " (0,1,2)");
			System.out.println("-----------------------------------------------------");
			entrada2 = entrada.nextLine();
			if (entrada2.length() > 1 || Byte.parseByte(entrada2) > 2) {
				System.out.println("--------------");
				System.out.println("datoIncorrecto");
				System.out.println("--------------");
				datoCorrecto = false;
			} else {
				fila = Byte.parseByte(entrada2);
				datoCorrecto = true;
				return fila;
			}
		}
		return 0;
	}

	// Funcion para pedir columna para colocar letra
	static byte pedirColumna(Scanner entrada, char letra) {
		boolean datoCorrecto = false;
		byte columna = 0;
		String entrada2;
		while (datoCorrecto == false) {
			System.out.println("--------------------------------------------------------");
			System.out.println("Ingrese numero de columna a colocar la " + letra + " (0,1,2)");
			System.out.println("--------------------------------------------------------");
			entrada2 = entrada.nextLine();
			if (entrada2.length() > 1 || Byte.parseByte(entrada2) > 2) {
				System.out.println("--------------");
				System.out.println("datoIncorrecto");
				System.out.println("--------------");
				datoCorrecto = false;
			} else {
				columna = Byte.parseByte(entrada2);
				datoCorrecto = true;
				return columna;
			}
		}
		return 0;
	}

	// Verifico gano x
	static byte ganoX(char[][] tablero, char x) {
		if ((tablero[0][0] == x) && (tablero[0][1] == x) && (tablero[0][2] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[1][0] == x) && (tablero[1][1] == x) && (tablero[1][2] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[2][0] == x) && (tablero[2][1] == x) && (tablero[2][2] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[0][0] == x) && (tablero[1][0] == x) && (tablero[2][0] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[0][1] == x) && (tablero[1][1] == x) && (tablero[2][1] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[0][2] == x) && (tablero[1][2] == x) && (tablero[2][2] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[0][0] == x) && (tablero[1][1] == x) && (tablero[2][2] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else if ((tablero[0][2] == x) && (tablero[1][1] == x) && (tablero[2][0] == x)) {
			System.out.println("Gano el jugador X");
			return 1;
		} else {
			return 2;
		}
	}

	// verifico gano O
	static byte ganoO(char[][] tablero, char o) {
		if ((tablero[0][0] == o) && (tablero[0][1] == o) && (tablero[0][2] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[1][0] == o) && (tablero[1][1] == o) && (tablero[1][2] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[2][0] == o) && (tablero[2][1] == o) && (tablero[2][2] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[0][0] == o) && (tablero[1][0] == o) && (tablero[2][0] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[0][1] == o) && (tablero[1][1] == o) && (tablero[2][1] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[0][2] == o) && (tablero[1][2] == o) && (tablero[2][2] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[0][0] == o) && (tablero[1][1] == o) && (tablero[2][2] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else if ((tablero[0][2] == o) && (tablero[1][1] == o) && (tablero[2][0] == o)) {
			System.out.println("Gano el jugador O");
			return 1;
		} else {
			return 2;
		}
	}

	// Verifico empate
	static byte empate(char[][] tablero) {
		if ((tablero[0][0] != '-') && (tablero[0][1] != '-') && (tablero[0][2] != '-') && (tablero[1][0] != '-')
				&& (tablero[1][1] != '-') && (tablero[1][2] != '-') && (tablero[2][0] != '-') && (tablero[2][1] != '-')
				&& (tablero[2][2] != '-')) {
			System.out.println("Empate");
			return 0;
		} else {
			return 2;
		}
	}
}
