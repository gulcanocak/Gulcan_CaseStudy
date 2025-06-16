# 🧪  Kariyer Sayfası Test Otomasyon Projesi

Bu proje, web sitesinin kariyer sayfası üzerinde otomatikleştirilmiş UI testlerini gerçekleştirmek amacıyla geliştirilmiştir. Selenium WebDriver ve TestNG kullanılarak, sayfa nesne modeli (Page Object Model - POM) mimarisiyle yazılmıştır.

## 🚀 Özellikler

- Kariyer sayfasının yüklenme kontrolleri
- QA departmanına ait açık pozisyonların listelenmesi
- Lokasyon ve departman filtreleme testleri
- Sayfa başlıkları ve URL doğrulama
- Çerez (cookie) bildirimi kapatma
- Temiz kod ve yeniden kullanılabilir sayfa nesneleri

## 🧰 Kullanılan Teknolojiler

- **Java 17**
- **Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)**
- **Maven** - proje bağımlılık yönetimi için
- **WebDriverManager** - otomatik driver yönetimi

## 🗂 Proje Yapısı

├── pom.xml
├── src
│ ├── main
│ │ └── java
│ │ └── Pages
│ │ ├── BasePage.java
│ │ ├── CareerPage.java
│ │ ├── HomePage.java
│ │ ├── ListJobPage.java
│ │ └── QualityAssurancePage.java
│ └── test
│ └── java
│ ├── BaseTest.java
│ ├── CareerPageTest.java
│ ├── HomePageTest.java
│ ├── ListJobPageTest.java
│ └── QualityAssurancePageTest.java

## ▶️ Projeyi Çalıştırma

### Ön Koşullar

- Java JDK 17+
- Maven 3.6+
- Google Chrome tarayıcısı


## 📸 Raporlama ve Ekran Görüntüsü (isteğe bağlı)

Projeye ExtentReports veya Allure entegrasyonu ekleyerek görsel raporlama yapılabilir. Hatalı testlerde ekran görüntüsü almak için `BaseTest` sınıfına ilgili metod eklenebilir.



📧 İletişim: gulcanocakk@gmail.com  
📌 LinkedIn: https://www.linkedin.com/in/gulcan-ocak/

