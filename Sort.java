package rpg;

public abstract class Sort {
	private String nom;
	protected int baseValue;
	protected int coutMp;
	protected boolean estZone;
	protected static final double CRIT_CHANCE_SORTS = 0.10;
	public Sort(String nom, int baseValue, int coutMp, boolean estZone)
	{
		this.nom = nom;
		this.baseValue = baseValue;
		this.coutMp = coutMp;
		this.estZone = estZone;
	}
	public abstract void calculSort(Personnage cible);
	public abstract boolean faitDegats();
	public boolean isCritical()
	{
		return Math.random()<CRIT_CHANCE_SORTS;
	}
	public boolean estZone()
	{
		return estZone;
	}
	public String getNom()
	{
		return nom;
	}
	public int getCout()
	{
		return coutMp;
	}
	
}
