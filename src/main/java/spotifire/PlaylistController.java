package spotifire;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spotifire.data.Playlist;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping
    public ResponseEntity getList() {
        Playlist[] playlists = new Playlist[]{
            new Playlist("Coole Liste")
        };
        return ResponseEntity.ok(playlists);
    }

}
