# 01. 변수
## 변수란?

* 변수는 값을 저장할 수 있는 메모리의 공간을 의미한다.

* 변수에는 한 가지 타입의 값만 저장할 수 있다.
    * ex ) 정수 타입 변수에는 정수값만, 실수 타입 변수에는 실수 값만

### 변수의 선언

* 변수를 사용하기 위해서는 먼저 변수를 선언해야 한다.

* 변수 선언은 다음과 같다.

```java
int age; // 타입과 변수 이름을 적어준다.
double value; // 실수(double) 값을 저장할 수 있는 value 변수 선언
```

* 같은 타입의 변수는 콤마(,)를 이용해서 한꺼번에 선언할 수도 있다.
```java
int x,y,z;
```

* 변수 이름은 자바 언어에서 정한 명명 규칙을 따라야 한다.

    * 필수

        * 첫번째 글자는 문자이거나 '$', '_'이어야 하고 숫자로 시작할 수 없다.
        
        * 영어 대소문자는 구분된다.
        
        * 자바 예약어는 사용할 수 없다.
    
    * 관례
    
        * 첫 문자는 영어 소문자로 시작하되, 다른 단어가 붙을 경우 첫 문자를 대문자로 한다.
    
        * 문자 수(길이)의 제한은 없다.

### 변수의 사용

* 변수를 사용한다는 것은 변수에 값을 저장하고 읽는 행위를 말한다.

#### 변수값 저장

* 변수에 값을 대입할 때는 대입 연산자 (=)를 사용한다.

    * 우측의 값을 좌측 변수에 저장한다는 의미를 갖는다.

```java
int score; // 변수 선언
score = 90; // 값 저장
```

* 초기값은 변수의 선언함과 동시에 줄 수도 있다.
```java
int score = 90;
```

* 변수의 초기값은 코드에서 직접 입력하는 경우가 많은데, 소스 코드 내에서 직접 입력된 값을 리터럴(literal)이라고 부른다.

* 상수(constant)와 같은 의미지만, 프로그램에서 상수는 "값을 한 번 저장하면 변경할 수 없는 변수"로 정의한다.

* 리터럴에는 정수, 실수, 문자, 문자열, 논리리터럴이 있다.

#### 변수값 읽기

* 변수는 초기화가 되어야 읽을 수 있고, 초기화 되지 않은 변수는 읽을 수 없다.

_[VariableExample.java] 참고_

### 변수의 사용 범위

* 변수는 중괄호 {} 블록 내에서 선언되고 사용된다.

* 중괄호 블록은 클래스, 생성자, 메소드에서 사용된다.

* 메소드 내에서 선언된 변수를 로컬 변수라고 부른다.

    * 로컬 변수는 메소드 실행이 끝나면 메모리에서 자동으로 사라진다.

    * if, for, while 등 제어문 블록에서 선언된 변수는 해당 제어문 블록 내에서만 사용이 가능하다.

_[VariableScopeExample.java] 참고_

## 데이터 타입

### 기본 타입

* 기본 타입이란 정수, 실수, 문자, 논리 리터럴을 직접 저장하는 타입을 말한다.

* 각 타입 별로 메모리 사용 크기가 다르며, 그에 따라 저장되는 값의 범위도 다르다.

### 정수 타입

* 정수 타입에는 byte(1), char(2), short(2), int(4), long(8) 다섯 개의 타입이 있다. (괄호 안의 값은 각 타입별 바이트 수를 의미한다)

#### byte 타입

* byte 타입은 색상 정보 및 파일 또는 이미지 등의 이진 데이터를 처리할 때 주로 사용된다.

* 표현할 수 있는 값의 범위는 -128 ~ 127이다.

* 최상위 비트는 정수 값의 부호를 결정한다.

#### char 타입

* 자바는 모든 문자를 유니코드로 처리한다.

* 하나의 유니코드를 저장하기 위해 2byte 크기인 char 타입을 제공한다.

* char 타입 변수에 작은 따옴표로 감싼 문자를 대입하면 해당 문자의 유니코드가 저장된다. ex) 'A', '가'

* 위의 방법이 아닌 직접 유니코드 값을 저장할 수도 있다. ex) 'A'의 경우 65

* 문자열을 저장하고 싶다면 String 타입을 사용해야 한다.

#### short 타입

* 2byte로 표현되는 정수값을 저장할 수 있는 데이터 타입이다.

* C언어와의 호환을 위해 사용, 비교적 자바에서 잘 사용되지 않는다.

#### int 타입

* 자바에서 정수 연산을 위한 4byte 크기의 기본 타입이다.

* 8진수인 경우에는 앞에 '0', 16진수는 '0x'을 붙이면 된다.

#### long 타입

* 8byte로 표현되는 정수값을 저장할 수 있는 데이터 타입이다.

* 수치가 큰 데이터를 다루는 프로그램에서 필수적으로 사용된다.

* long 타입 변수를 초기화 할 때는 정수갑 뒤에 소문자 'l'이나 대문자 'L'을 붙여야 한다.

### 실수 타입

* 실수 타입은 실수 타입은 소수점이 있는 실수 데이터를 저장할 수 있는 타입으로, 메모리 사용 크기에 따라 float과 double이 있다.

* 실수는 부동 소수점 방식으로 저장된다.

* float 타입은 리터럴 뒤에 소문자 'f'나 대문자 'F'를 붙여야 한다.

```java
double var1 = 3.14;
float var2 = 3.14; //컴파일 에러
float var3 = 3.14f;
```

### 논리 타입
 
* boolean 타입은 1byte로 표현되는 논리값을 저장할 수 있는 데이터 타입이다.

* 두 가지 상태값을 저장할 필요가 있을 경우에 사용된다.

    * 주로 조건문과 제어문의 실행 흐름을 변경하는데 이용된다.

## 타입 변환

* 타입 변환에는 자동 타입 변환과 강제 타입 변환이 있다.

### 자동 타입 변환

* 작은 크기를 가지는 타입이 큰 크기를 가지는 타입에 저장될 때 발생한다.

    * char 타입은 2byte크기를 가지지만 범위가 0 ~ 65535이므로 음수가 저장될 수 없다.

    * 따라서 음수가 저장될 수 있는 byte 타입을 char 타입으로 자동 변환 시킬 수 없다.

```java
byte byteValue = 10;
int intValue = byteValue; // 자동 타입 변환 발생
```

### 강제 타입 변환

* 큰 크기의 타입은 작은 크기의 타입으로 자동 타입 변환을 할 수 없다.

* 하지만 int 타입을 4개의 byte로 쪼갠 다음, 끝에 있는 1byte만 byte 타입 변수에 저장하는 것은 가능하다.

* 이처럼 강제적으로 저장하는 것을 강제 타입 변환(캐스팅 : Casting) 이라고 한다.

* 캐스팅 연산자 ()를 사용하는데, 괄호 안에 들어가는 타입은 쪼개는 단위이다.

```java
int intValue = 103029770;
byte byteValue = (byte)intValue; // 강제 타입 변환(캐스팅)
//원래 int 값은 보존되지 않는다.
```

* 값의 손실이 발생하지 않는지 검사해서 올바른 타입 변환이 되도록 해야 한다.

_[CheckValueBeforeCasting.java] 참고_

* 정수 타입을 실수 타입으로 변환할 때 정밀도 손실을 피해야 한다.

_[FromIntToFloat.java] 참고_


_[OperationsPromotionExample.java] 참고_