package id.bangkit2021.capstoneproject.data

object HospitalsDummy {
    fun generateHospitalsData() : List<HospitalsObject>{

        val hospitals = ArrayList<HospitalsObject>()

        hospitals.add(
            HospitalsObject(1,
            "RS Sari Asih Karawaci",
            "https://www.sariasih.com/media/library/3-rs-karawaci.jpg",
            "Jl. Imam Bonjol No.38, RT.003/RW.004, Sukajadi, Kec. Karawaci, Kota Tangerang, Banten 15113",
            "0215522794",
            "https://www.google.com/maps/dir//RS.+Sari+Asih+Karawaci/@-6.1793149,106.5563687,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69ff2ba76d32d3:0xd533af97acf7dac3!2m2!1d106.6264093!2d-6.1793195?hl=en",
            "https://www.sariasih.com/")
        )

        hospitals.add(
            HospitalsObject(2,
            "RS Sari Asih Sangiang",
            "https://www.sariasih.com/media/library/4-rs-sangiang.jpg",
            "Jl. Moh. Toha KM. 3,5 (Simpang Tiga Sangiang) Kota Tangerang, Banten",
            "0215582732",
            "https://www.google.com/maps/dir//rs.+sari+asih+sangiang/@-6.1702518,106.5308835,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69ff16fbe557d5:0xe75ced58ec1a00b8!2m2!1d106.6009241!2d-6.1702564?hl=en",
            "https://www.sariasih.com/")
        )

        hospitals.add(
            HospitalsObject(3,
            "Primaya Hospital Tangerang",
            "https://primayahospital.com/wp-content/uploads/2018/05/Primaya-Hospital-Tangerang-landscape-1-scaled.jpg.webp",
            "Jl. MH. Thamrin No.3, RT.003/RW.001, Cikokol, Kec. Pinang, Kota Tangerang, Banten 15143",
            "0215575888",
            "https://www.google.com/maps/dir//rumah+sakit+awal+bros+tangerang/@-6.2148641,106.5601182,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69f952ea1924c1:0xdac9e6180310b952!2m2!1d106.6301588!2d-6.2148687",
            "https://primayahospital.com/")
        )

        hospitals.add(
            HospitalsObject(4,
            "Mayapada Hospitals",
            "https://www.garnesia.com/images/vendor/5618_532578efa23b01847da0924788f4eeac.jpg",
            "Modernland, Jl. Honoris Raya No.6, RT.001/RW.006, Klp. Indah, Kec. Tangerang, Kota Tangerang, Banten 15117",
            "150770",
            "https://www.google.com/maps/dir//rumah+sakit+mayapada+tangerang/@-6.2049514,106.5715373,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69f947ce8c007b:0x7d0c6bb6ecab2153!2m2!1d106.6415779!2d-6.204956",
            "https://mayapadahospital.com/")
        )

        hospitals.add(
            HospitalsObject(5,
            "RS Ciputra Garden City",
            "https://citragardencity.com/wp-content/uploads/2017/09/CWasCOKUwAAo_x0.jpg",
            " Jl. Boulevard Timur No.1, RW.16, Prepedan, Kec. Kalideres, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11830",
            "02122557888",
            "https://www.google.com/maps/dir//rumah+sakit+ciputra+garden+city/@-6.123248,106.6350622,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e6a02bea7a2f30b:0x535e3bc11da2d4d3!2m2!1d106.7051028!2d-6.1232525",
            "https://ciputrahospital.com/ciputra-hospital-citra-garden-city/")
        )

        hospitals.add(
            HospitalsObject(6,
            "Eka Hospital BSD",
            "https://the-iconomics.storage.googleapis.com/wp-content/uploads/2020/05/02161645/Eka-Hospital-BSD-2-2-scaled-e1588411078793.jpg",
            "Central Business District Lot. IX, Jl. Boulevard BSD Tim., Lengkong Gudang, Kec. Serpong, Kota Tangerang Selatan, Banten 15321",
            "02125655555",
            "https://www.google.com/maps/dir//eka+hospital/@-6.298605,106.5995679,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69fb2954a14caf:0x691aa81bfa145d03!2m2!1d106.6696085!2d-6.2986097",
            "https://www.ekahospital.com/")
        )

        hospitals.add(
            HospitalsObject(7,
            "Rumah Sakit Umum Pusat Fatmawati",
                "data:image/jpeg;base64,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",
                "Jl. RS. Fatmawati Raya No.4, RT.4/RW.9, Cilandak Bar., Kec. Cilandak, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12430",
                "0217501524",
                "https://www.google.com/maps/dir//rs+umum+fatmawati/@-6.2950795,106.7264364,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69f1e653901bc1:0xc0478e03aaa208d7!2m2!1d106.796477!2d-6.2950842",
                "http://rsupfatmawati.id/"
                )
        )

        hospitals.add(
            HospitalsObject(8,
            "RS Mitra Keluarga Kalideres",
            "https://akcdn.detik.net.id/visual/2017/09/11/31d6b65f-3b4c-47f8-bd59-b3e92739561f_169.jpg?w=650",
            "Jl. Peta Selatan No.1, RT.7/RW.11, Kalideres, Kec. Kalideres, Kota Jakarta Barat, Daerah Khusus Ibukota Jakarta 11840",
            "02122523700",
            "https://www.google.com/maps/dir//rs+mitra+keluarga+kalideres/@-6.1494952,106.6323412,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69f9f7a117a40f:0x46f38f33384af90d!2m2!1d106.7023818!2d-6.1494998?hl=en",
            "https://www.mitrakeluarga.com/kalideres/menu-fasilitas-rs")
        )

        hospitals.add(
            HospitalsObject(9,
            "RS Mitra Keluarga Bintaro",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrILqY4OZDtymLNK5ydVFdox_W_3uRUIlIKg&usqp=CAU",
            "Jl. Bintaro Utama 3, Pd. Karya, Kec. Pd. Aren, Kota Tangerang Selatan, Banten 15225",
            "02127659777",
            "https://www.google.com/maps/dir//rs+mitra+keluarga+bintaro/@-6.2707908,106.6711438,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69f19286bb5a33:0x1c24a205db53095a!2m2!1d106.7411844!2d-6.2707954?hl=en",
            "https://www.mitrakeluarga.com/bintaro/menu-fasilitas-rs")
        )

        hospitals.add(
            HospitalsObject(10,
            "RS Premier Bintaro",
            "https://www.smarterhealth.id/wp-content/uploads/2020/02/premier-bintaro-hospital-1024x573.jpg",
            "Jl. Moh. Husni Thamrin No.1, Pd. Jaya, Kec. Pd. Aren, Kota Tangerang Selatan, Banten 15224",
            "02127625500",
            "https://www.google.com/maps/dir//rs+premier+bintaro/@-6.2761938,106.6536831,12z/data=!3m1!4b1!4m9!4m8!1m1!4e2!1m5!1m1!1s0x2e69fa9d8b042767:0x2a7956b6a6d3c3c3!2m2!1d106.7237237!2d-6.2761985",
            "https://www.ramsaysimedarby.co.id/rs-premier-bintaro/")
        )

        return hospitals
    }
}