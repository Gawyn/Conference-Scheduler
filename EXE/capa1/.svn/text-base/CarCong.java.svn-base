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

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.Rectangle;
import java.util.*;

import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import capa2.*;

// TODO: Auto-generated Javadoc
/**
 * The Class CarCong.
 */
public class CarCong extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** El j scroll pane. */
	private JScrollPane jScrollPane = null;

	/** La j table en la que estará el congreso. */
	private JTable jTable = null;

	/** El boton de Intercanviar comunicaciones. */
	private JButton jButton1 = null;

	/** El Controlador de Dominio. */
	private ControladorVistes cv = new ControladorVistes();

	private JButton Guardar = null;

	/**
	 * The Constructor.
	 */
	public CarCong(String title) {
		initialize(title);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String title) {
		this.setMaximizedBounds(new Rectangle());
		this.setTitle(title);
		this.setLayout(null);
		this.setSize(1100, 780);
		this.add(getJScrollPane(), null);
		this.add(getGuardar(), null);
		this.add(getIntercanviar(), null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	/**
	 * Devuelve el Jscroll panel
	 * 
	 * @return the J scroll pane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane(getJTable());
			jScrollPane.setBounds(new Rectangle(6, 33, 700, 680));
		}
		return jScrollPane;
	}

	/**
	 * Devuelve el J table.
	 * 
	 * @return the J table
	 */
	private JTable getJTable() {
		if (jTable == null) {
			DefaultTableModel dtm = new DefaultTableModel();
			jTable = new JTable(dtm);
			String[] data = new String[5];
			dtm.addColumn("Nom");
			dtm.addColumn("Autor");
			dtm.addColumn("Hora d'inici");
			dtm.addColumn("Hora de fi");
			dtm.addColumn("Identificador sessió");
			if (gettitle() != "Generar congrès" && gettitle() != "Generar congrès optimitzat") {
				Vector<Activitat> activitats = cv.CarregarHorariXML(gettitle());
				int M = activitats.size();
				int l = 0;
				while (l < M) {
					Activitat asf = activitats.get(l);
					int p = asf.GetInici().TempsToPes() + asf.GetDuracio();
					int te = p / 60;
					int te2 = p % 60;
					Temps hora = cv.CrTemps(te, te2);
					if (asf.GetTipus() == 2) {
						Comunicacio d = (Comunicacio) asf;
						String a1 = d.GetNom();
						String a2 = d.GetAutor().toString();
						String a3 = d.GetInici().ToString();
						String a4 = hora.ToString();
						String a5 = Integer.toString(asf.GetSessio().GetId());
						data[0] = a1;
						data[1] = a2;
						data[2] = a3;
						data[3] = a4;
						data[4] = a5;
					} else {
						InclouDescans me = (InclouDescans) activitats.get(l);
						String a1 = me.GetNom();
						String a2 = "";
						String a3 = me.GetInici().ToString();
						String a4 = hora.ToString();
						String a5 = Integer.toString(me.GetSessio().GetId());
						data[0] = a1;
						data[1] = a2;
						data[2] = a3;
						data[3] = a4;
						data[4] = a5;

					}
					dtm.addRow(data);
					l++;
				}

			} else {
				int N = cv.NumComCong();
				int i = 0;
				while (i < N) {
					data = cv.Plenacong(i);
					dtm.addRow(data);
					i++;
				}
				cv.setsessions(cv.quantes());
			}
			jTable.setBounds(new Rectangle(6, 33, 700, 680));
		}
		return jTable;
	}

	/**
	 * Funcion para cerrar la ventana
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

	public String gettitle() {
		return this.getTitle();
	}

	private JButton getGuardar() {
		if (Guardar == null) {
			Guardar = new JButton();
			Guardar.setText("Guardar a XML");
			Guardar.setBounds(new Rectangle(760, 200, 300, 33));
			Guardar.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String file2 = Dialegs.guardar();
					if (file2 != null) {
						boolean b = Dialegs.si_no("¿Segur que vol guardar a "
								+ file2 + " ?", "Confirmació de guardar");
						if (b == true) {
							cv.guardarhorarixml(file2);
						}
					} else {
						cv.VMissatge("No hi ha seleccionat cap fitxer");
					}
				}
			});
		}
		return Guardar;
	}

	private JButton getIntercanviar() {
		if (jButton1 == null) {
			jButton1 = new JButton();
			jButton1.setText("Intercanviar comunicacions");
			jButton1.setBounds(new Rectangle(760, 300, 300, 33));
			jButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (gettitle() != "Generar congrès"
							&& gettitle() != "Generar congrès optimitzat") {
						cv.VMissatge("Impossible intercanviar en XML");
					} else {
						cv.VRelcom("Intercanviar comunicacions");
						cierrate();
					}
				}
			});
		}
		return jButton1;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
