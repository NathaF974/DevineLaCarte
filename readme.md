**Projet 0 : Devine la carte**

Fontaine Nathanaël
Namoune Ryad



**Challenge 1 :** 
- ouverture du projet
- correction des erreurs de test dans "carteTest" et "PaquetTest"
  - dans "carteTest" nous avons réalisé des tests sur l'orthographe des noms et des couleurs des cartes 
    d'un paquet (vérifier qu'elles soient bien toute en majuscule), vérifier la correspondance des bonnes couleurs dans
    les paquets, vérifier les point des cartes (que les cartes n'est pas les mêmes points).
  - dans "paquetTest" nous avons testé le bon nombre de cartes dans un paquet, tester la récupération de cartes dans un paquet,
    vérifié le bon rangement des cartes dans un paquet (vérifié que les 4 premiers noms de cartes des paquets soit les même,
    vérifier le bon rangement des couleurs dans les paquets).



**Challenge 2:**
- Réalisation des TODO pour : demander au joueur s'il souhaite avoir de l'aide pour sa partie :
  - demande si le joueur veut une aide avec une boucle "do" et une variable "Boolean" s'il est d'accord ou non pour le 
    choix d'une aide, s'il n'y a pas de réponse correcte le jeu choisi alors qu'il n'y a pas d'aide.
- demander au joueur avec quel jeu de cartes 32 ou 52 il souhaite jouer :
  - à l'aide d'une boucle "do" on vient demander au joueur de saisir soit 32 ou 52 pour s'avoir si quel paquet il souhaite 
    choisir, s'il n'y a pas de réponse correcte le jeu choisira alors directement alors de créer un jeu de 52 cartes.
- demander (si l'aide à étais demander) si la carte choisie est plus ou moins grande que celle à trouver :
  - avec une boucle "if" on vient indiquer au joueur si la carte choisie est plus grande ou moins grande que celle choisi
    en s'appuyant sur les données des points attribuer aux cartes dans les paquets.
- permettre au joueur de retenter une autre carte (sans relancer le jeu) ou d'abandonner la partie :
  - on vient demander au joueur aux cas ou il n'aurait pas trouvé la carte du premier coup, si il souhaite retenter sa 
    chance dans cette partie, s'il accepte alors le jeu lui redemandera (à travers une boucle "do")le nom et la couleur
    de la nouvelle carte qu'il choisi, cette boucle est répété si le joueur ne trouve pas la carte et qu'il accepte de 
    vouloir réessayer.
- présenter à la fin la carte à deviner :
  - ici on vient afficher la carte a deviner.

- Réalisation des diagrammes UML:
  - avant les modifications :

@startuml 
start
:lancement de la partie;

:Entrez un paquet de carte oui/non;

:Instanciation du jeu;

:Entrez la couleur de la carte
:Entrez le nom de la carte;
:Carte est dans un paquet;
if  (carte match) then (true)
:Vous avez trouvé la carte !;
end
else
:Mauvaise carte;
end
endif


@enduml

- aprés modification :

@startuml
start
:lancement de la partie;

repeat
repeat
:Saisir Paquet Cartes 32;
:Saisir Paquet Cartes 52;
repeat while (Paquet existe?) is (no) not (yes)
:Instanciation du jeu;
repeat
:Entrez la couleur de la carte
:Entrez le nom de la carte;
repeat while (Carte existe ?) is (no) not (yes)
if  (carte match) then (true)
:Vous avez trouvé la carte;
end
else
:Mauvaise carte;
:Aide;
endif



repeat while (réeassayer) is (oui) not (non)
:montré la carte a deviné;
:Vous avez abandonné !;
:Strategie partie;
@enduml

**Challenge 3:**
- Creation d'une fonction "rebattreCarte()" qui utilise la methode shuffle. Shuffle permet de melanger aleatoirement
  les valeurs d'une liste.
- Creation d'un test unitaire "testMelangeCarte()" qui verifie que les cartes soient bien melangées en comparant la place
  des cartes avant et apres le passage de la fonction rebattreCarte().