import java.io.IOException;
import java.util.StringTokenizer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Exam {
	public static class Mappered extends Mapper<LongWritable, Text, Text, DoubleWritable>{
		public void map(LongWritable key ,Text value,Context context)
		{
			try
			{
				String []str = value.toString().split(",");
				double highs = Double.parseDouble(str[4]);
				context.write(new Text(str[1]), new DoubleWritable(highs));
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		 

	 }

	  public static class Reducered  extends Reducer<Text,DoubleWritable,Text,DoubleWritable> {
	   public void reduce(Text key,Iterable<DoubleWritable> value,Context context) throws IOException, InterruptedException
	   {
		   double max = 0.00;
		   for(DoubleWritable val : value)
		   {
			   if(val.get()>max)
			   {
			    max += val.get();
			   }
		   }
		   context.write(new Text(key),new DoubleWritable(max));
	   }
	  }

	public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    Job job = Job.getInstance(conf, " ");
	    job.setJarByClass(Exam.class);
	    job.setMapperClass(Mappered.class);
	    job.setReducerClass(Reducered.class);
	    job.setNumReduceTasks(1);
	    job.setMapOutputKeyClass(Text.class);
	    job.setMapOutputValueClass(DoubleWritable.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(DoubleWritable.class);
	    FileInputFormat.addInputPath(job, new Path(args[0]));
	    FileOutputFormat.setOutputPath(job, new Path(args[1]));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	  }
	}




