public class Playlist extends Object
{
    //used to keep track of the first song in the playlist
    public Song head;
    //used to keep track of how many songs exist
    //more space efficient than looping through the list
    public int songCount;

    public Playlist()
    {

    }
    //sets the starting song in the playlist to null, therefore eliminating the list
    public void clearPlaylist()
    {
        head = null;
        this.songCount = 0;
    }

    public boolean contains(String name)
    {
        boolean returner = false;
        Song current = head;
        while (current.next != null)
        {
            if(current.toString() == name)
            {
                returner = true;
            }
            current = current.next;
        }
        return returner;
    }

    public Song getSong(int pos)
    {
        Song current = head;
        //what happens when pos is zero here?
        for (int i = 0; i < pos; i++)
        {
            current = current.next;
        }
        return current;
    }

    public int getSong(String name)
    {
        //what should I return if this isnt found?
        Song current = head;
        //checks if first Song is the one you want
        if(contains(name) == false)
        {
            return -1;
        }
        int indexer=0;
        while (current.next != null)
        {
            if(current.toString() == name)
            {
             break;
            }
            indexer++;
            current = current.next;
        }
        return indexer;

    }

    //default adds to end of playlist
    public boolean insertSong(String name)
    {
        Song current = head;
        if(current == null)
        {
            head = new Song(name);
        }
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            Song newSong = new Song(name , null , current);
            current.next = newSong;
        }

        //increment song count because song added
        this.songCount++;
        return true;
    }

    //adds to a specific pos in playlist
    public boolean insertSong(String name, int pos)
    {
        if (this.songCount < 1)
            return false;
        Song current = head;
        for (int i = 0 ; i < pos ; i++ )
        {
            current = current.next;
        }
        //makes a new song to put in the new index and changes prev of the song
        //ahead and next of the song before
        Song tempNext = current.next;
        Song newSong = new Song(name, tempNext , current);
        current.next = newSong;
        tempNext.prev = newSong;

        //increment song count because song added
        this.songCount++;
        return true;

    }

    public int size()
    {
        return this.songCount;
    }

    public boolean removeSong(int pos)
    {
        Song current = head;
        if(this.songCount == 0)
            return false;
        for (int i = 0 ; i < pos-1 ; i++ )
        {
            current = current.next;
        }
        //checks if this is the last song on the playlist

        if(current.next.next == null)
        {
            current.next = null;
            return true;
        }
        current.next = current.next.next;
        current.next.prev = current;


        this.songCount--;
        return true;

    }

    public boolean removeSong(String name)
    {
        int pos = getSong(name);
        if(pos != -1)
        {
            return removeSong(pos);
        }
        return false;
    }

    public String toString()
    {
        String returner = "Head to Tail: ";
        Song current = head;
        //do i include the text "head to tail?"
        if(head != null)
            returner += current;
        while (current.next != null)
        {
            current = current.next;
            returner = returner + " -> " + current;
        }
        returner += "\nTail to Head: " + current;
        while (current.prev != null) {
            current = current.prev;
            returner = returner + " <- " + current;

        }
        return returner;
    }

    public String toHTMLString()
    {
        Song current = head;
        String returner = "<html>" + current;
        while (current.next != null)
        {
            current = current.next;
            returner = returner + "<br/>" + current;
        }
        returner += "</html>";
        return returner;

    }

}
