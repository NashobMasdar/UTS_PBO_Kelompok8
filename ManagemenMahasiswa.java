/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ujianTengahSemesterPBO;

import java.util.Scanner;

/**
 *
 * @author Zaidan NA
 * NIM = 25104410015
 * Kelas = Teknik Informatika 2A
 */
public class ManagemenMahasiswa {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mahasiswa[] daftarMhs = new Mahasiswa[10];
        int jumlah = 0;
        int pilihan;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Semua");
            System.out.println("3. Cari berdasarkan NIM");
            System.out.println("4. Tampilkan yang Lulus");
            System.out.println("5. Naikkan Semester Semua Mahasiswa");
            System.out.println("6. Keluar");
            System.out.print("Pilih : ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    if (jumlah >= 10) {
                        System.out.println("Data penuh!");
                        break;
                    }

                    System.out.print("NIM: ");
                    String nim = input.nextLine();

                    if (nim.isEmpty()) {
                        System.out.println("NIM tidak boleh kosong!");
                        break;
                    }

                    System.out.print("Nama: ");
                    String nama = input.nextLine();

                    System.out.print("Jurusan: ");
                    String jurusan = input.nextLine();

                    System.out.print("Semester (1-8): ");
                    int semester = input.nextInt();

                    if (semester < 1 || semester > 8) {
                        System.out.println("Semester tidak valid!");
                        break;
                    }

                    System.out.print("IPK (0.0-4.0): ");
                    double ipk = input.nextDouble();

                    if (ipk < 0.0 || ipk > 4.0) {
                        System.out.println("IPK tidak valid!");
                        break;
                    }

                    daftarMhs[jumlah] = new Mahasiswa(nim, nama, jurusan, semester, ipk);
                    jumlah++;
                    System.out.println("Data berhasil ditambahkan!");
                    break;

                case 2:
                    for (int i = 0; i < jumlah; i++) {
                        daftarMhs[i].tampilData(true);
                    }
                    break;

                case 3:
                    System.out.print("Masukkan NIM: ");
                    String cari = input.nextLine();
                    boolean ditemukan = false;

                    for (int i = 0; i < jumlah; i++) {
                        if (daftarMhs[i].getNim().equals(cari)) {
                            daftarMhs[i].tampilData(true);
                            ditemukan = true;
                        }
                    }

                    if (!ditemukan) {
                        System.out.println("Data tidak ditemukan!");
                    }
                    break;

                case 4:
                    for (int i = 0; i < jumlah; i++) {
                        if (daftarMhs[i].isLulus()) {
                            daftarMhs[i].tampilData(true);
                        }
                    }
                    break;

                case 5:
                    for (int i = 0; i < jumlah; i++) {
                        daftarMhs[i].naikSemester();
                    }
                    System.out.println("Semua mahasiswa naik semester!");
                    break;

                case 6:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (pilihan != 6);
    }
}

