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
 */
//Implementat per Cristian Planas
package capa1;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaMenu.
 */
public class VentanaMenu extends JFrame {

	/** The generar. */
	private MenuItem generar = new MenuItem("Generar congr�s");

	private MenuItem vertem = new MenuItem("Veure temes d'una comunicaci�");

	private static final long serialVersionUID = 1L;

	/** The sortir. */
	private MenuItem sortir = new MenuItem("Sortir");

	private MenuItem generarBT = new MenuItem("Generar congr�s optimitzat");

	/** The crcomunicacio. */
	private MenuItem crcomunicacio = new MenuItem("Crear comunicaci�");

	/** The delcom. */
	private MenuItem delcom = new MenuItem("Eliminar comunicaci�");

	/** The intercom. */
	private MenuItem relcom = new MenuItem("Relacionar comunicacions");

	private MenuItem veurerel = new MenuItem(
			"Veure relaci� entre dues comunicacions");

	/** The canviarautor. */
	private MenuItem canviarautor = new MenuItem(
			"Canviar l'autor d'una comunicaci�");

	/** The relacionartema. */
	private MenuItem relacionartema = new MenuItem(
			"Assignar comunicaci� a un tema");

	/** The guardar. */
	private MenuItem guardar = new MenuItem("Guardar");

	/** The carregarc. */
	private MenuItem carregarc = new MenuItem("Carregar");

	/** The carregarh. */
	private MenuItem carregarh = new MenuItem("Carregar horari");

	/** The sobrenos. */
	private MenuItem sobrenos = new MenuItem("Sobre els autors");

	/** The elimtem. */
	private MenuItem elimtem = new MenuItem("Eliminar tema de comunicaci�");

	/** The ben. */
	private Label ben = new Label("Benvinguts al generador de congressos");

	/** The congres. */
	private Menu congres = new Menu("Arxiu");

	/** The comunicacions. */
	private Menu comunicacions = new Menu("Comunicacions");

	/** The ajuda. */
	private Menu ajuda = new Menu("Ajuda");

	/** The barra. */
	private MenuBar barra = new MenuBar();

	/** The nou. */
	private MenuItem nou = new MenuItem("Nou");

	/** The control */

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */
	public VentanaMenu() {
		/** Crea la barra i hi afegeix els diferents Menus i els MenuItems. */

		setupSucesos();
		this.setBounds(360, 250, 300, 100);
		this.setTitle("Generador de congressos");
		congres.add(nou);
		congres.add(generar);
		congres.add(generarBT);
		congres.add(guardar);
		congres.add(carregarc);
		congres.add(carregarh);
		congres.add(sortir);

		comunicacions.add(crcomunicacio);
		comunicacions.add(relcom);
		comunicacions.add(canviarautor);
		comunicacions.add(relacionartema);
		comunicacions.add(delcom);
		comunicacions.add(veurerel);
		comunicacions.add(vertem);

		ajuda.add(sobrenos);

		barra.add(congres);
		barra.add(comunicacions);
		barra.setHelpMenu(ajuda);

		setMenuBar(barra);

		/** Hi afegeix l'etiqueta. */
		add(ben);
		ben.setSize(200, 200);

		/** La mostra. */
		pack();
		this.setVisible(true);

		/** Introdueix el listener */
		addWindowListener(new VentanamenuWindowListener());

	}

	/**
	 * Setup sucesos.
	 */
	void setupSucesos() {

		/** Crea tots els oients. */

		generar.addActionListener(new OyenteMen�());
		sortir.addActionListener(new OyenteMen�());

		nou.addActionListener(new OyenteMen�());
		generarBT.addActionListener(new OyenteMen�());
		crcomunicacio.addActionListener(new OyenteMen�());
		relcom.addActionListener(new OyenteMen�());
		canviarautor.addActionListener(new OyenteMen�());
		relacionartema.addActionListener(new OyenteMen�());
		delcom.addActionListener(new OyenteMen�());
		guardar.addActionListener(new OyenteMen�());
		carregarc.addActionListener(new OyenteMen�());
		elimtem.addActionListener(new OyenteMen�());
		veurerel.addActionListener(new OyenteMen�());
		vertem.addActionListener(new OyenteMen�());
		carregarh.addActionListener(new OyenteMen�());

		ajuda.addActionListener(new OyenteMen�());
		sobrenos.addActionListener(new OyenteMen�());

	}

	/**
	 * The main method.
	 * 
	 * @param arg
	 *            the arg
	 */
	public static void main(String[] arg) {

		new VentanaMenu();

	}

	/**
	 * The Class OyenteMen�.
	 */
	class OyenteMen� implements ActionListener {

		/**
		 * Depenent del item que l'usuari escolleixi, es generen unes finestres
		 * o unes altres
		 * 
		 * 
		 * @param e
		 *            the e
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "Generar congr�s") {
				cv.VGenCongres1("Generar congr�s");
			}

			else if (e.getActionCommand() == "Sortir") {
				int a = Dialegs.dialeg3("Sortir",
						"�Desitja guardar abans de sortir?", "S�", "No",
						"Cancelar");
				if (a == 0) {
					String file = Dialegs.guardar();
					if (file != null) {
						boolean r = Dialegs.si_no("�Segur que vol guardar a "
								+ file + " ?", "Confirmaci� de guardar");
						if (r == true) {
							cv.guardarcjt(file);
						}
					}
					System.exit(0);
				} else if (a == 1) {
					System.exit(0);
				}
			}

			else if (e.getActionCommand() == "Crear comunicaci�") {
				cv.VCrearCom("Crear comunicaci�");
			}

			else if (e.getActionCommand() == "Canviar l'autor d'una comunicaci�") {
				cv.VLista("Canviar l'autor d'una comunicaci�", null);
			}

			else if (e.getActionCommand() == "Generar congr�s optimitzat") {
				cv.VGenCongres1("Generar congr�s optimitzat");
			}

			else if (e.getActionCommand() == "Relacionar comunicacions") {
				cv.VRelcom("Relacionar comunicacions");
			}

			else if (e.getActionCommand() == "Sobre els autors") {

				cv.VMissatge("Sobre els autors");

			}

			else if (e.getActionCommand() == "Assignar comunicaci� a un tema") {
				cv.VLista("Assignar comunicaci� a un tema", null);
			}

			else if (e.getActionCommand() == "Eliminar comunicaci�") {
				cv.VLista("Eliminar comunicaci�", null);
			}

			else if (e.getActionCommand() == "Guardar") {
				String file = Dialegs.guardar();
				if (file != null) {
					boolean r = Dialegs.si_no("�Segur que vol guardar a "
							+ file + " ?", "Confirmaci� de guardar");
					if (r == true) {
						cv.guardarcjt(file);
					}
				}
			}

			else if (e.getActionCommand() == "Veure relaci� entre dues comunicacions") {
				cv.VRelcom("Veure relaci� entre dues comunicacions");
			}

			else if (e.getActionCommand() == "Carregar") {
				String file = Dialegs.obrir();
				if (file != null) {
					boolean r = Dialegs.si_no("�Segur que vol carregar a "
							+ file + " ?", "Confirmaci� de guardar");
					if (r == true) {
						cv.carregarcjt(file);
					}
				}
			} else if (e.getActionCommand() == "Veure temes d'una comunicaci�") {
				cv.VLista("Veure temes d'una comunicaci�", null);
			}

			else if (e.getActionCommand() == "Carregar horari") {
				cv.IniCong();
				String file = Dialegs.obrir();
				if (file != null) {
					boolean r = Dialegs.si_no("�Segur que vol carregar " + file
							+ " ?", "Confirmaci� de carregar");
					if (r == true) {
						CarCong as = new CarCong(file);
						as.setVisible(true);

					}
				}
			}

			else if (e.getActionCommand() == "Nou") {
				cv.IniCong();
				cv.IniCjt();
			}

		}

	}

	/**
	 * The Class Ventanamen�WindowListener.
	 */
	class VentanamenuWindowListener implements WindowListener {

		/**
		 * Window activated.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowActivated(WindowEvent e) {

		}

		/**
		 * Window closed.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowClosed(WindowEvent e) {

		}

		/**
		 * Window closing.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowClosing(WindowEvent e) {
			boolean a = Dialegs.si_no("�Desitja guardar abans de sortir?",
					"Sortir");
			if (a == true) {
				String file = Dialegs.guardar();
				if (file != null) {
					boolean r = Dialegs.si_no("�Segur que vol guardar a "
							+ file + " ?", "Confirmaci� de guardar");
					if (r == true) {
						cv.guardarcjt(file);
					}
				}
			}
			System.exit(0);
		}

		/**
		 * Window deactivated.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowDeactivated(WindowEvent e) {

		}

		/**
		 * Window deiconified.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowDeiconified(WindowEvent e) {

		}

		/**
		 * Window iconified.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowIconified(WindowEvent e) {

		}

		/**
		 * Window opened.
		 * 
		 * @param e
		 *            the e
		 */
		public void windowOpened(WindowEvent e) {

		}

	}
}
