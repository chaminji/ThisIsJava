# 06. 상속
## 상속 개념

* 상속은 부모가 자식에게 물려주는 행위를 말한다.

* 부모 클래스의 멤버를 자식 클래스에게 물려줄 수 있다.

    * 부모 클래스를 상위 클래스라고 부르기도 한다.

    * 자식 클래스를 하위 클래스, 또는 파생 클래스라고 부른다.

* 상속은 코드의 중복을 줄여준다.

## 클래스 상속

* 자식 클래스를 선언할 때 어떤 부모 클래스를 상속받을 것인지를 결정하고 extends 뒤에 부모 클래스를 기술한다.

```java
class 자식클래스 extends 부모클래스 {
    //필드
    //생성자
    //메소드
}
```

* 자바는 다중 상속을 허용하지 않는다.

_[CellPhone.java] 참고_

_[DmbCellPhone.java] 참고_

_[DmbCellPhoneExample.java] 참고_

## 부모 생성자 호출

* 자식 객체를 생성하면, 부모 객체가 먼저 생성되고 자식 객체가 그 다음에 생성된다.

```java
// CellPhone 객체가 생성되고, DmbCellPhone 객체가 생성된다.
DmbCellPhone dmbCellPhone = new DmbCellPhone();
```

* 부모 생성자는 자식 생성자의 맨 첫 줄에서 호출된다.

* 생성자가 명시적으로 선언되지 않았다면 super(); 라는 기본 생성자를 생성해낸다.

```java
//명시적으로 부모 생성자를 호출하고 싶을 경우
자식클래스(매개변수 선언, ... ){
    super(매가값, ... );
    ...
}
```

_[People.java] 참고_

_[Student.java] 참고_

_[StudentExample.java] 참고_

## 메소드 재정의

* 부모 클래스의 어떠한 메소드가 자식 클래스가 사용하기에 적합하지 않을 경우 메소드를 수정해서 사용해야 한다.

* 이 때 메소드 오버라이딩 기능을 사용한다.

### 메소드 재정의(@Override)

* 메소드 오버라이딩은 자식클래스에서 동일한 메소드를 재정의하는 것을 말한다.

* 이 경우, 부모 객체의 메소드는 숨겨지기 때문에, 자식 객체에서 메소드를 호출하면 오버라이딩된 자식 메소드가 호출된다.

* 메소드 오버라이딩할 때 주의해야 할 점

    * 부모의 메소드와 동일한 시그니처(리턴타입, 메소드이름, 매개변수리스트)를 가져야 한다.

    * 접근 제한을 더 강하게 오버라이딩할 수 없다.

    * 새로운 예외를 throws할 수 없다.

_[Calculator.java] 참고_

_[Computer.java] 참고_

_[ComputerExample.java] 참고_

### 부모 메소드 호출(super)

* 오버라이딩 된 부모 클래스이 메소드를 호출해야 하는 상황이 발생한다면 명시적으로 super 키워드를 붙여서 부모 메소드를 호출할 수 있다.

* super는 부모 객체를 참조하고 있기 때문에 부모 메소드에 직접 접근할 수 있다.

_[Airplane.java] 참고_

_[SupersonicAirplane.java] 참고_

_[SupersonicAirplaneExample.java] 참고_

### final 클래스와 final 메소드

* final 키워드는 클래스, 필드, 메소드 선언 시에 사용할 수 있다.

* 클래스와 메소드 선언 시에 final 키워드가 지정되면 상속과 관련이 있다.

### 상속할 수 없는 final 클래스

* final 클래스는 부모 클래스가 될 수 없어 자식 클래스를 만들 수 없다.

```java
// final 클래스
public final class Member{
}
//Member를 상속할 수 없음
public class VeryVeryImportantPerson extends Member{
    //불가능
}
```

### 오버라이딩할 수 없는 final 메소드

* 메소드 선언 시 final 키워드를 붙이면 오버라이딩 할 수 없는 메소드가 된다.

* 부모 클래스를 상속해서 자식 클래스를 선언할 때 부모 클래스에 선언된 final 메소드는 자식 클래스에서 재정의할 수 없다.

_[Car.java] 참고_

_[SportsCar.java] 참고_

## protected 접근 제한자

* protected는 public 과 default 접근 제한의 중간쯤에 해당한다.

* 같은 패키지에서는 default와 가팅 접근 제한이 없지만 다른 패키지에서는 자식 클래스만 접근을 허용한다.

## 타입 변환과 다형성

* 다형성은 같은 타입이지만 실행 결과가 다양한 객체를 이용할 수 있는 성질을 말한다.

* 자바는 다형성을 위해 타입 변환을 허용한다.

### 자동 타입 변환(Promotion)

* 자동적으로 타입 변환이 일어나는 것을 말한다.

* 바로 위의 부모가 아니더라도 상속 계층에서 상위 타입이라면 자동 타입 변환이 일어날 수 있다.

_[Promotion.java] 참고_

_[Parent.java] 참고_

_[Child.java] 참고_

_[ChildExample.java] 참고_

### 필드의 다형성

* 주로 필드의 값을 다양화함으로써 실행 결과가 다르게 나오도록 구현한다.

* 필드의 다형성은 필드의 타입은 변함이 없지만 실행 도중에 어떤 객체를 필드로 저장하느냐에 따라 실행결과가 달라질 수 있는 것을 의미한다.

_[Tire.java] 참고_

_[TireCar.java] 참고_

_[HankookTire.java] 참고_

_[KumhoTire.java] 참고_

_[TireCarExample.java] 참고_

### 하나의 배열로 객체 관리

* 위의 코드에서 타이어 객체를 배열로 관리할 수 있도록 작성해본다.

```java
class Car{
    Tire frontLeftTire = new Tire("앞왼쪽", 6);
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);
}
//배열을 사용한다면
class Car{
    Tire[] tires = {
        new Tire("앞왼쪽", 6),
        new Tire("앞오른쪽", 2),
        new Tire("뒤왼쪽", 3),
        new Tire("뒤오른쪽", 4)
    };
}
```

### 매개 변수의 다형성

* 주로 메소드를 호출 할 때 자동 타입 변환이 발생한다.

* 메소드를 호출할 때에는 매개 변수의 타입과 동일한 매개값을 지정하는 것이 정석이지만, 매개값을 다양화하기 위해 매개 변수에 자식 타입 객체를 지정할 수도 있다.

_[Vehicle.java] 참고_

_[Driver.java] 참고_

_[Bus.java] 참고_

_[Taxi.java] 참고_

_[DriverExample.java] 참고_

### 강제 타입 변환(Casting)

* 자식 타입이 부모 타입으로 자동 변환 후, 다시 자식 타입으로 변환할 때 강제 타입 변환을 사용할 수 있다.

* 자동 변환 하면, 부모 타입에 선언된 필드와 메소드만 사용 가능하다는 제약 사항이 따른다.

### 객체 타입 확인(instanceof)

* 강제 타입 변환은 자식 타입이 부모 타입으로 변환되어 있는 상태에서만 가능하다.

```java
Parent parent = new Parent();
Child child = (Child)parent; // 강제 타입 변환을 할 수 없다.
```

* 어떤 객체가 어떤 클래스의 인스턴스인지 확인하려면 instanceof 연산자를 사용할 수 있다.

```java
boolean result = 좌항(객체) instanceof 우항(타입)
```

_[InstanceofParent.java] 참고_

_[InstanceofChild.java] 참고_

_[InstanceofExample.java] 참고_

## 추상 클래스

### 추상 클래스의 개념

* 추상(abstract)은 실체 간에 공통되는 특성을 추출한 것을 말한다.

* 객체를 직접 생성할 수 있는 클래스를 실체 클래스라고 하고, 이 클래스들의 공통적인 특성을 추출해서 선언한 클래스를 추상 클래스라고 한다.

* 추상 클래스와 실체 클래스는 상속의 관계를 가지고 있다. 추상 클래스가 부모이고 실체 클래스가 자식으로 구현되어 있다.

* 추상 클래스는 실체 클래스의 공통되는 필드와 메소드를 추출해서 만들었기 때문에 new 연산자는 사용해서 인스턴스를 생성시키지 못한다.

### 추상 클래스의 용도

#### 첫 번쨰, 실체 클래스들의 공통된 필드와 메소드의 이름을 통일할 목적

#### 두 번째, 실체 클래스를 작성할 때 시간을 절약

### 추상 클래스 선언

* 추상 클래스를 선언할 때는 클래스 선언에 abstract 키워드를 붙여야 한다.

* 자식 객체가 생성될 때 super()를 호출해서 추상 클래스 객체를 생성하므로 생성자가 반드시 있어야 한다.

_[Phone.java] 참고_

_[SmartPhone.java] 참고_

_[PhoneExample.java] 참고_

### 추상 메소드와 오버라이딩

* 추상 클래스에서 메소드의 선언만 통일화 하고 실행 내용은 실체 클래스마다 달라야 하는 경우가 있다.

* 이런 경우에 추상 클래스는 추상 메소드를 선언할 수 있다.

* 메소드의 선언부만 있고 실행 내용인 중괄호{} 가 없는 메소드이다.

```java
//선언 방법
[public | protected] abstract 리턴타입 메소드명(매개변수, ...);
```

_[Animal.java] 참고_

_[Dog.java] 참고_

_[Cat.java] 참고_

_[AnimalExample.java] 참고_