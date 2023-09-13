package com.example.resi_android_new.data.dummy


object DummyData {
  val previewHistoryTransaction = """
            [
              {
                "title": "Indomaret Keputih No.24",
                "date_time": "Minggu, 26 Juni 2023",
                "total": "Rp. 35.610,00"
              },
              {
                "title": "Hympermart Manyar Surabaya",
                "date_time": "Sabtu, 25 Juni 2023",
                "total": "Rp. 3.005.610,00"
              },
              {
                "title": "Starbuck Basuki Rahmat",
                "date_time": "Jumat, 24 Juni 2023",
                "total": "Rp. 65.000,00"
              },
              {
                "title": "Indomaret Rungkut No.21",
                "date_time": "Kamis, 23 Juni 2023",
                "total": "Rp. 35.610,00"
              },
              {
                "title": "Alfamidi Mer Surabaya",
                "date_time": "Senin, 20 Juni 2023",
                "total": "Rp. 3.005.610,00"
              }
            ]

        """.trimIndent()

  val informationData = """
    [
      {
        "title": "Ingat, 6 Rekomendasi Tempat Belanja Murah Surabaya",
        "date_time": "1 Week Ago",
        "like" : "2.5 K"
      },
      {
        "title": "Wisata Malam di Surabaya Paling Recomended",
        "date_time": "2 Week Ago",
        "like" : "3.5 K"
      },
      {
        "title": "Ingat, 6 Rekomendasi Tempat Belanja Murah Surabaya",
        "date_time": "1 Week Ago",
        "like" : "2.5 K"
      }
    ]
  """.trimIndent()

  val detailPayment = """
    {
      "shopname" : "PT. Indomaret Primatama",
      "shopadress" : "JL. keputih No 3, Sukolilo. Surabaya, Jawa Timur",
      "no_telf" : "+62 858 596 00019",
      "logo" : "ic_indomaret",
      "payment_number": "915315/MIRA/J1",
      "payment_date" : "06 Juni 2023",
      "discount" : "(2)",
      "seller_price" : "43.400",
      "total" : "43.400",
      "cash" : "50.000",
      "return" : "6.600",
      "product" : [
            {
              "name": "Chitato sapi",
              "quantity": 1,
              "price": 11000,
              "total": "11.000"
            },
            {
              "name": "Ayam Goreng",
              "quantity": 3,
              "price": 6000,
              "total": "18.000"
            },
            {
              "name": "Ikan Asin",
              "quantity": 6,
              "price": 2400,
              "total": "14.400"
            },
            {
              "name": "Teh Botol",
              "quantity": 2,
              "price": 8000,
              "total": "16.000"
            },
            {
              "name": "Nasi Goreng",
              "quantity": 2,
              "price": 15000,
              "total": "30.000"
            },
            {
              "name": "Pasta Carbonara",
              "quantity": 1,
              "price": 25000,
              "total": "25.000"
            },
            {
              "name": "Mi Instant",
              "quantity": 5,
              "price": 2500,
              "total": "12.500"
            },
            {
              "name": "Es Krim Vanilla",
              "quantity": 4,
              "price": 5000,
              "total": "20.000"
            },
            {
              "name": "Roti Tawar",
              "quantity": 3,
              "price": 4500,
              "total": "13.500"
            },
            {
              "name": "Susu Coklat",
              "quantity": 2,
              "price": 12000,
              "total": "24.000"
            }
          ]
    }
  """.trimIndent()

  val historyTransaction = """
    [
      {
        "logo":"ic_indomaret",
        "store": "Indomaret Keputih No.24",
        "date": "Minggu, 26 Juni 2023",
        "total": "Rp. 35.610,00"
      },
      {
        "logo":"ic_hypermart",
        "store": "Hympermart Manyar Surabaya",
        "date": "Sabtu, 25 Juni 2023",
        "total": "Rp. 3.005.610,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck Basuki Rahmat",
        "date": "Jumat, 24 Juni 2023",
        "total": "Rp. 65.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck SPR",
        "date": "Kamis, 23 Juni 2023",
        "total": "Rp. 70.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck KKT",
        "date": "Rabu, 22 Juni 2023",
        "total": "Rp. 75.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck Darmo",
        "date": "Selasa, 21 Juni 2023",
        "total": "Rp. 80.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck Tunjungan",
        "date": "Senin, 20 Juni 2023",
        "total": "Rp. 85.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck PTC",
        "date": "Minggu, 19 Juni 2023",
        "total": "Rp. 90.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck Galaxy Mall",
        "date": "Sabtu, 18 Juni 2023",
        "total": "Rp. 95.000,00"
      },
      {
        "logo":"ic_starbucks",
        "store": "Starbuck Gresik",
        "date": "Jumat, 17 Juni 2023",
        "total": "Rp. 100.000,00"
      }
    ]
  
  """.trimIndent()

  val FAQItem = """
    [
        {
            "title": "Bagaimana cara kerja aplikasi RESI?", 
            "content": "Setelah Anda bertransaksi di tempat yang menggunakan Alat Responsive Electronic System Invoice yang terintegrasi dengan RESI, Anda cukup melakukan scan barcode. Melalui proses ini, Anda dapat menerima dan menyimpan nota digital Anda di aplikasi."
        },
        {
            "title": "Apakah saya harus menginstal aplikasi RESI?", 
            "content": "Ya, Anda perlu menginstal aplikasi RESI di perangkat Anda untuk menggunakan fitur-fiturnya."
        },
        {
            "title": "Seberapa aman nota digital di RESI?", 
            "content": "Nota digital yang Anda terima melalui RESI dienkripsi dengan standar keamanan tinggi, memastikan bahwa informasi transaksi Anda tetap aman dan terlindungi."
        },
        {
            "title": "Apakah menggunakan RESI membantu lingkungan?", 
            "content": "Tentu saja! Dengan memilih nota digital melalui RESI, Anda turut berkontribusi mengurangi penggunaan kertas dan menciptakan lingkungan yang lebih ramah dengan mengurangi limbah kertas."
        }
    ]
  """.trimIndent()

}