# Réponses aux questions
#####  Reiner Killian

## Partie _Solution Anti Pattern_
### Question 3
Trois points des principes SOLID ne sont pas respectés :
* SRP : La classe Sudoku a plusieurs responsabilités, telles que la lecture de fichiers, la validation des valeurs, la mise à jour du plateau de jeu, l'affichage du plateau de jeu, la demande de coordonnées à l'utilisateur et la demande de valeur à l'utilisateur. Ces responsabilités pourraient être mieux séparées en plusieurs classes distinctes.
* OCP : La classe Sudoku n'est pas fermée à la modification, car elle est susceptible de changer à chaque fois qu'une nouvelle fonctionnalité est ajoutée (par exemple, une nouvelle validation pour les valeurs saisies par l'utilisateur).
* DIP : La classe Sudoku dépend directement de plusieurs classes concrètes (BufferedReader, FileReader, Scanner), plutôt que d'interagir avec elles par l'intermédiaire d'interfaces. Cela rend la classe Sudoku plus difficile à tester et à réutiliser dans d'autres contextes.

### Question 4
Éléments qui pourraient appartenir à la partie modèle :

* La grille de sudoku en elle-même, stockée dans la variable grid.
* Les méthodes pour initialiser la grille (Constructeur), pour vérifier si un chiffre est valide (is_valid), pour remplir une case (fill_cell) et pour vider une case (empty_cell).
* La méthode solve qui permet de résoudre la grille de sudoku.

Éléments qui pourraient appartenir à la partie vue :
* Les méthodes pour afficher la grille (toString()) et pour afficher une erreur (display_error).
* La méthode input_grid qui permet de demander à l'utilisateur d'entrer une grille de sudoku.
* La méthode play qui permet d'interagir avec l'utilisateur pour remplir ou vider des cases de la grille.

## Partie MVC
## Observateur 
### Question 1
L'entité modèle :
* Gère la logique du jeu Sudoku, en maintenant l'état du jeu et en validant les entrées de l'utilisateur.
* Fournit des méthodes pour résoudre le Sudoku et pour vérifier si le Sudoku est résolu.

L'entité vue:
* Affiche le jeu Sudoku à l'utilisateur et permet à l'utilisateur de saisir des entrées.
* Fournit des méthodes pour lire les entrées de l'utilisateur et afficher l'état du jeu.

Pour séparer la classe Sudoku en une entité vue et une entité modèle, on peut donc créer deux classes distinctes :
* La classe SudokuModel qui contient les méthodes de la partie modèle. Cette classe est responsable de la logique du jeu et de la gestion de l'état du Sudoku.
* La classe SudokuView qui contient les méthodes de la partie vue. Cette classe est responsable de l'affichage du Sudoku et de la saisie des entrées de l'utilisateur.

### Question 2
Pour utiliser le pattern Observateur dans ce contexte, nous allons créer une interface Observer qui définira une méthode update que chaque vue du Sudoku implémentera. Ensuite, nous allons ajouter une méthode addObserver à la classe Sudoku pour que chaque vue puisse s'inscrire en tant qu'observateur. Enfin, nous allons ajouter une méthode notifyObservers à la classe Sudoku pour qu'elle puisse avertir chaque observateur lorsqu'une cellule est mise à jour.

## Controleur

## Strategie
### Question 1
La solution n'est pas encore évolutive car si on veut changer d'algorithme il faut coder une nouvelle classe et changer le fonctionnement dans le code, notamment le code du Controller.