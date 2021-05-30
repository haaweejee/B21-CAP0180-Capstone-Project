package id.bangkit2021.capstoneproject.data

object AboutDummy {
    fun generateAboutData() : List<AboutObject>{

        val about = ArrayList<AboutObject>()

        about.add(
            AboutObject(1,
                        "Pengertian Tumor Otak",
                        """ Tumor otak merupakan kondisi yang ditandai dengan tumbuhnya sel-sel abnormal di dalam atau di sekitar otak. Sel-sel abnormal itu tumbuh tak wajar dan tidak terkendali. Namun, tumor di dalam otak ini tidak selalu berubah menjadi tumor ganas atau kanker. 
                            
                            Tingkatan tumor otak terbagi dari tingkat 1-4. pengelompokkannya berdasarkan perilaku tumor tersebut. Misalnya, dinilai dari kecepatan pertumbuhan dan cara penyebarannya. Untuk tingkat 1 dan 2, tumor otak tergolong jinak, dan tidak berpotensi menjadi ganas.
                            
                            Sementara itu pada tingkat 3 dan 4 berbeda lagi. Di tingkat ini, tumor biasanya berpotensi menjadi kanker. Oleh sebab itu, kondisi ini sering disebut sebagai tumor otak ganas atau kanker otak.
                        """.trimIndent()
            )
        )

       about.add(
           AboutObject(2,
                    "Gejala Tumor Otak",
                    """Gejala tumor otak berbeda-beda tergantung jenisnya. Gejala yang muncul dipengaruhi oleh ukuran, kecepatan pertumbuhan, dan lokasi tumor. Tumor otak yang berukuran kecil sering kali tidak menimbulkan gejala. Seiring berkembangnya tumor otak, dapat muncul gejala berupa sakit kepala, gangguan saraf, atau kejang.
                    """.trimIndent())
       )
       about.add(
           AboutObject(3,
           "Diagnosis dan Pengobatan Tumor Otak",
           """Dokter akan melakukan pemeriksaan saraf dan pemeriksaan pencitraan, seperti CT scan atau MRI otak untuk melihat adanya tumor otak. Kemudian dokter akan menentukan jenis tumor otak melalui biopsi tumor, yaitu pengambilan sampel jaringan tumor untuk diperiksa dengan mikroskop. Penentuan jenis tumor ini akan membantu dokter untuk memperkirakan keparahan penyakit dan merencanakan pengobatan. 
               Penderita tumor otak, baik tumor jinak maupun ganas, dapat menjalani pengobatan dengan metode radioterapi, kemoterapi, atau operasi (salah satunya dengan bedah sinar gamma). Pasca pengobatan tumor otak, penderita dapat menjalani fisioterapi untuk mempercepat proses pemulihan.
           """.trimIndent())
       )

       about.add(
           AboutObject(4,
           "Faktor Risiko Tumor Otak",
           """Terdapat beberapa faktor yang bisa meningkatkan risiko terjadinya tumor otak. Misalnya usia (beberapa jenis tumor otak lebih sering diidap anak-anak), keturunan, paparan radiasi, hingga kelainan genetik. Di samping itu, tumor otak juga bisa disebabkan oleh penyebaran kanker di bagian tubuh selain otak. Cotonhnya kanker paru-paru atau kanker payudara.  
           """.trimIndent())
       )
    return about
    }

}