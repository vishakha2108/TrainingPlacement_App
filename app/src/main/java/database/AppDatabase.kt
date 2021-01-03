package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ StudentDetails::class, CompanyDetails::class , Experience::class], version = 2)

abstract class AppDatabase : RoomDatabase()
{
    abstract fun getStudentDetailsDao() : StudentDetailsDao
    abstract fun getCompanyDetailsDao(): CompanyDetailsDao
    abstract fun getExperienceDao(): ExperienceDao
    companion object {
        @Volatile
        private var instance: AppDatabase? = null
        operator fun invoke(context: Context) = instance?:

            synchronized(this) {
                instance?: buildDatabase(context).also ()
                {
                    instance = it
                }
            }
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "training_placement_ database").fallbackToDestructiveMigration()
            .build()
        }

}




