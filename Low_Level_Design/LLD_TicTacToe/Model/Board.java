package Low_Level_Design.LLD_TicTacToe.Model;

import java.util.ArrayList;
import java.util.List;

import Low_Level_Design.LLD_TicTacToe.Util.Pair;

public class Board {
  public int size;
  public PlayingPiece[][] board;

  public Board(int size) {
    this.size = size;
    board = new PlayingPiece[size][size];
  }

  public boolean addPiece(int row, int col, PlayingPiece playingPiece) {
    if(Integer.min(row, col) < 0 || Integer.max(row, col) >= size){
      return false;
    }
    if (board[row][col] != null) {
      return false;
    }

    board[row][col] = playingPiece;
    return true;
  }

  public List<Pair<Integer, Integer>> getFreeSpaces() {
    List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] == null) {
          Pair<Integer, Integer> rowColumn = new Pair<>(i, j);
          freeCells.add(rowColumn);
        }
      }
    }

    return freeCells;
  }

  public void printBoard() {

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (board[i][j] != null) {
          System.out.print(board[i][j].pieceType.name() + "   ");
        } else {
          System.out.print("    ");

        }
        System.out.print(" | ");
      }
      System.out.println();

    }
  }
}
