package personnage;

public class Musee {
	private Trophee[] trophees=new Trophee[200];
	private int nbTrophee= 0;
	public Musee(Trophee[] trophees, int nbTrophee) {
		super();
		this.trophees = trophees;
		this.nbTrophee = nbTrophee;
	}
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		Trophee nouvelleTrophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee]= nouvelleTrophee;
		nbTrophee++;
	}
	public int getNbTrophee() {
		return nbTrophee;
	}
	
	public String extraireInstructionsOCaml() {
		String texte = "let musee = [ "; 
		for (int i=0; i<nbTrophee; i++) {
			texte += trophees[i].donnerNom() + "," + trophees[i].getEquipement() + ";";
		}
		texte += "\n ]";
		return texte;
	}
	
	
}
