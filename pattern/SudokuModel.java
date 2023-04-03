package pattern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SudokuModel {
    private int[][] board;
    private ArrayList<SudokuObserver> listeObserver;

    public SudokuModel(String fileName) {
        try {
            this.listeObserver =new ArrayList<>();
            BufferedReader readerNb = new BufferedReader(new FileReader("dataset/" + fileName));
            BufferedReader reader = new BufferedReader(new FileReader("dataset/" + fileName));
            int boardSize = (int) readerNb.lines().count();
            this.board = new int[boardSize][boardSize];
            int row = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                int column = 0;
                String[] lineData = line.split(";");
                for (String data : lineData) {
                    int value = Integer.parseInt(data);
                    this.board[row][column] = value;
                    column++;
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getValueAt(int row, int col) {
        return board[row][col];
    }

    public boolean isValueValid(int row, int col, int value) {
        // Check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == value) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == value) {
                return false;
            }
        }

        // Check region
        int regionSize = (int) Math.sqrt(board.length);
        int rowRegionStart = (row / regionSize) * regionSize;
        int colRegionStart = (col / regionSize) * regionSize;
        for (int i = rowRegionStart; i < rowRegionStart + regionSize; i++) {
            for (int j = colRegionStart; j < colRegionStart + regionSize; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    public void setValueAt(int row, int col, int value) {
        board[row][col] = value;
        notifySu(row, col, value);
    }

    public int getBoardSize() {
        return board.length;
    }


    public int getBlockSize() {

        return (int) Math.sqrt(board[0].length);
    }

    /*
    isGameFinished vérifie si toutes les cellules de la grille ont une valeur
    différente de zéro, ce qui signifie que le jeu est terminé. Si une cellule
    a une valeur de zéro, cela signifie qu'elle est vide et donc que le jeu n'est pas terminé.
     */
    public boolean isGameFinished() {
        for (int i = 0; i < this.getBoardSize(); i++) {
            for (int j = 0; j < this.getBoardSize(); j++) {
                int value = getValueAt(i, j);
                if (value == 0 || !isValueValid(i, j, value)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addObserver(SudokuObserver obs){
        this.listeObserver.add(obs);
    }

    public void notifySu(int row, int col, int value){
        for(SudokuObserver o : listeObserver){
            o.update(row,col,value,this);
        }
    }
}
