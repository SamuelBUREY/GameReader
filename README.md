# GameReader

Application pour rechercher des jeux, visualiser des informations dessus et les sauvegarder.


# Application 

On va donc retrouver au lancement de l'application une page contenant  la liste des jeux sauvegarder par l'utilisateur.  
Pour chaque item on va retrouver :  
Le nom du jeu.  
L'url du jeu  
Ainsi que son score.  

En cliquant sur un des jeux nous allons arriver sur une page détaillant le jeux avec en plus la description  du jeux.  
Je n'ai pas eu le temps de récupérer plus de détails sur le jeu car il fallait gérer beaucoup d'identifiant en plus.  
Un bouton à la fin de la description est disponible pour pouvoir supprimer le jeu.  

En revenant en arrière nous atterrissons sur la première page. 
Un bouton flottant permet de lancer une nouvelle page où l'on va pouvoir faire une recherche de jeu.  
Une barre de recherche est disponible en cliquant dessus et en remplissant le texte  nous allons pouvoir retrouver une liste de jeu  qui correspond au texte rempli.  
Cette recherche utilise l'API IGDB qui est une grande base de données pour les jeux vidéos. 
En cliquant sur un des jeux de la liste , le jeu va s'ajouter à notre liste de jeu déja sauvegarder.  

# Conception

Pour afficher une liste de jeux j'utilise un fragment avec une recyclerview et un adapter pour la vue de la liste. (GamesFragment, GameAdapter, MainActivity).  
J'utilise un navigateur pour aller de fragment en fragment.  
En cliquant sur un des items de la liste , une action est produite et avec le navigateur je peux aller de la liste jusqu'à la page de détail du jeu (GameDetailFragment).  
Pour la recherche, j'utilise une searchview pour la barre de recherche,  pour la liste une recyclerview avec un adapter.(GameSearchAdapter,SearchActivity).  
J'utilise retrofit qui permet de faire des requêtes sur une API avec un interface qui permet de faire les requêtes.  
J'utilise room pour sauvegarder mes jeux en base de données.  


 



