package org.openfact.component;

import java.util.Comparator;

public class PrioritizedComponentModel extends ComponentModel {

    public static final String PRIORITY = "priority";

    public static Comparator<ComponentModel> comparator = (o1, o2) -> parsePriority(o1) - parsePriority(o2);

    public PrioritizedComponentModel(ComponentModel copy) {
        super(copy);
    }

    public PrioritizedComponentModel() {
    }

    public static int parsePriority(ComponentModel component) {
        String priority = component.getConfig().getFirst(PRIORITY);
        if (priority == null) return 0;
        return Integer.valueOf(priority);
    }

    public int getPriority() {
        return parsePriority(this);
    }

    public void setPriority(int priority) {
        getConfig().putSingle("priority", Integer.toString(priority));
    }
}
