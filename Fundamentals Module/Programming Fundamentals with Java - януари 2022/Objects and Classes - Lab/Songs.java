package bg.softuni.ObjectsАndClassesLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Songs {
    static class Song {
        private String typeList;
        private String name;
        private String time;

        //Getter and Setter #1
        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        //Getter and Setter #2
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        //Getter and Setter #3
        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfSong = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberOfSong; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();
        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
