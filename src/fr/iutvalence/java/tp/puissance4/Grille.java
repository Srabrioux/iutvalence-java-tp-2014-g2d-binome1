package fr.iutvalence.java.tp.puissance4;

/**
 * Représente une grille de Puissance4
 * 
 * @author vallid
 */
public class Grille
{
	/**
	 * Le nombre de lignes
	 */
	public static final int NOMBRE_DE_LIGNES = 6;

	/**
	 * Le nombre de colonnes
	 */
	public static final int NOMBRE_DE_COLONNES = 7;

	/**
	 * Les états des cases de la grille
	 */
	public EtatCase[][] etatsDesCases;

	/**
	 * Création d'une grille vide
	 */
	public Grille()
	{
		this.etatsDesCases = new EtatCase[NOMBRE_DE_LIGNES][NOMBRE_DE_COLONNES];

		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)

				this.etatsDesCases[numeroDeLigne][numeroDeColonne] = EtatCase.VIDE;				
	}

	/**
	 * Obtenir l'état de la case une position donnée
	 * @param position la position
	 * @return l'état de la case la position donnée
	 */
	private EtatCase obtenirCase(Position position)
	{
		if (position.obtenirNumeroDeLigne()<NOMBRE_DE_LIGNES && position.obtenirNumeroDeColonne()<NOMBRE_DE_COLONNES)
		return this.etatsDesCases[position.obtenirNumeroDeLigne()][position.obtenirNumeroDeColonne()];
		
		return null;
	}
	

	/**
	 * Modifier l'état de la case une position donnée
	 * @param position la position
	 * @param nouvelEtat le nouvel état de la case
	 */
	private void changerEtatCase(Position position, EtatCase nouvelEtat)
	{
		// TODO traiter le cas d'erreur (débordement de grille)
		this.etatsDesCases[position.obtenirNumeroDeLigne()][position.obtenirNumeroDeColonne()]=nouvelEtat;
	}

	/**
	 * Savoir si une position est hors de la grille
	 * @param position la position
	 * @return <tt>true</tt> si la position est hors de la grille
	 */
	public boolean estHorsDeLaGrille(Position position)
	{
		// TODO retourner le test, ce serait plus clair
		if (position.obtenirNumeroDeLigne() >=0 && position.obtenirNumeroDeLigne()< NOMBRE_DE_LIGNES)
			if (position.obtenirNumeroDeColonne()>=0 && position.obtenirNumeroDeColonne()< NOMBRE_DE_COLONNES)
				return true;
		return false;
	}
	
	/**
	 * Tenter de poser un jeton dans une colonne de la grille.
	 * 
	 * @param couleur
	 *            la couleur du jeton à poser
	 * @param numeroDeColonne
	 *            le numéro de colonne où poser le jeton
	 * 
	 * @return la position où le jeton a été posée, ou null si la colonne était
	 *         pleine.
	 * 
	 */
	public Position poserJeton(EtatCase couleur, int numeroDeColonne)
	{
		for (int numeroDeLigne = Grille.NOMBRE_DE_LIGNES - 1; numeroDeLigne >= 0; numeroDeLigne--)
		{
			Position position = new Position(numeroDeLigne, numeroDeColonne);
			if (this.obtenirCase(position) == EtatCase.VIDE)
			{
				this.changerEtatCase(position, couleur);
				return position;
			}
		}
		return null;
	}
	
	/**
	 * Permet de savoir si la partie est gagnée, quel que soit l'axe, autour
	 * d'une position
	 * 
	 * @param position
	 *            la position
	 * @return <tt>true</tt> si la partie est gagnée autour de la position
	 */
	public boolean estPartieGagneeAutourDUnePosition(Position position)
	{
		for (Axe axe : Axe.values())
			if (this.estPartieGagneeAutourDUnePositionEtDansUnAxe(position, axe))
				return true;
		return false;
	}

	/**
	 * Permet de savoir si la partie est gagnée autour d'une position dans un
	 * axe donné
	 * 
	 * @param position
	 *            la position
	 * @param axe
	 *            l'axe
	 * 
	 * @return <tt>true</tt> si la partie est gagnée autour de la position dans l'axe
	 */
	private boolean estPartieGagneeAutourDUnePositionEtDansUnAxe(Position position, Axe axe)
	{
		int nombreDeJetonsDansLaDirectionPrincipale = this
				.obtenirNombreDeJetonsAlignesDansUneDirection(position,
						axe.obtenirPrincipale());
		int nombreDeJetonsDansLaDirectionSecondaire = this
				.obtenirNombreDeJetonsAlignesDansUneDirection(position,
						axe.obtenirSecondaire());
		return (nombreDeJetonsDansLaDirectionPrincipale
				+ nombreDeJetonsDansLaDirectionSecondaire + 1 >= 4);
	}
	
	/**
	 * Permet de connaitre le nombre de jetons alignés sur une direction
	 * 
	 * @param position
	 *            Position d'où l'on commence à compter
	 * @param direction
	 *            Direction où l'on compte
	 * @return Le nombre de jetons alignés
	 */
	private int obtenirNombreDeJetonsAlignesDansUneDirection(Position position,
			Direction direction)
	{
		int nombreDeJetonsAlignes = 0;
		Position positionSuivante = position.obtenirVoisine(direction);
		while (true)
		{
			if (this.estHorsDeLaGrille(positionSuivante))
				break;
			if (this.obtenirCase(positionSuivante) != this.obtenirCase(position))
				break;
			nombreDeJetonsAlignes++;
		}
		return nombreDeJetonsAlignes;
	}

	
	/**
	 * Obtenir une représentation en ASCII-art
	 * @see java.lang.Object#toString()
	 */
	public String toString()
	{
		String puissance4EnAscii = "";
		for (int numeroDeLigne = 0; numeroDeLigne < NOMBRE_DE_LIGNES; numeroDeLigne++)
		{
			for (int numeroDeColonne = 0; numeroDeColonne < NOMBRE_DE_COLONNES; numeroDeColonne++)
				puissance4EnAscii += this.obtenirCase(new Position(numeroDeLigne, numeroDeColonne));
			puissance4EnAscii += "\n";
		}
		return puissance4EnAscii;
	}
}
