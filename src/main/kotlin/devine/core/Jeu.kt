package org.sio.slam.devine.core

import kotlin.math.log2

class Jeu(val avecAide: Boolean, val paquet: Paquet, paramCarteADeviner: Carte? = null) {
    val carteADeviner: Carte
        // le getter par défaut, inutile de le redéclarer (juste pour la démonstration)
        // field est ici synonyme de carteADeviner (implicite backing memory de la propriété)
        // REM : faire référence à carteADeviner au lieu de field entrainerait une récursion incontrôlée
        get() = field

    // set(value) { field = value } <== impossible car la propriété est en lecture seule (val)
    init {
        // si le paramètre paramCarteADeviner du constructeur a comme valeur null
        // alors on demande au paquet de nous fournir une carte à deviner
        // sinon on retient la valeur de carte transmise
        this.carteADeviner = paramCarteADeviner ?: this.paquet.getCarteADeviner()
    }

    /**
     * Permettre de savoir si la proposition de carte EST bien la carte à deviner, ou non
     */
    fun isMatch(carteProposee: Carte): Boolean {
        return this.carteADeviner == carteProposee
    }

    /**
     * Analyse la partie du joueur, a-t-il abandonné la partie,
     *  a-t-il trouvé la carte en un nombre de fois "convenable" ou "inconvenable",
     *  a-t-il eu de la chance ?
     */
    fun strategiePartie(){
        /*
        if (!abandonner) {
            if (avecAide) {
                val logEssai = log2(paquet.cartes.size.toDouble())
                if (nombreEssai.toDouble() >= logEssai * 2) {
                    return "Vous avez fait beaucoup trop d'essaie : $nombreEssai !"
                } else if (nombreEssai.toDouble() >= logEssai && nombreEssai.toDouble() < logEssai * 2) {
                    return "Bonne stratégie cepandant Vous avez de nombreux essaie: $nombreEssai !"
                } else if (nombreEssai == logEssai.toInt()) {
                    return "Très bonne stratégie, nombre d'essai: $nombreEssai"
                } else if (nombreEssai.toDouble() < logEssai) {
                    return "Rien à dire, vous l'avez dans le mile, nombre d'essai: $nombreEssai"
                }
            } else {
                val pourcentageChance = (nombreEssai.toDouble() / paquet.cartes.size.toDouble()) * 100
                if (pourcentageChance <= 0.50) {
                    return "Vous etes chanceux, ${pourcentageChance.toInt()}% de chance avec $nombreEssai nombre d'essai."
                } else {
                    return "Vous n'etes pas de chanceux, ${pourcentageChance.toInt()}% de chance $nombreEssai nombre d'essai."
                }
            }
            return "Soucis de nombre d'essai :$nombreEssai "
        } else {
            return "Vous avez abandonner :("
        }
         */

    }
}
