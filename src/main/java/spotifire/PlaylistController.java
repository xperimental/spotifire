package spotifire;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Paging;
import com.wrapper.spotify.model_objects.specification.PlaylistSimplified;
import com.wrapper.spotify.requests.data.playlists.GetListOfCurrentUsersPlaylistsRequest;
import javafx.scene.control.Pagination;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import spotifire.state.Client;
import spotifire.state.GlobalState;

import java.io.IOException;

@Controller
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping
    public ResponseEntity getList() {
        SpotifyApi api = new SpotifyApi.Builder()
            .setClientId(Client.ID)
            .setAccessToken(GlobalState.getInstance().getAuthToken().getAccessToken())
            .build();
        GetListOfCurrentUsersPlaylistsRequest req = api.getListOfCurrentUsersPlaylists().build();

        try {
            Paging<PlaylistSimplified> playlists = req.execute();
            return ResponseEntity.ok(playlists);
        } catch (SpotifyWebApiException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

}
