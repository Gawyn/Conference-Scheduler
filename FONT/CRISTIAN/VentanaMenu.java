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

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

// TODO: Auto-generated Javadoc
/**
 * The Class VentanaMenu.
 */
public class VentanaMenu extends JFrame {

	/** The generar. */
	private MenuItem generar = new MenuItem("Generar congrès");

	private MenuItem vertem = new MenuItem("Veure temes d'una comunicació");

	private static final long serialVersionUID = 1L;

	/** The sortir. */
	private MenuItem sortir = new MenuItem("Sortir");

	private MenuItem generarBT = new MenuItem("Generar congrès optimitzat");

	/** The crcomunicacio. */
	private MenuItem crcomunicacio = new MenuItem("Crear comunicació");

	/** The delcom. */
	private MenuItem delcom = new MenuItem("Eliminar comunicació");

	/** The intercom. */
	private MenuItem relcom = new MenuItem("Relacionar comunicacions");

	private MenuItem veurerel = new MenuItem(
			"Veure relació entre dues comunicacions");

	/** The canviarautor. */
	private MenuItem canviarautor = new MenuItem(
			"Canviar l'autor d'una comunicació");

	/** The relacionartema. */
	private MenuItem relacionartema = new MenuItem(
			"Assignar comunicació a un tema");

	/** The guardar. */
	private MenuItem guardar = new MenuItem("Guardar");

	/** The carregarc. */
	private MenuItem carregarc = new MenuItem("Carregar");

	/** The carregarh. */
	private MenuItem carregarh = new MenuItem("Carregar horari");

	/** The sobrenos. */
	private MenuItem sobrenos = new MenuItem("Sobre els autors");

	/** The elimtem. */
	private MenuItem elimtem = new MenuItem("Eliminar tema de comunicació");

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

		generar.addActionListener(new OyenteMenú());
		sortir.addActionListener(new OyenteMenú());

		nou.addActionListener(new OyenteMenú());
		generarBT.addActionListener(new OyenteMenú());
		crcomunicacio.addActionListener(new OyenteMenú());
		relcom.addActionListener(new OyenteMenú());
		canviarautor.addActionListener(new OyenteMenú());
		relacionartema.addActionListener(new OyenteMenú());
		delcom.addActionListener(new OyenteMenú());
		guardar.addActionListener(new OyenteMenú());
		carregarc.addActionListener(new OyenteMenú());
		elimtem.addActionListener(new OyenteMenú());
		veurerel.addActionListener(new OyenteMenú());
		vertem.addActionListener(new OyenteMenú());
		carregarh.addActionListener(new OyenteMenú());

		ajuda.addActionListener(new OyenteMenú());
		sobrenos.addActionListener(new OyenteMenú());

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
	 * The Class OyenteMenú.
	 */
	class OyenteMenú implements ActionListener {

		/**
		 * Depenent del item que l'usuari escolleixi, es generen unes finestres
		 * o unes altres
		 * 
		 * 
		 * @param e
		 *            the e
		 */
		public void actionPerformed(ActionEvent e) {

			if (e.getActionCommand() == "Generar congrès") {
				cv.VGenCongres1("Generar congrès");
			}

			else if (e.getActionCommand() == "Sortir") {
				int a = Dialegs.dialeg3("Sortir",
						"¿Desitja guardar abans de sortir?", "Sí", "No",
						"Cancelar");
				if (a == 0) {
					String file = Dialegs.guardar();
					if (file != null) {
						boolean r = Dialegs.si_no("¿Segur que vol guardar a "
								+ file + " ?", "Confirmació de guardar");
						if (r == true) {
							cv.guardarcjt(file);
						}
					}
					System.exit(0);
				} else if (a == 1) {
					System.exit(0);
				}
			}

			else if (e.getActionCommand() == "Crear comunicació") {
				cv.VCrearCom("Crear comunicació");
			}

			else if (e.getActionCommand() == "Canviar l'autor d'una comunicació") {
				cv.VLista("Canviar l'autor d'una comunicació", null);
			}

			else if (e.getActionCommand() == "Generar congrès optimitzat") {
				cv.VGenCongres1("Generar congrès optimitzat");
			}

			else if (e.getActionCommand() == "Relacionar comunicacions") {
				cv.VRelcom("Relacionar comunicacions");
			}

			else if (e.getActionCommand() == "Sobre els autors") {

				cv.VMissatge("Sobre els autors");

			}

			else if (e.getActionCommand() == "Assignar comunicació a un tema") {
				cv.VLista("Assignar comunicació a un tema", null);
			}

			else if (e.getActionCommand() == "Eliminar comunicació") {
				cv.VLista("Eliminar comunicació", null);
			}

			else if (e.getActionCommand() == "Guardar") {
				String file = Dialegs.guardar();
				if (file != null) {
					boolean r = Dialegs.si_no("¿Segur que vol guardar a "
							+ file + " ?", "Confirmació de guardar");
					if (r == true) {
						cv.guardarcjt(file);
					}
				}
			}

			else if (e.getActionCommand() == "Veure relació entre dues comunicacions") {
				cv.VRelcom("Veure relació entre dues comunicacions");
			}

			else if (e.getActionCommand() == "Carregar") {
				String file = Dialegs.obrir();
				if (file != null) {
					boolean r = Dialegs.si_no("¿Segur que vol carregar a "
							+ file + " ?", "Confirmació de guardar");
					if (r == true) {
						cv.carregarcjt(file);
					}
				}
			} else if (e.getActionCommand() == "Veure temes d'una comunicació") {
				cv.VLista("Veure temes d'una comunicació", null);
			}

			else if (e.getActionCommand() == "Carregar horari") {
				cv.IniCong();
				String file = Dialegs.obrir();
				if (file != null) {
					boolean r = Dialegs.si_no("¿Segur que vol carregar " + file
							+ " ?", "Confirmació de carregar");
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
	 * The Class VentanamenúWindowListener.
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
			boolean a = Dialegs.si_no("¿Desitja guardar abans de sortir?",
					"Sortir");
			if (a == true) {
				String file = Dialegs.guardar();
				if (file != null) {
					boolean r = Dialegs.si_no("¿Segur que vol guardar a "
							+ file + " ?", "Confirmació de guardar");
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
