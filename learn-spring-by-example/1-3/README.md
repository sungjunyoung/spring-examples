## 1-3 Bean 라이프 사이클

- `BeanFactory` 가 Bean 을 생성하고, Bean 이 사용가능한 산태가 될때까지의 흐름
    1. Bean 의 인스턴스화 (생성자 호출)
    2. 필드값 지정
    3. `setBeanName()` 메서드 호출 (`BeanNameAware` 인터페이스를 구현하고 있는 경우)
    4. `setBeanFactory()` 메서드 호출 (`BeanFactoryAware` 인터페이스를 구현하고 있는 경우)
    5. `BeanPostProcessor` 의 `postProcessBeforeInitialization()` 메서드 호출 (`BeanFactory` `BeanPostProcessor` 클래스가 관련되어 있는 경우)
    6. `afterPropertiesSet()` 메서드 호출 (`InitiailizingBean` 인터페이스를 구현하고 있는 경우)
    7. 사용자 구현 초기화 메서드 호출 (사용자 구현 초기화 메서드를 정의하고 있는 경우)
    8. `BeanPostProcessor` 의 `PostProcessAfterInitialization()` 메서드 호출 (`BeanFactory` 에 `BeanPostProcessor` 클래스가 관련되어 있는 경우)
    
- 컨테이너가 종료될 때
    1. `destroy()` 메서드 호출 (`DisposableBean` 인터페이스를 구현하고 있는 경우)
    2. 사용자 구현소거 메서드 호출 (사용자 구현소거 메서드를 정의하고 있는 경우)
    
- Autowiring
    - BeanFactory 의 기능
    - 어떤 Bean 이 참조하는 형태와 실제 사용할 클래스를 자동으로 연결해줌.
    - A -> B 로의 클래스 관계일때,
    ```java
    public class A {
	    B b;
      public void setB(B b){
  	    this.b = b;
      }
    }
    ```
    여기서 지금까지는 beans.xml 을 다음과 같이 기술하면 설정할 수 있다.
    ```xml
    <bean id="a" class="A">
      <property name="b"><ref bean="B"></ref></property>
    </bean>
    ```
    그러나 Autowiring 을 사용하면,
    ```xml
    <bean id="a" class="A" autowire="byname"/>
    ```
    스프링이 자동으로 B 클래스로의 의존성을 해결해줌 