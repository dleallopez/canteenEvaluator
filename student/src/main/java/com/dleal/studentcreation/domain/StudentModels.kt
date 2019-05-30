package com.dleal.studentcreation.domain

import android.os.Parcel
import android.os.Parcelable
import com.dleal.core.utils.readDate
import com.dleal.core.utils.writeDate
import java.util.*

typealias StudentGroup = List<Student>

data class Student(
    val id: Long? = 0,
    val name: String,
    val surname: String,
    val birthday: Date? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readLong(),
        parcel.readString().orEmpty(),
        parcel.readString().orEmpty(),
        parcel.readDate()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        with(parcel) {
            writeValue(id)
            writeString(name)
            writeString(surname)
            writeDate(birthday)
        }
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}