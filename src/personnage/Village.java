package personnage;

public class Village {
	private String nom;
	private int nbVillageois=0 ;
	private Gaulois[] villageois;
	private int nbVillageoisMax;
	

	public Village(String nom, int nbVillageoisMax ) {
		this.nom = nom;
		this.nbVillageoisMax=nbVillageoisMax;
		villageois= new Gaulois[nbVillageoisMax];
		
	}
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois<nbVillageoisMax) {
			villageois[nbVillageois]=gaulois;
			nbVillageois+=1;
		}
	}
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	public void afficherVillageois(Chef chef) {
		System.out.println("Dans village du chef " + chef.getNom() + " vivent les légendaires gaulois : " );
		for (int i=0 ; i<nbVillageois ;  i++) {
			Gaulois gaulois = villageois[i];
			System.out.println(gaulois.getNom());
		}
	}

	public static void main(String[] args) {
		Village irreductibles= new Village("Village des Irréductibles",30);
		/*Gaulois gaulois = irreductibles.trouverHabitant(30);*/
		Chef abraracourix = new Chef ("abraracourix",6,irreductibles);
		Gaulois asterix = new Gaulois("Asterix", 8);
		irreductibles.ajouterHabitant(asterix);
		/*Gaulois gaulois = irreductibles.trouverHabitant(1);
		System.out.println(gaulois);*/
		irreductibles.afficherVillageois(abraracourix);
		Gaulois obelix = new Gaulois("Obelix", 25);
		irreductibles.ajouterHabitant(obelix);
		irreductibles.afficherVillageois(abraracourix);
		
	}
	
}
