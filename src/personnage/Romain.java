package personnage;

public class Romain {
	private String nom;
	private int force;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void parler(String texte) {
	 System.out.println(prendreParole() + "« " + texte + "»");
	}
	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	private String prendreParole() {
		return "Le romain " + nom + ": ";
	}
	public void recevoirCoup(int forceCoup) {
		force -= forceCoup ;
		if (force>0) {
			parler("Aie !");
		} else {
			parler("J'abondonne ...");
		}
	}
	public static void main(String[] args) {
		Romain aribus = new Romain("Aribus",7);
		System.out.println(aribus.prendreParole());
		aribus.parler("Je suis fort! ");
		aribus.recevoirCoup(8);
	}

}
