package spotifire.data;

import java.util.Objects;

public class Playlist {

    private String name;
    private String spotifyId;
    private FunnelDefinition funnelDefinition;

    public Playlist(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpotifyId() {
        return spotifyId;
    }

    public void setSpotifyId(String spotifyId) {
        this.spotifyId = spotifyId;
    }

    public FunnelDefinition getFunnelDefinition() {
        return funnelDefinition;
    }

    public void setFunnelDefinition(FunnelDefinition funnelDefinition) {
        this.funnelDefinition = funnelDefinition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return Objects.equals(name, playlist.name) &&
            Objects.equals(spotifyId, playlist.spotifyId) &&
            Objects.equals(funnelDefinition, playlist.funnelDefinition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spotifyId, funnelDefinition);
    }

    @Override
    public String toString() {
        return "Playlist{" +
            "name='" + name + '\'' +
            ", spotifyId='" + spotifyId + '\'' +
            ", funnelDefinition=" + funnelDefinition +
            '}';
    }
}
