// package: connectfour
// file: connect_four.proto

/* tslint:disable */
/* eslint-disable */

import * as jspb from "google-protobuf";

export class GameBoard extends jspb.Message { 
    clearSlotsList(): void;
    getSlotsList(): Array<GameSlot>;
    setSlotsList(value: Array<GameSlot>): GameBoard;
    addSlots(value?: GameSlot, index?: number): GameSlot;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): GameBoard.AsObject;
    static toObject(includeInstance: boolean, msg: GameBoard): GameBoard.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: GameBoard, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): GameBoard;
    static deserializeBinaryFromReader(message: GameBoard, reader: jspb.BinaryReader): GameBoard;
}

export namespace GameBoard {
    export type AsObject = {
        slotsList: Array<GameSlot.AsObject>,
    }
}

export class PlayerInfo extends jspb.Message { 
    getName(): string;
    setName(value: string): PlayerInfo;
    getMode(): string;
    setMode(value: string): PlayerInfo;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): PlayerInfo.AsObject;
    static toObject(includeInstance: boolean, msg: PlayerInfo): PlayerInfo.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: PlayerInfo, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): PlayerInfo;
    static deserializeBinaryFromReader(message: PlayerInfo, reader: jspb.BinaryReader): PlayerInfo;
}

export namespace PlayerInfo {
    export type AsObject = {
        name: string,
        mode: string,
    }
}

export class GameInfo extends jspb.Message { 

    hasGameId(): boolean;
    clearGameId(): void;
    getGameId(): string | undefined;
    setGameId(value: string): GameInfo;

    hasPlayer1(): boolean;
    clearPlayer1(): void;
    getPlayer1(): PlayerInfo | undefined;
    setPlayer1(value?: PlayerInfo): GameInfo;

    hasPlayer2(): boolean;
    clearPlayer2(): void;
    getPlayer2(): PlayerInfo | undefined;
    setPlayer2(value?: PlayerInfo): GameInfo;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): GameInfo.AsObject;
    static toObject(includeInstance: boolean, msg: GameInfo): GameInfo.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: GameInfo, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): GameInfo;
    static deserializeBinaryFromReader(message: GameInfo, reader: jspb.BinaryReader): GameInfo;
}

export namespace GameInfo {
    export type AsObject = {
        gameId?: string,
        player1?: PlayerInfo.AsObject,
        player2?: PlayerInfo.AsObject,
    }
}

export class GameSlot extends jspb.Message { 
    getXCoord(): number;
    setXCoord(value: number): GameSlot;
    getYCoord(): number;
    setYCoord(value: number): GameSlot;

    hasPiece(): boolean;
    clearPiece(): void;
    getPiece(): GamePiece | undefined;
    setPiece(value?: GamePiece): GameSlot;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): GameSlot.AsObject;
    static toObject(includeInstance: boolean, msg: GameSlot): GameSlot.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: GameSlot, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): GameSlot;
    static deserializeBinaryFromReader(message: GameSlot, reader: jspb.BinaryReader): GameSlot;
}

export namespace GameSlot {
    export type AsObject = {
        xCoord: number,
        yCoord: number,
        piece?: GamePiece.AsObject,
    }
}

export class GamePiece extends jspb.Message { 
    getPlayer2(): boolean;
    setPlayer2(value: boolean): GamePiece;
    getMoveNumber(): number;
    setMoveNumber(value: number): GamePiece;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): GamePiece.AsObject;
    static toObject(includeInstance: boolean, msg: GamePiece): GamePiece.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: GamePiece, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): GamePiece;
    static deserializeBinaryFromReader(message: GamePiece, reader: jspb.BinaryReader): GamePiece;
}

export namespace GamePiece {
    export type AsObject = {
        player2: boolean,
        moveNumber: number,
    }
}

export class TurnInfo extends jspb.Message { 
    getGameId(): string;
    setGameId(value: string): TurnInfo;
    getXCoord(): number;
    setXCoord(value: number): TurnInfo;
    getPlayer2(): boolean;
    setPlayer2(value: boolean): TurnInfo;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): TurnInfo.AsObject;
    static toObject(includeInstance: boolean, msg: TurnInfo): TurnInfo.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: TurnInfo, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): TurnInfo;
    static deserializeBinaryFromReader(message: TurnInfo, reader: jspb.BinaryReader): TurnInfo;
}

export namespace TurnInfo {
    export type AsObject = {
        gameId: string,
        xCoord: number,
        player2: boolean,
    }
}

export class TurnResult extends jspb.Message { 
    getStatus(): TurnStatus;
    setStatus(value: TurnStatus): TurnResult;

    hasMoveNumber(): boolean;
    clearMoveNumber(): void;
    getMoveNumber(): number | undefined;
    setMoveNumber(value: number): TurnResult;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): TurnResult.AsObject;
    static toObject(includeInstance: boolean, msg: TurnResult): TurnResult.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: TurnResult, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): TurnResult;
    static deserializeBinaryFromReader(message: TurnResult, reader: jspb.BinaryReader): TurnResult;
}

export namespace TurnResult {
    export type AsObject = {
        status: TurnStatus,
        moveNumber?: number,
    }
}

export class DeleteResult extends jspb.Message { 
    getGameId(): string;
    setGameId(value: string): DeleteResult;

    serializeBinary(): Uint8Array;
    toObject(includeInstance?: boolean): DeleteResult.AsObject;
    static toObject(includeInstance: boolean, msg: DeleteResult): DeleteResult.AsObject;
    static extensions: {[key: number]: jspb.ExtensionFieldInfo<jspb.Message>};
    static extensionsBinary: {[key: number]: jspb.ExtensionFieldBinaryInfo<jspb.Message>};
    static serializeBinaryToWriter(message: DeleteResult, writer: jspb.BinaryWriter): void;
    static deserializeBinary(bytes: Uint8Array): DeleteResult;
    static deserializeBinaryFromReader(message: DeleteResult, reader: jspb.BinaryReader): DeleteResult;
}

export namespace DeleteResult {
    export type AsObject = {
        gameId: string,
    }
}

export enum TurnStatus {
    VALID = 0,
    INVALID = 1,
    SLOT_OCCUPIED = 2,
    OUT_OF_TURN = 3,
    WINNER = 4,
    DRAW = 5,
}
