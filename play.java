import com.sedmelluq.discord.lavaplayer.player.AudioPlayer;
import com.sedmelluq.discord.lavaplayer.player.DefaultAudioPlayerManager;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEvent;
import com.sedmelluq.discord.lavaplayer.player.event.AudioEventListener;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManager;
import com.sedmelluq.discord.lavaplayer.source.AudioSourceManagers;
import com.sedmelluq.discord.lavaplayer.track.AudioItem;
import com.sedmelluq.discord.lavaplayer.track.AudioReference;
import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import com.sedmelluq.discord.lavaplayer.track.AudioTrackInfo;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class play implements AudioSourceManager, AudioEventListener  {

    DefaultAudioPlayerManager playerManager = new DefaultAudioPlayerManager();
    AudioSourceManager sourceManager;
    AudioPlayer player = playerManager.createPlayer();


    public String getSourceName() {
        return null;
    }

    public AudioItem loadItem(DefaultAudioPlayerManager defaultAudioPlayerManager, AudioReference audioReference) {
        return null;
    }

    public boolean isTrackEncodable(AudioTrack audioTrack) {
        return false;
    }

    public void encodeTrack(AudioTrack audioTrack, DataOutput dataOutput) throws IOException {

    }

    public AudioTrack decodeTrack(AudioTrackInfo audioTrackInfo, DataInput dataInput) throws IOException {
        return null;
    }

    public void shutdown() {

    }

    public void onEvent(AudioEvent audioEvent) {
        player.playTrack();
    }
}
