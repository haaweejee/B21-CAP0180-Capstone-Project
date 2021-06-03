package id.bangkit2021.capstoneproject.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HospitalsObject(
    var id: Int,
    var hospitalsName: String,
    var hospitalsPhotoUrl: String,
    var hospitalsAddress: String,
    var hospitalsTelephone: String,
    var hospitalsRute: String,
    var hospitalsWeb: String,
) : Parcelable
