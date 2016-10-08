package reducers;


import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class R_WordCount extends Reducer<Text, IntWritable, Text, Text>{
	public static int totalWords=0;
	public R_WordCount(){
		System.out.println("WC Reducer class initiated");
	}
	
	@SuppressWarnings("unused")
	public void reduce(Text key, Iterable<IntWritable> value,Context context) throws IOException, InterruptedException{
	//	System.out.println("Key is '' "+key+" '' value is " +value);
		totalWords++;
		String valueStr = "";
		int count=0;
		for (IntWritable intWritable : value) {
			//valueStr+=""+intWritable+" ::: ";
			count++;
		}
		context.write(key,new Text(count+""));
	//	context.write(new Text("$$$$$$$$$$"), new Text(""+totalWords));
	}
}
