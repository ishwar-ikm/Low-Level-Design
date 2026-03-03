package design_patterns.behavioural_design_patterns.iterator_pattern.bad_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Playlist {
  private List<String> songs;
  public Playlist(List<String> songs) {
    this.songs = songs;
  }

  public void addSong(String song) {
    songs.add(song);
  }

  public void playPlaylist(String mode) {
    switch (mode) {
      case "normal":
        for (String song : songs) {
          System.out.println("Playing: " + song);
        }
        break;
      case "shuffle":
          List<String> shuffledSongs = new ArrayList<>(songs);
          Collections.shuffle(shuffledSongs);
          for (String song : shuffledSongs) {
            System.out.println("Playing: " + song);
          }
        break;
      default:
        System.out.println("Invalid mode: " + mode);
        break;
    }
  }
}
