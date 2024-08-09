package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class JavaStream {
	
	@Test
	public void regular()
	{
	
	   ArrayList<String> list = new ArrayList<String>();
	   List<String> ls = Stream.of("Raj", "Rahul", "Joy", "David", "Dan", "Javin").filter(s->s.startsWith("R")).collect(Collectors.toList());
	   ls.forEach(s->System.out.println(s));
	}
	
	@Test
	public void mapping()
	{
		SoftAssert a = new SoftAssert();
		List<String> ls = Arrays.asList("Raj", "Rahul", "Jod", "David", "Dad", "Javin");
		List<String> ls1 = Arrays.asList("Ban", "Bob", "Hans", "Ramore", "Drake");
		boolean flag = Stream.concat(ls.stream(), ls1.stream()).anyMatch(s->s.equalsIgnoreCase("ramore"));
		System.out.println(flag);
		a.assertTrue(flag, "the name is not in the string");
		a.assertAll();
	}
	
	@Test
	public void printmapping()
	{
		List<Integer> in = Arrays.asList(1,2,3,4,7,4,5,8,3,2,7);
		in.stream().distinct().sorted().limit(1).forEach(s->System.out.println(s));
		List<Integer> ListIn = in.stream().distinct().sorted().collect(Collectors.toList());
		//System.out.println(ListIn.get(3));
	}

}
