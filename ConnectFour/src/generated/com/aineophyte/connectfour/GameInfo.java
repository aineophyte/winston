// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connect_four.proto

package com.aineophyte.connectfour;

/**
 * <pre>
 * The game info contains the game id and ...
 * </pre>
 *
 * Protobuf type {@code connectfour.GameInfo}
 */
public final class GameInfo extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:connectfour.GameInfo)
    GameInfoOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GameInfo.newBuilder() to construct.
  private GameInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GameInfo() {
    gameId_ = "";
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GameInfo();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameInfo_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameInfo_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.aineophyte.connectfour.GameInfo.class, com.aineophyte.connectfour.GameInfo.Builder.class);
  }

  private int bitField0_;
  public static final int GAME_ID_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private volatile java.lang.Object gameId_ = "";
  /**
   * <code>optional string game_id = 1;</code>
   * @return Whether the gameId field is set.
   */
  @java.lang.Override
  public boolean hasGameId() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional string game_id = 1;</code>
   * @return The gameId.
   */
  @java.lang.Override
  public java.lang.String getGameId() {
    java.lang.Object ref = gameId_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      gameId_ = s;
      return s;
    }
  }
  /**
   * <code>optional string game_id = 1;</code>
   * @return The bytes for gameId.
   */
  @java.lang.Override
  public com.google.protobuf.ByteString
      getGameIdBytes() {
    java.lang.Object ref = gameId_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      gameId_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int PLAYER1_FIELD_NUMBER = 2;
  private com.aineophyte.connectfour.PlayerInfo player1_;
  /**
   * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
   * @return Whether the player1 field is set.
   */
  @java.lang.Override
  public boolean hasPlayer1() {
    return ((bitField0_ & 0x00000002) != 0);
  }
  /**
   * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
   * @return The player1.
   */
  @java.lang.Override
  public com.aineophyte.connectfour.PlayerInfo getPlayer1() {
    return player1_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player1_;
  }
  /**
   * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
   */
  @java.lang.Override
  public com.aineophyte.connectfour.PlayerInfoOrBuilder getPlayer1OrBuilder() {
    return player1_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player1_;
  }

  public static final int PLAYER2_FIELD_NUMBER = 3;
  private com.aineophyte.connectfour.PlayerInfo player2_;
  /**
   * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
   * @return Whether the player2 field is set.
   */
  @java.lang.Override
  public boolean hasPlayer2() {
    return ((bitField0_ & 0x00000004) != 0);
  }
  /**
   * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
   * @return The player2.
   */
  @java.lang.Override
  public com.aineophyte.connectfour.PlayerInfo getPlayer2() {
    return player2_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player2_;
  }
  /**
   * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
   */
  @java.lang.Override
  public com.aineophyte.connectfour.PlayerInfoOrBuilder getPlayer2OrBuilder() {
    return player2_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player2_;
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (((bitField0_ & 0x00000001) != 0)) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, gameId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      output.writeMessage(2, getPlayer1());
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      output.writeMessage(3, getPlayer2());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, gameId_);
    }
    if (((bitField0_ & 0x00000002) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(2, getPlayer1());
    }
    if (((bitField0_ & 0x00000004) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getPlayer2());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.aineophyte.connectfour.GameInfo)) {
      return super.equals(obj);
    }
    com.aineophyte.connectfour.GameInfo other = (com.aineophyte.connectfour.GameInfo) obj;

    if (hasGameId() != other.hasGameId()) return false;
    if (hasGameId()) {
      if (!getGameId()
          .equals(other.getGameId())) return false;
    }
    if (hasPlayer1() != other.hasPlayer1()) return false;
    if (hasPlayer1()) {
      if (!getPlayer1()
          .equals(other.getPlayer1())) return false;
    }
    if (hasPlayer2() != other.hasPlayer2()) return false;
    if (hasPlayer2()) {
      if (!getPlayer2()
          .equals(other.getPlayer2())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (hasGameId()) {
      hash = (37 * hash) + GAME_ID_FIELD_NUMBER;
      hash = (53 * hash) + getGameId().hashCode();
    }
    if (hasPlayer1()) {
      hash = (37 * hash) + PLAYER1_FIELD_NUMBER;
      hash = (53 * hash) + getPlayer1().hashCode();
    }
    if (hasPlayer2()) {
      hash = (37 * hash) + PLAYER2_FIELD_NUMBER;
      hash = (53 * hash) + getPlayer2().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.aineophyte.connectfour.GameInfo parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.aineophyte.connectfour.GameInfo parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.aineophyte.connectfour.GameInfo parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aineophyte.connectfour.GameInfo parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.aineophyte.connectfour.GameInfo prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * The game info contains the game id and ...
   * </pre>
   *
   * Protobuf type {@code connectfour.GameInfo}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:connectfour.GameInfo)
      com.aineophyte.connectfour.GameInfoOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameInfo_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.aineophyte.connectfour.GameInfo.class, com.aineophyte.connectfour.GameInfo.Builder.class);
    }

    // Construct using com.aineophyte.connectfour.GameInfo.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getPlayer1FieldBuilder();
        getPlayer2FieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      gameId_ = "";
      player1_ = null;
      if (player1Builder_ != null) {
        player1Builder_.dispose();
        player1Builder_ = null;
      }
      player2_ = null;
      if (player2Builder_ != null) {
        player2Builder_.dispose();
        player2Builder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameInfo_descriptor;
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameInfo getDefaultInstanceForType() {
      return com.aineophyte.connectfour.GameInfo.getDefaultInstance();
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameInfo build() {
      com.aineophyte.connectfour.GameInfo result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameInfo buildPartial() {
      com.aineophyte.connectfour.GameInfo result = new com.aineophyte.connectfour.GameInfo(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.aineophyte.connectfour.GameInfo result) {
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.gameId_ = gameId_;
        to_bitField0_ |= 0x00000001;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.player1_ = player1Builder_ == null
            ? player1_
            : player1Builder_.build();
        to_bitField0_ |= 0x00000002;
      }
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.player2_ = player2Builder_ == null
            ? player2_
            : player2Builder_.build();
        to_bitField0_ |= 0x00000004;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.aineophyte.connectfour.GameInfo) {
        return mergeFrom((com.aineophyte.connectfour.GameInfo)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.aineophyte.connectfour.GameInfo other) {
      if (other == com.aineophyte.connectfour.GameInfo.getDefaultInstance()) return this;
      if (other.hasGameId()) {
        gameId_ = other.gameId_;
        bitField0_ |= 0x00000001;
        onChanged();
      }
      if (other.hasPlayer1()) {
        mergePlayer1(other.getPlayer1());
      }
      if (other.hasPlayer2()) {
        mergePlayer2(other.getPlayer2());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              gameId_ = input.readStringRequireUtf8();
              bitField0_ |= 0x00000001;
              break;
            } // case 10
            case 18: {
              input.readMessage(
                  getPlayer1FieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000002;
              break;
            } // case 18
            case 26: {
              input.readMessage(
                  getPlayer2FieldBuilder().getBuilder(),
                  extensionRegistry);
              bitField0_ |= 0x00000004;
              break;
            } // case 26
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.lang.Object gameId_ = "";
    /**
     * <code>optional string game_id = 1;</code>
     * @return Whether the gameId field is set.
     */
    public boolean hasGameId() {
      return ((bitField0_ & 0x00000001) != 0);
    }
    /**
     * <code>optional string game_id = 1;</code>
     * @return The gameId.
     */
    public java.lang.String getGameId() {
      java.lang.Object ref = gameId_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        gameId_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>optional string game_id = 1;</code>
     * @return The bytes for gameId.
     */
    public com.google.protobuf.ByteString
        getGameIdBytes() {
      java.lang.Object ref = gameId_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        gameId_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>optional string game_id = 1;</code>
     * @param value The gameId to set.
     * @return This builder for chaining.
     */
    public Builder setGameId(
        java.lang.String value) {
      if (value == null) { throw new NullPointerException(); }
      gameId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>optional string game_id = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearGameId() {
      gameId_ = getDefaultInstance().getGameId();
      bitField0_ = (bitField0_ & ~0x00000001);
      onChanged();
      return this;
    }
    /**
     * <code>optional string game_id = 1;</code>
     * @param value The bytes for gameId to set.
     * @return This builder for chaining.
     */
    public Builder setGameIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) { throw new NullPointerException(); }
      checkByteStringIsUtf8(value);
      gameId_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }

    private com.aineophyte.connectfour.PlayerInfo player1_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder> player1Builder_;
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     * @return Whether the player1 field is set.
     */
    public boolean hasPlayer1() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     * @return The player1.
     */
    public com.aineophyte.connectfour.PlayerInfo getPlayer1() {
      if (player1Builder_ == null) {
        return player1_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player1_;
      } else {
        return player1Builder_.getMessage();
      }
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public Builder setPlayer1(com.aineophyte.connectfour.PlayerInfo value) {
      if (player1Builder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        player1_ = value;
      } else {
        player1Builder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public Builder setPlayer1(
        com.aineophyte.connectfour.PlayerInfo.Builder builderForValue) {
      if (player1Builder_ == null) {
        player1_ = builderForValue.build();
      } else {
        player1Builder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public Builder mergePlayer1(com.aineophyte.connectfour.PlayerInfo value) {
      if (player1Builder_ == null) {
        if (((bitField0_ & 0x00000002) != 0) &&
          player1_ != null &&
          player1_ != com.aineophyte.connectfour.PlayerInfo.getDefaultInstance()) {
          getPlayer1Builder().mergeFrom(value);
        } else {
          player1_ = value;
        }
      } else {
        player1Builder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public Builder clearPlayer1() {
      bitField0_ = (bitField0_ & ~0x00000002);
      player1_ = null;
      if (player1Builder_ != null) {
        player1Builder_.dispose();
        player1Builder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public com.aineophyte.connectfour.PlayerInfo.Builder getPlayer1Builder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getPlayer1FieldBuilder().getBuilder();
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    public com.aineophyte.connectfour.PlayerInfoOrBuilder getPlayer1OrBuilder() {
      if (player1Builder_ != null) {
        return player1Builder_.getMessageOrBuilder();
      } else {
        return player1_ == null ?
            com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player1_;
      }
    }
    /**
     * <code>optional .connectfour.PlayerInfo player1 = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder> 
        getPlayer1FieldBuilder() {
      if (player1Builder_ == null) {
        player1Builder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder>(
                getPlayer1(),
                getParentForChildren(),
                isClean());
        player1_ = null;
      }
      return player1Builder_;
    }

    private com.aineophyte.connectfour.PlayerInfo player2_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder> player2Builder_;
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     * @return Whether the player2 field is set.
     */
    public boolean hasPlayer2() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     * @return The player2.
     */
    public com.aineophyte.connectfour.PlayerInfo getPlayer2() {
      if (player2Builder_ == null) {
        return player2_ == null ? com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player2_;
      } else {
        return player2Builder_.getMessage();
      }
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public Builder setPlayer2(com.aineophyte.connectfour.PlayerInfo value) {
      if (player2Builder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        player2_ = value;
      } else {
        player2Builder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public Builder setPlayer2(
        com.aineophyte.connectfour.PlayerInfo.Builder builderForValue) {
      if (player2Builder_ == null) {
        player2_ = builderForValue.build();
      } else {
        player2Builder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public Builder mergePlayer2(com.aineophyte.connectfour.PlayerInfo value) {
      if (player2Builder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          player2_ != null &&
          player2_ != com.aineophyte.connectfour.PlayerInfo.getDefaultInstance()) {
          getPlayer2Builder().mergeFrom(value);
        } else {
          player2_ = value;
        }
      } else {
        player2Builder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public Builder clearPlayer2() {
      bitField0_ = (bitField0_ & ~0x00000004);
      player2_ = null;
      if (player2Builder_ != null) {
        player2Builder_.dispose();
        player2Builder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public com.aineophyte.connectfour.PlayerInfo.Builder getPlayer2Builder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getPlayer2FieldBuilder().getBuilder();
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    public com.aineophyte.connectfour.PlayerInfoOrBuilder getPlayer2OrBuilder() {
      if (player2Builder_ != null) {
        return player2Builder_.getMessageOrBuilder();
      } else {
        return player2_ == null ?
            com.aineophyte.connectfour.PlayerInfo.getDefaultInstance() : player2_;
      }
    }
    /**
     * <code>optional .connectfour.PlayerInfo player2 = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder> 
        getPlayer2FieldBuilder() {
      if (player2Builder_ == null) {
        player2Builder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.aineophyte.connectfour.PlayerInfo, com.aineophyte.connectfour.PlayerInfo.Builder, com.aineophyte.connectfour.PlayerInfoOrBuilder>(
                getPlayer2(),
                getParentForChildren(),
                isClean());
        player2_ = null;
      }
      return player2Builder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:connectfour.GameInfo)
  }

  // @@protoc_insertion_point(class_scope:connectfour.GameInfo)
  private static final com.aineophyte.connectfour.GameInfo DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.aineophyte.connectfour.GameInfo();
  }

  public static com.aineophyte.connectfour.GameInfo getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameInfo>
      PARSER = new com.google.protobuf.AbstractParser<GameInfo>() {
    @java.lang.Override
    public GameInfo parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<GameInfo> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameInfo> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.aineophyte.connectfour.GameInfo getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
