package rpg;
import java.util.ArrayList;

public class Jeu {
	private ArrayList<Niveau> listeNiveaux;
	public Jeu(ArrayList<Niveau> lst)
	{
		listeNiveaux = lst;
	}
	
	public void lancerJeu()
	{
		int i = 0;
		while(!PersoJouable.aPerdu() && i<listeNiveaux.size())
		{
			listeNiveaux.get(i).lancerNiveau();
			i++;
		}
		if (PersoJouable.aPerdu())
			System.out.println("Vous avez perdu");
		else
			System.out.println("Felicitations, vous avez terminé tous les niveaux");
		
	}

}
