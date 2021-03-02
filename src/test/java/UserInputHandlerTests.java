import com.LockedMe.UserInputHandler;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserInputHandlerTests {

  @Test
  public void isValidFilenameTest() {
    assertTrue(UserInputHandler.isValidFilename("file.txt"));
  }

  @Test
  public void isInvalidFirstChar() {
    assertFalse(UserInputHandler.isValidFilename(".filetxt"));
    assertFalse(UserInputHandler.isValidFilename("-filetxt"));
    assertFalse(UserInputHandler.isValidFilename("_filetxt"));
  }

  @Test
  public void isInvalidLastChar() {
    assertFalse(UserInputHandler.isValidFilename("filetxt."));
    assertFalse(UserInputHandler.isValidFilename("filetxt-"));
    assertFalse(UserInputHandler.isValidFilename("filetxt_"));
  }


}
