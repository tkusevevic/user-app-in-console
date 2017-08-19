package edunova;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProjectMain {

	Scanner tipkovnica;
	Student student;
	Operations operacija;
	String unos;
	List<Student> studenti;
	boolean trebaPoruka;
	int iteratorStudenta = 1;

	public ProjectMain() {
		tipkovnica = new Scanner(System.in);
		studenti = new ArrayList<>();
		program();
		tipkovnica.close();
	}

	private void program() {
		boolean kraj = false;
		while (kraj == false) {
			izbornik();
			for (;;) {
				unos = tipkovnica.nextLine();
				if (Operations.provjeraOperacija(unos)) {
					break;
				}
			}

			if (unos.trim().toUpperCase().equals("ENLIST")) {
				student = new Student();
				popuniStudenta(student);
			}
			if (unos.trim().toUpperCase().equals("DISPLAY")) {
				for (Student s : studenti) {
					System.out.println(s.toString());
				}
				kraj = true;
				tipkovnica.next();
			}
		}
	}

	private void popuniStudenta(Student student) {
		String imePrezime = "";
		student.setId(iteratorStudenta);
		System.out.println("Unesite ime");
		imePrezime = tipkovnica.nextLine();
		imePrezime = imePrezime.substring(0, 1).toUpperCase() + imePrezime.substring(1).toLowerCase();
		student.setIme(imePrezime);
		System.out.println("Unesite prezime");
		imePrezime = tipkovnica.nextLine();
		imePrezime = imePrezime.substring(0, 1).toUpperCase() + imePrezime.substring(1).toLowerCase();
		student.setPrezime(imePrezime);
		ubaciProsjek();
		iteratorStudenta++;
		studenti.add(student);
	}

	private void ubaciProsjek() {
		boolean success = false;
		while (!success) {
			try {
				System.out.println("Unesite prosjek");
				student.setProsjek(tipkovnica.nextDouble());
				success = true;
			} catch (IllegalStateException e) {
				System.out.println("krivi unos broja!");
				tipkovnica.next();
			} catch (InputMismatchException i) {
				System.out.println("krivi unos broja!");
				tipkovnica.next();
			}
		}
	}

	public static void main(String[] args) {
		new ProjectMain();

	}

	private static void izbornik() {
		System.out.println("Unesite \nENLIST za unos korisnika\nDISPLAY za prikaz unesenih!");
	}

}
