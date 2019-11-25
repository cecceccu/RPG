package rpg;
import java.util.ArrayList;

	public class Arme extends Equipement{
	private int baseDmg;
	private double accuracy;
	private static final double CRIT_CHANCE_ARMES = 0.10;
	private static ArrayList<Arme> listeArmes = new ArrayList<Arme>();
	
	public Arme(String nom, int baseDmg, double accuracy)
	{
		super(nom);
		this.baseDmg = baseDmg;
		this.accuracy = accuracy;
		
		listeArmes.add(this);
	}
	public Arme(String nom, int baseDmg, double accuracy, Personnage proprietaire)
	{
		super(nom, proprietaire);
		this.baseDmg = baseDmg;
		this.accuracy = accuracy;
	}
	
	private boolean isCritical() 
	{
		return Math.random()<=CRIT_CHANCE_ARMES;
	}
	private boolean reussie()
	{
		return Math.random()<=accuracy;
	}
	public void calculDmg(Personnage cible)
	{
		if (reussie())
		{
			int degats =(int) (baseDmg*(1-cible.getArmure().getReducPhys()));
			if (isCritical())
			{
				degats = degats*2;
			}
			cible.setHp(cible.getHp()-degats);
		}

	}
	public static ArrayList<Arme> getListeArmes()
	{
		return listeArmes;
	}
	public void equiper(Personnage p)
	{
		if (this.getProprietaire() == null)
		{
			if (p instanceof PersoJouable)
				listeArmes.add(p.getArme());
			p.getArme().desequiper();
			this.setProprietaire(p);
			p.setArme(this);
			listeArmes.remove(this);
		}
		else 
		{
			System.out.println("Impossible d'équiper l'arme " + this.getNom() + " à " + p.getNom());
		}
				
	}
	
	@Override
	public String toString()
	{
		return getNom() + " : (atk :" + baseDmg + ", acc :" + accuracy + ")";
	}
	
	
	
	
	

}
