## 1-2 의존관계주입

- 의존관계 주입
    - 생성자를 통한 주입
    ```java
    public class Foo {
	    private Bar bar;
        public Foo(Bar bar){
          this.bar = bar;
        }
    }
    ```
    - 설정 메서드를 통한 주입
    ```java
    public class Foo {
        private Bar bar;
        public setBar(Bar bar){
          this.bar = bar;
        }
    }
    ```
- 생성자 주입은 `<bean>` 요소의 자식 요소로 `<constructor-arg>`, 설정 주입은 `<property>` 요소를 사용
- `<property name="outputter" ref="outputter"/>` 로 작성하여 같은 정의 파일 안에 있는 Bean 을 참조할 수도 있다.
    