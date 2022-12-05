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
    int Ligne = 6;
    int Colonne = 7;
    
    public PlateauDeJeu () {
        for (int i = 0;i<6;i++) {
            for (int j = 0; j<7; j++) {
                grille [i][j] = new Cellulegrille();
            }
            
        }
        
    }
    
    public int ajouterJetonDansColonne(Jeton jt, int i) {
        int ligne = 100;
        if(colonneremplie(i) == false){
            if(grille[Ligne - 1][i].getJetonCourant() == null){
                grille[Ligne - 1][i].ajouterjeton(jt);
                return Ligne - 1;
            }
            
            for(int k = 0; k < Ligne; k++){
                if (grille[k][i].getJetonCourant() != null){
                    grille[k - 1][i].ajouterjeton(jt);
                    ligne = k - 1;
                    break;
                }
            }
        }
        return ligne;
    }
        
    public boolean colonneremplie(int i){
        for(int k = 0; k < Ligne; k++){
            if (grille[k][i].getJetonCourant() == null){
                return false;
            }
        }
        return true;
    }
    
    public boolean grilleremplie(){
        for (int i = 0;i<6;i++) {
            for (int j = 0; j<7; j++) {
                if (grille[j][i].getJetonCourant() == null) {
                    return false;    
                }
            }
            
        }
        return true;
    }
    
    public void afficherGrilleSurConsole(){
        
        for (int k = 0; k < 6; k++){
            for (int i = 0; i < 7; i++){
                
                System.out.print("[" + grille[k][i].lirecouleurjeton() + "]");
                
                if(i == Colonne - 1){
                    System.out.print("\n");
                }
            }
        }    
    }
    
    public boolean presenceJeton(int x, int y){
        if(grille[x][y].presencejeton()){
            return true;
        }else{
            return false;
        }
    }
    
    public String lireCouleurDuJeton(int x, int y){
        return grille[x][y].lirecouleurjeton();
    }
    
    public boolean etreGagnantePourCouleur(String couleur){
        return ligneGagnantePourCouleur(couleur) == true || colonneGagnantePourCouleur(couleur)== true || diagonaleMontanteGagnantePourCouleur(couleur) == true || diagonaleDesencanteGagnantePourCouleur(couleur) == true;
    }
    
    public boolean ligneGagnantePourCouleur(String couleur){
        for(int k = 0; k < Ligne; k++){
            for(int i = 0; i < Colonne - 3; i++){
                if(grille[k][i].lirecouleurjeton().equals(couleur) && grille[k][i + 1].lirecouleurjeton().equals(couleur) && grille[k][i + 2].lirecouleurjeton().equals(couleur) && grille[k][i + 3].lirecouleurjeton().equals(couleur)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean colonneGagnantePourCouleur(String couleur){
        for(int k = 0; k < Colonne; k++){
            for(int i = 0; i < Ligne - 3; i++){
                if(grille[i][k].lirecouleurjeton().equals(couleur) && grille[i + 1][k].lirecouleurjeton().equals(couleur) && grille[i + 2][k].lirecouleurjeton().equals(couleur) && grille[i + 3][k].lirecouleurjeton().equals(couleur)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean diagonaleMontanteGagnantePourCouleur(String couleur){
        for(int k = 3; k < Ligne; k ++){
            for(int i = 0; i < Colonne - 3; i++){
                if(grille[k][i].lirecouleurjeton().equals(couleur) && grille[k - 1][i + 1].lirecouleurjeton().equals(couleur) && grille[k - 2][i + 2].lirecouleurjeton().equals(couleur) && grille[k - 3][i + 3].lirecouleurjeton().equals(couleur)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean diagonaleDesencanteGagnantePourCouleur(String couleur){
        for(int k = 0; k < Ligne - 3; k++){
            for(int i = 0; i < Colonne - 3; i++){
                if(grille[k][i].lirecouleurjeton().equals(couleur) && grille[k + 1][i + 1].lirecouleurjeton().equals(couleur) && grille[k + 2][i + 2].lirecouleurjeton().equals(couleur) && grille[k + 3][i + 3].lirecouleurjeton().equals(couleur)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public void tasserColonne(int c){
        for(int i = Ligne - 1; i > 0; i--){
            if(grille[i][c].getJetonCourant() == null){
                grille[i][c].ajouterjeton(grille[i - 1][c].getJetonCourant());
                grille[i - 1][c].ajouterjeton(null);
            }
        }
    }
    
    public void tasserGrille(){
        for(int k = 0; k < Ligne; k++){
            tasserColonne(k);
        }
    }
    
    public boolean presenceTrouNoir(int x, int y){
        return grille[x][y].presencetrounoir();
    }
    
    public boolean presenceDesintegrateur(int x, int y){
        return grille[x][y].presencedesintegrateur();
    }
    
    public void placerTrouNoir(int x, int y){
        grille[x][y].placertrounoir();
    }
    
    public void placerDesintegrateur(int x, int y){
        grille[x][y].placerdesintegrateur();
    }
    
    public void supprimerTrouNoir(int x, int y){
        grille[x][y].supprimertrounoir();
    }
    
    public void supprimerDesintegrateur(int x, int y){
        grille[x][y].supprimerdesintegrateur();
    }
    
    public void supprimerJeton(int x, int y){
        grille[x][y].supprimerjeton();
    }
    
    public Jeton recupererjeton(int x, int y){
        Jeton jt = grille[x][y].recupererjeton();
        grille[x][y].supprimerjeton();
        return jt;
    }
    
}
