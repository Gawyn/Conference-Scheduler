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
 * Implementada per Clemente Tort Barbero
 */
package capa2;


import java.util.*;

//TODO: Auto-generated Javadoc

/**
 * The Class Congres.
 */
public class Congres {
	
	
	
	/** The hinici. */
	private Temps hinici; 	//es l'hora inici mati
	
	/** The hfinal. */
	private Temps hfinal; 	//es l'hora de fi tarda
	
	/** The sessions. */
	private List<Sessio> sessions;
	
	/** The Cxs. */
	private int Cxs;  //comunicacions per sessio
	
	/** The Num sessions. */
	private int NumSessions;
	
	/**
	 * The Constructor.
	 */
	private Congres() {
		
		sessions = new ArrayList<Sessio>();
		hinici = new Temps(8,0);
		hfinal = new Temps(21,0);
	}
	
	/**
	 * Gets the instance.
	 * 
	 * @return the congres
	 */
	public static Congres GetInstance() {
		
		return CongresHolder.instance;
		
	}
	
	/**
	 * The Class CongresHolder.
	 */
	private static class CongresHolder {
		
		/** The instance. */
		private static Congres instance = new Congres();
		
	}
	
	
	/**
	 * Afegir sessio.
	 * 
	 * @param a the a
	 */
	public void AfegirSessio(Sessio a) {
		
		if(!sessions.contains(a)) sessions.add(a);
		
	}
	
	/**
	 * Eliminar sessio.
	 * 
	 * @param a the a
	 */
	public void EliminarSessio(Sessio a) {
		
		if(sessions.contains(a)) sessions.remove(a);
		
	}
	
	/**
	 * Num sessions.
	 * 
	 * @return the int
	 */
	public int NumSessions() {
		
		return sessions.size();
		
	}
	

	public void InicialitzarCong(){
		sessions.clear();
		hinici=null;
		hfinal=null;
		Cxs=0;
		NumSessions=0;
	}
	/**
	 * Gets the sessio.
	 * 
	 * @param a the a
	 * 
	 * @return the sessio
	 */
	public Sessio GetSessio(int a){
		
		return sessions.get(a);
		
	}
	
	/**
	 * Gets the H final.
	 * 
	 * @return the temps
	 */
	public Temps GetHFinal() {
		
		return hfinal;
		
	}
	
	
	
	/**
	 * Sets the H final.
	 * 
	 * @param hft the hft
	 */
	public void SetHFinal(Temps hft) {
		
		this.hfinal = hft;
		
	}
	
	
	
	/**
	 * Gets the hinici.
	 * 
	 * @return the temps
	 */
	public Temps GetHinici() {
		
		return hinici;
		
	}
	
	
	
	/**
	 * Sets the hinici.
	 * 
	 * @param him the him
	 */
	public void SetHinici(Temps him) {
		
		this.hinici = him;
		
	}
	
	
	/**
	 * Gets the sessions.
	 * 
	 * @return the list< sessio>
	 */
	public List<Sessio> GetSessions() {
		
		return sessions;
		
	}
	
	/**
	 * Sets the sessions.
	 * 
	 * @param sessions the sessions
	 */
	public void SetSessions(List<Sessio> sessions) {
		
		this.sessions = sessions;
		
	}
	
	/**
	 * Gets the cxs.
	 * 
	 * @return the cxs
	 */
	public int GetCxs() {
		return Cxs;
	}
	
	/**
	 * Sets the cxs.
	 * 
	 * @param cxs the cxs
	 */
	public void SetCxs(int cxs) {
		Cxs = cxs;
	}
	
	/**
	 * Gets the num sessions.
	 * 
	 * @return the num sessions
	 */
	public int GetNumSessions() {
		return NumSessions;
	}
	
	/**
	 * Sets the num sessions.
	 * 
	 * @param numSessions the num sessions
	 */
	public void SetNumSessions(int numSessions) {
		NumSessions = numSessions;
	}
	
	/**
	 * Clean.
	 */
	private void Clean(){
		sessions = new ArrayList<Sessio>();
	}
	
	/**
	 * Pes.
	 * 
	 * @return the int
	 */
	public int Pes(){
		return this.hfinal.TempsToPes() - hinici.TempsToPes();
	}
	
	/**
	 * Copy.
	 * 
	 * @param s the s
	 * 
	 * @throws Exception the exception
	 */
	public void Copy(Sessio[] s) throws Exception
	{
		Clean();
		Sessio se;
		for(int i=0; i<s.length; i++)
		{
			se=new Sessio();
			se.Copy(s[i]);
			sessions.add(se);
		}
	}
	
	/**
	 * Gets the ses ar.
	 * 
	 * @return the sessio[]
	 */
	public Sessio[] GetSesAr(){
		Sessio s[]=new Sessio[this.sessions.size()];
		for(int i=0;i<this.sessions.size();i++){
			s[i]=sessions.get(i);
		}
		return s;
	}
	
	
	/**
	 * CanviarActivitats.
	 * 
	 * @param a1 the Activitat
	 * 
	 * @throws a2 the Activitat
	 */
	//Canvia dos activitats manualment del congrés
	public boolean CanviarActivitats(Activitat a1,Activitat a2)
	{
		Sessio s1=a1.GetSessio();
		Sessio s2=a2.GetSessio();
		int p1,p2;
		p1=s1.Posicio(a1);
		p2=s2.Posicio(a2);
		System.out.println("Chivato1" +p1);
		System.out.println("Chivato2" +p2);
		
		s1.DelActivitat(a1,0);
		s2.DelActivitat(a2,0);	
		
		s2.AddAct(p2,a1,0);
		s1.AddAct(p1,a2,0);
		
		s1.RecalcularHorari();
		s2.RecalcularHorari();
		
		return true;
	}	
}
