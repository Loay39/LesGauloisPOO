package personnage;

public class Romain {
	private String nom;
	private String texte;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipements=0;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert force>0;
	}
	public void sEquiper(Equipement equipement) {
		switch (nbEquipements) {
		case 2 : 
			System.out.println("Le Soldat "+nom+"est deja  bien protoge .");
			break;
		case 1 :
			if (equipements[0]==equipement) {
				System.out.println("Le Soldat "+nom+" possede deja  un "+equipement+"!");
			} else {
				bonEquipement(1,equipement);
			}
			break;
		default:
			bonEquipement(0, equipement);
			break;
		}	
	}
	private void bonEquipement(int indice, Equipement equipement) {
		System.out.println("Le Soldat "+nom+" s'equipe avec un "+equipement+".");
		equipements[indice]=equipement;
		nbEquipements++;
	}
	public void parler(String texte) {
	 System.out.println(prendreParole() + "Â« " + texte + "Â»");
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
		assert forceCoup>0;
		int forceAvantCoup=force;
		force -= forceCoup ;
		if (force>0) {
			parler("Aie !");
		} else {
			parler("J'abondonne ..");
		}
		assert force-forceAvantCoup<0;

	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus",7);
		System.out.println(minus.prendreParole());
		minus.recevoirCoup(8);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);	
		//lesGaulois
	}

}
