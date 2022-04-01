# 빌드하고 실행하기
- 명령프롬프트에서 실행
### 빌드
1. 프로젝트 폴더로 이동
   - cd C:\Users\sng22\Desktop\git\SpringBasic\hello-spring
2. 빌드하기
   - 윈도우의 경우
     - gradlew.bat build
   - 맥의 경우
     - ./gradlew build
### 실행
1. 프로젝트 폴더의 build의 libs로 이동
   - cd C:\Users\sng22\Desktop\git\SpringBasic\hello-spring\build\libs
2. dir로 파일 확인
   - dir
3. jar 파일 실행
   - java -jar 파일이름.jar
   
### 빌드 폴더 삭제하기
- 윈도우의 경우
  - gradlew.bat clean
- 맥의 경우
  - ./gradlew clean