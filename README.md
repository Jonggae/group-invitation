미니 기술 과제
[ 회원 초대 링크 생성 기능 ]

요구 사항
--
1) 참여자 초대

✅ 그룹 매니저는 그룹에 참여자를 초대할 수 있습니다.

✅ 회원 초대 시 DB에 임시 회원을 생성하고 초대 링크를 생성 합니다.

✅ 생성 시에 회원의 이름, 전화번호, 이메일 주소는 필수 값입니다.

---

2) 초대 수락

✅ 초대 받은 사용자는 그룹 참여 초대 링크를 통해 그룹에 참여할 수 있습니다.

✅ 초대 링크 수락 시 임시 회원을 활성화하고 초대 링크를 만료합니다.

✅ 초대 링크는 1회 사용 시 만료됩니다.

---

TODO list

- [ ] 구현 내용 문서 정리
  - [ ]  api 명세
  - [ ]  ERD
  - [ ]  시퀀스 다이어그램
     
- [ ] 초대 링크 만료 관련 개발하기
- [ ] 임시 멤버를 활성화 시킬 때, 예외처리 관련 구현하기 (이미 활성화 된 멤버가 다시 활성화를 하려할 때)




