package com.telenav.research.jooq;

import org.jooq.ExecuteContext;
import org.jooq.ExecuteType;
import org.jooq.impl.DefaultExecuteListener;


/**
 *
 *
 * @author dianabalan
 */
public class ConstraintCheckerListener extends DefaultExecuteListener {

    private static final long serialVersionUID = -4195704914532128162L;

    @Override
    public void renderEnd(final ExecuteContext ctx) {

    }

    @Override
    public void start(final ExecuteContext ctx) {
        if (ctx.type().equals(ExecuteType.DDL)) {
            throw new RuntimeException(ctx.query().toString());
        }
    }

}
