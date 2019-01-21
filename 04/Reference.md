# 04. 참조 타입
## 데이터 타입 분류

* 자바의 데이터 타입은 크게 기본 타입과 참조 타입으로 분류된다.

* 그 중 참조 타입은 객체의 번지를 참조하는 타입으로 배열, 열거, 클래스, 인터페이스 타입이 있다.

* 참조 타입에서 변수는 스택에 생성되고 객체는 힙에 생성된다.

## 메모리 사용 영역

* jave.exe로 JVM이 시작되면 JVM은 운영체제에서 할당받은 메모리 영역을 메소드, 힙, 스택 영역으로 구분해서 사용한다.

### 메소드(Method) 영역

* 메소드 영역은 JVM이 시작할 때 생성되고 모든 스레드가 공유하는 영역이다.

### 힙(Heap) 영역

* 힙 영역은 객체와 배열이 생성되는 영역이다.

* 생성된 객체와 배열은 JVM 스택 영역의 변수나 다른 객체의 필드에서 참조한다.

* 참조하는 변수나 필드가 없다면 의미 없는 객체가 되기 때문에 이것을 쓰레기로 취급하고 JVM은 쓰레기 수집기(Garbage Collector)를 실행시켜 쓰레기 객체를 자동으로 제거한다.

### JVM 스택(Stack) 영역

* JVM 스택 영역은 각 스레드마다 하나씩 존재하며 스레드가 시작될 때 할당된다.

* 메소드를 호출할 때 프레임을 추가(push)하고 메소드가 종료되면 해당 프레임을 제거(pop)한다.

## 참조 변수의 ==, != 연산

* 참조 타입 변수들 간의 ==, != 연산은 동일한 객체를 참조하는지, 다른 객체를 참조하는지 알아볼 때 사용된다.

## null과 NullPointerException

* 힙 영역의 객체를 참조하지 않는다는 뜻으로 null(널) 값을 가질 수 있다.

* 프로그램 실행 도중에 발생하는 오류를 예외(Exception)라고 부른다.

* 참조 변수를 사용하면서 가장 많이 발생하는 예외 중 하나로 NullPointerException이 있다.

    * 프로그래머의 실수로 null 값을 가지고 잇는 참조 타입 변수를 사용하면 NullPointerException이 발생한다.

## String 타입

* 자바는 문자열을 String 변수에 저장한다.

* 변수의 선언과 리터럴 대입은 다음과 같다.

```java
String 변수1;
변수1 = "문자열1";
String 변수2 = "문자열2"
```

* 문자열 리터럴이 동일하면 String 객체를 공유한다.

* new 연산자를 사용해서 직접 String 객체를 생성시킬 수 있다.

* new 연산자는 객체 생성 연산자라고도 한다.

```java
String name1 = "minjicha";
String name2 = "minjicha"; //name1과 동일한 String 객체 참조
String name3 = new String("minjicha"); //name1,2와  다른 String 객체 참조
```

* name1과 name2는 동일한 객체를 참조한다

    * 따라서 name1 == name2의 실행 결과는 true이다.

* 그러나 name3은 new 연산자로 String 객체를 별도로 생성했다.

    * 따라서 name1 == name3의 실행 결과는 false이다.

* 문자열만을 비교할 때는 equals() 메소드를 사용해야 한다.

_[StringEqualsExample.java] 참고_

* 참조를 잃은 String 객체는 JVM이 쓰레기 수집기를 구동시켜 메모리에서 자동 제거한다.

## 배열 타입

### 배열이란?

* 배열은 같은 타입의 데이터를 연속된 공간에 나열시키고, 각 데이터에 인덱스(index)를 부여해 놓은 자료구조이다.

* 배열은 같은 타입의 데이터만 저장할 수 있다.

* 배열은 선언과 동시에 저장할 수 있는 데이터 타입이 결정된다.

### 배열 선언

* 배열을 사용하려면 배열 변수를 선언해야 하는데, 배열 변수 선언은 다음과 같다.

```java
int[] intArray; // 타입[] 변수;
int intArray[]; // 타입 변수[];
```

### 값 목록으로 배열 생성

* 배열 항목에 지정될 값의 목록을 이용하여 간단하게 배열 객체를 만들 수 있다.

```java
String[] names = {"minjicha", "홍길동", "java"};
//데이터타입[] 변수 = {값0, 값1, 값2, ... };
```

_[ArrayCreateByValueListExample1.java] 참고_

* 배열 변수를 이미 선언한 후에 다른 실행문에서 중괄호를 사용한 배열 생성은 허용되지 않는다.

* 값 목록이 나중에 결정되는 상황이라면 new 연산자를 사용해서  값 목록을 지정한다.

```java
String names = null;
names = new String[] {"minjicha", "홍길동", "java"};
```

_[ArrayCreateByValueListExample2.java] 참고_

### new 연산자로 배열 생성

* 값의 목록을 가지고 있지 않지만 배열을 미리 만들고 싶다면 new 연산자를 사용한다.

* new 연산자로 배열을 처음 생성할 경우, 배열은 자동적으로 기본값으로 초기화된다.

```java
int[] intArray = new int[5];
```

_[ArrayCreateByNewExample.java] 참고_

### 배열 길이

* 배열의 길이란 배열에 저장할 수 있는 전체 항목 수를 말한다.

* 배열의 길이를 얻으려면 length 필드를 읽으면 된다.

```java
int[] intArray = {10, 20, 30};
int num = intArray.length;
```

_[ArraylengthExample.java] 참고_

### 커맨드 라인 입력

