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
    
    public String affecterCouleur(String couleur) {
        Couleur = couleur;
        return Couleur;
    }
    
    public int nombreJetonsRestants () {
        int a = reserveJetons.size();
        return a;
    }
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
