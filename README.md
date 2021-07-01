# 자동차 게임

백개길 자동차 게임 미션 저장소

### 구현할 기능 목록 (1차)

- 자동차 이름 입력받기
    - 자동차 이름 길이 체크(1~5자)
    - 자동차 이름 ,로 구분하기
    - 공백/null 체크
- 시도할 횟수 입력받기
- 랜덤 boolean값 추출하기
- 시도할 횟수만큼 자동차 움직이기
- 결과 출력
- 우승자 출력


### 구현할 기능 목록 (2차)

- [x] `Candidate` 대신 `Race`에 `List<Car>` 필드로 갖고 관리하기
- [x] rename `RandomStrategy` → `MoveStrategy`
- [x] `race`와 `round` 명칭 혼용 이슈 해결
- [x] 도메인의 `toString()`에 담긴 로직을 View로 이동하기
- [ ] Exception 메세지를 View와 분리하기
