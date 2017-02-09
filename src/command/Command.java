package command;

import board.Board;

public interface Command {
    void execute(Board board);
}
