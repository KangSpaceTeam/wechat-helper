package org.kangspace.wechat.helper.core.request.serialize;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * DataSerializer集合
 *
 * @author kango2gler@gmail.com
 * @since 2022/10/11
 */
public class DataSerializers implements Iterator<DataSerializer>, Iterable {
    private List<DataSerializer> dataSerializers;
    private Iterator<DataSerializer> it;

    public DataSerializers() {
        this(Collections.emptyList());
    }

    public DataSerializers(List<DataSerializer> dataSerializers) {
        Objects.requireNonNull(dataSerializers, "dataSerializers is not null!");
        dataSerializers.sort(Comparator.comparing(DataSerializer::getOrder));
        this.dataSerializers = dataSerializers;
        it = dataSerializers.iterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public DataSerializer next() {
        return it.next();
    }

    @Override
    public void remove() {
        it.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super DataSerializer> action) {
        it.forEachRemaining(action);
    }

    public List<DataSerializer> getDataSerializers() {
        return dataSerializers;
    }

    /**
     * 通过scope获取序列化对象
     *
     * @param scope
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public List<DataSerializer> getDataSerializers(DataSerializerScope scope) {
        return this.dataSerializers.stream().filter(t -> t.isSupport(scope)).collect(Collectors.toList());
    }


    /**
     * Stream PropertySources
     *
     * @return steam
     */
    Stream<DataSerializer> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    /**
     * Stream PropertySources by ordered
     *
     * @return steam
     */
    Stream<DataSerializer> streamOrdered() {
        return this.stream().sorted();
    }

    @Override
    public Iterator iterator() {
        return this.it;
    }

    @Override
    public void forEach(Consumer action) {
        this.dataSerializers.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return this.dataSerializers.spliterator();
    }
}
