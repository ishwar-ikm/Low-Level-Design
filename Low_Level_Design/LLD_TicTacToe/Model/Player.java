package Low_Level_Design.LLD_TicTacToe.Model;

public class Player {
  public String name;
  public PlayingPiece playingPiece;
  
  public Player(String name, PlayingPiece playingPiece){
    this.name = name;
    this.playingPiece = playingPiece;
  }
}