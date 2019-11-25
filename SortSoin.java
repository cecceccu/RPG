package rpg;

public class SortSoin extends Sort{
	public static final double VARIANCE_HEAL = 0.10;
	public SortSoin(String nom, int baseValue, int coutMp, boolean estZone)
	{
		super(nom, baseValue, coutMp, estZone);
	}
	public void calculSort(Personnage cible)
	{
		int heal = (int) (baseValue*(1+(-1*VARIANCE_HEAL+Math.random()*2*VARIANCE_HEAL)));
		if (isCritical())
		{
			heal = heal * 2;
		}
		cible.setHp(cible.getHp()+heal);
	}
	public boolean faitDegats()
	{
		return false;
	}

}
