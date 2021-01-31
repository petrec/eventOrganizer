package curs11CompunereAgregare;

import java.util.ArrayList;
import java.util.Scanner;

public class GuestList {

	static Scanner sc = new Scanner(System.in);
	
	int noSeats;
	int noPending;
	int orderNo = 0;
	public ArrayList<Guest> participantsList = new ArrayList<Guest>(noSeats);
	public ArrayList<Guest> pendingList = new ArrayList<Guest>();
	
	public GuestList(int noSeats) {
		this.noSeats = noSeats;
	}
	
	public GuestList() {
	}
	
	public void askForCheckParam() {
		System.out.println("Care e parametrul de verificare?\n"
				+ "\t1. Nume Prenume"
				+ "\t2. Email"
				+ "\t3. Numar telefon"
				+ "\t4. All");
		Guest.cazComparatie = sc.nextInt();
	}

	Guest getCheckGuest() {
		Guest g = new Guest();
		if (Guest.cazComparatie == 1) {
			System.out.println("Introdu prenumele:");
			String prenume = sc.next();
			System.out.println("Introdu numele:");
			String nume = sc.next();
			g = new Guest(prenume, nume, "", "");
		} else if (Guest.cazComparatie == 2) {
			System.out.println("Introdu emailul:");
			String email = sc.next();
			g = new Guest("", "", email, "");
		} else if (Guest.cazComparatie == 3) {
			System.out.println("Introdu numarul de telefon:");
			String nrTelefon = sc.next();
			g = new Guest("", "", "", nrTelefon);
		}
		return g;
	}

	Guest getCheckGuest(Guest g) {

		if (Guest.cazComparatie == 1) {
			System.out.println("Introdu prenumele:");
			String prenume = sc.next();
			System.out.println("Introdu numele:");
			String nume = sc.next();
			g = new Guest(prenume, nume, "", "");
		} else if (Guest.cazComparatie == 2) {
			System.out.println("Introdu emailul:");
			String email = sc.next();
			g = new Guest("", "", email, "");
		} else if (Guest.cazComparatie == 3) {
			System.out.println("Introdu numarul de telefon:");
			String nrTelefon = sc.next();
			g = new Guest("", "", "", nrTelefon);
		}
		else return g;
		return g;
	}
	
	public int adauga(Guest guest) {
		
		askForCheckParam();
		Guest guestToAdd = getCheckGuest(guest);

		if(!check(guestToAdd)) {
			if (noSeats > 0) {
				participantsList.add(guest);
				System.out.println("Felicitari! Locul tau la eveniment este confirmat. Te asteptam!\n");
				noSeats--;
				return 0;
			} else {
				pendingList.add(guest);
				orderNo++;
				System.out.println("Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine " +
									orderNo + ". Te vom notifica daca un loc devine disponibil.");
				return orderNo;
			}
		} else {
			System.out.println("Esti deja inscris pe lista!");
			return -1;
		}
	}
	
	public void adminAdd(Guest guest) {

		if(!check(guest)) {
			if (noSeats > 0) {
				participantsList.add(guest);
				noSeats--;
			} else {
				pendingList.add(guest);
				orderNo++;
			}
		} else {
			System.out.println("Esti deja inscris pe lista!");
		}
	}

	boolean check(Guest g) {
		if (this.participantsList.contains(g)) {
			return true;
		} else return false;
	}
	
	boolean removeGuest(Guest guest) {
		
		if(check(guest)) {
			participantsList.remove(guest);
			System.out.println("Ai fost eliminat de pe lista. La revedere!");
			if (pendingList != null && pendingList.contains(guest)) {
				pendingList.remove(guest);
				System.out.println("Ai fost eliminat si de pe lista de asteptare. La revedere!");
			}
			if (pendingList != null && pendingList.size() > 0) {				
				participantsList.add(pendingList.get(0));
				System.out.println(pendingList.get(0).getFirstName() + " " + pendingList.get(0).getLastName() + 
						", ai fost mutat din lista de asteptare, in lista de participare.");
				pendingList.remove(0);
			}
			return true;
		} else {
			System.out.println("Nu esti pe lista!");
			return false;
		}
	}
	
	public boolean updateGuest(Guest guest) {
		System.out.println("Ce doresti sa actualizam?\n"
				+ "\t1. Nume Prenume"
				+ "\t2. Email"
				+ "\t3. Numar telefon");
		
		Guest.cazComparatie = sc.nextInt();
		String s = sc.next();
		if(check(guest)) {
			int index = this.participantsList.indexOf(guest);
			if (Guest.cazComparatie == 1) {
				String nume = sc.next();
				this.participantsList.get(index).setFirstName(s);
				this.participantsList.get(index).setLastName(nume);
				System.out.println("Am actualizat userul " + guest.getFirstName() + " " + guest.getLastName() + "\n");
				return true;
			}
			if (Guest.cazComparatie == 2) {
				this.participantsList.get(index).setEmail(s);
				System.out.println("Am actualizat userul cu emailul " + guest.getEmail() + "\n");
				return true;
			}
			if (Guest.cazComparatie == 3) {
				this.participantsList.get(index).setPhoneNumber(s);
				System.out.println("Am actualizat userul cu numarul de telefon " + guest.getPhoneNumber() + "\n");
				return true;
			}
		} else {
			System.out.println("Nu esti pe lista!");
		}
		return false;
	}
	public void getParticipantsList() {
		System.out.println("\nLista de participare:");
		for (int i = 0; i < this.participantsList.size(); i++) {
			System.out.println("\t - " + this.participantsList.get(i).getFullName());
		}
	}
	public void getPendingList() {
		System.out.println("\nLista de asteptare:");
		for (int i = 0; i < this.pendingList.size(); i++) {
			System.out.println("\t - " + this.pendingList.get(i).getFullName());
		}
	}
	public int getPendingNo() {
		return this.pendingList.size();
	}
	public int getAvailableSeats() {
		if (this.participantsList.size() >= this.noSeats) {
			return 0;
		} else return this.noSeats - this.participantsList.size();
	}
	public int getParticiantsNo() {
		return this.participantsList.size();
	}
	public int getTotalCrowdNo() {
		return participantsList.size() + pendingList.size();
	}
	public void likeSearch(String s) {
		s = s.toLowerCase();
		int counter = 0;
		System.out.println("Rezultatele cautarii sunt:");
		for (int i = 0; i < participantsList.size(); i++) {
			if (participantsList.get(i).getFullName().toLowerCase().contains(s)){
				System.out.println("\tContact " + counter + " contine nume = " + participantsList.get(i).getFullName());
				counter++;
			} else if (participantsList.get(i).email.toLowerCase().contains(s)) {
				System.out.println("\tContact " + counter + " contine email = " + participantsList.get(i).getFullName());
				counter++;				
			} else if (participantsList.get(i).phoneNumber.contains(s)) {
				System.out.println("\tContact " + counter + " contine numar de telefon = " + participantsList.get(i).getFullName());
				counter++;
			}
		}
		if (counter == 0) {
			System.out.println("\t0");
		}
	}
}
