# 12. 제네릭
## 왜 제네릭을 사용해야 하는가?

#### 컴파일 시 강한 타입 체크를 할 수 있다.
* 코드에서 잘못 사용된 타입 때문에 발생하는 문제점을 제거하기 위해 제네릭 코드에 대해 강한 타입 체크를 한다.

* 실행 시 타입 에러가 나는 것보다는 사전에 방지하는 것이 좋기 때문이다.

#### 타입 변환(casting)을 제거한다.
```java
//비제네릭 코드
List list = new ArrayList();
list.add("hello");
String str = (String)list.get(0); //타입 변환을 해야 한다.
//제네릭 코드
List<String> list = new ArrayList<String>();
list.add("hello");
String str = list.get(0); //타입 변환을 하지 않는다.
```

## 제네릭 타입(class<T>, interface<T>)
* 제네릭 타입은 타입을 파라미터로 가지는 클래스와 인터페이스를 말한다.

```java
public class 클래스명<T> {...}
public interface 인터페이스명<T> {...}
```

_[Box.java] 참고_

_[Apple.java] 참고_

_[BoxExample.java] 참고_

_[GBox.java] 참고_

_[GBoxExample.java] 참고_

## 멀티 타입 파라미터(class<K,V,..>, interface<K,V,..>)
* 제네릭 타입은 두 개 이상의 멀티 타입 파라미터를 사용할 수 있는데, 이 경우 각 타입 파라미터를 콤마로 구분한다.

_[Product.java] 참고_

_[ProductExample.java] 참고_

## 제네릭 메소드(<T,R> R method(T t))
* 제네릭 메소드는 매개 타입과 리턴 타입으로 타입 파라미터를 갖는 메소드를 말한다.

```java
public<타입파라미터...> 리턴타입 메소드명(매개변수,...) {...}
```

_[Util.java] 참고_

_[Pair.java] 참고_

_[CompareMethodExample.java] 참고_

## 제한된 타입 파라미터(<T extends 최상위타입>)
* 타입 파라미터에 지정되는 구체적인 타입을 제한할 필요가 종종 있다.

* 이를 선언하려면 타입 파라미터 뒤에 extends 키워드를 붙이고 상위 타입을 명시하면 된다.

```java
public <T extends 상위타입> 리턴타입 메소드(매개변수, ...) {...}
```

* 제네릭 메소드 compare()는 두 개의 숫자 타입을 매개값으로 받아 차이를 리턴한다.

* doubleValue() 메소드는 숫자를 double 타입으로 변환하는데 첫번째 매개값이 작으면 -1, 같으면 0, 크면 1을 리턴한다.

_[Util2.java] 참고_

_[BoundedTypeParameterExample.java] 참고_

## 와일드카드 타입(<?>, <? extends...>, <? super...>)
* 코드에서 ?를 일반적으로 와일드카드라고 부른다.

* 제네릭 타입을 매개값이나 리턴 타입으로 사용할 때 구체적인 타입 대신에 와일드카드를 세 가지 형태로 사용할 수 있다.

    * 제네릭타입<?> : 모든 클래스나 인터페이스 타입이 올 수 있다.

    * 제네릭타입<? extends 상위타입> : 상위 타입만 올 수 있다.

    * 제네릭타입<? super 하위타입> : 하위 타입이나 상위 타입이 올 수 있다.

_[Course.java] 참고_

_[WildCardExample.java] 참고_

## 제네릭 타입의 상속과 구현
* 제네릭 타입도 다른 타입과 마찬가지로 부모 클래스가 될 수 있다.

```java
public class ChildProduct<T,M> extends Product<T,M> {...}
```

_[Product.java] 참고_

_[ChildProduct.java] 참고_

_[Storage.java] 참고_

_[StorageImpl.java] 참고_

_[ChildProductAndStorageExample.java] 참고_