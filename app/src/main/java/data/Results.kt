package data

sealed class Results<out T> {
    data class Success<out T>(val data: T) : Results<T>()
    data class Error(val exception: String?) : Results<Nothing>()
    data object Loading: Results<Nothing>()
}