import static org.junit.Assert.*;
import org.junit.Test;

public class CartesianProductTest {
	@Test(expected=UnclosedBracket.class)
	public void assertThrowsBracketError1() throws Throwable{
		CartesianProduct c = new CartesianProduct("c{d,e,f");
	}

	@Test(expected=UnclosedBracket.class)
	public void assertThrowsBracketError2() throws Throwable{
		CartesianProduct c = new CartesianProduct("cde{{f}");
	}

	@Test
	public void testCartesianProduct1() throws UnclosedBracket{
		CartesianProduct c = new CartesianProduct("bc");
		assertEquals("bc test","bc",c.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct2() throws UnclosedBracket{
		CartesianProduct product = new CartesianProduct("a{b,c}");
		assertEquals("a{b,c} test", "ab ac", product.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct3() throws UnclosedBracket{
		CartesianProduct product = new CartesianProduct("a{b,c}d{e,f,g}hi");
		assertEquals("a{b,c}d{e,f,g}hi test", "abdehi abdfhi abdghi acdehi acdfhi acdghi", product.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct4() throws UnclosedBracket{
		CartesianProduct product = new CartesianProduct("a{b,c{d,e,f}g,h}ij{k,l}");
		assertEquals("a{b,c{d,e,f}g,h}ij{k,l} test", "abijk abijl acdgijk acdgijl acegijk acegijl acfgijk acfgijl ahijk ahijl", product.getCartesianProduct());
	}

}
