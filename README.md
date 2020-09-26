병렬 프로그래밍
  - 주요 클래스
    * Future: 비동기 실행의 결과를 나타냄
    * RunnableFuture: ?
    * FutureTask: Future 의 기본 구현
      latch 나 barrier와 유사하게 동기화 수단으로 사용될 수 있음? 
      https://stackoverflow.com/questions/4956822/whats-the-difference-between-future-and-futuretask-in-java 
    * Executor: task 를 실행함. 실행과 작업을 분리했음
      ```java
      // 실행과 작업이 분리되지 않음
      new Thread(() -> System.out.println("hello world")).start();
      // 실행과 작업을 분리함
      // 실행에 대한 관심사는 Executor 가 책임지며, 실행에 대한 부분은 보이지 않는다
      Executor executor  = Executors.newSingleThreadExecutor();
      executor.execute(() -> System.out.println("hello world"));
      ```
    * ExecutorService: 종료를 관리하는 메소드(shutDown, shutDownNow, awaitTermination...)와 
      하나 이상의 비동기 작업의 진행 상황을 추적할 수 있는 Future 를 만들어내는 메소드(submit, invoke, invokeAll...)를 제공한다. 
    * AbstractExecutorService: ExecutorService 의 구현(submit, invoke, invokeAll)을 제공한다. 
      submit, invoke, invokeAll 은 RunnableFuture 를 반환한다.
    * ThreadPoolExecutor:
    * ThreadFactory: 스레드 생성
  - 중단 및 종료
    * 자바에는 스레드가 작업을 실행하고 있을 때 강제로 멈추도록 하는 방법이 없다
    * 인터럽트는 특정 스레드에게 작업을 멈춰달라고 요청하는 것이다
    * 스레드를 멈출 때 즉시 멈추는 게 아니라 진행중이던 작업을 정리한 다음 종료하도록 해야한다
    * 작업을 진행하던 스레드가 직접 마무리하는 게 좋다
    
    * 작업 중단
      * 작업 중단이 필요한 다양한 요구사항
        * 사용자의 취소 요청: GUI 화면에서 취소 버튼
        * 시간이 제한된 작업: 일정 시간 이내 결과를 찾다가 시간이 지나면 종료
        * 애플리케이션 이벤트: 작업을 진행하다가 원하는 값을 얻으면 종료
        * 오류: 오류가 발생하면 이전에 작업했던 내용을 제거하고 종료
        * 종료: 종료할 때 현재 진행중이던 작업 종료, 대기 큐 제거 등등
      * 특정 스레드를 명확하게 종료시킬 수 있는 방법은 없다
      * 기본적인 작업 종료 방법
        * 취소 요청에 대한 플래그 설정
        * 실행 중인 작업은 취소 요청 플래그를 주기적으로 확인
      * 작업을 쉽게 취소시킬 수 있도록 만들려면 취소 정책을 명확히 정의해야한다
        * 어떤 방법으로 취소 요청을 보낼 수 있는 지
        * 작업 내부에서 취소 요청이 들어 왔는지를 언제 확인하는 지
        * 취소 요청이 들어오면 실행 중이던 작업이 어떤 형태로 동작하는 지
      * 인터럽트
        * 위와 같은 방식으로 작업 종료할 때 작업 내부에 블로킹 연산이 있다면 취소 요청이 들어왔는 지 확인하지 못할 수 있다
        * 블로킹 API 중 일부는 인터럽트할 수 있다
        * 인터럽트는 실행 중이던 작업을 멈추고 다른 일을 할 수 있도록 해야한다고 신호를 보내는 것과 같다
        * 모든 스레드는 인터럽트 상태를 갖고 있다
        * static interrupted 는 인터럽트 상태를 해제하고 해제하기 이전의 값이 무엇인지 알려준다
        * wait, sleep 은 인터럽트가 걸리면 인터럽트 상태를 해제하면서 예외를 던진다
        * 스레드가 블록되어 있지 않은 실행 상태에서 인터럽트가 걸린다면 먼저 인터럽트 상태 변수가 설정되긴 하지만
          인터럽트가 걸렸는 지 확인하고 대응하는 일은 스레드가 알아서 해야한다
