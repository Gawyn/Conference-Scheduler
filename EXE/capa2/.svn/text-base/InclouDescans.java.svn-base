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
 * Implementada per Oscar Camacho
 */
package capa2;

//TODO: Auto-generated Javadoc

/**
 * The Class InclouDescans.
 */
public class InclouDescans implements Activitat {
	
	/** The descans. */
	private Descans descans;
	
	/** The hinici. */
	private Temps hinici;
	
	/** The se. */
	private Sessio se;
	
	/**
	 * The Constructor.
	 * 
	 * @param d the d
	 */
	public InclouDescans(Descans d) {
		
		this.descans = d;
		
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param d the d
	 * @param inici the inici
	 */
	public InclouDescans(Temps inici, Descans d) {
		
		this.descans = d;
		this.hinici = inici;
		
	}
	
	/**
	 * Copy.
	 * 
	 * @param iD the i D
	 */
	public void Copy(InclouDescans iD,Sessio s){
		this.descans=iD.descans;
		this.hinici=iD.hinici;
		this.se=iD.se;
	}
	
	
	/**
	 * Gets the Autor.
	 * 
	 * @return null
	 */
	public Autor GetAutor()
	{
		return null;
	}
	
	// Aquesta part es de la interface
	
	/**
	 * Gets the descans.
	 * 
	 * @return the descans
	 */
	public Descans GetDescans(){
		return descans;
	}
	
	/**
	 * Gets the duracio.
	 * 
	 * @return the int
	 */
	public int GetDuracio() {
		
		return descans.GetDuracio();
		
	}
	
	/**
	 * Gets the inici.
	 * 
	 * @return the temps
	 */
	public Temps GetInici() {
		
		return hinici;
		
	}
	
	/**
	 * Gets the Nom.
	 * 
	 * @return the string
	 */
	public String GetNom()
	{
		
		return descans.GetTipus();
		
	}
	
	/**
	 * Gets the sessio.
	 * 
	 * @return the sessio
	 */
	public Sessio GetSessio() {
		
		return this.se;
		
	}
	
	/**
	 * Gets the tipus.
	 * 
	 * @return the int
	 */
	public int GetTipus(){
		
		return 1;
		
	}
	
	/**
	 * Sets the hinici.
	 * 
	 * @param hinici the hinici
	 */
	public void SetHinici(Temps hinici){
		
		this.hinici = hinici;
		
	}
	
	/**
	 * Sets the inici.
	 * 
	 * @param t the t
	 */
	public void SetInici(Temps t) {
		
		this.hinici = t;
		
	}
	
	/**
	 * Sets the sessio.
	 * 
	 * @param s the s
	 */
	public void SetSessio(Sessio s) {
		
		this.se = s;
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String toString() {
		
		return this.descans.ToString() + " - Starts at: " + this.hinici.toString()+"\n";
		
	}
	
}