package personnage;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion=1;
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+texte);
	}
	private String prendreParole() {
		return "Le Gaulois " + nom + ": ";
	}
	public void frapper(Romain romain) {
		System.out.println(nom+" renvoie un grand coup sur le Romain "+romain.getNom());
		romain.recevoirCoup(force/3*effetPotion);
	}
	public void boirePotion(int forcePotion) {
			effetPotion=forcePotion;
			parler("« Merci Druide, je sens que ma force est " + forcePotion+ " fois décuplée. »");	
	}
	
	public String toString() {
		return "LesGaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix",8);
		System.out.println(asterix.getNom());
		System.out.println((asterix));
		System.out.println(asterix.prendreParole());
		asterix.parler("Je suis puissant!");
		Romain aribus = new Romain("Aribus",7); 
		Druide panoramix = new Druide("panoramix",10,5);
		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.getForcePotion());
		asterix.frapper(aribus);
		
	}
	}
