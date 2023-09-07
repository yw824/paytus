# 프로젝트 : 반응형 웹 페이지 제작

<p align="center">
  <br>
  <img src='./images/emblem.png'>
  <br>
</p>

## 프로젝트 소개

<p align="justify">
레거시 웹 구조를 웹 앱 구조로 설계 변경 

흩어져 있는 페이지 정리 및 모든 이용자의 접근성을 위한  
로그인 기능 없는 웹 페이지 구현

사용자 로그인 및 문의사항 등록 방식에서  
form 문의 입력 방식으로 전환
+
Slack / Email API를 통해 관리자 알림 기능 및 이메일 답장 방식

</p>
<br>

## 기술 스택 - FE

| ReactJS | TailWindCSS   |  Axios   |  JS   |
| :--------: | :--------: | :------: |:-----:|
| ![react]   |![tailwind] | ![axios] | ![js] |

## 기술 스택 - BE

| Gradle | Mybatis |  Springboot   |  Tomcat   |
| :--------: | :--------: | :------: | :-----: |
|   ![gradle]    |   ![mybatis]    | ![springboot] | ![tomcat] |

## 기술 스택 - DB

| ErdCloud | MySQL |
| :--------: | :--------: |
|   ![erdcloud]    |   ![mysql]    |

## 기술 스택 - TEST

| JUnit | Postman |  Swagger   |
| :--------: | :--------: | :------: |
|   ![junit]    |   ![postman]    | ![swagger] |

## 협업 툴

| Figma | Github |  Google Docs |  Notion   |  Slack   |
| :--------: | :--------: | :------: | :-----: | :-----: |
|   ![figma]    |   ![github]    | ![googledocs] | ![notion] | ![slack] |

<br>

## 구현 기능

### 1. 메인 페이지 : 반응형 웹 페이지 구현

다음 순서로 보이도록 페이지 구현

- 간단한 회사 소개
- 차트(이미지)
- 서비스 항목(결제 서비스 + 부가 서비스)
- 문의사항 이동 항목
- 보도자료(뉴스)
- Footer


### 2. FAQ 페이지

- 문의사항 범주
- 고객 정보(성명/고객사/전화번호/이메일)
- 문의 내용
- 신규 고객 여부
- 개인정보동의 여부

- 위의 Form 입력 받으면 => Slack / Email로 문의사항 전달 + DB에 저장


### 3. 공지사항 / 자료실 페이지
```관리자 페이지 :```
- 제목만 먼저 테이블에 표시
- 제목을 누르면 팝업 창이 뜨면서 추가 텍스트 내용 출력
- 관련 자료실 페이지 있으면 링크로 이동 가능하게 설정


```자료실 페이지 : ```
- 누르기만 하면 파일 바로 다운로드 가능
- 파일 이름을 바로 자료실 테이블에 표시
- 누구나 권한 없이 다운로드 가능
- 삭제 기능


### 4. 공지사항 / 자료실 관리자 등록 페이지
- 일정 문제로 인해 세션은 구현하지 못함
- 관리자 ID/PW 직접 입력하도록 구성
  - 전송 시 관리자 데이터 가져와서 인증 과정 내부적으로 구현
- 한번에 단일 파일만 올리도록 구성
  - 대신, 자료실 페이지에서 제목 누르기만 하면 자동으로 다운되므로
    여러 번 클릭하기만 하면 됨
- 내용 입력하고 전송하면, 관리자 업로드 권한 부여 알림 및
  전송 성공 여부 alert문으로 처리 후 리디렉션

<br>

## ERD(DB 구조)
![erd]

## User / Admin Flow
![userflow]

## 아키텍처
![architecture]

## 제작
### 제작 파트
- 박성훈(shprk) : BE
- 이철우(fewolee) : BE
- 이용우(yw824) : FE

### WBS
![wbs]


### 

## 배운 점 & 아쉬운 점

<p align="justify">

</p>

<br>

## 라이센스

MIT &copy; [NoHack](mailto:lbjp114@gmail.com)

<!-- Stack Icon Refernces -->

[logo]: /images/paytus.png
[emblem]: /images/emblem.png

[js]: /images/front/js.png
[react]: /images/front/react.png
[tailwind]: /images/front/tailwind.png
[axios]: /images/front/axios.png

[gradle]: /images/back/gradle.png
[mybatis]: /images/back/mybatis.png
[springboot]: /images/back/springboot.png
[tomcat]: /images/back/tomcat.png

[erdcloud]: /images/db/erdcloud.png
[mysql]: /images/db/mysql.png

[junit]: /images/test/junit.png
[postman]: /images/test/postman.png
[swagger]: /images/test/swagger.png

[figma]: /images/communication/figma.png
[github]: /images/communication/github.png
[googledocs]: /images/communication/googledocs.png
[notion]: /images/communication/notion.png
[slack]: /images/communication/slack.png

[api1]: /images/api1.jpg
[api2]: /images/api2.jpg
[architecture]: /images/architecture.jpg
[erd]: /images/erd.jpg
[userflow]: /images/userflow.jpg
[wbs]: /images/wbs.png