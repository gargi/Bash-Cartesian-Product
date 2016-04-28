import static org.junit.Assert.*;
import org.junit.Test;

public class CartesianProductTest {
	@Test(expected=InvalidString.class)
	public void assertInvalidStringError1() throws Throwable{
		CartesianProduct c = new CartesianProduct("c{d,e,f");
	}

	@Test(expected=InvalidString.class)
	public void assertInvalidStringError2() throws Throwable{
		CartesianProduct c = new CartesianProduct("cd|");
	}

	@Test
	public void testCartesianProduct1() throws InvalidString{
		CartesianProduct c = new CartesianProduct("Bc1");
		assertEquals("bc test","Bc1",c.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct2() throws InvalidString{
		CartesianProduct product = new CartesianProduct("a{b,1}");
		assertEquals("a{b,1} test", "ab a1", product.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct3() throws InvalidString{
		CartesianProduct product = new CartesianProduct("a{b,c}d{e,f,g}hi");
		assertEquals("a{b,c}d{e,f,g}hi test", "abdehi abdfhi abdghi acdehi acdfhi acdghi", product.getCartesianProduct());
	}

	@Test
	public void testCartesianProduct4() throws InvalidString{
		CartesianProduct product = new CartesianProduct("a{b,c{d,e,f}g,h}ij{k,l}");
		assertEquals("a{b,c{d,e,f}g,h}ij{k,l} test", "abijk abijl acdgijk acdgijl acegijk acegijl acfgijk acfgijl ahijk ahijl", product.getCartesianProduct());
	}

}
