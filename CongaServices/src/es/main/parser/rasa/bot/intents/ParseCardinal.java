package es.main.parser.rasa.bot.intents;

public class ParseCardinal {

	public static int parse(String text) {
		String number = clean(text);
		try {
			return Integer.parseInt(number);
		} catch (Exception e) {
			if (number.equals("zero")) {
				return 0;
			}
			int ret = thousands(number);
			if (ret == 0) {
				throw new NumberFormatException();
			} else {
				return ret;
			}
		}
	}

	private static String clean(String text) {
		String number = text.toLowerCase();
		while (number.contains("  ")) {
			number.replace("  ", " ");
		}
		if (number.startsWith(" ")) {
			number = number.substring(" ".length());
		}
		return number;

	}

	private static int units(String number) {
		String text = number.replaceAll(" ", "");
		switch (text) {
		case "one":
			return 1;
		case "two":
			return 2;
		case "three":
			return 3;
		case "four":
			return 4;
		case "five":
			return 5;
		case "six":
			return 6;
		case "seven":
			return 7;
		case "eight":
			return 8;
		case "nine":
			return 9;
		case "teen":
			return 10;
		default:
			return 0;
		}
	}

	private static int teens(String text) {
		String number = text.replaceAll(" ", "");
		if (number.equals("eleven")) {
			return 11;
		} else if (number.equals("twelve")) {
			return 12;
		} else if (number.equals("thirteen")) {
			return 13;
		} else if (number.equals("fifteen")) {
			return 15;
		} else if (number.endsWith("teen")) {
			return 10 + units(number.replace("teen", ""));
		} else {
			return units(number);
		}
	}

	private static int tens(String text) {
		String number = text;
		if (text.startsWith(" ")) {
			number = text.substring(" ".length());
		}
		if (number.startsWith("twenty")) {
			return 20 + units(number.replace("twenty", "").replace("-", ""));
		} else if (number.startsWith("thirty")) {
			return 30 + units(number.replace("thirty", "").replace("-", ""));
		} else if (number.startsWith("forty")) {
			return 40 + units(number.replace("forty", "").replace("-", ""));
		} else if (number.startsWith("fifty")) {
			return 50 + units(number.replace("fifty", "").replace("-", ""));
		} else if (number.startsWith("sixty")) {
			return 60 + units(number.replace("sixty", "").replace("-", ""));
		} else if (number.startsWith("seventy")) {
			return 70 + units(number.replace("seventy", "").replace("-", ""));
		} else if (number.startsWith("eighty")) {
			return 80 + units(number.replace("eighty", "").replace("-", ""));
		} else if (number.startsWith("ninety")) {
			return 90 + units(number.replace("ninety", "").replace("-", ""));
		} else {
			return teens(number);
		}
	}

	private static int hundreds(String text) {
		String number = text;
		if (text.startsWith(" ")) {
			number = text.substring(" ".length());
		}
		if (number.contains("hundred")) {
			String hundredString = number.substring(0, number.indexOf("hundred"));

			int hundred;
			if (hundredString.isEmpty() || hundredString.equals("a")) {
				hundred = 1;
			} else {
				hundred = units(hundredString);
			}
			String tensString = number.replace(hundredString + "hundred", "");
			int tens = tens(tensString);
			return hundred * 100 + tens;

		}
		return tens(number);
	}

	private static int thousands(String text) {
		String number = text;
		if (text.startsWith(" ")) {
			number = text.substring(" ".length());
		}
		if (number.contains("thousand")) {
			String thousandString = number.substring(0, number.indexOf("thousand"));
			int thousand;
			if (thousandString.isEmpty() || thousandString.equals("a")) {
				thousand = 1;
			} else {
				thousand = tens(thousandString);
			}
			String tensString = number.replace(thousandString + "thousand", "");
			int tens = hundreds(tensString);
			return thousand * 1000 + tens;

		}
		return hundreds(number);
	}

}
