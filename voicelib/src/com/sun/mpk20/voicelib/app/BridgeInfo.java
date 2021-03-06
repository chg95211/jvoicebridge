/*
 * Copyright 2007 Sun Microsystems, Inc.
 *
 * This file is part of jVoiceBridge.
 *
 * jVoiceBridge is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License version 2 as 
 * published by the Free Software Foundation and distributed hereunder 
 * to you.
 *
 * jVoiceBridge is distributed in the hope that it will be useful, 
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Sun designates this particular file as subject to the "Classpath"
 * exception as provided by Sun in the License file that accompanied this 
 * code. 
 */
package com.sun.mpk20.voicelib.app;

import java.io.Serializable;

public class BridgeInfo implements Serializable {

    public String bridgeId;
    public String privateHostName;
    public int privateControlPort;
    public int privateSipPort;
    public String publicHostName;
    public int publicControlPort;
    public int publicSipPort;

    public String toString() {
	return bridgeId + "::" + privateHostName
	    + ":" + privateControlPort 
	    + ":" + privateSipPort
	    + ":" + publicHostName
	    + ":" + publicControlPort
	    + ":" + publicSipPort;
    }

}
