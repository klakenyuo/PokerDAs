// Il s'agit ici de la variante simplifiée
public class PokerDAs2{
    public static void combi(int[] tab){
		// les variables
        String combinaison = "Aucune";
		boolean paire=false, brelan= false;
        int compteurDeIdentique1 = 0;
        boolean paire1 = false; 

        //Paire ----- code
		for(int i = 0; i <= 4 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);
			if(compteurDeIdentique1==2){
				combinaison = "Paire";
			} 
		}

		// Double Paire --- code .... redevient paire ici a cause de la variante de l exo
			for(int i = 0; i <= 4 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);

			if(compteurDeIdentique1==2 && paire1){
				combinaison = "Paire";
			}
			if(compteurDeIdentique1==2){
				paire1=true;
			}
		}

		 

        //Brelan ----- code
		for(int i = 0; i <= 4 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);
			if(compteurDeIdentique1==3){
				combinaison = "Brelan";
			} 
		}

		 
		//full ---- code ... ici on retourne Brelan a cause de la variante simplifiée
		for(int i = 1; i <= 6 ; i++){
			compteurDeIdentique1 = compteurDeIdentique(tab,i);

			if(compteurDeIdentique1==3){
				brelan=true ;
			} else if(compteurDeIdentique1==2){
				paire=true;
			}
		}
		if(paire && brelan){
			combinaison = "Brelan";
		}

		//Carré ----- code
		for(int i = 0; i <= 4 ; i++){
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