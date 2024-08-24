package xyz.westaylor.oppenminer.lib;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.function.BiConsumer;

import com.mojang.logging.LogUtils;

public class AnnotatedFieldFinder {
    public static <AnnotationType extends Annotation, T> void iterateFields(Class<?> clazz, Class<AnnotationType> annotationClass, BiConsumer<AnnotationType, T> consumer) {
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                // Check for annotation
                if (field.isAnnotationPresent(annotationClass)) {

                    // Get annotation
                    AnnotationType annotation = field.getAnnotation(annotationClass);

                    // Get the instance of the field
                    @SuppressWarnings("unchecked")
                    T instance = (T)field.get(null);

                    // Call the consumer
                    consumer.accept(annotation, instance);

                }
            } catch (IllegalAccessException e) {
                LogUtils.getLogger().error("Failed to access field: " + field.getName(), e);
            } catch (ClassCastException e) {
                LogUtils.getLogger().error("Failed to cast field: " + field.getName(), e);
            }
        }
    }
}
