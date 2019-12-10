package demo.knowledgepoints.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonDemo {
    public static void main(String[] args) {
        mapToJson();
        mapListToJson();
        objectToJson();
        objectListToJson();
        jsonToObject();
        jsonToMap();
        jsonToList();
    }

    /**
     * Map 转成 Json
     */
    public static void mapToJson() {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "One");
        map.put("key2", "Two");

        String mapJson = JSON.toJSONString(map);
        System.out.println("mapJson:" + mapJson);
    }

    /**
     * MapList 转成 Json
     */
    public static void mapListToJson() {
        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", "One");
        map1.put("key2", "Two");

        Map<String, Object> map2 = new HashMap<>();
        map2.put("key1", "Three");
        map2.put("key2", "Four");

        list.add(map1);
        list.add(map2);

        String listJson = JSON.toJSONString(list);
        System.out.println("listJson:" + listJson);
    }

    /**
     * Object 转成 Json
     */
    public static void objectToJson() {
        User user = new User();
        user.setUserName("李四");
        user.setAge(24);

        String userJson = JSON.toJSONString(user);
        System.out.println("userJson:"+userJson);
    }

    /**
     * ObjectList 转成 Json
     */
    public static void objectListToJson() {
        List<User> list = new ArrayList<>();
        for (int i = 25; i < 27 ; i++) {
            User user = new User();
            user.setUserName("李四-"+i);
            user.setAge(i);
            list.add(user);
        }

        String userJson = JSON.toJSONString(list);
        System.out.println("userJson:"+userJson);
    }

    /**
     * Json 转成 Map
     */
    public static void jsonToMap() {
        String msgJson = "{\"age\":25,\"userName\":\"李四-25\"}";
        Map<String, Object> map = JSON.parseObject(msgJson, Map.class);
        System.out.println("map:"+map);
    }

    /**
     * Json 转成 Object
     */
    public static void jsonToObject() {
        String msgJson = "{\"age\":25,\"userName\":\"李四-25\"}";
        User user = JSON.parseObject(msgJson,User.class);
        System.out.println("user:"+user);
    }

    /**
     * Json 转成 ObjectList
     */
    public static void jsonToList() {
        String msgJson = "[{\"age\":25,\"userName\":\"李四-25\"},{\"age\":26,\"userName\":\"李四-26\"}]";
        JSONArray array = JSON.parseArray(msgJson);
        for (int i = 0; i < array.size(); i++){
            User user = array.getObject(i,User.class);
            System.out.println("user:"+user);
        }
    }
}
