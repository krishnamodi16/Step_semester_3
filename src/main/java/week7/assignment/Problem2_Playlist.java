package week7.assignment;

import java.util.Arrays;

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        if (capacity < 0) {
            capacity = 0;
        }
        songs = new String[capacity];
        songCount = 0;
    }

    public void addSong(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Song title cannot be empty.");
            return;
        }
        if (songCount >= songs.length) {
            System.out.println("Playlist is full.");
            return;
        }
        songs[songCount++] = title;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}

public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        System.out.println("Playlist songs: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}
