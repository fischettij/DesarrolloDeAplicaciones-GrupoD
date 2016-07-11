package unq.tpi.desapp.aspect;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class ExceptionAspect {
	

	private Logger log = Logger.getLogger(ExceptionAspect.class);
	
	@AfterThrowing(pointcut = "execution(* unq.tpi.desapp.services..*(..))",throwing = "exception")
	public void log(JoinPoint joinPoint, Exception exception){
		log.error("# " + LocalDate.now() + " -> " + exception.getMessage());
	}
}
