package com.xiaoming.couroutine.server.vo

import android.os.Parcel
import android.os.Parcelable

/**
 * author: xxm
 */
data class AppVersionVo(
    val app_name: String?,
    val last_force: String?,
    val version_type: String?,
    val version_desc: String?,
    val update_url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(app_name)
        parcel.writeString(last_force)
        parcel.writeString(version_type)
        parcel.writeString(version_desc)
        parcel.writeString(update_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AppVersionVo> {
        override fun createFromParcel(parcel: Parcel): AppVersionVo {
            return AppVersionVo(parcel)
        }

        override fun newArray(size: Int): Array<AppVersionVo?> {
            return arrayOfNulls(size)
        }
    }

}

