package ccm.gospel.misook.player.playback;

import android.net.Uri;
import android.support.v4.media.MediaDescriptionCompat;


import ccm.gospel.misook.player.BasePlayer;
import ccm.gospel.misook.player.mediasession.MediaSessionCallback;
import ccm.gospel.misook.player.playqueue.PlayQueueItem;

public class BasePlayerMediaSession implements MediaSessionCallback {
    private BasePlayer player;

    public BasePlayerMediaSession(final BasePlayer player) {
        this.player = player;
    }

    @Override
    public void onSkipToPrevious() {
        player.onPlayPrevious();
    }

    @Override
    public void onSkipToNext() {
        player.onPlayNext();
    }

    @Override
    public void onSkipToIndex(int index) {
        if (player.getPlayQueue() == null) return;
        player.onSelected(player.getPlayQueue().getItem(index));
    }

    @Override
    public int getCurrentPlayingIndex() {
        if (player.getPlayQueue() == null) return -1;
        return player.getPlayQueue().getIndex();
    }

    @Override
    public int getQueueSize() {
        if (player.getPlayQueue() == null) return -1;
        return player.getPlayQueue().size();
    }

    @Override
    public MediaDescriptionCompat getQueueMetadata(int index) {
        if (player.getPlayQueue() == null || player.getPlayQueue().getItem(index) == null) {
            return null;
        }

        final PlayQueueItem item = player.getPlayQueue().getItem(index);
        MediaDescriptionCompat.Builder descriptionBuilder = new MediaDescriptionCompat.Builder()
                .setMediaId(String.valueOf(index))
                .setTitle(item.getTitle())
                .setSubtitle(item.getUploader());

        final Uri thumbnailUri = Uri.parse(item.getThumbnailUrl());
        if (thumbnailUri != null) descriptionBuilder.setIconUri(thumbnailUri);

        return descriptionBuilder.build();
    }

    @Override
    public void onPlay() {
        player.onPlay();
    }

    @Override
    public void onPause() {
        player.onPause();
    }

    @Override
    public void onSetShuffle(boolean isShuffled) {
        player.onShuffleModeEnabledChanged(isShuffled);
    }
}
