package Low_Level_Design.LLD_SnakeAndLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
  Board board;
  Dice dice;
  Deque<Player> players = new LinkedList<>();
  Player winner;

  public Game() {
    initialize();
  }

  /**
   * Initializes the game by setting up the board, dice, and players.
   * This method is called when a new Game object is created.
   */
  private void initialize() {
    board = new Board(10, 5, 4);
    dice = new Dice(1);
    winner = null;
    addPlayers();
  }

  /**
   * Adds two players to the game, with initial positions of 0.
   * This method is called when a new Game object is created.
   */
  private void addPlayers() {
    Player player1 = new Player("Player 1", 0);
    Player player2 = new Player("Player 2", 0);
    players.add(player1);
    players.add(player2);
  }

  /**
   * Starts the game by initializing the game loop.
   * This method is the main entry point for the game.
   * The game loop continues until a player reaches the end of the board (winning condition),
   * at which point the loop exits and the winner is printed to the console.
   * The game loop involves the following steps for each player turn:
   * - Get the current player from the player queue.
   * - Roll the dice and add the result to the player's current position.
   * - Check if the player jumped over a snake or ladder and update the player's position accordingly.
   * - Print the updated player position to the console.
   * - Check if the player reached the end of the board (winning condition).
   */
  public void startGame() {
    while (winner == null) {
      Player playerTurn = findPlayerTurn();
      System.out.println("player turn is:" + playerTurn.id + " current position is: " + playerTurn.currentPosition);

      int diceNumber = dice.rollDice();

      int newPosition = jumpCheck(playerTurn.currentPosition + diceNumber);
      playerTurn.currentPosition = newPosition;

      System.out.println("player turn is:" + playerTurn.id + " new Position is: " + newPosition);
      // check for winning condition
      if (newPosition >= board.cells.length * board.cells.length - 1) {
        winner = playerTurn;
      }
    }
    System.out.println("WINNER IS:" + winner.id);
  }

  /**
   * Finds the player who's turn it is and moves them to the end of the player queue.
   * @return the player who's turn it is
   */
  private Player findPlayerTurn() {
    Player playerTurn = players.removeFirst();
    players.addLast(playerTurn);
    return playerTurn;
  }

  /**
   * Checks if the player jumped over a snake or ladder.
   * If the player jumped over a snake or ladder, the player's position is updated accordingly.
   * @param playerPosition the current player position
   * @return the updated player position
   */
  private int jumpCheck(int playerPosition) {
    if (playerPosition > board.cells.length * board.cells.length - 1) {
      return playerPosition;
    }

    Cell cell = board.getCell(playerPosition);
    if (cell.jump != null && cell.jump.start == playerPosition) {
      String jumpBy = (cell.jump.start < cell.jump.end) ? "ladder" : "snake";
      System.out.println("jump done by: " + jumpBy);
      return cell.jump.end;
    }
    return playerPosition;
  }
}
