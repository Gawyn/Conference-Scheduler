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

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import capa2.*;

import javax.swing.JTextField;

// TODO: Auto-generated Javadoc
/**
 * The Class VGenCongres1.
 */
public class VGenCongres1 extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Aceptar. */
	private JButton Aceptar = null;

	/** The Cancelar. */
	private JButton Cancelar = null;

	/** The j label. */
	private JLabel jLabel = null;

	/** The j label1. */
	private JLabel jLabel1 = null;

	/** The j label2. */
	private JLabel jLabel2 = null;

	/** The j label3. */
	private JLabel jLabel3 = null;

	/** The j label4. */
	private JLabel jLabel4 = null;

	/** The j text field. */
	private JTextField jTextField = null;

	/** The j text field1. */
	private JTextField jTextField1 = null;

	/** The j text field2. */
	private JTextField jTextField2 = null;

	/** The j text field3. */
	private JTextField jTextField3 = null;

	/** The j text field4. */
	private JTextField jTextField4 = null;

	/** The j text field5. */
	private JTextField jTextField5 = null;

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */

	public VGenCongres1(String title) {
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setTitle(title);
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(103, 230, 156, 23));
		jLabel3.setText("Comunicacions per sessió");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(103, 280, 156, 23));
		jLabel4.setText("Nombre de sessions");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(103, 180, 156, 23));
		jLabel2.setText("Hora de fi");
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(103, 130, 157, 21));
		jLabel1.setText("Hora d'inici");
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(170, 52, 210, 29));
		jLabel.setText("Introdueixi les dades del congrès");
		this.setLayout(null);
		this.setBounds(290, 100, 500, 500);
		this.add(jLabel, null);
		this.add(jLabel1, null);
		this.add(jLabel2, null);
		this.add(jLabel3, null);
		this.add(jLabel4, null);
		this.add(getJTextField(), null);
		this.add(getJTextField1(), null);
		this.add(getJTextField2(), null);
		this.add(getJTextField3(), null);
		this.add(getJTextField4(), null);
		this.add(getJTextField5(), null);
		this.add(getAceptar(), null);
		this.add(getCancelar(), null);
		ControladorDomini cd = new ControladorDomini();

		jTextField4.setText(cd.congres().GetCxs() + "");
		jTextField5.setText(cd.congres().GetNumSessions() + "");

		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * JTextField per a l'hora d'inici
	 * 
	 * @return the J text field
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setBounds(new Rectangle(343, 130, 48, 20));
		}
		return jTextField;
	}

	/**
	 * JTextField per als minuts d'inici
	 * 
	 * @return the J text field1
	 */
	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setBounds(new Rectangle(420, 130, 48, 20));
		}
		return jTextField1;
	}

	/**
	 * JTextField per a l'hora de final
	 * 
	 * @return the J text field2
	 */
	private JTextField getJTextField2() {
		if (jTextField2 == null) {
			jTextField2 = new JTextField();
			jTextField2.setBounds(new Rectangle(343, 180, 48, 20));
		}
		return jTextField2;
	}

	/**
	 * JTextField per als minuts finals
	 * 
	 * @return the J text field3
	 */
	private JTextField getJTextField3() {
		if (jTextField3 == null) {
			jTextField3 = new JTextField();
			jTextField3.setBounds(new Rectangle(420, 180, 48, 20));
		}
		return jTextField3;
	}

	/**
	 * JTextField per a les comunicacions per sessio
	 * 
	 * @return the J text field4
	 */
	private JTextField getJTextField4() {
		if (jTextField4 == null) {
			jTextField4 = new JTextField();
			jTextField4.setBounds(new Rectangle(343, 230, 48, 20));
		}
		return jTextField4;
	}

	/**
	 * JTextField per al nombre de sessions
	 * 
	 * @return the J text field5
	 */
	private JTextField getJTextField5() {
		if (jTextField5 == null) {
			jTextField5 = new JTextField();
			jTextField5.setBounds(new Rectangle(343, 280, 48, 20));
		}
		return jTextField5;
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
			Aceptar.setBounds(new Rectangle(105, 368, 93, 33));
			Aceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						String a1 = jTextField.getText();
						String a2 = jTextField1.getText();
						String a3 = jTextField2.getText();
						String a4 = jTextField3.getText();
						if (a1.compareTo("") == 0 || a2.compareTo("") == 0
								|| a3.compareTo("") == 0
								|| a4.compareTo("") == 0) {
							cv.VMissatge("Falten les dades horaries");
						} else {
							int a = Integer.valueOf(a1).intValue();
							int b = Integer.valueOf(a2).intValue();
							int h = Integer.valueOf(a3).intValue();
							int d = Integer.valueOf(a4).intValue();
							int g;
							try {
								g = Integer.valueOf(jTextField4.getText())
										.intValue();
							} catch (Exception exxx) {
								g = 0;
							}
							int f;
							try {
								f = Integer.valueOf(jTextField5.getText()).intValue();
							} catch (Exception exc) {
								f = 0;
							}
							Temps t = cv.CrTemps(a, b);
							Temps fi = cv.CrTemps(h, d);
							int ca = 0;
							boolean b1 = true;
							if (gettitle() == "Generar congrès optimitzat") {
								ca = 1;
								b1 = Dialegs
										.si_no(
												"Generar congrès optimitzadament podria tardar molt depenent de la quantitat de comunicacions. ¿N'està segur?",
												"Generar congrès");
							}
							if (b1 == false) {

							} else {
								cv.IniCong();
								cv.CjtClean();
								cv.GenCongres(t, fi, g, f, ca);
								if (cv.NumSes()==0){
									cv.VMissatge("Error en les dades");
								}
								else{
								cv.CarCong(gettitle());
								}

								cierrate();
							}
							// Proves
							// ControladorDomini cd=new ControladorDomini();
							// cd.guardarhorarixml("cristian.xml");
							//
						}
					} catch (Exception ecs) {
						cv.VMissatge("Error al generar el congrès");
					}
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
			Cancelar.setBounds(new Rectangle(321, 368, 91, 33));
			Cancelar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierrate();
				}
			});
		}
		return Cancelar;
	}

	/**
	 * Funcio per tancar
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

	/**
	 * Retorna el titol del frame
	 */

	public String gettitle() {
		return this.getTitle();
	}

} // @jve:decl-index=0:visual-constraint="3,53"
