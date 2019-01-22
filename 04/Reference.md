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

* main() 메소드에서 매개값인 String[] args의 필요성

* 프로그램을 실행하면 JVM은 길이가 0인 String 배열을 생성하고 main() 메소드를 호출할 때 매개값으로 전달한다.

* main() 메소드는 String[] args 매개 변수를 통해서 커맨드 라인에서 입력된 데이터의 수(배열의 길이)와 입력된 데이터(배열의 항목 값)을 알 수 있게 된다.

### 다차원 배열

* 행과 열로서 구성된 배열을 2차원 배열이라고 한다.

```java
int[][] scores = new int[2][3]; // 2(행) * 3(열)인 행렬을 만든다.
```

* 이 코드는 메모리에 세 개의 배열 객체를 생성한다.

```java
scores.length // 2
scores[0].length // 3
scores[1].length // 3
```

* 자바는 일차원 배열이 서로 연결된 구조로 다차원 배열을 구현하기 때문에 계단식 구조를 가질 수 있다.

* 그룹화된 값 목록을 가지고 있다면 중괄호 안에 중괄호를 사용해서 값 목록을 나열한다.

```java
int[][] scores = { {95, 80}, {92, 96} };
```

_[ArrayInArrayExample.java] 참고_

### 객체를 참조하는 배열

* 참조 타입에서 == 연산자는 주소값을 비교한다.

* String[] 배열에서 문자열을 비교하고 싶다면 equals() 메소드를 사용해야 한다.

_[ArrayReferenceObjectExample.java] 참고_

### 배열 복사

* 배열 간의 항목 값들을 복사하려면 for문을 사용하거나 System.arraycopy() 메소드를 사용하면 된다.

_[ArrayCopyByForExample.java] 참고_

* System.arraycopy()를 호출하는 방법이다.

    * src 매개값은 원본 배열
    
    * sPos는 원본 배열에서 복사할 항목의 시작 인덱스

    * dest 매개값은 새 배열

    * dPos는 새 배열에서 붙여넣을 시작 인덱스

    * len은 복사할 개수

```java
System.arraycopy(Object src, int sPos, Object dest, int dPos, int len);
```

_[ArrayCopyExample.java] 참고_

### 향상된 for문

```java
for( 타입변수 : 배열 ){ 실행문; }
```

* for문이 실행되면 배열에서 가져올 값이 있는지 판단하고, 값이 있다면 해당 값을 변수에 저장한 후, 실행문을 실행한다.

* for문의 반복 횟수는 배열의 항목 수가 된다.

_[AdvancedForExample.java] 참고_

## 열거 타입

* 한정된 값만을 갖는 데이터 타입이 열거타입이다.

### 열거 타입 선언

* 열거 타입을 선언하기 위해서는 열거 타입 이름으로 소스 파일을 생성해야 한다.

* public enum 키워드는 열거 타입을 선언하기 위한 키워드이다.

* 관례적으로 열거 상수는 모두 대문자로 작성한다.

```java
public enum Week {MONDAY, TUESDAY, WENDSDAY, ...}
```

_[Week.java] 참고_

### 열거 타입 변수

* 열거타입.열거상수로 사용된다.

* 열거 상수는 열거 객체로 생성된다.

```java
Week today = Week.SUNDAY;
```

### 열거 객체의 메소드

#### name() 메소드

* name() 메소드는 열거 객체가 가지고 있는 문자열을 리턴한다.

```java
Week today = Week.SUNDAY;
String name = today.name(); //name 변수에 SUNDAY 저장
```

#### ordinal() 메소드

* ordinal() 메소드는 전체 열거 객체 중 몇 번째 열거 객체인지 알려준다.

```java
Week today = Week.SUNDAY;
int ordinal = today.ordinal(); // 6을 리턴하여 ordinal 변수에 저장
```

#### compareTo() 메소드

* compareTo() 메소드는 매개값으로 주어진 열거 객체를 기준으로 전후로 몇 번째 위치하는지를 비교한다.

* 순번이 빠르다면 음수가, 느리다면 양수가 리턴된다.

```java
Week day1 = Week.MONDAY;
Week day2 = Week.WEDNESDAY;
int result1 = day1.compareTo(day2); // -2
int result2 = day2.compareTo(day1); // 2
```

#### valueOf() 메소드

* valueOf() 메소드는 매개값으로 주어지는 문자열과 동일한 문자열을 가지는 열거 객체를 리턴한다.

* 외부로부터 문자열을 입력받아 열거 객체로 변환할 때 유용하게 사용할 수 있다.

```java
// weekday 변수는 Week.SATURDAY 열거 객체를 참조한다.
Week weekDay = Week.valueOf("SATURDAY");
```

#### values() 메소드

* values() 메소드는 열거 타입의 모든 열거 객체들을 배열로 만들어 리턴한다.

```java
Week[] days = Week.values();
for(Week day : days){
    System.out.println(day);
}
```

_[EnumMethodExample.java] 참고_