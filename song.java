public class song {
        private String title;
        private String artist;

        public song(String t, String a){
            this.title = t;
            this.artist = a;
        }

        public String getArtist(){
            return artist;
        }

        public String getTitle(){
            return title;
        }
}
