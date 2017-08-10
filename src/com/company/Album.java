package com.company;

import java.util.ArrayList;

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

    private boolean addSong(Song song){
        this.songs.add(song);
        return true;
    }

    public boolean addSong(String title, double duration){
        if (!existingSong(title)){
        return this.songs.add(new Song(title,duration));
        }
        return false;
    }

    private boolean existingSong(String title){
        for (int i = 0; i <songs.size() ; i++) {
            if (songs.get(i).getTitle().equals(title)){
                return true;
            }

        }
        return false;
    }

    public  Song getSong(String title){
        for (int i = 0; i <songs.size() ; i++) {
            if (songs.get(i).getTitle().equals(title)){
                return songs.get(i);
            }

        }
        return null;
    }

    //additional example on fori loop
    private Song findSong(String title){
        for (Song checkedSong:this.songs) {
            if (checkedSong.getTitle().equals(title))
                return checkedSong;
            
        }
        return null;
    }
}
