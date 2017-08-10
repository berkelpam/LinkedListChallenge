package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by pauljava on 09/08/2017.
 */
public class Album {
    private String title;
    private ArrayList<Song> songs;

    public Album(String title) {
        this.title = title;
        this.songs = new ArrayList<Song>();
    }

    public String getTitle() {
        return title;
    }

    private boolean addSong(Song song) {
        this.songs.add(song);
        return true;
    }

    public boolean addSong(String title, double duration) {
        if (!existingSong(title)) {
            return this.songs.add(new Song(title, duration));
        }
        return false;
    }

    private boolean existingSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return true;
            }

        }
        return false;
    }

    public Song getSong(String title) {
        for (int i = 0; i < songs.size(); i++) {
            if (songs.get(i).getTitle().equals(title)) {
                return songs.get(i);
            }

        }
        return null;
    }

    //additional example on fori loop
    private Song findSong(String title) {
        for (Song checkedSong : this.songs) {
            if (checkedSong.getTitle().equals(title))
                return checkedSong;

        }
        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;

        if ((index > 0) && (index <= this.songs.size())) {
            playlist.add(this.songs.get(index));
            System.out.println(index + ". " + this.songs.get(index).getTitle() + " - added to playlist.");
            return true;
        }
        System.out.println("This album does not have track number: " + index);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSong(title);
        if (checkedSong != null) {
            playlist.add(checkedSong);
            System.out.println(this.songs.indexOf(checkedSong)+1 + ". " + this.songs.get(this.songs.indexOf(checkedSong)).getTitle() + " - added to playlist.");
            return true;
        }
        System.out.println("This album does not have song: " + title);
        return false;
    }

    public void listSongs() {
        System.out.println("Songs in album " + this.title + ": ");

        for (Song song : this.songs) {
            System.out.println(this.songs.indexOf(song) + 1 + ". " + song.getTitle() + ":" + song.getDuration());
        }
        System.out.println("\n");
    }


}
