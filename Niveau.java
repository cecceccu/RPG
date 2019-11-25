package rpg;

import java.util.ArrayList;
import java.util.Scanner;


public class Niveau {
	private ArrayList<Ennemi> listeEnnemis = new ArrayList<Ennemi>();
	private ArrayList<Ennemi> ennemisVivants = new ArrayList<Ennemi>();
	
	public Niveau (ArrayList<Ennemi> listeEnnemis)
	{
		this.listeEnnemis = listeEnnemis;
		ennemisVivants = listeEnnemis;
	}
	public void lancerNiveau()
	{
		Scanner scan = new Scanner (System.in);
		int x = 0;
		while (ennemisVivants.size()>0 && !PersoJouable.aPerdu())
		{
			for (PersoJouable p : PersoJouable.getJoueursVivants())
			{
				System.out.println("Joueurs : ");
				for (PersoJouable pers : PersoJouable.getJoueursVivants())
					System.out.println(pers);
				System.out.println("Ennemis : ");
				for (Ennemi enn : ennemisVivants)
					System.out.println(enn);
				System.out.println("Menu : " + p.getNom() + " :\n");
				System.out.println("1 : Attaquer ");
				System.out.println("2 : Lancer un sort ");
				System.out.println("3 : Équiper une arme ");
				System.out.println("4 : Équiper une armure ");
				System.out.println("Entrez le numéro correspondant à l'action à effectuer : ");
				x = scan.nextInt();
				
				switch(x)
				{
				case 1 :
					p.attaquePhys(this);
					break;
				case 2 :
					p.lancerSort(this);
					break;
				case 3 :
					p.choisirArme();
					break;
				case 4 :
					p.choisirArmure();
					break;
				default :
					System.out.println("Erreur de saisie, vous passez votre tour");
				}
			}
			for (Ennemi e : ennemisVivants)
			{
				if (e.getSorts().size() == 0)
					e.attaquePhys();
				else
				{	
					double rand = Math.random();
					if (rand<0.5)
						e.attaquePhys();
					else
						e.lancerSort(this);
				}
			}
			if (ennemisVivants.size() == 0)
			{
				System.out.println("Felicitations, passage au niveau suivant");
				PersoJouable.partyLevelUp();
				PersoJouable.setPersosVivants(PersoJouable.getListeJoueurs()); // On ressuscite/soigne les personnages entre les niveaux
				for (PersoJouable p : PersoJouable.getJoueursVivants())
				{
					p.setHp(p.getMaxHp());
					p.setMp(p.getMaxMp());
				}
			}
		}
	}
	public ArrayList<Ennemi> getListeEnnemis()
	{
		return listeEnnemis;
	}
	public ArrayList<Ennemi> getEnnemisVivants()
	{
		return ennemisVivants;
	}
	

}
