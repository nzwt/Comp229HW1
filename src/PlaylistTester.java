
public class PlaylistTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Testing for Song.java...");
		System.out.println("--------------------------");
		Song s0 = new Song();
		Song s1 = new Song("A");
		Song s2 = new Song("B", s0, s1);
		// should print A -> B -> null
		System.out.println(s2.prev + " -> " + s2 + " -> " + s2.next);

		System.out.println("\n\nTesting for Playlist.java...");
		System.out.println("--------------------------\n");
		System.out.println("Tester 1: ");
		
		Playlist pl = new Playlist();
		// should print 0
		System.out.println("  Playlist.size(): " + pl.size());
		try {
			pl.removeSong(1);
		}
		catch(IndexOutOfBoundsException ex) {
			System.out.println("  removeSong: Index out of bound.");
		}
		try {
			pl.getSong(-9);	
		}
		catch(NullPointerException ex) {
			System.out.println("  getSong: Cannot get from the index.");
		}
		try {
			pl.insertSong("1", 9);	
		}
		catch(IndexOutOfBoundsException ex) {
			System.out.println("  insertSong: Index out of bound.");
		}
		System.out.println("--------------------------\n");
		System.out.println("Tester 2: ");
		for (char i = 100; i < 107; i++) {
			pl.insertSong(i+"");
		}
		// should print Head to tail: d -> e -> f -> g -> h -> i -> j
		// 				Tail to head: j <- i <- h <- g <- f <- e <- d
		System.out.println(pl);
		
		
		System.out.println("--------------------------\n");
		System.out.println("Tester 3: ");
		System.out.println("  insert a to index 0... " + pl.insertSong("a", 0));
		System.out.println("  insert z to the tail... " + pl.insertSong("z"));
		System.out.println("  insert k to index 4... " + pl.insertSong("k", 4));
		System.out.println("\nCurrent playlist: ");
		// should print Head to tail: a -> d -> e -> f -> k -> g -> h -> i -> j -> z
		//              Tail to head: z <- j <- i <- h <- g <- k <- f <- e <- d <- a
		System.out.println(pl);
		
		
		System.out.println("--------------------------\n");
		System.out.println("Tester 4: ");
		System.out.println("  Does the playlist contain d? " + pl.contains("d")); //true
		System.out.println("  Does the playlist contain b? " + pl.contains("b")); // false
		System.out.println("  Does the playlist contain a? " + pl.contains("a")); // true
		System.out.println();
		System.out.println("  e is at index " + pl.getSong("e")); // 2
		System.out.println("  m is at index " + pl.getSong("m")); // -1
		System.out.println("  z is at index " + pl.getSong("z")); // 9
		System.out.println("  a is at index " + pl.getSong("a")); // 0
		System.out.println();
		System.out.println("  Song with name " + pl.getSong(3) + " is at index 3." ); // Song f
		System.out.println("  Song with name " + pl.getSong(6) + " is at index 6." ); // Song h
		System.out.println("  Song with name " + pl.getSong(7) + " is at index 7." ); // Song i
		System.out.println("  Song with name " + pl.getSong(2) + " is at index 2." ); // Song e

		System.out.println("--------------------------\n");
		System.out.println("Tester 5: ");

		System.out.println("  Removing song with name n? " + pl.removeSong("n")); // false
		System.out.println("  Removing song with name a? " + pl.removeSong("a")); // true
		System.out.println("  Removing song with name z? " + pl.removeSong("z")); // true
		System.out.println("  Removing song with name h? " + pl.removeSong("h")); // true

		System.out.println();
		
		System.out.println("  Removing song at index 3? " + pl.removeSong(3)); // true
		System.out.println("  Removing song at index 0? " + pl.removeSong(0)); // true
		System.out.println("  Removing song at index 3? " + pl.removeSong(3)); // true
		System.out.println("\nCurrent playlist: ");
		System.out.println(pl);
		// should print Head to tail: e -> f -> g -> j
		//              Tail to head: j <- g <- f <- e 
				

		System.out.println("--------------------------\n");
		System.out.println("Tester 6: ");
		System.out.println("  Clearing the playlist... " );
		pl.clearPlaylist();
		//should print 0
		System.out.println("  Playlist.size(): " + pl.size());
	}

}
