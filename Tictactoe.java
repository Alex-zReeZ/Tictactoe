package fr.isae.morpion.model;

public class Morpion {
    public final static int NEUTRE = 0;
    public final static int CROIX = 1;
    public final static int ROND = 2;

    private int[][] cases;
    private int joueur;
    private int numbers_try;

    public Morpion() {
        cases = new int[3][3];
        joueur = CROIX;
    }

    public void reset() {               //try again function
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cases[i][j] = NEUTRE;
            }
        }
        joueur = CROIX;
        numbers_try = 0;
    }

    public boolean setCase(int i, int j) {
        if (i >= 0 && i < 3 && j >= 0 && j < 3 && cases[i][j] == NEUTRE) {
            cases[i][j] = joueur;
            numbers_try++;

            if (gagne(i, j)) {
                return true;
            }
            joueur = (joueur == CROIX ? ROND : CROIX);
        }
        return false;
    }

    private boolean gagne(int i, int j) {
        return ((cases[i][0] == cases[i][1] && cases[i][1] == cases[i][2]) ||
                (cases[0][j] == cases[1][j] && cases[1][j] == cases[2][j]) ||
                (i == j && cases[0][0] == cases[1][1] && cases[1][1] == cases[2][2]) ||
                (i + j == 2 && cases[0][2] == cases[1][1] && cases[1][1] == cases[2][0]));
    }

    public int getJoueur() {
        return joueur;
    }

    public int getNumbers_try() {
        return numbers_try;
    }
}
