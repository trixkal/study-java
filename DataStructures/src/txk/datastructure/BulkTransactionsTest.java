package txk.datastructure;

public class BulkTransactionsTest {
	
	
	//after 3 transactions insertions, do one rollback and show top
	public int oneRollback(int[] values) {
		TransactionalStack transactionalTest = new TransactionalStack();
		for (int i = 0; i<values.length-1; i++) {
			transactionalTest.push(values[i]);
			if (i != (values.length -1))
				transactionalTest.begin();
		}

		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
	
	//after 3 transactions insertions, do two rollback and show top
	public int twoRollbacks(int[] values) {
		TransactionalStack transactionalTest = new TransactionalStack();
		for (int i = 0; i<values.length-1; i++) {
			transactionalTest.push(values[i]);
			if (i != (values.length -1))
				transactionalTest.begin();
		}
		transactionalTest.rollback();
		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
	
	//after 3 transactions insertions, do three rollback and show top
	public int threeRollbacks(int[] values) {
		TransactionalStack transactionalTest = new TransactionalStack();
		for (int i = 0; i<values.length-1; i++) {
			transactionalTest.push(values[i]);
			if (i != (values.length -1))
				transactionalTest.begin();
		}
		transactionalTest.rollback();
		transactionalTest.rollback();
		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
	
	//after a transactions insertion, rollback and then commit, then do a rollback.
	public int rollbackAndCommit(int[] values) {
		TransactionalStack transactionalTest = new TransactionalStack();
		for (int i = 0; i<values.length-1; i++) {
			transactionalTest.push(values[i]);
			if (i != (values.length -1))
				transactionalTest.begin();
		}
		transactionalTest.rollback();
		transactionalTest.commit();
		if (transactionalTest.rollback()) {
			return transactionalTest.top();
		} else { 
			return 0;
		}
	}
}
