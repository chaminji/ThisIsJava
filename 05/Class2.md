## 생성자

* new 연산자와 같이 사용되어 클래스로부터 객체를 생성할 때 호출되어 객체의 초기화를 담당한다.

### 기본 생성자

* 클래스 내부에 생성자 선언을 생략한다면 컴파일러는 기본 생성자를 바이트 코드에 자동 추가시킨다.

```java
//소스파일(Car.java)
public class Car{

}
//바이트코드파일(Car.class)
public class Car{
    public Car(){ } //자동 추가
}
```

### 생성자 선언

* 생성자를 명시적으로 선언하려면 다음과 같은 형태로 작성하면 된다.

```java
클래스 ( 매개변수 선언, ... ) {
    //객체의 초기화 코드
}
```

* 앞에서 다룬 Car크래스에서 생성자를 선언해보면 다음과 같다.

```java
public class Car{
    Car(String model, String color, int maxSpeed) { ... }
}
```

### 필드 초기화

* 객체가 생성될 때 필드는 기본 초기값으로 자동 설정된다.

* 다른 값을 주고 싶다면 필드를 선언할 때 초기값을 주거나 생성자에서 초기값을 주는 방법이 있다.

* 필드를 선언할 때 초기값을 주게 되면 동일한 클래스로부터 생성되는 객체들은 모두 같은 데이터를 갖게 된다.

_[Korean.java] 참고_

_[KoreanExample.java] 참고_

* 필드와 매개변수 이름이 동일한 경우, 필드 앞에 "this."를 붙인다.

### 생성자 오버로딩

* 외부의 다양한 데이터를 이용해서 객체를 초기화하려면 생성자도 다양화될 필요가 있다.

* 생성자 오버로딩이란 매개 변수를 달리하는 생성자를 여러 개 선언하는 것을 말한다.

```java
public class Car {
    Car() { ... }
    Car(String model) { ... }
    Car(String model, String color) { ... }
}
```

* 주의할 점은 매개 변수의 타입과 개수 그리고 선언된 순서가 똑같을 경우에는 해당하지 않는다.

_[Car.java] 참고_

_[CarExample.java] 참고_

### 다른 생성자 호출(this())

* 생성자에서 다른 생성자를 호출할 때에는 this() 코드를 사용한다.

```java
Car(String model){
    this.model = model;
    this.color = "은색";
    this.maxSpeed = 250;
}

Car(String model, String color){
    this.model = model;
    this.color = color;
    this.maxSpeed = 250;
}

Car(String model, String color, int maxSpeed){
    this.model = model;
    this.color = color;
    this.maxSpeed = maxSpeed;
}

//중복 코드를 줄이기
//생성자
Car(){
}

Car(String model){
    this(model, "은색", 250);
}

Car(String model, String color){
    this(model, color, 250;)
}

Car(String model, String color, int maxSpeed){
    this.model = model;
    this.color = color;
    this.maxSpeed = maxSpeed;
}
```

## 메소드

* 메소드는 객체의 동작에 해당하는 중괄호{} 블록을 말한다.

### 메소드 선언

* 메소드 선언은 선언부와 실행 블록으로 구성된다.

```java
리턴타입 메소드이름([매개변수선언, ... ]){
    실행할 코드 작성...
}
```

#### 리턴 타입

* 리턴 타입은 메소드가 실행 후 리턴하는 값의 타입을 말한다.

* 예를 들어 전자계산기 객체에서 전원을 켜는 powerOn() 메소드와 두 수를 나누는 divide() 메소드가 있다고 가정해본다.
    
    * divide() 메소드는 나눗셈의 결과를 리턴해야 하므로 리턴값이 있다.

    * powerOn() 메소드는 전원만 켜면 끝이므로 리턴값고, void 타입이 온다.

```java
void powerOn() { ... }
double divide(int x, int y) { ... }
//호출 방법
powerOn();
double result = divide(10,20);
```

#### 메소드 이름

* 메소드 이름은 메소드가 어떤 기능을 수행하는지 쉽게 알 수 있도록 지어주는 게 좋다.

#### 매개 변수 선언

* 앞의 예시에서 powerOn() 의 경우에는 매개 변수가 필요하지 않다.

* 하지만 divide() 메소드는 나눗셈을 위한 두 수가 필요하다.

```java
//메소드 선언
double divide(int x, int y) { ... }
//메소드 호출
double result = double divie(10,20);
```

_[Calculator.java] 참고_

_[CalculatorExample.java] 참고_

#### 매개 변수의 수를 모를 경우

* 매개 변수의 수를 모를 경우에는 매개 변수를 배열 타입으로 선언한다.

* 배열의 항목 수는 호출할 때 결정된다.

```java
int sum1(int[] values) { }
//메소드 호출
int[] values = {1,2,3};
int result = sum1(values);
```

* 매개 변수를 배열 타입으로 선언하면, 메소드를 호출하기 전에 배열을 생성해야 하는 불편한 점이 있다.

* 매개 변수를 "..."를 사용해서 선언하면, 메소드 호출 시 넘겨준 값의 수에 따라 자동으로 배열이 생성되고 매개값으로 사용된다.

```java
int sum2(int ... values) { }
//메소드 호출
int result = sum2(1,2,3);
```

_[Computer.java] 참고_

_[ComputerExample.java] 참고_

### 리턴(return)문

#### 리턴 값이 있는 메소드

* 리턴 타입이 있는 메소드는 반드시 리턴문을 사용해서 리턴값을 지정해야 한다.

* return문이 없다면 컴파일 오류가 발생하고, return문이 실행되면 메소드는 즉시 종료된다.

_[Car2.java] 참고_

_[Car2Example.java] 참고_

### 메소드 호출

#### 객체 내부에서 호출

* 메소드가 매개 변수를 갖고 있을 때에는 매개 변수의 타입과 수에 맞게 매개값을 제공한다.

* 예를 들어 method2() 메소드에서 method1() 메소드를 호출하려면 다음과 같이 작성하면 된다.

```java
public class ClassName{
    void method1(String p1, int p2){

    }
    void method2(){
        method1("홍길동", 100);
    }
}
```

_[Calculator2.java] 참고_

_[Calculator2Example.java] 참고_

#### 객체 외부에서 호출

* 우선 클래스로부터 객체를 생성해야 한다.

* 객체가 생성되었다면 참조 변수와 도트(.) 연산자를 사용해서 메소드를 호출할 수 있다.

_[Car3.java] 참고_

_[Car3Example.java] 참고_

### 메소드 오버로딩

* 클래스 내에 같은 이름의 메소드를 여러 개 선언하는 것을 메소드 오버로딩이라고 한다.

* 메소드 오버로딩의 조건은 매개 변수의 타입, 개수, 순서 중 하나가 달라야 한다.

```java
//plus(10,20);을 호출 했을 때 실행되는 코드
int plus(int x, int y){
    int result = x + y;
    return result;
}
//plus(10.5,20.3);을 호출 했을 때 실행되는 코드
//위의 코드를 오버로딩 하였다
double plus(double x, double y){
    double result = x + y;
    return result;
}
```

* 메소드 오버로딩의 가장 대표적인 예는 System.out.println() 메소드이다.

_[Calculator3.java] 참고_

_[Calculator3Example.java] 참고_