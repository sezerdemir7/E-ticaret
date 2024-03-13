## Proje Hakkında:

Bu proje, Spring Boot kullanarak geliştirilmiş bir e-ticaret web sitesi örneğidir. Proje, ürün katalogu, sepet, ödeme ve sipariş yönetimi gibi temel e-ticaret işlevlerini içerir.

### Kullanılan Teknolojiler:

#### Backend:
- Spring Boot 2.7.0
- Java 17
- PostgreSql
- Lombok
- Spring Data JPA


## Proje Kurulumu:

### Backend:
1. Projeyi klonlayın: `git clone https://github.com/sezerdemir7/E-ticaret.git`
2. `backend` dizinine gidin: `cd backend`
3. Maven'i kullanarak projeyi kurun: `mvn clean install`
4. Veritabanını oluşturun ve `application.properties` dosyasında gerekli bağlantı bilgilerini girin.



## Proje Kullanımı:

- Uygulamaya web tarayıcınızdan `localhost:8080` adresinden erişebilirsiniz.
- Ürünler ekleyebilir, düzenleyebilir ve silebilirsiniz.
- Sepetinizi yönetebilir ve sipariş verebilirsiniz.

## Proje Özellikleri:

- Temel CRUD işlemleri
- Ürün kataloğu yönetimi
- Sepet ve ödeme işlevleri
- Sipariş yönetimi




## E-Ticaret Projesi API Endpoints
Bu tablo, projenin sunduğu API endpoint'lerini listeler.

### GET İstekleri

| URL | Açıklama |
|---|---|
| `/customer` | Tüm müşterileri listeler. |
| `/customer/{{id}}` | Belirli ID'ye sahip müşteriyi getirir. |
| `/cart` | Sepet içeriğini getirir. |
| `/cart/{{customerId}}` | Belirtilen müşteriye ait sepeti getirir. |
| `/cartItem/customerId/{{customerId}}` | Belirtilen müşteriye ait tüm sepet öğelerini getirir. |
| `/cartItem/{{cartItemId}}` | Belirli ID'ye sahip sepet öğesini getirir. |
| `/orderdetail/{{orderId}}` | Belirtilen siparişin detaylarını getirir. |
| `/product` | Tüm ürünleri listeler. |
| `/product/category/{{categoryname}}` | Belirli bir kategoriye ait ürünleri listeler. |
| `/product/{{productname}}` | Belirtilen ürün adına sahip ürünü getirir. |
| `/siparis/aktif/{{customerId}}` | Belirtilen müşterinin aktif siparişlerini listeler. |
| `/siparis/tamamlanan/{{customerId}}` | Belirtilen müşterinin tamamlanmış siparişlerini listeler. |
| `/favoriler` | Favorileri listeler. |
| `/favoriler/{{favoriteId}}` | Belirli bir ID'ye sahip favoriyi getirir. |
| `/category` | Tüm kategorileri listeler. |
| `/store/getAllStore` | Tüm mağazaları listeler. |
| `/store/getStoreById` | Belirli bir ID'ye sahip mağazayı getirir. |

### POST İstekleri

| URL | Açıklama |
|---|---|
| `/customer` | Yeni bir müşteri oluşturur. |
| `/shoppingcart/siparis_ver/{{customerId}}` | Sepetteki ürünleri siparişe çevirir. |
| `/cartItem` | Sepete yeni bir ürün ekler. |
| `/seller` | Yeni bir satıcı oluşturur. |
| `/product` | Yeni bir ürün oluşturur. |
| `/favoriler` | Yeni bir favori ekler. |
| `/category` | Yeni bir kategori oluşturur. |
| `/payment` | Ödemeyi gerçekleştirir. |
| `/store/saveStore` | Yeni bir mağaza oluşturur. |

### PUT İstekleri

| URL | Açıklama |
|---|---|
| `/customer/updateadres/{{id}}` | Belirli bir müşterinin adresini günceller. |
| `/product/{{id}}` | Belirli bir ürünün stok veya fiyat bilgisini günceller. |

### DELETE İstekleri

| URL | Açıklama |
|---|---|
| `/customer/deletecustomer/{{id}}` | Belirli bir müşteriyi siler. |
| `/cartItem/{{customerId}}/{{productId}}` | Belirtilen sepetten belirtilen ürünü siler. |
| `/favoriler/{{favoriteId}}` | Belirtilen favoriyi siler. |



## Notlar:

- Bu proje, e-ticaret web sitesinin temel bir örneğidir. Gelişmiş işlevler eklemek için projeyi özelleştirebilirsiniz.
- Proje ile ilgili herhangi bir sorun veya sorunuz olursa, GitHub'da bir issue açabilirsiniz.

## Destek:

Bu projeyi beğendiyseniz,GitHub'da yıldız vererek ve paylaşarak desteğinizi gösterin.
