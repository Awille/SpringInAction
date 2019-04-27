package wiringbean.conditionbeab;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicExistsCondition implements Condition {
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
    /*
        public interface ConditionContext {
            BeanDefinitionRegistry getRegistry();

            ConfigurableListableBeanFactory getBeanFactory();

            Environment getEnvironment();

            ResourceLoader getResourceLoader();

            ClassLoader getClassLoader();
        }
    */
        //conditionContext对象可以获得Environment
        Environment environment = conditionContext.getEnvironment();
        return false;
    }
}
