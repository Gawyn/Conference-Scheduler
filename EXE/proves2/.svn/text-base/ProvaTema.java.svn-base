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

import capa2.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ProvaTema.
 */
public class ProvaTema {
	
	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main (String args[])throws Exception
	{
		String linea, line2, line3;
		int x;
		Tema te;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		Prop.PS("- TEST DE TEMA\n==================\n");
		Prop.PS("Creem un tema");
		Prop.PS("Escriu el nom:");
		linea = teclado.readLine();
		Tema t = new Tema(linea);
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
            	Prop.PS(t.ToString());
            	break;
            
            case 2:
            	Prop.PS("Nom de la comunicacio:");
            	line2 = teclado.readLine();
            	Prop.PS("Duracio de la comunicacio:");
            	line3 = teclado.readLine();
            	x = Integer.parseInt(line3);
            	Comunicacio c = new Comunicacio (line2, x);
            	t.AfegirCom(c);
            	Prop.PS("Comunicacio afegida");
            	break;
            	
            case 3:
            	if(t.GetListCom().size()==0) Prop.PS("No hi ha comunicacions al tema");
            	else{
            		int i=t.GetListCom().size() - 1;
	            	Prop.PS("Tria una comunicacio de la 0 a la "+i+" per borrar:");
	            	line2 = teclado.readLine();
	            	x = Integer.parseInt(line2);
	            	while(x<0 || x>i)
	            	{
	            		Prop.PS("Numero erroni! Torni a escriure un numero del 0 al " +i);
	            		line2 = teclado.readLine();
		            	x= Integer.parseInt(line2);
	            	}
	            	t.RemCom(x);
	            	Prop.PS("Comunicacio eliminada");
            	}
            	break;
            	
            case 4:
            	int i=t.GetListCom().size() - 1;
            	Prop.PS("Escrigui el numero de la comunicacio entre 0 i "+i+":");
            	line2 = teclado.readLine();
            	x = Integer.parseInt(line2);
            	Comunicacio co = t.GetCom(x);
            	while(x<0 || x>i)
            	{
            		Prop.PS("Numero erroni! Torni a escriure un numero del 0 al " +i);
            		line2 = teclado.readLine();
	            	x= Integer.parseInt(line2);
            	}
            	line3 = co.GetNom();
            	Prop.PS(line3);
            	break;
            	
            case 5:
            	Prop.PS("Escrigui el nom del tema:");
            	line2 = teclado.readLine();
            	Prop.PS("Escrigui el grau de semblan√ßa");
            	Prop.PS("0 - Gens semblant");
            	Prop.PS("1 - Mitjanament semblants");
            	Prop.PS("2 - Molt semblants");
            	line3 = teclado.readLine();
            	x = Integer.parseInt(line3);
            	Tema r = new Tema(line2);
            	t.AfegirTema(r, x);
            	Prop.PS("Tema afegit");
            	break;
            	
            case 6:
            	Prop.PS("Introdueixi el nom del tema (el creem per eliminar-lo):");
            	line2 = teclado.readLine();
            	te = new Tema(line2);
            	t.EliminarTema(te);
            	Prop.PS("Tema eliminat");
            	break;
            	
            case 7:
            	Prop.PS("Nom: "+t.GetNom());
            	break;
            	
            case 8:
            	Prop.PS("Escriu el nou nom:");
            	line2 = teclado.readLine();
            	t.SetNom(line2);
            	Prop.PS("Nom modificat correctament");
            	break;
            	
            case 9:
            	Prop.PS("Id: "+t.GetId());
            	break;
            	
            case 10: 
            	Prop.PS("Escriu la nova Id:");
            	line2 = teclado.readLine();
            	x = Integer.parseInt(line2);
            	t.SetId(x);
            	Prop.PS("Id modificada correctament");
            	break;
            
            /*case 11:
            	Prop.PS("Escrigui el numero del tema:");
            	line2 = teclado.readLine();
            	x = Integer.parseInt(line2);
            	int n = t.GetGrau(x);
            	Prop.PS(n);
            	break;
            	
            case 12:
            	Prop.PS("Escrigui el nom del tema:");
            	line2 = teclado.readLine();
            	Tema tem = new Tema (line2);
            	x = t.GetGrau(tem);
            	Prop.PS("Semblanca");
            	Prop.PS(x);
            	break;*/
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
		Prop.PS("1. Mostrar Tema");
		Prop.PS("2. Afegir Comunicacio al tema");
		Prop.PS("3. Eliminar comunicacio");
		Prop.PS("4. Obte comunicacio");
		Prop.PS("5. Estableix la relacio d'un altre tema amb el tema");
		Prop.PS("6. Elimina la relacio entre el tema que introdueixi l'usuari i el tema");
		Prop.PS("7. Consultar nom");
		Prop.PS("8. Modificar nom");
		Prop.PS("9. Consultar Id");
		Prop.PS("10. Modificar Id"); 
		/*Prop.PS("11. Obte el grau de semblansa que te el tema amb el numero de tema que introdueixi l'usuari");
		Prop.PS("12. Obte el grau de semblansa que te el tema amb el tema que introdueixi l'usuari");*/
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}

}
