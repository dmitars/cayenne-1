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

package org.apache.cayenne.configuration.event;

import java.util.EventListener;

/**
 * An interface for a listener interested in DataMap changes.
 */
public interface DataMapListener extends EventListener {

    /**
     * Called on DataMap property changes. 
     */
    public void dataMapChanged(DataMapEvent e);

    /** 
     * Called when a new DataMap is added.
     */
    public void dataMapAdded(DataMapEvent e);

    /** 
     * Called when a DataMap is removed.
     */
    public void dataMapRemoved(DataMapEvent e);

}
