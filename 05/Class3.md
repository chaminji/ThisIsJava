# 05. 클래스
## 인스턴스 멤버와 this

* 인스턴스 멤버란 객체를 생성한 후 사용할 수 있는 필드와 메소드를 말하는데, 이들을 각각 인스턴스 필드, 인스턴스 메소드라고 부른다.

* 지금까지 작성한 모든 필드와 메소드는 인스턴스 멤버들이었다.

* 객체 내부에서 인스턴스 멤버에 접근하기 위해 this를 사용할 수 있다.

* 주로 생성자와 메소드의 매개 변수 이름이 필드와 동일한 경우 this를 사용한다.

```java
Car(String model){
    this.model = model;
}
void setModel(String model){
    this.model = model;
}
```

_[Car4.java] 참고_
_[Car4Example.java] 참고_

## 정적 멤버와 static

* 정적(static)은 '고정된'이란 의미를 가지고 있다.

* 정적 멤버는 클래스에 고정된 멤버로서 객체를 생성하지 않고 사용할 수 있는 필드와 메소드를 말한다.

### 정적 멤버 선언

* 필드와 메소드 선언시 static 키워드를 추가적으로 붙이면 된다.

```java
public class 클래스{
    //정적 필드
    static 타입 필드 [ = 초기값];

    //정적 메소드
    static 리턴 타입 메소드(매개변수 선언, ... ) { ... }
}
```

* 객체마다 가지고 있어야 할 데이터라면 인스턴스 필드로 선언하고, 공용적인 데이터는 정적 필드로 선언하면 좋다.

```java
public class Calculator{
    String color; //계산기별로 색이 다를 수 있다.
    static double pi = 3.14159; //계산기에서 사용하는 파이 값은 동일
    static plus(int x, int y){ ... }
}
```

### 정적 멤버 사용

* 클래스가 메모리로 로딩되면 사용할 수 있는데, 클래스 이름과 도트 연산자로 접근한다.

```java
int result = Calculator.plus(10,5);
```

* 원칙적으로는 클래스 이름으로 접근해야 하지만 객체 참조 변수로도 접근 가능하다.

* 하지만 클래스 이름으로 접근하는 것이 좋다.

```java
Calculator myCalc = new Calculator();
int result2 = myCalc.plus(10,5);
```

### 정적 초기화 블록

* 자바는 정적 필드의 복잡한 초기화 작업을 위해 정적 블록을 제공한다.

```java
static{
    ...
}
```

_[Television.java] 참고_

_[TelevisionExample.java] 참고_

#### 정적 메소드와 블록 선언 시 주의할 점

* 인스턴스 필드나 인스턴스 메소드, this 키워드 사용이 불가능하다.

* 인스턴스 멤버를 사용하고 싶다면 객체를 생성한 후, 참조 변수로 접근해야 한다.

### 싱글톤

* 싱글톤은 단 하나만 생성되는 객체이다.

* 생성자를 외부에서 호출할 수 없도록 생성자 앞에 private 접근 제한자를 붙여주면 된다.

* 대신 외부에서 호출할 수 있는 정적 메소드 getInstance()를 선언해준다.

```java
//싱글톤을 만드는 코드
public class 클래스{
    //정적 필드
    private static 클래스 singleton = new 클래스();

    //생성자
    private 클래스(){}

    //정적 메소드
    static 클래스 getInstance(){
        return singleton;
    }
}
```

* getInstance() 메소드는 단 하나의 객체만 리턴하기 때문에 아래 코드의 변수1과 변수2는 동일한 객체를 참조한다.

```java
클래스 변수1 = 클래스.getInstance();
클래스 변수2 = 클래스.getInstance();
```

_[Singleton.java] 참고_

_[SingletonExample.java] 참고_

## final 필드와 상수

### final 필드

* final 필드는 초기값이 저장되면 이것이 최종적인 값이 되어 프로그램 실행 도중에 수정할 수 없는 것이다.

```java
final 타입 필드 [= 초기값];
```

* final 필드에 초기값을 주는 방법은 필드 선언시 주는 방법과 생성자에서 주는 방법, 두 가지 밖에 없다.

_[Person.java] 참고_

_[PersonExample.java] 참고_