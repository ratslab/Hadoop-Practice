package mappers;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class M_MaxTemp extends Mapper<Object, Text, IntWritable, Text> {
	public static int i=0;
	
	public void map(Object key,Text value,Context context) throws IOException, InterruptedException{
		i++;
		
		String text= value.toString();
		String date= text.substring(18, 26);
		String month=text.substring(22,24);
		IntWritable m= new IntWritable(Integer.parseInt(month));
		String temp=text.substring(95,98);
		value = new Text(date+ "-"+temp);
		context.write(m,value);
	}

}
