package txk.datastructure;

public class TwoTransactionsTest {
	
	//after five insertions, delete the last one and show the top of the stack before the commit.
	public int deleteShowTopBeforeCommit() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();//a
		transactionalTest.push(33);
		transactionalTest.begin();//b
		transactionalTest.push(77);
		transactionalTest.begin();//c
		transactionalTest.push(23);
		transactionalTest.begin();//d
		transactionalTest.push(60);
		transactionalTest.rollback();
		transactionalTest.rollback();
		transactionalTest.rollback();
		transactionalTest.rollback();
		transactionalTest.rollback();
		System.out.println(transactionalTest.top());
		
		return transactionalTest.top();
	}
	
	//after five insertions, do a rollback, push another value, do commit and show the top of the stack.
	public int deletePushDeleteCommit() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();
		transactionalTest.push(33);
		transactionalTest.begin();
		transactionalTest.push(77);
		transactionalTest.begin();
		transactionalTest.push(23);
		transactionalTest.begin();
		transactionalTest.push(60);
		transactionalTest.rollback();
		transactionalTest.push(11);
		transactionalTest.commit();
		//System.out.println(transactionalTest.top());
		
		return transactionalTest.top();
	}
	
	//after five insertions, do two rollback and two commits
	public int deleteTwiceAndCommitTwice() {
		TransactionalStack transactionalTest = new TransactionalStack();
		transactionalTest.push(20);
		transactionalTest.begin();
		transactionalTest.push(33);
		transactionalTest.begin();
		transactionalTest.push(77);
			transactionalTest.begin();
				transactionalTest.push(23);
					
			transactionalTest.begin();
				transactionalTest.push(60);
		transactionalTest.rollback();
		transactionalTest.push(11);
		transactionalTest.commit();
		transactionalTest.rollback();
		transactionalTest.commit();
		
		return transactionalTest.top();
	}
}
