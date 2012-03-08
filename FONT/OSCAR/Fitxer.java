/* PRACTICA PROP CLUSTER 6.1
 * ===================================
 * Enunciat 1: Generador d'horaris  ==
 * ===================================
 * 
 * Rosina Garcia 
 * Clemente Tort
 * Cristian Planas
 * Oscar Camacho
 * � 2006. 
 * 
 * Implementada per Oscar Camacho
 */
package capa3;

import java.io.*;
// TODO: Auto-generated Javadoc

/**
 * La classe Fitxer.
 */
public class Fitxer {
	
	/** Nom del fitxer. */
	private String nom;
	
	/** Mode d'acc�s al fitxer {Lectura|Escriptura}. */
	private String mode_acces;
	
	/** Arxiu relacionat amb aquest nom. */
	private File file;

	/**
	 * La Constructora.
	 * 
	 * @param mode_acces El mode d'acc�s al fitxer.
	 * @param nom El nom del fitxer.
	 */
	public Fitxer(String nom, String mode_acces) 
	{
		this.nom = nom;
		this.mode_acces = mode_acces;
		file= new File(this.nom);
	}
	
	/**
	 * Obt� el mode d'acc�s.
	 * 
	 * @return Retorna el mode d'acc�s (String {"L" Lectura| "E" Escriptura}) 
	 */
	public String GetMode_acces() 
	{
		return mode_acces;
	}
	
	/**
	 * Sets Actualitza el mode d'acc�s.
	 * 
	 * @param mode_acces Mode d'acc�s (String {"L" Lectura| "E" Escriptura})
	 */
	public void SetMode_acces(String mode_acces) 
	{
		this.mode_acces = mode_acces;
	}
	

	
	/**
	 * Obtenir el Fitxer.
	 * 
	 * @return Retorna l'arxiu
	 */
	public File GetFile() {
		return file;
	}

	/**
	 * Actualitza l'arxiu.
	 * 
	 * @param f L'arxiu que es passa.
	 */
	public void SetFile(File f) {
		this.file = f;
	}

	/**
	 * Obt� el nom del fitxer.
	 * 
	 * @return String amb el nom del fitxer.
	 */
	public String GetNom() 
	{
		return nom;
	}
	
	/**
	 * Posa nom al fitxer.
	 * 
	 * @param nom El nom que li volem posar.
	 */
	public void SetNom(String nom) 
	{
		this.nom = nom;
	}
	
	/**
	 * Obrir el fitxer per lectura.
	 * 
	 * @return El BufferedReader que va llegint cada l�nia.
	 * 
	 * @throws IOException L'exepci� d'Entrada/Sortida.
	 */
	public BufferedReader ObrirFitxerLectura() throws IOException 
	{
		BufferedReader br=null;
		if (file.exists() && file.canRead())
		{
			FileReader in = new FileReader(file);
			br=new BufferedReader(in);
		}
        return br;
	}
	
	/**
	 * Obrir fitxer per escriptura.
	 * 
	 * @return Retorna el BufferedWriter que serveix per escriure al fitxer.
	 * 
	 * @throws IOException L'exepci� d'Entrada/Sortida.
	 */
	public BufferedWriter ObrirFitxerEscriptura() throws IOException
	{
		BufferedWriter bw=null;
		FileWriter out = new FileWriter(file);
		bw= new BufferedWriter(out);
		return bw;
	}
	
	/**
	 * Tanca el fitxer de lectura.
	 * 
	 * @param br El BufferedReader que llegeix del fitxer.
	 * 
	 * @throws IOException L'exepci� d'Entrada/Sortida.
	 */
	public void TancarFitxerDeLectura(BufferedReader br) throws IOException 
	{
		br.close();
	}

	/**
	 * Tanca el fitxer d'escriptura.
	 * 
	 * @param bw El BufferedWriter que escriu al fitxer.
	 * 
	 * @throws IOException L'exepci� d'Entrada/Sortida.
	 */
	public void TancarFitxerDEscriptura(BufferedWriter bw) throws IOException 
	{
		bw.flush();
		bw.close();
	}
}
