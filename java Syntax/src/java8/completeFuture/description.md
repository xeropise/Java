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
    Double result = future.get(1, TimeUnit.SECONDS);
} catch ( ExecutionException ee) {
    
} catch ( InterruptedException ie) {
    
}
```
