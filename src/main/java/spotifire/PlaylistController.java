package spotifire;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping
    public ResponseEntity getList() {
        return ResponseEntity.ok("Viele Listen.");
    }

}
