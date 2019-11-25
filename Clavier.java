package rpg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
/** Classe fournissant des fonctions de lecture au clavier en mode Console
 * @author Evelyne Vittori
  * 
 */ 
public class Clavier
	{ /** Méthode de lecture d'une chaîne de caractères au clavier en mode console
	 * @param msg message à afficher pour demander à l'utilisateur de saisir une chaine au clavier 
	 * @return chaîne de caractère lue
	 */
	public static String lireString (String msg)   // lecture d'une chaine
	  { String ligne_lue = null ;
	    //Affichage du message de demande
	    System.out.print(msg);
	    try
	    { // tentative de lecture de l'entrée standard référencée par System.ini
	      InputStreamReader lecteur = new InputStreamReader (System.in) ;
	      BufferedReader entree = new BufferedReader (lecteur) ;
	      ligne_lue = entree.readLine() ;
	    }
	    catch (IOException err)
	    { System.exit(0) ;
	    }
	    return ligne_lue ;
	  }
	/** Méthode de lecture d'un réel (float) au clavier en mode console
	 * @param msg message à afficher pour demander à l'utilisateur de saisir un réel au clavier 
	 * @return réel (float) lu au clavier
	 */
	public static float lireFloat (String msg)   // lecture d'un float
	  { float x=0 ;   // valeur a lire
	    try
	    { String ligne_lue = lireString(msg) ;
	      x = Float.parseFloat(ligne_lue) ;// Conversion de la chaîne ligne_lue en float
	    }
	    catch (NumberFormatException err)
	    { System.out.println ("*** Erreur de saisie ***") ;
	      System.exit(0) ;
	    }
	    return x ;
	  }
	/** Méthode de lecture d'un réel (double) au clavier en mode console
	 * @param msg message à afficher pour demander à l'utilisateur de saisir un réel au clavier 
	 * @return réel (double) lu au clavier
	 */
	  public static double lireDouble (String msg)   // lecture d'un double
	  { double x=0 ;   // valeur a lire
	    try
	    { String ligne_lue = lireString(msg) ;
	      x = Double.parseDouble(ligne_lue) ; // Conversion de la chaîne ligne_lue en double
	    }
	    catch (NumberFormatException err)
	    { System.out.println ("*** Erreur de saisie ***") ;
	      System.exit(0) ;
	    }
	    return x ;
	  }
	  /** Méthode de lecture d'un entier (int) au clavier en mode console
		 * @param msg message à afficher pour demander à l'utilisateur de saisir un entier au clavier 
		 * @return entier(int) lu au clavier
		 */
	  public static int lireInt (String msg)         // lecture d'un int
	  { int n=0 ;   // valeur a lire
	    try
	    { String ligne_lue = lireString(msg) ;
	      n = Integer.parseInt(ligne_lue) ; // Conversion de la chaîne ligne_lue en int
	      }
	    catch (NumberFormatException err)
	    { System.out.println ("*** Erreur de donnee ***") ;
	      System.exit(0) ;
	    }
	    return n ;
	  }
	}
	  /** Programme de test de la classe Clavier
	   */

