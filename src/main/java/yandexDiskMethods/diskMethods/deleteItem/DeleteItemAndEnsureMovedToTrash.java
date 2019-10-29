package yandexDiskMethods.diskMethods.deleteItem;

import org.apache.commons.httpclient.HttpStatus;
import yandexDiskMethods.trashMethods.removeFromTrash.EnsureItemIsInTrash;
import yandexDiskMethods.trashMethods.trashInfoMethods.GetItemsCount;


public class DeleteItemAndEnsureMovedToTrash {
    public static void deleteItemAndEnsureMovedToTrash(String path,  String name, int SCForRemoval404, int SCFindItemInTrash200,
                                                       int SCForDeletion202, int SCForDeletion204) {

        //codes 202, 204 for deletion, 404 - ensureItemIsDeleted, 200 - EnsureItemIsInTrash
        int trashSize = GetItemsCount.getItemsCount();

        DeleteFileOrFolder.deleteFileOrFolder(path, SCForDeletion202, SCForDeletion204);
        int newSize = 0;

        while (trashSize + 1 != newSize) {
            newSize = GetItemsCount.getItemsCount();
        }

     //   await().until(GetTrashSize.getTrashSize(), equalTo(trashSize + 1));
        EnsureItemIsDeleted.ensureItemIsDeleted(path, HttpStatus.SC_NOT_FOUND);
        EnsureItemIsInTrash.ensureItemIsInTrash(name, SCFindItemInTrash200);
    }
}
