# 10. 기본 API 클래스
## 자바 API 도큐먼트

* API는 라이브러리라고 부르기도 하는데, 프로그램 개발에 자주 사용되는 클래스 및 인터페이스의 모음을 말한다.

* API 도큐먼트는 API를 쉽게 찾아 이용할 수 있도록 문서화한 것을 말한다.

```
http://docs.oracle.com/javase/8/docs/api/
```

## java.lang과 java.util 패키지

### java.lang 패키지

* java.lang 패키지에 있는 클래스와 인터페이스는 import 없이 사용할 수 있다.

* Object, System, Class, String, StringBuffer, StringBuilder, Math, Wrapper 등이 있다.

### java.util 패키지

* java.util 패키지는 자바 프로그램 개발에 조미료 같은 역할을 하는 클래스를 담고 있다.

* Arrays, Calendar, Date, Objects, StringTokenizer, Random 등이 있다.

## Object 클래스

* Object는 자바의 최상위 부모 클래스에 해당한다.

### 객체 비교(equals)

```java
//Object의 equals() 메소드
public boolean equals(Object obj) { ... }
```
    
* equals() 메소드는 비교 연산자인 ==과 동일한 결과를 리턴한다.

* 논리적으로 동등하면 true를, 그렇지 않으면 false를 리턴한다.

_[Member.java] 참고_

_[MemberExample.java] 참고_

### 객체 해시코드(hashCode())

* 객체 해시코드란 객체를 식별할 하나의 정수값을 말한다.

* hashCode() 리턴값이 다르면 다른 객체, 같으면 equals() 메소드로 다시 비교한다.

* hashCode() 메소드가 true가 나와도 equals()의 리턴값이 다르면 다른 객체가 된다.

```java
//Key 객체를 식별키로 사용해서 String 값을 저장하는 HashMap 객체 생성
HashMap<Key, String> hashMap = new HashMap<Key, String>();
```

* String의 hashCode()는 같은 문자열일 경우 동일한 해시코드를 리턴한다.

### 객체 문자 정보(toString())

* Object 클래스의 toString() 메소드는 객체의 문자 정보를 리턴한다.

### 객체 복제(clone())

* 객체 복제는 원본 객체의 필드값과 동일한 값을 가지는 새로운 객체를 생성하는 것을 말한다.

* 원본 객체를 안전하게 보호하기 위해서이다.

#### 얕은 복제(thin clone)

* 얕은 복제란 단순히 필드값을 복사해서 객체를 복제하는 것을 말한다.

* 필드가 기본 타입일 경우 값 복사를, 찹조 타입일 경우에는 번지가 복사된다.

#### 깊은 복제(deep clone)

* 깊은 복제란 참조하고 있는 개체도 복제하는 것을 말한다.

### 객체 소멸자(finalize())

* 쓰레기 수집기는 객체를 소멸하기 직전에 소멸자를 실행시킨다.

## Objects 클래스

### 객체 비교(compare(T a, T b, Comparator< T >c))

* 두 객체를 비교해서 int 값을 리턴한다.

### 동등 비교(equals()와 deepEquals())

* Objects.equals(Object a, Object b)는 두 객체의 동등을 비교하는데 a와 b가 모두 null일 경우 true를 리턴한다.

* a와 b가 null이 아닌 경우는 a.equals(b)의 결과를 리턴한다.

_[EqualsAndDeepEqualsExample.java] 참고_

### 해시코드 생성(hash(), hashCode())

* Objects.hash 메소드는 매개값으로 주어진 값들을 이용해서 해시 코드를 생성하는 역할을 한다.

* 클래스가 여러 가지 필드를 가지고 있을 때 이 필드들로부터 해시코드를 생성하게 되면 동일한 필드값을 가지는 객체는 동일한 해시코드를 가질 수 있다.

### 널 여부 조사(isNull(), nonNull(), requireNonNull())

* isNull()은 매개값이 null일 경우, nonNull()은 매개값이 not null일 경우 true를 리턴한다.

* requireNonNull()은 첫번째 매개값이 not null이면 첫 번째 매개값을 리턴하고, null이면 모두 NullPointException을 발생시킨다.

_[NullExample.java] 참고_

### 객체 문자 정보(toString())

* Objects.toString()은 객체의 문자 정보를 리턴한다.

_[ToStringExample.java] 참고_

## System 클래스

* java.lang 패키지에 속하는 System 클래스를 이용하면 운영체제의 일부 기능을 이용할 수 있다.

### 프로그램 종료(exit())

* 강제적으로 JVM을 종료시킬 때는 System 클래스의 exit() 메소드를 호출하면 된다.

* exit() 메소드는 int 매개값을 지정하도록 되어 있는데, 정상 종료일 경우 0으로 지정하고 비정상 종료일 경우 0 이외의 다른 값을 준다.

### 쓰레기 수집기 실행(gc())

* JVM은 메모리가 부족할 때와 CPU가 한가할 때 쓰레기 수집기를 실행시킨다.

* System.gc() 메소드가 호출되면 JVM은 빠른 시간 내에 실행시키기 위해 노력한다.

## Class 클래스

### Class 객체 얻기(getClass(), forName())

* 프로그램에서 Class객체를 얻고자 할 때, getClass() 메소드를 이용한다.

```java
Class clazz = obj.getClass();
```

* getClass() 메소드는 해당 클래스로 객체를 생성했을 때만 사용할 수 있는데, 객체를 생성하기 전에 직접 Class 객체를 얻을 수도 있다.

* Class는 생성자를 감추고 있기 때문에 new 연산자로 객체를 만들 수 없고, 정적 메소드인 forName()을 이용해야 한다.

```java
try{
    Class clazz = Class.forName(String className);
} catch(ClassNotFoundException e) {
}
```

### 리플렉션

* Class 객체를 이용하면 클래스의 생성자, 필드, 메소드 정보를 알아낼 수 있는데, 이것을 리플렉션이라고 한다.

* Class 객체는 리플렉션을 위해 getDeclaredConstructors(), getDeclaredFields(), getDeclaredMethods()를 제공한다.

### 동적 객체 생성(newInstance())

* Class.forName() 메소드로 Class 객체를 얻은 다음 newInstance() 메소드를 호출하면 Object 타입의 객체를 얻을 수 있다.

* 이 때, 반드시 클래스에 기본 생성자가 존재해야 한다.

## String 클래스

### String 생성자

_[ByteToStringExample.java] 참고_

### String 메소드

* 문자 추출(charAt())

* 문자열 비교(equals())

* 바이트 배열로 변환(getBytes())

* 문자열 찾기(indexOf())

* 문자열 길이(length())

* 문자열 대치(replace())

* 문자열 잘라내기(substring())

* 알파벳 소, 대문자 변경(toLowerCase(), toUpperCase())

* 문자열 앞뒤 공백 잘라내기(trim())

* 문자열 변환(valueOf())

## StringTokenizer 클래스

### split() 메소드

* String 클래스의 split() 메소드는 정규 표현식을 구분자로 해서 문자열을 분리한 후, 배열에 저장하고 리턴한다.

```java
String[] result = "문자열".split("정규표현식");
```

### StringTokenizer 클래스

* 문자열이 한 종류의 구분자로 연결되어 있을 경우, StringTokenizer 클래스를 사용하면 손쉽게 문자열을 분리해 낼 수 있다.

```java
StringTokenizer st = new StringTokenizer("문자열", "구분자");
```

_[StringTokenizerExample.java] 참고_

## StringBuffer, StringBuilder 클래스

* 문자열을 저장하는 String은 내부의 문자열을 수정할 수 없다.

* 문자열을 결합하는 + 연산자를 많이 사용하면 할수록 String 객체의 수가 늘어나기 때문에, 프로그램 성능을 느리게 하는 요인이 된다.

* 문자열을 변경하는 작업이 많을 경우에는 StringBuffer 또는 StringBuilder 클래스를 사용하는 것이 좋다.

    * StringBuffer는 멀티 스레드 환경에서 사용할 수 있도록 되어 있어    스레드에 안전하다.

    * StringBuilder는 단일 스레드 환경에서만 사용하도록 설계되어 있다.

* StringBuilder는 버퍼가 부족할 경우 자동으로 버퍼 크기를 늘린다.

    * append, insert, delete 등의 메소드를 사용하여 수정한다.

_[StringBuilderExample.java] 참고_

## 정규 표현식과 Pattern 클래스

### 정규 표현식 작성 방법

```java
//전화번호
(02|010)-\d{3,4}-\d{4}
//이메일
\w+@\w+\.\w+(\.\w+)?
```

### Pattern 클래스

* 문자열을 정규 표현식으로 검증하는 기능은 matches() 메소드가 제공한다.

_[PatternExample.java] 참고_

## Arrays 클래스

* Arrays 클래스는 배열 조작 기능을 가지고 있다.

### 배열 복사

* 배열 복사 메소드는 copyOf(원본배열, 복사할길이), copyOfRange(원본배열, 시작인덱스, 끝인덱스)이다.

_[ArrayCopyExample.java] 참고_

### 배열 항목 비교

* Arrays의 equals()와 deepEquals()는 배열 항목을 비교한다.

### 배열 항목 정렬

* 기본 타입 또는 String 배열은 Arrays.sort() 메소드의 매개값으로 지정해주면 자동으로 오름차순 정렬이 된다.

### 배열 항목 검색

* 배열의 항목을 검색하려면 Arrays.sort() 메소드로 항목들을 오름차순으로 정렬한 후, Arrays.binarySearch() 메소드로 항목을 찾아야 한다.

## Wrapper(포장) 클래스

* 자바는 기본 타입의 값을 갖는 객체를 생성할 수 있는데, 이를 포장 객체라고 한다.

* 포장 객체의 특징은 포장하고 있는 기본 타입 값은 외부에서 변경할 수 없다.

### 박싱(Boxing)과 언박싱(Unboxing)

* 기본 타입의 값을 포장 객체로 만드는 과정을 박싱이라고 하고, 포장 객체에서 기본 타입의 값을 얻어내는 과정을 언박싱이라고 한다.

_[BoxingUnBoxingExample.java] 참고_

### 자동 박싱과 언박싱

* 자동 박싱은 포장 클래스 타입에 기본갑싱 대입될 경우에 발생한다.

* 자동 언바싱은 기본 타입에 포장 객체가 대입될 경우에 발생한다.

```java
Integer obj = 100; //자동 박싱
int value1 = obj; //자동 언박싱
```

### 문자열을 기본 타입 값으로 변환

* 대부분의 포장 클래스에는 "parse + 기본타입"명으로 되어 있는 정적(static) 메소드가 있다.

* 이 메소드는 문자열을 매개값으로 받아 기본 타입 값으로 변환한다.

### 포장 값 비교

* 포장 객체는 내부의 값을 비교하기 위해 ==와 != 연산자를 사용할 수 없다.

* 직접 내부 값을 언박싱해서 비교하거나, equals() 메소드로 내부 값을 비교하는 것이 좋다.

## Math, Random 클래스

### Math 클래스

* java.lang.Math 클래스는 수학 계산에 사용할 수 있는 메소드를 제공한다.

_[MathExample.java] 참고_

### Random 클래스

* java.util.Random 클래스는 난수를 얻어내기 위해 다양한 메소드를 제공한다.

```java
//Random 객체 생성
Random random = new Random(3);
```

### Date, Calendar 클래스

* 자바는 시스템의 날짜 및 시각을 읽을 수 있도록 Date와 Calendar 클래스를 제공하고 있다.

### Date 클래스

```java
//Date 객체 생성
Date now = new Date();
```

_[DateExample.java] 참고_

### Calendar 클래스

* Calendar 클래스는 추상 클래스이므로 new 연산자를 사용해서 생성할 수 없다.

```java
//Calendar 객체 생성
Calendar now = Calendar.getInstance();
```