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

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class VCrearTema.
 */
public class VCrearTema extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The j label. */
	private JLabel jLabel = null;

	/** The j label1. */
	private JLabel jLabel1 = null;

	/** The j text field. */
	private JTextField jTextField = null;

	/** The Aceptar. */
	private JButton Aceptar = null;

	/** The Cancelar. */
	private JButton Cancelar = null;

	/** La Comunicacio */
	private Comunicacio com = null;

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */
	public VCrearTema(String title, Comunicacio c) {
		com = c;
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setTitle(title);
		jLabel1 = new JLabel();
		jLabel1.setText("Nom");
		jLabel1.setBounds(new Rectangle(135, 116, 36, 21));
		jLabel = new JLabel();
		jLabel.setText("Introdueixi el nom del tema");
		jLabel.setBounds(new Rectangle(201, 43, 174, 16));
		this.setLayout(null);
		this.setSize(568, 290);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(getJTextField(), null);
		this.add(getAceptar(), null);
		this.add(getCancelar(), null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * J TextField per al nom
	 * 
	 * @return the J text field
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(312, 117, 124, 21));
		}
		return jTextField;
	}

	/**
	 * Gets the aceptar.
	 * 
	 * @return the aceptar
	 */
	private JButton getAceptar() {
		if (Aceptar == null) {
			Aceptar = new JButton();
			Aceptar.setBounds(new Rectangle(101, 176, 93, 33));
			Aceptar.setText("Aceptar");
			Aceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String n = jTextField.getText();
					Tema t = cv.CrTema(n);
					if (gettitle() == "Crear comunicació"
							|| gettitle() == "Crear comunicació ") {
						cv.AfegirTemaaCom(com, t);
						cv.Afegircom(com);
					} else {
						cv.AfegirTemaaCom(com, t);
					}
					cierrate();
				}
			});
		}
		return Aceptar;
	}

	/** Retorna el nom del tema */

	public String gettitle() {
		return this.getTitle();
	}

	/**
	 * Gets the cancelar.
	 * 
	 * @return the cancelar
	 */
	private JButton getCancelar() {
		if (Cancelar == null) {
			Cancelar = new JButton();
			Cancelar.setBounds(new Rectangle(368, 174, 91, 33));
			Cancelar.setText("Cancelar");
			Cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierrate();
				}
			});
		}
		return Cancelar;
	}

	/**
	 * Funcio per a tancar
	 */
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

} // @jve:decl-index=0:visual-constraint="10,10"
