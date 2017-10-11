package br.ufg.inf.romanos;

import java.util.HashMap;

public class RomanNumberParser {

	public static final HashMap<Character, Integer> romanosMap = new HashMap<>();

	static {
		romanosMap.put('I', 1);
		romanosMap.put('V', 5);
		romanosMap.put('X', 10);
		romanosMap.put('L', 50);
		romanosMap.put('C', 100);
		romanosMap.put('D', 500);
		romanosMap.put('M', 1000);
	}
	
	

	public static int romanoParaInteiro(String numeroRomano) {
		int romanNumberAsInt = 0;

		romanNumberAsInt += romanosMap.get(numeroRomano.charAt(0));

		for (int i = 1, tamanho = numeroRomano.length(); i < tamanho ; i++) {

			int currentRomanNumberAsInt = romanosMap.get(numeroRomano.charAt(i));
			int nextRomanNumberAsInt = 0;
			if(i < tamanho - 1) nextRomanNumberAsInt = romanosMap.get(numeroRomano.charAt(i + 1));

			if (currentRomanNumberAsInt < nextRomanNumberAsInt) {
				romanNumberAsInt += nextRomanNumberAsInt - currentRomanNumberAsInt;
				i++;
			}

			else {
				romanNumberAsInt += currentRomanNumberAsInt;
			}
		}

		return romanNumberAsInt;

	}

	public static boolean validarQuantidadeDeDigitos(String numeroRomano) {
		
		boolean valido = true;

		char[] charVector = numeroRomano.toCharArray();
		int count[] = { 0, 0, 0, 0, 0, 0, 0 };
		

		for (int i = 0; i < charVector.length; i++) {
			switch (charVector[i]) {
			case 'I':
				count[0] += 1;
				if (count[0] > 3) return valido = false;
				break;
			case 'V':
				count[1] += 1;
				if (count[1] > 1) return valido = false;
				break;
			case 'X':
				count[2] += 1;
				if (count[2] > 3) return valido = false;
				break;
			case 'L':
				count[3] += 1;
				if (count[3] > 1) return valido = false;
				break;
			case 'C':
				count[4] += 1;
				if (count[4] > 3) return valido = false;
				break;
			case 'D':
				count[5] += 1;
				if (count[5] > 1) return valido = false;
				break;
			case 'M':
				count[6] += 1;
				if (count[6] > 3) return valido = false;
				break;
			default: return valido = false;
			}

		}
		return valido;
	}
	
	public static boolean ehRomano(String s){
	    return s.matches("M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})");
	}


}
