package tsisyk.app.babysleeptracker.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SleepNight::class], version = 1,  exportSchema = false)
abstract class SleepDatabase : RoomDatabase() {

    companion object {
        @Volatile
        private var INSTANCE: SleepDatabase? = null

        fun getIntance(context: Context): SleepDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            SleepDatabase::class.java,
                            "sleep_history_database"
                    )
                            .fallbackToDestructiveMigration()
                            .build()
                }
                return instance
            }
        }
    }
}