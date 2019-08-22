package appometric.meteoros.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import appometric.meteoros.model.Forecast
import appometric.meteoros.room.dao.ForecastDao

@Database(entities = [Forecast::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun forecastDao(): ForecastDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "meteorosDB")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build()
            }

            return INSTANCE as AppDatabase
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}