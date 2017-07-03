package com.microservice.entities;

/**
 * @author (Santhosh kumar k) 574990
 * Description : UnitIdGenerator
 *
 */
import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class UnitIdGenerator implements IdentifierGenerator{
	
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {		
		String prefix = "UNIT";
		Session newSession =(Session)session;
		try {			
		
			String queryString = "from Unit order by unitId desc";
			Query query = newSession.createQuery(queryString);			
			Unit lastUnit = (Unit)query.setMaxResults(1).uniqueResult();			
            
			if(lastUnit!=null) {
				int count = Integer.parseInt(lastUnit.getUnitId().replace(prefix, ""));
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
