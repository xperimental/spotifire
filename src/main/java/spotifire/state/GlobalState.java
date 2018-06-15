package spotifire.state;

import spotifire.data.AuthToken;

public class GlobalState {

    private static final GlobalState INSTANCE = new GlobalState();

    public static GlobalState getInstance() {
        return INSTANCE;
    }

    private AuthToken authToken;

    public AuthToken getAuthToken() {
        return authToken;
    }

    public void setAuthToken(AuthToken authToken) {
        this.authToken = authToken;
    }

}
