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

## 스레드 우선순위

* 멀티 스레드는 동시성 또는 병렬성으로 실행된다.

    * 동시성은 멀티 작업을 위해 하나의 코어에서 멀티 스레드가 번갈아가며 실행하는 성질을 말한다.

    * 병렬성은 멀티 작업을 위해 멀티 코어에서 개별 스레드를 동시에 실행하는 성질을 말한다.

* 스레드 스케줄링이란 스레드의 개수가 코어의 수보다 많을 경우, 어떤 순서에 의해 동시성을 실행할 것인가를 결정하는 것을 말한다.

    * 우선순위 방식은 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 하는 스케줄링하는 것이다.

        * 우선순위 변경 시, Thread 클래스의 setPriority() 메소드를 사용한다.

    * 순환 할당 방식은 시간 할당량을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다시 다른 스레드를 실행하는 방식이다.

_[CalcThread.java] 참고_

_[PriorityExample.java] 참고_

## 동기화 메소드와 동기화 블록
### 공유 객체를 사용할 때의 주의할 점

* 싱글 스레드 프로그램에서는 한 개의 스레드가 객체를 독차지해서 사용하면 되지만, 멀티 스레드 프로그램에서는 스레드들이 객체를 공유해서 작업해야 하는 경우가 있다.

* 이 때, 스레드 A를 사용하던 객체가 스레드 B에 의해 상태가 변경될 수 있기 때문에 의도와 다른 결과가 산출될 수도 있다.

### 동기화 메소드 및 동기화 블록

* 멀티 스레드 프로그램에서 단 하나의 스레드만 실행할 수 있는 코드 영역을 임계 영역이라고 한다.

* 임계 영역을 지정하기 위해 동기화 메소드와 동기화 블록을 제공한다.

* 동기화 메소드를 만드는 방법은 메소드 선언에 synchronized 키워드를 붙이면 된다.

```java
public synchronized void method(){
    임계 영역; //단 하나의 스레드만 실행
}
```

* 동기화 메소드를 실행하는 즉시 객체에는 잠금이 일어나고, 스레드가 동기화 메소드를 실행 종료하면 잠금이 풀린다.

* 일부 내용만 임계 영역으로 만들고 싶다면 동기화 블록을 만들면 된다.

_[MainThreadExample.java] 참고_

_[Calculator.java] 참고_

_[User1.java] 참고_

_[User2.java] 참고_

## 스레드 상태

* 스레드 객체 생성 후, start() 메소드를 호출하면 실행 대기 상태가 된다.

* 실행 대기 상태에 있는 스레드 중에 선택된 스레드가 CPU를 점유하고 run() 메소드를 실행한다. 이때를 실행 상태라고 한다.

* 스레드는 실행 대기 상태와 실행 상태를 번갈아 가며 run() 메소드를 조금씩 실행한다.

* run() 메소드가 종료되면, 스레드의 실행은 멈추게 되고 이를 종료 상태라고 한다.

* 실행 상태에서 일시 정지 상태로 가기도 하는데, 일시 정지 상태는 스레드가 실행할 수 없는 상태이다.

* 이러한 스레드의 상태를 확인하려면 getState() 메소드를 사용한다.

_[StatePrintThread.java] 참고_

_[TargetThread.java] 참고_

_[ThreadStateExample.java] 참고_

## 스레드 상태 제어

* 실행중인 스레드의 상태를 변경하는 것을 스레드 상태 제어라고 한다.

### 주어진 시간동안 일시 정지(sleep())

* sleep() 메소드를 호출한 스레드는 주어진 시간 동안 일시 정지 상태가 되고, 다시 실행 대기 상태로 돌아간다.

### 다른 스레드에게 실행 양보(yield())

* yield() 메소드를 호출한 스레드는 실행 대기 상태로 돌아가고 동일하거나 높은 우선순위를 갖는 다른 스레드가 실행 기회를 가질 수 있도록 해준다.

### 다른 스레드의 종료 기다림(join())

* 다른 스레드가 종료될 때까지 기다렸다가 실행해야 하는 경우가 발생할 수도 는데 이 때, join() 메소드를 사용할 수 있다.

### 스레드 간 협업(wait(), notify(), notifyAll())

* 두 개의 스레드를 교대로 번갈아가며 실행해야 할 경우, 공유 객체를 사용한다.

* 공유 객체는 두 스레드가 작업할 내용을 각각 동기화 메소드로 구분해 놓는다.

* 한 스레드가 작업을 완료하면 notify() 메소드를 호출해서 일시 정지 상태에 있는 다른 스레드를 실행 대기 상태로 만들고, 자신은 두번 작업을 하지 않도록 wait() 메소드를 호출하여 일시 정지 상태로 만든다.

* notify()는 wait()에 의해 일시 정지된 스레드 중 한 개를, notifyAll()는 wait()에 의해 모든 스레드를 실행 대기 상태로 만든다.

### 스레드의 안전한 종료(stop 플래그, interrupt())

#### stop 플래그를 이용하는 방법

* stop플래그를 이용해서 run() 메소드가 정상적으로 종료되도록 유도하는 것이 최선의 방법이다.

```java
public class XXXThread extends Thread {
    private boolean stop; //stop 플래그 필드

    public void run() {
        while(!stop) {
            스레드가 반복 실행하는 코드;
        }
        //스레드가 사용한 자원 정리
    }
}
```

#### interrupt() 메소드를 이용하는 방법

* interrupt() 메소드는 스레드가 일시 정지 상태에 있을 때 InterruptedException 예외를 발생시키는 역할을 한다.

* 이는 run() 메소드를 정상 종료 시킨다.

## 데몬 스레드

* 데몬 스레드는 주 스레드의 작업을 돕는 보조적인 역할을 수행하는 스레드이다.

* 주 스레드가 종료되면 데몬 스레드는 강제적으로 자동 종료되는데, 그 이유는 주 스레드의 보조 역할을 수행하므로 주 스레드가 종료되면 데몬 스레드의 존재 의미가 없어지기 때문이다.

* 주 스레드가 데몬이 될 스레드의 setDaemon(true)를 호출해주면 된다.

```java
public static void main(String[] args){
    AutoSaveThread thread = new AutoSaveThread(); //데몬 스레드
    thread.setDaemon(true);
    thread.start();
    ...
}
```

## 스레드 그룹

* 스레드 그룹은 관련된 스레드를 묶어서 관리할 목적으로 이용된다.

* JVM이 실행되면 system 스레드 그룹을 만들고, JVM 운영에 필요한 스레드들을 생성해서 system 스레드 그룹에 포함시킨다.

### 스레드 그룹 이름 얻기

```java
ThreadGroup group = Thread.currentThread().getThreadGroup();
String groupName = group.getName();
```

_[ThreadInfoExample.java] 참고_

### 스레드 그룹 생성

```java
ThreadGroup tg = new ThreadGroup(String name);
ThreadGroup tg = new ThreadGroup(ThreadGroup parent, String name);
```

* 스레드 생성 시 부모 스레드 그룹을 지정하지 않으면 현재 스레드가 속한 그룹의 하위 그룹으로 생성된다.

### 스레드 그룹의 일괄 interrupt()

* interrupt() 메소드를 이용하면 그룹 내에 포함된 모든 스레드들을 일괄 interrupt 할 수 있다.

## 스레드풀

* 갑작스런 병렬 작업의 폭증으로 인한 스레드의 폭증을 막으려면 스레드풀을 사용해야 한다.

* 스레드풀은 작업 처리에 사용되는 스레드를 제한된 개수만큼 정해 놓고 작업 큐에 들어오는 작업들을 하나씩 스레드가 맡아 처리한다.

* Executors의 다양한 정적 메소드를 이용해서 ExecutorService 구현 객체를 만들 수 있는데, 이것이 스레드풀이다.

### 스레드풀 생성 및 종료
#### 스레드풀 생성

```java
//ExecutorService 구현 객체
ExecutorService executorService = Executors.newCachedThreadPool();
//CPU 코어의 수만큼 최대 스레드를 사용하는 스레드풀 생성
ExecutorService executorService = Executors.newFixedThreadPool(
    Runtime.getRuntime().availableProcessors()
);
```

* 코어 스레드 개수와 최대 스레드 개수를 설정하고 싶다면, 직접 ThreadPoolExecutor 객체를 생성하면 된다.

#### 스레드풀 종료

* 종료를 위한 메소드로는 shutdown(), shutdownNow(), awaitTermination(long timeout, TimeUnit unit)이 있다.

### 작업 생성과 처리 요청
#### 작업 생성

* 하나의 작업은 Runnable 또는 Callable 구현 클래스로 표현한다.

    * Runnable의 run() 메소드는 리턴값이 없고, Callable의 call() 메소드는 리턴값이 있다.

#### 작업 처리 요청

* 이는 ExecutoService의 작업 큐에 Runnable 또는 Callable 객체를 넣는 행위를 말한다.

* 작업 처리 요청을 위한 메소드로는 execute()와 submit()이 있다.

    * execute()는 작업 처리 결과를 받지 못하고 submit()은 받을 수 있다.

    * execute()는 작업 처리 도중 예외가 발생하면 스레드가 종료되고 해당 스레드는 스레드풀에서 제거되는 반면, submit()은 예외가 발생해도 스레드는 종료되지 않고 다음 작업을 위해 재사용된다.

_[ExecuteExample.java] 참고_

### 블로킹 방식의 작업 완료 통보

* ExecutorService의 submit() 메소드는 매개값으로 준 Runnable 또는 Callable 작업을 스레드 풀의 작업 큐에 저장하고 즉시 Future 객체를 리턴한다.

* Future 객체는 지연 완료 객체라고도 하는데 작업이 완료될 때까지 기다렸다가 최종 결과를 얻는데 사용된다.

* Future의 get() 메소드를 호출하면 스레드가 작업을 완료할 때까지 블로킹 되었다가 작업을 완료하면 처리 결과를 리턴하는데 이것이 작업 완료 통보 방식이다.

### 콜백 방식의 작업 완료 통보

* 콜백이란 애플리케이션이 스레드에게 작업 처리를 요청한 후, 스레드가 작업을 완료하면 특정 메소드를 자동 실행하는 기법을 말한다.

* 블로킹 방식은 작업 처리를 요청한 후 작업이 완료될 때까지 블로킹되지만, 콜백 방식은 작업 처리를 요청한 후 결과를 기다릴 필요 없이 다른 긴으을 수행할 수 있다.

* ExecutorService는 콜백을 위한 별도의 기능을 제공하지 않는다. 대신 Runnable 구현 클래스를 작성할 때 콜백 기능을 구현할 수 있다.