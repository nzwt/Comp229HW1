public class Song extends Object
{
    //instance variables
    public String name;
    public Song next;
    public Song prev;

    //default constructor
    Song()
    {

    }
    //constructor with song name
    Song(String name)
    {
        this.name = name;
    }
    //constructor with song name, specific next song and prev song
    Song(String name, Song next, Song prev)
    {
        this.name = name;
        this.next = next;
        this.prev = prev;

    }

    public String toString()
    {
        return name;
    }
}
