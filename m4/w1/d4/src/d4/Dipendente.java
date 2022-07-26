package d4;

public class Dipendente {
	public double stipendioBase = 1000;
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello lvl;
	private Dipartimento dpt;

	public Dipendente(String matricola, Dipartimento dpt) {
		this.matricola = matricola;
		this.dpt = dpt;
		this.stipendio = this.stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.lvl = Livello.OPERAIO;
	}
	
	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario, Livello lvl, Dipartimento dpt) {
		this(matricola, dpt);
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.lvl = lvl;
	}

	public String getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}

	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public Livello getLvl() {
		return lvl;
	}

	public Dipartimento getDpt() {
		return dpt;
	}

	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public void setDpt(Dipartimento dpt) {
		this.dpt = dpt;
	}
	
	public void stampaDatiDipendente() {
		System.out.println(this.matricola);
		System.out.println(this.stipendio);
		System.out.println(this.importoOrarioStraordinario);
		System.out.println(this.lvl);
		System.out.println(this.dpt);
	}
	
	public Livello promuovi() {
		switch(this.lvl) {
		case OPERAIO:
			this.lvl = Livello.IMPIEGATO;
			this.stipendio = this.stipendioBase * 1.2;
			break;
		case IMPIEGATO:
			this.lvl = Livello.QUADRO;
			this.stipendio = this.stipendioBase * 1.5;
			break;
		case QUADRO:
			this.lvl = Livello.DIRIGENTE;
			this.stipendio = this.stipendioBase * 2;
			break;
		case DIRIGENTE:
			System.out.println("Impossibile promuovere il dirigente");
		}
		return this.lvl;
	}
	
	public static double calcolaPaga(Dipendente d) {
		double s = d.getStipendio();
		System.out.println(s);
		return s;
	}
	
	public static double calcolaPagaPiuStraordinario(Dipendente d, int oreDiStraordinario) {
		double s = d.getStipendio() + d.getImportoOrarioStraordinario() * oreDiStraordinario;
		System.out.println(s);
		return s;
	}
	
}
