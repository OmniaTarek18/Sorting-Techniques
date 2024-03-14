import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class Sort_ArrayTest {

	// manual small tests
	@Nested
	class ManualSmallInput {
		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			expectedResult.add(4);
			expectedResult.add(28);
			expectedResult.add(10);
			expectedResult.add(15);
			expectedResult.add(0);
			expectedResult.add(0);
			expectedResult.add(34);
			expectedResult.add(48);
			expectedResult.add(12);
			expectedResult.add(9);
			expectedResult.add(15);
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			expectedResult.add(140);
			expectedResult.add(28);
			expectedResult.add(102);
			expectedResult.add(15);
			expectedResult.add(0);
			expectedResult.add(0);
			expectedResult.add(3);
			expectedResult.add(35);
			expectedResult.add(12);
			expectedResult.add(9);
			expectedResult.add(144);
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();

			expectedResult.add(18);
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

	}

	// worst case small input size
	@Nested
	class WorstCaseWithSmallInput {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 20; i > 0; i--) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 20; i > 0; i--) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			expectedResult.add(1000000);
			expectedResult.add(24);
			expectedResult.add(10002);
			expectedResult.add(15);
			expectedResult.add(1250);
			expectedResult.add(0);
			expectedResult.add(1000202);
			expectedResult.add(35);
			expectedResult.add(12);
			expectedResult.add(9);
			expectedResult.add(1000212);
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

	}

	// worst case large input size
	@Nested
	class WorstCaseWithLargeInput {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 1000; i > 0; i--) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 1000; i > 0; i--) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		// @Test
		// void testNonComparisonSort() {
		// List<Integer> expectedResult = new ArrayList<>();
		// Sort_Array object = new Sort_Array(expectedResult);
		// Collections.sort(expectedResult);
		// assertEquals(expectedResult, object.nonComparisonSort(false));
		// }

	}

	// best case small input
	@Nested
	class BestCaseWithSmallInput {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 20; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 20; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		// @Test
		// void testNonComparisonSort() {
		// List<Integer> expectedResult = new ArrayList<>();
		// Sort_Array object = new Sort_Array(expectedResult);
		// Collections.sort(expectedResult);
		// assertEquals(expectedResult, object.nonComparisonSort(false));
		// }

	}

	// best case large input
	@Nested
	class BestCaseWithLargeInput {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		// @Test
		// void testNonComparisonSort() {
		// List<Integer> expectedResult = new ArrayList<>();
		// Sort_Array object = new Sort_Array(expectedResult);
		// Collections.sort(expectedResult);
		// assertEquals(expectedResult, object.nonComparisonSort(false));
		// }

	}

	@Nested
	class AverageCaseWithInputOfSize1e3 {

		@Test
		// @RepeatedTest(10)
		void testSimpleForWorstCaseAverageInput1e3() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.simpleSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testEfficientSortAverageInput1e3() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			// System.out.println(list);
			// long startTime = System.currentTimeMillis();
			list = object.efficientSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testNonComparisonSortAverageInput1e3() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.nonComparisonSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

	}

	// average case random input of size 10000
	@Nested
	class AverageCaseWithInputOfSize1e4 {

		@Test
		// @RepeatedTest(10)
		void testSimpleForWorstCaseAverageInput1e4() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.simpleSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testEfficientSortAverageInput1e4() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			// System.out.println(list);
			// long startTime = System.currentTimeMillis();
			list = object.efficientSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testNonComparisonSortAverageInput1e4() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.nonComparisonSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

	}

	// average case random input of size 100000
	@Nested
	class AverageCaseWithInputOfSize1e5 {

		@Test
		// @RepeatedTest(10)
		void testSimpleForWorstCaseAverageInput1e5() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.simpleSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testEfficientSortAverageInput1e5() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			// System.out.println(list);
			// long startTime = System.currentTimeMillis();
			list = object.efficientSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void testNonComparisonSortAverageInput1e5() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.nonComparisonSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

	}

	// duplicated input using random
	@Nested
	class TestRandomInput {
		@Test
		// @RepeatedTest(10)
		void SimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = -200; i < 200; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			// System.out.println(list);
			// long startTime = System.currentTimeMillis();
			list = object.simpleSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void EfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = -200; i < 200; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			// System.out.println(list);
			// long startTime = System.currentTimeMillis();
			list = object.efficientSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

		@Test
		// @RepeatedTest(10)
		void NonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 400; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			// System.out.println(list);
			Sort_Array object = new Sort_Array(list);
			// long startTime = System.currentTimeMillis();
			list = object.nonComparisonSort(false);
			// long endTime = System.currentTimeMillis();
			// long elapsedTime = endTime - startTime;
			// System.out.println("time is "+ elapsedTime + " ms");
			assertEquals(expectedResult, list);
		}

	}
	// test special cases (empty array - one element - all elements are duplicated )
	@Nested
	class SpecialCases {
		
		// Method to provide test data as a stream
		static Stream<List<Integer>> listProvider() {
			return Stream.of(
					Arrays.asList(),
					Arrays.asList(4),
					Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5)
			);
		}
		@ParameterizedTest
		@MethodSource("listProvider")
		void testSimpleSort(List<Integer> expectedResult) {
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.simpleSort(false));
		}

		@ParameterizedTest
		@MethodSource("listProvider")
		void testEfficientSort(List<Integer> expectedResult) {
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		@ParameterizedTest
		@MethodSource("listProvider")
		void testNonComparisonSort(List<Integer> expectedResult) {
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

	}
}
// fail("Not yet implemented");
// is used to manually indicate test failure,
// typically when a specific condition is not met,
// and you want to provide a custom error message.

// Assertion is used to verify our output with the actual input

// Assertions.assertFalse(false);
// we want to verify if a condition is true or not
// if it's true the test fails

// Assertions.assertEquals(,)
// takes the first parameter as expected output
// takes the second parameter as actual output

// to run the test just click on run test