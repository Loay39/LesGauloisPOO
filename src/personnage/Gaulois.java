package personnage;

public class Gaulois extends Personnage {
	private int effetPotion=1;
	private int nb_trophees=0;
	private Equipement[] trophees;
	public Gaulois(String nom, int force) {
			super(nom,force);
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getForce() {
		return force;
	}

	public void parler(String texte) {
		System.out.println(prendreParole()+texte);
	}

	 private String prendreParole() {
         return "Le gaulois " + nom + " : ";
}

	/*public void frapper(Romain romain) {
		System.out.println(nom+" renvoie un grand coup sur le Romain "+romain.getNom());
		romain.recevoirCoup(force/3*effetPotion);
	}*/
	 
	 public void frapper(Romain romain) {
		 System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		 Equipement[] trophees = romain.recevoirCoup((force / 3) * effetPotion);
		 for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			 this.trophees[i] = trophees[i] ;
}
		 }
	public void faireUneDonnation(Musee musee) {
		parler("Je donne au musée tous mes trophees : ");
		for (int i=0;i<nb_trophees;i++) {
			System.out.println("-"+trophees[i]+"\n");
			musee.donnerTrophees(this, trophees[i]);
		}
		
	}
	public void boirePotion(int forcePotion) {
			effetPotion=forcePotion;
			parler("« Merci Druide, je sens que ma force est " + forcePotion+ " fois décuplée. »");	
	}

	
	public String toString() {
		String etatPersonnage= super.toString();
		return "LesGaulois" + etatPersonnage.substring(0,etatPersonnage.length()-1) + "effetPotion"+effetPotion+"]";
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
