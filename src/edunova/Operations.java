package edunova;

public class Operations {

	public enum Mogucnosti {
		DISPLAY, ENLIST
	}

	public static boolean provjeraOperacija(String op) {
		if (!provjeriJelText(op)) {
			System.out.println("Niste unjeli text!");
			return false;
		}
		if (op.trim().toUpperCase().equals(Mogucnosti.DISPLAY.toString())
				|| op.trim().toUpperCase().equals(Mogucnosti.ENLIST.toString())) {
			return true;

		} else {
			System.out.println("Krivi unos, unesite ponovno");
			return false;
		}

	}

	private static boolean provjeriJelText(String op) {
		char niz[] = op.toCharArray();
		for (char n : niz) {
			if (!Character.isLetter(n))
				return false;
		}
		return true;

	}

}
