package area.manage.area_management.scans;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(EnableConfig.class)
public @interface EnableProvider {
}
