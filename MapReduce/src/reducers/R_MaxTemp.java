package reducers;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import general.Functions;

public class R_MaxTemp extends Reducer<IntWritable, Text, IntWritable, Text>{
	public void reduce(IntWritable key,Iterable<Text> value,Context context) throws IOException, InterruptedException{
		
		String text= new String(Functions.getMonth(key.get())+" ===================================\n");
		
		int maxtemp=0;
		for (Text t : value) {
			text=text+t+"\n";
			String[] datetemp=t.toString().split("-");
			maxtemp = Math.max(maxtemp, Integer.parseInt(datetemp[1]));
			text =text+datetemp[0]+"   "+datetemp[1]+"\n";
		}
	
		text= text+"======================================";
		
		context.write(key,new Text(maxtemp+""));	
	}

}
