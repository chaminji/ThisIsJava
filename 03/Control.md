# 03. 조건문과 반복문
## 코드 실행 흐름 제어

* 프로그램을 시작하면 main() 메소드의 시작 중괄호 { 에서 시작해서 끝 중괄호 } 까지 위부터 아래로 실행하는 흐름을 가지고 있다.

* 이러한 실행 흐름을 개발자가 원하는 방향으로 바꿀 수 있도록 해주는 것이 흐름 제어문이다.

* 조건식과 중괄호{} 블록으로 구성되는데, 조건식의 연산 결과에 따라 블록 내부의 실행 여부가 결정된다.

* 제어문에는 조건문과 반복문이 있다.

## 조건문

### if문

```java
if (조건식) {실행문;}
```

* 조건식에는 true 또는 false 값을 산출할 수 있는 연산식이나, boolean 변수가 올 수 있다.

* 조건식이 true이면 블록을 실행하고 false이면 블록을 실행하지 않는다.

_[IfExample.java] 참고_

### if-else문

* 조건문이 true면 if문의 블록이 실행되고, 조건식이 false면 else 블록이 실행된다.

_[IfElseExample.java] 참고_

### if-else if-else문

* 조건문이 여러 개인 if문이다.

* else if문의 수는 제한이 없으며 여러 개의 조건식 중 true가 되는 블록만 실행하고 전체 if문을 벗어나게 된다.

_[IfDiceExample.java] 참고_

### 중첩 if문

* if문의 블록 내부에 또 다른 if문을 사용하는 것을 중첩 if문이라고 한다.

_[IfNestedExample.java] 참고_

### switch문

* switch문은 변수의 값에 따라서 실행문이 결정된다.

* switch문은 괄호 안의 값과 동일한 값을 갖는 case로 가서 실행문을 실행시킨다. 

* 만약 동일한 값을 갖는 case가 없으면 default로 가서 실행문을 실행시킨다.

_[SwitchExample.java] 참고_

* case 끝에 break가 붙어 있는 이유는 다음 case를 실행하지 않고 switch문을 빠져나가기 위해서이다.

* break가 없다면 다음 case문이 연달아 실행된다.

* char 타입과 String 타입의 변수도 올 수 있다. (String은 자바 7부터)

## 반복문

### for문

* 프로그램을 작성하다 보면 똑같은 실행문을 반복적으로 실행해야 할 경우가 많이 발생한다.

* 이런 경우 for문을 사용하면 코드를 획기적으로 줄여준다.

```java
for(초기화식; 조건식; 증감식){
    실행문;
}
```
* 실행 흐름은 다음과 같다.

    1. for문이 실행되면 초기화식이 제일 먼저 실행된다.

    2. 조건식이 true이면 실행문을 실행시키고, false이면 블록을 실행하지 않고 끝난다.

    3. 실행문들이 모두 실행되면 증감식을 실행시키고 다시 조건식을 평가하게 된다.

_[ForPrintFrom1To10Example.java] 참고_

* 초기화식은 조건식과 실행문, 증감식에서 사용할 변수를 초기화하는 역할을 하는데, 필요 없을 경우에는 생략할 수 있다.

* 주의할 점은 카운터 변수를 선언할 때, 부동소수점 타입을 사용하지 말아야 한다는 것이다.

* for문은 또 다른 for문을 내포할 수 있는데, 이를 중첩 for문이라고 한다.

_[ForMutiplicationTableExample.java] 참고_

### while문

* while문은 조건식이 true일 경우 계속해서 반복한다.

* 조건식에는 비교 또는 논리 연산식이 주로 오는데, 조건식이 false가 되면 반복을 멈추고 while문을 종료한다.

_[WhilePrintFrom1To10Example.java] 참고_

### do-while문

* 블록 내부의 실행문을 우선 실행시키고 실행 결과에 따라서 바복 여부를 결정하는 경우에 사용한다.

* 작성 시 주의할 점은 while() 뒤에 반드시 세미콜론(;)을 붙여야 한다.

_[DoWhileExample.java] 참고_

### break문

* break문은 반복문인 for문, while문, do-while문을 실행 중지할 때 사용된다.

* switch문을 종료할 때도 사용된다.

* 만약 반복문이 중첩되어 있을 경우 break문은 가장 가까운 반복문만 종료하고 바깥쪽 반복문은 종료시키지 않는다.

* 바깥쪽 반복문까지 종료시키려면 바깥쪽 반복문에 이름(라벨)을 붙이고, "break 이름;"을 사용하면 된다.

_[BreakOutterExample.java] 참고_

### continue문

* continue문은 반복문에서 사용되는데, 블록 내부에서 continue문이 실행되면 for문의 증감식 또는 while문, do-while문의 조건식으로 이동한다.

* continue문은 반복문을 종료하지 않고 계속 반복을 수행한다는 점이 break문과 다르다.

_[ContinueExample.java] 참고_