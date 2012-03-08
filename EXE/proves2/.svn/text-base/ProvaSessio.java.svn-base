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
import capa2.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class ProvaSessio.
 */
public class ProvaSessio {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
			Prop.PS("- TEST DE SESSIO\n==================\n");
			
			String linea, line2, line3;
			int x;
			BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
			Prop.PS("Crearem una Sessio");
			Prop.PS("Escriu el pes de la sessio:");
        	line2 = teclado.readLine();
    		x= Integer.parseInt(line2);
    		Sessio s=new Sessio(x);
    		Prop.PS("Creacio completada amb exit\n");
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
	            	Prop.PS("Escriu la nova id:");
	            	line2 = teclado.readLine();
	            	x= Integer.parseInt(line2);
	            	s.SetId(x);
	            	Prop.PS(s.ToString());
	            	break;
	            case 2:
	            	Prop.PS("Escriu el nou pes:");
	            	line2 = teclado.readLine();
	            	x= Integer.parseInt(line2);
	            	s.SetPes(x);
	            	Prop.PS(s.ToString());
	            	break;
	            case 3:
	            	Prop.PS("Escriu nom activitat:");
	            	line2 = teclado.readLine();
	            	Prop.PS("Escriu durada activitat:");
	            	line3 = teclado.readLine();
	            	x= Integer.parseInt(line3);
	            	Activitat a= new Comunicacio(line2,x);
	            	s.AddAct(a);
	            	Prop.PS("Activitat afegida correctament");
	            	break;
	            case 4:
	            	if(s.GetActivitats().size()==0) Prop.PS("No hi ha activitats a la sessio");
	            	else{
		            	int i=s.GetActivitats().size();
		            	int u=i-1;
		            	Prop.PS("Tria una activitat de la 0 a la "+u+" per borrar:");
		            	line3 = teclado.readLine();
		            	x= Integer.parseInt(line3);
		            	while(x<0 || x>u)
		            	{
		            		Prop.PS("Numero erroni! Torni a escriure un numero del 0 al " +u);
		            		line2 = teclado.readLine();
			            	x= Integer.parseInt(line2);
		            	}
		            	s.Esborrar(x);
		            	Prop.PS("S'ha borrat l'activitat satisfactoriament");
	            	}
	            	break;
	            case 5:
	            	Prop.PS("Creem llista de 3 activitats");
	            	List<Activitat> la=new ArrayList<Activitat>();
	            	for(int j=0; j<3; j++)
	            	{
	            		Prop.PS("Escriu nom activitat:");
		            	line2 = teclado.readLine();
		            	Prop.PS("Escriu durada activitat:");
		            	line3 = teclado.readLine();
		            	x= Integer.parseInt(line3);
		            	Activitat b= new Comunicacio(line2,x);
		            	la.add(b);
	            	}
	            	s.SetActivitats(la);
	            	Prop.PS("S'ha afegit la llista correctament");
	            	break;
	            case 6:
	            	if(s.GetActivitats().size()==0) Prop.PS("No hi ha activitats a la sessio");
	            	else{
		            	int i=s.GetActivitats().size();
		            	int u=i-1;
		            	Prop.PS("Tria una activitat de la 0 a la "+u+" per consultar:");
		            	line3 = teclado.readLine();
		            	x= Integer.parseInt(line3);
		            	Activitat c=s.GetAct(x);
		            	Prop.PS(c.ToString());
	            	}
	            	break;
	            case 7:
	            	Prop.PS("Pes de la sessio: "+s.GetPes());
	            	break;
	            case 8:
	            	Prop.PS("Id de la sessio: "+s.GetId());
	            	break;
	            case 9:
	            	List<Activitat> lu=s.GetActivitats();
	            	int i=lu.size();
	            	Prop.PS("La Sessio te "+i+" activitats assignades");
	            	break;
	            case -1:
	            	menu();
	            	break;
	            }
	            linea = teclado.readLine(); 
	        }
			
			Prop.PS("");
			Prop.PS("-------");
			Prop.PS("Fi del provador.");	
		
	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Modificar Id ");
		Prop.PS("2. Modificar el pes");
		Prop.PS("3. Afegir activitat");
		Prop.PS("4. Esborrar activitat");
		Prop.PS("5. Afegir llista d'activitats");
		Prop.PS("6. Consultar activitat");
		Prop.PS("7. Consultar pes");
		Prop.PS("8. Consultar id");
		Prop.PS("9. Consultar quantes activitats te assignades");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}

}
