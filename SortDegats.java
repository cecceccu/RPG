package rpg;

public class SortDegats extends Sort{
	public static final double VARIANCE_DMG = 0.20;
	protected enum Type
	{
		EAU,
		FEU,
		GLACE,
		TONNERRE,
	}
	private Type type;
	public SortDegats(String nom, int baseValue, int coutMp, boolean estZone, Type type)
	{
		super(nom, baseValue, coutMp, estZone);
		this.type = type;
	}
	public void calculSort(Personnage cible)
	{	
		
		boolean ennemiImmunise = false;
		if(cible instanceof Ennemi)
			{
				 Ennemi e = (Ennemi) cible;
				 if (e.getImmunites().contains(type))
					 ennemiImmunise = true;
			}
		
		if (!cible.getArmure().getImmunites().contains(type)
			&& !ennemiImmunise)
		{
			int dmg = (int) (baseValue*(1+(-1*VARIANCE_DMG+Math.random()
							 *2*VARIANCE_DMG))
						     *(1-cible.getArmure().getreducMag()));
			if (isCritical())
			{
				dmg = dmg * 2;
			}	
			cible.setHp(cible.getHp()-dmg);
		}
		
		
		
	}
	public boolean faitDegats()
	{
		return true;
	}
	public Type getType()
	{
		return type;
	}

}
