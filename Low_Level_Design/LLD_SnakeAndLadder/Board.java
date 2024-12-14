package Low_Level_Design.LLD_SnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
  Cell[][] cells;

  Board(int boardSize, int numSnakes, int numLadders) {
    initializeCells(boardSize);
    addSnakesLadders(cells, numSnakes, numLadders);
  }

/**
 * Initializes the board with a grid of empty cells.
 * 
 * @param boardSize the size of the board (number of rows and columns).
 */
  private void initializeCells(int boardSize) {
    cells = new Cell[boardSize][boardSize];
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        cells[i][j] = new Cell();
      }
    }
  }

/**
 * Randomly adds snakes and ladders to the board.
 * The head of each snake/ladder is randomly selected from the board and the
 * tail is also randomly selected, ensuring that the tail is lower than the
 * head. The process is repeated until the desired number of snakes and
 * ladders have been added.
 * @param cells the cells of the board
 * @param numSnakes the number of snakes to add
 * @param numLadders the number of ladders to add
 */
  private void addSnakesLadders(Cell[][] cells, int numSnakes, int numLadders) {
    while (numSnakes > 0) {
      int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
      int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

      if (snakeTail >= snakeHead) {
        continue;
      }

      Jump snakeObj = new Jump();
      snakeObj.start = snakeHead;
      snakeObj.end = snakeTail;

      Cell cell = getCell(snakeHead);
      cell.jump = snakeObj;

      numSnakes--;
    }

    while(numLadders > 0) {
      int ladderStart = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);
      int ladderEnd = ThreadLocalRandom.current().nextInt(1, cells.length * cells.length - 1);

      if (ladderEnd <= ladderStart) {
        continue;
      }

      Jump ladderObj = new Jump();
      ladderObj.start = ladderStart;
      ladderObj.end = ladderEnd;

      Cell cell = getCell(ladderStart);
      cell.jump = ladderObj;

      numLadders--;
    }
  }

  /**
   * Returns the cell at the given player position on the board.
   * @param playerPosition the position of the player on the board
   * @return the cell at the given player position
   */
  Cell getCell(int playerPosition) {
    int boardRow = playerPosition / cells.length;
    int boardColumn = (playerPosition % cells.length);
    return cells[boardRow][boardColumn];
  }

}
