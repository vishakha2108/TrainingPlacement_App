package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "placed_students")
data class PlacedStudents
    (

    @PrimaryKey
    val RollNo :Int,
    @ColumnInfo(name = "company_name")
    val CompanyName:String
)