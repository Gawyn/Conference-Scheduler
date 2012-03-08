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

// TODO: Auto-generated Javadoc

/**
 * La classe Temps.
 */
public class Temps {
	
	/** The hora. */
	private int hora;
	
	/** The minuts. */
	private int minuts;
	
	/**
	 * The Constructor.
	 * 
	 * @param m the m
	 * @param h the h
	 */
	public Temps(int h, int m) {
		
		this.hora = h;
		this.minuts = m;
		
	}
	
	/**
	 * Gets the hora.
	 * 
	 * @return the int
	 */
	public int GetHora() {
		
		return hora;
		
	}

	/**
	 * Sets the hora.
	 * 
	 * @param hora the hora
	 */
	public void SetHora(int hora) {
		
		this.hora = hora;
		
	}

	/**
	 * Gets the minuts.
	 * 
	 * @return the int
	 */
	public int GetMinuts() {
		
		return minuts;
		
	}

	/**
	 * Sets the minuts.
	 * 
	 * @param minuts the minuts
	 */
	public void SetMinuts(int minuts) {
		
		this.minuts = minuts;
		
	}

	
	/**
	 * Temps to pes.
	 * 
	 * @return the int
	 */
	public int TempsToPes()
	{
		return (hora * 60) + minuts;
	}
	
	/**
	 * Pes to temps.
	 * 
	 * @param pes the pes
	 */
	public void PesToTemps(int pes) {
		
		Temps t_inici;
		int pesInicial;
		Congres c = Congres.GetInstance();
		t_inici = c.GetHinici();
		
		pesInicial = t_inici.TempsToPes();
		pesInicial = pesInicial + pes;
		
		hora=pesInicial / 60;
		minuts=pesInicial % 60;
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String toString() {
		
		return Prop.LPAD(this.hora + "", '0', 2) + ":" + Prop.LPAD(this.minuts + "", '0', 2);
		
	}

	public String ToString() {
		
		return Prop.LPAD(this.hora + "", '0', 2) + ":" + Prop.LPAD(this.minuts + "", '0', 2);
		
	}
}	

