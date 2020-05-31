package rshu.example.grpc.client;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
import rshu.example.grpc.lib.HelloReply;
import rshu.example.grpc.lib.HelloRequest;
import rshu.example.grpc.lib.SimpleGrpc;

@Service
public class GrpcClientService {
    @GrpcClient("local-grpc-server")
    private SimpleGrpc.SimpleBlockingStub simpleStub;

    public String sendMessage(final String name){
        try{
            final HelloReply response = this.simpleStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getMessage();
        } catch (final StatusRuntimeException e){
            return "FAILED with " + e.getStatus().getCode().name();
        }
    }
}
