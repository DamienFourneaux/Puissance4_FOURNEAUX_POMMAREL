package superpuissance4_fourneaux_pommarel;


import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Damien
 */
public class joueur {
    private String Nom;
    String Couleur;
    ArrayList<Jeton> reserveJetons = new ArrayList<Jeton>();
    int nombreDesintegrateurs;
    
    public joueur(String Joueur){
        Nom = Joueur;
    }
    
    /**
     *affecte la couleur au joueur
     * @param couleur
     * @return
     */
    public String affecterCouleur(String couleur) {
        Couleur = couleur;
        return Couleur;
    }
    
    /**
     *Permet de faire varier nombreJetonsRestants en fonction de la taille du tableau dynamique
     * @return
     */
    public int nombreJetonsRestants () {
        int a = reserveJetons.size();
        return a;
    }

    /**
     *Ajoute le jeton passé en paramètre à la liste ReserveJetons
     * @param a
     */
    public void ajouterJeton (Jeton a) {
        reserveJetons.add(a);
        
    }
    
    public void obtenirDesintegrateur() {
        nombreDesintegrateurs+=1;
        System.out.println("Vous venez de gagner un désintégrateur. Vous avez" + nombreDesintegrateurs + "désintégrateur(s).");
        
    }
   
    
    public void utiliserDesintegrateurs() {
        nombreDesintegrateurs-= 1;
        System.out.println("Vous venez d'utiliser un désintégrateur. Il vous reste " + nombreDesintegrateurs + "désintégrateur(s).");
    }
    
    
}
