package demo.knowledgepoints.dbf;

import com.linuxense.javadbf.DBFDataType;
import com.linuxense.javadbf.DBFField;
import com.linuxense.javadbf.DBFReader;
import com.linuxense.javadbf.DBFWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 读写DBF文件工具类
 */
public class DBFUtils {

    /**
     * 读DBF文件
     * @param path
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static List<Map<String, String>> readDbf(String path, String charsetName) {
        List<Map<String, String>> rowList = new ArrayList<>();
        DBFReader dbfReader = null;
        Object[] rowValues;
        try {
            dbfReader = new DBFReader(new FileInputStream(path), Charset.forName(charsetName));

            while ((rowValues = dbfReader.nextRecord()) != null) {
                Map<String, String> rowMap = new HashMap<>();
                for (int i = 0; i < rowValues.length; i++) {
                    rowMap.put(dbfReader.getField(i).getName(), String.valueOf(rowValues[i]).trim());
                }
                rowList.add(rowMap);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dbfReader != null){
                dbfReader.close();
            }
        }
        return rowList;
    }

    /**
     * 创建dbf
     * @param path:文件路径
     * @param fieldList：字段
     * @param charsetName 编码字符集
     * @throws IOException
     */
    public static void createDbf(String path, List<Map<String, String>> fieldList, String charsetName){
        DBFField[] fields = new DBFField[fieldList.size()];
        int index = 0;
        for (Map<String, String> fieldMap : fieldList) {
            DBFField field = new DBFField();
            field.setName(fieldMap.get("name"));//字段名称
            field.setType(DBFDataType.CHARACTER);//指定字段类型为字符串
            field.setLength(Integer.valueOf(fieldMap.get("length")));//指定长度
            fields[index] = field;
            index++;
        }
        //定义DBFWriter实例用来写DBF文件
        DBFWriter dbfWriter = null;
        try {
            dbfWriter = new DBFWriter(new FileOutputStream(path), Charset.forName(charsetName));
            //设置字段
            dbfWriter.setFields(fields);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //写入dbf文件并关闭
            if(dbfWriter != null){
                dbfWriter.close();
            }
        }

    }

    /**
     * 获取字段名
     * @param path
     * @param charsetName
     * @return
     * @throws IOException
     */
    public static String[] getFieldName(String path, String charsetName){
        DBFReader dbfReader = null;
        String[] fieldName = null;
        try {
            dbfReader = new DBFReader(new FileInputStream(path), Charset.forName(charsetName));
            int fieldCount = dbfReader.getFieldCount();//获取字段数量
            fieldName = new String[fieldCount];
            for (int i = 0; i < fieldCount; i++) {
                fieldName[i] = dbfReader.getField(i).getName();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dbfReader != null){
                dbfReader.close();
            }
        }
        return fieldName;
    }

    /**
     * 写dbf文件
     * @param path:dbf文件路径
     * @param rowList:要写入的记录行
     * @param charsetName：字符集
     * @throws IOException
     */
    public static void writeDbf(String path, List<Map<String, String>> rowList, String charsetName) {
        DBFWriter dbfWriter = new DBFWriter(new File(path));
        //获取字段
        String[] fieldName = getFieldName(path, "GBK");
        for (Map<String, String> rowMap : rowList) {
            Object[] rowData = new Object[fieldName.length];
            for (int i = 0; i < rowData.length; i++) {
                //根据字段来排列指，不然可能出现错位情况
                rowData[i] = rowMap.get(fieldName[i]);
            }
            //添加记录（此时并没有写入文件）
            dbfWriter.addRecord(rowData);
        }
        //写入dbf文件并保存关闭
        dbfWriter.close();
    }

    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name","A10");
        map.put("length","18");
        mapList.add(map);
        //创建文件
        createDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF",mapList,"GBK");

        mapList.clear();
        map = new HashMap<>();
        map.put("A10","蕾蕾");
        mapList.add(map);
        //写文件
        writeDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF",mapList,"GBK");

        //读取
        mapList = readDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF","GBK");
        System.out.println(mapList);
    }
}
