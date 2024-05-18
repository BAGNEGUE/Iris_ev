package controleur;

import java.util.ArrayList;

import modele.Modele;

public class Controleur {
	
	public static User selectWhereUser (String email, String mdp) {
		//tester email et la complexite mdp. 
		return Modele.selectWhereUser(email, mdp);
	}
	/****************** gestion des classes ***************/
	public static void insertClasse( Classe uneClasse) {
		Modele.insertClasse(uneClasse);
	}
	
	public static void deleteClasse( int idClasse) {
		Modele.deleteClasse(idClasse);
	}
	
	public static void updateClasse( Classe uneClasse) {
		Modele.updateClasse(uneClasse);
	}
	
	public static ArrayList<Classe> selectAllClasses( String filtre) {
		return Modele.selectAllClasses(filtre);
	}
	public static Classe selectWhereClasse(int idClasse) {
		return Modele.selectWhereClasse(idClasse);
	}
	public static void updateUser(User unUser) {
		Modele.updateUser(unUser);		
	}
}










