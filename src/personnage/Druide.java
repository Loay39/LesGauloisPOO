package personnage;
import java.util.Random;
public class Druide {
	private String nom;
	private int effetPotionMax;
	private int effetPotionMin;
	private int forcePotion=1 ;
	
	public Druide(String nom, int effetPotionMax, int effetPotionMin) {
		this.nom = nom;
		this.effetPotionMax = effetPotionMax;
		this.effetPotionMin = effetPotionMin;
		parler("Bonjour, je suis le druide " + nom
		+ " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	public void preparerPotion() {
		Random random = new Random();
		forcePotion=random.nextInt(effetPotionMax);
		if (effetPotionMin<=forcePotion && forcePotion<=effetPotionMax) {
			parler("<< J'ai préparé une super potion de force " + forcePotion + ">>");
		} else {
			parler("« Je n'ai pas trouvé tous les ingrédients, ma potion est seulement de force " + forcePotion+">>");
		}
		
	}
	public String getNom() {
		return nom;
	}

	public void parler(String texte) { 
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	private String prendreParole() {
		return "Le Druide"+nom+":";
	}
	
	public int getForcePotion() {
		return forcePotion;
	}
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",10,5);
		panoramix.preparerPotion();
		
	}
	
}
