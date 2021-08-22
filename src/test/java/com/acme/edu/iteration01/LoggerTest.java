package com.acme.edu.iteration01;

import com.acme.edu.Logger;
import static com.acme.edu.Logger.*;
import com.acme.edu.SysoutCaptureAndAssertionAbility;
import org.junit.jupiter.api.*;

import java.io.*;

public class LoggerTest implements SysoutCaptureAndAssertionAbility {
    static private final String sep = System.lineSeparator();

    //region given
    @BeforeEach
    public void setUpSystemOut() throws IOException {
        resetOut();
        captureSysout();
    }

    @AfterEach
    public void tearDown() {
        resetOut();
    }
    //endregion

    @Test
    public void shouldLogInteger() throws IOException {
        //region when
        Logger.log(1);
        Logger.flush();
        Logger.log(0);
        Logger.flush();
        Logger.log(-1);
        Logger.flush();
        //endregion

        //region then
        assertSysoutContains(PRIMITIVE_TYPE);
        assertSysoutEquals(PRIMITIVE_TYPE + "1" + sep + PRIMITIVE_TYPE + "0" + sep + PRIMITIVE_TYPE + "-1" + sep);
        //endregion
    }

    @Test
    public void shouldLogByte() throws IOException {
        //region when
        Logger.log((byte)1);
        Logger.log((byte)0);
        Logger.log((byte)-1);
        //endregion

        //region then
        assertSysoutContains(PRIMITIVE_TYPE);
        assertSysoutContains("1");
        assertSysoutContains("0");
        assertSysoutContains("-1");
        //endregion
    }


    // TODO: implement Logger solution to match specification as tests

    @Test
    public void shouldLogChar() throws IOException {
        //region when
        Logger.log('a');
        Logger.log('b');
        //endregion

        //region then
        assertSysoutContains(CHAR_TYPE);
        assertSysoutContains("a");
        assertSysoutContains("b");
        //endregion
    }

    @Test
    public void shouldLogString() throws IOException {
        //region when
        Logger.log("test string 1");
        Logger.log("other str");
        //endregion

        //region then
        assertSysoutContains(STRING_TYPE);
        assertSysoutContains("test string 1");
        assertSysoutContains("other str");
        //endregion
    }

    @Test
    public void shouldLogBoolean() throws IOException {
        //region when
        Logger.log(true);
        Logger.log(false);
        //endregion

        //region then
        assertSysoutContains(PRIMITIVE_TYPE);
        assertSysoutContains("true");
        assertSysoutContains("false");
        //endregion
    }

    @Test
    public void shouldLogReference() throws IOException {
        //region when
        Logger.log(new Object());
        //endregion

        //region then
        assertSysoutContains(REFERENCE_TYPE);
        assertSysoutContains("@");
        //endregion
    }

}