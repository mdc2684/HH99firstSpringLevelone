# 항해99 Spring 1주차 과제

1. 수정, 삭제 API의 request를 어떤 방식으로 사용하셨나요? (param, query, body)

  @PutMapping("/api/board/{id}") /   @DeleteMapping("/api/board/{id}")

2. 어떤 상황에 어떤 방식의 request를 써야하나요?

  작성은 POST
  수정은 PUT
  삭제는 DELETE
  조회는 GET

3. RESTful한 API를 설계했나요? 어떤 부분이 그런가요? 어떤 부분이 그렇지 않나요?
  
  CRUD 메서드를 모두 사용하였다.
  
4. 적절한 관심사 분리를 적용하였나요? (Controller, Repository, Service)

  Controller에서 클라이언트 정보를 받아서 Service로 넘겨주었다.
  그리고 Board와 연결되 있는 Repository에서 JPA를 상속받아 메서드들을 사용했고,
  모든 게시글조회할 때에는 쿼리메서드를 만들어 내림차순으로 조회할 수 있도록 해보았다.

5. API 명세서 작성 가이드라인을 검색하여 직접 작성한 API 명세서와 비교해보세요!


메인페이지 GET	  /	                 index.html
생성하기	 POST	 /api/board	        Board
단일조회	 GET	 /api/board/{id}	  Optional<board>
전체조회   GET   /api/board         List<board>
변경하기	 PUT	 /api/board/{id}	  String
삭제하기	 DELETE	/api/board/{id}	  String
