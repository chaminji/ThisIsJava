# 11. 멀티 스레드
## 멀티 스레드 개념
### 프로세스와 스레드

* 프로세스란 실행 중인 하나의 애플리케이션이다.

* 멀티 태스킹은 두 가지 이상의 작업을 동시에 처리하는 것을 말한다.

* 하나의 프로세스가 두 가지 이상의 작업을 처리할 수 있도록 하는 것은 멀티 스레드의 도움을 받는다.

* 하나의 스레드는 하나의 코드 실행 흐름이기 때문에 한 프로세스 내에 스레드가 두 개라면 두 개의 코드 실행 흐름이 생긴다는 의미이다.

### 메인 스레드

* 메인 스레드는 main() 메소드의 첫 코드부터 순차적으로 실행하고, main() 메소드의 마지막 코드를 실행하거나 return문을 만나면 실행이 종료된다.

* 멀티 스레드 애플리케이션에서 실행 중인 스레드가 하나라도 있다면, 프로세스는 종료되지 않는다.

## 작업 스레드 생성과 실행

* 병렬로 실행할 작업을 결정하고, 각 작업별로 스레드를 생성한다.

### Thread 클래스로부터 직접 생성

* Runnable을 매개값으로 갖는 생성자를 호출해야 한다.

```java
Thread thread = new Thread(Runnable target);
```

* Runnable(인터페이스 타입)은 작업 스레드가 실행할 수 있는 코드를 가지고 있는 객체라고 해서 붙여진 이름이다.

* Runnable에는 run() 메소드 하나가 정의되어 있는데, 구현 클래스는 run()을 재정의해서 작업 스레드가 실행할 코드를 작성해야 한다.

```java
class Task implements Runnable{
    public void run(){
        스레드가 실행할 코드;
    }
}
```

* Runnalbe은 작업 내용을 가지고 있는 객체이고 실제 스레드는 아니다.

```java
Runnable task = new Task(); //구현 객체 생성
Thread thread = new Thread(task); //객체를 매개값으로 Thread 생성자 호출
```

_[BeepPrintExample1.java] 참고_

_[BeepTask.java] 참고_

_[BeepPrintExample2.java] 참고_

### Thread 하위 클래스로부터 생성

```java
public class WorkerThread extends Thread{
    @Override
    public void run(){
        //스레드가 실행할 코드
    }
}
Thread thread = new WorkerThread();
```

_[BeepThread.java] 참고_

_[BeepPrintExample3.java] 참고_

### 스레드의 이름

* 스레드는 자동적으로 "Thread-n"이라는 이름으로 설정되는데, 다른 이름으로 설정하고 싶다면 setName() 메소드로 변경하면 된다.

* 스레드의 이름을 알고 싶을 경우에는 getName() 메소드를 호출하면 된다.

* 스레드의 객체 참조가 필요할 때, currentThread() 로 코드를 실행하는 현재 스레드의 참조를 얻을 수 있다.

_[ThreadNameExample.java] 참고_

_[ThreadA.java] 참고_

_[ThreadB.java] 참고_