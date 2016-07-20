package org.openfact.connections.jpa.util;

import org.junit.Assert;
import org.junit.Test;

public class JpaUtilsTest {

    @Test
    public void testConvertTableName() {
        Assert.assertEquals("DATABASECHANGELOG_FOO", JpaUtils.getCustomChangelogTableName("foo"));
        Assert.assertEquals("DATABASECHANGELOG_FOOBAR", JpaUtils.getCustomChangelogTableName("foo123bar"));
        Assert.assertEquals("DATABASECHANGELOG_FOO_BAR", JpaUtils.getCustomChangelogTableName("foo_bar568"));
        Assert.assertEquals("DATABASECHANGELOG_FOO_BAR_C", JpaUtils.getCustomChangelogTableName("foo-bar-c568"));
        Assert.assertEquals("DATABASECHANGELOG_EXAMPLE_EN", JpaUtils.getCustomChangelogTableName("example-entity-provider"));
    }
}
