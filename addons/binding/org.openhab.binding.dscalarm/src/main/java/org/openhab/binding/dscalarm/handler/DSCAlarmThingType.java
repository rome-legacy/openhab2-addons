/**
 * Copyright (c) 2014-2015 openHAB UG (haftungsbeschraenkt) and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.openhab.binding.dscalarm.handler;

import java.util.HashMap;
import java.util.Map;

/**
 * Used to map thing types from the binding string to a ENUM value.
 * 
 * @author Russell Stephens - Initial Contribution
 */
public enum DSCAlarmThingType {
    PANEL("panel"),
    PARTITION("partition"),
    ZONE("zone"),
    KEYPAD("keypad");

    private String label;

    /**
     * Lookup map to get a DSCAlarmDeviceType from its label.
     */
    private static Map<String, DSCAlarmThingType> labelToDSCAlarmThingType;

    /**
     * Constructor.
     * 
     * @param label
     */
    private DSCAlarmThingType(String label) {
        this.label = label;
    }

    /**
     * Creates a HashMap that maps the string label to a DSCAlarmDeviceType enum value.
     */
    private static void initMapping() {
        labelToDSCAlarmThingType = new HashMap<String, DSCAlarmThingType>();
        for (DSCAlarmThingType s : values()) {
            labelToDSCAlarmThingType.put(s.label, s);
        }
    }

    /**
     * Returns the label of the DSCAlarmItemType Values enumeration.
     * 
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * Lookup function based on the binding type label. Returns null if the binding type is not found.
     * 
     * @param label
     * @return enum value
     */
    public static DSCAlarmThingType getDSCAlarmThingType(String label) {
        if (labelToDSCAlarmThingType == null) {
            initMapping();
        }
        return labelToDSCAlarmThingType.get(label);
    }

}
