package org.kangspace.wechat.helper.core.env;

import lombok.Getter;
import org.kangspace.devhelper.CollectionUtil;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

/**
 * 多PropertySource集合
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
@Getter
public class MultiPropertySources implements PropertySources {
    /**
     * PropertySources集合
     */
    List<PropertySource<?>> propertySources;

    public MultiPropertySources() {
        this.propertySources = new CopyOnWriteArrayList<>();
    }

    public MultiPropertySources(PropertySource... propertySources) {
        this(Arrays.asList(propertySources));
    }

    public MultiPropertySources(List<PropertySource<?>> propertySources) {
        this();
        if (CollectionUtil.isNotEmpty(propertySources)) {
            this.propertySources.addAll(propertySources);
        }
    }

    public MultiPropertySources(PropertySource<?> propertySource) {
        this();
        add(propertySource);
    }

    /**
     * 添加新的propertySource
     *
     * @param propertySource 配置源
     * @return {@link MultiPropertySources}
     */
    public MultiPropertySources add(PropertySource<?> propertySource) {
        if (propertySource != null) {
            this.propertySources.add(propertySource);
        }
        return this;
    }

    @Override
    public Iterator<PropertySource<?>> iterator() {
        return this.propertySources.iterator();
    }

    @Override
    public void forEach(Consumer<? super PropertySource<?>> action) {
        this.propertySources.forEach(action);
    }

    @Override
    public Spliterator<PropertySource<?>> spliterator() {
        return propertySources.spliterator();
    }


}
