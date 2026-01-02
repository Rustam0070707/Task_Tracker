package com.pm;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil {

 public static List<Task> fromJson(String context){
     List<Task> tasks = new ArrayList<>();
     if(context.isBlank()){
         return new ArrayList<>();
     }
     String[] jsons = context.split("\\{");
     for (String json : jsons){
         if(!json.contains("id"))
              continue;

         Task task = new Task(Integer.parseInt(extract(json,"id")),extract(json,"description") );

         task.setStatus(TaskStatus.valueOf(extract(json,"status")));
         tasks.add(task);
     }

     return tasks;
 }
    public static String extract(String json , String regex){
return json.split("\"" + regex + "\"")[1]
        .split(":")[1]
        .split(",")[0]
        .replaceAll("[\"\\n]","")
        .trim();
    }

    public static String toJson(List<Task> tasks) {
     StringBuilder jsonBuilder = new StringBuilder();

jsonBuilder.append("[\n");
for (int i =0 ; i< tasks.size(); i++) {
    jsonBuilder.append("  {\n");
    jsonBuilder.append("    \"id\": ").append(tasks.get(i).getId()).append(",\n");
    jsonBuilder.append("    \"description\": \"").append(tasks.get(i).getDescription()).append("\",\n");
    jsonBuilder.append("    \"status\": \"").append(tasks.get(i).getStatus()).append("\",\n");
    jsonBuilder.append("    \"createdAt\": \"").append(tasks.get(i).getCreatedAt()).append("\",\n");
    jsonBuilder.append("    \"updatedAt\": \"").append(tasks.get(i).getUpdatedAt()).append("\",\n");
    jsonBuilder.append("  }\n");
   if (i < tasks.size()-1)
       jsonBuilder.append(",");

}
        jsonBuilder.append("]");

return jsonBuilder.toString();
    }
}
