package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Classe;
import controleur.User;

public class Modele {
	private static Bdd uneBdd = new Bdd ("localhost:3307","scolarite_iris_2024","root","");
	
	public static User selectWhereUser (String email, String mdp) {
		String requete = "select * from user where email='"+email+"' and "
				+ " mdp ='"+mdp+"' ; ";
		User unUser = null; 
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet unRes = unStat.executeQuery(requete);
			if (unRes.next()) {
				unUser = new User (
						unRes.getInt("iduser"), unRes.getString("nom"), 
						unRes.getString("prenom"), unRes.getString("email"), 
						unRes.getString("mdp"), unRes.getString("role")
						);
			}
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return unUser; 
	}
	/*************** Gestion des Classes ***************************/ 
	public static void insertClasse (Classe uneClasse) {
		String requete ="insert into classe values (null, '"
				+uneClasse.getNom()+"','"
				+uneClasse.getSalle()+"','"
				+uneClasse.getDiplome()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	
	public static void deleteClasse (int idClasse) {
		String requete ="delete from classe where idclasse = "+idClasse+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static void updateClasse (Classe uneClasse) {
		String requete ="update classe set nom='" 
				+uneClasse.getNom()+"', salle ='"
				+uneClasse.getSalle()+"', diplome ='"
				+uneClasse.getDiplome()+"' where idclasse = "
				+uneClasse.getIdclasse()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
	}
	public static ArrayList<Classe> selectAllClasses (String filtre){
		ArrayList<Classe> lesClasses = new  ArrayList<Classe>(); 
		String requete ="" ; 
		if (filtre.contentEquals("")) {
			requete = "select * from  classe ; ";
		}else {
			requete = "select * from  classe where nom like '%" + filtre 
					+ "%'  or  salle like '%"+filtre
					+ "%' or diplome like '%"+filtre +"%' ;"; 
		}
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			while (desRes.next()) {
				Classe uneClasse = new Classe(desRes.getInt("idclasse"),
						desRes.getString("nom"), 
						desRes.getString("salle"),desRes.getString("diplome"));
				lesClasses.add(uneClasse);
			}
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return lesClasses; 
	}
	public static Classe selectWhereClasse (int idClasse) {
		Classe uneClasse = null; 
		String requete = "select * from classe where idclasse = " +idClasse+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			ResultSet desRes = unStat.executeQuery(requete);
			if (desRes.next()) {
				uneClasse = new Classe(desRes.getInt("idclasse"),
						desRes.getString("nom"), 
						desRes.getString("salle"),desRes.getString("diplome"));
			}
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
		return uneClasse; 
	}
	public static void updateUser(User unUser) {
		String requete = "update user set nom='"
				+unUser.getNom()+"' , prenom ='"
				+unUser.getPrenom()+"' , email ='"
				+unUser.getEmail()+"' , role ='"
				+unUser.getRole()+"' , mdp ='"
				+unUser.getMdp()+"' , where iduser ="
				+unUser.getIduser()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat = uneBdd.getMaConnexion().createStatement(); 
			unStat.execute(requete);
			unStat.close(); 
			uneBdd.seDeConnecter();
		}
		catch (SQLException exp) {
			System.out.println("Erreur de requete : " + requete);
		}
				
	}
}





















