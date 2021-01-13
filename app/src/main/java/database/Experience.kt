package database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

 class Experience (
    val companyName:String,
    val rollNo:Int,
    val studentName:String,
    val exp:String
)
 {



     constructor() : this("", 0, "", "")
     {

     }



 }