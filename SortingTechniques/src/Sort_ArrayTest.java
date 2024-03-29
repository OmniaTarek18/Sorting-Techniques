import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import java.io.File;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Sort_ArrayTest {

	Random random = new Random();

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
			expectedResult = Arrays.asList(0, 0, 4, 9, 10, 12, 15, 15, 28, 34, 48);
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
			expectedResult = Arrays.asList(0, 0, 3, 9, 12, 15, 28, 35, 102, 140, 144);
			assertEquals(expectedResult, object.efficientSort(false));
		}

		@Test
		void testNonComparisonSort() {
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
			expectedResult.add(18);
			Sort_Array object = new Sort_Array(expectedResult);
			expectedResult = Arrays.asList(0, 0, 3, 9, 12, 15, 18, 28, 35, 102, 140);
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
			expectedResult.add(10000000);
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

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				if (random.nextBoolean())
					expectedResult.add(random.nextInt(20));
				else
					expectedResult.add(random.nextInt(10000000 - 10000) + 10000);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			Collections.sort(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

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

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 20; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

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

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			Sort_Array object = new Sort_Array(expectedResult);
			assertEquals(expectedResult, object.nonComparisonSort(false));
		}

	}

	// average case random input of size 1000
	@Nested
	class AverageCaseWithInputOfSize1e3 {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.simpleSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.efficientSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 1000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.nonComparisonSort(false);
			assertEquals(expectedResult, list);
		}

	}

	// average case random input of size 10000
	@Nested
	class AverageCaseWithInputOfSize1e4 {

		@Test
		void testSimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.simpleSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void testEfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.efficientSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void testNonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 10000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.nonComparisonSort(false);
			assertEquals(expectedResult, list);
		}

	}

	// average case random input of size 100000
	@Nested
	class AverageCaseWithInputOfSize1e5 {

		@Test
		@Timeout(value = 3, unit = TimeUnit.SECONDS)
		void SimpleSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.simpleSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void EfficientSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.efficientSort(false);
			assertEquals(expectedResult, list);
		}

		@Test
		void NonComparisonSort() {
			List<Integer> expectedResult = new ArrayList<>();
			for (int i = 0; i < 100000; i++) {
				expectedResult.add(i);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Sort_Array object = new Sort_Array(list);
			list = object.nonComparisonSort(false);
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
				expectedResult.add(random.nextInt(400) - 200);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.shuffle(list);
			Collections.sort(expectedResult);
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
				expectedResult.add(random.nextInt(400) - 200);
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.sort(expectedResult);
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
				expectedResult.add(random.nextInt(400));
			}
			List<Integer> list = new ArrayList<>(expectedResult);
			Collections.sort(expectedResult);
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
					Arrays.asList(5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5));
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

	// test using file
	@Nested
	class TestUsingFile {

		List<Integer> readInputFromFile(File file) {
			List<Integer> arr = new ArrayList<>();
			try {
				Scanner sc = new Scanner(file);
				String str = sc.nextLine();
				String[] arrStrings = str.split(",");
				for (String val : arrStrings) {
					arr.add(Integer.parseInt(val));
				}
			} catch (Exception e) {
				fail("File is Empty");
			}
			return arr;
		}

		@ParameterizedTest
		@ValueSource(strings = { "SortingTechniques\\src\\testcase1.txt", "SortingTechniques\\src\\testcase2.txt",
				"SortingTechniques\\src\\testcase3.txt" })
		@Timeout(value = 3, unit = TimeUnit.SECONDS)
		void SimpleSort(String path) {
			File file = new File(path);
			Sort_Array obj = new Sort_Array(file);
			List<Integer> expected = readInputFromFile(file);
			Collections.sort(expected);
			assertEquals(expected, obj.simpleSort(false));
		}

		@ParameterizedTest
		@ValueSource(strings = { "SortingTechniques\\src\\testcase1.txt", "SortingTechniques\\src\\testcase2.txt",
				"SortingTechniques\\src\\testcase3.txt" })
		@Timeout(value = 3, unit = TimeUnit.SECONDS)
		void EfficientSort(String path) {
			File file = new File(path);
			Sort_Array obj = new Sort_Array(file);
			List<Integer> expected = readInputFromFile(file);
			Collections.sort(expected);
			assertEquals(expected, obj.efficientSort(false));
		}

		@ParameterizedTest
		@ValueSource(strings = { "SortingTechniques\\src\\testcase1.txt", "SortingTechniques\\src\\testcase2.txt",
				"SortingTechniques\\src\\testcase3.txt" })
		@Timeout(value = 3, unit = TimeUnit.SECONDS)
		void nonComparisonSort(String path) {
			File file = new File(path);
			Sort_Array obj = new Sort_Array(file);
			List<Integer> expected = readInputFromFile(file);
			Collections.sort(expected);
			assertEquals(expected, obj.nonComparisonSort(false));
		}

	}

	// test Efficiency 
		// average case random input of size 10000
		@Nested
		class TestInputOfSize1e4 {
	
			@Test
			// @RepeatedTest(10)
			@Timeout(value = 3 , unit = TimeUnit.SECONDS)
			void testSimpleSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 10000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.simpleSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
			@Test
			// @RepeatedTest(10)
			void testEfficientSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 10000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.efficientSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
			@Test
			// @RepeatedTest(10)
			void testNonComparisonSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 10000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.nonComparisonSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
		}

		// average case random input of size 100000
		@Nested
		class TestInputOfSize1e5 {
	
			@Test
			// @RepeatedTest(10)
			void testSimpleSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 100000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.simpleSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
			@Test
			// @RepeatedTest(10)
			void testEfficientSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 100000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.efficientSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
			@Test
			// @RepeatedTest(10)
			void testNonComparisonSort() {
				List<Integer> list = new ArrayList<>();
				for (int i = 0; i < 100000; i++) {
					list.add(random.nextInt(1000));
				}
				Sort_Array object = new Sort_Array(list);
				long startTime = System.currentTimeMillis();
				list = object.nonComparisonSort(false);
				long endTime = System.currentTimeMillis();
				long elapsedTime = endTime - startTime;
				System.out.println("time is "+ elapsedTime + " ms");
			}
	
		}
}
