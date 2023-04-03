package pattern;

public class SudokuController {
    SudokuView vue;
    SudokuModel model;

    public SudokuController(){
        this.model = new SudokuModel("");
        this.vue = new SudokuView(this.model, this);
    }

    public void resoudreSudoku(){
        SudokuSolver s = new SudokuSolver();
        s.solve(this.model);
    }

    public int getValueAt(int row, int col) {
        return model.getValueAt(row,col);
    }

    public int getBoardSize() {
        return model.getBoardSize();
    }

    public int getBlockSize() {
        return model.getBlockSize();
    }
}
