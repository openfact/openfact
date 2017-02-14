package org.openfact.testsuite.model;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.openfact.models.OpenfactSession;
import org.openfact.testsuite.rule.OpenfactRule;

public class TransactionsTest {

    @ClassRule
    public static OpenfactRule kc = new OpenfactRule();

    @Test
    public void testTransactionActive() {
        OpenfactSession session = kc.startSession();

        Assert.assertTrue(session.getTransactionManager().isActive());
        session.getTransactionManager().commit();
        Assert.assertFalse(session.getTransactionManager().isActive());

        session.getTransactionManager().begin();
        Assert.assertTrue(session.getTransactionManager().isActive());
        session.getTransactionManager().rollback();
        Assert.assertFalse(session.getTransactionManager().isActive());

        session.close();
    }
}
