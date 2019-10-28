package yandexDiskMethods.trashMethods.trashInfoMethods;

import org.json.JSONArray;
import org.json.JSONObject;

import static yandexDiskMethods.requestsData.RequestsData.*;
import static yandexDiskMethods.trashMethods.trashInfoMethods.GetTrashContent.getTrashContent;

public class GetSizesOfDeletedFiles {
    public static int getSizesOfDeletedFiles(String... fileNames) {
        String content = getTrashContent();
        int sumOfSizes = 0;
        JSONObject object1 = new JSONObject(content);
        JSONObject object2 = object1.getJSONObject(EMBEDDED);
        JSONArray array = (JSONArray) object2.get(ITEMS);

        for (int i = 0; i < array.length(); i++) {
            String s = array.getJSONObject(i).getString(NAME);
            for (String fileName : fileNames) {
                if (fileName.equals(s)) {
                    sumOfSizes += array.getJSONObject(i).getInt(SIZE);
                }
            }
        }
        return sumOfSizes;
    }
}
