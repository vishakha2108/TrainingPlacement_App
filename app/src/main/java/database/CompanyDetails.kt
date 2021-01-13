package database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


 class CompanyDetails (


     val companyName: String,
     val minCgpa: Float ,
     val maxBacklogs: Int ,
     val stream: String ,
     val jD: String ,
     val location: String ,
     val stipend: String ,
     val notes: String)
 {



         constructor() : this("hi", 0.0f, 0, "Any", "", "will be specified later", "will be specified later", "")
         {

         }



 }

