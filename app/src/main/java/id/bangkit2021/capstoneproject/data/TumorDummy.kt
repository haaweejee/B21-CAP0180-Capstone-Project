package id.bangkit2021.capstoneproject.data

object TumorDummy {
    fun getTumorData(): List<TumorData> {
        val tumorData : ArrayList<TumorData> = ArrayList()
        return tumorData.apply {
            add(
                TumorData(
                    1,
                    "Normal",
                    "Photo MRI tidak terindikasi Tumor"
                )
            )

            add(
                TumorData(
                    2,
                    "Glioma Tumor",
                    """
                        Glioma Tumor adalah Suatu jenis tumor yang terjadi di otak dan sumsum tulang belakang.
                        Glioma dapat terjadi di otak dan di berbagai lokasi dalam sistem saraf, termasuk batang otak dan tulang belakang."
                    """.trimIndent()
                )
            )
            add(
                TumorData(
                    3,
                    "Tumor ganas (Malignant tumor)",
                    """
                        Tumor ganas (malignant tumor) adalah jenis tumor yang terbentuk dari sel kanker. Tumor ganas inilah yang bisa Anda sebut sebagai penyakit kanker.
                        Tumor yang ganas ini dapat menyebar dengan cepat dan merusak jaringan sekitarnya, bahkan ke bagian tubuh mana pun (metastasis).
                    """.trimIndent()
                )
            )

            add(
                TumorData(
                    4,
                    "Tumor hipofisis (pituitary Tumor)",
                    """
                       Tumor non-kanker di kelenjar pituitari yang tidak menyebar di luar tengkorak.
                       Kelenjar pituitari di tengkorak, di bawah otak dan di atas bagian hidung. Suatu tumor besar dapat menekan pada dan merusak otak dan saraf.
                    """.trimIndent()
                )
            )

        }
    }
}