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
 * The Class ProvaActivitat.
 */
public class ProvaActivitat
{

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception
	{
		
		
		Prop.PS("- TEST D'ACTIVITAT\n==================\n");
		String linea, line2;
		int x,m,h;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		Activitat act1=null;
		
		System.out.println("Creem una Activitat");
		System.out.println("Escriu 1 perque sigui de tipus Descans");
		System.out.println("Escriu 2 perque sigui de tipus Comunicacio");
		line2 = teclado.readLine();
    	x= Integer.parseInt(line2);
    	if(x==1)
    	{
			System.out.println();
			System.out.println("Escriu el tipus de Descans:");
			linea = teclado.readLine();
			System.out.println("Escriu la durada del Descans:");
			line2 = teclado.readLine();
	    	x= Integer.parseInt(line2);
	    	Descans d=new Descans(linea,x);
	    	System.out.println("Escriu la Hora d'Inici del Descans");
	    	System.out.println("Escriu la Hora (0-23):");
    		line2 = teclado.readLine();
        	h= Integer.parseInt(line2);
        	while(h>23 || h<0)
        			{
        				System.out.println("ERROR! Format d'hora erroni! Torni a intoduir l'Hora (entre 0 i 23):");
        				line2 = teclado.readLine();
        		    	h= Integer.parseInt(line2);
        			}
    		System.out.println("Escriu els Minuts (0-59):");
    		linea = teclado.readLine();
    		m= Integer.parseInt(linea);
    		while(m>59 || m<0)
    		{
    			System.out.println("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
    			linea = teclado.readLine();
    	    	m= Integer.parseInt(linea);
    		}
    		Temps t2 = new Temps(h,m);
	    	act1=new InclouDescans(t2,d);
	    	
    	}
    	else if(x==2)
    	{
	    	System.out.println();
			System.out.println("Escriu el nom de la Comunicacio:");
			linea = teclado.readLine();
			System.out.println("Escriu la durada:");
			line2 = teclado.readLine();
	    	x= Integer.parseInt(line2);
	    	act1=new Comunicacio(linea,x);
	    	System.out.println("Escriu la Hora d'Inici de la Comunicacio");
	    	System.out.println("Escriu la Hora (0-23):");
    		line2 = teclado.readLine();
        	h= Integer.parseInt(line2);
        	while(h>23 || h<0)
        			{
        				System.out.println("ERROR! Format d'hora erroni! Torni a intoduir l'Hora (entre 0 i 23):");
        				line2 = teclado.readLine();
        		    	h= Integer.parseInt(line2);
        			}
    		System.out.println("Escriu els Minuts (0-59):");
    		linea = teclado.readLine();
    		m= Integer.parseInt(linea);
    		while(m>59 || m<0)
    		{
    			System.out.println("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
    			linea = teclado.readLine();
    	    	m= Integer.parseInt(linea);
    		}
    		Temps t2 = new Temps(h,m);
	    	act1.SetInici(t2);
	    	System.out.println();
    	}
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
            	System.out.println(act1.toString());
            	break;
            	
            case 2:
            	if(act1.GetInici()==null) System.out.println("No hi ha Hora d'Inici assignada");
            	else System.out.println("Hora Inici: "+act1.GetInici().toString());
            	break;
            	
            case 3:
            	System.out.println("Escriu la Hora (0-23):");
        		line2 = teclado.readLine();
            	h= Integer.parseInt(line2);
            	while(h>23 || h<0)
            			{
            				System.out.println("ERROR! Format d'hora erroni! Torni a intoduir l'Hora (entre 0 i 23):");
            				line2 = teclado.readLine();
            		    	h= Integer.parseInt(line2);
            			}
        		System.out.println("Escriu els Minuts (0-59):");
        		linea = teclado.readLine();
        		m= Integer.parseInt(linea);
        		while(m>59 || m<0)
        		{
        			System.out.println("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
        			linea = teclado.readLine();
        	    	m= Integer.parseInt(linea);
        		}
        		Temps t = new Temps(h,m);
        		act1.SetInici(t);
        		System.out.println("Hora Inici assignada correctament");
            	break;
            	
            case 4:
            	System.out.println("Durada: "+act1.GetDuracio()+" min");
            	break;
            	
            case 5:
            	if(act1.GetTipus()==1) System.out.println("Tipus: InclouDescans");
            	else System.out.println("Tipus: Comunicacio");
            	break;
            	
            case 6:
            	System.out.println("Escriu el pes de la sessio on vols assignar l'Activitat:");
            	line2 = teclado.readLine();
    	    	x= Integer.parseInt(line2);
    	    	Sessio s=new Sessio();
    	    	s.SetId(x);
    	    	act1.SetSessio(s);
    	    	System.out.println("Sessio assignada correctament");
            	break;
            	
            case 7:
            	if(act1.GetSessio()==null) System.out.println("No hi ha Hora Sessio assignada");
            	else Prop.PS(act1.GetSessio().ToString());
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
		Prop.PS("Escull una opcio:");
		Prop.PS("1. Mostrar Activitat");
		Prop.PS("2. Consultar Hora Inici");
		Prop.PS("3. Modificar Hora Inici");
		Prop.PS("4. Consultar durada");
		Prop.PS("5. Consultar tipus");
		Prop.PS("6. Assignar sessio a l'Activitat");
		Prop.PS("7. Consultar sessio");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}

}
