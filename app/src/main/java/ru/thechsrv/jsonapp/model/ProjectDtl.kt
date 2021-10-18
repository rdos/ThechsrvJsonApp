package ru.thechsrv.jsonapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProjectDtl(
    val id: String,
    val subject: String,
    val description: String,
    val startDate: String
):Parcelable
