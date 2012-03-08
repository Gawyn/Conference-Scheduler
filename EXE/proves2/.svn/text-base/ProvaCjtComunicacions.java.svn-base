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
 * The Class ProvaCjtComunicacions.
 */
public class ProvaCjtComunicacions {
	
	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception
	{
		String linea, line2;
		int x;
		BufferedReader teclado=new BufferedReader( new InputStreamReader(System.in));
		Prop.PS("- TEST DE CJTCOMUNICACIONS\n==================\n");
		Prop.PS("Creem un conjunt de comunicacions");
		CjtComunicacions cc= new CjtComunicacions();
		Prop.PS("Creacio completada amb exit");
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
            	System.out.println("Creem una Comunicacio");
        		Prop.PS("Escriu el nom:\n");
            	line2 = teclado.readLine();
            	System.out.println("Escriu la durada");
            	linea = teclado.readLine();
            	x = Integer.parseInt(linea);
            	Comunicacio c = new Comunicacio(line2,x);
            	cc.AfegirC(c);
            	System.out.println("Comunicacio afegida amb exit");
            	break;
            	
            case 2:
            	if(cc.GetSize()==0) System.out.println("No hi ha comunicacions al conjunt");
            	else{
	            	Comunicacio c1= cc.GetGorda();
	            	System.out.println("Comunicacio amb mes durada: "+c1.ToString());
	            	cc.DelCom(c1);
	            	System.out.println("S'ha borrat la comunicacio amb mes durada satisfactoriament");
            	}
            	break;
            	
            case 3:
            	if(cc.GetSize()==0) Prop.PS("No hi ha comunicacions al conjunt");
            	else
            	{
	            	Comunicacio c1= cc.GetGorda();
	            	Prop.PS("Comunicacio amb mes durada: "+c1.ToString());
	            }
            	break;
            	
            case 4:
            	Prop.PS("#comunicacions = " +cc.GetSize());
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

		
		/*try{
			
			CjtComunicacions cjt=new CjtComunicacions();
			Prop.PS("Afegim una comunicacio 1 amb duracio 40'");
			Comunicacio c=new Comunicacio("comunicacio 1",40);
			cjt.afegirC(c);
			Prop.PS("Numero de comunicacions al conjunt: "+cjt.GetSize());
			Prop.PS("Afegim una comunicacio 2 amb duracio 20'");
			c=new Comunicacio("comunicacio 2",20);
			cjt.afegirC(c);
			Prop.PS("Afegim una comunicacio 3 amb duracio 80'");
			c=new Comunicacio("comunicacio 3",80);
			cjt.afegirC(c);
			Prop.PS("Afegim una comunicacio 4 amb duracio 12'");
			c=new Comunicacio("comunicacio 4",10);
			cjt.afegirC(c);
			Prop.PS("Numero de comunicacions al conjunt: "+cjt.GetSize());
			Prop.PS();
			Prop.PS("Ara anirem treient les comunicacions amb mes duracio");
			Prop.PS("del conjunt i les imprimirem per pantalla han de sortir en ordre de duracio");
			Prop.PS();
			c=cjt.getGorda();
			do{
				print(c);
				cjt.delCom(c);
				c=cjt.getGorda();
			}while(c!=null);
		}catch(Exception e){
			Prop.PS("Error!");
		}*/
	
	}
	/*private static void print(Comunicacio c){
		Prop.PS("Nom: "+c.GetNom()+" Id: "+c.GetId()+" Duracio "+c.GetDuracio()+" ");
		Prop.PS();
	}*/
	/**
	 * Menu.
	 */
	private static void menu(){
    	Prop.PS("");
		Prop.PS("1. Afegir Comunicacio");
		Prop.PS("2. Eliminar Comunicacio amb mes durada");
		Prop.PS("3. Mostrar la Comunicacio amb mes durada");
		Prop.PS("4. Numero de Comunicacions que hi ha al CjtComunicacions");
		Prop.PS("-1 Mostra aquest menu");
		Prop.PS("0. Sortir");
	}
}
