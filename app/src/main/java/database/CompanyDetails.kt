package database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_details")
data class CompanyDetails(
    @ColumnInfo(name = "name")
    val CompanyName:String,
    @ColumnInfo(name = "min_cgpa")
    val MinCgpa:Float,
    @ColumnInfo(name = "max_backlog")
    val MaxBacklogs:Int,
    @ColumnInfo(name = "stream")
    val Stream:String,
    @ColumnInfo(name = "jd")
    val JD:String,
    @ColumnInfo(name = "location")
    val Location:String,
    @ColumnInfo(name = "stipend")
    val Stipend:Int,
    @ColumnInfo(name = "notes")
    val Notes : String

)



