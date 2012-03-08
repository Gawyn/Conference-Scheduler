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
 * Implementada per Clemente Tort
 */
package capa2;



import java.util.*;

// TODO: Auto-generated Javadoc


/**
 * The Class Tema.
 */
public class Tema {
	
	/** The com. */
	private List<Comunicacio> com; 	//ha de ser una list de rel
	
	/** The nom. */
	private String nom;
	
	//	 Constructora de tema
	/**
	 * The Constructor.
	 * 
	 * @param nom the nom
	 */
	public Tema(String nom) {

		this.nom = nom;
		com = new ArrayList<Comunicacio>();
	}
	
	//	s'afegeix una comunicacio a un tema
	/**
	 * Afegir com.
	 * 
	 * @param c the c
	 * 
	 * @throws Exception the exception
	 */
	public void AfegirCom(Comunicacio c) throws Exception {
		
		if(com.size() == 0)com.add(c);
		else {
		if(!com.contains(c)) {
			boolean b = false;
			int i=0;
			while(!b) 	//quan b=true es que hem afegit la comunicacio
				{
				if(com.get(i).GetDuracio() > c.GetDuracio()) i++; 	//si la com[i] dura mes que la que volem afegir, passem
				else if(com.get(i).GetDuracio() < c.GetDuracio())		 // si duracio es mes petita, afegim al seu lloc 
					{
						com.add(i,c);
						b = true;
					}
				else if(com.get(i).GetDuracio() == c.GetDuracio()) 	//si duracio es igual, mirem la comunicacio que tingui mes temes, que anira primera
				{
					if(com.get(i).GetTemes().size() > c.GetTemes().size())
						{
							com.add(i + 1,c);
							b = true;
						}
					else if(com.get(i).GetTemes().size() < c.GetTemes().size()) 
						{
							com.add(i,c);
							b = true;
						}
					else 	// si tenen el mateix numero de temes, es mira la que tingui mes comProperes, que anira al davant.
					{
						/**if(com.get(i).GetComProp().size() > c.GetComProp().size()) 
							{
								com.add(i + 1,c);
								b = true;
							}
						else 
							{
								com.add(i,c);
								b = true;
							}**/
					}
				}
			}
			}
		}
	}
	
	
	
	/**
	 * Rem com.
	 * 
	 * @param n the n
	 */
	public void RemCom(int n) {
		
		com.remove(n);
		
	}
	
	/**
	 * Gets the com.
	 * 
	 * @param n the n
	 * 
	 * @return the comunicacio
	 */
	public Comunicacio GetCom(int n) {
		
		return com.get(n);
		
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
		
		return this.nom;
		
	}
	
	/**
	 * Gets the list com.
	 * 
	 * @return the list< comunicacio>
	 */
	public List<Comunicacio> GetListCom(){
		
		return this.com;
		
	}

}