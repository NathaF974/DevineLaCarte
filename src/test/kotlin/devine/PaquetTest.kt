package org.sio.slam.devine

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.fail
import org.sio.slam.devine.core.Carte
import org.sio.slam.devine.core.Paquet
import org.sio.slam.devine.enum.CouleurCarte
import org.sio.slam.devine.enum.NomCarte
import org.sio.slam.devine.fabrique.createJeu32Cartes
import org.sio.slam.devine.fabrique.createJeu52Cartes

internal class PaquetTest {

    @Test
    fun cardinal2Cartes() {
        val paquet2Cartes = Paquet(
            listOf(
                Carte(NomCarte.VALET, CouleurCarte.COEUR),
                Carte(NomCarte.DIX, CouleurCarte.TREFLE),
            )
        )
        assertEquals(2, paquet2Cartes.cardinal())
    }

    @Test
    fun testToString2Cartes() {
        val paquet2Cartes = Paquet(
            listOf(
                Carte(NomCarte.VALET, CouleurCarte.COEUR),
                Carte(NomCarte.DIX, CouleurCarte.TREFLE),
            )
        )
        assertEquals("Paquet de 2 cartes", paquet2Cartes.toString())
    }

    @Test
    fun testGetCartes() {
        val paquet = Paquet(emptyList())
        val paquetSize = paquet.cartes.size
        assertEquals(32, paquetSize)
        assertEquals(NomCarte.AS, paquet.cartes[0].nom)
    }

    @Test
    fun fabriqueDe32Cartes() {
        val paquet32 = createJeu32Cartes()
        assertEquals(32, createJeu32Cartes().size)
        assertEquals(NomCarte.AS, paquet32[0].nom)
        assertEquals(CouleurCarte.CARREAU, paquet32[31].couleur)
        for (i in (0..3).step(1)) {
            assertEquals(NomCarte.AS, paquet32[i].nom)
        }
        for (i in (0..31).step(4)) {
            assertEquals(CouleurCarte.TREFLE, paquet32[i].couleur)
        }
    }

    @Test
    fun fabriqueDe52Cartes() {
        val paquet52 = createJeu52Cartes()
        assertEquals(52, createJeu52Cartes().size)
        assertEquals(NomCarte.AS, paquet52[0].nom)
        assertEquals(CouleurCarte.PIQUE, paquet52[51].couleur)
        // test pour asssurer l'ordres de rangement des cartes (Trefle tout les 4 cartes)
        for (i in (0..51).step(4)) {
            assertEquals(CouleurCarte.TREFLE, paquet52[i].couleur)
        }
    }
}
