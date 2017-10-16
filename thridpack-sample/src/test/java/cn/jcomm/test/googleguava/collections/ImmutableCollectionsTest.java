package cn.jcomm.test.googleguava.collections;

import com.google.common.collect.*;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author tiantiangao
 */
public class ImmutableCollectionsTest extends TestCase{

//	@Test
//	public void test() {
//		testJDKUnmodifiedList();
//		testCreate();
//		testAsList();
//		testImmutableXXX();
//	}

	public void testJDKUnmodifiedList() {
		List<String> lists = Lists.newArrayList("aa", "bb", "cc");

		List<String> unmodifiedLists = Collections.unmodifiableList(lists);
		assertEquals(3, unmodifiedLists.size());
        System.out.println(unmodifiedLists);
        lists.add("dd");
		assertEquals(4, unmodifiedLists.size());
        System.out.println(unmodifiedLists);
	}

//    public void testCreate() {
//		testCopyOf();
//		testOf();
//		testBuilder();
//	}

    public void testCopyOf() {
		ArrayList<Integer> list = Lists.newArrayList(1, 2, 3);
		ImmutableList<Integer> unmodifiedList = ImmutableList.copyOf(list);
		assertEquals(3, unmodifiedList.size());
        System.out.println(unmodifiedList);
		list.add(4);
		assertEquals(3, unmodifiedList.size());
        System.out.println(unmodifiedList);
	}

	private void testOf() {
		assertEquals(4, ImmutableList.of(1, 2, 3, 4).size());
		assertEquals(4, ImmutableSet.of(1, 2, 3, 4).size());
		assertEquals(4, ImmutableMap.of("aa", 1, "bb", 2, "cc", 3, "dd", 4).entrySet().size());
		assertEquals(4, (Object) ImmutableMap.of("aa", 1, "bb", 2, "cc", 3, "dd", 4).get("dd"));
	}

	private void testBuilder() {
		ImmutableMap<Object, Object> map = ImmutableMap.builder().put("aaa", 1).put("bbb", 2).put("ccc", 3).build();
		assertEquals(3, map.size());
		assertEquals(1, map.get("aaa"));
		assertEquals(2, map.get("bbb"));
		assertEquals(3, map.get("ccc"));
	}

	private void testAsList() {
		ImmutableSortedSet<Integer> iset = ImmutableSortedSet.of(5, 2, 3, 4, 1);
		ImmutableList<Integer> ilist = iset.asList();

		List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
		assertEquals(list, ilist);
	}

	public void testImmutableXXX() {
		assertEquals(5, ImmutableList.of(1, 2, 3, 4, 5).size());
		assertEquals(5, ImmutableSet.of(1, 2, 3, 4, 5).size());
		assertEquals(5, ImmutableSortedSet.of(1, 2, 3, 4, 5).size());
		assertEquals(3, ImmutableMap.of(1, 2, 3, 4, 5, 6).size());
        System.out.println(ImmutableMap.of(1, 2, 3, 4, 5, 6));
        assertEquals(3, ImmutableSortedMap.of(1, 2, 3, 4, 5, 6).size());
		assertEquals(9, ImmutableMultiset.of(1, 1, 2, 2, 3, 3, 4, 5, 6).size());
		assertEquals(6, ImmutableMultiset.of(1, 1, 2, 2, 3, 3, 4, 5, 6).elementSet().size());
		assertEquals(2, ImmutableMultiset.of(1, 1, 2, 2, 3, 3, 4, 5, 6).count(1));
        System.out.println(ImmutableMultiset.of(1, 1, 2, 2, 3, 3, 4, 5, 6).count(1));
    }
}
