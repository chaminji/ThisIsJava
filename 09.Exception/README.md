# 09. 예외 처리
## 예외와 예외 클래스

* 예외란 사용자의 잘못된 조작 또는 개발자의 잘못된 코딩으로 인해 발생하는 프로그램 오류를 말한다.

* 에러와는 다르게 예외는 예외 처리를 통해 정상 실행 상태를 유지시킬 수 있다.

* 예외에는 일반 예외와 실행 예외가 있다.

    * 일반 예외는 예외 처리 코드가 없다면 컴파일 오류가 발생한다.

    * 실행 예외는 컴파일 시 예외 처리 코드를 검사하지 않는 예외이다.

    * 실행 예외는 java.lang.RuntimeException을 상속받은 클래스들이다.

## 실행 예외

* 개발자가 예외 처리 코드를 삽입해야 한다.

### NullPointException

* 객체 참조가 없는, null 값을 갖는 참조 변수로 접근 했을 때 발생한다.

_[NullPointExceptionExample.java] 참고_

### ArrayIndexOutOfBoundsException

* 배열에서 인덱스 범위를 초과할 경우 발생한다.

_[ArrayIndexOutOfBoundsExceptionExample.java] 참고_

### NumberFormatException

* 포장(Wrapper) 클래스의 정적 메소드인 parseXX() 메소드를 이용하면 문자열을 숫자로 변환할 수 있다.

* 이 때, 변환이 가능하면 숫자를 리턴하고, 불가능 하면 java.lang.NumberFormatException을 발생시킨다.

_[NumberFormatException.java] 참고_

### ClassCastException

* 타입 변환은 상위 클래스와 하위 클래스, 구현 클래스와 인터페이스 간에 발생한다.

* 이러한 관계가 아니라면 클래스는 다른 클래스로 변환할 수 없고, 억지로 변환을 시도할 경우 ClassCastException이 발생한다.

_[ClassCastExceptionExample.java] 참고_

## 예외 처리 코드

* 프로그램에서 예외가 발생했을 경우 프로그램의 갑작스러운 종료를 막고, 정상 실행을 유지할 수 있도록 처리하는 코드를 예외 처리 코드라고 한다.

* 예외 처리 코드는 try-catch-finally 블록을 이용한다.

    * try 블록에는 예외 발생 가능 코드가 위치한다.

    * try 블록의 코드가 정상 실행되면 finally 코드를 실행한다.

    * try 블록의 코드에서 예외가 발생하면 즉시 실행을 멈추고 catch 블록으로 이동하여 예외 처리 코드를 실행한 후 finally 블록의 코드를 실행한다.

_[TryCatchFinallyExample.java] 참고_

_[TryCatchFinallyRuntimeExceptionExample.java] 참고_

## 예외 종류에 따른 처리 코드

### 다중 catch

* 다양한 종류의 예외가 발생할 경우를 대비하여 다중 catch 블록을 작성한다.

* catch 블록이 여러 개라 할지라도 단 하나의 catch 블록만 실행된다.

### catch 순서

* 작성 시 주의할 점은 사우이 예외 클래스가 하위 예외 클래스보다 아래쪽에 위치해야 한다는 점이다.

* 하위 예외는 상위 예외를 상속했기 때문에 상위 예외 타입도 가능하기 때문이다.

### 멀티 catch

* 자바 7부터 하나의 catch 블록에서 여러 개의 예외를 처리할 수 있도록 멀티 catch 기능을 추가했다.

* catch 괄호 () 안에 동일하게 처리하고 싶은 예외를 | 로 연결하면 된다.

```java
try{
    ...
} catch (ArrayIndexOutOfBoundsException|NumberFormatException e) {
    ...
}
```

## 자동 리소스 닫기

* try 블록이 정상적으로 실행을 완료했거나 도중에 예외가 발생하게 되면 자동으로 FileInputStream의 close() 메소드가 호출된다.

* try-with-resources를 사용하기 위해서는 java.lang.AutoCloseable 인터페이스를 구현하고 있어야 한다. 이 때 try-with-resources는 close() 메소드를 자동으로 호출한다.

## 예외 떠넘기기

* throws 키워드는 메소드 선언부의 끝에 작성되어 메소드에서 처리하지 않은 예외를 호출한 곳으로 떠넘기는 역할을 한다.

* throws 키워드 뒤에는 떠넘길 예외 클래스를 쉼표로 구분해서 나열하면 된다.

* throwsException만으로 모든 예외를 간단히 떠넘길 수도 있다.

## 사용자 정의 예외와 예외 발생

* 어플리케이션 예외라고도 하며 개발자가 직접 정의해서 만드는 예외이다.

### 사용자 정의 예외 클래스 선언

```java
public class XXXException extends [ Exception | RuntimeException] {
    public XXXException() { }
    public XXXException(String message) { super(message); }
}
```

### 예외 발생시키기

```java
throw new XXXException();
throw new XXXException("메시지");
```

* 예외 객체를 생성할 때는 기본 생성자 또는 예외 메시지를 갖는 생성자 중 어떤 것을 사용해도 된다.

* 대부분 자신을 호출한 곳에서 예외를 처리하도록 throws 키워드로 예외를 떠넘긴다.

## 예외 정보 얻기

* try 블록에서 예외가 발생되면 예외 객체는 catch 블록의 매개 변수에서 참조하게 되므로 매개 변수를 이용하면 예외 객체의 정보를 알 수 있다.

* getMessage()와 printStackTrace()를 가장 많이 사용한다.

```java
throw new XXXException("예외메시지");
//getMessage() 메소드의 리턴값으로 예외메시지 받기
  catch(Exception e){
    String message = e.getMessage();
}
//printStackTrace()로 예외의 발생 경로 추적하기
e.printStackTrace();
```