package org.sio.slam.devine

import org.sio.slam.devine.core.Carte
import org.sio.slam.devine.core.Jeu
import org.sio.slam.devine.core.Paquet
import org.sio.slam.devine.enum.CouleurCarte
import org.sio.slam.devine.enum.NomCarte
import org.sio.slam.devine.enum.getCouleurCarteFromString
import org.sio.slam.devine.enum.getNomCarteFromString
import org.sio.slam.devine.fabrique.createJeu32Cartes
import org.sio.slam.devine.fabrique.createJeu52Cartes

fun main(args: Array<String>) {
    // TODO (A) demander au joueur s'il souhaite avoir de l'aide pour sa partie
    var Aide: Boolean = false
    do {
        println("Voulez-vous une aide ?(oui/non)")
        val reponse = readLine() + ""

        if (reponse == "oui") {
            Aide = true
            println("Vous avez demander de l'aide !")
        } else {
            Aide = false
            println("Vous n'avez pas demander d'aide !")
        }
    } while (reponse == "oui" && reponse == "non")


    // TODO (A) demander au joueur avec quel jeu de cartes 32 ou 52 il souhaite jouer
    var paqueDeCartes: Paquet = Paquet()
    do {
        println("Voulez-vous un paquet de 32 cartes ou 52 cartes ?")
        val repPaquet = readLine() + ""

        if (repPaquet == "32") {
            paqueDeCartes = Paquet(createJeu32Cartes())
        } else {
            paqueDeCartes = Paquet(createJeu52Cartes())
        }
    } while (repPaquet != "32" && repPaquet != "52")
    println("Création d'un paquet de $paqueDeCartes cartes")



    println(" ==== Instanciation du jeu, début de la partie. ====")
    val jeu = Jeu(Aide, paqueDeCartes)

    println("Entrez un nom de carte dans le jeu (exemples : Roi, sept, six, As...) :")
    // TODO (optionnel) permettre de saisir un chiffre au lieu d'une chaine : 7 au lieu de Sept...
    val nomCarteUserStr: String = readLine() + ""
    val nomCarteUser: NomCarte? = getNomCarteFromString(nomCarteUserStr.trim().uppercase())

    println("Entrez un nom de \"couleur\" de carte parmi : Pique, Trefle, Coeur, Carreau : ")
    val couleurCarteUserStr: String = readLine() + ""
    val couleurCarteUser: CouleurCarte? = getCouleurCarteFromString(couleurCarteUserStr.trim().uppercase())

    if (nomCarteUser != null && couleurCarteUser != null) {
        // prise en compte de la carte du joueur
        val carteDuJoueur: Carte = Carte(nomCarteUser, couleurCarteUser)

        if (jeu.isMatch(carteDuJoueur)) {
            println("Bravo, vous avez trouvé la bonne carte !")
        } else {
            println("Ce n'est pas la bonne carte !")
            println("votre proposition  : $carteDuJoueur")
            if (Aide) {
                // TODO: (A) si l'aide est activée, alors dire si la carte proposée est
                //  plus petite ou plus grande que la carte à deviner
                if (carteDuJoueur > jeu.carteADeviner){
                    println("Votre carte est plus grande que celle a deviner !")
                } else {
                    println("Votre carte est plus petite que celle a deviner !")
                }
            }
            // TODO (A) permettre au joueur de retenter une autre carte (sans relancer le jeu) ou d'abandonner la partie
            var carteTrouver: Boolean = false
            do {
                println("Voulez-vous réessayer ?")
                val suiteDuJeu = readLine() + ""
                if (suiteDuJeu == "oui"){
                    println("Entrez un nom de carte dans le jeu (exemples : Roi, sept, six, As...) :")
                    val nomCarteUserStr: String = readLine() + ""
                    val nomCarteUser: NomCarte? = getNomCarteFromString(nomCarteUserStr.trim().uppercase())

                    println("Entrez un nom de \"couleur\" de carte parmi : Pique, Trefle, Coeur, Carreau : ")
                    val couleurCarteUserStr: String = readLine() + ""
                    val couleurCarteUser: CouleurCarte? = getCouleurCarteFromString(couleurCarteUserStr.trim().uppercase())

                    if (nomCarteUser != null && couleurCarteUser != null) {
                        // prise en compte de la carte du joueur
                        val carteDuJoueur: Carte = Carte(nomCarteUser, couleurCarteUser)

                        if (jeu.isMatch(carteDuJoueur)) {
                            println("Bravo, vous avez trouvé la bonne carte !")
                            carteTrouver == true
                        } else {
                            println("Ce n'est pas la bonne carte !")
                            println("votre proposition  : $carteDuJoueur")
                            if (Aide) {
                                if (carteDuJoueur > jeu.carteADeviner){
                                    println("Votre carte est plus grande que celle a deviner !")
                                } else {
                                    println("Votre carte est plus petite que celle a deviner !")
                                }
                            }
                        }
                    } else {
                        println(" ==== Fin prématurée de la partie ====")
                    }
                }
            } while (suiteDuJeu == "oui" && carteTrouver == true)
        }
    } else {
        // utilisateur a mal renseigné sa carte
        val nomCarte = if (nomCarteUserStr == "") "?" else nomCarteUserStr
        val couleurCarte = if (couleurCarteUserStr == "") "?" else couleurCarteUserStr

        println("Désolé, mauvaise définition de carte ! (${nomCarte} de ${couleurCarte})")
    }




    // TODO (A) Présenter à la fin la carte à deviner
    println("La carte à deviner est " + jeu.carteADeviner)

    // TODO (challenge-4) la stratégie de jeu est à implémenter... à faire lorsque les autres TODOs auront été réalisés

    println("Votre stratégie de jeu : ${jeu.strategiePartie()} ")

    println(" ==== Fin de la partie. ====")
}