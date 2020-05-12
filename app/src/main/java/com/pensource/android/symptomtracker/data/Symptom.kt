package com.pensource.android.symptomtracker.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_symptom")
data class Symptom constructor (
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "name") val symptomName: String,
    @ColumnInfo(name = "time") val dateTime: String,
    @ColumnInfo(name = "scale") val scale: Int,
    @ColumnInfo(name = "note") val note: String,
    @ColumnInfo(name = "tag") val tag: String,
    @ColumnInfo(name = "duration") val duration: Long,
    @ColumnInfo(name = "color") val color: String
)