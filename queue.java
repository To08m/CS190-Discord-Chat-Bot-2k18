package To08m;

import java.util.*;

public class queue {
        private LinkedList songs;

        public queue(){
            LinkedList <String> songs = new LinkedList<>();
        }

        public void addq(String s){
            songs.add(s);
        }

        public String playnext(){
            String temp = (String) songs.get(0);
            songs.remove(0);
            return temp;
        }
        public void printq() {
            for(int i =0; i<songs.size(); i++){
                String temp = (String) songs.get(i);
                //print?
            }
        }
        public void clearq(){
            songs.clear();
        }
}
