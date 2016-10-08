package mappers;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class M_WordCount extends Mapper<Object, Text, Text, IntWritable>{
	
	public M_WordCount(){
		System.out.println("WC Mapper class initiated");
	}
	IntWritable one = new IntWritable(1);
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException{
	//	System.out.println("Key is '' "+key+" '' value is " +value);
		String value1=value.toString().replace(",", " ");
		String values[] = value1.split(" ");
		for (String string : values) {
			context.write(new Text(string), one);	
		}
		
	}

}
