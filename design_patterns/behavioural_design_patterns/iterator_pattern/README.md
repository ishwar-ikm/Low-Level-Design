# Iterator Pattern (Behavioural)

- **Summary:** The Iterator pattern provides a way to access the elements of an aggregate object sequentially
  without exposing its underlying representation. It decouples the client from the collection implementation
  and allows multiple traversal strategies.

## Problem & Motivation

Collections such as lists, trees, or playlists often need to be traversed in different ways.
If the client code knows about the internal structure (indices, pointers, etc.) it becomes
tightly coupled and any change to the collection forces changes everywhere it’s used.  
The Iterator pattern addresses this by providing a `Iterator` interface that encapsulates the
traversal logic.

In our example, a `Playlist` holds songs. The bad implementation:

* exposes internal array/list to the caller,
* forces the client to manage indexes,
* doesn’t support more than one traversal at a time,
* and can’t easily provide alternative orders (shuffled, favourites only, …).

## When to Use

- You need to traverse a complex aggregate without exposing its representation.
- You want to support different traversal algorithms (forward, backward, random, filtered).
- Multiple clients may iterate over the same collection simultaneously.
- You want to hide the iteration logic so that the collection class can change freely.

## Trade‑offs / Drawbacks

* **Overhead:** creating iterator objects introduces a small object-creation cost.
* **Complexity:** many iterator classes may be required for different traversal strategies.
* **Encapsulation leaks:** careless iterator implementations can still expose mutable state.

## This Folder Demonstrates

### Bad Code

`bad_code/Playlist.java` implements its own loop inside the collection and exposes
the song list:

```java
public class Playlist {
    private String[] songs = { … };

    public void playAll() {
        for (int i = 0; i < songs.length; i++) {
            System.out.println("Playing " + songs[i]);
        }
    }
}
```

* Clients can only “play all”; they cannot choose a subset or a different order.
* The iteration code is embedded in the playlist class, violating single‑responsibility.
* You cannot have two independent traversals at once without copying the data.

### Good Code

A `Iterator` interface in `good_code/Iterator.java`:

```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}
```

The subject (`Playlist`, implicitly) offers a factory method that returns an
`Iterator` object; the client never touches the underlying collection.

Three concrete iterators show how to vary traversal:

* `SimpleIterator` – sequential traversal.
* `FavSongIterator` – only favourite tracks.
* `ShuffledIterator` – random order (defensive copy of the list).

Each iterator holds its own state, so multiple iterators can iterate the same
playlist independently. New traversal strategies are added by creating new
iterator classes; `Playlist` remains unchanged.

`good_code/Main.java` demonstrates usage:

```java
Playlist playlist = new Playlist(List.of("One", "Two", "Three", "Four"));

Iterator<String> it1 = playlist.simpleIterator();
Iterator<String> it2 = playlist.favSongIterator();
Iterator<String> it3 = playlist.shuffledIterator();

// iterate concurrently, each using its own strategy
```

## Key Differences: Bad vs Good Practice

| Aspect                   | Bad Practice                   | Good Practice                                |
|--------------------------|--------------------------------|----------------------------------------------|
| **Coupling**             | Client depends on concrete list | Client uses abstract iterator interface      |
| **Extensibility**        | Add new behaviour by editing `Playlist` | Add new iterator class                      |
| **Separation of concerns** | Iteration logic in collection | Iteration logic in separate iterator objects |
| **Multiple traversals**  | Not supported                  | Naturally supported                          |
| **Order flexibility**    | Fixed order                    | Easily swapped (`shuffled`, `filtered`, …)   |

## How to Run the Examples

1. Open a terminal in the workspace root.

2. Bad example:

   ```bash
   cd design_patterns/behavioural_design_patterns/iterator_pattern/bad_code
   javac Playlist.java
   java design_patterns.behavioural_design_patterns.iterator_pattern.bad_code.Playlist
   ```

3. Good example:

   ```bash
   cd ../good_code
   javac -d . *.java concrete_iterators/*.java
   java design_patterns.behavioural_design_patterns.iterator_pattern.good_code.Main
   ```

   (ensure `Iterator.java` is on the classpath as well).


## Real‑World Examples

- `java.util.Iterator` and `Iterable` in the JDK.
- `Enumerator` in .NET.
- Cursor objects in databases.
- Stream APIs that under the hood use iterator‑like mechanisms.
