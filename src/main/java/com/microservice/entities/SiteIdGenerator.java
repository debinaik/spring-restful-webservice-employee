package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : SiteIdGenerator
 *
 */
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SiteIdGenerator implements IdentifierGenerator {
	
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {		
		String prefix = "SITE";
		Session newSession =(Session)session;
		try {			
		
			String queryString = "from Site order by siteId desc";
			Query query = newSession.createQuery(queryString);			
			Site lastSite = (Site)query.setMaxResults(1).uniqueResult();			
            
			if(lastSite!=null) {
				int count = Integer.parseInt(lastSite.getSiteId().replace(prefix, ""));
				int present=count+1;
				String code = prefix + StringUtils.leftPad("" + present,8,'0');			
				return code;
			} else	{
				String code = prefix + StringUtils.leftPad("" + 1,8,'0');				
				return code;
			}

		} catch (Exception e) {       
			e.printStackTrace();			
		} 
		return null;
	}

}
