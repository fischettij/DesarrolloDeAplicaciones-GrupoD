package unq.tpi.desapp.userStoryTest;

import static org.junit.Assert.assertNotNull;
import static org.reflections.ReflectionUtils.getAllMethods;
import static org.reflections.ReflectionUtils.withModifier;
import static org.reflections.ReflectionUtils.withPrefix;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Set;

import org.junit.Test;
import org.reflections.Reflections;

import com.google.common.base.Predicates;

public class ArchitectureTest {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testAllClasesInPackageServicesAreTransactional() {
		Reflections reflections = new Reflections("unq.tpi.desapp.services");
		Set<Class<? extends Serializable>> allClasses = reflections.getSubTypesOf(Serializable.class);
		for (Class myClass : allClasses) {
			Set<Method> allMethods = getAllMethods(myClass, withModifier(Modifier.PUBLIC),
					Predicates.and(Predicates.not(withPrefix("get")), Predicates.not(withPrefix("set"))));
			System.out.println(allMethods);
			this.assertAllMethodsAreTransactional(allMethods);
		}
	}

	private void assertAllMethodsAreTransactional(Set<Method> allMethods) {
		for (Method method : allMethods) {
			assertNotNull(method.getAnnotation(org.springframework.transaction.annotation.Transactional.class));
		}
	}

}
