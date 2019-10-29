package yandexDiskMethods.trashMethods.removeFromTrash;

import yandexDiskMethods.diskMethods.createItem.EnsureItemCreatedOrRestored;

public class RestoreItemFromTrashAndEnsureMovedToDisk {
    public static void restoreItemFromTrashAndEnsureMovedToDisk(String path, String name, int SCRestoreFromTrash201,
                                                                int SCCreationValidation200) {
        //code 201 for restore, 200 - for validation
        RestoreItemFromTrash.restoreItemFromTrash(name, SCRestoreFromTrash201);
        EnsureItemCreatedOrRestored.ensureItemCreatedOrRestored(path, SCCreationValidation200);
    }
}
