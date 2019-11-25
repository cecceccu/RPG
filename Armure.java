package rpg;
import java.util.ArrayList;

public class Armure extends Equipement{
	private double reducDegatsPhys;
	private double reducDegatsMag;
	private ArrayList<SortDegats.Type> immunites;
	public static ArrayList<Armure> listeArmures = new ArrayList<Armure>();
	public Armure(String nom, double reducDegatsPhys, double reducDegatsMag, ArrayList<SortDegats.Type> immunites)
	{
		super(nom);
		if (reducDegatsPhys>=0 && reducDegatsPhys<=1) 
			this.reducDegatsPhys = reducDegatsPhys;
		else 
			this.reducDegatsPhys = 0.1;//Valeur par défaut
		if (reducDegatsMag>=0 && reducDegatsMag<=1) 
			this.reducDegatsMag = reducDegatsMag;
		else 
			this.reducDegatsMag = 0.1;
		this.immunites = immunites;
		listeArmures.add(this);
	}
	public Armure(String nom, double reducDegatsPhys, double reducDegatsMag, ArrayList<SortDegats.Type> immunites, Personnage proprietaire)
	{
		super(nom, proprietaire);
		if (reducDegatsPhys>=0 && reducDegatsPhys<=1) 
			this.reducDegatsPhys = reducDegatsPhys;
		else 
			this.reducDegatsPhys = 0.1;
		if (reducDegatsMag>=0 && reducDegatsMag<=1) 
			this.reducDegatsMag = reducDegatsMag;
		else 
			this.reducDegatsMag = 0.1;
		this.immunites = immunites;
		this.equiper(proprietaire);
		
	}
	public static ArrayList<Armure> getListeArmures()
	{
		return listeArmures;
	}
	public void equiper(Personnage p)
	{
		if (this.getProprietaire() == null)
		{
			if (p instanceof PersoJouable)
				listeArmures.add(p.getArmure());
			p.getArmure().desequiper();
			this.setProprietaire(p);
			p.setArmure(this);
			listeArmures.remove(this);
		}
		else 
		{
			System.out.println("Impossible d'équiper l'armure " + this.getNom() + " à " + p.getNom());
		}
				
	}
	public double getReducPhys()
	{
		return reducDegatsPhys;
	}
	public double getreducMag()
	{
		return reducDegatsMag;
	}
	public ArrayList<SortDegats.Type> getImmunites()
	{
		return immunites;
	}
	@Override
	public String toString()
	{
		return getNom() + " : ( Def : " +  reducDegatsPhys + ", Res : " + reducDegatsMag + ")";
	}

}
