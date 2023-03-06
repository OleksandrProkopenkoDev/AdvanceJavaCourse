package optional;

import java.util.Optional;
import java.util.function.Supplier;

public class OptionalDemo {

	public static void main(String[] args) {
		Optional<Cat> optionalCat = findCatByName("Fred");
//		usecase1
		if( optionalCat.isPresent()) {
			System.out.println("my cat age is "+optionalCat.get().getAge());
		}else {
			System.out.println("cat age is 0");
		}
//		usecase2
		Cat myCat = optionalCat.orElse(new Cat("Unknown cat",0));
		System.out.println("usecase2: "+myCat);
		
//		-------
		
		myCat = optionalCat.orElseGet(new Supplier<Cat>() {

			@Override
			public Cat get() {
				
				return new Cat("new supplied cat", 10);
			}
		});
		System.out.println("usecase2: "+myCat);
		
//		-------same supplier with lambda----
		
		myCat = optionalCat.orElseGet(  () -> {				
				return new Cat("new supplied lambda cat", 4);
			});
		System.out.println("usecase2: "+myCat);
		
//		-------orElseThrow------
//		myCat = optionalCat.orElseThrow();
	System.out.println("usecase2: "+myCat);
	
//	----------mapping----if cat is present and it has age then get this age
//	if cat or age == null then get default
	System.out.println(optionalCat.map(Cat::getAge).orElse(100));
	}

	private static Optional<Cat> findCatByName(String name) {
		Cat cat = new Cat(name, 3);
		return Optional.ofNullable(cat);// cat may be null or not
	}
}
