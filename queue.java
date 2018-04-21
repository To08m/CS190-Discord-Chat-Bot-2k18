import java.util.*;

public class queue {
        private LinkedList songs;

        public queue(){
            LinkedList <song> songs = new LinkedList<song>();
        }

        public void addq(song s){
            songs.add(s);
        }

        public song playnext(){
            song temp = (song) songs.get(0);
            songs.remove(0);
            return temp;
        }
        public void printq() {
            for(int i =0; i<songs.size(); i++){
                song temp = (song) songs.get(i);
                String a = temp.getArtist();
                String t = temp.getTitle();
                //print?
            }
        }
}
