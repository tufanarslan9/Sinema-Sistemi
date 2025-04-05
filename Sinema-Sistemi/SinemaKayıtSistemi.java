import java.util.Scanner;

public class SinemaKayıtSistemi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] filmler = new String[10];
        String[] filmTurleri = new String[10];
        int[] filmSureleri = new int[10];
        String[] musteriler = new String[20];
        String[] musteriEmail = new String[20];
        int[][] biletler = new int[20][10];
        int filmSayisi = 0;
        int musteriSayisi = 0;
        int secim;

        do {
            System.out.println("\n--- Sinema Müşteri Kayıt Sistemi ---");
            System.out.println("1. Film Ekle");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Satışı Yap");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Müşterileri Listele");
            System.out.println("6. Biletleri Listele");
            System.out.println("7. Film Sil");
            System.out.println("8. Müşteri Sil");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminizi yapın: ");
            secim = scanner.nextInt();
            scanner.nextLine();

            if (secim == 1) {
                // Film Ekleme
                if (filmSayisi < 10) {
                    System.out.print("Film Adı: ");
                    filmler[filmSayisi] = scanner.nextLine();
                    System.out.print("Film Türü: ");
                    filmTurleri[filmSayisi] = scanner.nextLine();
                    System.out.print("Film Süresi (dakika): ");
                    filmSureleri[filmSayisi] = scanner.nextInt();
                    scanner.nextLine();
                    filmSayisi++;
                } else {
                    System.out.println("Maksimum film kapasitesine ulaşıldı!");
                }
            } else if (secim == 2) {
                // Müşteri Ekleme
                if (musteriSayisi < 20) {
                    System.out.print("Müşteri Adı: ");
                    musteriler[musteriSayisi] = scanner.nextLine();
                    System.out.print("Müşteri Email: ");
                    musteriEmail[musteriSayisi] = scanner.nextLine();
                    musteriSayisi++;
                } else {
                    System.out.println("Maksimum müşteri kapasitesine ulaşıldı!");
                }
            } else if (secim == 3) {
                // Bilet Satışı Yap
                if (musteriSayisi > 0 && filmSayisi > 0) {
                    System.out.println("Müşteriler:");
                    for (int i = 0; i < musteriSayisi; i++) {
                        System.out.println(i + ". " + musteriler[i]);
                    }
                    System.out.print("Müşteri seçin (indeks numarası): ");
                    int musteriNo = scanner.nextInt();

                    System.out.println("Filmler:");
                    for (int i = 0; i < filmSayisi; i++) {
                        System.out.println(i + ". " + filmler[i]);
                    }
                    System.out.print("Film seçin (indeks numarası): ");
                    int filmNo = scanner.nextInt();

                    if (musteriNo < musteriSayisi && filmNo < filmSayisi) {
                        biletler[musteriNo][filmNo] = 1;
                        System.out.println("Bilet başarıyla alındı!");
                    } else {
                        System.out.println("Geçersiz giriş! Lütfen tekrar deneyin.");
                    }
                } else {
                    System.out.println("Önce müşteri ve film ekleyin!");
                }
            } else if (secim == 4) {
                // Filmleri Listeleme
                System.out.println("--- Filmler ---");
                for (int i = 0; i < filmSayisi; i++) {
                    System.out.println(i + ". " + filmler[i] + " - " + filmTurleri[i] + " - " + filmSureleri[i] + " dk");
                }
            } else if (secim == 5) {
                // Müşterileri Listeleme
                System.out.println("--- Müşteriler ---");
                for (int i = 0; i < musteriSayisi; i++) {
                    System.out.println(i + ". " + musteriler[i] + " - " + musteriEmail[i]);
                }
            } else if (secim == 6) {
                // Biletleri Listeleme
                System.out.println("--- Biletler ---");
                for (int i = 0; i < musteriSayisi; i++) {
                    boolean biletVar = false;
                    for (int j = 0; j < filmSayisi; j++) {
                        if (biletler[i][j] == 1) {
                            System.out.println(musteriler[i] + " -> " + filmler[j]);
                            biletVar = true;
                        }
                    }
                    if (!biletVar) {
                        System.out.println(musteriler[i] + " için bilet bulunmuyor.");
                    }
                }
            } else if (secim == 7) {
                // Film Silme
                System.out.print("Silmek istediğiniz film indeks numarasını girin: ");
                int filmSil = scanner.nextInt();
                if (filmSil >= 0 && filmSil < filmSayisi) {
                    for (int i = filmSil; i < filmSayisi - 1; i++) {
                        filmler[i] = filmler[i + 1];
                        filmTurleri[i] = filmTurleri[i + 1];
                        filmSureleri[i] = filmSureleri[i + 1];
                    }
                    filmSayisi--;
                    System.out.println("Film başarıyla silindi.");
                } else {
                    System.out.println("Geçersiz indeks!");
                }
            } else if (secim == 8) {
                // Müşteri Silme
                System.out.print("Silmek istediğiniz müşteri indeks numarasını girin: ");
                int musteriSil = scanner.nextInt();
                if (musteriSil >= 0 && musteriSil < musteriSayisi) {
                    for (int i = musteriSil; i < musteriSayisi - 1; i++) {
                        musteriler[i] = musteriler[i + 1];
                        musteriEmail[i] = musteriEmail[i + 1];
                    }
                    musteriSayisi--;
                    System.out.println("Müşteri başarıyla silindi.");
                } else {
                    System.out.println("Geçersiz indeks!");
                }
            }
        } while (secim != 0);
        
        System.out.println("Çıkış yapılıyor...");
        scanner.close();
    }
}
