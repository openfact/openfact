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

        Assert.assertTrue(session.getTransaction().isActive());
        session.getTransaction().commit();
        Assert.assertFalse(session.getTransaction().isActive());

        session.getTransaction().begin();
        Assert.assertTrue(session.getTransaction().isActive());
        session.getTransaction().rollback();
        Assert.assertFalse(session.getTransaction().isActive());

        session.close();
    }
}
