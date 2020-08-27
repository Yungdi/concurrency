병렬 프로그래밍
  - 주요 클래스
    * Future: 비동기 실행의 결과를 나타냄
    * Executor: task 를 실행함. 실행과 작업을 분리했음
      ```java
      // 실행과 작업이 분리되지 않음
      new Thread(() -> System.out.println("hello world")).start();
      // 실행과 작업을 분리함
      // 실행에 대한 관심사는 Executor 가 책임지며, 실행에 대한 부분은 보이지 않는다.
      Executor executor  = Executors.newSingleThreadExecutor();
      executor.execute(() -> System.out.println("hello world"));
