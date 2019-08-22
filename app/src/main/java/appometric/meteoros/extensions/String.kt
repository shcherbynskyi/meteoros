package appometric.meteoros.extensions

fun String.truncate(length: Int = 18): String {
    if (length > this.trim().length)
        return this.trim()
    return this.substring(0, length).trim() + "..."
}