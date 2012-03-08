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
package capa3;

import capa2.*;

import org.jdom.input.*;
import org.jdom.output.*;
import org.jdom.*;

import java.io.*;
import java.util.*;

//Per utilitzar la classe del cluster
import javax.xml.parsers.ParserConfigurationException;

//TODO: Auto-generated Javadoc
/**
 * La classe TractamentXML.
 */
public class TractamentXML {

	/** El fitxer de tipus XML. */
	private Fitxer fxml;

	/**
	 * El constructor.
	 * 
	 * @param nom_fitxer El nom del fitxer
	 * @param mode_acces El mode d'acces
	 */
	public TractamentXML(String nom_fitxer, String mode_acces)
	{
		try
		{
			fxml=new Fitxer(nom_fitxer,mode_acces);
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
		}
	}

	/**
	 * L'estructura del Fitxer XML es correcte?.
	 * 
	 * @return Retorna cert si es un XML correcte, fals en qualsevol altre cas
	 */
	public boolean XMLCorrecte()
	{
		boolean result=true;

		SAXBuilder builder = new SAXBuilder();

		// command line should offer URIs or file names
		try {
			builder.build(fxml.GetNom());
			// If there are no well-formedness errors, 
			// then no exception is thrown
			GestorDiscConstants.PS(fxml.GetNom() + " esta bien formado.");
		}
		// indicates a well-formedness error
		catch (JDOMException e) { 
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO + " No está bien formado.");
			result=false;
		}  
		catch (IOException e) { 
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
			result=false;
		}  
		return result;
	}


//	funcions d'escriptura de XML
	/**
	 * Crea un Element amb les dades d'una comunicacio.
	 * 
	 * @param com La Comunicació
	 * 
	 * @return Retorna un Element que utilitza Jdom per afegir al fitxer XML.
	 */
	private Element EscriuComunicacioAXML(Comunicacio com)
	{
		//Tractament dels temes
		Element temes=new Element("temes");
		Iterator itTemes=com.GetTemes().iterator();
		int j=0;

		while (itTemes.hasNext())
		{
			Tema tem = (Tema) itTemes.next();
			Element tema=new Element("tema");
			tema.setAttribute("nom",tem.GetNom());
			temes.addContent(tema);
			j++;
		} 

		//Tractament Autor
		Element autor=new Element("autor");
		autor.setAttribute("nom",com.GetAutor().GetNom());
		autor.setAttribute("cognoms",com.GetAutor().GetCognoms());

		//Tractament Comunicacio
		Element comunicacio= new Element("comunicacio");

		Element assignacio=new Element("assignacio");
		assignacio.setAttribute("sessio",com.GetSessio().GetId()+"");
		assignacio.setAttribute("hora",com.GetHInici().GetHora()+"");
		assignacio.setAttribute("minuts",com.GetHInici().GetMinuts()+"");

		//comunicacio.setAttribute("hora_inici",dades.get(i).GetHInici().ToString());
		comunicacio.setAttribute("titol",com.GetNom());
		comunicacio.setAttribute("duracio", com.GetDuracio()+"");

		comunicacio.addContent(autor);
		comunicacio.addContent(temes);
		comunicacio.addContent(assignacio);

		return comunicacio;
	}

	/**
	 * Crea un Element amb les dades del Descans.
	 * 
	 * @param des El descans
	 * 
	 * @return L'element Element que utilitzarà JDOM
	 */
	private Element EscriuInclouDescansAXML(InclouDescans des)
	{   	
		Element descans=new Element("descans");
		descans.setAttribute("nom",des.GetDescans().GetTipus());
		descans.setAttribute("duracio",des.GetDuracio()+"");

		Element assignacio=new Element("assignacio");
		assignacio.setAttribute("sessio",des.GetSessio().GetId()+"");
		assignacio.setAttribute("hora",des.GetInici().GetHora()+"");
		assignacio.setAttribute("minuts",des.GetInici().GetMinuts()+"");

		descans.addContent(assignacio);

		return descans;
	}

	/**
	 * Escriu el contingut del fitxer XML a disc (Versio Grup).
	 * 
	 * @param dades Vector d'Activitat (horari)
	 */
	public boolean EscriureFitxerXMLaDisc(Vector<Activitat> dades)
	{
		//XmlSimple xmls=new XmlSimple();
		//xmls.obrir(fxml.getNom());
		//xmls.
		boolean resultat=true;
		Element root = new Element("horari");

		int nbactivitats= dades.size();
		for (int i = 0; i < nbactivitats; i++) {
			if (dades.get(i).GetTipus()==2)
			{
				Comunicacio actComunicacio=(Comunicacio) dades.get(i);
				Element comEl=EscriuComunicacioAXML(actComunicacio);
				root.addContent(comEl);	
			}
			else
			{
				InclouDescans actDescans=(InclouDescans) dades.get(i);
				Element desEl=EscriuInclouDescansAXML(actDescans);
				root.addContent(desEl);	
			}


		}

		Document doc = new Document(root);
		// serialize it onto System.out
		try {
			Format form=Format.getPrettyFormat();	
			form.setIndent("  ");
			form.setLineSeparator("\n");
			XMLOutputter serializer = new XMLOutputter(form);

			//Guardar-ho a disc
			BufferedWriter bw=fxml.ObrirFitxerEscriptura();
			serializer.output(doc,bw);
			fxml.TancarFitxerDEscriptura(bw);
		}
		catch (IOException e) {
			resultat=false;
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_IO);
		}
		return resultat;
	}

	
//	funcions de lectura de XML
	/**
	 * Llegir el document XML.
	 * 
	 * @return El Vector d'Activitats
	 */
	public Vector<Activitat> LlegirDocumentXML () 
	{
		Vector <Activitat> a=new Vector<Activitat>();
		try {
			//  Use SAXBuilder
			SAXBuilder builder = new SAXBuilder();
			Document doc = builder.build(fxml.GetNom());
			Element root = doc.getRootElement();
			ProcessarElement (root,a);
		} catch (Exception e) {
			GestorDiscConstants.PS("JDOM Exception:  "+e.getMessage());
		}
		return a;
	}

	/**
	 * Processar Element i afegir-ho al vector d'Activitat.
	 * 
	 * @param elem L'Element que estem processant
	 * @param vact El Vector d'Activitat
	 */
	private void ProcessarElement(Element elem, Vector<Activitat> vact)
	{

		List kids = elem.getChildren();
		Iterator iterator = kids.iterator();

		while (iterator.hasNext()) {
			Element kid = (Element) iterator.next();

			if (kid.getName().toUpperCase().compareTo("COMUNICACIO")==0)
			{
				Activitat act=ProcessarElementComunicacio(kid);
				vact.addElement(act);
			}
			else if (kid.getName().toUpperCase().compareTo("DESCANS")==0)
			{
				Activitat act=ProcessarElementInclouDescans(kid);
				vact.addElement(act);
			}
			else 
			{
				GestorDiscConstants.PS(GestorDiscConstants.ERROR_ELEMENT);
			}
		}

	}

	/**
	 * Processar l'element comunicacio.
	 * 
	 * @param elem L'Element que estem processant
	 * 
	 * @return Una Activitat amb les dades d'una Comunicació
	 */
	private Activitat ProcessarElementComunicacio(Element elem)
	{

		Comunicacio com=null;

		String titolc=elem.getAttributeValue("titol");
		String durac=elem.getAttributeValue("duracio");

		try {

			com=new Comunicacio(titolc,Integer.valueOf(durac).intValue());

			List kids = elem.getChildren();
			Iterator iterator = kids.iterator();

			while (iterator.hasNext()) 
			{
				Element kid = (Element) iterator.next();
				if (kid.getName().toUpperCase().compareTo("AUTOR")==0)
				{
					String nom_autor_com=kid.getAttributeValue("nom");
					String cognoms_autor_com=kid.getAttributeValue("cognoms");

					//Afegir l'autor a la comunicacio
					com.SetAutor(new Autor(nom_autor_com,cognoms_autor_com));
				}
				else if (kid.getName().toUpperCase().compareTo("TEMES")==0)
				{
					List grandsons= kid.getChildren();
					Iterator iterator2=grandsons.iterator();
					while (iterator2.hasNext())
					{
						Element grandson=(Element) iterator2.next();
						String nom_t=grandson.getAttributeValue("nom");

						//Afegir un nou tema a la comunicacio
						Tema temT=new Tema(nom_t);
						Tema tem=Prop.ExisteixTema(temT);
						if (tem==null)
						{
							com.AfegirTema(temT);
							Prop.AfegeixTemaAVector(temT);
						}
						else
						{
							com.AfegirTema(tem);
						}
					}
				}
				else if (kid.getName().toUpperCase().compareTo("ASSIGNACIO")==0)
				{
					String sessio_com=kid.getAttributeValue("sessio");
					String hora_com=kid.getAttributeValue("hora");
					String minuts_com=kid.getAttributeValue("minuts");

					Sessio s=new Sessio();
					s.SetId(Integer.valueOf(sessio_com).intValue());

					//Afegir la sessió i l'hora d'inici
					com.SetSessio(s);
					com.SetHInici(new Temps(Integer.valueOf(hora_com).intValue(),Integer.valueOf(minuts_com).intValue()));

				}

			}
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_AFEGIR_COMUNICACIO_VECTOR);
		}
		return com;
	}

	/**
	 * Processar element Descans.
	 * 
	 * @param elem L'element que volem processar
	 * 
	 * @return L'Activitat amb les dades d'un Descans
	 */
	private Activitat ProcessarElementInclouDescans(Element elem)
	{
		InclouDescans id=null;

		String nomd=elem.getAttributeValue("nom");
		String durad=elem.getAttributeValue("duracio");

		Descans d=new Descans(nomd,Integer.valueOf(durad).intValue());
		Temps t=null;
		Sessio s=new Sessio();

		try {

			List kids = elem.getChildren();
			Iterator iterator = kids.iterator();

			while (iterator.hasNext()) 
			{
				Element kid = (Element) iterator.next();
				if (kid.getName().toUpperCase().compareTo("ASSIGNACIO")==0)
				{
					String sessio_des=kid.getAttributeValue("sessio");
					String hora_des=kid.getAttributeValue("hora");
					String minuts_des=kid.getAttributeValue("minuts");

					s.SetId(Integer.valueOf(sessio_des).intValue());

					//Afegir la sessió i l'hora d'inici
					t=new Temps(Integer.valueOf(hora_des).intValue(),Integer.valueOf(minuts_des).intValue());					
				}

			}

			id=new InclouDescans(t,d);
			id.SetSessio(s);
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_AFEGIR_DESCANS_VECTOR);
		}	
		return id;
	}

//	funcions de lectura de XML V
	/**
	 * Llegir el document XML. - Versió Cluster
	 * 
	 * @return El Vector d'Activitats
	 */
	public Vector<Activitat> LlegirDocumentXML_vCluster () 
	{
		Vector <Activitat> a=new Vector<Activitat>();
		XmlSimpleExtended xml = new XmlSimpleExtended();
		try 
		{
			xml.obrir(fxml.GetNom());

		//String domini = xml.atribut("url", "");
		//Boolean pcert=true;

		Activitat act=null;
		//Site s = new Site(domini);
		int i;
		int nombreActiv=xml.getTag("comunicacio").getLength()+xml.getTag("descans").getLength();
		GestorDiscConstants.PS(nombreActiv+"");
		for(i=0; i<nombreActiv; i++) 
		{
			if (xml.tria(i).atribut("nom", "noEs").compareTo("noEs")==0)
			{
				act=ProcessarXmlSimpleDescans(xml.tria(i));
			}
			else
			{
				act=ProcessarXmlSimpleComunicacio(xml.tria(i));
			}
			a.add(act);
		}
		} catch (IOException e) {
			System.out.println("C");
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			System.out.println("A");
			e.printStackTrace();
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_GENERAL);
		}
		return a;
	}

	/**
	 * Processar l'element comunicacio. - Versió Cluster
	 * 
	 * @param elem L'Element que estem processant
	 * 
	 * @return Una Activitat amb les dades d'una Comunicació
	 */
	private Activitat ProcessarXmlSimpleComunicacio(XmlSimple elem)
	{
		Comunicacio com=null;
		try{
		com=new Comunicacio(elem.atribut("titol", ""),Integer.valueOf(elem.atribut("duracio", "")).intValue());
		
		com.SetAutor(new Autor(elem.getTag("autor").atribut("nom", ""),elem.getTag("autor").atribut("cognoms", "")));
		com.SetHInici(new Temps(Integer.valueOf(elem.getTag("assignacio").atribut("hora", "")).intValue(),Integer.valueOf(elem.getTag("assignacio").atribut("minuts", "")).intValue()));
		
		Sessio s=new Sessio();
		s.SetId(Integer.valueOf(elem.getTag("assignacio").atribut("sessio", "")).intValue());
		com.SetSessio(s);

		XmlSimple temes=elem.getTag("temes");
		int nombreTemes=elem.getTag("temes").getTag("tema").getLength();

		///TEST

		GestorDiscConstants.PS(elem.atribut("titol", "")+elem.atribut("duracio", ""));
		
		GestorDiscConstants.PS(elem.getTag("autor").atribut("nom", "")+" "+elem.getTag("autor").atribut("cognoms", ""));
		GestorDiscConstants.PS(elem.getTag("assignacio").atribut("hora", "")+" "+elem.getTag("assignacio").atribut("minuts", ""));
		
		
		GestorDiscConstants.PS(elem.getTag("assignacio").atribut("sessio", ""));

		GestorDiscConstants.PS(elem.getTag("temes").getTag("tema").getLength()+"");

		
		///
		
		for (int j=0; j<nombreTemes;j++)
		{
			String tema=temes.getTag("tema").tria(j).atribut("nom", "");
			com.AfegirTema(Prop.ExisteixTema(new Tema(tema)));
		}
		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_AFEGIR_COMUNICACIO_VECTOR+" "+e.getMessage());
		}
		return com;
	}

	/**
	 * Processar element Descans. - Versió Cluster
	 * 
	 * @param elem L'element que volem processar
	 * 
	 * @return L'Activitat amb les dades d'un Descans
	 */
	private Activitat ProcessarXmlSimpleDescans(XmlSimple elem)
	{
		InclouDescans id=null;

		try{
		Descans d=new Descans(elem.atribut("nom", ""),Integer.valueOf(elem.atribut("duracio", "")).intValue());
		Temps t=new Temps(Integer.valueOf(elem.getTag("assignacio").atribut("hora", "")).intValue(),Integer.valueOf(elem.getTag("assignacio").atribut("minuts", "")).intValue());
		
		id=new InclouDescans(t,d);
		
		Sessio s=new Sessio();
		s.SetId(Integer.valueOf(elem.getTag("assignacio").atribut("sessio", "")).intValue());
		id.SetSessio(s);

		}
		catch (Exception e)
		{
			GestorDiscConstants.PS(GestorDiscConstants.ERROR_AFEGIR_DESCANS_VECTOR+" "+e.getMessage());
		}
		return id;
	}


}
