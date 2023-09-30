package histoire;
import personnage.Gaulois;
import personnage.Romain;
import personnage.Druide;


public class Scenario {
	public static void main(String[] args) {
		Druide panoramix = new Druide("Panoramix",10,5);
		panoramix.parler("<<Je vais aller préparer une petite potion ..>>");
		panoramix.preparerPotion();
		Gaulois obelix = new Gaulois("Obélix",25);
		panoramix.booster(obelix);
		obelix.parler("<< Par Bélénos , ce n'est pas juste! >>");
		Gaulois asterix = new Gaulois("Astérix",8);
		asterix.boirePotion(panoramix.getForcePotion());
		asterix.parler("<<Bonjour!>>");
		Romain minus = new Romain("Minus",6);
		do {
			asterix.frapper(minus);
		}
		while (minus.getForce()>0);
	}
}
