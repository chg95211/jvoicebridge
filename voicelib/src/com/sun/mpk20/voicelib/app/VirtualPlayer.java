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

import java.util.ArrayList;

public class VirtualPlayer implements Serializable {

    public AudioGroup audioGroup;
    public Player player;
    public Player realPlayer;
    public Player playerWithVirtualPlayer;

    public VirtualPlayer(AudioGroup audioGroup, Player player, Player realPlayer,
	    Player playerWithVirtualPlayer) {

	this.audioGroup = audioGroup;
	this.player = player;
	this.realPlayer = realPlayer;
	this.playerWithVirtualPlayer = playerWithVirtualPlayer;
    }
	
    public String getId() {
	return player.getId();
    }

    public boolean equals(Object o) {
	if (o instanceof VirtualPlayer == false) {
	    return false;
	}

	return getId().equals(((VirtualPlayer) o).getId());
    }

    public String toString() {
	return getId() + ":  audioGroup " + audioGroup + ", real player " + realPlayer 
	+ " player with virtual player " + playerWithVirtualPlayer;
    }

}
