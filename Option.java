package curs11CompunereAgregare;

public enum Option {

	help			("\t\t- Afiseaza aceasta lista de comenzi"),
	add				("\t\t- Adauga o noua persoana (inscriere)"),
	check			("\t\t- Verifica daca o persoana este inscrisa la eveniment"),
	remove			("\t\t- Sterge o persoana existenta din lista"),
	update			("\t\t- Actualizeaza detaliile unei persoane"),
	guests			("\t\t- Lista de persoane care participa la eveniment"),
	waitlist		("\t- Persoanele din lista de asteptare"),
	available		("\t- Numarul de locuri libere"),
	guests_no		("\t- Numarul de persoane care participa la eveniment"),
	waitlist_no		("\t- Numarul de persoane din lista de asteptare"),
	subscribe_no	("\t- Numarul total de persoane inscrise"),
	search			("\t\t- Cauta toti invitatii conform sirului de caractere introdus"),
	quit			("\t\t- Inchide aplicatia");
	
	private final String details;
	
	Option(String details) {
		this.details = details;
	}
	
	public String getDetails() {
		return this.details;
	}
}
