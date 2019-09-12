package txk.datastructure;

public class OneTransactionTest {
	
	
	//after 3 transactions insertions, do one rollback and show top
	public int oneRollback() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();
		transactionalTest.push(33);
		transactionalTest.begin();
		transactionalTest.push(77);
		
		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
	
	//after 3 transactions insertions, do two rollback and show top
	public int twoRollbacks() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();
		transactionalTest.push(33);
		transactionalTest.begin();
		transactionalTest.push(77);
		
		transactionalTest.rollback();
		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
	
	//after 3 transactions insertions, do three rollback and show top
	public int threeRollbacks() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();
		transactionalTest.push(33);
		transactionalTest.begin();
		transactionalTest.push(77);
		
		transactionalTest.rollback();
		transactionalTest.rollback();
		if (transactionalTest.rollback())
			return transactionalTest.top();
		else 
			return 0;
	}
}
