package d4;

public class GestioneDipendenti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Dipendente d1 = new Dipendente("ergwebwrbs", 800, 15, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente d2 = new Dipendente("dhndxrfhbs", 900, 20, Livello.OPERAIO, Dipartimento.PRODUZIONE);
		Dipendente d3 = new Dipendente("ehrkgviuer", 1250, 35, Livello.IMPIEGATO, Dipartimento.AMMINISTRAZIONE);
		Dipendente d4 = new Dipendente("iwurqv4iut", 1600, 50, Livello.DIRIGENTE, Dipartimento.VENDITE);
		
		d1.promuovi();
		d3.promuovi();
		
		System.out.println("DIPENDENTE 1\n" + d1.getMatricola());
		System.out.println(d1.getStipendio());
		System.out.println(d1.getImportoOrarioStraordinario());
		System.out.println(d1.getLvl());
		System.out.println(d1.getDpt() + "\n------------------");
		
		System.out.println("DIPENDENTE 2\n" + d2.getMatricola());
		System.out.println(d2.getStipendio());
		System.out.println(d2.getImportoOrarioStraordinario());
		System.out.println(d2.getLvl());
		System.out.println(d2.getDpt() + "\n------------------");
		
		System.out.println("DIPENDENTE 3\n" + d3.getMatricola());
		System.out.println(d3.getStipendio());
		System.out.println(d3.getImportoOrarioStraordinario());
		System.out.println(d3.getLvl());
		System.out.println(d3.getDpt() + "\n------------------");
		
		System.out.println("DIPENDENTE 4\n" + d4.getMatricola());
		System.out.println(d4.getStipendio());
		System.out.println(d4.getImportoOrarioStraordinario());
		System.out.println(d4.getLvl());
		System.out.println(d4.getDpt() + "\n------------------");
		
	}


}
