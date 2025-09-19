# Keelung Sights Viewer

本專案為「基隆景點瀏覽器」，使用 Spring Boot、MongoDB 及 JSoup 實作，並以 Bootstrap 製作前端介面。  
使用者可依照行政區瀏覽基隆市各景點資訊，並可點擊地址連結至 Google Maps。

## 特色功能

-   爬取旅遊網站資料，並儲存至 MongoDB
-   提供 RESTful API 查詢指定行政區景點
-   前端以 Bootstrap 呈現卡片式景點資訊
-   支援 Google Maps 地址跳轉

## 技術架構

-   **後端**：Spring Boot、Spring Data MongoDB、JSoup
-   **前端**：HTML、CSS、JavaScript、Bootstrap
-   **資料庫**：MongoDB

## 使用方式

1. 啟動 MongoDB 並設定連線資訊於 `application.properties`
2. 執行 Spring Boot 應用程式
3. 於瀏覽器開啟首頁，選擇行政區即可瀏覽景點

## API 說明

-   `GET /SightAPI?zone={行政區}`  
     回傳該行政區所有景點資訊

## 專案結構

-   `src/main/java/com/example`：Java 程式碼
-   `src/main/resources/static`：前端靜態資源
-   `src/main/resources/application.properties`：設定檔

## 貢獻者

-   [owen0806]

---

2024 NTOU Summer Homework
