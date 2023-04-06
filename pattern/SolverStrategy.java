package pattern;

public interface SolverStrategy {
    public boolean solve(SudokuModel sudoku);
    private boolean solveCell(int row, int column, SudokuModel sudoku){return false;}
}
