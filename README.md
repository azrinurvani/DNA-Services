# DNA-Services

# Technology used

1. Dagger2
2. Navigation Component
3. MVVM
4. ROOM
5. RxJava2

# DEV-LOG
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
