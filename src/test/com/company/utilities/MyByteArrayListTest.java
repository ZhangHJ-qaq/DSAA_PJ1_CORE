package test.com.company.utilities; 

import com.company.utilities.MyByteArrayList;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* MyByteArrayList Tester. 
* 
* @author <Authors name> 
* @since <pre>10ÔÂ 5, 2020</pre> 
* @version 1.0 
*/ 
public class MyByteArrayListTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(byte b) 
* 
*/ 
@Test
public void testAdd() throws Exception {
    MyByteArrayList myByteArrayList=new MyByteArrayList();
    for(int i=0;i<25;i++){
        myByteArrayList.add((byte) i);
    }
    System.out.println(myByteArrayList.get(4));


} 

/** 
* 
* Method: get(int index) 
* 
*/ 
@Test
public void testGet() throws Exception { 
//TODO: Test goes here... 
} 


} 
