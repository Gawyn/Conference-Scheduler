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
 * Implementada por Oscar Camacho
 */
package capa2;
import capa3.*;
import java.util.*;
// TODO: Auto-generated Javadoc
//TODO: Auto-generated Javadoc

/**
 * The Class Prop.
 */
public final class Prop {

	//Codigos de Error
	/** The ERRO r_ IO. */
	public static String ERROR_IO="Error a l'accedir a Disc";

	/** The ERRO r_ GENERAL. */
	public static String ERROR_GENERAL="Error general de l'aplicació";

	/** The ERRO r_ XM l_ FORMED. */
	public static String ERROR_XML_FORMED="Error d'estructura al fitxer XML";

	/** The vt. */
	private static Vector<Tema> vt=new Vector<Tema>();
	
	private static CjtComunicacions cjt=CjtComunicacions.GetInstance();

	//Operacions específiques de LLISTA DE COMUNICACIONS

	/**
	 * Gets the L lista comunicacions.
	 * 
	 * @return the list< comunicacio>
	 */
	public static List<Comunicacio> GetLListaComunicacions()
	{
		return cjt.GetComunicacions();
	}
	
	/**
	 * LCOM to string.
	 */
	public static void LCOMToString()
	{
		int comunicacions=cjt.GetSize();
		for (int i=0;i<comunicacions;i++)
		{
			Prop.PS(cjt.GetCom(i).ToString());
		}
	}

	/**
	 * Carregar comunicacions de disc.
	 * 
	 * @param nomFitxer the nom fitxer
	 * 
	 * @return true, if carregar comunicacions de disc
	 */
	public static boolean CarregarComunicacionsDeDisc(String nomFitxer)
	{
		Vector<String> v;

		capa3.ControladorDades cd=new capa3.ControladorDades();
		v=cd.LlegirDadesDisc(nomFitxer);
		
		if (v!=null)
		{

		int nombre_de_comunicacions=0, nombre_de_sessions=0, comunicacions_per_sessio=0;

		int long_fitxer=v.size();

		for (int i=0;i<long_fitxer;i++)
		{
			if (v.get(i).toUpperCase().indexOf("COMUNICACIONS:")>=0)
			{
				//nombre de comunicacions
				nombre_de_comunicacions=Integer.valueOf(v.get(i).substring(v.get(i).indexOf(": ")+2));
			}
			else if (v.get(i).toUpperCase().indexOf("COMUNICACIONS PER SESSIO:")>=0)
			{
				//nombre de comunicacions per sessio
				Congres c=Congres.GetInstance();
				comunicacions_per_sessio=Integer.valueOf(v.get(i).substring(v.get(i).indexOf(": ")+2));
				c.SetCxs(comunicacions_per_sessio);
			}
			else if (v.get(i).toUpperCase().indexOf("SESSIONS:")>=0)
			{
				//nombre de sessions del congres
				Congres c=Congres.GetInstance();
				nombre_de_sessions=Integer.valueOf(v.get(i).substring(v.get(i).indexOf(": ")+2));
				c.SetNumSessions(nombre_de_sessions);
			}

			try 
			{				
				//tractament de totes les comunicacions
				if (v.get(i).toUpperCase().indexOf("AUTOR")>=0)
				{
					//Assignem una duració estandar per cada comunicació
					Comunicacio c= new Comunicacio("",30);

					//obtenim l'autor
					Autor a=DonaAutor(v.get(i).substring(v.get(i).indexOf(": ")+2));
					c.SetAutor(a);

					//obtenim les dades de les comunicacions
					if (v.get(i+1).toUpperCase().indexOf("TITOL")>=0)
					{
						String nomComunicacio = v.get(i+1).substring(v.get(i+1).indexOf(": ")+2);
						c.SetNom(nomComunicacio);
					}
					else
					{
						Prop.PS("Error a l'estructura del fitxer de Comunicacions");
					}

					//obtenim els temes
					if (v.get(i+2).toUpperCase().indexOf("TEMES")>=0)
					{
						String t=v.get(i+2).substring(v.get(i+2).indexOf(": ")+2);
						String[] temes = t.split(" ");
						for (int j=0;j<temes.length;j++)
						{
							Tema temaAafegir=new Tema(temes[j]);
							Tema temaExistent=null;
							
							temaExistent=Prop.ExisteixTema(temaAafegir);
							//vt.add(temaAafegir);
							if (temaExistent==null)
							{
								c.AfegirTema(temaAafegir);
								AfegeixTemaAVector(temaAafegir);
							}
							else
							{
								c.AfegirTema(temaExistent);
							}
							
						}
					}
					if ((i+3)<long_fitxer) //Ens assegurem que no ens passem de l'array 
					{
						//obtenim la duracio (si no hi ha, posem una per defecte
						if (v.get(i+3).toUpperCase().indexOf("DURACIO")>=0)
						{
							c.SetDuracio(Integer.valueOf(v.get(i+3).substring(v.get(i+3).indexOf(": ")+2)).intValue());
						}
					}
					cjt.AfegirC(c);
					Prop.PS("Comunicacio afegida:\n "+c.ToString());
				}
			}
			catch (Exception e)
			{
				Prop.PS("El document de comunicacions no es correcte!: "+e.getMessage()+e.toString());
			}
		}
			return (cjt.GetSize()==nombre_de_comunicacions);
		}
		else
		{
			return false;
		}
	}

	
	/**
	 * Guardar comunicacions A disc.
	 * 
	 * @param nomFitxer the nom fitxer
	 * 
	 * @return true, if guardar comunicacions A disc
	 */
	public static boolean GuardarComunicacionsADisc(String nomFitxer)
	{
		boolean resultat=true;
		List<Comunicacio> list_com=cjt.GetComunicacions();
		int nbcomunicacions=list_com.size();
		Vector<String> v=new Vector<String>();
		String temes_en_string="";
		try
		{
			// Escribim les dades generals de una conferencia
			v.add("Nombre de comunicacions: "+nbcomunicacions);
			Congres c=Congres.GetInstance();
			v.add("Nombre de comunicacions per sessio: "+c.GetCxs());
			v.add("Nombre de sessions: "+c.GetNumSessions());

			v.add(""); //deixem dues linies en blanc
			v.add(""); 

			for (int i=0; i<nbcomunicacions; i++)
			{
				temes_en_string="";
				v.add("Autor: "+list_com.get(i).GetAutor().GetNom()+" "+list_com.get(i).GetAutor().GetCognoms());
				v.add("Titol: "+list_com.get(i).GetNom());

				List themes=list_com.get(i).GetTemes();
				Iterator itTemes=themes.iterator();
				while (itTemes.hasNext())
				{
					temes_en_string+=" "+((Tema)itTemes.next()).GetNom();
				}

				v.add("Temes:"+temes_en_string);
				v.add("Duracio: "+list_com.get(i).GetDuracio());
			}


			ControladorDades cd=new ControladorDades();
			cd.GuardarDadesDisc(nomFitxer, v);
		}
		catch (Exception e)
		{
			resultat=false;
		}
		return resultat;
	}
	
	
	/**
	 * Afegir comunicacio.
	 * 
	 * @param c the c
	 */
	public static void AfegirComunicacio(Comunicacio c)
	{
		cjt.AfegirC(c);
		
		List<Tema> t=c.GetTemes();
		Iterator itTemes=t.iterator();
		while (itTemes.hasNext())
		{
			ExisteixTema((Tema)itTemes.next());
		}
	}
	
	/**
	 * Modificar l'autor d'una comunicacio
	 * 
	 * @param id Identificador de la comunicacio
	 * @param a Autor de la comunicacio
	 */
	public static void SetAutorComunicacio(int id, Autor a)
	{
		for (int i=0; i<cjt.GetSize();i++)
		{
			if (cjt.GetCom(i).GetId()==id)
			{
				cjt.GetCom(i).SetAutor(a);
			}
		}
	}
	
	/**
	 * Eliminar la Comunicacio C
	 * 
	 * @param c La comunicacio que volem eliminar
	 */
	public static void EliminarComunicacio(Comunicacio c)
	{
		cjt.GetComunicacions().remove(c);
	}
	
	//Operació per dividir el nom de l'autor
	/**
	 * Dona autor.
	 * 
	 * @param nomConferenciant the nom conferenciant
	 * 
	 * @return the autor
	 */
	private static Autor DonaAutor(String nomConferenciant)
	{
		String[] nom_sencer=nomConferenciant.split(" ");
		String nom="", cognoms="";
		switch(nom_sencer.length)
		{
		case 1:
			nom=nomConferenciant;
			break;
		case 2:
			nom=nom_sencer[0];
			cognoms=nom_sencer[1];
			break;
		case 3:
			nom=nom_sencer[0];
			cognoms=nom_sencer[1]+" "+nom_sencer[2];
			break;
		default:
			nom=nom_sencer[0]+" "+nom_sencer[1];
		cognoms=nom_sencer[2];
		for (int i=3;i<nom_sencer.length;i++)
		{
			cognoms+=" "+nom_sencer[i];
		}	                		
		break;
		}
		return new Autor(nom,cognoms);

	}

	//Operacions específiques de TEMES

	/**
	 * Carregar temes de disc.
	 */
/*	public static void CarregarTemesDeDisc()
	{
		Vector<String> fitxerTemes=null;
		String nomTema;
		capa3.ControladorDades cd=new capa3.ControladorDades();
		fitxerTemes=cd.LlegirDadesDisc("temes.tem");
		int long_fitxer=fitxerTemes.size();
		for (int i=0; i<long_fitxer;i++)
		{
			//temes
			nomTema=fitxerTemes.get(i);
			Prop.AfegirTema(new Tema(nomTema));
		}

	}*/

	/**
	 * Guardar temes A disc.
	 */
/*	public static void GuardarTemesADisc()
	{
		capa3.ControladorDades cd= new capa3.ControladorDades();
		cd.GuardarDadesDisc("temes.tem", Prop.TransformarTemesAString());
	}*/


	/**
	 * Retorna el tema, si existeix previament al vector de temes
	 * 
	 * @param t Tema que volem comprobar si existeix
	 * @return Tema existent al vector de temes.
	 */
	public static Tema ExisteixTema(Tema t)
	{
		Tema tem=null;
		for (int i=0;i<vt.size();i++)
		{
			if (t.GetNom().toUpperCase().compareTo(vt.get(i).GetNom().toUpperCase())==0)
			{
				tem=vt.get(i);
			}
		}
		return tem;
	}
	
	public static void AfegeixTemaAVector(Tema t)
	{
		
		vt.add(t);
	}
	
	
	/**
	 * Eliminar tema.
	 * 
	 * @param i the i
	 * 
	 * @return true, if eliminar tema
	 */
	public static boolean EliminarTema(int i)
	{
		boolean resultado=true;
		try
		{
			vt.removeElementAt(i);
		}
		catch (Exception e)
		{
			resultado=false;
		}
		return resultado;
	}

	/**
	 * Eliminar tema.
	 * 
	 * @param t the t
	 * 
	 * @return true, if eliminar tema
	 */
	public static boolean EliminarTema(Tema t)
	{
		return vt.remove(t);
	}

	/**
	 * Transformar temes A string.
	 * 
	 * @return the vector< string>
	 */
/*	public static Vector<String> TransformarTemesAString()
	{
		Vector<String> vs=new Vector<String>();
		try 
		{
			if (vt.size()>0)
			{
				for (int i=0; i<vt.size();i++) vs.add((vt.get(i)).GetNom().toUpperCase());
			}
		}
		catch (Exception e)
		{
			Prop.PS(Prop.ERROR_GENERAL+" "+e.getMessage());
		}
		return vs;
	}*/

	/**
	 * Temes to string.
	 */
	public static void TemesToString()
	{
		for (int i=0; i<vt.size();i++) Prop.PS(vt.get(i).GetNom());
	}

	/**
	 * Gets the temes.
	 * 
	 * @return the vector< tema>
	 */
	public static Vector<Tema> GetTemes()
	{
		return vt;
	}	

	/**
	 * Inicialitzar temes.
	 */
/*	public static void InicialitzarTemes()
	{
		Vector<String> v;
		String textLinia="";

		ControladorDades cd= new ControladorDades();
		v=cd.LlegirDadesDisc("temes.tem");

		int LiniesATractar=v.size();

		for (int i=0; i<LiniesATractar;i++)
		{
			textLinia=v.get(i);

			//Fer tractament amb TextLinia
			Tema t=new Tema(textLinia); 
			vt.add(t);
		}

	}*/

	/**
	 * LPAD.
	 * 
	 * @param text the text
	 * @param longitud the longitud
	 * @param caracter_relleno the caracter_relleno
	 * 
	 * @return the string
	 */
	public static String LPAD(String text, char caracter_relleno, int longitud) {

		//esta funcion aï¿½ade el caracter CARACTER_RELLENO a la cadena text hasta
		//la longitud LONGITUD por la izquierda

		String result="";
		if (text.length() < longitud) result = result + caracter_relleno;

		return result = result + text;

	}

	//esta funcion aï¿½ade el caracter CARACTER_RELLENO a la cadena text hasta
	//la longitud LONGITUD por la derecha
	/**
	 * RPAD.
	 * 
	 * @param text the text
	 * @param longitud the longitud
	 * @param caracter_relleno the caracter_relleno
	 * 
	 * @return the string
	 */
	public static String RPAD(String text, char caracter_relleno, int longitud) {

		String result="";
		if (text.length() < longitud) result = result + caracter_relleno;

		return result = text + result;

	}

	/**
	 * PS.
	 * 
	 * @param text the text
	 */
	public static void PS (String text) {

		System.out.println(text);

	}

	/**
	 * PS.
	 * 
	 * @param text the text
	 */
	public static void PS (Integer text) {

		System.out.println(text);

	}

	/**
	 * Voras.
	 * 
	 * @param pes the pes
	 * @param cjt the cjt
	 * @param c the c
	 */
	/*	public static void voras(Congres c,CjtComunicacions cjt,int pes){
		Sessio SesAct=new Sessio(pes);
		Comunicacio co,nco;
		Activitat a;
		a=cjt.GetGorda();
		if(!SesAct.AddAct(a))
		{
			SesAct.SetPes(a.GetDuracio());
			SesAct.AddAct((Comunicacio)a);

		}
		a.SetInici(c.GetHinici());
		cjt.DelCom((Comunicacio)a);
		a.SetSessio(SesAct);
		int d=a.GetDuracio();
		AsignarDescans(SesAct,d);



		while(!cjt.isEmpty()){
			if(SesAct.GetPes()>0) 
			{
				co=SesAct.GetLastCom();
				nco=null;
				for(int i=0;i<co.GetComProp().size();i++)
				{
					//PATEJAR COM SEMBLANTS
					if((co.GetComProp().get(i).GetDuracio()<=SesAct.GetPes())&&co.GetComProp().get(i).GetHInici()==null)
					{
						nco=co.GetComProp().get(i);
					}
				}
				if(nco==null)
				{
					//PATEJAR TEMES
					//Eto ta xungo, que impl usamos?
				}

			}
			else
			{
				c.AfegirSessio(SesAct);
				SesAct=new Sessio(pes);
				a=cjt.GetGorda();
				if(!SesAct.AddAct(a))
				{
					SesAct.SetPes(a.GetDuracio());
					SesAct.AddAct((Comunicacio)a);
				}
				a.SetInici(c.GetHinici());
				cjt.DelCom((Comunicacio)a);
				a.SetSessio(SesAct);
				d=a.GetDuracio();
				AsignarDescans(SesAct,d);
			}
		}
	}*/

}
