// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: connect_four.proto

package com.aineophyte.connectfour;

public final class ConnectFourProto {
  private ConnectFourProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_GameBoard_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_GameBoard_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_PlayerInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_PlayerInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_GameInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_GameInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_GameSlot_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_GameSlot_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_GamePiece_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_GamePiece_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_TurnInfo_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_TurnInfo_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_connectfour_TurnResult_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_connectfour_TurnResult_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022connect_four.proto\022\013connectfour\"1\n\tGam" +
      "eBoard\022$\n\005slots\030\001 \003(\0132\025.connectfour.Game" +
      "Slot\"-\n\nPlayerInfo\022\014\n\004name\030\001 \001(\t\022\021\n\tauto" +
      "_play\030\002 \001(\010\"\242\001\n\010GameInfo\022\024\n\007game_id\030\001 \001(" +
      "\tH\000\210\001\001\022-\n\007player1\030\002 \001(\0132\027.connectfour.Pl" +
      "ayerInfoH\001\210\001\001\022-\n\007player2\030\003 \001(\0132\027.connect" +
      "four.PlayerInfoH\002\210\001\001B\n\n\010_game_idB\n\n\010_pla" +
      "yer1B\n\n\010_player2\"b\n\010GameSlot\022\017\n\007x_coord\030" +
      "\001 \001(\005\022\017\n\007y_coord\030\002 \001(\005\022*\n\005piece\030\003 \001(\0132\026." +
      "connectfour.GamePieceH\000\210\001\001B\010\n\006_piece\"\034\n\t" +
      "GamePiece\022\017\n\007player2\030\001 \001(\010\"=\n\010TurnInfo\022\017" +
      "\n\007game_id\030\001 \001(\t\022\017\n\007x_coord\030\002 \001(\005\022\017\n\007play" +
      "er2\030\003 \001(\010\"5\n\nTurnResult\022\'\n\006status\030\001 \001(\0162" +
      "\027.connectfour.TurnStatus*T\n\nTurnStatus\022\t" +
      "\n\005VALID\020\000\022\013\n\007INVALID\020\001\022\021\n\rSLOT_OCCUPIED\020" +
      "\002\022\017\n\013OUT_OF_TURN\020\003\022\n\n\006WINNER\020\0042\310\001\n\013Conne" +
      "ctFour\022;\n\tStartGame\022\025.connectfour.GameIn" +
      "fo\032\025.connectfour.GameInfo\"\000\022;\n\010GetBoard\022" +
      "\025.connectfour.GameInfo\032\026.connectfour.Gam" +
      "eBoard\"\000\022?\n\013ExecuteTurn\022\025.connectfour.Tu" +
      "rnInfo\032\027.connectfour.TurnResult\"\000B5\n\032com" +
      ".aineophyte.connectfourB\020ConnectFourProt" +
      "oP\001\242\002\002CFb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_connectfour_GameBoard_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_connectfour_GameBoard_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_GameBoard_descriptor,
        new java.lang.String[] { "Slots", });
    internal_static_connectfour_PlayerInfo_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_connectfour_PlayerInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_PlayerInfo_descriptor,
        new java.lang.String[] { "Name", "AutoPlay", });
    internal_static_connectfour_GameInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_connectfour_GameInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_GameInfo_descriptor,
        new java.lang.String[] { "GameId", "Player1", "Player2", "GameId", "Player1", "Player2", });
    internal_static_connectfour_GameSlot_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_connectfour_GameSlot_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_GameSlot_descriptor,
        new java.lang.String[] { "XCoord", "YCoord", "Piece", "Piece", });
    internal_static_connectfour_GamePiece_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_connectfour_GamePiece_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_GamePiece_descriptor,
        new java.lang.String[] { "Player2", });
    internal_static_connectfour_TurnInfo_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_connectfour_TurnInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_TurnInfo_descriptor,
        new java.lang.String[] { "GameId", "XCoord", "Player2", });
    internal_static_connectfour_TurnResult_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_connectfour_TurnResult_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_connectfour_TurnResult_descriptor,
        new java.lang.String[] { "Status", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}