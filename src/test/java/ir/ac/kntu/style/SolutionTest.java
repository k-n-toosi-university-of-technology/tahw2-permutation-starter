/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu.style;


import ir.ac.kntu.Permutation;
import java.util.Arrays;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Hamed Khashehchi
 */
public class SolutionTest {
    
    @Before
    public void setup() {
        Class<Permutation> permutationClass = Permutation.class;
        Field[] fields = permutationClass.getDeclaredFields();
        for (Field field : fields) {
            Class fieldType = field.getType();
            if (Modifier.isPrivate(field.getModifiers())) {
                field.setAccessible(true);
            }
            String typeName = fieldType.getName().toUpperCase().replace(".", "");
            try {
                if (typeName.equals("INT")) {
                    field.setInt(permutationClass, 0);
                } else if (typeName.equals("[LJAVALANGSTRING;")) {
                    field.set(permutationClass, null);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
@Test
    public void testNormal() {
        String[] args=new String[2];
        args[0]="0";
        args[1]="2";
        Permutation.main(args);
        String[] list = Permutation.permutation;
        Arrays.sort(list);
        String[] answer = new String[2];
        answer[0]="ba";
        answer[1]="ab";
        Arrays.sort(answer);
        assertArrayEquals(answer, list);
    }
    
     @Test
    public void testNormal1() {
        String[] args=new String[2];
        args[0]="25";
        args[1]="28";
        Permutation.main(args);
        String[] list = Permutation.permutation;
        Arrays.sort(list);
        String[] answer = new String[6];
        answer[0]="zAB";
        answer[1]="zBA";
        answer[2]="AzB";
        answer[3]="ABz";
        answer[4]="BzA";
        answer[5]="BAz";
        Arrays.sort(answer);
        assertArrayEquals(answer, list);
    }
 
    
    @Test
    public void testEmpty() {
        String[] args=new String[2];
        args[0]="1";
        args[1]="1";
        Permutation.main(args);
        String[] list = Permutation.permutation;
        Arrays.sort(list);
	    String[] answer = new String[0];
        Arrays.sort(answer);
        assertArrayEquals(answer, list);
    }

}
