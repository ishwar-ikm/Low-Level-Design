package design_patterns.behavioural_design_patterns.iterator_pattern.good_code.concrete_iterators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import design_patterns.behavioural_design_patterns.iterator_pattern.good_code.Iterator;

public class ShuffledIterator implements Iterator {
  private List<String> songs;
  private int position = 0;

  public ShuffledIterator(List<String> songs) {
    this.songs = new ArrayList<>(songs);
    Collections.shuffle(this.songs);
  }

  @Override
  public boolean hasNext() {
    return position < songs.size();
  }

  @Override
  public String next() {
    if (hasNext()) {
      return songs.get(position++);
    }
    throw new RuntimeException("No more songs");
  }
}
