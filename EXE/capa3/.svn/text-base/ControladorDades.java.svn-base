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
 * implementada per Oscar Camacho
 */
package capa3;

import capa2.*;
import java.util.*;
//TODO: Auto-generated Javadoc


/**
 * El Controlador de Dades.
 */
public class ControladorDades {

	/**
	 * Escriu els Strings del Vector dades al fitxer en format TXT (pla).
	 * 
	 * @param nomFitxer Nom del fitxer
	 * @param dades línies a escriure al fitxer.
	 */
	public void GuardarDadesDisc(String nomFitxer, Vector<String> dades)
	{
		TractamentTXT txt=new TractamentTXT(nomFitxer, "E");
		txt.EscripturaFitxer(dades);		
	}

	/**
	 * Llegir les dades d'un fitxer en format TXT.
	 * 
	 * @param nom_fitxer Nom del fitxer
	 * 
	 * @return Les línies del fitxer en un Vector de Strings
	 */
	public Vector<String> LlegirDadesDisc(String nom_fitxer)
	{
		try
		{
			TractamentTXT txt=new TractamentTXT(nom_fitxer,"L");
			return txt.LecturaFitxer();
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_GENERAL);
			return null;
		}
	}

	/**
	 * Llegir les dades d'un fitxer en format XML.
	 * 
	 * @param nom_fitxer El nom del fitxer
	 * 
	 * @return Un Vector d'elements Activitat (Horari del congrés)
	 */
	public Vector<Activitat> LlegirDadesDiscXML(String nom_fitxer)
	{
		try
		{	
			TractamentXML txml=new TractamentXML(nom_fitxer,"L");
			return txml.LlegirDocumentXML();
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_GENERAL);
			return null;
		}
	}

	/**
	 * LLegir les dades d'un fitxer en format XML - Versió Cluster
	 * 
	 * @param nom_fitxer Nom del fitxer
	 * @return LLista d'activitats
	 */

	public Vector<Activitat> LLegirDadesDiscXML_vCluster(String nom_fitxer)
	{
		try {
			TractamentXML txml=new TractamentXML(nom_fitxer,"L");
			return txml.LlegirDocumentXML_vCluster();
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_GENERAL);
			return null;
		}
	}

	/**
	 * Guarda un horari en format XML al fitxer amb nom nomFitxer.
	 * 
	 * @param nomFitxer Nom del fitxer on guardarem la informació.
	 * @param dades Vector d'elements Activitat que guardarem a disc.
	 */
	public void EscriureDadesDiscXML(String nomFitxer,Vector<Activitat> dades)
	{
		try {
			TractamentXML txml=new TractamentXML(nomFitxer,"E");
			txml.EscriureFitxerXMLaDisc(dades);
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_GENERAL);
		}
	}

}
