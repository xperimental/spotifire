package spotifire.data;

import java.util.Arrays;
import java.util.Objects;

public class User {

    private String spotifyId;
    private AuthToken authToken;
    private Playlist[] playlists;

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

    public Playlist[] getPlaylists() {
        return playlists;
    }

    public void setPlaylists(Playlist[] playlists) {
        this.playlists = playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(spotifyId, user.spotifyId) &&
            Objects.equals(authToken, user.authToken) &&
            Arrays.equals(playlists, user.playlists);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(spotifyId, authToken);
        result = 31 * result + Arrays.hashCode(playlists);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "spotifyId='" + spotifyId + '\'' +
            ", authToken=" + authToken +
            ", playlists=" + Arrays.toString(playlists) +
            '}';
    }
}
