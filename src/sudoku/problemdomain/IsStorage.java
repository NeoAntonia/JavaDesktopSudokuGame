package sudoku.problemdomain;

import java.io.IOException;

public interface IsStorage {
    void updateGameData(SudokuGame game) throws IOException;
    SudokuGame getGameData() throws IOException;

}
