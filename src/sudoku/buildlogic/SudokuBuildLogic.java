package sudoku.buildlogic;

import sudoku.computationlogic.GameLogic;
import sudoku.persistence.LocalStorageImpl;
import sudoku.problemdomain.IsStorage;
import sudoku.problemdomain.SudokuGame;
import sudoku.userinterface.IUserInterfaceContract;
import sudoku.userinterface.logic.ControlLogic;

import java.io.IOException;

public class SudokuBuildLogic {

    public static  void build(IUserInterfaceContract.View userInterface)
            throws IOException {
        SudokuGame initialState;
        IsStorage storage = new LocalStorageImpl();

        try {
            initialState = storage.getGameData();
        }catch (IOException e){
            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }
    IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);

        userInterface.setLister(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
