package ccm.gospel.misook.local.holder;

import android.view.ViewGroup;

import org.schabi.newpipe.extractor.NewPipe;

import java.text.DateFormat;

import ccm.gospel.misook.database.LocalItem;
import ccm.gospel.misook.database.playlist.model.PlaylistRemoteEntity;
import ccm.gospel.misook.local.LocalItemBuilder;
import ccm.gospel.misook.util.ImageDisplayConstants;
import ccm.gospel.misook.util.Localization;

public class RemotePlaylistItemHolder extends PlaylistItemHolder {
    public RemotePlaylistItemHolder(LocalItemBuilder infoItemBuilder, ViewGroup parent) {
        super(infoItemBuilder, parent);
    }

    @Override
    public void updateFromItem(final LocalItem localItem, final DateFormat dateFormat) {
        if (!(localItem instanceof PlaylistRemoteEntity)) return;
        final PlaylistRemoteEntity item = (PlaylistRemoteEntity) localItem;

        itemTitleView.setText(item.getName());
        itemStreamCountView.setText(String.valueOf(item.getStreamCount()));
        itemUploaderView.setText(Localization.concatenateStrings(item.getUploader(),""));

        itemBuilder.displayImage(item.getThumbnailUrl(), itemThumbnailView,
                ImageDisplayConstants.DISPLAY_PLAYLIST_OPTIONS);

        super.updateFromItem(localItem, dateFormat);
    }
}
