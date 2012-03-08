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

import javax.swing.JFrame;
import java.util.*;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;

import capa2.*;

// TODO: Auto-generated Javadoc

/**
 * The Class VEliminarCom.
 */
public class VTemes extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Comunicacio com;

	/** The j list. */
	private JList jList = null;

	/** The j label. */
	private JLabel jLabel = null;

	/** The j scroll pane. */
	private JScrollPane jScrollPane = null;

	/** El boto de Controlador de Domini */
	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */
	public VTemes(String title, Comunicacio c) {
		com = c;
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setTitle(title);
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(280, 27, 159, 25));
		jLabel.setText("Llista de temes");
		this.setLayout(null);
		this.setBounds(150, 100, 800, 500);
		this.add(jLabel, null);
		this.add(getJScrollPane(), null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * Gets the J scroll pane.
	 * 
	 * @return the J scroll pane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane(getJList());
			jScrollPane.setBounds(new Rectangle(175, 80, 350, 220));
		}
		return jScrollPane;
	}

	/**
	 * Gets the J list.
	 * 
	 * @return the J list
	 */
	private JList getJList() {
		if (jList == null) {
			DefaultListModel bogart = new DefaultListModel();
			jList = new JList(bogart);
			jList.setBounds(new Rectangle(200, 92, 300, 150));

			List<Tema> temes = cv.TemesdeCom(com);
			int N = temes.size();
			int i = 0;
			while (i < N) {
				bogart.addElement(temes.get(i));
				i++;
			}
		}

		return jList;
	}

	public void cierrate() {
		this.dispose();
	}

	/**
	 * Window closing.
	 * 
	 * @param e
	 *            the e
	 */
	public void windowClosing(WindowEvent e) {
		cierrate();
	}

	/** Retorna el titol del frame */
	public String gettitle() {
		return this.getTitle();
	}
}
