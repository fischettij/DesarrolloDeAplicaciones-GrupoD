package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

//import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import unq.tpi.desapp.builders.UserBuilder;
import unq.tpi.desapp.model.User;

public class MappingGenericTestTest {

	private XmlBeanFactory factory;

	protected ClassMetadata classMapping;

	private SessionFactory sessionFactory;

	@Before
	public void setUp() {
		ClassPathResource resource = new ClassPathResource("/META-INF/spring-persistence-context.xml");
		this.factory = new XmlBeanFactory(resource);
		PropertyPlaceholderConfigurer ppc = (PropertyPlaceholderConfigurer) this.factory
				.getBean("persistence.propertyConfigurer");
		ppc.postProcessBeanFactory(this.factory);

		this.sessionFactory = (SessionFactory) this.factory.getBean("persistence.sessionFactory");

	}

	@Test
	public void mappingTest() {

		User user = new UserBuilder().setName("Pepe").build();

		Session session = this.sessionFactory.openSession();

		session.save(user);

		List<User> listOfSavedObjects =  session.createCriteria(User.class).list();
		assertFalse(listOfSavedObjects.isEmpty());
		assertEquals(listOfSavedObjects.size(), 1);
		assertEquals(listOfSavedObjects.get(0), user);

		session.close();

	}

	public XmlBeanFactory getFactory() {
		return this.factory;
	}

	public void setFactory(final XmlBeanFactory factory) {
		this.factory = factory;
	}

}
