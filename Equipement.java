package rpg;

public abstract class Equipement {
	private final String nom;
	private Personnage proprietaire;
	public Equipement(String nom)
	{
		this.nom = nom;
		this.proprietaire = null;
		
	}
	
	public Equipement(String nom, Personnage proprietaire)
	{
		this(nom);
		this.proprietaire = proprietaire;
	}
	public abstract void equiper(Personnage p);
	public String getNom()
	{
		return nom;
	}
	protected void desequiper()
	{
		this.proprietaire = null;
	}
	public Personnage getProprietaire()
	{
		return proprietaire;
	}
	public void setProprietaire(Personnage p)
	{
		this.proprietaire = p;
	}

}
