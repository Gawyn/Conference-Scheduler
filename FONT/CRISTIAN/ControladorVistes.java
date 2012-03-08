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
 */
//Implementat per Cristian Planas
package capa1;
import capa2.*;

import java.util.*;

public class ControladorVistes {
	
	ControladorDomini control = new ControladorDomini();
	
	public void VLista(String s, Comunicacio com){
		VLista l = new VLista(s);
		l.setCom(com);
		l.setVisible(true);
	}
	
	public void VGenCongres1 (String s){
		VGenCongres1 g = new VGenCongres1(s);
		g.setVisible(true);
	}
	
	public void VMissatge (String s){
		VMissatge m = new VMissatge(s);
		m.setVisible(true);
	}
	
	public void VCrearAutor (String s, Comunicacio com){
		VCrearAutor c = new VCrearAutor(s);
		c.setcom(com);
		c.setVisible(true);
	}
	
	public void VTemes (String s, Comunicacio com){
		VTemes t = new VTemes(s,com);
		t.setVisible(true);
	}
	
	public void CarCong (String s){
		CarCong c = new CarCong(s);
		c.setVisible(true);
	}
	
	public void VCrearCom (String s){
		VCrearCom c = new VCrearCom(s);
		c.setVisible(true);
	}
	
	public void VCrearTema (String s, Comunicacio com){
		VCrearTema c = new VCrearTema(s, com);
		c.setVisible(true);
	}
	
	public void VRelcom (String s){
		VRelcom r = new VRelcom(s);
		r.setVisible(true);
	}
	
	public void guardarcjt(String file){
		control.guardarcjt(file);
	}
	
	public void carregarcjt (String file){
		control.carregarcjt(file);
	}
	
	public void IniCong(){
		control.IniCong();
	}
	
	public void IniCjt(){
		control.IniCjt();
	}
	
	public Vector<Activitat> CarregarHorariXML(String s){
		return control.CarregarHorariXML(s);
	}
	
	public Temps CrTemps(int a, int b){
		return control.CrTemps(a,b);
	}
	
	public int NumComCong(){
		return control.NumComCong();
	}
	
	public String[] Plenacong(int x){
		return control.Plenacong(x);
	}
	
	public void setsessions(int a){
		control.setsessions(a);
	}
	
	public int quantes(){
		return control.quantes();
	}
	
	public void guardarhorarixml(String file){
		control.guardarhorarixml(file);
	}
	
	public Autor CrAutor(String a, String b){
		return control.CrAutor(a, b);
	}
	
	public void setautor(Autor a, Comunicacio com){
		control.setautor(a, com);
	}
	
	public Comunicacio CrComunicacio (String a, int b){
		return control.CrComunicacio(a, b);
	}
	
	public Tema CrTema(String n){
		return control.CrTema(n);
	}
	
	public void AfegirTemaaCom(Comunicacio c, Tema t){
		control.AfegirTemaaCom(c, t);
	}
	
	public void Afegircom(Comunicacio c){
		control.Afegircom(c);
	}
	
	public void GenCongres(Temps a, Temps b, int c, int d, int e){
		control.GenCongres(a, b, c, d, e);
	}
	
	public List<Tema> LlistaTemes(){
		return control.LlistaTemes();
	}
	
	public List<Comunicacio> LlistaCom(){
		return control.LlistaCom();
	}
	
	public void Eliminarcom(Comunicacio c){
		control.Eliminarcom(c);
	}
	
	public void modautor (Autor a, Comunicacio c){
		control.modautor(a, c);
	}
	
	public void setAutor (Comunicacio c, Autor a){
		control.setAutor(c, a);
	}
	
	public Vector <Activitat> Getacts(){
		return control.Getacts();
	}

	public int getgrau(Comunicacio a, Comunicacio b){
		return control.getgrau(a, b);
	}
	
	public void CanviarActivitats(Activitat a, Activitat b){
		control.CanviarActivitats(a, b);
	}
	
	public void SetGrau(Comunicacio a, Comunicacio b, int x){
		control.SetGrau(a, b, x);
	}
	
	public List<Tema> TemesdeCom(Comunicacio c){
		return control.TemesdeCom(c);
	}
	
	public void CjtClean(){
		control.CjtClean();
	}
	
	public int NumSes(){
		return control.NumSes();
	}
}
