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
 * Implementat per Rosina Garcia
 */
package capa2;

import java.util.*;

// TODO: Auto-generated Javadoc


/**
 * The Class Comunicacio.
 */
public class Comunicacio implements Activitat {
	
	/** The D. */
	private static int D=30;
	
	/** The NUM. */
	private static int NUM;
	
	/** The RelTotal. */
	private static int RelTotal;   //numero de panets totals
	
	//private Dictionary<Comunicacio,Integer> SEMBLANTS;
	
	/** The autor. */
	private Autor autor;
	
	/** The duracio. */
	private int duracio;
	
	/** The grau0. */
	private List<Comunicacio> grau0;
	
	/** The grau2. */
	private List<Comunicacio> grau2;
	
	/** The h inici. */
	private Temps hInici;
	
	/** The id. */
	private int id;
	
	/** The nom. */
	private String nom;
	
	/** The RelComu. */
	private int RelComu;        //numero de panets que te la comunicacio
	
	/** The s. */
	private Sessio s;
	
	/** The temes. */
	private List<Tema> temes;		//temes als que pertany la comunicacio
	
	/**
	 * The Constructor.
	 * 
	 * @param nom the nom
	 * 
	 * @throws Exception the exception
	 */
	public Comunicacio(String nom) throws Exception {
		NUM++;
		
		id = NUM;
		duracio=D;
		this.nom=nom;
		hInici = null;
		s = null;
		temes = new ArrayList<Tema>();		
		if(grau2==null)grau2 = new ArrayList<Comunicacio>();
		if(grau0==null)grau0 = new ArrayList<Comunicacio>();
		
	}
	
	/**
	 * The Constructor.
	 * 
	 * @param duracio the duracio
	 * @param nom the nom
	 * 
	 * @throws Exception the exception
	 */
	public Comunicacio(String nom, int duracio) throws Exception {
		NUM++;
		
		id = NUM;
		this.duracio = duracio;
		this.nom = nom;
		hInici = null;
		s = null;
		if(grau2==null)grau2 = new ArrayList<Comunicacio>();
		if(grau0==null)grau0 = new ArrayList<Comunicacio>();
		temes = new ArrayList<Tema>();	
		
	}
	
	/**
	 * Afegir tema.
	 * 
	 * @param t the t
	 * 
	 * @throws Exception the exception
	 */
	public void AfegirTema(Tema t) throws Exception {
		
		if(!temes.contains(t)) temes.add(t);
		
	}
	
	/**
	 * Assignat.
	 * 
	 * @return true, if assignat
	 */
	public boolean Assignat(){
		if (hInici==null) return false;
		else return true;
	}
	
	/**
	 * Augmentar associats.
	 * 
	 * @return the int (que es el numero de relacions que hem augmentat)
	 */
	public int AugmentarAssociats()
	{
		int ret=0;
		for(int i=0;i<grau2.size();i++){
			if(grau2.get(i).AugmentarRelComu()) ret++;
		}
		return ret;
	}
	
	/**
	 * Augmentar RelComu.
	 * 
	 * @return true, if augmentar RelComu
	 */
	public boolean AugmentarRelComu()
	{
		RelComu++;
		if(RelComu==1) return true;
		else return false;
	}
	
	/**
	 * Conte tema.
	 * 
	 * @param t the t
	 * 
	 * @return true, if conte tema
	 */
	public boolean ConteTema(Tema t)
	{
		return temes.contains(t);
	}
	
	/**
	 * Copy.
	 * 
	 * @param c the c
	 */
	public void Copy(Comunicacio c, Sessio s){
		this.s=s;
		this.autor=c.autor;
		this.nom=c.nom;
		this.temes=c.temes;
		this.duracio=c.duracio;
		this.hInici=c.hInici;
		this.id=c.id;
	}
	
	/**
	 * Disminuir associats.
	 * 
	 * @return the int  (retorna el numero de relacions que s'han trencat)
	 */
	public int DisminuirAssociats()
	{
		int ret=0;
		for(int i=0;i<grau2.size();i++){
			if(grau2.get(i).DisminuirRelComu()) ret++;
		}
		return ret;
	}
	
	/**
	 * Disminuir RelComu.
	 * 
	 * @return true, if disminuir RelComu
	 */
	public boolean DisminuirRelComu()
	{
		RelComu--;
		if(RelComu==0) return true;
		else return false;
	}
	
	/**
	 * Gets the autor.
	 * 
	 * @return the autor
	 */
	public Autor GetAutor() {
		
		return autor;
		
	}
	
	/**
	 * Gets the com.
	 * 
	 * @return the comunicacio
	 */
	public Comunicacio GetCom(){ 
		
		return this;
		
	}
	

	/**
	 * Gets the descans.
	 * 
	 * @return the inclou descans
	 */
	public InclouDescans GetDescans(){ 
		
		return null;
		
	}

	/**
	 * Gets the duracio.
	 * 
	 * @return the int
	 */
	public int GetDuracio() {
		
		return duracio;
		
	}

	/**
	 * Gets the grau.
	 * 
	 * @param c the c
	 * 
	 * @return the int
	 */
	public int GetGrau(Comunicacio c) {
		
		if(grau0.contains(c)) return 0;
		else if(grau2.contains(c)) return 2;
		else return 1;
	}

	/**
	 * Gets the H inici.
	 * 
	 * @return the temps
	 */
	public Temps GetHInici() {
		
		return hInici;
		
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
	 * Gets the inici.
	 * 
	 * @return the temps
	 */
	public Temps GetInici(){
		
		return this.hInici;
		
	}

	/**
	 * Gets the nom.
	 * 
	 * @return the string
	 */
	public String GetNom() {
		
		return nom;
		
	}

	/**
	 * Gets the num temes.
	 * 
	 * @return the int
	 */
	public int GetNumTemes ()
	{
		return temes.size();
	}

	/**
	 * Gets the RelComu.
	 * 
	 * @return the int
	 */
	public int GetRelComu()
	{
		return RelComu;
	}


	/**
	 * Gets the RelTotal.
	 * 
	 * @return the RelTotal
	 */
	public int GetRelTotal(){
		return RelTotal;
	}
	
	// Aquesta part es de la interface

	/**
	 * Gets the sessio.
	 * 
	 * @return the sessio
	 */
	public Sessio GetSessio() {
		
		return s;
		
	}
	
	/**
	 * Gets the tema.
	 * 
	 * @param i the i
	 * 
	 * @return the tema
	 */
	public Tema GetTema(int i)
	{
		return temes.get(i);
	}
	
	/**
	 * Gets the temes.
	 * 
	 * @return the list< tema>
	 */
	public List<Tema> GetTemes() {
		
		return temes;
		
	}
	
	/**
	 * Gets the tiRelTotal.
	 * 
	 * @return the int
	 */
	public int GetTipus() {
		
		return 2;
		
	}
	
	/**
	 * Sets the autor.
	 * 
	 * @param autor the autor
	 */
	public void SetAutor(Autor autor) {
		
		this.autor = autor;
		
	}

	/**
	 * Sets the duracio.
	 * 
	 * @param duracio the duracio
	 */
	public void SetDuracio(int duracio) {
		
		this.duracio = duracio;
		
	}

	/**
	 * Sets the grau.
	 * 
	 * @param c the c
	 * @param x the x
	 */
	public void SetGrau(Comunicacio c,int x){
		if(c!=this)
		{
			if(x==2) //si el grau es 2
			{
				if(!grau2.contains(c)&&!grau0.contains(c)){
					grau2.add(c);
					c.SetGrauNR(this,x);
					RelComu++;
					if(RelComu<=2 && c.GetRelComu()<=2) RelTotal++;
				}
			}
			if(x==0) //si el grau es 0
			{
				if(!grau0.contains(c)&&!grau2.contains(c)){
					grau0.add(c);
					SetGrauNR(this,x);
				}
			}
		}
	}
	
	/**
	 * Sets the grau NR.
	 * 
	 * @param c the c
	 * @param x the x
	 */
	public void SetGrauNR(Comunicacio c,int x){
		if(x==2) 
			{
				RelComu++;
				if(!grau2.contains(c)&&!grau0.contains(c))grau2.add(c);
			}
		if(x==0){
			if(!grau0.contains(c)&&!grau2.contains(c))grau0.add(c);
		}
	}
	
	/**
	 * Sets the H inici.
	 * 
	 * @param inici the inici
	 */
	public void SetHInici(Temps inici) {
		
		hInici = inici;
		
	}
	
	/**
	 * Sets the id.
	 * 
	 * @param id the id
	 */
	public void SetId(int id) {
		
		this.id = id;
		
	}
	
	/**
	 * Sets the inici.
	 * 
	 * @param t the t
	 */
	public void SetInici(Temps t){
		
		this.hInici = t;
		
	}
	
	/**
	 * Sets the nom.
	 * 
	 * @param nom the nom
	 */
	public void SetNom(String nom) {
		
		this.nom = nom;
		
	}
	
	/**
	 * Sets the RelComu.
	 * 
	 * @param x the x
	 */
	public void SetRelComu(int x){
		RelComu=x;
	}
	
	/**
	 * Sets the sessio.
	 * 
	 * @param s the s
	 */
	public void SetSessio(Sessio s) {
		
		this.s = s;
		
	}
	
	/**
	 * Sets the temes.
	 * 
	 * @param temes the temes
	 */
	public void SetTemes(List<Tema> temes) {
		
		this.temes = temes;
		
	}
	
	/**
	 * Tema string.
	 * 
	 * @return the string
	 */
	private String TemaString() {
		
		String text = "";
		for(int i = 0; i < this.GetTemes().size(); i++) {
			text = text + " " + this.GetTemes().get(i).toString()+",";
		}
			
		return text;
	}
	public String toString() {
		
		return this.nom + ", " + "per "+this.autor.toString()+" - " + Integer.toString(this.duracio) + "minuts";
		
	}
	
	/**
	 * To string.
	 * 
	 * @return the string
	 */
	public String ToString() {
		
		String text = "";
		text = "Conferencia: \"" + this.nom+ "\"\n";
		text = text + "Duracio: " + this.GetDuracio()+ " min\n";
		if(this.autor!=null)text = text + "Autor: " + this.autor.toString()+ "\n";
		else text = text + "Autor: " + this.autor+ "\n";
		text = text + "Temes: [" +  this.TemaString()+"]\n";
		if(this.hInici!=null) text = text + "Starts at: " + this.hInici.toString()+"\n";
		return text;
		
	}
}

