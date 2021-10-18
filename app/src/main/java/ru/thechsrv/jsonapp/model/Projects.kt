package ru.thechsrv.jsonapp.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Projects(
    @SerializedName("Projects") var projectList : List<ProjectDtl>
) : Parcelable
