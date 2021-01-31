package curs11CompunereAgregare;

import java.util.Scanner;

public class Main {

	static Scanner scM = new Scanner(System.in);
	
	public static void showOptions() {
		for (Option opt : Option.values()) {
			System.out.println(opt.name() + opt.getDetails());
		}
	}

	public static void main(String[] args) {

		GuestList list = new GuestList(2);
		Guest g = new Guest();
		
		g = new Guest("Alison",	"Buckland",	"alison.buckland@email.com", "071231");
		list.adminAdd(g);
		g = new Guest("Joshua",	"Payne",	"joshua.payne@email.com", "071232");
		list.adminAdd(g);
//		g = new Guest("Lily",	"Ince",	"lily.ince@email.com", "071233");
//		list.adminAdd(g);

		g = new Guest("dummy1",	"dummy11",	"dummy1.ince@email.com", "090909");
		list.adminAdd(g);
//		g = new Guest("dummy2",	"dummy22",	"dummy2.ince@email.com", "010101");
//		list.adminAdd(g);
		
		boolean start = true;
		String chosenOption = "";
		
//		System.out.println("Bun venit! Introduceti numarul de locuri disponibile:\n\n");
//		list = new GuestList(scM.nextInt());
		System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");

		while(start) {
			chosenOption = scM.next();
			if (chosenOption.equals("help")) {
				showOptions();
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("add")) {
				System.out.println("Introdu prenumele:");
				String prenume = scM.next();
				System.out.println("Introdu numele:");
				String nume = scM.next();
				System.out.println("Introdu adresa de email:");
				String email = scM.next();
				System.out.println("Introdu numarul de telefon:");
				String nrTelefon = scM.next();
				g = new Guest(prenume, nume, email, nrTelefon);
				list.adauga(g);
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("check")) {
				list.askForCheckParam();
				g = list.getCheckGuest(g);
				list.check(g);
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("remove")) {
				System.out.println("Se sterge o persoana existenta din lista…");
				list.askForCheckParam();
				g = list.getCheckGuest();
				list.removeGuest(g);
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("update")) {
				list.askForCheckParam();
				g = list.getCheckGuest(g);
				list.updateGuest(g);
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("guests")) {
				list.getParticipantsList();
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("waitlist")) {
				list.getPendingList();
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("available")) {
				System.out.println("Sunt " + list.getAvailableSeats() + " locuri libere.");
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("guests_no")) {
				System.out.println("Sunt " + list.getParticiantsNo() + " participanti.");
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("waitlist_no")) {
				System.out.println("Sunt " + list.getPendingNo() + " participanti.");
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("subscribe_no")) {
				System.out.println("Sunt " + list.getTotalCrowdNo() + " inscrisi.");
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("search")) {
				System.out.println("Introdu campul dupa care se va face cautarea:");
				String s = scM.next();
				list.likeSearch(s);
				System.out.println("Asteapta comanda: (help - Afiseaza lista de comenzi)");
			} else if (chosenOption.equals("quit")) {
				System.out.println("La revedere!");
				start = false;
			}
		}
	}

}
