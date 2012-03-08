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
import javax.swing.JButton;
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
public class VLista extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private Comunicacio com;

	/** The j list. */
	private JList jList = null;

	/** The j label. */
	private JLabel jLabel = null;

	/** The Aceptar. */
	private JButton Aceptar = null;

	/** The Cancelar. */
	private JButton Cancelar = null;

	/** El boto de crear autor */
	private JButton CrAutor = null;

	/** El boto de crear tema */
	private JButton CrTema = null;

	/** The j scroll pane. */
	private JScrollPane jScrollPane = null;

	private ControladorVistes cv = new ControladorVistes();

	/**
	 * The Constructor.
	 */
	public VLista(String title) {
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setTitle(title);
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(280, 27, 159, 25));
		if (title == "Assignar comunicació a un tema "
				|| title == "Crear comunicació ") {
			jLabel.setText("Seleccioni tema");
			this.add(GetCrTema(), null);
		} else if (title == "Canviar l'autor d'una comunicació "
				|| title == "Crear comunicació") {
			jLabel.setText("Seleccioni l'autor");
			this.add(GetCrAutor(), null);
		} else if (title == "Veure temes d'una comunicació ") {
			jLabel.setText("Llista de temes");
		} else {
			jLabel.setText("Seleccioni la comunicació");
		}
		this.setLayout(null);
		this.setBounds(150, 100, 800, 500);
		this.add(jLabel, null);
		this.add(getJScrollPane(), null);
		this.add(getAceptar(), null);
		this.add(getCancelar(), null);
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
			if (gettitle() == "Assignar comunicació a un tema "
					|| gettitle() == "Crear comunicació ") {
				List<Tema> temes = cv.LlistaTemes();
				int N = temes.size();
				int i = 0;
				while (i < N) {
					bogart.addElement(temes.get(i));
					i++;
				}
			} else {
				List<Comunicacio> coms = cv.LlistaCom();
				int N = coms.size();
				int i = 0;
				while (i < N) {
					bogart.addElement(coms.get(i));
					i++;
				}
			}
		}
		return jList;
	}

	/**
	 * Gets the aceptar.
	 * 
	 * @return the aceptar
	 */
	private JButton getAceptar() {
		if (Aceptar == null) {
			Aceptar = new JButton();
			Aceptar.setBounds(new Rectangle(166, 350, 100, 33));
			Aceptar.setText("Aceptar");
			Aceptar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {

					if (gettitle() == "Assignar comunicació a un tema ") {
						Tema t = (Tema) jList.getSelectedValue();
						if (t == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.AfegirTemaaCom(com, t);
							cierrate();
						}
					} else if (gettitle() == "Crear comunicació ") {
						Tema t = (Tema) jList.getSelectedValue();
						if (t == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.AfegirTemaaCom(com, t);
							cv.Afegircom(com);
						}
						cierrate();
					} else if (gettitle() == "Eliminar comunicació") {
						Comunicacio u = (Comunicacio) jList.getSelectedValue();
						if (u == null) {
							cv.VMissatge("No ha seleccionat cap comunicació");
						} else {
							cv.Eliminarcom(u);
							cierrate();
						}
					} else if (gettitle() == "Canviar l'autor d'una comunicació") {
						Comunicacio u = (Comunicacio) jList.getSelectedValue();
						if (u == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.VCrearAutor(
									"Canviar l'autor d'una comunicació ", u);
							cierrate();
						}
					} else if (gettitle() == "Assignar comunicació a un tema") {
						Comunicacio u = (Comunicacio) jList.getSelectedValue();
						if (u == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.VLista("Assignar comunicació a un tema ", u);
							cierrate();
						}
					} else if (gettitle() == "Canviar l'autor d'una comunicació ") {
						Autor aut = (Autor) jList.getSelectedValue();
						if (aut == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.modautor(aut, com);
							cierrate();
						}

					}

					else if (gettitle() == "Crear comunicació") {

						Autor paco = (Autor) jList.getSelectedValue();
						if (paco == null) {
							cv.VMissatge("No ha seleccionat cap tema");
						} else {
							cv.setAutor(com, paco);
							cv.VLista("Crear comunicació ", com);
							cierrate();
						}
					}

					else if (gettitle() == "Veure temes d'una comunicació") {
						Comunicacio u = (Comunicacio) jList.getSelectedValue();
						if (u == null) {
							cv.VMissatge("No ha seleccionat cap comunicació");
						} else {
							cv.VTemes("Veure temes d'una comunicació", u);
						}
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
			Cancelar.setBounds(new Rectangle(433, 350, 100, 33));
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
	 * Cierrate.
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

	/** Retorna el titol del frame */
	public String gettitle() {
		return this.getTitle();
	}

	/** Retorna el boto de crear autor */
	private JButton GetCrAutor() {
		if (CrAutor == null) {
			CrAutor = new JButton();
			CrAutor.setBounds(new Rectangle(600, 150, 150, 33));
			CrAutor.setText("Crear un nou autor");
			CrAutor.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cv.VCrearAutor(gettitle(), com);
					cierrate();
				}
			});
		}
		return CrAutor;
	}

	/** Retorna el boto de crear tema */
	private JButton GetCrTema() {
		if (CrTema == null) {
			CrTema = new JButton();
			CrTema.setBounds(new Rectangle(600, 150, 150, 33));
			CrTema.setText("Crear un nou tema");
			CrTema.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cv.VCrearTema(gettitle(), com);
					cierrate();
				}
			});
		}
		return CrTema;
	}

	/** Fixa la comunicacio c com a comunicacio de la classe */
	public void setCom(Comunicacio c) {
		try {
			com = new Comunicacio("", 0);
			com = c;
		} catch (Exception e) {

		}
	}

} // @jve:decl-index=0:visual-constraint="10,10"
