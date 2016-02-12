package factory.design.pattern;

public class TransformClass {

	public interface Transform<A, B> {
		B transform(A a);
	}

	// Foo -> Bar ==> Transfrom<Foo, Bar>
	// Bar -> Zoo ==> TransformClass<Bar, Zoo>
	// Foo -> Zoo

	public Tansform<A, C> combine(TransformClass<A, B> ab, TransformClass<B, C> bc) {

	}

	
	public class Tansform<S1, S2> {

	}
	
	
}