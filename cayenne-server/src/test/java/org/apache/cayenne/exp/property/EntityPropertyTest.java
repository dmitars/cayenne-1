/*****************************************************************
 *   Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 ****************************************************************/

package org.apache.cayenne.exp.property;

import org.apache.cayenne.exp.ExpressionFactory;
import org.apache.cayenne.testdo.testmap.Artist;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @since 4.2
 */
public class EntityPropertyTest {

    private EntityProperty<Artist> property;
    private EntityProperty<Artist> property1;

    @Before
    public void createProperty() {
        property = new EntityProperty<>("path", null, Artist.class);
        property1 = new EntityProperty<>("path.artist", null, Artist.class);
    }

    @Test
    public void alias() {
        assertEquals("path", property.getName());
        property = property.alias("alias");
        assertEquals("alias", property.getName());
        assertEquals(1, property.getExpression().getPathAliases().size());

        assertEquals("path.artist", property1.getName());
        property1 = property1.alias("a");
        assertEquals("path.a", property1.getName());
        assertEquals(1, property1.getExpression().getPathAliases().size());
        assertEquals("artist", property1.getExpression().getPathAliases().get("a"));
    }

    @Test
    public void outer() {
        assertEquals("path", property.getName());
        assertEquals(ExpressionFactory.pathExp("path"), property.getExpression());

        property = property.outer();

        assertEquals("path+", property.getName());
        assertEquals(ExpressionFactory.pathExp("path+"), property.getExpression());

        property = property.outer();

        assertEquals("path+", property.getName());
        assertEquals(ExpressionFactory.pathExp("path+"), property.getExpression());
    }

    @Test
    public void dot() {
        BaseProperty<?> other = property.dot("other");
        assertEquals("path.other", other.getName());
        assertEquals(ExpressionFactory.pathExp("path.other"), other.getExpression());
    }
}