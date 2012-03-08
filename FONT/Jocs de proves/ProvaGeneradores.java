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
import java.util.List;
import java.util.Vector;
import capa3.ControladorDades;
import capa2.*;
// TODO: Auto-generated Javadoc

/**
 * The Class ProvaGeneradores.
 */
public class ProvaGeneradores {

	/**
	 * The main method.
	 * 
	 * @param args the args
	 * 
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Congres c=Congres.GetInstance();
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		Generadores ge=Generadores.GetInstance();
		Comunicacio co;
		Tema t1=new Tema("tema1");
		Tema t2=new Tema("tema2");
		Tema t3=new Tema("tema3");
		Tema t4=new Tema("tema4");
		Tema t5=new Tema("tema5");
		Tema t6=new Tema("tema6");
		Comunicacio com[]=new Comunicacio[40];
		for(int i=1;i<21;i++){
			co=new Comunicacio("Jojojo " +i,4*i);
			co.SetAutor(new Autor("Cristian","Master Leader"));
			switch((i)%6){
			case 0:
				co.AfegirTema(t1);
				co.AfegirTema(t3);
				co.AfegirTema(t5);
				co.AfegirTema(t6);
				break;
			case 1:
				co.AfegirTema(t2);
				break;
			case 2:
				co.AfegirTema(t3);
				break;
			case 3:
				co.AfegirTema(t2);
				co.AfegirTema(t4);
				co.AfegirTema(t6);
				break;
			case 4:
				co.AfegirTema(t2);
				co.AfegirTema(t5);
				co.AfegirTema(t3);
				break;
			case 5:
				co.AfegirTema(t2);
				co.AfegirTema(t3);
				break;
			}
			com[i-1]=co;
			cjt.AfegirC(co);
		}
		com[0].SetGrau(com[2],2);
		com[2].SetGrau(com[3],2);
		com[3].SetGrau(com[5],2);
		com[0].SetGrau(com[4],0);
		com[8].SetGrau(com[15],2);
		com[15].SetGrau(com[18],2);
		com[0].SetGrau(com[15],0);
		com[14].SetGrau(com[1],0);
		com[16].SetGrau(com[7],2);
		
		/*System.out.print(com[0].ToString());
		System.out.print(com[2].ToString());
		System.out.print("Afegides\n");*/
		c.setCxs(5);
		c.setNumSessions(4);
		//c.SetHinici(new Temps(8,0));
		//c.SetHFinal(new Temps(23,59));
		
		
		try{
			ge.GenerarCongresBT();
			List<Sessio> Sessions=c.GetSessions();
			Vector<Activitat> va=new Vector<Activitat>();
	    	for(int i=0;i<c.GetSessions().size();i++){
	    		
	    		List<Activitat> a=Sessions.get(i).GetActivitats();
	    		System.out.println("Sessio "+i +" Percentatge: "+Sessions.get(i).GetPerc()+" Asig: "+Sessions.get(i).GetCas());
	    		for(int j=0;j<a.size();j++){
	    			System.out.print(a.get(j).toString());
	    			va.add(a.get(j));
	    		}
	    		System.out.println("------------------------------");
	    	}
	    	//ControladorDades cd=new ControladorDades();
	    	//cd.EscriureDadesDiscXML("clemente.xml", va);
		}catch(Exception e){
			System.out.println(e.getMessage());
			System.out.print("ERror");
			//System.out.println(e.getCause().getMessage());
		}
		
	}

}
