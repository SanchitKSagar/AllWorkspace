package StreamANdlambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MyExample implements Consumer<Integer>{

	@Override
	public void accept(Integer t) {
		System.out.println(t);
		
	}
	
}

public class StreamAPIExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = new ArrayList<Integer>();
		l1.add(11);
		l1.add(22);
		l1.add(56);
		l1.add(1);
		l1.forEach(new MyExample());
		System.out.println("--------------");
		l1.forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
				
			}

		});
		System.out.println("-------------");
		l1.forEach((t)->System.out.println(t));
		System.out.println("-----------------");
		l1.stream().filter((t) ->{
		}).forEach((t) -> System.out.println(t));
	}

}
