### 자바 8에서의 비동기 처리, CompletableFuture 

- 멀티코어 프로세서의 등작 => 애플리케이션을 효율적으로 실행하려면 멀티코어를 온전히 활용 가능해야 함
    - 하나의 큰 태스크를 작은 서브태스크로 분할해서 병렬 실행해야 함
    

- 전통적인 스레드 방식 대신에 자바 7에서 지원하는 포크/조인 프레임워크, 자바8의 Stream 병렬 실행하는 방법이 있지만, CPU의 사용을 극대화 하기에는 부족
    - 스레드가 블록됨
    

- Future 인터페이스와 이를 구현하는 새로운 클래스 CompletableFuture 를 이용해서 이와 같은 문제 해결 가능

<br>

***
### Future

- 자바5에서 제공, 미래의 어느 시점의 결과를 얻기 위함

```java
ExecutorService excutor = Executors.newCachedThreadPool();
Future<Double> future = executor.submit(new Callable<Double>() {
    public Double call() {
        return doSomeLongComputation();    
    }
});
doSomethingElse();
try {
    Double result = future.get(1, TimeUnit.SECONDS);  // 오래 걸릴 수 있으므로 타임아웃을 설정 했다.
} catch ( ExecutionException ee) {
    
} catch ( InterruptedException ie) {
    
}
```

<br>

- submit(Callable callable) 실행 순간에 doSomeLongComputation()을 다른 쓰레드로 실행중이지만, future.get 하는 시점에 실행 완료가 안되어 있는경우,
메인 쓰레드는 결과를 얻을 때까지 블락된다.


<br>

***

### Future의 문제점

- '여러 Future 결과가 있을 때, 그 결과를 다른 오래 걸리는 계산에 전달하시오' 와 같은 요구사항을 구현하기 쉽지 않음


- 다음과 같은 요구사항에 대한 기능이 필요함
  - 2개 이상의 비동기 계산 결과를 하나로 합침, 계산 결과는 서로 독립적이거나 2번째 결과가 1번째에 의존하는 상황일 수 있음  
  - Future 집합이 실행하는 모든 태스크의 완료를 기다림  
  - Future 집합에서 가장 빨리 완료되는 태스크를 기다렸다가 가장 빠른걸 얻기
  - 프로그램적으로 Future 완료 (비동기 동작에 값을 수동으로 제공)
  - Future에 완료 동작에 반응 (결과를 기다리면서 블록되지 않고, 결과가 준비되었다는 알림을 받을 때 추가 동작 이행)
  
<br>

***

