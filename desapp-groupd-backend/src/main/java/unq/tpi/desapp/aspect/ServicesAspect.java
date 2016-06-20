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

	@After("execution(* unq.tpi.desapp.services..*(..))")
	public void log(JoinPoint point) {
		String infoResult = getInfo(point).stream().collect(Collectors.joining(""));
		log.info("# " + LocalDate.now() + " -> " + infoResult);
	}

	private List<String> getInfo(JoinPoint point) {
		List<String> info = new ArrayList<String>();
		info.add(point.getTarget().getClass().getSimpleName());
		info.add(" -> " + point.getSignature().getName());
		info.add("( " + this.argsToString(point.getArgs())+ " )");
		return info;
	}

	private String argsToString(Object[] args) {
		String result = "";
		Boolean isStart = true;
		for (Object argument : args) {
			if(isStart){
				isStart = false;
			}
			else{
				result += ", ";
			}
			result += argument;
		}
		return result;
	}
}
