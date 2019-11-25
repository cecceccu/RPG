package rpg;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
	
	public static void main(String[] args)
	{
		SortDegats feu = new SortDegats("Feu", 50, 10, false, SortDegats.Type.FEU); 
		SortDegats eau = new SortDegats("Eau", 50, 10, false, SortDegats.Type.EAU); 
		SortDegats glace = new SortDegats("Glace", 50, 10, false, SortDegats.Type.GLACE); 
		SortDegats foudre = new SortDegats("Foudre", 50, 10, true, SortDegats.Type.TONNERRE); 
		SortSoin soin = new SortSoin("Soin", 50, 35, false);
		Armure a1 = new Armure("a1", 0.1, 0.1, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.EAU, SortDegats.Type.FEU)));
		Armure a2 = new Armure("a2", 0.15, 0.05, new ArrayList<SortDegats.Type>());
		Armure a3 = new Armure("a3", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.TONNERRE)));
		Armure a4 = new Armure("a4", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU)));
		Armure a5 = new Armure("a4", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU)));
		Armure a6 = new Armure("a4", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU)));
		Armure a7 = new Armure("a4", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU)));
		Armure a8 = new Armure("a4", 0.2, 0.2, new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU)));
		Arme a11 = new Arme("a11", 25, 0.85);
		Arme a22 = new Arme("a22", 15, 0.99);
		Arme a33 = new Arme("a33", 85, 0.77);
		Arme a44 = new Arme("a33", 85, 0.77);
		Arme a55 = new Arme("a33", 85, 0.77);
		Arme a66 = new Arme("a33", 85, 0.77);
		Arme a77 = new Arme("a33", 85, 0.77);
		Arme a88 = new Arme("a33", 85, 0.77);
		
		ArrayList<Sort> lst_sorts = new ArrayList<Sort>(Arrays.asList(feu, glace, soin));
		ArrayList<SortDegats.Type> lst_types = new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.TONNERRE));
		ArrayList<SortDegats.Type> lst_types_2 = new ArrayList<SortDegats.Type>(Arrays.asList(SortDegats.Type.FEU, SortDegats.Type.EAU));
		
		Ennemi e3 = new Ennemi(200, a55, a5, lst_sorts, lst_types_2, "e3");
		Ennemi e4 = new Ennemi(350, a66, a6, lst_sorts, lst_types, "e4");
		Ennemi e5 = new Ennemi(350, a77, a7, lst_sorts, lst_types, "e5");
		Ennemi e6 = new Ennemi(350, a77, a7, lst_sorts, lst_types, "e6");
		
		e3.ajouterSort(foudre);
		
		PersoJouable p1 = new PersoJouable(250, 100, a11, a1, new ArrayList<Sort>(Arrays.asList(feu, foudre)), "Tidus");
		PersoJouable p2 = new PersoJouable(200, 150, a22, a2, new ArrayList<Sort>(Arrays.asList(eau, glace, soin)), "Rikku");
		ArrayList<Ennemi> lst1 = new ArrayList<Ennemi>(Arrays.asList(new Ennemi(300, a33, a3, "e1"),
				new Ennemi(450, a44, a4, lst_sorts, lst_types, "e2" ), e3));
		ArrayList<Ennemi> lst2 = new ArrayList<Ennemi>(Arrays.asList(e4, e5, e6));
		Niveau n1 = new Niveau(lst1);
		Niveau n2 = new Niveau(lst2);
		Jeu j = new Jeu(new ArrayList<Niveau>(Arrays.asList(n1, n2)));
		j.lancerJeu();
	}
	
	

}
