package sample07_generic;

public class GenericBox<T> {

	private T itemT;

	public T getItemT() {
		return itemT;
	}

	public void setItemT(T itemT) {
		this.itemT = itemT;
	}
}

	//생성할 수 있는 객체의 타입 제한하기 : Phone류의 객체
	class GenericPhoneBox<T extends Phone> {
	
	private T itemT;
	
	public T getItemT() {
		return itemT;
	}
	
	public void setItemT(T itemT) {
		this.itemT = itemT;
	}
}

	class Phone {

	}

	class SmartPhone extends Phone{

	}

	class FeaturePhone extends Phone {

	}