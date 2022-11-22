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
public class DataSerializers<DataType> implements Iterator<DataSerializer<DataType>>, Iterable<DataSerializer<DataType>> {
    private final List<DataSerializer<DataType>> dataSerializers;
    private final Iterator<DataSerializer<DataType>> it;

    public DataSerializers() {
        this(Collections.emptyList());
    }

    public DataSerializers(List<DataSerializer<DataType>> dataSerializers) {
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
    public DataSerializer<DataType> next() {
        return it.next();
    }

    @Override
    public void remove() {
        it.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super DataSerializer<DataType>> action) {
        it.forEachRemaining(action);
    }

    public List<DataSerializer<DataType>> getDataSerializers() {
        return dataSerializers;
    }

    /**
     * 通过scope获取序列化对象
     *
     * @param scope {@link DataSerializerScope}
     * @return List&lt;{@link DataSerializer}&gt;
     */
    public List<DataSerializer<DataType>> getDataSerializers(DataSerializerScope scope) {
        return this.dataSerializers.stream().filter(t -> t.isSupport(scope)).collect(Collectors.toList());
    }


    /**
     * Stream PropertySources
     *
     * @return steam
     */
    Stream<DataSerializer<DataType>> stream() {
        return StreamSupport.stream(this.spliterator(), false);
    }

    /**
     * Stream PropertySources by ordered
     *
     * @return steam
     */
    Stream<DataSerializer<DataType>> streamOrdered() {
        return this.stream().sorted();
    }

    @Override
    public Iterator<DataSerializer<DataType>> iterator() {
        return this.it;
    }

    @Override
    public void forEach(Consumer<? super DataSerializer<DataType>> action) {
        this.dataSerializers.forEach(action);
    }

    @Override
    public Spliterator<DataSerializer<DataType>> spliterator() {
        return this.dataSerializers.spliterator();
    }
}
