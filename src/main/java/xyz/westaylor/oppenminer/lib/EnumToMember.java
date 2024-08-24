package xyz.westaylor.oppenminer.lib;

import org.apache.logging.log4j.util.BiConsumer;

public class EnumToMember {
    @SuppressWarnings("unchecked")
    public static <E extends Enum<E>, T> void stepwise(Class<E> enumClass, Class<?> clazz, BiConsumer<E, T> consumer) {
        // Get enum members
        for (E enumValue : enumClass.getEnumConstants()) {
            try {
                // Take enum value, lets say "COMBAT"
                // Go find clazz.COMBAT and get that field
                Object fieldObj = clazz.getField(enumValue.toString()).get(null);
                consumer.accept(enumValue, (T)fieldObj);
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
