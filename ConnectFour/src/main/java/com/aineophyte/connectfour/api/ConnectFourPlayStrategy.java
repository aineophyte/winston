package com.aineophyte.connectfour.api;

import com.aineophyte.connectfour.GameBoard;

public interface ConnectFourPlayStrategy
{
	ConnectFourSlotInfo getSlot(GameBoard board);
}
