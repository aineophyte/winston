// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connect_four.proto

package com.aineophyte.connectfour;

public interface GamePieceOrBuilder extends
    // @@protoc_insertion_point(interface_extends:connectfour.GamePiece)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>bool player2 = 1;</code>
   * @return The player2.
   */
  boolean getPlayer2();

  /**
   * <code>int32 move_number = 2;</code>
   * @return The moveNumber.
   */
  int getMoveNumber();

  /**
   * <code>optional int32 evaluations = 3;</code>
   * @return Whether the evaluations field is set.
   */
  boolean hasEvaluations();
  /**
   * <code>optional int32 evaluations = 3;</code>
   * @return The evaluations.
   */
  int getEvaluations();
}
