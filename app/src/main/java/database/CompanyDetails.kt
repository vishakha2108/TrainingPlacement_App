package database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_details")
data class CompanyDetails(
    @PrimaryKey
    val CompanyName: String,
    @ColumnInfo(name = "min_cgpa")
    val MinCgpa: Float = 0.0f,
    @ColumnInfo(name = "max_backlog")
    val MaxBacklogs: Int = 0,
    @ColumnInfo(name = "stream")
    val Stream: String = "Any",
    @ColumnInfo(name = "jd")
    val JD: String = "",
    @ColumnInfo(name = "location")
    val Location: String = "will be specified later",
    @ColumnInfo(name = "stipend")
    val Stipend: String = "will be specified later",
    @ColumnInfo(name = "notes")
    val Notes: String = ""

)

