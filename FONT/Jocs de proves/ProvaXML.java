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
 * Implementada per 
 */
package proves2;

import capa3.*;
import capa2.*;
import java.util.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaXML.
 */
public class ProvaXML {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 */
	public static void main(String[] args) {
		
		ControladorDades cd=new ControladorDades();
		
		Vector<Activitat> v=new Vector<Activitat>();
		
		Sessio s=new Sessio();
		
		Descans d1=new Descans("Coffe Break",30);
		Descans d2=new Descans("Short Break",10);
		
		Temps tmp1= new Temps(10,10);
		Temps tmp2= new Temps(14,33);
		Temps tmp3= new Temps(11,55);
		Temps tmp4= new Temps(15,21);
		
		Tema t1= new Tema("Prop");
		Tema t2= new Tema("Historia");
		Tema t3= new Tema("Filosofia");
		
		Autor a1= new Autor("John","Williams");
		Autor a2= new Autor("James", "Horner");
		Comunicacio c1=null,c2=null;
		InclouDescans id1=null, id2=null;
		try 
		{
			c1=new Comunicacio("Como aprobar PROP en un fin de semana",30);
			c1.AfegirTema(t1);
			c1.AfegirTema(t3);
			c1.SetSessio(s);
			c1.SetHInici(tmp1);
			c1.SetAutor(a1);
			
			id1=new InclouDescans(tmp3,d1);
			id1.SetSessio(s);
			
			id2=new InclouDescans(tmp4,d2);
			id2.SetSessio(s);
			
			
			c2=new Comunicacio("Como incentivar al grupo de trabajo",45);
			c2.AfegirTema(t2);
			c2.SetSessio(s);
			c2.SetHInici(tmp2);
			c2.SetAutor(a2);
			
			
		
		}
		catch (Exception e)
		{
			Prop.PS("Error en las pruebas");
		}
		v.add(c1);
		v.add(id1);
		v.add(c2);
		v.add(id2);
		
		
		cd.EscriureDadesDiscXML("horarix.xml",v);
		
		//ControladorDades cd2=new ControladorDades();
		//cd2.
		
		ControladorDades cd1=new ControladorDades();
		Vector<Activitat> vww=cd1.LlegirDadesDiscXML("horarix.xml");
		Prop.PS("El vector te "+vww.size()+" elements");
		cd1.EscriureDadesDiscXML("horarix2.xml", vww);
	}
}
