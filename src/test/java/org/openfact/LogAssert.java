package org.openfact;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LogAssert {

    private final Log log;

    LogAssert(Log log) {
        this.log = log;
    }

    public LogAssert hasLineContaining(String match) {
        assertThat( this.log.getLines().stream().filter( e->e.contains(match)).count() )
                .describedAs( log.getLogName() + " should contain '" + match + "'" ).isGreaterThan( 0);
        return this;
    }

}
