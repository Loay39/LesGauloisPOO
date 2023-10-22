package personnage;

public class Personnage {
	protected String nom;
	protected int force;
	public Personnage(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	public String getNom() {
		return nom;
	}
	@Override
	public String toString() {
		return "Personnage [nom=" + nom + ", force=" + force + "]";
	}
	
}
