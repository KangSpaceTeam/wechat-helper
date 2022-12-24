package org.kangspace.wechat.helper.core;

import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

/**
 * 普通测试类
 *
 * @author kango2gler@gmail.com
 * @since 2022/12/24
 */
@RunWith(JUnit4.class)
public class NormalTest {


    /**
     * stream.sorted测试
     */
    @Test
    public void sortedTest() {
        @Data
        class SortObject implements Comparable<SortObject> {
            private Integer order;

            public SortObject(Integer order) {
                this.order = order;
            }

            @Override
            public int compareTo(SortObject o) {
                return this.getOrder() - o.getOrder();
            }
        }

        List<SortObject> sortObjectList = new ArrayList<>();
        sortObjectList.add(new SortObject(2));
        sortObjectList.add(new SortObject(5));
        sortObjectList.add(new SortObject(1));
        sortObjectList.add(new SortObject(8));
        sortObjectList.add(new SortObject(10));
        sortObjectList.add(new SortObject(3));
        sortObjectList.add(new SortObject(6));
        sortObjectList.add(new SortObject(7));
        sortObjectList.add(new SortObject(9));
        sortObjectList.stream().sorted().forEach(System.out::println);
    }

}
