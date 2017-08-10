package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedList<Song> playList = new LinkedList<Song>();

        Album Once = new Album("Once");
        Once.addSong("Even flow", 3.3d);
        Once.addSong("Jeremy", 2.3d);
        Once.addSong("Break", 1.45d);

        Album Jump = new Album("Jump");
        Jump.addSong("Jump", 2.3d);
        Jump.addSong("Frozen", 6.3d);
        Jump.addSong("Even", 5.32d);

        addSongToPlaylist(playList, Jump.getSong("Jump"));
        addSongToPlaylist(playList, Once.getSong("Jeremy"));
        addSongToPlaylist(playList, Jump.getSong("Frozen"));
        addSongToPlaylist(playList, Jump.getSong("Even"));

        //displayList(playList);
        Once.listSongs();
        Once.addToPlayList(3,playList);
        Once.addToPlayList("Even flow",playList);
        playPlaylist(playList);


    }

    private static boolean addSongToPlaylist(LinkedList<Song> playList, Song song) {
        ListIterator<Song> listIterator = playList.listIterator();
        if (song != null) {
            while (listIterator.hasNext()) {
                if (listIterator.next() == song) {
                    //do not add
                    System.out.println("Song already in the list");
                    return false;
                }

            }
            listIterator.add(song);
            return true;
        } else {
            //song not found
            System.out.println("Song is not found in album");
            return false;
        }
    }

    private static void displayList(LinkedList<Song> playList) {
        ListIterator<Song> listIterator = playList.listIterator();
        System.out.println("Playlist for you:");

        while (listIterator.hasNext()) {
            System.out.println(listIterator.next().getTitle());
        }
    }


    private static void playPlaylist(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean forward = true;
        boolean quit = false;

        ListIterator<Song> listoperator = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("No songs to play");
        } else {

            System.out.println("Now playing: " + listoperator.next().getTitle());
            displayMenu();
        }
        while (!quit) {
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    //display menu options
                    displayMenu();
                    break;

                case 1:
                    //replay current song
                    if (!forward) {
                        if (listoperator.hasNext()) {
                            listoperator.next();
                            forward = true;
                        }
                    }
                    if (listoperator.hasNext()) {
                        System.out.println("Now playing: " + listoperator.next().getTitle());
                    } else {
                        System.out.println("End of the playlist reached.");
                    }
                    break;
                case 2:
                    //next song
                    if (!forward) {
                        if (listoperator.hasNext()) {
                            listoperator.next();
                            forward = true;
                        }
                    }
                    if (listoperator.hasNext()) {
                        System.out.println("Now playing: " + listoperator.next().getTitle());
                    } else {
                        System.out.println("End of the playlist reached.");
                        forward = false;
                    }
                    break;

                case 3:
                    //previous song
                    if (forward) {
                        listoperator.previous();
                        forward = false;
                    }
                    if (listoperator.hasPrevious()) {
                        System.out.println("Now playing: " + listoperator.previous().getTitle());

                    } else {
                        System.out.println("Beginning of the playlist reached.");
                        forward = true;
                    }
                    break;
                case 4:
                    //remove song from list
                    //System.out.println("Removed " + listoperator.+ " from playlist.");

                    //listoperator.remove();
                    //listoperator.next();

                    if (forward) {
                        listoperator.previous();
                        forward = false;
                    }
                    if (listoperator.hasPrevious()) {
                        listoperator.previous();
                        System.out.println("Remove song: " + listoperator.next().getTitle());
                        listoperator.remove();
                    } else {
                        listoperator.next();
                        listoperator.previous();
                        System.out.println("Remove song: " + listoperator.next().getTitle());
                        listoperator.remove();
                    }

                    break;

                case 8:
                    displayList(playlist);
                    break;


                case 9:
                    //quit
                    quit = true;
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("Options:\n");
        System.out.println("0 - display options\n");
        System.out.println("1 - replay song\n");
        System.out.println("2 - next song\n");
        System.out.println("3 - previous song\n");
        System.out.println("4 - remove song\n");
        System.out.println("8 - display songlist\n");
        System.out.println("9 - quit\n");
        System.out.println("Your choide:");
    }

}

