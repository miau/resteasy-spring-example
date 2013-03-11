package example.infrastructure.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

public class PlatformTransactionManagerProxy implements PlatformTransactionManager {

    private PlatformTransactionManager targetTransactionManager;

    public PlatformTransactionManagerProxy(PlatformTransactionManager targetTransactionManager) {
        this.targetTransactionManager = targetTransactionManager;
    }

    @Override
    public TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException {
        return targetTransactionManager.getTransaction(definition);
    }

    @Override
    public void commit(TransactionStatus status) throws TransactionException {
        targetTransactionManager.commit(status);
    }

    @Override
    public void rollback(TransactionStatus status) throws TransactionException {
        targetTransactionManager.rollback(status);
    }

}
