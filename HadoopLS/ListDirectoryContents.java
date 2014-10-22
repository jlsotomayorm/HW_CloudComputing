package org.jvg;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
//import java.io.FileNotFoundException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class ListDirectoryContents {
  public static void main(String[] args) throws IOException, URISyntaxException
  {
//    System.out.println(args[0]);
    URI p = new URI(args[0]);
    URI fileSystem = new URI(p.getScheme(),
        p.getUserInfo(), p.getHost(), p.getPort(),
        null, null,null);
    //System.out.println(fileSystem);
    //1. Get the Configuration instance
    Configuration configuration = new Configuration();
    //2. Get the instance of the HDFS
    FileSystem hdfs = FileSystem.get(fileSystem, configuration);
    //3. Get the metadata of the desired directory
     listFiles(new Path(p),hdfs);
    //FileStatus[] fileStatus = hdfs.listStatus(new Path(p));
    //4. Using FileUtil, getting the Paths for all the FileStatus
    //Path[] paths = FileUtil.stat2Paths(fileStatus);
    //5. Iterate through the directory and display the files in it
    //System.out.println("***** Contents of the Directory *****");
    //for(Path path : paths)
    //{
     // System.out.println(path);
    //}
  }

  public static void listFiles(Path dir, FileSystem hdfs) throws IOException, URISyntaxException {
    FileStatus[] fileStatus = hdfs.listStatus(dir);
    for( FileStatus stat : fileStatus)
    {
      System.out.println(stat.getPath());
      if(stat.isDirectory())
      {
        listFiles(stat.getPath(),hdfs);
      }
    }
  }
}
