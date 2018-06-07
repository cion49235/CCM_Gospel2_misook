package ccm.gospel.misook.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;


import ccm.gospel.misook.database.history.dao.SearchHistoryDAO;
import ccm.gospel.misook.database.history.dao.StreamHistoryDAO;
import ccm.gospel.misook.database.history.model.SearchHistoryEntry;
import ccm.gospel.misook.database.history.model.StreamHistoryEntity;
import ccm.gospel.misook.database.playlist.dao.PlaylistDAO;
import ccm.gospel.misook.database.playlist.dao.PlaylistRemoteDAO;
import ccm.gospel.misook.database.playlist.dao.PlaylistStreamDAO;
import ccm.gospel.misook.database.playlist.model.PlaylistEntity;
import ccm.gospel.misook.database.playlist.model.PlaylistRemoteEntity;
import ccm.gospel.misook.database.playlist.model.PlaylistStreamEntity;
import ccm.gospel.misook.database.stream.dao.StreamDAO;
import ccm.gospel.misook.database.stream.dao.StreamStateDAO;
import ccm.gospel.misook.database.stream.model.StreamEntity;
import ccm.gospel.misook.database.stream.model.StreamStateEntity;
import ccm.gospel.misook.database.subscription.SubscriptionDAO;
import ccm.gospel.misook.database.subscription.SubscriptionEntity;

import static ccm.gospel.misook.database.Migrations.DB_VER_12_0;

@TypeConverters({Converters.class})
@Database(
        entities = {
                SubscriptionEntity.class, SearchHistoryEntry.class,
                StreamEntity.class, StreamHistoryEntity.class, StreamStateEntity.class,
                PlaylistEntity.class, PlaylistStreamEntity.class, PlaylistRemoteEntity.class
        },
        version = DB_VER_12_0,
        exportSchema = false
)
public abstract class AppDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "newpipe.db";

    public abstract SubscriptionDAO subscriptionDAO();

    public abstract SearchHistoryDAO searchHistoryDAO();

    public abstract StreamDAO streamDAO();

    public abstract StreamHistoryDAO streamHistoryDAO();

    public abstract StreamStateDAO streamStateDAO();

    public abstract PlaylistDAO playlistDAO();

    public abstract PlaylistStreamDAO playlistStreamDAO();

    public abstract PlaylistRemoteDAO playlistRemoteDAO();
}
