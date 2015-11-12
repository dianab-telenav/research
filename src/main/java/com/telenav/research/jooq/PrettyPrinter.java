package com.telenav.research.jooq;

import org.apache.log4j.Logger;
import org.jooq.DSLContext;
import org.jooq.ExecuteContext;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultExecuteListener;
import org.jooq.tools.StringUtils;


/**
 *
 *
 * @author dianabalan
 */
public class PrettyPrinter extends DefaultExecuteListener {

    private static final long serialVersionUID = -7418814639040367631L;
    private static Logger LOG = Logger.getLogger(PrettyPrinter.class);

    /**
     * Hook into the query execution lifecycle before executing queries
     */
    @Override
    public void executeStart(final ExecuteContext ctx) {
        // Create a new DSLContext for logging rendering purposes
        // This DSLContext doesn't need a connection, only the SQLDialect...
        final DSLContext create = DSL.using(ctx.dialect(),

                // ... and the flag for pretty-printing
                new Settings().withRenderFormatted(true));
        // If we're executing a query
        if (ctx.query() != null) {
            LOG.info(create.renderInlined(ctx.query()));
        }

        // If we're executing a routine
        else if (ctx.routine() != null) {
            LOG.info(create.renderInlined(ctx.routine()));
        }

        // If we're executing anything else (e.g. plain SQL)
        else if (!StringUtils.isBlank(ctx.sql())) {
            LOG.info(ctx.sql());
        }
    }
}