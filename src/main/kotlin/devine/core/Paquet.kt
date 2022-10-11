package org.sio.slam.devine.core

import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
import org.sio.slam.devine.enum.CouleurCarte
import org.sio.slam.devine.enum.NomCarte
import org.sio.slam.devine.fabrique.createJeu32Cartes
import java.util.Collections.shuffle

class Paquet constructor(var cartes: List<Carte> = ArrayList<Carte>()) {
    init {
        if (this.cartes.isEmpty()) {
            this.cartes = createJeu32Cartes()
        }
    }

    /**
     * Donne le nombre de cartes dans le paquet
     */
    fun cardinal(): Int = cartes.size

    /**
     * Représentation textuelle de l'état du paquet
     */
    override fun toString(): String {
        return "Paquet de ${cardinal()} cartes"
    }

    /**
     * C'est le paquet qui décide quelle sera la carte à deviner
     * @see [org.sio.slam.Jeu]
     */
    fun getCarteADeviner(): Carte {
        // TODO implémenter une solution moins prédictive !!
        return this.cartes.random()
    }

    fun rabattreCartes(list: List<Carte>): List<Carte> {
        return list.shuffled()
    }

    @Test
    fun testRabattreCartes() {
        val paquet2Cartes = Paquet(
            listOf(
                Carte(NomCarte.DEUX, CouleurCarte.TREFLE),
                Carte(NomCarte.TROIS, CouleurCarte.COEUR),
                Carte(NomCarte.QUATRE, CouleurCarte.CARREAU),
                Carte(NomCarte.CINQ, CouleurCarte.PIQUE),
                Carte(NomCarte.SIX, CouleurCarte.CARREAU),
                Carte(NomCarte.SEPT, CouleurCarte.COEUR),
                Carte(NomCarte.HUIT, CouleurCarte.PIQUE),
                Carte(NomCarte.NEUF, CouleurCarte.TREFLE),
                Carte(NomCarte.DIX, CouleurCarte.COEUR),
            )
        )

        val paquetMixed = paquet2Cartes.rabattreCartes(paquet2Cartes.cartes)
        assertNotEquals(paquet2Cartes.cartes[0], paquetMixed[0])

    }
}
