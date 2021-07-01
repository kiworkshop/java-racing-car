# 스터디로그 (1차)

### 테스트 메서드 네이밍
- `Given_Preconditions_When_StateUnderTest_Then_ExpectedBehavior` 형식으로 통일
- 참고: [7 Popular Unit Test Naming Conventions](https://dzone.com/articles/7-popular-unit-test-naming)

### `String::repeat`
- String을 반복하는 메서드
- 참고: [repeat](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html#repeat(int))

### `Util`
- 유틸 클래스는 상태를 유지하지 않고 한 가지 기능만 수행해야 한다.

---
# 스터디로그 (2차)



# 질문

## `MoveStrategy` 변수와 테스트

`Race` 클래스에서 사용하는 `MoveStrategy`는 현재 `RandomStrategy` 한 가지이고, 이 변수는 변할 일이 없으니 `Race`에서 `static final` 변수로 선언하여 활용하려 했습니다.

그런데 이렇게 하면, `runOneRoundWith(MoveStrategy strategy)`에서 파라미터가 필요없게 되고, `MoveStrategy`에 따라 테스트를 할 수 없는 상황이 됩니다. 그렇다고 파라미터를 그대로 유지하자니, 메서드를 호출할 때마다 `MoveStrategy` 객체를 참조하는 것이 깔끔가지 않은 것 같습니다.

제가 지금 작성한 코드처럼 `GameController`에서 `MoveStrategy`를 `static final` 필드로 가지고 `Game`에 넘기는 방식이 저는 만족스럽지가 않은데 다른 방법이 떠오르지 않습니다.. 도움을 주실 수 있으실까요?

## `Race` 클래스의 `isRunning()` 메서드

`isRunning()` 메서드가 올바른 bool 값을 리턴하는지 테스트하고 싶은데, 그러려면 `currentRoundCount`의 접근자를 더 공개적으로 바꾸던가 메서드를 추가해야 돼서 테스트를 하지 않았습니다. 이전 1차 미션 때 테스트를 위한 프로덕션 코드의 변경은 지양해야 한다고 느꼈기 때문인데요.. 다른 좋은 방법이 떠오르지 않아서 코드를 이 상태로 나뒀습니다. 혹시 이를 테스트할 필요가 있는지, 테스트를 해야 한다면 어떻게 하면 좋을지 조언 부탁드립니다!

## 예외 처리 Best practice

현재는 예외를 던질 때 필요한 정보값이 없고 메세지만 넘겨 주면 된다고 생각해서 `ExceptionMessage`만 인자로 넘기도록 했습니다. 그런데 현업에서는 로깅도 해야 하니 더 개선된 방식으로 예외를 처리할 것 같은데, 이에 관한 정보를 찾기 어려웠습니다. 혹시 예외처리 관련해서 참고하고 공부할 만한 자료가 있다면 추천 부탁드립니다..!