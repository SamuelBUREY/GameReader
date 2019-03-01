# GameReader

Application pour rechercher des jeux, visualiser des informations dessus et les sauvegarder.


# Application 

On va donc retrouver au lancement de l'application une page contenant  la liste des jeux sauvegarder par l'utilisateur.  
Pour chaque item on va retrouver :  
Le nom du jeu.  
L'url du jeu  
Ainsi que son score.  

En cliquant sur un des jeux nous allons arriver sur une page d�taillant le jeux avec en plus la description  du jeux.  
Je n'ai pas eu le temps de r�cup�rer plus de d�tails sur le jeu car il fallait g�rer beaucoup d'identifiant en plus.  
Un bouton � la fin de la description est disponible pour pouvoir supprimer le jeu.  

En revenant en arri�re nous atterrissons sur la premi�re page. 
Un bouton flottant permet de lancer une nouvelle page o� l'on va pouvoir faire une recherche de jeu.  
Une barre de recherche est disponible en cliquant dessus et en remplissant le texte  nous allons pouvoir retrouver une liste de jeu  qui correspond au texte rempli.  
Cette recherche utilise l'API IGDB qui est une grande base de donn�es pour les jeux vid�os. 
En cliquant sur un des jeux de la liste , le jeu va s'ajouter � notre liste de jeu d�ja sauvegarder.  

# Conception

Pour afficher une liste de jeux j'utilise un fragment avec une recyclerview et un adapter pour la vue de la liste. (GamesFragment, GameAdapter, MainActivity).  
J'utilise un navigateur pour aller de fragment en fragment.  
En cliquant sur un des items de la liste , une action est produite et avec le navigateur je peux aller de la liste jusqu'� la page de d�tail du jeu (GameDetailFragment).  
Pour la recherche, j'utilise une searchview pour la barre de recherche,  pour la liste une recyclerview avec un adapter.(GameSearchAdapter,SearchActivity).  
J'utilise retrofit qui permet de faire des requ�tes sur une API avec un interface qui permet de faire les requ�tes.  
J'utilise room pour sauvegarder mes jeux en base de donn�es.  


 



