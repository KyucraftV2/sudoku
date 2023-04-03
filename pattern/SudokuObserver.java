package pattern;

public interface SudokuObserver {
    public void update(int row,int col, int value, SudokuModel model);
}
