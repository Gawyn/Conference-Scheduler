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

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import java.awt.event.WindowEvent;
import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class VSobreNosaltres.
 */
public class VMissatge extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The j content pane. */
	private JPanel jContentPane = null;

	/** The j label. */
	private JLabel jLabel = null;

	/** The j label1. */
	private JLabel jLabel1 = null;

	/** The j label2. */
	private JLabel jLabel2 = null;

	/** The j label3. */
	private JLabel jLabel3 = null;

	/** The j button. */
	private JButton jButton = null;

	/**
	 * The Constructor.
	 */
	public VMissatge(String s) {
		initialize(s);
	}

	/**
	 * Initialize.
	 */
	private void initialize(String s) {
		this.setBounds(320, 250, 450, 266);
		this.setTitle(s);
		this.setContentPane(getJContentPane(s));
	}

	/**
	 * Gets the J content pane.
	 * 
	 * @return the J content pane
	 */
	private JPanel getJContentPane(String s) {
		if (jContentPane == null) {
			if (this.getTitle() == "Sobre els autors") {
				jLabel = new JLabel();
				jLabel
						.setText("Cristian Planas Gonz�lez - e6982991@est.fib.upc.edu");
				jLabel.setBounds(new Rectangle(30, 20, 350, 23));
				jLabel3 = new JLabel();
				jLabel3.setBounds(new Rectangle(30, 110, 300, 23));
				jLabel3
						.setText("Oscar Camacho Patilla -  d8836230@est.fib.upc.edu");
				jLabel2 = new JLabel();
				jLabel2.setBounds(new Rectangle(30, 80, 300, 23));
				jLabel2.setText("Rosina Garcia Bru - d9386227@est.fib.upc.edu");
				jLabel1 = new JLabel();
				jLabel1.setBounds(new Rectangle(30, 50, 300, 23));
				jLabel1
						.setText("Clemente Tort Barbero - e6945429@est.fib.upc.edu");
				jContentPane = new JPanel();
				jContentPane.setLayout(null);
				jContentPane.add(jLabel, null);
				jContentPane.add(jLabel1, null);
				jContentPane.add(jLabel2, null);
				jContentPane.add(jLabel3, null);
				jContentPane.add(getJButton(), null);
			} else {
				this.setTitle("Missatge");
				jLabel = new JLabel(s, JLabel.CENTER);
				jLabel.setBounds(new Rectangle(30, 20, 350, 23));
				this.setSize(400, 80);
				jContentPane = new JPanel();
				jContentPane.setLayout(null);
				jContentPane.add(jLabel, null);
				jContentPane.add(getJButton(), null);
			}
		}
		return jContentPane;
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

	/**
	 * El boto d'acceptar
	 * 
	 * @return the J button
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Aceptar");
			jButton.setBounds(new Rectangle(174, 171, 107, 28));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					cierrate();
				}
			});
		}
		return jButton;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
