package org.apache.skywalking.oal.rt;

import org.apache.skywalking.oal.rt.parser.OALScripts;
import org.apache.skywalking.oal.rt.parser.ScriptParser;
import org.apache.skywalking.oap.server.library.module.ModuleStartException;
import org.apache.skywalking.oap.server.library.util.ResourceUtils;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class OALRuntimeTest {

    @Test
    public void start() throws ModuleStartException {
        Reader read;

        try {
            read = ResourceUtils.read("oal/event.oal");
        } catch (FileNotFoundException e) {
            throw new ModuleStartException("Can't locate ", e);
        }
        // 解析.OAL文件内容
        OALScripts oalScripts;
        try {
            ScriptParser scriptParser = ScriptParser.createFromFile(read, "org.apache.skywalking.oap.server.core.source.");
            oalScripts = scriptParser.parse();
        } catch (IOException e) {
            throw new ModuleStartException("OAL script parse analysis failure.", e);
        }
    }
}