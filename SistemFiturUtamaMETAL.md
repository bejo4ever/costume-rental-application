Terdapat 5 fitur utama pada METAL ini yaitu fitur profil perusahaan, kelola penyewa, stok barang yang disewakan, sistem sewa, dan reminder.

Penjelasan Fitur

Dari fitur-fitur diatas, memiliki fungsi dan kegunaan masing-masing :
1. Profil Perusahaan
> Mengisi data perusahaan pada database
2. Kelola Penyewa
> Mengisi data pelanggan yang menyewa kostum
3. Stok Barang yang Disewakan
> Mengisi semua data barang yang akan disewakan
4. Sistem Sewa
> - Sitem Persewaan (data pelanggan, barang sewa,total biaya sewa, dll)
> - Sistem Pengembalian (data pelanggan, barang sewa, denda, dll)
5. Reminder
> Sebagai pengingat untuk use (pemilik perusahaan) bahwa sudah saatnya  bagi pelanggan untuk mengembalikan kostum yang disewa.

Sistem Pada Fitur

1.) Fitur Toko

Kebutuhan fungsional:
a. Menambahkan data toko seperti nama, alamat, telepon, email/fax, dan nama pemilik (KF-01)
b. Mengupdate data toko (KF-02)

Alur operasi normal:
a. Pengisian form oleh admin toko pada data toko yang telah tersedia Konfirmasi penyimpanan data
b. Data tersimpan di database
c. Data ditampilkan pada header aplikasi

2.) Fitur Barang

Kebutuhan fungsional:
a. Menambahkan data barang seperti kode, jangka waktu menyewa, aksesoris, jenis, nama, foto dan harga sewa kostume (KF-03)

Alur operasi normal:
a. Pengisian form oleh admin toko pada data barang yang telah tersedia
b. Konfirmasi penyimpanan data
c. Data tersimpan di database
d. Data ditampilkan pada interface sistem pertama khusus user dii halaman daftar barang dan di fitur sewa pada sistem kedua

3.) Fitur Profil Penyewa

Kebutuhan fungsional:
a. Menambahkan data penyewa baru seperti kode, nama, jenis kelamin, umur, alamat, telepon dan email/fax penyewa baru (KF-04)
b. Mengupdate data profil penyewa (KF-05)

Alur operasi normal:
a. Pengisian form oleh admin toko pada profil penyewa  yang telah tersedia
b. Konfirmasi penyimpanan data
c. Data tersimpan di database
d. Data ditampilkan hanya pada sistem yang kedua milik admin di halaman lihat profil penyewa

4.) Fitur Sewa

Kebutuhan fungsional:
- Persewaan
a. Menambahkan tanggal sewa dan pengembalian barang, kode barang yang disewa, kode pelanggan yang menyewa, dan total biaya sewa  (KF-06)
b. Mengupdate data barang yang disewa seperti menambah lama sewa barang (KF-07)
- Pengembalian
a. Mencocokkan kode pelanggan yang menyewa dengan konten database (KF-08)

Alur operasi normal:
- Persewaan
a. Pengisian form oleh admin toko pada halaman data persewaan yang telah tersedia
b. Konfirmasi penyimpanan data
c. Data tersimpan di database
d. Data ditampilkan hanya pada sistem yang kedua milik admin di halaman sewa barang
- Pengembalian
a. Menuliskan kata kunci pada kolom kode pelanggan
b. Sistem melakukan proses pencarian dengan pencocokan kode pelanggan  yang dimasukkan dengan data yang ada di database
c. Menampilkan hasil pencarian kode pelanggan beserta barang yang disewa

5.) Fitur Pengingat (Reminder)

Kebutuhan fungsional:
a. Menambahkan data pelanggan, kostum yang disewakan dan waktu pengingat pengembalian barang (KF-09)

Alur operasi normal:
a. Pengisian form oleh admin toko pada halaman pengingat   yang telah tersedia
b. Konfirmasi penyimpanan data
c Data tersimpan di database
d. Ketika waktu sewa habis maka pop-up akan tampil dan menampilkan pengingat pada sistem kedua milik admin

6.) Fitur Pencarian (bukan fitur utama)

Kebutuhan fungsional:
a. Mencocokkan kata kunci dengan konten database (KF-10)

Alur operasi normal:
a. Menuliskan kata kunci pada kolom pencarian
b. Sistem melakukan proses pencarian dengan pencocokan kata kunci yang dimasukkan dengan data yang ada di database
c. Menampilkan hasil pencarian kata kunci yang dilakukan

