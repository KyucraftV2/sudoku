package pattern;

public class SudokuApp {
    public static void main(String[] args) {
        SudokuModel sudoku = new SudokuModel("");
        SudokuSolver solver = new SudokuSolver();
        solver.solve(sudoku);
    }
}
