package test.com.company; 

import com.company.HuffmanTree;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* HuffmanTree Tester. 
* 
* @author <Authors name> 
* @since <pre>10ÔÂ 1, 2020</pre> 
* @version 1.0 
*/ 
public class HuffmanTreeTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: generateHuffmanTree(byte[] bytes) 
* 
*/ 
@Test
public void testGenerateHuffmanTree() throws Exception { 
//TODO: Test goes here...
    HuffmanTree huffmanTree=HuffmanTree.generateHuffmanTree("abbcccdddd".getBytes());

} 

/** 
* 
* Method: getEncodingTable() 
* 
*/ 
@Test
public void testGetEncodingTable() throws Exception { 
//TODO: Test goes here... 
} 


/** 
* 
* Method: countFrequency(byte[] byteArray) 
* 
*/ 
@Test
public void testCountFrequency() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = HuffmanTree.getClass().getMethod("countFrequency", byte[].class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: generateNodeQueue(int[] frequencyArray) 
* 
*/ 
@Test
public void testGenerateNodeQueue() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = HuffmanTree.getClass().getMethod("generateNodeQueue", int[].class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: generateHuffmanTreeWithPriorityQueue(PriorityQueue<HuffmanNode> huffmanNodePriorityQueue) 
* 
*/ 
@Test
public void testGenerateHuffmanTreeWithPriorityQueue() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = HuffmanTree.getClass().getMethod("generateHuffmanTreeWithPriorityQueue", PriorityQueue<HuffmanNode>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

/** 
* 
* Method: computeEncodingTable(HuffmanNode node, StringBuilder stringBuilder) 
* 
*/ 
@Test
public void testComputeEncodingTable() throws Exception { 
//TODO: Test goes here... 
/* 
try { 
   Method method = HuffmanTree.getClass().getMethod("computeEncodingTable", HuffmanNode.class, StringBuilder.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/ 
} 

} 
