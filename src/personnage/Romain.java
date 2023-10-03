package personnage;

public class Romain {
	private String nom;
	private int force;
	private boolean vainqueur=false;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement=0;
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public boolean isVainqueur() {
		return vainqueur;
	}

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 2 : 
			System.out.println("Le Soldat "+nom+"est déjà bien protogé .");
		break;
		case 1 :
			if (equipements[0]==equipement) {
				System.out.println("Le Soldat "+nom+" possede deja� un "+equipement+"!");
			} else {
				bonEquipement(nbEquipement,equipement);
			}
		break;
		default:
			bonEquipement(nbEquipement, equipement);
		break;
		}
	}
	private void bonEquipement(int nbEquipement , Equipement equipement) {
		System.out.println("Le Soldat "+nom+" s'equipe avec un "+equipement+".");
		equipements[nbEquipement]=equipement;
		nbEquipement++;
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
	/*public void recevoirCoup(int forceCoup) {
		assert forceCoup>0;
		int forceAvantCoup=force;
		force -= forceCoup ;
		if (force>0) {
			parler("Aie !");
		} else {
			parler("J'abondonne ..");
		}
		assert force-forceAvantCoup<0;

	}*/
	public Equipement[] recevoirCoup(int forceCoup) {
        Equipement[] equipementEjecte = null;
        // précondition
        assert force > 0;
        int oldForce = force;
        forceCoup = calculResistanceEquipement(forceCoup);
        force -= forceCoup;
        if (force > 0) {
        	parler("Aïe");
        } else {
        	vainqueur=true;
        	equipementEjecte=ejecterEquipement();
            parler("J'abandonne...");
        }
     // post condition la force a diminuée
        parler("mon ancienne force est "+oldForce+" et ma nouvelle force est "+force);
        assert force < oldForce;
        return equipementEjecte;
}
	
	private int calculResistanceEquipement(int forceCoup) {
		String texte;
        texte = "Ma force est  de " + this.force + ", et la force du coup est de " + forceCoup;
        int resistanceEquipement = 0;
        if (nbEquipement != 0) {
             texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
             for (int i = 0; i < nbEquipement;) {
                  if ((equipements[i] != null &&
equipements[i].equals(Equipement.BOUCLIER))) {
                       resistanceEquipement += 8;
                  } else {
                       System.out.println("Equipement casque");
                       resistanceEquipement += 5;
                  }
}
             texte += resistanceEquipement + "!";
        }
        parler(texte);
        if (resistanceEquipement>forceCoup) {
        	forceCoup=0;
        }
        else {
        	 forceCoup -= resistanceEquipement;
        }
               return forceCoup;
}
private Equipement[] ejecterEquipement() {
Equipement[] equipementEjecte = new Equipement[nbEquipement]; System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
        int nbEquipementEjecte = 0;
        for (int i = 0; i < nbEquipement; i++) {
        	if (equipements[i] != null) {
        		equipementEjecte[nbEquipementEjecte] =
        				equipements[i];
        		nbEquipementEjecte++;
        				equipements[i] = null;
} 
}
      return equipementEjecte;
 }

        

        
	


	public static void main(String[] args) {
		Romain minus = new Romain("Minus",7);
		System.out.println(minus.prendreParole());
		//minus.recevoirCoup(8);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);	
		//lesGaulois
	}

}
