package pattern;

public class SudokuView implements SudokuObserver{

    private SudokuController controller;

    public SudokuView(SudokuModel m, SudokuController c) {
        controller = c;
    }

    @Override
    public void update(int row, int col, int value) {
        System.out.println("Cell at row " + row + ", column " + col + " updated to " + value);
        display();
    }

    public void display() {
        for (int row = 0; row < controller.getBoardSize(); row++) {
            if (row % controller.getBlockSize() == 0) {
                System.out.println(" -----------------------");
            }
            for (int col = 0; col < controller.getBoardSize(); col++) {
                if (col % controller.getBlockSize() == 0) {
                    System.out.print("| ");
                }
                int value = controller.getValueAt(row, col);
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
