package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_details")
data class StudentDetails(
    @ColumnInfo(name = "full_name")
    val FullName: String,
    @PrimaryKey
    val RollNo: Int,
    @ColumnInfo(name = "cgpa")
    val Cgpa: Float,
    @ColumnInfo(name = "backlogs")
    val Backlogs: Int,
    @ColumnInfo(name = "stream")
    val Stream: String,
    @ColumnInfo(name = "phone_no")
    val PhoneNo: Int

)


