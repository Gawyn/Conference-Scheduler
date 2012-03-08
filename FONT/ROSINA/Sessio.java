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
 * Implementada per Rosina Garcia
 */
package capa2;

import java.util.*;

//TODO: Auto-generated Javadoc

/**
 * The Class Sessio.
 */
public class Sessio {
	
	/** The NUM. */
	private static int NUM;
	
	/** The activitats. */
	private List<Activitat> activitats;
	
	/** The com AS. */
	private int comAS; //numero de comunicacions ja assignades a la sessio
	
	/** The id. */
	private int id;
	
	/** The perc. */
	private int perc; //percentatge de semblansa que tenen les comunicacions
	
	/** The pes. */
	private int pes; //pes inicialment 0, cada cop que afegim comunicacio, augmentem el pes de la sessio.
	
	
	/**
	 * The Constructor.
	 */
	public Sessio() {
		
		NUM++;
		
		this.id = NUM;
		
		activitats = new ArrayList<Activitat>();
		
	}
	
	/**
	 * Adds the act.
	 * 
	 * @param psemblansa: la semblansa que te la activitat amb la ultima comunicacio assignada
	 * @param a the a
	 * 
	 * @return true, if add act
	 */
	public boolean AddAct(Activitat a, int psemblansa) {
		
		Congres c=Congres.GetInstance();
		int durada = a.GetDuracio();
		int pc=c.Pes(); //pes del congres
		if((( pes + durada) <= (pc + durada)) && !activitats.contains(a)) //si la activitat hi cap a la sessio i no hi es
		{
			activitats.add(a);
			if(a.GetTipus()==2)  //si es de tipus Comunicacio
			{
				CjtComunicacions cjt=CjtComunicacions.GetInstance();
				cjt.AugmentarComAssig();
				RecalcularPercentatge(psemblansa);
				comAS++;
				
			}
			Temps t=new Temps(0,0);
			t.PesToTemps(pes);		//calculem hora inici
			a.SetInici(t);
			pes = pes + durada;
			a.SetSessio(this);
			return true;
		}
		else return false;
	}
	
	
	/**
	 * Adds the act.
	 * 
	 * @param psemblansa the psemblansa entre la activitat que afegim i la ultima activitat
	 * @param a the a es la activitat que afegim
	 * @param pos the pos on la volem afegir
	 * 
	 * @return true, if add act
	 */
	public boolean AddAct(int pos, Activitat a, int psemblansa) {
		
		Congres c=Congres.GetInstance();
		int pc=c.Pes();
		int durada = a.GetDuracio();
		if((( pes + durada) <= (pc + durada)) && !activitats.contains(a)) //si la activitat hi cap i no existix ja a la sessio
		{
			activitats.add(pos,a);
			if(a.GetTipus()==2) //si es de tipus comunicacio
			{
				CjtComunicacions cjt=CjtComunicacions.GetInstance();
				cjt.AugmentarComAssig();
				RecalcularPercentatge(psemblansa);
				comAS++;
			}
			Temps t=new Temps(0,0);
			t.PesToTemps(pes);
			a.SetInici(t);
			pes = pes + durada;
			a.SetSessio(this);
			return true;
		}
		else return false;	
	}
	
	/**
	 * Clean.
	 */
	private void Clean()
	{
		comAS=0;
		perc=0;
		pes=0;
		activitats = new ArrayList<Activitat>();
	}
	
	
	/**
	 * Copy.
	 * 
	 * @param s the s
	 * 
	 * @throws Exception the exception
	 */
	public void Copy(Sessio s) throws Exception
	{
		Clean();
		InclouDescans iD;
		Comunicacio c;
		List<Activitat> la=s.GetActivitats();
		id=s.GetId();
		pes=s.GetPes();
		comAS=s.GetCas();
		perc=s.GetPerc();
		for(int i=0; i<la.size(); i++)
		{
			if(la.get(i).GetTipus()==1){
				iD=new InclouDescans(null);
				iD.Copy((InclouDescans)la.get(i),this);
				activitats.add(iD);
			}else if(la.get(i).GetTipus()==2){
				c=new Comunicacio("",0);
				c.Copy((Comunicacio)la.get(i),this);
				activitats.add(c);
			}
		}
		
		
	}
	
	
	/**
	 * Del activitat.
	 * 
	 * @param psemblansa the psemblansa
	 * @param a the a
	 */
	public void DelActivitat(Activitat a, int psemblansa)
	{
		int pos=Posicio(a);
		if(a.GetTipus()==2)  //si activitat es de tipus comunicacio
		{
			EsborrarC(pos, psemblansa);
			comAS--;
			CjtComunicacions cjt=CjtComunicacions.GetInstance();
			cjt.DisminuirComAssig();
			
		}
		else EsborrarD(pos);
	}
	
	
	/**
	 * Esborrar Comunicacio
	 * 
	 * @param psemblansa the psemblansa
	 * @param pos the pos on es troba de la llista d'activitats
	 */
	private void EsborrarC(int pos, int psemblansa)
	{
		
		Activitat a = activitats.get(pos);
		a.SetInici(null);
		int durada = a.GetDuracio();
		activitats.remove(pos);
		pes = pes - durada;
		if(comAS>1) perc-=psemblansa;  //actualitzem semblansa
		else if(comAS<=1) perc=0;
	}
	
	/**
	 * Esborrar Descans
	 * 
	 * @param pos the pos
	 */
	private void EsborrarD(int pos) {
		
		Activitat a = activitats.get(pos);
		activitats.remove(pos);
		int durada = a.GetDuracio();
		pes = pes - durada;
		a.SetInici(null);
		
	}
	
	
	/**
	 * Gets the act.
	 * 
	 * @param p the p
	 * 
	 * @return the activitat
	 */
	public Activitat GetAct(int p) {
		
		return activitats.get(p);
		
	}
	
	/**
	 * Gets the activitats.
	 * 
	 * @return the list< activitat>
	 */
	public List<Activitat> GetActivitats() {
		
		return activitats;
		
	}
	
	/**
	 * Gets the cas.
	 * 
	 * @return the int
	 */
	public int GetCas()
	{
		return comAS;
	}
	
	/**
	 * Gets the id.
	 * 
	 * @return the int
	 */
	public int GetId() {
		
		return id;
		
	}
	
	/**
	 * Sets the id.
	 * 
	 * @return the int
	 */
	public void SetId(int id) {
		
		this.id=id;
		
	}
	
	/**
	 * Gets the last comunicacio assignada
	 * 
	 * @return the comunicacio
	 */
	public Comunicacio GetLastCom(){
		for(int a=activitats.size()-1;a>-1;a--){
			if(activitats.get(a).GetTipus()==2)  //si es de tipus comunicacio
			{
				return (Comunicacio)activitats.get(a);
			}
		}
		return null;
	}
	
	/**
	 * Gets the perc.
	 * 
	 * @return the int
	 */
	public int GetPerc() {
		return perc;
	}
	
	/**
	 * Gets the pes.
	 * 
	 * @return the int
	 */
	public int GetPes() {
		
		return pes;
		
	}
	
	
	/**
	 * Posicio.
	 * 
	 * @param a the a
	 * 
	 * @return la posicio de la llista d'activitats on es troba a
	 */
	public int Posicio(Activitat a) {
		
		for(int i=0;i<activitats.size();i++){
			if (activitats.get(i)  == a) return i;
		}
		return 0;

	}
	
	/**
	 * Recalcular Horari.
	 * Actualitza els temps de les activitats quan es fan intercanvis manuals d'activitats
	 * 
	 */
	
	public void RecalcularHorari()
	{
		pes=0;
		for(int i=0;i<activitats.size();i++)
		{
			activitats.get(i).GetInici().PesToTemps(pes);
			pes = pes + activitats.get(i).GetDuracio();
		}
	}
	
	/**
	 * Recalcular percentatge.
	 * 
	 * @param psemb the psemb
	 */
	public void RecalcularPercentatge(int psemb)
	{
		if(comAS>=1) perc+=psemb;
		if(comAS<1) perc=0;
	}
	
	/**
	 * Sets the activitats.
	 * 
	 * @param activitats the activitats
	 */
	public void SetActivitats(List<Activitat> activitats) {
		
		this.activitats = activitats;
		int d;
		for(int i = 0; i < activitats.size(); i++) {
			d = activitats.get(i).GetDuracio();
			pes = pes - d;
		}
	}
	
	
	/**
	 * Sets the perc.
	 * 
	 * @param perc the perc
	 */
	public void SetPerc(int perc) {
		this.perc = perc;
	}
	
	/**
	 * Sets the pes.
	 * 
	 * @param pes the pes
	 */
	public void SetPes(int pes) {
		
		this.pes = pes;
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String toString() {
		
		return "Sessio #: " + this.id + " (" + this.pes + " min)";
		
	}
	
}
