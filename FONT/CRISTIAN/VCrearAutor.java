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

import java.awt.Rectangle;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class VCrearAutor.
 */
public class VCrearAutor extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Aceptar. */
	private JButton Aceptar = null;

	/** The Cancelar. */
	private JButton Cancelar = null;

	/** The j text field. */
	private JTextField jTextField = null;

	/** The j text field2. */
	private JTextField jTextField2 = null;

	/** The j label. */
	private JLabel jLabel = null;

	/** The j label1. */
	private JLabel jLabel1 = null;

	/** The j label2. */
	private JLabel jLabel2 = null;

	/** La comunicació */
	private Comunicacio com;

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */

	public VCrearAutor(String title) {
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setTitle(title);
		this.setSize(552, 321);
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(203, 42, 177, 27));
		jLabel2.setText("Introdueixi les dades del autor");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(136, 149, 100, 21));
		jLabel1.setText("Cognoms");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(132, 93, 128, 21));
		jLabel.setText("Nom");
		this.setLayout(null);
		this.add(getAceptar(), null);
		this.add(getCancelar(), null);
		this.add(getJTextField(), null);
		this.add(getJTextField2(), null);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/** Situa la comunicacio n com a comunicacio de la classe. */

	public void setcom(Comunicacio n) {
		com = n;
	}

	/**
	 * J text field per al nom
	 * 
	 * @return the J text field
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(305, 95, 124, 21));
		}
		return jTextField;
	}

	/**
	 * J text field per als cognoms
	 * 
	 * @return the J text field2
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(305, 148, 124, 21));
		}
		return jTextField2;
	}

	/**
	 * Gets the aceptar.
	 * 
	 * @return the aceptar
	 */
	private JButton getAceptar() {
		if (Aceptar == null) {
			Aceptar = new JButton();
			Aceptar.setText("Aceptar");
			Aceptar.setBounds(new Rectangle(105, 201, 93, 33));
			Aceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String a = jTextField.getText();
					String b = jTextField2.getText();
					Autor aut = cv.CrAutor(a, b);
					cv.setAutor(com, aut);
					if (gettitle() != "Canviar l'autor d'una comunicació ") {
						cv.VLista("Crear comunicació ", com);
					}
					cierrate();
				}
			});
		}
		return Aceptar;
	}

	/**
	 * Gets the cancelar.
	 * 
	 * @return the cancelar
	 */
	private JButton getCancelar() {
		if (Cancelar == null) {
			Cancelar = new JButton();
			Cancelar.setText("Cancelar");
			Cancelar.setBounds(new Rectangle(321, 200, 91, 33));
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

	/** Retorna el titol de la classe */

	public String gettitle() {
		return this.getTitle();
	}

} // @jve:decl-index=0:visual-constraint="8,9"
