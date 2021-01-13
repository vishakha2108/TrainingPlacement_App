package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


class StudentDetails(

    val fullName: String,
    val rollNo: Int,
    val cgpa: Float,
    val backlogs: Int,
    val stream: String,
    val phoneNo: Long,
    val password: String

) {


    constructor() : this("", 0, 0.0f, 0, "", 0, "") {

    }


}


