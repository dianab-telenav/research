/**
 * This class is generated by jOOQ
 */
package com.telenav.research.generated;


import com.telenav.research.generated.routines.RetrieveEmptyPresentations;

import javax.annotation.Generated;

import org.jooq.Configuration;


/**
 * Convenience access to all stored procedures and functions in itdays_db
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.6.1"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

	/**
	 * Call <code>itdays_db.retrieve_empty_presentations</code>
	 */
	public static Integer retrieveEmptyPresentations(Configuration configuration) {
		RetrieveEmptyPresentations p = new RetrieveEmptyPresentations();

		p.execute(configuration);
		return p.getResultCount();
	}
}
