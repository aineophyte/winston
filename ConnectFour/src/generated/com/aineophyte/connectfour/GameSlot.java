// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connect_four.proto

package com.aineophyte.connectfour;

/**
 * Protobuf type {@code connectfour.GameSlot}
 */
public final class GameSlot extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:connectfour.GameSlot)
    GameSlotOrBuilder {
private static final long serialVersionUID = 0L;
  // Use GameSlot.newBuilder() to construct.
  private GameSlot(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private GameSlot() {
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new GameSlot();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameSlot_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameSlot_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.aineophyte.connectfour.GameSlot.class, com.aineophyte.connectfour.GameSlot.Builder.class);
  }

  private int bitField0_;
  public static final int X_COORD_FIELD_NUMBER = 1;
  private int xCoord_ = 0;
  /**
   * <code>int32 x_coord = 1;</code>
   * @return The xCoord.
   */
  @java.lang.Override
  public int getXCoord() {
    return xCoord_;
  }

  public static final int Y_COORD_FIELD_NUMBER = 2;
  private int yCoord_ = 0;
  /**
   * <code>int32 y_coord = 2;</code>
   * @return The yCoord.
   */
  @java.lang.Override
  public int getYCoord() {
    return yCoord_;
  }

  public static final int PIECE_FIELD_NUMBER = 3;
  private com.aineophyte.connectfour.GamePiece piece_;
  /**
   * <code>optional .connectfour.GamePiece piece = 3;</code>
   * @return Whether the piece field is set.
   */
  @java.lang.Override
  public boolean hasPiece() {
    return ((bitField0_ & 0x00000001) != 0);
  }
  /**
   * <code>optional .connectfour.GamePiece piece = 3;</code>
   * @return The piece.
   */
  @java.lang.Override
  public com.aineophyte.connectfour.GamePiece getPiece() {
    return piece_ == null ? com.aineophyte.connectfour.GamePiece.getDefaultInstance() : piece_;
  }
  /**
   * <code>optional .connectfour.GamePiece piece = 3;</code>
   */
  @java.lang.Override
  public com.aineophyte.connectfour.GamePieceOrBuilder getPieceOrBuilder() {
    return piece_ == null ? com.aineophyte.connectfour.GamePiece.getDefaultInstance() : piece_;
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
    if (xCoord_ != 0) {
      output.writeInt32(1, xCoord_);
    }
    if (yCoord_ != 0) {
      output.writeInt32(2, yCoord_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      output.writeMessage(3, getPiece());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (xCoord_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, xCoord_);
    }
    if (yCoord_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, yCoord_);
    }
    if (((bitField0_ & 0x00000001) != 0)) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(3, getPiece());
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
    if (!(obj instanceof com.aineophyte.connectfour.GameSlot)) {
      return super.equals(obj);
    }
    com.aineophyte.connectfour.GameSlot other = (com.aineophyte.connectfour.GameSlot) obj;

    if (getXCoord()
        != other.getXCoord()) return false;
    if (getYCoord()
        != other.getYCoord()) return false;
    if (hasPiece() != other.hasPiece()) return false;
    if (hasPiece()) {
      if (!getPiece()
          .equals(other.getPiece())) return false;
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
    hash = (37 * hash) + X_COORD_FIELD_NUMBER;
    hash = (53 * hash) + getXCoord();
    hash = (37 * hash) + Y_COORD_FIELD_NUMBER;
    hash = (53 * hash) + getYCoord();
    if (hasPiece()) {
      hash = (37 * hash) + PIECE_FIELD_NUMBER;
      hash = (53 * hash) + getPiece().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.aineophyte.connectfour.GameSlot parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static com.aineophyte.connectfour.GameSlot parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static com.aineophyte.connectfour.GameSlot parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.aineophyte.connectfour.GameSlot parseFrom(
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
  public static Builder newBuilder(com.aineophyte.connectfour.GameSlot prototype) {
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
   * Protobuf type {@code connectfour.GameSlot}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:connectfour.GameSlot)
      com.aineophyte.connectfour.GameSlotOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameSlot_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameSlot_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.aineophyte.connectfour.GameSlot.class, com.aineophyte.connectfour.GameSlot.Builder.class);
    }

    // Construct using com.aineophyte.connectfour.GameSlot.newBuilder()
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
        getPieceFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      xCoord_ = 0;
      yCoord_ = 0;
      piece_ = null;
      if (pieceBuilder_ != null) {
        pieceBuilder_.dispose();
        pieceBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.aineophyte.connectfour.ConnectFourProto.internal_static_connectfour_GameSlot_descriptor;
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameSlot getDefaultInstanceForType() {
      return com.aineophyte.connectfour.GameSlot.getDefaultInstance();
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameSlot build() {
      com.aineophyte.connectfour.GameSlot result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.aineophyte.connectfour.GameSlot buildPartial() {
      com.aineophyte.connectfour.GameSlot result = new com.aineophyte.connectfour.GameSlot(this);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartial0(com.aineophyte.connectfour.GameSlot result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000001) != 0)) {
        result.xCoord_ = xCoord_;
      }
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.yCoord_ = yCoord_;
      }
      int to_bitField0_ = 0;
      if (((from_bitField0_ & 0x00000004) != 0)) {
        result.piece_ = pieceBuilder_ == null
            ? piece_
            : pieceBuilder_.build();
        to_bitField0_ |= 0x00000001;
      }
      result.bitField0_ |= to_bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.aineophyte.connectfour.GameSlot) {
        return mergeFrom((com.aineophyte.connectfour.GameSlot)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.aineophyte.connectfour.GameSlot other) {
      if (other == com.aineophyte.connectfour.GameSlot.getDefaultInstance()) return this;
      if (other.getXCoord() != 0) {
        setXCoord(other.getXCoord());
      }
      if (other.getYCoord() != 0) {
        setYCoord(other.getYCoord());
      }
      if (other.hasPiece()) {
        mergePiece(other.getPiece());
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
            case 8: {
              xCoord_ = input.readInt32();
              bitField0_ |= 0x00000001;
              break;
            } // case 8
            case 16: {
              yCoord_ = input.readInt32();
              bitField0_ |= 0x00000002;
              break;
            } // case 16
            case 26: {
              input.readMessage(
                  getPieceFieldBuilder().getBuilder(),
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

    private int xCoord_ ;
    /**
     * <code>int32 x_coord = 1;</code>
     * @return The xCoord.
     */
    @java.lang.Override
    public int getXCoord() {
      return xCoord_;
    }
    /**
     * <code>int32 x_coord = 1;</code>
     * @param value The xCoord to set.
     * @return This builder for chaining.
     */
    public Builder setXCoord(int value) {

      xCoord_ = value;
      bitField0_ |= 0x00000001;
      onChanged();
      return this;
    }
    /**
     * <code>int32 x_coord = 1;</code>
     * @return This builder for chaining.
     */
    public Builder clearXCoord() {
      bitField0_ = (bitField0_ & ~0x00000001);
      xCoord_ = 0;
      onChanged();
      return this;
    }

    private int yCoord_ ;
    /**
     * <code>int32 y_coord = 2;</code>
     * @return The yCoord.
     */
    @java.lang.Override
    public int getYCoord() {
      return yCoord_;
    }
    /**
     * <code>int32 y_coord = 2;</code>
     * @param value The yCoord to set.
     * @return This builder for chaining.
     */
    public Builder setYCoord(int value) {

      yCoord_ = value;
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     * <code>int32 y_coord = 2;</code>
     * @return This builder for chaining.
     */
    public Builder clearYCoord() {
      bitField0_ = (bitField0_ & ~0x00000002);
      yCoord_ = 0;
      onChanged();
      return this;
    }

    private com.aineophyte.connectfour.GamePiece piece_;
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.GamePiece, com.aineophyte.connectfour.GamePiece.Builder, com.aineophyte.connectfour.GamePieceOrBuilder> pieceBuilder_;
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     * @return Whether the piece field is set.
     */
    public boolean hasPiece() {
      return ((bitField0_ & 0x00000004) != 0);
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     * @return The piece.
     */
    public com.aineophyte.connectfour.GamePiece getPiece() {
      if (pieceBuilder_ == null) {
        return piece_ == null ? com.aineophyte.connectfour.GamePiece.getDefaultInstance() : piece_;
      } else {
        return pieceBuilder_.getMessage();
      }
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public Builder setPiece(com.aineophyte.connectfour.GamePiece value) {
      if (pieceBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        piece_ = value;
      } else {
        pieceBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public Builder setPiece(
        com.aineophyte.connectfour.GamePiece.Builder builderForValue) {
      if (pieceBuilder_ == null) {
        piece_ = builderForValue.build();
      } else {
        pieceBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public Builder mergePiece(com.aineophyte.connectfour.GamePiece value) {
      if (pieceBuilder_ == null) {
        if (((bitField0_ & 0x00000004) != 0) &&
          piece_ != null &&
          piece_ != com.aineophyte.connectfour.GamePiece.getDefaultInstance()) {
          getPieceBuilder().mergeFrom(value);
        } else {
          piece_ = value;
        }
      } else {
        pieceBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000004;
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public Builder clearPiece() {
      bitField0_ = (bitField0_ & ~0x00000004);
      piece_ = null;
      if (pieceBuilder_ != null) {
        pieceBuilder_.dispose();
        pieceBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public com.aineophyte.connectfour.GamePiece.Builder getPieceBuilder() {
      bitField0_ |= 0x00000004;
      onChanged();
      return getPieceFieldBuilder().getBuilder();
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    public com.aineophyte.connectfour.GamePieceOrBuilder getPieceOrBuilder() {
      if (pieceBuilder_ != null) {
        return pieceBuilder_.getMessageOrBuilder();
      } else {
        return piece_ == null ?
            com.aineophyte.connectfour.GamePiece.getDefaultInstance() : piece_;
      }
    }
    /**
     * <code>optional .connectfour.GamePiece piece = 3;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
        com.aineophyte.connectfour.GamePiece, com.aineophyte.connectfour.GamePiece.Builder, com.aineophyte.connectfour.GamePieceOrBuilder> 
        getPieceFieldBuilder() {
      if (pieceBuilder_ == null) {
        pieceBuilder_ = new com.google.protobuf.SingleFieldBuilderV3<
            com.aineophyte.connectfour.GamePiece, com.aineophyte.connectfour.GamePiece.Builder, com.aineophyte.connectfour.GamePieceOrBuilder>(
                getPiece(),
                getParentForChildren(),
                isClean());
        piece_ = null;
      }
      return pieceBuilder_;
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


    // @@protoc_insertion_point(builder_scope:connectfour.GameSlot)
  }

  // @@protoc_insertion_point(class_scope:connectfour.GameSlot)
  private static final com.aineophyte.connectfour.GameSlot DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.aineophyte.connectfour.GameSlot();
  }

  public static com.aineophyte.connectfour.GameSlot getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<GameSlot>
      PARSER = new com.google.protobuf.AbstractParser<GameSlot>() {
    @java.lang.Override
    public GameSlot parsePartialFrom(
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

  public static com.google.protobuf.Parser<GameSlot> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<GameSlot> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.aineophyte.connectfour.GameSlot getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

