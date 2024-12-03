package Low_Level_Design.LLD_TicTacToe;

import java.util.*;

import Low_Level_Design.LLD_TicTacToe.Model.Board;
import Low_Level_Design.LLD_TicTacToe.Model.PieceType;
import Low_Level_Design.LLD_TicTacToe.Model.Player;
import Low_Level_Design.LLD_TicTacToe.Model.PlayingPiece0;
import Low_Level_Design.LLD_TicTacToe.Model.PlayingPieceX;
import Low_Level_Design.LLD_TicTacToe.Util.Pair;

public class TicTacToeGame {
  Deque<Player> players;
  Board gameBoard;

  public TicTacToeGame() {
    initialize();
  }

  public void initialize() {
    players = new LinkedList<>();

    PlayingPieceX cross = new PlayingPieceX();
    Player player1 = new Player("Player 1", cross);

    PlayingPiece0 circle = new PlayingPiece0();
    Player player2 = new Player("Player 2", circle);

    players.add(player1);
    players.add(player2);

    gameBoard = new Board(3);
  }

  public String startGame() {
    boolean noWinner = true;

    while (noWinner) {
      Player playerTurn = players.removeFirst();

      gameBoard.printBoard();
      List<Pair<Integer, Integer>> freeSpaces = gameBoard.getFreeSpaces();

      if (freeSpaces.isEmpty()) {
        noWinner = false;
        break;
      }

      System.out.print("Player: " + playerTurn.name + " enter x,y: ");
      Scanner input = new Scanner(System.in);
      String s = input.nextLine();

      if (!s.matches("\\d+,\\d+")) {
        System.out.println("Invalid input format. Please enter the row and column as 'x,y' (e.g., 1,2).");
        players.addFirst(playerTurn);
        continue;
      }

      String[] values = s.split(",");
      int row = Integer.valueOf(values[0]);
      int col = Integer.valueOf(values[1]);

      boolean placedSuccessfully = gameBoard.addPiece(row, col, playerTurn.playingPiece);

      if (!placedSuccessfully) {
        System.out.println("Incorrect position");
        players.addFirst(playerTurn);
        continue;
      }

      players.addLast(playerTurn);

      boolean winner = isWinner(row, col, playerTurn.playingPiece.pieceType);
      if (winner) {
        return playerTurn.name + " is the winner";
      }
    }

    return "We have a draw";
  }

  public boolean isWinner(int row, int column, PieceType pieceType) {

    boolean rowMatch = true;
    boolean columnMatch = true;
    boolean diagonalMatch = true;
    boolean antiDiagonalMatch = true;

    for (int i = 0; i < gameBoard.size; i++) {

      if (gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
        rowMatch = false;
      }
    }

    for (int i = 0; i < gameBoard.size; i++) {

      if (gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
        columnMatch = false;
      }
    }

    for (int i = 0, j = 0; i < gameBoard.size; i++, j++) {
      if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
        diagonalMatch = false;
      }
    }

    for (int i = 0, j = gameBoard.size - 1; i < gameBoard.size; i++, j--) {
      if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
        antiDiagonalMatch = false;
      }
    }

    return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
  }

}
