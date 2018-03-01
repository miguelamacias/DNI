package application;
//DNI.java
//Clase que ofrece varias utilidades referentes al DNI.
public class DNI {
	private boolean compruebaFormatoNIF(String numeroDNI) { //Comprueba si una String cumple el formato genérico de NIF
		/**
		 * El formato debe cumplir 3 condiciones:
		 * -Que tenga 8 carácteres (funcion .length())
		 * -que el primero sea un número, una X o una Y (se hace con expresiones regulares)
		 * 		XxYy -> que puede ser una X o Y que puede ser mayúscula o no; \\d -> que puede ser un número
		 * -que los 7 carácteres restantes sean numéricos (expresiones regulares)
		 * 		\\dd{7} --> deben ser 7 números seguidos
		 */
		if (numeroDNI.length() == 8 && numeroDNI.substring(0, 1).matches("[XxYy\\d]") && numeroDNI.substring(1, 8).matches("\\d{7}")) {
			return true;
		} else {
			return false;
		}

	}

	private String calculoLetra(String numeroDNI) { //Calcula la letra del DNI
		/* Se convierte la String numeroDNI a un entero y luego se calcula la letra
		del DNI con un Switch, cada case devuelve directamente la letra correspondiente */
		switch (Integer.parseInt(numeroDNI) % 23) { //Más adelante esto se debería sustituir por una Array
		case 0:
			return "T";
		case 1:
			return "R";
		case 2:
			return "W";
		case 3:
			return "A";
		case 4:
			return "G";
		case 5:
			return "M";
		case 6:
			return "Y";
		case 7:
			return "F";
		case 8:
			return "P";
		case 9:
			return "D";
		case 10:
			return "X";
		case 11:
			return "B";
		case 12:
			return "N";
		case 13:
			return "J";
		case 14:
			return "Z";
		case 15:
			return "S";
		case 16:
			return "Q";
		case 17:
			return "V";
		case 18:
			return "H";
		case 19:
			return "L";
		case 20:
			return "C";
		case 21:
			return "K";
		case 22:
			return "E";
		default:
			return "0";
		}
	}

	private boolean compruebaDNI(String dni) { //Comprueba si un DNI es válido
			//Se divide el DNI en el número y en la letra
			String numero = dni.substring(0, 8); //Los 8 primeros carácteres son el número
			String letra = dni.substring(8); //el 9 es la letra

			if (letra.equalsIgnoreCase(calculoLetra(numero))) { //Se calcula la letra correspondiente a ese número y se mira si es igual a la introducida
				return true;
			} else {
				return false;
			}

	}

	public String calculoNIF(String numeroNIF) { //Calcula cualquier tipo de NIF, tanto NIE como DNI.
		if (compruebaFormatoNIF(numeroNIF)) { //primero se comprueba que el NIF cumpla el formáto genérico
			String letra = numeroNIF.substring(0, 1);//se separa el primer carácter
			String numero = numeroNIF.substring(1, 8);//del resto del NIF
			if (letra.equalsIgnoreCase("X")) {//Se mira si el primer carácter del NIF es una X y la sustituye por un 0
				return calculoLetra(String.format("0%s", numero));
			} else if (letra.equalsIgnoreCase("Y")) {//Se mira si el primer carácter es una Y y la sustituye por un 1
				return calculoLetra(String.format("1%s", numero));
			} else { //si no es ni una x ni una y, se trata como si fuera un número
				return calculoLetra(numeroNIF);
			}
		} else {
			return "ERROR";
		}
	}

	public boolean compruebaNIF(String NIF) { //comprueba si un NIF es verdadero
		if (NIF.length() == 9 && compruebaFormatoNIF(NIF.substring(0, 8))) { //se comprueba que tenga 9 cifras y cumpla el formato general
			String letra = NIF.substring(0, 1);//se separa el primer carácter del resto del NIF
			String numero = NIF.substring(1, 9);//El resto del NIF
			if (letra.equalsIgnoreCase("X")) {//Se mira si el primer carácter del NIF es una X y la sustituye por un 0 y se manda a comprobar
				return compruebaDNI(String.format("0%s", numero));
			} else if (letra.equalsIgnoreCase("Y")) {//Se mira si el primer carácter es una Y y la sustituye por un 1 y se manda a comprobar
				return compruebaDNI(String.format("1%s", numero));
			} else { //si no es ni una x ni una y, se trata como si fuera un número
				return compruebaDNI(NIF);
			}
		} else {
			return false;
		}
	}
}