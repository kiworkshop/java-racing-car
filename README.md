# 자동차 게임

백개길 자동차 게임 미션 저장소

# 구현해야할 기능 목록
### [X] 입력
    - [X] 이름 입력
    - [X] 시도 횟수 입력

### [] 출력
    - [] 각 자동차의 현재 위치 출력
    - [] 우승자들의 이름 출력

### [] 시도 횟수
    - [x] ERROR : 음수일 경우 
    - [x] ERROR : 숫자가 아닐 경우
    
    - 기능
    - [] 현재 시도 횟수가 남아있을 경우 참을 반환하는 기능 

### [x] 자동차
    - 요소
    - [x] 이름
    - [x] 위치
  
    - 기능
    - [x] 전진
        - [x] 난수 생성기에서 생성된 난수를 인자로 받아 4 이상일 경우 전진
    - [x] 자신의 위치 값 반환
    - [x] 자신의 이름 값 반환
    - [x] 위치 값을 인자로 받은 후 자신의 위치값과 같은 지 비교하는 기능

### [x] 이름
    - [x] ERROR : null 또는 빈 문자열일 경우 
    - [x] ERROR : 5자 초과일 경우
    
    - 기능
    - [x] 이름 문자열 반환

### [x] 위치
    - [x] ERROR : 음수일 경우
    
    - 기능
    - [x] 현재 위치 반환
    
### [x] 모든 자동차 
    - 요소
    - [x] 자동차 리스트
        - [x] ERROR : 2대 미만일 경우   
    - 기능
    - [x] 최대 위치 값을 구하는 기능 
    - [x] 최대 위치 값을 가지는 자동차들의 이름을 반환하는 기능

### [x] 모든 이름
    - 요소
    - [x] 이름 리스트
    
    - 기능
    - [x] 이름 리스트를 반환하는 기능

### [x] 문자열 분리기
    - [x] 인자로 받은 구분자를 기준으로 분리
        - [x] ERROR : 구분자가 존재하지 않을 경우
    - [x] 앞,뒤 공백 제거

### [] 자동차 경주
    - 요소
    - [x] 자동차 리스트
    - [x] 시도 횟수
    
    - 기능
    - [] 시도 횟수만큼 자동차 경주
    - [] 자동차의 최대 위치 값을 반환하는 기능
    - [] 우승자들의 이름을 반환하는 기능
