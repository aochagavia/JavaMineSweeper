package command;

import board.Board;

public class MarkCommand implements Command {
    int x, y;

    public MarkCommand(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void execute(Board board) {
        board.markCell(this.x, this.y);
    }
}
