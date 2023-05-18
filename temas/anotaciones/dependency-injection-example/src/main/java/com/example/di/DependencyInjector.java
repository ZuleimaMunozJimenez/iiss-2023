package com.example.di;

import com.example.annotations.Inject;
import com.example.annotations.Named;
import com.example.annotations.Singleton;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DependencyInjector {
    private Map<String, Object> singletonInstances;

    public DependencyInjector() {
        singletonInstances = new HashMap<>();
    }

    public void injectDependencies(Object target) {
        Class<?> targetClass = target.getClass();
        Field[] fields = targetClass.getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }

                Object dependency = createDependency(field.getType());
                try {
                    field.set(target, dependency);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object createDependency(Class<?> type) {
        Named namedAnnotation = type.getAnnotation(Named.class);
        Singleton singletonAnnotation = type.getAnnotation(Singleton.class);

        if (namedAnnotation != null) {
            String beanName = namedAnnotation.value();
            if (singletonAnnotation != null && singletonInstances.containsKey(beanName)) {
                return singletonInstances.get(beanName);
            } else {
                Object dependency = createInstance(type);
                if (singletonAnnotation != null) {
                    singletonInstances.put(beanName, dependency);
                }
                return dependency;
            }
        } else {
            return createInstance(type);
        }
    }

    private Object createInstance(Class<?> type) {
        try {
            return type.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
