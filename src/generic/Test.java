package generic;

/*
 *  have;

List<String> stringList = new ArrayList<String>();
List<Integer> integerList = new ArrayList<Integer>();

Is there a (easy) way to retrieve the generic type of the list?
 * 
 * http://stackoverflow.com/questions/1942644/get-generic-type-of-java-util-list/1942680#1942680
 * 
 * You can also do that for parameter types and return type of methods. 
 * But if they're inside the same scope of the class/method where you need to know about them, 
 * then there's no point of knowing them, because you already have declared them yoursel

 */

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class Test {

    List<String> stringList = new ArrayList<String>();
    List<Integer> integerList = new ArrayList<Integer>();

    public static void main(String... args) throws Exception {
    	
        Field stringListField = Test.class.getDeclaredField("stringList");
        ParameterizedType stringListType = (ParameterizedType) stringListField.getGenericType();
        Class<?> stringListClass = (Class<?>) stringListType.getActualTypeArguments()[0];
        System.out.println(stringListClass); // class java.lang.String.

        Field integerListField = Test.class.getDeclaredField("integerList");
        ParameterizedType integerListType = (ParameterizedType) integerListField.getGenericType();
        Class<?> integerListClass = (Class<?>) integerListType.getActualTypeArguments()[0];
        System.out.println(integerListClass); // class java.lang.Integer.
    }
    
}





