# nestalk 😊
kakaotalk clone service 의 nestalk 입니다! <br/> 
본 레파지토리는 nestalk backend의 spring 파트입니다 🙌


<br/>

## 개발환경 😎
- jdk 11
- Spring boot 2.4.2
- Spring data JPA 2.4.2
- Maria DB 10.5.5

<br/>

## 구현 기능 🎃
1. 사용자 관리
    - 로그인/로그아웃
    - 회원 가입 및 탈퇴
    - 회원 정보 수정 / 조회
    - 계정 찾기
    - 비밀번호 찾기/변경
2. 프로필 관리
    - 프로필 등록 / 수정
    - 프로필 삭제 시, 기본 프로필로 수정
    - 프로필/배경화면/상태메시지 조회
    - 상태 메시지 관리
    - 배경화면 등록/수정
    - 배경화면 삭제 시, 기본 배경화면으로 수정
3. 채팅 알림 기능
    - 채팅 개설시 알림
    - 채팅 왔을 때 알림(나와 대화중이 아닐 경우에만 해당) => node.js로부터 데이터를 받아서 처리
4. 친구 관리
    - 친구 추가 기능
    - 친구 이름 변경
5. 채팅 목록 조회
    - 채팅 방 최순순으로 정렬
    - 채팅 방 리스트 조회
    - node.js로부터 데이터를 받아 RDBMS에 데이터 등록(채팅방 정보 등록)