# flu_epidemic
### Membres du groupe
- FILIOL DE RAIMOND-MICHEL Guillaume
- KUMAR Raphaël
- KEYNES Timothy
### Contraintes client

Les différentes contraintes client ont étées respectées, à savoir : 
- Utiliser de l'héritage
- Utiliser du polymorphisme sur les attributs
- Utiliser du polymorphisme sur les fonction
- Utiliser des enums
- Implémenter une variante, ici l'immunité possible au virus
- Le développement a aussi été accés pour faciliter les futurs améliorations (on peut facilement modifier les % d'infections et autres caractéristiques spécifiques des entitées)

### Régles générales du jeu

Malheireisement, l'interface graphique ne marche pas, nous avons eu des problèmes avec le rafraichissement des composantes, et nous nous sommes rendus compte à la fin, que comme nous avions fait, sans threads il est impossible d'afficher les états "temporaires", d'ou en plus problème d'affichage, qui est du au stack des informations. 

- Dés le début, il faut sélectionner le nombre de voisins voulus
- On peut changer la vitesse du d'exécution en cours de jeu
- A chaque tour, chaque entité se déplace d'une case et essaye d'infecter ses 4 ou 8 voisins comme choisi en début de jeu.
- Les cochons ont une chance d'infecter les chochons et une plus faible, d'infecter les humains.
- Les poulets ont une chance d'infecter les poulets et une plus faible, d'infecter les humains.
- Les canards ont une chance d'infecter les canards et une plus faible, d'infecter les humains.
- Enfin, les humains peuvent d'infecter entre eux avec un certain pourcentage de chance.
- Les animaux ne peuvent pas mourir, ni devenir immunisée.
- Si une personne est censée être infectée par une autre, mais qu'elle est déjà infectée, cela accélére la croissance de son virus.
- Le jeu est fini quand tout les humains sont ou morts ou immunisés
- Le vert correspond aux humains
- Le orange aux canards
- Le rouge aux poulets
- le Rose aux cochons

### Lancer le jeu

```sh
$ chmod +x bash.sh
$ ./bash.sh
```
