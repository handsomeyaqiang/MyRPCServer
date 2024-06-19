package com.itwang.rpc.common;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * RPC 解码器
 *
 */
public class RpcDecoder extends ByteToMessageDecoder {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(RpcDecoder.class);
	
    private Class<?> genericClass;

	// 构造函数传入向反序列化的class
    public RpcDecoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 4) {
            return;
        }
        in.markReaderIndex();
        int dataLength = in.readInt();
        if (dataLength < 0) {
            ctx.close();
        }
        if (in.readableBytes() < dataLength) {
            in.resetReaderIndex();
        }
        //将ByteBuf转换为byte[]
        byte[] data = new byte[dataLength];
        in.readBytes(data);
        //将data转换成object
        Object obj = SerializationUtil.deserialize(data, genericClass);
        LOGGER.info("服务端解码data："+ obj);
        out.add(obj);
    }
}
