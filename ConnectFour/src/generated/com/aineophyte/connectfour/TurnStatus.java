// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connect_four.proto

package com.aineophyte.connectfour;

/**
 * Protobuf enum {@code connectfour.TurnStatus}
 */
public enum TurnStatus
    implements com.google.protobuf.ProtocolMessageEnum {
  /**
   * <code>VALID = 0;</code>
   */
  VALID(0),
  /**
   * <code>INVALID = 1;</code>
   */
  INVALID(1),
  /**
   * <code>SLOT_OCCUPIED = 2;</code>
   */
  SLOT_OCCUPIED(2),
  /**
   * <code>OUT_OF_TURN = 3;</code>
   */
  OUT_OF_TURN(3),
  /**
   * <code>WINNER = 4;</code>
   */
  WINNER(4),
  UNRECOGNIZED(-1),
  ;

  /**
   * <code>VALID = 0;</code>
   */
  public static final int VALID_VALUE = 0;
  /**
   * <code>INVALID = 1;</code>
   */
  public static final int INVALID_VALUE = 1;
  /**
   * <code>SLOT_OCCUPIED = 2;</code>
   */
  public static final int SLOT_OCCUPIED_VALUE = 2;
  /**
   * <code>OUT_OF_TURN = 3;</code>
   */
  public static final int OUT_OF_TURN_VALUE = 3;
  /**
   * <code>WINNER = 4;</code>
   */
  public static final int WINNER_VALUE = 4;


  public final int getNumber() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalArgumentException(
          "Can't get the number of an unknown enum value.");
    }
    return value;
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   * @deprecated Use {@link #forNumber(int)} instead.
   */
  @java.lang.Deprecated
  public static TurnStatus valueOf(int value) {
    return forNumber(value);
  }

  /**
   * @param value The numeric wire value of the corresponding enum entry.
   * @return The enum associated with the given numeric wire value.
   */
  public static TurnStatus forNumber(int value) {
    switch (value) {
      case 0: return VALID;
      case 1: return INVALID;
      case 2: return SLOT_OCCUPIED;
      case 3: return OUT_OF_TURN;
      case 4: return WINNER;
      default: return null;
    }
  }

  public static com.google.protobuf.Internal.EnumLiteMap<TurnStatus>
      internalGetValueMap() {
    return internalValueMap;
  }
  private static final com.google.protobuf.Internal.EnumLiteMap<
      TurnStatus> internalValueMap =
        new com.google.protobuf.Internal.EnumLiteMap<TurnStatus>() {
          public TurnStatus findValueByNumber(int number) {
            return TurnStatus.forNumber(number);
          }
        };

  public final com.google.protobuf.Descriptors.EnumValueDescriptor
      getValueDescriptor() {
    if (this == UNRECOGNIZED) {
      throw new java.lang.IllegalStateException(
          "Can't get the descriptor of an unrecognized enum value.");
    }
    return getDescriptor().getValues().get(ordinal());
  }
  public final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptorForType() {
    return getDescriptor();
  }
  public static final com.google.protobuf.Descriptors.EnumDescriptor
      getDescriptor() {
    return com.aineophyte.connectfour.ConnectFourProto.getDescriptor().getEnumTypes().get(0);
  }

  private static final TurnStatus[] VALUES = values();

  public static TurnStatus valueOf(
      com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
    if (desc.getType() != getDescriptor()) {
      throw new java.lang.IllegalArgumentException(
        "EnumValueDescriptor is not for this type.");
    }
    if (desc.getIndex() == -1) {
      return UNRECOGNIZED;
    }
    return VALUES[desc.getIndex()];
  }

  private final int value;

  private TurnStatus(int value) {
    this.value = value;
  }

  // @@protoc_insertion_point(enum_scope:connectfour.TurnStatus)
}
