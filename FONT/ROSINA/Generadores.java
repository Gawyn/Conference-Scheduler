/* PRACTICA PROP CLUSTER 6.1
 * ===================================
 * Enunciat 1: Generador d'horaris  ==
 * ===================================
 * 
 * Rosina Garcia 
 * Clemente Tort
 * Cristian Planas
 * Oscar Camacho
 * � 2006. 
 * 
 * Implementada per 
 */
package capa2;
import java.lang.Throwable;
import java.util.*;
// TODO: Auto-generated Javadoc
class ComunicacioPer{
	public Comunicacio c;
	public int p;
}

/**
 * The Class Generadores.
 */
public class Generadores {
	
	/** The matriu. */
	private static int[][] matriu;
	//private static boolean mod;
	/** The vector. */
	private static Comunicacio[] vector;
	//private static Vector vector;
	/** The relacions. */
	private static int relacions;
	
	/** The descans dinar. */
	private static boolean descansDinar=false;
	
	/**
	 * The Constructor.
	 */
	private Generadores() {
		//mod=false;
	}
	
	/**
	 * Gets the instance.
	 * 
	 * @return the generadores
	 */
	public static Generadores GetInstance() {
		
		return GeneradoresHolder.instance;
		
	}
	
	/**
	 * The Class GeneradoresHolder.
	 */
	private static class GeneradoresHolder {
		
		/** The instance. */
		private static Generadores instance = new Generadores();
	}
	
	/**
	 * Generar congres BT.
	 * 
	 * @throws Exception the exception
	 */
	public static void GenerarCongresBT() throws Exception
	{
		Congres c=Congres.GetInstance();
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		if((c.GetCxs()!=0)&&(c.GetNumSessions()!=0))
		{
			
			Sessio[] auxSessions=new Sessio[c.GetNumSessions()];
			for(int i=0;i<c.GetNumSessions();i++) auxSessions[i]=new Sessio();
			GenerarCongresVoras();
			cjt.Clean();
			BT1(auxSessions);
			
		}else if((c.GetNumSessions()!=0))
		{
			GenerarCongresVoras();
			cjt.Clean();
			if(cjt.GetDuradaTot()>c.GetHFinal().TempsToPes()*c.GetNumSessions()) throw new Exception("Error d'integritat");
			
			c.SetCxs(cjt.GetSize()/c.GetNumSessions());
			if(cjt.GetSize()%c.GetNumSessions()!=0) c.SetCxs(c.GetCxs()+1);
			
			Sessio[] auxSessions=new Sessio[c.GetNumSessions()];
			for(int i=0;i<c.GetNumSessions();i++) auxSessions[i]=new Sessio();
			
			BT1(auxSessions);
			c.SetCxs(0);
			
		}else if(c.GetCxs()!=0)
		{
			GenerarCongresVoras();
			
			cjt.Clean();
			if(cjt.GetSize()%c.GetCxs()!=0)c.SetNumSessions(cjt.GetSize()/c.GetCxs()+1);
			else c.SetNumSessions(cjt.GetSize()/c.GetCxs());
			
			Sessio[] auxSessions=new Sessio[c.GetNumSessions()];
			for(int i=0;i<c.GetNumSessions();i++) auxSessions[i]=new Sessio();
			
			BT1(auxSessions);
			
			c.SetNumSessions(0);
		}else
		{
			GenerarCongresVoras();
			
			cjt.Clean();
			
			BT2();
		}
	}
	
	/**
	 * B t1.
	 * 
	 * @param auxSessions the aux sessions
	 * 
	 * @return true, if B t1
	 * 
	 * @throws Exception the exception
	 */
	private static boolean BT1(Sessio[] auxSessions)throws Exception{
		//System.out.println("Recursio!");
		
		GenerarM();
		Comunicacio c=new Comunicacio("");
		relacions=c.GetRelTotal();
		//System.out.println("ooo!");
		
		BT1H(auxSessions,0);
		//System.out.println("Fi!!");
		return true;
	}
	
	/**
	 * B t1 H.
	 * 
	 * @param posP the pos P
	 * @param auxSessions the aux sessions
	 * 
	 * @throws Exception the exception
	 */
	private static void BT1H(Sessio auxSessions[],int posP)throws Exception{
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		ComunicacioPer c=new ComunicacioPer();
		Congres co=Congres.GetInstance();
		InclouDescans ID=null;    
		boolean b=false;
		int pussy=0;
		int pussyUlt=0;
		//System.out.println("nivell "+auxSessions[posP].GetCas() +" auxSessions "+posP);
		for(int i=0;i<cjt.GetSize();i++){
			c.c=cjt.GetCom(i);
			
			if(!c.c.Assignat()){// Si no esta assignada...
				
				if(auxSessions[posP].GetCas()!=0){// y no es la primera...
					
					//Mirem el percentatge de temes en comu a la matriu
					c.p=matriu[TrobarPosicio(auxSessions[posP].GetLastCom())][TrobarPosicio(c.c)];
					
					pussy=auxSessions[posP].GetLastCom().GetRelComu();
					if(pussy>0) relacions--;
					auxSessions[posP].GetLastCom().DisminuirAssociats();
					auxSessions[posP].GetLastCom().SetRelComu(0);
					
					//Si l'anterior amb aquesta era de grau 2...
					if(auxSessions[posP].GetLastCom().GetGrau(c.c)==2)
					{
						c.p+=101;
						//Augmentem el grau de semblança
						//pussy=auxSessions[posP].GetLastCom().GetRelTotalsy();
						//Mirem les relacions que tenia per tal de restaurar-les
						//auxSessions[posP].GetLastCom().DisminuirAssociats();
						// Reduim el nombre de relacions dels associats, en cas de que algu es faci 0 el descomptem
						// de les posibles relacions vàlides 
						//auxSessions[posP].GetLastCom().SetPussy(0);
						// Anotem que el que acabem d'anotar ja no ens serveix per a calcular pesos
					}
					else if(auxSessions[posP].GetLastCom().GetGrau(c.c)==0)c.p-=101;
					// Sino si es de grau 0 restem -101 per baixar el percentatge...
				}else{
					c.p=0;
				}
				// Afegim la comunicacio amb el seu percentatge
				b=auxSessions[posP].AddAct(c.c,c.p);
				
				// Assignem el seu descans
				if(b)
				{
					if(auxSessions[posP].GetCas()==co.GetCxs()){
						pussyUlt=c.c.GetRelComu();
						if(pussyUlt>0) 
						{
							relacions--;
							c.c.SetRelComu(0);
						}
						c.c.DisminuirAssociats();
					}else{
						ID=AsignarDescans(auxSessions[posP],c.c.GetDuracio());
					}
					// Si estem en l'ultia sessio...
					
					if(cjt.IsEmpty()) TaiLoviu(auxSessions); // Mirem si es millor que la que la que tenim al congres
					else if(Estimar2(auxSessions))
					{
						
						if(auxSessions[posP].GetCas()<co.GetCxs()) BT1H(auxSessions,posP);
						else if(posP<auxSessions.length-1) BT1H(auxSessions, posP+1);
						
					}
					//Fem recursio per la seguent sessio
					// Eliminem el descans
					if(auxSessions[posP].GetCas()==co.GetCxs()){
						
						c.c.AugmentarAssociats();
						if(pussyUlt>0) 
						{
							c.c.SetRelComu(pussyUlt);
							relacions++;
						}
						
						
					}else{
						
						auxSessions[posP].DelActivitat(ID,0);
						
					}
					// Eliminem la comunicacio
					auxSessions[posP].DelActivitat(c.c,c.p);
				}
				if(auxSessions[posP].GetCas()!=0){
					auxSessions[posP].GetLastCom().SetRelComu(pussy);
					//System.out.println("3");
					auxSessions[posP].GetLastCom().AugmentarAssociats();
					//System.out.println("4");
					if(pussy>0) relacions++;
					//System.out.println("5");
				}
			}	
		}
	}
	
	/**
	 * B t2.
	 * 
	 * @return true, if B t2
	 * 
	 * @throws Exception the exception
	 */
	private static boolean BT2()throws Exception{
		GenerarM();
		
		Comunicacio c=new Comunicacio("");
		
		relacions=c.GetRelTotal();
		//System.out.println("ooo!");
		List<Sessio> sessions=new ArrayList<Sessio>(); 
		Sessio s=new Sessio();
		sessions.add(s);
		BT2H(sessions,0);
		
		return true;
	}
	
	/**
	 * B t2 H.
	 * 
	 * @param sessions the sessions
	 * @param posP the pos P
	 * 
	 * @throws Exception the exception
	 */
	private static void BT2H(List<Sessio> sessions,int posP)throws Exception{
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		ComunicacioPer c=new ComunicacioPer();
		InclouDescans ID=null;    
		boolean b=false;
		int pussy=0;
		int pussyUlt=0;
		
		//if(!sessions.contains(actual)) sessions.add(actual);
		//System.out.println("nivell "+auxSessions[posP].GetCas() +" auxSessions "+posP);
		for(int i=0;i<cjt.GetSize();i++){
			c.c=cjt.GetCom(i);
			if(!c.c.Assignat()){// Si no esta assignada...
				//System.out.println("1");
				if(sessions.get(posP).GetCas()!=0){// y no es la primera...
					//System.out.println("1");
					//Mirem el percentatge de temes en comu a la matriu
					c.p=matriu[TrobarPosicio(sessions.get(posP).GetLastCom())][TrobarPosicio(c.c)];
					
					pussy=sessions.get(posP).GetLastCom().GetRelComu();
					//Mirem les relacions que tenia per tal de restaurar-les
					if(pussy>0) relacions--;
					sessions.get(posP).GetLastCom().DisminuirAssociats();
					// Reduim el nombre de relacions dels associats, en cas de que algu es faci 0 el descomptem
					// de les posibles relacions vàlides 
					sessions.get(posP).GetLastCom().SetRelComu(0);
					//Si l'anterior amb aquesta era de grau 2...
					
					if(sessions.get(posP).GetLastCom().GetGrau(c.c)==2) c.p+=101;
					else if(sessions.get(posP).GetLastCom().GetGrau(c.c)==0) c.p-=101;
					
					// Sino si es de grau 0 restem -101 per baixar el percentatge...
				}else{
					c.p=0;
				}
				
				// Afegim la comunicacio amb el seu percentatge
				b=sessions.get(posP).AddAct(c.c,c.p);
				
				// Assignem el seu descans
				if(b)
				{
					ID=AsignarDescans(sessions.get(posP),c.c.GetDuracio());
					// Si estem en l'ultia sessio...
					
					if(cjt.IsEmpty()){ TaiLoviu(sessions); System.out.println("Chivato7");}// Mirem si es millor que la que la que tenim al congres
					
					else if(Estimar2(sessions)&&ID!=null){
						BT2H(sessions,posP);
					}
					
					else if(Estimar2(sessions)&&ID==null)
					{
						pussyUlt=c.c.GetRelComu();
						if(pussyUlt>0) relacions--;
						c.c.DisminuirAssociats();
						Sessio s=new Sessio();
						sessions.add(s);
						BT2H(sessions, posP+1);
						sessions.remove(posP+1);
						c.c.AugmentarAssociats();
						if(pussyUlt>0) relacions++;
					}else{
					}
					if(ID!=null)sessions.get(posP).DelActivitat(ID,0);
					//else if(posP<sessions.size()-1) BT2H(sessions, posP+1);
					//else System.out.println("Rebutjem a nivell: "+((posP+1)*sessions.get(posP).GetCas()));
					
					sessions.get(posP).DelActivitat(c.c,c.p);
					
					//Fem recursio per la seguent sessio
					// Eliminem el descans
					
					// Eliminem la comunicacio			
				}
				//Fem recursio per la seguent sessio
				// Eliminem el descans
				
				// Eliminem la comunicacio
				else
				{
					Sessio s=new Sessio();
					sessions.add(s);
					BT2H(sessions, posP+1);
					sessions.remove(posP+1);
				}
				if(sessions.get(posP).GetCas()!=0)
				{
					//En cas de que hagim fet algo de disminuir i tal hem de restaurar a l'estat anterior
					if(pussy>0)relacions++;
					sessions.get(posP).GetLastCom().AugmentarAssociats();
					sessions.get(posP).GetLastCom().SetRelComu(pussy);
				}
			}	
		}
	}
	
	/**
	 * Generar congres voras.
	 * 
	 * @throws Exception the exception
	 */
	public static void GenerarCongresVoras() throws Exception
	{
		Congres c=Congres.GetInstance();
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		if((c.GetCxs()!=0)&&(c.GetNumSessions()!=0))
		{
			//Comprovacio d'integritat
			if(cjt.GetSize()!=(c.GetCxs()*c.GetNumSessions())) throw new Exception("Error d'integritat",new Throwable("Numero de comunicacions per sessio i Numero de sessions no concorden amb el numero de comunicacions") );
			if(cjt.GetDuradaTot()+(120*c.GetNumSessions())>c.GetHFinal().TempsToPes()*c.GetNumSessions()) throw new Exception("Error d'integritat: Comunicacions + Descansos no hi caben");
			Voras1(0);
		}else if((c.GetNumSessions()!=0))
		{
			if(cjt.GetDuradaTot()+(120*c.GetNumSessions())>c.GetHFinal().TempsToPes()*c.GetNumSessions()) throw new Exception("Error d'integritat: Comunicacions + Descansos no hi caben");
			c.SetCxs(cjt.GetSize()/c.GetNumSessions());
			Voras1(cjt.GetSize()%c.GetNumSessions());
			c.SetCxs(0);
		}else if(c.GetCxs()!=0)
		{
			
			if(cjt.GetSize()%c.GetCxs()!=0) throw new Exception("Error d'integritat: No es pot generar horari amb la quantitat de comunicacions i la condicio de Cxs que s'ha ficat");
			else c.SetNumSessions(cjt.GetSize()/c.GetCxs());
			if(cjt.GetDuradaTot()+(120*c.GetNumSessions())>c.GetHFinal().TempsToPes()*c.GetNumSessions()) throw new Exception("Error d'integritat: Comunicacions + Descansos no hi caben");
			Voras1(0);
			c.SetNumSessions(0);
		}else
		{
			Voras2();
		}
	}
	
	
	
	/**
	 * Voras1.
	 * 
	 * @param paco the paco
	 */
	private static void Voras1(int paco) throws Exception{
		Congres c=Congres.GetInstance();
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		ComunicacioPer[] ultCom;
		Sessio s;
		GenerarM();
		boolean b=true;
		Sessio[] Sessions=new Sessio[c.GetNumSessions()];
		ultCom=new ComunicacioPer[c.GetNumSessions()];
		
		for(int i=0;i<c.GetNumSessions();i++){
			//System.out.println();
			Sessions[i]=new Sessio();
			ultCom[i]=new ComunicacioPer();
			ultCom[i].c=cjt.GetGorda();
			Sessions[i].AddAct(cjt.GetGorda(),0);
			
			if(c.GetCxs()!=Sessions[i].GetCas())AsignarDescans(Sessions[i],ultCom[i].c.GetDuracio());
		}
		
		for(int i=0;i<c.GetNumSessions();i++)
		{
			b=true;
			
			for(int j=1;(j<c.GetCxs()) &&b ;j++){
				
				ultCom[i]=TrobarMillor(ultCom[i].c);
				b=Sessions[i].AddAct(ultCom[i].c,ultCom[i].p);
				
				if(c.GetCxs()!=Sessions[i].GetCas()) AsignarDescans(Sessions[i],ultCom[i].c.GetDuracio());
			}
		}
		
		if(paco!=0)
		{
			for(int i=0;i<paco;i++)
			{
				ultCom[i]=TrobarMillor(ultCom[i].c);
				Sessions[i].AddAct(ultCom[i].c,ultCom[i].p);
				
				if(c.GetCxs()!=Sessions[i].GetCas()) AsignarDescans(Sessions[i],ultCom[i].c.GetDuracio());
			}
		}
		for(int i=0;i<c.GetNumSessions();i++){
			s=new Sessio();
			s.Copy(Sessions[i]);
			c.AfegirSessio(s);
		}
		
	}
	
	/**
	 * Voras2.
	 */
	private static void Voras2() throws Exception{
		
		Congres c=Congres.GetInstance();
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		ComunicacioPer ultCom=new ComunicacioPer();
		Sessio s;
		Sessio sAux;
		GenerarM();
		
		boolean seguimos;
		
		while(!cjt.IsEmpty()){
			
			s=new Sessio();
			seguimos=true;
			ultCom.c=cjt.GetGorda();
			
			if(!s.AddAct(ultCom.c,0)){
				s.SetPes(ultCom.c.GetDuracio());
				s.AddAct(ultCom.c,0);
				seguimos=false;
			}
			else AsignarDescans(s,ultCom.c.GetDuracio());
			
			while(seguimos&&!cjt.IsEmpty()){
				ultCom=TrobarMillor(ultCom.c);
				if(ultCom!=null){
					seguimos=s.AddAct(ultCom.c,ultCom.p);
					
					if(seguimos && c.GetCxs()!=s.GetCas())AsignarDescans(s,ultCom.c.GetDuracio());
				}else{
					seguimos=false;
				}
			}
			sAux=new Sessio();
			sAux.Copy(s);
			c.AfegirSessio(sAux);
		}
	}
	
	/**
	 * Asignar descans.
	 * 
	 * @param d the d
	 * @param s the s
	 * 
	 * @return the inclou descans
	 */
	private static InclouDescans AsignarDescans (Sessio s, int d)
	{
		Descans de;
		Temps t=new Temps(13,0);
		
		if(!descansDinar && (s.GetLastCom().GetHInici().TempsToPes()+s.GetLastCom().GetDuracio())> t.TempsToPes())
		{
			de=new Descans("Descans per Dinar", 120);
			descansDinar=true;
		}
		else
		{
			if(d>60)
			{
				de=new Descans("Coffee Break",30);
			}
			
			else if (d>30)
			{
				de=new Descans("Semi Break",20);
			}
			
			else
			{
				de=new Descans("Small Break",10);
			}
		}
		
		InclouDescans ID=new InclouDescans(de);
		if(s.AddAct(ID,0)==true) return ID;
		else return null;
	}
	
	/**
	 * Generar M.
	 */
	private static void GenerarM()
	{
		
		CjtComunicacions c = CjtComunicacions.GetInstance();
		int N = c.GetSize();
		matriu=new int[N][N];
		GenerarVector();
		for(int i=0; i<N; i++)
		{
			for(int j=i; j<N; j++)
			{
				
				matriu[i][j]=matriu[j][i] = Calcular(vector[i],vector[j]);
			}
		}
	}
	
	/**
	 * Trobar millor.
	 * 
	 * @param in the in
	 * 
	 * @return the comunicacio per
	 */
	private static ComunicacioPer TrobarMillor(Comunicacio in){
		ComunicacioPer aux=new ComunicacioPer();
		aux.p=0;
		int f=-1;
		int pos=TrobarPosicio(in);
		for(int i=0;i<vector.length;i++){
			if(!vector[i].Assignat()&&vector[i]!=in)
			{
				if(f==-1){
					f=i;
					aux.p=matriu[pos][f];
					aux.c=vector[i];
					
					if(vector[f].GetGrau(in)==2)aux.p+=101;
					if(vector[f].GetGrau(in)==0)aux.p-=101;
					
					
				}else if(vector[i].GetGrau(in)>vector[f].GetGrau(in)){
					f=i;
					aux.p=matriu[pos][f];
					aux.c=vector[i];
					
					if(vector[f].GetGrau(in)==2)aux.p+=101;
					if(vector[f].GetGrau(in)==0)aux.p-=101;
					
				}else if(vector[i].GetGrau(in)==vector[f].GetGrau(in)){
					if(matriu[pos][i]>matriu[pos][f]){
						f=i;
						aux.p=matriu[pos][f];
						aux.c=vector[i];
						
						if(vector[f].GetGrau(in)==2)aux.p+=101;
						if(vector[f].GetGrau(in)==0)aux.p-=101;
						
					}
				}
			}
		}
		if(f==-1) return null;
		return aux;
	}
	
	/**
	 * Trobar posicio.
	 * 
	 * @param c the c
	 * 
	 * @return the int
	 */
	private static int TrobarPosicio(Comunicacio c)
	{
		//Es pot optimitzar...
		for(int k=0;k<vector.length;k++){
			if(vector[k]==c){
				return k;
			}
		}
		return -1;
	}
	
	/**
	 * Generar vector.
	 */
	private static void GenerarVector()
	{
		int size;
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		size=cjt.GetSize();
		vector=new Comunicacio[size];
		
		for(int i=0;i<size;i++)
		{
			vector[i]=cjt.GetCom(i);
		}
	}
	
	/**
	 * Calcular.
	 * 
	 * @param i the i
	 * @param j the j
	 * 
	 * @return the int
	 */
	private static int Calcular(Comunicacio i, Comunicacio j )
	{
		int cont=0;
		if((i==j)||i==null||j==null)
		{
			cont=-1;
		}
		else
		{
			if(i.GetNumTemes()<j.GetNumTemes())
			{
				//Ens fixem en i
				for(int k=0;k<i.GetNumTemes();k++){
					if(j.ConteTema(i.GetTema(k))) cont++;
				}
				cont=(cont*100)/i.GetNumTemes();
			}else{
				//Ens fixem en j
				for(int k=0;k<j.GetNumTemes();k++){
					if(i.ConteTema(j.GetTema(k))) cont++;
				}
				cont=(cont*100)/j.GetNumTemes();
			}
		}
		return cont;
	}
	
	/**
	 * Estimar2.
	 * 
	 * @param s the s
	 * 
	 * @return true, if estimar2
	 */
	private static boolean Estimar2(List<Sessio> s)
	{
		int sum=0;
		int sumCongres=0;
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		Congres c=Congres.GetInstance();
		Sessio[] sC=c.GetSesAr();
		
		for(int i=0; i<s.size();i++) sum+=s.get(i).GetPerc();
		
		sum+=100*(cjt.GetSize()-cjt.GetcomAssig());
		sum+=101*relacions;
		for(int i=0;i<sC.length;i++)
		{
			sumCongres+=sC[i].GetPerc();
		}
		
		return sum>sumCongres;
	}
	
	/**
	 * Tai loviu.
	 * 
	 * @param s the s
	 * 
	 * @throws Exception the exception
	 */
	private static void TaiLoviu(List<Sessio> s) throws Exception
	{
		Sessio[] se=new Sessio[s.size()];
		for(int i=0; i<s.size();i++) se[i]=s.get(i);
		TaiLoviu(se);
	}
	
	/**
	 * Estimar2.
	 * 
	 * @param s the s
	 * 
	 * @return true, if estimar2
	 */
	private static boolean Estimar2(Sessio[] s)
	{
		CjtComunicacions cjt=CjtComunicacions.GetInstance();
		Congres c=Congres.GetInstance();
		Sessio[] sC=c.GetSesAr();
		int sumauxSessions=0;
		int sumCongres=0;
		int num=cjt.GetSize();
		num-=cjt.GetcomAssig();
		for(int i=0;i<s.length;i++)
		{
			sumauxSessions+=s[i].GetPerc();
			
			if(s[i].GetCas()==0){
				num-=c.GetCxs();
				sumauxSessions+=100*(c.GetCxs()-1);
			}else{
				num-=c.GetCxs()-s[i].GetCas();
				sumauxSessions+=100*(c.GetCxs()-s[i].GetCas());
			}
		}
		
		sumauxSessions+=101*(relacions);
		
		for(int i=0;i<sC.length;i++)
		{
			sumCongres+=sC[i].GetPerc();
		}
		return sumauxSessions>sumCongres;
	}
	
	/**
	 * Tai loviu.
	 * 
	 * @param s the s
	 * 
	 * @throws Exception the exception
	 */
	private static void TaiLoviu(Sessio s[])throws Exception
	{
		int sumProp=0;
		int sumCongres=0;
		Congres c=Congres.GetInstance();
		Sessio[] ses=c.GetSesAr();
		
		for(int i=0;i<s.length;i++){
			sumProp+=s[i].GetPerc();
		}
		
		for(int i=0;i<ses.length;i++){
			sumCongres+=ses[i].GetPerc();
		}
		
		if(sumProp>sumCongres){
			c.Copy(s);
		}
		
	}
}
