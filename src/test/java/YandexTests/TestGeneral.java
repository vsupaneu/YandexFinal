package YandexTests;

import expectedStatusCodes.StatusCodes;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

import static yandexDiskMethods.trashMethods.removeFromTrash.ClearTrash.clearTrash;

public class TestGeneral {
    @BeforeMethod
    public void clearTrashBeforeMethod() {
        clearTrash(StatusCodes.SCClearTrash202);
    }

    @AfterSuite
    public void clearTrashAfterSuite() {
        clearTrash(StatusCodes.SCClearTrash202);
    }
}
