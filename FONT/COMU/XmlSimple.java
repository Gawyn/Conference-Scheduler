package capa3;


// Implementada per CLUSTER

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlSimple
{
	private Element m_elem;
	private Document m_doc;
	private String m_tag;

	public XmlSimple() {}

	public XmlSimple(Document ndoc, Element nelem) {
		m_elem=nelem;
		m_doc =ndoc;
		m_tag ="";
	}

	public XmlSimple(XmlSimple s)
	{
		m_elem = s.m_elem;
		m_doc = s.m_doc;
	}

	public int getLength() {
		NodeList m = m_elem.getElementsByTagName(m_tag);
		return m.getLength();
	}

	public XmlSimple tria(int i) throws Exception
	{
		NodeList m = m_elem.getElementsByTagName(m_tag);
		if(m.getLength()==0)
			throw new Exception("no hi ha cap fill amb tag: "+m_tag);
		if(m.getLength()<=i)
			throw new Exception("no hi ha tants elements en el tag: "+m_tag);
		Element nelem = (Element) m.item(i);
		return new XmlSimple(m_doc, nelem);
	}

	public XmlSimple getTag(String tag) throws Exception
	{
		m_tag = tag;
		return this;
	}

	public void obrir(String path) throws IOException, SAXException, ParserConfigurationException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		m_doc = factory.newDocumentBuilder().parse(new File(path));
		m_elem = m_doc.getDocumentElement();
	}

	public String atribut(String nom, String defecte)
	{
		if(m_elem.hasAttribute(nom))
			return m_elem.getAttribute(nom);
		else
			return defecte;
	}

	public String valor() throws Exception
	{
		if(m_elem.getFirstChild().getNodeType()!=3) { //3 = TEXTNODE
			throw new Exception("hola caracola");
		}else {
			Text val = (Text) m_elem.getFirstChild(); 
			return val.getTextContent();
		}
	}
}

