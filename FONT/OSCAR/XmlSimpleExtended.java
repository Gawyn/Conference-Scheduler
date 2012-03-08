package capa3;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlSimpleExtended extends XmlSimple
{
	
	public XmlSimpleExtended() 
	{
		super();
	}

	public XmlSimpleExtended(Document ndoc, Element nelem) {
		super(ndoc,nelem);
	}

	public XmlSimpleExtended(XmlSimpleExtended s)
	{
		super(s);
	}
	
	public String GetNomLocal()
	{
		return getM_elem().getLocalName(); 
	}

}
