package id.bangkit2021.capstoneproject.data

data class Recognition(
    var id: String = "",
    var typeTumor: String = "",
    var confidence: Float = 0F
) {
    override fun toString(): String {
        return "Title = $typeTumor, Confidence = $confidence"
    }
}
