// package: connectfour
// file: connect_four.proto

/* tslint:disable */
/* eslint-disable */

import * as grpc from "@grpc/grpc-js";
import * as connect_four_pb from "./connect_four_pb";

interface IConnectFourService extends grpc.ServiceDefinition<grpc.UntypedServiceImplementation> {
    startGame: IConnectFourService_IStartGame;
    getBoard: IConnectFourService_IGetBoard;
    executeTurn: IConnectFourService_IExecuteTurn;
    deleteGame: IConnectFourService_IDeleteGame;
}

interface IConnectFourService_IStartGame extends grpc.MethodDefinition<connect_four_pb.GameInfo, connect_four_pb.GameInfo> {
    path: "/connectfour.ConnectFour/StartGame";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<connect_four_pb.GameInfo>;
    requestDeserialize: grpc.deserialize<connect_four_pb.GameInfo>;
    responseSerialize: grpc.serialize<connect_four_pb.GameInfo>;
    responseDeserialize: grpc.deserialize<connect_four_pb.GameInfo>;
}
interface IConnectFourService_IGetBoard extends grpc.MethodDefinition<connect_four_pb.GameInfo, connect_four_pb.GameBoard> {
    path: "/connectfour.ConnectFour/GetBoard";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<connect_four_pb.GameInfo>;
    requestDeserialize: grpc.deserialize<connect_four_pb.GameInfo>;
    responseSerialize: grpc.serialize<connect_four_pb.GameBoard>;
    responseDeserialize: grpc.deserialize<connect_four_pb.GameBoard>;
}
interface IConnectFourService_IExecuteTurn extends grpc.MethodDefinition<connect_four_pb.TurnInfo, connect_four_pb.TurnResult> {
    path: "/connectfour.ConnectFour/ExecuteTurn";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<connect_four_pb.TurnInfo>;
    requestDeserialize: grpc.deserialize<connect_four_pb.TurnInfo>;
    responseSerialize: grpc.serialize<connect_four_pb.TurnResult>;
    responseDeserialize: grpc.deserialize<connect_four_pb.TurnResult>;
}
interface IConnectFourService_IDeleteGame extends grpc.MethodDefinition<connect_four_pb.GameInfo, connect_four_pb.DeleteResult> {
    path: "/connectfour.ConnectFour/DeleteGame";
    requestStream: false;
    responseStream: false;
    requestSerialize: grpc.serialize<connect_four_pb.GameInfo>;
    requestDeserialize: grpc.deserialize<connect_four_pb.GameInfo>;
    responseSerialize: grpc.serialize<connect_four_pb.DeleteResult>;
    responseDeserialize: grpc.deserialize<connect_four_pb.DeleteResult>;
}

export const ConnectFourService: IConnectFourService;

export interface IConnectFourServer extends grpc.UntypedServiceImplementation {
    startGame: grpc.handleUnaryCall<connect_four_pb.GameInfo, connect_four_pb.GameInfo>;
    getBoard: grpc.handleUnaryCall<connect_four_pb.GameInfo, connect_four_pb.GameBoard>;
    executeTurn: grpc.handleUnaryCall<connect_four_pb.TurnInfo, connect_four_pb.TurnResult>;
    deleteGame: grpc.handleUnaryCall<connect_four_pb.GameInfo, connect_four_pb.DeleteResult>;
}

export interface IConnectFourClient {
    startGame(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    startGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    startGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    getBoard(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    getBoard(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    getBoard(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    executeTurn(request: connect_four_pb.TurnInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    executeTurn(request: connect_four_pb.TurnInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    executeTurn(request: connect_four_pb.TurnInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    deleteGame(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
    deleteGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
    deleteGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
}

export class ConnectFourClient extends grpc.Client implements IConnectFourClient {
    constructor(address: string, credentials: grpc.ChannelCredentials, options?: Partial<grpc.ClientOptions>);
    public startGame(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    public startGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    public startGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameInfo) => void): grpc.ClientUnaryCall;
    public getBoard(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    public getBoard(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    public getBoard(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.GameBoard) => void): grpc.ClientUnaryCall;
    public executeTurn(request: connect_four_pb.TurnInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    public executeTurn(request: connect_four_pb.TurnInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    public executeTurn(request: connect_four_pb.TurnInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.TurnResult) => void): grpc.ClientUnaryCall;
    public deleteGame(request: connect_four_pb.GameInfo, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
    public deleteGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
    public deleteGame(request: connect_four_pb.GameInfo, metadata: grpc.Metadata, options: Partial<grpc.CallOptions>, callback: (error: grpc.ServiceError | null, response: connect_four_pb.DeleteResult) => void): grpc.ClientUnaryCall;
}
