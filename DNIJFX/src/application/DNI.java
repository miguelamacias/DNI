package application;
import com.google.common.primitives.Ints;
//DNI.java
//Clase que ofrece varias utilidades referentes al DNI.
public class DNI {
	private boolean compruebaNumDNI(String numeroDNI) { //Comprueba si una String es un número válido de DNI
		//Comprueba que el DNI introducido contiene 8 carácteres usando String.length
		if (numeroDNI.length() == 8) {
			if (Ints.tryParse(numeroDNI) != null) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	private String calculoLetra(String numeroDNI) { //Calcula la letra del DNI, USO INTERNO, NO USAR DESDE OTRA CLASE!
		/* Se convierte la String numeroDNI a un entero y luego se calcula la letra
		del DNI con un Switch, cada case devuelve directamente la letra correspondiente */
		switch (Integer.parseInt(numeroDNI) % 23) {
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
	public boolean compruebaDNI(String dni) { //Comprueba si un DNI es válido
		String numero;
		String letra;
		if (dni.length() == 9 && Ints.tryParse(dni.substring(0, 8)) != null) { //Primero se comprueba que la String tenga 9 carácteres
			//Se divide el DNI en el número y en la letra
			numero = dni.substring(0, 8);
			letra = dni.substring(8);

			if (letra.equalsIgnoreCase(calculoLetra(numero))) { //Se calcula la letra correspondiente a ese número y se mira si es igual a la introducida
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}

	}
	public String calculoNIF(String numeroNIF) { //Calcula cualquier tipo de NIF, tanto NIE como DNI. LLamar a este método desde otras clases
		if (compruebaNumDNI(numeroNIF)) {
			String letra = numeroNIF.substring(0, 1);
			String numero = numeroNIF.substring(1, 8);
			if (letra.equalsIgnoreCase("X")) {
				return calculoLetra(String.format("0%s", numero));
			} else if (letra.equalsIgnoreCase("Y")) {
				return calculoLetra(String.format("1%s", numero));
			} else {
				return calculoLetra(numeroNIF);
			}
		} else {
			return "ERROR";
		}
	}
}