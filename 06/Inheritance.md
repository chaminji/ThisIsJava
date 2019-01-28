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