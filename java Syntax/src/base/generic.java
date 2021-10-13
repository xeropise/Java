package base;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class generic {

    public static void main(String[] args) {

        //비 제네릭
        Corn corn = new Corn();

        corn.set("콘");                        // String -> Object (자동 타입 변환)

        String name = (String) corn.get();  // Object -> String (강제 타입 변환)
        //String

        // 제네릭
        Corn2<String> corn2 = new Corn2();

        corn2.set("콘");

        String name2 = corn2.get();

        /*------------------------------------------------------*/


        // 멀티 타입 파라미터
        // 제네릭 타입은 두 개 이상의 멀티 파라미터를 이용할 수 있다, 이 경우 각 타입 파라미터는 콤마로 구분한다.

        Entry<String, String> ent = new Entry("규비", "는 누구인가");


        /*------------------------------------------------------*/

        // 제네릭 메소드

        String[] name3 = {"김철수", "김영희", "김숙자", "김말년"};
        String[] last = generic.genericMethod(name3); // 컴파일러는 이미 타입 정보를 알고 있음

        /*------------------------------------------------------*/
        // 와일드 카드 ? , 타입 파라미터가 의미가 없을 때 사용
        // 상위 제한자
        List<? super Integer> foo3 = new ArrayList<>();

        // 하위 제한자
        List<? extends Integer> foo4 = new ArrayList<>();
    }


    // 제네릭 타입(class, interface)
    // 타입을 파라미터로 가지는 클래스와 인터페이스
    // 클래스 또는 인터페이스 이름 뒤에 "<>" 부호가 붙고, 사이에 타입 파라미터가 위치한다.
    public class Person<T> {
    }

    public interface interfacePerson<T> {
    }


    //비 제네릭 타입 이용 시

    static public class Corn {
        private Object obj;

        public Object get() {
            return obj;
        }

        public void set(Object obj) {
            this.obj = obj;
        }
    }

    // 제네릭 타입 이용시

    static public class Corn2<T> {

        private T t;

        public T get() {
            return t;
        }

        public void set(T t) {
            this.t = t;
        }

    }

    /*------------------------------------------------------*/

    // 멀티 타입 파라미터 (class<K,V,...>, interface<K,V,...>)
    // 제네릭 타입은 두 개 이상의 멀티 파라미터를 이용할 수 있다. 이 경우 각 타입 파라미터는 콤마로 구분한다.

    static public class Entry<K, V> implements Map.Entry<K, V> {

        private K key;

        private V value;

        public Entry(K key, V Value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public V getValue() {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public V setValue(V value) {
            // TODO Auto-generated method stub
            return null;
        }

    }

    /*------------------------------------------------------*/

    // 제네릭 메소드 (<T,R> R method(T t))

    // 제네릭 메소드는 매개타입과 리턴타입으로 타입파라미터를 갖는 메소드를 말한다.

    // 제네릭 메소드를 선언하는 방법은 리턴 타입 앞에 "<>" 기호를 추가하고, 타입 파라미터를 기술한 다음,

    // 리턴 타입과 매개 타입으로 타입 파라미터를 사용하면 된다.

    public static <T> T genericMethod(T name3) {

        return name3;

    }

    /*------------------------------------------------------*/

    // 한정적 타입 매개변수 (Bounded Type Parameter)
    // 범위 제한


}
