package ccm.gospel.misook;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import ccm.gospel.misook.database.AppDatabase;

import static ccm.gospel.misook.database.AppDatabase.DATABASE_NAME;
import static ccm.gospel.misook.database.Migrations.MIGRATION_11_12;

public final class NewPipeDatabase {

    private static volatile AppDatabase databaseInstance;

    private NewPipeDatabase() {
        //no instance
    }

    private static AppDatabase getDatabase(Context context) {
        return Room
                .databaseBuilder(context.getApplicationContext(), AppDatabase.class, DATABASE_NAME)
                .addMigrations(MIGRATION_11_12)
                .fallbackToDestructiveMigration()
                .build();
    }

    @NonNull
    public static AppDatabase getInstance(@NonNull Context context) {
        AppDatabase result = databaseInstance;
        if (result == null) {
            synchronized (NewPipeDatabase.class) {
                result = databaseInstance;
                if (result == null) {
                    databaseInstance = (result = getDatabase(context));
                }
            }
        }

        return result;
    }
}
