package rpg;
import java.util.ArrayList;

public abstract class Personnage {
	private final String nom;
	private int hp;
	private int mp;
	private int maxHp;
	private int maxMp;
	private ArrayList<Sort> sorts;
	private Arme arme;
	private Armure armure;
	public Personnage(int maxHp, int maxMp, Arme arme, Armure armure, String nom){
		this.hp=maxHp;
		this.mp=maxMp;
		this.maxHp=maxHp;
		this.maxMp=maxMp;
		this.arme=arme;
		this.armure=armure;
		Arme.getListeArmes().remove(arme);
		Armure.getListeArmures().remove(armure);
		this.nom=nom;
		sorts = new ArrayList<Sort>();
	}
	public Personnage(int maxHp, int maxMp, Arme arme, Armure armure, String nom, ArrayList<Sort> sorts){
		this(maxHp, maxMp, arme, armure, nom);
		this.sorts=sorts;
	}
	
	
	
	/*On met un niveau en paramètre de la méthode lancerSort car on a besoin de savoir
	  dans quel niveau on se situe pour accéder à la liste d'ennemis  de ce niveau
	  étant des cibles potentielles*/
	public abstract void lancerSort(Niveau niv);
	public boolean estVivant()
	{
		boolean retour = true;
		if (hp == 0)
			retour = false;
		return retour;
			
	}
	//public abstract void attaquePhys(Niveau niv);
	public void ajouterSort(Sort s)
	{
		sorts.add(s);
	}
	public void setHp(int hp)
	{
		if (hp<0)
			this.hp=0;
		else if (hp>maxHp)
			this.hp=maxHp;
		else
			this.hp = hp;
	}
	public void setMaxHp(int maxHp)
	{
		this.maxHp = maxHp;
	}
	public int getHp()
	{
		return hp;
	}
	public ArrayList<Sort> getSorts()
	{
		return sorts;
	}
	public Arme getArme()
	{
		return arme;
	}
	public void setArme(Arme a)
	{
		this.arme = a;
	}
	public Armure getArmure()
	{
		return armure;
	}
	public void setArmure(Armure a)
	{
		this.armure = a;
	}
	public String getNom()
	{
		return nom;
	}
	public int getMp()
	{
		return mp;
	}
	public int getMaxHp()
	{
		return maxHp;
	}
	public int getMaxMp()
	{
		return maxMp;
	}
	public void setMp(int val)
	{
		if (val<0)
			mp = 0;
		else if (val>maxMp)
			mp = maxMp;
		else
			mp = val;
	}
	public void setMaxMp(int maxMp)
	{
		this.maxMp = maxMp;
	}
	
}
