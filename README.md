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
-   **容器化**：Docker、Docker Compose

## 快速開始

### 環境需求

-   Docker
-   Docker Compose

### 安裝與執行

1. **複製專案**

    ```bash
    git clone https://github.com/owen0806/KeelungSightsViewer.git
    cd KeelungSightsViewer
    ```

2. **使用 Docker Compose 啟動**

    ```bash
    docker-compose up -d
    ```

3. **查看服務狀態**

    ```bash
    docker-compose ps
    ```

4. **開啟瀏覽器**
   前往 http://localhost:8080 即可使用

### 停止服務

```bash
docker-compose down
```

如需完全清除資料，包含 MongoDB 資料：

```bash
docker-compose down -v
```

## 本地開發

### 環境需求

-   Java 17+
-   Maven 3.6+
-   MongoDB（本地安裝或使用 MongoDB Atlas）

## 使用方式

1. 於瀏覽器開啟首頁
2. 選擇行政區即可瀏覽景點
3. 點擊地址可跳轉至 Google Maps

## API 說明

-   `GET /SightAPI?zone={行政區}`  
     回傳該行政區所有景點資訊

## 服務說明

### MongoDB 設定

-   **容器名稱**：keelung-sights-mongodb
-   **連接埠**：27017
-   **資料庫名稱**：sights
-   **預設帳號**：admin / password

### 應用程式設定

-   **容器名稱**：keelung-sights-app
-   **連接埠**：8080
-   **環境變數**：
    -   `PORT=8080`
    -   `MONGODB_URI=mongodb://admin:password@mongodb:27017/sights?authSource=admin`

## 專案結構

-   `src/main/java/com/example`：Java 程式碼
-   `src/main/resources/static`：前端靜態資源
-   `src/main/resources/application.properties`：設定檔
-   `docker-compose.yml`：Docker Compose 配置
-   `Dockerfile`：Docker 配置
-   `mongo-init.js`：MongoDB 初始化腳本

## 貢獻者

-   owen0806

---

2024 NTOU Summer Homework
