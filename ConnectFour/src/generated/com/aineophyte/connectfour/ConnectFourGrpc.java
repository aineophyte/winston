package com.aineophyte.connectfour;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.54.1)",
    comments = "Source: connect_four.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ConnectFourGrpc {

  private ConnectFourGrpc() {}

  public static final String SERVICE_NAME = "connectfour.ConnectFour";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.GameInfo> getStartGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartGame",
      requestType = com.aineophyte.connectfour.GameInfo.class,
      responseType = com.aineophyte.connectfour.GameInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.GameInfo> getStartGameMethod() {
    io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.GameInfo> getStartGameMethod;
    if ((getStartGameMethod = ConnectFourGrpc.getStartGameMethod) == null) {
      synchronized (ConnectFourGrpc.class) {
        if ((getStartGameMethod = ConnectFourGrpc.getStartGameMethod) == null) {
          ConnectFourGrpc.getStartGameMethod = getStartGameMethod =
              io.grpc.MethodDescriptor.<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.GameInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StartGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.GameInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.GameInfo.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectFourMethodDescriptorSupplier("StartGame"))
              .build();
        }
      }
    }
    return getStartGameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.GameBoard> getGetBoardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetBoard",
      requestType = com.aineophyte.connectfour.GameInfo.class,
      responseType = com.aineophyte.connectfour.GameBoard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.GameBoard> getGetBoardMethod() {
    io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.GameBoard> getGetBoardMethod;
    if ((getGetBoardMethod = ConnectFourGrpc.getGetBoardMethod) == null) {
      synchronized (ConnectFourGrpc.class) {
        if ((getGetBoardMethod = ConnectFourGrpc.getGetBoardMethod) == null) {
          ConnectFourGrpc.getGetBoardMethod = getGetBoardMethod =
              io.grpc.MethodDescriptor.<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.GameBoard>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetBoard"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.GameInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.GameBoard.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectFourMethodDescriptorSupplier("GetBoard"))
              .build();
        }
      }
    }
    return getGetBoardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.aineophyte.connectfour.TurnInfo,
      com.aineophyte.connectfour.TurnResult> getExecuteTurnMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExecuteTurn",
      requestType = com.aineophyte.connectfour.TurnInfo.class,
      responseType = com.aineophyte.connectfour.TurnResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.aineophyte.connectfour.TurnInfo,
      com.aineophyte.connectfour.TurnResult> getExecuteTurnMethod() {
    io.grpc.MethodDescriptor<com.aineophyte.connectfour.TurnInfo, com.aineophyte.connectfour.TurnResult> getExecuteTurnMethod;
    if ((getExecuteTurnMethod = ConnectFourGrpc.getExecuteTurnMethod) == null) {
      synchronized (ConnectFourGrpc.class) {
        if ((getExecuteTurnMethod = ConnectFourGrpc.getExecuteTurnMethod) == null) {
          ConnectFourGrpc.getExecuteTurnMethod = getExecuteTurnMethod =
              io.grpc.MethodDescriptor.<com.aineophyte.connectfour.TurnInfo, com.aineophyte.connectfour.TurnResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExecuteTurn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.TurnInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.TurnResult.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectFourMethodDescriptorSupplier("ExecuteTurn"))
              .build();
        }
      }
    }
    return getExecuteTurnMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.DeleteResult> getDeleteGameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteGame",
      requestType = com.aineophyte.connectfour.GameInfo.class,
      responseType = com.aineophyte.connectfour.DeleteResult.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo,
      com.aineophyte.connectfour.DeleteResult> getDeleteGameMethod() {
    io.grpc.MethodDescriptor<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.DeleteResult> getDeleteGameMethod;
    if ((getDeleteGameMethod = ConnectFourGrpc.getDeleteGameMethod) == null) {
      synchronized (ConnectFourGrpc.class) {
        if ((getDeleteGameMethod = ConnectFourGrpc.getDeleteGameMethod) == null) {
          ConnectFourGrpc.getDeleteGameMethod = getDeleteGameMethod =
              io.grpc.MethodDescriptor.<com.aineophyte.connectfour.GameInfo, com.aineophyte.connectfour.DeleteResult>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteGame"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.GameInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.aineophyte.connectfour.DeleteResult.getDefaultInstance()))
              .setSchemaDescriptor(new ConnectFourMethodDescriptorSupplier("DeleteGame"))
              .build();
        }
      }
    }
    return getDeleteGameMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConnectFourStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectFourStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectFourStub>() {
        @java.lang.Override
        public ConnectFourStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectFourStub(channel, callOptions);
        }
      };
    return ConnectFourStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConnectFourBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectFourBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectFourBlockingStub>() {
        @java.lang.Override
        public ConnectFourBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectFourBlockingStub(channel, callOptions);
        }
      };
    return ConnectFourBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConnectFourFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ConnectFourFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ConnectFourFutureStub>() {
        @java.lang.Override
        public ConnectFourFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ConnectFourFutureStub(channel, callOptions);
        }
      };
    return ConnectFourFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Start a game, the returned game information
     * will contain the game id.
     * </pre>
     */
    default void startGame(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameInfo> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStartGameMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get the current state of the game board.
     * </pre>
     */
    default void getBoard(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameBoard> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetBoardMethod(), responseObserver);
    }

    /**
     * <pre>
     * Execute a turn in the game.
     * </pre>
     */
    default void executeTurn(com.aineophyte.connectfour.TurnInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.TurnResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExecuteTurnMethod(), responseObserver);
    }

    /**
     * <pre>
     * Delete all the info related to a game.
     * </pre>
     */
    default void deleteGame(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.DeleteResult> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteGameMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ConnectFour.
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ConnectFourImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ConnectFourGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ConnectFour.
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ConnectFourStub
      extends io.grpc.stub.AbstractAsyncStub<ConnectFourStub> {
    private ConnectFourStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectFourStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectFourStub(channel, callOptions);
    }

    /**
     * <pre>
     * Start a game, the returned game information
     * will contain the game id.
     * </pre>
     */
    public void startGame(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameInfo> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get the current state of the game board.
     * </pre>
     */
    public void getBoard(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameBoard> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetBoardMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Execute a turn in the game.
     * </pre>
     */
    public void executeTurn(com.aineophyte.connectfour.TurnInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.TurnResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExecuteTurnMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Delete all the info related to a game.
     * </pre>
     */
    public void deleteGame(com.aineophyte.connectfour.GameInfo request,
        io.grpc.stub.StreamObserver<com.aineophyte.connectfour.DeleteResult> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteGameMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ConnectFour.
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ConnectFourBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ConnectFourBlockingStub> {
    private ConnectFourBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectFourBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectFourBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Start a game, the returned game information
     * will contain the game id.
     * </pre>
     */
    public com.aineophyte.connectfour.GameInfo startGame(com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getStartGameMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get the current state of the game board.
     * </pre>
     */
    public com.aineophyte.connectfour.GameBoard getBoard(com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetBoardMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Execute a turn in the game.
     * </pre>
     */
    public com.aineophyte.connectfour.TurnResult executeTurn(com.aineophyte.connectfour.TurnInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExecuteTurnMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Delete all the info related to a game.
     * </pre>
     */
    public com.aineophyte.connectfour.DeleteResult deleteGame(com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteGameMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ConnectFour.
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ConnectFourFutureStub
      extends io.grpc.stub.AbstractFutureStub<ConnectFourFutureStub> {
    private ConnectFourFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConnectFourFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ConnectFourFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Start a game, the returned game information
     * will contain the game id.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.aineophyte.connectfour.GameInfo> startGame(
        com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getStartGameMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get the current state of the game board.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.aineophyte.connectfour.GameBoard> getBoard(
        com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetBoardMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Execute a turn in the game.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.aineophyte.connectfour.TurnResult> executeTurn(
        com.aineophyte.connectfour.TurnInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExecuteTurnMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Delete all the info related to a game.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.aineophyte.connectfour.DeleteResult> deleteGame(
        com.aineophyte.connectfour.GameInfo request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteGameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_START_GAME = 0;
  private static final int METHODID_GET_BOARD = 1;
  private static final int METHODID_EXECUTE_TURN = 2;
  private static final int METHODID_DELETE_GAME = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_START_GAME:
          serviceImpl.startGame((com.aineophyte.connectfour.GameInfo) request,
              (io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameInfo>) responseObserver);
          break;
        case METHODID_GET_BOARD:
          serviceImpl.getBoard((com.aineophyte.connectfour.GameInfo) request,
              (io.grpc.stub.StreamObserver<com.aineophyte.connectfour.GameBoard>) responseObserver);
          break;
        case METHODID_EXECUTE_TURN:
          serviceImpl.executeTurn((com.aineophyte.connectfour.TurnInfo) request,
              (io.grpc.stub.StreamObserver<com.aineophyte.connectfour.TurnResult>) responseObserver);
          break;
        case METHODID_DELETE_GAME:
          serviceImpl.deleteGame((com.aineophyte.connectfour.GameInfo) request,
              (io.grpc.stub.StreamObserver<com.aineophyte.connectfour.DeleteResult>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getStartGameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.aineophyte.connectfour.GameInfo,
              com.aineophyte.connectfour.GameInfo>(
                service, METHODID_START_GAME)))
        .addMethod(
          getGetBoardMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.aineophyte.connectfour.GameInfo,
              com.aineophyte.connectfour.GameBoard>(
                service, METHODID_GET_BOARD)))
        .addMethod(
          getExecuteTurnMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.aineophyte.connectfour.TurnInfo,
              com.aineophyte.connectfour.TurnResult>(
                service, METHODID_EXECUTE_TURN)))
        .addMethod(
          getDeleteGameMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.aineophyte.connectfour.GameInfo,
              com.aineophyte.connectfour.DeleteResult>(
                service, METHODID_DELETE_GAME)))
        .build();
  }

  private static abstract class ConnectFourBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConnectFourBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.aineophyte.connectfour.ConnectFourProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConnectFour");
    }
  }

  private static final class ConnectFourFileDescriptorSupplier
      extends ConnectFourBaseDescriptorSupplier {
    ConnectFourFileDescriptorSupplier() {}
  }

  private static final class ConnectFourMethodDescriptorSupplier
      extends ConnectFourBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConnectFourMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ConnectFourGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConnectFourFileDescriptorSupplier())
              .addMethod(getStartGameMethod())
              .addMethod(getGetBoardMethod())
              .addMethod(getExecuteTurnMethod())
              .addMethod(getDeleteGameMethod())
              .build();
        }
      }
    }
    return result;
  }
}
