'use strict';

const app = new Vue({
    el: '#app',
    data: {
        playlists: []
    },
    methods: {
        refreshData: function() {
            fetch('/playlists').then(function(response) {
                return response.json();
            }).then(function(jsondata) {
                this.playlists = jsondata;
            }.bind(this)).catch(function(error) {
                console.error(error);
            });
        },
        savePlaylist: function(playlist) {
            const flashMessageElement = document.querySelector('#flashmessage');
            flashMessageElement.MaterialSnackbar.showSnackbar({
                message: `Playlist ${playlist.name} in Spotify gespeichert!`,
                timeout: 2000
            });
        }
    },
    mounted: function() {
        this.$nextTick(() => {
            this.refreshData(true);
        });
    }
});
