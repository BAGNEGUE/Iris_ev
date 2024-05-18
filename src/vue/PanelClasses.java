package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.Classe;
import controleur.Controleur;

public class PanelClasses extends PanelPrincipal implements ActionListener
{
	private JPanel panelForm = new JPanel (); 
	private JTextField txtNom = new JTextField(); 
	private JTextField txtSalle = new JTextField(); 
	private JTextField txtDiplome = new JTextField(); 
	private JButton btAnnuler = new JButton("Annuler"); 
	private JButton btEnregistrer = new JButton("Enregistrer");
	
	private JTable tableClasses;//table des classes
	private JScrollPane uneScroll;
	
	//panel de filtrage
	private JPanel panelFiltre = new JPanel();
	private JTextField txtFiltre = new JTextField();
	private JButton btFiltrer = new JButton("Filtrer");
	
	public PanelClasses()
	{
		super ();
		//construction du formulaire Classe. 
		this.panelForm.setLayout(new GridLayout(4,2));
		this.panelForm.setBackground(new Color (225, 198, 22));
		this.panelForm.setBounds(10, 10, 300, 300);
		this.panelForm.add(new JLabel("Nom Classe :")); 
		this.panelForm.add(this.txtNom); 
		this.panelForm.add(new JLabel("Salle Cours :")); 
		this.panelForm.add(this.txtSalle); 
		this.panelForm.add(new JLabel("Diplome :")); 
		this.panelForm.add(this.txtDiplome); 
		this.panelForm.add(this.btAnnuler); 
		this.panelForm.add(this.btEnregistrer); 
		this.panelForm.setVisible(true);
		this.add(this.panelForm);
		
		//construction de la table des classes
		String entetes [] = {"ID Classe","Nom classe", "Salle cours","Diplôme"};
		this.tableClasses = new JTable(this.remplirDonnees(""), entetes) ;
		this.tableClasses.getTableHeader().setReorderingAllowed(false);
		this.uneScroll = new JScrollPane(this.tableClasses);
		this.uneScroll.setBounds(350, 80, 460, 230);
		this.add(this.uneScroll);
		
		//construction le panel Filtre 
		this.panelFiltre.setBounds(400, 30, 400, 30);
		this.panelFiltre.setBackground(new Color (255, 198, 22));
		this.panelFiltre.setLayout(new GridLayout(1, 3));
		this.panelFiltre.add(new JLabel("Filtrer les classes par :"));
		this.panelFiltre.add(this.txtFiltre);
		this.panelFiltre.add(this.btFiltrer);
		this.add(this.panelFiltre);
		//rendre les boutons ecoutables 
		this.btAnnuler.addActionListener(this);
		this.btEnregistrer.addActionListener(this);
		
	}
	
	public Object [][] remplirDonnees (String filtre){
		//cette méthode permet de convertir l'ArrayList en une matrice de données
		ArrayList<Classe> lesClasses = Controleur.selectAllClasses(filtre);
		Object [][] matrice = new Object [lesClasses.size()][4];
		int i =0;
		for (Classe uneClasse : lesClasses) {
			matrice [i][0]= uneClasse.getIdclasse();
			matrice [i][1]= uneClasse.getNom();
			matrice [i][2]= uneClasse.getSalle();
			matrice [i][3]= uneClasse.getDiplome();
			i++;
		}
		return matrice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		 if (e.getSource() == this.btAnnuler) {
			 this.txtDiplome.setText("");
			 this.txtSalle.setText("");
			 this.txtNom.setText("");
		 }
		 else if (e.getSource() == this.btEnregistrer) {
			 String nom = this.txtNom.getText(); 
			 String salle = this.txtSalle.getText();
			 String diplome = this.txtDiplome.getText();
			 
			 //instanciation d'une classe 
			 Classe uneClasse = new Classe (nom,salle, diplome); 
			 
			 //insertion dans la base de données 
			 Controleur.insertClasse(uneClasse);
			 JOptionPane.showMessageDialog(this, "Classe ajoutée avec succès");
			 this.txtDiplome.setText("");
			 this.txtSalle.setText("");
			 this.txtNom.setText("");
		 }
	}
}
























