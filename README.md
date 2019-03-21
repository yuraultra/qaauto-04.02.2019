1. Скачать и установить "Java SE Development Kit 8u201"
URL https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-windows-x64.exe
2. Скачать и установить "IntelliJ IDEA" бесплатную версию
URL https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC
3. Зайти в репозитории maven "Selenium Java » 3.141.59"
URL https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59
и прописать в файле проэкта "pom.xml" следующие строки:
    <dependencies>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>3.141.59</version>
        </dependency>
    </dependencies>
4. Скачать и установить "ChromeDriver"
URL https://chromedriver.storage.googleapis.com/2.46/chromedriver_win32.zip
файл из архива скопировать в директорию C:\Windows\System32\
