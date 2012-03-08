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
 * The Class ProvaCongres.
 */
public class ProvaCongres {
	
	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception
	{
		Prop.PS("- TEST DE CONGRES\n==================\n");
		
		String linea, line2;
		int h,m;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		Prop.PS("Creem el congres\n");
		Congres c=Congres.GetInstance();
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
            	Prop.PS("Escriu el pes de la sessio:");
            	line2 = teclado.readLine();
        		m= Integer.parseInt(line2);
        		Sessio sx=new Sessio(m);
        		c.AfegirSessio(sx);
        		Prop.PS("Sessio afegida correctament");
            	break;
            	
            case 2:
            	if(c.NumSessions()==0) Prop.PS("No hi ha sessions al congres");
            	else
            	{
            		int i=c.NumSessions() -1;
	            	Prop.PS("Tria una activitat de la 0 a la "+i+" per consultar");
	            	line2 = teclado.readLine();
	            	m= Integer.parseInt(line2);
	            	while(m<0 || m>i)
	            	{
	            		Prop.PS("Numero erroni! Torni a escriure un numero del 0 al " +i);
	            		line2 = teclado.readLine();
		            	m= Integer.parseInt(line2);
	            	}
	            	Sessio s3=c.GetSessio(m);
	            	c.EliminarSessio(s3);
	            	Prop.PS("Sessio eliminada amb exit");
            	}
            	break;
            	
            case 3:
            	Prop.PS("#sessions: "+c.NumSessions());
            	break;
            	
            case 4:
            	if(c.GetHFinal()==null) Prop.PS("No hi ha Hora Final assignada");
            	else Prop.PS("Hora Final: "+c.GetHFinal().ToString());
            	break;
            	
            case 5:
            	Prop.PS("Escriu la Hora(0-23):");
            	line2 = teclado.readLine();
            	h= Integer.parseInt(line2);
            	while(h>23 || h<0)
    			{
    				Prop.PS("ERROR! Format d'hora erroni! Torni a posar l'Hora (entre 0 i 23):");
    				line2 = teclado.readLine();
    		    	h= Integer.parseInt(line2);
    			}
            	Prop.PS("Escriu els Minuts(0-59):");
            	line2 = teclado.readLine();
        		m= Integer.parseInt(line2);
        		while(m>59 || m<0)
        		{
        			Prop.PS("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
        			line2 = teclado.readLine();
        	    	m= Integer.parseInt(line2);
        		}
        		Temps t = new Temps(h,m);
            	c.SetHFinal(t);
            	Prop.PS("Hora Final actualitzada amb exit");
            	break;
            	
            case 6:
            	if(c.GetHinici()==null) Prop.PS("No hi ha Hora d'Inici assignada");
            	else Prop.PS("Hora Inici: "+c.GetHinici().ToString());
            	break;
            	
            case 7:
            	Prop.PS("Escriu la Hora(0-23):");
            	line2 = teclado.readLine();
            	h= Integer.parseInt(line2);
            	while(h>23 || h<0)
    			{
    				Prop.PS("ERROR! Format d'hora erroni! Torni a posar l'Hora (entre 0 i 23):");
    				line2 = teclado.readLine();
    		    	h= Integer.parseInt(line2);
    			}
            	Prop.PS("Escriu els Minuts(0-59):");
            	line2 = teclado.readLine();
        		m= Integer.parseInt(line2);
        		while(m>59 || m<0)
        		{
        			Prop.PS("ERROR! Format de minuts erroni! Torni a introduir els Minuts (entre 0 i 59):");
        			line2 = teclado.readLine();
        	    	m= Integer.parseInt(line2);
        		}
        		Temps t2 = new Temps(h,m);
            	c.SetHinici(t2);
            	Prop.PS("Hora d'Inici actualitzada amb exit");
            	break;
            	
            case 8:
            	Prop.PS("Crearem una llista de 2 sessions");
            	List<Sessio> ls=new ArrayList<Sessio>();
            	Prop.PS("Escriu el pes de la primera sessio:");
            	line2 = teclado.readLine();
        		m= Integer.parseInt(line2);
        		Sessio s1=new Sessio(m);
        		ls.add(s1);
            	Prop.PS("Escriu el pes de la segona sessio:");
            	line2 = teclado.readLine();
        		h= Integer.parseInt(line2);
        		Sessio s2=new Sessio(h);
        		ls.add(s2);
        		c.SetSessions(ls);
        		Prop.PS("Llista de sessions afegida correctament");
            	break;
            case -1:
            	menu();
            	break;
            }
            
            linea = teclado.readLine(); 
        }
		
		
		/*try
		{
			Prop.PS("Afegirem 3 sessions al congres de 50,60,30 respectivament");
			Congres c=Congres.getInstance();
			Sessio s=new Sessio(50);
			c.AfegirSessio(s);
			s=new Sessio(60);
			c.AfegirSessio(s);
			s=new Sessio(30);
			c.AfegirSessio(s);
			
			Prop.PS("");
			Prop.PS("Mostrem les sessions del congres:");
			for(int i=0;i<c.NumSessions();i++){
				s=c.GetSessio(i);
				print(s);
			}
			Prop.PS("Esborrem la comunicacio amb id=2");
			s=c.GetSessio(1);
			c.EliminarSessio(s);
			
			Prop.PS("");
			Prop.PS("Mostrem les sessions del congres:");
			for(int i=0;i<c.NumSessions();i++){
				s=c.GetSessio(i);
				print(s);
			}
			Prop.PS("");
			Prop.PS("Hora inici i final del congres:");
			Prop.PS("Hora inici: "+c.getHinici().toString());
			Prop.PS("Hora final: "+c.GetHFinal().toString());
			Prop.PS("");
			Prop.PS("Modifiquem hora inici i final del congres(02:00 - 20:00):");
			c.getHinici().SetHora(20);
			c.getHinici().SetMinuts(0);
			c.GetHFinal().SetHora(20);
			c.GetHFinal().SetMinuts(0);
			Prop.PS("Hora inici: "+c.getHinici().toString());
			Prop.PS("Hora final: "+c.GetHFinal().toString());
		}catch(Exception e)
		{
			Prop.PS("Error!");
		}*/
		
		Prop.PS("");
		Prop.PS("-------");
		Prop.PS("Fi del provador.");
	}
	
	/**
	 * Print.
	 * 
	 * @param s the s
	 */
	public static void print(Sessio s){
		Prop.PS("Id: "+s.GetId()+" Duracio: "+s.GetPes());
	}
	
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Afegir Sessio");
		Prop.PS("2. Eliminar Sessio"); 
		Prop.PS("3. Numero de sessions que hi ha al congres");
		Prop.PS("4. Consultar Hora Final sessio");
		Prop.PS("5. Modificar Hora Final");
		Prop.PS("6. Consultar Hora Inici sessio");
		Prop.PS("7. Modificar Hora Inici");
		Prop.PS("8. Afegir llista de sessions");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}
}
