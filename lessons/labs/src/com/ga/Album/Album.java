package com.ga.Album;
/**
 * ⏱️ Estimated Time: 30 minutes
 *
 * You will build a class to model a music album and navigate through its songs.
 *
 * 🔧 Properties
 * artistName (string)
 * albumName (string)
 * songs (array/list of strings)
 * currentSong (one of the songs)
 * 🛠️ Methods
 * nextSong() → prints the next song
 * previousSong() → prints the previous song
 * 🧩 Getters & Setters
 * Create getters and setters for:
 *
 * artistName
 * albumName
 * son
 *
 *
 */
import java.util.List;

public class Album {
    private String artistName;
    private String albumName;
    private List<String> songs;
    private int currentIndex = 0;


    public Album(String artistName, String albumName, List<String> songs) {
        this.artistName = artistName;
        this.albumName = albumName;
        this.songs = songs;
    }


    public String getArtistName() {
        return artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public List<String> getSongs() {
        return songs;
    }

    public String getCurrentSong() {
        if (songs.isEmpty()) return null;
        return songs.get(currentIndex);
    }


    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
        this.currentIndex = 0;
    }


    public void nextSong() {
        if (songs.isEmpty()) return;
        currentIndex = (currentIndex + 1) % songs.size();
        System.out.println("Now playing: " + getCurrentSong());
    }

    public void previousSong() {
        if (songs.isEmpty()) return;
        currentIndex = (currentIndex - 1 + songs.size()) % songs.size();
        System.out.println("Now playing: " + getCurrentSong());
    }

    public static void main(String[] args) {
        List<String> songs = List.of("Yellow", "Trouble", "Shiver");
        Album album = new Album("Coldplay", "Parachutes", songs);

        System.out.println(album.getCurrentSong());
        album.nextSong();
        album.nextSong();
        album.nextSong();
        album.previousSong();
    }
}