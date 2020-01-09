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
 * ��дDBF�ļ�������
 */
public class DBFUtils {

    /**
     * ��DBF�ļ�
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
     * ����dbf
     * @param path:�ļ�·��
     * @param fieldList���ֶ�
     * @param charsetName �����ַ���
     * @throws IOException
     */
    public static void createDbf(String path, List<Map<String, String>> fieldList, String charsetName){
        DBFField[] fields = new DBFField[fieldList.size()];
        int index = 0;
        for (Map<String, String> fieldMap : fieldList) {
            DBFField field = new DBFField();
            field.setName(fieldMap.get("name"));//�ֶ�����
            field.setType(DBFDataType.CHARACTER);//ָ���ֶ�����Ϊ�ַ���
            field.setLength(Integer.valueOf(fieldMap.get("length")));//ָ������
            fields[index] = field;
            index++;
        }
        //����DBFWriterʵ������дDBF�ļ�
        DBFWriter dbfWriter = null;
        try {
            dbfWriter = new DBFWriter(new FileOutputStream(path), Charset.forName(charsetName));
            //�����ֶ�
            dbfWriter.setFields(fields);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            //д��dbf�ļ����ر�
            if(dbfWriter != null){
                dbfWriter.close();
            }
        }

    }

    /**
     * ��ȡ�ֶ���
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
            int fieldCount = dbfReader.getFieldCount();//��ȡ�ֶ�����
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
     * дdbf�ļ�
     * @param path:dbf�ļ�·��
     * @param rowList:Ҫд��ļ�¼��
     * @param charsetName���ַ���
     * @throws IOException
     */
    public static void writeDbf(String path, List<Map<String, String>> rowList, String charsetName) {
        DBFWriter dbfWriter = new DBFWriter(new File(path));
        //��ȡ�ֶ�
        String[] fieldName = getFieldName(path, "GBK");
        for (Map<String, String> rowMap : rowList) {
            Object[] rowData = new Object[fieldName.length];
            for (int i = 0; i < rowData.length; i++) {
                //�����ֶ�������ָ����Ȼ���ܳ��ִ�λ���
                rowData[i] = rowMap.get(fieldName[i]);
            }
            //��Ӽ�¼����ʱ��û��д���ļ���
            dbfWriter.addRecord(rowData);
        }
        //д��dbf�ļ�������ر�
        dbfWriter.close();
    }

    public static void main(String[] args) {
        List<Map<String, String>> mapList = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        map.put("name","A10");
        map.put("length","18");
        mapList.add(map);
        //�����ļ�
        createDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF",mapList,"GBK");

        mapList.clear();
        map = new HashMap<>();
        map.put("A10","����");
        mapList.add(map);
        //д�ļ�
        writeDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF",mapList,"GBK");

        //��ȡ
        mapList = readDbf("src\\demo\\knowledgepoints\\dbf\\1.DBF","GBK");
        System.out.println(mapList);
    }
}
