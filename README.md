# Paytus_HomePage 
- 반응형 웹 페이지 작성 


## Backend : SpringBoot
- Java JDK 11
- Spring Boot 2.7.14(Gradle - Groovy)
  - Lombok
  - Spring Web
  - MySQL Driver
- port 8082
- IntelliJ 


## SQL : MySQL 
- v8.0
- MySQL Workbench - MySQL와 Version Sync 맞추기


## Frontend : ReactJS + TailWindCSS
- Node.js : v18.17.0 LTS
- port 3005 -> proxy -> port 8082
  - SpringBoot와 React를 연동하면서, reactBuild 과정을  
    SpringBoot Build 과정에 연동
- Vscode
  - vscode 추가 plugin : Tailwind CSS Intellisense
- packages
```
npx create-react-app frontend

npm install react-icons --save

npm install react-router-dom
npm install http-proxy-middleware --save
npm install axios --save

npm install -D tailwindcss
npx tailwindcss init
```