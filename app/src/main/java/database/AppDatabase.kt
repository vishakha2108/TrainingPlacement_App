package database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [ StudentDetails::class, CompanyDetails::class,PlacedStudents::class , Login::class], version = 1)

abstract class AppDatabase : RoomDatabase()
{
    abstract val StudentDetailsDao: StudentDetailsDao
    abstract val CompanyDetailsDao: CompanyDetailsDao
    abstract val PlacedStudentDao: PlacedStudentsDao
    abstract val LoginDao: LoginDao
    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance==null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "training_placement_ database").fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }

    }



}
