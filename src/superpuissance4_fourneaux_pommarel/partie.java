/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package superpuissance4_fourneaux_pommarel;


import java.util.Random;
import java.util.Scanner;



/**
 *
 * @author quent
 * 
 * Cette classe permet de mettre en commun toutes les classes précédemment créées afin de créer une partie. 
 */
public class partie  {
    private joueur [] listeJoueurs = new joueur[2];
    private joueur joueurCourant;
    private PlateauDeJeu plateau = new PlateauDeJeu();
    
    public partie (joueur j1,joueur j2){
        listeJoueurs[0]=j1;
        listeJoueurs[1]=j2;
    }
    
    /**
     * Permet d'associer aux deux joueurs une couleur aléatoire.
     */
    public void attribuerCouleurAuxJoueurs(){
       Random n =new Random();
       int var=n.nextInt(2);
       if (var==0){
               listeJoueurs[0].affecterCouleur("jaune");
               listeJoueurs[1].affecterCouleur("rouge");
       }else{
               listeJoueurs[0].affecterCouleur("rouge");
               listeJoueurs[1].affecterCouleur("jaune");
       }
   }
   
    /**
     * Créé 30 jetons à chauqe joueur de sa couleur (précédemmment associé grâce à la méthode précédente)
     * @param j1
     */
    public void créeretaffecterJeton(joueur j1){ 
        if("rouge"==j1.getCouleur()){
            for(int i=0;i<30;i++){
                Jeton stockjeton=new Jeton("rouge");
                j1.ajouterJeton(stockjeton);
            }
        }
        if("jaune"==j1.getCouleur()){
            for(int i=0;i<30;i++){
                Jeton stockjeton=new Jeton("jaune");
                j1.ajouterJeton(stockjeton);
            }
        }
    }
    
    /**
     * Place les trous noirs et les désintégrateurs aléatoirement sur la grille.
     */
    public void placerTrousNoirsEtDesintegrateurs(){
        Random r = new Random();
        int tn = 5;
        int dtn = 2;
        int d = 3;
        int x, y;
        Cellulegrille[] ltn= new Cellulegrille[5];
        while(tn > 0){
            x = r.nextInt(6);
            y = r.nextInt(7);
            if(plateau.grille[x][y].presencetrounoir() == false){
                ltn[tn - 1] = plateau.grille[x][y];
                tn--;
            }
        }
        
        while(dtn > 0){
            ltn[r.nextInt(ltn.length)].placerdesintegrateur();
            dtn--;
        }
        
        while(d > 0){
            x = r.nextInt(6);
            y = r.nextInt(7);
            if(plateau.grille[x][y].presencetrounoir() == false){
                if(plateau.grille[x][y].presencedesintegrateur()){
                    plateau.grille[x][y].placerdesintegrateur();
                    d--;
                }
            }
        }
    }
    
    /**
     * Permet d'initialiser la partie
     */
    public void initialiserPartie(){
        attribuerCouleurAuxJoueurs();
        créeretaffecterJeton(listeJoueurs[0]);
        créeretaffecterJeton(listeJoueurs[1]);
        placerTrousNoirsEtDesintegrateurs();
        plateau.afficherGrilleSurConsole();
    }
    
    /**
     * Permet de lancer la partie
     */
    public void lancerPartie(){
        int cpt = -1;
        Scanner sc = new Scanner(System.in);      
        int rep;
        while(plateau.etreGagnantePourCouleur(listeJoueurs[0].getCouleur()) == false && plateau.etreGagnantePourCouleur(listeJoueurs[1].getCouleur()) == false && plateau.grilleremplie() == false){
            cpt++;
            
            if (cpt % 2 == 0){
                joueurCourant = listeJoueurs[0];
            }else{
                joueurCourant = listeJoueurs[1];
            }
            
            System.out.println("C'est au tour de " + joueurCourant.getNom() + " de jouer");
            
            rep = 100;
            while(rep < 0 | rep > 2){
                System.out.println("0 -> Jouer jeton\n1 -> Récupérer Jeton\n2 -> Désintégrer jeton");
                rep = sc.nextInt();
                
                if(rep == 1 && joueurCourant.nombreJetonsRestants() >= 30){
                    System.out.println("Vous n'avez pas posé de jeton");
                    rep = 100;
                }
                if(rep == 2 && joueurCourant.nombreDesintegrateurs < 1){
                    System.out.println("vous n'avez pas de désintégrateur");
                    rep = 100;
                }
            }
            
            switch(rep){
                case 0:
                    jouerJeton();
                    break;
                case 1:
                    recupererJeton();
                    break;
                case 2:
                    desintegrerJeton();
                    break;
            }
            
            boolean v1 =  plateau.etreGagnantePourCouleur(listeJoueurs[0].Couleur);
            boolean v2 = plateau.etreGagnantePourCouleur(listeJoueurs[1].Couleur);

            if(v1 & !v2){System.out.println("Victoire de " + listeJoueurs[0].getNom());}
            if(v2 & !v1){System.out.println("Victoire de " + listeJoueurs[1].getNom());}

            if(v1 & v2){
                if(joueurCourant == listeJoueurs[0]){System.out.println("Victoire de " + listeJoueurs[1].getNom() + " sur une faute de jeu de " + joueurCourant.getNom());}
                if(joueurCourant == listeJoueurs[1]){System.out.println("Victoire de " + listeJoueurs[0].getNom() + " sur une faute de jeu de " + joueurCourant.getNom());}
            }
            
            if(plateau.grilleremplie()){
                System.out.println("Grille pleine");
            }
            
            plateau.afficherGrilleSurConsole();
      
        }
        System.out.println("partie fini");
    }
    
    /**
     * Permet d'untiliser un d"se=intégrateur précédemment récupéré avoir de détruire un jeton
     */
    public void desintegrerJeton(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ligne :");
        int x = sc.nextInt();
        System.out.println("Colonne :");
        int y = sc.nextInt();
        if(joueurCourant.nombreDesintegrateurs > 0){
            while(plateau.grille[x][y].getJetonCourant() == null){
                System.out.println("Les coordonnées du point que vous voulez désintégerer : ");
                System.out.println("ligne :");
                x = sc.nextInt();
                System.out.println("Colonne :");
                y = sc.nextInt();
            }
            
            if(plateau.grille[x][y].lirecouleurjeton().equals(joueurCourant.Couleur) && plateau.presenceJeton(x, y) == true){
                plateau.supprimerJeton(x, y);
            }
        }
    }
    
    /**
     * Permet de récupérer un jeton dan la grile
     */
    public void recupererJeton(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("ligne :");
        int x = sc.nextInt();
        System.out.println("Colonne :");
        int y = sc.nextInt();
        
        while(plateau.grille[x][y].lirecouleurjeton().equals(joueurCourant.getCouleur()) == false){
            System.out.println("ligne :");
            x = sc.nextInt();
            System.out.println("Colonne :");
            y = sc.nextInt();
        }
        
        Jeton jeton = plateau.grille[x][y].recupererjeton();
        joueurCourant.ajouterJeton(jeton);
        
        plateau.tasserGrille();
    }
    
    /**
     * Permet de jouer un jeton sur la grille
     */
    public void jouerJeton(){
        int colonne = 100;
        int l;
        Scanner sc = new Scanner(System.in);
        
        if(joueurCourant.nombreJetonsRestants() > 0){
            
            while(colonne < 0 || colonne > 6){
                System.out.println("Colonne :");
                colonne = sc.nextInt();
            }
            
            if (plateau.colonneremplie(colonne) == false){
                
                Jeton jt = joueurCourant.prendreUnJeton();
                l = plateau.ajouterJetonDansColonne(jt, colonne);
                if(l != 100){
                    if(plateau.grille[l][colonne].presencetrounoir()){
                        plateau.grille[l][colonne].activertrounoir();
                    }

                    if(plateau.grille[l][colonne].presencedesintegrateur()){
                        plateau.grille[l][colonne].supprimerdesintegrateur();
                        joueurCourant.obtenirDesintegrateur();
                    }
                }
            }
        }
    }

}