package superpuissance4_fourneaux_pommarel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Damien
 */
public class PlateauDeJeu {
    Cellulegrille[][] grille = new Cellulegrille [6][7];
    
    public PlateauDeJeu () {
        for (int i = 0;i<7;i++) {
            for (int j = 0; j<6; j++) {
                grille [j][i] = new Cellulegrille();
            }
            
        }
        
    }
    public Jeton ajouterJetonDansColonne(Jeton jt, int i) {
        
        
        
        
        
        
    
        
    }
    
    public boolean grilleremplie(){
         for (int i = 0;i<7;i++) {
            for (int j = 0; j<6; j++) {
                if (Cellulegrille[j][i] == null) {
                    return false;    
                }
                El
            }
            
        }
    }
    
}
