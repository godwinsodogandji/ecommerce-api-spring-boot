### Objectif de la Classe `Matrix`

L'objectif de la classe `Matrix` est de fournir une structure de données générique qui permet de stocker et de manipuler une matrice d'éléments de tout type. La classe doit permettre les opérations de base sur une matrice, telles que la récupération, la modification, le remplacement de lignes, l'échange d'éléments, et la conversion en tableau de chaînes de caractères.

### Étapes pour Développer la Classe `Matrix`

1. **Définir la Structure de Données**

   - Utiliser un tableau 2D d'objets (`Object[][]`) pour stocker les éléments de la matrice.

2. **Implémenter le Constructeur**

   - Initialiser la matrice avec les dimensions données (nombre de lignes et de colonnes).
   - Remplir la matrice avec des valeurs nulles par défaut.

3. **Ajouter la Méthode `get`**

   - Permettre de récupérer l'élément à une position spécifique (i, j) en utilisant des indices 1-indexés.
   - Effectuer la conversion appropriée pour retourner l'élément dans le type générique.

4. **Ajouter la Méthode `set`**

   - Permettre de définir ou de mettre à jour l'élément à une position spécifique (i, j).
   - Assurer que les indices sont valides.

5. **Ajouter la Méthode `setRow`**

   - Permettre de définir les éléments d'une ligne entière en fournissant un tableau de valeurs.
   - Vérifier que la taille du tableau correspond au nombre de colonnes de la matrice.

6. **Ajouter la Méthode `swap`**

   - Permettre d'échanger les éléments entre deux positions spécifiées dans la matrice.

7. **Ajouter la Méthode `toArray`**

   - Convertir la matrice en un tableau 2D de chaînes de caractères pour chaque élément, avec la gestion des valeurs nulles.

8. **Ajouter des Méthodes de Validation**
   - Inclure des méthodes pour valider les indices (lignes et colonnes) afin de prévenir les erreurs d'accès hors limites.

```java
public class Matrix<E> {
    private final Object[][] data;  // Tableau de données qui stocke les éléments de la matrice

    /**
     * Constructeur de la classe Matrix.
     * Initialise la matrice avec des dimensions données et remplit toutes les cases avec null.
     *
     * @param rows le nombre de lignes de la matrice
     * @param cols le nombre de colonnes de la matrice
     */
    public Matrix(int rows, int cols) {
        data = new Object[rows][cols];  // Crée une matrice de dimensions spécifiées
    }

    /**
     * Récupère l'élément à la position (i, j) de la matrice.
     *
     * @param i l'indice de la ligne (1-indexé)
     * @param j l'indice de la colonne (1-indexé)
     * @return l'élément à la position (i, j)
     */
    @SuppressWarnings("unchecked")
    public E get(int i, int j) {
        validateIndices(i, j);
        return (E) data[i - 1][j - 1];
    }

    /**
     * Remplace l'élément à la position (i, j) de la matrice par une nouvelle valeur.
     *
     * @param i l'indice de la ligne (1-indexé)
     * @param j l'indice de la colonne (1-indexé)
     * @param value la nouvelle valeur à placer à la position (i, j)
     */
    public void set(int i, int j, E value) {
        validateIndices(i, j);
        data[i - 1][j - 1] = value;
    }

    /**
     * Définit le contenu de la ligne i avec un tableau d'éléments.
     *
     * @param i l'indice de la ligne (1-indexé)
     * @param values tableau des valeurs à placer dans la ligne
     */
    public void setRow(int i, E... values) {
        validateRowIndex(i);
        if (values.length != data[0].length) {
            throw new IllegalArgumentException("La taille du tableau ne correspond pas au nombre de colonnes.");
        }
        for (int j = 0; j < values.length; j++) {
            data[i - 1][j] = values[j];
        }
    }

    /**
     * Échange les éléments à deux positions différentes dans la matrice.
     *
     * @param i1 l'indice de la ligne du premier élément (1-indexé)
     * @param j1 l'indice de la colonne du premier élément (1-indexé)
     * @param i2 l'indice de la ligne du deuxième élément (1-indexé)
     * @param j2 l'indice de la colonne du deuxième élément (1-indexé)
     */
    public void swap(int i1, int j1, int i2, int j2) {
        validateIndices(i1, j1);
        validateIndices(i2, j2);
        E temp = get(i1, j1);
        set(i1, j1, get(i2, j2));
        set(i2, j2, temp);
    }

    /**
     * Convertit la matrice en un tableau 2D de chaînes de caractères.
     */
    public String[][] toArray() {
        int rows = data.length;
        int cols = data[0].length;
        String[][] result = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = (data[i][j] != null) ? data[i][j].toString() : "null";
            }
        }
        return result;
    }

    // Méthode pour valider les indices de ligne et de colonne
    private void validateIndices(int i, int j) {
        if (i < 1 || i > data.length || j < 1 || j > data[0].length) {
            throw new IndexOutOfBoundsException("Indices hors limites.");
        }
    }

    // Méthode pour valider l'indice de ligne
    private void validateRowIndex(int i) {
        if (i < 1 || i > data.length) {
            throw new IndexOutOfBoundsException("Indice de ligne hors limites.");
        }
    }
}
```

### Objectif

Nous devons déterminer le nombre minimum de cassures (ou segments) nécessaires pour réarranger une barre de chocolat, représentée par une séquence d'éléments, pour correspondre à un autre ordre donné. Les éléments peuvent être réarrangés en les repositionnant après les avoir cassés en morceaux.

### Étapes pour résoudre le problème

1. **Créer un Mapping des Positions :**

   - Créez une carte (un dictionnaire) pour associer chaque portrait de `secondBar` à sa position (indice).

2. **Transformer la Barre Initiale :**

   - Utilisez la carte pour transformer `firstBar` en un tableau d'indices, où chaque indice représente la position de l'élément de `firstBar` dans `secondBar`.

3. **Trouver la Longue Sous-Séquence Croissante :**

   - Trouvez la longueur de la plus longue sous-séquence croissante dans ce tableau d'indices. Cette sous-séquence représente la partie de `firstBar` qui est déjà dans l'ordre correct par rapport à `secondBar`.

4. **Calculer le Nombre de Cassures :**
   - Le nombre minimum de cassures nécessaires est donné par la différence entre le nombre total d'éléments Longue Sous-Séquence Croissante et la longueur. Chaque segment qui n'est pas inclus dans la Longue Sous-Séquence Croissante doit être cassé pour pouvoir le réarranger.

### Implementation en Java

Voici le code Java correspondant :

```java


import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class Solution {
    public static int chocolate(int N, int[] firstBar, int[] secondBar) {
        // Créer une carte des positions des portraits dans secondBar
        Map<Integer, Integer> positionMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            positionMap.put(secondBar[i], i);
        }

        // Transformer firstBar en tableau d'indices basés sur secondBar
        int[] transformedArray = new int[N];
        for (int i = 0; i < N; i++) {
            transformedArray[i] = positionMap.get(firstBar[i]);
        }

        // Trouver la longueur de la Longue Sous-Séquence Croissante
        int lisLength = findLISLength(transformedArray);

        // Calculer le nombre minimum de cassures nécessaires
        return N - lisLength;
    }

    private static int findLISLength(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;

        // LIS stocke la fin de chaque sous-séquence croissante trouvée
        int[] lis = new int[n];
        int length = 0;

        for (int num : arr) {
            // Trouver la position d'insertion pour `num`
            int pos = Arrays.binarySearch(lis, 0, length, num);
            if (pos < 0) pos = -(pos + 1); // Binary search retourne -(point d'insertion) - 1

            // Mettre à jour la fin de la sous-séquence croissante trouvée
            lis[pos] = num;
            if (pos == length) length++;
        }

        return length;
    }
}

```
