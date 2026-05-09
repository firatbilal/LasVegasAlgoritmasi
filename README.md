# Las Vegas Algoritması 

Bu proje, "Final Değerlendirme Ödevi -4" kapsamında, büyük bir veri seti içerisindeki özel bir elemanın tespit edilmesini amaçlayan **Las Vegas Randomize Algoritması** uygulamasını ve zaman karmaşıklığı analizini içermektedir.

## Proje Parametreleri ve Sınır Koşulları

- **Algoritma Tipi:** Las Vegas Yaklaşımı (Öğrenci no son iki hanesi: `23` - Tek Sayı)
- **Veri Hacmi ($n$):** $10^5$ Eleman (Öğrenci no son rakamı: `3 < 5`)
- **Seed Zorunluluğu:** Rastgele sayı üreticisi öğrenci numarası ile beslenmiştir.
- **Problem Tanımı:** Dizi içinde rastgele seçilen sayının 7'ye tam bölünme (`mod 7 == 0`) koşulunun aranması.

## Las Vegas Algoritmasının Doğası

Las Vegas yaklaşımı, **%100 doğru cevabı** bulana kadar çalışır. Algoritma asla hatalı bir sonuç döndürmez ve hedef eleman bulunana kadar döngü kırılamaz. Doğruluktan kesinlikle ödün verilmez, ancak doğru sonucun ne kadar sürede bulunacağı tamamen rastgele bir değişkendir.

## Analiz ve Sonuçlar

Algoritma peş peşe **100 kez** çalıştırılmış ve aşağıdaki deneysel veriler elde edilerek teorik hesaplamalarla karşılaştırılmıştır:

### 1. Matematiksel Beklenti ($E[X]$) ve Deneysel Karşılaştırma
- **Tekil Başarı Olasılığı ($p$):** $\approx 1/7$ ($0$ - $999.999$ arasında $\approx 142.858$ adet 7'nin katı)
- **Teorik Beklenen Adım Sayısı ($E[X]$):** $\approx 7$ Adım
- **Deneysel Ortalama Adım Sayısı:** $7.56$ Adım

> **Yorum:** Deneysel veriler, matematiksel beklentiye (7.00) oldukça yakındır. Aradaki minimal fark, öğrenci numarası seed'inin yarattığı doğal rastgelelik varyasyonudur. Kod, matematiksel beklentiyle tam bir senkronizasyon içinde çalışmaktadır.

### 2. Zaman Analizi ve Standart Sapma
- **Ortalama Çalışma Süresi:** $979,00$ ns
- **Çalışma Süresi Standart Sapması:** $1999,81$ ns

> **Yorum:** Standart sapmanın ortalama süreden yaklaşık iki kat daha büyük olması, Las Vegas yaklaşımının en temel doğasını kanıtlar. Sürelerdeki ani sıçramalar, şanslı seçimlerde sonucun çok hızlı bulunması (ilk birkaç adım), şanssız denemelerde ise iterasyon sayısının 20-30 adıma kadar uzamasından kaynaklanmaktadır. Rastgelelik, zaman karmaşıklığında yüksek varyanslı bir şok etkisi yaratır.
