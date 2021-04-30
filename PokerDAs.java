public class PokerDAs{
    public static void combi(int[] tab){
		// les variables
        String combinaison = "Aucune";
        int compteurDeIdentique1 = 0;
		boolean paire=false, brelan= false;
        boolean paire1 = false;
		boolean a3et4 = true ;
		boolean a1et2 = false , a2et5 = false , a5et6 = false ;
		boolean aDe2a5 = true ;
		boolean a1ou6 = false ;

        //Paire ----- code
		for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);
			if(compteurDeIdentique1==2){
				combinaison = "Paire";
			} 
		}

		// Double Paire --- code
			for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);

			if(compteurDeIdentique1==2 && paire1){
				combinaison = "Double Paire";
			}
			if(compteurDeIdentique1==2){
				paire1=true;
			}
		}

		//Petite Suite ---- code
		for(int i=3 ;  i<=4 ; i++){ //Détection de la présence de 3 et 4
			if(!GobeletAValeur(tab,i)) {
				a3et4 = false ;
			}
		}
		a1et2 = (GobeletAValeur(tab,1) && GobeletAValeur(tab,2));//Détection des autres valeurs
		a2et5 = (GobeletAValeur(tab,2) && GobeletAValeur(tab,5));
		a5et6 = (GobeletAValeur(tab,5) && GobeletAValeur(tab,6));
		if(a3et4 && (a1et2||a2et5||a5et6)){
		 combinaison = "Petite Suite";
		}

        //Brelan ----- code
		for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);
			if(compteurDeIdentique1==3){
				combinaison = "Brelan";
			} 
		}

		//Grande Suite ---- code
		for(int i=2 ;  i<=5 ; i++){
			if(!GobeletAValeur(tab,i)) {
				aDe2a5 = false ;
			}
		}
		a1ou6 = (GobeletAValeur(tab,1) || GobeletAValeur(tab,6));//Détection de la présence de 1 ou 6
		if(aDe2a5 && a1ou6){
			combinaison = "Grande Suite";
		}

		//full ---- code  
		for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);

			if(compteurDeIdentique1==3){
				brelan=true ;
			} else if(compteurDeIdentique1==2){
				paire=true;
			}
		}
		if(paire && brelan){
			combinaison = "Full";
		}

		//Carré ----- code
		for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);
			if(compteurDeIdentique1==4){
				combinaison = "Carré";
			} 
		}

        // Poker-----code
        if(tab[0]==tab[1] && tab[1]==tab[2] && tab[2]==tab[3]&& tab[3]==tab[4]){
            combinaison = "Poker";
        }

		//Affichage de la combinaison obtenue
        System.out.print("Combinaison Obtenue : " + combinaison);

        
    }


	// compte le nombre le de identiques
    public static int compteurDeIdentique(int[] tab, int i){
		//Déclaration de la variable
		int nbDe = 0 ;
		for(int j = 0 ; j<5 ; j++){
            if(i == tab[j]){
                nbDe++;
            }
        }
		return(nbDe);
	} 

	//
	public static boolean GobeletAValeur(int[] tab, int i){
		return(tab[0] == i || tab[1] == i || tab[2] == i || tab[3] == i || tab[4] == i);
	}


    public static void main(String[] args){
       int[] tirage = new int[5];
        for(int i = 0 ; i<5 ; i++){
            tirage [i] = (int)(Math.random()*6+1);
        }
        java.util.Arrays.sort(tirage);
        for(int i = 0 ; i<5 ; i++){
            System.out.print(tirage[i]+" ");
        }
		// pour effectuer les tests en entrant vos propres numers
		/*tirage[0] = 1;
		tirage[1] = 2;
		tirage[2] = 4;
		tirage[3] = 5;
		tirage[4] = 6;*/
        combi(tirage);
        System.out.println();
    }
}