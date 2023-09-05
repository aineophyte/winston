protoc --typescript_out=src\generated\ts --proto_path=src\main\proto connect_four_ts.proto

protoc --plugin=protoc-gen-ts=C:\Users\krasr\node_modules\.bin\protoc-gen-ts.cmd --ts_out=grpc_js:src\generated\ts2 --proto_path=src\main\proto connect_four.proto