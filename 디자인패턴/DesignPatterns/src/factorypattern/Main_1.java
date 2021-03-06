package factorypattern;

import factorypattern.pizza.Pizza;
import factorypattern.pizzastore.ChicagoPizzaStore;
import factorypattern.pizzastore.NYPizzaStore;
import factorypattern.pizzastore.PizzaStore;

public class Main_1 {
	/*
	 *  챕터 4-1
	 * 
	 * 간단한 팩토리는 디자인 패턴이라고 하지는 않는다.
	 * 
	 * if(type.equal("cheese")) {
	 * 	pizza = new CheesePizza();
	 * } else if (type .equal("greek")) {
	 * 	pizza = new GreekPizza();
	 * } ...
	 * 이렇게 만들어져 있다고 가정하자.
	 * 그럼 다른 클래스에서 피자를 쓰려면 어떻게 해야할까?
	 * 다시 위와 같은 코드를 써야할 것이다.
	 * 그럼 이렇게 많은 클래스에서 위와 같은 코드를 쓰고 있을 때. 치즈피자를 없애고 페퍼로니 피자를 추가한다면?
	 * 각 클래스에서
	 * 치즈부분을 전부 제거하고 페퍼로니를 전부 추가해야 할 것이다.
	 * 
	 * 그러니 따로 클래스를 만들어서 메소르를 빼내보자. - 여기까지가 간단한 팩토리 155p까지 내용
	 * 
	 * 그러나 문제가 발생했다.
	 * 피자를 만드는 것은 craetePizza-prepare-bake-cut-box 로 동일한 알고리즘으로 돌아가나 = 
	 * 지역마다 피자를 만드는(createPizza) 스타일이 다른 것이다.
	 * 시카고 피자는 도우가 두껍고 치즈가 엄청 들어가고
	 * 뉴욕피자는 얇고 바삭한 도우가 들어간다.
	 * 
	 * 피자 가게마다 스타일이 다르니 피자가게에 createPizza를 추상화시켜 서브클래스에서 구현하게 만든다.
	 * 
	 *  팩토리 메소드 패턴(factory method pattern)
	 * 팩토리 메소드패턴에서는 객체를 생성하기 위한 인터페이스를 정의하는데 어떤 클래스의 인스턴스를 만들지는 서브클래스에서 결정하게 만든다.
	 * 팩토리 메소드 패턴을 이용하면 클래스의 인스턴스를 만드는 일을 서브클래스에 맡기는 것이죠.
	 * 
	 * 172페이지 클래스 다이어그램으로 구조확인 가능
	 * 
	 *  팩토리를 썼을 때의 장점
	 * 1. 객체 생성 코드를 전부 한 객체 또는 메소드에 집어넣으면 코드에서 중복되는 내용 제거.
	 * 2. 클라이언트 입장에서는 객체 인스턴스를 만들 때 필요한 구상 클래스가 아닌 인터페이스만 필요로 하게 된다.
	 * 3. 구현이 아닌 인터페이스를 바탕으로 프로그래밍을 할 수 있게 되어 유연성과 확장성이 뛰어난 코드를 만들 수 있음
	 * 
	 *  디자인의 원칙
	 * 5. 추상화된 것에 의존하도록 만들어라. 구상클래스에 의존하도록 만들지 않도록 한다. - 의존성 뒤집기 원칙
	 * PizzaStroe는 "고수준 구성요소"라 할 수 있고
	 * 피자 클래스들은 "저수준 구성요소"라 할 수 있다.
	 * PizzaStore 클래스는 피자 클래스들에 의해 행동이 정의되기 때문에 "고수준 구성요소"이다.
	 * PizzaStore 클래스는 피자 클래스들에 의존하고 있다.
	 * 
	 *  팩토리 패턴 적용 가이드
	 * 앞내용을 전부 잊고 피자가게를 만든다고 생각하자. 뭘 만들어야 할까?
	 * 피자가게에서는 피자를 준비하고, 굽고, 포장해야하고. 치즈피자, 야채피자, 조개피자 같이 다양한 메뉴가 있어야할꺼야...
	 *  굿!
	 * 이제 생각하는 순서를 뒤집어보자.
	 * 치즈 피자든 야채 피자든 조개 피자든 전부다 피자잖아. Pizza라는 동일한 인터페이스를 공유하면 되겠지?
	 *  굿!
	 * 이제 Pizza에서 어떤것을 추상화시킬 수 있을지 궁리해보자.
	 * 이런 흐름으로 생각하면 된다!
	 * 
	 *  의존성 뒤집기 원칙에 위배되는 객체지향 디자인을 피하는데 도움이되는 가이드 라인
	 * 1. 어떤 변수에도 구상클래스에 대한 레퍼런스를 저장하지 말자. 
	 * (new 연산자의 사용을 최소화하라는 말인듯. 메인부분에서 피자를 만들때 new가 아닌 orderPizza 메소드를 사용함)
	 * 2. 구상 클래스에서 유도된 클래스를 만들지 말자.
	 * (그냥 만들어져있는 클래스를 extends 하지 말고 인터페이스나 추상화된 클래스를 사용하자인듯)
	 * 3. 베이스 클래스에 이미 구현되어 있던 메소드를 오버라이드하지 말자
	 * (베이스 클래스에서 메소드를 정의할 때는 모든 서브클래스에서 공유할 수 있는 것만 정의하고 아닌 것은 추상화를 하자인듯)
	 * 
	 * 가이드라인은 말그대로 지향해야할 바를 밝힐 뿐. 엄밀히 말하면 자바 프로그램 가운데 이 가이드라인을 완벽히 따르는 것은 하나도 없다. 
	 * 하지만 가이드라인을 완전히 습득한 상태에서 디자인을 할 때 할상 이 가이드라인을 염두에 둔다면 확실히 알고 있는 상태에서 그렇게 할 테고
	 * 불가피한 상황에서만 합리적인 이유를 바탕으로 그렇게 하게 될 것이다.
	 * 예를 들어 클래스가 거의 바뀌지 않을 것같은 경우에 그 클래스의 인스턴스를 만드는 코드를 작성한다 해도 그리 큰 문제가 생기지 않는다.
	 * String 객체의 인스턴스도 엄밀히 말하면 원칙에 위배가 된다.
	 * 하지만!
	 * 만들고 있는 클래스가 바뀔 가능성이 있다면 팩토리 메소드 패턴 같은 기법을 써서 변경될 수 있는 부분을 캡슐화 해야한다.
	 *  
	 */
	public static void main(String[] args) {
		PizzaStore nyStore = new NYPizzaStore();
		Pizza pizza = nyStore.orderPizza("cheese");
		System.out.println(pizza.getName());
		System.out.println();
		PizzaStore chstore = new ChicagoPizzaStore();
		Pizza pizza2 = chstore.orderPizza("cheese");
		System.out.println(pizza2.getName());
	}

}
