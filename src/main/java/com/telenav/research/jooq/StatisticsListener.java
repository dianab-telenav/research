package com.telenav.research.jooq;

import java.util.HashMap;
import java.util.Map;
import org.jooq.ExecuteContext;
import org.jooq.ExecuteType;
import org.jooq.impl.DefaultExecuteListener;


/**
 *
 *
 * @author dianabalan
 */

public class StatisticsListener extends DefaultExecuteListener {

    private static final long serialVersionUID = 8821213269323584708L;

    public static Map<ExecuteType, Integer> STATISTICS = new HashMap<ExecuteType, Integer>();

    // Count "start" events for every type of query executed by jOOQ
    @Override
    public void start(final ExecuteContext ctx) {
        synchronized (STATISTICS) {

            Integer count = STATISTICS.get(ctx.type());

            if (count == null) {
                count = 0;
            }

            STATISTICS.put(ctx.type(), count + 1);
        }
    }
}
