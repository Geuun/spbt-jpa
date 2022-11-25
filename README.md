

# Springboot-JPA
> SpringBoot/JPA를 활용한 BackEnd REST API 프로젝트


### [Swagger-Ui](http://geun.me:8888/swagger-ui/)

<details>
<summary>[BackEnd] 도서목록 조회 기능 RESTAPI</summary>
<div>

 - REST API
  - EndPoints
    - [GET]
      - [전체 조회] : http://geun.me:8888/api/v1/books
      - [책 Id값으로 조회] : http://http://geun.me:8888/api/v1/books/{id}

</div>
</details>

<details>
<summary>[BackEnd] 병원 및 리뷰 RESTAPI</summary>
<div>

- REST API
  - EndPoints
    - [GET]
      - [{id} 병원의 정보] : http://geun.me:8888/api/v1/hospitals/{id}
      - [{id} 병원의 리뷰 조회] : http://geun.me:8888/api/v1/hospitals/reviews
      - [{id} 리뷰 조회] : http://geun.me:8888/api/v1/hospitals/reviews/{id}
      - [총 병원 등록 수 조회] : http://geun.me:8888/api/v1/hospitals/totalcounts
    - [POST]
       - [새 리뷰 등록] : http://geun.me:8888/api/v1/reviews/{id}

</div>
</details>

---

### Commit Convention
- `feat` : 새로운 기능 추가
- `fix` : 버그 수정
- `docs` : 문서 수정
- `style` : 코드 포맷팅
- `refactor` : 코드 리펙토링
- `test` : 테스트 및 테스트코드 관련
- `chore` : 빌드 및 패키지 매니저 수정