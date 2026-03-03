package design_patterns.behavioural_design_patterns.iterator_pattern.good_code;

import java.util.List;

import design_patterns.behavioural_design_patterns.iterator_pattern.good_code.concrete_iterators.FavSongIterator;
import design_patterns.behavioural_design_patterns.iterator_pattern.good_code.concrete_iterators.ShuffledIterator;
import design_patterns.behavioural_design_patterns.iterator_pattern.good_code.concrete_iterators.SimpleIterator;

public class Main {
  public static void main(String[] args) {
    List<String> songs = List.of("Fav Song 1", "Song 2", "Fav Song 3", "Song 4");

    Iterator favSongIterator = new FavSongIterator(songs);
    while(favSongIterator.hasNext()) {
      System.out.println(favSongIterator.next());
    }

    System.out.println("----");
    Iterator simpleIterator = new SimpleIterator(songs);
    while(simpleIterator.hasNext()) {
      System.out.println(simpleIterator.next());
    }

    System.out.println("----");
    Iterator shuffledIterator = new ShuffledIterator(songs);
    while(shuffledIterator.hasNext()) {
      System.out.println(shuffledIterator.next());
    }
  }
}
