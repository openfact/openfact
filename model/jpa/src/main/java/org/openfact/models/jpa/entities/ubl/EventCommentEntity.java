package org.openfact.models.jpa.entities.ubl;

import java.time.LocalDate;
import java.time.LocalTime;

import org.openfact.models.ubl.type.TextType;

/**
 * A class to define comments about a retail event.
 * 
 * @author Erik
 * @version 2.1
 * @created 07-Set.-2016 9:14:55 a. m.
 */
public class EventCommentEntity {

    /**
     * Text commenting on the event.
     */
    private TextType comment;
    /**
     * The date on which this comment was made.
     */
    private LocalDate issueDate;
    /**
     * The time at which this comment was made.
     */
    private LocalTime issueTime;

}
