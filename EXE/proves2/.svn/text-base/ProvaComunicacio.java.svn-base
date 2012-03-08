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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

import capa2.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaComunicacio.
 */
public class ProvaComunicacio {
	
	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main (String args[]) throws Exception
    {
		Prop.PS("- TEST DE COMUNICACIO\n==================\n");
		System.out.println();
		
		String linea, line2, line3;
		int x,y;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		
		System.out.println("Creem una Comunicacio");
		System.out.println("Escriu el nom:");
		line2 = teclado.readLine();
		System.out.println("Escriu la durada:");
		linea = teclado.readLine();
		x= Integer.parseInt(linea);
		Comunicacio c=new Comunicacio(line2,x);
		Prop.PS("Creacio completada amb exit\n");
		System.out.println(c.ToString());
		
		menu();
		
		linea = teclado.readLine(); 
		for(int op = Integer.parseInt(linea); op != 0; op = Integer.parseInt(linea))
        {
			
            switch(op)
            {
            case 0:
            
            default:
            	break;
            
            case 1:
            	Prop.PS("Creem un tema");
        		Prop.PS("Escriu el nom del tema:");
            	line2 = teclado.readLine();
            	Tema t=new Tema(line2);
            	c.AfegirTema(t);
            	Prop.PS("Tema afegit correctament");
            	print(c);
            	break;
            	
            case 2:
            	System.out.println("Creem una nova comunicacio");
            	Prop.PS("Escriu el nom de la comunicacio:");
            	line2 = teclado.readLine();
            	System.out.println("Escriu la durada de la comunicacio:");
            	line3 = teclado.readLine();
        		x= Integer.parseInt(line3);
            	Comunicacio c1=new Comunicacio(line2,x);
            	c.AfegircomProp(c1);
            	System.out.println("Comunicacio propera afegida correctament");
            	print(c);
            	break;
            	
            case 3:
            	System.out.println("Creem una llista de 3 comunicacions properes");
            	List<Comunicacio> lc=new ArrayList<Comunicacio>();
            	for(int j=0; j<3; j++)
            	{
            		System.out.println("Escriu nom comunicacio:");
	            	line2 = teclado.readLine();
	            	System.out.println("Escriu durada comunicacio:");
	            	line3 = teclado.readLine();
	            	x= Integer.parseInt(line3);
	            	Comunicacio c2= new Comunicacio(line2,x);
	            	lc.add(c2);
            	}
            	c.SetComProp(lc);
            	System.out.println("S'ha afegit la llista correctament");
            	print(c);
            	break;
            	
            case 4:
            	System.out.println("Durada: "+c.GetDuracio() +"minuts");
            	break;
            	
            case 5:
            	System.out.println("Escriu la nova durada:");
            	line3 = teclado.readLine();
            	x= Integer.parseInt(line3);
            	c.SetDuracio(x);
            	System.out.println(c.ToString());
            	break;
            	
            case 6:
            	System.out.println("ID: "+c.GetId());
            	break;
            	
            case 7:
            	System.out.println("Escriu el nou Id:");
            	line3 = teclado.readLine();
            	x= Integer.parseInt(line3);
            	c.SetId(x);
            	System.out.println(c.ToString());
            	break;
            	
            case 8:
            	System.out.println("Escriu el nou nom:");
            	line3 = teclado.readLine();
            	c.SetNom(line3);
            	System.out.println(c.ToString());
            	break;
            	
            case 9:
            	System.out.println("Nom: "+c.GetNom());
            	break;
            	
            case 10:
            	if(c.GetTemes().size()==0) System.out.println("No hi ha temes a la comunicacio");
            	else{
	            	int i=c.GetTemes().size();
	            	i=i-1;
	            	System.out.println("Tria una activitat de la 0 a la "+i+" per consultar");
	            	line3 = teclado.readLine();
	            	x= Integer.parseInt(line3);
	            	Tema t9=c.GetTemes().get(x);
	            	System.out.println(t9.ToString());
            	}
            	break;
            	
            case 11:
            	System.out.println("Creem una llista de 3 temes");
            	List<Tema> lt=new ArrayList<Tema>();
            	for(int j=0; j<3; j++)
            	{
            		System.out.println("Escriu nom del tema:");
	            	line2 = teclado.readLine();
	            	Tema t2=new Tema(line2);
	            	lt.add(t2);
            	}
            	c.SetTemes(lt);
            	System.out.println("S'ha afegit la llista correctament");
            	System.out.println(c.ToString());
            	break;
            	
            case 12:
            	System.out.println("Escriu l'Hora d'Inici:");
            	line3 = teclado.readLine();
            	x= Integer.parseInt(line3);
            	System.out.println("Escriu el Minut d'Inici:");
            	line2 = teclado.readLine();
            	y= Integer.parseInt(line2);
            	Temps tem=new Temps(x,y);
            	c.SetInici(tem);
            	System.out.println("Temps afegit correctament");
            	break;
            	
            case 13:
            	if(c.GetHInici()==null) System.out.println("No hi ha Temps d'inici assignat");
            	else System.out.println(c.GetInici().ToString());
            	break;
            	
            case 14:
            	if(c.GetAutor()==null) System.out.println("No hi ha Autor assignat");
            	else System.out.println(c.GetAutor().ToString());
            	break;
            	
            case 15:
            	System.out.println("Escriu el nom de l'autor:");
            	line3 = teclado.readLine();
            	System.out.println("Escriu els cognoms de l'autor:");
            	line2 = teclado.readLine();
            	Autor au=new Autor(line3,line2);
            	c.SetAutor(au);
            	System.out.println("Autor afegit correctament");
            	print(c);
            	break;
            case -1:
            	menu();
            	break;
            	
            }
            linea = teclado.readLine();
        }    
		
			System.out.println();
			System.out.println("-------");
			System.out.println("Fi del provador.");
				
		
    }
	
	/**
	 * Print.
	 * 
	 * @param c the c
	 */
	private static void print(Comunicacio c){
		System.out.println(c.ToString());
		Comunicacio auxc;
		System.out.println(" -Comunicacions properes (id, duracio, nom)");
		for(int i=0;i<c.GetComProp().size();i++){
			auxc=c.GetComProp().get(i);
			System.out.println("  -Comunicacio "+auxc.GetId()+" "+auxc.GetDuracio()+" "+auxc.GetNom());
		}
		
		Prop.PS("");
	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Afegir tema");
		Prop.PS("2. Afegir comunicacio propera");
		Prop.PS("3. Afegir llistat de comunicacions properes");
		Prop.PS("4. Consultar durada");
		Prop.PS("5. Modifica durada");
		Prop.PS("6. Consultar id");
		Prop.PS("7. Modificar id");
		Prop.PS("8. Modificar nom");
		Prop.PS("9. Consultar nom");
		Prop.PS("10. Consultar tema de la llista de temes");
		Prop.PS("11. Afegir llista de temes");
		Prop.PS("12. Modificar Temps d'Inici");
		Prop.PS("13. Consultar Temps d'Inici");
		Prop.PS("14. Consultar autor");
		Prop.PS("15. Modificar autor");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}



}
