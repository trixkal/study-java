package txk.datastructure;
import java.util.Stack;


public class TransactionalStack {

	private Stack<TransactionalStack> stackOfTransactions;
	private Stack<Integer> content;

    TransactionalStack() {
        content = new Stack<Integer>();
            stackOfTransactions = new Stack<TransactionalStack>();
            stackOfTransactions.push(this);
    }
    
    public void begin() {
        TransactionalStack newTransaction = new TransactionalStack();
        newTransaction.content = (Stack<Integer>) content.clone();
        stackOfTransactions.add(newTransaction);
    }

    public void push(int value) {
        stackOfTransactions.peek().content.push(value);
    }

    public boolean rollback() {
        TransactionalStack lastTransaction = stackOfTransactions.peek();
        if (lastTransaction != this) {
            stackOfTransactions.pop();
            return true;
        }
        return false;
    }

    public boolean commit() {
        TransactionalStack lastTransaction = stackOfTransactions.peek();
        if (lastTransaction != this) {
            lastTransaction = stackOfTransactions.pop();
            stackOfTransactions.peek().content = lastTransaction.content;
            return true;
        }
        return false;
    }

    public int top() {
        Stack<Integer> cn = stackOfTransactions.peek().content;
        return cn.empty() ? 0 : cn.peek();
    }

    public int pop() {
        Stack<Integer> cn = stackOfTransactions.peek().content;
        return cn.empty() ? 0 : cn.pop();
    }
}