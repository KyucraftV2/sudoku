package pattern;

public class SudokuView implements SudokuObserver{

    @Override
    public void update(int row, int col, int value, SudokuModel model) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        display(model);
    }

    public void display(SudokuModel model) {
        for (int row = 0; row < model.getBoardSize(); row++) {
            if (row % model.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < model.getBoardSize(); col++) {
                if (col % model.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = model.getValueAt(row, col);
                if (value == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println("|");
        }
        System.out.println(" -----------------------");
    }
}
