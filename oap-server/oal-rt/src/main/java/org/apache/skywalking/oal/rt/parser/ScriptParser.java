/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.apache.skywalking.oal.rt.parser;

import java.io.IOException;
import java.io.Reader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.skywalking.oal.rt.grammar.OALLexer;
import org.apache.skywalking.oal.rt.grammar.OALParser;

/**
 * Script reader and parser.
 */
public class ScriptParser {
    private OALLexer lexer;

    private String sourcePackage;

    private ScriptParser() {

    }

    public static ScriptParser createFromFile(Reader scriptReader, String sourcePackage) throws IOException {
        ScriptParser parser = new ScriptParser();
        parser.lexer = new OALLexer(CharStreams.fromReader(scriptReader));
        parser.sourcePackage = sourcePackage;
        return parser;
    }

    public static ScriptParser createFromScriptText(String script, String sourcePackage) throws IOException {
        ScriptParser parser = new ScriptParser();
        // 待解析信息放入 OAL 词法分析器 对象中
        parser.lexer = new OALLexer(CharStreams.fromString(script));
        parser.sourcePackage = sourcePackage;
        return parser;
    }

    public OALScripts parse() throws IOException {
        // 初始化OALScripts对象 OAL 脚本
        OALScripts scripts = new OALScripts();
        // 把词法解析的结果进行token流的转换
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        // 拿着token流进行语法分析
        OALParser parser = new OALParser(tokens);

        ParseTree tree = parser.root();
        // 解析树遍历器
        ParseTreeWalker walker = new ParseTreeWalker();
        // 注册OALListener的监听器 后续才会执行OALListener中每个enter、exit方法
        walker.walk(new OALListener(scripts, sourcePackage), tree);

        return scripts;
    }

    public void close() {
    }
}
