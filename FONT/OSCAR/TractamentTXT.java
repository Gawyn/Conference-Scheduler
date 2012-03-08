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
 * implementat per Oscar Camacho
 */
package capa3;

import java.io.*;
import java.util.*;
// TODO: Auto-generated Javadoc

/**
 * La classe Tractament dels fitxers de text (TXT)
 */
public class TractamentTXT {
	
	/** El fitxer de text. */
	private Fitxer ftxt;
	
	/**
	 * The Constructor.
	 * 
	 * @param mode_acces El mode d'accés al fitxer
	 * @param nom El nom del fitxer
	 */
	public TractamentTXT(String nom, String mode_acces)
	{
		try
		{
		this.ftxt= new Fitxer(nom, mode_acces);
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
		}
	}
	
	/**
	 * Lectura del fitxer de text.
	 * 
	 * @return Retorna un Vector de String amb les linies del fitxer.
	 */
	public Vector<String> LecturaFitxer()
	{
		Vector<String> filas= new Vector<String>();
		if (this.ftxt.GetFile().exists())
		{
			try 
			{
				BufferedReader br=this.ftxt.ObrirFitxerLectura();
				while (br.ready())
				{
					filas.add(br.readLine());
				}
				this.ftxt.TancarFitxerDeLectura(br);
			}
			catch (IOException e)
			{
				GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
			}
		}
		return filas;
	}
	
	/**
	 * Escriptura al fitxer.
	 * 
	 * @param Vector de String que correspon a les linies del fitxer
	 */
	public void EscripturaFitxer(Vector<String> linies)
	{
		int DocumentLines= linies.size();
		try {
		BufferedWriter bw=this.ftxt.ObrirFitxerEscriptura();
		for (int i=0; i<DocumentLines; i++)
		{
			bw.write(linies.get(i)+"\n");
		}
		this.ftxt.TancarFitxerDEscriptura(bw);
		}
		catch (IOException e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
		}
	}
	
	
}