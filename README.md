# DNA-Services

# Technology used

1. Dagger2
2. Navigation Component
3. MVVM
4. ROOM
5. RxJava2

# DEV-LOG
Ver.0.1.0 - Part 2
- Update AppComponent

Ver.0.1.0
- Add halaman Detail Pengiriman Barang (Aksesoris/Sparepart/Motor)
- Submit Pengiriman Barang/Motor 
- Add halaman List Ekspedisi (EkspediisiRecyclerAdapter)
- Add EkspedisiModule
- Add halaman untuk konfirmasi paket diterima
- Update Navigation Graph
- Update FragmentBuildersModule

Ver.0.0.9 
- Add EkspedisiDao
- Update DTO Ekspedisi
- Add halaman Detail Pengiriman Motor
- Add EkspedisiViewModel
- Submit pengiriman motor
- Update Navigation Graph
- Update FragmentBuildersModule
- Update ViewModelsModule

Ver.0.0.8
- Bug Fix move to Gallery tidak bisa pada STNK 5 Tahunan
- Add EkspedisiFragment
- Add FormPengirimanAksesorisFragment
- Add FormPengirimanMotorFragment
- Add field pada tabel (entity/model) Ekspedisi
- Update Nav Graph dan FragmentBuildersModule
- Design layout EkspedisiFragment
- Design layout FormPengirimanMotor -> ON_PROGRESS

Ver.0.0.7
- Bug Fix upload image via gallery (Pada semua Form STNK)
- Bug Fix save path image null using ROOM (Pada semua Form STNK)

Ver.0.0.6
- Submit Form STNK Hilang (Design, Fragment)
- Submit Form STNK Hilang (Design, Fragment)
- Submit Form Balik Nama (Design, Fragment)
- Add Fragment Module Builders
- Improve Navigation Graph
- Bug Fix Approval STNK

note : Upload image via gallery masih belum jalan

Ver.0.0.5 - part 2
- Update model BiroJasa.kt
- Update design list pengajuan pada FragmentDetailStnk.kt
- Delete decoration item list pengajuan STNK
- Add drawable icon

Ver.0.0.5
- Action approval pada halaman Aproval (Approve/Reject)
  --> update pada bagian BiroJasaDao.kt, StnkViewModel.kt, dan pada ApprovalStnkFragent
- Update field pada tabel t_biro_jasa (penambahan field receipt_avail)
- Penambahan action ketika nomor handphone di klik pada halaman Aproval
- Penambahan icon pada Home (setiap menu)
- Update design xml pada Form Pengajuan STNK Tahunan dan STNK 5 Tahunan
- Update design xml pada fragment_aproval_stnk.xml
- Fix Submit path Image ketika take dari Camera (STNK Tahunan dan STNK 5 Tahunan)
- Fix action back button pada setiap halaman

Note : "Take image from gallery masih belum jalan"

Ver.0.0.4
- Menambahkan halaman Aproval apabila salah satu list stnk di klik
- Rename StnkTahunanViewModel menjadi StnkViewModel
- Persiapan method update data pengajuan STNK pada BiroJasaDao
- Improve BiroJasa DTO menggunakan parcelable
- Improve StnkDetailRecycler (menambahkan action klik untuk redirect ke halaman aproval)
- Update Navigation Graph
- Action Submit pada Form STNK 5 Tahunan
- Penambahan validasi ketika submit form pada STNK Tahunan dan STNK 5 Tahunan
- Penambahan direktori anim untuk persiapan animasi ketika berpindah halaman


Ver.0.0.3
- Improve BiroJasa DTO
- Improve Form STNK Tahunan
- Add method getDataBiroJasaList in StnkTahunanViewModel.kt
- Create layout_list_stnk_detail.xml
- Add Icon and Background design drawable
- Add Recylcer Adapter STNK Detail
- Improve STNK Detail Fragment
- Add Module STNK

Ver.0.0.2
- Design UI Home 
- Membuat Form STNK tahunan (menambahkan fragment_form_stnk_tahunan
- Menambahkan AppModule (untuk instance class atau pun depedency yang dibutuhkan pada Scope App)
- Update Depedency Component and Module
- Menambahkan ViewModel untuk Form STNK Tahunan
- Update DTO BiroJasa
- Update Navigation Graph
- Membuat layout_list_empty.xml
- Membuat package helper untuk class FileCompressor (Compress File Image), FunctionGlobalDir untuk Class pembuatan direktori, dan ImageUtil
- Design circle_shape background
- Penambahan file_path.xml dan file_provider_paths berfungsi untuk setting path (direktori) dalam pengambila file(gambar)

Note : 
1. Submit berhasil dengan data dummy
2. Get path image masih gagal
3. Action dalam segi UI ketika berhasil Submit belum di implement


Version 0.0.1 :
1. Setup arsitektur app
   - Dagger2
   - Navigation Component
   - MVVM
   - RxJava
2. Create DTO User, BiroJasa
3. Setup ROOM DB (Dao, Entitiy and DB INSTANCE)
4. Setup template Navigation Component
5. Provide FragmentHome.xml,FragmentStnk.xml, FragmentEkspedisi.xml, FragmentHelp.xml
6. Provide Navigation Graph

Note "Pada tahap ini berfungsi untuk setup project secara global, agar codingan bisa tersusun dengan arsitektur yang tersedia"
