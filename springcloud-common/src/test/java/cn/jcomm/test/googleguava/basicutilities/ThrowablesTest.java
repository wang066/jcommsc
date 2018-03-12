package cn.jcomm.test.googleguava.basicutilities;

import com.google.common.base.Throwables;
import junit.framework.TestCase;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * @author tiantiangao
 */
public class ThrowablesTest extends TestCase{

//	@Test
//	public void test() {
//		testPropagate();
//		testPropagateIfInstanceOf();
//		testPropagateIfPossible();
//		testGetRootCause();
//		testGetStackTraceAsString();
//		testGetCausalChain();
//	}

	public void testPropagate() {
		try {
			URL url = new URL("http://www.dianping.com");
			InputStream in = url.openStream();
			in.close();
		} catch (Exception e) {
			throw Throwables.propagate(e);
		}
	}

    public void testPropagateIfInstanceOf() {
		try {
			throw new NumberFormatException("a");
		} catch (Throwable t) {
			try {
				Throwables.propagateIfInstanceOf(t, NumberFormatException.class);
				fail();
			} catch (Throwable t2) {
				assertTrue(true);
			}
		}
	}

    public void testPropagateIfPossible() {
		try {
			throw new NumberFormatException();
		} catch (Throwable t) {
			try {
				Throwables.propagateIfPossible(t, Exception.class);
				fail();
			} catch (Throwable t1) {
				assertTrue(true);
			}
		}
	}

    public void testGetRootCause() {
		Exception e = new NumberFormatException("a");
		assertEquals(e, Throwables.getRootCause(e));

		IllegalArgumentException e2 = new IllegalArgumentException(e);
		assertEquals(e, Throwables.getRootCause(e2));
	}

    public void testGetStackTraceAsString() {
		try {
			Integer.parseInt("a");
			fail();
		} catch (Exception e) {
			assertTrue(Throwables.getStackTraceAsString(e).startsWith(
					"java.lang.NumberFormatException: For input string: \"a\""));
		}
	}

    public void testGetCausalChain() {
		FileNotFoundException fnfe = new FileNotFoundException();
		IllegalArgumentException iae = new IllegalArgumentException(fnfe);
		RuntimeException re = new RuntimeException(iae);
		IllegalStateException ex = new IllegalStateException(re);

		assertEquals(Arrays.asList(ex, re, iae, fnfe), Throwables.getCausalChain(ex));
		try {
            List<Throwable> causalChain = Throwables.getCausalChain(null);
            fail("Should have throw NPE");
		} catch (NullPointerException expected) {

		}
	}

	public void test1(){
//        Throwables.
    }
}
