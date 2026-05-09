import java.util.Random;

public class LasVegasAlgoritmasi {
    public static void main(String[] args) {

        long ogrenciNumarasi = 1240505023;

        // Seed zorunluluğu: Rastgele sayı üreticisi öğrenci numarası ile beslenmelidir.
        Random random = new Random(ogrenciNumarasi);

        // Veri Hacmi: Y = 3 (Y < 5) olduğu için n = 10^5.
        int n = 100000;
        int[] dizi = new int[n];

        // Diziyi rastgele sayılarla doldurma
        for (int i = 0; i < n; i++) {
            dizi[i] = random.nextInt(1000000); // 0 ile 1.000.000 arası rastgele değerler
        }

        int testSayisi = 100;
        long[] calismaSureleri = new long[testSayisi];
        long toplamAdim = 0;
        long toplamSure = 0;

        // Algoritmanın 100 kez çalıştırılması.
        for (int test = 0; test < testSayisi; test++) {
            long baslangicZamani = System.nanoTime();
            int adimSayisi = 0;
            boolean bulundu = false;

            // Las Vegas: %100 doğru sonuç bulana kadar çalışma.
            while (!bulundu) {
                adimSayisi++;
                int rastgeleIndeks = random.nextInt(n);

                // Problem Tanımı: Mod 7'ye göre belirli bir koşulu sağlayan (örn: tam bölünen) elemanı bulma.
                if (dizi[rastgeleIndeks] % 7 == 0) {
                    bulundu = true;
                }
            }

            long bitisZamani = System.nanoTime();
            long gecenSure = bitisZamani - baslangicZamani;

            calismaSureleri[test] = gecenSure;
            toplamSure += gecenSure;
            toplamAdim += adimSayisi;
        }

        // Ortalama çalışma süresi ve adım sayısının hesaplanması.
        double ortalamaSure = (double) toplamSure / testSayisi;
        double ortalamaAdim = (double) toplamAdim / testSayisi;

        // Zaman Analizi: Rastgeleliğin çalışma süresindeki standart sapmaya etkisinin hesaplanması[cite: 63].
        double varyansToplami = 0;
        for (int i = 0; i < testSayisi; i++) {
            varyansToplami += Math.pow(calismaSureleri[i] - ortalamaSure, 2);
        }
        double standartSapma = Math.sqrt(varyansToplami / testSayisi);

        // Analiz çıktıları
        System.out.println("--- Las Vegas Algoritması Test Sonuçları ---");
        System.out.println("Toplam Çalıştırma Sayısı: " + testSayisi);
        System.out.println("Ortalama Adım Sayısı: " + ortalamaAdim);
        System.out.println("Ortalama Çalışma Süresi (nanosaniye): " + String.format("%.2f", ortalamaSure));
        System.out.println("Çalışma Süresi Standart Sapması (nanosaniye): " + String.format("%.2f", standartSapma));
    }
}