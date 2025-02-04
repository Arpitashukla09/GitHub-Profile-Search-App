package data

import com.google.gson.annotations.SerializedName

data class GHRepo(
    val id: Int,
    val name: String,
    @SerializedName("html_url") val repoURL: String
)
