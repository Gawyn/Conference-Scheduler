/* PRACTICA PROP CLUSTER 6.1
 * ===================================
 * Enunciat 1: Generador d'horaris  ==
 * ===================================
 * 
 * Rosina Garcia 
 * Clemente Tort
 * Cristian Planas
 * Oscar Camacho
 * © 2006. 
 * 
 * Implementat per: Cristian Planas
 */


package capa2;

// TODO: Auto-generated Javadoc

/**
 * The Class Autor.
 */
public class Autor {
	
	/** The NUM. */
	private static int NUM;
	
	/** The id. */
	private int id;
	
	/** The nom. */
	private String nom;
	
	/** The cognoms. */
	private String cognoms;
	
	//	constructora d'autor	
	/**
	 * The Constructor.
	 * 
	 * @param cognoms the cognoms
	 * @param nom the nom
	 */
	public Autor(String nom, String cognoms) {
		
		NUM++;
		
		this.id = NUM;
		this.nom = nom;
		this.cognoms = cognoms;
		
	}
	
	/**
	 * Gets the cognoms.
	 * 
	 * @return the string
	 */
	public String GetCognoms() {
		
		return cognoms;
		
	}

	/**
	 * Sets the cognoms.
	 * 
	 * @param cognoms the cognoms
	 */
	public void SetCognoms(String cognoms) {
		
		this.cognoms = cognoms;
		
	}

	/**
	 * Gets the id.
	 * 
	 * @return the int
	 */
	public int GetId() {
		
		return id;
		
	}

	/**
	 * Sets the id.
	 * 
	 * @param id the id
	 */
	public void SetId(int id) {
		
		this.id = id;
		
	}

	/**
	 * Gets the nom.
	 * 
	 * @return the string
	 */
	public String GetNom() {
		
		return nom;
		
	}

	/**
	 * Sets the nom.
	 * 
	 * @param nom the nom
	 */
	public void SetNom(String nom) {
		
		this.nom = nom;
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String toString() {
		
		return this.cognoms + ", " + this.nom;
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String ToString() {
		
		return this.cognoms + ", " + this.nom;
		
	}
}
