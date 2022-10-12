package org.kangspace.wechat.helper.core.env;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * PropertySource集合
 *
 * @author kango2gler@gmail.com
 * @since 2022/9/29
 */
public interface PropertySources extends Iterable<PropertySource<?>> {

    /**
     * Stream PropertySources
     *
     * @return steam
     */
    default Stream<PropertySource<?>> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    /**
     * Stream PropertySources by ordered
     *
     * @return steam
     */
    default Stream<PropertySource<?>> streamOrdered() {
        return this.stream().sorted();
    }
}
