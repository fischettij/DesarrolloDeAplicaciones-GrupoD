package unq.tpi.desapp.repositories;

import java.util.List;

import org.hibernate.Query;

import unq.tpi.desapp.model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}
	
	
	public List<User> getUsersLike(String paramUserName){
        String hql = "SELECT r " +
                " FROM " + this.getDomainClass().getName() + " r " +
                " WHERE LOWER(r.name) LIKE LOWER(:userName)" ;

        Query query =  getHibernateTemplate()
                .getSessionFactory()
                .getCurrentSession()
                .createQuery(hql);
        
        query.setParameter("userName", "%"+paramUserName+"%");

        List<User> foundUsers = query.list();
      
        return foundUsers;
    }
}
