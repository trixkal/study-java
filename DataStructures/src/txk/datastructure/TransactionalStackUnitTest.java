package txk.datastructure;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TransactionalStackUnitTest {

	@Test
	void oneRollback() {
		BulkTransactionsTest test = new BulkTransactionsTest();
		int[] values = {17, 55, 33};
		int result = test.oneRollback(values);
		assertEquals(55, result);
	}
	
	@Test
	void twoRollbacks() {
		BulkTransactionsTest test = new BulkTransactionsTest();
		int[] values = {17, 55, 33};
		int result = test.twoRollbacks(values);
		assertEquals(17, result);
	}
	
	@Test
	void threeRollbacks() {
		BulkTransactionsTest test = new BulkTransactionsTest();
		int[] values1 = {17, 55, 33};
		int result1 = test.threeRollbacks(values1);
		assertEquals(0, result1);
		
		int[] values2 = {65, 13, 77, 88, 41};
		int result2 = test.threeRollbacks(values2);
		assertEquals(13, result2);
	}
	
	@Test
	void rollbackAndCommit() {
		BulkTransactionsTest test = new BulkTransactionsTest();
		int[] values1 = {17, 55, 33};
		int result1 = test.rollbackAndCommit(values1);
		assertEquals(0, result1);
		
		int[] values2 = {65, 13, 77, 88, 41};
		int result2 = test.rollbackAndCommit(values2);
		assertEquals(13, result2);
	}
	
}
