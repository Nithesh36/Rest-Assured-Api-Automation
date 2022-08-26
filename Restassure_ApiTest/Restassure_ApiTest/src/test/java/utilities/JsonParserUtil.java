package utilities;

import io.restassured.internal.support.FileReader;

import java.io.*;

public class JsonParserUtil {

    BufferedReader bufferedReader;
//    Read data from JsonFile
//    file-represents the directory path & file
//    FileReader-reads streams of charcters from the file
//    BufferReader-reads of chars-line by line


    public String getJsonDataFile(String jsonFile) throws IOException {
        String filePath=System.getProperty("user.dir")+"/src/test/java/data/"+jsonFile+".json";

        File file=new File(filePath);
        FileInputStream fileInputStream=new FileInputStream(file);
        InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
        bufferedReader =new BufferedReader(inputStreamReader);
        StringBuilder stringBuilder=new StringBuilder();
        String line;
        while((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }
}
