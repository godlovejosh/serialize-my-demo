package com.caucho.hessian.demo;

import com.alibaba.fastjson.JSON;
import com.caucho.hessian.serialize.HessianSerializer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wuxing
 *
 * 陷阱，子类拥有一个与父类一样当属性，Hessian序列化会丢失
 */
public class Test {

    public static void main(String[] args) {
        class P implements Serializable {

            private static final long serialVersionUID = -3407376989541311099L;

            private List<Long> idList;

            public List<Long> getIdList() {
                return idList;
            }

            public void setIdList(List<Long> idList) {
                this.idList = idList;
            }
        }

        class Child extends P implements Serializable {

            private static final long serialVersionUID = -1919788294098053208L;

            private List<Long> idList;

            @Override
            public List<Long> getIdList() {
                return idList;
            }

            @Override
            public void setIdList(List<Long> idList) {
                this.idList = idList;
            }
        }

        List<Long> list0 = new ArrayList<>();
        list0.add(1L);
        list0.add(2L);
        list0.add(3L);

        HessianSerializer hessianSerializer = new HessianSerializer();

        P p = new P();
        p.setIdList(list0);
        byte[] bytes = hessianSerializer.serialize(p);
        p = (P) hessianSerializer.unserialize(bytes);
        System.out.println(JSON.toJSONString(p));

        Child child = new Child();
        child.setIdList(list0);
        byte[] byte2 = hessianSerializer.serialize(child);
        child = (Child) hessianSerializer.unserialize(byte2);
        System.out.println(JSON.toJSONString(child));

    }
}
