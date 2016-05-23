package unq.tpi.desapp.aspect;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ServicesAspect {

	private Logger log = Logger.getLogger(ServicesAspect.class);

	@After("execution(* unq.tpi.desapp.services.GenericService.*(..))")
	public void log(JoinPoint point) {
		String infoResult = getInfo(point).stream().collect(Collectors.joining(", "));
		log.info(LocalDate.now() + " " + infoResult);
	}

	private List<String> getInfo(JoinPoint point) {
		List<String> info = new ArrayList<String>();
		info.add("class: " + point.getTarget().toString());
		info.add("method: " + point.getSignature().getName());
		info.add("parameters: " + argsToString(point.getArgs()));
		return info;
	}

	private static String argsToString(Object[] args) {
		String result = "";
		for (Object argument : args) {
			result += argument;
		}
		return result;
	}
}
