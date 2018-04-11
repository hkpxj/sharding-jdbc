/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package io.shardingjdbc.core.parsing.parser.clause;

import io.shardingjdbc.core.parsing.lexer.LexerEngine;
import io.shardingjdbc.core.parsing.lexer.token.DefaultKeyword;
import io.shardingjdbc.core.parsing.lexer.token.Keyword;
import io.shardingjdbc.core.parsing.lexer.token.Symbol;
import io.shardingjdbc.core.parsing.parser.sql.dml.insert.InsertStatement;
import lombok.RequiredArgsConstructor;

/**
 * Insert into clause parser.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
public class InsertIntoClauseParser implements SQLClauseParser {
    
    private final LexerEngine lexerEngine;
    
    private final TableReferencesClauseParser tableReferencesClauseParser;
    
    /**
     * Parse insert into.
     *
     * @param insertStatement insert statement
     */
    public void parse(final InsertStatement insertStatement) {
        lexerEngine.unsupportedIfEqual(getUnsupportedKeywordsBeforeInto());
        lexerEngine.skipUntil(DefaultKeyword.INTO);
        lexerEngine.nextToken();
        tableReferencesClauseParser.parse(insertStatement, true);
        skipBetweenTableAndValues(insertStatement);
    }
    
    protected Keyword[] getUnsupportedKeywordsBeforeInto() {
        return new Keyword[0];
    }
    
    private void skipBetweenTableAndValues(final InsertStatement insertStatement) {
        while (lexerEngine.skipIfEqual(getSkippedKeywordsBetweenTableAndValues())) {
            lexerEngine.nextToken();
            if (lexerEngine.equalAny(Symbol.LEFT_PAREN)) {
                lexerEngine.skipParentheses(insertStatement);
            }
        }
    }
    
    protected Keyword[] getSkippedKeywordsBetweenTableAndValues() {
        return new Keyword[0];
    }
}
