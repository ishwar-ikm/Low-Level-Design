package design_patterns.behavioural_design_patterns.iterator_pattern.good_code.concrete_iterators;

import java.util.List;

import design_patterns.behavioural_design_patterns.iterator_pattern.good_code.Iterator;

public class FavSongIterator implements Iterator {
  List<String> songs;
  int position = 0;
  
  public FavSongIterator(List<String> songs) {
    this.songs = songs;
  }

  @Override
  public boolean hasNext() {
    if(position < songs.size()) {
      if(songs.get(position).contains("Fav")) {
        return true;
      } else {
        position++;
        return hasNext();
      }
    }
    return false;
  }

  @Override
  public String next() {
    if (hasNext()) {
      return songs.get(position++);
    }
    throw new RuntimeException("No more songs");
  }
}
