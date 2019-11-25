package rpg;
import java.util.ArrayList;
import java.util.Scanner;
public class PersoJouable extends Personnage{
	public static int partyLevel = 1;
	private static ArrayList<PersoJouable> listePersos = new ArrayList<PersoJouable>();
	private static ArrayList<PersoJouable> joueursVivants = new ArrayList<PersoJouable>();
	public PersoJouable(int maxHp, int maxMp, Arme arme, Armure armure, String nom)
	{
		super(maxHp, maxMp, arme, armure, nom);
		listePersos.add(this);
		joueursVivants.add(this);
	}
	public PersoJouable(int maxHp, int maxMp, Arme arme, Armure armure, ArrayList<Sort> sorts, String nom)
	{
		super(maxHp, maxMp, arme, armure, nom, sorts);
		listePersos.add(this);
		joueursVivants.add(this);
	}
	public static ArrayList<PersoJouable> getListeJoueurs()
	{
		return listePersos;
	}
	public static ArrayList<PersoJouable> getJoueursVivants()
	{
		return joueursVivants;
	}
	public static void setPersosVivants(ArrayList<PersoJouable> lst)
	{
		joueursVivants = lst;
	}
	public void attaquePhys(Niveau niv)
	{
		System.out.println("Choix de la cible : ");
		for (int i=1; i<=niv.getEnnemisVivants().size(); i++)
		{
			System.out.println(i + " : " + niv.getEnnemisVivants().get(i-1));
		}
		Scanner sc = new Scanner (System.in);
		System.out.println("Entrez le numéro correspondant à la cible : ");
		int x = sc.nextInt();
		;
		this.getArme().calculDmg(niv.getEnnemisVivants().get(x-1));
		if (niv.getEnnemisVivants().get(x-1).getHp() == 0)
			niv.getEnnemisVivants().remove(x-1);
		
	}
	public void lancerSort(Niveau niv)
	{
		System.out.println("Choix du sort : ");
		for (int i=1; i<=this.getSorts().size(); i++)
		{
			System.out.println(i + " : " + this.getSorts().get(i-1).getNom());
		}
		Scanner sc = new Scanner (System.in);
		System.out.println("Entrez le numéro correspondant au sort: ");
		int x = sc.nextInt();
		Sort spell = getSorts().get(x-1);
		if (spell.getCout()<=getMp())
		{
			if (spell.faitDegats())
			{
				if (!spell.estZone())
				{
					System.out.println("Choix de la cible : ");
					for (int i=1; i<=niv.getEnnemisVivants().size(); i++)
					{
						System.out.println(i + " : " + niv.getEnnemisVivants().get(i-1));
					}
					Scanner sc2 = new Scanner (System.in);
					System.out.println("Entrez le numéro correspondant à la cible : ");
					int y = sc2.nextInt();
					spell.calculSort(niv.getEnnemisVivants().get(y-1));
					if (niv.getEnnemisVivants().get(y-1).getHp() == 0)
						niv.getEnnemisVivants().remove(y-1);
				}
				else
				{
					for (Ennemi e : niv.getEnnemisVivants())
					{
						spell.calculSort(e);
						if (e.getHp() == 0)
							niv.getEnnemisVivants().remove(e);
					}
				}
			}
			else
			{
				if (!spell.estZone())
				{
					System.out.println("Choix de la cible : ");
					for (int i=1; i<=joueursVivants.size(); i++)
					{
						System.out.println(i + " : " + joueursVivants.get(i-1));
					}
					Scanner sc3 = new Scanner (System.in);
					System.out.println("Entrez le numéro correspondant à la cible : ");
					int z = sc3.nextInt();
					spell.calculSort(joueursVivants.get(z-1));
				}
				else
				{
					for (PersoJouable p : joueursVivants)
					{
						spell.calculSort(p);
					}
				}
			}
			this.setMp(getMp()-spell.getCout());
		}
		else
		{
			System.out.println("Mp insuffisants");
		}
	}
	public void choisirArme()
	{
		System.out.println("Choix de l'arme : ");
		for (int i=1; i<=Arme.getListeArmes().size(); i++)
		{
			System.out.println(i + " : " + Arme.getListeArmes().get(i-1));
		}
		Scanner sc = new Scanner (System.in);
		System.out.println("Entrez le numéro correspondant à l'arme : ");
		int x = sc.nextInt();
		Arme.getListeArmes().get(x-1).equiper(this);
	}
	public void choisirArmure()
	{
		System.out.println("Choix de l'armure : ");
		for (int i=1; i<=Armure.getListeArmures().size(); i++)
		{
			System.out.println(i + " : " + Armure.getListeArmures().get(i-1));
		}
		Scanner sc = new Scanner (System.in);
		System.out.println("Entrez le numéro correspondant à l'armure : ");
		int x = sc.nextInt();
		Armure.getListeArmures().get(x-1).equiper(this);
	}
	public static void partyLevelUp()
	{
		partyLevel++;
		for (PersoJouable p : listePersos)
		{
			p.setMaxHp((int) (1.1*p.getMaxHp()));
			p.setMaxMp((int) (1.1*p.getMaxMp()));
		}
	}
	
	public static boolean aPerdu()
	{
		return joueursVivants.size() == 0;
	}
	
	@Override
	public String toString()
	{
		return getNom() + " : HP :" + getHp() + "/" + getMaxHp() + ", mp :" + getMp() + "/" + getMaxMp()
		+", arme :" + getArme() + ", armure :" + getArmure(); 
	}

}
