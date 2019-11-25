package rpg;

import java.util.ArrayList;

public class Ennemi extends Personnage{
	private ArrayList<SortDegats.Type> immunites;
	public Ennemi(int maxHp, Arme arme, Armure armure, ArrayList<Sort> sorts, ArrayList<SortDegats.Type> immunites, String nom)
	{
		super(maxHp, Integer.MAX_VALUE/2, arme, armure, nom, sorts);
		this.immunites=immunites;
	
		
	}
	public Ennemi(int maxHp, Arme arme, Armure armure, String nom)
	{
		super(maxHp, Integer.MAX_VALUE/2, arme, armure, nom);
		immunites = new ArrayList<SortDegats.Type>();
	}
	public ArrayList<SortDegats.Type> getImmunites()
	{
		return immunites;
	}
	
	public void attaquePhys()
	{
		
		int numCible = 0;
		numCible = (int) Math.random()*PersoJouable.getJoueursVivants().size();
		System.out.println(getNom() + " attaque " + (PersoJouable.getJoueursVivants().get(numCible).getNom()));
		this.getArme().calculDmg(PersoJouable.getJoueursVivants().get(numCible));
		if (PersoJouable.getJoueursVivants().get(numCible).getHp() == 0)
			PersoJouable.getJoueursVivants().remove(PersoJouable.getJoueursVivants().get(numCible));
	}
	public void lancerSort(Niveau niv)
	{
		int index = (int) Math.random()*getSorts().size();
		Sort spell = getSorts().get(index);
		if (spell.getCout()<=getMp())
		{
			if (spell.faitDegats())
			{
				if (!spell.estZone())
				{
					int numCible = (int) Math.random()*PersoJouable.getJoueursVivants().size();
					spell.calculSort(PersoJouable.getJoueursVivants().get(numCible));
					System.out.println(getNom() + " lance " + spell.getNom() + "sur " 
					+ (PersoJouable.getJoueursVivants().get(numCible).getNom()));
					if (PersoJouable.getJoueursVivants().get(numCible).getHp() == 0)
						PersoJouable.getJoueursVivants().remove(numCible);
				}
				else
				{
					for (PersoJouable p : PersoJouable.getJoueursVivants())
					{
						spell.calculSort(p);
						System.out.println(getNom() + " lance " + spell.getNom());
						if (p.getHp() == 0)
							PersoJouable.getJoueursVivants().remove(p);
					}
				}
			}
			else
			{
				if (!spell.estZone())
				{
					int numCible = (int) Math.random()*niv.getEnnemisVivants().size();
					System.out.println(getNom() + " soigne " + niv.getEnnemisVivants().get(numCible).getNom());
					spell.calculSort(niv.getEnnemisVivants().get(numCible));
				}
				else
				{
					for (Ennemi e : niv.getEnnemisVivants())
					{
						System.out.println(getNom() + " soigne tous les ennemis");
						spell.calculSort(e);
					}
				}
			}
			this.setMp(this.getMp()-spell.getCout());
		}
		else
		{
			System.out.println("Mp insuffisants");
		}
				
	}
	
	@Override
	public String toString()
	{
		return getNom() + " : HP :" + getHp() + "/" + getMaxHp(); 
	}
	
}
