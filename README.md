Crud Practice Project

Java Spring을 이용한 간단한 CRUD 게시판

배포 환경:

데이터베이스: MySQL (JpaRepository 사용) → Azure 배포

서버: AWS Elastic Beanstalk

🔗 접속 URL: http://choiwooheoncrud-env.eba-svmgzvb8.ap-southeast-2.elasticbeanstalk.com/main


🚀 구현 기능

🔑 인증 및 사용자 관리

✅ 로그인 / 회원가입


📝 게시판 기능

✅ 글 작성 / 삭제

✅ 댓글 작성 / 삭제

🎯 개선할 점 (To-Do)
🔹 비밀번호 암호화 → 현재 Member 테이블에서 비밀번호를 암호화하지 않음

➝ BCrypt 또는 Argon2 알고리즘 적용

🔹 세션 방식 개선 → 로그인 확인을 Session이 아닌 JWT 토큰 기반 인증으로 변경

🔹 게시글 및 댓글 수정 기능 추가

💻 개발 환경
기술	버전

Java	17

Spring Boot	3.4.3

MySQL	8.0.4

JPA	최신 버전 사용

AWS Elastic Beanstalk	배포 환경

Azure	데이터베이스 배포

📌 프로젝트 실행 방법

# 프로젝트 클론
git clone https://github.com/wooheon00/Crud_practice.git

# 프로젝트 이동
cd Crud_practice

# 실행 (Spring Boot)
./mvnw spring-boot:run
