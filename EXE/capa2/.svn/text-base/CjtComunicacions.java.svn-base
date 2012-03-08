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
 * Implementada per Clemente Tort
 */


package capa2;
//to do: una funcio que em retorni tots els autors

import java.util.*;

// TODO: Auto-generated Javadoc


/**
 * The Class CjtComunicacions.
 */
public class CjtComunicacions {
	
	/** The comunicacions. */
	private List<Comunicacio> comunicacions; 	
	
	/** The durada tot. */
	private int duradaTot;
	
	/** The com assig. */
	private int comAssig; 	//num de comunicacions assignades
	
	/**
	 * The Constructor.
	 */
	private CjtComunicacions() {
		
		comunicacions = new ArrayList<Comunicacio>();
		
	}

	public void InicialitzarCJTComunicacions()
	{
		comunicacions.clear();
		comAssig=0;
	}
	
    public List<Comunicacio> GetComunicacions() {
		return comunicacions;
	}

	/**
     * Gets the instance.
     * 
     * @return the cjt comunicacions
     */
    public static CjtComunicacions GetInstance() {
    	
        return CjtComunicacionsHolder.instance;
        
    }

    /**
     * The Class CjtComunicacionsHolder.
     */
    private static class CjtComunicacionsHolder {
    	
           /** The instance. */
           private static CjtComunicacions instance = new CjtComunicacions();
           
    }
    
    //  Afegeix una nova comunicacio a la llista
    /**
     * Afegir C.
     * 
     * @param a the a
     */
    public void AfegirC(Comunicacio a) {
    	
    	int d=a.GetDuracio();
    	int duracio; //se li calcula la durada del descans per sumar-la a duradaTot
    	if(d>60)
		{
			duracio=30;
		}
		
		else if (d>30)
		{
			duracio=20;
		}
		
		else
		{
			duracio=10;
		}
    	if(!comunicacions.contains(a)) {
    		if(comunicacions.size() == 0){
    			comunicacions.add(a);
    			duradaTot+=a.GetDuracio()+duracio;  //afegim la comunicacio i se li suma a duradaTot la durada de la comunicacio + el descans
    		}
    		else {
    			boolean b = false;
    			int i = 0;
	    		while(!b && i < comunicacions.size()) {
	    			if(comunicacions.get(i).GetDuracio() >= a.GetDuracio()) i++;
	    			else {
	    				comunicacions.add(i,a);
	    				duradaTot+=a.GetDuracio()+duracio;
	    				b = true;
	    			}
	    		}
	    		if(!b) {
	    			comunicacions.add(a);
	    			duradaTot+=a.GetDuracio()+duracio;
	    		}
    		} 		
    	}
    }
    
    //  Elimina una comunicacio de la llista
    /**
     * Del com.
     * 
     * @param a the a
     */
    public void DelCom(Comunicacio a) {
    	if(comunicacions.contains(a)) comunicacions.remove(a);
    }

    /**
     * Gets the gorda.
     * 
     * @return the comunicacio
     */
    public Comunicacio GetGorda() {
    	
    	Comunicacio ret = null;
    	for(int i = 0; i < comunicacions.size(); i++) {
    		if(comunicacions.get(i).GetHInici() == null){
    			ret = comunicacions.get(i);
    			i = comunicacions.size();
    		}
    	}
    	return ret;
    	
    }
    //  Retorna el numero de comunicacions que tenim
    /**
     * Gets the size.
     * 
     * @return the int
     */
    public int GetSize(){
    	return comunicacions.size();
    }
    
    /**
     * Gets the com.
     * 
     * @param i the i
     * 
     * @return the comunicacio
     */
    public Comunicacio GetCom(int i)
    {
    	return comunicacions.get(i);
    }
    
    /**
     * Checks if is empty.
     * 
     * @return true, if is empty
     */
    public boolean IsEmpty()
    {
    	//diu si totes les comunicacions estan assignades o no
    	return comAssig==comunicacions.size();
    }

	/**
	 * Gets the durada tot.
	 * 
	 * @return the durada tot
	 */
	public int GetDuradaTot() {
		return duradaTot;
	}

	/**
	 * Sets the durada tot.
	 * 
	 * @param duradaTot the durada tot
	 */
	public void SetDuradaTot(int duradaTot) {
		this.duradaTot = duradaTot;
	}

    /**
     * Augmentar com assig.
     */
    public void AugmentarComAssig()
    {
    	comAssig++;
    }
    
    /**
     * Clean.
     */
    public void Clean()
    {
    	for(int i=0; i<comunicacions.size(); i++)
    	{
    		comunicacions.get(i).SetHInici(null);
    	}
    	comAssig=0;
    }
    
    /**
     * Disminuir com assig.
     */
    public void DisminuirComAssig()
    {
    	comAssig--;
    }
    
    /**
     * Getcom assig.
     * 
     * @return the int
     */
    public int GetcomAssig()
    {
    	return comAssig;
    }
}
