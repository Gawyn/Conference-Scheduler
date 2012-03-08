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
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class VCrearCom.
 */
public class VCrearCom extends JFrame {

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

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */

	public VCrearCom(String title) {
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setLocation(300, 300);
		this.setTitle(title);
		this.setBounds(250, 200, 552, 321);
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(160, 42, 234, 27));
		jLabel2.setText("Introdueixi les dades de la comunicació");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(136, 149, 126, 21));
		jLabel1.setText("Duració (en minuts)");
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

	/**
	 * J Text Field per al nom de la comunicacio
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
	 * J Text field per a la duració
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
					try {
						String nom = jTextField.getText();
						int duracio = Integer.valueOf(jTextField2.getText())
								.intValue();
						Comunicacio com = cv.CrComunicacio(nom, duracio);
						cv.VCrearAutor(gettitle(), com);
						cierrate();
					} catch (Exception exc) {
						cv.VMissatge("Duració incorrecta");
					}

				}
			});

		}
		return Aceptar;
	}

	/**
	 * Retorna el titol del frame
	 */

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
	 * Funcio per a tancar la finestra.
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

} // @jve:decl-index=0:visual-constraint="8,9"
