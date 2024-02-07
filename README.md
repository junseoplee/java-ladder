# 1단계 - 사다리 생성
## 기능 요구사항
- **입력**
- [x] 참여자 이름 입력
  - [x] 참여자의 이름은 쉼표(,)를 기준으로 구분한다.
  - [x] 참여자의 이름이 5글자를 초과하면 예외 처리한다.
  - [x] 참여자의 이름에 공백이 포함되면 예외 처리한다.
  - [x] 참여자의 이름에 중복이 포함되면 예외 처리한다.
  - [x] 참여자가 두 명 미만일 경우 예외 처리한다.
- [x] 사다리 높이 입력
  - [x] 정수가 아닌 입력이 들어오면 예외 처리한다.
  - [x] 사다리의 높이가 2보다 작으면 예외 처리한다.

- **생성**
- [x] 사다리 생성
  - [x] 세로 라인은 참여자의 수 만큼 생성한다.
  - [x] 가로 라인 생성
    - [x] 50% 확률로 가로 라인을 생성한다.
    - [x] 만약 가로 라인이 겹친다면 해당 라인은 건너뛴다.
    - [x] 가로 라인의 폭은 5칸이다.

- **출력**
- [x] 사다리를 출력할 때 참여자의 이름도 같이 출력한다.

# 2단계 - 사다리 게임 실행
## 기능 요구사항
- **입력**
- [x] 실행 결과(상금) 입력
  - [x] 결과는 쉼표(,)를 기준으로 구분한다.
  - [x] 구분자 사이에 공백이 있다면 공백을 삭제한다.
  - [x] 결과가 참여자의 수와 일치하지 않는 경우 예외 처리한다.
  - [x] 결과에 공백이 포함되면 예외 처리한다.
  - [x] 결과가 5글자를 초과하면 예외 처리한다.
  - [x] 결과에 'all' 이 포함되면 예외 처리한다.
- [x] 결과를 보고 싶은 사람을 입력받는다.
  - [x] 입력에 공백이 있는 경우 공백을 삭제한다.

- **결과 계산**
- [x] 실행 결과 계산

- **출력**
- [ ] 결과 조회
  - [ ] 결과를 보고 싶은 사람을 지정할 수 있다.
    - [ ] 결과를 보고 싶은 사람의 결과를 출력한다.
    - [ ] 반복해서 조회할 수 있다.
    - [ ] 결과를 보고 싶은 사람이 일치하지 않는 경우 예외 처리한다.
  - [ ] 'all' 을 입력받는 경우 전체 참여자의 결과를 출력하고 종료한다.
  - 
# 설계
- ### 컨트롤러
    - LadderGameController <- 플레이어와 결과를 받아 결과 가져오는 로직 추가
                           <- 실행 결과(상금)을 입력 받아 상금 객체를 만드는 로직 추가
- ### 모델
    - #### 참여자
        - 참여자
        - 참여자들
    - #### 사다리
        - Ladder <- 결과 계산 로직 추가
        - Rung
        - Height
        - 랜덤 결정
    - #### 상금
        - 상금
        - 상금들
    - 사다리 생성기
    - 예외 메세지 enum
- ### 뷰
    - InputView
    - OutputView
    - 사다리 규격 enum
