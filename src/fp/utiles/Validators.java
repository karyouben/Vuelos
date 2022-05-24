package fp.utiles;

public class Validators {

	/**
	 * @param cad Cadena de caracteres
	 * @return true si todos los caracteres de la cadena cad son letras, y devuelve 
	 * false en caso contrario.
	 */
	public static Boolean sonLetras(String cad) {
		//Esquema para todo
		Boolean res = true;
		//AB1dghk
		for (int i = 0; i < cad.length();i++) { //i=0 i =1  1<3 B i=2  2<3 1
			if (!Character.isLetter(cad.charAt(i))) {
				res=false;
				break;
			}
		}
		return res;
	}

	/**
	 * @param cad Cadena de caracteres
	 * @return true si todos los caracteres de la cadena cad son dígitos, y devuelve 
	 * false en caso contrario.
	 */
	public static Boolean sonDigitos(String cad) {
		Boolean res = true;
		
		for (int i = 0; i < cad.length();i++)
			if (!Character.isDigit(cad.charAt(i))) {
				res=false;
				break;
			}
		
		return res;
	}

	
}
