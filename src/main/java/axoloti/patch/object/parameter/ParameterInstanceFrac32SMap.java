/**
 * Copyright (C) 2013, 2014, 2015 Johannes Taelman
 *
 * This file is part of Axoloti.
 *
 * Axoloti is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * Axoloti is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * Axoloti. If not, see <http://www.gnu.org/licenses/>.
 */
package axoloti.patch.object.parameter;

import axoloti.object.parameter.ParameterFrac32SMap;
import axoloti.patch.object.AxoObjectInstance;
import org.simpleframework.xml.Attribute;

/**
 *
 * @author Johannes Taelman
 */
public class ParameterInstanceFrac32SMap extends ParameterInstanceFrac32UMap<ParameterFrac32SMap> {

    public ParameterInstanceFrac32SMap() {
        super();
    }

    public ParameterInstanceFrac32SMap(@Attribute(name = "value") double v) {
        super(v);
    }

    public ParameterInstanceFrac32SMap(ParameterFrac32SMap param, AxoObjectInstance axoObj1) {
        super(param, axoObj1);
    }

    @Override
    public double getMin() {
        return -64.0;
    }

    @Override
    public double getMax() {
        return 64.0;
    }

    @Override
    public double getTick() {
        return 1.0;
    }

    @Override
    public String getCOffset() {
        return "0";
    }

}
