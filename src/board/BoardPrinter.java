package board;

import java.io.PrintStream;

public class BoardPrinter {
    Board board;

    public BoardPrinter(Board board) {
        this.board = board;
    }

    public void print(PrintStream stream) {
        // Column numbers
        stream.print("     ");
        for (int x = 0; x < this.board.width; x++) {
            // Spaces before each column number
            String spaces = x < 9 ? "  " : " ";
            stream.print(spaces);
            stream.print(x + 1);
        }

        // A horizontal line to separate the column numbers from the board
        int length = 3 * this.board.width;
        StringBuilder hLine = new StringBuilder();
        for (int i = 0; i < length; i++)
            hLine.append('_');

        stream.println();
        stream.print("     ");
        stream.println(hLine);

        // The vertical coordinate numbers are mixed with the printing of the board itself
        for (int y = 0; y < this.board.height; y++) {
            // Vertical coordinates
            String spaces = y < 9 ? "  " : " ";
            stream.print(spaces);
            stream.print(y + 1);

            // Horizontal line
            stream.print(" |");

            // Board row
            for (int x = 0; x < this.board.width; x++) {
                Cell cell = this.board.cell(x, y);

                // Mark
                if (cell.isMarked())
                    stream.print("  #");

                // Hidden
                else if (!cell.isShown())
                    stream.print("  *");

                // Shown mine
                else if (cell.isMine())
                    stream.print("  X");

                // Shown empty cell
                else if (cell.number == 0)
                    stream.print("   ");

                // Shown number
                else
                    stream.print("  " + cell.number);
            }

            stream.print("\n\n");
        }
    }
}
