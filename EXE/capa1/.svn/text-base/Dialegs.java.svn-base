//Grup 6.3
//Autor: Marti Cairo Font

package capa1;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Dialegs {
	
	public static String obrir(){
		String path = null;
		File arxiu;
		JFileChooser fc = new JFileChooser();
		int resultat;
		resultat = fc.showOpenDialog(null);
		if (resultat == JFileChooser.APPROVE_OPTION)
		{
			arxiu = fc.getSelectedFile();
			path = arxiu.getAbsolutePath();
		}
		return path;
	}
	
	public static String guardar(){
		String path = null;
		File arxiu;
		JFileChooser fc = new JFileChooser();
		int resultat;
		resultat = fc.showSaveDialog(null);
		if (resultat == JFileChooser.APPROVE_OPTION)
		{
			arxiu = fc.getSelectedFile();
			path = arxiu.getAbsolutePath();
		}
		return path;
	}
	
	public static boolean si_no(String missatge, String titol) {
		int n = 0;
		boolean res;
		n = JOptionPane.showConfirmDialog( null, missatge, titol, JOptionPane.YES_NO_OPTION);
		if (n==0)
			res = true;
		else
			res = false;
		return res;
	}

	public static int dialeg3(String titol, String missatge, String b1, String b2, String b3){
		Object[] options = {b1, b2, b3};
		int n = 0;
		n= JOptionPane.showOptionDialog(null,missatge,titol, JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		return n;
	}
}	